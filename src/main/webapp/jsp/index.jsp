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

		<div class="page-header">
			<h2>qwre</h2>
		</div>
		<form name="roundForm" method="get" action="/">
			<div class="input-group">
				<input type="text" name="round" class="form-control"
					value="${roundInfo.drwNo}"> <span class="input-group-btn">
					<button class="btn btn-default" type="submit">Go!</button>
				</span>
			</div>
		</form>
		<div class="input-group">
			<h3>
				<c:choose>
					<c:when test="${roundInfo.drwtNo1 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo1}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo1 >= 11 && roundInfo.drwtNo1 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo1}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo1 >= 21 && roundInfo.drwtNo1 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo1}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo1 >= 31 && roundInfo.drwtNo1 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo1}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo1}</span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${roundInfo.drwtNo2 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo2}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo2 >= 11 && roundInfo.drwtNo2 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo2}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo2 >= 21 && roundInfo.drwtNo2 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo2}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo2 >= 31 && roundInfo.drwtNo2 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo2}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo2}</span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${roundInfo.drwtNo3 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo3}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo3 >= 11 && roundInfo.drwtNo3 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo3}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo3 >= 21 && roundInfo.drwtNo3 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo3}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo3 >= 31 && roundInfo.drwtNo3 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo3}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo3}</span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${roundInfo.drwtNo4 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo4}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo4 >= 11 && roundInfo.drwtNo4 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo4}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo4 >= 21 && roundInfo.drwtNo4 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo4}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo4 >= 31 && roundInfo.drwtNo4 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo4}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo4}</span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${roundInfo.drwtNo5 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo5}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo5 >= 11 && roundInfo.drwtNo5 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo5}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo5 >= 21 && roundInfo.drwtNo5 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo5}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo5 >= 31 && roundInfo.drwtNo5 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo5}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo5}</span>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${roundInfo.drwtNo6 < 11}">
						<span class="label label-warning draw-ball">${roundInfo.drwtNo6}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo6 >= 11 && roundInfo.drwtNo6 < 21}">
						<span class="label label-primary draw-ball">${roundInfo.drwtNo6}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo6 >= 21 && roundInfo.drwtNo6 < 31}">
						<span class="label label-danger draw-ball">${roundInfo.drwtNo6}</span>
					</c:when>
					<c:when test="${roundInfo.drwtNo6 >= 31 && roundInfo.drwtNo6 < 41}">
						<span class="label label-default draw-ball">${roundInfo.drwtNo6}</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success draw-ball">${roundInfo.drwtNo6}</span>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>

		<div class="input-group">
			<h3>
				<c:forEach var="winningNumber" items="${mostWinnigNumbers}">
					<c:choose>
						<c:when test="${winningNumber < 11}">
							<span class="label label-warning draw-ball">${winningNumber}</span>
						</c:when>
						<c:when test="${winningNumber >= 11 && winningNumber < 21}">
							<span class="label label-primary draw-ball">${winningNumber}</span>
						</c:when>
						<c:when test="${winningNumber >= 21 && winningNumber < 31}">
							<span class="label label-danger draw-ball">${winningNumber}</span>
						</c:when>
						<c:when test="${winningNumber >= 31 && winningNumber < 41}">
							<span class="label label-default draw-ball">${winningNumber}</span>
						</c:when>
						<c:otherwise>
							<span class="label label-success draw-ball">${winningNumber}</span>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</h3>
		</div>

		<div class="row">
			<input type="radio" value="true" name="withBonus" />보너스 포함 <input
				type="radio" value="false" name="withBonus" />보너스 제외
		</div>

	</div>
	<!-- /container -->


	<!-- jQuery 2.1.4 -->
	<script src="webjars/jquery/2.1.4/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
	<!-- lng -->
	<script src="resources/js/lng.js"></script>
</body>


</html>