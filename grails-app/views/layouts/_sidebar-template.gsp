<div class="well">
    <div class="row-fluid sidebar-header">
        Omiljeni restorani
    </div>
    <g:each var="highRatedPoi" in="${highestRatedPois}">
        <g:render template="/layouts/sidebar-row-template" model="['poi': highRatedPoi[0]]"/>
    </g:each>

    <div class="row-fluid sidebar-header">
        Izdvajamo...
    </div>
    <g:each var="featuredPoi" in="${featuredPois}">
        <g:render template="/layouts/sidebar-row-template" model="['poi': featuredPoi]"/>
    </g:each>
</div>