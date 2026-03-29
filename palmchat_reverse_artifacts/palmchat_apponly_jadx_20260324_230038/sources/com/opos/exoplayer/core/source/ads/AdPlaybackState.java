package com.opos.exoplayer.core.source.ads;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class AdPlaybackState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlaybackState f8286a = new AdPlaybackState(new long[0]);
    public final int b;
    public final long[] c;
    public final a[] d;
    public final long e;
    public final long f;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8287a;
        public final Uri[] b;
        public final int[] c;
        public final long[] d;

        public a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        public int a() {
            return a(-1);
        }

        public boolean b() {
            return this.f8287a == -1 || a() < this.f8287a;
        }

        private a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.opos.exoplayer.core.util.a.a(iArr.length == uriArr.length);
            this.f8287a = i;
            this.c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        public int a(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.c;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.b = length;
        this.c = Arrays.copyOf(jArr, length);
        this.d = new a[length];
        for (int i = 0; i < length; i++) {
            this.d[i] = new a();
        }
        this.e = 0L;
        this.f = -9223372036854775807L;
    }

    public int a(long j) {
        int length = this.c.length - 1;
        while (length >= 0) {
            long j2 = this.c[length];
            if (j2 != Long.MIN_VALUE && j2 <= j) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.d[length].b()) {
            return -1;
        }
        return length;
    }

    public int b(long j) {
        int i = 0;
        while (true) {
            long[] jArr = this.c;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j2 == Long.MIN_VALUE || (j < j2 && this.d[i].b())) {
                break;
            }
            i++;
        }
        if (i < this.c.length) {
            return i;
        }
        return -1;
    }
}
