package com.opos.exoplayer.core.upstream;

import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r<? super o> f8384a;
    private RandomAccessFile b;
    private Uri c;
    private long d;
    private boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "FileDataSourceException";
        }
    }

    public o() {
        this(null);
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.b.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.d -= (long) i3;
                r<? super o> rVar = this.f8384a;
                if (rVar != null) {
                    rVar.a(this, i3);
                }
            }
            return i3;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() {
        this.c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                throw new a(e);
            }
        } finally {
            this.b = null;
            if (this.e) {
                this.e = false;
                r<? super o> rVar = this.f8384a;
                if (rVar != null) {
                    rVar.a(this);
                }
            }
        }
    }

    public o(r<? super o> rVar) {
        this.f8384a = rVar;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public long a(DataSpec dataSpec) throws a {
        try {
            this.c = dataSpec.f8366a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(dataSpec.f8366a.getPath(), t.k);
            this.b = randomAccessFile;
            randomAccessFile.seek(dataSpec.d);
            long length = dataSpec.e;
            if (length == -1) {
                length = this.b.length() - dataSpec.d;
            }
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            r<? super o> rVar = this.f8384a;
            if (rVar != null) {
                rVar.a(this, dataSpec);
            }
            return this.d;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        return this.c;
    }
}
