package com.example.demo.p1.rest.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach myCoach;
	
	@Autowired
	public void setter(@Qualifier("footBallCoach") Coach theCoach)
	{
		myCoach = theCoach;
	}
	
	
	@GetMapping("/w")
	public String getDailyWorkOut()
	{
		return myCoach.getDailyWorkout();
	}
}
