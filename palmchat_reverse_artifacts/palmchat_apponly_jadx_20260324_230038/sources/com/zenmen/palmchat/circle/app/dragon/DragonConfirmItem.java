package com.zenmen.palmchat.circle.app.dragon;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DragonConfirmItem implements Serializable {
    public static long UNDEFINED_ID = -1;
    public String content;
    public long dragonId;

    @SerializedName("id")
    private long dragonItemId;

    @SerializedName("seq")
    public long sid;
    public long time;
    public String uid;

    @SerializedName("nickname")
    public String uname;

    public DragonConfirmItem() {
        long j = UNDEFINED_ID;
        this.sid = j;
        this.time = j;
    }

    public long getDragonItemId() {
        return this.dragonItemId;
    }

    public void setDragonItemId(long j) {
        this.dragonItemId = j;
    }
}
