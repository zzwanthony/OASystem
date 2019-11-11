$(function () {
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var starttime = $("#starttime");
        var endtime = $("#endtime");
        var address = $("#address");
        var title = $("#title");
        var content = $("#content");
        if (starttime.val() == null || starttime.val() == '') {
            alert("请输入会议开始时间");
        } else if (endtime.val() == null || endtime.val() == '') {
            alert("请输入会议结束时间");
        } else if (address.val() == null || address.val() == '') {
            alert("输入会议地点")
        } else if (title.val() == null || title.val() == '') {
            alert("输入标题")
        } else if (content.val() == null || content.val() == '') {
            alert("输入会议内容")
        } else {
            $("#userForm").submit();
        }
    });
});
