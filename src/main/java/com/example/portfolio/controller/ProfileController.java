package com.example.portfolio.controller;
import java.util.ArrayList;
import com.example.portfolio.entity.*;
import com.example.portfolio.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    ProjectRepository projectRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/p/{username}")
    public String profile(@PathVariable String username, Model model) {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            return "error";
        }

        List<Project> projects = projectRepo.findByUserId(user.getId());

        if (projects == null) {
            projects = new ArrayList<>();
        }

        model.addAttribute("user", user);
        model.addAttribute("projects", projects);

        return "profile";
    }

    @GetMapping("/project/{id}")
    public String projectDetail(@PathVariable int id, Model model) {

        Project project = projectRepo.findById(id).orElse(null);

        if (project == null) {
            return "error";
        }

        model.addAttribute("project", project);

        return "project-detail";
    }
}