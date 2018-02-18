// var grid;
// var loader = new Slick.Data.RemoteModel();
// var nameFormatter = function (row, cell, value, columnDef, dataContext) {
//     s ="<b><a href='" + dataContext["id"] + "' target=_blank>" +
//         dataContext["name"] + "</a></b>";
//     return s;
// };
// var dateFormatter = function (row, cell, value, columnDef, dataContext) {
//     return (value.getMonth()+1) + "/" + value.getDate() + "/" + value.getFullYear();
// };
// var columns = [
//     {id: "Id", name: "#", field: "id", width: 40},
//     {id: "name", name: "Name", width: 520, formatter: nameFormatter, cssClass: "cell-story"},
//     {id: "date", name: "Date", width: 60, field: "dateFirstCame", sortable: true},
//     {id: "price", name: "price", field: "price", width: 60, sortable: true}
// ];
// var options = {
//     rowHeight: 64,
//     editable: false,
//     enableAddRow: false,
//     enableCellNavigation: false
// };
// var loadingIndicator = null;
// $(function () {
//     grid = new Slick.Grid("#myGrid", loader.data, columns, options);
//     grid.onViewportChanged.subscribe(function (e, args) {
//         var vp = grid.getViewport();
//         loader.ensureData(vp.top, vp.bottom);
//     });
//     grid.onSort.subscribe(function (e, args) {
//         loader.setSort(args.sortCol.field, args.sortAsc ? 1 : -1);
//         var vp = grid.getViewport();
//         loader.ensureData(vp.top, vp.bottom);
//     });
//     loader.onDataLoading.subscribe(function () {
//         if (!loadingIndicator) {
//             loadingIndicator = $("<span class='loading-indicator'><label>Buffering...</label></span>").appendTo(document.body);
//             var $g = $("#myGrid");
//             loadingIndicator
//                 .css("position", "absolute")
//                 .css("top", $g.position().top + $g.height() / 2 - loadingIndicator.height() / 2)
//                 .css("left", $g.position().left + $g.width() / 2 - loadingIndicator.width() / 2);
//         }
//         loadingIndicator.show();
//     });
//     loader.onDataLoaded.subscribe(function (e, args) {
//         for (var i = args.from; i <= args.to; i++) {
//             grid.invalidateRow(i);
//         }
//         grid.updateRowCount();
//         grid.render();
//         loadingIndicator.fadeOut();
//     });
//     $("#txtSearch").keyup(function (e) {
//         if (e.which == 13) {
//             loader.setSearch($(this).val());
//             var vp = grid.getViewport();
//             loader.ensureData(vp.top, vp.bottom);
//         }
//     });
//     loader.setSearch($("#txtSearch").val());
//     loader.setSort("create_ts", -1);
//     grid.setSortColumn("date", false);
//     // load the first page
//     grid.onViewportChanged.notify();
// });

$(function(){

});


function requiredFieldValidator(value) {
    if (value == null || value == undefined || !value.length) {
        return {valid: false, msg: "This is a required field"};
    } else {
        return {valid: true, msg: null};
    }
}
function waitingFormatter(value) {
    return "wait...";
}
function renderSparkline(cellNode, row, dataContext, colDef) {
    var vals = [
        dataContext["n1"],
        dataContext["n2"],
        dataContext["n3"],
        dataContext["n4"],
        dataContext["n5"]
    ];
    $(cellNode).empty().sparkline(vals, {width: "100%"});
}
var grid;
var data = [];
var columns = [
    {id: "id", name: "id", field: "id", sortable: false, width: 120, cssClass: "cell-title"},
    {id: "n1", name: "1", field: "n1", sortable: false, editor: Slick.Editors.Integer, width: 40, validator: requiredFieldValidator},
    {id: "n2", name: "2", field: "n2", sortable: false, editor: Slick.Editors.Integer, width: 40, validator: requiredFieldValidator},
    {id: "n3", name: "3", field: "n3", sortable: false, editor: Slick.Editors.Integer, width: 40, validator: requiredFieldValidator},
    {id: "n4", name: "4", field: "n4", sortable: false, editor: Slick.Editors.Integer, width: 40, validator: requiredFieldValidator},
    {id: "n5", name: "5", field: "n5", sortable: false, editor: Slick.Editors.Integer, width: 40, validator: requiredFieldValidator},
    {id: "chart", name: "Chart", sortable: false, width: 60, formatter: waitingFormatter, rerenderOnResize: true, asyncPostRender: renderSparkline}
];
var columns = [
    {id: "Id", name: "#", field: "id", width: 40},
    {id: "name", name: "Name", width: 100, field: "name", cssClass: "cell-story"},
    {id: "date", name: "Date", width: 350, field: "dateFirstCame", sortable: true},
    {id: "price", name: "price", field: "price", width: 200, sortable: true}
];
var options = {
    editable: true,
    enableAddRow: false,
    enableCellNavigation: true,
    asyncEditorLoading: false,
    enableAsyncPostRender: true
};
$(function () {

    //
    // for (var i = 0; i < 500; i++) {
    //     var d = (data[i] = {});
    //     d["title"] = "Record " + i;
    //     d["n1"] = Math.round(Math.random() * 10);
    //     d["n2"] = Math.round(Math.random() * 10);
    //     d["n3"] = Math.round(Math.random() * 10);
    //     d["n4"] = Math.round(Math.random() * 10);
    //     d["n5"] = Math.round(Math.random() * 10);
    // }

    $.getJSON( "/product/", function( data ) {

        for(var i=0; i< 500; i++){
            data[i].dateFirstCame = new Date(data[i].dateFirstCame).toLocaleDateString("en-GB");
        }
        //onSuccess(data);
        grid = new Slick.Grid("#myGrid2", data, columns, options);
    });

});