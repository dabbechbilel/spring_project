package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Category;
import com.bilel.weapens.repos.WeaponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class WeaponServiceImpl implements WeaponService{

	@Autowired
	WeaponRepository weaponRepository;
	
	@Override
	public Weapon saveWeapon(Weapon weapon) {
	
		return weaponRepository.save(weapon);
	}

	@Override
	public Weapon updateWeapon(Weapon weapon) {
		return weaponRepository.save(weapon);
	}

	@Override
	public void deleteWeapon(Weapon weapon) {
		weaponRepository.delete(weapon);
	}

	@Override
	public void deleteWeaponById(Long id) {
		weaponRepository.deleteById(id);
	}

	@Override
	public Weapon getWeapon(Long id) {
		return weaponRepository.findById(id).get();
	}

	@Override
	public List<Weapon> getAllWeapons() {
		return weaponRepository.findAll();
	}

	

	@Override
	public List<Weapon> findByNameWeaponContains(String nom) {
		return weaponRepository.findByNameWeaponContains(nom);
	}


	@Override
	public List<Weapon> findByCategory(Category category) {
		return weaponRepository.findByCategory(category);
	}

	

	@Override
	public List<Weapon> findByCategoryIdCategory(Long id) {
		return weaponRepository.findByCategoryIdCategory(id);
	}

	
	
	@Override
	public Page<Weapon> getAllWeaponsParPage(int page, int size) {
	return weaponRepository.findAll(PageRequest.of(page, size));
	}
	


}
