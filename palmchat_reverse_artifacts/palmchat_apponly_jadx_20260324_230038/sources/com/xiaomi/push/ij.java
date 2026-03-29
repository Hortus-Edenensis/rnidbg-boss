package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class ij extends ik {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f845a;
    private int b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.ik
    public int a_() {
        return this.f11651a;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f845a = bArr;
        this.f11651a = i;
        this.b = i + i2;
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i, int i2) {
        int iB = b();
        if (i2 > iB) {
            i2 = iB;
        }
        if (i2 > 0) {
            System.arraycopy(this.f845a, this.f11651a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.ik
    public int b() {
        return this.b - this.f11651a;
    }

    @Override // com.xiaomi.push.ik
    /* JADX INFO: renamed from: a */
    public void mo646a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ik
    public byte[] a() {
        return this.f845a;
    }

    @Override // com.xiaomi.push.ik
    public void a(int i) {
        this.f11651a += i;
    }
}
