<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    User Page!

</body>
<script src="http://cdn.bootcss.com/jquery/1.12.3/jquery.min.js"></script>
<script type="text/javascript">
$.ajax({
    url: "/pagehelper",
    type: 'POST',
	dataType:"json",
	contentType: 'application/json',
	data:JSON.stringify({"robitid":""}),
    dataSrc: function (myJson) {
        if (myJson.timeout) {
            return "";
        }
        console.log(myJson);
        return myJson;
    }
  })
</script>
</html>