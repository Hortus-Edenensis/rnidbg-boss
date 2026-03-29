package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.Npth;
import com.huawei.hms.ads.ex;
import defpackage.y37;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mz6 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements y37.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f19398a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ long d;

        public a(File file, String str, File file2, long j) {
            this.f19398a = file;
            this.b = str;
            this.c = file2;
            this.d = j;
        }

        @Override // y37.a
        public ev6 a(int i, ev6 ev6Var, boolean z) {
            try {
                JSONObject jSONObjectG = ev6Var.G();
                if (jSONObjectG.length() > 0) {
                    re7.m(new File(this.c.getAbsolutePath() + '.' + i), jSONObjectG, false);
                }
            } catch (IOException e) {
                n37.a();
                n37.b("NPTH_CATCH", e);
            }
            if (i == 0) {
                zu6.a().d();
                zu6.a().b(CrashType.NATIVE, this.d, x97.l());
            }
            return ev6Var;
        }

        @Override // y37.a
        public ev6 b(int i, ev6 ev6Var) {
            String str;
            String str2 = ex.Code;
            if (i != 1) {
                if (i == 2) {
                    JSONArray jSONArrayB = u77.b();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    JSONObject jSONObjectC = u77.c(jUptimeMillis);
                    JSONArray jSONArrayA = oc7.a(100, jUptimeMillis);
                    ev6Var.j("history_message", jSONArrayB);
                    ev6Var.j("current_message", jSONObjectC);
                    ev6Var.j("pending_messages", jSONArrayA);
                    ev6Var.e("disable_looper_monitor", String.valueOf(nv6.l()));
                } else if (i != 3) {
                    if (i == 4) {
                        kv6.d(x97.m(), ev6Var.G());
                        nd7.a(wi7.F(x97.m()), CrashType.NATIVE, "");
                    }
                } else if (nv6.m()) {
                    ev6Var.j("all_thread_stacks", yl7.r(this.b));
                    str = "has_all_thread_stack";
                }
                return ev6Var;
            }
            s07.h(this.f19398a, CrashType.NATIVE);
            String str3 = this.b;
            if (str3 != null && str3.length() != 0) {
                ev6Var.j("java_data", mz6.e(this.b));
            }
            if (!Npth.hasCrashWhenNativeCrash()) {
                str2 = ex.V;
            }
            str = "crash_after_crash";
            ev6Var.e(str, str2);
            return ev6Var;
        }

        @Override // y37.a
        public void a(Throwable th) {
        }
    }

    public static int a() {
        return 6;
    }

    public static void b(String str) {
        String strE;
        long jCurrentTimeMillis = System.currentTimeMillis();
        kj7.a("[onNativeCrash] enter");
        try {
            try {
                qz6.a().m();
                File file = new File(wi7.a(), x97.l());
                File fileS = wi7.s(file);
                ev6 ev6VarB = da7.d().b(CrashType.NATIVE, null, new a(file, str, fileS, jCurrentTimeMillis), true);
                JSONObject jSONObjectG = ev6VarB.G();
                if (jSONObjectG != null && jSONObjectG.length() != 0) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                    try {
                        jSONObjectG.put("java_end", jCurrentTimeMillis2);
                        ev6VarB.q("crash_cost", String.valueOf(j));
                        ev6VarB.e("crash_cost", String.valueOf(j / 1000));
                    } catch (Throwable unused) {
                    }
                    File file2 = new File(fileS.getAbsolutePath() + ".tmp");
                    re7.m(file2, jSONObjectG, false);
                    file2.renameTo(fileS);
                }
            } catch (Throwable th) {
                try {
                    n37.a();
                    n37.b("NPTH_CATCH", th);
                    if (cg7.a().h().isEmpty()) {
                        return;
                    }
                    File file3 = new File(wi7.a(), x97.l());
                    ba7 ba7Var = new ba7(file3);
                    ba7Var.d(file3);
                    strE = ba7Var.e();
                } catch (Throwable th2) {
                    try {
                        if (!cg7.a().h().isEmpty()) {
                            File file4 = new File(wi7.a(), x97.l());
                            ba7 ba7Var2 = new ba7(file4);
                            ba7Var2.d(file4);
                            c(ba7Var2.e(), null);
                        }
                    } catch (Throwable unused2) {
                        c("", null);
                    }
                    throw th2;
                }
            }
            if (cg7.a().h().isEmpty()) {
                return;
            }
            File file5 = new File(wi7.a(), x97.l());
            ba7 ba7Var3 = new ba7(file5);
            ba7Var3.d(file5);
            strE = ba7Var3.e();
            c(strE, null);
        } catch (Throwable unused3) {
            c("", null);
        }
    }

    public static void c(String str, Thread thread) {
        Iterator<ICrashCallback> it = cg7.a().h().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.NATIVE, str, thread);
            } catch (Throwable th) {
                n37.a();
                n37.b("NPTH_CATCH", th);
            }
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("main".equalsIgnoreCase(str)) {
            return yl7.e(Looper.getMainLooper().getThread().getStackTrace());
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int iActiveCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroup.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            String name = threadArr[i].getName();
            if (!TextUtils.isEmpty(name) && (name.equals(str) || name.startsWith(str) || name.endsWith(str))) {
                return yl7.e(threadArr[i].getStackTrace());
            }
        }
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                String name2 = entry.getKey().getName();
                if (name2.equals(str) || name2.startsWith(str) || name2.endsWith(str)) {
                    return yl7.e(entry.getValue());
                }
            }
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
        return "";
    }
}
