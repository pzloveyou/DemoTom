<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet" href="css/sc.css" />
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <script type="text/javascript" src="js/sc.js" ></script>

</head>

<body>
<div class="upload-div" id="uploadImageDiv">
    <ul class="upload-ul" id="uploadUL">
        <!--默认的点击窗口在添加了图片之后，循环在这个前面insert图片的li-->
        <li class="upload-li" id="uploadBtn">
            <form class="img-input-form" enctype="multipart/form-data" style="opacity: 0;">
                <input type="file" accept="image/*" capture="camera" multiple onchange="uploadSingleFile(this)" id="upload">
            </form>
            <div class="item">
                <span class="iconfont icon-jiahao item_span"></span>
                <span class="item_span">上传</span>
            </div>
        </li>
    </ul>
</div>


</body>

</html>
