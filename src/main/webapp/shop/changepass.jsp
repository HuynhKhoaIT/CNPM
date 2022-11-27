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

    <title>Change Password</title>
</head>
<body  style="
    background-image: url(https://static.vecteezy.com/system/resources/previews/002/037/924/original/abstract-blue-background-with-beautiful-fluid-shapes-free-vector.jpg);
">


<div class="d-md-flex half">
    <%--     <div class="bg" style="background-image: url('${root}asset/img/ipad.webp');"></div>
        <div class="contents"> --%>

    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-md-12">
                <div class="form-block mx-auto">
                    <div class="text-center mb-5">
                        <h3 class="text-uppercase">Đổi Mật Khẩu <strong>APPLEStore</strong></h3>
                    </div>
                    <form action="changepass" method="POST" id="form-6">
                        <div class="form-group first">
                            <p class="form-message">${mess}</p>
                            <label for="password">Mật Khẩu</label>
                            <input type="password" name="password" class="form-control"
                                   placeholder="Mật khẩu mới của bạn..." id="password">
                            <span class="form-message"></span>
                        </div>
                        <div class="form-group last mb-3">
                            <label for="repassword">Nhập Lại Mật khẩu</label>
                            <input type="password" name="repassword" class="form-control"
                                   placeholder="Nhập lại mật khẩu..." id="repassword">
                            <span class="form-message"></span>
                        </div>

                        <!-- <div class="d-sm-flex mb-5 align-items-center">
                          <label class="control control--checkbox mb-3 mb-sm-0"><span class="caption">Remember me</span>
                            <input type="checkbox" checked="checked"/>
                            <div class="control__indicator"></div>
                          </label>
                          <span class="ml-auto"><a href="#" class="forgot-pass">Quên mật khẩu</a></span>
                          <span class="ml-auto"><a href="/Apple_store/shop/signup" class="forgot-pass">Chưa có tài khoản</a></span>
                        </div> -->

                        <button class="btn btn-block py-2 btn-primary" type="submit">Đổi Mật Khẩu</button>

                        <!--  <span class="text-center my-3 d-block">or</span>


                         <div class="">
                         <a href="#" class="btn btn-block py-2 btn-facebook">
                           <span class="icon-facebook mr-3"></span> Đăng nhập với Facebook
                         </a>
                         <a href="#" class="btn btn-block py-2 btn-google"><span class="icon-google mr-3"></span> Đăng nhập với google</a>
                         </div> -->
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--     </div> -->


</div>
  <script src="${root}asset/js/Validator.js"></script>

  <script>

      document.addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
      //   Đăng nhập
        Validator({
          form: '#form-6',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
        	  Validator.minLength('#password', 6),
              Validator.isRequired('#repassword'),
              Validator.isConfirmed('#repassword', function () {
                  return document.querySelector('#form-6 #password').value;
              }, 'Mật khẩu nhập lại không chính xác')
          ],
        });
      //   Đăng nhập

      });

  </script>


</body>
</html>