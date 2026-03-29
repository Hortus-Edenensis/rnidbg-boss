package com.zenmen.palmchat.conversations.threadsnew.riskthread;

import androidx.annotation.Keep;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RiskThreadItem {
    public String fid;
    public String icon;
    public String name;
    public long time;
    public String uid;

    public RiskThreadItem(String str) {
        this.uid = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.uid, ((RiskThreadItem) obj).uid);
    }

    public RiskThreadItem() {
    }
}
