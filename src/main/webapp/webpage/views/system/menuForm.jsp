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
    <title>菜单管理</title>
    <%@include file="/webpage/template/common/commoncss.jsp" %>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                <form:form id="form" modelAttribute="menu" action="${ctx}/system/menu/save" method="post"
                           class="form-label-left input_mask">
                    <form:hidden path="id"/>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="name" name="name" path="name" required="required"
                               class="form-control has-feedback-left" placeholder="菜单名称"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="href" name="href" path="href" required="required"
                                    class="form-control has-feedback-left" placeholder="菜单链接"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="isShow" name="isShow" path="isShow" required="required"
                                    class="form-control has-feedback-left" placeholder="隐藏/显示"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="menuTypE" name="menuTypE" path="menuType" required="required"
                                    class="form-control has-feedback-left" placeholder="类型"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="permission" name="permission" path="permission" required="required"
                                    class="form-control has-feedback-left" placeholder="菜单权限"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <div class="col-md-6 col-sm-6 offset-md-3">
                            <button type="button" class="btn btn-primary">取消</button>
                            <button type="submit" class="btn btn-success">提交</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <!-- /page content -->
</div>

<%@include file="/webpage/template/common/commonjs.jsp" %>

</body>
</html>
