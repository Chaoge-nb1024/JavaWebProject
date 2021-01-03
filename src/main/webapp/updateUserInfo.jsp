<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户个人管理界面</title>
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
                <td></td>
                <td></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
