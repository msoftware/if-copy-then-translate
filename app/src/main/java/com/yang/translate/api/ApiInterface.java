package com.yang.translate.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {

    String HOST = "http://fanyi.youdao.com";

    @GET("/openapi.do")
    Observable<TranslateAPI> mTranslateAPI(@Query("keyfrom") String keyfrom,
                                           @Query("key") String key,
                                           @Query("type") String type,
                                           @Query("doctype") String doctype,
                                           @Query("version") String version,
                                           @Query("q") String q);

}