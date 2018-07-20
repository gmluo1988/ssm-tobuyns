package cn.gmluo.bebetterme.service.requesttype;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.service.requesttype
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:17
 */

/**
 * 用户查询条件格式
 */
public class GetUserList {
    private String userName;
    private Integer pageIndex;
    private Integer pageSize;

    @Override
    public String toString() {
        return "GetUserList{" +
                "userName='" + userName + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
