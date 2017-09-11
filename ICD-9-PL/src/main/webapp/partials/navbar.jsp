<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<nav class="navbar navbar-inverse navbar-fixed-top">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}">
            <span class="glyphicon glyphicon-link"></span> ICD-9 Classification</a>
    </div>

    <div class="collapse navbar-collapse navHeaderCollapse">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}#about">ABOUT ICD</a></li>
            <li><a href="${pageContext.request.contextPath}#version">Version: 1.0-SNAPSHOT </a></li>
        </ul>
    </div>

</nav>
