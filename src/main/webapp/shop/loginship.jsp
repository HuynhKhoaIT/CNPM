<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Login</title>
</head>
<body>
	  

  <div class="d-md-flex half">
    <div class="bg" style="background-image: url('${root}asset/img/ip14-s.webp');"></div>
    <div class="contents">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="form-block mx-auto">
              <div class="text-center mb-5">
                <h3 class="text-uppercase">Login SHIPPER <strong>APPLEStore</strong></h3>
              </div>
              <form action="loginship" method="POST" id="form-2">
                <div class="form-group first">
               	  <p class="form-message">${mess}</p>
                  <label for="username">Tên đăng nhập</label>
                  <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập của bạn..." id="username">
                  <span class="form-message"></span>
                </div>
                <div class="form-group last mb-3">
                  <label for="password">Mật khẩu</label>
                  <input type="password" name="password" class="form-control" placeholder="Mật khẩu của bạn..." id="password">
                  <span class="form-message"></span>
                </div>


                <button class="btn btn-block py-2 btn-primary" type="submit" >Đăng nhập</button>

                <!-- <span class="text-center my-3 d-block">or</span>
                
                
                <div class="">
                <a href="#" class="btn btn-block py-2 btn-facebook">
                  <span class="icon-facebook mr-3"></span> Đăng nhập với Facebook
                </a>
                <a href="#" class="btn btn-block py-2 btn-google"><span class="icon-google mr-3"></span> Đăng nhập với google</a> -->
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    
  </div>
<!--
  <script src="${root}asset/js/Validator.js"></script>

  <script>

      document.addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
      //   Đăng nhập
        Validator({
          form: '#form-2',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isRequired('#username', 'Vui lòng nhập tên đăng nhập'),
            Validator.isRequired('#password', 'Vui lòng nhập mật khẩu'),
          ],
        });
      //   Đăng nhập

      });

  </script>

-->
</body>
</html>