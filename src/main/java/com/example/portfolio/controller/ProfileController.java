package com.example.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.portfolio.entity.Project;
import com.example.portfolio.entity.User;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProjectRepository projectRepo;

    // =========================
    // HOME PAGE
    // =========================
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // =========================
    // DEBUG ENDPOINT (Railway check)
    // =========================
    @GetMapping("/api")
    @ResponseBody
    public String api() {
        return "Portfolio System Running";
    }

    // =========================
    // USER PROFILE PAGE
    // =========================
    @GetMapping("/p/{username}")
    public String profile(@PathVariable String username, Model model) {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            return "redirect:/";
        }

        List<Project> projects = projectRepo.findByUserId(user.getId());

        if (projects == null) {
            projects = new ArrayList<>();
        }

        model.addAttribute("user", user);
        model.addAttribute("projects", projects);

        return "profile";
    }

    // =========================
    // PROJECT PAGE (SAFE VERSION)
    // =========================
    @GetMapping("/project/{id}")
    public String projectDetail(@PathVariable int id, Model model) {

        Project project = projectRepo.findById(id).orElse(null);

        if (project == null) {
            return "redirect:/";
        }

        model.addAttribute("project", project);

        return "profile"; // fallback to profile (NO extra HTML needed)
    }
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "OK - App is working";
    }
}