document.getElementById("bodyID").onload = function() {OnLoadBody()};

function OnLoadBody(){
    var radionButtonValue = document.getElementById("radioButtonValue").value;
    var item = ["sxten", "sxlop", "sxquequan", "sxgioitinh", "sx"];
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
