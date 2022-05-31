package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}
