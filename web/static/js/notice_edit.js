$(function () {
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var title = $("#title");
        var content = $("#content");
        if (title.val() == null || title.val() == '') {
            alert("请输入公告标题");
        } else if (content.val() == null || content.val() == '') {
            alert("请输入公告内容");
        } else {
            $("#userForm").submit();
        }
    });
});
