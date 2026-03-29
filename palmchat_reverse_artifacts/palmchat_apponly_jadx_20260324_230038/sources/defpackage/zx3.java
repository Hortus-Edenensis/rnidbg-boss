package defpackage;

import cn.jiguang.sdk.impl.helper.JException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class zx3 extends ur {
    public final int g;
    public ByteBuffer h = ByteBuffer.allocate(8192);

    public zx3(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    @Override // defpackage.ur
    public synchronized int a(String str, int i) {
        super.a(str, i);
        try {
            this.b = SocketChannel.open();
            this.d = Selector.open();
            this.b.configureBlocking(false);
            this.b.connect(new InetSocketAddress(str, i));
            k63.a("NioSocketClient", "tcp connecting...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (!this.b.finishConnect()) {
                if (!this.e) {
                    k63.a("NioSocketClient", "has close channel when connect...");
                    return -991;
                }
                Thread.sleep(10L);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 3000) {
                    close();
                    return -994;
                }
            }
            if (!this.e) {
                k63.a("NioSocketClient", "has close channel when connected...");
                return -991;
            }
            k63.a("NioSocketClient", "tcp connected");
            this.b.register(this.d, 1);
            return 0;
        } catch (Throwable th) {
            k63.n("NioSocketClient", "tcp connect has failed:" + th);
            close();
            return th instanceof SocketTimeoutException ? -994 : -1000;
        }
    }

    @Override // defpackage.ur, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        k63.a("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        z86.b(this.b);
        this.b = null;
    }

    @Override // defpackage.ur
    public ByteBuffer g(int i) throws JException {
        ByteBuffer byteBufferD;
        try {
            if (!c()) {
                throw new JException(-991, "recv error,the connect is invalid");
            }
            int iE = e();
            if (iE > 0 && (byteBufferD = d(iE)) != null) {
                return byteBufferD;
            }
            int i2 = 0;
            int iE2 = 1048576;
            while (c() && this.c < iE2) {
                int iSelect = i > 0 ? this.d.select(i) : this.d.select();
                if (iSelect == 0) {
                    k63.a("NioSocketClient", "readSelect:" + iSelect + ",time out:" + i);
                    if (i > 0) {
                        throw new JException(-994, "recv time out");
                    }
                } else {
                    Iterator<SelectionKey> it = this.d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (next.isReadable()) {
                            int i3 = socketChannel.read(this.h);
                            if (i3 < 0) {
                                throw new JException(-996, "read len < 0:" + i3);
                            }
                            this.h.flip();
                            int iLimit = this.h.limit();
                            if (this.f21274a.remaining() < iLimit) {
                                throw new JException(-996, "the total buf remaining less than readLen,remaining:" + this.f21274a.remaining() + ",readLen:" + iLimit);
                            }
                            this.f21274a.put(this.h);
                            this.c += iLimit;
                            this.h.compact();
                            if (this.c < this.f) {
                                k63.a("NioSocketClient", "totalbuf can not parse head:" + this.c + ",peerNetData len:" + iLimit + ",read:" + i3);
                            } else {
                                iE2 = e();
                            }
                            i2 = iLimit;
                        } else {
                            next.isWritable();
                        }
                        it.remove();
                    }
                }
            }
            if (iE2 == 1048576) {
                throw new JException(-997, "recv empty data or tcp has close");
            }
            k63.a("NioSocketClient", "read len:" + i2 + ",recvTotalLen:" + this.c + ",shouldLen:" + iE2);
            ByteBuffer byteBufferD2 = d(iE2);
            if (byteBufferD2 != null) {
                return byteBufferD2;
            }
            throw new JException(-1001, "parse error");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new JException(-994, th.getMessage());
            }
            if (th instanceof JException) {
                throw th;
            }
            throw new JException(-997, th.getMessage());
        }
    }

    @Override // defpackage.ur
    public int h(byte[] bArr) {
        if (bArr == null) {
            k63.a("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        k63.a("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.g) {
            return i(bArr) ? 0 : 103;
        }
        k63.a("NioSocketClient", "sendData failed, data length must less than " + this.g);
        return 6026;
    }

    public final boolean i(byte[] bArr) {
        try {
            if (!c()) {
                k63.a("NioSocketClient", "send error - connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int iWrite = this.b.write(ByteBuffer.wrap(bArr));
                if (iWrite > 0) {
                    k63.j("NioSocketClient", "isWritable has send len:" + iWrite);
                    return true;
                }
                if (iWrite >= 0) {
                    return true;
                }
                k63.j("NioSocketClient", "isWritable error:" + iWrite);
                return false;
            }
            k63.a("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e) {
            k63.n("NioSocketClient", "send data error:" + e);
            close();
            return false;
        }
    }
}
