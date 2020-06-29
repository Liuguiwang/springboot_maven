$(function(){
        $name = $('#username[name="username"]')
        $name.blur(function(){
            // alert($name.val())
            $.get("reg.jhtml", {username:$name.val()}, function(data, status){
                // alert(data)
                $('#message').html(data)
            })
        });
        $name.focus(function () {
            $("#message").html("")
        });
    });
$(function () {
    $repwd=$("#repassword[name='repassword']");
    $repwd.blur(function () {
        if($("#password").val()!=$("#repassword").val()){
            $("#message1").html("两次密码不匹配");
        }else {
            $("#message1").html("");
        }
    })
});
