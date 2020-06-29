function person1() {
    if($(".topMenu").find("i").attr("class") == "iconfont icon-yonghu1") {
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>个人资料');
    }
    var iframe=document.getElementById("mainIframe");
    iframe.src="/personInfo";
    return true;
}
function person2() {
    if($(".topMenu").find("i").attr("class") == "iconfont icon-yonghu1") {
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>个人资料');
    }
    var iframe=document.getElementById("mainIframe");
    iframe.src="/backpersonInfo";
    return true;
}
function updatepassword() {
    if($(".topMenu .password").text() == "修改密码") {
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>' + $(".topMenu .password").text());
    }
    var iframe=document.getElementById("mainIframe");
    iframe.src="/password";
    return true;
}

function applist() {
    if($(".menu .menuFA dt a").text()=="APP维护"){
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>' + $(".menu .menuFA dt a").text());
    }
    var iframe=document.getElementById("mainIframe");
    iframe.src="/devapp/appinfolist";
    return true;
}
function appcheck() {
    if($(".menu .menuFA dt a").text()=="APP审核"){
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>' + $(".menu .menuFA dt a").text());
    }
    var iframe=document.getElementById("mainIframe");
    iframe.src="/manager/backend/app/list";
    return true;
}

function checkApp() {
    var obj = $("#checkApp");
    var status = obj.attr("status");
    var vid = obj.attr("versionid");
    if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
        window.location.href="check?aid="+ obj.attr("appinfoid") + "&vid="+ obj.attr("versionid");
    }else if(vid != "" || vid != null){
        alert("该APP应用没有上传最新版本,不能进行审核操作！");
    }else if(status != "1"){
        alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
    }

}

function getbacklist() {
    var iframe=document.getElementById("mainIframe");
    iframe.src="/backuser/list";
    return true;
}

function userInfo() {
        var iframe=document.getElementById("mainIframe");
        iframe.src="/devapp/devuserInfo";
        return true;
}

function updatepassword1() {
    var iframe=document.getElementById("mainIframe");
    iframe.src="/password";
    return true;
}
