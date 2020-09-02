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
                    <div class="x_panel tile fixed_height_320 overflow_hidden">
                        <div class="x_title">
                            <h2>Device Usage</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                        <a class="dropdown-item" href="#">Settings 1</a>
                                        <a class="dropdown-item" href="#">Settings 2</a>
                                    </div>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="" style="width:100%">
                                <tr>
                                    <th style="width:37%;">
                                        <p>Top 5</p>
                                    </th>
                                    <th>
                                        <div class="col-lg-7 col-md-7 col-sm-7 ">
                                            <p class="">Device</p>
                                        </div>
                                        <div class="col-lg-5 col-md-5 col-sm-5 ">
                                            <p class="">Progress</p>
                                        </div>
                                    </th>
                                </tr>
                                <tr>
                                    <td>
                                        <canvas class="canvasDoughnut" height="140" width="140"
                                                style="margin: 15px 10px 10px 0"></canvas>
                                    </td>
                                    <td>
                                        <table class="tile_info">
                                            <tr>
                                                <td>
                                                    <p><i class="fa fa-square blue"></i>IOS </p>
                                                </td>
                                                <td>30%</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p><i class="fa fa-square green"></i>Android </p>
                                                </td>
                                                <td>10%</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p><i class="fa fa-square purple"></i>Blackberry </p>
                                                </td>
                                                <td>20%</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p><i class="fa fa-square aero"></i>Symbian </p>
                                                </td>
                                                <td>15%</td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <p><i class="fa fa-square red"></i>Others </p>
                                                </td>
                                                <td>30%</td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
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
