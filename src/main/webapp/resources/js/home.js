

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
    location.reload();
}

function createAuthorizationTokenHeader() {
    var token = getJwtToken();
    if (token) {
        return {"Authorization": token};
    } else {
        return {};
    }
}

// REGISTER EVENT LISTENERS =============================================================

$("#logoutButton").click(doLogout);

function viewExpense() {
    $.ajax({
        url: "app/expenditure",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        headers: createAuthorizationTokenHeader(),
        success: function (data) {
            if (data.length > 0) {
                $('#table').remove();
                $("#view-expense").empty();
                var tbl = $("<table/>").attr({"id": "table", "class": "table table-striped"});
                $("#view-expense").append(tbl);
                var th = "<thead><tr><th>Amount</th><th>Date</th><th>Category</th><th>Description</th></tr></thead>";
                $("#table").append(th);
                var i;
                for (i = 0; i < data.length; i++)
                {
                    var tr = "<tr>";
                    var td1 = "<td>" + data[i]["amount"] + "</td>";
                    var td2 = "<td>" + data[i]["expenseDate"] + "</td>";
                    var td3 = "<td>" + data[i]["category"] + "</td>";
                    var td4 = "<td>" + data[i]["description"] + "</td>";
                    $("#table").append(tr + td1 + td2 + td3 + td4);
                }

            } else {
                $("#view-expense").empty();
                $("#view-expense").append("No record found.");
            }
        }
    });
}


function expense(loginData) {
    $.ajax({
        url: "app/expenditure",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(loginData),
        headers: createAuthorizationTokenHeader(),
        success: function (data) {
            $('#showModal')
                    .modal("show")
                    .find(".modal-body")
                    .empty()
                    .html("<p>" + data + "</p>");
            $("#expense-form").trigger('reset');
        }
    });
}

$("#expense-form").submit(function (event) {
    event.preventDefault();

    var $form = $(this);
    var formData = {
        amount: $form.find('input[name="amount"]').val(),
        description: $form.find('input[name="description"]').val(),
        category: $form.find('select[name="category"]').val(),
        expenseDateForm: $form.find('input[name="expenseDate"]').val(),
        confirmPassword: $form.find('input[name="confirmPassword"]').val()
    };
    expense(formData);
});

//$("view-expense").hide();
$('#add-expense-link').click(function (e) {
    $("#expense-form").delay(100).fadeIn(100);
    $("#view-expense").fadeOut(100);
    $('#view-expense-link').removeClass('active');
    $(this).addClass('active');
    e.preventDefault();
});
$('#view-expense-link').click(function (e) {
    $("#view-expense").delay(100).fadeIn(100);
    $("#expense-form").fadeOut(100);
    $('#add-expense-link').removeClass('active');
    $(this).addClass('active');
    viewExpense();
    e.preventDefault();
});