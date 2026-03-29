package com.opos.exoplayer.core.upstream;

import android.content.Context;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8381a;
    private final r<? super g> b;
    private final g c;
    private g d;
    private g e;
    private g f;
    private g g;
    private g h;
    private g i;
    private g j;

    public k(Context context, r<? super g> rVar, g gVar) {
        this.f8381a = context.getApplicationContext();
        this.b = rVar;
        this.c = (g) com.opos.exoplayer.core.util.a.a(gVar);
    }

    private g c() {
        if (this.d == null) {
            this.d = new o(this.b);
        }
        return this.d;
    }

    private g d() {
        if (this.e == null) {
            this.e = new c(this.f8381a, this.b);
        }
        return this.e;
    }

    private g e() {
        if (this.f == null) {
            this.f = new e(this.f8381a, this.b);
        }
        return this.f;
    }

    private g f() {
        if (this.g == null) {
            try {
                this.g = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                com.opos.cmn.an.f.a.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    private g g() {
        if (this.h == null) {
            this.h = new f();
        }
        return this.h;
    }

    private g h() {
        if (this.i == null) {
            this.i = new q(this.f8381a, this.b);
        }
        return this.i;
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public int a(byte[] bArr, int i, int i2) {
        return this.j.a(bArr, i, i2);
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public void b() {
        g gVar = this.j;
        if (gVar != null) {
            try {
                gVar.b();
            } finally {
                this.j = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    @Override // com.opos.exoplayer.core.upstream.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(DataSpec dataSpec) {
        g gVarE;
        com.opos.exoplayer.core.util.a.b(this.j == null);
        String scheme = dataSpec.f8366a.getScheme();
        if (y.a(dataSpec.f8366a)) {
            gVarE = dataSpec.f8366a.getPath().startsWith("/android_asset/") ? d() : c();
        } else if (!"asset".equals(scheme)) {
            gVarE = "content".equals(scheme) ? e() : LiveConfigKey.RTMP.equals(scheme) ? f() : "data".equals(scheme) ? g() : "rawresource".equals(scheme) ? h() : this.c;
        }
        this.j = gVarE;
        return this.j.a(dataSpec);
    }

    @Override // com.opos.exoplayer.core.upstream.g
    public Uri a() {
        g gVar = this.j;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }
}
