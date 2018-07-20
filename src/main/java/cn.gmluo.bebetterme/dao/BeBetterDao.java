package cn.gmluo.bebetterme.dao;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.dao
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:14
 */

import cn.gmluo.bebetterme.model.BeBetter;

import java.util.List;

/**
 * 2.数据访问层（持久层）
 */
public interface BeBetterDao {
    /**
     * 添加每日报告方法
     *
     * @param record
     * @return
     */
    int insert(BeBetter record);

    /**
     * 新增被选中的报告方法
     *
     * @param record
     * @return
     */
    int insertSelective(BeBetter record);

    /**
     * 按ID删除报告方法
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 更新被选中的报告信息方法
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BeBetter record);

    /**
     * 更新报告信息方法
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(BeBetter record);

    /**
     * 根据id查询报告信息方法
     *
     * @param id
     * @return
     */
    BeBetter selectByPrimaryKey(Integer id);

    /**
     * 查询所有报告信息方法
     *
     * @return
     */
    List<BeBetter> selectAllReports();

    /**
     * 查询总记录数方法
     *
     * @return
     */
    int selectTotalCount();

    /**
     * 根据日期查询总记录数方法
     *
     * @param date
     * @return
     */
    int selectTotalCountByDate(String date);

    /**
     * 根据用户名称查询所有用户信息方法
     *
     * @param date
     * @return
     */
    List<BeBetter> selectReportsByDate(String date);

    /**
     * 查询所有得分方法
     *
     * @return
     */
    int selectTotalScore();

}

