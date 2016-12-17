package com.github.benhaixiao.mapstruct.examples.fieldmappings;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/16
 * Time: 23:43
 */
public class OrderItem {

    private String name;

    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
