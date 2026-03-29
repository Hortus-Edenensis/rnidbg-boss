package com.zenmen.square.fragment.online;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class OnLineItemData {
    public String avatar;
    public String bgColor;
    public String content;
    public int gender;
    public boolean hasMineAnim = false;
    public boolean hasShowEvent;
    public String id;
    public int mineType;
    public int onlineStatus;
    public int scheduleTag;
    public int type;
    public long uid;
    public String url;

    @NonNull
    public String toString() {
        return "content:" + this.content + " id " + this.id + " scheduleTag " + this.scheduleTag + " uid " + this.uid;
    }
}
