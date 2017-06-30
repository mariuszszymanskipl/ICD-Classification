<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ attribute name="mainCategory" type="domain.MainCategory" required="true" %>

<li class="list-group-item">
    <div class="row">
        <div class="col-xs-1"><strong>${mainCategory.code}</strong>
        </div>
        <div class="col-xs-11">${mainCategory.title}</div>
    </div>
    <c:forEach var="detailedCategory"
               items="${mainCategory.detailedCategories}">
        <tags:detailedCategoryView detailedCategory="${detailedCategory}"/>
    </c:forEach>
</li>