package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class pr5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20088a;
    public SelectionKey b;

    public pr5(long j) throws Throwable {
        Selector selectorOpen;
        SocketChannel socketChannelOpen = SocketChannel.open();
        this.f20088a = j;
        try {
            selectorOpen = Selector.open();
            try {
                socketChannelOpen.configureBlocking(false);
                this.b = socketChannelOpen.register(selectorOpen, 1);
            } catch (Throwable th) {
                th = th;
                if (selectorOpen != null) {
                    selectorOpen.close();
                }
                socketChannelOpen.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            selectorOpen = null;
        }
    }

    public static void c(SelectionKey selectionKey, long j) throws IOException {
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if ((jCurrentTimeMillis > 0 ? selectionKey.selector().select(jCurrentTimeMillis) : jCurrentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    public static byte[] h(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) throws IOException {
        pr5 pr5Var = new pr5(j);
        if (socketAddress != null) {
            try {
                pr5Var.b(socketAddress);
            } finally {
                pr5Var.d();
            }
        }
        pr5Var.e(socketAddress2);
        pr5Var.g(bArr);
        return pr5Var.f();
    }

    public final byte[] a(int i) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.b.isReadable()) {
                    long j = socketChannel.read(byteBufferWrap);
                    if (j < 0) {
                        throw new EOFException();
                    }
                    i2 += (int) j;
                    if (i2 < i && System.currentTimeMillis() > this.f20088a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    c(this.b, this.f20088a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
        return bArr;
    }

    public void b(SocketAddress socketAddress) throws IOException {
        ((SocketChannel) this.b.channel()).socket().bind(socketAddress);
    }

    public void d() throws IOException {
        this.b.selector().close();
        this.b.channel().close();
    }

    public void e(SocketAddress socketAddress) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.b.isConnectable()) {
                    c(this.b, this.f20088a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
    }

    public byte[] f() throws IOException {
        byte[] bArrA = a(2);
        byte[] bArrA2 = a(((bArrA[0] & UByte.MAX_VALUE) << 8) + (bArrA[1] & UByte.MAX_VALUE));
        return bArrA2;
    }

    public void g(byte[] bArr) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.b.interestOps(4);
        int i = 0;
        while (i < bArr.length + 2) {
            try {
                if (this.b.isWritable()) {
                    long jWrite = socketChannel.write(byteBufferArr);
                    if (jWrite < 0) {
                        throw new EOFException();
                    }
                    i += (int) jWrite;
                    if (i < bArr.length + 2 && System.currentTimeMillis() > this.f20088a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    c(this.b, this.f20088a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
    }
}
