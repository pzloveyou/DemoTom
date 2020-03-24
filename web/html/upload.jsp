<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
</head>
<body class="form-wrap" style="background-image: url('../images/e9218aec65aadad0fd9e7e7c700d305d.jpg');background-repeat:no-repeat; background-size: 100%;" >
<div class="x-nav" style="margin-top: -15px; ">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <table>
                <tr>
                    <th>商品编码：</th>
                    <td><input type="text" name="userId"  placeholder="请输入商品编码" autocomplete="off" class="layui-input"></td>
                    <th>标题：</th>
                    <td><input type="text" name="userTitle"  placeholder="请输入商品标题" autocomplete="off" class="layui-input"></td>
                    <th>品牌：</th>
                    <td><input type="text" name="userBrand"  placeholder="请输入商品品牌" autocomplete="off" class="layui-input"></td>
                    <th>类型：</th>
                    <td><input type="text" name="userClass"  placeholder="请输入商品类型" autocomplete="off" class="layui-input"></td>
                    <th>价格：</th>
                    <td><input type="text" name="userPrice"  autocomplete="off" class="layui-input">——<input type="text" name="userPrice2"  autocomplete="off" class="layui-input"></td>
                    <td> <button class="layui-btn select" type="button"  <%--lay-submit="" lay-filter="sreach"--%>><i class="layui-icon">&#xe615;</i></button></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span class="userId" style="font-size: 15px;color: red;display: none">必须是数字</span></td>
                    <td></td>
                    <td ><span class="userTitle" style="font-size: 15px;color: red;display: none">必须是文本</span></td>
                    <td></td>
                    <td ><span class="userBrand" style="font-size: 15px;color: red;display: none">必须是文本</span></td>
                    <td></td>
                    <td><span  class="userClass" style="font-size: 15px;color: red;display: none">必须是文本</span></td>
                    <td></td>
                    <td><span class="userPrice" style="font-size: 15px;color: red;display: none">必须是数字</span></td>
                </tr>
            </table>
        </form>
    </div>
</div>
            <script type="text/javascript">
                $(function () {
                    $(".select").click(function () {
                        var id=$("input[name=userId]").val();
                        var userTitle=$("input[name=userTitle]").val();
                        var userBrand=$("input[name=userBrand]").val();
                        var userClass=$("input[name=userClass]").val();
                        var userPrice=$("input[name=userPrice]").val();
                        var userPrice2=$("input[name=userPrice2]").val();
                        var bobo="true";
                        if (id!=""){
                        if (isNaN(id)){
                            $(".userId").fadeIn(600);
                            $(".userId").fadeOut(6000);
                            bobo="false"
                        }
                        }
                        if (userTitle!="") {
                            if (isNaN(userTitle) == false) {
                                $(".userTitle").fadeIn(600);
                                $(".userTitle").fadeOut(6000);
                                bobo = "false"
                            }
                        }
                        if (userBrand!="") {
                            if (isNaN(userBrand) == false) {
                                $(".userBrand").fadeIn(600);
                                $(".userBrand").fadeOut(6000);
                                bobo = "false"
                            }
                        }
                        if (userClass!="") {
                            if (isNaN(userClass) == false) {
                                $(".userClass").fadeIn(600);
                                $(".userClass").fadeOut(6000);
                                bobo = "false"
                            }
                        }
                        if (userPrice!=""&&userPrice2!="") {
                            if (isNaN(userPrice) || isNaN(userPrice2)) {
                                $(".userPrice").fadeIn(600);
                                $(".userPrice").fadeOut(6000);
                                bobo = "false"
                            }
                        }
                if (bobo=="true"){
                    location.href="selectPutaway?id="+id+"&title="+userTitle+"&brand="+userBrand+"&classify="+userClass+"&price="+userPrice+"&price2="+userPrice2;
                }


                    })
                    
                })
            </script>
<xblock>
    <button class="layui-btn layui-btn-danger"><i class="layui-icon"></i>批量删除</button>
    <button class="layui-btn"><i class="layui-icon"></i>添加</button>
    <button class="layui-btn"><i class="layui-icon"></i>上架</button>
    <button class="layui-btn"><i class="layui-icon"></i>下架</button>
    <span class="x-right" style="line-height:40px">共有数据：${list.size()} 条</span>
</xblock>
<table class="layui-table">
    <thead>
    <tr>
        <th>
            <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
        </th>
        <th>商品id</th>
        <th>商品标题</th>
        <th>类型</th>
        <th>品牌</th>
        <th>价格</th>
        <th>库存</th>
        <th>状态</th>
        <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list" begin="0" end="${list.size()}" varStatus="status">
    <tr>
        <td>
            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
        </td>
        <td>${list.id}</td>
        <td>${list.title}</td>
        <td>${listBrand.get(status.index)}</td>
        <td>${listClassify.get(status.index)}</td>
        <td>${list.price}</td>
        <td><span class="count">${listCount.get(status.index)}</span><span style="color: red;display: none">(需补货)</span></td>
        <td class="td-status">
            <span class="layui-btn layui-btn-normal layui-btn-mini status">已上架</span></td>
        <td class="td-manage">
            <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                <i class="layui-icon">&#xe601;</i>
            </a>
            <a title="编辑"  onclick="x_admin_show('编辑','admin-edit.html')" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
            </a>
            <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
            </a>
        </td>
    </tr>
        <script>
            $(function () {
                var count=${listCount.get(status.index)};
                if (count<50){
                    $(".count:eq(${status.index})").css("color","red");
                    $(".count:eq(${status.index})").next().show();
                }
                var status=${list.status};
                if (status==0){
                    $(".status:eq(${status.index})").html("待上架");
                    $(".status:eq(${status.index})").attr("class","layui-btn layui-btn-mini status")
                } else if (status==1){
                    $(".status:eq(${status.index})").html("已上架");//layui-btn-danger
                    $(".status:eq(${status.index})").attr("class","layui-btn layui-btn-danger layui-btn-mini status")
                } else if(status==2){
                    $(".status:eq(${status.index})").html("已下架");
                    $(".status:eq(${status.index})").attr("class","layui-btn layui-btn-normal  layui-btn-mini status")
                }

            })
        </script>
    </c:forEach>
    </tbody>
</table>
<div class="page">
    <div>
        <a class="prev" href="">&lt;&lt;</a>
        <span class="num" href="">1</span>
        <a class="current">2</a>
        <a class="num" href="">3</a>
        <a class="num" href="">489</a>
        <a class="next" href="">&gt;&gt;</a>
    </div>
</div>
</div>
<%--<table style="margin-left:60px;margin-top: 2%;border: 3px mistyrose solid;">
  <tr><td colspan="7"style="border-bottom: 1px mistyrose solid;background-color: mistyrose;width:1550px ;"><h1>商品列表</h1></td></tr>
  <tr>
    <td colspan="7"style="border-bottom: #A9A9A9;border-bottom: 1px #A9A9A9 solid;width:1550px ;"><button>新增</button><button>编制</button><button>删除</button><button>上架</button><button>下架</button></td>
  </tr>
  <tr>
    <td><input type="checkbox" class="che" name="che"></td>
    <td>商品id</td>
    <td>商品标题</td>
    <td>类型</td>
    <td>品牌</td>
    <td>价格</td>
    <td>库存</td>
    <td>状态</td>
  </tr>
  <tr>
    <td><input type="checkbox"  name="che"></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
</table>--%>

</body>
</html>
