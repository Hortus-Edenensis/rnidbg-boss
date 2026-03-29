package com.opos.exoplayer.core.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f8372a;
    private final r<? super c> b;
    private Uri c;
    private InputStream d;
    private long e;
    private boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends com.opos.exoplayer.core.util.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "AssetDataSourceException";
        }
    }

    public c(Context context, r<? super c> rVar) {
        this.f8372a = context.getAssets();
        this.b = rVar;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e);
            }
        }
        int i3 = this.d.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - ((long) i3);
        }
        r<? super c> rVar = this.b;
        if (rVar != null) {
            rVar.a(this, i3);
        }
        return i3;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() {
        this.c = null;
        try {
            try {
                InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new a(e);
            }
        } finally {
            this.d = null;
            if (this.f) {
                this.f = false;
                r<? super c> rVar = this.b;
                if (rVar != null) {
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public long a(DataSpec dataSpec) throws a {
        try {
            Uri uri = dataSpec.f8366a;
            this.c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.f8372a.open(path, 1);
            this.d = inputStreamOpen;
            if (inputStreamOpen.skip(dataSpec.d) < dataSpec.d) {
                throw new EOFException();
            }
            long j = dataSpec.e;
            if (j != -1) {
                this.e = j;
            } else {
                long jAvailable = this.d.available();
                this.e = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            r<? super c> rVar = this.b;
            if (rVar != null) {
                rVar.a(this, dataSpec);
            }
            return this.e;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        return this.c;
    }
}
