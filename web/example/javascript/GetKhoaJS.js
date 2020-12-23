document.getElementById("bodyID1").onload = function() {OnLoadBody()};

function OnLoadBody(){
    var radionButtonValue = document.getElementById("radioButtonValue").value;
    var checkErrorDelete = document.getElementById("checkErrorDelete").value;
    
    var item = ["sxmakhoa", "sxtenkhoa"];
    item.forEach(myFunction);
    
    function myFunction(item, index){
        var it = document.getElementById(item).value;
        if(it == radionButtonValue){
            document.getElementById(item).checked = true;
        }
    }
    
    if(checkErrorDelete == "true"){
        alert("Không được phép xoá Khoa khi còn tồn tại khoá ngoại");
    }
    
    
    
    //convert true -> nam va nguoc lai
    var cell = document.querySelectorAll("[id = 'sum']");
    
    
}
