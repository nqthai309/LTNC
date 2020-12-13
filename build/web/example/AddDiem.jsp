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
        
    

        <title>Thêm Sinh Viên</title>

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
                        <div class="card">
    <div class="card-header"><strong>Basic Form</strong> Elements</div>
    <div class="card-body">
        <s:form class="form-horizontal" action="addDiemSinhVienSubmitAction" method="post" enctype="multipart/form-data">

            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="text-input">Mã Sinh Viên</label>
                <div class="col-md-9">
                    <input class="form-control" readonly="" value="<s:property value="maSV"/>" id="maSV" type="text" name="maSV" placeholder="Mã SV">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="text-input">Mã Môn Học</label>
                <div class="col-md-9">
                    <select class="form-control" id="maMH" name="maMH">
                        <s:iterator value="maMocHocs">
                            <option value="<s:property/>"><s:property/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="email-input">Học Kỳ</label>
                <div class="col-md-9">
                    <input class="form-control" type="number" id="hocKy" name="hocKy" >
                </div>
                    
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="email-input">Điểm Lần 1</label>
                <div class="col-md-9">
                    <input class="form-control" type="number" id="diemLan1" name="diemLan1" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label" for="address">Điểm Lần 2</label>
                <div class="col-md-9">
                    <input class="form-control" type="number" id="diemLan2" name="diemLan2" >
                </div>
            </div>
            
            
            <div style="color:red; font-size:20px; text-align:center" id="divThongBao"></div>
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
    <script src="javascript/AddDiemJS.js" type="text/javascript"></script>
    </body>
</html>
