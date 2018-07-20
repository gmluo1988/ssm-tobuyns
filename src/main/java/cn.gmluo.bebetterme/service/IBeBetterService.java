package cn.gmluo.bebetterme.service;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:32
 */

import cn.gmluo.bebetterme.model.BeBetter;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.PageBean;

import java.util.List;

/**
 * 3.业务逻辑层
 * 3.1-service接口设计
 */
public interface IBeBetterService {
    /**
     * 添加每日报告方法
     *
     * @param bebetter
     */
    public void saveReport(BeBetter bebetter);

    /**
     * 按ID删除报告方法
     *
     * @param id
     */
    public void deleteReport(int id);

    /**
     * 根据ID批量删除报告方法
     *
     * @param idList
     */
    public void batchDeleteReportById(DeleteIdList idList);

    /**
     * 修改每日报告方法
     *
     * @param bebetter
     */
    public void uadateReport(BeBetter bebetter);

    /**
     * 根据Id查询每日报告方法
     *
     * @param id
     * @return
     */
    public BeBetter findById(int id);

    /**
     * 查询所有报告方法
     */
    public List<BeBetter> getAllReports();

    /**
     * 根据查询条件分页获取报告列表方法
     *
     * @param pageBean
     * @param getReportList
     */
    public void getReportList(PageBean<BeBetter> pageBean, GetReportList getReportList);

    /**
     * 计算每日报告得分方法
     *
     * @param beBetter
     * @return
     */
//    public int getScore(BeBetter beBetter);

    /**
     * 查询所有得分方法
     *
     * @return
     */
    public int getAllScore();
}
