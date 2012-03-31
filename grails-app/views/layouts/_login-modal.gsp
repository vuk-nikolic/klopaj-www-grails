<div id="login-modal" class="modal fade" style="display: none; ">
    <form name="login" action="/j_spring_security_check" method='POST'>
        <fieldset>
            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>

                <h3>Prijavi se</h3>
            </div>

            <div class="modal-body">
                <div class="clearfix">
                    <label for="j_username">Nadimak:</label>

                    <div class="input">
                        <g:textField name="j_username" class="xlarge"/>
                    </div>
                </div>

                <div class="clearfix">
                    <label for="j_password">Šifra:</label>

                    <div class="input">
                        <g:passwordField name="j_password" class="xlarge"/>
                    </div>
                </div>

                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary" value='${message(code: "springSecurity.login.button")}' />
                </div>
        </fieldset>
    </form>
</div>

