package com.bytedance.pangle.n;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
abstract class x {
    private static final byte[] u = new byte[8];

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements jk {
        private final byte[] b;
        private final MessageDigest fx;
        private final ByteBuffer nr;
        private final byte[] pn;
        private int u;

        /* JADX INFO: Access modifiers changed from: private */
        public void nr() {
            int iPosition = this.nr.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.nr.put(ByteBuffer.allocate(4096 - iPosition));
        }

        private nr(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.b = new byte[32];
            this.pn = bArr;
            this.nr = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW);
            this.fx = messageDigest;
            messageDigest.update(bArr);
            this.u = 0;
        }

        @Override // com.bytedance.pangle.n.jk
        public void u(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.u);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.fx.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.u + iMin;
                this.u = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.fx;
                    byte[] bArr = this.b;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.nr.put(this.b);
                    this.fx.update(this.pn);
                    this.u = 0;
                }
            }
        }

        public void u() throws DigestException {
            if (this.u == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.u);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public final byte[] nr;
        public final ByteBuffer u;

        public u(ByteBuffer byteBuffer, byte[] bArr) {
            this.u = byteBuffer;
            this.nr = bArr;
        }
    }

    private static int[] nr(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = u(j, 4096L) * 32;
            arrayList.add(Long.valueOf(u(j, 4096L) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + u(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    public static u u(RandomAccessFile randomAccessFile, mv mvVar, a aVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int i = nr(randomAccessFile.length() - (mvVar.fx - mvVar.nr))[r0.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferU = aVar.u(i2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferU.order(byteOrder);
        ByteBuffer byteBufferU2 = u(byteBufferU, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferU3 = u(byteBufferU, i, i3);
        ByteBuffer byteBufferU4 = u(byteBufferU, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(byteOrder);
        u(randomAccessFile, mvVar, byteBufferU2, byteBufferWrap, byteBufferU3, byteBufferU4);
        byteBufferU.position(i3 + byteBufferU4.limit());
        byteBufferU.putInt(byteBufferU4.limit() + 64 + 4);
        byteBufferU.flip();
        return new u(byteBufferU, bArr);
    }

    private static void u(RandomAccessFile randomAccessFile, mv mvVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        u(mvVar);
        long j = mvVar.fx - mvVar.nr;
        int[] iArrNr = nr(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrU = u(randomAccessFile, mvVar, u, iArrNr, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrU);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            u(byteBuffer3, randomAccessFile.length(), iArrNr.length - 1, u);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            u(byteBuffer4, mvVar.nr, j, mvVar.b);
        }
    }

    private static void u(jk jkVar, t tVar, int i) throws DigestException, IOException {
        long jU = tVar.u();
        long j = 0;
        while (jU > 0) {
            int iMin = (int) Math.min(jU, i);
            tVar.u(jkVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jU -= j2;
        }
    }

    private static void u(RandomAccessFile randomAccessFile, mv mvVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        nr nrVar = new nr(bArr, byteBuffer);
        u(nrVar, new l(randomAccessFile.getFD(), 0L, mvVar.nr), 1048576);
        long j = mvVar.b + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j2 = mvVar.fx;
        u(nrVar, new l(fd, j2, j - j2), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(u(mvVar.nr));
        byteBufferOrder.flip();
        nrVar.u(byteBufferOrder);
        long j3 = j + 4;
        u(nrVar, new l(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            nrVar.u(ByteBuffer.allocate(4096 - length));
        }
        nrVar.u();
        nrVar.nr();
    }

    private static byte[] u(RandomAccessFile randomAccessFile, mv mvVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        u(randomAccessFile, mvVar, bArr, u(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferU = u(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferU2 = u(byteBuffer, iArr[length], iArr[i]);
                n nVar = new n(byteBufferU);
                nr nrVar = new nr(bArr, byteBufferU2);
                u(nrVar, nVar, 4096);
                nrVar.u();
                nrVar.nr();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                nr nrVar2 = new nr(bArr, ByteBuffer.wrap(bArr2));
                nrVar2.u(u(byteBuffer, 0, 4096));
                nrVar2.u();
                return bArr2;
            }
        }
    }

    private static ByteBuffer u(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length == 8) {
            byteBuffer.put("TrueBrew".getBytes());
            byteBuffer.put((byte) 1);
            byteBuffer.put((byte) 0);
            byteBuffer.put((byte) 12);
            byteBuffer.put((byte) 7);
            byteBuffer.putShort((short) 1);
            byteBuffer.putShort((short) 1);
            byteBuffer.putInt(0);
            byteBuffer.putInt(0);
            byteBuffer.putLong(j);
            byteBuffer.put((byte) 2);
            byteBuffer.put((byte) 0);
            byteBuffer.put(bArr);
            u(byteBuffer, 22);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new IllegalArgumentException("salt is not 8 bytes long");
    }

    private static ByteBuffer u(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        u(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        u(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(u(j));
        u(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void u(mv mvVar) {
        long j = mvVar.nr;
        if (j % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mvVar.nr);
        }
        if ((mvVar.fx - j) % 4096 == 0) {
            return;
        }
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mvVar.fx - mvVar.nr));
    }

    private static ByteBuffer u(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void u(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long u(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int u(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
