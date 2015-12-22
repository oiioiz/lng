<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>title</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.6/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.6/dist/css/bootstrap-theme.min.css">

<style>
span.draw-ball {
	display: inline-block;
	border-radius: 50%;
	line-height: 1.7em;
	width: 2.3em;
}

.round-info {
	font-size: 1.2em;
}

.round-info>span {
	font-weight: bold;
}

ul.inline-ul {
	display: inline-block;
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body role="document">

	<div class="container theme-showcase" role="main">

		<div class="page-header" data-role="ui-last-info">
			<p class="round-info">
				최종회차 : <span data-role="ui-round"></span>&nbsp; 추첨일 : <span
					data-role="ui-date"></span>
			</p>
			<h4 data-role="ui-ball-list"></h4>
		</div>

		<div class="cont" data-role="ui-most-info">
			<ul class="nav nav-pills inline-ul" data-role="ui-most-winning-sort">
				<li role="presentation"><a href="javascript:void(0);"
					data-most-winning-sort="desc"
					class="glyphicon glyphicon-sort-by-attributes-alt"></a></li>
				<li role="presentation"><a href="javascript:void(0);"
					data-most-winning-sort="asc"
					class="glyphicon glyphicon-sort-by-attributes"></a></li>
			</ul>

			<ul class="nav nav-pills inline-ul" data-role="ui-with-bonus-number">
				<li role="presentation" class="active"><a href="javascript:void(0);"
					data-with-bonus-number="true" class="glyphicon glyphicon-eye-open"></a></li>
				<li role="presentation"><a href="javascript:void(0);"
					data-with-bonus-number="false" class="glyphicon glyphicon glyphicon-eye-close"></a></li>
			</ul>
			<h3 data-role="ui-ball-list"></h3>
			<hr>
		</div>
		
		<div class="cont" data-role="ui-appearance-info">
		
		</div>

	</div>
	<!-- /container -->


	<!-- jQuery 2.1.4 -->
	<script src="webjars/jquery/2.1.4/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
	<!-- lng -->
	<script src="js/lng.js"></script>
	<script src="js/event.js"></script>
</body>


</html>