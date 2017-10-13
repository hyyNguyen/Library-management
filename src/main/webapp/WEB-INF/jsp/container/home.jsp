<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
<section class="content section-padding">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 remove-padding-bootstrap">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="resources/images/quangcao/quangcao1.jpg" style="width:100%;">
                        </div>
                        <div class="item">
                            <img src="resources/images/quangcao/quangcao2.jpg" style="width:100%;">
                        </div>
                        <div class="item">
                            <img src="resources/images/quangcao/quangcao3.jpg" style="width:100%;">
                            <!--                                                        <div class="carousel-caption">
                                                                                        <h3>New York</h3>
                                                                                        <p>We love the Big Apple!</p>
                                                                                    </div>-->
                        </div>
                        <div class="item">
                            <img src="resources/images/quangcao/quangcao4.jpg" style="width:100%;">
                        </div>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>

<!--        <div style="padding-top: 20px; text-decoration: underline; color: black; font-size: 27px; ">
            <p>Sách Mới Phát Hành</p>
        </div>-->
        <div class="row" style="margin-top: 15px;">
             <c:forEach items="${listSach}" var="sach">
           <div class="col-xs-12 col-sm-3 col-md-3 product" >
               <a href="<c:url value="/detail?idbook=${sach.idBook}"/>">
                   <img class="home-img img-responsive center-block" src="${sach.imageBook}" alt="">
                    <h3 style="padding-top:5px; color: red" 
                        data-toggle="tooltip" title="${sach.nameBook}">${sach.nameBook}</h3>
                    <label style = "text-align: center">${sach.idAuthor.nameAuthor}</label>
                </a>
            </div>
             </c:forEach>
            
        </div>

    </div>
</section>