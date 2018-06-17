package com.xyj.java8.ch04;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {
    private Integer calories;
    private String name;
    private boolean isVegetarian;

}
