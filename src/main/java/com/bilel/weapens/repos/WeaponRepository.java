package com.bilel.weapens.repos;

import java.util.List;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WeaponRepository extends JpaRepository<Weapon, Long> {
	List<Weapon> findByNameWeaponContains(String nameWeapen);
	List<Weapon> findByCategory(Category category);
	List<Weapon> findByCategoryIdCategory(Long id);
}