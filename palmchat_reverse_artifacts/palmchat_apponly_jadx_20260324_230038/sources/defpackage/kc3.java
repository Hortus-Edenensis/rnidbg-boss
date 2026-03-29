package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.media3.common.C;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.login.InitActivity;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class kc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f18619a;
    public boolean b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public long p;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static kc3 f18620a = new kc3();
    }

    public static kc3 c() {
        return a.f18620a;
    }

    public final void a() {
        this.o = -1;
        this.g = 0L;
        this.h = 0L;
    }

    public long b() {
        return this.c;
    }

    public final boolean d() {
        return AppContext.getContext().isBackground();
    }

    public void e(Activity activity) {
        if (this.f18619a == null) {
            this.f18619a = activity.getClass();
        } else {
            this.b = true;
        }
    }

    public void f() {
        this.d = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.c = SystemClock.elapsedRealtime();
    }

    public void h() {
        a();
    }

    public void i() {
        this.f = SystemClock.elapsedRealtime();
    }

    public void j() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void k(Activity activity) {
        this.b = true;
        if (this.o != -1) {
            if (activity == null || !(activity instanceof MainTabsActivity)) {
                a();
            }
        }
    }

    public void l() {
        this.h = SystemClock.elapsedRealtime();
    }

    public void m() {
        int i = this.o;
        if (i == -1) {
            return;
        }
        y(i);
        a();
    }

    public final void n(int i, long j) {
        this.o = i;
        this.p = j;
    }

    public void o(Intent intent) {
        if (intent == null) {
            a();
        } else if (!d() || intent.getSourceBounds() == null) {
            a();
        } else {
            this.g = SystemClock.elapsedRealtime();
        }
    }

    public void p() {
        this.i = SystemClock.elapsedRealtime();
        if (d()) {
            long j = this.g;
            if (j > 0 && this.h > 0) {
                if (this.b || this.f18619a != InitActivity.class || j - this.f >= 500) {
                    n(2, j);
                    return;
                } else {
                    n(1, -1L);
                    return;
                }
            }
        }
        a();
    }

    public void q(Activity activity) {
        this.j = SystemClock.elapsedRealtime();
    }

    public void r() {
        a();
    }

    public void s() {
        if (d() && this.g == 0) {
            n(3, SystemClock.elapsedRealtime());
        } else {
            a();
        }
    }

    public void t() {
        this.m = SystemClock.elapsedRealtime();
    }

    public void u() {
        this.n = SystemClock.elapsedRealtime();
    }

    public void v() {
        this.k = SystemClock.elapsedRealtime();
        if (d()) {
            return;
        }
        a();
    }

    public void w() {
        this.l = SystemClock.elapsedRealtime();
    }

    public void x() {
        a();
    }

    public final void y(int i) {
        long j;
        long j2;
        long j3 = this.p;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = new HashMap();
        if (i == 1) {
            if (!t5.m()) {
                z53.d("MainUiLaunchCost", "is not NormalLaunch");
                return;
            }
            long j4 = this.c;
            if (j4 == -1 || j4 > j4 || j4 - j4 > 1000) {
                z53.b("MainUiLaunchCost", "processStartTime is invalid processStartTime=" + j4 + " mAppAttachStartTime=" + this.c);
                if (Build.VERSION.SDK_INT < 29) {
                    return;
                } else {
                    j3 = this.c;
                }
            } else {
                j3 = j4;
            }
            long j5 = this.c;
            long j6 = j5 - j3;
            long j7 = this.f;
            long j8 = j7 - j5;
            long j9 = this.d;
            long j10 = j9 - j5;
            long j11 = this.e;
            long j12 = j7 - j11;
            if (j11 - j9 > 1000) {
                return;
            }
            map.put("process_cost", String.valueOf(j6));
            map.put("app_cost", String.valueOf(j8));
            map.put("app_attach_cost", String.valueOf(j10));
            map.put("app_create_cost", String.valueOf(j12));
        }
        if (i == 1 || i == 2) {
            j = j3;
            long j13 = this.h;
            long j14 = this.g;
            long j15 = j13 - j14;
            if (j15 > 2000) {
                return;
            }
            long j16 = this.i;
            long j17 = jElapsedRealtime - j16;
            long j18 = this.j - j16;
            long j19 = this.l - this.k;
            long j20 = this.n;
            long j21 = j20 - this.m;
            long j22 = jElapsedRealtime - j20;
            j2 = jElapsedRealtime;
            if (i == 1) {
                map.put("jumpInit", String.valueOf(j14 - this.f));
                map.put("jumpMain", String.valueOf(j16 - j13));
            }
            map.put("jump_cost", String.valueOf(j15));
            map.put("main_cost", String.valueOf(j17));
            map.put("main_create_cost", String.valueOf(j18));
            map.put("main_start_cost", String.valueOf(j19));
            map.put("main_resume_cost", String.valueOf(j21));
            map.put("main_focus_cost", String.valueOf(j22));
        } else {
            long j23 = jElapsedRealtime - j3;
            long j24 = this.l - this.k;
            long j25 = this.n;
            j = j3;
            long j26 = j25 - this.m;
            map.put("main_cost", String.valueOf(j23));
            map.put("main_start_cost", String.valueOf(j24));
            map.put("main_resume_cost", String.valueOf(j26));
            map.put("main_focus_cost", String.valueOf(jElapsedRealtime - j25));
            j2 = jElapsedRealtime;
        }
        long j27 = j2 - j;
        if (j27 > 0) {
            if (i != 1 || j27 <= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
                if (i != 2 || j27 <= 7500) {
                    if (i != 3 || j27 <= 3000) {
                        map.put("type", String.valueOf(i));
                        map.put("total_cost", String.valueOf(j27));
                        zn6.i("lx_launch_cost", map);
                    }
                }
            }
        }
    }

    public kc3() {
        this.o = -1;
    }
}
