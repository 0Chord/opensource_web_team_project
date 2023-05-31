package com.example.opensource_web_team_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.opensource_web_team_project.dto.LocationDto;
import com.example.opensource_web_team_project.dto.LocationInfoDto;
import com.example.opensource_web_team_project.entity.LocationEntity;
import com.example.opensource_web_team_project.repository.LocationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapServiceImpl implements Mapservice {
	private final String SEARCH_URL = "https://dapi.kakao.com/v2/local/search/keyword.json?y=36.6287079&x=127.4605813&radius=5000";
	private final RestTemplate restTemplate;
	private final String REST_API_KEY = "d078d63bfea989cd9ed843a8b8c59cfe";
	private final LocationRepository locationRepository;

	public String mapToUrlParam(Map<String, Object> params) {
		StringBuilder paramData = new StringBuilder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (paramData.length() != 0) {
				paramData.append('&');
			}
			paramData.append(param.getKey());
			paramData.append('=');
			paramData.append(String.valueOf(param.getValue()));
		}
		return paramData.toString();
	}

	@Override
	public LocationInfoDto getLocation(String keyword) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK " + REST_API_KEY);
			Map<String, Object> params = new HashMap<>();
			params.put("query", keyword);

			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);
			log.info(this.mapToUrlParam(params));
			ResponseEntity<LocationInfoDto> locationInfo = restTemplate.exchange(
				SEARCH_URL + "&" + this.mapToUrlParam(params), HttpMethod.GET, entity, LocationInfoDto.class);
			LocationInfoDto info = locationInfo.getBody();
			System.out.println("info = " + info);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void register(LocationDto locationDto) {
		Optional<LocationEntity> location = locationRepository.findByPlaceName(locationDto.getPlaceName());
		if (location.isEmpty()) {
			LocationEntity locationEntity = LocationEntity.builder()
				.placeName(locationDto.getPlaceName())
				.placeUrl(locationDto.getPlaceUrl())
				.x(locationDto.getX())
				.y(locationDto.getY())
				.roadAddressName(locationDto.getRoadAddressName())
				.count(1L)
				.build();

			locationRepository.save(locationEntity);
		} else {
			updateCount(location.get(), location.get().getCount() + 1);
		}
	}

	@Override
	public List<LocationEntity> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<LocationEntity> findLocationByPlaceName(String placeName) {
		return locationRepository.findByPlaceName(placeName);
	}

	@Override
	@Transactional
	public void updateCount(LocationEntity location, Long count) {
		location.updateCount(count);
	}

	@Override
	public List<LocationEntity> findRank5() {
		return locationRepository.findTop5ByOrderByCountDesc();
	}
}
