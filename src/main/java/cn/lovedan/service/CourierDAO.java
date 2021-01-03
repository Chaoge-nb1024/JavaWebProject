package cn.lovedan.service;

import cn.lovedan.pojo.LogisticInfo;
import cn.lovedan.pojo.User;
import cn.lovedan.util.DBUtils;

import java.util.List;

public class CourierDAO {
    /**
     * 根据用户来查询快递信息
     * @param user 用户
     * @return 与用户相关联的全部快递信息的集合
     */
    public List<LogisticInfo> searchCourierInfosByUser(User user) {
        String sql = "select courier_id courierId,user_id userId,logisticsCompany_name logisticsCompanyName,sender_name senderName," +
                "sender_tel senderTel,recipient_name recipientName,recipient_tel recipientTel,recipient_address recipientAddress,current_address currentAddress\n" +
                "from logisticsinfo\n" +
                "where user_id=?;";
        return DBUtils.getList(LogisticInfo.class, sql, user.getUserId());
    }

    /**
     * 根据传入的快递单号查询快递
     * @param courierId 待查询的快递单号
     * @return 快递信息
     */
    public LogisticInfo searchCourierInfosByCourierId(Integer courierId) {
        String sql = "select courier_id courierId,user_id userId,logisticsCompany_name logisticsCompanyName,sender_name senderName," +
                "sender_tel senderTel,recipient_name recipientName,recipient_tel recipientTel,recipient_address recipientAddress,current_address currentAddress\n" +
                "from logisticsinfo\n" +
                "where courier_id=?;";
        return DBUtils.getSingleObject(LogisticInfo.class, sql, courierId);
    }

    /**
     * 分页查询
     * @param sql SQL语句
     * @return 页面对应的快递信息集合
     */
    public List<LogisticInfo> getLogisticInfoListByPage(String sql) {
        return DBUtils.getList(LogisticInfo.class, sql);
    }

    /**
     * 查询一共有多少行数据
     * @param sql SQL语句
     * @param args SQL语句限定条件
     * @return 数据行数
     */
    public Integer getLogisticInfoCount(String sql, Object... args) {
        return DBUtils.getCount(sql, args);
    }

    /**
     * 新增快递信息
     * @param logisticInfo 待增加的快递信息
     * @return 返回true，表示新增快递信息成功；返回false，表示新增快递信息失败
     */
    public boolean addLogisticInfo(LogisticInfo logisticInfo) {
        String sql = "insert into logisticsinfo(courier_id,user_id,logisticsCompany_name,sender_name,sender_tel,recipient_name," +
                "recipient_tel,recipient_address,current_address) values(?,?,?,?,?,?,?,?,?);";
        return DBUtils.save(sql, logisticInfo.getCourierId(), logisticInfo.getUserId(), logisticInfo.getLogisticsCompanyName(),
                logisticInfo.getSenderName(), logisticInfo.getSenderTel(), logisticInfo.getRecipientName(), logisticInfo.getRecipientTel(),
                logisticInfo.getRecipientAddress(), logisticInfo.getCurrentAddress());
    }

    /**
     * 根据快递单号签收快递
     * @param courierId 待签收快递的快递单号
     * @return 返回true，表示签收成功；返回false，表示签收失败
     */
    public boolean acceptCourierByCourierId(String courierId) {
        String sql = "delete from logisticsinfo where courier_id=?;";
        return DBUtils.save(sql, courierId);
    }
}
