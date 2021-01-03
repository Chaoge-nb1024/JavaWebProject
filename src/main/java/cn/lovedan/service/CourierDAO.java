package cn.lovedan.service;

import cn.lovedan.pojo.LogisticInfo;
import cn.lovedan.pojo.User;
import cn.lovedan.util.DBUtils;

import java.util.List;

public class CourierDAO {
    /**
     * �����û�����ѯ�����Ϣ
     * @param user �û�
     * @return ���û��������ȫ�������Ϣ�ļ���
     */
    public List<LogisticInfo> searchCourierInfosByUser(User user) {
        String sql = "select courier_id courierId,user_id userId,logisticsCompany_name logisticsCompanyName,sender_name senderName," +
                "sender_tel senderTel,recipient_name recipientName,recipient_tel recipientTel,recipient_address recipientAddress,current_address currentAddress\n" +
                "from logisticsinfo\n" +
                "where user_id=?;";
        return DBUtils.getList(LogisticInfo.class, sql, user.getUserId());
    }

    /**
     * ���ݴ���Ŀ�ݵ��Ų�ѯ���
     * @param courierId ����ѯ�Ŀ�ݵ���
     * @return �����Ϣ
     */
    public LogisticInfo searchCourierInfosByCourierId(Integer courierId) {
        String sql = "select courier_id courierId,user_id userId,logisticsCompany_name logisticsCompanyName,sender_name senderName," +
                "sender_tel senderTel,recipient_name recipientName,recipient_tel recipientTel,recipient_address recipientAddress,current_address currentAddress\n" +
                "from logisticsinfo\n" +
                "where courier_id=?;";
        return DBUtils.getSingleObject(LogisticInfo.class, sql, courierId);
    }

    /**
     * ��ҳ��ѯ
     * @param sql SQL���
     * @return ҳ���Ӧ�Ŀ����Ϣ����
     */
    public List<LogisticInfo> getLogisticInfoListByPage(String sql) {
        return DBUtils.getList(LogisticInfo.class, sql);
    }

    /**
     * ��ѯһ���ж���������
     * @param sql SQL���
     * @param args SQL����޶�����
     * @return ��������
     */
    public Integer getLogisticInfoCount(String sql, Object... args) {
        return DBUtils.getCount(sql, args);
    }

    /**
     * ���������Ϣ
     * @param logisticInfo �����ӵĿ����Ϣ
     * @return ����true����ʾ���������Ϣ�ɹ�������false����ʾ���������Ϣʧ��
     */
    public boolean addLogisticInfo(LogisticInfo logisticInfo) {
        String sql = "insert into logisticsinfo(courier_id,user_id,logisticsCompany_name,sender_name,sender_tel,recipient_name," +
                "recipient_tel,recipient_address,current_address) values(?,?,?,?,?,?,?,?,?);";
        return DBUtils.save(sql, logisticInfo.getCourierId(), logisticInfo.getUserId(), logisticInfo.getLogisticsCompanyName(),
                logisticInfo.getSenderName(), logisticInfo.getSenderTel(), logisticInfo.getRecipientName(), logisticInfo.getRecipientTel(),
                logisticInfo.getRecipientAddress(), logisticInfo.getCurrentAddress());
    }

    /**
     * ���ݿ�ݵ���ǩ�տ��
     * @param courierId ��ǩ�տ�ݵĿ�ݵ���
     * @return ����true����ʾǩ�ճɹ�������false����ʾǩ��ʧ��
     */
    public boolean acceptCourierByCourierId(String courierId) {
        String sql = "delete from logisticsinfo where courier_id=?;";
        return DBUtils.save(sql, courierId);
    }
}
