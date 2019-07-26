/**
 * 预定会议页面的js文件
 */

$(function () {
    findAllRoom();
    findAllDept();
});

/**
 * 预定会议
 */
function subFrom() {
    var data = $("#mettingForm").serializeArray()
    $.ajax({
        url:"metting/addMetting",
        type:"post",
        data:data,
        success:function () {
            alert("添加完毕~")
        }
    })
}


/**
 * 选中user
 */
function selectedUser() {
    $("#selEmployees>option:selected").appendTo($("#selSelectedEmployees"))
}

/**
 * 根据部门获取员工信息
 */
function findUserByDeptId() {
    var val = $("#selDepartments").val();
    $.ajax({
        url:"user/findUserByDeptId/"+val,
        type:"get",
        dataType:"json",
        success:function (data) {
            $("#selEmployees").html("")
            $(data).each(function (index, ele) {
                $("#selEmployees").append("<option name='"+ele.userId+"' value=\""+ele.userId+"\">"+ele.username+"</option>")
            })
        }
    })
}

/**
 * 查询所有部门以及部门下的员工信息
 */
function findAllDept() {
    $.ajax({
        url:"dept",
        type:"get",
        dataTYpe:"json",
        success:function (data) {
            $(data).each(function (index, ele) {
                $("#selDepartments").append("<option value=\""+ele.deptId+"\">"+ele.deptName+"</option>")
            })
            findUserByDeptId();
        }
    })
}

/**
 * 展示所有会议室
 */
function findAllRoom() {
    $.ajax({
        url:"room",
        type:"get",
        dataType:"json",
        success:function (data) {
$(data).each(function (index, ele) {
        $("#rooms").append("<option value=\""+ele.roomId+"\">"+ele.roomName+"</option>")
})
        }
    })
}

$.fn.serializeJson=function(){
    var serializeObj={};
    var array=this.serializeArray();
    var str=this.serialize();
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value;
        }
    });
    return serializeObj;
};