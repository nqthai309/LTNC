document.getElementById("bodyIDLop").onload = function() {OnLoadBody()};

function OnLoadBody(){
    var radionButtonValue = document.getElementById("radioButtonValue").value;
    var checkErrorDelete = document.getElementById("checkErrorDelete").value;
    
    var item = ["sxten", "sxkhoa", "sxhedt", "sxkhoahoc", "sx"];
    item.forEach(myFunction);
    
    function myFunction(item, index){
        var it = document.getElementById(item).value;
        if(it == radionButtonValue){
            document.getElementById(item).checked = true;
        }
    }
    
    if(checkErrorDelete == "true"){
        alert("Không được phép xoá Lớp còn chứa sinh viên ");
    }
}
