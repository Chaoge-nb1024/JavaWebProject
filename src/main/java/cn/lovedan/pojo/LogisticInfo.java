package cn.lovedan.pojo;

import java.io.Serializable;

/**
 * 物流信息类
 * @author dan's lover
 * @version 1.0
 */
public class LogisticInfo implements Serializable {
    private Long courierId;                 // 快递单号，主键
    private Integer userId;                 // 用户编号，外键
    private String logisticsCompanyName;    // 物流公司名称
    private String senderName;              // 寄件人姓名
    private String senderTel;               // 寄件人手机号码
    private String recipientName;           // 收件人姓名
    private String recipientTel;            // 收件人手机号码
    private String recipientAddress;        // 收件人地址
    private String currentAddress;          // 快递当前所在地址

    /**
     * 无参构造器
     */
    public LogisticInfo() {
    }

    /**
     * 全参构造器
     * @param userId 用户编号
     * @param logisticsCompanyName 物流公司名称
     * @param senderName 寄件人姓名
     * @param senderTel 寄件人手机号码
     * @param recipientName 收件人姓名
     * @param recipientTel 收件人手机号码
     * @param recipientAddress 收件人地址
     * @param currentAddress 快递当前所在地址
     */
    public LogisticInfo(Long courierId, Integer userId, String logisticsCompanyName, String senderName, String senderTel, String recipientName, String recipientTel, String recipientAddress, String currentAddress) {
        this.courierId = courierId;
        this.userId = userId;
        this.logisticsCompanyName = logisticsCompanyName;
        this.senderName = senderName;
        this.senderTel = senderTel;
        this.recipientName = recipientName;
        this.recipientTel = recipientTel;
        this.recipientAddress = recipientAddress;
        this.currentAddress = currentAddress;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
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

    public void setLogisticsCompanyName(String logisticsCompanyId) {
        this.logisticsCompanyName = logisticsCompanyId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientTel() {
        return recipientTel;
    }

    public void setRecipientTel(String recipientTel) {
        this.recipientTel = recipientTel;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    @Override
    public String toString() {
        return "LogisticInfo{" +
                "courierId=" + courierId +
                ", userId=" + userId +
                ", logisticsCompanyName='" + logisticsCompanyName + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderTel='" + senderTel + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientTel='" + recipientTel + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                '}';
    }
}
