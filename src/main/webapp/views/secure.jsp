<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="usermenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="<spring:url value="/resources/jquery/jquery-1.8.3.min.js"/>"/></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>
<body>
<h1>In Coffee Shop!</h1>
<img src="CLASSPATH_RESOURCE_LOCATIONS:/coffee.*" alt="Coffee">
<img  class="group list-group-image" src="<c:url value="CLASSPATH_RESOURCE_LOCATIONS:/coffee.*"></c:url>" alt="image"  style = "width:100%"/>
<a href="<c:url value="/logout" />"> Now logout </a>

</body>
</html>
<%@ include file="footer.jsp"%>