<%-- 
    Document   : home
    Created on : Apr 9, 2017, 8:12:18 AM
    Author     : baldeepsinghkwatra
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <link rel="stylesheet" href="/expense/resources/css/main.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
    </head>
    <body>
         <input style=" position:absolute;
   top:0;
   right:0;" type="button" id="logoutButton" class="btn btn-login" value="Logout">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="add-expense-link">Add Expense</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="view-expense-link">View Expense</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="expense-form" method="post" role="form" style="display: block">
                                        <div> <label>Amount:</label><input placeholder="Write your Amount here" class="form-control" name="amount" size="15" type="number" /> 
                                        </div><br> 
                                        <div> <label>Description:</label><input placeholder="Description about expense" class="form-control" name="description" size="30" type="text" />
                                        </div><br>
                                        <div><label> Category:</label> <select name="category" class="form-control">
                                                <option value="Shopping">Shopping</option>
                                                <option value="Travel">Travel</option>
                                                <option value="Food">food</option>
                                                <option value="Other">other</option>
                                            </select>
                                        </div><br>
                                        <div><label>Expense Date:</label><input class="form-control" name="expenseDate" type="date" /> 
                                        </div><br>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Submit">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div style="" id="view-expense">
                                    <table id="table"></table>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" tabindex="-1" role="dialog" id="showModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <script src="https://code.jquery.com/jquery-2.2.2.js" integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
        crossorigin="anonymous"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>  
        <script src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
        <script src="resources/js/home.js"></script>
    </body>
</html>
