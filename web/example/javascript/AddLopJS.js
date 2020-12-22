document.getElementById("btnThem").setAttribute("type", "button");

document.getElementById("btnThem").onclick = function() {checkInfo()};

function checkInfo(){
    var tenLop = document.getElementById("tenLop").value;
    
    if( tenLop == ""){
        document.getElementById("divThongBao").innerHTML = "Thông tin chưa đủ.";
        document.getElementById("btnThem").setAttribute("type", "button");
    }else{
        document.getElementById("btnThem").setAttribute("type", "submit");
        document.getElementById("btnThem").click();
    }
}

