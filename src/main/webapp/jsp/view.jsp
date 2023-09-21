<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript">

$(document).ready(function () {
    $('#cargotab').DataTable({
        pagingType: 'full_numbers',
    });
});
</script>





</head>
<body>
<h3>View  Cargo</h3>
<a href="/">AddCargo</a>
<table id="cargotab" class="table">
<thead class="thead-dark">
<tr>
<th>
CargoName
</th>
<th>
PhoneNumber
</th>
<th>
EmailID
</th>
<th>
Place
</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
 
<c:forEach items="${cargos}" var="cargo">
<tr>
<td>${cargo.cargoid}</td>

<td>${cargo.cargoname}</td>
<td>${cargo.phno}</td>
<td>${cargo.email}</td>
<td>${cargo.place}</td>
<td><a href="editCargo?cid=${cargo.cargoid}">Edit</a></td>
     <td><a href="deleteCargo?cid=${cargo.cargoid}">Delete</a>

</tr>

</c:forEach>

</tbody>

</table>
</body>
</html>