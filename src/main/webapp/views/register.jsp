 
<spring:url var="newUser" value="/newUser" />

<form:form modelAttribute="newUser" action="${addUser}" method="POST"
	class="form-horizontal">

	<legend align="center">Sign up form</legend>
	<br></br>



	<div class="form-group">
		<label class="col-md-4 control-label" for="">First Name</label>
		<div class="col-md-4">
			<form:input id="firstName" path="firstName" type="text"
				class="form-control input-md" />
			<form:errors path="firstName" cssStyle="color : red;" />

		</div>
	</div>

	<div class="form-group">
		<label class="col-md-4 control-label" for="">Last Name</label>
		<div class="col-md-4">
			<form:input id="lastName" path="lastName" type="text"
				class="form-control input-md" />
			<form:errors path="lastName" cssStyle="color : red;" />

		</div>
	</div>
  
	<div class="form-group">
		<label class="col-md-4 control-label" for="">Username</label>
		<div class="col-md-4">

			<form:input id="username"
				path="username" type="text"
				class="form-control input-md" />
			<form:errors path="username" cssStyle="color:red;"></form:errors>
		</div>
	</div>

	<div class="form-group">
		<label class="col-md-4 control-label" for="">Password</label>
		<div class="col-md-4">
			<form:password id="password" path="password"
				class="form-control input-md" /> 
		</div>
	</div>
   

</form:form>
<%@ include file="footer.jsp"%>