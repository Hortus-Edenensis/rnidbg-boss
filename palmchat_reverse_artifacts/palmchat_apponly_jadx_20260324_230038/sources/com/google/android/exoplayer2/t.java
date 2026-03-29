package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.config.remote.RemoteConfig;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.t;
import defpackage.g86;
import defpackage.m54;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class t extends y {
    public static final String d = g86.w0(1);
    public static final f.a<t> e = new f.a() { // from class: kg4
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return t.d(bundle);
        }
    };
    public final float c;

    public t() {
        this.c = -1.0f;
    }

    public static t d(Bundle bundle) {
        vh.a(bundle.getInt(y.f6047a, -1) == 1);
        float f = bundle.getFloat(d, -1.0f);
        return f == -1.0f ? new t() : new t(f);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t) && this.c == ((t) obj).c;
    }

    public int hashCode() {
        return m54.b(Float.valueOf(this.c));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(y.f6047a, 1);
        bundle.putFloat(d, this.c);
        return bundle;
    }

    public t(@FloatRange(from = 0.0d, to = RemoteConfig.FULL_RATE) float f) {
        vh.b(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.c = f;
    }
}
