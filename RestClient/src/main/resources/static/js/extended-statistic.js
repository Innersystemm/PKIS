function addParameter() {
    var report_type = $("#report-type-select option:selected").attr("href");
    var token = $("#select-parameter option:selected").val();
    var parameter_value = $("#selected-parameter-value").val();
    var selectedParamsInnerHTML = $("#selected-params-list").html();
    var filtrationParams = $("#filtration-params option:selected").val();
    $("#selected-params-list").html(
        selectedParamsInnerHTML + "<a class='requestParameter'>" + filtrationParams + token + parameter_value + "</a>");
}

/*
* Отправляем запрос к нужному методу rest api и возвращаем данные
* */
function sendRequest(urlAddr) {
    $.ajax({
        url: urlAddr,
        type: 'get',
        dataType: "json",
        success: function (data) {
            alert(data);
        },
        error: function (data) {
            alert("Something wrong:" + data.toString());
        }
    });
}

function getRequestUrl() {
    var data = $("a.requestParameter");
    var data_from = "&from=" + $("#interval-to").val();
    var data_to = "&to="  +$("#interval-to").val();
    var request = "&params=";
    $.each(data, function (i, val) {
        request += val.text + ",";
    });
    var skip = "&skip=" + $("#report-current-page").val();
    var take = "&recordsCount=25";
    var url = $("#report-type").val();
    return url + "?" + data_from + data_to + skip + take + request;
}

function reportSelected() {
    $("#report-type").val($("#report-type-select option:selected").attr("href"));
}

function getData() {
    alert(getRequestUrl());
}

function nextPage(){
    var value = $("report-current-page").val();
    $("report-current-page").val(value + 25);
}

function prevPage(){
    var value = $("report-current-page").val();
    if (value - 25 >= 0){
        $("report-current-page").val(value + 25);
    }
}