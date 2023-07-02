package mbuchatskyi.controller;

import mbuchatskyi.model.Task;
import mbuchatskyi.repository.TaskRepository;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskRepository taskRepository;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/read-task.jsp");
    	try {
    		// get task's id
        	int id = Integer.parseInt(request.getParameter("id"));
    		Task task = taskRepository.read(id);
    		request.setAttribute("idt", task.getId());
    		request.setAttribute("name", task.getTitle());
    		request.setAttribute("prio", task.getPriority());
    		requestDispatcher.forward(request, response);
    	} catch (Exception e) {
    		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			request.setAttribute("idErrorRead", "id error");
			request.setAttribute("idt", Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    	}
    }
}
