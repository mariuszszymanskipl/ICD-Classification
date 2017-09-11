<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="partials/meta.jsp"/>
</head>
<body>

<jsp:include page="partials/navbar.jsp"/>

<a href="#" id="goToTopBtn" title="Go to top"><span class="glyphicon glyphicon-chevron-up"></span></a>

<div class="container">

    <div class="row">
        <div class="col-sm-offset-2 col-sm-8">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>ICD-9 Classification
                    </h3></div>
                </div>
            </div>

            <div class="panel-group" id="accordion">
                <jsp:useBean id="classification" scope="request" type="domain.Classification"/>
                <c:forEach var="section" items="${classification.sections}">
                    <tags:sectionView section="${section}"/>
                </c:forEach>
            </div>
        </div>
    </div>

</div>

<jsp:include page="partials/footer.jsp"/>

</body>
</html>
