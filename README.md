# PRACTICE TASK. JAVA EE, SERVLETS

Using Servlet API, JSP, HTML and CSS create a simple Web Application for working with the To-Do List.

Created Web Application should be able to:

1. Create a new Task with given Priority.

2. View info about the Task from the To-Do List.

3. Edit the Task from the To-Do List.

4. Delete the Task from the To-Do List.

5. Show all Tasks from the To-Do List.

For all given above operations should be used a Web Interface.

## The below given list of all routes and examples of pages:

1. Route http://<host-name:port>/home

Home page with references to other pages.

2. Route http://<host-name:port>/create-task

The page for creating a new task and saving its in the To-Do List. The Priority is an enum with values 'Low', 'Medium', 'High'. If a task with a given name already exists in the To-Do List, then make redirect to the same page and display info about error.

3. Route http://<host-name:port>/tasks-list

Page with all tasks from To-Do List organized in a table and hyperlinks buttons for reading, editing and deleting tasks.

4. Route http://<host-name:port>/read-task?id=<task ID>

The page for viewing info about task that correspond to ID specified through the request parameters.

If the task with the given ID is not found in the To-Do List, then make redirect to the error page and return the status code 404.

5. Route http://<host-name:port>/edit-task?id=<task ID>

The page for edit an existing task that correspond to ID specified through the request parameters.

If the task with the given ID is not found in the To-Do List, then make redirect to the error page and return the status code 404.

6. Route http://<host-name:port>/delete-task?id=<task ID>

The 'Delete' button deletes the task that correspond to ID specified through the request parameters from To-Do List and the table.