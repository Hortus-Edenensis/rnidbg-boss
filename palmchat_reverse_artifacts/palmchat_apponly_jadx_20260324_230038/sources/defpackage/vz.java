package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import defpackage.mw0;
import defpackage.vz;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class vz implements en5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<b> f21561a = new ArrayDeque<>();
    public final ArrayDeque<jn5> b;
    public final PriorityQueue<b> c;

    @Nullable
    public b d;
    public long e;
    public long f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends in5 implements Comparable<b> {
        public long j;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (g() != bVar.g()) {
                return g() ? 1 : -1;
            }
            long j = this.e - bVar.e;
            if (j == 0) {
                j = this.j - bVar.j;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends jn5 {
        public mw0.a<c> f;

        public c(mw0.a<c> aVar) {
            this.f = aVar;
        }

        @Override // defpackage.mw0
        public final void l() {
            this.f.a(this);
        }
    }

    public vz() {
        for (int i = 0; i < 10; i++) {
            this.f21561a.add(new b());
        }
        this.b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(new mw0.a() { // from class: uz
                @Override // mw0.a
                public final void a(mw0 mw0Var) {
                    this.f21327a.j((vz.c) mw0Var);
                }
            }));
        }
        this.c = new PriorityQueue<>();
    }

    public abstract dn5 a();

    public abstract void b(in5 in5Var);

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public in5 dequeueInputBuffer() throws SubtitleDecoderException {
        vh.g(this.d == null);
        if (this.f21561a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f21561a.pollFirst();
        this.d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public jn5 dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((b) g86.j(this.c.peek())).e <= this.e) {
            b bVar = (b) g86.j(this.c.poll());
            if (bVar.g()) {
                jn5 jn5Var = (jn5) g86.j(this.b.pollFirst());
                jn5Var.a(4);
                i(bVar);
                return jn5Var;
            }
            b(bVar);
            if (g()) {
                dn5 dn5VarA = a();
                jn5 jn5Var2 = (jn5) g86.j(this.b.pollFirst());
                jn5Var2.m(bVar.e, dn5VarA, Long.MAX_VALUE);
                i(bVar);
                return jn5Var2;
            }
            i(bVar);
        }
        return null;
    }

    @Nullable
    public final jn5 e() {
        return this.b.pollFirst();
    }

    public final long f() {
        return this.e;
    }

    @Override // defpackage.kw0
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            i((b) g86.j(this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            i(bVar);
            this.d = null;
        }
    }

    public abstract boolean g();

    @Override // defpackage.kw0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(in5 in5Var) throws SubtitleDecoderException {
        vh.a(in5Var == this.d);
        b bVar = (b) in5Var;
        if (bVar.f()) {
            i(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.j = j;
            this.c.add(bVar);
        }
        this.d = null;
    }

    public final void i(b bVar) {
        bVar.b();
        this.f21561a.add(bVar);
    }

    public void j(jn5 jn5Var) {
        jn5Var.b();
        this.b.add(jn5Var);
    }

    @Override // defpackage.en5
    public void setPositionUs(long j) {
        this.e = j;
    }

    @Override // defpackage.kw0
    public void release() {
    }
}
