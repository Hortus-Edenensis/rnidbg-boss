package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.d;
import defpackage.g86;
import defpackage.tu0;
import defpackage.u06;
import defpackage.vh;
import defpackage.y53;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6013a;
    public final List<u06> b = new ArrayList();
    public final com.google.android.exoplayer2.upstream.a c;

    @Nullable
    public com.google.android.exoplayer2.upstream.a d;

    @Nullable
    public com.google.android.exoplayer2.upstream.a e;

    @Nullable
    public com.google.android.exoplayer2.upstream.a f;

    @Nullable
    public com.google.android.exoplayer2.upstream.a g;

    @Nullable
    public com.google.android.exoplayer2.upstream.a h;

    @Nullable
    public com.google.android.exoplayer2.upstream.a i;

    @Nullable
    public com.google.android.exoplayer2.upstream.a j;

    @Nullable
    public com.google.android.exoplayer2.upstream.a k;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements a.InterfaceC0360a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f6014a;
        public final a.InterfaceC0360a b;

        @Nullable
        public u06 c;

        public a(Context context) {
            this(context, new d.b());
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0360a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createDataSource() {
            c cVar = new c(this.f6014a, this.b.createDataSource());
            u06 u06Var = this.c;
            if (u06Var != null) {
                cVar.b(u06Var);
            }
            return cVar;
        }

        public a(Context context, a.InterfaceC0360a interfaceC0360a) {
            this.f6014a = context.getApplicationContext();
            this.b = interfaceC0360a;
        }
    }

    public c(Context context, com.google.android.exoplayer2.upstream.a aVar) {
        this.f6013a = context.getApplicationContext();
        this.c = (com.google.android.exoplayer2.upstream.a) vh.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        vh.g(this.k == null);
        String scheme = bVar.f6011a.getScheme();
        if (g86.B0(bVar.f6011a)) {
            String path = bVar.f6011a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.k = g();
            } else {
                this.k = d();
            }
        } else if ("asset".equals(scheme)) {
            this.k = d();
        } else if ("content".equals(scheme)) {
            this.k = e();
        } else if (LiveConfigKey.RTMP.equals(scheme)) {
            this.k = i();
        } else if ("udp".equals(scheme)) {
            this.k = j();
        } else if ("data".equals(scheme)) {
            this.k = f();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.k = h();
        } else {
            this.k = this.c;
        }
        return this.k.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.c.b(u06Var);
        this.b.add(u06Var);
        k(this.d, u06Var);
        k(this.e, u06Var);
        k(this.f, u06Var);
        k(this.g, u06Var);
        k(this.h, u06Var);
        k(this.i, u06Var);
        k(this.j, u06Var);
    }

    public final void c(com.google.android.exoplayer2.upstream.a aVar) {
        for (int i = 0; i < this.b.size(); i++) {
            aVar.b(this.b.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.k = null;
            }
        }
    }

    public final com.google.android.exoplayer2.upstream.a d() {
        if (this.e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f6013a);
            this.e = assetDataSource;
            c(assetDataSource);
        }
        return this.e;
    }

    public final com.google.android.exoplayer2.upstream.a e() {
        if (this.f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f6013a);
            this.f = contentDataSource;
            c(contentDataSource);
        }
        return this.f;
    }

    public final com.google.android.exoplayer2.upstream.a f() {
        if (this.i == null) {
            tu0 tu0Var = new tu0();
            this.i = tu0Var;
            c(tu0Var);
        }
        return this.i;
    }

    public final com.google.android.exoplayer2.upstream.a g() {
        if (this.d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.d = fileDataSource;
            c(fileDataSource);
        }
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        return aVar == null ? Collections.emptyMap() : aVar.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        com.google.android.exoplayer2.upstream.a aVar = this.k;
        if (aVar == null) {
            return null;
        }
        return aVar.getUri();
    }

    public final com.google.android.exoplayer2.upstream.a h() {
        if (this.j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f6013a);
            this.j = rawResourceDataSource;
            c(rawResourceDataSource);
        }
        return this.j;
    }

    public final com.google.android.exoplayer2.upstream.a i() {
        if (this.g == null) {
            try {
                com.google.android.exoplayer2.upstream.a aVar = (com.google.android.exoplayer2.upstream.a) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.g = aVar;
                c(aVar);
            } catch (ClassNotFoundException unused) {
                y53.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    public final com.google.android.exoplayer2.upstream.a j() {
        if (this.h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.h = udpDataSource;
            c(udpDataSource);
        }
        return this.h;
    }

    public final void k(@Nullable com.google.android.exoplayer2.upstream.a aVar, u06 u06Var) {
        if (aVar != null) {
            aVar.b(u06Var);
        }
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return ((com.google.android.exoplayer2.upstream.a) vh.e(this.k)).read(bArr, i, i2);
    }
}
