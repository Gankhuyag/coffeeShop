<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="usermenu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<title>Add an Order</title>
</head>
<body>
	<form:form modelAttribute="order" action="../add" method="post">
		<p>
			<form:errors path="*" cssStyle="color : red;" />
		</p>
		<table>
			<tr>
				<td>Order Date:</td>
				<td><form:input path="orderDate" /></td>
			</tr>		 
					<p><input type="text" id="datepicker"></p>
		 
			<tr>	 
				<td><form:errors path="orderDate" cssClass="color : red;" /></td>
			</tr>
		<form:form action="../add" method="post">	
			<tr>
				<td>Quantity:</td>
				<td><form:input path="orderLines" /></td>
				
			</tr>
			<tr>
				<td>Product:</td>
				<td><form:input path="orderLines" /></td>
				
			</tr>
		<input type="submit" value="Submit" />	
		</form:form>		
		</table>
		<input type="submit" value="Submit" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>
</body>
</html>
<%@ include file="footer.jsp"%>
