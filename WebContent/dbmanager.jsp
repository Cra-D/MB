<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.Math"%>
<%@ page import=" bean.Table"%>
<%@ page import=" bean.Data"%>
<%@ page import=" dao.DBOper"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DB Manager</title>
<script src="js_jquery/dbmanage.js" charset="UTF-8"></script>
<script src="js_jquery/stulist.js" charset="UTF-8"></script>
<link rel="stylesheet" href="css/stulist.css">
</head>
<body>
<center style=" background-color: #FFE4B5;">
	<div style="width:60%; margin-top:200px;  background-color: #FFE4B5;">
	<form method="POST" name="Excute" action="ExcuteSQLServlet">
<div align="left" style="position: relative ">

<input type="button" value="Run" onclick="runSQL()"></input>
<input type="button" value="Clean"></input>
<input type="button" value="Cancel"></input>
</div>
 
</br>
<textarea rows="10" style="  width: 100%;  overflow: auto;  word-break: break-all; " name="SQLArea"></textarea>
</form>
</div>
 
<div id="container">
    <div id="title">
        <ul>
            <li id="tag1"><a href="#" onclick="switchTag('tag1','content1');this.blur();" class="selectli1"><span
                    class="selectspan1">结果</span></a></li>
            <li id="tag2"><a href="#" onclick="switchTag('tag2','content2');this.blur();"><span>信息</span></a></li>
            <li id="tag3"><a href="#" onclick="switchTag('tag3','content3');this.blur();"><span>状态</span></a></li>
            <li id="tag4"><a href="#" onclick="switchTag('tag4','content4');this.blur();"><span>数据量</span></a></li>
            
        </ul>
    </div>
    <div id="content" class="content1">
        <div id="content1" >
 
<c:if test="${dataCount!=null}">
	<table border="0" align="center" cellspacing="0" class="list_table"
		id="senfe" style='width: 90%'>
		<thead>
		
				
						
		
				<tr align="center">
					<c:forEach var="columns" items="${columnList}">
						<th>${columns}</th>
						</c:forEach>
						</tr>
	 
		</thead>
		
		<tbody>
			<form method="post" name="DelUp" action="getStudent_extend">
  				<c:forEach var="data" items="${dataList}">  
					<tr align="center">
					
					
					  <c:set value="${data.objectlist }" var="subItem"/>
		    <c:forEach items="${subItem }" var="var">
		    	<td>${var}</td>
		    	
		    </c:forEach>
<td><input type="submit" name="" value="delete"
							onclick="del(this)"></td>
						<td><input type="button" name="" value="edit"
							onclick="updata(this)"></td>
					
					</tr>
 				</c:forEach>  
				
				 
					
				<input type="hidden" name="flag_delUp"> <input type="hidden"
					name="parameter_del">
			</form>
		</tbody>
		
		
	</table>
	<div id="pageCount" style="width:600px;margin-left:auto;margin-right:auto;">
		
			<br /> 
			<c:out value="${dataCount}"></c:out>条记录 
			共<fmt:formatNumber type="number" value="${(dataCount-((dataCount-1)%10))/10+1}" maxFractionDigits="0"/>页
			,当前为第<c:out value="${currentPage}"></c:out>页
		
	 
	</c:if>
	</div></div>
        <div id="content2" class="hidecontent">2、不同的项目使用不同的颜色来区分</div>
        <div id="content3" class="hidecontent">3、这回需要使用到js了，呵呵</div>
        <div id="content4" class="hidecontent">4、背景图片只需要两个图片文件就足够，减少服务器负担</div>
     
    </div>
</div>
</center>

</body>
</html>