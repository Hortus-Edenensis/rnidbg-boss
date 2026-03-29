package com.igexin.push.d.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class l extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7322a = 36;
    public long b;

    public l() {
        this.m = 36;
        this.n = (byte) 20;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        this.b = com.igexin.c.a.b.g.d(bArr, 0);
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte[] bArr = new byte[8];
        com.igexin.c.a.b.g.a(this.b, bArr, 0);
        return bArr;
    }
}
