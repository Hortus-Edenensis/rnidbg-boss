package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import defpackage.g86;
import defpackage.lw0;
import defpackage.ow0;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface d {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f5838a;

        @Nullable
        public final d b;

        public a(@Nullable Handler handler, @Nullable d dVar) {
            this.f5838a = dVar != null ? (Handler) vh.e(handler) : null;
            this.b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i, long j, long j2) {
            ((d) g86.j(this.b)).onAudioUnderrun(i, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((d) g86.j(this.b)).onAudioCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((d) g86.j(this.b)).onAudioSinkError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j, long j2) {
            ((d) g86.j(this.b)).onAudioDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((d) g86.j(this.b)).onAudioDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(lw0 lw0Var) {
            lw0Var.c();
            ((d) g86.j(this.b)).c(lw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(lw0 lw0Var) {
            ((d) g86.j(this.b)).e(lw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(com.google.android.exoplayer2.m mVar, ow0 ow0Var) {
            ((d) g86.j(this.b)).h(mVar);
            ((d) g86.j(this.b)).a(mVar, ow0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j) {
            ((d) g86.j(this.b)).onAudioPositionAdvancing(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z) {
            ((d) g86.j(this.b)).onSkipSilenceEnabledChanged(z);
        }

        public void B(final long j) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: xk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21991a.y(j);
                    }
                });
            }
        }

        public void C(final boolean z) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: pl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20036a.z(z);
                    }
                });
            }
        }

        public void D(final int i, final long j, final long j2) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: sl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20773a.A(i, j, j2);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: jl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18429a.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: gl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17745a.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j, final long j2) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ml
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19260a.t(str, j, j2);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ok
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19782a.u(str);
                    }
                });
            }
        }

        public void o(final lw0 lw0Var) {
            lw0Var.c();
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: al
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1248a.v(lw0Var);
                    }
                });
            }
        }

        public void p(final lw0 lw0Var) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: dl
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17067a.w(lw0Var);
                    }
                });
            }
        }

        public void q(final com.google.android.exoplayer2.m mVar, @Nullable final ow0 ow0Var) {
            Handler handler = this.f5838a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: uk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21231a.x(mVar, ow0Var);
                    }
                });
            }
        }
    }

    void a(com.google.android.exoplayer2.m mVar, @Nullable ow0 ow0Var);

    void c(lw0 lw0Var);

    void e(lw0 lw0Var);

    @Deprecated
    void h(com.google.android.exoplayer2.m mVar);

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onAudioDecoderReleased(String str);

    void onAudioPositionAdvancing(long j);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i, long j, long j2);

    void onSkipSilenceEnabledChanged(boolean z);
}
