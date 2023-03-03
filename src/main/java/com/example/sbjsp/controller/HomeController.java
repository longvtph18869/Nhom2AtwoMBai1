package com.example.sbjsp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class HomeController {

	@GetMapping String home(){
		return "index";
	}
}
