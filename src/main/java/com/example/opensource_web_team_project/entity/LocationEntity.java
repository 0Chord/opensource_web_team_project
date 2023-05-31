package com.example.opensource_web_team_project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "place_name")
	private String placeName;
	@Column(name = "place_url")
	private String placeUrl;
	@Column(name = "road_address_name")
	private String roadAddressName;
	private String x;
	private String y;
	private Long count;

	public void updateCount(Long count) {
		this.count = count;
	}
}
