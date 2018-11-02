package com.champion.bero.xdg_task.RetrofitWrapper;

import com.champion.bero.xdg_task.Model.Channel;
import com.champion.bero.xdg_task.Model.News;
import com.champion.bero.xdg_task.Model.Rss;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Champion on 24-Sep-18.
 */
public class APIHelperImpl implements APIHelper {


    @Override
    public void getBBCNews(Callback <Rss>callback) {
        Call<Rss> call = RetrofitClientInstance.getRetrofitInstance()
                .create(API.class).getBBCNews();
        call.enqueue(callback);
    }

}
