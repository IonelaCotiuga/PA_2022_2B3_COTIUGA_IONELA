<html>
<head><title> ${title} </title>
<body>
<h1> ${title} </h1>
<p>
    ${message}
</p>
<h3>Item List</h3>

<#list list as item>
    id = '${item.id}', title = '${item.title}', location='${item.location}', type= '${item.type}',
    <#if item.year?has_content>
        year= ${item.year},
    </#if>
    <#if item.author?has_content>
        author= ${item.author}
    </#if>
    <br>
</#list>

</body>
</html>