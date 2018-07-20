package cn.gmluo.bebetterme.model;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.model
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:11
 */

import java.util.Date;

/**
 * 1.数据实例层设计
 */
public class BeBetter {
    /**
     * 主键
     */
    private Integer id;

    /**
     * Date 日期（时间戳）
     */
    private Date datachangeCreatetime;

    private Date datachangeLasttime;

    /**
     * self-discipline(自我约束)实例
     * Cola             不喝碳酸饮料
     * Fattyfood        不吃油腻的食物
     * Snacks           不吃零食
     * Badword          不说脏话
     * Complain         不说抱怨的话
     * Stayuplate       不熬夜
     */
    private Integer cola;

    private Integer fattyfood;

    private Integer snacks;

    private Integer badword;

    private Integer complain;

    private Integer stayuplate;

    /**
     * self-improvement（自我提高）
     * Readbook         阅读书籍
     * Learningskills   学习相关技能
     * Developskills    拓展技能
     */
    private Integer readbook;

    private Integer learnskills;

    private Integer developskills;

    /**
     * Change myself（改变自我）
     * Running          跑步
     * Keep             keep训练
     */
    private Float running;

    private Integer keep;

    /**
     * Additional points（加分项）
     * Breakfast        做早饭
     * Lunch            做午饭
     * Otherfood        做甜品或者其他食物
     */

    private Integer breakfast;

    private Integer lunch;

    private Integer otherfood;

    /**
     * 每日得分 Score 每日得分
     */
    private Integer score;

    /**
     * 无参构造方法
     */
    public BeBetter() {
    }

    @Override
    public String toString() {
        return "BeBetter{" +
                "id=" + id +
                ", datachangeCreatetime=" + datachangeCreatetime +
                ", datachangeLasttime=" + datachangeLasttime +
                ", cola=" + cola +
                ", fattyfood=" + fattyfood +
                ", snacks=" + snacks +
                ", badword=" + badword +
                ", complain=" + complain +
                ", stayuplate=" + stayuplate +
                ", readbook=" + readbook +
                ", learnskills=" + learnskills +
                ", developskills=" + developskills +
                ", running=" + running +
                ", keep=" + keep +
                ", breakfast=" + breakfast +
                ", lunch=" + lunch +
                ", otherfood=" + otherfood +
                ", score=" + score +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCola() {
        return cola;
    }

    public void setCola(Integer cola) {
        this.cola = cola;
    }

    public Integer getFattyfood() {
        return fattyfood;
    }

    public void setFattyfood(Integer fattyfood) {
        this.fattyfood = fattyfood;
    }

    public Integer getSnacks() {
        return snacks;
    }

    public void setSnacks(Integer snacks) {
        this.snacks = snacks;
    }

    public Integer getBadword() {
        return badword;
    }

    public void setBadword(Integer badword) {
        this.badword = badword;
    }

    public Integer getComplain() {
        return complain;
    }

    public void setComplain(Integer complain) {
        this.complain = complain;
    }

    public Integer getStayuplate() {
        return stayuplate;
    }

    public void setStayuplate(Integer stayuplate) {
        this.stayuplate = stayuplate;
    }

    public Integer getReadbook() {
        return readbook;
    }

    public void setReadbook(Integer readbook) {
        this.readbook = readbook;
    }

    public Integer getLearnskills() {
        return learnskills;
    }

    public void setLearnskills(Integer learnskills) {
        this.learnskills = learnskills;
    }

    public Integer getDevelopskills() {
        return developskills;
    }

    public void setDevelopskills(Integer developskills) {
        this.developskills = developskills;
    }

    public Float getRunning() {
        return running;
    }

    public void setRunning(Float running) {
        this.running = running;
    }

    public Integer getKeep() {
        return keep;
    }

    public void setKeep(Integer keep) {
        this.keep = keep;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getLunch() {
        return lunch;
    }

    public void setLunch(Integer lunch) {
        this.lunch = lunch;
    }

    public Integer getOtherfood() {
        return otherfood;
    }

    public void setOtherfood(Integer otherfood) {
        this.otherfood = otherfood;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDatachangeCreatetime() {
        return datachangeCreatetime;
    }

    public void setDatachangeCreatetime(Date datachangeCreatetime) {
        this.datachangeCreatetime = datachangeCreatetime;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }
}
