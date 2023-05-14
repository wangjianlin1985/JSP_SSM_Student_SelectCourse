<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/ssm_xuanke/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/ssm_xuanke/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>学生选课信息管理系统</title>
<script type="text/javascript" src="/ssm_xuanke/utils/js/jquery-3.3.1.min.js"></script>
<!-- Loading Bootstrap -->
<link href="/ssm_xuanke/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/ssm_xuanke/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/ssm_xuanke/utils/scripts/flat-ui.min.js"></script>


<script type='text/javascript' src='/ssm_xuanke/utils/scripts/particles.js'></script><link href="/ssm_xuanke/utils/css/animate.css" rel="stylesheet"></head>




<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="teacherLeft.jsp" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h5>修改课程</h5>
			<c:forEach var="cplan" items="${sessionScope.cPlanList}">
				<form action="../moditycouplan/${cplan.tid }"
			method="get">
				<div class="row">
					<div class="col-md-6">
						<br /> 新建班级名称
			
			 <input type="text" name="courseclass" value="${cplan.courseclass}" class="form-control" readOnly/>
			上课时间
					${cplan.coursetime}节 选择
			
			
			<label class="checkbox" for="coursetime1">
	            <input type="checkbox" name="coursetime" value="12" id="coursetime1" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                               第一二节
          	</label>
          	<label class="checkbox" for="coursetime2">
	            <input type="checkbox" name="coursetime" value="34" id="coursetime2" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                              第三四节
          	</label>
          	<label class="checkbox" for="coursetime3">
	            <input type="checkbox" name="coursetime" value="56" id="coursetime3" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             第五六节
          	</label>
          	<label class="checkbox" for="coursetime4">
	            <input type="checkbox" name="coursetime" value="78" id="coursetime4" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             第七八节
          	</label>
			

			<br> 上课周
			 ${cplan.courseweek}周 选择
			<label class="checkbox" for="courseweek1">
	            <input type="checkbox" name="courseweek" value="1" id="courseweek1" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期一
          	</label>
          	
          	<label class="checkbox" for="courseweek2">
	            <input type="checkbox" name="courseweek" value="2" id="courseweek2" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期二
          	</label>
          	
          	<label class="checkbox" for="courseweek3">
	            <input type="checkbox" name="courseweek" value="3" id="courseweek3" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期三
          	</label>
          	
          	<label class="checkbox" for="courseweek4">
	            <input type="checkbox" name="courseweek" value="4" id="courseweek4" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期四
          	</label>
          	
          	<label class="checkbox" for="courseweek5">
	            <input type="checkbox" name="courseweek" value="5" id="courseweek5" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期五
          	</label>
          	
          	<label class="checkbox" for="courseweek6">
	            <input type="checkbox" name="courseweek" value="6" id="courseweek6" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期六
          	</label>
          	
          	<label class="checkbox" for="courseweek7">
	            <input type="checkbox" name="courseweek" value="7" id="courseweek7" data-toggle="checkbox" class="custom-checkbox"><span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
	                             星期日
          	</label>
			
					</div>
					<div class="col-md-6">
					<h6>课程编号</h6>
					<div class="row">
			<div class="col-md-6">
				<input type="text" name="cid" value="${cplan.cid}" class="form-control" readonly/>
			</div></div>
			<h6>教师编号 </h6>
			<div class="row">
			<div class="col-md-6">
				<input type="text" name="tid" value="${sessionScope.tid}" class="form-control" readonly/> 
			</div></div>
			<h6>上课教室 </h6>
			<div class="row">
			<div class="col-md-6">
				<input type="text" name="classroom" id="classroom" value="${cplan.classroom}" class="form-control" maxlength="8"/> 
			</div></div>
			<span id="couplan" style="color:#ff0000;"></span>
			<h6>学分 </h6>
			<div class="row">
			<div class="col-md-6">
			 <input type="text" name="credits" class="form-control" value="${cplan.credits}" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="1"/>
			 </div></div>
			 <h6>学时</h6>
			 <div class="row">
			 <div class="col-md-6">
			 <input type="text" name="period" class="form-control" value="${cplan.period }" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="2"/> 
			 </div></div>
			 <h6>总人数</h6>
			 <div class="row">
			 <div class="col-md-6">
			 <input type="text" name="totalnum" class="form-control" value="${cplan.totalnum }" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="2"/>
			 </div></div>
					</div>
					<div class="col-md-12" style="margin-top:1rem;"><input type="submit" value="修改" class="btn btn-primary btn-wide login-btn"/>
					</div>
				</div>
			</form>

			</c:forEach>
		</div>
	</div>
</div>				
<script type="text/javascript" src="/ssm_xuanke/utils/scripts/flat-ui.js"></script><script src="/ssm_xuanke/utils/scripts/bganimation.js"></script></body>
</html>