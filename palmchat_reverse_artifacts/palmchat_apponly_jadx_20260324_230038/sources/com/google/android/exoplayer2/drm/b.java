package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.i;
import defpackage.g86;
import defpackage.vh;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface b {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5859a;

        @Nullable
        public final i.b b;
        public final CopyOnWriteArrayList<C0351a> c;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C0351a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f5860a;
            public b b;

            public C0351a(Handler handler, b bVar) {
                this.f5860a = handler;
                this.b = bVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(b bVar) {
            bVar.t(this.f5859a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(b bVar) {
            bVar.y(this.f5859a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(b bVar) {
            bVar.v(this.f5859a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(b bVar, int i) {
            bVar.z(this.f5859a, this.b);
            bVar.u(this.f5859a, this.b, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(b bVar, Exception exc) {
            bVar.C(this.f5859a, this.b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(b bVar) {
            bVar.K(this.f5859a, this.b);
        }

        public void g(Handler handler, b bVar) {
            vh.e(handler);
            vh.e(bVar);
            this.c.add(new C0351a(handler, bVar));
        }

        public void h() {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: uh1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21212a.n(bVar);
                    }
                });
            }
        }

        public void i() {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: rh1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20477a.o(bVar);
                    }
                });
            }
        }

        public void j() {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: xh1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21959a.p(bVar);
                    }
                });
            }
        }

        public void k(final int i) {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: oh1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19768a.q(bVar, i);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: lh1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18976a.r(bVar, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0351a c0351a : this.c) {
                final b bVar = c0351a.b;
                g86.Q0(c0351a.f5860a, new Runnable() { // from class: ih1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18166a.s(bVar);
                    }
                });
            }
        }

        public void t(b bVar) {
            for (C0351a c0351a : this.c) {
                if (c0351a.b == bVar) {
                    this.c.remove(c0351a);
                }
            }
        }

        @CheckResult
        public a u(int i, @Nullable i.b bVar) {
            return new a(this.c, i, bVar);
        }

        public a(CopyOnWriteArrayList<C0351a> copyOnWriteArrayList, int i, @Nullable i.b bVar) {
            this.c = copyOnWriteArrayList;
            this.f5859a = i;
            this.b = bVar;
        }
    }

    void C(int i, @Nullable i.b bVar, Exception exc);

    void K(int i, @Nullable i.b bVar);

    void t(int i, @Nullable i.b bVar);

    void u(int i, @Nullable i.b bVar, int i2);

    void v(int i, @Nullable i.b bVar);

    void y(int i, @Nullable i.b bVar);

    @Deprecated
    void z(int i, @Nullable i.b bVar);
}
