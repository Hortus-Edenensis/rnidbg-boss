package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import defpackage.fh1;
import defpackage.g86;
import defpackage.kh3;
import defpackage.m43;
import defpackage.u06;
import defpackage.vh;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class c<T> extends com.google.android.exoplayer2.source.a {
    public final HashMap<T, b<T>> h = new HashMap<>();

    @Nullable
    public Handler i;

    @Nullable
    public u06 j;

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements j, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f5935a;
        public j.a b;
        public b.a c;

        public a(T t) {
            this.b = c.this.o(null);
            this.c = c.this.m(null);
            this.f5935a = t;
        }

        @Override // com.google.android.exoplayer2.source.j
        public void A(int i, @Nullable i.b bVar, kh3 kh3Var) {
            if (d(i, bVar)) {
                this.b.D(f(kh3Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i, @Nullable i.b bVar, Exception exc) {
            if (d(i, bVar)) {
                this.c.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void E(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var) {
            if (d(i, bVar)) {
                this.b.r(m43Var, f(kh3Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void H(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var) {
            if (d(i, bVar)) {
                this.b.A(m43Var, f(kh3Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void J(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z) {
            if (d(i, bVar)) {
                this.b.x(m43Var, f(kh3Var), iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void K(int i, @Nullable i.b bVar) {
            if (d(i, bVar)) {
                this.c.m();
            }
        }

        public final boolean d(int i, @Nullable i.b bVar) {
            i.b bVarX;
            if (bVar != null) {
                bVarX = c.this.x(this.f5935a, bVar);
                if (bVarX == null) {
                    return false;
                }
            } else {
                bVarX = null;
            }
            int iZ = c.this.z(this.f5935a, i);
            j.a aVar = this.b;
            if (aVar.f5968a != iZ || !g86.c(aVar.b, bVarX)) {
                this.b = c.this.n(iZ, bVarX);
            }
            b.a aVar2 = this.c;
            if (aVar2.f5859a == iZ && g86.c(aVar2.b, bVarX)) {
                return true;
            }
            this.c = c.this.l(iZ, bVarX);
            return true;
        }

        public final kh3 f(kh3 kh3Var) {
            long jY = c.this.y(this.f5935a, kh3Var.f);
            long jY2 = c.this.y(this.f5935a, kh3Var.g);
            return (jY == kh3Var.f && jY2 == kh3Var.g) ? kh3Var : new kh3(kh3Var.f18688a, kh3Var.b, kh3Var.c, kh3Var.d, kh3Var.e, jY, jY2);
        }

        @Override // com.google.android.exoplayer2.source.j
        public void h(int i, @Nullable i.b bVar, kh3 kh3Var) {
            if (d(i, bVar)) {
                this.b.i(f(kh3Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void q(int i, @Nullable i.b bVar, m43 m43Var, kh3 kh3Var) {
            if (d(i, bVar)) {
                this.b.u(m43Var, f(kh3Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void t(int i, @Nullable i.b bVar) {
            if (d(i, bVar)) {
                this.c.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void u(int i, @Nullable i.b bVar, int i2) {
            if (d(i, bVar)) {
                this.c.k(i2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void v(int i, @Nullable i.b bVar) {
            if (d(i, bVar)) {
                this.c.j();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void y(int i, @Nullable i.b bVar) {
            if (d(i, bVar)) {
                this.c.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void z(int i, i.b bVar) {
            fh1.a(this, i, bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f5936a;
        public final i.c b;
        public final c<T>.a c;

        public b(i iVar, i.c cVar, c<T>.a aVar) {
            this.f5936a = iVar;
            this.b = cVar;
            this.c = aVar;
        }
    }

    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public abstract void A(T t, i iVar, e0 e0Var);

    public final void C(final T t, i iVar) {
        vh.a(!this.h.containsKey(t));
        i.c cVar = new i.c() { // from class: ck0
            @Override // com.google.android.exoplayer2.source.i.c
            public final void a(i iVar2, e0 e0Var) {
                this.f1999a.A(t, iVar2, e0Var);
            }
        };
        a aVar = new a(t);
        this.h.put(t, new b<>(iVar, cVar, aVar));
        iVar.e((Handler) vh.e(this.i), aVar);
        iVar.i((Handler) vh.e(this.i), aVar);
        iVar.k(cVar, this.j, r());
        if (s()) {
            return;
        }
        iVar.h(cVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<b<T>> it = this.h.values().iterator();
        while (it.hasNext()) {
            it.next().f5936a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void p() {
        for (b<T> bVar : this.h.values()) {
            bVar.f5936a.h(bVar.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void q() {
        for (b<T> bVar : this.h.values()) {
            bVar.f5936a.g(bVar.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void t(@Nullable u06 u06Var) {
        this.j = u06Var;
        this.i = g86.w();
    }

    @Override // com.google.android.exoplayer2.source.a
    @CallSuper
    public void v() {
        for (b<T> bVar : this.h.values()) {
            bVar.f5936a.a(bVar.b);
            bVar.f5936a.b(bVar.c);
            bVar.f5936a.j(bVar.c);
        }
        this.h.clear();
    }

    @Nullable
    public abstract i.b x(T t, i.b bVar);

    public long y(T t, long j) {
        return j;
    }

    public int z(T t, int i) {
        return i;
    }
}
