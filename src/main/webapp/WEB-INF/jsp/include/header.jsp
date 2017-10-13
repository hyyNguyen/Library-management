    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="header">
    <header id="main-header">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span class="logo-dec">Thuvien.vn</span></a>
                </div>
                    
                    
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right ">
                        <li style="padding-top: 17px">
                            <input type="text" style="width: 500px; border: 1px solid black; border-radius: 12px; padding: 4px 0px 2px 5px;" placeholder="Tìm Kiếm Sách...">
                                
                        </li>
                        <li><a href="<c:url value="/home"/>">Home</a></li>
                        <li class="dropdown">
                            <a href="#"data-toggle="dropdown" class="dropdown-toggle" >Product  <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${listCategory}" var="category">
                                    <li><a href="<c:url value="/product"/>">${category.nameCategory}</a></li>
                                    </c:forEach>
                            </ul>
                        </li>
                            
                        <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
                            <li><a href="#">Profile</a></li>
                            <li><a href="<c:url value="/logout"/>">LogOut</a></li
                            </c:if>       
                                
                        <c:if test="${not pageContext.request.isUserInRole('ROLE_USER')}">
                            <li><a href="<c:url value="/login"/>">Login</a></li>
                            <li><a href="<c:url value="/signup"/>">Sign up</a></li>
                            </c:if>
                                
                                
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</div>