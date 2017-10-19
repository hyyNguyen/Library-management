<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section class="content section-padding">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 cart" style="margin-top: 20px">
                <h3 class="text-center">Thuê Sách</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 text-center" style="margin-top: 20px">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <tr>
                        <th>Bìa Sách</th>
                        <th>Tên Sách</th>
                        <th>Số Lượng</th>
                        <th>Ngày Trả</th>
                        <th>Thực Thi</th>
                        </tr>
                        <c:forEach items="${cartInfo.cartLines}" var="cart" varStatus="status">
                            <tr>
                            <td><img src="${cart.book.imageBook}" class="img-responsive center-block" ></td>
                            <td data-toggle="tooltip" title="${cart.book.nameBook}">${cart.book.nameBook}</td>
                            <form action="${contextPath}/updateBook" method="post">
                                <input name="idbook" type="hidden" value="${cart.book.idBook}"/>
                                <td><input type="number" name="soluong" value="${cart.quantity}"   style="border-radius: 10px;padding: 5px; text-align: center;"></td>
                                <td><input type="text" name="ngaytra" style="padding: 5px; border-radius: 10px" value="${cart.ngayTra}"/></td>
                                <td>
                                <button class="btn btn-warning" type="button" onclick="location.href = '${contextPath}/deleteCart/${cart.book.idBook}'" >Xóa</button>
                                <input type="submit" class="btn btn-primary" value="Cập Nhật" >
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                </div> 
            </div>
            <div style="float:left">
                <a href="<c:url value="/home"/>">
                    <input type="button" value="Tiếp Tục" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 14px  ;cursor: pointer;">
                </a>
            </div>
            <div style="float:right">
                <a href="<c:url value="/order"/>">
                    <input type="button" value="Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 14px  ;cursor: pointer;">
                </a>
            </div>
        </div>
</section>