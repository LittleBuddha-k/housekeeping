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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${ctxStatic}/gentelella/production/images/favicon.jpg" type="image/ico"/>
    <title>猪儿虫网络爬虫</title>
    <%@include file="/webpage/template/common/gentelella.jsp" %>
    <%@include file="index.js" %>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%@include file="/webpage/template/common/menunavigation.jsp" %>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="row">
                <div class="col-md-4 col-sm-4 ">

                </div>
            </div>
        </div>
        <!-- /page content -->

        <%--引入页脚--%>
        <%@include file="/webpage/template/common/footer.jsp" %>
    </div>
</div>

<!-- jQuery -->
<script src="${ctxStatic}/gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${ctxStatic}/gentelella/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="${ctxStatic}/gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="${ctxStatic}/gentelella/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="${ctxStatic}/gentelella/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="${ctxStatic}/gentelella/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="${ctxStatic}/gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="${ctxStatic}/gentelella/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="${ctxStatic}/gentelella/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="${ctxStatic}/gentelella/vendors/Flot/jquery.flot.js"></script>
<script src="${ctxStatic}/gentelella/vendors/Flot/jquery.flot.pie.js"></script>
<script src="${ctxStatic}/gentelella/vendors/Flot/jquery.flot.time.js"></script>
<script src="${ctxStatic}/gentelella/vendors/Flot/jquery.flot.stack.js"></script>
<script src="${ctxStatic}/gentelella/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="${ctxStatic}/gentelella/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="${ctxStatic}/gentelella/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="${ctxStatic}/gentelella/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="${ctxStatic}/gentelella/vendors/DateJS/build/date.js"></script>


<!-- Custom Theme Scripts -->
<script src="${ctxStatic}/gentelella/build/js/custom.min.js"></script>

</body>
</html>
