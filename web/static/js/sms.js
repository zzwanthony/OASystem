$(function () {
    $(".delete").on("click", function () {
        var obj = $(this);
        if (confirm("你确定要删除该短信吗？")) {
            window.location.href = obj.attr("lir");
        }
    });
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var sender = $("#sender");
        var message = $("#message");
        if (sender.val() == null || sender.val() == '') {
            alert("请输入接收人");
        } else if (message.val() == null || message.val() == '') {
            alert("请输入信息内容");
        } else {
            $("#userForm").submit();
        }
    });
});
