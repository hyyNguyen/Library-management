    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="content section-padding">
    <div class="container">
        <div class="row" style="width: 100%">
            <!--            <div style="margin-top: 20px ;text-decoration: underline;">Cart</div>-->
            <c:url value="/order" var="action_order"/>
            <div class="col-xs-12 col-sm-12 col-md-12 cart" style="margin-top: 20px">
                <form:form id="cartform" method="POST"  commandName="cartList" action="${action_order}">
                    <table width="100%">
                        <thead>
                            <tr>
                            <th>ID Sách</th>
                            <th>Bìa Sách</th>
                            <th>Tên Sách</th>
                            <th>Số Lượng</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cartList.cartLines}" var="cart" varStatus="status">
                                <c:url value="/updateCart" var="action_form_update"/>
                                <input name="idBook" type="hidden" value="${cart.book.idBook}"/>
                                <tr>
                                <td>${cart.book.idBook}</td>
                                    
                                <td><img src="${cart.book.imageBook}" class="img-responsive center-block" ></td>
                                <td data-toggle="tooltip" >${cart.book.nameBook}</td>
                                <td>${cart.quantity}</td>
                                </tr>
                            </c:forEach>
                                
                        </tbody>
                    </table>
                        
                    <div style="margin: 50px;">
                        <div style=" float: left;font-size: 20px">Ngày Trả Sách</div>
                        <input type="date" style="margin-left: 20px; padding: 5px"/>
                    </div>
                        
                    <input type="submit" value="Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 14px  ;cursor: pointer;">
                        
                </form:form>
                    
            </div>
            </section>