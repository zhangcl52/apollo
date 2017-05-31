<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="../sys/common/common.jsp" %>
    <title>管理平台</title>
    <link rel="stylesheet" href="${path}/css/css.css"/>
    <script type="text/javascript" src="${path}/js/sdmenu.js"></script>

</head>

<body>
<!--顶部开始-->
<div class="header">
    <%--<div class="logo"><img src="/img/logo.png"/></div>--%>
    <div class="logo"><img src=""/></div>
    <div class="header-right">
        <i class="icon-off icon-white"></i>
        <a id="modal-973557" href="#modal-container-973558" role="button" data-toggle="modal" style="font-size: 16px">欢迎 ${user.userAccount}</a>
        <i class="icon-off icon-white"></i>
        <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal" style="font-size: 16px">注销</a>
        <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">
                    注销系统
                </h3>
            </div>
            <div class="modal-body">
                <p>
                    您确定要注销退出系统吗？
                </p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                <a class="btn btn-primary" style="line-height:20px;" href="登录.html">确定退出</a>
            </div>
        </div>
    </div>
</div>
<!-- 顶部结束 -->
<!--中部开始(包括左侧导航和右侧内容)-->
<div id="middle">
    <%--左侧导航--%>
    <div class="left">
        <script type="text/javascript">
            var myMenu;
            window.onload = function () {
                myMenu = new SDMenu("my_menu");
                myMenu.init();
            };
        </script>

        <div id="my_menu" class="sdmenu">
            <div>
                <span>用户管理</span>
                <a href="#" dateUrl="${path}/sys/user/list.do" id="menu_1_1" onclick="getPage('menu_1_1')">用户管理</a>
            </div>
            <div>
                <span>房间管理</span>
                <a href="#" dateUrl="${path}/sys/room/normal/list.do" id="menu_2_1" onclick="getPage('menu_2_1')">普通房间管理</a>
            </div>
        </div>
    </div>
    <div class="Switch"></div>
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".Switch").click(function () {
                $(".left").toggle();

            });
        });
    </script>
    <%--右侧内容--%>
    <div class="right" id="mainFrame">
        <div class="right_cont">
            <iframe src="${path}/sys/login/getHomePage.do" marginheight="0" marginwidth="0" frameborder="0"
                    width="100%" height="100%"
                    id="iframepage" name="iframepage" onLoad="iFrameHeight()">
            </iframe>


        </div>
    </div>
</div>
<!--中部结束(包括左侧导航和右侧内容)-->

<!-- 底部 -->
<div id="footer">版权所有：晶科客流 &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
</div>


<script>
    !function () {
        laydate.skin('molv');
        laydate({elem: '#Calendar'});
    }();
    function iFrameHeight() {
        var ifm = document.getElementById("iframepage");
        var subWeb = document.frames ? document.frames["iframepage"].document :
                ifm.contentDocument;
        if (ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
        }
    }
    function getPage(menuId) {
        var _menu = $("#" + menuId);
        $("a").each(function () {
            $(this).removeAttr("class");
        });
        _menu.attr("class", "current");
        var pageUrl = _menu.attr("dateUrl");
        var ifm = $("#iframepage");
        ifm.attr("src", pageUrl);

    }
    //将菜单折叠起来(还需要调试)
    //    $(document).ready(function () {
    //        var myMenuDiv=$("#my_menu");
    //        var childDiv=myMenuDiv.children("div");
    //        childDiv.each(function () {
    //            $(this).attr("class","collapsed");
    //        });
    //
    //    });
</script>
</body>
</html>
