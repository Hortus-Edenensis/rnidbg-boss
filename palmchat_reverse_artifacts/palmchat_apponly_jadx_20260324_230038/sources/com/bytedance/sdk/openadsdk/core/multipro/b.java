package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.bq;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.web.MultiWebview;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.gi.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strU = u();
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(context, TextUtils.isEmpty(strU) ? "webview" : "webview_".concat(String.valueOf(strU)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
        if (file.exists()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                randomAccessFile = randomAccessFile2;
                th = th2;
            }
            try {
                FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
                if (fileLockTryLock != null) {
                    fileLockTryLock.close();
                } else {
                    u(file, file.delete());
                }
                com.bytedance.sdk.component.iz.fx.fx.nr.u(randomAccessFile);
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                u(file, file.exists() ? file.delete() : false);
                com.bytedance.sdk.component.iz.fx.fx.nr.u(randomAccessFile2);
            } catch (Throwable th3) {
                th = th3;
                com.bytedance.sdk.component.iz.fx.fx.nr.u(randomAccessFile);
                throw th;
            }
        }
    }

    public static void u(final Context context) {
        if (context == null) {
            return;
        }
        MultiWebview.b = new com.bytedance.sdk.component.widget.u() { // from class: com.bytedance.sdk.openadsdk.core.multipro.b.1
            @Override // com.bytedance.sdk.component.widget.u
            public void u(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                s.u().u("webview_init_failed", jSONObject, th);
            }
        };
        com.bytedance.sdk.component.x.fx.u(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (bq.u(context)) {
                    x.u(new a("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.b.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            b.fx(context);
                        }
                    });
                    return;
                }
                String strNr = bq.nr(context);
                try {
                    if (TextUtils.isEmpty(strNr)) {
                        strNr = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strNr);
                } catch (IllegalStateException unused) {
                    u(strNr);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            k.u(th.getMessage());
        }
    }

    private static void u(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void u(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
    }

    private static String u() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
