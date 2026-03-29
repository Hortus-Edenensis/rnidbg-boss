package com.opos.mobad.o;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static void a(final Context context, final String str, final byte[] bArr) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.b.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis;
                StringBuilder sb;
                if (TextUtils.isEmpty(str) || bArr == null) {
                    com.opos.cmn.an.f.a.d("FileStreamUtils", "path or data is empty");
                    return;
                }
                try {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), str));
                        try {
                            fileOutputStream.write(bArr);
                            com.opos.cmn.an.f.a.a("FileStreamUtils", "write data in " + str + " success");
                            fileOutputStream.close();
                            jCurrentTimeMillis = System.currentTimeMillis();
                            sb = new StringBuilder();
                        } finally {
                        }
                    } catch (Throwable th) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        com.opos.cmn.an.f.a.a("FileStreamUtils", "update cache time" + jCurrentTimeMillis2);
                        d.b(context, "adCacheTime", jCurrentTimeMillis2);
                        throw th;
                    }
                } catch (IOException e) {
                    d.b(context, "adCacheTime", 0L);
                    com.opos.cmn.an.f.a.d("FileStreamUtils", "write data in " + str + " fail", e);
                    jCurrentTimeMillis = System.currentTimeMillis();
                    sb = new StringBuilder();
                }
                sb.append("update cache time");
                sb.append(jCurrentTimeMillis);
                com.opos.cmn.an.f.a.a("FileStreamUtils", sb.toString());
                d.b(context, "adCacheTime", jCurrentTimeMillis);
            }
        });
    }

    public static byte[] a(Context context, String str) {
        StringBuilder sb;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.d("FileStreamUtils", "path is empty");
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    com.opos.cmn.an.f.a.a("FileStreamUtils", "getCacheData " + str + " success");
                    fileInputStream.close();
                    sb = new StringBuilder();
                } finally {
                }
            } catch (IOException e) {
                com.opos.cmn.an.f.a.d("FileStreamUtils", "getCacheData " + str + " fail:", e);
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(" close file success");
            com.opos.cmn.an.f.a.a("FileStreamUtils", sb.toString());
            return bArr;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("FileStreamUtils", str + " close file success");
            throw th;
        }
    }
}
