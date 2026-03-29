package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d0;
import com.google.android.exoplayer2.f;
import defpackage.g86;
import defpackage.m54;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d0 extends y {
    public static final String e = g86.w0(1);
    public static final String f = g86.w0(2);
    public static final f.a<d0> g = new f.a() { // from class: hx5
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return d0.d(bundle);
        }
    };
    public final boolean c;
    public final boolean d;

    public d0() {
        this.c = false;
        this.d = false;
    }

    public static d0 d(Bundle bundle) {
        vh.a(bundle.getInt(y.f6047a, -1) == 3);
        return bundle.getBoolean(e, false) ? new d0(bundle.getBoolean(f, false)) : new d0();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.d == d0Var.d && this.c == d0Var.c;
    }

    public int hashCode() {
        return m54.b(Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(y.f6047a, 3);
        bundle.putBoolean(e, this.c);
        bundle.putBoolean(f, this.d);
        return bundle;
    }

    public d0(boolean z) {
        this.c = true;
        this.d = z;
    }
}
