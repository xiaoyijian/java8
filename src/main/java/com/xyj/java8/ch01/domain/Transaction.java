package com.xyj.java8.ch01.domain;

import lombok.Data;

@Data
public class Transaction {
    /**
     * 金额
     */
    private int price;

    /**
     * 货币
     */
    private Currency currency;
}
