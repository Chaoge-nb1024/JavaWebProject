package cn.lovedan.service;

import cn.lovedan.util.DBUtils;

public class LogisticsCompanyDAO {
    /**
     * 物流公司注册
     * @param userId 用户编号
     * @param logisticsCompanyName 物流公司名称
     * @param logisticsCompanyPrice 物流公司价格
     * @return 返回true，表示注册成功；返回false，表示注册失败
     */
    public boolean logisticsCompanyRegister(Integer userId, String logisticsCompanyName, Integer logisticsCompanyPrice) {
        String sql = "insert into logisticscompany(user_id,logisticsCompany_name,logisticsCompany_price) values(?,?,?);";
        return DBUtils.save(sql, userId, logisticsCompanyName, logisticsCompanyPrice);
    }
}
