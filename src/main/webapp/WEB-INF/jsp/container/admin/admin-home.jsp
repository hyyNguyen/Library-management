<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div id="page-wrapper" class="gray-bg">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Static Tables</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="index.html">Home</a>
                </li>
                <li>
                    <a>Tables</a>
                </li>
                <li class="active">
                    <strong>Duyệt Sách</strong>
                </li>
            </ol>
        </div>
            
    </div>
        
    <div class="wrapper wrapper-content animated fadeInRight">
        
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Duyệt Sách </h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row" style="margin-right: 10px">
                            <div class="col-sm-3">
                                <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> 
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> 
                                    </span>
                                        
                                </div>
                                    
                                    
                                    
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th>#</th>
                                        
                                    <th>Tên Người Đặt Hàng</th>
                                    <th>Email</th>
                                    <th>Tên Sách Thuê</th>
                                    <th>Số Lượng</th>
                                    <th>Ngày Thuê</th>
                                    <th>Ngày Trả</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listcartdetail}" var="cartdetail" varStatus="status">
                                        <tr>
                                        <td>${status.index}</td>
                                        <td>${cartdetail.idCart.idUser.nameUser}</td>
                                        <td>${cartdetail.idCart.idUser.email}</td>
                                        <td>${cartdetail.idBook.nameBook}</td>
                                        <td>${cartdetail.indemnification}</td>
                                        <td>${cartdetail.borrowingDay}</td>
                                        <td>${cartdetail.payDay}</td>
                                        <td>
                                            <a class="fa fa-check-square-o" title="Duyệt Sách" ></a>
                                                
                                            <a class="fa fa-times-circle-o" title="Xóa Đưn Hàng" href="<c:url value="/admin/deletecartdetail?idCartdetail=${cartdetail.idCartdetail}"/>" ></a> 
                                        </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
                
        </div>
    </div>
    <div style="clear:both">
        
    </div>