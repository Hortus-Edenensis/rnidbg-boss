package com.yuyakaido.android.cardstackview;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public enum Duration {
    Fast(100),
    Normal(250),
    Slow(500);

    public final int duration;

    Duration(int i) {
        this.duration = i;
    }

    public static Duration fromVelocity(int i) {
        return i < 1000 ? Slow : i < 5000 ? Normal : Fast;
    }
}
