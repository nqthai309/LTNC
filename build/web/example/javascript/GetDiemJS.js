document.getElementById("bodyID").onload = function() {OnLoadBody()};

function OnLoadBody(){
    var radionButtonValue = document.getElementById("radioButtonValue").value;
    var item = ["sxMaSV", "sxMaMH", "sxHocKy", "sxDiemLan1", "sxDiemLan2", "sx"];
    item.forEach(myFunction);
    
    function myFunction(item, index){
        var it = document.getElementById(item).value;
        if(it == radionButtonValue){
            document.getElementById(item).checked = true;
        }
    }
    
    //convert true -> nam va nguoc lai
    var cell = document.querySelectorAll("[id = 'sum']");
    
    
}
