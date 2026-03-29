package com.bytedance.sdk.component.panglearmor.u.u.u;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final com.bytedance.sdk.component.panglearmor.u.nr.nr nr;
        private final long u;

        public u(long j, com.bytedance.sdk.component.panglearmor.u.nr.nr nrVar) {
            this.u = j;
            this.nr = nrVar;
        }

        public com.bytedance.sdk.component.panglearmor.u.nr.nr nr() {
            return this.nr;
        }

        public long u() {
            return this.u;
        }
    }

    public static com.bytedance.sdk.component.panglearmor.u.u.fx.nr u(com.bytedance.sdk.component.panglearmor.u.nr.nr nrVar) throws com.bytedance.sdk.component.panglearmor.u.u.fx.u, IOException {
        Pair<ByteBuffer, Long> pairU = com.bytedance.sdk.component.panglearmor.u.u.nr.nr.u.u(nrVar);
        if (pairU == null) {
            throw new com.bytedance.sdk.component.panglearmor.u.u.fx.u("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairU.first;
        long jLongValue = ((Long) pairU.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jU = com.bytedance.sdk.component.panglearmor.u.u.nr.nr.u.u(byteBuffer);
        if (jU > jLongValue) {
            throw new com.bytedance.sdk.component.panglearmor.u.u.fx.u("ZIP Central Directory start offset out of range: " + jU + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jNr = com.bytedance.sdk.component.panglearmor.u.u.nr.nr.u.nr(byteBuffer);
        long j = jU + jNr;
        if (j <= jLongValue) {
            return new com.bytedance.sdk.component.panglearmor.u.u.fx.nr(jU, jNr, com.bytedance.sdk.component.panglearmor.u.u.nr.nr.u.fx(byteBuffer), jLongValue, byteBuffer);
        }
        throw new com.bytedance.sdk.component.panglearmor.u.u.fx.u("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
    }

    public static u u(com.bytedance.sdk.component.panglearmor.u.nr.nr nrVar, com.bytedance.sdk.component.panglearmor.u.u.fx.nr nrVar2) throws Exception {
        long jU = nrVar2.u();
        long jNr = nrVar2.nr() + jU;
        long jB = nrVar2.b();
        if (jNr != jB) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jNr + ", EoCD start: " + jB);
        }
        if (jU >= 32) {
            ByteBuffer byteBufferU = nrVar.u(jU - 24, 24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferU.order(byteOrder);
            if (byteBufferU.getLong(8) == 2334950737559900225L && byteBufferU.getLong(16) == 3617552046287187010L) {
                long j = byteBufferU.getLong(0);
                if (j < byteBufferU.capacity() || j > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
                }
                long j2 = (int) (8 + j);
                long j3 = jU - j2;
                if (j3 >= 0) {
                    ByteBuffer byteBufferU2 = nrVar.u(j3, 8);
                    byteBufferU2.order(byteOrder);
                    long j4 = byteBufferU2.getLong(0);
                    if (j4 == j) {
                        return new u(j3, nrVar.u(j3, j2));
                    }
                    throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jU)));
    }
}
