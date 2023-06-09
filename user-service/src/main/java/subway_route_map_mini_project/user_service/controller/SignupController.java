package subway_route_map_mini_project.user_service.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import subway_route_map_mini_project.user_service.dto.JoinDto;
import subway_route_map_mini_project.user_service.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/signup")
public class SignupController {
	private final UserService userService;

	@PostMapping("/join")
	public String signup(@Validated @RequestBody JoinDto joinDto) {
		if (!userService.findUser(joinDto.getEmail())) {
			return "AlreadyExistsUser";
		}
		userService.join(joinDto);
		return "SUCCESS";
	}


}
