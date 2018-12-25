package com.company.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.User;
import com.company.model.UserOperation;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	UserOperation userOperation = null;

	public UserController() {
		super();

		// TODO Auto-generated constructor stub
	}

	public void init() {

		userOperation = new UserOperation();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {
			case "/new":
				addUser(request, response);
				break;
			case "/edit":
				updateUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/getAll":
				getAllUsers(request, response);
				break;
			case "/new1":
				showNewForm(request, response);
				break;

			default:
				getAllUsers(request, response);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userOperation = new UserOperation();
		List<User> userList = userOperation.getAll("FROM User");
		request.setAttribute("userList", userList);
		RequestDispatcher dispatcher =request.getRequestDispatcher("jsp/user/usertable.jsp");
	    dispatcher.forward(request, response);
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("userName");
		String address = request.getParameter("userAddress");
		int age = Integer.parseInt(request.getParameter("userAge"));
		
		User  user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setAge(age);
		userOperation.insert(user);
		response.sendRedirect("getAll");

	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/userfrom.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
