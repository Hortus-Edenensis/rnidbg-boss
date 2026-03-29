package com.zenmen.square.bean.req;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedsReqBean {
    public String cityCode;
    public String latitude;
    public String longitude;
    public int page;
    public String pageKey;
    public String pandaValueLx62476;
    public String reqId;
    public int sex;
    public List<UnReadFeedBean> unreadActivities;
    public String version;

    /* JADX INFO: compiled from: SearchBox */
    public static class UnReadFeedBean {
        public String exid;
        public long feedId;
    }
}
