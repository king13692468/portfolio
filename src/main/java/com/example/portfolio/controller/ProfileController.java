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

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/p/{username}")
    public String showMenu(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "menu"; // Main menu page
    }

    // Show GitHub
    @GetMapping("/p/{username}/github")
    public String showGithub(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "github";
    }

    // Show LinkedIn
    @GetMapping("/p/{username}/linkedin")
    public String showLinkedin(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "linkedin";
    }

    // Show all projects (list view)
    @GetMapping("/p/{username}/projects")
    public String showProjects(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        List<Project> projects = projectRepo.findByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("projects", projects);
        return "projects-list";
    }

    // Show single project details
    @GetMapping("/p/{username}/project/{projectId}")
    public String showProjectDetails(@PathVariable String username,
                                     @PathVariable int projectId,
                                     Model model) {
        User user = userRepo.findByUsername(username);
        Project project = projectRepo.findById(projectId).orElse(null);

        if (user == null || project == null) return "redirect:/";

        model.addAttribute("user", user);
        model.addAttribute("project", project);
        return "project-details";
    }

    // Show Resume
    @GetMapping("/p/{username}/resume")
    public String showResume(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "resume";
    }

    // Direct redirect to GitHub link
    @GetMapping("/p/{username}/redirect/github")
    public String redirectToGithub(@PathVariable String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";
        return "redirect:" + user.getGithubLink();
    }

    // Direct redirect to LinkedIn link
    @GetMapping("/p/{username}/redirect/linkedin")
    public String redirectToLinkedin(@PathVariable String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";
        return "redirect:" + user.getLinkedinLink();
    }
}