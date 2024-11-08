<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTamplates pageTitle=" Cars">
    <h1> Cars</h1>
    <div class="row">
        <div class="col">
            Car1
        </div>
        <div class="col">
            Spot 1
        </div>
        <div class="col">
            User 1
        </div>
    </div>
    <div class="row">
        <div class="col">
            Car2
        </div>
        <div class="col">
            Spot 2
        </div>
        <div class="col">
            User 2
        </div>
    </div>
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTamplates>
