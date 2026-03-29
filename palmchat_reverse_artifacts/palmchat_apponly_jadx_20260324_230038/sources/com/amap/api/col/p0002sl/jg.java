package com.amap.api.col.p0002sl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ji f2929a;
    private ByteBuffer b;

    public jg(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.b = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f2929a = new ji(this.b);
    }

    public final jg a() {
        this.f2929a.a(this.b);
        return this;
    }
}
