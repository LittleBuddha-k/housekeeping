<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${ctx}/index" class="site_title"><i class="fa fa-paw"></i> <span>猪儿虫网络爬虫</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_pic">
                <img src="${sessionScope.currentUser.picture}" alt="他泰坦" class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span>欢迎登录,</span>
                <h2>
                    <shiro:principal property="name"/>
                </h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br/>

        <!-- 左侧菜单 -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-sitemap"></i>系统设置<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a>地域管理<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li class="sub_menu"><a href="${ctx}/system/province/list">省级管理</a>
                                    </li>
                                    <li><a href="${ctx}/system/city/list">市级管理</a>
                                    </li>
                                    <li><a href="${ctx}/system/area/list">区级管理</a>
                                    </li>
                                    <li><a href="${ctx}/system/street/list">街级管理</a>
                                    </li>
                                </ul>
                            </li>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- 顶层显示邮件栏 -->
<div class="top_nav">
    <div class="nav_menu">
        <div class="nav toggle">
            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
        </div>
        <c:forEach items="${sessionScope.menus}" var="menu">
            <div class="navigation-bar-menu">
                <a href="javascript:;" onclick="getMenu(${menu.id})" id="${menu.id}">${menu.name}</a>
            </div>
        </c:forEach>
        <nav class="nav navbar-nav">
            <ul class=" navbar-right">
                <li class="nav-item dropdown open" style="padding-left: 15px;">
                    <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                       id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                        <img src="${sessionScope.currentUser.picture}" alt="">John Doe
                    </a>
                    <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="javascript:;"> Profile</a>
                        <a class="dropdown-item" href="javascript:;">
                            <span class="badge bg-red pull-right">50%</span>
                            <span>Settings</span>
                        </a>
                        <a class="dropdown-item" href="javascript:;">Help</a>
                        <a class="dropdown-item" href="login.html"><i class="fa fa-sign-out pull-right"></i> Log
                            Out</a>
                    </div>
                </li>

                <li role="presentation" class="nav-item dropdown open">
                    <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1"
                       data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-envelope-o"></i>
                        <span class="badge bg-green">6</span>
                    </a>
                    <ul class="dropdown-menu list-unstyled msg_list" role="menu"
                        aria-labelledby="navbarDropdown1">
                        <li class="nav-item">
                            <a class="dropdown-item">
                                        <span class="image"><img src="${sessionScope.currentUser.picture}"
                                                                 alt="Profile Image"/></span>
                                <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where${ctxStatic}.
                        </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="dropdown-item">
                                        <span class="image"><img src="${sessionScope.currentUser.picture}"
                                                                 alt="Profile Image"/></span>
                                <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where${ctxStatic}.
                        </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="dropdown-item">
                                        <span class="image"><img src="${sessionScope.currentUser.picture}"
                                                                 alt="Profile Image"/></span>
                                <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where${ctxStatic}.
                        </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="dropdown-item">
                                        <span class="image"><img src="${sessionScope.currentUser.picture}"
                                                                 alt="Profile Image"/></span>
                                <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                                <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where${ctxStatic}.
                        </span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <div class="text-center">
                                <a class="dropdown-item">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /顶层显示邮件栏 -->


</body>
</html>