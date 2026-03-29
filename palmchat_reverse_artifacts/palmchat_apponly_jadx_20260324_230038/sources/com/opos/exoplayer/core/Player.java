package com.opos.exoplayer.core;

import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface Player {

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements b {
        @Override // com.opos.exoplayer.core.Player.b
        public void a(int i) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(n nVar) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(com.opos.exoplayer.core.source.p pVar, com.opos.exoplayer.core.c.g gVar) {
        }

        @Deprecated
        public void a(w wVar, Object obj) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(w wVar, Object obj, int i) {
            a(wVar, obj);
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(boolean z) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void a(boolean z, int i) {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void e_() {
        }

        @Override // com.opos.exoplayer.core.Player.b
        public void b(int i) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);

        void a(ExoPlaybackException exoPlaybackException);

        void a(n nVar);

        void a(com.opos.exoplayer.core.source.p pVar, com.opos.exoplayer.core.c.g gVar);

        void a(w wVar, Object obj, int i);

        void a(boolean z);

        void a(boolean z, int i);

        void b(int i);

        void e_();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(com.opos.exoplayer.core.text.h hVar);

        void b(com.opos.exoplayer.core.text.h hVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.opos.exoplayer.core.video.e eVar);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.opos.exoplayer.core.video.e eVar);
    }

    @Nullable
    d a();

    void a(int i);

    void a(int i, long j);

    void a(long j);

    void a(b bVar);

    void a(boolean z);

    int b(int i);

    @Nullable
    c b();

    void b(b bVar);

    int c();

    boolean d();

    n e();

    void f();

    com.opos.exoplayer.core.c.g g();

    w h();

    int i();

    int j();

    int k();

    long l();

    long m();

    long n();

    boolean o();

    long p();
}
