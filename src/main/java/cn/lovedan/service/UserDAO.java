package cn.lovedan.service;

import cn.lovedan.pojo.User;
import cn.lovedan.util.DBUtils;

public class UserDAO {
    /**
     * ע���û�
     * @param user ��ע����û�
     * @return ����true����ʾע��ɹ�������false����ʾע��ʧ��
     */
    public boolean userRegister(User user){
        // ��ѯ�û��Ƿ��Ѿ����ڡ������ڣ���ע��ʧ�ܣ��������ڣ���ע��ɹ�
        if (isExistUser(user)) {
            return false;
        } else {
            String sql = "insert into user(user_name,user_pwd,user_tel,user_identity) values(?,?,?,?);";
            return DBUtils.save(sql, user.getUserName(), user.getUserPwd(), user.getUserTel(), user.getUserIdentity());
        }
    }

    /**
     * �ж��û��Ƿ����
     * @param user ���жϵ��û�
     * @return ����true����ʾ�û����ڣ�����false����ʾ�û�������
     */
    private boolean isExistUser(User user) {
        // ��ѯ�û��Ƿ��Ѿ����ڡ������ڣ���ע��ʧ�ܣ��������ڣ���ע��ɹ�
        String sql = "select count(*) from user where user_name=? and user_pwd=?;";
        return DBUtils.getCount(sql, user.getUserName(), user.getUserPwd()) > 0 ? true : false;
    }

    /**
     * �жϵ�¼�ĳɹ����
     * @param userName ��¼���û���
     * @param userPwd ��¼���û�����
     * @return ����¼�ɹ������ض�Ӧ�� User ��������¼ʧ�ܣ����� null
     */
    public User userLogin(String userName, String userPwd) {
        // �����ݿ��в�ѯ�Ƿ�����û�����Ϣ�봫���������ͬ������У����¼�ɹ������û�У����¼ʧ��
        String sql = "select user_id userId,user_name userName,user_pwd userPwd,user_tel userTel,user_identity userIdentity from user where user_name=? and user_pwd=?;";
        return DBUtils.getSingleObject(User.class, sql, userName, userPwd);
    }
}
