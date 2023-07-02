package mbuchatskyi.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mbuchatskyi.repository.TaskRepository;

import java.io.IOException;

@WebServlet("/delete-task")
public class DeleteTaskServlet extends HttpServlet {

	private TaskRepository taskRepository;

	@Override
	public void init() {
		taskRepository = TaskRepository.getTaskRepository();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		boolean isDeleted = taskRepository.delete(Integer.parseInt(request.getParameter("id")));
		if (!isDeleted) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			request.setAttribute("idErrorDelete", "id error");
			request.setAttribute("idt", Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
		} else {
			response.sendRedirect("/tasks-list");
		}
	}
}
