package com.cogent.Batch65_TripHW.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Entity
@Table

public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	private String name;

	private boolean veg;

	@Max(value = 5, message = "Maximum number of kids allowed is 5")
	private int kids;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public int getKids() {
		return kids;
	}

	public void setKids(int kids) {
		this.kids = kids;
	}
	

	public Trip(Long id, String name, boolean veg, int kids) {
		super();
		this.id = id;
		this.name = name;
		this.veg = veg;
		this.kids = kids;
	}

	public Trip() {
		super();
	}


}
