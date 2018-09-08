/**
 * Created by yangxin on 2018/9/8.
 */
$(document).ready(function () {

    $(document).on("click",".ui-icon-close",function () {
        $(this).prev().val('');
    })

    $("#addThis").click(function () {
        appendContent($("#thisWeekDiv"), "thisWeek")
    })

    $("#addNext").click(function () {
        appendContent($("#nextWeekDiv"), "nextWeek")
    })

    function appendContent(obj, inputName) {
        let size = $(obj).find(".demo-block").size() + 1;

        let thisWeekTemplate = `<div class="demo-block">
                    <div class="ui-form ui-border-t">
                        <form action="#">
                            <div class="ui-form-item ui-border-b">
                                <label>
                                    ${size}
                                </label>
                                <input type="text" placeholder="" name="${inputName}"/>
                                <a href="#" class="ui-icon-close"></a>
                            </div>
                        </form>
                    </div>
                </div>`;
        $(obj).append(thisWeekTemplate);
    }

    $("#send").click(function () {
        let index = layer.load(2);
        $.post("/email/send",$("form").serialize(),function (data) {
            layer.close(index);
            if (data.success){
                layer.msg("发送成功",{time:1000},function () {
                    parent.location.reload();
                });
            }

        },'json')
    })

})
