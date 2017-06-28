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
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading"><h3>ICD-9 Classification
                <%--<span class="badge">${classification.sections.subsections.mainCategories.detailedCategories.size()}</span>--%>
            </h3></div>
            <ul class="list-group">
                <c:forEach var="section" items="${classification.sections}">
                    <li class="list-group-item active">
                        <div class="row">
                            <div class="col-xs-1"><strong>${section.code}</strong></div>
                            <div class="col-xs-11">${section.title}</div>
                        </div>
                    </li>
                    <ul class="list-group">
                        <c:forEach var="subsection" items="${section.subsections}">
                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-xs-1"><strong>${subsection.code}</strong></div>
                                    <div class="col-xs-11">${subsection.title}</div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
