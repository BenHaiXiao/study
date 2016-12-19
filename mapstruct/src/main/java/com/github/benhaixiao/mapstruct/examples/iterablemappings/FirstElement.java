package com.github.benhaixiao.mapstruct.examples.iterablemappings;

import org.mapstruct.Qualifier;

import java.lang.annotation.*;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/17
 * Time: 12:24
 */
@Qualifier
@java.lang.annotation.Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface FirstElement {
}
