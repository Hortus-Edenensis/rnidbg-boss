package com.zenmen.palmchat.conversations.threadsnew.filter;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class FilterConfig {
    public List<Items> subtitles;
    public int chatting_days = 3;
    public float intimacy = 5.0f;
    public int hotChatCount = 50;
    public String intimacy_txt = null;
    public int msg_new_hours = 48;
    public String blank_txt = "还没有消息，去地图找找附近好友";
    public String blank_button = "立即找朋友";
    public String blank_url = "zenxin://activity?page=a0406&openMap=true&directEnter=true";

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Items {
        public String name;
        public String type;

        public Items(String str, String str2) {
            this.type = str;
            this.name = str2;
        }
    }

    public static FilterConfig getDefaultFilterConfig() {
        FilterConfig filterConfig = new FilterConfig();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Items(FilterType.NEW.value, "新招呼"));
        arrayList.add(new Items(FilterType.HOT.value, "热聊中"));
        arrayList.add(new Items(FilterType.INTIMACY.value, "亲密好友"));
        arrayList.add(new Items(FilterType.ALL.value, "全部"));
        filterConfig.subtitles = arrayList;
        return filterConfig;
    }

    public long getHotChatInterval() {
        return ((long) (this.chatting_days * 24 * 60 * 60)) * 1000;
    }

    public long getNewMsgInterval() {
        return ((long) (this.msg_new_hours * 60 * 60)) * 1000;
    }
}
