package com.qq.gdt.action.b;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g {
    public static ByteBuffer a(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.k);
            try {
                d<ByteBuffer, Long> dVarA = a.a(randomAccessFile2);
                ByteBuffer byteBufferA = dVarA.a();
                long jLongValue = dVarA.b().longValue();
                if (h.a(randomAccessFile2, jLongValue)) {
                    throw new e("ZIP64 APK not supported");
                }
                ByteBuffer byteBufferA2 = a.a(randomAccessFile2, a.a(byteBufferA, jLongValue)).a();
                randomAccessFile2.close();
                return byteBufferA2;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws e {
        a.a(byteBuffer);
        ByteBuffer byteBufferA = a.a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (byteBufferA.hasRemaining()) {
            i++;
            if (byteBufferA.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i);
            }
            long j = byteBufferA.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new e("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferA.position() + i2;
            if (i2 > byteBufferA.remaining()) {
                throw new e("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferA.remaining());
            }
            linkedHashMap.put(Integer.valueOf(byteBufferA.getInt()), a.a(byteBufferA, i2 - 4));
            byteBufferA.position(iPosition);
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new e("not have Id-Value Pair in APK Signing Block entry #" + i);
    }
}
