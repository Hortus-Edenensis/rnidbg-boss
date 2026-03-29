package com.heytap.mspsdk.core.crash;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.log.MspLog;
import com.heytap.mspsdk.util.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, List<c>> f6387a;
    private static b b = new b();

    /* JADX INFO: renamed from: com.heytap.mspsdk.core.crash.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0397a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6388a = new a();
    }

    private void b(final Context context) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f6389a.e(context);
            }
        });
    }

    private synchronized void c(final Context context) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.f
            @Override // java.lang.Runnable
            public final void run() {
                a.d(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Context context) {
        int iIntValue = ((Integer) new g(context, Constants.SP_COMMON_FILE, 0).a("key_version_code", 0)).intValue();
        if (iIntValue > 0) {
            com.heytap.mspsdk.core.b bVarA = com.heytap.mspsdk.core.b.a(context);
            int iE = bVarA.e();
            String strD = bVarA.d();
            if (iE > iIntValue) {
                a(context, iE, strD);
            }
        }
    }

    public static a a() {
        return C0397a.f6388a;
    }

    private synchronized void b(final Context context, final String str, final int i, final int i2, final int i3, final String str2) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.e
            @Override // java.lang.Runnable
            public final void run() {
                a.c(context, str, i, i2, i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, String str, int i, int i2, int i3, String str2) {
        try {
            g gVar = new g(context, Constants.SP_COMMON_FILE, 0);
            gVar.b("key_process_name", str);
            gVar.b("key_crash_count", Integer.valueOf(i));
            gVar.b("key_launch_count", Integer.valueOf(i2));
            gVar.b("key_version_code", Integer.valueOf(i3));
            gVar.b("key_version_name", str2);
            gVar.b();
        } catch (Exception e) {
            MspLog.e("AppCrashManager", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context) {
        try {
            new g(context, Constants.SP_COMMON_FILE, 0).a("key_version_code").a("key_version_name").a("key_crash_count").a("key_launch_count").a("key_process_name").b();
        } catch (Exception e) {
            MspLog.e("AppCrashManager", e);
        }
    }

    public static String a(Context context, String str) {
        return str.contains("com.heytap.htms") ? str.replace("com.heytap.htms", com.heytap.mspsdk.core.b.a(context).f()) : str;
    }

    public void a(Context context) {
        MspLog.d("AppCrashManager", "registerCrashReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.heytap.htms.sub_process_crash");
        int i = Build.VERSION.SDK_INT;
        Context applicationContext = context.getApplicationContext();
        if (i >= 33) {
            applicationContext.registerReceiver(b, intentFilter, 4);
        } else {
            applicationContext.registerReceiver(b, intentFilter);
        }
    }

    public synchronized void a(Context context, int i, String str) {
        c(context);
        for (String str2 : f6387a.keySet()) {
            List<c> list = f6387a.get(str2);
            if (list != null && list.size() > 0) {
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(str2, i, str);
                }
            }
        }
    }

    public synchronized void a(Context context, String str, int i, int i2, int i3, String str2) {
        b(context, str, i, i2, i3, str2);
        if (f6387a.containsKey(str)) {
            List<c> list = f6387a.get(str);
            if (list != null && list.size() > 0) {
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(i2, i, str, i3, str2);
                }
            }
        }
    }

    public synchronized void a(Context context, String str, c cVar) {
        MspLog.d("AppCrashManager", "addMspProcessCrashListener:" + str);
        if (f6387a == null) {
            a(new ConcurrentHashMap());
        }
        List<c> copyOnWriteArrayList = f6387a.containsKey(str) ? f6387a.get(str) : null;
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (copyOnWriteArrayList.size() > 10) {
            return;
        }
        copyOnWriteArrayList.add(cVar);
        f6387a.put(str, copyOnWriteArrayList);
        b(context);
    }

    private static void a(Map<String, List<c>> map) {
        f6387a = map;
    }
}
