package com.zenmen.palmchat.circle.label.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RoomTag implements Serializable {
    public String tagId;
    public String tagName;

    public String toString() {
        return "{tagName:'" + this.tagName + "'}";
    }
}
