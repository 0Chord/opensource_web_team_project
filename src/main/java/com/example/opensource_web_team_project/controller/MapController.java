package com.example.opensource_web_team_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.opensource_web_team_project.dto.LocationDto;
import com.example.opensource_web_team_project.dto.LocationInfoDto;
import com.example.opensource_web_team_project.dto.SearchDto;
import com.example.opensource_web_team_project.service.Mapservice;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {

	private final Mapservice mapservice;

	@GetMapping("/map/search")
	public String search(@ModelAttribute SearchDto searchDto) {
		return "search";
	}

	@GetMapping("/view")
	public String view() {
		return "location";
	}

	@GetMapping("/map/ranking")
	public String chart(){
		return "chart";
	}

	@PostMapping("/map/search-location")
	public String location(@ModelAttribute @Validated SearchDto searchDto, Model model) {
		LocationInfoDto location = mapservice.getLocation(searchDto.getKeyword());
		model.addAttribute("documents", location.getDocuments());
		model.addAttribute("locationDto", new LocationDto());
		return "search";
	}

	@PostMapping("/map/register-location")
	public String register(@ModelAttribute @Validated LocationDto locationDto, Model model) {
		mapservice.register(locationDto);
		model.addAttribute("searchForm", new SearchDto());
		return "search";
	}
}
