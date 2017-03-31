<%-- 
    Document   : passwordchange
    Created on : Mar 20, 2017, 12:07:46 PM
    Author     : bala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Password Change</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
        <script type="text/javascript">
            function check()
            {
                var x = document.getElementById("newpassword").value;
                var y = document.getElementById("confirmpassword").value;


                if (x !== y)
                {
                    window.alert("Current password is not Equal");
                    return false;
                }
                return true;
            }
            function changeStatus()
            {
                var x = document.getElementById("changestatus").value;
                if (x == "A")
                {
                    document.getElementById("changestatus").value = "";
                    alert("Password Changed");
                    window.location.href = "admindash.html";
                } else if (x == "S")
                {
                    document.getElementById("changestatus").value= "";
                    alert("Password Changed");
                    window.location.href = "salesmandash.html";
                } else if (x == "M")
                {
                    document.getElementById("changestatus").value = "";
                    alert("Password Changed");
                    window.location.href = "managerdash.html";
                } else if (x == "R")
                {
                    document.getElementById("changestatus").value = "";
                    alert("Password Changed");
                    window.location.href = "retailerdash.html";
                }

            }
        </script>

    </head>
    <body class="templatemo-bg-gray" onload="changeStatus()">
        <div class="container">
            <div class="col-md-12">
                <h1 class="margin-bottom-15">Password Change</h1>
                <form class="form-horizontal templatemo-forgot-password-form templatemo-container" role="form" action="LoginServlet" method="post">	

                    <div class="form-group">
                        <div class="col-md-12">
                            New Password
                        </div>
                    </div>		
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="Password" class="form-control" id="newpassword" name="new_password" placeholder="New Password" required>	            
                        </div>              
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            Confirm Password
                        </div>
                    </div>		
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="Password" class="form-control" id="confirmpassword" name="confirm_password" placeholder="Confirm Password"  required>	            
                        </div>              
                    </div>
                    <% if (request.getAttribute("changeStatus") != null) {%>
                    <input type="hidden" name="change_status" id="changestatus" value="<%=(String) request.getAttribute("changeStatus")%>">
                    <% request.setAttribute("changeStatus", null);
                    } else {%>
                    <input type="hidden" name="change_status" id="changestatus" >
                    <%}%>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Submit" name="operation" class="btn btn-danger" onclick="return check()" >
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
