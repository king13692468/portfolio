package com.example.portfolio.entity;
import jakarta.persistence.*;
@Entity
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String username;
        private String name;
        private String githubLink;
        private String linkedinLink;
        private String resumeLink;

        // getters & setters

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getGithubLink() { return githubLink; }
        public void setGithubLink(String githubLink) { this.githubLink = githubLink; }

        public String getLinkedinLink() { return linkedinLink; }
        public void setLinkedinLink(String linkedinLink) { this.linkedinLink = linkedinLink; }

        public String getResumeLink() { return resumeLink; }
        public void setResumeLink(String resumeLink) { this.resumeLink = resumeLink; }
}