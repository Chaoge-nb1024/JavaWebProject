package cn.lovedan.controller;

import cn.lovedan.service.CourierDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CourierAcceptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1������������л�ȡ����ǩ�յĿ�ݵ��š�
        String courierId = request.getParameter("courierId");
        // 2�������ݿ���н���
        CourierDAO courierDAO = new CourierDAO();
        boolean result = courierDAO.acceptCourierByCourierId(courierId);
        // 3����Ӧ
        if (result) {
            request.getRequestDispatcher("/courierShow").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('ǩ��ʧ�ܣ���ݲ����ڣ�����');");
            out.write("</script>");
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
