var Detail = function () {
    //详情页
    var handlerDetail = function (url) {
        $.ajax({
            "url":url,
            "type":"GET",
            "dataType":"html",
            "success":function (data) {
                $("#model_detailBody").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };
    var handlerCloseDetail = function () {
        $("#modal-detail").modal("hide");
        window.location.reload();
    };
    return{
        showDetail:function (url) {
            handlerDetail(url);
        },
        closeDetail:function () {
            handlerCloseDetail();
        }
    }
}();