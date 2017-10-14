    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper" class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
        
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Thông Tin Chi Tiết Sách</h5>
                            
                    </div>
                    <div class="ibox-content">
                        <form:form method="post" action="update" commandName="listbook" class="form-horizontal">
                            
                            <div class="hr-line-dashed"></div>
                                
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Tên Sách</label>
                                        
                                <div class="col-sm-10">
                                    <form:input type="text" path="nameBook" class="form-control"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                                
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Tác Giả</label>
                                        
                                <div class="col-sm-10">
                                    <form:select class="form-control m-b" path="idAuthor.idAuthor">
                                        <c:forEach items="${listauthor}" var="author">
                                            <form:option value="${author.idAuthor}">${author.nameAuthor}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                                
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Danh Mục</label>
                                        
                                <div class="col-sm-10">
                                    <form:select class="form-control m-b" path="idCategory.idCategory">
                                        <c:forEach items="${listcategory}" var="category">
                                            <form:option value="${category.idCategory}">${category.nameCategory}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Nhà Xuất Bản</label>
                                        
                                <div class="col-sm-10">
                                    <form:select class="form-control m-b" path="idPublishingcompany.idPublishingcompany">
                                        <c:forEach items="${listpublishingcompany}" var="publishingcompany">
                                            <form:option value="${publishingcompany.idPublishingcompany}">${publishingcompany.namePublishingcompany}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Noi Luu Tru</label>
                                    
                                <div class="col-sm-10">
                                    <form:select class="form-control m-b" path="idStorage.idStorage">
                                        <c:forEach items="${liststorage}" var="storage">
                                            <form:option value="${storage.idStorage}">${storage.nameStoragel}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            
                                
                            <div class="hr-line-dashed"></div>
                                
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Số lượng</label>
                                        
                                <div class="col-sm-10">
                                    <form:input type="text" path="quantity" class="form-control"/></div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Hình Ảnh Sách</label>
                                        
                                <div class="col-sm-10">
                                    <form:input type="text" path="imageBook" class="form-control"/></div>
                            </div>
                            <div class="hr-line-dashed"></div>
                                
                                
                            
                            <button type="submit" class="btn btn-sm btn-primary" style="margin-left: 795px">Save </button> 
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>