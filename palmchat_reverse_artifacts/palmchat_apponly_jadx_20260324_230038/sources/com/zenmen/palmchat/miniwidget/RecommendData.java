package com.zenmen.palmchat.miniwidget;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RecommendData {
    public List<RecommendItem> list;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class RecommendItem {
        public String desc;
        public String icon;
        public String nickName;
        public String title;
        public String turnUrl;
    }
}
