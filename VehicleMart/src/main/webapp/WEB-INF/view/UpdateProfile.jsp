<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<div class="container">
<div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header" align="center" style="color: blue"><h3><b>Update profile</b></h3></div><hr>
                            <div class="card-body">

                                <form class="form-horizontal" method="post" action="updateProfile">

                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">User Name</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="username" id="name" value="${user.userName }"/>
                                            </div>
                                        </div>
                                    </div>
                     
                                    <div class="form-group">
                                        <label for="email" class="cols-sm-2 control-label">Your Email</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="email" id="email" value="${user.email }"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">User Role</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="role" id="role" value="${user.userRole }" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">Full name</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="fullname" id="fullname" value="${user.fullName }" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="username" class="cols-sm-2 control-label">Address</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="address" id="address" value="${user.address }" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group ">
                                        <center><input type="submit"  value="Register" class="btn btn-primary"/></center>
                                    </div>
                                
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
</div>
</body>
</html>