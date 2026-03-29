package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import defpackage.gc4;
import defpackage.u06;
import defpackage.vh;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f5955a;
    public final int b;
    public final a c;
    public final byte[] d;
    public int e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(gc4 gc4Var);
    }

    public e(com.google.android.exoplayer2.upstream.a aVar, int i, a aVar2) {
        vh.a(i > 0);
        this.f5955a = aVar;
        this.b = i;
        this.c = aVar2;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.f5955a.b(u06Var);
    }

    public final boolean c() throws IOException {
        if (this.f5955a.read(this.d, 0, 1) == -1) {
            return false;
        }
        int i = (this.d[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int i4 = this.f5955a.read(bArr, i3, i2);
            if (i4 == -1) {
                return false;
            }
            i3 += i4;
            i2 -= i4;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.c.a(new gc4(bArr, i));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f5955a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return this.f5955a.getUri();
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.e == 0) {
            if (!c()) {
                return -1;
            }
            this.e = this.b;
        }
        int i3 = this.f5955a.read(bArr, i, Math.min(this.e, i2));
        if (i3 != -1) {
            this.e -= i3;
        }
        return i3;
    }
}
