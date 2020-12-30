<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/30
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物流管理系统-注册页面</title>
</head>
<body>
    <center>
        <form action="/register" method="post">
            <table border="1px" cellspacing="0px">
                <caption style="font-family: 微软雅黑; font-size: 24px">注册界面</caption>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="userName" placeholder="请输入用户名"/></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;密码</td>
                    <td><input type="password" name="userPwd" placeholder="请输入密码"/></td>
                </tr>
                <tr>
                    <td>手机号码</td>
                    <td><input type="text" name="userTel" placeholder="请输入手机号码"/></td>
                </tr>
                <tr>
                    <td>用户身份</td>
                    <td>
                        <input type="radio" name="userIdentity" value="true" />消费者
                        <input type="radio" name="userIdentity" value="false" />物流公司
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="确认注册">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
