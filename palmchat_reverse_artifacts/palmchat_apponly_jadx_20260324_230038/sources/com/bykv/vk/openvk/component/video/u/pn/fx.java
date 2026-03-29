package com.bykv.vk.openvk.component.video.u.pn;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    public static File fx(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static File nr(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static long u(String str, String str2) {
        File fileFx = fx(str, str2);
        if (fileFx.exists()) {
            return fileFx.length();
        }
        File fileNr = nr(str, str2);
        if (fileNr.exists()) {
            return fileNr.length();
        }
        return 0L;
    }

    public static boolean u(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
