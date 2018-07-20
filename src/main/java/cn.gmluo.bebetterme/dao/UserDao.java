package cn.gmluo.bebetterme.dao;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.dao
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:13
 */

import cn.gmluo.bebetterme.model.User;

import java.util.List;

/**
 * 2.数据访问层（持久层）
 */
public interface UserDao {
    /**
     * 根据id删除用户信息方法
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户信息方法
     */

    int insert(User record);

    /**
     * 新增被选中的用户方法
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据id查询用户信息方法
     *
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新被选中的用户信息方法
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新用户信息方法
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询所有用户信息方法
     *
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 查询总记录数方法
     *
     * @return
     */
    int selectTotalCount();

    /**
     * 根据用户名称查询总记录数方法
     *
     * @param uerName
     * @return
     */
    int selectTotalCountByUserName(String uerName);

    /**
     * 根据用户名称查询所有用户信息方法
     *
     * @param uerName
     * @return
     */
    List<User> selectUsersByUserName(String uerName);
}
