package com.example.sbjsp.controller;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sbjsp.entities.User;
import com.example.sbjsp.service.UserService;

//Long
@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("list", userService.findAll());
		return mav;
	}

	@GetMapping("/insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("user/insert");
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		User user = userService.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("id [%d] was not found!", id)));
		ModelAndView mav = new ModelAndView("user/edit");
		mav.addObject("user", user);
		return mav;
	}

	@PostMapping("/insert")
	public ModelAndView store(@RequestParam("fullName") String fullName, @RequestParam("gender") int gender,
			@RequestParam("birthDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDay) {
		userService.insert(new User(fullName, gender, birthDay));
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
			@RequestParam("gender") int gender,
			@RequestParam("birthDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDay) {
		User user = userService.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("id [%d] was not found!", id)));
		userService.insert(new User(user.getId(),fullName, gender, birthDay));
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		User user = userService.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("id [%d] was not found!", id)));
		userService.delete(user);
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}
}
