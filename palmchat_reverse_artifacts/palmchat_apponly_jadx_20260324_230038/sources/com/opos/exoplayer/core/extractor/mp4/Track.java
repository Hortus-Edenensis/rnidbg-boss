package com.opos.exoplayer.core.extractor.mp4;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Track {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8203a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final Format f;
    public final int g;

    @Nullable
    public final long[] h;

    @Nullable
    public final long[] i;
    public final int j;

    @Nullable
    private final c[] k;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable c[] cVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f8203a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = format;
        this.g = i3;
        this.k = cVarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public c a(int i) {
        c[] cVarArr = this.k;
        if (cVarArr == null) {
            return null;
        }
        return cVarArr[i];
    }
}
