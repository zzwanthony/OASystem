$(function () {
    $(".delete").on("click", function () {
        var obj = $(this);
        if (confirm("你确定要删除该联系人吗？")) {
            window.location.href = obj.attr("lir");
        }
    });
    $("#back").on("click",function(){
        history.back(-1);
    });
    $("#add").on("click", function () {
        var name = $("#name");
        var mobile = $("#mobile");
        var email = $("#email");
        var qq = $("#qq");
        var company = $("#company");
        var address = $("#address");
        var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
        if ( name.val() == "" || name.val() == null) {
            alert("请输入名字");
        } else if (mobile.val() == null || name.val() == '') {
            alert("请输入手机号");
        } else if(!mobile.val().match(patrn)){
            alert("您输入的手机号格式不正确")
        } else if (email.val() == null || email.val() == '') {
            alert("请输入邮箱")
        } else if (qq.val() == null || qq.val() == '') {
            alert("请输入qq")
        } else if (company.val() == null || company.val() == '') {
            alert("请输入工作单位")
        } else if (address.val() == null || address.val() == '') {
            alert("请输入地址")
        } else {
            $("#userForm").submit();
        }
    });
});
/*
function toDelete(url) {
    if (confirm("你确定要删除该联系人吗？")) {
        window.location.href = url;
    }
}*/
