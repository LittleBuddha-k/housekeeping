<%--
Created by IntelliJ IDEA.
User: LittleBuddha-k
Date: 2020/7/7
Time: 14:57
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webpage/template/common/taglib.jsp" %>
<html lang="en">
<head>
    <title>猪儿虫网络爬虫</title>
    <link rel="icon" href="${ctxStatic}/gentelella/production/images/favicon.jpg" type="image/ico"/>
    <%@include file="index.js" %>
    <%@include file="/webpage/template/common/commoncss.jsp" %>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%@include file="/webpage/template/common/public.jsp" %>

        <!-- page content -->
        <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${ctx}/home" frameborder="0" data-id="/home" />
        <!-- /page content -->

        <%--引入页脚--%>
        <%@include file="/webpage/template/common/footer.jsp" %>
    </div>
</div>
<%--引入js--%>
<%@include file="/webpage/template/common/commonjs.jsp"%>
</body>
</html>
