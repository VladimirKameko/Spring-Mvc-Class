<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>

  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">PVT-Market</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="${pageContext.request.contextPath}/home/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/catalog/">Product Catalog</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="${pageContext.request.contextPath}/navbarDropdown/" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            My account
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/cart">Cart</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/orders">Orders</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/help">Help</a>
          </div>
        </li>
      <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
          <a class="nav-link " href="${pageContext.request.contextPath}/register">Register</a>
        </li>
         <li class="nav-item">
                  <a class="nav-link " href="${pageContext.request.contextPath}/login">Login</a>
         </li>
       </sec:authorize>
       <sec:authorize access="isAuthenticated()">
          <li class="nav-item">
                           <a class="nav-link " href="${pageContext.request.contextPath}/logout">Logout</a>
           </li>
        </sec:authorize>
      </ul>
      <form class="form-inline my-2 my-lg-0"   action="${pageContext.request.contextPath}/search">
        <input name= "searchStr" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0"    type="submit">Search</button>
      </form>
    </div>
  </nav>