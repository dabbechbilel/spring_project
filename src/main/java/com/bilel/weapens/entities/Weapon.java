package com.bilel.weapens.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Weapon {
	
     	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	    private Long idWeapon;
     	@NotNull
     	@Size (min = 4,max = 40)
	    private String nameWeapon ;
     	@Min(value = 10)
     	@Max(value = 10000)
	    private double priceWeapon;
		
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @PastOrPresent
	    private Date dateWeapon;
	    
	    @ManyToOne
	    private Category category;
	    
	    
		
		public Weapon() {
			super();
		}



		public Weapon(Long idWeapon, @NotNull @Size(min = 4, max = 40) String nameWeapon,
				@Min(10) @Max(10000) double priceWeapon,
				@PastOrPresent Date dateWeapon, Category category) {
			this.idWeapon = idWeapon;
			this.nameWeapon = nameWeapon;
			this.priceWeapon = priceWeapon;
	
			this.dateWeapon = dateWeapon;
			this.category = category;
		}



		public Long getIdWeapon() {
			return idWeapon;
		}



		public void setIdWeapon(Long idWeapon) {
			this.idWeapon = idWeapon;
		}



		public String getNameWeapon() {
			return nameWeapon;
		}



		public void setNameWeapon(String nameWeapon) {
			this.nameWeapon = nameWeapon;
		}



		public double getPriceWeapon() {
			return priceWeapon;
		}



		public void setPriceWeapon(double priceWeapon) {
			this.priceWeapon = priceWeapon;
		}





		public Date getDateWeapon() {
			return dateWeapon;
		}



		public void setDateWeapon(Date dateWeapon) {
			this.dateWeapon = dateWeapon;
		}



		public Category getCategory() {
			return category;
		}



		public void setCategory(Category category) {
			this.category = category;
		}



		@Override
		public String toString() {
			return "Weapon [category=" + category + ", dateWeapon=" + dateWeapon + ", idWeapon=" + idWeapon
					+ ", nameWeapon=" + nameWeapon + ", priceWeapon=" + priceWeapon + "]";
		}
		
	    
}
