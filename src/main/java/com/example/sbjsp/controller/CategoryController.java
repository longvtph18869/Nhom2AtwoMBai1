package com.example.sbjsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.sbjsp.entities.Category;

@RestController
@RequestMapping("categories")
public class CategoryController {
	private static List<Category> categories = new ArrayList<Category>();

	static {
		categories.add(new Category(1, "CT01", "Đồng hồ", "Đồng hồ Thụy Sỹ sale 50%"));
		categories.add(new Category(2, "CT02", "Máy tính", "Máy assus sale 60%"));
		categories.add(new Category(3, "CT03", "Điện thoại", "Iphone sale 50%"));
		categories.add(new Category(4, "CT04", "Tivi", "Tivi sony 4k sale 50%"));
		categories.add(new Category(5, "CT05", "Tủ lạnh", "Tủ lạnh toshiba sale 50%"));
	}
	
	@GetMapping("")
	public ModelAndView getAllCategories() {
		ModelAndView mav = new ModelAndView("category/index");
		mav.addObject("list", categories);
		return mav;
	}

	@GetMapping("/insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("category/insert");
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("category/edit");
		for (Category category : categories) {
			if (category.getId() == id) {
				mav.addObject("category", category);
			}
		}
		return mav;
	}

	@PostMapping("/insert")
	public ModelAndView save(@RequestParam("code") String code, @RequestParam("name") String name,
			@RequestParam("description") String description) {
		categories.add(new Category(categories.size() + 1, code, name, description));
		ModelAndView mav = new ModelAndView("redirect:/categories");
		mav.addObject("list", categories);
		return mav;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView update(@PathVariable("id") int id, @RequestParam("code") String code,
			@RequestParam("name") String name,
			@RequestParam("description") String description) {
		for (Category category : categories) {
			if (category.getId() == id) {
				category.setCode(code);
				category.setName(name);
				category.setDescription(description);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/categories");
		mav.addObject("list", categories);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		categories.removeIf(c -> c.getId() == id);
		ModelAndView mav = new ModelAndView("redirect:/categories");
		mav.addObject("list", categories);
		return mav;
	}
}
