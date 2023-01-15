package com.ty_one_to_many_uni_school_student_teachers.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int fees;
	private String address;
	@OneToMany
	List<Student> slist;

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	public List<Teacher> getTlist() {
		return tlist;
	}

	public void setTlist(List<Teacher> tlist) {
		this.tlist = tlist;
	}

	@OneToMany
	List<Teacher> tlist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFees() {
		return fees;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", fees=" + fees + ", address=" + address + ", slist=" + slist
				+ ", tlist=" + tlist + "]";
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
