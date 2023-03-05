package com.example.sbjsp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sbjsp.entities.User;

//Long
@RestController
@RequestMapping("users")
public class UserController {
	private static List<User> users = new ArrayList<User>();
	private static Long i;
	static {
		users.add(new User(1L, "Nguyễn Văn A", 0, new Date()));
		users.add(new User(2L, "Nguyễn Văn B", 0, new Date()));
		i = 3L;
	}

	@GetMapping("")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("user/index");
		mav.addObject("list", users);
		return mav;
	}

	@GetMapping("/insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("user/insert");
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("user/edit");
		for (User user : users) {
			if (user.getId() == id) {
				mav.addObject("user", user);
			}
		}
		return mav;
	}

	@PostMapping("/insert")
	public ModelAndView store(@RequestParam("fullName") String fullName, @RequestParam("gender") int gender,
			@RequestParam("birthDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDay) {
		users.add(new User(i++, fullName, gender, birthDay));
		ModelAndView mav = new ModelAndView("redirect:/users");
		mav.addObject("list", users);
		return mav;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
			@RequestParam("gender") int gender,
			@RequestParam("birthDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDay) {
		for (User user : users) {
			if (user.getId() == id) {
				user.setFullName(fullName);
				user.setBirthDay(birthDay);
				user.setGender(gender);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/users");
		mav.addObject("list", users);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView insert(@PathVariable("id") Long id) {
		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/users");
		mav.addObject("list", users);
		return mav;
	}
}
