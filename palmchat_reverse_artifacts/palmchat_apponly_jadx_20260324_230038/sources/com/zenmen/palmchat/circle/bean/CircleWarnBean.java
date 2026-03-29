package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleWarnBean {
    public WarnExt info;

    /* JADX INFO: compiled from: SearchBox */
    public static class WarnExt {
        public String act;
        public String content;
        public WarnUserFrom from;
        public String roomId;
        public WarnUserTo to;
        public String type;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class WarnUserFrom {
        public String fromUserId;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class WarnUserTo {
        public String toUserId;
    }
}
