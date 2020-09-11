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
    <link rel="icon" href="${ctxStatic}/gentelella/production/images/favicon.jpg" type="image/ico"/>
    <title>猪儿虫网络爬虫</title>
    <%--引入Jquery--%>
    <script src="${ctxStatic}/jquery/jquery-3.3.1.min.js"></script>
    <%@include file="menu.js" %>
    <%@include file="/webpage/template/common/commoncss.jsp" %>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%@include file="/webpage/template/common/public.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <form:form id="query-form" modelAttribute="menu" class="form-horizontal form-label-left">
                        <div class="item form-group">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="name">菜单名称
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                                <form:input type="text" id="name" name="name" path="name" class="form-control "/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <div class="col-md-6 col-sm-6 offset-md-3">
                                <button class="btn btn-primary" type="reset">重置</button>
                                <button type="submit" class="btn btn-success">查询</button>
                            </div>
                        </div>
                    </form:form>
                </div>
                <%--功能按钮--%>
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <shiro:hasPermission name="system:operator:add">
                        <button type="button" id="add" class="btn btn-info" onclick="add()">新建</button>
                    </shiro:hasPermission>

                    <a href="#" id="search-btn" style="margin-left: 70%"><i class="glyphicon glyphicon-search"></i>搜索</a>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <table id="menu-table" class="table table-striped table-bordered bulk_action"
                           style="white-space: nowrap;">
                        <thead>
                        <tr role="row">
                            <th> 类目ID </th>
                            <th> 类目名称 </th>
                            <th> 链接</th>
                            <th> 显示/隐藏</th>
                            <th> 排序</th>
                            <th>权限标识</th>
                        </tr>
                        </thead>
                        <tbody id="menu-table-body">
                        <c:forEach items="${list}" var="itemcat">
                            <%--注意：此处的 id 和pId 是重点--%>
                            <tr data-tt-id="${itemcat.id}" data-tt-parent-id="${itemcat.parentId}">
                                <td>${itemcat.id}</td>
                                <td>${itemcat.name}</td>
                                <td>${itemcat.href}</td>
                                <td>${itemcat.isShow}</td>
                                <td>${itemcat.sort}</td>
                                <td>${itemcat.permission}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <%--引入页脚--%>
        <%@include file="/webpage/template/common/footer.jsp" %>
    </div>
</div>

<%@include file="/webpage/template/common/commonjs.jsp" %>

</body>
</html>
