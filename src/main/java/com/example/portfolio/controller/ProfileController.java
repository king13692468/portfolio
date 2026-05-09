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
        return "menu";
    }

    // ============ CREATE PROFILE FEATURE ============

    @GetMapping("/create-profile")
    public String showCreateProfileForm() {
        return "create-profile";
    }

    @PostMapping("/create-profile")
    public String createProfile(@RequestParam String username,
                                @RequestParam String name,
                                @RequestParam(required = false) String githubLink,
                                @RequestParam(required = false) String linkedinLink,
                                @RequestParam(required = false) String resumeLink) {

        User existingUser = userRepo.findByUsername(username);
        if (existingUser != null) {
            return "redirect:/create-profile?error=Username already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setGithubLink(githubLink != null ? githubLink : "#");
        user.setLinkedinLink(linkedinLink != null ? linkedinLink : "#");
        user.setResumeLink(resumeLink != null ? resumeLink : "#");

        userRepo.save(user);

        return "redirect:/p/" + username;
    }

    // ============ OTHER EXISTING METHODS ============

    @GetMapping("/p/{username}/projects")
    public String showProjects(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        List<Project> projects = projectRepo.findByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("projects", projects);
        return "projects-list";
    }

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

    @GetMapping("/p/{username}/resume")
    public String showResume(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "resume";
    }

    @GetMapping("/p/{username}/redirect/github")
    public String redirectToGithub(@PathVariable String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";
        return "redirect:" + user.getGithubLink();
    }

    @GetMapping("/p/{username}/redirect/linkedin")
    public String redirectToLinkedin(@PathVariable String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";
        return "redirect:" + user.getLinkedinLink();
    }

    @GetMapping("/p")
    public String profileWithQuery(@RequestParam String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            return "redirect:/?error=User not found";
        }
        List<Project> projects = projectRepo.findByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("projects", projects);
        return "profile";
    }

    @GetMapping("/check-users")
    @ResponseBody
    public String checkUsers() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return "No users found in database! Please add a user.";
        }
        StringBuilder sb = new StringBuilder("Users in database:<br>");
        for (User u : users) {
            sb.append("• ").append(u.getUsername()).append(" (").append(u.getName()).append(")<br>");
        }
        return sb.toString();
    }

    @GetMapping("/test-create")
    @ResponseBody
    public String testCreate() {
        return "Create profile endpoint is reachable!";
    }
    // ============ CREATE PROJECT FEATURE ============

    @PostMapping("/create-project")
    public String createProject(@RequestParam int userId,
                                @RequestParam String title,
                                @RequestParam String description,
                                @RequestParam(required = false) String githubLink,
                                @RequestParam(required = false) String projectLink,
                                @RequestParam(required = false) String details) {

        Project project = new Project();
        project.setUserId(userId);
        project.setTitle(title);
        project.setDescription(description);
        project.setGithubLink(githubLink != null && !githubLink.isEmpty() ? githubLink : "#");
        project.setProjectLink(projectLink != null && !projectLink.isEmpty() ? projectLink : "#");
        project.setDetails(details != null && !details.isEmpty() ? details : "No details provided");

        projectRepo.save(project);

        User user = userRepo.findById(userId).get();
        return "redirect:/p/" + user.getUsername() + "/projects";
    }

    // Also add the GET endpoint for showing the form
    @GetMapping("/create-project/{username}")
    public String showCreateProjectForm(@PathVariable String username, Model model) {
        User user = userRepo.findByUsername(username);
        if (user == null) return "redirect:/";

        model.addAttribute("user", user);
        return "create-project";
    }
    
}