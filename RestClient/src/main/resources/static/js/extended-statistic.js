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
            var json = "<tr><td>id</td><td>price</td><td>day</td><td>flatId</td><td>area</td><td>rooms</td><td>balcon</td><td>regionname</td></tr>";

            if (urlAddr.indexOf("detailed") >= 0) {
                $.each(data, function (i, val) {
                    json += "<tr><td>" + val.dealId.asInt + "</td><td>" + val.price.asDouble +
                        "</td><td>" + val.dealDate.dayOfYear + "</td><td>" + val.flat.flatId.asInt +
                        "</td><td>" + val.flat.flatArea.asDouble + "</td><td>" + val.flat.flatRooms.asInt +
                        "</td><td>" + val.flat.haveBalcony + "</td><td>" + val.flat.flatRegion.regionName + "</td>";
                });
            }
            if (urlAddr.indexOf("average") >= 0) {
                params = (""+data).split(' ');

                json = "<tr><td>averageDealCost=" + data.averageDealCost + "</td><td>" + "averageFlatArea="
                    + data.averageFlatArea + "</td><td>" + "averageRoomsCount=" + data.averageRoomsCount + "</td></tr>";
            }

            $("#returned-result-table").html(json);
        },
        error: function (data) {
            alert("Something wrong:" + data.toString());
        }
    });
}

function getRequestUrl() {
    var data = $("a.requestParameter");
    var data_from = "&from=" + $("#interval-from").val();
    var data_to = "&to=" + $("#interval-to").val();
    var request = "&params=";
    $.each(data, function (i, val) {
        request += val.text + ",";
    });
    var skip = "&skip=" + $("#report-current-page").val();
    var take = "&recordsCount=25";
    var url = $("#report-type").val();
    return url + "?" + data_from + data_to + skip + take + request.substring(0, request.length - 1);
}

function reportSelected() {
    $("#report-type").val($("#report-type-select option:selected").attr("href"));
}

function getData() {
    alert(getRequestUrl());
}

function nextPage() {
    var value = parseInt($("#report-current-page").val());
    $("#report-current-page").val(value + 25);
    sendRequest(getRequestUrl());
}

function prevPage() {
    var value = parseInt($("#report-current-page").val());
    if (value - 25 >= 0) {
        $("#report-current-page").val(value - 25);
    }
    sendRequest(getRequestUrl());
}