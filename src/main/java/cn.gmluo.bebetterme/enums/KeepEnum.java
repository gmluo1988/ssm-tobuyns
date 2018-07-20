package cn.gmluo.bebetterme.enums;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.enums
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:21
 */

/**
 * Change myself（改变自我）
 * <p>
 * 完成keep分值设置
 * Keep    keep训练(0:没完成，1：完成了1组...以此类推)
 */
public enum KeepEnum {
    Keep_0(0),
    Keep_1(3),
    Keep_2(6),
    Keep_3(9);

    private int actionScore;

    private KeepEnum(int actionScore) {
        this.actionScore = actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }

}