<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="jquery/jquery-1.9.1.js" type="text/javascript" ></script>
<script src="index.js" type="text/javascript" ></script>


</head>
<body>
<input type="button" style='font-size: 15px' value="传值zhangsan" onclick="startZhangsan()">

<input type="button" style='font-size: 15px' value="传值 lisi" onclick="startLisi()">
</br>
jobName:TestQuartz2,TestQuartz3</br>
type:00=新增 ;01=启动 10=停止 11=删除 状态的修改。 30 = 时间表达式的修改</br>

jobName:<input type="text" id="jobName">
type:<input type="text" id="type">
时间粒度:<input type="text" id="cron">
<input type="button" style='font-size: 15px' value="发送消息" onclick="sendMessage()">

</body>


</html>