package com.example.portfolio.repository;

import com.example.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByUserId(int userId);
}