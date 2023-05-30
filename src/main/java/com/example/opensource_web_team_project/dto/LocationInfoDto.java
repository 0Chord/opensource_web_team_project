package com.example.opensource_web_team_project.dto;

import java.util.Arrays;

import lombok.Getter;

@Getter
public class LocationInfoDto {
	private Document[] documents;
	private Meta meta;

	public LocationInfoDto() {
	}

	public LocationInfoDto(Document[] documents, Meta meta) {
		this.documents = documents;
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "LocationInfoDto{" +
			"documents=" + Arrays.toString(documents) +
			", meta=" + meta +
			'}';
	}
}
