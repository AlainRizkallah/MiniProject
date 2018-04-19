
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>

<jsp:useBean id="res" class="model.Reservation" scope="request"/>

<p>Your book <strong><jsp:getProperty property="result" name="res"/></strong> has been successfully booked</p>


<form method="post" action="AuthServlet">
<input type="hidden" name="type" value="form2" />
<input type="submit" value="Logout">
</form>


</html>