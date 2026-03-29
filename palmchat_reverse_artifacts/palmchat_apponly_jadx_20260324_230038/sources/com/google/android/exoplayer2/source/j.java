package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.i;
import defpackage.g86;
import defpackage.kh3;
import defpackage.m43;
import defpackage.vh;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface j {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5968a;

        @Nullable
        public final i.b b;
        public final CopyOnWriteArrayList<C0358a> c;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.source.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C0358a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f5969a;
            public j b;

            public C0358a(Handler handler, j jVar) {
                this.f5969a = handler;
                this.b = jVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(j jVar, kh3 kh3Var) {
            jVar.h(this.f5968a, this.b, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(j jVar, m43 m43Var, kh3 kh3Var) {
            jVar.E(this.f5968a, this.b, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(j jVar, m43 m43Var, kh3 kh3Var) {
            jVar.q(this.f5968a, this.b, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(j jVar, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z) {
            jVar.J(this.f5968a, this.b, m43Var, kh3Var, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(j jVar, m43 m43Var, kh3 kh3Var) {
            jVar.H(this.f5968a, this.b, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(j jVar, i.b bVar, kh3 kh3Var) {
            jVar.A(this.f5968a, bVar, kh3Var);
        }

        public void A(final m43 m43Var, final kh3 kh3Var) {
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: nl3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19555a.n(jVar, m43Var, kh3Var);
                    }
                });
            }
        }

        public void B(j jVar) {
            for (C0358a c0358a : this.c) {
                if (c0358a.b == jVar) {
                    this.c.remove(c0358a);
                }
            }
        }

        public void C(int i, long j, long j2) {
            D(new kh3(1, i, null, 3, null, g86.m1(j), g86.m1(j2)));
        }

        public void D(final kh3 kh3Var) {
            final i.b bVar = (i.b) vh.e(this.b);
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: cm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2018a.o(jVar, bVar, kh3Var);
                    }
                });
            }
        }

        @CheckResult
        public a E(int i, @Nullable i.b bVar) {
            return new a(this.c, i, bVar);
        }

        public void g(Handler handler, j jVar) {
            vh.e(handler);
            vh.e(jVar);
            this.c.add(new C0358a(handler, jVar));
        }

        public void h(int i, @Nullable com.google.android.exoplayer2.m mVar, int i2, @Nullable Object obj, long j) {
            i(new kh3(1, i, mVar, i2, obj, g86.m1(j), -9223372036854775807L));
        }

        public void i(final kh3 kh3Var) {
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: ql3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20275a.j(jVar, kh3Var);
                    }
                });
            }
        }

        public void p(m43 m43Var, int i) {
            q(m43Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void q(m43 m43Var, int i, int i2, @Nullable com.google.android.exoplayer2.m mVar, int i3, @Nullable Object obj, long j, long j2) {
            r(m43Var, new kh3(i, i2, mVar, i3, obj, g86.m1(j), g86.m1(j2)));
        }

        public void r(final m43 m43Var, final kh3 kh3Var) {
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: zl3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22444a.k(jVar, m43Var, kh3Var);
                    }
                });
            }
        }

        public void s(m43 m43Var, int i) {
            t(m43Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void t(m43 m43Var, int i, int i2, @Nullable com.google.android.exoplayer2.m mVar, int i3, @Nullable Object obj, long j, long j2) {
            u(m43Var, new kh3(i, i2, mVar, i3, obj, g86.m1(j), g86.m1(j2)));
        }

        public void u(final m43 m43Var, final kh3 kh3Var) {
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: wl3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21745a.l(jVar, m43Var, kh3Var);
                    }
                });
            }
        }

        public void v(m43 m43Var, int i, int i2, @Nullable com.google.android.exoplayer2.m mVar, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
            x(m43Var, new kh3(i, i2, mVar, i3, obj, g86.m1(j), g86.m1(j2)), iOException, z);
        }

        public void w(m43 m43Var, int i, IOException iOException, boolean z) {
            v(m43Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void x(final m43 m43Var, final kh3 kh3Var, final IOException iOException, final boolean z) {
            for (C0358a c0358a : this.c) {
                final j jVar = c0358a.b;
                g86.Q0(c0358a.f5969a, new Runnable() { // from class: tl3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21019a.m(jVar, m43Var, kh3Var, iOException, z);
                    }
                });
            }
        }

        public void y(m43 m43Var, int i) {
            z(m43Var, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void z(m43 m43Var, int i, int i2, @Nullable com.google.android.exoplayer2.m mVar, int i3, @Nullable Object obj, long j, long j2) {
            A(m43Var, new kh3(i, i2, mVar, i3, obj, g86.m1(j), g86.m1(j2)));
        }

        public a(CopyOnWriteArrayList<C0358a> copyOnWriteArrayList, int i, @Nullable i.b bVar) {
            this.c = copyOnWriteArrayList;
            this.f5968a = i;
            this.b = bVar;
        }
    }

    void A(int i, i.b bVar, kh3 kh3Var);

    void E(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var);

    void H(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var);

    void J(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z);

    void h(int i, @Nullable i.b bVar, kh3 kh3Var);

    void q(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var);
}
