/**
 * 会议详情页面的js文件
 */
$(function () {
    findMettingInfo();
});

function findMettingInfo() {
    var mettingId = location.search.split("?")[1].split("=")[1];
    $.ajax({
        url:"metting/getMttingById/"+mettingId,
        type:"get",
        dataType:"json",
        success:function (data) {
            var userList = "";
            $(data.metting.userList).each(function (index,ele) {
               userList+="<tr>\n" +
                   "                                            <td>"+ele.username+"</td>\n" +
                   "                                            <td>"+ele.phone+"</td>\n" +
                   "                                            <td>j"+ele.email+"</td>\n" +
                   "                                        </tr>"
            });
            $("#metting-info").append(" <tr>\n" +
                "                                <td>会议名称：</td>\n" +
                "                                <td>"+data.metting.mettingName+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>预计参加人数：</td>\n" +
                "                                <td>"+data.metting.mettingSize+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>预计开始时间：</td>\n" +
                "                                <td>"+data.startTime+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>预计结束时间：</td>\n" +
                "                                <td>"+data.endTime+"\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>会议说明：</td>\n" +
                "                                <td>\n" +
                "                                    <textarea id=\"description\" rows=\"5\" readonly>"+data.metting.remark+"</textarea>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td>参会人员：</td>\n" +
                "                                <td>\n" +
                "                                    <table class=\"listtable\">\n" +
                "                                        "+userList+
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td class=\"command\" colspan=\"2\">\n" +
                "                                    <input type=\"button\" class=\"clickbutton\" value=\"返回\" onclick=\"window.history.back();\"/>\n" +
                "                                </td>\n" +
                "                            </tr>")
        }
    })
}
