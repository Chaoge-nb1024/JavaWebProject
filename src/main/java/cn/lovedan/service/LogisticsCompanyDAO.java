package cn.lovedan.service;

import cn.lovedan.util.DBUtils;

public class LogisticsCompanyDAO {
    /**
     * ������˾ע��
     * @param userId �û����
     * @param logisticsCompanyName ������˾����
     * @param logisticsCompanyPrice ������˾�۸�
     * @return ����true����ʾע��ɹ�������false����ʾע��ʧ��
     */
    public boolean logisticsCompanyRegister(Integer userId, String logisticsCompanyName, Integer logisticsCompanyPrice) {
        String sql = "insert into logisticscompany(user_id,logisticsCompany_name,logisticsCompany_price) values(?,?,?);";
        return DBUtils.save(sql, userId, logisticsCompanyName, logisticsCompanyPrice);
    }
}
