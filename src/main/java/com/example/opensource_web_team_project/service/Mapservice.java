package com.example.opensource_web_team_project.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.opensource_web_team_project.dto.LocationDto;
import com.example.opensource_web_team_project.dto.LocationInfoDto;
import com.example.opensource_web_team_project.entity.LocationEntity;

public interface Mapservice {

	String mapToUrlParam(Map<String, Object> params);

	LocationInfoDto getLocation(String keyword);

	void register(LocationDto locationDto);

	List<LocationEntity> findAll();

	Optional<LocationEntity> findLocationByPlaceName(String placeName);

	void updateCount(LocationEntity location, Long count);

	List<LocationEntity> findRank5();
}
