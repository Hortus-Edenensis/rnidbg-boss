package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b0;
import com.google.android.exoplayer2.f;
import defpackage.g86;
import defpackage.m54;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b0 extends y {
    public static final String e = g86.w0(1);
    public static final String f = g86.w0(2);
    public static final f.a<b0> g = new f.a() { // from class: ik5
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return b0.d(bundle);
        }
    };

    @IntRange(from = 1)
    public final int c;
    public final float d;

    public b0(@IntRange(from = 1) int i) {
        vh.b(i > 0, "maxStars must be a positive integer");
        this.c = i;
        this.d = -1.0f;
    }

    public static b0 d(Bundle bundle) {
        vh.a(bundle.getInt(y.f6047a, -1) == 2);
        int i = bundle.getInt(e, 5);
        float f2 = bundle.getFloat(f, -1.0f);
        return f2 == -1.0f ? new b0(i) : new b0(i, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.c == b0Var.c && this.d == b0Var.d;
    }

    public int hashCode() {
        return m54.b(Integer.valueOf(this.c), Float.valueOf(this.d));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(y.f6047a, 2);
        bundle.putInt(e, this.c);
        bundle.putFloat(f, this.d);
        return bundle;
    }

    public b0(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f2) {
        vh.b(i > 0, "maxStars must be a positive integer");
        vh.b(f2 >= 0.0f && f2 <= ((float) i), "starRating is out of range [0, maxStars]");
        this.c = i;
        this.d = f2;
    }
}
