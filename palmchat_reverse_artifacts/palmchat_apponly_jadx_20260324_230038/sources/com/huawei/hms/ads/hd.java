package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class hd {
    public static final int B = 100;
    public static final int Code = 0;
    public static final int I = 50;
    public static final int V = 25;
    public static final int Z = 75;

    public static int Code(float f, float f2) {
        if (f2 >= 75.0f && f < 75.0f) {
            return 75;
        }
        if (f2 < 50.0f || f >= 50.0f) {
            return (f2 < 25.0f || f >= 25.0f) ? 0 : 25;
        }
        return 50;
    }
}
