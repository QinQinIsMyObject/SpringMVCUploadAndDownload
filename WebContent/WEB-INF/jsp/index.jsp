<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form action="doUpload.do" method="post" enctype="multipart/form-data">
		图片:<input type="file" name="file" /><input type="submit" />
	</form>
</body>
</html>