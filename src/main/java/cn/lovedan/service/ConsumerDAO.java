package cn.lovedan.service;

import cn.lovedan.util.DBUtils;

public class ConsumerDAO {
    /**
     * ������ע��
     * @param userId �û����
     * @param consumerName ����������
     * @return ����true����ʾע��ɹ�������false����ʾע��ʧ��
     */
    public boolean consumerRegister(Integer userId, String consumerName) {
        String sql = "insert into consumer(user_id,consumer_name) values(?,?);";
        return DBUtils.save(sql, userId, consumerName);
    }
}
