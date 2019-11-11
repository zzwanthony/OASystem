$(function () {
    $(".delete").on("click", function () {
        var obj = $(this);
        if (confirm("你确定要删除该日程安排吗？")) {
            window.location.href = obj.attr("lir");
        }
    });
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var scheduleTime = $("#scheduleTime");
        var plan = $("#plan");
        if (scheduleTime.val() == null || scheduleTime.val() == '') {
            alert("请输入日程完整时间");
        } else if (plan.val() == null || plan.val() == '') {
            alert("请输入手日程安排");
        } else {
            $("#userForm").submit();
        }
    });
});
