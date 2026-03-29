package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19109a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final m f;
    public final int g;

    @Nullable
    public final long[] h;

    @Nullable
    public final long[] i;
    public final int j;

    @Nullable
    public final mz5[] k;

    public lz5(int i, int i2, long j, long j2, long j3, m mVar, int i3, @Nullable mz5[] mz5VarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f19109a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = mVar;
        this.g = i3;
        this.k = mz5VarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    @Nullable
    public mz5 a(int i) {
        mz5[] mz5VarArr = this.k;
        if (mz5VarArr == null) {
            return null;
        }
        return mz5VarArr[i];
    }
}
