package com.zenmen.palmchat.friendcircle.netdao;

import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NetResponseData implements BaseBean {
    public String advId;
    public long clientId;
    public int commentNum;
    public List<Comment> comments;
    public String content;
    public String cover;
    public long createDt;
    public Feed feed;
    public long feedId;
    public int feedSource;
    public int feedType;
    public List<Feed> feeds;
    public boolean hasMore;
    public long lastTime;
    public List<Comment> likes;
    public Feed.Location location;
    public List<Media> mediaList;
    public int privateStatus;
    public List<Comment> showComments;
    public Feed.Source source;
    public int status;
    public long timestamp;
    public long tipVersion;
    public int total;
    public String uid;
    public long version;
}
