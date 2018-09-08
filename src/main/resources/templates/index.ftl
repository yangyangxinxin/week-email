
<#--http://frozenui.github.io-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <title>发送周报</title>
    <!-- 引入 FrozenUI -->
    <link rel="stylesheet" href="http://i.gtimg.cn/vipstyle/frozenui/2.0.0/css/frozen.css"/>
    <link rel="stylesheet" href="/css/index.css"/>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="/layer/layer.js"></script>
    <script src="/index.js"></script>

</head>
<body>
<body ontouchstart>
<header class="ui-header ui-header-positive ui-border-b">
    <i class="ui-icon-return" onclick="history.back()"></i><h1>发送周报</h1><button class="ui-btn" id="send">发送</button>
</header>
<form>
<section class="ui-container">

    <section id="form">
        <div class="demo-item">
            <p class="demo-desc">本周工作</p>
            <div id="thisWeekDiv">
                <div class="demo-block">
                    <div class="ui-form ui-border-t">
                        <form action="#">
                            <div class="ui-form-item ui-border-b">
                                <label>
                                    1
                                </label>
                                <input type="text" placeholder="" name="thisWeek"/>
                                <a href="#" class="ui-icon-close"></a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="demo">
            <button class="ui-btn-lg-nowhole" id="addThis" type="button">添加</button>
        </div>
        <div class="demo-item">

            <div class="demo-item">
                <p class="demo-desc">下周工作</p>
                <div id="nextWeekDiv">
                    <div class="demo-block">
                        <div class="ui-form ui-border-t">
                            <form action="#">
                                <div class="ui-form-item ui-border-b">
                                    <label>
                                        1
                                    </label>
                                    <input type="text" placeholder="" name="nextWeek"/>
                                    <a href="#" class="ui-icon-close"></a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="demo">
            <button class="ui-btn-lg-nowhole" id="addNext" type="button">添加</button>
        </div>
    </section>
</section>
</form>
</body>
</html>