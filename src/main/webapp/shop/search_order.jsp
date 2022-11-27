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
<body>

    <div class="content">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="form-block mx-auto">
                        <div class="text-center mb-5">
                            <h3 class="text-uppercase">TÌNH TRẠNG ĐƠN HÀNG</h3>
                        </div>
                        <form action="order-tatus" method="POST" id="form-2">
                            <div class="form-group first">
                                <p class="form-message">${mess}</p>
                                <label for="username">Email của bạn</label>
                                <input type="text" name="username" class="form-control"
                                       placeholder="Email của bạn" id="username">
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