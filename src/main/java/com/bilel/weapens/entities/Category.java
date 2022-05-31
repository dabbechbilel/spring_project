package com.bilel.weapens.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategory;
	private String nameCategory;
	private String descriptionCategory;
	
	
	


	public Long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	public String getDescriptionCategory() {
		return descriptionCategory;
	}


	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}


	


	@Override
	public String toString() {
		return "Category [descriptionCategory=" + descriptionCategory + ", idCategory=" + idCategory + ", nameCategory="
				+ nameCategory + "]";
	} 
	

}	
	
	