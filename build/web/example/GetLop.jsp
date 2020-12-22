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
    <body id="bodyIDLop">
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
                <div class="card-header"><i class="fa fa-align-justify" ></i>
                    <s:form action="timKiemLopAction" method="post">
                    <div style="display: flex">
                        <input class="form-control" id="timKiem" type="text" name="textSearch" placeholder="Tìm Kiếm theo tên  VD: Lớp A" value="<s:property value="textSearch"/>">
                        <button id="btnTimKiem" class="btn btn-sm btn-primary"  type="submit"> Search</button>
                    </div>
                    <div style="display: flex; margin-top: 8px">
                        <input type="hidden" value="<s:property value="radioButton"/>" id="radioButtonValue"/>
                        <input type="hidden" value="<s:property value="sum"/>" id="sum"/>
                        <div style="display: flex">
                            <input id="sxten" name="radioButton" style="margin-top: 4px" type="radio" value="sxten" checked=<s:property value="radioButton"/>==sxten?"checked":"unchecked" />
                            <div style="padding-left: 6px">Sắp xếp theo Tên lớp</div> 
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxkhoa" name="radioButton" style="margin-top: 4px" type="radio" value="sxkhoa"/>
                            <div style="padding-left: 6px">Sắp xếp theo Khoa</div>
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxhedt" name="radioButton" style="margin-top: 4px" type="radio" value="sxhedt"/>
                            <div style="padding-left: 6px">Sắp xếp theo Hệ ĐT</div>
                        </div>
                        <div style="display: flex; margin-left: 50px">
                            <input id="sxkhoahoc" name="radioButton" style="margin-top: 4px" type="radio" value="sxkhoahoc"/>
                            <div style="padding-left: 6px">Sắp xếp theo Khóa Học</div>
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
                                   
                                    <td><a href="editLopAction.action?submitType=updatedata&maLop=<s:property value="maLop"/>">Sửa</a></td>
                                   
                                    <td><a id="deleteLop<s:property value="maLop"/>" style="color:red" href="deleteLopAction.action?submitType=deletedata&maLop=<s:property value="maLop"/>">Xoá</a></td>
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
    <script src="javascript/GetLopJS.js" type="text/javascript"></script>
    <script src="./home_style/js/main.js"></script>
    </body>
</html>
