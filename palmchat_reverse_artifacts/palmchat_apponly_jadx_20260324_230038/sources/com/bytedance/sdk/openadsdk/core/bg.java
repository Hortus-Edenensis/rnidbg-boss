package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg {
    private static volatile Handler iz = null;
    public static volatile boolean u = false;
    public static AtomicBoolean nr = new AtomicBoolean(false);
    public static AtomicBoolean fx = new AtomicBoolean(false);
    public static AtomicBoolean b = new AtomicBoolean(false);
    public static final long pn = SystemClock.elapsedRealtime();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u implements com.bytedance.sdk.component.iz.c {
        private u() {
        }

        @Override // com.bytedance.sdk.component.iz.c
        public void clearMemoryCache(double d) {
            com.bytedance.sdk.openadsdk.n.nr.nr().clearMemoryCache(d);
        }

        @Override // com.bytedance.sdk.component.iz.c
        public com.bytedance.sdk.component.iz.s from(String str) {
            return com.bytedance.sdk.openadsdk.n.nr.nr().from(str);
        }

        @Override // com.bytedance.sdk.component.iz.c
        public InputStream getCacheStream(String str, String str2) {
            return com.bytedance.sdk.openadsdk.n.nr.nr().getCacheStream(str, str2);
        }
    }

    public static void b() {
        com.bytedance.sdk.component.adexpress.u.u.u.u().u(new com.bytedance.sdk.component.adexpress.u.u.fx() { // from class: com.bytedance.sdk.openadsdk.core.bg.2
            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int a() {
                return dw.nr().ap();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public com.bytedance.sdk.component.a.nr.nr b() {
                return com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().b();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public com.bytedance.sdk.component.adexpress.u.fx.u fx() {
                return dw.u().u(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public Context getContext() {
                return dw.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public String iz() {
                return n.o().c();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int jk() {
                return n.o().ay();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int k() {
                return y.b(dw.getContext());
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public boolean l() {
                return com.bytedance.sdk.openadsdk.core.multipro.nr.fx();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public ExecutorService mv() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int n() {
                return dw.nr().kv();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public Handler nr() {
                return bg.iz();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public com.bytedance.sdk.component.a.nr.fx pn() {
                return com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().fx();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public ExecutorService s() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int t() {
                return dw.nr().dd();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int u() {
                if (dw.nr() == null) {
                    return 0;
                }
                return dw.nr().e();
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.fx
            public int x() {
                return 0;
            }
        });
    }

    public static void fx() {
        com.bytedance.sdk.component.b.nr.fx fxVarU = nr.u();
        long jCurrentTimeMillis = fxVarU.get("sdk_first_init_timestamp", 0L);
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            fxVarU.put("sdk_first_init_timestamp", jCurrentTimeMillis);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String strNr = jp.nr(jCurrentTimeMillis, jCurrentTimeMillis2);
        long j = fxVarU.get("sdk_init_timestamp", 0L);
        StringBuilder sb = new StringBuilder();
        sb.append(j != 0 ? (jCurrentTimeMillis2 - j) / 1000 : 0L);
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(strNr, sb.toString());
        fxVarU.put("sdk_init_timestamp", System.currentTimeMillis());
    }

    public static Handler iz() {
        if (iz == null) {
            synchronized (bg.class) {
                if (iz == null) {
                    iz = new Handler(Looper.getMainLooper());
                }
            }
        }
        return iz;
    }

    private static void n() {
        com.bytedance.sdk.openadsdk.core.fx.b.u().b(UUID.randomUUID().toString());
    }

    public static void nr() {
        dw.nr().u(1);
        if (!b.get()) {
            u();
        }
        Context context = dw.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().u(context, com.bytedance.sdk.openadsdk.core.multipro.nr.fx());
        } catch (Exception unused) {
        }
    }

    public static void pn() {
        com.bytedance.sdk.component.adexpress.u.u.u.u().u(new com.bytedance.sdk.component.adexpress.u.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.bg.3
            @Override // com.bytedance.sdk.component.adexpress.u.u.nr
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.delete(dw.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.nr
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.u.u.insert(dw.getContext(), str, contentValues);
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.nr
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.query(dw.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.nr
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.u.u.update(dw.getContext(), str, contentValues, str2, strArr);
            }
        });
        com.bytedance.sdk.component.adexpress.u.u.u.u().u(new com.bytedance.sdk.component.adexpress.u.u.b() { // from class: com.bytedance.sdk.openadsdk.core.bg.4
            @Override // com.bytedance.sdk.component.adexpress.u.u.b
            public void u(final int i) {
                com.bytedance.sdk.openadsdk.core.qq.s.u().pn(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.bg.4.1
                    @Override // com.bytedance.sdk.openadsdk.t.u.u
                    public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().nr(i).x(x.u(i));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.u.u.u.u().u(new u());
        com.bytedance.sdk.component.adexpress.u.u.u.u().u(new com.bytedance.sdk.component.adexpress.u.u.pn() { // from class: com.bytedance.sdk.openadsdk.core.bg.5
            @Override // com.bytedance.sdk.component.adexpress.u.u.pn
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.fx.nr.u().u(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.u.u.pn
            public void update(String str, com.bytedance.sdk.component.adexpress.u.fx.fx fxVar) {
                com.bytedance.sdk.openadsdk.core.fx.nr.u().u(str, fxVar);
            }
        });
    }

    public static void u() {
        Context context;
        if (b.get() || !dw.nr().tk() || (context = dw.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().u(context, true, (com.bytedance.sdk.component.a.fx.nr) new com.bytedance.sdk.openadsdk.core.gi.b(context));
        } catch (Exception unused) {
        }
        b.set(true);
    }

    private static void x() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context) {
        nr.set(true);
        fx.set(true);
        x();
        y.u(context);
        n();
        String strFx = sx.fx();
        if (!TextUtils.isEmpty(strFx)) {
            com.bytedance.sdk.openadsdk.core.qq.nr.u(strFx);
        }
        if (com.bytedance.sdk.openadsdk.u.u.u.u() != null) {
            com.bytedance.sdk.openadsdk.u.u.u.u().u(strFx);
        }
        com.bytedance.sdk.component.adexpress.u.nr.nr.u();
        new com.bytedance.sdk.openadsdk.core.b.nr("playable_engine_init").nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.bg.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.u.nr.nr.nr();
            }
        });
    }
}
