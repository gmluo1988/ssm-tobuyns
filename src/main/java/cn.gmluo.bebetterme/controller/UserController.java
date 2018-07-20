package cn.gmluo.bebetterme.controller;

import cn.gmluo.bebetterme.model.User;
import cn.gmluo.bebetterme.service.IUserService;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetUserList;
import cn.gmluo.bebetterme.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.controller
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:35
 */

/**
 * 4.控制层(Controller控制类实现)
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
        // 获取当前系统时间
        Date systemTime = new Date();
        user.setDatachangeCreatetime(systemTime);
        user.setDatachangeLasttime(systemTime);
        this.userService.register(user);
        return "success";
    }

    /**
     * 根据id删除用户信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "id") int id) {
        this.userService.deleteUserById(id);
        return "success";
    }

    /**
     * 批量删除用户信息
     *
     * @param idList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "batchDeleteUser", method = RequestMethod.POST)
    public String batchDeleteUser(@RequestBody DeleteIdList idList) {
        this.userService.batchDeleteUserById(idList);
        return "success";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user) {
        // 获取当前系统时间
        Date systemTime = new Date();
        user.setDatachangeLasttime(systemTime);
        this.userService.updateUser(user);
        return "success";
    }

    /**
     * 根据查询条件分页获取用户信息列表
     *
     * @param getUserList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUerList", method = RequestMethod.POST)
    public PageBean<User> getUerList(@RequestBody GetUserList getUserList) {
        PageBean<User> pageBean = new PageBean<>();
        this.userService.getUserList(pageBean, getUserList);
        return pageBean;
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findUserById", method = RequestMethod.GET)
    public User findUserById(@RequestParam(value = "id") int id) {
        User user = this.userService.getUserByID(id);
        return user;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllUsers", method = RequestMethod.GET)
    public List<User> findAllUsers(@RequestParam(required = false, defaultValue = "1") Integer startPage,
                                   @RequestParam(required = false, defaultValue = "20") Integer PageSize) {
        PageHelper.startPage(startPage, PageSize);
        List<User> userList = this.userService.selectAllUsers();
        return userList;
    }


}
