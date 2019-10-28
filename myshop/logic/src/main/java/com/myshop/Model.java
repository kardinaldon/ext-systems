package com.myshop;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Model implements Serializable {
    private List<String> list = Arrays.asList(new String[]{"first", "second", "third"});
    public List<String> getList() {
        return list;
    }
}
