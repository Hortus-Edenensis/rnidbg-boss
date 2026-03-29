package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.n;
import defpackage.g86;
import defpackage.m54;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n extends y {
    public static final String e = g86.w0(1);
    public static final String f = g86.w0(2);
    public static final f.a<n> g = new f.a() { // from class: ch2
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return n.d(bundle);
        }
    };
    public final boolean c;
    public final boolean d;

    public n() {
        this.c = false;
        this.d = false;
    }

    public static n d(Bundle bundle) {
        vh.a(bundle.getInt(y.f6047a, -1) == 0);
        return bundle.getBoolean(e, false) ? new n(bundle.getBoolean(f, false)) : new n();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.d == nVar.d && this.c == nVar.c;
    }

    public int hashCode() {
        return m54.b(Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(y.f6047a, 0);
        bundle.putBoolean(e, this.c);
        bundle.putBoolean(f, this.d);
        return bundle;
    }

    public n(boolean z) {
        this.c = true;
        this.d = z;
    }
}
