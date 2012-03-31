<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="${createLink(uri: '/')}">klopaj!</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li><a data-toggle="modal" href="#login-modal">Prijavi se</a></li>
                    <li><a data-toggle="modal" href="#register-modal">Registruj se</a></li>
                </ul>

                <g:formRemote url="[controller: 'search', action:'index']" update="searchResult" class="navbar-search pull-right" action="/search" name="search">
                    <input name="query" type="text" class="search-query span3" placeholder="Search" />
                </g:formRemote >
            </div><!-- /.nav-collapse -->
        </div>
    </div><!-- /navbar-inner -->
</div>
