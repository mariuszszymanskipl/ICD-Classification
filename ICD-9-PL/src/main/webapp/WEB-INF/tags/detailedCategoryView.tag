<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="detailedCategory" type="domain.DetailedCategory" required="true" %>

<li class="list-group-item">
    <div class="row">
        <div class="col-xs-1 col-xs-less-1">
            <strong>${detailedCategory.code}</strong>
        </div>
        <div class="col-xs-10">${detailedCategory.description}</div>
    </div>
</li>