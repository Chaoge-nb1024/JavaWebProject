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
        // 1������������л�ȡһ�� User ����
        User user = createUser(request);

        // 2��ע���û�
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.userRegister(user);
        userDAO.userRegister(user);

        // 3����Ӧ
        response.setContentType("text/html;charset=UTF-8");
        if (result) {
            response.getWriter().print("ע��ɹ���");
        } else {
            response.getWriter().print("ע��ʧ�ܣ�");
        }
    }

    /**
     * ����������л�ȡ���ݣ���װ��һ�� User ���󲢷���
     * @param request �������
     * @return User����
     */
    private User createUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userTel = request.getParameter("userTel");
        String userIdentity = request.getParameter("userIdentity");
        return new User(userName, userPwd, userTel, Boolean.parseBoolean(userIdentity));
    }
}
