<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
<h1>Search Result :</h1>
<jsp:useBean id="book" class="model.Reservation" scope="request"/>
<p><jsp:getProperty name="book" property="result" /></strong></p>
<form method="post" action="ResServlet">
<input type="submit" value="Reserve">
</form>
<h3>Search : </h3>
<form method="get" action="ResServlet">
<input type="text" name="book">
<input type="submit" value="Search">
</form>
<form method="post" action="AuthServlet">
<input type="hidden" name="type" value="form2" />
<input type="submit" value="Logout">
</form>

</body>
</html>