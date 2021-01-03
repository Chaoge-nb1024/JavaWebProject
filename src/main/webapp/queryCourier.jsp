<%@ page import="net.sf.json.JSON" %>
<%@ page import="cn.lovedan.pojo.LogisticInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.lovedan.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>物流公司-查询快递</title>
    <style>
        * {
            text-decoration: none;
            list-style: none;
            margin: 0;
            padding: 0;
        }
        button {
            cursor: pointer;
        }
        .container {
            position: relative;
            width: 100%;
        }
        .container .header .searchBar {
            float: right;
            width: 300px;
            line-height: 24px;
        }
        .container .header .showButton {
            float: left;
            width: 100px;
            line-height: 24px;
        }
        .container .header .searchButton {
            float: right;
            width: 100px;
            line-height: 24px;
        }
        .container .header .acceptButton {
            float: right;
            width: 100px;
            line-height: 24px;
        }
        .container .result table#generatedTable {
            border: 1px solid black;
            table-layout: fixed;
            width: 100%;
            font-size: 12px;
            text-align: center;
            line-height: 30px;
        }
    </style>
    <script src="/webjars/jquery/3.5.1/jquery.js"></script>

</head>
<body>
    <script>
        $(document).ready(function (){
            var tbody = window.document.getElementById("tbody-result");
            // var tfoot = window.document.getElementById("tfooter")
            // 使用 ajax 和 寄送 局部生成一个表格用来显示查询快递结果，注册【查询快递】按钮上
            $(".container .header .searchButton").click(function (){
                var courierId = $(".searchBar").val();
                $(tbody).empty();
                $.ajax({
                    type : "post",
                    url : "/courierQuery?courierId=" + courierId,
                    success : function (result){
                        result = JSON.parse(result);
                        str = "<tr>" +
                            "<td align='center'>" + result.courierId + "</td>" +
                            "<td align='center'>" + result.userId + "</td>" +
                            "<td align='center'>" + result.logisticsCompanyName + "</td>" +
                            "<td align='center'>" + result.senderName + "</td>" +
                            "<td align='center'>" + result.senderTel + "</td>" +
                            "<td align='center'>" + result.recipientName + "</td>" +
                            "<td align='center'>" + result.recipientTel + "</td>" +
                            "<td align='center'>" + result.recipientAddress + "</td>" +
                            "<td align='center'>" + result.currentAddress + "</td>" +
                            "</tr>";
                        tbody.innerHTML = str;
                    }
                });
            });
            // 使用 ajax 和 json 局部生成一个表格用来显示物流信息，注册到【显示快递信息】按钮上
            $(".container .header .showButton").click(function (){
                $(tbody).empty();
                $.ajax({
                    type : "post",
                    url : "/courierShow",
                    success : function (result){
                        var str = "";
                        result = JSON.parse(result);
                        for (i in result) {
                            str += "<tr>" +
                                "<td align='center'>" + result[i].courierId + "</td>" +
                                "<td align='center' >" + result[i].userId + "</td>" +
                                "<td align='center'>" + result[i].logisticsCompanyName + "</td>" +
                                "<td align='center'>" + result[i].senderName + "</td>" +
                                "<td align='center'>" + result[i].senderTel + "</td>" +
                                "<td align='center'>" + result[i].recipientName + "</td>" +
                                "<td align='center'>" + result[i].recipientTel + "</td>" +
                                "<td align='center'>" + result[i].recipientAddress + "</td>" +
                                "<td align='center'>" + result[i].currentAddress + "</td>" +
                                "</tr>";
                        }
                        tbody.innerHTML = str;
                    }
                });
            });
            // 【签收快递】
            $(".container .header .acceptButton").click(function () {
                $(tbody).empty();
                var courierId = $(".searchBar").val();
                $.ajax({
                    type : "get",
                    url : "/courierAccept?courierId=" + courierId,
                    success : function (result){
                        var str = "";
                        result = JSON.parse(result);
                        for (i in result) {
                            str += "<tr>" +
                                "<td align='center'>" + result[i].courierId + "</td>" +
                                "<td align='center'>" + result[i].userId + "</td>" +
                                "<td align='center'>" + result[i].logisticsCompanyName + "</td>" +
                                "<td align='center'>" + result[i].senderName + "</td>" +
                                "<td align='center'>" + result[i].senderTel + "</td>" +
                                "<td align='center'>" + result[i].recipientName + "</td>" +
                                "<td align='center'>" + result[i].recipientTel + "</td>" +
                                "<td align='center'>" + result[i].recipientAddress + "</td>" +
                                "<td align='center'>" + result[i].currentAddress + "</td>" +
                                "</tr>";
                        }
                        tbody.innerHTML = str;
                    }
                });
            });
        });
    </script>
    <div class="container">
        <div class="header">
            <button class="showButton">显示快递</button>
            <button class="acceptButton">
                <c:choose>
                    <c:when test="${sessionScope.SESSION_USER.userIdentity == true}">签收快递</c:when>
                    <c:when test="${sessionScope.SESSION_USER.userIdentity == false}">删除快递</c:when>
                </c:choose>
            </button>
            <button class="searchButton">查询快递</button>
            <input type="text" class="searchBar" placeholder="请输入快递单号..." />
        </div>
        <p style="clear: left"></p>
        <div class="result">
            <table id="generatedTable" rules="all">
                <thead>
                    <tr>
                        <td>快递单号</td>
                        <td>用户编号</td>
                        <td>快递公司</td>
                        <td>寄件人姓名</td>
                        <td>寄件人手机号码</td>
                        <td>收件人姓名</td>
                        <td>收件人手机号码</td>
                        <td>收件人地址</td>
                        <td>快递当前所在地点</td>
                    </tr>
                </thead>
                <tbody id="tbody-result">

                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
