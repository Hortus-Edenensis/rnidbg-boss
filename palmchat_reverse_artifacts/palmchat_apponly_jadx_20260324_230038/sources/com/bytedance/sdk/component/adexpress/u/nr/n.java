package com.bytedance.sdk.component.adexpress.u.nr;

import com.bytedance.sdk.component.utils.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static com.bytedance.sdk.component.adexpress.u.fx.u u;

    public static void b() {
        fx.nr(pn.x(), nr(), "temp_pkg_info.json");
        u = null;
    }

    public static void fx() {
        fx.u(pn.x(), nr(), "temp_pkg_info.json");
    }

    public static synchronized com.bytedance.sdk.component.adexpress.u.fx.u nr() {
        return u;
    }

    public static void u() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(pn.x(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.u.fx.u uVarU = com.bytedance.sdk.component.adexpress.u.fx.u.u(new JSONObject(new String(bArr, "utf-8")));
                    if (uVarU != null) {
                        u = uVarU;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        k.u("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static boolean nr(com.bytedance.sdk.component.adexpress.u.fx.u uVar) {
        return fx.fx(nr(), uVar);
    }

    public static synchronized void u(com.bytedance.sdk.component.adexpress.u.fx.u uVar) {
        if (uVar != null) {
            if (uVar.iz()) {
                u = uVar;
            }
        }
    }

    public static boolean u(String str) {
        return fx.u(nr(), str);
    }
}
