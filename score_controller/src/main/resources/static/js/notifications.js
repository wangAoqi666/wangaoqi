/**
 展示未来7天会议的页面 的js文件
 */

$(function () {
    get7day();
});

/**
 * 查询7天后的会议
 */
function get7day() {

    $.ajax({
        url:"/user/getLoginUserId",
        type:"get",
        dataType:"json",
        success:function (data) {
            $.ajax({
                url:"/metting/findMettingByDate/"+data.userId,
                type:"get",
                dataType:"json",
                success:function (data) {
                    $(data).each(function (index, ele) {
                        $("#huiyi-list").append("<tr>\n" +
                            "                        <td>"+ele.metting.mettingName+"</td>\n" +
                            "                        <td>"+ele.metting.room.roomName+"</td>\n" +
                            "                        <td>"+ele.startTime+"</td>\n" +
                            "                        <td>"+ele.endTime+"</td>\n" +
                            "                        <td>\n" +
                            "                            <a class=\"clickbutton\" href=\"meetingdetails.html?mettingId="+ele.metting.mettingId+"\">查看详情</a>\n" +
                            "                        </td>\n" +
                            "                    </tr>")
                    });
                }
            })
        }
    })

}