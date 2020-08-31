package com.partnera.rezervationapp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="pozition")
	private String pozition;

	public Employee(int id, String fullname, String pozition) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.pozition = pozition;
	}

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPozition() {
		return pozition;
	}

	public void setPozition(String pozition) {
		this.pozition = pozition;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", pozition=" + pozition + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + id;
		result = prime * result + ((pozition == null) ? 0 : pozition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (id != other.id)
			return false;
		if (pozition == null) {
			if (other.pozition != null)
				return false;
		} else if (!pozition.equals(other.pozition))
			return false;
		return true;
	}
	
	
	
	

}
