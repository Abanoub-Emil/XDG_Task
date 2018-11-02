package com.champion.bero.xdg_task.UI.Activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.champion.bero.xdg_task.Model.Channel;
import com.champion.bero.xdg_task.Model.News;
import com.champion.bero.xdg_task.Model.Rss;
import com.champion.bero.xdg_task.Components.ScrollTextView;
import com.champion.bero.xdg_task.R;
import com.champion.bero.xdg_task.RetrofitWrapper.APIHelper;
import com.champion.bero.xdg_task.RetrofitWrapper.APIHelperImpl;
import com.champion.bero.xdg_task.UI.Presenter.MainActivityPresenterImpl;
import com.champion.bero.xdg_task.UI.Presenter.MainActivityPresenterInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    @BindView(R.id.marquee) ScrollTextView marquee;
    @BindView(R.id.newsEditText) EditText newNews;
    @BindView(R.id.appendBtn) Button append;
    private MainActivityPresenterInterface mainPresenter;
    private long speed = 10000;
    StringBuilder text = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter =  new MainActivityPresenterImpl(this);
        mainPresenter.requestNews();

        marquee.setText("Hello To XDG Teleprompter Application");
        marquee.setRndDuration(marquee.getText().length()*100);
        startScroll();

    }


    public void startScroll(){
        marquee.startScroll();
    }

    public void appendBtn(View v){
        appendToMarquee(newNews.getText().toString());
        newNews.setText("");
//        Toast.makeText(this, ""+marquee.getText().length()+"\n"+marquee.getRndDuration(), Toast.LENGTH_SHORT).show();
    }

    public void increaseFont(View v){
        float fontSize = marquee.getTextSize();
        fontSize = fontSize/2 + 5;
        if (fontSize > 80) {
            Toast.makeText(this, "This is the max Font size", Toast.LENGTH_SHORT).show();
            return;
        }
        marquee.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
    }

    public void decreaseFont(View v){
        float fontSize = marquee.getTextSize();
        fontSize = fontSize/2 - 5;
        if (fontSize < 10) {
            Toast.makeText(this, "This is the min Font size", Toast.LENGTH_SHORT).show();
            return;
        }
        marquee.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
    }

    private void appendToMarquee (String news){
        marquee.append("  <^_^>  ");
        marquee.append(news);
        marquee.setRndDuration(marquee.getText().length()*100);
    }

    public void appendToMarquee(StringBuilder news){
        marquee.setText(news.toString());
        marquee.setRndDuration(marquee.getText().length()*100);
    }

    public void increaseSpeed(View v){
        speed = marquee.getRndDuration();
        marquee.setRndDuration((long)(speed * 0.8));
        startScroll();
    }

    public void decreaseSpeed (View v){
        speed = marquee.getRndDuration();
        if (speed * 1.2 > Long.MAX_VALUE) return;
        marquee.setRndDuration((long)(speed * 1.2));
        startScroll();
    }

    public void getNews(View v){
        mainPresenter.getNews();
    }


}





//    protected void setMarqueeSpeed(TextView tv, float speed, boolean speedIsMultiplier) {
//
//        try {
//            Field f;
//            if (tv instanceof AppCompatTextView) {
//                f = tv.getClass().getSuperclass().getDeclaredField("mMarquee");
//            } else {
//                f = tv.getClass().getDeclaredField("mMarquee");
//            }
//            f.setAccessible(true);
//
//            Object marquee = f.get(tv);
//            if (marquee != null) {
//
//                String scrollSpeedFieldName = "mScrollUnit";
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//                    scrollSpeedFieldName = "mPixelsPerSecond";
//
//                Field mf = marquee.getClass().getDeclaredField(scrollSpeedFieldName);
//                mf.setAccessible(true);
//
//                float newSpeed = speed;
//                if (speedIsMultiplier)
//                    newSpeed = mf.getFloat(marquee) * speed;
//
//                mf.setFloat(marquee, newSpeed);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void setTextSpeed(long speed){
//        setMarqueeSpeed(marquee, speed, false);
//    }
