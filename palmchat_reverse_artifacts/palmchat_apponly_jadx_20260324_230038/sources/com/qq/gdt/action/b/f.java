package com.qq.gdt.action.b;

import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.j.o;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f10465a = {108, 116, 108, 111, 118, 101, 122, 104};

    public static String a(File file) {
        try {
            return b(file);
        } catch (Exception e) {
            o.a("" + e, new Object[0]);
            return "";
        }
    }

    public static String b(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.k);
            try {
                long length = randomAccessFile2.length();
                byte[] bArr = f10465a;
                byte[] bArr2 = new byte[bArr.length];
                long length2 = length - ((long) bArr.length);
                randomAccessFile2.seek(length2);
                randomAccessFile2.readFully(bArr2);
                if (!a(bArr2)) {
                    throw new Exception("zip v1 magic not found");
                }
                long j = length2 - 2;
                randomAccessFile2.seek(j);
                int iA = a(randomAccessFile2);
                if (iA <= 0) {
                    throw new Exception("zip channel info not found");
                }
                randomAccessFile2.seek(j - ((long) iA));
                byte[] bArr3 = new byte[iA];
                randomAccessFile2.readFully(bArr3);
                String strTrim = new String(bArr3, "UTF-8").trim();
                randomAccessFile2.close();
                return strTrim;
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

    private static short a(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != f10465a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr2 = f10465a;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }
}
