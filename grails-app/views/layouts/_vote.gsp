<span id="voteContainer">
    <g:remoteLink mapping="poiVote"
                  id="${poiId}"
                  params="[value: '1']"
                  update="voteContainer">

        <g:if test="${vote?.voteValue?.voteValueId == 1}">
            <span class="span4 like-active">
                <img src="/img/like.png" alt="like"/>
            </span>
        </g:if>
        <g:else>
            <span class="span4 like-inactive">
                <img src="/img/like.png" alt="like"/>
            </span>
        </g:else>
        <span class="span2 like-text">${ratePlus}</span>
    </g:remoteLink>
    <g:remoteLink mapping="poiVote"
                  id="${poiId}"
                  params="[value: '-1']"
                  update="voteContainer">
        <g:if test="${vote?.voteValue?.voteValueId == -1}">
            <span class="span4 unlike-active">
                <img src="/img/unlike.png" alt="like"/>
            </span>
        </g:if>
        <g:else>
            <span class="span4 unlike-inactive">
                <img src="/img/unlike.png" alt="unlike"/>
            </span>
        </g:else>
        <span class="span2 like-text">${rateMinus}</span>
    </g:remoteLink>
</span>