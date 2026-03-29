package com.zx.a.I8b7;

import android.content.Context;
import com.cdo.oaps.ad.OapsWrapper;
import com.zx.a.I8b7.l2;
import com.zx.a.I8b7.v3;
import com.zx.module.base.ZXModule;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class v {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f16871a = new v();
    }

    public ZXModule a(Context context) {
        ZXModule zXModule = null;
        try {
            m3.f16830a = context;
            l2.a.f16824a.f16823a.a("3.3.4.43514");
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("zx-core-3.3.4.43514.zip");
            String string = sb.toString();
            String str2 = context.getFilesDir().getAbsolutePath() + str + "zx-core-3.3.4.43514";
            File file = new File(str2);
            File file2 = new File(string);
            if (file2.exists()) {
                file.delete();
                a(file2, file);
                File file3 = new File(str2 + str + "classes.jar");
                ZXModule zXModule2 = (ZXModule) new t(file3.getAbsolutePath(), str2, null).b().newInstance();
                String str3 = str2 + str + "libzx-core-d.so";
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(OapsWrapper.KEY_PATH, str3);
                zXModule2.invoke("loadLib", jSONObject.toString());
                v3.f.f16875a.b.execute(new u(this, file3, str3, file2, file));
                zXModule = zXModule2;
            }
        } catch (Throwable th) {
            r2.a(th);
        }
        return zXModule == null ? new j2() : zXModule;
    }

    public static void a(File file, File file2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file3 = new File(file2, nextEntry.getName().replaceFirst("^\\./", ""));
                    File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        throw new FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                    }
                    if (!nextEntry.isDirectory()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                        while (true) {
                            try {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            } finally {
                            }
                        }
                        fileOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                zipInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
