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

import com.example.sbjsp.entities.Product;
import com.example.sbjsp.entities.User;

@RestController
@RequestMapping("products")
public class ProductController {

	private static List<Product> listProducts = new ArrayList<Product>();
	private static int i;

	static {
		listProducts.add(new Product(1, "Xe máy", 1000));
		listProducts.add(new Product(2, "Ô tô", 120));
		i = 3;
	}

	@GetMapping("")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("products/index");
		mav.addObject("listProduct", listProducts);
		return mav;
	}

	@GetMapping("/insert")
	public ModelAndView insertProduct() {
		ModelAndView mav = new ModelAndView("products/insert");
		return mav;
	}

	@GetMapping("/editProduct/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("products/edit");
		for (Product product : listProducts) {
			if (product.getId() == id) {
				mav.addObject("product", product);
			}
		}
		return mav;
	}

	@PostMapping("/insert")
	public ModelAndView add(@RequestParam("productName") String productName,
			@RequestParam("productAmount") int productAmount) {
		listProducts.add(new Product(i++, productName, productAmount));
		ModelAndView mav = new ModelAndView("redirect:/products");
		mav.addObject("listProducts", listProducts);
		return mav;
	}

	@PostMapping("/editProduct/{id}")
	public ModelAndView update(@PathVariable("id") int id, @RequestParam("productName") String productName,
			@RequestParam("productAmount") int productAmount) {
		for (Product product : listProducts) {
			if (product.getId() == id) {
				product.setProductName(productName);
				product.setProductAmount(productAmount);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/products");
		mav.addObject("listProducts", listProducts);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		for (Product product : listProducts) {
			if (product.getId() == id) {
				listProducts.remove(product);
			}
		}
		ModelAndView mav = new ModelAndView("redirect:/users");
		mav.addObject("listProducts", listProducts);
		return mav;
	}
}
