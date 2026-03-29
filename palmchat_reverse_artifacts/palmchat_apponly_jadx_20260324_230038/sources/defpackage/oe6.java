package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface oe6 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Handler f19750a;

        @Nullable
        public final oe6 b;

        public a(@Nullable Handler handler, @Nullable oe6 oe6Var) {
            this.f19750a = oe6Var != null ? (Handler) vh.e(handler) : null;
            this.b = oe6Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j, long j2) {
            ((oe6) g86.j(this.b)).onVideoDecoderInitialized(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((oe6) g86.j(this.b)).onVideoDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(lw0 lw0Var) {
            lw0Var.c();
            ((oe6) g86.j(this.b)).j(lw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i, long j) {
            ((oe6) g86.j(this.b)).onDroppedFrames(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(lw0 lw0Var) {
            ((oe6) g86.j(this.b)).b(lw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(m mVar, ow0 ow0Var) {
            ((oe6) g86.j(this.b)).l(mVar);
            ((oe6) g86.j(this.b)).k(mVar, ow0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j) {
            ((oe6) g86.j(this.b)).onRenderedFirstFrame(obj, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j, int i) {
            ((oe6) g86.j(this.b)).onVideoFrameProcessingOffset(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((oe6) g86.j(this.b)).onVideoCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(te6 te6Var) {
            ((oe6) g86.j(this.b)).i(te6Var);
        }

        public void A(final Object obj) {
            if (this.f19750a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f19750a.post(new Runnable() { // from class: fe6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17520a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j, final int i) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: wd6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21680a.x(j, i);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ce6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1967a.y(exc);
                    }
                });
            }
        }

        public void D(final te6 te6Var) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: td6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20969a.z(te6Var);
                    }
                });
            }
        }

        public void k(final String str, final long j, final long j2) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: le6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18966a.q(str, j, j2);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: qd6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20236a.r(str);
                    }
                });
            }
        }

        public void m(final lw0 lw0Var) {
            lw0Var.c();
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: jd6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18388a.s(lw0Var);
                    }
                });
            }
        }

        public void n(final int i, final long j) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ie6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18153a.t(i, j);
                    }
                });
            }
        }

        public void o(final lw0 lw0Var) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: nd6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19495a.u(lw0Var);
                    }
                });
            }
        }

        public void p(final m mVar, @Nullable final ow0 ow0Var) {
            Handler handler = this.f19750a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: zd6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22397a.v(mVar, ow0Var);
                    }
                });
            }
        }
    }

    void b(lw0 lw0Var);

    void i(te6 te6Var);

    void j(lw0 lw0Var);

    void k(m mVar, @Nullable ow0 ow0Var);

    @Deprecated
    void l(m mVar);

    void onDroppedFrames(int i, long j);

    void onRenderedFirstFrame(Object obj, long j);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void onVideoDecoderReleased(String str);

    void onVideoFrameProcessingOffset(long j, int i);
}
