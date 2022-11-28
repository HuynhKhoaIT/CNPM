<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${root}asset/font/icomoon/style.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${root}asset/cssacc/bootstrap.min.css">

    <!-- Style -->
    <link rel="stylesheet" href="${root}asset/cssacc/style.css">

    <title>Login</title>
</head>
<body style="
    background-image: url(https://static.vecteezy.com/system/resources/previews/002/037/924/original/abstract-blue-background-with-beautiful-fluid-shapes-free-vector.jpg);
">

    <div class="content">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="form-block mx-auto">
                        <div class="text-center mb-5">
                            <h3 class="text-uppercase">TÌNH TRẠNG ĐƠN HÀNG</h3>
                        </div>
                        <form action="searchorder" method="POST" id="form-2">
                            <div class="form-group first">
                                <p class="form-message-1">${mess}</p>
                                <label for="email">Email của bạn</label>
                                <input type="text" name="email" class="form-control"
                                       placeholder="Email của bạn" id="email">
                                <span class="form-message"></span>
                            </div>
                            <button class="btn btn-block py-2 btn-primary" type="submit">Tìm Kiếm</button>
						</form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>