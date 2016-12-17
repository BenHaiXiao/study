package com.github.benhaixiao.mapstruct.examples.fieldmappings;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-12-16T23:53:51+0800",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.7.0_04 (Oracle Corporation)"
)
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItem toOrder(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setName( orderItemDto.getName() );
        orderItem.setQuantity( orderItemDto.getQuantity() );

        return orderItem;
    }

    @Override
    public OrderItemDto fromOrder(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setName( orderItem.getName() );
        orderItemDto.setQuantity( orderItem.getQuantity() );

        return orderItemDto;
    }
}
