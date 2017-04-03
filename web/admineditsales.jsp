<%-- 
    Document   : admineditsales
    Created on : Apr 1, 2017, 2:16:38 PM
    Author     : bala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bio Mart</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor1.css">
        <!-- Theme initialization -->
        <script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
                    {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            } else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
        <script>
            var req;
            function checkStatus()
            {
                var x = document.getElementById("status").value;
                if (x != "")
                {
                    document.getElementById("status").value = "";
                    window.alert(x);
                }
            }
            function get()
            {
                if (window.XMLHttpRequest) {
                    return  new XMLHttpRequest( );
                } else if (window.ActiveXObject)
                {
                    return new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            function namelist()
            {
                checkStatus();
                req = get();
                var url = "AdminSalesmanServlet?operation=" + "namelist";
                req.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("snameid").innerHTML =
                                this.responseText;
                    }
                };
                req.open("POST", url, true);
                req.send(null);
            }
            function getDetails(userName)
            {

                req = get();
                var url = "AdminSalesmanServlet?operation=getDetails&&userName=" + userName;
                req.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {

                        var details = this.responseText.split(",");
                        if (details.length > 1) {
                            document.getElementById("userid").value = details[0];
                            document.getElementById("mobileno").value = details[2];
                            document.getElementById("email").value = details[3];
                            document.getElementById("doorno").value = details[5];
                            document.getElementById("streetname").value = details[6];
                            document.getElementById("city").value = details[7];
                            document.getElementById("district").value = details[8];
                            document.getElementById("state").value = details[9];
                            document.getElementById("pincode").value = details[10];
                        } else
                        {
                            document.getElementById("userid").value = "";
                            document.getElementById("mobileno").value = "";
                            document.getElementById("email").value = "";
                            document.getElementById("doorno").value = "";
                            document.getElementById("streetname").value = "";
                            document.getElementById("city").value = "";
                            document.getElementById("district").value = "";
                            document.getElementById("state").value = "";
                            document.getElementById("pincode").value = "";
                        }
                    }
                };
                req.open("POST", url, true);
                req.send(null);

            }

        </script>
    </head>

    <body onload="namelist()">
        <div class="main-wrapper">
            <div class="app" id="app">
                <header class="header">
                    <div class="header-block header-block-collapse hidden-lg-up"> <button class="collapse-btn" id="sidebar-collapse-btn">
                            <i class="fa fa-bars"></i>
                        </button> </div>

                    <div class="header-block header-block-nav">
                        <ul class="nav-profile">

                            <li class="profile dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <span class="name">
                                        Admin
                                    </span> </a>
                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <form action="LoginServlet" method="post" id="f1">                            
                                        <a class="dropdown-item" href="passwordchange.jsp"> <i class="fa fa-gear icon"></i>  Change Password </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('f1').submit();">  <i class="fa fa-power-off icon"></i> Logout </a>
                                        <input type="hidden" name="operation" value="logout" >
                                        </div></form>
                            </li>
                        </ul>
                    </div>
                </header>
                <aside class="sidebar">
                    <div class="sidebar-container">
                        <div class="sidebar-header">
                            <div class="brand">
                                <div class="logo"> <span class="l l1"></span> <span class="l l2"></span> <span class="l l3"></span> <span class="l l4"></span> <span class="l l5"></span> </div> Bio Mart </div>
                        </div>
                        <nav class="menu">
                            <ul class="nav metismenu" id="sidebar-menu">
                                <li>
                                    <a href="table.html"> <i class="fa fa-home"></i>Payment Status</a>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-th-large"></i> Items Manager <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="adminadditem.html">
                                                Add item
                                            </a> </li>
                                        <li> <a href="adminedititem.html">
                                                Edit item
                                            </a> </li>
                                        <li> <a href="admindeleteitem.jsp">
                                                Delete Item
                                            </a> </li>
                                    </ul>
                                </li>
                                <li class="active open">
                                    <a href=""> <i class="fa fa-pencil-square-o"></i> Salesman<i class="fa arrow"></i> </a>
                                    <ul><li > <a href="adminaddsales.jsp">
                                                Add Salesman
                                            </a> </li>
                                        <li class="active"> <a href="admineditsales.jsp">
                                                Edit Salesman Details
                                            </a> </li>
                                        <li > <a href="admindeletesales.jsp">
                                                Remove Salesman
                                            </a> </li></ul>
                                </li>
                                <li >
                                    <a href=""> <i class="fa fa-user"></i> Retailer<i class="fa arrow"></i> </a>
                                    <ul><li > <a href="adminaddret.jsp">
                                                Add Retailer
                                            </a> </li>
                                        <li > <a href="admineditret.jsp">
                                                Edit Retailer Details
                                            </a> </li>
                                        <li > <a href="adminrefer.html">
                                                Referred Details
                                            </a> </li>
                                        <li > <a href="admindeleteret.html">
                                                Remove Retailer
                                            </a> </li></ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-th-large"></i>Orders<i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="adminorderconfirm.html">
                                                Order Confirmation
                                            </a> </li>
                                        <li> <a href="adminorderpending.html">
                                                Pending Order
                                            </a> </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-envelope"></i> Cheque Status <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="adminchequestatus.html">
                                                Status Update
                                            </a> </li>
                                        <li> <a href="chequetransaction.html">
                                                Transaction
                                            </a> </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <footer class="sidebar-footer">
                        <ul class="nav metismenu" id="customize-menu">
                            <li>
                                <ul>
                                    <li class="customize">

                                        <div class="customize-item">
                                            <ul class="customize-colors">
                                                <li> <span class="color-item color-red" data-theme="red"></span> </li>
                                                <li> <span class="color-item color-orange" data-theme="orange"></span> </li>
                                                <li> <span class="color-item color-green active" data-theme=""></span> </li>
                                                <li> <span class="color-item color-seagreen" data-theme="seagreen"></span> </li>
                                                <li> <span class="color-item color-blue" data-theme="blue"></span> </li>
                                                <li> <span class="color-item color-purple" data-theme="purple"></span> </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                                <a href=""> <i class="fa fa-cog"></i> Customize </a>
                            </li>
                        </ul>
                    </footer>
                </aside>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <article class="content items-list-page">
                    <div class="title-block">
                        <div class="row">
                            <div class="col-md-12">
                                <h3 class="title"> Edit Salesman Details

                                </h3>
                            </div>
                        </div>
                    </div>
                    <form action="AdminSalesmanServlet" method="post">
                        <div class="form-group row"> <label class="col-sm-2 form-control-label text-xs-right">
                                Name:
                            </label>
                            <div class="col-sm-10"> <input class="form-control form-control-lg" type="text" list="snameid" placeholder="Salesman Name" name="username" id="username" oninput="getDetails(this.value)" > </div>
                            <datalist id="snameid">

                            </datalist>  
                        </div>

                        <div class="form-group row"> <label class="col-sm-2 form-control-label text-xs-right">
                                Mobile No:
                            </label>
                            <div class="col-sm-10"> <input type="text" class="form-control boxed" placeholder="Mobile No." name="mobileno" id="mobileno" value=""> </div>
                        </div>
                        <div class="form-group row"> <label class="col-sm-2 form-control-label text-xs-right">
                                E-mail:
                            </label>
                            <div class="col-sm-10"> <input type="email" class="form-control boxed" placeholder="E-mail" name="email" id="email" value=""> </div>
                        </div>
                        <div class="form-group row"> 
                            <label class="col-sm-2 form-control-label text-xs-right">
                                Address:
                            </label>
                            <div class="col-sm-2"> <input type="text" class="form-control boxed" placeholder="Door No" name="doorno" id="doorno" value=""> </div>
                            <div class="col-sm-4"> <input type="text" class="form-control boxed" placeholder="Street Name" name="streetname" id="streetname" value=""> </div>
                            <div class="col-sm-4"> <input type="text" class="form-control boxed" placeholder="City" name="city" id="city" value=""> </div>
                        </div>
                        <div class="form-group row"> 
                            <div class="col-sm-2"></div>
                            <div class="col-sm-4"> <input type="text" class="form-control boxed" placeholder="District" name="district" id="district" value=""> </div>
                            <div class="col-sm-3"> <input type="text" class="form-control boxed" placeholder="State" name="state" id="state" value=""> </div>
                            <div class="col-sm-3"> <input type="text" class="form-control boxed" placeholder="Pincode" name="pincode" id="pincode" value=""> </div>
                        </div>
                        <input type="hidden"  id="userid" name="userid" value="" />
                        <%if (request.getAttribute("status") != null) {%>
                        <input type="hidden" name="status" id="status" value="<%=(String) request.getAttribute("status")%>"/>
                        <%request.setAttribute("status", null);
                        } else {%>
                        <input type="hidden" name="status" id="status" />
                        <%}%>
                        <div class="form-group row">
                            <div class="col-sm-10 col-sm-offset-2"> <button type="submit" value="update" name="operation" class="btn btn-primary">
                                    Update
                                </button> </div>
                        </div>
                    </form>
                </article>
            </div>
        </div>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
        <script>
            (function (i, s, o, g, r, a, m)
            {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function ()
                {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
            ga('create', 'UA-80463319-2', 'auto');
            ga('send', 'pageview');
        </script>
        <script src="js/admindash.js"></script>
        <script src="js/adminapp.js"></script>
    </body>

</html>