package cn.gmluo.bebetterme.service.requesttype;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service.requesttype
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:18
 */

import java.util.List;

/**
 * 批量删除信息格式
 */
public class DeleteIdList {
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
