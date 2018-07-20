package cn.gmluo.bebetterme.controller;

import cn.gmluo.bebetterme.model.BeBetter;
import cn.gmluo.bebetterme.service.IBeBetterService;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.GetBeBetterScore;
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
 * @date : 2018/7/19 15:37
 */

/**
 * 4.控制层(Controller控制类实现)
 */
@Controller
@RequestMapping("/bebetter")
public class BeBetterController {

    @Resource(name = "beBetterService")
    private IBeBetterService beBetterService;

    /**
     * 新增报告
     *
     * @param beBetter
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveReport", method = RequestMethod.POST)
    public String saveReport(@RequestBody BeBetter beBetter) {
        // 获取当前系统时间
        Date systemTime = new Date();
        //设置时间戳
        beBetter.setDatachangeCreatetime(systemTime);
        beBetter.setDatachangeLasttime(systemTime);
        //计算每日报告得分
        beBetter.setScore(this.getScore(beBetter));
        this.beBetterService.saveReport(beBetter);
        return "success";
    }

    /**
     * 根据id删除报告
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteReport", method = RequestMethod.GET)
    public String deleteReport(@RequestParam(value = "id") int id) {
        this.beBetterService.deleteReport(id);
        return "success";
    }

    /**
     * 根据id批量删除报告
     *
     * @param idList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "batchDeleteReport", method = RequestMethod.POST)
    public String batchDeleteReport(@RequestBody DeleteIdList idList) {
        this.beBetterService.batchDeleteReportById(idList);
        return "success";
    }

    /**
     * 修改报告
     *
     * @param beBetter
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateReport", method = RequestMethod.POST)
    public String updateReport(@RequestBody BeBetter beBetter) {
        // 获取当前系统时间
        Date systemTime = new Date();
        //更新时间戳
        beBetter.setDatachangeLasttime(systemTime);
        //重新计算每日报告得分
        beBetter.setScore(this.getScore(beBetter));
        this.beBetterService.uadateReport(beBetter);
        return "success";
    }

    /**
     * 根据id查询报告
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findReportById", method = RequestMethod.GET)
    public BeBetter findReportById(@RequestParam(value = "id") int id) {
        return this.beBetterService.findById(id);
    }

    /**
     * 根据查询条件分页获取报告列表
     *
     * @param getReportList
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getReportList", method = RequestMethod.POST)
    public PageBean<BeBetter> getReportList(@RequestBody GetReportList getReportList) {
        PageBean<BeBetter> pageBean = new PageBean<>();
        this.beBetterService.getReportList(pageBean, getReportList);
        return pageBean;
    }


    /**
     * 查询所有用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllReports", method = RequestMethod.GET)
    public List<BeBetter> findAllUsers(@RequestParam(required = false, defaultValue = "1") Integer startPage,
                                       @RequestParam(required = false, defaultValue = "20") Integer PageSize) {
        PageHelper.startPage(startPage, PageSize);
        List<BeBetter> userList = this.beBetterService.getAllReports();
        return userList;
    }

    /**
     * 查询所有得分
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllScore", method = RequestMethod.GET)
    public int getAllScore() {
        return this.beBetterService.getAllScore();
    }

    /**
     * 计算每日报告得分方法
     *
     * @param beBetter
     * @return
     */
    public int getScore(BeBetter beBetter) {
        return new GetBeBetterScore().getDayScore(beBetter);
    }

}

