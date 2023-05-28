package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.repository.TaskRepository;
import com.softserve.itacademy.model.Task;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskRepository taskRepository;

	@Override
	public void init() {
		taskRepository = TaskRepository.getTaskRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/create-task.jsp");
		request.setAttribute("priorities", Priority.values());
		response.sendRedirect("/tasks-list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// display on JSP-page the list of Priorities
		request.setAttribute("priorities", Priority.values());
		// get input parameters from JSP
		if (request.getParameter("name") != null && request.getParameter("prio") != null) {
			String firstName = request.getParameter("name");
			String priority = request.getParameter("prio");

			Priority prio = Priority.valueOf(priority);
			// create new Task
			boolean isCreated = taskRepository.create(new Task(firstName, prio));
			if (!isCreated) {
				request.setAttribute("creationError", "Task with a given name already exist!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/error.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		doGet(request, response);
	}
}
