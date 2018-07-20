package cn.gmluo.bebetterme.service.impl;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service.impl
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:33
 */

import cn.gmluo.bebetterme.dao.UserDao;
import cn.gmluo.bebetterme.model.User;
import cn.gmluo.bebetterme.service.IUserService;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetUserList;
import cn.gmluo.bebetterme.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 3.业务逻辑层
 * 3.2-service接口实现类
 */
@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserDao userdao;

    /**
     * 注册用户方法实现
     *
     * @param user
     */
    @Override
    public void register(User user) {
        this.userdao.insertSelective(user);

    }

    /**
     * 删除用户信息方法实现
     *
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        this.userdao.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除用户信息方法实现
     *
     * @param idList
     */
    @Override
    public void batchDeleteUserById(DeleteIdList idList) {
        for (Integer id : idList.getIdList()) {
            this.userdao.deleteByPrimaryKey(id);
        }
    }

    /**
     * 更改用户信息方法实现
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        this.userdao.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User getUserByID(int id) {
        return this.userdao.selectByPrimaryKey(id);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> selectAllUsers() {
        return this.userdao.selectAllUsers();
    }

    /**
     * 分页获取用户信息列表方法实现
     *
     * @param pageBean
     */
    @Override
    public void getUserList(PageBean<User> pageBean, GetUserList getUserList) {
        String uerName = getUserList.getUserName();
        int pageIndex = getUserList.getPageIndex();
        int pageSize = getUserList.getPageSize();
        int totalCount = -1;

        // 1.设置当前页码
        pageBean.setCurrentPage(pageIndex);

        // 2.设置每页返回的数据数目
        pageBean.setPageCount(pageSize);

        // 3.1查询总结果数;设置到pageBean对象中
        if (uerName == null || uerName.length() <= 0) {
            totalCount = this.userdao.selectTotalCount();
        } else {
            totalCount = this.userdao.selectTotalCountByUserName(uerName);
        }

        //3.2如果总条数小于等于0
        if (totalCount <= 0) {
            pageBean.setTotalCount(0);
            pageBean.setTotalPage(0);
            pageBean.setPageData(null);
        } else {
            //3.3设置结果总条数
            pageBean.setTotalCount(totalCount);

            // 4.判断前端传入的当前页值
            // 4.1如果前端传入的当前页值<=0;则需将当前页赋值为1（即第一页）
            if (pageBean.getCurrentPage() <= 0) {
                pageBean.setCurrentPage(1);// 将当前页赋值为第一页
            }
            // 4.2如果前端传入的当前页值大于最大页的值
            else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
                pageBean.setCurrentPage(pageBean.getTotalPage());// 将当前页赋值为最大页的值
            }

            // 5. 获取当前页数，每页返回的条数
            int currentPage = pageBean.getCurrentPage();// 获取此时pageBean中的当前页值
            int pageCount = pageBean.getPageCount();// 获取需要返回的数据行数
            //如果没有传入uerName,即走分页查询
            if (uerName == null || uerName.length() <= 0) {
                PageHelper.startPage(currentPage, pageCount);
                List<User> userList = this.userdao.selectAllUsers();
                pageBean.setPageData(userList);
            }
            //如果传入了uerName，即走按名字查询
            else {
                PageHelper.startPage(currentPage, pageCount);
                List<User> userList = this.userdao.selectUsersByUserName(uerName);
                pageBean.setPageData(userList);
            }
        }
    }
}
