package com.github.benhaixiao.mapstruct.examples.fieldmappings;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by xiaobenhai@yy.com
 * Date: 2016/12/16
 * Time: 23:45
 */
@Mapper(uses = { OrderItemMapper.class })
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @Mappings({
            @Mapping(source = "orders", target = "orderItems"),
            @Mapping(source = "customerName", target = "name")
    })
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
