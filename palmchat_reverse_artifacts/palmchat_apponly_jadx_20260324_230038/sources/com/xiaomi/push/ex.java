package com.xiaomi.push;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class ex extends er {
    public ex() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.er
    /* JADX INFO: renamed from: a */
    public ByteBuffer mo415a(ByteBuffer byteBuffer) {
        return m418a().length == 0 ? byteBuffer : super.mo415a(byteBuffer);
    }

    @Override // com.xiaomi.push.er
    public int c() {
        if (m418a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
