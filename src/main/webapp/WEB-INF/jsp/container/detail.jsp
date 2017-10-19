    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="content section-padding">
    <div class="container">
        <div class="row" style="width: 100%">
            <div style="margin-top: 20px ;text-decoration: underline;">Danh Mục/ ${sach.idCategory.nameCategory}/ ${sach.nameBook}</div>
            <div class="col-xs-12 col-sm-12 col-md-12 " style="margin-top: 20px">

                <div  class="col-xs-12 col-sm-4 col-md-4" style=" height: 500px" align="middle">
                    <img style="width: 90%"src=${sach.imageBook}   >
                </div>
                <div  class="col-xs-12 col-sm-8 col-md-8" style="height: 500px ;  ">
                    <p style="margin-top: 10px; color: black; font-weight: bold">${sach.nameBook}</p>
                    <p > Tác giả: <a href="#">${sach.idAuthor.nameAuthor}</a></p>
                    <div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="standard" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>  
                    <p style="margin-top: 5px">${sach.description1}</p>
                    <a href="#gts">Xem thêm nhiều hơn</a>
                    <hr style=" display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;">

                    <div style="margin-top: 20px">
                        <p>Số lượng sách còn lại: 10 </p>
                        <p>Có thể mượn sách</p>
                        <c:if test="${not pageContext.request.isUserInRole('ROLE_USER')}">
                            <a href="<c:url value="/login"/>">
                                <input type="submit" value="Đăng Nhập Để Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 4px 2px;cursor: pointer;">
                            </a>
                        </c:if>
                        <c:if test="${ pageContext.request.isUserInRole('ROLE_USER')}">
                            <a href="<c:url value="/addCart?idbook=${sach.idBook}"/>">
                                <input type="submit" value="Thuê Sách" style="border-radius: 12px; background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none; font-size: 16px; margin: 4px 2px;cursor: pointer;">
                            </a>
                        </c:if>
                    </div>
                </div>
                <hr style=" display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;">
            </div> 

        </div>

    </div>
    <div class="container">
        <div class="row" style="width: 100%">
            <a name="gts">
                <div style="margin-top: 20px ;text-decoration: underline;">Giới Thiệu Sách</div></a>
            <div class="col-xs-12 col-sm-12 col-md-12 product remove-padding-bootstrap" style="margin-top: 20px">
                <p>${sach.nameBook}</p>
                <p>${sach.description1}</p>
                <p>${sach.description2}</p>
                <p>${sach.description3}</p>
                <p>${sach.description4}</p>

                <p>Mời bạn đón đọc.</p>

            </div> 

        </div>
        <hr style=" display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;">
        <div class="fb-comments" data-href="http://localhost:8080/SpringProject/detail" data-numposts="5"></div>
    </div>
</section>