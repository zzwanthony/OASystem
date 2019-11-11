$(function () {

    var mimaXG = $("#mimaXG");
    var remove = $("#removeBi");
    var zhezhao = $(".zhezhao");

    var userPWD = $("#userPWD");

    var oldPassword = $("#oldPassword");
    var newPassword = $("#newPassword");
    var newPassword2 = $("#newPassword2");

    var yes = $("#yes");
    var no = $("#no");
    var massage = yes.prev();

    mimaXG.click(function () {
        remove.css("display", "block");
        zhezhao.css("display", "block");
    });
    no.click(function () {
        remove.css("display", "none");
        zhezhao.css("display", "none");
        oldPassword.val("");
        newPassword.val("");
        newPassword2.val("");
    })
    yes.on("click", function () {
        if (oldPassword.val() == '') {
            massage.html("请输入原密码");
        } else if (newPassword.val() == '' || newPassword2.val() == '') {
            massage.html("请输入新密码");
        } else if (newPassword.val().length < 6) {
            massage.html("密码长度不能少于6位")
        } else if (newPassword.val() != newPassword2.val()) {
            massage.html("两次输入的密码不同")
        } else if (userPWD.val() != $.md5(oldPassword.val())) {
            massage.html("原密码输入错误！")
        } else {
            window.location.href = "/UserLogin/passwordModify.action?userPassword=" + oldPassword.val() + "&newPassword=" + newPassword.val();
        }
    })
})