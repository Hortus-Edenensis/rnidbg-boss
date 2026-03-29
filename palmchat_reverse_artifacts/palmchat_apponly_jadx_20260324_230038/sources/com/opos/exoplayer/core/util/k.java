package com.opos.exoplayer.core.util;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8395a;
    private long[] b;

    public k() {
        this(32);
    }

    public int a() {
        return this.f8395a;
    }

    public long[] b() {
        return Arrays.copyOf(this.b, this.f8395a);
    }

    public k(int i) {
        this.b = new long[i];
    }

    public long a(int i) {
        if (i >= 0 && i < this.f8395a) {
            return this.b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f8395a);
    }

    public void a(long j) {
        int i = this.f8395a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f8395a;
        this.f8395a = i2 + 1;
        jArr2[i2] = j;
    }
}
