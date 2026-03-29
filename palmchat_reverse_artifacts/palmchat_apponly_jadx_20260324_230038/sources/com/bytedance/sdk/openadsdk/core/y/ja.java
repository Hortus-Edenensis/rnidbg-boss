package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ja {
    private String u;

    private ja() {
        nr();
    }

    private void fx() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.u.u.u().fx();
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().nr();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.pb.n.u();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.u.nr.nr.nr();
            com.bytedance.sdk.openadsdk.core.ugeno.iz.u.nr().iz();
        } catch (Throwable unused4) {
        }
        try {
            Function<SparseArray<Object>, Object> functionY = com.bytedance.sdk.openadsdk.core.n.o().y();
            if (functionY != null) {
                functionY.apply(com.bytedance.sdk.openadsdk.my.b.u().u(7).u(Void.class).nr());
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.fx.fx.u().jk();
            com.bytedance.sdk.openadsdk.core.fx.b.u().q();
            com.bytedance.sdk.openadsdk.core.fx.pn.u().my();
        } catch (Throwable unused6) {
        }
    }

    private void nr() {
        File fileU;
        Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.gi.fx.u()) && (fileU = com.bytedance.sdk.openadsdk.api.plugin.nr.u(context, "TTCache")) != null) {
                fileU.mkdirs();
                this.u = fileU.getPath();
            }
            if (TextUtils.isEmpty(this.u)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(context), "TTCache");
                file.mkdirs();
                this.u = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public static ja u() {
        return new ja();
    }

    public void u(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            zContains = string != null ? string.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.x.b.u().u(thread, th);
        } catch (Throwable unused) {
        }
        if (zContains) {
            nr(thread, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void nr(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        int i;
        boolean z;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.u)) {
                nr();
            }
            if (TextUtils.isEmpty(this.u)) {
                return;
            }
            File file = new File(this.u, "tt_crash_count.properties");
            if (file.exists() && file.isFile() && file.canRead()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream3);
                    String property = properties.getProperty("crash_count", "0");
                    String property2 = properties.getProperty("crash_last_time", "0");
                    int iIntValue = Integer.valueOf(property).intValue();
                    long jLongValue = Long.valueOf(property2).longValue();
                    int i2 = 0;
                    if (System.currentTimeMillis() - jLongValue < 300000) {
                        i = iIntValue + 1;
                        z = false;
                    } else {
                        i = 1;
                        z = true;
                    }
                    boolean z2 = i >= 3;
                    if (!z2) {
                        i2 = i;
                    }
                    com.bytedance.sdk.component.utils.k.nr("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                    if (z2) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    } else {
                        properties.setProperty("crash_count", String.valueOf(i2));
                        if (z) {
                            properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            properties.store(fileOutputStream, "tt_crash_info");
                            fileOutputStream2 = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream3;
                            com.bytedance.sdk.component.utils.k.u("TTCrashHandler", "crash count error", th);
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        }
                    }
                    if (z2) {
                        fx();
                    }
                    fileOutputStream = fileOutputStream2;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                }
            } else {
                Properties properties2 = new Properties();
                properties2.setProperty("crash_count", "1");
                properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                fileOutputStream = new FileOutputStream(file);
                try {
                    properties2.store(fileOutputStream, "tt_crash_info");
                    com.bytedance.sdk.component.utils.k.nr("TTCrashHandler", "==first");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        com.bytedance.sdk.component.utils.k.u("TTCrashHandler", "crash count error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }
}
