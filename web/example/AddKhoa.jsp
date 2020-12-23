<%-- 
    Document   : AddKhoa
    Created on : Nov 28, 2020, 4:50:49 PM
    Author     : Thang
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
        
    

        <title>Thêm Khoa</title>

        <!-- Main styles for this application-->
        <link href="./home_style/css/style.css" rel="stylesheet">
        <!-- Global site tag (gtag.js) - Google Analytics-->
        <link href="./home_style/vendors/coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    </head>
    <body id = "bodyID">
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
                        <div class="card">
    <div class="card-header"><strong>Basic Form</strong> Elements</div>
    <div class="card-body">
        <s:form class="form-horizontal" action="addKhoaSubmitAction" method="post" enctype="multipart/form-data">

            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="text-input">Mã Khoa</label>
                <div class="col-md-9">
                    <input class="form-control" id="maKhoa" type="text" name="maKhoa" placeholder="Mã Khoa">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="text-input">Tên Khoa</label>
                <div class="col-md-9">
                    <input class="form-control" id="tenKhoa" type="text" name="tenKhoa" placeholder="Tên Khoa">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="address">Địa Chỉ</label>
                <div class="col-md-9">
                    <input class="form-control" type="address" id="diaChi" name="diaChi" placeholder="Địa Chỉ" autocomplete="">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="text-input">Số Điện Thoại</label>
                <div class="col-md-9">
                    <input class="form-control" id="dienThoai" type="text" name="dienThoai" placeholder="Số Điện Thoại Của Khoa">
                </div>
            </div>
                        
                        
                </div>
            </div>
            
            <input type="hidden"  id="divThongBao" value="<s:property value="checkError" />"/>
            <div class="card-footer">
                <button id="btnThem" class="btn btn-sm btn-primary" type="submit"> Submit</button>
            </div>
        </s:form>
    </div>
</div>
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
    <script src="javascript/AddKhoaJS.js" type="text/javascript"></script>
    <script src="./home_style/js/main.js"></script>
    </body>
</html>

