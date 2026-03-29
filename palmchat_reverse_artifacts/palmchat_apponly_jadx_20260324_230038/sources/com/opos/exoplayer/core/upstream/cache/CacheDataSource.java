package com.opos.exoplayer.core.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.upstream.DataSpec;
import com.opos.exoplayer.core.upstream.cache.a;
import com.opos.exoplayer.core.upstream.g;
import com.opos.exoplayer.core.upstream.h;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class CacheDataSource implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.upstream.cache.a f8373a;
    private final g b;
    private final g c;
    private final g d;

    @Nullable
    private final a e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private g i;
    private boolean j;
    private Uri k;
    private int l;
    private String m;
    private long n;
    private long o;
    private b p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(long j, long j2);
    }

    private boolean c() {
        return this.i == this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        g gVar = this.i;
        if (gVar == null) {
            return;
        }
        try {
            gVar.b();
        } finally {
            this.i = null;
            this.j = false;
            b bVar = this.p;
            if (bVar != null) {
                this.f8373a.a(bVar);
                this.p = null;
            }
        }
    }

    private void e() {
        a aVar = this.e;
        if (aVar == null || this.s <= 0) {
            return;
        }
        aVar.a(this.f8373a.a(), this.s);
        this.s = 0L;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.o == 0) {
            return -1;
        }
        try {
            if (this.n >= this.t) {
                a(true);
            }
            int iA = this.i.a(bArr, i, i2);
            if (iA != -1) {
                if (this.i == this.b) {
                    this.s += (long) iA;
                }
                long j = iA;
                this.n += j;
                long j2 = this.o;
                if (j2 != -1) {
                    this.o = j2 - j;
                }
            } else {
                if (!this.j) {
                    long j3 = this.o;
                    if (j3 <= 0) {
                        if (j3 == -1) {
                        }
                    }
                    d();
                    a(false);
                    return a(bArr, i, i2);
                }
                a(0L);
            }
            return iA;
        } catch (IOException e) {
            if (this.j && a(e)) {
                a(0L);
                return -1;
            }
            b(e);
            throw e;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() throws IOException {
        this.k = null;
        e();
        try {
            d();
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    private void b(IOException iOException) {
        if (this.i == this.b || (iOException instanceof a.C0705a)) {
            this.q = true;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public long a(DataSpec dataSpec) throws IOException {
        try {
            this.k = dataSpec.f8366a;
            this.l = dataSpec.g;
            String strA = c.a(dataSpec);
            this.m = strA;
            this.n = dataSpec.d;
            boolean z = (this.g && this.q) || (dataSpec.e == -1 && this.h);
            this.r = z;
            long j = dataSpec.e;
            if (j != -1 || z) {
                this.o = j;
            } else {
                long jA = this.f8373a.a(strA);
                this.o = jA;
                if (jA != -1) {
                    long j2 = jA - dataSpec.d;
                    this.o = j2;
                    if (j2 <= 0) {
                        throw new h(0);
                    }
                }
            }
            a(false);
            return this.o;
        } catch (IOException e) {
            b(e);
            throw e;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        g gVar = this.i;
        return gVar == this.d ? gVar.a() : this.k;
    }

    private void a(long j) {
        this.o = j;
        if (c()) {
            this.f8373a.c(this.m, this.n + j);
        }
    }

    private void a(boolean z) throws InterruptedIOException {
        b bVarA;
        long jMin;
        DataSpec dataSpec;
        g gVar;
        if (this.r) {
            bVarA = null;
        } else if (this.f) {
            try {
                bVarA = this.f8373a.a(this.m, this.n);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            bVarA = this.f8373a.b(this.m, this.n);
        }
        if (bVarA == null) {
            gVar = this.d;
            dataSpec = new DataSpec(this.k, this.n, this.o, this.m, this.l);
        } else if (bVarA.d) {
            Uri uriFromFile = Uri.fromFile(bVarA.e);
            long j = this.n - bVarA.b;
            long jMin2 = bVarA.c - j;
            long j2 = this.o;
            if (j2 != -1) {
                jMin2 = Math.min(jMin2, j2);
            }
            dataSpec = new DataSpec(uriFromFile, this.n, j, jMin2, this.m, this.l);
            gVar = this.b;
        } else {
            if (bVarA.a()) {
                jMin = this.o;
            } else {
                jMin = bVarA.c;
                long j3 = this.o;
                if (j3 != -1) {
                    jMin = Math.min(jMin, j3);
                }
            }
            DataSpec dataSpec2 = new DataSpec(this.k, this.n, jMin, this.m, this.l);
            g gVar2 = this.c;
            if (gVar2 == null) {
                gVar2 = this.d;
                this.f8373a.a(bVarA);
                bVarA = null;
            }
            dataSpec = dataSpec2;
            gVar = gVar2;
        }
        this.t = (this.r || gVar != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            com.opos.exoplayer.core.util.a.b(this.i == this.d);
            if (gVar == this.d) {
                return;
            }
            try {
                d();
            } catch (Throwable th) {
                if (bVarA.b()) {
                    this.f8373a.a(bVarA);
                }
                throw th;
            }
        }
        if (bVarA != null && bVarA.b()) {
            this.p = bVarA;
        }
        this.i = gVar;
        this.j = dataSpec.e == -1;
        long jA = gVar.a(dataSpec);
        if (!this.j || jA == -1) {
            return;
        }
        a(jA);
    }

    private static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof h) && ((h) cause).f8377a == 0) {
                return true;
            }
        }
        return false;
    }
}
