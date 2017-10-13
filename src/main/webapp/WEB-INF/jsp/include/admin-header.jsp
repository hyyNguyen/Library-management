<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="#">Profile</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Logout</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            TV
                        </div>
                    </li>
                    <li>
                      <a href="<c:url value="/admin"/>"> <i class="fa fa-laptop"></i><span class="nav-label">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="<c:url value="/adminnhanvien"/>"><i class="fa fa-group"></i> <span class="nav-label">Nhân Viên</span> </a>
                    </li>
                    <li>
                       <a href="<c:url value="/adminbandoc"/>"><i class="fa fa-child"></i> <span class="nav-label">Bạn Đọc</span> </a>
                    </li>
                    <li>
                        <a href="<c:url value="/adminsach"/>"><i class="fa fa-book"></i> <span class="nav-label">Sách</span> </a>
                    </li>
                    <li>
                       <a href="<c:url value="/admintacgia"/>"><i class="fa fa-gavel"></i> <span class="nav-label">Tác Giả</span> </a>
                    </li>
                    <li >
                        <a href="<c:url value="/admindanhmuc"/>"><i class="fa fa-folder-open"></i> <span class="nav-label">Danh Mục</span> </a>
                        
                    </li>
                    <li>
                       <a href="<c:url value="/adminnhaxuatban"/>"><i class="fa fa-gavel"></i> <span class="nav-label">Nhà Xuất Bản</span> </a>
                    </li>
                    
                </ul>

            </div>
        </nav>