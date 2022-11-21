<%-- Created by IntelliJ IDEA. User: lelon Date: 21/10/2022 Time: 00:53 To change this template use File | Settings | File Templates. --%> <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root" />
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Apple-Store</title>
      <link rel="stylesheet" href="${root}asset/style.css">
      <link rel="stylesheet" href="${root}asset/font/themify-icons/themify-icons.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- Latest compiled JavaScript -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
   </head>
   <body>
    <div id="main">
        <c:set var="items" value="${listlsp}" scope="request"/>
        <jsp:include page="./header2.jsp" />
         <div class="detail-blog">
            <div class="container">
               <div class="row">
                  <div class="detail-content"> 
                    <!-- thay đổi nội dung class detail-content này nha -->
                    <h1 class="title">${baiViet.tieuDeBV}</h1>
                  <p class="fs-ndt-day">${baiViet.ngayTao}</p>
                  <!-- Tiêu đề là thẻ h1 đó nha -->
                  <div class="fs-ndt-main" id="contents">
                      ${baiViet.noiDung}
                  </div>
                  </div>
               </div>
            </div>
         </div>
         <%@include file="./footer2.jsp"%>
      </div>
</body>
</html>