package com.zenmen.square.mvp.model.bean;

import com.zenmen.listui.list.BaseBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RecommendResp implements BaseBean {
    public DiscussionalTopics discussionalTopics;
    public List<SquareFeed> feeds;
    public long resVersion;

    /* JADX INFO: compiled from: SearchBox */
    public static class DiscussionalTopics {
        public int index;
        public List<SquareDiscussionTopicBean> list;
        public String recommendTopicIcon;
        public String recommendTopicTitle;
    }
}
