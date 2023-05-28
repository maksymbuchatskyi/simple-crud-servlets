package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class UpdateTaskServlet extends HttpServlet {

	private TaskRepository taskRepository;
	private Task task;

	@Override
	public void init() {
		taskRepository = TaskRepository.getTaskRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		task = taskRepository.read(id);
		if (task == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			request.setAttribute("idErrorEdit", "id error");
			request.setAttribute("idt", id);
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
		} else {
			request.setAttribute("task", task);
			request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (request.getParameter("name") == null || request.getParameter("priority") == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		task.setTitle(request.getParameter("name"));
		task.setPriority(Priority.valueOf(request.getParameter("priority")));
		boolean isUpdated = taskRepository.update(task);
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("/tasks-list");
	}
}
