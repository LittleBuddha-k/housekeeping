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
    <%@include file="/webpage/template/common/commoncss.jsp" %>
    <%@include file="operatorList.js" %>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%@include file="/webpage/template/common/public.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="row">
                <%--查询表格--%>
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <form:form id="search-form" modelAttribute="operator" class="form-horizontal form-label-left">
                        <div class="item form-group">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="first-name">名字
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                                <form:input type="text" id="first-name" name="name"
                                       class="form-control " path="name"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="col-form-label col-md-3 col-sm-3 label-align" for="first-name">性别
                            </label>
                            <div class="col-md-6 col-sm-6 ">
                                <form:input type="text" id="sex" name="sex"
                                       class="form-control" path="sex"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <div class="col-md-6 col-sm-6 offset-md-3">
                                <button type="reset" class="btn btn-primary">重置</button>
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
                    <shiro:hasPermission name="system:operator:edit">
                        <button type="button" id="edit" class="btn btn-warning" onclick="edit()">编辑</button>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="system:operator:del">
                        <button type="button" id="del" class="btn btn-danger" onclick="deleteAll()">删除</button>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="system:operator:view">
                        <button type="button" id="view" class="btn btn-info" onclick="view()">查看</button>
                    </shiro:hasPermission>

                    <a href="#" id="search-btn" style="margin-left: 70%"><i class="glyphicon glyphicon-search"></i>搜索</a>
                </div>
                <%--信息列表表格--%>
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <table id="operator-table" class="table table-striped table-bordered bulk_action"
                           style="width:100%;white-space: nowrap;">
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
