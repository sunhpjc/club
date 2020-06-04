var iCheck = function () {
    //iCheck两个私有属性
    var check_master;
    var check_one;
    //数组私有属性,用存放id
    var idArray;

    //激活iCheck
    var handlerInitCheck=function () {
        //激活iCheck
        $(document).ready(function(){
            $('input[type="checkbox"].check').iCheck({
                checkboxClass: 'icheckbox_flat-blue',
            });
        });
        //获取控制端
        check_master = $('input[type=checkbox].check_master');
        //获取所有
        check_one = $('input[type=checkbox].check_one');
    };
    //全选功能
    var handlerCheckAll = function () {
        check_master.on('ifClicked',function (e) {
            //true表示未选中
            if(e.target.checked){
                check_one.iCheck("uncheck")
            }
            //否则选中
            else{
                check_one.iCheck("check")
            }
        });
    };
    return{
        init: function () {
            handlerInitCheck();
        }
    }
}();