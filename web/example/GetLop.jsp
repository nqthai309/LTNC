<%-- 
    Document   : GetSinhVien
    Created on : Nov 27, 2020, 2:49:47 PM
    Author     : thai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="./">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
        <meta name="author" content="Łukasz Holeczek">
        <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
        
    

        <title>Danh Sách Lớp</title>

        <!-- Main styles for this application-->
        <link href="./home_style/css/style.css" rel="stylesheet">
        <!-- Global site tag (gtag.js) - Google Analytics-->
        <link href="./home_style/vendors/coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    </head>
    <body>
        <s:include value="menu.jsp"></s:include>
    <div class="c-wrapper c-fixed-components">
        <header class="c-header c-header-light c-header-fixed c-header-with-subheader">
            <s:include value="header.jsp"></s:include>
        </header>
        <div class="c-body">
            <main class="c-main">
                <div class="container-fluid">
                    <div class="fade-in">
                        <!--body-->
                        <s:if test="noData==true">
                            
                        
                        <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-header"><i class="fa fa-align-justify"></i> Danh sách lớp</div>
                <div class="card-body">
                    <table class="table table-responsive-sm">

                        <thead>

                            <tr>
                                <th>Mã Lớp</th>
                                <th>Tên Lớp</th>
                                <th>Mã Khoa</th>
                                <th>Mã Hệ ĐT</th>
                                <th>Mã Khoá Học</th>
                                <th> </th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listLops">
                                <tr>

                                    <td><s:property value="maLop"/></td>
                                    <td><s:property value="tenLop"/></td>
                                    <td><s:property value="maKhoa"/></td>
                                    <td><s:property value="maHeDT"/></td>
                                    <td><s:property value="maKhoaHoc"/></td>
                                    
                                    <!--<td><a href="">Thêm điểm</a></td>-->
                                    <td><a href="">Sửa</a></td>
                                    <td><a style="color:red" href="">Xoá</a></td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
                            </s:if>
                        <s:else>
                            <div style="color: red;">No Data Found.</div>
                        </s:else>
                        <!--body-->
                        
                    </div>
                </div>
            </main>
            <footer class="c-footer">
                <s:include value="footer.jsp"></s:include>
            </footer>
        </div>
    </div>
    <!-- CoreUI and necessary plugins-->
    <script src="./home_style/vendors/coreui/coreui/js/coreui.bundle.min.js"></script>
    <!--[if IE]><!-->
    <script src="./home_style/vendors/coreui/icons/js/svgxuse.min.js"></script>
    <!--<![endif]-->
    <!-- Plugins and scripts required by this view-->
    <script src="./home_style/vendors/coreui/chartjs/js/coreui-chartjs.bundle.js"></script>
    <script src="./home_style/vendors/coreui/utils/js/coreui-utils.js"></script>
    <script src="./home_style/js/main.js"></script>
    </body>
</html>
