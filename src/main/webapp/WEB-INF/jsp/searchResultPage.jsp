<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

    <h1>Product catalog</h1>

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
          <td>${item.name}</td>
          <td>${item.price}</td>
        </tr>
         </c:forEach>
        </tbody>
    </table>

<jsp:include page="footer.jsp"/>