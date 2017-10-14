    
    
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
                    <table>
                        <thead>
                            <tr>
                            <th>ID Sách</th>
                            <th>Bìa Sách</th>
                            <th>Tên Sách</th>
                            <th>Số Lượng</th>
                            <th>Ngày Trả</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cartList.cartLines}" var="cart" varStatus="status">
                                <c:url value="/updateCart" var="action_form_update"/>
                                <input name="idsach" type="hidden" value="${cart.sach.idsach}"/>
                                <tr>
                                <td>${cart.sach.idsach}</td>
                                
                                <td><img src="${cart.sach.hinhanhsach}" class="img-responsive center-block" ></td>
                                <td data-toggle="tooltip" title="Trên Đường bay ">${cart.sach.tensach}</td>
                                <td>${cart.quantity}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                     <c:if test="${not empty sessionScope.userId}">
               
                    <input type="submit" value="Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 14px  ;cursor: pointer;">
                
            </c:if>
            
                                
                                
                </form:form>
            </div>  
        </div>
</section>