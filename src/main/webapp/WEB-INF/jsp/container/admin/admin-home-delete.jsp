<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<div id="page-wrapper" class="gray-bg">
    <div class="col-lg-12 animated fadeInRight">
        <div class="mail-box-header">
            
            <h2>
                Xóa Đơn Hàng
            </h2>
        </div>
        <div class="mail-box">
            
            <form:form method="POST" action="deletecartdetail"commandName="cartdetail" class="form-horizontal">
                <div class="mail-body">
                    
                    <div class="form-group"><label class="col-sm-2 control-label">To:</label>
                        <div class="col-sm-10">
                            <form:input type="text" path="email" required="true" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group"><label class="col-sm-2 control-label">Subject:</label>
                        
                        <div class="col-sm-10">
                            <input type="text" class="form-control" value="Hủy Đơn Hàng">
                        </div>
                    </div>
                    <div class="form-group"><label class="col-sm-2 control-label">Nội Dung</label>
                        
                        <div class="col-sm-10">
                            <input type="text" class="form-control" value="Ly Do Huy">
                        </div>
                    </div>
                        
                </div>
                    
        </div>
        <div class="mail-body text-right tooltip-demo">
            <a href="mailbox.html" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i> OK</a>
        </div>
        <div class="clearfix"></div>
            
        </form:form>
            
    </div>
</div>
    
</div>