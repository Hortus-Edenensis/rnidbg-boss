package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class l73 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18923a;
    public long[] b;

    public l73() {
        this(32);
    }

    public void a(long j) {
        int i = this.f18923a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f18923a;
        this.f18923a = i2 + 1;
        jArr2[i2] = j;
    }

    public long b(int i) {
        if (i >= 0 && i < this.f18923a) {
            return this.b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f18923a);
    }

    public int c() {
        return this.f18923a;
    }

    public long[] d() {
        return Arrays.copyOf(this.b, this.f18923a);
    }

    public l73(int i) {
        this.b = new long[i];
    }
}
