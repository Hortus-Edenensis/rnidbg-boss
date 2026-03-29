package defpackage;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ShortCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ow2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19887a;
    public int b;
    public int c;
    public Long d;
    public int e;
    public long f;
    public boolean g;

    public ow2(boolean z, int i, int i2, int i3, long j, int i4, long j2) {
        this.g = z;
        this.f19887a = i;
        this.b = i2;
        this.c = i3;
        this.d = Long.valueOf(j);
        this.e = i4;
        this.f = j2;
    }

    public int a() {
        return this.c;
    }

    public long b() {
        return this.f;
    }

    public Long c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.b;
    }

    public void f(long j) {
        this.f = j;
    }

    public void g(int i) {
        this.f19887a = i;
    }

    public void h(int i) {
        this.e = i;
    }

    public byte[] i() {
        if (this.f19887a == 0) {
            throw new IllegalStateException("The head is not initialized yet.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.putShort((short) this.f19887a);
        byteBufferAllocate.put((byte) this.b);
        byteBufferAllocate.put((byte) this.c);
        byteBufferAllocate.putLong(this.d.longValue());
        if (this.g) {
            byteBufferAllocate.putInt(this.e);
        }
        byteBufferAllocate.putLong(this.f);
        byteBufferAllocate.flip();
        return ProtocolUtil.getBytesConsumed(byteBufferAllocate);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[JHead] - len:");
        sb.append(this.f19887a);
        sb.append(", version:");
        sb.append(this.b);
        sb.append(", command:");
        sb.append(this.c);
        sb.append(", rid:");
        sb.append(this.d);
        if (this.g) {
            str = ", sid:" + this.e;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.f);
        return sb.toString();
    }

    public ow2(boolean z, int i, int i2, long j) {
        this(z, 0, i, i2, j, 0, 0L);
    }

    public ow2(boolean z, byte[] bArr) {
        this.g = z;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f19887a = byteBufferWrap.getShort() & ShortCompanionObject.MAX_VALUE;
        this.b = byteBufferWrap.get();
        this.c = byteBufferWrap.get();
        Long lValueOf = Long.valueOf(byteBufferWrap.getLong());
        this.d = lValueOf;
        this.d = Long.valueOf(lValueOf.longValue() & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        if (z) {
            this.e = byteBufferWrap.getInt();
        }
        this.f = byteBufferWrap.getLong();
    }
}
