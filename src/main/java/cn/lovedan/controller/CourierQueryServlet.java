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
        // 1、从请求对象中获取待查询快递的快递单号
        String courierIdStr = request.getParameter("courierId");
        Integer courierId = 0;
        if (courierIdStr != null && courierIdStr.length()>0) {
            courierId = Integer.parseInt(request.getParameter("courierId"));
        }
        // 2、根据快递单号查询快递信息
        CourierDAO courierDAO = new CourierDAO();
        LogisticInfo logisticInfo = courierDAO.searchCourierInfosByCourierId(courierId);
        // 3、将查询得到的快递信息转为 Json 对象
        JSONObject jsonObject = JSONObject.fromObject(logisticInfo);
        // 4、获取响应对象的输出对象
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 5、将 Json 对象的字符串形式写入响应对象中去
        writer.print(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
