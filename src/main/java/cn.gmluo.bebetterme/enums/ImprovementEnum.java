package cn.gmluo.bebetterme.enums;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.enums
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:21
 */

/**
 * self-improvement（自我提高）分值设置
 * <p>
 * Readbook          阅读书籍(0:没完成，1：完成了)
 * Learningskills    学习相关技能(0:没完成，1：完成了)
 * Developskills     拓展技能(0:没完成，1：完成了)
 */
public enum ImprovementEnum {
    Fail(-1), Done(3);

    private int actionScore;

    private ImprovementEnum(int actionScore) {
        this.actionScore = actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }

}
