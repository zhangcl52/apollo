<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<!DOCTYPE html>
<head>
    <title>游戏管理平台</title>
    <link rel="stylesheet" href="../../css/bootstrap.css"/>

    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/md5.js"></script>

    <style type="text/css">
        body {
            background: #0066A8 url(../../img/login_bg.png) no-repeat center 0px;
        }

        .tit {
            margin: auto;
            margin-top: 100px;
            text-align: center;
            width: 350px;
            padding-bottom: 20px;
        }

        .login-wrap {
            width: 220px;
            /*padding: 30px 50px 0 330px;*/
            height: 220px;
            /*background: #fff url(img/login_bg_HZ.png) no-repeat 30px 40px;*/
            margin: auto;
            overflow: hidden;
        }

        .login_input {
            display: block;
            width: 210px;
        }

        .login_user {
            background: url(../../img/input_icon_1.png) no-repeat 190px center;
            font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif
        }

        .login_password {
            background: url(../../img/input_icon_2.png) no-repeat 190px center;
            font-family: "Courier New", Courier, monospace
        }

        .btn-login {
            background: #40454B;
            box-shadow: none;
            text-shadow: none;
            color: #fff;
            border: none;
            height: 35px;
            line-height: 26px;
            font-size: 14px;
            font-family: "microsoft yahei";
        }

        .btn-login:hover {
            background: #333;
            color: #fff;
        }

        .copyright {
            margin: auto;
            margin-top: 10px;
            text-align: center;
            width: 370px;
            color: #CCC
        }

        /*@media (max-height: 700px) {*/
            /*.tit {*/
                /*margin: auto;*/
                /*margin-top: 100px;*/
            /*}*/
        /*}*/

        /*@media (max-height: 500px) {*/
            /*.tit {*/
                /*margin: auto;*/
                /*margin-top: 50px;*/
            /*}*/
        /*}*/
    </style>
</head>

<body>
<div class="tit"><img src="img/tit1.png" alt=""/></div>
<form action="" id="_form" method="post">
    <div class="login-wrap">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td height="25" valign="bottom">手机号：</td>
            </tr>
            <tr>
                <td><input name="phone" id="phone" type="text" class="login_input login_user" value=""/></td>
            </tr>
            <tr>
                <td height="35" valign="bottom">密 码：</td>
            </tr>
            <tr>
                <td><input name="password" id="password" type="password" class="login_input login_password" value=""/>
                </td>
            </tr>
            <tr>
                <td height="60" valign="bottom"><a class="btn btn-block btn-login" onclick="submitForm()">登录</a>
                </td>
            </tr>
            <tr>
                <td height="30" valign="bottom"><a style="color:red" id="messageInfo"></a>
                </td>
            </tr>
        </table>
    </div>
</form>
<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
<script>
    function submitForm() {
        var phone = $("#phone").val().trim();
        var password = $("#password").val();
        var encryptPwd=calcMD5(calcMD5(password)+phone);
        //ajax 登录
        if (validate(phone, password)) {
            $.ajax({
                url: '${path}/sys/login/ajax/login.do',
                type: 'post',
                async: false,//是否异步
                data: {
                    phone: phone,
                    password: encryptPwd
                },
                timeout: 5000,
                dataType: 'json',
                success: function (data) {
                    var code = data.code;
                    var message = data.message;
                    if (code == '2000') {
                        location.href="${path}/sys/login/login.do";
                    } else {
                        $("#messageInfo").text(message);
                    }
                }
            });
        }

    }

    function validate(phone, password) {
        if (phone == "") {
            $("#messageInfo").text("手机号不能为空");
            return false;
        }
        if (password == "") {
            $("#messageInfo").text("密码不能为空");
            return false;
        }
        return true;
    }


</script>
</html>
