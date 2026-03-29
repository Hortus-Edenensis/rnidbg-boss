package com.amap.api.col.p0002sl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ji extends mo {
    public ji(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // com.amap.api.col.p0002sl.mo
    public final int a(CharSequence charSequence) {
        try {
            return super.a(charSequence);
        } catch (Throwable th) {
            ku.a(th);
            return super.a("");
        }
    }
}
