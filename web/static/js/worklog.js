$(function () {
    $(".delete").on("click", function () {
        var obj = $(this);
        if (confirm("你确定要删除该日志吗？")) {
            window.location.href = obj.attr("lir");
        }
    });
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var workTime = $("#workTime");
        var title = $("#title");
        var description = $("#description");
        if (workTime.val() == null || workTime.val() == '') {
            alert("请输入时间");
        } else if (title.val() == null || title.val() == '') {
            alert("请输入标题");
        } else if (description.val() == null || description.val() == '') {
            alert("请输入内容")
        } else {
            $("#userForm").submit();
        }
    });
});
