<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<html>
<head>
    <title>消费者-寄送快递</title>
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
            width: 80%;
        }
        .container table {
            border: 1px solid black;
            width: 125%;
            font-size: 12px;
            text-align: center;
            line-height: 30px;
        }
    </style>
    <script src="/webjars/jquery/3.5.1/jquery.js"></script>
</head>
<body>
    <div class="container">
        <form action="/courierSend" method="post">
            <table>
                <tr>
                    <td>物流公司名称</td>
                    <td>
                        <select name="logisticsCompanyName" style="width: 400px">
                            <option value="请选择快递公司" selected disabled>请选择快递公司</option>
                            <option value="某东快递">某东快递</option>
                            <option value="某通快递">某通快递</option>
                            <option value="某达快递">某达快递</option>
                            <option value="某天快递">某天快递</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td><span style="line-height: 30px">寄件人姓名</span></td>
                    <td><input type="text" style="width: 400px;line-height: 24px" name="senderName"></td>
                </tr>
                <tr>
                    <td><span style="line-height: 30px">寄件人手机号码</span></td>
                    <td><input type="text" style="width: 400px;line-height: 24px" name="senderTel"></td>
                </tr>
                <tr>
                    <td><span style="line-height: 30px">收件人姓名</span></td>
                    <td><input type="text" style="width: 400px;line-height: 24px" name="recipientName"></td>
                </tr>
                <tr>
                    <td><span style="line-height: 30px">收件人手机号码</span></td>
                    <td><input type="text" style="width: 400px;line-height: 24px" name="recipientTel"></td>
                </tr>
                <tr>
                    <td><span style="line-height: 30px">收件人地址</span></td>
                    <td><input type="text" style="width: 400px;line-height: 24px" name="recipientAddress"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div>
                            <input type="submit" style="width: 100px; margin-right: 80px" />
                            <input type="reset" style="width: 100px" />
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
