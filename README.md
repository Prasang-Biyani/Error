# Error
“Error Monitoring” web application wherein a user can monitor and search for different kinds of application error(s) by providing error name or error description within a particular time span.

1) Error - A Class represents Model containing eid (error id), category ( of error), Description (of error), Date, Time.
2) Error DAO - Class which provides interface between Error and Database (MySQL).
3) ErrorsServlet - Servlet Class
4) SQLQueryGenerator - When user enters a query, that query (request) is processed in the backend and the result (response) is thrown with the help of "errors.jsp".

The Project uses JDBC, MySQL, JSP, HTML, CSS, JavaScript which makes the use of MVC architecture (Model - View - Controller).
