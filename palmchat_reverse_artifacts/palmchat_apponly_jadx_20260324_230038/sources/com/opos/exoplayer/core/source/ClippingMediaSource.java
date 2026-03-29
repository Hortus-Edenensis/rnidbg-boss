package com.opos.exoplayer.core.source;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ClippingMediaSource extends b<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f8280a;
    private final long b;
    private final long c;
    private final boolean d;
    private final ArrayList<com.opos.exoplayer.core.source.a> e;
    private h.a f;
    private IllegalClippingException g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class IllegalClippingException extends com.opos.exoplayer.core.util.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8281a;

        /* JADX INFO: compiled from: SearchBox */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i) {
            this.f8281a = i;
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "IllegalClippingException";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends f {
        private final long c;
        private final long d;

        public a(w wVar, long j, long j2) throws IllegalClippingException {
            super(wVar);
            if (wVar.c() != 1) {
                throw new IllegalClippingException(0);
            }
            if (wVar.a(0, new w.a()).c() != 0) {
                throw new IllegalClippingException(1);
            }
            w.b bVarA = wVar.a(0, new w.b(), false);
            j2 = j2 == Long.MIN_VALUE ? bVarA.i : j2;
            long j3 = bVarA.i;
            if (j3 != -9223372036854775807L) {
                j2 = j2 > j3 ? j3 : j2;
                if (j != 0 && !bVarA.d) {
                    throw new IllegalClippingException(2);
                }
                if (j > j2) {
                    throw new IllegalClippingException(3);
                }
            }
            this.c = j;
            this.d = j2;
        }

        @Override // com.opos.exoplayer.core.source.f, com.opos.exoplayer.core.w
        public w.a a(int i, w.a aVar, boolean z) {
            w.a aVarA = this.b.a(0, aVar, z);
            long j = this.d;
            aVarA.d = j != -9223372036854775807L ? j - this.c : -9223372036854775807L;
            return aVarA;
        }

        @Override // com.opos.exoplayer.core.source.f, com.opos.exoplayer.core.w
        public w.b a(int i, w.b bVar, boolean z, long j) {
            w.b bVarA = this.b.a(0, bVar, z, j);
            long j2 = this.d;
            bVarA.i = j2 != -9223372036854775807L ? j2 - this.c : -9223372036854775807L;
            long j3 = bVarA.h;
            if (j3 != -9223372036854775807L) {
                long jMax = Math.max(j3, this.c);
                bVarA.h = jMax;
                long j4 = this.d;
                if (j4 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j4);
                }
                bVarA.h = jMax - this.c;
            }
            long jA = C.a(this.c);
            long j5 = bVarA.b;
            if (j5 != -9223372036854775807L) {
                bVarA.b = j5 + jA;
            }
            long j6 = bVarA.c;
            if (j6 != -9223372036854775807L) {
                bVarA.c = j6 + jA;
            }
            return bVarA;
        }
    }

    @Override // com.opos.exoplayer.core.source.h
    public g a(h.b bVar, com.opos.exoplayer.core.upstream.b bVar2) {
        com.opos.exoplayer.core.source.a aVar = new com.opos.exoplayer.core.source.a(this.f8280a.a(bVar, bVar2), this.d);
        this.e.add(aVar);
        aVar.a(this.b, this.c);
        return aVar;
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void b() {
        super.b();
        this.g = null;
        this.f = null;
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void a() throws IllegalClippingException {
        IllegalClippingException illegalClippingException = this.g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.a();
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void a(com.opos.exoplayer.core.g gVar, boolean z, h.a aVar) {
        super.a(gVar, z, aVar);
        this.f = aVar;
        a((Object) null, this.f8280a);
    }

    @Override // com.opos.exoplayer.core.source.h
    public void a(g gVar) {
        com.opos.exoplayer.core.util.a.b(this.e.remove(gVar));
        this.f8280a.a(((com.opos.exoplayer.core.source.a) gVar).f8284a);
    }

    @Override // com.opos.exoplayer.core.source.b
    public void a(Void r7, h hVar, w wVar, @Nullable Object obj) {
        if (this.g != null) {
            return;
        }
        try {
            this.f.a(this, new a(wVar, this.b, this.c), obj);
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                this.e.get(i).a(this.b, this.c);
            }
        } catch (IllegalClippingException e) {
            this.g = e;
        }
    }
}
