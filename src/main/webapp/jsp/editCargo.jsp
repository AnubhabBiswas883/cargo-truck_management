<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="update" modelAttribute="cargo">

 <form:hidden path="cargoid"/>


CargoName  : <form:input path="cargoname"/><br><br>

PhoneNumber     : <form:input path="phno"/> <br><br>

EmailID  : <form:input path="email"/><br><br>

Place     : <form:input path="place"/> <br><br>


<input type="submit" value="EditCargo">



</form:form>


<a href="viewAll">ViewAllCargos </a>

</body>
</html>