    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="content section-padding">
    <div class="container">
        <div class="row" style="width: 100%">
            <!--            <div style="margin-top: 20px ;text-decoration: underline;">Cart</div>-->
            <div class="col-xs-12 col-sm-12 col-md-12 cart" style="margin-top: 20px">
                <table>
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
                            <form:form method="get" action="${action_form_update}" id="contact${status.index+1}">
                                <input name="idsach" type="hidden" value="${cart.book.idBook}"/>
                                <tr>
                                <td>${cart.book.idBook}</td>
                                
                                <td><img src="${cart.book.imageBook}" class="img-responsive center-block" ></td>
                                <td data-toggle="tooltip" title="Trên Đường bay ">${cart.book.nameBook}</td>
                                <td><input type="number" name="soluong" value="${cart.quantity}"   style="border-radius: 12px;padding: 5px; text-align: center"></td>
                               <td><a href="<c:url value="/deleteCart?idsach=${cart.book.idBook}"/>" >xóa </a></td>
                                <td><a onclick="document.getElementById('contact${status.index+1}').submit(); return false;" href="javascript:{}" >cập nhật </a></td>
                                </tr>
                            </form:form>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
           
                <a href="<c:url value="/order"/>">
                    <input type="submit" value="Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 14px  ;cursor: pointer;">
                </a> 
           
            
        </div>
</section>