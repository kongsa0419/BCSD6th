<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021-05-09
  Time: 오전 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--현위치: /productlist--%>
<h1>Product List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>price</th><th>countryCode</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="prod" items="${list}">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.price}</td>
            <td>${prod.countryCode}</td>
<%--            href 고쳐라--%>
            <td><a href="productedt/${prod.id}">Edit</a></td>
            <td><a href="productrmv/${prod.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="product/list/form">Add New Product</a>

