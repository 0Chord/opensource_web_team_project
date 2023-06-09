package subway_route_map_mini_project.user_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/signup/joinPage")
	public String join() {
		return "join";
	}
}
