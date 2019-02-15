<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工添加</title>
</head>
<body>
<h1 align="center">员工添加</h1>
<form action="<c:url value="/emp"/>" method="post">
    <table align="center" border="1" cellpadding="5" cellspacing="0">
        <tr>
            <td>
                姓名：<input type="text" name="empName" /><br/>
            </td>
        </tr>
        <tr>
            <td>
                性别：<input type="radio" name="gender" value="M">男
                <input type="radio" name="gender" value="F">女
            </td>
        </tr>
        <tr>
            <td>
                邮箱：<input type="email" name="email"/>
            </td>
        </tr>
        <tr>
            <td>
                部门：<select name="dId">
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.deptId}">${dept.deptName}</option>
                        </c:forEach>
                     </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="保存"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
