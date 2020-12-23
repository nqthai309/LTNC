document.getElementById("btnThem").setAttribute("type", "button");

document.getElementById("btnThem").onclick = function() {checkInfo()};

function checkInfo(){
    var hocKy = document.getElementById("hocKy").value;
    var diemLan1 = document.getElementById("diemLan1").value;
    var diemLan2 = document.getElementById("diemLan2").value;
    
    if( (hocKy <= 0 || hocKy > 10 || hocKy == "") || (diemLan1 < 0 || diemLan1 > 10 || diemLan1 == "") 
            || (diemLan2 < 0 || diemLan2 > 10 || diemLan2 == "") ){
        document.getElementById("divThongBao").innerHTML = "Thông tin chưa đúng.";
        document.getElementById("btnThem").setAttribute("type", "button");
    }else{
        document.getElementById("btnThem").setAttribute("type", "submit");
        document.getElementById("btnThem").click();
//        alert("Thêm thành công");
    }
}