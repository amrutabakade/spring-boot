package com.example.demo.p1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class First {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.game}")
	private String coachGame;
	@GetMapping("/")
	public String say()
	{
		return coachName;
	}
	@GetMapping("/k")
	public String say1()
	{
		return coachGame;
	}
	
}
