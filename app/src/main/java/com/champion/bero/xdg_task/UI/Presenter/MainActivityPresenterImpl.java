package com.champion.bero.xdg_task.UI.Presenter;

import android.widget.Toast;

import com.champion.bero.xdg_task.Model.Channel;
import com.champion.bero.xdg_task.Model.News;
import com.champion.bero.xdg_task.Model.Rss;
import com.champion.bero.xdg_task.RetrofitWrapper.APIHelper;
import com.champion.bero.xdg_task.RetrofitWrapper.APIHelperImpl;
import com.champion.bero.xdg_task.UI.Activity.MainActivity;
import com.champion.bero.xdg_task.UI.Activity.MainActivityInterface;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Champion on 02-Nov-18.
 */
public class MainActivityPresenterImpl implements MainActivityPresenterInterface {

    MainActivityInterface mainView;
    private ArrayList<News> newsList = new ArrayList<>();
    APIHelper apiHelper = new APIHelperImpl();
    StringBuilder bbcNews = new StringBuilder();


    public MainActivityPresenterImpl(MainActivityInterface mainView) {
        this.mainView = mainView;
    }

    public void requestNews() {
        try {
            apiHelper.getBBCNews(new Callback<Rss>() {
                @Override
                public void onResponse(Call<Rss> call, Response<Rss> response) {
                    Rss rss = response.body();
                    Channel channel = rss.getChannel();
                    newsList = (ArrayList<News>) channel.getAllNews();
                    for (News news : newsList) {
                        bbcNews.append(news.getDescription() + "  <^_^>  ");
                    }
                }

                @Override
                public void onFailure(Call<Rss> call, Throwable t) {
                    System.out.println(t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    public void getNews(){
        mainView.appendToMarquee(bbcNews);
         Timer timer = new Timer();

        TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run() {
                requestNews();
            }
        };

// schedule the task to run starting now and then every hour...
        timer.schedule(hourlyTask,0l,1000*60*60);
    }

}
