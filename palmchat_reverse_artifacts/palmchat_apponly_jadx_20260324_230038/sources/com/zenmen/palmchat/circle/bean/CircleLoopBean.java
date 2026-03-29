package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleLoopBean {
    public List<LoopData> actBitList;
    public String hotSearchWord;

    /* JADX INFO: compiled from: SearchBox */
    public static class LoopData {
        public String cover;
        public String endTime;
        public long id;
        public int jumpMode;
        public String link;
        public String startTime;
        public String title;
    }
}
