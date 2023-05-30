package com.example.opensource_web_team_project.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opensource_web_team_project.dto.Document;
import com.example.opensource_web_team_project.dto.LocationInfoDto;
import com.example.opensource_web_team_project.dto.SearchDto;
import com.example.opensource_web_team_project.service.Mapservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {
	private final Mapservice mapservice;

	@PostMapping("/search-location")
	public Document[] search(@Validated SearchDto searchDto){
		LocationInfoDto location = mapservice.getLocation(searchDto.getKeyword());
		System.out.println(location);
		// mapservice.register(location);
		return location.getDocuments();
	}

}
