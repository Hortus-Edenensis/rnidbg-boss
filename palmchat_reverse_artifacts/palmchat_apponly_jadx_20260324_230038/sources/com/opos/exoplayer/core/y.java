package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.f;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.source.g;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class y implements Handler.Callback, h.a, f.a, o.a, g.a, h.a {
    private int A;
    private boolean B;
    private int C;
    private f D;
    private long E;
    private int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q[] f8434a;
    private final r[] b;
    private final com.opos.exoplayer.core.c.h c;
    private final com.opos.exoplayer.core.c.i d;
    private final l e;
    private final com.opos.exoplayer.core.util.j f;
    private final HandlerThread g;
    private final Handler h;
    private final g i;
    private final w.b j;
    private final w.a k;
    private final long l;
    private final boolean m;
    private final com.opos.exoplayer.core.f n;
    private final ArrayList<d> p;
    private final com.opos.exoplayer.core.util.e q;
    private ac t;
    private com.opos.exoplayer.core.source.h u;
    private q[] v;
    private boolean w;
    private boolean y;
    private boolean z;
    private volatile boolean x = false;
    private long G = 500;
    private final ab r = new ab();
    private u s = u.e;
    private final e o = new e(null);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.exoplayer.core.util.v<Boolean> {
        public a() {
        }

        @Override // com.opos.exoplayer.core.util.v
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b() {
            return Boolean.valueOf(y.this.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f8436a;

        public b(o oVar) {
            this.f8436a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                y.this.e(this.f8436a);
            } catch (ExoPlaybackException e) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.exoplayer.core.source.h f8437a;
        public final w b;
        public final Object c;

        public c(com.opos.exoplayer.core.source.h hVar, w wVar, Object obj) {
            this.f8437a = hVar;
            this.b = wVar;
            this.c = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f8438a;
        public int b;
        public long c;

        @Nullable
        public Object d;

        public d(o oVar) {
            this.f8438a = oVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull d dVar) {
            Object obj = this.d;
            if ((obj == null) != (dVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - dVar.b;
            return i != 0 ? i : com.opos.exoplayer.core.util.y.a(this.c, dVar.c);
        }

        public void a(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ac f8439a;
        private int b;
        private boolean c;
        private int d;

        private e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public void b(int i) {
            if (this.c && this.d != 4) {
                com.opos.exoplayer.core.util.a.a(i == 4);
            } else {
                this.c = true;
                this.d = i;
            }
        }

        public void a(int i) {
            this.b += i;
        }

        public void b(ac acVar) {
            this.f8439a = acVar;
            this.b = 0;
            this.c = false;
        }

        public boolean a(ac acVar) {
            return acVar != this.f8439a || this.b > 0 || this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f8440a;
        public final int b;
        public final long c;

        public f(w wVar, int i, long j) {
            this.f8440a = wVar;
            this.b = i;
            this.c = j;
        }
    }

    public y(q[] qVarArr, com.opos.exoplayer.core.c.h hVar, com.opos.exoplayer.core.c.i iVar, l lVar, boolean z, int i, boolean z2, Handler handler, g gVar, com.opos.exoplayer.core.util.e eVar) {
        this.f8434a = qVarArr;
        this.c = hVar;
        this.d = iVar;
        this.e = lVar;
        this.y = z;
        this.A = i;
        this.B = z2;
        this.h = handler;
        this.i = gVar;
        this.q = eVar;
        this.l = lVar.e();
        this.m = lVar.f();
        this.t = new ac(w.f8429a, -9223372036854775807L, iVar);
        this.b = new r[qVarArr.length];
        for (int i2 = 0; i2 < qVarArr.length; i2++) {
            qVarArr[i2].a(i2);
            this.b[i2] = qVarArr[i2].b();
        }
        this.n = new com.opos.exoplayer.core.f(this, eVar);
        this.p = new ArrayList<>();
        this.v = new q[0];
        this.j = new w.b();
        this.k = new w.a();
        hVar.a((h.a) this);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = eVar.a(handlerThread.getLooper(), this);
    }

    private int a(int i, w wVar, w wVar2) {
        int iC = wVar.c();
        int iA = i;
        int iA2 = -1;
        for (int i2 = 0; i2 < iC && iA2 == -1; i2++) {
            iA = wVar.a(iA, this.k, this.j, this.A, this.B);
            if (iA == -1) {
                break;
            }
            iA2 = wVar2.a(wVar.a(iA, this.k, true).b);
        }
        return iA2;
    }

    private void c() {
        if (this.o.a(this.t)) {
            this.h.obtainMessage(0, this.o.b, this.o.c ? this.o.d : -1, this.t).sendToTarget();
            this.o.b(this.t);
        }
    }

    private void d() {
        this.z = false;
        this.n.a();
        for (q qVar : this.v) {
            qVar.b_();
        }
    }

    private void e() {
        this.n.b();
        for (q qVar : this.v) {
            a(qVar);
        }
    }

    private void f() {
        if (this.r.f()) {
            z zVarC = this.r.c();
            long jC = zVarC.f8441a.c();
            if (jC != -9223372036854775807L) {
                a(jC);
                if (jC != this.t.i) {
                    ac acVar = this.t;
                    this.t = acVar.a(acVar.c, jC, acVar.e);
                    this.o.b(4);
                }
            } else {
                long jC2 = this.n.c();
                this.E = jC2;
                long jB = zVarC.b(jC2);
                b(this.t.i, jB);
                this.t.i = jB;
            }
            this.t.j = this.v.length == 0 ? zVarC.h.e : zVarC.a(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() throws ExoPlaybackException {
        int i;
        long jB = this.q.b();
        o();
        if (!this.r.f()) {
            m();
            a(jB, 10L);
            return;
        }
        z zVarC = this.r.c();
        com.opos.exoplayer.core.util.x.a("doSomeWork");
        f();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        zVarC.f8441a.a(this.t.i - this.l, this.m);
        boolean z = true;
        boolean z2 = true;
        for (q qVar : this.v) {
            qVar.a(this.E, jElapsedRealtime);
            z2 = z2 && qVar.u();
            boolean z3 = qVar.t() || qVar.u() || c(qVar);
            if (!z3) {
                qVar.j();
            }
            z = z && z3;
        }
        if (!z) {
            m();
        }
        long j = zVarC.h.e;
        if (!z2 || ((j != -9223372036854775807L && j > this.t.i) || !zVarC.h.g)) {
            if (this.t.f == 2 && f(z)) {
                b(3);
                if (this.y) {
                    d();
                }
            } else if (this.t.f == 3 && (this.v.length != 0 ? !z : !l())) {
                this.z = this.y;
                b(2);
            }
            if (this.t.f == 2) {
                for (q qVar2 : this.v) {
                    qVar2.j();
                }
            }
            if ((!this.y && this.t.f == 3) || (i = this.t.f) == 2) {
                a(jB, 10L);
            } else if (this.v.length == 0 || i == 4) {
                this.f.b(2);
            } else {
                a(jB, 1000L);
            }
            com.opos.exoplayer.core.util.x.a();
        }
        b(4);
        e();
        if (this.t.f == 2) {
        }
        if (!this.y) {
            if (this.v.length == 0) {
                this.f.b(2);
            }
        } else if (this.v.length == 0) {
        }
        com.opos.exoplayer.core.util.x.a();
    }

    private void h() {
        a(true, true, true);
        this.e.c();
        b(1);
        this.g.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    private int i() {
        w wVar = this.t.f8110a;
        if (wVar.a()) {
            return 0;
        }
        return wVar.a(wVar.b(this.B), this.j).f;
    }

    private void j() {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (!a(this.p.get(size))) {
                this.p.get(size).f8438a.a(false);
                this.p.remove(size);
            }
        }
        Collections.sort(this.p);
    }

    private void k() throws ExoPlaybackException {
        if (this.r.f()) {
            float f2 = this.n.e().b;
            z zVarD = this.r.d();
            boolean z = true;
            for (z zVarC = this.r.c(); zVarC != null && zVarC.f; zVarC = zVarC.i) {
                if (zVarC.b(f2)) {
                    if (z) {
                        z zVarC2 = this.r.c();
                        boolean zA = this.r.a(zVarC2);
                        boolean[] zArr = new boolean[this.f8434a.length];
                        long jA = zVarC2.a(this.t.i, zA, zArr);
                        a(zVarC2.j);
                        ac acVar = this.t;
                        if (acVar.f != 4 && jA != acVar.i) {
                            ac acVar2 = this.t;
                            this.t = acVar2.a(acVar2.c, jA, acVar2.e);
                            this.o.b(4);
                            a(jA);
                        }
                        boolean[] zArr2 = new boolean[this.f8434a.length];
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            q[] qVarArr = this.f8434a;
                            if (i >= qVarArr.length) {
                                break;
                            }
                            q qVar = qVarArr[i];
                            boolean z2 = qVar.a_() != 0;
                            zArr2[i] = z2;
                            com.opos.exoplayer.core.source.l lVar = zVarC2.c[i];
                            if (lVar != null) {
                                i2++;
                            }
                            if (z2) {
                                if (lVar != qVar.f()) {
                                    b(qVar);
                                } else if (zArr[i]) {
                                    qVar.a(this.E);
                                }
                            }
                            i++;
                        }
                        this.t = this.t.a(zVarC2.j);
                        a(zArr2, i2);
                    } else {
                        this.r.a(zVarC);
                        if (zVarC.f) {
                            zVarC.a(Math.max(zVarC.h.b, zVarC.b(this.E)), false);
                            a(zVarC.j);
                        }
                    }
                    if (this.t.f != 4) {
                        q();
                        f();
                        this.f.a(2);
                        return;
                    }
                    return;
                }
                if (zVarC == zVarD) {
                    z = false;
                }
            }
        }
    }

    private boolean l() {
        z zVar;
        z zVarC = this.r.c();
        long j = zVarC.h.e;
        return j == -9223372036854775807L || this.t.i < j || ((zVar = zVarC.i) != null && (zVar.f || zVar.h.f8108a.a()));
    }

    private void m() {
        z zVarB = this.r.b();
        z zVarD = this.r.d();
        if (zVarB == null || zVarB.f) {
            return;
        }
        if (zVarD == null || zVarD.i == zVarB) {
            for (q qVar : this.v) {
                if (!qVar.g()) {
                    return;
                }
            }
            zVarB.f8441a.c_();
        }
    }

    private void n() {
        b(4);
        a(false, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o() throws ExoPlaybackException {
        com.opos.exoplayer.core.source.h hVar = this.u;
        if (hVar == null) {
            return;
        }
        if (this.C > 0) {
            hVar.a();
            return;
        }
        p();
        z zVarB = this.r.b();
        int i = 0;
        if (zVarB == null || zVarB.b()) {
            b(false);
        } else if (!this.t.g) {
            q();
        }
        if (!this.r.f()) {
            return;
        }
        z zVarC = this.r.c();
        z zVarD = this.r.d();
        boolean z = false;
        while (this.y && zVarC != zVarD && this.E >= zVarC.i.e) {
            if (z) {
                c();
            }
            int i2 = zVarC.h.f ? 0 : 3;
            z zVarH = this.r.h();
            a(zVarC);
            ac acVar = this.t;
            aa aaVar = zVarH.h;
            this.t = acVar.a(aaVar.f8108a, aaVar.b, aaVar.d);
            this.o.b(i2);
            f();
            zVarC = zVarH;
            z = true;
        }
        if (zVarD.h.g) {
            while (true) {
                q[] qVarArr = this.f8434a;
                if (i >= qVarArr.length) {
                    return;
                }
                q qVar = qVarArr[i];
                com.opos.exoplayer.core.source.l lVar = zVarD.c[i];
                if (lVar != null && qVar.f() == lVar && qVar.g()) {
                    qVar.h();
                }
                i++;
            }
        } else {
            z zVar = zVarD.i;
            if (zVar == null || !zVar.f) {
                return;
            }
            int i3 = 0;
            while (true) {
                q[] qVarArr2 = this.f8434a;
                if (i3 < qVarArr2.length) {
                    q qVar2 = qVarArr2[i3];
                    com.opos.exoplayer.core.source.l lVar2 = zVarD.c[i3];
                    if (qVar2.f() != lVar2) {
                        return;
                    }
                    if (lVar2 != null && !qVar2.g()) {
                        return;
                    } else {
                        i3++;
                    }
                } else {
                    com.opos.exoplayer.core.c.i iVar = zVarD.j;
                    z zVarG = this.r.g();
                    com.opos.exoplayer.core.c.i iVar2 = zVarG.j;
                    boolean z2 = zVarG.f8441a.c() != -9223372036854775807L;
                    int i4 = 0;
                    while (true) {
                        q[] qVarArr3 = this.f8434a;
                        if (i4 >= qVarArr3.length) {
                            return;
                        }
                        q qVar3 = qVarArr3[i4];
                        if (iVar.b[i4]) {
                            if (!z2) {
                                if (!qVar3.i()) {
                                    com.opos.exoplayer.core.c.f fVarA = iVar2.c.a(i4);
                                    boolean z3 = iVar2.b[i4];
                                    boolean z4 = this.b[i4].a() == 5;
                                    s sVar = iVar.e[i4];
                                    s sVar2 = iVar2.e[i4];
                                    if (z3 && sVar2.equals(sVar) && !z4) {
                                        qVar3.a(a(fVarA), zVarG.c[i4], zVarG.a());
                                    } else {
                                        qVar3.h();
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    private void p() {
        this.r.a(this.E);
        if (this.r.a()) {
            aa aaVarA = this.r.a(this.E, this.t);
            if (aaVarA == null) {
                this.u.a();
                return;
            }
            this.r.a(this.b, 60000000L, this.c, this.e.d(), this.u, this.t.f8110a.a(aaVarA.f8108a.f8292a, this.k, true).b, aaVarA).a(this, aaVarA.b);
            b(true);
        }
    }

    private void q() {
        z zVarB = this.r.b();
        long jC = zVarB.c();
        if (jC == Long.MIN_VALUE) {
            b(false);
            return;
        }
        boolean zA = this.e.a(jC - zVarB.b(this.E), this.n.e().b);
        b(zA);
        if (zA) {
            zVarB.d(this.E);
        }
    }

    public Looper b() {
        return this.g.getLooper();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String strA;
        ExoPlaybackException e2;
        try {
            switch (message.what) {
                case 0:
                    b((com.opos.exoplayer.core.source.h) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    g();
                    break;
                case 3:
                    a((f) message.obj);
                    break;
                case 4:
                    b((n) message.obj);
                    break;
                case 5:
                    a((u) message.obj);
                    break;
                case 6:
                    a(message.arg1 != 0, true);
                    break;
                case 7:
                    h();
                    return true;
                case 8:
                    a((c) message.obj);
                    break;
                case 9:
                    c((com.opos.exoplayer.core.source.g) message.obj);
                    break;
                case 10:
                    d((com.opos.exoplayer.core.source.g) message.obj);
                    break;
                case 11:
                    k();
                    break;
                case 12:
                    c(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    b((o) message.obj);
                    break;
                case 15:
                    d((o) message.obj);
                    break;
                default:
                    return false;
            }
            c();
        } catch (ExoPlaybackException e3) {
            e2 = e3;
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Playback error.", e2);
            a(false, false);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        } catch (IOException e4) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Source error.", e4);
            a(false, false);
            strA = com.opos.exoplayer.core.util.y.a(e4);
            com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "Exception class name = " + strA);
            e2 = ExoPlaybackException.a(e4);
            e2.a(strA);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        } catch (RuntimeException e5) {
            com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Internal runtime error.", e5);
            a(false, false);
            strA = com.opos.exoplayer.core.util.y.a(e5);
            com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "Exception class name = " + strA);
            e2 = ExoPlaybackException.a(e5);
            e2.a(strA);
            this.h.obtainMessage(2, e2).sendToTarget();
            c();
        }
        return true;
    }

    private long a(h.b bVar, long j) {
        return a(bVar, j, this.r.c() != this.r.d());
    }

    private Pair<Integer, Long> b(w wVar, int i, long j) {
        return wVar.a(this.j, this.k, i, j);
    }

    private void c(int i) throws ExoPlaybackException {
        this.A = i;
        if (this.r.a(i)) {
            return;
        }
        e(true);
    }

    private void d(o oVar) {
        oVar.e().post(new b(oVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(o oVar) {
        try {
            oVar.b().a(oVar.c(), oVar.d());
        } finally {
            oVar.a(true);
        }
    }

    private boolean f(boolean z) {
        if (this.v.length == 0) {
            return l();
        }
        if (!z) {
            return false;
        }
        if (!this.t.g) {
            return true;
        }
        z zVarB = this.r.b();
        long jA = zVarB.a(!zVarB.h.g);
        return jA == Long.MIN_VALUE || this.e.a(jA - zVarB.b(this.E), this.n.e().b, this.z);
    }

    private long a(h.b bVar, long j, boolean z) throws ExoPlaybackException {
        e();
        this.z = false;
        b(2);
        z zVarC = this.r.c();
        z zVarH = zVarC;
        while (true) {
            if (zVarH == null) {
                break;
            }
            if (a(bVar, j, zVarH)) {
                this.r.a(zVarH);
                break;
            }
            zVarH = this.r.h();
        }
        if (zVarC != zVarH || z) {
            for (q qVar : this.v) {
                b(qVar);
            }
            this.v = new q[0];
            zVarC = null;
        }
        if (zVarH != null) {
            a(zVarC);
            if (zVarH.g) {
                long jB = zVarH.f8441a.b(j);
                zVarH.f8441a.a(jB - this.l, this.m);
                j = jB;
            }
            a(j);
            q();
        } else {
            this.r.i();
            a(j);
        }
        this.f.a(2);
        return j;
    }

    private void b(int i) {
        ac acVar = this.t;
        if (acVar.f != i) {
            this.t = acVar.b(i);
        }
    }

    private void c(o oVar) {
        if (oVar.e().getLooper() != this.f.a()) {
            this.f.a(15, oVar).sendToTarget();
            return;
        }
        e(oVar);
        int i = this.t.f;
        if (i == 3 || i == 2) {
            this.f.a(2);
        }
    }

    private void d(com.opos.exoplayer.core.source.g gVar) {
        if (this.r.a(gVar)) {
            this.r.a(this.E);
            q();
        }
    }

    private void e(boolean z) throws ExoPlaybackException {
        h.b bVar = this.r.c().h.f8108a;
        long jA = a(bVar, this.t.i, true);
        if (jA != this.t.i) {
            ac acVar = this.t;
            this.t = acVar.a(bVar, jA, acVar.e);
            if (z) {
                this.o.b(4);
            }
        }
    }

    private Pair<Integer, Long> a(f fVar, boolean z) {
        int iA;
        w wVar = this.t.f8110a;
        w wVar2 = fVar.f8440a;
        if (wVar.a()) {
            return null;
        }
        if (wVar2.a()) {
            wVar2 = wVar;
        }
        try {
            Pair<Integer, Long> pairA = wVar2.a(this.j, this.k, fVar.b, fVar.c);
            if (wVar == wVar2) {
                return pairA;
            }
            int iA2 = wVar.a(wVar2.a(((Integer) pairA.first).intValue(), this.k, true).b);
            if (iA2 != -1) {
                return Pair.create(Integer.valueOf(iA2), pairA.second);
            }
            if (!z || (iA = a(((Integer) pairA.first).intValue(), wVar2, wVar)) == -1) {
                return null;
            }
            return b(wVar, wVar.a(iA, this.k).c, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new k(wVar, fVar.b, fVar.c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r3.F < r3.p.size()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        r1 = r3.p.get(r3.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
    
        if (r1 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r1.d == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r4 = r1.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        if (r4 < r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r4 != r0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        if (r1.c > r8) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r1 = r3.F + 1;
        r3.F = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
    
        if (r1 >= r3.p.size()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
    
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0095, code lost:
    
        if (r1.d == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        if (r1.b != r0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r4 = r1.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009f, code lost:
    
        if (r4 <= r8) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a3, code lost:
    
        if (r4 > r10) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a5, code lost:
    
        r3.c(r1.f8438a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:
    
        if (r1.f8438a.h() == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b2, code lost:
    
        r3.p.remove(r3.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ba, code lost:
    
        r3.F++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:
    
        if (r3.F >= r3.p.size()) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ca, code lost:
    
        r1 = r3.p.get(r3.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d5, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0070, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008e -> B:27:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(long j, long j2) {
        y yVar;
        d dVar;
        if (!this.p.isEmpty() && !this.t.c.a()) {
            ac acVar = this.t;
            if (acVar.d == j) {
                j--;
            }
            int i = acVar.c.f8292a;
            int i2 = this.F;
            if (i2 > 0) {
                dVar = this.p.get(i2 - 1);
                yVar = this;
            } else {
                yVar = this;
                dVar = null;
            }
            while (dVar != null) {
                int i3 = dVar.b;
                if (i3 <= i && (i3 != i || dVar.c <= j)) {
                    break;
                }
                int i4 = yVar.F - 1;
                yVar.F = i4;
                if (i4 > 0) {
                    dVar = yVar.p.get(i4 - 1);
                } else {
                    yVar = yVar;
                    dVar = null;
                }
            }
        }
    }

    private void c(com.opos.exoplayer.core.source.g gVar) throws ExoPlaybackException {
        if (this.r.a(gVar)) {
            a(this.r.a(this.n.e().b));
            if (!this.r.f()) {
                a(this.r.h().h.b);
                a((z) null);
            }
            q();
        }
    }

    private void d(boolean z) throws ExoPlaybackException {
        this.B = z;
        if (this.r.a(z)) {
            return;
        }
        e(true);
    }

    private void b(n nVar) {
        this.n.a(nVar);
    }

    private void c(boolean z) {
        this.z = false;
        this.y = z;
        if (!z) {
            e();
            f();
            return;
        }
        int i = this.t.f;
        if (i == 3) {
            d();
        } else if (i != 2) {
            return;
        }
        this.f.a(2);
    }

    public synchronized void a() {
        this.x = true;
        if (this.w) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f.a(7);
        a(new a(), this.G);
        com.opos.cmn.an.f.a.a("ExoPlayerImplInternal", "release success:" + this.w + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " releaseTimeoutMs:" + this.G);
    }

    private void a(float f2) {
        for (z zVarE = this.r.e(); zVarE != null; zVarE = zVarE.i) {
            com.opos.exoplayer.core.c.i iVar = zVarE.j;
            if (iVar != null) {
                for (com.opos.exoplayer.core.c.f fVar : iVar.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private void b(o oVar) {
        if (oVar.f() == -9223372036854775807L) {
            c(oVar);
            return;
        }
        if (this.u == null || this.C > 0) {
            this.p.add(new d(oVar));
            return;
        }
        d dVar = new d(oVar);
        if (!a(dVar)) {
            oVar.a(false);
        } else {
            this.p.add(dVar);
            Collections.sort(this.p);
        }
    }

    private boolean c(q qVar) {
        z zVar = this.r.d().i;
        return zVar != null && zVar.f && qVar.g();
    }

    private void b(q qVar) {
        this.n.b(qVar);
        a(qVar);
        qVar.l();
    }

    public void a(int i) {
        this.f.a(12, i, 0).sendToTarget();
    }

    private void a(int i, boolean z, int i2) throws ExoPlaybackException {
        z zVarC = this.r.c();
        q qVar = this.f8434a[i];
        this.v[i2] = qVar;
        if (qVar.a_() == 0) {
            com.opos.exoplayer.core.c.i iVar = zVarC.j;
            s sVar = iVar.e[i];
            Format[] formatArrA = a(iVar.c.a(i));
            boolean z2 = this.y && this.t.f == 3;
            qVar.a(sVar, formatArrA, zVarC.c[i], this.E, !z && z2, zVarC.a());
            this.n.a(qVar);
            if (z2) {
                qVar.b_();
            }
        }
    }

    @Override // com.opos.exoplayer.core.source.m.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.opos.exoplayer.core.source.g gVar) {
        this.f.a(10, gVar).sendToTarget();
    }

    private void a(long j) {
        long jA = !this.r.f() ? j + 60000000 : this.r.c().a(j);
        this.E = jA;
        this.n.a(jA);
        for (q qVar : this.v) {
            qVar.a(this.E);
        }
    }

    private void b(com.opos.exoplayer.core.source.h hVar, boolean z, boolean z2) {
        this.C++;
        a(true, z, z2);
        this.e.a();
        this.u = hVar;
        b(2);
        hVar.a(this.i, true, this);
        this.f.a(2);
    }

    private void a(long j, long j2) {
        this.f.b(2);
        this.f.a(2, j + j2);
    }

    private void b(boolean z) {
        ac acVar = this.t;
        if (acVar.g != z) {
            this.t = acVar.a(z);
        }
    }

    private void a(com.opos.exoplayer.core.c.i iVar) {
        this.e.a(this.f8434a, iVar.f8129a, iVar.c);
    }

    @Override // com.opos.exoplayer.core.f.a
    public void a(n nVar) {
        this.h.obtainMessage(1, nVar).sendToTarget();
        a(nVar.b);
    }

    @Override // com.opos.exoplayer.core.o.a
    public synchronized void a(o oVar) {
        if (!this.x && !this.w) {
            this.f.a(14, oVar).sendToTarget();
            return;
        }
        com.opos.cmn.an.f.a.c("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        oVar.a(false);
    }

    private void a(q qVar) {
        if (qVar.a_() == 2) {
            qVar.k();
        }
    }

    @Override // com.opos.exoplayer.core.source.g.a
    public void a(com.opos.exoplayer.core.source.g gVar) {
        this.f.a(9, gVar).sendToTarget();
    }

    @Override // com.opos.exoplayer.core.source.h.a
    public void a(com.opos.exoplayer.core.source.h hVar, w wVar, Object obj) {
        this.f.a(8, new c(hVar, wVar, obj)).sendToTarget();
    }

    public void a(com.opos.exoplayer.core.source.h hVar, boolean z, boolean z2) {
        this.f.a(0, z ? 1 : 0, z2 ? 1 : 0, hVar).sendToTarget();
    }

    private void a(u uVar) {
        this.s = uVar;
    }

    private synchronized void a(com.opos.exoplayer.core.util.v<Boolean> vVar, long j) {
        long jA = this.q.a() + j;
        boolean z = false;
        while (!vVar.b().booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jA - this.q.a();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void a(w wVar, int i, long j) {
        this.f.a(3, new f(wVar, i, j)).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[PHI: r10 r11 r14
      0x0066: PHI (r10v5 com.opos.exoplayer.core.ac) = (r10v2 com.opos.exoplayer.core.ac), (r10v6 com.opos.exoplayer.core.ac) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0066: PHI (r11v11 com.opos.exoplayer.core.source.h$b) = (r11v8 com.opos.exoplayer.core.source.h$b), (r11v12 com.opos.exoplayer.core.source.h$b) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0066: PHI (r14v4 long) = (r14v1 long), (r14v5 long) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068 A[PHI: r10 r11 r14
      0x0068: PHI (r10v3 com.opos.exoplayer.core.ac) = (r10v2 com.opos.exoplayer.core.ac), (r10v6 com.opos.exoplayer.core.ac) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0068: PHI (r11v9 com.opos.exoplayer.core.source.h$b) = (r11v8 com.opos.exoplayer.core.source.h$b), (r11v12 com.opos.exoplayer.core.source.h$b) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x0068: PHI (r14v2 long) = (r14v1 long), (r14v5 long) binds: [B:23:0x00a5, B:13:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(c cVar) throws ExoPlaybackException {
        ac acVarA;
        long jLongValue;
        h.b bVarA;
        ac acVar;
        long j;
        if (cVar.f8437a != this.u) {
            return;
        }
        w wVar = this.t.f8110a;
        w wVar2 = cVar.b;
        Object obj = cVar.c;
        this.r.a(wVar2);
        this.t = this.t.a(wVar2, obj);
        j();
        int i = this.C;
        if (i > 0) {
            this.o.a(i);
            this.C = 0;
            f fVar = this.D;
            if (fVar != null) {
                Pair<Integer, Long> pairA = a(fVar, true);
                this.D = null;
                if (pairA != null) {
                    int iIntValue = ((Integer) pairA.first).intValue();
                    jLongValue = ((Long) pairA.second).longValue();
                    bVarA = this.r.a(iIntValue, jLongValue);
                    acVar = this.t;
                    j = bVarA.a() ? 0L : jLongValue;
                }
                n();
                return;
            }
            if (this.t.d == -9223372036854775807L) {
                if (!wVar2.a()) {
                    Pair<Integer, Long> pairB = b(wVar2, wVar2.b(this.B), -9223372036854775807L);
                    int iIntValue2 = ((Integer) pairB.first).intValue();
                    jLongValue = ((Long) pairB.second).longValue();
                    bVarA = this.r.a(iIntValue2, jLongValue);
                    acVar = this.t;
                    if (bVarA.a()) {
                    }
                }
                n();
                return;
            }
            return;
            this.t = acVar.a(bVarA, j, jLongValue);
            return;
        }
        ac acVar2 = this.t;
        int i2 = acVar2.c.f8292a;
        long j2 = acVar2.e;
        if (wVar.a()) {
            if (wVar2.a()) {
                return;
            }
            h.b bVarA2 = this.r.a(i2, j2);
            this.t = this.t.a(bVarA2, bVarA2.a() ? 0L : j2, j2);
            return;
        }
        z zVarE = this.r.e();
        int iA = wVar2.a(zVarE == null ? wVar.a(i2, this.k, true).b : zVarE.b);
        if (iA == -1) {
            int iA2 = a(i2, wVar, wVar2);
            if (iA2 == -1) {
                n();
                return;
            }
            Pair<Integer, Long> pairB2 = b(wVar2, wVar2.a(iA2, this.k).c, -9223372036854775807L);
            int iIntValue3 = ((Integer) pairB2.first).intValue();
            long jLongValue2 = ((Long) pairB2.second).longValue();
            h.b bVarA3 = this.r.a(iIntValue3, jLongValue2);
            wVar2.a(iIntValue3, this.k, true);
            if (zVarE != null) {
                Object obj2 = this.k.b;
                loop0: while (true) {
                    aa aaVarA = zVarE.h.a(-1);
                    while (true) {
                        zVarE.h = aaVarA;
                        zVarE = zVarE.i;
                        if (zVarE == null) {
                            break loop0;
                        } else if (zVarE.b.equals(obj2)) {
                            aaVarA = this.r.a(zVarE.h, iIntValue3);
                        }
                    }
                }
            }
            acVarA = this.t.a(bVarA3, a(bVarA3, bVarA3.a() ? 0L : jLongValue2), jLongValue2);
        } else {
            if (iA != i2) {
                this.t = this.t.a(iA);
            }
            h.b bVar = this.t.c;
            if (bVar.a()) {
                h.b bVarA4 = this.r.a(iA, j2);
                if (!bVarA4.equals(bVar)) {
                    acVarA = this.t.a(bVarA4, a(bVarA4, bVarA4.a() ? 0L : j2), j2);
                }
            }
            if (this.r.a(bVar, this.E)) {
                return;
            }
            e(false);
            return;
        }
        this.t = acVarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[Catch: all -> 0x00da, TRY_LEAVE, TryCatch #0 {all -> 0x00da, blocks: (B:14:0x005c, B:16:0x0060, B:21:0x0069, B:22:0x0071, B:24:0x007b, B:28:0x0087, B:30:0x0091, B:32:0x00a1, B:38:0x00b8, B:42:0x00c2, B:43:0x00c6), top: B:54:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(f fVar) {
        long jLongValue;
        h.b bVar;
        long j;
        boolean z;
        long j2;
        long jA;
        boolean z2 = true;
        this.o.a(1);
        Pair<Integer, Long> pairA = a(fVar, true);
        try {
            if (pairA == null) {
                bVar = new h.b(i());
                jLongValue = -9223372036854775807L;
                j = -9223372036854775807L;
            } else {
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue2 = ((Long) pairA.second).longValue();
                h.b bVarA = this.r.a(iIntValue, jLongValue2);
                if (bVarA.a()) {
                    jLongValue = 0;
                    bVar = bVarA;
                    j = jLongValue2;
                } else {
                    jLongValue = ((Long) pairA.second).longValue();
                    bVar = bVarA;
                    j = jLongValue2;
                    if (fVar.c != -9223372036854775807L) {
                        z = false;
                    }
                    if (this.u != null || this.C > 0) {
                        this.D = fVar;
                    } else if (jLongValue == -9223372036854775807L) {
                        b(4);
                        a(false, true, false);
                    } else {
                        if (bVar.equals(this.t.c)) {
                            z zVarC = this.r.c();
                            jA = (zVarC == null || jLongValue == 0) ? jLongValue : zVarC.f8441a.a(jLongValue, this.s);
                            if (C.a(jA) == C.a(this.t.i)) {
                                this.t = this.t.a(bVar, this.t.i, j);
                                if (z) {
                                    this.o.b(2);
                                    return;
                                }
                                return;
                            }
                        } else {
                            jA = jLongValue;
                        }
                        long jA2 = a(bVar, jA);
                        if (jLongValue == jA2) {
                            z2 = false;
                        }
                        z |= z2;
                        j2 = jA2;
                        this.t = this.t.a(bVar, j2, j);
                        if (z) {
                            this.o.b(2);
                            return;
                        }
                        return;
                    }
                    j2 = jLongValue;
                    this.t = this.t.a(bVar, j2, j);
                    if (z) {
                    }
                }
            }
            if (this.u != null) {
                this.D = fVar;
                j2 = jLongValue;
            }
            this.t = this.t.a(bVar, j2, j);
            if (z) {
            }
        } catch (Throwable th) {
            this.t = this.t.a(bVar, jLongValue, j);
            if (z) {
                this.o.b(2);
            }
            throw th;
        }
        z = true;
    }

    private void a(@Nullable z zVar) throws ExoPlaybackException {
        z zVarC = this.r.c();
        if (zVarC == null || zVar == zVarC) {
            return;
        }
        boolean[] zArr = new boolean[this.f8434a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            q[] qVarArr = this.f8434a;
            if (i >= qVarArr.length) {
                this.t = this.t.a(zVarC.j);
                a(zArr, i2);
                return;
            }
            q qVar = qVarArr[i];
            boolean z = qVar.a_() != 0;
            zArr[i] = z;
            boolean z2 = zVarC.j.b[i];
            if (z2) {
                i2++;
            }
            if (z && (!z2 || (qVar.i() && qVar.f() == zVar.c[i]))) {
                b(qVar);
            }
            i++;
        }
    }

    public void a(boolean z) {
        this.f.a(1, z ? 1 : 0, 0).sendToTarget();
    }

    private void a(boolean z, boolean z2) {
        a(true, z, z);
        this.o.a(this.C + (z2 ? 1 : 0));
        this.C = 0;
        this.e.b();
        b(1);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.opos.exoplayer.core.source.h hVar;
        this.f.b(2);
        this.z = false;
        this.n.b();
        this.E = 60000000L;
        for (q qVar : this.v) {
            try {
                b(qVar);
            } catch (ExoPlaybackException | RuntimeException e2) {
                com.opos.cmn.an.f.a.d("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.v = new q[0];
        this.r.i();
        b(false);
        if (z2) {
            this.D = null;
        }
        if (z3) {
            this.r.a(w.f8429a);
            Iterator<d> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().f8438a.a(false);
            }
            this.p.clear();
            this.F = 0;
        }
        w wVar = z3 ? w.f8429a : this.t.f8110a;
        Object obj = z3 ? null : this.t.b;
        h.b bVar = z2 ? new h.b(i()) : this.t.c;
        long j = z2 ? -9223372036854775807L : this.t.i;
        long j2 = z2 ? -9223372036854775807L : this.t.e;
        ac acVar = this.t;
        this.t = new ac(wVar, obj, bVar, j, j2, acVar.f, false, z3 ? this.d : acVar.h);
        if (!z || (hVar = this.u) == null) {
            return;
        }
        hVar.b();
        this.u = null;
    }

    private void a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.v = new q[i];
        z zVarC = this.r.c();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f8434a.length; i3++) {
            if (zVarC.j.b[i3]) {
                a(i3, zArr[i3], i2);
                i2++;
            }
        }
    }

    private boolean a(h.b bVar, long j, z zVar) {
        if (!bVar.equals(zVar.h.f8108a) || !zVar.f) {
            return false;
        }
        this.t.f8110a.a(zVar.h.f8108a.f8292a, this.k);
        int iB = this.k.b(j);
        return iB == -1 || this.k.a(iB) == zVar.h.c;
    }

    private boolean a(d dVar) {
        Object obj = dVar.d;
        if (obj == null) {
            Pair<Integer, Long> pairA = a(new f(dVar.f8438a.a(), dVar.f8438a.g(), C.b(dVar.f8438a.f())), false);
            if (pairA == null) {
                return false;
            }
            dVar.a(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue(), this.t.f8110a.a(((Integer) pairA.first).intValue(), this.k, true).b);
        } else {
            int iA = this.t.f8110a.a(obj);
            if (iA == -1) {
                return false;
            }
            dVar.b = iA;
        }
        return true;
    }

    @NonNull
    private static Format[] a(com.opos.exoplayer.core.c.f fVar) {
        int iE = fVar != null ? fVar.e() : 0;
        Format[] formatArr = new Format[iE];
        for (int i = 0; i < iE; i++) {
            formatArr[i] = fVar.a(i);
        }
        return formatArr;
    }
}
