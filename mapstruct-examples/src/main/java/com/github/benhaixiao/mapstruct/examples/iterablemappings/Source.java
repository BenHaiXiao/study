package com.github.benhaixiao.mapstruct.examples.iterablemappings;

import java.util.List;

/**
 * Created by BenHaiXiao
 * Date: 2016/12/17
 * Time: 12:20
 */
public class Source{

    private List<Integer> myIntegers;

    private List<String> myStrings;

    public List<Integer> getMyIntegers() {
        return myIntegers;
    }

    public void setMyIntegers( List<Integer> myIntegers ) {
        this.myIntegers = myIntegers;
    }

    public List<String> getMyStrings() {
        return myStrings;
    }

    public void setMyStrings( List<String> myStrings ) {
        this.myStrings = myStrings;
    }

}
