package cn.gmluo.bebetterme.util;

/**
 * Project: ssmbebetterme
 * Package: cn.gmluo.bebetterme.util
 *
 * @author : gmluo1988
 * @date : 2018/7/19 15:19
 */

import cn.gmluo.bebetterme.enums.AdditionalEnum;
import cn.gmluo.bebetterme.enums.DisciplineEnum;
import cn.gmluo.bebetterme.enums.ImprovementEnum;
import cn.gmluo.bebetterme.enums.KeepEnum;
import cn.gmluo.bebetterme.enums.OtherfoodEnum;
import cn.gmluo.bebetterme.enums.RunningScore;
import cn.gmluo.bebetterme.model.BeBetter;

/**
 * 计算每日得分方法工具类
 */
public class GetBeBetterScore {
    /**
     * 获取每天报告计算得分
     * @param beBetter
     * @return
     */
    public int getDayScore(BeBetter beBetter) {
        int score=0;
        score+=getSumDisciplineScore(beBetter);
        score+=getSumImprovementScore(beBetter);
        score+=getSumMyselfScore(beBetter);
        score+=getSumAdditionalScore(beBetter);

        return score;
    }


    public int getDisciplineScore(int value) {
        if (value==1) {
            return DisciplineEnum.Done.getActionScore();
        }else {
            return DisciplineEnum.Fail.getActionScore();
        }
    }

    public int getSumDisciplineScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getDisciplineScore(beBetter.getCola());
        sumScore+=getDisciplineScore(beBetter.getFattyfood());
        sumScore+=getDisciplineScore(beBetter.getSnacks());
        sumScore+=getDisciplineScore(beBetter.getBadword());
        sumScore+=getDisciplineScore(beBetter.getComplain());
        sumScore+=getDisciplineScore(beBetter.getStayuplate());
        return sumScore;
    }


    public int getImprovementScore(int value) {
        if (value==1) {
            return ImprovementEnum.Done.getActionScore();
        }else {
            return ImprovementEnum.Fail.getActionScore();
        }
    }

    public int getSumImprovementScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getImprovementScore(beBetter.getReadbook());
        sumScore+=getImprovementScore(beBetter.getLearnskills());
        sumScore+=getImprovementScore(beBetter.getDevelopskills());
        return sumScore;
    }


    public int getKeepScore(int value) {
        if (value==1) {
            return KeepEnum.Keep_1.getActionScore();
        }else if (value==2) {
            return KeepEnum.Keep_2.getActionScore();
        }else if (value==3) {
            return KeepEnum.Keep_3.getActionScore();
        } else {
            return KeepEnum.Keep_0.getActionScore();
        }
    }

    public int getSumMyselfScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=new RunningScore().getRunningScore(beBetter.getRunning());
        sumScore+=getKeepScore(beBetter.getKeep());
        return sumScore;
    }


    public int getAdditionalScore(int value) {
        if (value==1) {
            return AdditionalEnum.Done.getActionScore();
        }else {
            return AdditionalEnum.Fail.getActionScore();
        }
    }

    public int getOtherfoodScore(int value) {
        if (value==1) {
            return OtherfoodEnum.Otherfood_1.getActionScore();
        }else if (value==2) {
            return OtherfoodEnum.Otherfood_2.getActionScore();
        }else if (value==3) {
            return OtherfoodEnum.Otherfood_3.getActionScore();
        } else {
            return OtherfoodEnum.Otherfood_0.getActionScore();
        }
    }

    public int getSumAdditionalScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getAdditionalScore(beBetter.getBreakfast());
        sumScore+=getAdditionalScore(beBetter.getLunch());
        sumScore+=getOtherfoodScore(beBetter.getOtherfood());
        return sumScore;
    }
}
