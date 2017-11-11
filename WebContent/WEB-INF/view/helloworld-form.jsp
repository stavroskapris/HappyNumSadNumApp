<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello World - Input Form</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<style>
.error {
	color: red;
	
	padding: 10px;
	font-family: 'Open Sans Condensed', sans-serif;
	font-style: italic;
	font-size :30px;
}
.success {
	color:  Limegreen;
	padding: 10px;
	font-family: 'Open Sans Condensed', sans-serif;
	font-style: italic;
	font-size :30px;
}

</style>
<body>
<div class="form-wrapper cf">
<c:if test="${not empty message1}">
				<div class="success">
					<c:out value="${param.number} ${message1}" />
				</div>
			</c:if>

<c:if test="${not empty message2}">
				<div class="error">
					<c:out value="${param.number} ${message2}" />
				</div>
			</c:if>
	<form action="proccesApp" method="GET">

		<input type="number" name="number" placeholder="Type an integer.."required>

       <button type="submit">go</button>	</form>
	</div>
</body>

</html>