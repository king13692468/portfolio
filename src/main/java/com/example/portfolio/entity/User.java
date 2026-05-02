package com.example.portfolio.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}