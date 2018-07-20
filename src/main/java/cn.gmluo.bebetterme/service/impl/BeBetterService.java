package cn.gmluo.bebetterme.service.impl;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service.impl
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:34
 */

import cn.gmluo.bebetterme.dao.BeBetterDao;
import cn.gmluo.bebetterme.model.BeBetter;
import cn.gmluo.bebetterme.service.IBeBetterService;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 3.业务逻辑层
 * 3.2-service接口实现类
 */
@Service("beBetterService")
public class BeBetterService implements IBeBetterService {

    @Resource
    private BeBetterDao beBetterDao;

    /**
     * 添加每日报告方法实现
     *
     * @param bebetter
     */
    @Override
    public void saveReport(BeBetter bebetter) {
        this.beBetterDao.insertSelective(bebetter);
    }

    /**
     * 按ID删除报告方法实现
     *
     * @param id
     */
    @Override
    public void deleteReport(int id) {
        this.beBetterDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据ID批量删除报告方法实现
     *
     * @param idList
     */
    @Override
    public void batchDeleteReportById(DeleteIdList idList) {
        for (Integer id : idList.getIdList()) {
            this.beBetterDao.deleteByPrimaryKey(id);
        }
    }

    /**
     * 修改每日报告方法实现
     *
     * @param bebetter
     */
    @Override
    public void uadateReport(BeBetter bebetter) {
        this.beBetterDao.updateByPrimaryKeySelective(bebetter);
    }

    /**
     * 根据Id查询每日报告方法实现
     *
     * @param id
     * @return
     */
    @Override
    public BeBetter findById(int id) {
        return this.beBetterDao.selectByPrimaryKey(id);
    }

    /**
     * 查询所有报告方法实现
     */
    @Override
    public List<BeBetter> getAllReports() {
        return this.beBetterDao.selectAllReports();
    }

    /**
     * 根据查询条件分页获取报告列表方法实现
     *
     * @param pageBean
     * @param getReportList
     */
    @Override
    public void getReportList(PageBean<BeBetter> pageBean, GetReportList getReportList) {
        String date = getReportList.getDate();
        int pageIndex = getReportList.getPageIndex();
        int pageSize = getReportList.getPageSize();
        int totalCount = -1;

        // 1.设置当前页码
        pageBean.setCurrentPage(pageIndex);

        // 2.设置每页返回的数据数目
        pageBean.setPageCount(pageSize);

        // 3.1查询总结果数;设置到pageBean对象中
        if (date == null || date.length() <= 0) {
            totalCount = this.beBetterDao.selectTotalCount();
        } else {
            totalCount = this.beBetterDao.selectTotalCountByDate(date);
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

            //如果没有传入date,即走分页查询
            if (date == null || date.length() <= 0) {
                PageHelper.startPage(currentPage, pageCount);
                List<BeBetter> betterList = this.beBetterDao.selectAllReports();
                pageBean.setPageData(betterList);
            }
            //如果传入了date，即走按date查询
            else {
                PageHelper.startPage(currentPage, pageCount);
                List<BeBetter> betterList = this.beBetterDao.selectReportsByDate(date);
                pageBean.setPageData(betterList);
            }
        }
    }

    /**
     * 查询所有得分方法
     *
     * @return
     */
    @Override
    public int getAllScore() {
        return this.beBetterDao.selectTotalScore();
    }
}
