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
    <%@include file="/webpage/template/common/gentelellacss.jsp" %>
    <%@include file="menu.js" %>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%@include file="/webpage/template/common/menunavigation.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <form id="query-form" data-parsley-validate class="form-horizontal form-label-left">
                        <div class="item form-group">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="first-name">First Name
                                <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                                <input type="text" id="first-name" name="name" required="required" class="form-control ">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="last-name">Last Name <span
                                    class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                                <input type="text" id="last-name" name="shortName" required="required"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="item form-group">
                            <div class="col-md-6 col-sm-6 offset-md-3">
                                <button class="btn btn-primary" type="reset">重置</button>
                                <button type="submit" class="btn btn-success">查询</button>
                            </div>
                        </div>
                    </form>
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
                        <tbody>
                        <c:forEach items="${list}" var="itemcat">
                            <%--注意：此处的 id 和pId 是重点--%>
                            <tr id="${itemcat.id}" pId="${itemcat.parentId}">
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

<%@include file="/webpage/template/common/gentelellajs.jsp" %>

</body>
</html>
