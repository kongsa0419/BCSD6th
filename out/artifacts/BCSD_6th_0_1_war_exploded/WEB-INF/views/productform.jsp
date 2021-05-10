<%@ page import="dto.Product" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021-05-09
  Time: 오전 2:30
  To change this template use File | Settings | File Templates.
--%>
<%--ADD PRODUCT--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
    <%
        Product product = (Product) request.getAttribute("product");
    %>
    <h1>Add New Product</h1>
    <form:form method="post" action="save">
        <table >
            <tr>
                <td>name : </td>
                <td><form:input path="name"  /></td>
            </tr>
            <tr>
                <td>price :</td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td>countryCode :</td>
                <td><form:input path="countryCode" /></td>
            </tr>
            <tr>
                <td> </td>
                <td><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form:form>
</body>