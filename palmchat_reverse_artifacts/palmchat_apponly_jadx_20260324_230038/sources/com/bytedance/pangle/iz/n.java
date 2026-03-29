package com.bytedance.pangle.iz;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n implements Closeable {
    private fx[] b;
    private nr[] fx;
    private u nr;
    private final Map<String, fx> pn = new HashMap();
    private final FileInputStream u;

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5068a;
        public final long b;
        public final long fx;
        public final long iz;
        public final long jk;
        public final int n;
        public final int nr;
        public final long pn;
        public String t;
        public final int u;
        public final int x;

        private fx(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.u = byteBuffer.getInt();
                this.nr = byteBuffer.getInt();
                this.fx = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.pn = byteBuffer.getInt();
                this.iz = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.n = byteBuffer.getInt();
                this.f5068a = byteBuffer.getInt();
                this.jk = byteBuffer.getInt();
            } else {
                if (i != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
                }
                this.u = byteBuffer.getInt();
                this.nr = byteBuffer.getInt();
                this.fx = byteBuffer.getLong();
                this.b = byteBuffer.getLong();
                this.pn = byteBuffer.getLong();
                this.iz = byteBuffer.getLong();
                this.x = byteBuffer.getInt();
                this.n = byteBuffer.getInt();
                this.f5068a = byteBuffer.getLong();
                this.jk = byteBuffer.getLong();
            }
            this.t = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public final long b;
        public final long fx;
        public final long iz;
        public final long n;
        public final int nr;
        public final long pn;
        public final int u;
        public final long x;

        private nr(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.u = byteBuffer.getInt();
                this.fx = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.pn = byteBuffer.getInt();
                this.iz = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.nr = byteBuffer.getInt();
                this.n = byteBuffer.getInt();
                return;
            }
            if (i != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.u = byteBuffer.getInt();
            this.nr = byteBuffer.getInt();
            this.fx = byteBuffer.getLong();
            this.b = byteBuffer.getLong();
            this.pn = byteBuffer.getLong();
            this.iz = byteBuffer.getLong();
            this.x = byteBuffer.getLong();
            this.n = byteBuffer.getLong();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short f5069a;
        public final int b;
        public final short fx;
        public final long iz;
        public final short jk;
        public final short l;
        public final short mv;
        public final int n;
        public final short nr;
        public final long pn;
        public final short s;
        public final short t;
        public final byte[] u;
        public final long x;

        private u(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.u = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            n.nr(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
            n.nr(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            n.nr(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
            this.nr = byteBufferAllocate.getShort();
            this.fx = byteBufferAllocate.getShort();
            int i = byteBufferAllocate.getInt();
            this.b = i;
            n.nr(i, 1, 1, "bad elf version: " + i);
            byte b = bArr[4];
            if (b == 1) {
                this.pn = byteBufferAllocate.getInt();
                this.iz = byteBufferAllocate.getInt();
                this.x = byteBufferAllocate.getInt();
            } else {
                if (b != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.pn = byteBufferAllocate.getLong();
                this.iz = byteBufferAllocate.getLong();
                this.x = byteBufferAllocate.getLong();
            }
            this.n = byteBufferAllocate.getInt();
            this.f5069a = byteBufferAllocate.getShort();
            this.jk = byteBufferAllocate.getShort();
            this.t = byteBufferAllocate.getShort();
            this.l = byteBufferAllocate.getShort();
            this.mv = byteBufferAllocate.getShort();
            this.s = byteBufferAllocate.getShort();
        }
    }

    private n(File file) throws IOException {
        fx[] fxVarArr;
        this.nr = null;
        this.fx = null;
        this.b = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.u = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.nr = new u(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.nr.jk);
        byteBufferAllocate.order(this.nr.u[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.nr.iz);
        this.fx = new nr[this.nr.t];
        for (int i = 0; i < this.fx.length; i++) {
            nr(channel, byteBufferAllocate, "failed to read phdr.");
            this.fx[i] = new nr(byteBufferAllocate, this.nr.u[4]);
        }
        channel.position(this.nr.x);
        byteBufferAllocate.limit(this.nr.l);
        this.b = new fx[this.nr.mv];
        int i2 = 0;
        while (true) {
            fxVarArr = this.b;
            if (i2 >= fxVarArr.length) {
                break;
            }
            nr(channel, byteBufferAllocate, "failed to read shdr.");
            this.b[i2] = new fx(byteBufferAllocate, this.nr.u[4]);
            i2++;
        }
        short s = this.nr.s;
        if (s > 0) {
            ByteBuffer byteBufferU = u(fxVarArr[s]);
            for (fx fxVar : this.b) {
                byteBufferU.position(fxVar.u);
                String strU = u(byteBufferU);
                fxVar.t = strU;
                this.pn.put(strU, fxVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.u.close();
        this.pn.clear();
        this.fx = null;
        this.b = null;
    }

    public static boolean u(File file) {
        try {
            com.bytedance.pangle.util.x.u(new n(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.x.u((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.x.u((Closeable) null);
            throw th;
        }
    }

    private static String u(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName(HTTP.ASCII));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    private ByteBuffer u(fx fxVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) fxVar.iz);
        this.u.getChannel().position(fxVar.pn);
        nr(this.u.getChannel(), byteBufferAllocate, "failed to read section: " + fxVar.t);
        return byteBufferAllocate;
    }
}
