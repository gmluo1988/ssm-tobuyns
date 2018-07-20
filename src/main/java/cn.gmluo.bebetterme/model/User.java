package cn.gmluo.bebetterme.model;

import java.util.Date;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.model
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:10
 */

/**
 * 1.数据实例层设计
 */
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * Date 日期（时间戳）
     */
    private Date datachangeLasttime;
    private Date datachangeCreatetime;

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     * 1：male
     * 0:female
     */
    private Integer gender;

    /**
     * 无参构造方法
     */
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", datachangeLasttime=" + datachangeLasttime +
                ", datachangeCreatetime=" + datachangeCreatetime +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public Date getDatachangeCreatetime() {
        return datachangeCreatetime;
    }

    public void setDatachangeCreatetime(Date datachangeCreatetime) {
        this.datachangeCreatetime = datachangeCreatetime;
    }
}
