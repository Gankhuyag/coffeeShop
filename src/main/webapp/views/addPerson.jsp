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
	<form:form modelAttribute="person" action="../add" method="post">
		<p>
			<form:errors path="*" cssStyle="color : red;" />
		</p>
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="color : red;" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="color : red;" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="color : red;" /></td>
			</tr>
			<tr>
				<td>Address:</td>
			</tr>
			<tr>
			    <td>Line1:</td>	
				<td><form:input path="address.city"   placeholder="City" /></td>
				<td><form:input path="address.state"   placeholder="State" /></td>
			</tr>
			<tr>
			<td>Line2:</td>	
				<td><form:input path="address.country"   placeholder="Country" /></td>
				<td><form:input path="address.zipcode"  placeholder="Zipcode" /></td>
				 
			</tr>
			<td>Phone:</td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="color : red;" /></td>
		</table>
		<input type="submit" value="Submit"/>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>
</body>
</html>
<%@ include file="footer.jsp"%>
