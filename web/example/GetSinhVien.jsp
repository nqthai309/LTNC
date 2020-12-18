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
        
    

        <title>Danh Sách Sinh Viên</title>

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
                <div class="card-header"><i class="fa fa-align-justify"></i> Danh sách sinh viên</div>
                <div class="card-header"><i class="fa fa-align-justify" ></i>
                    <s:form action="timKiemSinhVienAction" method="post">
                    <div style="display: flex">
                        
                        <input class="form-control" id="timKiem" type="text" name="textSearch" placeholder="Tìm Kiếm theo tên  VD: Thái" value="<s:property value="textSearch"/>">
                        <button id="btnTimKiem" class="btn btn-sm btn-primary"  type="submit"> Search</button>
                        
                    </div>
                    <div style="display: flex; margin-top: 8px">
                        <input type="hidden" value="<s:property value="radioButton"/>" id="radioButtonValue"/>
                        <input type="hidden" value="<s:property value="sum"/>" id="sum"/>
                        <div style="display: flex">
                            <input id="sxten" name="radioButton" style="margin-top: 4px" type="radio" value="sxten" checked=<s:property value="radioButton"/>==sxten?"checked":"unchecked" />
                            <div style="padding-left: 6px">Sắp xếp theo tên</div>
                            
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxlop" name="radioButton" style="margin-top: 4px" type="radio" value="sxlop"/>
                            <div style="padding-left: 6px">Sắp xếp theo lớp</div>
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxgioitinh" name="radioButton" style="margin-top: 4px" type="radio" value="sxgioitinh"/>
                            <div style="padding-left: 6px">Sắp xếp theo giới tính</div>
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxquequan" name="radioButton" style="margin-top: 4px" type="radio" value="sxquequan"/>
                            <div style="padding-left: 6px">Sắp xếp theo quê quán</div>
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
                                <th>Tên Sinh Viên</th>
                                <th>Giới Tính</th>
                                <th>Ngày Sinh</th>
                                <th>Quê Quán</th>
                                <th>Mã Lớp</th>
                                <th> </th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
        
                            <s:iterator value="sinhViens">
                                <tr>
                                    
                                    <td><s:property value="tenSinhVien"/></td>
                                    <td><s:property value="gioiTinh"/></td>
                                    <td><s:property value="ngaySinh"/></td>
                                    <td><s:property value="queQuan"/></td>
                                    <td><s:property value="maLop"/></td>
      
                                    <td><a href="addDiemSinhVienAction.action?maSV=<s:property value="maSV"/>">Thêm điểm</a></td>
                                    <td><a href="editSinhVienAction.action?submitType=updatedata&maSV=<s:property value="maSV"/>">Sửa</a></td>
                                   
                                    <td><a id="deleteSinhVien<s:property value="maSV"/>" style="color:red" href="deleteSinhVienAction.action?submitType=deletedata&maSV=<s:property value="maSV"/>">Xoá</a></td>
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
    <script src="javascript/GetSinhVienJS.js" type="text/javascript"></script>
    </body>
</html>
