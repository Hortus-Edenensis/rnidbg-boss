package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleTagItem implements Serializable {
    private long rid;
    private long tagId;
    private String tagName;

    public long getRid() {
        return this.rid;
    }

    public long getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public void setTagId(long j) {
        this.tagId = j;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
