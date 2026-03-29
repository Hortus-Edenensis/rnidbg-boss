package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f10904a;
    private int b = -1;

    public cf(int i) {
        this.f10904a = new short[i];
    }

    private void d() {
        short[] sArr = this.f10904a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f10904a = sArr2;
    }

    public short a() {
        short[] sArr = this.f10904a;
        int i = this.b;
        this.b = i - 1;
        return sArr[i];
    }

    public short b() {
        return this.f10904a[this.b];
    }

    public void c() {
        this.b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f10904a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.b) {
                sb.append(">>");
            }
            sb.append((int) this.f10904a[i]);
            if (i == this.b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.f10904a.length == this.b + 1) {
            d();
        }
        short[] sArr = this.f10904a;
        int i = this.b + 1;
        this.b = i;
        sArr[i] = s;
    }
}
