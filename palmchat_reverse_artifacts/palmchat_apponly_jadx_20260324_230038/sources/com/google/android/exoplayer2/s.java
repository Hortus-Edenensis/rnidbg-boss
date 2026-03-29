package com.google.android.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.bk4;
import defpackage.fh1;
import defpackage.g86;
import defpackage.ga5;
import defpackage.hm3;
import defpackage.kc;
import defpackage.kh3;
import defpackage.m43;
import defpackage.mg2;
import defpackage.u06;
import defpackage.vh;
import defpackage.w9;
import defpackage.y53;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bk4 f5928a;
    public final d e;
    public final kc h;
    public final mg2 i;
    public boolean k;

    @Nullable
    public u06 l;
    public ga5 j = new ga5.a(0);
    public final IdentityHashMap<com.google.android.exoplayer2.source.h, c> c = new IdentityHashMap<>();
    public final Map<Object, c> d = new HashMap();
    public final List<c> b = new ArrayList();
    public final HashMap<c, b> f = new HashMap<>();
    public final Set<c> g = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.drm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f5929a;

        public a(c cVar) {
            this.f5929a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(Pair pair, kh3 kh3Var) {
            s.this.h.h(((Integer) pair.first).intValue(), (i.b) pair.second, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(Pair pair) {
            s.this.h.t(((Integer) pair.first).intValue(), (i.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void L(Pair pair) {
            s.this.h.y(((Integer) pair.first).intValue(), (i.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void M(Pair pair) {
            s.this.h.v(((Integer) pair.first).intValue(), (i.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void N(Pair pair, int i) {
            s.this.h.u(((Integer) pair.first).intValue(), (i.b) pair.second, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O(Pair pair, Exception exc) {
            s.this.h.C(((Integer) pair.first).intValue(), (i.b) pair.second, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void P(Pair pair) {
            s.this.h.K(((Integer) pair.first).intValue(), (i.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Q(Pair pair, m43 m43Var, kh3 kh3Var) {
            s.this.h.E(((Integer) pair.first).intValue(), (i.b) pair.second, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void R(Pair pair, m43 m43Var, kh3 kh3Var) {
            s.this.h.q(((Integer) pair.first).intValue(), (i.b) pair.second, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S(Pair pair, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z) {
            s.this.h.J(((Integer) pair.first).intValue(), (i.b) pair.second, m43Var, kh3Var, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void T(Pair pair, m43 m43Var, kh3 kh3Var) {
            s.this.h.H(((Integer) pair.first).intValue(), (i.b) pair.second, m43Var, kh3Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void U(Pair pair, kh3 kh3Var) {
            s.this.h.A(((Integer) pair.first).intValue(), (i.b) vh.e((i.b) pair.second), kh3Var);
        }

        @Override // com.google.android.exoplayer2.source.j
        public void A(int i, @Nullable i.b bVar, final kh3 kh3Var) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: qm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20277a.U(pairB, kh3Var);
                    }
                });
            }
        }

        @Nullable
        public final Pair<Integer, i.b> B(int i, @Nullable i.b bVar) {
            i.b bVar2 = null;
            if (bVar != null) {
                i.b bVarN = s.n(this.f5929a, bVar);
                if (bVarN == null) {
                    return null;
                }
                bVar2 = bVarN;
            }
            return Pair.create(Integer.valueOf(s.s(this.f5929a, i)), bVar2);
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void C(int i, @Nullable i.b bVar, final Exception exc) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: sm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20786a.O(pairB, exc);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void E(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: om3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19791a.Q(pairB, m43Var, kh3Var);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void H(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: jm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18435a.T(pairB, m43Var, kh3Var);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void J(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var, final IOException iOException, final boolean z) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: mm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19265a.S(pairB, m43Var, kh3Var, iOException, z);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void K(int i, @Nullable i.b bVar) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: rm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20507a.P(pairB);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void h(int i, @Nullable i.b bVar, final kh3 kh3Var) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: nm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19558a.D(pairB, kh3Var);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.j
        public void q(int i, @Nullable i.b bVar, final m43 m43Var, final kh3 kh3Var) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: tm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21023a.R(pairB, m43Var, kh3Var);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void t(int i, @Nullable i.b bVar) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: km3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18723a.I(pairB);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void u(int i, @Nullable i.b bVar, final int i2) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: pm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20052a.N(pairB, i2);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void v(int i, @Nullable i.b bVar) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: lm3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19030a.M(pairB);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public void y(int i, @Nullable i.b bVar) {
            final Pair<Integer, i.b> pairB = B(i, bVar);
            if (pairB != null) {
                s.this.i.post(new Runnable() { // from class: um3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21244a.L(pairB);
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.drm.b
        public /* synthetic */ void z(int i, i.b bVar) {
            fh1.a(this, i, bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.i f5930a;
        public final i.c b;
        public final a c;

        public b(com.google.android.exoplayer2.source.i iVar, i.c cVar, a aVar) {
            this.f5930a = iVar;
            this.b = cVar;
            this.c = aVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements hm3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.g f5931a;
        public int d;
        public boolean e;
        public final List<i.b> c = new ArrayList();
        public final Object b = new Object();

        public c(com.google.android.exoplayer2.source.i iVar, boolean z) {
            this.f5931a = new com.google.android.exoplayer2.source.g(iVar, z);
        }

        public void a(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }

        @Override // defpackage.hm3
        public e0 getTimeline() {
            return this.f5931a.Q();
        }

        @Override // defpackage.hm3
        public Object getUid() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onPlaylistUpdateRequested();
    }

    public s(d dVar, kc kcVar, mg2 mg2Var, bk4 bk4Var) {
        this.f5928a = bk4Var;
        this.e = dVar;
        this.h = kcVar;
        this.i = mg2Var;
    }

    public static Object m(Object obj) {
        return com.google.android.exoplayer2.a.z(obj);
    }

    @Nullable
    public static i.b n(c cVar, i.b bVar) {
        for (int i = 0; i < cVar.c.size(); i++) {
            if (cVar.c.get(i).d == bVar.d) {
                return bVar.c(p(cVar, bVar.f18710a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return com.google.android.exoplayer2.a.A(obj);
    }

    public static Object p(c cVar, Object obj) {
        return com.google.android.exoplayer2.a.C(cVar.b, obj);
    }

    public static int s(c cVar, int i) {
        return i + cVar.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(com.google.android.exoplayer2.source.i iVar, e0 e0Var) {
        this.e.onPlaylistUpdateRequested();
    }

    public void A(com.google.android.exoplayer2.source.h hVar) {
        c cVar = (c) vh.e(this.c.remove(hVar));
        cVar.f5931a.f(hVar);
        cVar.c.remove(((com.google.android.exoplayer2.source.f) hVar).f5956a);
        if (!this.c.isEmpty()) {
            k();
        }
        v(cVar);
    }

    public e0 B(int i, int i2, ga5 ga5Var) {
        vh.a(i >= 0 && i <= i2 && i2 <= r());
        this.j = ga5Var;
        C(i, i2);
        return i();
    }

    public final void C(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.b.remove(i3);
            this.d.remove(cVarRemove.b);
            g(i3, -cVarRemove.f5931a.Q().t());
            cVarRemove.e = true;
            if (this.k) {
                v(cVarRemove);
            }
        }
    }

    public e0 D(List<c> list, ga5 ga5Var) {
        C(0, this.b.size());
        return f(this.b.size(), list, ga5Var);
    }

    public e0 E(ga5 ga5Var) {
        int iR = r();
        if (ga5Var.getLength() != iR) {
            ga5Var = ga5Var.cloneAndClear().cloneAndInsert(0, iR);
        }
        this.j = ga5Var;
        return i();
    }

    public e0 f(int i, List<c> list, ga5 ga5Var) {
        if (!list.isEmpty()) {
            this.j = ga5Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.b.get(i2 - 1);
                    cVar.a(cVar2.d + cVar2.f5931a.Q().t());
                } else {
                    cVar.a(0);
                }
                g(i2, cVar.f5931a.Q().t());
                this.b.add(i2, cVar);
                this.d.put(cVar.b, cVar);
                if (this.k) {
                    y(cVar);
                    if (this.c.isEmpty()) {
                        this.g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i, int i2) {
        while (i < this.b.size()) {
            this.b.get(i).d += i2;
            i++;
        }
    }

    public com.google.android.exoplayer2.source.h h(i.b bVar, w9 w9Var, long j) {
        Object objO = o(bVar.f18710a);
        i.b bVarC = bVar.c(m(bVar.f18710a));
        c cVar = (c) vh.e(this.d.get(objO));
        l(cVar);
        cVar.c.add(bVarC);
        com.google.android.exoplayer2.source.f fVarC = cVar.f5931a.c(bVarC, w9Var, j);
        this.c.put(fVarC, cVar);
        k();
        return fVarC;
    }

    public e0 i() {
        if (this.b.isEmpty()) {
            return e0.f5869a;
        }
        int iT = 0;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = this.b.get(i);
            cVar.d = iT;
            iT += cVar.f5931a.Q().t();
        }
        return new x(this.b, this.j);
    }

    public final void j(c cVar) {
        b bVar = this.f.get(cVar);
        if (bVar != null) {
            bVar.f5930a.h(bVar.b);
        }
    }

    public final void k() {
        Iterator<c> it = this.g.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.c.isEmpty()) {
                j(next);
                it.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.g.add(cVar);
        b bVar = this.f.get(cVar);
        if (bVar != null) {
            bVar.f5930a.g(bVar.b);
        }
    }

    public ga5 q() {
        return this.j;
    }

    public int r() {
        return this.b.size();
    }

    public boolean t() {
        return this.k;
    }

    public final void v(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVar = (b) vh.e(this.f.remove(cVar));
            bVar.f5930a.a(bVar.b);
            bVar.f5930a.b(bVar.c);
            bVar.f5930a.j(bVar.c);
            this.g.remove(cVar);
        }
    }

    public e0 w(int i, int i2, int i3, ga5 ga5Var) {
        vh.a(i >= 0 && i <= i2 && i2 <= r() && i3 >= 0);
        this.j = ga5Var;
        if (i == i2 || i == i3) {
            return i();
        }
        int iMin = Math.min(i, i3);
        int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int iT = this.b.get(iMin).d;
        g86.G0(this.b, i, i2, i3);
        while (iMin <= iMax) {
            c cVar = this.b.get(iMin);
            cVar.d = iT;
            iT += cVar.f5931a.Q().t();
            iMin++;
        }
        return i();
    }

    public void x(@Nullable u06 u06Var) {
        vh.g(!this.k);
        this.l = u06Var;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = this.b.get(i);
            y(cVar);
            this.g.add(cVar);
        }
        this.k = true;
    }

    public final void y(c cVar) {
        com.google.android.exoplayer2.source.g gVar = cVar.f5931a;
        i.c cVar2 = new i.c() { // from class: im3
            @Override // com.google.android.exoplayer2.source.i.c
            public final void a(i iVar, e0 e0Var) {
                this.f18201a.u(iVar, e0Var);
            }
        };
        a aVar = new a(cVar);
        this.f.put(cVar, new b(gVar, cVar2, aVar));
        gVar.e(g86.y(), aVar);
        gVar.i(g86.y(), aVar);
        gVar.k(cVar2, this.l, this.f5928a);
    }

    public void z() {
        for (b bVar : this.f.values()) {
            try {
                bVar.f5930a.a(bVar.b);
            } catch (RuntimeException e) {
                y53.d("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.f5930a.b(bVar.c);
            bVar.f5930a.j(bVar.c);
        }
        this.f.clear();
        this.g.clear();
        this.k = false;
    }
}
