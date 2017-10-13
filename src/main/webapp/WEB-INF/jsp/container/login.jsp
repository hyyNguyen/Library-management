<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
    <div class="bg-color">
        <div class="wrapper">
            <div class="container banner-info login-page">
                <div class="panel background-transparent-white">
                    <div class="panel-body">
                        <div class="row text-center logo-dec">
                            <div class="col-xs-12 col-sm-12 col-md-12">
                                <h1>Login</h1>
                            </div>
                        </div>
                        <div class="row">
                            <form class="form-horizontal login-form" action="<c:url value='j_spring_security_check' />" method='POST'>
                                <div class="form-group">
                                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-8">
                                        <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                                    <div class="col-sm-8">
                                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group text-center">
                                    <button type="submit" class="btn btn-default">Sign in</button>
                                </div> 
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>