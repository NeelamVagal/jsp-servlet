<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learning request,session,context objects</title>
</head>
<body>
<%
String username = request.getParameter("name");
if(username != null){
	//2 ways to set attribute in session
	session.setAttribute("username", username);
	pageContext.setAttribute("username", username, PageContext.SESSION_SCOPE);
	//2 ways to set attribute in application context
	application.setAttribute("username", username);
	pageContext.setAttribute("username", username, PageContext.APPLICATION_SCOPE);
	
	pageContext.setAttribute("username", username);
}
%>
User name in Request object: <%=username %>		
<br>
User name in Session object: <%=session.getAttribute("username") %>
<br>
User name in Context object: <%=application.getAttribute("username") %>
<br>
User name in PageContext object: <%=pageContext.getAttribute("username") %>
</body>
</html>