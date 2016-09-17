package com.yang.translate.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by zk on 2015/12/16.
 * update by hugo thanks for brucezz
 */
public class RetrofitSingleton {

    private static ApiInterface apiService = null;
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    private void init() {
        initOkHttp();
        initRetrofit();
        apiService = retrofit.create(ApiInterface.class);
    }

    private RetrofitSingleton() {
        init();
    }

    public static RetrofitSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private static void initRetrofit() {
        retrofit = new Retrofit.Builder()
            .baseUrl(ApiInterface.HOST)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    }

    public Observable<TranslateAPI> translate(String data) {
        return apiService.mTranslateAPI("magicFlinger", "741889180","data","json","1.1",data);
    }


}
