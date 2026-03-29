package com.opos.exoplayer.core.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.source.i;
import com.opos.exoplayer.core.source.r;
import com.opos.exoplayer.core.upstream.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e implements h, r.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f8290a;
    private final g.a b;
    private final com.opos.exoplayer.core.extractor.h c;
    private final int d;
    private final i.a e;
    private final String f;
    private final int g;
    private h.a h;
    private long i;
    private boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g.a f8291a;

        @Nullable
        private com.opos.exoplayer.core.extractor.h b;

        @Nullable
        private String c;
        private int d = -1;
        private int e = 1048576;
        private boolean f;

        public a(g.a aVar) {
            this.f8291a = aVar;
        }

        public e a(Uri uri) {
            return a(uri, null, null);
        }

        public e a(Uri uri, @Nullable Handler handler, @Nullable i iVar) {
            this.f = true;
            if (this.b == null) {
                this.b = new com.opos.exoplayer.core.extractor.c();
            }
            return new e(uri, this.f8291a, this.b, this.d, handler, iVar, this.c, this.e);
        }
    }

    private e(Uri uri, g.a aVar, com.opos.exoplayer.core.extractor.h hVar, int i, @Nullable Handler handler, @Nullable i iVar, @Nullable String str, int i2) {
        this.f8290a = uri;
        this.b = aVar;
        this.c = hVar;
        this.d = i;
        this.e = new i.a(handler, iVar);
        this.f = str;
        this.g = i2;
    }

    @Override // com.opos.exoplayer.core.source.h
    public g a(h.b bVar, com.opos.exoplayer.core.upstream.b bVar2) {
        com.opos.exoplayer.core.util.a.a(bVar.f8292a == 0);
        return new r(this.f8290a, this.b.a(), this.c.a(), this.d, this.e, this, bVar2, this.f, this.g);
    }

    @Override // com.opos.exoplayer.core.source.h
    public void b() {
        this.h = null;
    }

    private void b(long j, boolean z) {
        this.i = j;
        this.j = z;
        this.h.a(this, new n(this.i, this.j, false), null);
    }

    @Override // com.opos.exoplayer.core.source.h
    public void a() {
    }

    @Override // com.opos.exoplayer.core.source.r.e
    public void a(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.i;
        }
        if (this.i == j && this.j == z) {
            return;
        }
        b(j, z);
    }

    @Override // com.opos.exoplayer.core.source.h
    public void a(com.opos.exoplayer.core.g gVar, boolean z, h.a aVar) {
        this.h = aVar;
        b(-9223372036854775807L, false);
    }

    @Override // com.opos.exoplayer.core.source.h
    public void a(g gVar) {
        ((r) gVar).f();
    }
}
