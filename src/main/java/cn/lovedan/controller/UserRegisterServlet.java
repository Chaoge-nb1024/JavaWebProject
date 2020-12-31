package cn.lovedan.controller;

import cn.lovedan.pojo.User;
import cn.lovedan.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1、从请求对象中获取一个 User 对象
        User user = createUser(request);

        // 2、注册用户
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.userRegister(user);
        userDAO.userRegister(user);

        // 3、响应
        response.setContentType("text/html;charset=UTF-8");
        if (result) {
            response.getWriter().print("注册成功！");
        } else {
            response.getWriter().print("注册失败！");
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
