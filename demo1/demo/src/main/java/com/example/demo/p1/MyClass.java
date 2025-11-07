package com.example.demo.p1;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class MyClass {

	@GetMapping("/")
	public String fun1()
	{
		return "say HII";
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("init" + getClass().getSimpleName());
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("Destroy" + getClass().getSimpleName());
	}
	
}
