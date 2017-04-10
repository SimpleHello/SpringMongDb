<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="jquery/jquery-1.9.1.js" type="text/javascript" ></script>
<script src="index.js" type="text/javascript" ></script>
<style type="text/css">
	p.normal {font-style:normal}
	p.italic {font-style:italic}
	p.oblique {font-style:italic;color:#9D9D9D}
</style>

</head>
<body>
<!-- <input type="button" style='font-size: 15px' value="传值zhangsan" onclick="startZhangsan()">

<input type="button" style='font-size: 15px' value="传值 lisi" onclick="startLisi()"> -->
</br>

<p class="italic">type:01=启动;10=停止; 30=时间粒度修改</p>
<p class="oblique">00=新增-(暂不开放); 11=删除 状态的修改(暂不开放)</p>
</br>

<label>Job名称</label>
<select id="jobName">
	<option value="TestQuartz2">测试2 job</option>
	<option value="TestQuartz3">测试3 job</option>
	<option value="TestQuartz4">测试4 job</option>
</select>
<label>操作类型:</label>
<select id="type">
	<option value="01">启动</option>
	<option value="10">停止</option>
	<option value="30">修改时间粒度</option>
</select>


测试时间粒度:
<select id="cron">
	<option value=""> - </option>
	<option value="0/2 * * * * ?">2秒 执行一次</option>
	<option value="0/3 * * * * ?">3秒 执行一次</option>
	<option value="0/5 * * * * ?">5秒 执行一次</option>
	<option value="0/7 * * * * ?">7秒 执行一次</option>
	<option value="0/9 * * * * ?">9秒 执行一次</option>
</select>

<input type="button" style='font-size: 15px' value="发送消息" onclick="sendMessage()">

</body>


</html>