<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ICD-9-PL Classification</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><h3>ICD-9 Classification
            <span class="badge">${classification.size()}</span>
        </h3></div>
        <ul class="list-group">
            <c:forEach var="record" items="${classification}">
                <li class="list-group-item">${record.mainCategoryNumber} ${record.mainCategory}</li>
            </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
