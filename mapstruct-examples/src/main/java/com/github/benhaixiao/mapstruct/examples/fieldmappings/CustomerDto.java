package com.github.benhaixiao.mapstruct.examples.fieldmappings;

import java.util.List;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/16
 * Time: 23:44
 */
public class CustomerDto {

    public Long id;

    public String customerName;

    public List<OrderItemDto> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItemDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItemDto> orders) {
        this.orders = orders;
    }
}
