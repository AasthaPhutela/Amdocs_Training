<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/adminUserRegister.css" rel="stylesheet" type="text/css"/> 
</head>
<body>
<div align="center">

  <h1>Admin Registeration Form</h1><br>
  <form action="<%= request.getContextPath() %>/admin-register" method="post">
  
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   
   <br><br>
   <input type="submit" value="Submit" />
   
  </form>
 </div>
    <div>
		<a href="/FinalProject/admin">Home</a>&emsp; <a
			href="/FinalProject/logout">Log Out</a>&emsp;
	</div>
</body>
</html>