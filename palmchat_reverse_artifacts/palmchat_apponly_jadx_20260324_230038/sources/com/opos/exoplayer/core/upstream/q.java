package com.opos.exoplayer.core.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class q implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f8388a;
    private final r<? super q> b;
    private Uri c;
    private AssetFileDescriptor d;
    private InputStream e;
    private long f;
    private boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "RawResourceDataSourceException";
        }

        public a(String str) {
            super(str);
        }
    }

    public q(Context context, r<? super q> rVar) {
        this.f8388a = context.getResources();
        this.b = rVar;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
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
        int i3 = this.e.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - ((long) i3);
        }
        r<? super q> rVar = this.b;
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
                InputStream inputStream = this.e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new a(e);
                    }
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        r<? super q> rVar = this.b;
                        if (rVar != null) {
                            rVar.a(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } catch (Throwable th) {
            this.e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        r<? super q> rVar2 = this.b;
                        if (rVar2 != null) {
                            rVar2.a(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new a(e3);
                }
            } finally {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    r<? super q> rVar3 = this.b;
                    if (rVar3 != null) {
                        rVar3.a(this);
                    }
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public long a(DataSpec dataSpec) throws a {
        try {
            Uri uri = dataSpec.f8366a;
            this.c = uri;
            if (!TextUtils.equals("rawresource", uri.getScheme())) {
                throw new a("URI must use scheme rawresource");
            }
            try {
                this.d = this.f8388a.openRawResourceFd(Integer.parseInt(this.c.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.d.getFileDescriptor());
                this.e = fileInputStream;
                fileInputStream.skip(this.d.getStartOffset());
                if (this.e.skip(dataSpec.d) < dataSpec.d) {
                    throw new EOFException();
                }
                long j = dataSpec.e;
                long j2 = -1;
                if (j != -1) {
                    this.f = j;
                } else {
                    long length = this.d.getLength();
                    if (length != -1) {
                        j2 = length - dataSpec.d;
                    }
                    this.f = j2;
                }
                this.g = true;
                r<? super q> rVar = this.b;
                if (rVar != null) {
                    rVar.a(this, dataSpec);
                }
                return this.f;
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        return this.c;
    }
}
