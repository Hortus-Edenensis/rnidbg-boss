package com.bytedance.pangle.n;

import android.util.Pair;
import androidx.media3.muxer.MuxerUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
abstract class bg {
    private static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int fx(ByteBuffer byteBuffer) {
        b(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && u(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static long nr(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return nr(byteBuffer, byteBuffer.position() + 12);
    }

    public static Pair<ByteBuffer, Long> u(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairU = u(randomAccessFile, 0);
        return pairU != null ? pairU : u(randomAccessFile, 65535);
    }

    private static long nr(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }

    private static Pair<ByteBuffer, Long> u(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i >= 0 && i <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            long jCapacity = length - ((long) byteBufferAllocate.capacity());
            randomAccessFile.seek(jCapacity);
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            int iFx = fx(byteBufferAllocate);
            if (iFx == -1) {
                return null;
            }
            byteBufferAllocate.position(iFx);
            ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
            byteBufferSlice.order(byteOrder);
            return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) iFx)));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    public static final boolean u(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long u(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return nr(byteBuffer, byteBuffer.position() + 16);
    }

    public static void u(ByteBuffer byteBuffer, long j) {
        b(byteBuffer);
        u(byteBuffer, byteBuffer.position() + 16, j);
    }

    private static int u(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    private static void u(ByteBuffer byteBuffer, int i, long j) {
        if (j >= 0 && j <= MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
            byteBuffer.putInt(byteBuffer.position() + i, (int) j);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
    }
}
