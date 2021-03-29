<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="util" uri="functions"%>
<%@ taglib prefix="shiro" uri="http://www.springside.org.cn/tags/shiro"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>司机管理</title>
<script type="text/javascript">
$(function(){
	activeNav2("3","3_2");
	$("#sortcreateTime").click(function(){
		var id=$(this).data('id');
		if(id == 1){
			$("#ipt_sortName").val("orderTime");
			$("#ipt_sortType").val("asc");
			requestLoad();
		}else{
			$("#ipt_sortName").val("orderTime");
			$("#ipt_sortType").val("desc");
			requestLoad();
		}
	});
	$("#btn_search").click(function(){
		var searchName =$("#selectorder").val();
		var searchValue =$("#ipt_searchValue1").val();
		$("#ipt_searchName").val(searchName);
		$("#ipt_searchValue").val(searchValue);
		requestLoad();
	})
	$("#btn_excel").click(function(){
		window.open("${ctx}/admin/orderform/pc/export;JSESSIONID=<%=request.getSession().getId()%>?"
				+ "userType=${userType}&status=${status}&billType=${billType}&type=${type}"
				+ "&sortName=${sortName}&sortType=${sortType}&searchName=${searchName}&searchValue=${searchValue}");
	})
});
function changeValue(object){
	var $this = $(object);
	var type = $this.data("type");
	var value = $this.data("value");
	if(type== 'ordersStatus'){
		$(".orderstatus").removeClass('e_class');
		$this.addClass('e_class');
		$("#ipt_status").val(value);
		requestLoad();
	}
}
function requestLoad(){
	$("#request_form").submit();
}
</script>
</head>
<body>
	<form id = "request_form" action ="${ctx}/admin/driver/list">
		<input type ="hidden" id ="ipt_status" value ="${status}" name = "status"/>
		<input type ="hidden" id ="ipt_sortName" value ="${sortName }" name = "sortName"/>
		<input type ="hidden" id = "ipt_sortType" value = "${sortType}" name = "sortType"/>
		<input type ="hidden" id = "ipt_searchName" value = "${searchName }" name = "searchName"/>
		<input type ="hidden" id = "ipt_searchValue" value = "${searchValue }" name = "searchValue"/>
		<input type = "hidden" id ="ipt_page" name = "page"/>
		<%-- <input type = "hidden" id ="ipt_isMain" name = "${isMain }"/> --%>
	</form>
	<div class="row border-bottom">
		<div class="basic">
	   		<p>司机管理</p>
	        <span><a href="${ctx }/admin/main;JSESSIONID=<%=request.getSession().getId()%>"  style="margin-left:0;">首页</a>><a href="#" >司机管理</a>><a><strong>评价列表</strong></a></span>
	    </div>
    </div>

        <div class="username-text animated fadeInRight">
                    	<div class="row">
			<div class="col-lg-12">
				<div class="ibox float-e-margins">

						<div class="table-responsive">
        <div class="level">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class ="table table-striped">
             <tbody>
            	 <tr>
                 	<td class="l_width">
                   <!--  <input type="checkbox" class="l_in"> -->
                    </td>
                    <td><strong>乘客姓名</strong></td>
					 <td><strong>起点</strong></td>
					 <td><strong>终点</strong></td>
                    <td><strong>评价</strong></td>
					 <td><strong>星级</strong></td>
                    <td><strong>评价时间</strong></td>
                 </tr>
                 <c:forEach items = "${tbEvaluates.content }" var ="tbEvaluates">
                 	<tr>
                 		<td></td>
	                    <td>${tbEvaluates.tbPassenger.userName }</td>
						<td>${tbEvaluates.tbOrder.orderStartAddress }</td>
						<td>${tbEvaluates.tbOrder.orderEndAddress }</td>
						<td>${tbEvaluates.orderEvaluate }</td>
						<td class="l_ls">${tbEvaluates.orderStar }星</td>
						<td>${util:formatNormalDate(tbEvaluates.createTime) }</td>
                 	</tr>
                 </c:forEach>

                 </tbody>
                 </table>
			<div class=" m_right">
				<tags:pagination paginationSize="10" page="${tbEvaluates}" hrefPrefix="${ctx }/admin/driver/toDriverEvalute/${driverId}" hrefSubfix="${queryStr}"></tags:pagination>
			</div>
        </div>
        </div>
        </div>
        </div>
        </div>
    </div> 

</body>
</html>