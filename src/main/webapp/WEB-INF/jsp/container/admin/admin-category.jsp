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
                    <strong>Tác Giả</strong>
                </li>
            </ol>
        </div>
        
    </div>
    
        <div class="wrapper wrapper-content animated fadeInRight">
    
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Danh Mục Sách </h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row" style="margin-right: 10px">
                            <div class="col-sm-3">
                                <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> 
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> 
                                    </span>
                                            
                                </div>
                                <a href="<c:url value="/admin/addcategory"/>">
                                <button type="button" class="btn btn-sm btn-primary"> Thêm Danh Mục</button> </a>
                                            
                                            
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                    <th>#</th>
                                    <th>ID Danh Mục</th>
                                    <th>Tên Danh Mục</th>
                                    <th>Hoạt Động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listcategory}" var="category" varStatus="status">
                                        <tr>    
                                        <td>${status.index}</td>
                                        <td>${category.idCategory}</td>
                                        <td>${category.nameCategory}</td>
                                        <td>
                                            <a class="fa fa-pencil-square" title="Edit" href="<c:url value="/update?idCategory=${category.idCategory}"/>"></a>
                                            
                                            <a class="fa fa-times-circle-o" title="Delete" href="<c:url value="/delete?idCategory=${category.idCategory}"/>" ></a> 
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