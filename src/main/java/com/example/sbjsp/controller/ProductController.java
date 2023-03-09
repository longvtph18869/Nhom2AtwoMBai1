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

import com.example.sbjsp.entities.Product;

@RestController
@RequestMapping("product")
public class ProductController {

	private static List<Product> listproduct = new ArrayList<Product>();
	private static int i;

	static {
		listproduct.add(new Product(1, "Xe máy", 1000));
		listproduct.add(new Product(2, "Ô tô", 120));
		listproduct.add(new Product(3, "Xe đạp điện", 123123));
		i = 4;
	}

	@GetMapping("")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("product/index");
		mav.addObject("listproduct", listproduct);
		return mav;
	}

	@GetMapping("/add")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView("product/add");
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("product/edit");
		for (Product product : listproduct) {
			if (product.getId() == id) {
				mav.addObject("product", product);
			}
		}
		return mav;
	}

	@PostMapping("/add")
	public ModelAndView add(@RequestParam("productName") String productName,
			@RequestParam("productAmount") int productAmount) {
		listproduct.add(new Product(i++, productName, productAmount));
		ModelAndView mav = new ModelAndView("redirect:/product");
		mav.addObject("listproduct", listproduct);
		return mav;
	}

	@PostMapping("/edit/{id}")
	public ModelAndView update(@PathVariable("id") int id, @RequestParam("productName") String productName,
			@RequestParam("productAmount") int productAmount) {
		for (Product product : listproduct) {
			if (product.getId() == id) {
				product.setProductName(productName);
				product.setProductAmount(productAmount);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/product");
		mav.addObject("listproduct", listproduct);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		listproduct.removeIf(e -> e.getId() == id);
		ModelAndView mav = new ModelAndView("redirect:/product");
		mav.addObject("listproduct", listproduct);
		return mav;
	}
}
