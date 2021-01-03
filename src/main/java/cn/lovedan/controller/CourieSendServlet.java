package cn.lovedan.controller;

import cn.lovedan.pojo.LogisticInfo;
import cn.lovedan.pojo.User;
import cn.lovedan.service.CourierDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CourieSendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1、从请求对象和 session域 中获取数据，并封装成一个 LogisticsInfo 对象
        String logisticsCompanyName = request.getParameter("logisticsCompanyName");
        String senderName = request.getParameter("senderName");
        String senderTel = request.getParameter("senderTel");
        String recipientName = request.getParameter("recipientName");
        String recipientTel = request.getParameter("recipientTel");
        String recipientAddress = request.getParameter("recipientAddress");
        User user = (User) request.getSession().getAttribute("SESSION_USER");
        LogisticInfo logisticInfo = new LogisticInfo(null, user.getUserId(), logisticsCompanyName, senderName, senderTel, recipientName, recipientTel, recipientAddress, "吉首大学");

        // 2、与数据库交互
        CourierDAO courierDAO = new CourierDAO();
        boolean result = courierDAO.addLogisticInfo(logisticInfo);

        // 3、返回操作结果
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result == true) {
            out.write("<script>");
            out.write("alert('寄送快递成功！！！');");
            out.write("window.parent.location.href='customer/customerPage.jsp'");
            out.write("</script>");
            out.flush();
        } else {
            out.write("<script>");
            out.write("alert('寄送快递失败！！！');");
            out.write("window.parent.location.href='customer/customerPage.jsp'");
            out.write("</script>");
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
