<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTamplates pageTitle="Users">
  <h1> Users</h1>

  <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add User</a>

  <div class="container text-center">

    <c:forEach var="user" items="${users}">
      <div class="row">
        <div class="col">
            ${user.id}
        </div>
        <div class="col">
            ${user.username}
        </div>
      </div>
    </c:forEach>

  </div>

</t:pageTamplates>
