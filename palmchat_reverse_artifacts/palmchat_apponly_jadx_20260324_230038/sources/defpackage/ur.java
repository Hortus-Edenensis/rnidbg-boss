package defpackage;

import cn.jiguang.sdk.impl.helper.JException;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class ur implements Closeable {
    public SocketChannel b;
    public int c;
    public Selector d;
    public int f = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f21274a = ByteBuffer.allocate(49152);
    public boolean e = false;

    public int a(String str, int i) {
        if (this.f21274a == null) {
            this.f21274a = ByteBuffer.allocate(49152);
        }
        this.f21274a.clear();
        this.c = 0;
        this.e = true;
        return 0;
    }

    public boolean c() {
        SocketChannel socketChannel;
        return this.e && (socketChannel = this.b) != null && socketChannel.isConnected();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = false;
        ByteBuffer byteBuffer = this.f21274a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.c = 0;
    }

    public ByteBuffer d(int i) {
        int i2 = this.c;
        if (i2 < i) {
            return null;
        }
        this.c = i2 - i;
        byte[] bArr = new byte[i];
        this.f21274a.flip();
        this.f21274a.get(bArr, 0, i);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f21274a.compact();
        return byteBufferWrap;
    }

    public int e() {
        if (this.c < this.f) {
            return 0;
        }
        int iPosition = this.f21274a.position();
        this.f21274a.position(0);
        int i = this.f21274a.getShort() & ShortCompanionObject.MAX_VALUE;
        this.f21274a.position(iPosition);
        return i;
    }

    public ByteBuffer f() throws JException {
        return g(0);
    }

    public abstract ByteBuffer g(int i) throws JException;

    public abstract int h(byte[] bArr);
}
