var maLop = document.getElementById("maLop").value;
var e = document.getElementById("selectMaLop").value = maLop;
document.getElementById("btnThem").setAttribute("type","button");

document.getElementById("btnThem").onclick = function() {checkEmpty()};
function checkEmpty(){
//    alert("Hello! I am an alert box!!");
    var tenSinhVien = document.getElementById("tenSinhVien").value;
//    var ngaySinh = document.getElementById("ngaySinh").value;
    var queQuan = document.getElementById("queQuan").value;
    
    if(tenSinhVien == "" || queQuan == ""){
        document.getElementById("divThongBao").innerHTML = "Thiếu Thông Tin.";
    }else{
        document.getElementById("btnThem").setAttribute("type","submit");
        document.getElementById("btnThem").click();
    }
}
