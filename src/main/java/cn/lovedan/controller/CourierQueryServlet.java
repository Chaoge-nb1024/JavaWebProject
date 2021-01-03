package cn.lovedan.controller;

import cn.lovedan.pojo.LogisticInfo;
import cn.lovedan.service.CourierDAO;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CourierQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1������������л�ȡ����ѯ��ݵĿ�ݵ���
        String courierIdStr = request.getParameter("courierId");
        Integer courierId = 0;
        if (courierIdStr != null && courierIdStr.length()>0) {
            courierId = Integer.parseInt(request.getParameter("courierId"));
        }
        // 2�����ݿ�ݵ��Ų�ѯ�����Ϣ
        CourierDAO courierDAO = new CourierDAO();
        LogisticInfo logisticInfo = courierDAO.searchCourierInfosByCourierId(courierId);
        // 3������ѯ�õ��Ŀ����ϢתΪ Json ����
        JSONObject jsonObject = JSONObject.fromObject(logisticInfo);
        // 4����ȡ��Ӧ������������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 5���� Json ������ַ�����ʽд����Ӧ������ȥ
        writer.print(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
