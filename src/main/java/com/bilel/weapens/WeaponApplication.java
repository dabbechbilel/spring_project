package com.bilel.weapens;

import java.util.Date;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.service.WeaponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeaponApplication implements CommandLineRunner {

	@Autowired
	WeaponService weaponService;
	
	public static void main(String[] args) {
		SpringApplication.run(WeaponApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	

}
}
