package com.github.benhaixiao.mapstruct.examples.fieldmappings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-12-16T23:53:51+0800",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.7.0_04 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    private final OrderItemMapper orderItemMapper = Mappers.getMapper( OrderItemMapper.class );

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDto.getCustomerName() );
        Collection<OrderItem> collection = orderItemDtoListToOrderItemCollection( customerDto.getOrders() );
        if ( collection != null ) {
            customer.setOrderItems( collection );
        }
        customer.setId( customerDto.getId() );

        return customer;
    }

    @Override
    public CustomerDto fromCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName( customer.getName() );
        List<OrderItemDto> list = orderItemCollectionToOrderItemDtoList( customer.getOrderItems() );
        if ( list != null ) {
            customerDto.setOrders( list );
        }
        customerDto.setId( customer.getId() );

        return customerDto;
    }

    protected Collection<OrderItem> orderItemDtoListToOrderItemCollection(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<OrderItem> collection = new ArrayList<OrderItem>();
        for ( OrderItemDto orderItemDto : list ) {
            collection.add( orderItemMapper.toOrder( orderItemDto ) );
        }

        return collection;
    }

    protected List<OrderItemDto> orderItemCollectionToOrderItemDtoList(Collection<OrderItem> collection) {
        if ( collection == null ) {
            return null;
        }

        List<OrderItemDto> list = new ArrayList<OrderItemDto>();
        for ( OrderItem orderItem : collection ) {
            list.add( orderItemMapper.fromOrder( orderItem ) );
        }

        return list;
    }
}
