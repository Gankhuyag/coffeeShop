<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="usermenu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
  
<title>Update  a Product</title>
</head>
<body>
 	 
 	<form:form modelAttribute="product" action="../prod/${product.id}" method="post">
		<table>
			<tr>

				<td>Product Name:</td>
				<td><input type="text" name="productName" value="${product.productName}" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="${product.description}" /></td>
				 
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" value="${product.price}" /></td>				 		
			 
			</tr> 
			<tr>
				<td>Product Type:</td>
				<td>
				<form:select   path="productType"
				              items="${prodType}"/>				               
				</td>
 			</tr>
		</table>
		<input type="submit" value="update" />
		 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form:form>
	<form action="del/${product.id}" method="post">
		<button type="submit">Delete</button>
		 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form>
</body>
</html>
 <%@ include file="footer.jsp"%>