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
     	<c:set var="items" value="${listlsp}" scope="request" />
		<jsp:include page="./header2.jsp" />
	    <div id="title-blog">
	        <div class="container">
	            <div class="row">
	                <p>THÔNG TIN</p>
	            </div>
	        </div>
	    </div>
	    <div id="content-blog">
	        <div class="container">
	            <div class="row">
	                <div class="img-blog col-md-6 col-12">
	                    <div class="blog-main">
	                        <a href="http://localhost:8080/Apple_store/BlogDetailControl?maBV=${baiViet.maBV}">
	                            <img class="avatar-blog" src="${baiViet.anh}" alt="">
	                            <div class="title1-blog">
	                                <h3>${baiViet.tieuDeBV}</h3>
	                            </div>
	                        </a>
	                    </div>
	                    <div class="blog-item">
	                        <ul>
	                        <c:forEach items="${listblog}" var="o" >
	                            <li>
	                                <div class="item row">
	                                    <a class="col-md-4 col-4" href="${root}shop/detail_blog.jsp">
	                                        <img class="avatar-blog" src="${o.anh}" alt="">
	                                    </a>
	                                    <div class="title2-blog col-md-8 col-8">
	                                        <a  href="http://localhost:8080/Apple_store/BlogDetailControl?maBV=${o.maBV}">${o.tieuDeBV}</a>
	                                    </div>
	                                </div>
	                            </li>
	                           </c:forEach>
	                        </ul>
	                    </div>
	                </div>
	                
	            </div>
	        </div>
	    </div>
	    <%@include file="./footer2.jsp"%>
    </div>
</body>
</html>