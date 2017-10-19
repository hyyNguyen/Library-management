<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div id="content">
    <div class="bg-color">
        <div class="wrapper">
            <div class="container banner-info login-page">
                <div class="panel background-transparent-white">
                    <div class="panel-body">
                        <div class="row text-center logo-dec">
                            <div class="col-xs-12 col-sm-12 col-md-12">
                                <h1>Sign Up</h1>
                            </div>
                        </div>
                        <div class="row">
                            
                            <form:form method="POST"  class="login-form logo-dec" commandName="signup">
                                <div class="form-group">
                                    <label >Họ Và Tên</label>
                                    <form:input type="text" path="nameUser" required="true"  class="form-control"  placeholder="Họ và tên"/>
                                </div>
                                <div class="form-group">
                                    <label >Password</label>
                                    <form:input type="password" path="password" required="true"  class="form-control"  placeholder="Password"/>
                                </div>
                                <div class="form-group">
                                    <label >Email</label>
                                    <form:input type="email" path="email" required="true"  class="form-control"   placeholder="Email"/>
                                </div>
                                    
                                <div class="form-group text-center">
                                    <button type="submit" class="btn btn-default" name="save" >Sign up</button>
                                </div> 
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                            </form:form>
                                
                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>