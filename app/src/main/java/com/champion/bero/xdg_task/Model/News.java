package com.champion.bero.xdg_task.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Champion on 01-Nov-18.
 */
@Root(name = "item", strict=false)
public class News {
    @Element(name = "title", required = false)
    private String title;
    @Element(name = "description", required = false)
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
