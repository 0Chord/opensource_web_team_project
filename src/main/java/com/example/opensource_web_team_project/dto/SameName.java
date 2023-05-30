package com.example.opensource_web_team_project.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class SameName {

	private String keyword;
	private String[] region;
	@JsonProperty("selected_region")
	private String selectedRegion;

	public SameName() {
	}

	public SameName(String keyword, String[] region, String selectedRegion) {
		this.keyword = keyword;
		this.region = region;
		this.selectedRegion = selectedRegion;
	}

	@Override
	public String toString() {
		return "SameName{" +
			"keyword='" + keyword + '\'' +
			", region=" + Arrays.toString(region) +
			", selectedRegion='" + selectedRegion + '\'' +
			'}';
	}
}
