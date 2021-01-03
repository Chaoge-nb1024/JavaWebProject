package cn.lovedan.controller;

import cn.lovedan.pojo.LogisticInfo;
import cn.lovedan.pojo.User;
import cn.lovedan.service.CourierDAO;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ��ݲ�ѯ Servlet
 */
public class CourierShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // �� session ��ȡ�� User ���󣬲����� userId �Կ�ݽ��в�ѯ
        User user = (User)request.getSession().getAttribute("SESSION_USER");
        CourierDAO courierDAO = new CourierDAO();
        List<LogisticInfo> logisticInfoList = courierDAO.searchCourierInfosByUser(user);
        // 6������������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 7���� List ����ת�� Json ���󣬲��� Json ��ʽ���ַ���д������Ӧ������ȥ
        JSONArray jsonArray = JSONArray.fromObject(logisticInfoList);
        writer.print(jsonArray.toString());
    }
}
