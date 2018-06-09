<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="usermenu.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Product</title>
</head>
<body>
	<form:form modelAttribute="product" action="add" method="post">
		<p>
			<form:errors path="*" cssStyle="color : red;" />
		</p>
		<table>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="productName" /></td>				 
				<td><form:errors path="productName" cssClass="color : red;" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="color : red;" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="color : red;" /></td>
			</tr>			 
		</table>
		<input type="submit" />

	</form:form>
</body>
</html>
 <%@ include file="footer.jsp"%>	
 