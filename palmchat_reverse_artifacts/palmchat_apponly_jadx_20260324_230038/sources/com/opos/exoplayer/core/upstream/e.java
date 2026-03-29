package com.opos.exoplayer.core.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentResolver f8375a;
    private final r<? super e> b;
    private Uri c;
    private AssetFileDescriptor d;
    private FileInputStream e;
    private long f;
    private boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "ContentDataSourceException";
        }
    }

    public e(Context context, r<? super e> rVar) {
        this.f8375a = context.getContentResolver();
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
        r<? super e> rVar = this.b;
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
                FileInputStream fileInputStream = this.e;
                if (fileInputStream != null) {
                    fileInputStream.close();
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
                        r<? super e> rVar = this.b;
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
                        r<? super e> rVar2 = this.b;
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
                    r<? super e> rVar3 = this.b;
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
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f8375a.openAssetFileDescriptor(uri, t.k);
            this.d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long jSkip = this.e.skip(dataSpec.d + startOffset) - startOffset;
            if (jSkip != dataSpec.d) {
                throw new EOFException();
            }
            long j = dataSpec.e;
            long jPosition = -1;
            if (j != -1) {
                this.f = j;
            } else {
                long length = this.d.getLength();
                if (length == -1) {
                    FileChannel channel = this.e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        jPosition = size - channel.position();
                    }
                    this.f = jPosition;
                } else {
                    j = length - jSkip;
                    this.f = j;
                }
            }
            this.g = true;
            r<? super e> rVar = this.b;
            if (rVar != null) {
                rVar.a(this, dataSpec);
            }
            return this.f;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        return this.c;
    }
}
