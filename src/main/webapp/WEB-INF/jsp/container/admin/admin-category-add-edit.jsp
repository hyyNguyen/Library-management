<%-- 
    Document   : admin-sach-add-edit
    Created on : Sep 20, 2017, 12:32:35 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="page-wrapper" class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
        
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Chi Tiết Danh Mục</h5>
                    </div>
                              
                    <form:form method="POST" action="updatecategory" commandName="category" class="form-horizontal" >
                       
                            <div class="ibox-content">
                                
                            <div class="form-group"><label class="col-sm-2 control-label">Tên Danh Mục</label>
                                <form:hidden path="idCategory" />
                                <div class="col-sm-10">
                                    <form:input type="text" path="nameCategory" required="true" class="form-control"/>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <input type="submit" class="btn btn-sm btn-primary" style="margin-left: 795px" value="Save"/>
                            
                        </div>
                    </form:form>
                </div>
                
            </div>
        </div>
    </div>
</div>
</div>