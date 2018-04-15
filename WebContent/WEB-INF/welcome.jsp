<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>

<body>
<h1>Welcome</h1>

   <form method="get" action="ResServlet">
        
        <fieldset id="f1">  
        <legend id="l1">Book Search</legend>
        
  <label>Search for a book:</label>
  <input type="text" name="book" class="champ" id="c1">
  
  </fieldset>
 
  <input type="submit" value="Search" class="bou" id="b">
        
        </form>
        
        
<form name="myForm" method="post" action="AuthServlet">
  <input type="hidden" name="type" value="form2" />
   	<input type="submit" value="Logout" class="bou" id="b">
        </form>
        
    
    
</body>
</html>