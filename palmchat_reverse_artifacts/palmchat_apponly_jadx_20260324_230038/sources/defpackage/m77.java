package defpackage;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.NativeImpl;
import com.huawei.hms.ads.ex;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import com.zm.fda.Z200O.ZZ00Z;
import defpackage.y37;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class m77 implements r37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19155a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements y37.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19156a = 0;
        public final /* synthetic */ Throwable b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Thread g;
        public final /* synthetic */ String h;
        public final /* synthetic */ File i;

        public a(Throwable th, boolean z, long j, String str, boolean z2, Thread thread, String str2, File file) {
            this.b = th;
            this.c = z;
            this.d = j;
            this.e = str;
            this.f = z2;
            this.g = thread;
            this.h = str2;
            this.i = file;
        }

        @Override // y37.a
        public ev6 a(int i, ev6 ev6Var, boolean z) {
            if (nj7.c(nj7.d(i))) {
                return ev6Var;
            }
            try {
                re7.m(new File(this.i, this.i.getName() + "." + i), ev6Var.G(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ev6Var;
        }

        @Override // y37.a
        public ev6 b(int i, ev6 ev6Var) {
            String str;
            String strValueOf;
            this.f19156a = SystemClock.uptimeMillis();
            if (i != 0) {
                if (i == 1) {
                    Thread thread = this.g;
                    ev6Var.j("crash_thread_name", thread != null ? thread.getName() : "");
                    ev6Var.j("tid", Integer.valueOf(Process.myTid()));
                    boolean zHasCrashWhenJavaCrash = Npth.hasCrashWhenJavaCrash();
                    String str2 = ex.Code;
                    ev6Var.e("crash_after_crash", zHasCrashWhenJavaCrash ? ex.Code : ex.V);
                    if (!NativeImpl.duringNativeCrash()) {
                        str2 = ex.V;
                    }
                    ev6Var.e("crash_after_native", str2);
                    st6.c().j(this.g, this.b, false, ev6Var);
                } else if (i == 2) {
                    if (this.c) {
                        kv6.d(m77.this.f19155a, ev6Var.G());
                    }
                    JSONArray jSONArrayB = u77.b();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    JSONObject jSONObjectC = u77.c(jUptimeMillis);
                    JSONArray jSONArrayA = oc7.a(100, jUptimeMillis);
                    ev6Var.j("history_message", jSONArrayB);
                    ev6Var.j("current_message", jSONObjectC);
                    ev6Var.j("pending_messages", jSONArrayA);
                    strValueOf = String.valueOf(nv6.l());
                    str = "disable_looper_monitor";
                    ev6Var.e(str, strValueOf);
                } else if (i == 3) {
                    JSONObject jSONObjectR = yl7.r(Thread.currentThread().getName());
                    if (jSONObjectR != null) {
                        ev6Var.j("all_thread_stacks", jSONObjectR);
                    }
                    ev6Var.j("logcat", hf7.b(x97.l()));
                } else if (i != 4) {
                    if (i == 5) {
                        ev6Var.j("crash_uuid", this.h);
                        nd7.a(wi7.F(x97.m()), CrashType.JAVA, "");
                    }
                } else if (!this.c) {
                    kv6.d(m77.this.f19155a, ev6Var.G());
                }
            } else {
                ev6Var.j("data", yl7.b(this.b));
                ev6Var.j("isOOM", Boolean.valueOf(this.c));
                ev6Var.j("isJava", 1);
                ev6Var.j("crash_time", Long.valueOf(this.d));
                ev6Var.j("launch_mode", Integer.valueOf(nz6.n()));
                ev6Var.j("launch_time", Long.valueOf(nz6.s()));
                String str3 = this.e;
                if (str3 != null) {
                    ev6Var.j(ZZ00Z.s, str3);
                    ev6Var.e(ZZ00Z.s, this.e);
                    boolean z = this.f;
                    if (z) {
                        str = "has_ignore";
                        strValueOf = String.valueOf(z);
                        ev6Var.e(str, strValueOf);
                    }
                }
            }
            return ev6Var;
        }

        @Override // y37.a
        public void a(Throwable th) {
        }
    }

    public m77(Context context) {
        this.f19155a = context;
    }

    public static int b() {
        return 6;
    }

    @Override // defpackage.r37
    public void a(long j, Thread thread, Throwable th, String str, File file, String str2, boolean z) {
        File file2 = new File(wi7.b(this.f19155a), str);
        st6.c().h(file2.getName());
        file2.mkdirs();
        re7.F(file2);
        ev6 ev6VarB = da7.d().b(CrashType.JAVA, null, new a(th, yl7.w(th), j, str2, z, thread, str, file2), true);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        try {
            ev6VarB.e(CrashHianalyticsData.CRASH_TYPE, PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL);
            ev6VarB.q("crash_cost", String.valueOf(jCurrentTimeMillis));
            ev6VarB.e("crash_cost", String.valueOf(jCurrentTimeMillis / 1000));
        } catch (Throwable th2) {
            n37.a();
            n37.b("NPTH_CATCH", th2);
        }
        if (nj7.c(4)) {
            return;
        }
        nj7.c(2048);
    }

    @Override // defpackage.r37
    public boolean a(Throwable th) {
        return true;
    }
}
