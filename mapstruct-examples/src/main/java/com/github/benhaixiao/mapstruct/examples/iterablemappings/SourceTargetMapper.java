package com.github.benhaixiao.mapstruct.examples.iterablemappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/17
 * Time: 12:23
 */
@Mapper( uses = IterableNonInterableUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mappings( {
            @Mapping( source = "myIntegers", target = "myInteger", qualifiedBy = FirstElement.class ),
            @Mapping( source = "myStrings", target = "myString", qualifiedBy = LastElement.class )
    } )
    Target toTarget( Source s );
}
