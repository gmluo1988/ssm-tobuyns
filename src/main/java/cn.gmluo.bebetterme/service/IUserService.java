package cn.gmluo.bebetterme.service;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:15
 */

import cn.gmluo.bebetterme.model.User;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetUserList;
import cn.gmluo.bebetterme.util.PageBean;

import java.util.List;

/**
 * 3.业务逻辑层
 * 3.1-service接口设计
 */
public interface IUserService {
    /**
     * 注册用户方法
     *
     * @param user
     */
    public void register(User user);

    /**
     * 删除用户信息方法
     *
     * @param id
     */
    public void deleteUserById(int id);

    /**
     * 批量删除用户信息方法
     *
     * @param idList
     */
    public void batchDeleteUserById(DeleteIdList idList);

    /**
     * 更改用户信息方法
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User getUserByID(int id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> selectAllUsers();

    /**
     * 分页获取用户信息列表方法
     *
     * @param pageBean
     * @param getUserList
     */
    public void getUserList(PageBean<User> pageBean, GetUserList getUserList);

}

