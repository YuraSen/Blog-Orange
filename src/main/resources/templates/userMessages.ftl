<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <div class="content__wrapper">
        <h3>${userChannel.username}</h3>
        <#if !isCurrentUser>
            <#if isSubscriber>
                <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Unsubscribe</a>
            <#else>
                <a class="btn btn-info" href="/user/subscribe/${userChannel.id}">Subscribe</a>
            </#if>
        </#if>
    </div>
    <div class="my-3" style="margin-top: 20px">
        <div class="content__wrapper">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">Subscriptions</div>
                            <h3 class="card-text">
                                <a href="/user/subscriptions/${userChannel.id}/list">${subscriptionsCount}</a>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">Subscribers</div>
                            <h3 class="card-text">
                                <a href="/user/subscribers/${userChannel.id}/list">${subscribersCount}</a>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#if isCurrentUser || isAdmin>
        <#include "parts/messageEdit.ftl" />
    </#if>

    <#include "parts/messageList.ftl" />
</@c.page>
