package com.champion.bero.xdg_task.UI.Activity;

import android.view.View;

import com.champion.bero.xdg_task.Model.News;

import java.util.ArrayList;

/**
 * Created by Champion on 02-Nov-18.
 */
public interface MainActivityInterface {

    void startScroll();
    void appendToMarquee(StringBuilder news);

}
