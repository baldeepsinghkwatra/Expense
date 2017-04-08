
$(function () {
    // VARIABLES =============================================================
    var TOKEN_KEY = "jwtToken"
    var $notLoggedIn = $("#notLoggedIn");
    var $loggedIn = $("#loggedIn").hide();
    var $response = $("#response");
    var $login = $("#login");
    var $userInfo = $("#userInfo").hide();

    // FUNCTIONS =============================================================
    function getJwtToken() {
        return localStorage.getItem(TOKEN_KEY);
    }

    function setJwtToken(token) {
        localStorage.setItem(TOKEN_KEY, token);
    }

    function removeJwtToken() {
        localStorage.removeItem(TOKEN_KEY);
    }

    function doLogout() {
        removeJwtToken();
        $login.show();
        $userInfo
                .hide()
                .find("#userInfoBody").empty();
        $loggedIn
                .hide()
                .attr("title", "")
                .empty();
        $notLoggedIn.show();
    }

    function createAuthorizationTokenHeader() {
        var token = getJwtToken();
        if (token) {
            return {"Authorization": token};
        } else {
            return {};
        }
    }

    function showUserInformation() {
        $.ajax({
            url: "user",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                var $userInfoBody = $userInfo.find("#userInfoBody");

                $userInfoBody.append($("<div>").text("Username: " + data.username));
                $userInfoBody.append($("<div>").text("Email: " + data.email));

                var $authorityList = $("<ul>");
                data.authorities.forEach(function (authorityItem) {
                    $authorityList.append($("<li>").text(authorityItem.authority));
                });
                var $authorities = $("<div>").text("Authorities:");
                $authorities.append($authorityList);

                $userInfoBody.append($authorities);
                $userInfo.show();
            }
        });
    }

    function showTokenInformation() {
        $loggedIn
                .text("Token: " + getJwtToken())
                .attr("title", "Token: " + getJwtToken())
                .show();
    }

    function showResponse(statusCode, message) {
        $response
                .empty()
                .text("status code: " + statusCode + "\n-------------------------\n" + message);
    }

    // REGISTER EVENT LISTENERS =============================================================

    $("#logoutButton").click(doLogout);

    $("#exampleServiceBtn").click(function () {
        $.ajax({
            url: "persons",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, JSON.stringify(data));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });

    $("#adminServiceBtn").click(function () {
        $.ajax({
            url: "protected",
            type: "GET",
            contentType: "application/json; charset=utf-8",
            headers: createAuthorizationTokenHeader(),
            success: function (data, textStatus, jqXHR) {
                showResponse(jqXHR.status, data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                showResponse(jqXHR.status, errorThrown);
            }
        });
    });

    $loggedIn.click(function () {
        $loggedIn
                .toggleClass("text-hidden")
                .toggleClass("text-shown");
    });

    // INITIAL CALLS =============================================================
    if (getJwtToken()) {
//        $login.hide();
//        $notLoggedIn.hide();
//        showTokenInformation();
//        showUserInformation();
 $.ajax({
                    url: "app/homepage",
                    type: "GET",
                    contentType: "application/json; charset=utf-8",
                    headers: createAuthorizationTokenHeader(),
                success:function(data){
                    $('body').html(data);
                }});
    }

    function doLogin(loginData) {
        $.ajax({
            url: "auth",
            type: "POST",
            data: JSON.stringify(loginData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                setJwtToken(data.token);

                $.ajax({
                    url: "app/homepage",
                    type: "GET",
                    contentType: "application/json; charset=utf-8",
                    headers: createAuthorizationTokenHeader(),
                success:function(data){
                    $('body').html(data);
                }});
                    
            },
            error: function (jqXHR, textStatus, errorThrown) {
                if (jqXHR.status === 401) {
                    $('#loginErrorModal')
                            .modal("show")
                            .find(".modal-body")
                            .empty()
                            .html("<p>Spring exception:<br>" + jqXHR.responseJSON.exception + "</p>");
                } else {
                    $('#showModal')
                            .modal("show")
                            .find(".modal-body")
                            .empty()
                            .html("<p>Invalid Credentials</p>");
                    $("#login-form").trigger('reset');
                }
            }
        });
    }

    function register(loginData) {
        $.ajax({
            url: "register",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(loginData),
            success: function (data) {
                $('#showModal')
                        .modal("show")
                        .find(".modal-body")
                        .empty()
                        .html("<p>" + data + "</p>");
                $("#register-form").trigger('reset');
            }
        });
    }


    $("#login-form").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            username: $form.find('input[name="username"]').val(),
            password: $form.find('input[name="password"]').val()
        };

        doLogin(formData);
    });

    $("#register-form").submit(function (event) {
        event.preventDefault();

        var $form = $(this);
        var formData = {
            firstname: $form.find('input[name="firstname"]').val(),
            lastname: $form.find('input[name="lastname"]').val(),
            email: $form.find('input[name="email"]').val(),
            password: $form.find('input[name="password"]').val(),
            confirmPassword: $form.find('input[name="confirmPassword"]').val()
        };

        register(formData);
    });
});