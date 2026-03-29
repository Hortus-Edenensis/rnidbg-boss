package defpackage;

import androidx.media3.muxer.MuxerUtil;
import j$.util.Objects;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ej0<K, V> extends bj0<K, V> {
    public transient long[] k;
    public transient int l;
    public transient int m;
    public final boolean n;

    public ej0() {
        this(3);
    }

    public static <K, V> ej0<K, V> r0() {
        return new ej0<>();
    }

    public static <K, V> ej0<K, V> s0(int i) {
        return new ej0<>(i);
    }

    @Override // defpackage.bj0
    public Map<K, V> E(int i) {
        return new LinkedHashMap(i, 1.0f, this.n);
    }

    @Override // defpackage.bj0
    public int M() {
        return this.l;
    }

    @Override // defpackage.bj0
    public int N(int i) {
        return ((int) u0(i)) - 1;
    }

    @Override // defpackage.bj0
    public void S(int i) {
        super.S(i);
        this.l = -2;
        this.m = -2;
    }

    @Override // defpackage.bj0
    public void T(int i, K k, V v, int i2, int i3) {
        super.T(i, k, v, i2, i3);
        y0(this.m, i);
        y0(i, -2);
    }

    @Override // defpackage.bj0
    public void b0(int i, int i2) {
        int size = size() - 1;
        super.b0(i, i2);
        y0(t0(i), N(i));
        if (i < size) {
            y0(t0(size), i);
            y0(i, N(size));
        }
        w0(size, 0L);
    }

    @Override // defpackage.bj0, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (c0()) {
            return;
        }
        this.l = -2;
        this.m = -2;
        long[] jArr = this.k;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // defpackage.bj0
    public void i0(int i) {
        super.i0(i);
        this.k = Arrays.copyOf(v0(), i);
    }

    public final int t0(int i) {
        return ((int) (u0(i) >>> 32)) - 1;
    }

    @Override // defpackage.bj0
    public void u(int i) {
        if (this.n) {
            y0(t0(i), N(i));
            y0(this.m, i);
            y0(i, -2);
            Q();
        }
    }

    public final long u0(int i) {
        return v0()[i];
    }

    @Override // defpackage.bj0
    public int v(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    public final long[] v0() {
        long[] jArr = this.k;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    @Override // defpackage.bj0
    public int w() {
        int iW = super.w();
        this.k = new long[iW];
        return iW;
    }

    public final void w0(int i, long j) {
        v0()[i] = j;
    }

    public final void x0(int i, int i2) {
        w0(i, (u0(i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) (i2 + 1)) << 32));
    }

    public final void y0(int i, int i2) {
        if (i == -2) {
            this.l = i2;
        } else {
            z0(i, i2);
        }
        if (i2 == -2) {
            this.m = i;
        } else {
            x0(i2, i);
        }
    }

    @Override // defpackage.bj0
    public Map<K, V> z() {
        Map<K, V> mapZ = super.z();
        this.k = null;
        return mapZ;
    }

    public final void z0(int i, int i2) {
        w0(i, (u0(i) & (-4294967296L)) | (((long) (i2 + 1)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    public ej0(int i) {
        this(i, false);
    }

    public ej0(int i, boolean z) {
        super(i);
        this.n = z;
    }
}
