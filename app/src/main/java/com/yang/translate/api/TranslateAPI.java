package com.yang.translate.api;

import java.util.List;

/**
 * Created by qinfeng on 2016/8/23.
 */
public class TranslateAPI {
    public int errorCode;
    public String query;
    public List<String> translation;

    @Override
    public String toString() {
        return "TranslateAPI{" +
                "errorCode=" + errorCode +
                ", query='" + query + '\'' +
                ", translation=" + translation +
                '}';
    }
}
