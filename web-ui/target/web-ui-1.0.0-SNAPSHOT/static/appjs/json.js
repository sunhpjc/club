var MyJson = function () {
    //职位
    var possition = ["社长","副社长","宣传部长","财务部长","外联部长","组织部长"];
    //学院
    var college = [{"college":"石油与天然气工程学院","major":["石油工程","油气储运工程","海洋油气工程"]},{"college":"地球科学与技术学院","major":["资源勘查工程","勘查技术与工程","地质学","地理信息科学","城市地下空间工程"]}];
    return{
        possition,
        college
    }
}();
$(document).ready(function () {
    return MyJson.possition;
    return MyJson.college;
});