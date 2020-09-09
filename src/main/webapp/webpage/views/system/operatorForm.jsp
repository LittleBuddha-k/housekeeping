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
    <title>用户信息管理</title>
    <%@include file="/webpage/template/common/commoncss.jsp" %>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                <form:form id="form" modelAttribute="operator" action="${ctx}/system/operator/save" method="post"
                           class="form-label-left input_mask">
                    <form:hidden path="id"/>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="name" name="name" path="name" required="required"
                               class="form-control has-feedback-left" placeholder="用户名称"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="password" name="password" path="password" required="required"
                               class="form-control has-feedback-left" placeholder="用户密码"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group">
                        <form:input type="file" id="picture" name="picture" path="picture" class="form-control"/>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="single_cal1" name="birthday" path="birthday" class="form-control has-feedback-left"
                               placeholder="用户出生日期" aria-describedby="inputSuccess2Status"/>
                        <span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
                        <span id="inputSuccess2Status" class="sr-only">(success)</span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="address" name="address" path="address" required="required"
                               class="form-control has-feedback-left" placeholder="用户地址"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <div id="sex" class="btn-group" data-toggle="buttons">
                            <label class="btn btn-secondary" data-toggle-class="btn-primary"
                                   data-toggle-passive-class="btn-default">
                                <input type="radio" name="sex" value="男" class="join-btn"> 男 &nbsp;
                            </label>
                            <label class="btn btn-primary" data-toggle-class="btn-primary"
                                   data-toggle-passive-class="btn-default">
                                <input type="radio" name="sex" value="女" class="join-btn"> 女
                            </label>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="age" name="age" path="age" required="required"
                               class="form-control has-feedback-left" placeholder="用户年龄"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="isMarry" name="isMarry" path="isMarry" required="required"
                               class="form-control has-feedback-left" placeholder="用户婚否"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="hobby" name="hobby" path="hobby" required="required"
                               class="form-control has-feedback-left" placeholder="用户爱好"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="specialty" name="specialty" path="specialty" required="required"
                               class="form-control has-feedback-left" placeholder="用户特长"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="primarySchool" name="primarySchool" path="primarySchool" required="required"
                               class="form-control has-feedback-left" placeholder="用户所在小学"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="middleSchool" name="middleSchool" path="middleSchool" required="required"
                               class="form-control has-feedback-left" placeholder="用户所在中学"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="highSchool" name="highSchool" path="highSchool" required="required"
                               class="form-control has-feedback-left" placeholder="用户所在高中"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="university" name="university" path="university" required="required"
                               class="form-control has-feedback-left" placeholder="用户所在大学"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="otherEducation" name="otherEducation" path="otherEducation" required="required"
                               class="form-control has-feedback-left" placeholder="用户其他教育经历"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="skill" name="skill" path="skill" required="required"
                               class="form-control has-feedback-left" placeholder="用户拥有技能"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="company" name="company" path="company"
                               class="form-control has-feedback-left" placeholder="用户所在公司"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="resume" name="resume" path="resume"
                               class="form-control has-feedback-left" placeholder="用户履历"/>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="area" name="area" path="area"
                               class="form-control has-feedback-left" placeholder="用户地区地址"/>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="phone" name="phone" path="phone"
                               class="form-control has-feedback-left" placeholder="用户电话"/>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="email" name="email" path="email"
                               class="form-control has-feedback-left" placeholder="用户邮箱"/>
                    </div>
                    <div class="col-md-4 col-sm-4  form-group has-feedback">
                        <form:input type="text" id="usingStatus" name="usingStatus" path="usingStatus"
                               class="form-control has-feedback-left" placeholder="账号是否启用"/>
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
