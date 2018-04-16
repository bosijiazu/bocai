<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
// 第一步：动态追加一级分类
	$(function(){
		$.getJSON("json/class_1.js",function(data){
			$(data).each(function(i,json){
				$("#select_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		})
	});
// 第二步：根据一级分类动态追加二级分类
	function class_2_tm_by_class_1_id(class_1_id){
		$("#select_class_2").empty();
		$.getJSON("json/class_2_by_"+class_1_id+".js",function(data){
			$(data).each(function(i,json){
				$("#select_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
			});
		});
		tm_by_class_1_id(class_1_id);
	}
// 第三步：根据一级分类动态追加商标
	function tm_by_class_1_id(class_1_id){
		$("#select_trade_mark").empty();
		$.getJSON("json/tm_by_class_1_"+class_1_id+".js",function(data){
			$(data).each(function(i,json){
				$("#select_trade_mark").append("<option value="+json.id+">"+json.ppmch+"</option>");
			});
		});
	}

//商标选择完后，根据一级分类id、二级分类id、商标id显示所有商品列表
	function get_spu_by_class_1_2_tm_id(){
		var a = $("#select_class_1").val();
		var b = $("#select_class_2").val();
		var c = $("#select_trade_mark").val();
		$.post("select_spu_by_class_1_2_tm_id.do",{"class_1_id":a,"class_2_id":b,"tm_id":c},function(data){
			
		})
	}

// 	点击缩略图，相当于点击隐藏的文件上传
	function index_img_click(index){
		$("#index_file_"+index).click();
	}
// 	每次上传完后，在后面追加一个上传图片，最多追加5次
	function index_img_change(ind){
	    //获得缩略图
		var image = $("#index_file_"+ind)[0].files[0];
		//将缩略图替换掉被点击的图片按钮
		var url = window.URL.createObjectURL(image);
		$("#index_img_"+ind).attr("src",url);
		//获取页面上所有file对象的个数
		var num = $(":file").length;
		//当点击的图片为最后一张图片且数量少于5张时，再追加上传图片（要求最多上传5张图片）
		if(ind<4&&num==(ind+1)){
			//调用追加上传图片方法
			image_append(ind);
		}
	}
	//追加上传图片的方法
	function image_append(ind){
		var a = '<img id="index_img_'+(ind+1)+'" src="image/upload_hover.png" width="70px" style="cursor: pointer;" onclick="index_img_click('+(ind+1)+')">';
		var b = '<input id="index_file_'+(ind+1)+'" style="display:none;" onchange="index_img_change('+(ind+1)+')" type="file" name="files"/>';
		$("#img_div").append(a);
		$("#img_div").append(b);
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品发布页面</title>
</head>
<body>
	<form action="spu_Publish.do" enctype="multipart/form-data" method="post">
		一级分类：<select name="flbh1" id="select_class_1" onchange="javascript:class_2_tm_by_class_1_id(this.value)"><option>--请选择--</option></select><br>
		二级分类：<select name="flbh2" id="select_class_2"></select><br>
		商品：<select name="pp_id" id="select_trade_mark"></select><br>
		
<!-- 		<button id="index_add_spu">添加商品</button>  onchange="javascript:get_spu_by_class_1_2_tm_id()"-->
		
		<hr>
		<div id="index_spu_inner">
			商品名称：<input type="text" name="shp_mch"/><br>
			商品描述：<input type="text" name="shp_msh"/><br>
			<div id="img_div">
				<img id="index_img_0" src="image/upload_hover.png" width="70px" style="cursor: pointer;" onclick="index_img_click(0)">
				<input id="index_file_0" style="display:none;" onchange="index_img_change(0)" type="file" name="files"/>
			</div>
		</div>
		<br>
		<input type="submit" value="发布spu信息"/>
	</form>
</body>
</html>