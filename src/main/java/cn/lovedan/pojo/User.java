package cn.lovedan.pojo;

/**
 * 用户类（消费者/物流公司）
 * @author dan's lover
 * @version 1.0
 */
public class User {
    private Integer userId;         // 用户编号，主键
    private String userName;        // 用户名
    private String userPwd;         // 用户密码
    private String userTel;         // 用户手机号码
    private Boolean userIdentity;   // 用户身份标识。true表示消费者，false表示物流公司

    /**
     * 无参构造器
     */
    public User() {
    }

    /**
     * 全参构造器
     * @param userId 用户编号
     * @param userName 用户名
     * @param userPwd 用户密码
     * @param userTel 用户手机号码
     * @param userIdentity 用户身份
     */
    public User(Integer userId, String userName, String userPwd, String userTel, Boolean userIdentity) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userIdentity = userIdentity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Boolean getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Boolean userIdentity) {
        this.userIdentity = userIdentity;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userIdentity=" + userIdentity +
                '}';
    }
}
