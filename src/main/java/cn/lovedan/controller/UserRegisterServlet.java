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
 * �û�ע�� Servlet
 */
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1������������л�ȡһ�� User ����
        User user = createUser(request);

        // 2��ע���û�����ӵ� user ����
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.userRegister(user);
        userDAO.userRegister(user);

        // 3����Ӧ
        response.setContentType("text/html;charset=UTF-8");
        if (result) {
            User currentUser = userDAO.userLogin(user.getUserName(), user.getUserPwd());
            // 4��ע���û�����ӵ���Ӧ����ݱ��У�consumer/logisticsCompany��
            if (user.getUserIdentity()) {
                // ������
                ConsumerDAO customerDAO = new ConsumerDAO();
                customerDAO.consumerRegister(currentUser.getUserId(), "Ĭ������");
            }
            else {
                // ������˾
                LogisticsCompanyDAO logisticsCompanyDAO = new LogisticsCompanyDAO();
                logisticsCompanyDAO.logisticsCompanyRegister(currentUser.getUserId(), "Ĭ������", 1);
            }
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('ע��ɹ���');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('ע��ʧ�ܣ��û�����Ѵ��ڣ�');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
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
