<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>物理管理系统-物流公司页面</title>
    <style>
        * {
            list-style: none;
            text-decoration: none;
            margin: 0;
            padding: 0;
        }
        .container .logisticsCompanyHeader {
            height: 20%;
            text-align: center;
            font-size: 36px;
            line-height: 140px;
            background: lightsteelblue;
        }
        .container .logisticsCompanyHeader span{
            color: lightcoral;
        }
        .container .logisticsCompanyList {
            float: left;
            width: 20%;
            height: 80%;
            background: lightsteelblue;
            overflow: hidden;
        }
        .container .logisticsCompanyList .menu ul>li {
            display: block;
            text-align: center;
            margin: 40px 20px;
        }
        .container .logisticsCompanyList .menu ul>li span{
            cursor: pointer;
            color: whitesmoke;
        }
        .container .logisticsCompanyContainer {
            float: left;
            position: relative;
            width: 80%;
            height: 80%;
            text-align: center;
            line-height: 250px;
            background: aliceblue;
            overflow: hidden;
        }
        .container .logisticsCompanyContainer span{
            position: absolute;
            left: 10%;
            font-size: 24px;
        }
        .container .logisticsCompanyContainer .searchFrame {
            position: relative;
            margin: 5% auto;
            width: 80%;
            height: 80%;
        }
    </style>

    <script src="${ctx}/webjars/jquery/3.5.1/jquery.js"></script>
</head>
<body>
    <div class="container">
        <div class="logisticsCompanyHeader">
            <span>你好，物流公司 - ${sessionScope.SESSION_USER.userName}!</span>
        </div>

        <script>
            $(document).ready(function (){
                $(".logisticsCompanyList .menu ul>li span.queryItem").click(function (){
                    $(".logisticsCompanyContainer").empty();
                    var searchFrame = "<iframe src='../queryCourier.jsp' class='searchFrame' frameborder='none' />"
                    $(".logisticsCompanyContainer").append(searchFrame);
                });
                $(".logisticsCompanyList .menu ul>li span.addItem").click(function (){
                    $(".logisticsCompanyContainer").empty();
                    var searchFrame = "<iframe src='addCourier.jsp' class='searchFrame' frameborder='none' />"
                    $(".logisticsCompanyContainer").append(searchFrame);
                });
            });
        </script>
        <div class="logisticsCompanyList">
            <div class="menu">
                <ul>
                    <li><span class="queryItem">查询快递</span></li>
                    <li><span class="addItem">新增快递信息</span></li>
                    <li><span class="updateItem">修改快递信息</span></li>
                    <li><span class="userItem">管理个人信息</span></li>
                </ul>
            </div>
        </div>

        <div class="logisticsCompanyContainer">
            <span>请在左边选择您的业务请求！</span>
        </div>
    </div>
</body>
</html>
