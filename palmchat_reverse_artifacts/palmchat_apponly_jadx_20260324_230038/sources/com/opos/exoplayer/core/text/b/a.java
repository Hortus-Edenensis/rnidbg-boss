package com.opos.exoplayer.core.text.b;

import com.opos.exoplayer.core.util.p;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f8325a;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        p pVar = new p(list.get(0));
        this.f8325a = new b(pVar.h(), pVar.h());
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f8325a.a();
        }
        return new c(this.f8325a.a(bArr, i));
    }
}
