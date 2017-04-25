package com.ysdpk.utils;

public class LuckyNumberUtil {

    //产生中奖代码   1--一等奖  2--二等奖  3--三等奖  -1--不中奖
    public static final int generate(){

        // 1-20之间的整数
        int range= (int) (Math.floor(Math.random()*20)+1);
        if (range==1){
            return 1;
        }else if (range==2||range==3){
            return 2;
        }else if (range==4||range==5||range==6){
            return 3;
        }else {
            return -1;
        }
    }

}
