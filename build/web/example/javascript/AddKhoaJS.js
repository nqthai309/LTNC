document.getElementById("bodyID").onload = function() {OnLoadBody()};

function OnLoadBody() {
    var thongBao = document.getElementById("divThongBao").value;
    if(thongBao == "true"){
        alert("Mã khoa bị trùng");
    }
}