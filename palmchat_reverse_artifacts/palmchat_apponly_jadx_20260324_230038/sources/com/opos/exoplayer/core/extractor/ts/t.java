package com.opos.exoplayer.core.extractor.ts;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8248a;
    public int b;
    private final int c;
    private boolean d;
    private boolean e;

    public t(int i, int i2) {
        this.c = i;
        byte[] bArr = new byte[i2 + 3];
        this.f8248a = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.d = false;
        this.e = false;
    }

    public boolean b() {
        return this.e;
    }

    public void a(int i) {
        com.opos.exoplayer.core.util.a.b(!this.d);
        boolean z = i == this.c;
        this.d = z;
        if (z) {
            this.b = 3;
            this.e = false;
        }
    }

    public boolean b(int i) {
        if (!this.d) {
            return false;
        }
        this.b -= i;
        this.d = false;
        this.e = true;
        return true;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f8248a;
            int length = bArr2.length;
            int i4 = this.b + i3;
            if (length < i4) {
                this.f8248a = Arrays.copyOf(bArr2, i4 * 2);
            }
            System.arraycopy(bArr, i, this.f8248a, this.b, i3);
            this.b += i3;
        }
    }
}
