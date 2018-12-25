package com.company.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class UserOperationTest1 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		UserOperation operation = new UserOperation();
		
		User user = new User();
		user.setAddress("ddddd");
		user.setName("ddddejurrr");
		user.setAge(10);
		user.setActive(true);
		
		Department department = new Department();
		department.setId("ujjj");
//		Set<User> users = new HashSet<User>();
//		users.add(user);
//		department.setUsers(users);
		
		Set<Department> departments = new HashSet<Department>();
		departments.add(department);
		user.setDepartment(departments);
		
		operation.insert(user);
	}

}
