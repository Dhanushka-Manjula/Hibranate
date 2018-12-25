package com.company.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "AGE")
	private int age;
	@Column(name = "BIRTHDAY")
	private Date birthday;
	@Column(name = "USER_STATUS", nullable = false)
	private boolean isActive;
	
	@ManyToMany (fetch = FetchType.LAZY , cascade = CascadeType.ALL) 
	@JoinTable(name = "USER_DEPARTMENT" , joinColumns = {
			
			@JoinColumn ( name = "USER_ID" , nullable = false )
	} , inverseJoinColumns = {
			
			@JoinColumn ( name = "DEPARTMENT_ID" , nullable = false )	
	})
	private Set<Department> departments = new HashSet<Department>();

	public User() {

	}

	public User(int id, String name, String address, int age, Date birthday, boolean isActive,
			Set<Department> department) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.birthday = birthday;
		this.isActive = isActive;
		this.departments = department;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Set<Department> getDepartmenst() {
		return departments;
	}

	public void setDepartment(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((departments == null) ? 0 : departments.hashCode());
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (departments == null) {
			if (other.departments != null)
				return false;
		} else if (!departments.equals(other.departments))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", birthday=" + birthday
				+ ", isActive=" + isActive + ", department=" + departments + "]";
	}

}
