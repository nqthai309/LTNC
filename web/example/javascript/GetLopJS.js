document.getElementById("bodyIDLop").onload = function() {OnLoadBody()};

function OnLoadBody(){
    var radionButtonValue = document.getElementById("radioButtonValue").value;
    var item = ["sxten", "sxkhoa", "sxhedt", "sxkhoahoc", "sx"];
    item.forEach(myFunction);
    
    function myFunction(item, index){
        var it = document.getElementById(item).value;
        if(it == radionButtonValue){
            document.getElementById(item).checked = true;
        }
    }
}
