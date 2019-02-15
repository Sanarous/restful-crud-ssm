<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工编辑页面</title>
</head>
<body>
<h1 align="center">员工编辑</h1>
<form action="<c:url value="/emp/${emp.empId}"/>" method="post">
    <input type="hidden" name="_method" value="put"/>
    <table align="center" border="1" cellpadding="5" cellspacing="0">
        <tr>
            <td>
                姓名：<input type="text" name="empName" value="${emp.empName}" disabled="disabled"/>
                <input type="hidden" name="empName" value="${emp.empName}"/>
            </td>
        </tr>
        <tr>
            <td>
                性别：<input type="radio" name="gender" value="M" <c:if test="${emp.gender eq 'M'}">checked="checked"</c:if>>男
                <input type="radio" name="gender" value="F" <c:if test="${emp.gender eq 'F'}">checked="checked"</c:if>>女
            </td>
        </tr>
        <tr>
            <td>
                邮箱：<input type="email" name="email" value="${emp.email}"/>
            </td>
        </tr>
        <tr>
            <td>
                部门：<select name="dId">
                <c:forEach items="${depts}" var="dept">
                    <option value="${dept.deptId}" <c:if test="${dept.deptId eq emp.dId}">selected</c:if>>${dept.deptName}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
