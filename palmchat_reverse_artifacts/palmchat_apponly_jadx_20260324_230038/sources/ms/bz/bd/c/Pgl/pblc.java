package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblc {

    /* JADX INFO: compiled from: SearchBox */
    public static class pblb extends Exception {
        public pblb(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class pgla<A, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A f19323a;
        public final B b;

        /* JADX WARN: Multi-variable type inference failed */
        public pgla(ByteBuffer byteBuffer, Long l) {
            this.f19323a = byteBuffer;
            this.b = l;
        }

        public static pgla b(ByteBuffer byteBuffer, Long l) {
            return new pgla(byteBuffer, l);
        }

        public final A a() {
            return this.f19323a;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || pgla.class != obj.getClass()) {
                return false;
            }
            pgla pglaVar = (pgla) obj;
            A a2 = this.f19323a;
            if (a2 == null) {
                if (pglaVar.f19323a != null) {
                    return false;
                }
            } else if (!a2.equals(pglaVar.f19323a)) {
                return false;
            }
            B b = this.b;
            B b2 = pglaVar.b;
            return b == null ? b2 == null : b.equals(b2);
        }

        public final int hashCode() {
            A a2 = this.f19323a;
            int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
            B b = this.b;
            return iHashCode + (b != null ? b.hashCode() : 0);
        }
    }

    public static HashMap a(String str) {
        RandomAccessFile randomAccessFile = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f4b9d3", new byte[]{101}));
                try {
                    for (Map.Entry entry : b(c(randomAccessFile2.getChannel()).a()).entrySet()) {
                        if (entry != null && entry.getKey() != null && ((Integer) entry.getKey()).intValue() != 1896449818) {
                            try {
                                ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
                                byte[] bArrArray = byteBuffer.array();
                                int iArrayOffset = byteBuffer.arrayOffset();
                                map.put((Integer) entry.getKey(), new String(Arrays.copyOfRange(bArrArray, byteBuffer.position() + iArrayOffset, byteBuffer.limit() + iArrayOffset)));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    randomAccessFile2.close();
                } catch (Throwable unused2) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return map;
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
        }
        return map;
    }

    public static LinkedHashMap b(ByteBuffer byteBuffer) throws pblb {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5c1bdd", new byte[]{117}));
        }
        int iCapacity = byteBuffer.capacity() - 24;
        if (iCapacity < 8) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dbef00", new byte[]{33}));
        }
        byteBuffer.capacity();
        if (iCapacity > byteBuffer.capacity()) {
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ee6008", new byte[]{33}));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(iCapacity);
            byteBuffer.position(8);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (byteBufferSlice.hasRemaining()) {
                if (byteBufferSlice.remaining() < 8) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "169d0a", new byte[]{118}));
                }
                long j = byteBufferSlice.getLong();
                if (j < 4 || j > 2147483647L) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f67a5d", new byte[]{32}));
                }
                int i = (int) j;
                int iPosition2 = byteBufferSlice.position() + i;
                if (i > byteBufferSlice.remaining()) {
                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e4678b", new byte[]{44}));
                }
                Integer numValueOf = Integer.valueOf(byteBufferSlice.getInt());
                int i2 = i - 4;
                if (i2 < 0) {
                    throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0bc959", new byte[]{115}));
                }
                int iLimit2 = byteBufferSlice.limit();
                int iPosition3 = byteBufferSlice.position();
                int i3 = i2 + iPosition3;
                if (i3 < iPosition3 || i3 > iLimit2) {
                    throw new BufferUnderflowException();
                }
                byteBufferSlice.limit(i3);
                try {
                    ByteBuffer byteBufferSlice2 = byteBufferSlice.slice();
                    byteBufferSlice2.order(byteBufferSlice.order());
                    byteBufferSlice.position(i3);
                    byteBufferSlice.limit(iLimit2);
                    linkedHashMap.put(numValueOf, byteBufferSlice2);
                    byteBufferSlice.position(iPosition2);
                } catch (Throwable th) {
                    byteBufferSlice.limit(iLimit2);
                    throw th;
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
            throw th2;
        }
    }

    public static pgla<ByteBuffer, Long> c(FileChannel fileChannel) throws IOException, pblb {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6dddc5", new byte[]{118, 55}));
        }
        long j = size - 22;
        long jMin = Math.min(j, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > jMin) {
                throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2d90ed", new byte[]{114, 54}));
            }
            long j3 = j - j2;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(byteBufferAllocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(byteOrder);
                short s = byteBufferAllocate2.getShort(0);
                if (s == i) {
                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(4);
                    byteBufferAllocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - ((long) s)) - 6);
                    fileChannel.read(byteBufferAllocate3);
                    long j4 = byteBufferAllocate3.getInt(0);
                    if (j4 < 32) {
                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d8e3df", new byte[]{44}));
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(byteBufferAllocate4);
                    byteBufferAllocate4.order(byteOrder);
                    if (byteBufferAllocate4.getLong(8) != 2334950737559900225L || byteBufferAllocate4.getLong(16) != 3617552046287187010L) {
                        return null;
                    }
                    long j5 = byteBufferAllocate4.getLong(0);
                    if (j5 < byteBufferAllocate4.capacity() || j5 > 2147483639) {
                        return null;
                    }
                    int i2 = (int) (8 + j5);
                    long j6 = j4 - ((long) i2);
                    if (j6 < 0) {
                        return null;
                    }
                    fileChannel.position(j6);
                    ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(i2);
                    fileChannel.read(byteBufferAllocate5);
                    byteBufferAllocate5.order(byteOrder);
                    if (byteBufferAllocate5.getLong(0) == j5) {
                        return pgla.b(byteBufferAllocate5, Long.valueOf(j6));
                    }
                    return null;
                }
            }
            i++;
        }
    }
}
