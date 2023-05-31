package com.example.opensource_web_team_project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opensource_web_team_project.entity.LocationEntity;
import com.example.opensource_web_team_project.service.Mapservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapRestController {

	private final Mapservice mapservice;

	@GetMapping("/get-location-info")
	public List<LocationEntity> locationInfo(){
		List<LocationEntity> locations = mapservice.findAll();
		return locations;
	}

	@GetMapping("/get-location-info-ranking")
	public List<LocationEntity> locationRank(){
		List<LocationEntity> rank5 = mapservice.findRank5();
		return rank5;
	}
}
