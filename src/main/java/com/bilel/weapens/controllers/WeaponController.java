package com.bilel.weapens.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Category;
import com.bilel.weapens.service.WeaponService;
import com.bilel.weapens.service.CategoryService;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeaponController {

	@Autowired
	WeaponService weaponService;

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Category> categorys = categoryService.findAll();
		
		Weapon weapon = new Weapon();
		Category category = new Category();
		category = categorys.get(0);
		weapon.setCategory(category);
		
		modelMap.addAttribute("weapon", weapon);
		modelMap.addAttribute("categorys", categorys);

		modelMap.addAttribute("mode", "new");

		return "formWeapon";
	}
	
	
	@RequestMapping("/search-by-name")
	public String doSearchWeaponName(@ModelAttribute("weaponSearchFormData")Weapon formData,Model model, @RequestParam("nameWeapon") String nameWeapon) {
		List<Weapon> weapons = weaponService.findByNameWeaponContains(nameWeapon);
		model.addAttribute("weapons",weapons);
		List<Category> categorys = categoryService.findAll();
		model.addAttribute("categorys", categorys);

		return "listWeapons";
	}
	
	@RequestMapping("/search-by-category")
	public String doSearchWeaponCategory(@ModelAttribute("weaponSearchFormData")Weapon formData, Model modelMap, @RequestParam("id") Long id) {
		
		List<Category> categorys = categoryService.findAll();
		modelMap.addAttribute("categorys", categorys);
		
		List<Weapon> weapons = weaponService.findByCategoryIdCategory(id);
		modelMap.addAttribute("weapons",weapons);

		return "listWeapons";
	}


	@RequestMapping("/saveWeapon")
	public String saveWeapon(@Valid Weapon weapon,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formWeapon";
	 		weaponService.saveWeapon(weapon);
	 return "redirect:/list-weapons";
	}

	@RequestMapping("/list-weapons")
	public String listWeapons(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Weapon> weapons = weaponService.getAllWeaponsParPage(page, size);
		
		List<Category> categorys = categoryService.findAll();
		modelMap.addAttribute("categorys", categorys);
		
		modelMap.addAttribute("weapons", weapons);
		modelMap.addAttribute("pages", new int[weapons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listWeapons";
	}

	@RequestMapping("/supprimerWeapon")
	public String supprimerWeapon(@RequestParam("id") Long id, ModelMap modelMap,
		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		weaponService.deleteWeaponById(id);
		Page<Weapon> weapons = weaponService.getAllWeaponsParPage(page, size);
		modelMap.addAttribute("weapons", weapons);
		modelMap.addAttribute("pages", new int[weapons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listWeapons";
	}

	@RequestMapping("/modifier-weapon")
	public String editerWeapon(@RequestParam("id") Long id, ModelMap modelMap) {
		Weapon weapon = weaponService.getWeapon(id);
		List<Category> categorys = categoryService.findAll();
		modelMap.addAttribute("weapon", weapon);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("categorys", categorys);

		return "formWeapon";
	}

	@RequestMapping("/updateWeapon")
	public String updateWeapon(@ModelAttribute("weapon") Weapon weapon, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEmbauche = dateformat.parse(String.valueOf(date));
		weapon.setDateWeapon(dateEmbauche);

		weaponService.updateWeapon(weapon);
		List<Weapon> weapons = weaponService.getAllWeapons();
		modelMap.addAttribute("weapons", weapons);
		return "listWeapons";
	}

}
