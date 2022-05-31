package com.bilel.weapens.restControllers;

import com.bilel.weapens.entities.Weapon;
import com.bilel.weapens.entities.Role;
import com.bilel.weapens.entities.User;
import com.bilel.weapens.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apii")
@CrossOrigin
public class UserRESTController {

	@Autowired
	UserService userService;
	
	/*
	 @Override
	public User addRoleToUser(String username, String rolename) {
		User usr = UserRepository.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}
	 */
	
	//@RequestMapping(method = RequestMethod.PUT)
	@RequestMapping(value="/{nom}/{role}",method = RequestMethod.PUT)
	public User changeUser(@PathVariable("nom") String nom, @PathVariable("role") String role ) {
		
	User abc= userService.addRoleToUser(nom,role);
	return userService.updateUser(abc);
	}
}
