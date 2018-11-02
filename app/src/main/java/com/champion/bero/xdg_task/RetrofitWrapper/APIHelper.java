package com.champion.bero.xdg_task.RetrofitWrapper;


import com.champion.bero.xdg_task.Model.Channel;
import com.champion.bero.xdg_task.Model.News;
import com.champion.bero.xdg_task.Model.Rss;

import retrofit2.Callback;

/**
 * Created by Champion on 24-Sep-18.
 */
public interface APIHelper {

    public void getBBCNews(Callback<Rss> callback);


}
