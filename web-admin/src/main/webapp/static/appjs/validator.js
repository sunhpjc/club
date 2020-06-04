/*
* 函数对象——> 默认闭包，更安全--->闭包特性，私有化（类似于私有函数）
* */
var Validate = function () {
    //下面是函数
    //初始化validation
    var handlerInitValidate = function () {
        $.validator.addMethod("mobile", function (value, element) {
            var length = value.length;
            var mobile = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])[0-9]{8}$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");
    };
    $("#inputForm").validate({
        errorElement:'span',
        errorClass:'help-block',
        errorPlaceMent:function (error,element) {
            element.attr("class","is-invalid");
            error.insertAfter(element);
        }
    });
    //因为是私有的，所以需要暴露给外部
    return{
        init:handlerInitValidate
    }
}();
$(document).ready(function () {
    Validate.init();
});
