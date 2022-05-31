package com.bilel.weapens.restControllers;

import java.util.List;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.service.WeaponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class WeaponRESTController {
	@Autowired
	WeaponService weaponService;
	
	
		@RequestMapping(method=RequestMethod.GET)
		List<Weapon>getAllEnseignants(){ 
			return weaponService.getAllWeapons();
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
		public Weapon getWeaponById(@PathVariable("id") Long id) 
		{ 
			return weaponService.getWeapon(id);
		}
		
		@RequestMapping(value="/recherche/{nom}",method = RequestMethod.GET)
		public List<Weapon> getWeaponByNameContains(@PathVariable("nameWeapon") String nameWeapon) 
		{ 
			return weaponService.findByNameWeaponContains(nameWeapon);
		}

		@RequestMapping(method = RequestMethod.POST)
		public Weapon createWeapon(@RequestBody Weapon weapon) {
		return weaponService.saveWeapon(weapon);
		}
		
		
		@RequestMapping(method = RequestMethod.PUT)
		public Weapon updateWeapon(@RequestBody Weapon weapon) {
		return weaponService.updateWeapon(weapon);
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
		public void deleteWeapon(@PathVariable("id") Long id)
		{
			weaponService.deleteWeaponById(id);
		}
		
		@RequestMapping(value="/ensispe/{idCategory}",method = RequestMethod.GET)
		public List<Weapon> getWeaponsByIdCategory(@PathVariable("idCategory") Long idCategory) 
		{
		return weaponService.findByCategoryIdCategory(idCategory);
		}
}
