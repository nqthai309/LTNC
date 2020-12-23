document.getElementById("bodyIDLop").onload = function() {OnLoadBody()};

function OnLoadBody() {
    var thongBao = document.getElementById("divThongBao").value;
    if(thongBao == "true"){
        alert("Mã Lớp bị trùng");
    }
}