<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="header.jsp"/>

    <h1>Product catalog</h1>
    <sec:authorize access="hasRole('ADMIN')">
    <a class="btn btn-link" href="${pageContext.request.contextPath}/add">Add new product</button></a>
    </sec:authorize>
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">S/N</th>
          <th scope="col">Product Name</th>
          <th scope="col">Price</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach var="item" items="${items}">
        <tr>
          <th scope="row">${item.id}</th>
          <td><a href = "${pageContext.request.contextPath}/product/item/${item.id}">${item.name}</a></td>
          <td>${item.price}</td>
        </tr>
         </c:forEach>
        </tbody>
    </table>

<jsp:include page="footer.jsp"/>