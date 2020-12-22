var maKhoa = document.getElementById("maKhoa").value;
var maHeDT = document.getElementById("maHeDT").value;
var maKhoaHoc = document.getElementById("maKhoaHoc").value;
var e = document.getElementById("selectMaKhoa").value = maKhoa;
var e1 = document.getElementById("selectMaHeDT").value = maHeDT;
var e2 = document.getElementById("selectMaKhoaHoc").value = maKhoaHoc;
document.getElementById("btnThem").setAttribute("type","button");

document.getElementById("btnThem").onclick = function() {checkEmpty()};
function checkEmpty(){
    var tenLop = document.getElementById("tenLop").value;
    
    if(tenLop == ""){
        document.getElementById("divThongBao").innerHTML = "Thiếu Thông Tin.";
    }else{
        document.getElementById("btnThem").setAttribute("type","submit");
        document.getElementById("btnThem").click();
    }
}
