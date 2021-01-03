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
 * 快递查询 Servlet
 */
public class CourierShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 从 session 中取得 User 对象，并根据 userId 对快递进行查询
        User user = (User)request.getSession().getAttribute("SESSION_USER");
        CourierDAO courierDAO = new CourierDAO();
        List<LogisticInfo> logisticInfoList = courierDAO.searchCourierInfosByUser(user);
        // 6、获得输出对象
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        // 7、将 List 对象转成 Json 对象，并将 Json 形式的字符串写出到响应对象中去
        JSONArray jsonArray = JSONArray.fromObject(logisticInfoList);
        writer.print(jsonArray.toString());
    }
}
