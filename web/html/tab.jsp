<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body class="form-wrap" >


  <div class="layui-fluid" id="component-tabs">
    <div class="layui-row">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">默认风格</div>
          <div class="layui-card-body">
            <div class="layui-tab">
              <ul class="layui-tab-title">
                <li class="layui-this">网站设置</li>
                <li>用户管理</li>
                <li>权限分配</li>
                <li>商品管理</li>
                <li>订单管理</li>
              </ul>
              <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                  1. 高度默认自适应，也可以随意固宽。
                  <br>2. Tab进行了响应式处理，所以无需担心数量多少。
                </div>
                <div class="layui-tab-item">内容2</div>
                <div class="layui-tab-item">内容3</div>
                <div class="layui-tab-item">内容4</div>
                <div class="layui-tab-item">内容5</div>
              </div>
            </div>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-header">简洁风格</div>
          <div class="layui-card-body">
            <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-brief">
              <ul class="layui-tab-title">
                <li class="layui-this">网站设置</li>
                <li>用户管理</li>
                <li>权限分配</li>
                <li>商品管理</li>
                <li>订单管理</li>
              </ul>
              <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                  你也可以监听 tab 事件
                </div>
                <div class="layui-tab-item">内容2</div>
                <div class="layui-tab-item">内容3</div>
                <div class="layui-tab-item">内容4</div>
                <div class="layui-tab-item">内容5</div>
              </div>
            </div>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-header">卡片风格</div>
          <div class="layui-card-body">
            <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
              <li class="layui-this">网站设置</li>
              <li>用户管理</li>
              <li>权限分配</li>
              <li>商品管理</li>
              <li>订单管理</li>
            </ul>
            <div class="layui-tab-content">
              <div class="layui-tab-item layui-show">默认宽度是相对于父元素100%适应的，你也可以固定宽度。</div>
              <div class="layui-tab-item">2</div>
              <div class="layui-tab-item">3</div>
              <div class="layui-tab-item">4</div>
              <div class="layui-tab-item">5</div>
              <div class="layui-tab-item">6</div>
            </div>
          </div>
        </div>
      </div>
     </div>
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-header">动态操作</div>
        <div class="layui-card-body">
          <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
              <li class="layui-this" lay-id="11">网站设置<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
              <li lay-id="22">用户管理<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
              <li lay-id="33">权限分配<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
              <li lay-id="44">商品管理<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
              <li lay-id="55">订单管理<i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
            </ul>
            <div class="layui-tab-content">
              <div class="layui-tab-item layui-show">内容1</div>
              <div class="layui-tab-item">内容2</div>
              <div class="layui-tab-item">内容3</div>
            </div>
          </div>
          <div class="layui-btn-container">
            <button class="layui-btn site-demo-active" data-type="tabAdd">新增一个项</button>
            <button class="layui-btn site-demo-active" data-type="tabDelete">删除：用户管理</button>
            <button class="layui-btn site-demo-active" data-type="tabChange">切换到：权限分配</button>
          </div>
        </div>
      </div>
      <div class="layui-card">
        <div class="layui-card-header">记录状态</div>
        <div class="layui-card-body">
          <div class="layui-tab layui-tab-brief" lay-filter="component-tabs-hash">
            <ul class="layui-tab-title">
              <li class="layui-this" lay-id="11">网站设置</li>
              <li lay-id="22">用户管理</li>
              <li lay-id="33">权限分配</li>
              <li lay-id="44">商品管理</li>
              <li lay-id="55">订单管理</li>
            </ul>
            <div class="layui-tab-content" style="height: 165px;">
              <div class="layui-tab-item layui-show">
                点击该Tab的任一标题，观察地址栏变化，再刷新页面。选项卡将会自动定位到上一次切换的项
              </div>
              <div class="layui-tab-item">内容2</div>
              <div class="layui-tab-item">内容3</div>
              <div class="layui-tab-item">内容4</div>
              <div class="layui-tab-item">内容5</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  
  <script>
  layui.config({
    base: '../../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,router = layui.router();

    element.render();
    
    element.on('tab(component-tabs-brief)', function(obj){
      layer.msg(obj.index + '：' + this.innerHTML);
    });
    
    /* 触发事件 */
    var active = {
      tabAdd: function(){
        /* 新增一个Tab项 */
        element.tabAdd('demo', {
          title: '新选项'+ (Math.random()*1000|0) /* 用于演示 */
          ,content: '内容'+ (Math.random()*1000|0)
          ,id: new Date().getTime() /* 实际使用一般是规定好的id，这里以时间戳模拟下 */
        })
      }
      ,tabDelete: function(othis){
        /* 删除指定Tab项 */
        element.tabDelete('demo', '22');
        othis.addClass('layui-btn-disabled');
      }
      ,tabChange: function(){
        /* 切换到指定Tab项 */
        element.tabChange('demo', '33');
      }
    };
    
    $('#component-tabs .site-demo-active').on('click', function(){
      var othis = $(this), type = othis.data('type');
      active[type] ? active[type].call(this, othis) : '';
    });
    
    /* Hash地址的定位 */
    var layid = router.hash.replace(/^#layid=/, '');
    layid && element.tabChange('component-tabs-hash', layid);
    
    element.on('tab(component-tabs-hash)', function(elem){
      location.hash = '/'+ layui.router().path.join('/') + '#layid=' + $(this).attr('lay-id');
    });
  });
  </script>


</div><style id="LAY_layadmin_theme">.layui-side-menu,.layadmin-pagetabs .layui-tab-title li:after,.layadmin-pagetabs .layui-tab-title li.layui-this:after,.layui-layer-admin .layui-layer-title,.layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child{background-color:#20222A !important;}.layui-nav-tree .layui-this,.layui-nav-tree .layui-this>a,.layui-nav-tree .layui-nav-child dd.layui-this,.layui-nav-tree .layui-nav-child dd.layui-this a{background-color:#009688 !important;}.layui-layout-admin .layui-logo{background-color:#20222A !important;}</style></body>


</html>