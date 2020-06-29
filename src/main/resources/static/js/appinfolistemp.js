$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
    var obj = $(this);
    var appinfoid = obj.attr("appinfoid");
    var saleSwitch = obj.attr("saleSwitch");
    if("open" === saleSwitch){
        saleSwitchAjax(appinfoid,obj);
    }else if("close" === saleSwitch){
        if(confirm("你确定要下架您的APP应用【"+obj.attr("appsoftwarename")+"】吗？")){
            saleSwitchAjax(appinfoid,obj);
        }
    }
});

var saleSwitchAjax = function(appId,obj){
    $.ajax({
        type:"PUT",
        url:appId+"/sale.json",
        dataType:"json",
        success:function(data){
            /*
             * resultMsg:success/failed
             * errorCode:exception000001
             * appId:appId
             * errorCode:param000001
             */
            if(data.errorCode === '0'){
                if(data.resultMsg === "success"){//操作成功
                    if("open" === obj.attr("saleSwitch")){
                        //alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
                        $("#appInfoStatus" + obj.attr("appinfoid")).html("已上架");
                        obj.className="saleSwichClose";
                        obj.html("下架");
                        obj.attr("saleSwitch","close");
                        $("#appInfoStatus" + obj.attr("appinfoid")).css({
                            'background':'green',
                            'color':'#fff',
                            'padding':'3px',
                            'border-radius':'3px'
                        });
                        $("#appInfoStatus" + obj.attr("appinfoid")).hide();
                        $("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
                    }else if("close" === obj.attr("saleSwitch")){
                        //alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
                        $("#appInfoStatus" + obj.attr("appinfoid")).html("已下架");
                        obj.className="saleSwichOpem";
                        obj.html("上架");
                        obj.attr("saleSwitch","open");
                        $("#appInfoStatus" + obj.attr("appinfoid")).css({
                            'background':'red',
                            'color':'#fff',
                            'padding':'3px',
                            'border-radius':'3px'
                        });
                        $("#appInfoStatus" + obj.attr("appinfoid")).hide();
                        $("#appInfoStatus" + obj.attr("appinfoid")).slideDown(300);
                    }
                }else if(data.resultMsg === "failed"){//删除失败
                    if("open" === obj.attr("saleSwitch")){
                        alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作失败");
                    }else if("close" === obj.attr("saleSwitch")){
                        alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作失败");
                    }
                }
            }else{
                if(data.errorCode === 'exception000001'){
                    alert("对不起，系统出现异常，请联系IT管理员");
                }else if(data.errorCode === 'param000001'){
                    alert("对不起，参数出现错误，您可能在进行非法操作");
                }
            }
        },
        error:function(data){
            if("open" === obj.attr("saleSwitch")){
                alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
            }else if("close" === obj.attr("saleSwitch")){
                alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
            }
        }
    });
};