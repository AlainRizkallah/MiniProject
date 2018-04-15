<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1 id="h">Login</h1>
    
        <form name="myForm" method="post" action="AuthServlet">
        <input type="hidden" name="type" value="form1" />
        
        <fieldset id="f1">  
        <legend id="l1">Personal information</legend>
        
  <label>Username:</label>
  <input type="text" name="uname" class="champ" id="c1">
  <label>Pasword:</label>
  <input type="text" name="pword" class="champ" id="c2">
 
  </fieldset>
 
 
  
  <input type="submit" value="Login" class="bou" id="b">
        
        </form>
</html>