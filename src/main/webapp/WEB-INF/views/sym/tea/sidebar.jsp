<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<ul>
	<li><a id="sidebar-home" class="active" href="#">교강사 홈</a></li>
	<li><a id="tea-data-mgt" href="#">성적관리</a></li>
	<li><a href="#">Contact</a></li>
	<li><a href="#">About</a></li>
</ul>
<script>
$('#tea-data-mgt').click(function(e){
	e.preventDefault()
	location.href=`${ctx}/tea/grd_mgt`
})
</script>