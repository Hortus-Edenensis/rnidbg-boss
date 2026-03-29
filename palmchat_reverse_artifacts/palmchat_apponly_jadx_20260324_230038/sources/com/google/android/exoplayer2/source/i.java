package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import defpackage.bk4;
import defpackage.hi1;
import defpackage.kk3;
import defpackage.od0;
import defpackage.u06;
import defpackage.w9;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface i {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        a a(od0.a aVar);

        a b(com.google.android.exoplayer2.upstream.f fVar);

        i c(com.google.android.exoplayer2.p pVar);

        a d(hi1 hi1Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends kk3 {
        public b(Object obj) {
            super(obj);
        }

        public b c(Object obj) {
            return new b(super.a(obj));
        }

        public b(Object obj, long j) {
            super(obj, j);
        }

        public b(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public b(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public b(kk3 kk3Var) {
            super(kk3Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(i iVar, e0 e0Var);
    }

    void a(c cVar);

    void b(j jVar);

    h c(b bVar, w9 w9Var, long j);

    void e(Handler handler, j jVar);

    void f(h hVar);

    void g(c cVar);

    @Nullable
    e0 getInitialTimeline();

    com.google.android.exoplayer2.p getMediaItem();

    void h(c cVar);

    void i(Handler handler, com.google.android.exoplayer2.drm.b bVar);

    boolean isSingleWindow();

    void j(com.google.android.exoplayer2.drm.b bVar);

    void k(c cVar, @Nullable u06 u06Var, bk4 bk4Var);

    void maybeThrowSourceInfoRefreshError() throws IOException;
}
