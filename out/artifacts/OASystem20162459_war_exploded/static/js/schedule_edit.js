$(function () {
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var scheduleTime = $("#scheduleTime");
        var plan = $("#plan");
        if (scheduleTime.val() == null || scheduleTime.val() == '') {
            alert("请输入日程时间");
        } else if (plan == null || plan == '') {
            alert("请输入手日程安排");
        } else {
            $("#userForm").submit();
        }
    });
});
