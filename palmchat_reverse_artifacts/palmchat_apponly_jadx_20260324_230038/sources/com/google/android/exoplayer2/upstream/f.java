package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import defpackage.kh3;
import defpackage.m43;
import defpackage.vh;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface f {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6024a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, int i4) {
            this.f6024a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(int i) {
            if (i == 1) {
                if (this.f6024a - this.b <= 1) {
                    return false;
                }
            } else if (this.c - this.d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6025a;
        public final long b;

        public b(int i, long j) {
            vh.a(j >= 0);
            this.f6025a = i;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m43 f6026a;
        public final kh3 b;
        public final IOException c;
        public final int d;

        public c(m43 m43Var, kh3 kh3Var, IOException iOException, int i) {
            this.f6026a = m43Var;
            this.b = kh3Var;
            this.c = iOException;
            this.d = i;
        }
    }

    long a(c cVar);

    @Nullable
    b b(a aVar, c cVar);

    int getMinimumLoadableRetryCount(int i);

    void onLoadTaskConcluded(long j);
}
