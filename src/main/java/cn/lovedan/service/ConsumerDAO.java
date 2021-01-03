package cn.lovedan.service;

import cn.lovedan.util.DBUtils;

public class ConsumerDAO {
    /**
     * 消费者注册
     * @param userId 用户编号
     * @param consumerName 消费者姓名
     * @return 返回true，表示注册成功；返回false，表示注册失败
     */
    public boolean consumerRegister(Integer userId, String consumerName) {
        String sql = "insert into consumer(user_id,consumer_name) values(?,?);";
        return DBUtils.save(sql, userId, consumerName);
    }
}
