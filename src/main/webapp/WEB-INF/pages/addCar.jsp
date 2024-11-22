<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTamplates pageTitle="Add Car">
    <div class="container">
        <h1>Add Car</h1>
        <form class="needs-validation was-validated" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
            <div class="mb-3">
                <label for="license_plate">License Plate</label>
                <input type="text" class="form-control" id="license_plate" name="license_plate" required>
                <div class="invalid-feedback">
                    License Plate is required.
                </div>
            </div>
            <div class="mb-3">
                <label for="parking_spot">Parking Spot</label>
                <input type="text" class="form-control" id="parking_spot" name="parking_spot" required>
                <div class="invalid-feedback">
                    Parking Spot is required.
                </div>
            </div>
            <div class="mb-3">
                <label for="owner_id">Owner</label>
                <select class ="custom-select d-block w-100" id="owner_id" name="owner_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="user" items="${users}" varStatus="status">
                        <option value="${user.id}">${user.username}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
</t:pageTamplates>
