package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import defpackage.g86;
import defpackage.ip0;
import defpackage.lw;
import defpackage.mp0;
import defpackage.nw;
import defpackage.u06;
import defpackage.uu0;
import defpackage.vh;
import defpackage.vm4;
import defpackage.xt5;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f6017a;
    public final com.google.android.exoplayer2.upstream.a b;

    @Nullable
    public final com.google.android.exoplayer2.upstream.a c;
    public final com.google.android.exoplayer2.upstream.a d;
    public final lw e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    @Nullable
    public Uri i;

    @Nullable
    public com.google.android.exoplayer2.upstream.b j;

    @Nullable
    public com.google.android.exoplayer2.upstream.b k;

    @Nullable
    public com.google.android.exoplayer2.upstream.a l;
    public long m;
    public long n;
    public long o;

    @Nullable
    public nw p;
    public boolean q;
    public boolean r;
    public long s;
    public long t;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements a.InterfaceC0360a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f6018a;

        @Nullable
        public uu0.a c;
        public boolean e;

        @Nullable
        public a.InterfaceC0360a f;

        @Nullable
        public PriorityTaskManager g;
        public int h;
        public int i;
        public a.InterfaceC0360a b = new FileDataSource.b();
        public lw d = lw.f19088a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0360a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            a.InterfaceC0360a interfaceC0360a = this.f;
            return b(interfaceC0360a != null ? interfaceC0360a.createDataSource() : null, this.i, this.h);
        }

        public final a b(@Nullable com.google.android.exoplayer2.upstream.a aVar, int i, int i2) {
            uu0 uu0VarCreateDataSink;
            Cache cache = (Cache) vh.e(this.f6018a);
            if (this.e || aVar == null) {
                uu0VarCreateDataSink = null;
            } else {
                uu0.a aVar2 = this.c;
                uu0VarCreateDataSink = aVar2 != null ? aVar2.createDataSink() : new CacheDataSink.a().a(cache).createDataSink();
            }
            return new a(cache, aVar, this.b.createDataSource(), uu0VarCreateDataSink, this.d, i, this.g, i2, null);
        }

        public c c(Cache cache) {
            this.f6018a = cache;
            return this;
        }

        public c d(lw lwVar) {
            this.d = lwVar;
            return this;
        }

        public c e(@Nullable a.InterfaceC0360a interfaceC0360a) {
            this.f = interfaceC0360a;
            return this;
        }
    }

    public static Uri d(Cache cache, String str, Uri uri) {
        Uri uriB = ip0.b(cache.getContentMetadata(str));
        return uriB != null ? uriB : uri;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        try {
            String strA = this.e.a(bVar);
            com.google.android.exoplayer2.upstream.b bVarA = bVar.a().f(strA).a();
            this.j = bVarA;
            this.i = d(this.f6017a, strA, bVarA.f6011a);
            this.n = bVar.g;
            int iN = n(bVar);
            boolean z = iN != -1;
            this.r = z;
            if (z) {
                k(iN);
            }
            if (this.r) {
                this.o = -1L;
            } else {
                long jA = ip0.a(this.f6017a.getContentMetadata(strA));
                this.o = jA;
                if (jA != -1) {
                    long j = jA - bVar.g;
                    this.o = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = bVar.h;
            if (jMin != -1) {
                long j2 = this.o;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.o = jMin;
            }
            long j3 = this.o;
            if (j3 > 0 || j3 == -1) {
                l(bVarA, false);
            }
            long j4 = bVar.h;
            return j4 != -1 ? j4 : this.o;
        } catch (Throwable th) {
            e(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.b.b(u06Var);
        this.d.b(u06Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() throws IOException {
        com.google.android.exoplayer2.upstream.a aVar = this.l;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.k = null;
            this.l = null;
            nw nwVar = this.p;
            if (nwVar != null) {
                this.f6017a.b(nwVar);
                this.p = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.j = null;
        this.i = null;
        this.n = 0L;
        j();
        try {
            c();
        } catch (Throwable th) {
            e(th);
            throw th;
        }
    }

    public final void e(Throwable th) {
        if (g() || (th instanceof Cache.CacheException)) {
            this.q = true;
        }
    }

    public final boolean f() {
        return this.l == this.d;
    }

    public final boolean g() {
        return this.l == this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        return h() ? this.d.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return this.i;
    }

    public final boolean h() {
        return !g();
    }

    public final boolean i() {
        return this.l == this.c;
    }

    public final void l(com.google.android.exoplayer2.upstream.b bVar, boolean z) throws IOException {
        nw nwVarStartReadWrite;
        long jMin;
        com.google.android.exoplayer2.upstream.b bVarA;
        com.google.android.exoplayer2.upstream.a aVar;
        String str = (String) g86.j(bVar.i);
        if (this.r) {
            nwVarStartReadWrite = null;
        } else if (this.f) {
            try {
                nwVarStartReadWrite = this.f6017a.startReadWrite(str, this.n, this.o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            nwVarStartReadWrite = this.f6017a.startReadWriteNonBlocking(str, this.n, this.o);
        }
        if (nwVarStartReadWrite == null) {
            aVar = this.d;
            bVarA = bVar.a().h(this.n).g(this.o).a();
        } else if (nwVarStartReadWrite.d) {
            Uri uriFromFile = Uri.fromFile((File) g86.j(nwVarStartReadWrite.e));
            long j = nwVarStartReadWrite.b;
            long j2 = this.n - j;
            long jMin2 = nwVarStartReadWrite.c - j2;
            long j3 = this.o;
            if (j3 != -1) {
                jMin2 = Math.min(jMin2, j3);
            }
            bVarA = bVar.a().i(uriFromFile).k(j).h(j2).g(jMin2).a();
            aVar = this.b;
        } else {
            if (nwVarStartReadWrite.c()) {
                jMin = this.o;
            } else {
                jMin = nwVarStartReadWrite.c;
                long j4 = this.o;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
            }
            bVarA = bVar.a().h(this.n).g(jMin).a();
            aVar = this.c;
            if (aVar == null) {
                aVar = this.d;
                this.f6017a.b(nwVarStartReadWrite);
                nwVarStartReadWrite = null;
            }
        }
        this.t = (this.r || aVar != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            vh.g(f());
            if (aVar == this.d) {
                return;
            }
            try {
                c();
            } finally {
            }
        }
        if (nwVarStartReadWrite != null && nwVarStartReadWrite.b()) {
            this.p = nwVarStartReadWrite;
        }
        this.l = aVar;
        this.k = bVarA;
        this.m = 0L;
        long jA = aVar.a(bVarA);
        mp0 mp0Var = new mp0();
        if (bVarA.h == -1 && jA != -1) {
            this.o = jA;
            mp0.g(mp0Var, this.n + jA);
        }
        if (h()) {
            Uri uri = aVar.getUri();
            this.i = uri;
            mp0.h(mp0Var, bVar.f6011a.equals(uri) ^ true ? this.i : null);
        }
        if (i()) {
            this.f6017a.c(str, mp0Var);
        }
    }

    public final void m(String str) throws IOException {
        this.o = 0L;
        if (i()) {
            mp0 mp0Var = new mp0();
            mp0.g(mp0Var, this.n);
            this.f6017a.c(str, mp0Var);
        }
    }

    public final int n(com.google.android.exoplayer2.upstream.b bVar) {
        if (this.g && this.q) {
            return 0;
        }
        return (this.h && bVar.h == -1) ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:9:0x001e, B:11:0x0026, B:12:0x002a, B:14:0x003a, B:16:0x0040, B:17:0x0046, B:19:0x0057, B:20:0x005b, B:22:0x0061, B:24:0x0067, B:26:0x006d, B:27:0x0079, B:33:0x0085), top: B:38:0x001e }] */
    @Override // defpackage.ru0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) vh.e(this.j);
        com.google.android.exoplayer2.upstream.b bVar2 = (com.google.android.exoplayer2.upstream.b) vh.e(this.k);
        try {
            if (this.n >= this.t) {
                l(bVar, true);
            }
            int i3 = ((com.google.android.exoplayer2.upstream.a) vh.e(this.l)).read(bArr, i, i2);
            if (i3 != -1) {
                if (g()) {
                    this.s += (long) i3;
                }
                long j = i3;
                this.n += j;
                this.m += j;
                long j2 = this.o;
                if (j2 != -1) {
                    this.o = j2 - j;
                }
            } else if (h()) {
                long j3 = bVar2.h;
                if (j3 != -1 && this.m >= j3) {
                    long j4 = this.o;
                    if (j4 <= 0) {
                        if (j4 == -1) {
                        }
                    }
                    c();
                    l(bVar, false);
                    return read(bArr, i, i2);
                }
                m((String) g86.j(bVar.i));
            }
            return i3;
        } catch (Throwable th) {
            e(th);
            throw th;
        }
    }

    public a(Cache cache, @Nullable com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, @Nullable uu0 uu0Var, @Nullable lw lwVar, int i, @Nullable PriorityTaskManager priorityTaskManager, int i2, @Nullable b bVar) {
        this.f6017a = cache;
        this.b = aVar2;
        this.e = lwVar == null ? lw.f19088a : lwVar;
        this.f = (i & 1) != 0;
        this.g = (i & 2) != 0;
        this.h = (i & 4) != 0;
        if (aVar == null) {
            this.d = h.f6028a;
            this.c = null;
        } else {
            aVar = priorityTaskManager != null ? new vm4(aVar, priorityTaskManager, i2) : aVar;
            this.d = aVar;
            this.c = uu0Var != null ? new xt5(aVar, uu0Var) : null;
        }
    }

    public final void j() {
    }

    public final void k(int i) {
    }
}
