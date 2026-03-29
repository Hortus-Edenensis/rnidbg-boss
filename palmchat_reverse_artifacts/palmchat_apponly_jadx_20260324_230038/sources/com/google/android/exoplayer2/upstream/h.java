package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.h;
import defpackage.u06;
import defpackage.vu0;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6028a = new h();
    public static final a.InterfaceC0360a b = new a.InterfaceC0360a() { // from class: ti4
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0360a
        public final a createDataSource() {
            return h.c();
        }
    };

    public static /* synthetic */ h c() {
        return new h();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map getResponseHeaders() {
        return vu0.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
    }
}
