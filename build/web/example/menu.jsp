<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="c-sidebar c-sidebar-dark c-sidebar-fixed c-sidebar-lg-show" id="sidebar">
        <div class="c-sidebar-brand d-lg-down-none">
            <svg class="c-sidebar-brand-full" width="118" height="46" alt="CoreUI Logo">
                <use xlink:href="./home_style/assets/brand/coreui.svg#full"></use>
            </svg>
            <svg class="c-sidebar-brand-minimized" width="46" height="46" alt="CoreUI Logo">
                <use xlink:href="./home_style/assets/brand/coreui.svg#signet"></use>
            </svg>
        </div> 
        <ul class="c-sidebar-nav">
            <li class="c-sidebar-nav-item">
<!--                <a class="c-sidebar-nav-link" href="#">
                    <svg class="c-sidebar-nav-icon">
                        <use xlink:href="./home_style/vendors/coreui/icons/svg/free.svg#cil-speedometer"></use>
                    </svg> Dashboard<span class="badge badge-info">NEW</span>
                </a>-->
            </li>
            <li class="c-sidebar-nav-title">Components</li>
            <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">
                <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">
                    <svg class="c-sidebar-nav-icon">
                        <!--<use xlink:href="./home_style/vendors/coreui/icons/svg/free.svg#cil-cart"></use>-->
                    </svg> Sinh Viên
                </a>
                <ul class="c-sidebar-nav-dropdown-items">
  
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="addSinhVienAction"><span class="c-sidebar-nav-icon"></span> Thêm mới</a></li>
                    
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="listSinhVienAction"><span class="c-sidebar-nav-icon"></span> Danh sách</a></li>
                </ul>
            </li>
            <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">
                <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">
                    <svg class="c-sidebar-nav-icon">
                        <!--<use xlink:href="./home_style/vendors/coreui/icons/svg/free.svg#cil-contact"></use>-->
                    </svg> Điểm
                </a>
                <ul class="c-sidebar-nav-dropdown-items">
                    <!--<li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="AddDiem.jsp"><span class="c-sidebar-nav-icon"></span> Thêm mới</a></li>-->
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="listDiemAction"><span class="c-sidebar-nav-icon"></span> Danh sách</a></li>
                </ul>
            </li>
            <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">
                <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">
                    <svg class="c-sidebar-nav-icon">
                        <!--<use xlink:href="./home_style/vendors/coreui/icons/svg/free.svg#cil-room"></use>-->
                    </svg> Lớp
                </a>
                <ul class="c-sidebar-nav-dropdown-items">
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="addLopAction"><span class="c-sidebar-nav-icon"></span> Thêm mới</a></li>
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="listLopAction"><span class="c-sidebar-nav-icon"></span> Danh sách</a></li>
                </ul>
            </li>
            <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">
                <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">
                    <svg class="c-sidebar-nav-icon">
                        <!--<use xlink:href="./home_style/vendors/coreui/icons/svg/free.svg#cil-house"></use>-->
                    </svg> Khoa
                </a>
                <ul class="c-sidebar-nav-dropdown-items">
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="addKhoaAction"><span class="c-sidebar-nav-icon"></span> Thêm mới</a></li>
                    <li class="c-sidebar-nav-item"><a class="c-sidebar-nav-link" href="listKhoaAction"><span class="c-sidebar-nav-icon"></span> Danh sách</a></li>
                </ul>
            </li>
        </ul>
        <button class="c-sidebar-minimizer c-class-toggler" type="button" data-target="_parent" data-class="c-sidebar-minimized"></button>
    </div>