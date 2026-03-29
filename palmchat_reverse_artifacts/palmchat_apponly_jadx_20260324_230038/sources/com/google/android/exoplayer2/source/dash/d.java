package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.p;
import defpackage.c06;
import defpackage.f12;
import defpackage.g86;
import defpackage.gc4;
import defpackage.on1;
import defpackage.ru0;
import defpackage.so3;
import defpackage.w9;
import defpackage.x50;
import defpackage.zt0;
import defpackage.zz5;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9 f5952a;
    public final b b;
    public zt0 f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final TreeMap<Long, Long> e = new TreeMap<>();
    public final Handler d = g86.x(this);
    public final on1 c = new on1();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5953a;
        public final long b;

        public a(long j, long j2) {
            this.f5953a = j;
            this.b = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(long j);

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements c06 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f5954a;
        public final f12 b = new f12();
        public final so3 c = new so3();
        public long d = -9223372036854775807L;

        public c(w9 w9Var) {
            this.f5954a = p.l(w9Var);
        }

        @Override // defpackage.c06
        public void a(gc4 gc4Var, int i, int i2) {
            this.f5954a.d(gc4Var, i);
        }

        @Override // defpackage.c06
        public void b(m mVar) {
            this.f5954a.b(mVar);
        }

        @Override // defpackage.c06
        public /* synthetic */ int c(ru0 ru0Var, int i, boolean z) {
            return zz5.a(this, ru0Var, i, z);
        }

        @Override // defpackage.c06
        public /* synthetic */ void d(gc4 gc4Var, int i) {
            zz5.b(this, gc4Var, i);
        }

        @Override // defpackage.c06
        public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
            this.f5954a.e(j, i, i2, i3, aVar);
            l();
        }

        @Override // defpackage.c06
        public int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException {
            return this.f5954a.c(ru0Var, i, z);
        }

        @Nullable
        public final so3 g() {
            this.c.b();
            if (this.f5954a.S(this.b, this.c, 0, false) != -4) {
                return null;
            }
            this.c.n();
            return this.c;
        }

        public boolean h(long j) {
            return d.this.j(j);
        }

        public void i(x50 x50Var) {
            long j = this.d;
            if (j == -9223372036854775807L || x50Var.h > j) {
                this.d = x50Var.h;
            }
            d.this.m(x50Var);
        }

        public boolean j(x50 x50Var) {
            long j = this.d;
            return d.this.n(j != -9223372036854775807L && j < x50Var.g);
        }

        public final void k(long j, long j2) {
            d.this.d.sendMessage(d.this.d.obtainMessage(1, new a(j, j2)));
        }

        public final void l() {
            while (this.f5954a.K(false)) {
                so3 so3VarG = g();
                if (so3VarG != null) {
                    long j = so3VarG.e;
                    Metadata metadataA = d.this.c.a(so3VarG);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.get(0);
                        if (d.h(eventMessage.schemeIdUri, eventMessage.value)) {
                            m(j, eventMessage);
                        }
                    }
                }
            }
            this.f5954a.s();
        }

        public final void m(long j, EventMessage eventMessage) {
            long jF = d.f(eventMessage);
            if (jF == -9223372036854775807L) {
                return;
            }
            k(j, jF);
        }

        public void n() {
            this.f5954a.T();
        }
    }

    public d(zt0 zt0Var, b bVar, w9 w9Var) {
        this.f = zt0Var;
        this.b = bVar;
        this.f5952a = w9Var;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return g86.O0(g86.D(eventMessage.messageData));
        } catch (ParserException unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @Nullable
    public final Map.Entry<Long, Long> e(long j) {
        return this.e.ceilingEntry(Long.valueOf(j));
    }

    public final void g(long j, long j2) {
        Long l = this.e.get(Long.valueOf(j2));
        if (l == null) {
            this.e.put(Long.valueOf(j2), Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.e.put(Long.valueOf(j2), Long.valueOf(j));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f5953a, aVar.b);
        return true;
    }

    public final void i() {
        if (this.h) {
            this.i = true;
            this.h = false;
            this.b.b();
        }
    }

    public boolean j(long j) {
        zt0 zt0Var = this.f;
        boolean z = false;
        if (!zt0Var.d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        Map.Entry<Long, Long> entryE = e(zt0Var.h);
        if (entryE != null && entryE.getValue().longValue() < j) {
            this.g = entryE.getKey().longValue();
            l();
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public c k() {
        return new c(this.f5952a);
    }

    public final void l() {
        this.b.a(this.g);
    }

    public void m(x50 x50Var) {
        this.h = true;
    }

    public boolean n(boolean z) {
        if (!this.f.d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.j = true;
        this.d.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f.h) {
                it.remove();
            }
        }
    }

    public void q(zt0 zt0Var) {
        this.i = false;
        this.g = -9223372036854775807L;
        this.f = zt0Var;
        p();
    }
}
