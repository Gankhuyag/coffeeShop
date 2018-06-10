<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="usermenu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>

<script type="text/javascript">
	$(document).ready(function() {

		var contextRoot = "/" + window.location.pathname.split('/')[1];

		deleteProduct = function(Id) {
			$.ajax({
				url : contextRoot + "/del/" + Id,
				type : 'DELETE',
				dataType : "json",
				success : function(response) {
					alert("Product Deleted");
					//$('#row-'+auctionId).remove();

				},
				error : function() {
					alert('Error while request..');
				}
			});
		}

		rejectAuction = function(auctionId) {
			$.ajax({
				url : contextRoot + "/admin/auction/reject/" + auctionId,
				type : 'PUT',
				dataType : "json",
				success : function(response) {
					alert("Auction Reject");
					$('#row-' + auctionId).remove();

				},
				error : function() {
					alert('Error while request..');
				}
			});
		}

	});
</script>
<title>Products currently in the Coffee Shop</title>
</head>
<body>
	<h2>Products currently in the Coffee shop</h2>
	<table>
		<c:forEach var="person" items="${person}">
			<tr>
				<td width="150px">${person.firstName}</td>
				<td width="150px">${person.lastName}</td>
				<td width="230px">${person.email}</td>
				<td width="100px">${person.address.city}</td>
				<td width="100px">${person.address.state}</td>
				<td width="100px">${person.address.country}</td>
				<td width="100px">${person.address.zipcode}</td>
				<td width="100px">${person.phone}</td>
				
				<td>
					<form action="../person/${person.id}" method="get">
						<button type="submit">Edit</button>
					</form>
				</td>
				<td><form action="../person/del/${person.id}">
						<button type="submit">Delete</button>
					</form></td>

			</tr>
		</c:forEach>
	</table>
	 <form action="../person/add/">
			<button type="submit">Add a Person</button>
		</form> 

	<!--<a href="../prod/add"> Add a Product</a>  -->
</body>
</html>
<%@ include file="footer.jsp"%>
