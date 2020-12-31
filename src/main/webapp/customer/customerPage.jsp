<%@ page import="cn.lovedan.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
        .container .customerList .menu ul>li a{
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

    </style>

    <%
        User customer = (User)request.getSession().getAttribute("SESSION_USER");
    %>
</head>
<body>
    <div class="container">
        <div class="customerHeader">
            <span>你好，消费者<%= customer.getUserName()%>！</span>
        </div>

        <div class="customerList">
            <div class="menu">
                <ul>
                    <li><a href="javascript:;">查询快递</a></li>
                    <li><a href="javascript:;" >寄送快递</a></li>
                    <li><a href="javascript:;">签收快递</a></li>
                    <li><a href="javascript:;" >评价服务</a></li>
                    <li><a href="javascript:;">管理个人信息</a></li>
                </ul>
            </div>
        </div>

        <div class="customerContainer">
            <span>请在左边选择您的业务请求！</span>
        </div>
    </div>
</body>
</html>
