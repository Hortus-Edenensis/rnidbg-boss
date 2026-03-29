package com.opos.exoplayer.core.text;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends com.opos.exoplayer.core.decoder.f<f, g, d> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8315a;

    public a(String str) {
        super(new f[2], new g[2]);
        this.f8315a = str;
        a(1024);
    }

    public abstract b a(byte[] bArr, int i, boolean z);

    @Override // com.opos.exoplayer.core.decoder.f
    public final d a(f fVar, g gVar, boolean z) {
        try {
            ByteBuffer byteBuffer = fVar.b;
            gVar.a(fVar.c, a(byteBuffer.array(), byteBuffer.limit(), z), fVar.d);
            gVar.c(Integer.MIN_VALUE);
            return null;
        } catch (d e) {
            return e;
        }
    }

    @Override // com.opos.exoplayer.core.decoder.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final d a(Throwable th) {
        return new d("Unexpected decode error", th);
    }

    @Override // com.opos.exoplayer.core.decoder.f
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final f g() {
        return new f();
    }

    @Override // com.opos.exoplayer.core.decoder.f
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final g h() {
        return new j(this);
    }

    @Override // com.opos.exoplayer.core.text.c
    public void a(long j) {
    }

    @Override // com.opos.exoplayer.core.decoder.f
    public final void a(g gVar) {
        super.a(gVar);
    }
}
