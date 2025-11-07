package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processFom()
	{
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersion2")
	public String shoutOut(HttpServletRequest request, Model model)
	{
		
		String name = request.getParameter("studentName");
		
		String caseChange = name.toUpperCase();
		
		String message = "Yo!" + caseChange;
		
		model.addAttribute("message", message);
		model.addAttribute("message", "Bakade");
		
		return "helloworld";
	}
	
	@RequestMapping("/process3")
	public String shoutOut2(@RequestParam("studentName") String name, Model model)
	{
		
		String caseChange = name.toUpperCase();
		
		String message = "Yo!" + caseChange;
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}
}
