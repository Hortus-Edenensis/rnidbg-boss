package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.u;
import defpackage.g86;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class u implements f {
    public static final u d = new u(1.0f);
    public static final String e = g86.w0(0);
    public static final String f = g86.w0(1);
    public static final f.a<u> g = new f.a() { // from class: jj4
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return u.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5989a;
    public final float b;
    public final int c;

    public u(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this(f2, 1.0f);
    }

    public static /* synthetic */ u c(Bundle bundle) {
        return new u(bundle.getFloat(e, 1.0f), bundle.getFloat(f, 1.0f));
    }

    public long b(long j) {
        return j * ((long) this.c);
    }

    @CheckResult
    public u d(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        return new u(f2, this.b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.f5989a == uVar.f5989a && this.b == uVar.b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f5989a)) * 31) + Float.floatToRawIntBits(this.b);
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(e, this.f5989a);
        bundle.putFloat(f, this.b);
        return bundle;
    }

    public String toString() {
        return g86.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f5989a), Float.valueOf(this.b));
    }

    public u(@FloatRange(from = 0.0d, fromInclusive = false) float f2, @FloatRange(from = 0.0d, fromInclusive = false) float f3) {
        vh.a(f2 > 0.0f);
        vh.a(f3 > 0.0f);
        this.f5989a = f2;
        this.b = f3;
        this.c = Math.round(f2 * 1000.0f);
    }
}
