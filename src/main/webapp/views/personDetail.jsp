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
 	 
 	<form:form modelAttribute="person" action="../person/${person.id}" method="post">
		<table>
			<tr>

				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${person.firstName}" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${person.lastName}" /></td>
				 
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${person.email}" /></td>				 		
			 
			</tr> 
			<tr>
				<td>Address:</td>
			</tr>
			<tr>	
				<td> City  :<input type="text" name="city" value="${person.address.city}" /></td>
			</tr>
			<tr>	 
				<td> State :<input type="text" name="state" value="${person.address.state}" /></td>
			</tr>
			<tr>	 
				<td>Country:<input type="text" name="country" value="${person.address.country}" /></td>
			</tr>
			<tr>	 
                <td>ZipCode:<input type="text" name="zipcode" value="${person.address.zipcode}" /></td>
            </tr>   
 		 
 			<tr>
				<td>Phone  :<input type="text" name="phone" value="${person.phone}" /></td>			 			 		
			 
			</tr>
		</table>
		<input type="submit" value="update" />
		 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form:form>
	<form action="del/${person.id}" method="post">
		<button type="submit">Delete</button>
		 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form>
</body>
</html>
 <%@ include file="footer.jsp"%>