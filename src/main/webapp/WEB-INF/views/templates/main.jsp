<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<c:url value="/resources/stylesheets/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/stylesheets/estilo.css" />" rel="stylesheet">
    <script href="<c:url value="/resources/js/bootstrap.min.js" />"></script>	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script href="<c:url value="/resources/js/ytembed.js" />"></script>
	<script src="http://www.yvoschaap.com/ytpage/ytembed.js"></script>
	
	<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div class="container borderedForm">
		<tiles:insertAttribute name="body"/>
	</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>