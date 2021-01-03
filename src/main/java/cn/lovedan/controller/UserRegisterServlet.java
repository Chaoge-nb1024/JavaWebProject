package cn.lovedan.controller;

import cn.lovedan.pojo.User;
import cn.lovedan.service.ConsumerDAO;
import cn.lovedan.service.LogisticsCompanyDAO;
import cn.lovedan.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户注册 Servlet
 */
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1、从请求对象中获取一个 User 对象
        User user = createUser(request);

        // 2、注册用户，添加到 user 表中
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.userRegister(user);
        userDAO.userRegister(user);

        // 3、响应
        response.setContentType("text/html;charset=UTF-8");
        if (result) {
            User currentUser = userDAO.userLogin(user.getUserName(), user.getUserPwd());
            // 4、注册用户，添加到对应的身份表中（consumer/logisticsCompany）
            if (user.getUserIdentity()) {
                // 消费者
                ConsumerDAO customerDAO = new ConsumerDAO();
                customerDAO.consumerRegister(currentUser.getUserId(), "默认名称");
            }
            else {
                // 物流公司
                LogisticsCompanyDAO logisticsCompanyDAO = new LogisticsCompanyDAO();
                logisticsCompanyDAO.logisticsCompanyRegister(currentUser.getUserId(), "默认名称", 1);
            }
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('注册成功！');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('注册失败，用户编号已存在！');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
        }
    }

    /**
     * 从请求对象中获取数据，封装成一个 User 对象并返回
     * @param request 请求对象
     * @return User对象
     */
    private User createUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userTel = request.getParameter("userTel");
        String userIdentity = request.getParameter("userIdentity");
        return new User(userName, userPwd, userTel, Boolean.parseBoolean(userIdentity));
    }
}
