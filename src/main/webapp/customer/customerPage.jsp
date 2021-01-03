<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>物流管理系统-消费者界面</title>
    <style>
        * {
            list-style: none;
            text-decoration: none;
            margin: 0;
            padding: 0;
        }
        .container .customerHeader {
            height: 20%;
            text-align: center;
            font-size: 36px;
            line-height: 140px;
            background: lightsteelblue;
        }
        .container .customerHeader span{
            color: lightcoral;
        }
        .container .customerList {
            float: left;
            width: 20%;
            height: 100%;
            background: lightsteelblue;
            overflow: hidden;
        }
        .container .customerList .menu ul>li {
            display: block;
            text-align: center;
            margin: 40px 20px;
        }
        .container .customerList .menu ul>li span{
            cursor: pointer;
            color: whitesmoke;
        }
        .container .customerContainer {
            float: left;
            position: relative;
            width: 80%;
            height: 100%;
            text-align: center;
            line-height: 250px;
            background: aliceblue;
            overflow: hidden;
        }
        .container .customerContainer span{
            position: absolute;
            left: 10%;
            font-size: 24px;
        }
        .container .customerContainer .searchFrame {
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
        <div class="customerHeader">
            <span>你好，消费者 ${sessionScope.SESSION_USER.userName}!</span>
        </div>

        <script>
            $(document).ready(function (){
                $(".customerList .menu ul>li span.queryItem").click(function (){
                    $(".customerContainer").empty();
                    var searchFrame = "<iframe src='../queryCourier.jsp' class='searchFrame' frameborder='none' />"
                    $(".customerContainer").append(searchFrame);
                });
                $(".customerList .menu ul>li span.sendItem").click(function (){
                    $(".customerContainer").empty();
                    var searchFrame = "<iframe src='sendCourier.jsp' class='searchFrame' frameborder='none' />"
                    $(".customerContainer").append(searchFrame);
                });
            });
        </script>
        <div class="customerList">
            <div class="menu">
                <ul>
                    <li><span class="queryItem">查询快递</span></li>
                    <li><span class="sendItem">寄送快递</span></li>
                    <li><span class="acceptItem">签收快递</span></li>
                    <li><span class="evaluationItem">评价服务</span></li>
                    <li><span class="userItem">管理个人信息</span></li>
                </ul>
            </div>
        </div>

        <div class="customerContainer">
            <span>请在左边选择您的业务请求！</span>
        </div>
    </div>
</body>
</html>
