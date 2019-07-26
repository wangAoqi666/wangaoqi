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

function loadname() {
    $.ajax({
        url:"/user/searchName",
        type:"GET",
        statusCode:{
            200:function (data) {
                // alert("yes login")
                var html = "欢迎您，<strong>"+data+"</strong>\n" +
                    "<a href=\"#\">[修改密码]</a>";
                $(".header-quicklink").html(html);
            },
            204:function (data) {
                // alert("no login")
                var html = "<a href='/login.html'>[登录]</a>" +
                    "<a href=\"#\">[修改密码]</a>";
                $(".header-quicklink").html(html);
            }
        }
    })
 }
 window.onload = loadname();