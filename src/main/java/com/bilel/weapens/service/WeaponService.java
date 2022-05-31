package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Category;

import org.springframework.data.domain.Page;

public interface WeaponService {
	
	Weapon saveWeapon(Weapon weapon);
	Weapon updateWeapon(Weapon weapon);
	void deleteWeapon(Weapon weapon);
	void deleteWeaponById(Long id);
	Weapon getWeapon(Long id);
	List<Weapon> getAllWeapons();
	List<Weapon> findByNameWeaponContains(String nom);
	List<Weapon> findByCategory (Category category);
	List<Weapon> findByCategoryIdCategory(Long id);
	Page<Weapon> getAllWeaponsParPage(int page, int size);

}
