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
        // 1������������л�ȡ��¼�û����û������û�����
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        // 2����¼�û�
        UserDAO userDAO = new UserDAO();
        User resultUser = userDAO.userLogin(userName, userPwd);

        // 3������ѯ�õ�һ�� User �������¼�ɹ����ض�������ҳ customerPage.jsp
        response.setContentType("text/html;charset=UTF-8");
        if (resultUser != null) {
            // 3.1��������¼���û��� ���浽 session ��ȥ
            request.getSession().setAttribute("SESSION_USER", resultUser);
            if (resultUser.getUserIdentity() == true) {
                response.sendRedirect("customer/customerPage.jsp");
            }
            else {
                response.sendRedirect("logisticsCompany/logisticsCompanyPage.jsp");
            }
        } else {
            // 3.2������ѯ�õ�һ�� null�����¼ʧ�ܣ�����ת������¼���� login.html
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('�û������������');");
            out.write("window.location.href='login.jsp'");
            out.write("</script>");
            out.flush();
        }
    }
}
