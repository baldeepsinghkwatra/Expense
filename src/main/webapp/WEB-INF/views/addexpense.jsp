<%-- 
    Document   : register
    Created on : Mar 3, 2017, 4:50:56 PM
    Author     : baldeepsinghkwatra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
         <link rel="stylesheet" href="/expense/resources/css/main.css">
    </head>
    <body>
       <div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Add Expense</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="expense-form" action="http://phpoll.com/login/process" method="post" role="form" style="display: block;">
									
                                                                    <div> Amount:<input name="Amount" size="15" type="number" /> 
                                                                    </div><br> 
                                                                    
                                                                     <div> Description:<input name="description" size="30" type="text" />
                                                                     </div><br>
                                                                    
                                                                      <div> Category: <select>
  <option value="shopping">Shopping</option>
  <option value="travel">Travel</option>
  <option value="food">food</option>
  <option value="other">other</option>
</select>
                                                                      </div><br>
                                                                    
                                                                       <div> Date:<input name="date" type="date" /> 
                                                                       </div><br>
									
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Submit">
											</div>
										</div>
									</div>
									
									</div>
								</form>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> 
        <script src="https://code.jquery.com/jquery-2.2.2.js" integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
        crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
        <script>$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
</script>
    </body>
</html>