package com.github.benhaixiao.mapstruct.examples.iterablemappings;

import java.util.List;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/17
 * Time: 12:24
 */
public class IterableNonInterableUtil {

    @FirstElement
    public <T> T first( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( 0 );
        }
        else {
            return null;
        }
    }

    @LastElement
    public <T> T last( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( in.size() - 1 );
        }
        else {
            return null;
        }
    }
}
