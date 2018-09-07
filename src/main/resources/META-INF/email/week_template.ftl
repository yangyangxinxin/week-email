<html>
    <head></head>
    <body>
        <div>
            <h2>本周工作(${thisWeekDate!})</h2>
            <#list thisWeek as t>
                <ul>
                    <li>${t!}</li>
                </ul>
            </#list>
            <h2>下周工作</h2>
            <#list nextWeek as n>
                <ul>
                    <li>${n!}</li>
                </ul>
            </#list>
        </div>
    </body>
</html>