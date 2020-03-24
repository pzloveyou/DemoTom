$(document).click(function(){
	if($("#PowerTabDiv").is(":visible")){
		PowerTabDiv_hide()
	}
})

//存放选中的选项内容
$("#PowerValue").click(function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	if($("#PowerTabDiv").is(":visible")){
		PowerTabDiv_hide()
	}
	else{
		PowerTabDiv_Show(0)}
})

//点项已选中的项，显示对应项的选项卡及内容【动态加载】
$("#SelectedValue").on("click","a",function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	//通过获取点击已选中项的下标，显示对应的选项卡和内容
	PowerTabDiv_Show($(this).index())
})


//============弹出的 选项卡function

//在选项卡内点击时，防止触发document点击事件，导致隐蔽选项卡
$("#PowerTabDiv").click(function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
})


//在选项卡中添加新选项



//弹出的选项卡
$("#Tab-tag a").click(function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	//修改点击的选项样式，恢复其他选项的默认样式
	$(this).addClass("Selected").siblings().removeClass("Selected");
	//通过获取点击选项的下标，显示对应的内容，其他内容隐蔽
	$("#PowerTabDiv .Tab-Content").eq($(this).index()).show().siblings("#PowerTabDiv .Tab-Content").hide()
})


//点击选项卡中的选项（元素）
$(".Tab-Content").on("click","li",function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	
	//获取当前选项卡的序号
	var TabIndex=$(this).parent().parent().index(".Tab-Content")
	//选中的项添加样式，其他项删除样式
	$(this).addClass("Selected").siblings().removeClass("Selected")
	
	//调用显示函数
	SelectValue(TabIndex)
})

//添加内容实现搜索，当文本框输入内容时触发
$(".Tab-Content").on("input propertychange","input",function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	
	//获取当前输入框所在选项卡的索引
	var TabIndex=$(this).parent().parent().index(".Tab-Content"); 
	
	//获取当前选项卡的值、输入框的内容
	var TabContentHtml= $(".Tab-Content").eq(TabIndex).find("ul").html();
	var KeyWord=$(this).val()

	//如果关键词大于1个字符，则添加分隔符“|”
	var NewKeyWord='';
	if(KeyWord.length>1){
		for(var i=0; i<KeyWord.length; i++){
			NewKeyWord=NewKeyWord+KeyWord.substr(i,1)+'|'
		}}
	else{
		NewKeyWord=KeyWord}
	
	//删除已经标记搜索结果的标签
	TabContentHtml=TabContentHtml.replace(/<b>/g,"");
	TabContentHtml=TabContentHtml.replace(/<\/b>/g,"");
	
	//正则搜索标签内与关键词匹配的内容，得出的结果添加标签
	var reg=new RegExp("(?!<[^>]*)(" + NewKeyWord + ")(?![^<]*>)","gm");
	$(".Tab-Content").eq(TabIndex).find("ul").html(TabContentHtml.replace(reg,'<b>$1</b>'));
	
})

//
$(".Tab-Content p").on("click","a",function(e){
	e.stopPropagation();//防止点击冒泡，触发父框的Click
	
	//获取当前选项卡的序号
	var TabIndex=$(this).parent().parent().index(".Tab-Content")
	var AddSelectValue=$(".Tab-Content").eq(TabIndex).find(".AddSelect input").val()
	
	//在列表<ul>最后，添加待添加的项
	if($.trim(AddSelectValue)!=''){
		//清除已选中的选项
		$(".Tab-Content").eq(TabIndex).find("ul li").removeClass("Selected")
		
		if($(".Tab-Content").eq(TabIndex).find(".add").length>0){
			$(".Tab-Content").eq(TabIndex).find("ul .add").html(AddSelectValue);
			$(".Tab-Content").eq(TabIndex).find("ul .add").attr("value",AddSelectValue);
			$(".Tab-Content").eq(TabIndex).find("ul .add").addClass("Selected")}
		else{
		$(".Tab-Content").eq(TabIndex).find("ul").append('<li class="Selected add" value="'+AddSelectValue+'">' + AddSelectValue + '</li>')}
		
		$(this).html("更改")
	}
	
	//调用显示函数
	SelectValue(TabIndex)
	
})

function PowerTabDiv_hide(){
	$("#PowerTabDiv").hide();
	$("#PowerValue b").removeClass("open");
}

function PowerTabDiv_Show(index){
		//框弹出选项卡
	$("#PowerTabDiv").show();
	$("#PowerValue b").addClass("open");
	
	//将选项卡设置为默认弹出状态（1.第一个选项卡为选中状态、2.显示第一个选项卡的内容）
	$("#PowerTabDiv a").eq(index).addClass("Selected").siblings("#PowerTabDiv a").removeClass("Selected");
	$("#PowerTabDiv .Tab-Content").eq(index).show().siblings("#PowerTabDiv .Tab-Content").hide()
}

//显示选择的项，index为当前点击元素所在选项卡中的索引
function SelectValue(index){
	
	var TabIndex=index;
	
	//获取可供选择的选项卡数量
	var TabCount=$(".Tab-Content").length
	
	//判断前方的选项卡，是否已经有选择，如没有选择不执行下方的代码
	if(TabIndex>0){
		if($(".Tab-Content").eq(TabIndex-1).find(".Selected").length<=0){
			$(".Tab-Content").eq(TabIndex).find("li").removeClass("Selected");
			alert("请先选择“"+$("#Tab-tag a").eq(TabIndex-1).html()+"”的选项")
			PowerTabDiv_Show(TabIndex-1)
			return false;
		}
	}
			
	//只显示当前选项及前面的选项卡内容
	$("#SelectedValue").html("")//清空已显示的内容	
	for(var i=0; i<=TabIndex;i++){
		if(i>0){$("#SelectedValue").append("/")}
		//已添加了.Selected样式的，为已选中的，则显示出来
		$("#SelectedValue").append("<a href='JavaScript:;'>"+$(".Tab-Content").eq(i).find(".Selected").attr("value")+"</a>")
	}
	
	//将当前选项卡以后的选项卡内容恢复默认，
	for(var i=TabIndex+1;i<=TabCount-1;i++){
		$(".Tab-Content").eq(i).find("ul li").remove("li");//将所有选项删除
		$(".Tab-Content").eq(i).find(".AddSelect a").html("添加");//恢复添加选项按钮
		$(".Tab-Content").eq(i).find(".AddSelect input").val("");//清空输入框
		$(".Tab-Content").eq(i).find("ul li").remove(".add");//移除已添加的选项
	}
	
	//建立后一个选项卡的内容(***********************************【可在此处添加联动代码】*********************************************)
	for(var i=1; i<=50; i++){
		$(".Tab-Content").eq(TabIndex+1).find("ul .clearfix").before('<li value="分类'+(TabIndex+2)+'-'+i+'">分类'+(TabIndex+2)+'-'+i+'</li>')
	}	
		
	//选择完后，跳转到下一个选项卡，最后一个不跳转
	if(TabIndex+1<TabCount){
		PowerTabDiv_Show(TabIndex+1)}
	
	//如果当时选项卡是最后一个，选择完后关闭整个选项卡
	if(TabIndex+1==TabCount){
		PowerTabDiv_hide()}
}