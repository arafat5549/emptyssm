<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/Public/taglib.jsp" %>

<%--@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="/Public/csslib.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>后台主页</title>

</head>
<body>
   

<div id="wrapper">    
	<h5>时间处理</h5>
	<form action="${context }/date" method="post">
		<input type="text" class="form-control" name="losttime" id="losttime">
		<button>提交</button>
	</form>
	<br>
	<h5>文件上传</h5>
	<form action="${context }/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file">
		<img src="${context }${imgName}">
		${context }${imgName}
		<button>提交</button>
	</form>
	
	
	<img src="${context }/Public/img/a1.jpg">
</div>
  
  
<%@ include file="/Public/jslib.jsp" %>
 
 <!-- 时间选择插件 laydate --> 
    <script>
        laydate({elem:"#losttime",event:"focus", format: 'YYYY-MM-DD'});
    </script>
 
</body>
</html>