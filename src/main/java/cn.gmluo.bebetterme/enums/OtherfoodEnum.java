package cn.gmluo.bebetterme.enums;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.enums
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:22
 */

/**
 * Additional points（加分项）
 * <p>
 * 完成其他餐点分值设置
 * Otherfood   做甜品或者其他食物(0:没做到，1：做了一个其他食物...以此类推))
 */
public enum OtherfoodEnum {
    Otherfood_0(0),
    Otherfood_1(3),
    Otherfood_2(6),
    Otherfood_3(9);

    private int actionScore;

    private OtherfoodEnum(int actionScore) {
        this.actionScore = actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }
}
