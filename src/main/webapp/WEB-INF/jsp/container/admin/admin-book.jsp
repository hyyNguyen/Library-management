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
                    <strong>Sách</strong>
                </li>
            </ol>
        </div>
        
    </div>
    
    <div class="wrapper wrapper-content animated fadeInRight">
        
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Sách </h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row" style="margin-right: 10px">
                            <div class="col-sm-3">
                                <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> 
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> 
                                    </span>
                                    
                                </div>
                              <a href="<c:url value="/admin/addbook"/>">
                                <button type="button" class="btn btn-sm btn-primary">Thêm Sách </button> </a>
                                       
                                       
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>ID Sách</th>
                                        <th>Tên Sách</th>
                                        <th>Tên Tác Giả</th>
                                        <th>Tên Nhà Xuất Bản</th>
                                        <th>Tên Danh Mục</th>
                                        <th>Noi Luu Tru</th>
                                        <th>ISBN</th>
                                        <th>Số Lượng</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listbook}" var="book" varStatus="status">
                                        <tr>
                                            <td>${status.index}</td>
                                            <td>${book.idBook}</td>
                                            <td>${book.nameBook}</td>
                                            <td>${book.idAuthor.nameAuthor}</td>
                                            <td>${book.idPublishingcompany.namePublishingcompany}</td>
                                            <td>${book.idCategory.nameCategory}</td>
                                            <td>${book.idStorage.nameStoragel}</td>
                                            <td>${book.isbn}</td>
                                            <td>${book.quantity}</td>
                                        <td>
                                            <a class="fa fa-pencil-square" title="Edit" href="<c:url value="/adminsachedit"/>"></a>
                                            
                                            <a class="fa fa-times-circle-o" title="Delete" href="<c:url value="/delete?idBook=${book.idBook}"/>" ></a> 
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