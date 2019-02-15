<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工后台管理页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
</head>
<body>
<h1 align="center">员工后台管理页面</h1>
<div align="center">
    <a href="<c:url value="/toaddpage"/>">添加员工</a>
</div>
<table border="1" cellpadding="5" cellspacing="0" align="center" style="text-align: center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>部门名</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="emp">
        <tr>
            <td>${emp.empId}</td>
            <td>${emp.empName}</td>
            <td>${emp.gender eq 'M' ? "男":"女"}</td>
            <td>${emp.email}</td>
            <td>${emp.department.deptName}</td>
            <td><a class="delBtn" href="<c:url value="/toeditpage/${emp.empId}"/>">编辑</a>&nbsp;<a onclick="return confirm('确认删除该员工?')" href="<c:url value="/emp/${emp.empId}"/>">删除</a></td>
            <form id="deleteForm" action="<c:url value="/emp/${emp.empId}"/>" method="post">
                <input type="hidden" name="_method" value="delete"/>
            </form>
        </tr>
    </c:forEach>
</table>
<!-- 分页信息 -->
<div align="center">
    当前第${pageInfo.pageNum}页 共${pageInfo.total}条记录
    <a href="<c:url value="/emps/1"/>">  首页</a>
    <c:choose>
        <c:when test="${pageInfo.pageNum eq 1}">
            上一页
        </c:when>
        <c:otherwise>
            <a href="<c:url value="/emps/${pageInfo.prePage}"/>">上一页</a>
        </c:otherwise>
    </c:choose>
    <!-- 页码页 -->
    <c:forEach items="${pageInfo.navigatepageNums}" var="nvpage">
        <c:choose>
            <c:when test="${pageInfo.pageNum eq nvpage}">
                <a href="<c:url value="/emps/${nvpage}"/>"><font color="red">${nvpage}</font></a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/emps/${nvpage}"/>">${nvpage}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:choose>
        <c:when test="${pageInfo.pageNum eq pageInfo.pages}">
            下一页
        </c:when>
        <c:otherwise>
            <a href="<c:url value="/emps/${pageInfo.nextPage}"/>">下一页</a>
        </c:otherwise>
    </c:choose>
    <a href="<c:url value="/emps/${pageInfo.pages}"/>">尾页</a>
</div>
<script type="text/javascript">
    $(function () {
        $(".delBtn").click(function(){
            //1.改变表单的action指向
            $("#deleteForm").attr("action",this.href);
            //2.提交表单
            $("#deleteForm").submit();
            return false;
        })
    });
</script>
</body>
</html>
