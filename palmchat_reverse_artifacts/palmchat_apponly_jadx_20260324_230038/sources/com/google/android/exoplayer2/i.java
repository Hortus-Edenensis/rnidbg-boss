package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i;
import defpackage.g86;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class i implements f {
    public static final i e = new b(0).e();
    public static final String f = g86.w0(0);
    public static final String g = g86.w0(1);
    public static final String h = g86.w0(2);
    public static final String i = g86.w0(3);
    public static final f.a<i> j = new f.a() { // from class: ub1
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return i.b(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5878a;

    @IntRange(from = 0)
    public final int b;

    @IntRange(from = 0)
    public final int c;

    @Nullable
    public final String d;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5879a;
        public int b;
        public int c;

        @Nullable
        public String d;

        public b(int i) {
            this.f5879a = i;
        }

        public i e() {
            vh.a(this.b <= this.c);
            return new i(this);
        }

        public b f(@IntRange(from = 0) int i) {
            this.c = i;
            return this;
        }

        public b g(@IntRange(from = 0) int i) {
            this.b = i;
            return this;
        }

        public b h(@Nullable String str) {
            vh.a(this.f5879a != 0 || str == null);
            this.d = str;
            return this;
        }
    }

    public static /* synthetic */ i b(Bundle bundle) {
        int i2 = bundle.getInt(f, 0);
        int i3 = bundle.getInt(g, 0);
        int i4 = bundle.getInt(h, 0);
        return new b(i2).g(i3).f(i4).h(bundle.getString(i)).e();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5878a == iVar.f5878a && this.b == iVar.b && this.c == iVar.c && g86.c(this.d, iVar.d);
    }

    public int hashCode() {
        int i2 = (((((527 + this.f5878a) * 31) + this.b) * 31) + this.c) * 31;
        String str = this.d;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        int i2 = this.f5878a;
        if (i2 != 0) {
            bundle.putInt(f, i2);
        }
        int i3 = this.b;
        if (i3 != 0) {
            bundle.putInt(g, i3);
        }
        int i4 = this.c;
        if (i4 != 0) {
            bundle.putInt(h, i4);
        }
        String str = this.d;
        if (str != null) {
            bundle.putString(i, str);
        }
        return bundle;
    }

    public i(b bVar) {
        this.f5878a = bVar.f5879a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
    }
}
