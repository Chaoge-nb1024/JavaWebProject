package cn.lovedan.service;

import cn.lovedan.pojo.User;
import cn.lovedan.util.DBUtils;

public class UserDAO {
    /**
     * 注册用户
     * @param user 待注册的用户
     * @return 返回true，表示注册成功；返回false，表示注册失败
     */
    public boolean userRegister(User user){
        // 查询用户是否已经存在。若存在，则注册失败；若不存在，则注册成功
        if (isExistUser(user)) {
            return false;
        } else {
            String sql = "insert into user(user_name,user_pwd,user_tel,user_identity) values(?,?,?,?);";
            return DBUtils.save(sql, user.getUserName(), user.getUserPwd(), user.getUserTel(), user.getUserIdentity());
        }
    }

    /**
     * 判断用户是否存在
     * @param user 待判断的用户
     * @return 返回true，表示用户存在；返回false，表示用户不存在
     */
    private boolean isExistUser(User user) {
        // 查询用户是否已经存在。若存在，则注册失败；若不存在，则注册成功
        String sql = "select count(*) from user where user_name=? and user_pwd=?;";
        return DBUtils.getCount(sql, user.getUserName(), user.getUserPwd()) > 0 ? true : false;
    }

    /**
     * 判断登录的成功与否
     * @param userName 登录的用户名
     * @param userPwd 登录的用户密码
     * @return 若登录成功，返回对应的 User 对象；若登录失败，返回 null
     */
    public User userLogin(String userName, String userPwd) {
        // 从数据库中查询是否存在用户的信息与传入的数据相同。如果有，则登录成功；如果没有，则登录失败
        String sql = "select user_id userId,user_name userName,user_pwd userPwd,user_tel userTel,user_identity userIdentity from user where user_name=? and user_pwd=?;";
        return DBUtils.getSingleObject(User.class, sql, userName, userPwd);
    }
}
