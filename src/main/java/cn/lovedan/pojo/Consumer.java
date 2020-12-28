package cn.lovedan.pojo;

/**
 * 消费者类
 * @author dan's lover
 * @version 1.0
 */
public class Consumer {
    private Integer consumerId;     // 消费者编号，主键
    private Integer userId;         // 用户编号，外键
    private String consumerName;    // 用户名称

    /**
     * 无参构造器
     */
    public Consumer() {
    }

    /**
     * 全参构造器
     * @param consumerId 消费者编号
     * @param userId 用户编号
     * @param consumerName 用户名称
     */
    public Consumer(Integer consumerId, Integer userId, String consumerName) {
        this.consumerId = consumerId;
        this.userId = userId;
        this.consumerName = consumerName;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerId='" + consumerId + '\'' +
                ", userId=" + userId +
                ", consumerName='" + consumerName + '\'' +
                '}';
    }
}
