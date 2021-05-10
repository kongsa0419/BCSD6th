<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021-05-09
  Time: 오전 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Product</h1>
<form:form method="POST" action="/BCSD-6th-0.1/editsave">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="price" /></td>
        </tr>
        <tr>
            <td>Designation :</td>
            <td><form:input path="countryCode" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /></td>
        </tr>
    </table>
</form:form>