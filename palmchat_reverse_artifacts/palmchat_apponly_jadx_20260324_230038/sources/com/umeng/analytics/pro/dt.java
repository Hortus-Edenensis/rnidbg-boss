package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class dt extends du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f10937a;
    private int b;
    private int c;

    public dt() {
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() throws dv {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
    }

    public void e() {
        this.f10937a = null;
    }

    @Override // com.umeng.analytics.pro.du
    public byte[] f() {
        return this.f10937a;
    }

    @Override // com.umeng.analytics.pro.du
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.du
    public int h() {
        return this.c - this.b;
    }

    public dt(byte[] bArr) {
        a(bArr);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i, int i2) throws dv {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f10937a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i, int i2) throws dv {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.f10937a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public dt(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.du
    public void a(int i) {
        this.b += i;
    }
}
