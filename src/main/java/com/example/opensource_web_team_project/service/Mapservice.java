package com.example.opensource_web_team_project.service;

import java.util.Map;

import com.example.opensource_web_team_project.dto.LocationDto;
import com.example.opensource_web_team_project.dto.LocationInfoDto;

public interface Mapservice {

	String mapToUrlParam(Map<String, Object> params);

	LocationInfoDto getLocation(String keyword);

	void register(LocationDto locationDto);
}
