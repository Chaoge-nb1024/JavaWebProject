<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/30
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物流管理系统-登录界面</title>

</head>
<body>
<center>
    <form action="" method="post">
        <table border="1px" cellspacing="0px">
            <caption style="font-family: 微软雅黑; font-size: 24px">登录界面</caption>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userName" placeholder="请输入用户名"/></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;密码</td>
                <td><input type="password" name="userPwd" placeholder="请输入密码"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录">
                    <a href="register.jsp"><input type="button" value="注册"></a>
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
