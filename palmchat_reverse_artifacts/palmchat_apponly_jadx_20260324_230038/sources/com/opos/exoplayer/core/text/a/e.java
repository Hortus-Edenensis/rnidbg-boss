package com.opos.exoplayer.core.text.a;

import androidx.annotation.NonNull;
import com.opos.exoplayer.core.text.g;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class e implements com.opos.exoplayer.core.text.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<b> f8323a = new LinkedList<>();
    private final LinkedList<g> b;
    private final PriorityQueue<b> c;
    private b d;
    private long e;
    private long f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.opos.exoplayer.core.text.f implements Comparable<b> {
        private long e;

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull b bVar) {
            if (c() != bVar.c()) {
                return c() ? 1 : -1;
            }
            long j = this.c - bVar.c;
            if (j == 0) {
                j = this.e - bVar.e;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c extends g {
        private c() {
        }

        @Override // com.opos.exoplayer.core.text.g
        public final void e() {
            e.this.a((g) this);
        }
    }

    public e() {
        int i = 0;
        while (true) {
            if (i >= 10) {
                break;
            }
            this.f8323a.add(new b());
            i++;
        }
        this.b = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c());
        }
        this.c = new PriorityQueue<>();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public abstract void a(com.opos.exoplayer.core.text.f fVar);

    @Override // com.opos.exoplayer.core.decoder.c
    public void c() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            a(this.c.poll());
        }
        b bVar = this.d;
        if (bVar != null) {
            a(bVar);
            this.d = null;
        }
    }

    public abstract boolean e();

    public abstract com.opos.exoplayer.core.text.b f();

    @Override // com.opos.exoplayer.core.decoder.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public g b() {
        g gVarPollFirst;
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && this.c.peek().c <= this.e) {
            b bVarPoll = this.c.poll();
            if (bVarPoll.c()) {
                gVarPollFirst = this.b.pollFirst();
                gVarPollFirst.b(4);
            } else {
                a((com.opos.exoplayer.core.text.f) bVarPoll);
                if (e()) {
                    com.opos.exoplayer.core.text.b bVarF = f();
                    if (!bVarPoll.d_()) {
                        gVarPollFirst = this.b.pollFirst();
                        gVarPollFirst.a(bVarPoll.c, bVarF, Long.MAX_VALUE);
                    }
                }
                a(bVarPoll);
            }
            a(bVarPoll);
            return gVarPollFirst;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.decoder.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.opos.exoplayer.core.text.f a() {
        com.opos.exoplayer.core.util.a.b(this.d == null);
        if (this.f8323a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f8323a.pollFirst();
        this.d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // com.opos.exoplayer.core.text.c
    public void a(long j) {
        this.e = j;
    }

    @Override // com.opos.exoplayer.core.decoder.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.opos.exoplayer.core.text.f fVar) {
        com.opos.exoplayer.core.util.a.a(fVar == this.d);
        if (fVar.d_()) {
            a(this.d);
        } else {
            b bVar = this.d;
            long j = this.f;
            this.f = 1 + j;
            bVar.e = j;
            this.c.add(this.d);
        }
        this.d = null;
    }

    private void a(b bVar) {
        bVar.a();
        this.f8323a.add(bVar);
    }

    public void a(g gVar) {
        gVar.a();
        this.b.add(gVar);
    }

    @Override // com.opos.exoplayer.core.decoder.c
    public void d() {
    }
}
