package com.google.android.exoplayer2.upstream.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import defpackage.g86;
import defpackage.uu0;
import defpackage.vh;
import defpackage.vx4;
import defpackage.y53;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class CacheDataSink implements uu0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f6015a;
    public final long b;
    public final int c;

    @Nullable
    public com.google.android.exoplayer2.upstream.b d;
    public long e;

    @Nullable
    public File f;

    @Nullable
    public OutputStream g;
    public long h;
    public long i;
    public vx4 j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements uu0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f6016a;
        public long b = 5242880;
        public int c = 20480;

        public a a(Cache cache) {
            this.f6016a = cache;
            return this;
        }

        @Override // uu0.a
        public uu0 createDataSink() {
            return new CacheDataSink((Cache) vh.e(this.f6016a), this.b, this.c);
        }
    }

    public CacheDataSink(Cache cache, long j, int i) {
        vh.h(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            y53.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f6015a = (Cache) vh.e(cache);
        this.b = j == -1 ? Long.MAX_VALUE : j;
        this.c = i;
    }

    @Override // defpackage.uu0
    public void a(com.google.android.exoplayer2.upstream.b bVar) throws CacheDataSinkException {
        vh.e(bVar.i);
        if (bVar.h == -1 && bVar.d(2)) {
            this.d = null;
            return;
        }
        this.d = bVar;
        this.e = bVar.d(4) ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            c(bVar);
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            g86.n(this.g);
            this.g = null;
            File file = (File) g86.j(this.f);
            this.f = null;
            this.f6015a.commitFile(file, this.h);
        } catch (Throwable th) {
            g86.n(this.g);
            this.g = null;
            File file2 = (File) g86.j(this.f);
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long j = bVar.h;
        this.f = this.f6015a.startFile((String) g86.j(bVar.i), bVar.g + this.i, j != -1 ? Math.min(j - this.i, this.e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            vx4 vx4Var = this.j;
            if (vx4Var == null) {
                this.j = new vx4(fileOutputStream, this.c);
            } else {
                vx4Var.a(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    @Override // defpackage.uu0
    public void close() throws CacheDataSinkException {
        if (this.d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // defpackage.uu0
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        com.google.android.exoplayer2.upstream.b bVar = this.d;
        if (bVar == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    b();
                    c(bVar);
                }
                int iMin = (int) Math.min(i2 - i3, this.e - this.h);
                ((OutputStream) g86.j(this.g)).write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }
}
