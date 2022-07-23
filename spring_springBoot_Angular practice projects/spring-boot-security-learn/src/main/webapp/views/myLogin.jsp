<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

        <div class="container col-md-5 text-center">
        <c:if test="${param.error != null }">
              <h1 style="color:red;">Invalid Username and Password</h1>
        </c:if>
        
        <c:if test="${param.logout != null }">
           <h1 style="color:red;">Logout success</h1>
        </c:if>
   
        
          <form:form>
              Username: <input type="text"  class="form-control" name = "username"><br>       
              Password: <input type="password" class="form-control" name = "password"><br>
              <input type="checkbox" class="from-control" name="remember-me" />Remember Me
              <input type="submit" value="Login" />
              
              
              <br><br>
              <a class="btn-btn-primary" href="/oauth2/authorization/google">Google<img src="/images/google.png"></a><br>
               <a class="btn-btn-primary" href="/oauth2/authorization/github">Github<img src="/images/google.png"></a>
              
          </form:form>   
          
          </div>
      
</body>
</html>