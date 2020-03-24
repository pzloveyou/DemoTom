<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>

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

    <style>
        th{
            background-color:#1adeed;
        }
        td{
            background-color:floralwhite;
        }
        tr th,td{
            width: 200px;
            height: 30px;
        }
        select{
            height: 30px;
        }
    </style>
</head>
<body class="form-wrap" style="background-image: url('../images/e9218aec65aadad0fd9e7e7c700d305d.jpg');background-repeat:no-repeat; background-size: 100%;" >

    <form method="post" enctype="multipart/form-data" id="formadd">

      <table border="1px;">
          <tr>
          <th colspan="5" style="background-color: #2fdab8">新增商品</th>
          </tr>
          <tr>
              <th>商品名称：</th>
              <td><input type="text" name="title"></td>

              <td></td>

              <th>适应性：</th>
              <td>
                  <input type="radio" name="men" value="男子">男子
                  <input type="radio" name="men"  value="女子">女子
              </td>
          </tr>

          <tr>
              <th>类型：</th>
              <td>
                  <select name="lx">
                      <option value="板鞋">板鞋</option>
                  </select>
              </td>

              <td></td>

              <th>品牌：</th>
              <td>
                  <select name="pp">
                      <option value="耐克">耐克</option>

                  </select>
              </td>
          </tr>
          <tr>
              <th>市场价：</th>
              <td><input type="text" name="original"></td>

              <td></td>

              <th>鞋库价：</th>
              <td><input type="text" name="price"></td>
          </tr>
          <tr>
              <th>图片：</th>

                            <td colspan="4">
                                <input type="file" name="tp" multiple="multiple">
                               <%-- <div class=" layui-fluid  layui-bg-white">

                                    <fieldset class="layui-elem-field layui-field-title" style="border-style:none">
                                    </fieldset>

                                        <div class="layui-upload">
                                            <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多张图片</button>
                                            <div class="layui-upload-list">
                                                <table class="layui-table">
                                                    <thead>
                                                    <tr><th>图片名</th>
                                                        <th>大小</th>
                                                        <th>状态</th>
                                                        <th>操作</th>
                                                    </tr></thead>
                                                    <tbody id="demoList"></tbody>
                                                </table>
                                            </div>

                                        </div>

                                </div>--%>
                            </td>
             </tr>
          <tr>
              <td colspan="5"><button type="submit" class="layui-btn" id="testListAction"  style="margin-left: 90%" >开始上传</button></td>
          </tr>
      </table>

   </form>

    <script>
        $(function () {
            $("#testListAction").click(function () {
                $.ajax({
                     cache: false,
                     contentType: false,
                    url: "/putaway", //发送请求到后台的地址
                    type: "post",
                    dataType: "text",//返回的数据类型为纯文本字符串
                    data: new FormData(document.getElementById("formadd")), //发送的数据是id="for"的表单中的数据,其中document.getElementById()函数的功能是根据对象的名称获取对象
                    processData: false,//不希望自动转换
                    async: false,//请求设为异步
                    success: function (data) {
                        //发送请求成功执行的函数
                        if (data == "true") {
                            alert("添加成功");
                        } else {
                            alert("添加失败,请确认信息是否正确")
                        }
                    }
                });
        })
            })

    </script>


    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <%--<script>
        layui.use('upload', function(){
            var $ = layui.jquery
                ,upload = layui.upload;
            //多文件列表示例
            var demoListView = $('#demoList')
                ,uploadListIns = upload.render({
                elem: '#testList'
                ,url: '/putaway'
                ,accept: 'file'
                ,multiple: true
                ,auto: false
                ,bindAction: '#testListAction'
                ,choose: function(obj){
                    var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                    //读取本地文件
                    obj.preview(function(index, file, result){
                        var tr = $(['<tr id="upload-'+ index +'">'
                            ,'<td>'+ file.name +'</td>'
                            ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                            ,'<td>等待上传</td>'
                            ,'<td>'
                            ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                            ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                            ,'</td>'
                            ,'</tr>'].join(''));

                        //单个重传
                        tr.find('.demo-reload').on('click', function(){
                            obj.upload(index, file);
                        });

                        //删除
                        tr.find('.demo-delete').on('click', function(){
                            delete files[index]; //删除对应的文件
                            tr.remove();
                            uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                        });

                        demoListView.append(tr);
                    });
                }
                ,done: function(res, index, upload){
                    if(res.code == 0){ //上传成功
                        var tr = demoListView.find('tr#upload-'+ index)
                            ,tds = tr.children();
                        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                        tds.eq(3).html(''); //清空操作
                        return delete this.files[index]; //删除文件队列已经上传成功的文件
                    }
                    this.error(index, upload);
                }
                ,error: function(index, upload){
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                    tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
                }
            });
        });
    </script>&lt;%&ndash;文件上传&ndash;%&gt;--%>
</body>
</html>
