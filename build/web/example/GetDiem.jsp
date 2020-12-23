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
        
    

        <title>Danh Sách Điểm</title>

        <!-- Main styles for this application-->
        <link href="./home_style/css/style.css" rel="stylesheet">
        <!-- Global site tag (gtag.js) - Google Analytics-->
        <link href="./home_style/vendors/coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    </head>
    <body id="bodyID">
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
                        <div class="card-header"><i class="fa fa-align-justify"></i> Danh sách điểm</div>
                        <div class="card-header"><i class="fa fa-align-justify" ></i>
                            <s:form action="timKiemDiemAction" method="post">
                            <div style="display: flex">

                                <input class="form-control" id="timKiem" type="text" name="textSearch" placeholder="Tìm Kiếm theo mã sinh viên:" value="<s:property value="textSearch"/>">
                                <button id="btnTimKiem" class="btn btn-sm btn-primary"  type="submit"> Search</button>

                            </div>
                            <div style="display: flex; margin-top: 8px">
                                <input type="hidden" value="<s:property value="radioButton"/>" id="radioButtonValue"/>
                                <input type="hidden" value="<s:property value="sum"/>" id="sum"/>
                                <div style="display: flex">
                                    <input id="sxMaSV" name="radioButton" style="margin-top: 4px" type="radio" value="sxMaSV" checked=<s:property value="radioButton"/>==sxMaSV?"checked":"unchecked" />
                                    <div style="padding-left: 6px">Sắp xếp theo mã sinh viên</div>

                                </div>
                                <div style="display: flex; margin-left: 50px">
                                    <input id="sxMaMH" name="radioButton" style="margin-top: 4px" type="radio" value="sxMaMH"/>
                                    <div style="padding-left: 6px">Sắp xếp theo mã môn học</div>
                                </div>
                                <div style="display: flex; margin-left: 50px">
                                    <input id="sxHocKy" name="radioButton" style="margin-top: 4px" type="radio" value="sxHocKy"/>
                                    <div style="padding-left: 6px">Sắp xếp theo học kỳ</div>
                                </div>
                                <div style="display: flex; margin-left: 50px">
                                    <input id="sxDiemLan1" name="radioButton" style="margin-top: 4px" type="radio" value="sxDiemLan1"/>
                                    <div style="padding-left: 6px">Sắp xếp theo điểm lần 1</div>
                                </div>
                                    <div style="display: flex; margin-left: 50px">
                                    <input id="sxDiemLan2" name="radioButton" style="margin-top: 4px" type="radio" value="sxDiemLan2"/>
                                    <div style="padding-left: 6px">Sắp xếp theo điểm lần 2</div>
                                </div>
                                <div style="display: flex; margin-left: 50px">
                                    <input id="sx" name="radioButton" style="margin-top: 4px" type="radio" value="sx" checked="checked"/>
                                    <div style="padding-left: 6px">Tất cả</div>
                                </div>
                            </div>
                            </s:form>
                        </div>
                        <div class="card-body">
                            <table class="table table-responsive-sm">
                                <thead>
                                    <tr>
                                        <th>Mã Sinh Viên</th>
                                        <th>Mã Môn Học</th>
                                        <th>Học Kỳ</th>
                                        <th>Điểm Lần 1</th>
                                        <th>Điểm Lần 2</th>
                                        <th> </th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="listDiem">
                                        <tr>
                                            <td><s:property value="maSV"/></td>
                                            <td><s:property value="maMH"/></td>
                                            <td><s:property value="hocKy"/></td>
                                            <td><s:property value="diemLan1"/></td>
                                            <td><s:property value="diemLan2"/></td>
                                            <td><a href="editDiemAction.action?submitType=updatedata&maSV=<s:property value="maSV"/>&maMH=<s:property value="maMH"/>">Sửa</a></td>
                                            <td><a style="color:red" href="deleteDiemAction.action?submitType=deletedata&maSV=<s:property value="maSV"/>&maMH=<s:property value="maMH"/>">Xoá</a></td>
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
    <script src="javascript/GetDiemJS.js" type="text/javascript"></script>
    </body>
</html>
