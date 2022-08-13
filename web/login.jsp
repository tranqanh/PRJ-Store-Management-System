

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    </head>

    <body style="background-image: url(https://pdp.edu.vn/wp-content/uploads/2021/06/hinh-anh-anime-cute.jpg); background-repeat: no-repeat;background-size:cover">


    <center>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-5 col-md-3">
                    <div class="form-login">
                        <form action="MainController" method="POST">

                            <h2>Welcome</h2>
                            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="UserName" name="userID"/>

                            </br>
                            <input type="password" id="userPassword" class="form-control input-sm chat-input" placeholder="password"name="password" />

                            </br>
                            <div class="wrapper">
                                <span class="group-btn">     
                                    <input type="submit" name="action" value="Login"> 
                                    <div class="g-recaptcha" data-sitekey="6LcLSNQeAAAAAAr9cda_dSQkJarGF4PjCnlbG6DT"></div>
                                </span>
                            </div>

                        </form>
                    </div>

                </div>
            </div>
        </div>
    </center>
</body>
</html>
