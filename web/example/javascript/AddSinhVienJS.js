document.getElementById("bodyID").onload = function() {OnLoadBody()};

function OnLoadBody() {
    var thongBao = document.getElementById("divThongBao").value;
    if(thongBao == "true"){
        alert("Mã sinh viên bị trùng");
    }
}