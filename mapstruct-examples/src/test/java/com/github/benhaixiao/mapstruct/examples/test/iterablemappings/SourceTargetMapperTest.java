package com.github.benhaixiao.mapstruct.examples.test.iterablemappings;

import com.github.benhaixiao.mapstruct.examples.iterablemappings.Source;
import com.github.benhaixiao.mapstruct.examples.iterablemappings.SourceTargetMapper;
import com.github.benhaixiao.mapstruct.examples.iterablemappings.Target;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/17
 * Time: 12:28
 */
public class SourceTargetMapperTest {
    @Test
    public void testToTarget() {

        Source s = new Source();
        s.setMyIntegers( Arrays.asList( 5, 3, 7 ) );
        s.setMyStrings( Arrays.asList( "five", "three", "seven" ) );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        assertEquals( new Integer( 5 ), t.getMyInteger() );
        assertEquals( "seven", t.getMyString() );
    }
}
