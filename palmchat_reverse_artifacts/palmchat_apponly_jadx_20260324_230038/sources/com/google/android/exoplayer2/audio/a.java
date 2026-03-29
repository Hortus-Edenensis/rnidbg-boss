package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.f;
import defpackage.g86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a implements com.google.android.exoplayer2.f {
    public static final a g = new e().a();
    public static final String h = g86.w0(0);
    public static final String i = g86.w0(1);
    public static final String j = g86.w0(2);
    public static final String k = g86.w0(3);
    public static final String l = g86.w0(4);
    public static final f.a<a> m = new f.a() { // from class: dj
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return a.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5830a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    @Nullable
    public d f;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(29)
    public static final class b {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(32)
    public static final class c {
        @DoNotInline
        public static void a(AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(21)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f5831a;

        public d(a aVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(aVar.f5830a).setFlags(aVar.b).setUsage(aVar.c);
            int i = g86.f17680a;
            if (i >= 29) {
                b.a(usage, aVar.d);
            }
            if (i >= 32) {
                c.a(usage, aVar.e);
            }
            this.f5831a = usage.build();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5832a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;
        public int e = 0;

        public a a() {
            return new a(this.f5832a, this.b, this.c, this.d, this.e);
        }

        public e b(int i) {
            this.d = i;
            return this;
        }

        public e c(int i) {
            this.f5832a = i;
            return this;
        }

        public e d(int i) {
            this.b = i;
            return this;
        }

        public e e(int i) {
            this.e = i;
            return this;
        }

        public e f(int i) {
            this.c = i;
            return this;
        }
    }

    public static /* synthetic */ a c(Bundle bundle) {
        e eVar = new e();
        String str = h;
        if (bundle.containsKey(str)) {
            eVar.c(bundle.getInt(str));
        }
        String str2 = i;
        if (bundle.containsKey(str2)) {
            eVar.d(bundle.getInt(str2));
        }
        String str3 = j;
        if (bundle.containsKey(str3)) {
            eVar.f(bundle.getInt(str3));
        }
        String str4 = k;
        if (bundle.containsKey(str4)) {
            eVar.b(bundle.getInt(str4));
        }
        String str5 = l;
        if (bundle.containsKey(str5)) {
            eVar.e(bundle.getInt(str5));
        }
        return eVar.a();
    }

    @RequiresApi(21)
    public d b() {
        if (this.f == null) {
            this.f = new d();
        }
        return this.f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5830a == aVar.f5830a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
    }

    public int hashCode() {
        return ((((((((527 + this.f5830a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(h, this.f5830a);
        bundle.putInt(i, this.b);
        bundle.putInt(j, this.c);
        bundle.putInt(k, this.d);
        bundle.putInt(l, this.e);
        return bundle;
    }

    public a(int i2, int i3, int i4, int i5, int i6) {
        this.f5830a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
    }
}
