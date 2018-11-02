package com.champion.bero.xdg_task.RetrofitWrapper;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Champion on 23-Sep-18.
 */
public class RetrofitClientInstance  {

    private static Retrofit retrofit;
    private static String BASE_URL = "http://feeds.bbci.co.uk/news/";

    public static Retrofit getRetrofitInstance() {
        System.out.println(BASE_URL);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}