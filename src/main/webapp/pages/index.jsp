<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>

    <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script src="<c:url value="/pages/js/angular.min.js"/> "></script>
    <script src="<c:url value="/pages/js/main-app.js"/> "></script>
</head>

<body ng-app="main">
<div ng-app="articles" ng-controller="PanelController as panel">
    <ul class="nav nav-pills">
        <li ng-class="{active:panel.isSelected(1)}"><a href ng-click="panel.selectTab(1)">
            Списки</a></li>

        <sec:authorize access="hasRole('ADMIN')">
            <li ng-class="{active:panel.isSelected(2)}"><a href ng-click="panel.selectTab(3)">
            Добавить продукт</a></li>

        </sec:authorize>

    </ul>
    <div ng-show="panel.isSelected(1)">
        <div class="col-sm-9" style="margin: auto 0">
            <div class="row" style="margin-top: 20px;">
                <global-list class="col-sm-6"></global-list>
                <user-list class="col-sm-4"></user-list>
                <registration class="col-sm-2"></registration>
            </div>
        </div>
    </div>

    <sec:authorize access="hasRole('ADMIN')">
        <div class="panel" ng-show="panel.isSelected(2)">
            <add-product></add-product>
        </div>
    </sec:authorize>


</div>

</body>
</html>
