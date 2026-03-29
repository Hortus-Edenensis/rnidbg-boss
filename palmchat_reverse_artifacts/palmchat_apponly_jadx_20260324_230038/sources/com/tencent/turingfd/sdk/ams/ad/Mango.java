package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Mango {
    public static final byte[] e = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10720a;
    public final int b;
    public final int c;
    public final byte[] d;

    public Mango(int i, byte[] bArr, int i2, int i3) {
        this.f10720a = i;
        this.d = bArr;
        this.b = i2;
        this.c = i3;
    }

    public static Mango a(int i) {
        return new Mango(i, e, 0, 0);
    }

    public static Mango a(byte[] bArr) {
        return new Mango(0, bArr, 0, 0);
    }
}
