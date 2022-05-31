package com.bilel.weapens.service;

import java.util.List;

import com.bilel.weapens.entities.Role;
import com.bilel.weapens.repos.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByRole(role);
	}



}
