<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="usermenu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" >
$(document).ready(function() {

	var contextRoot = "/"+ window.location.pathname.split('/')[1];

	deleteProduct = function(Id) {
		$.ajax({
			url : contextRoot+"/del/" + Id,
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
				$('#row-'+auctionId).remove();

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
		<c:forEach var="product" items="${product}">
			<tr>
				<td width="150px">${product.productName}</td>
				<td width="250px">${product.description}</td>
				<td width="120px">${product.price}</td>
				<td width="100px">${product.productType}</td>
				<td width="100px"><a href="prod/${product.id}"> edit</a></td>
				<td><button onclick="deleteProduct(${product.id})">Delete</button></td>				 
				<td width="100px"><a href="del/${product.id}">
						delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="prod/add"> Add a Product</a>
</body>
</html>
<%@ include file="footer.jsp"%>
