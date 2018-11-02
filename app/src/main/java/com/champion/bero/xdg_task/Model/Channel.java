package com.champion.bero.xdg_task.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Champion on 02-Nov-18.
 */
@Root(name = "channel", strict=false)

public class Channel {
    @ElementList(name = "item", inline = true, required = false)
    private List<News> allNews;

    public List<News> getAllNews() {
        return allNews;
    }

    public void setAllNews(List<News> allNews) {
        this.allNews = allNews;
    }
}
