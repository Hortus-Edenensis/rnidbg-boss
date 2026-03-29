package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import defpackage.l63;
import defpackage.ll5;
import defpackage.ow2;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class JProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2449a;
    public ow2 b;
    public ByteBuffer c;

    public JProtocol(boolean z, Object obj, ByteBuffer byteBuffer) {
        this.f2449a = z;
        this.b = (ow2) obj;
        if (byteBuffer == null) {
            l63.f("JProtocol", "No body to parse.");
        } else {
            this.c = byteBuffer;
            b();
        }
    }

    public static byte[] parseHead(Object obj) {
        if (obj == null) {
            l63.f("JProtocol", "object was null");
            return null;
        }
        if (obj instanceof ow2) {
            return ((ow2) obj).i();
        }
        l63.f("JProtocol", "unknow Object");
        return null;
    }

    public abstract boolean a();

    public abstract void b();

    public final byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = ProtocolUtil.getBytes(this.c);
        if (bytes == null) {
            l63.f("JProtocol", "toBytes bodyBytes  is  null");
            return null;
        }
        this.b.g((this.f2449a ? 24 : 20) + bytes.length);
        try {
            byteArrayOutputStream.write(this.b.i());
            byteArrayOutputStream.write(bytes);
        } catch (Exception unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l63.a("JProtocol", "Final - len:" + byteArray.length + ", bytes: " + ll5.b(byteArray));
        return byteArray;
    }

    public abstract void d();

    public void e(int i) {
        this.c.putShort((short) i);
    }

    public ByteBuffer getBody() {
        return this.c;
    }

    public int getCommand() {
        return this.b.a();
    }

    public ow2 getHead() {
        return this.b;
    }

    public long getJuid() {
        return this.b.b();
    }

    public abstract String getName();

    public Long getRid() {
        return this.b.c();
    }

    public int getSid() {
        return this.b.d();
    }

    public int getVersion() {
        return this.b.e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2449a ? "[Request]" : "[Response]");
        sb.append(" - ");
        sb.append(this.b.toString());
        return sb.toString();
    }

    public final byte[] writeBodyAndToBytes() {
        this.c.clear();
        d();
        this.c.flip();
        return c();
    }

    public JProtocol(boolean z, ByteBuffer byteBuffer, byte[] bArr) {
        this.f2449a = z;
        try {
            this.b = new ow2(z, bArr);
        } catch (Exception e) {
            l63.f("JProtocol", "create JHead failed:" + e.getMessage());
        }
        if (byteBuffer != null) {
            this.c = byteBuffer;
            b();
        } else {
            l63.f("JProtocol", "No body to parse.");
        }
    }

    public JProtocol(boolean z, int i, int i2, long j) {
        this.f2449a = z;
        this.b = new ow2(z, i, i2, j);
        this.c = ByteBuffer.allocate(7168);
    }

    public JProtocol(boolean z, int i, int i2, long j, int i3, long j2) {
        this.f2449a = z;
        this.b = new ow2(z, 0, i, i2, j, i3, j2);
        this.c = ByteBuffer.allocate(7168);
    }
}
