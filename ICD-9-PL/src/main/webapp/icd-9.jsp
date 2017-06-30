<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ICD-9-PL Classification</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading"><h3>ICD-9 Classification
                <%--<span class="badge">${classification.sections.subsections.mainCategories.detailedCategories.size()}</span>--%>
            </h3></div>
        </div>
    </div>

    <div class="panel-group" id="accordion">
        <c:forEach var="section" items="${classification.sections}">
            <tags:sectionView section="${section}"/>
        </c:forEach>
    </div>

</div>
</body>
</html>
