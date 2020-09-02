<%--
  Created by IntelliJ IDEA.
  User: LittleBuddha-k
  Date: 2020/7/1
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><%--使用shiro的jsp标签需要引入--%>
<html>
<head>
    <title>智能家居平台</title>
    <%@include file="/webpage/views/other/bootstrap.jsp" %>
    <%@include file="/webpage/views/other/datatable.jsp" %>
</head>
<body>
<%--正文--%>
<div class="container-fluid housekeeping-layout">
    <div class="row">
        <div class="column col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="jumbotron content-center">
                <h1>阁下无此操作权限</h1>
                <p>需要认证相关操作权限</p>
                <p><a class="btn btn-primary btn-lg" href="loginPage" role="button" id="pre-page">去认证</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
