package com.zenmen.square.mvp.model.bean;

import com.zenmen.listui.list.BaseBean;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicResp implements BaseBean {
    public Plot activity;
    public String buttonIconUrl;
    public String buttonText;
    public String emptyListText;
    public List<SquareFeed> feeds;
    public String publishButtonIcon;
    public String publishButtonText;
    public String publishButtonUrl;
    public String toast;
    public String topic;
    public String topicDesc;

    /* JADX INFO: compiled from: SearchBox */
    public static class Plot {
        public String detailUrl;
        public boolean end;
        public long id;
        public String rule;
        public String time;
    }
}
