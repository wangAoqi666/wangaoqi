/**
 * 我的会议页面 js文件
 */

$(function () {
    findMettingByUserId();
});


function findMettingByUserId() {
    $.ajax({
        url:"metting",
        type:"get",
        success:function (data) {
            $(data).each(function (index, ele) {
                $("#metting-list").append("<tr>\n" +
                    "                       <td>"+ele.metting.mettingName+"</td>\n" +
                    "                       <td>"+ele.metting.room.roomName+"</td>\n" +
                    "                       <td>"+ele.startTime+"</td>\n" +
                    "                       <td>"+ele.endTime+"</td>\n" +
                    "                       <td>"+ele.createTime+"</td>\n" +
                    "                       <td>"+ele.metting.status+"</td>\n" +
                    "                       <td>\n" +
                    "                           <a class=\"clickbutton\" href=\"meetingdetails.html?mettingId="+ele.metting.mettingId+"\">查看详情</a>\n" +
                    "                       </td>\n" +
                    "                   </tr>")
            })

        }
    })
}