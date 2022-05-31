package com.bilel.weapens.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Category;
import com.bilel.weapens.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/showCreate1")
	public String showCreate(ModelMap modelMap) {
		Category category = new Category();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("category", category);
		return "formCategory";
	}
	
	
	@RequestMapping("/list-categorys")
	public String listCategorys(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Category> categorys = categoryService.getAllCategorysParPage(page, size);
		
		modelMap.addAttribute("categorys", categorys);
		modelMap.addAttribute("pages", new int[categorys.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listCategorys";
	}
	
	
	@RequestMapping("/saveCategory")
	public String saveSpecilate(@Valid Category category, BindingResult bindingResult){
		if (bindingResult.hasErrors()) return "formSpecilate";
	 		categoryService.saveCategory(category);
	 	return "redirect:/list-categorys";
	}
	
	@RequestMapping("/supprimer-categorys")
	public String supprimerCategory(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		categoryService.deleteCategoryById(id);
		Page<Category> categorys = categoryService.getAllCategorysParPage(page,
				size);
		modelMap.addAttribute("categorys", categorys);
		modelMap.addAttribute("pages", new int[categorys.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listCategorys";
	}
	
	
	@RequestMapping("/modifier-category")
	public String editerCategory(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Category category = categoryService.getCategory(id);
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("mode", "edit");
		return "formCategory";
	}

	@RequestMapping("/updateCategory")
	public String updateCategory(@ModelAttribute("category") Category category, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		categoryService.updateCategory(category);
		List<Category> categorys = categoryService.findAll();
		modelMap.addAttribute("categorys", categorys);
		return "listCategorys";
	}

}
