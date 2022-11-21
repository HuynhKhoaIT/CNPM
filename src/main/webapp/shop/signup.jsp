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

    <title>Sign Up</title>
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
                <h3 class="text-uppercase">Sign Up <strong>APPLEStore</strong></h3>
              </div>
              <form action="signup" method="post" id="form-1">
              <p class="form-message">${mess}</p>
                <div class="form-group first">
                  <label for="fullname">Họ tên</label>
                  <input type="text" name="fullname" class="form-control" placeholder="Tên đăng nhập của bạn..." id="fullname">
                  <span class="form-message"></span>
                </div>
                <div class="form-group first">
                  <label for="username">Tên đăng nhập</label>
                  <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập của bạn..." id="username">
                  <span class="form-message"></span>
                </div>
                <div class="form-group last mb-3">
                  <label for="email">Email</label>
                  <input type="text" name="email" class="form-control" placeholder="Mật khẩu của bạn..." id="email">
                  <span class="form-message"></span>
                </div>
                <div class="form-group last mb-3">
                  <label for="phone">Số điện thoại</label>
                  <input type="text" name="phone" class="form-control" placeholder="Mật khẩu của bạn..." id="phone">
                  <span class="form-message"></span>
                </div>
                <div class="form-group last mb-3">
                  <label for="password">Mật khẩu</label>
                  <input type="password" name="password" class="form-control" placeholder="Mật khẩu của bạn..." id="password">
                  <span class="form-message"></span>
                </div>
                <div class="form-group last mb-3">
                  <label for="repassword">Nhập lại mật khẩu</label>
                  <input type="password" name="repassword" class="form-control" placeholder="Mật khẩu của bạn..." id="repassword">
                  <span class="form-message"></span>
                </div>

                <button type="submit" class="btn btn-block py-2 btn-primary">Đăng ký</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    
  </div>
  
	<script src="${root}asset/js/Validator.js"></script>

  <script>

      document.addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
      //   Đăng ký
        Validator({
          form: '#form-1',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isRequired('#fullname', 'Vui lòng nhập tên đầy đủ của bạn'),
            Validator.isRequired('#username', 'Vui lòng nhập tên đăng nhập'),
            Validator.isRequired('#email'),
            Validator.isRequired('#phone'),
            Validator.isPhone('#phone'),
            Validator.isEmail('#email'),
            Validator.minLength('#password', 6),
            Validator.isRequired('#repassword'),
            Validator.isConfirmed('#repassword', function () {
              return document.querySelector('#form-1 #password').value;
            }, 'Mật khẩu nhập lại không chính xác')
          ],
        });
      //   Đăng ký

      });

  </script>

	
</body>
</html>