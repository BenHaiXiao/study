package com.github.benhaixiao.mapstruct.examples.fieldmappings;

import java.util.Collection;

/**
 * Created by xiaobenhai@yy.com
 * Date: 2016/12/16
 * Time: 23:42
 */
public class Customer {

    private Long id;

    private String name;

    private Collection<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
