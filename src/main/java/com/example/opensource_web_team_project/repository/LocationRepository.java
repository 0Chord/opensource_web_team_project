package com.example.opensource_web_team_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.opensource_web_team_project.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, String> {
}
