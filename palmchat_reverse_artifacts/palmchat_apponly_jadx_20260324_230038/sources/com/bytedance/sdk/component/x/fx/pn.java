package com.bytedance.sdk.component.x.fx;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements com.bytedance.sdk.component.x.nr, com.bytedance.sdk.component.x.u {
    private static boolean fx = false;
    private static Method nr;
    private static Method u;
    private final com.bytedance.sdk.component.b.nr.u b;
    private final boolean pn;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            u = cls.getDeclaredMethod("readMapXml", InputStream.class);
            nr = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            u.setAccessible(true);
            nr.setAccessible(true);
            fx = true;
        } catch (Exception unused) {
            fx = false;
        }
    }

    public pn(com.bytedance.sdk.component.b.nr.u uVar) {
        this.b = uVar;
        this.pn = false;
    }

    public static boolean u() {
        return fx;
    }

    @Override // com.bytedance.sdk.component.x.u
    public Map<String, Object> u(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        if (fx && file.exists()) {
            BufferedInputStream bufferedInputStream2 = null;
            if (!file.canRead()) {
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 49152);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                Map<String, Object> mapU = new com.bytedance.sdk.component.x.u.nr().u((Map) u.invoke(null, bufferedInputStream), this.b, this.pn);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return mapU;
            } catch (Exception unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return Collections.emptyMap();
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return Collections.emptyMap();
    }

    public pn(com.bytedance.sdk.component.b.nr.u uVar, boolean z) {
        this.b = uVar;
        this.pn = z;
    }

    @Override // com.bytedance.sdk.component.x.nr
    public void u(Map<String, Object> map, File file) throws Throwable {
        if (!fx || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                nr.invoke(null, new com.bytedance.sdk.component.x.u.nr().u(map, this.b, this.pn), fileOutputStream2);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
