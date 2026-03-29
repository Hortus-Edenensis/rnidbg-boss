package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.m;
import defpackage.ai1;
import defpackage.bk4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5861a;

    @Deprecated
    public static final c b;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5862a = new b() { // from class: di1
            @Override // com.google.android.exoplayer2.drm.c.b
            public final void release() {
                fi1.a();
            }
        };

        void release();
    }

    static {
        a aVar = new a();
        f5861a = aVar;
        b = aVar;
    }

    void a(Looper looper, bk4 bk4Var);

    @Nullable
    DrmSession b(@Nullable b.a aVar, m mVar);

    b c(@Nullable b.a aVar, m mVar);

    int d(m mVar);

    void prepare();

    void release();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c {
        @Override // com.google.android.exoplayer2.drm.c
        @Nullable
        public DrmSession b(@Nullable b.a aVar, m mVar) {
            if (mVar.o == null) {
                return null;
            }
            return new f(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ b c(b.a aVar, m mVar) {
            return ai1.a(this, aVar, mVar);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public int d(m mVar) {
            return mVar.o != null ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void prepare() {
            ai1.b(this);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void release() {
            ai1.c(this);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public void a(Looper looper, bk4 bk4Var) {
        }
    }
}
