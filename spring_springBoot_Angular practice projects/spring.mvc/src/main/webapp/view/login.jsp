<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  .center{
           text-align:center;
        }
</style>

</head>
<body>
  <div class="center">
     Login page <br>
     
       <form:form action="/process-login" method="get" modelAttribute="user">
            <label for="username">Username:</label>
            <form:input path="username" id="username" /> <br>
            
            <label for="password">Password:</label>
            <form:password path="password" id="password" /> <br>
            
            <input type="submit" value="Login" />
       </form:form>
     
   </div>
    
</body>
</html>