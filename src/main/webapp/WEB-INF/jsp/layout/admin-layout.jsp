<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <link rel="stylesheet" href="<c:url value="/resources/css/admin/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/font-awesome/css/font-awesome.css"/>"/ >
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/plugins/iCheck/custom.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/animate.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/admin/style.css" />"/>
    
    <!-- Mainly scripts -->
    <script src="<c:url value="/resources/js/admin/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="/resources/js/admin/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/admin/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
    <script src="<c:url value="/resources/js/admin/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>

    <!-- Peity -->
    <script src="<c:url value="/resources/js/adminplugins/peity/jquery.peity.min.js"/>"></script>

    <!-- Custom and plugin javascript -->
    <script src="<c:url value="/resources/js/admin/inspinia.js"/>"></script>
    <script src="<c:url value="/resources/js/admin/plugins/pace/pace.min.js"/>"></script>

    <!-- iCheck -->
    <script src="<c:url value="/resources/js/admin/plugins/iCheck/icheck.min.js"/>"></script>

    <!-- Peity -->
    <script src="<c:url value="/resources/js/admin/demo/peity-demo.js"/>"></script>


    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="body" />
        <div style="clear:both">
            <tiles:insertAttribute name="footer" />
        </div>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
    </body>
</html>
