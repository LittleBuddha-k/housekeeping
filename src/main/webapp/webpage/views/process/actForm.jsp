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
            <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12" style="margin-top: 2%;">

                <form id="demo-form2" action="${ctx}/system/act/actTestAdd" data-parsley-validate class="form-horizontal form-label-left">

                    <div class="item form-group">
                        <label class="col-form-label col-md-3 col-sm-3 label-align" for="name">姓名</label>
                        <div class="col-md-6 col-sm-6 ">
                            <input type="text" id="name" name="name" required="required" class="form-control ">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="col-form-label col-md-3 col-sm-3 label-align" for="reason">请假缘由</label>
                        <div class="col-md-6 col-sm-6 ">
                            <textarea type="text" id="reason" name="reason" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="col-form-label col-md-3 col-sm-3 label-align">性别</label>
                        <div class="col-md-6 col-sm-6 ">
                            <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-secondary" data-toggle-class="btn-primary"
                                       data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="男" class="join-btn">男
                                </label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary"
                                       data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="女" class="join-btn">女
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="col-form-label col-md-3 col-sm-3 label-align">填写日期</label>
                        <div class="col-md-6 col-sm-6 ">
                            <input id="birthday" class="date-picker form-control" placeholder="dd-mm-yyyy" type="text"
                                   required="required" type="text" onfocus="this.type='date'"
                                   onmouseover="this.type='date'" onclick="this.type='date'" onblur="this.type='text'"
                                   onmouseout="timeFunctionLong(this)">
                            <script>
                                function timeFunctionLong(input) {
                                    setTimeout(function () {
                                        input.type = 'text';
                                    }, 60000);
                                }
                            </script>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="item form-group">
                        <div class="col-md-6 col-sm-6 offset-md-3">
                            <button class="btn btn-primary" type="button">关闭</button>
                            <button class="btn btn-primary" type="reset">重置</button>
                            <button type="submit" class="btn btn-success">提交</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <!-- /page content -->
</div>

<%@include file="/webpage/template/common/commonjs.jsp" %>
</body>
</html>
