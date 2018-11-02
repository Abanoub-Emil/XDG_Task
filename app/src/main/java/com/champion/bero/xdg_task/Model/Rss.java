package com.champion.bero.xdg_task.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Champion on 02-Nov-18.
 */
@Root(name = "rss", strict=false)
public class Rss
{
    @Element(name = "channel")
    private Channel channel;

    private String version;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+", version = "+version+"]";
    }
}
