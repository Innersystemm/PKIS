function addParameter() {
    var select_box = document.getElementById("select-parameter");
    var token = select_box.options[select_box.selectedIndex].value;
    var parameter_value = document.getElementById("selected-parameter-value").value;
    document.getElementById("selected-params-list").innerHTML +=
        "<p>" + token + parameter_value + "</p>"
}