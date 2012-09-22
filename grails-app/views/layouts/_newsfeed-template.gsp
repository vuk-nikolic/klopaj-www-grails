<g:each var="activity" in="${activities}">
    <div class="row-fluid newsfeed-row">
        <div class="row-fluid">
            <span class="span2">
                <div class="row-fluid">
                    <g:link controller="user" action="show" id="${activity.poiId}">${activity.username}</g:link>
                </div>

                <div class="row-fluid">
                    <img src="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05366bc.jpg?s=48&d=identicon"
                         alt="${activity.username}">
                </div>
            </span>
            <span class="span10">
                <g:if test="${activity.type == 'comment'}">
                    <div class="row-fluid newsfeed-row-action">
                        <g:if test="${activity.sex == 'M'}">
                            Komentarisao
                        </g:if>
                        <g:else>
                            Komentarisala
                        </g:else>
                        restoran <g:link controller="poi" action="index"
                                         id="${activity.poiId}">${activity.poiName}</g:link>
                    </div>

                    <div class="row-fluid newsfeed-row-comment">
                        ${activity.value}
                    </div>
                </g:if>
                <g:elseif test="${activity.type == 'vote'}">
                    <span class="span10">
                        <g:if test="${activity.value == 1}">
                            Voli
                        </g:if>
                        <g:else>
                            Ne voli
                        </g:else>
                        restoran <g:link controller="poi" action="index"
                                         id="${activity.poiId}">${activity.poiName}</g:link>
                    </span>
                    <span class="span2 newsfeed-row-image">
                        <g:if test="${activity.value == 1}">
                            <img src="/img/like.png" alt="${activity.username}">
                        </g:if>
                        <g:else>
                            <img src="/img/unlike.png" alt="${activity.username}">
                        </g:else>
                    </span>
                </g:elseif>
                <g:elseif test="${activity.type == 'photo'}">
                    <span class="span10">
                        <g:if test="${activity.sex == 'M'}">
                            Poslao
                        </g:if>
                        <g:else>
                            Poslala
                        </g:else>
                        sliku za restoran <g:link controller="poi" action="index"
                                                  id="${activity.poiId}">${activity.poiName}</g:link>
                    </span>
                    <span class="span2 newsfeed-row-image">
                        <img src="/img/plus-12px.png" class="newsfeed-row-image-plus-overlay" alt="Povećaj">
                        <img src="http://www.gravatar.com/avatar/f93d4ba3c5de9f2f82074792c05466bc.jpg?s=64&d=identicon"
                             alt="${activity.username}">
                    </span>
                </g:elseif>
                <g:elseif test="${activity.type == 'poi'}">
                    <span class="span10">
                        <g:if test="${activity.sex == 'M'}">
                            Promenio
                        </g:if>
                        <g:else>
                            Promenila
                        </g:else>
                        restoran <g:link controller="poi" action="index"
                                         id="${activity.poiId}">${activity.poiName}</g:link>
                    </span>
                    <span class="span2 newsfeed-row-image">
                        <img src="/img/like.png" alt="${activity.username}">
                    </span>
                </g:elseif>
            </span>
        </div>

        <div class="row-fluid newsfeed-row-datetime">
            <prettytime:display date="${activity.datetime}"/>
        </div>
    </div>
</g:each>