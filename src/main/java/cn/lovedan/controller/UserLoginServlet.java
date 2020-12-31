package cn.lovedan.controller;

import cn.lovedan.pojo.User;
import cn.lovedan.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1、从请求对象中获取登录用户的用户名和用户密码
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        // 2、登录用户
        UserDAO userDAO = new UserDAO();
        User resultUser = userDAO.userLogin(userName, userPwd);

        // 3、若查询得到一个 User 对象，则登录成功，重定向至首页 customerPage.jsp
        response.setContentType("text/html;charset=UTF-8");
        if (resultUser != null) {
            // 3.1、将【登录的用户】 保存到 session 中去
            request.getSession().setAttribute("SESSION_USER", resultUser);
            if (resultUser.getUserIdentity() == true) {
                response.sendRedirect("customer/customerPage.jsp");
            }
            else {
                response.sendRedirect("logisticsCompany/logisticsCompanyPage.jsp");
            }
        } else {
            // 3.2、若查询得到一个 null，则登录失败，请求转发至登录界面 login.html
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户名或密码错误！');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
        }
    }
}
