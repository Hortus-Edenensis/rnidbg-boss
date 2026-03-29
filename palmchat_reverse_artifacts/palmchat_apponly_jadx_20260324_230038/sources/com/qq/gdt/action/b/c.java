package com.qq.gdt.action.b;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {
    public static String a(File file, int i) {
        byte[] bArrB;
        if (file != null && file.exists() && file.isFile() && (bArrB = b(file, i)) != null) {
            try {
                if (bArrB.length > 0) {
                    return new String(bArrB, "UTF-8").trim();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static byte[] b(File file, int i) {
        ByteBuffer byteBufferC;
        if (file == null || !file.exists() || !file.isFile() || (byteBufferC = c(file, i)) == null) {
            return null;
        }
        return Arrays.copyOfRange(byteBufferC.array(), byteBufferC.arrayOffset() + byteBufferC.position(), byteBufferC.arrayOffset() + byteBufferC.limit());
    }

    public static ByteBuffer c(File file, int i) {
        Map<Integer, ByteBuffer> mapA;
        if (file == null || !file.exists() || !file.isFile() || (mapA = a(file)) == null) {
            return null;
        }
        return mapA.get(Integer.valueOf(i));
    }

    public static Map<Integer, ByteBuffer> a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                return g.a(g.a(file));
            } catch (e | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
