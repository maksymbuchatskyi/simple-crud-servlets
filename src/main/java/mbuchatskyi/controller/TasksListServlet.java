package mbuchatskyi.controller;

import mbuchatskyi.repository.TaskRepository;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tasks-list")
public class TasksListServlet extends HttpServlet {
  private TaskRepository taskRepository;

  @Override
  public void init() {
    taskRepository = TaskRepository.getTaskRepository();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/tasks-list.jsp");
    request.setAttribute("tasks", taskRepository.all());
    requestDispatcher.forward(request, response);
  }
}