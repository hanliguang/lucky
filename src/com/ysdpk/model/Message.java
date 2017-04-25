package com.ysdpk.model;

import java.util.List;

public class Message {

    private Integer code;
    private List<LuckyBoy> luckyBoys;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<LuckyBoy> getLuckyBoys() {
        return luckyBoys;
    }

    public void setLuckyBoys(List<LuckyBoy> luckyBoys) {
        this.luckyBoys = luckyBoys;
    }
}
