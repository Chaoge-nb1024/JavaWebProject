package cn.lovedan.pojo;

/**
 * 物流公司类
 * @author dan's lover
 * @version 1.0
 */
public class LogisticsCompany {
    private Integer logisticsCompanyId;     // 公司编号，主键
    private Integer userId;                 // 用户编号，外键
    private String logisticsCompanyName;    // 用户名称
    private Integer logisticsCompanyPrice;  // 物流公司的寄件价格

    /**
     * 无参构造器
     */
    public LogisticsCompany() {
    }

    /**
     * 全参构造器
     * @param logisticsCompanyId 物流公司编号
     * @param userId 用户编号
     * @param logisticsCompanyName 物流公司名称
     * @param logisticsCompanyPrice 物流公司的寄件价格
     */
    public LogisticsCompany(Integer logisticsCompanyId, Integer userId, String logisticsCompanyName, Integer logisticsCompanyPrice) {
        this.logisticsCompanyId = logisticsCompanyId;
        this.userId = userId;
        this.logisticsCompanyName = logisticsCompanyName;
        this.logisticsCompanyPrice = logisticsCompanyPrice;
    }

    public Integer getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(Integer logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogisticsCompanyName() {
        return logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    public Integer getLogisticsCompanyPrice() {
        return logisticsCompanyPrice;
    }

    public void setLogisticsCompanyPrice(Integer logisticsCompanyPrice) {
        this.logisticsCompanyPrice = logisticsCompanyPrice;
    }

    @Override
    public String toString() {
        return "LogisticsCompany{" +
                "logisticsCompanyId=" + logisticsCompanyId +
                ", logisticsCompanyName='" + logisticsCompanyName + '\'' +
                ", logisticsCompanyPrice=" + logisticsCompanyPrice +
                '}';
    }
}
