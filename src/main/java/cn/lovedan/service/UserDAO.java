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
}
