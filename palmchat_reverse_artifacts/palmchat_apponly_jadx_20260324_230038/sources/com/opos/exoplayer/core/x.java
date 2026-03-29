package com.opos.exoplayer.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.opos.exoplayer.core.Player;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class x implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q[] f8432a;
    private final com.opos.exoplayer.core.c.h b;
    private final com.opos.exoplayer.core.c.i c;
    private final Handler d;
    private final y e;
    private final Handler f;
    private final CopyOnWriteArraySet<Player.b> g;
    private final w.b h;
    private final w.a i;
    private boolean j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private n p;
    private ac q;
    private int r;
    private int s;
    private long t;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            x.this.a(message);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public x(q[] qVarArr, com.opos.exoplayer.core.c.h hVar, l lVar, com.opos.exoplayer.core.util.e eVar) {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.util.y.e + "]");
        com.opos.exoplayer.core.util.a.b(qVarArr.length > 0);
        this.f8432a = (q[]) com.opos.exoplayer.core.util.a.a(qVarArr);
        this.b = (com.opos.exoplayer.core.c.h) com.opos.exoplayer.core.util.a.a(hVar);
        this.j = false;
        this.k = 0;
        this.l = false;
        this.g = new CopyOnWriteArraySet<>();
        com.opos.exoplayer.core.c.i iVar = new com.opos.exoplayer.core.c.i(com.opos.exoplayer.core.source.p.f8304a, new boolean[qVarArr.length], new com.opos.exoplayer.core.c.g(new com.opos.exoplayer.core.c.f[qVarArr.length]), null, new s[qVarArr.length]);
        this.c = iVar;
        this.h = new w.b();
        this.i = new w.a();
        this.p = n.f8277a;
        a aVar = new a(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.d = aVar;
        this.q = new ac(w.f8429a, 0L, iVar);
        y yVar = new y(qVarArr, hVar, iVar, lVar, this.j, this.k, this.l, aVar, this, eVar);
        this.e = yVar;
        this.f = new Handler(yVar.b());
    }

    private boolean r() {
        return this.q.f8110a.a() || this.m > 0;
    }

    @Override // com.opos.exoplayer.core.Player
    public Player.d a() {
        return null;
    }

    @Override // com.opos.exoplayer.core.Player
    public int b(int i) {
        return this.f8432a[i].a();
    }

    @Override // com.opos.exoplayer.core.Player
    public int c() {
        return this.q.f;
    }

    @Override // com.opos.exoplayer.core.Player
    public boolean d() {
        return this.j;
    }

    @Override // com.opos.exoplayer.core.Player
    public n e() {
        return this.p;
    }

    @Override // com.opos.exoplayer.core.Player
    public void f() {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.util.y.e + "] [" + i.a() + "]");
        this.e.a();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.opos.exoplayer.core.Player
    public com.opos.exoplayer.core.c.g g() {
        return this.q.h.c;
    }

    @Override // com.opos.exoplayer.core.Player
    public w h() {
        return this.q.f8110a;
    }

    @Override // com.opos.exoplayer.core.Player
    public int i() {
        if (r()) {
            return this.r;
        }
        ac acVar = this.q;
        return acVar.f8110a.a(acVar.c.f8292a, this.i).c;
    }

    @Override // com.opos.exoplayer.core.Player
    public int j() {
        w wVar = this.q.f8110a;
        if (wVar.a()) {
            return -1;
        }
        return wVar.a(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.Player
    public int k() {
        w wVar = this.q.f8110a;
        if (wVar.a()) {
            return -1;
        }
        return wVar.b(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.Player
    public long l() {
        w wVar = this.q.f8110a;
        if (wVar.a()) {
            return -9223372036854775807L;
        }
        if (!o()) {
            return wVar.a(i(), this.h).b();
        }
        h.b bVar = this.q.c;
        wVar.a(bVar.f8292a, this.i);
        return C.a(this.i.c(bVar.b, bVar.c));
    }

    @Override // com.opos.exoplayer.core.Player
    public long m() {
        return r() ? this.t : b(this.q.i);
    }

    @Override // com.opos.exoplayer.core.Player
    public long n() {
        return r() ? this.t : b(this.q.j);
    }

    @Override // com.opos.exoplayer.core.Player
    public boolean o() {
        return !r() && this.q.c.a();
    }

    @Override // com.opos.exoplayer.core.Player
    public long p() {
        if (!o()) {
            return m();
        }
        ac acVar = this.q;
        acVar.f8110a.a(acVar.c.f8292a, this.i);
        return this.i.b() + C.a(this.q.e);
    }

    public int q() {
        return r() ? this.s : this.q.c.f8292a;
    }

    private ac a(boolean z, boolean z2, int i) {
        long jM;
        if (z) {
            this.r = 0;
            this.s = 0;
            jM = 0;
        } else {
            this.r = i();
            this.s = q();
            jM = m();
        }
        this.t = jM;
        w wVar = z2 ? w.f8429a : this.q.f8110a;
        Object obj = z2 ? null : this.q.b;
        ac acVar = this.q;
        return new ac(wVar, obj, acVar.c, acVar.d, acVar.e, i, false, z2 ? this.c : acVar.h);
    }

    private long b(long j) {
        long jA = C.a(j);
        if (this.q.c.a()) {
            return jA;
        }
        ac acVar = this.q;
        acVar.f8110a.a(acVar.c.f8292a, this.i);
        return jA + this.i.b();
    }

    @Override // com.opos.exoplayer.core.g
    public o a(o.b bVar) {
        return new o(this.e, bVar, this.q.f8110a, i(), this.f);
    }

    @Override // com.opos.exoplayer.core.Player
    public Player.c b() {
        return null;
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(int i) {
        if (this.k != i) {
            this.k = i;
            this.e.a(i);
            Iterator<Player.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        }
    }

    @Override // com.opos.exoplayer.core.Player
    public void b(Player.b bVar) {
        this.g.remove(bVar);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(int i, long j) {
        w wVar = this.q.f8110a;
        if (i < 0 || (!wVar.a() && i >= wVar.b())) {
            throw new k(wVar, i, j);
        }
        this.o = true;
        this.m++;
        if (o()) {
            com.opos.cmn.an.f.a.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.d.obtainMessage(0, 1, -1, this.q).sendToTarget();
            return;
        }
        this.r = i;
        if (wVar.a()) {
            this.t = j == -9223372036854775807L ? 0L : j;
            this.s = 0;
        } else {
            long jA = j == -9223372036854775807L ? wVar.a(i, this.h).a() : C.b(j);
            Pair<Integer, Long> pairA = wVar.a(this.h, this.i, i, jA);
            this.t = C.a(jA);
            this.s = ((Integer) pairA.first).intValue();
        }
        this.e.a(wVar, i, C.b(j));
        Iterator<Player.b> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().b(1);
        }
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(long j) {
        a(i(), j);
    }

    public void a(Message message) {
        int i = message.what;
        if (i == 0) {
            ac acVar = (ac) message.obj;
            int i2 = message.arg1;
            int i3 = message.arg2;
            a(acVar, i2, i3 != -1, i3);
            return;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
            Iterator<Player.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(exoPlaybackException);
            }
            return;
        }
        n nVar = (n) message.obj;
        if (this.p.equals(nVar)) {
            return;
        }
        this.p = nVar;
        Iterator<Player.b> it2 = this.g.iterator();
        while (it2.hasNext()) {
            it2.next().a(nVar);
        }
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(Player.b bVar) {
        this.g.add(bVar);
    }

    private void a(ac acVar, int i, boolean z, int i2) {
        int i3 = this.m - i;
        this.m = i3;
        if (i3 == 0) {
            if (acVar.d == -9223372036854775807L) {
                acVar = acVar.a(acVar.c, 0L, acVar.e);
            }
            ac acVar2 = acVar;
            if ((!this.q.f8110a.a() || this.n) && acVar2.f8110a.a()) {
                this.s = 0;
                this.r = 0;
                this.t = 0L;
            }
            int i4 = this.n ? 0 : 2;
            boolean z2 = this.o;
            this.n = false;
            this.o = false;
            a(acVar2, z, i2, i4, z2);
        }
    }

    private void a(ac acVar, boolean z, int i, int i2, boolean z2) {
        ac acVar2 = this.q;
        boolean z3 = (acVar2.f8110a == acVar.f8110a && acVar2.b == acVar.b) ? false : true;
        boolean z4 = acVar2.f != acVar.f;
        boolean z5 = acVar2.g != acVar.g;
        boolean z6 = acVar2.h != acVar.h;
        this.q = acVar;
        if (z3 || i2 == 0) {
            for (Player.b bVar : this.g) {
                ac acVar3 = this.q;
                bVar.a(acVar3.f8110a, acVar3.b, i2);
            }
        }
        if (z) {
            Iterator<Player.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        }
        if (z6) {
            this.b.a(this.q.h.d);
            for (Player.b bVar2 : this.g) {
                com.opos.exoplayer.core.c.i iVar = this.q.h;
                bVar2.a(iVar.f8129a, iVar.c);
            }
        }
        if (z5) {
            Iterator<Player.b> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.q.g);
            }
        }
        if (z4) {
            Iterator<Player.b> it3 = this.g.iterator();
            while (it3.hasNext()) {
                it3.next().a(this.j, this.q.f);
            }
        }
        if (z2) {
            Iterator<Player.b> it4 = this.g.iterator();
            while (it4.hasNext()) {
                it4.next().e_();
            }
        }
    }

    @Override // com.opos.exoplayer.core.g
    public void a(com.opos.exoplayer.core.source.h hVar) {
        a(hVar, true, true);
    }

    public void a(com.opos.exoplayer.core.source.h hVar, boolean z, boolean z2) {
        ac acVarA = a(z, z2, 2);
        this.n = true;
        this.m++;
        this.e.a(hVar, z, z2);
        a(acVarA, false, 4, 1, false);
    }

    @Override // com.opos.exoplayer.core.Player
    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<Player.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.q.f);
            }
        }
    }
}
