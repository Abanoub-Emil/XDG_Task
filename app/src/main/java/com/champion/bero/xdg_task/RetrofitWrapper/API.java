package com.champion.bero.xdg_task.RetrofitWrapper;


import com.champion.bero.xdg_task.Model.Channel;
import com.champion.bero.xdg_task.Model.News;
import com.champion.bero.xdg_task.Model.Rss;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Champion on 23-Sep-18.
 */
public interface API {

    @GET("technology/rss.xml")
    Call<Rss> getBBCNews();
}
