function loadRegions() {
    $.ajax({
        url: 'http://localhost:8080/region/all',
        type: 'get',
        dataType: "json",
        success: function (data) {
            var itemsTable = "<table>" +
                "<tr>" +
                "<th>ID Региона</th>" +
                "<th>Наименование региона</th>" +
                "</tr>";
            $.each(data, function (i, val) {
                itemsTable += toRegionRow();
            });

            $("#data-tbl").html(itemsTable + "</table>");
        }
    });
}

function loadFlats() {
    $.ajax({
        url: 'http://localhost:8080/flat/all',
        type: 'get',
        dataType: "json",
        success: function (data) {
            var itemsTable = "<table>" +
                "<tr>" +
                "<th>ID Квартиры</th>" +
                "<th>Площадь</th>" +
                "<th>Комнат</th>" +
                "<th>Балкон</th>" +
                "<th>ID Региона</th>" +
                "<th>Наименование региона</th>" +
                "</tr>";
            $.each(data, function (i, val) {
                itemsTable += toFlatRow(val);
            });

            $("#data-tbl").html(itemsTable + "</table>");
        }
    });
}

function loadDeals() {
    $.ajax({
        url: 'http://localhost:8080/deal/all',
        type: 'get',
        dataType: "json",
        success: function (data, textStatus) {
            var itemsTable = "<table>" +
                "<tr>" +
                "<th>ID Сделки</th>" +
                "<th>Цена</th>" +
                "<th>Дата</th>" +
                "<th>ID Квартиры</th>" +
                "<th>Площадь</th>" +
                "<th>Комнат</th>" +
                "<th>Балкон</th>" +
                "<th>ID Региона</th>" +
                "<th>Наименование региона</th>" +
                "</tr>";
            $.each(data, function (i, val) {
                itemsTable += toDealRow(val);
            });

            $("#data-tbl").html(itemsTable + "</table>");
        }
    });
}

function nextPage(request, urlStr, beanType){
    $.ajax({
        url: 'urlStr',
        type: 'get',
        dataType: "json",
        data: request,
        success: function (data) {
            var itemsTable = "<table>";
            $.each(data, function (i, val) {
                if (beanType == 0)
                    itemsTable += toRegionRow(val);
                else if (beanType == 1)
                    itemsTable += toFlatRow(val);
                else if (beanType == 2)
                    itemsTable += toDealRow(val);
            });

            $("#data-tbl").html(itemsTable + "</table>");
        }
    });
}

function toRegionRow(val){
    return getRows([val.regionID, val.regionName]);
}

function toDealRow(val){
    return getRows([
        val.dealId.asInt,
        val.price.asDouble,
        val.dealDate.dayOfMonth,
        val.flat.flatId.asInt,
        val.flat.flatArea.asDouble,
        val.flat.flatRooms.asInt,
        val.flat.haveBalcony,
        val.flat.flatRegion.regionID,
        val.flat.flatRegion.regionName]);
}

function toFlatRow(val){
    return getRows([
        val.dealId.asInt,
        val.price.asDouble,
        val.dealDate.dayOfMonth,
        val.flat.flatId.asInt,
        val.flat.flatArea.asDouble,
        val.flat.flatRooms.asInt,
        val.flat.haveBalcony,
        val.flat.flatRegion.regionID,
        val.flat.flatRegion.regionName]);
}

function getRows(items) {
    var tr = "<tr>";
    $.each(items, function (i, value) {
        tr += "<td>" + value + "</td>";
    });
    return tr + "</tr>"
}

function itemSelected(item){
    item.style.color = 'white';
}

function itemUnselected(item){
    item.style.color = 'black';
}