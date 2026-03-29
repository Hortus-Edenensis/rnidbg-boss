package com.bytedance.pangle.n;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class iz {
    static final HashMap<String, SparseArray<mv>> u = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements jk {
        private final MessageDigest[] u;

        public u(MessageDigest[] messageDigestArr) {
            this.u = messageDigestArr;
        }

        @Override // com.bytedance.pangle.n.jk
        public void u(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.u) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> b(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(com.huawei.openalliance.ad.constant.x.dW, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                    }
                }
                return Pair.create(RSAUtil.SIGNATURE_ALGORITHM, null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    public static String fx(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return EncryptUtils.RSA_ENCRYPT_ALGORITHM;
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return EncryptUtils.RSA_ENCRYPT_ALGORITHM;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    private static int nr(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    private static int pn(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    @RequiresApi(api = 21)
    public static void u(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, mv mvVar) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                u(arrayMap, randomAccessFile.getFD(), mvVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            u(map.get(3), randomAccessFile, mvVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void fx(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static String nr(int i) {
        if (i == 1) {
            return com.huawei.openalliance.ad.constant.x.dW;
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return com.huawei.openalliance.ad.constant.x.dW;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    public static byte[] nr(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void u(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, mv mvVar) throws SecurityException {
        l lVar = new l(fileDescriptor, 0L, mvVar.nr);
        long j = mvVar.fx;
        l lVar2 = new l(fileDescriptor, j, mvVar.b - j);
        ByteBuffer byteBufferDuplicate = mvVar.pn.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        bg.u(byteBufferDuplicate, mvVar.nr);
        n nVar = new n(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrU = u(iArr, new t[]{lVar, lVar2, nVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrU[i2])) {
                    throw new SecurityException(nr(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] u(int[] iArr, t[] tVarArr) throws DigestException {
        String str;
        t[] tVarArr2 = tVarArr;
        long j = 0;
        long jU = 0;
        for (t tVar : tVarArr2) {
            jU += u(tVar.u());
        }
        if (jU < 2097151) {
            int i = (int) jU;
            byte[][] bArr = new byte[iArr.length][];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                byte[] bArr2 = new byte[(pn(iArr[i2]) * i) + 5];
                bArr2[0] = 90;
                u(i, bArr2, 1);
                bArr[i2] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i3 = 0;
            while (true) {
                str = " digest not supported";
                if (i3 >= iArr.length) {
                    break;
                }
                String strNr = nr(iArr[i3]);
                try {
                    messageDigestArr[i3] = MessageDigest.getInstance(strNr);
                    i3++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(strNr + " digest not supported", e);
                }
            }
            u uVar = new u(messageDigestArr);
            int length2 = tVarArr2.length;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length2) {
                t tVar2 = tVarArr2[i4];
                int i7 = length2;
                int i8 = i6;
                u uVar2 = uVar;
                String str2 = str;
                long jU2 = tVar2.u();
                long j2 = j;
                while (jU2 > j) {
                    int iMin = (int) Math.min(jU2, 1048576L);
                    u(iMin, bArr3, 1);
                    for (int i9 = 0; i9 < length; i9++) {
                        messageDigestArr[i9].update(bArr3);
                    }
                    u uVar3 = uVar2;
                    try {
                        tVar2.u(uVar3, j2, iMin);
                        uVar2 = uVar3;
                        int i10 = 0;
                        while (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i10];
                            int iPn = pn(i11);
                            t tVar3 = tVar2;
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int i12 = length;
                            int iDigest = messageDigest.digest(bArr5, (i8 * iPn) + 5, iPn);
                            if (iDigest != iPn) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                            }
                            i10++;
                            bArr3 = bArr4;
                            tVar2 = tVar3;
                            length = i12;
                        }
                        long j3 = iMin;
                        j2 += j3;
                        jU2 -= j3;
                        i8++;
                        bArr3 = bArr3;
                        j = 0;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                    }
                }
                i5++;
                i4++;
                tVarArr2 = tVarArr;
                i6 = i8;
                uVar = uVar2;
                str = str2;
                length2 = i7;
                j = 0;
            }
            String str3 = str;
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                byte[] bArr7 = bArr[i13];
                String strNr2 = nr(i14);
                try {
                    bArr6[i13] = MessageDigest.getInstance(strNr2).digest(bArr7);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(strNr2 + str3, e3);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(jU)));
    }

    public static byte[] u(byte[] bArr, long j, mv mvVar) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(32);
            if (byteBufferOrder.getLong() == j - (mvVar.fx - mvVar.nr)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    private static void u(byte[] bArr, RandomAccessFile randomAccessFile, mv mvVar) throws SecurityException {
        try {
            if (Arrays.equals(u(bArr, randomAccessFile.length(), mvVar), x.u(randomAccessFile, mvVar, new a() { // from class: com.bytedance.pangle.n.iz.1
                @Override // com.bytedance.pangle.n.a
                public ByteBuffer u(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).nr)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    public static Pair<ByteBuffer, Long> u(RandomAccessFile randomAccessFile) throws s, IOException {
        Pair<ByteBuffer, Long> pairU = bg.u(randomAccessFile);
        if (pairU != null) {
            return pairU;
        }
        throw new s("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static long u(ByteBuffer byteBuffer, long j) throws s {
        long jU = bg.u(byteBuffer);
        if (jU <= j) {
            if (bg.nr(byteBuffer) + jU == j) {
                return jU;
            }
            throw new s("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new s("ZIP Central Directory offset out of range: " + jU + ". ZIP End of Central Directory offset: " + j);
    }

    private static long u(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static int u(int i, int i2) {
        return nr(u(i), u(i2));
    }

    public static int u(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    public static ByteBuffer u(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
    }

    public static ByteBuffer u(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i2 = i + iPosition;
            if (i2 >= iPosition && i2 <= iLimit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return byteBufferSlice;
                } finally {
                    byteBuffer.limit(iLimit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
    }

    public static ByteBuffer u(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return u(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static void u(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static Pair<ByteBuffer, Long> u(RandomAccessFile randomAccessFile, long j) throws s, IOException {
        if (j >= 32) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                return null;
            }
            long j2 = byteBufferAllocate.getLong(0);
            if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                throw new s("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
            }
            int i = (int) (8 + j2);
            long j3 = j - ((long) i);
            if (j3 >= 0) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
                byteBufferAllocate2.order(byteOrder);
                randomAccessFile.seek(j3);
                randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                long j4 = byteBufferAllocate2.getLong(0);
                if (j4 == j2) {
                    return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
                }
                throw new s("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
            }
            throw new s("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        throw new s("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
    }

    public static void u(String str, RandomAccessFile randomAccessFile, int... iArr) throws s, IOException {
        HashSet hashSet;
        int i;
        long j;
        ByteBuffer byteBuffer;
        String str2 = str;
        u.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairU = u(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairU.first;
        long jLongValue = ((Long) pairU.second).longValue();
        if (!bg.u(randomAccessFile, jLongValue)) {
            long jU = u(byteBuffer2, jLongValue);
            Pair<ByteBuffer, Long> pairU2 = u(randomAccessFile, jU);
            if (pairU2 == null) {
                return;
            }
            ByteBuffer byteBuffer3 = (ByteBuffer) pairU2.first;
            long jLongValue2 = ((Long) pairU2.second).longValue();
            fx(byteBuffer3);
            int i2 = 8;
            ByteBuffer byteBufferU = u(byteBuffer3, 8, byteBuffer3.capacity() - 24);
            HashSet hashSet2 = new HashSet();
            for (int i3 : iArr) {
                hashSet2.add(Integer.valueOf(i3));
            }
            while (byteBufferU.hasRemaining() && byteBufferU.remaining() >= i2) {
                long j2 = byteBufferU.getLong();
                if (j2 < 4 || j2 > 2147483647L) {
                    return;
                }
                int i4 = (int) j2;
                int iPosition = byteBufferU.position() + i4;
                if (i4 > byteBufferU.remaining()) {
                    return;
                }
                int i5 = byteBufferU.getInt();
                if (hashSet2.contains(Integer.valueOf(i5))) {
                    hashSet = hashSet2;
                    i = iPosition;
                    j = jU;
                    u.get(str2).put(i5, new mv(u(byteBufferU, i4 - 4), jLongValue2, jU, jLongValue, byteBuffer2));
                    byteBuffer = byteBufferU;
                } else {
                    hashSet = hashSet2;
                    i = iPosition;
                    j = jU;
                    byteBuffer = byteBufferU;
                }
                byteBuffer.position(i);
                hashSet2 = hashSet;
                byteBufferU = byteBuffer;
                jU = j;
                i2 = 8;
                str2 = str;
            }
            return;
        }
        throw new s("ZIP64 APK not supported");
    }
}
