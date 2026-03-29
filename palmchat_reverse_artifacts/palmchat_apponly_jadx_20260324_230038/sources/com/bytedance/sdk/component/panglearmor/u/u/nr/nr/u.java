package com.bytedance.sdk.component.panglearmor.u.u.nr.nr;

import android.util.Pair;
import androidx.media3.muxer.MuxerUtil;
import com.bytedance.sdk.component.panglearmor.u.nr.nr;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    public static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int fx(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return u(byteBuffer, byteBuffer.position() + 10);
    }

    public static long nr(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return nr(byteBuffer, byteBuffer.position() + 12);
    }

    private static int pn(ByteBuffer byteBuffer) {
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

    public static long u(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return nr(byteBuffer, byteBuffer.position() + 16);
    }

    public static long nr(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }

    public static Pair<ByteBuffer, Long> u(nr nrVar) throws IOException {
        if (nrVar.u() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairU = u(nrVar, 0);
        return pairU != null ? pairU : u(nrVar, 65535);
    }

    private static Pair<ByteBuffer, Long> u(nr nrVar, int i) throws IOException {
        if (i >= 0 && i <= 65535) {
            long jU = nrVar.u();
            if (jU < 22) {
                return null;
            }
            int iMin = ((int) Math.min(i, jU - 22)) + 22;
            long j = jU - ((long) iMin);
            ByteBuffer byteBufferU = nrVar.u(j, iMin);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferU.order(byteOrder);
            int iPn = pn(byteBufferU);
            if (iPn == -1) {
                return null;
            }
            byteBufferU.position(iPn);
            ByteBuffer byteBufferSlice = byteBufferU.slice();
            byteBufferSlice.order(byteOrder);
            return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iPn)));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    public static int u(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }
}
