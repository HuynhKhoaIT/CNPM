<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url value="/" var="root" />
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

    <title>Verify</title>
</head>
<body>


<div class="d-md-flex half">
    <div class="bg" style="background-image: url('${root}asset/img/images/iphone.webp');"></div>
    <div class="contents">

        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-12">
                    <div class="form-block mx-auto">
                        <div class="text-center mb-5">
                            <h3 class="text-uppercase">Verify <strong>APPLEStore</strong></h3>
                        </div>
                        <form action="verify" method="post" id="form-3">
                            <p class="form-message">${mess}</p>
                            <div class="form-group first">
                                <label for="verify">Mã xác nhận</label>
                                <input type="text" name="verify" class="form-control" placeholder="Mã xác nhận" id="verify">
                                <span class="form-message"></span>
                            </div>

                            <button type="submit" class="btn btn-block py-2 btn-primary">Xác nhận</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>

<%--<script src="${root}asset/js/Validator.js"></script>--%>

<%--<script>--%>
<%--    document.addEventListener('DOMContentLoaded', function () {--%>
<%--        // Mong muốn của chúng ta--%>
<%--        //   Đăng ký--%>
<%--        Validator({--%>
<%--            form: '#form-3',--%>
<%--            formGroupSelector: '.form-group',--%>
<%--            errorSelector: '.form-message',--%>
<%--            rules: [--%>
<%--                Validator.isRequired('#verify', 'Vui lòng nhập mã xác nhận'),--%>
<%--            ],--%>
<%--        });--%>
<%--        //   Đăng ký--%>
<%--    });--%>
<%--</script>--%>


</body>
</html>