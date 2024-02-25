<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.0/css/dataTables.bootstrap4.css">

</head>

<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/addName.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%=addEntryURL.toString()%>" value="Thêm mới"></aui:button>
</aui:button-row>




<div class="chien">
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>STT</th>
				<th>Name</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${usersList}" varStatus="loop">
				<tr>
					<td>${loop.index +1}</td>
					<td>${user.pname}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>


<%-- 		
<tfoot>
			<tr>
				<th>STT</th>
				<th>Name</th>
			</tr>
</tfoot> 
--%>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/2.0.0/js/dataTables.js"></script>
<script
	src="https://cdn.datatables.net/2.0.0/js/dataTables.bootstrap4.js"></script>
<script>
new DataTable('#example');
</script>
