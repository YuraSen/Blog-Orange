<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="content__wrapper">
        <div class="mb-1">Add new user</div>
        ${message?ifExists}
    </div>
    <@l.login "/registration" true />
</@c.page>
