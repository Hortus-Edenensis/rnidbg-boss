package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import defpackage.bv0;
import defpackage.g86;
import defpackage.m43;
import defpackage.rk5;
import defpackage.vh;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class g<T> implements Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6027a;
    public final b b;
    public final int c;
    public final rk5 d;
    public final a<? extends T> e;

    @Nullable
    public volatile T f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public g(com.google.android.exoplayer2.upstream.a aVar, Uri uri, int i, a<? extends T> aVar2) {
        this(aVar, new b.C0361b().i(uri).b(1).a(), i, aVar2);
    }

    public long a() {
        return this.d.c();
    }

    public Map<String, List<String>> b() {
        return this.d.e();
    }

    @Nullable
    public final T c() {
        return this.f;
    }

    public Uri d() {
        return this.d.d();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        this.d.f();
        bv0 bv0Var = new bv0(this.d, this.b);
        try {
            bv0Var.d();
            this.f = this.e.parse((Uri) vh.e(this.d.getUri()), bv0Var);
        } finally {
            g86.n(bv0Var);
        }
    }

    public g(com.google.android.exoplayer2.upstream.a aVar, b bVar, int i, a<? extends T> aVar2) {
        this.d = new rk5(aVar);
        this.b = bVar;
        this.c = i;
        this.e = aVar2;
        this.f6027a = m43.a();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void cancelLoad() {
    }
}
