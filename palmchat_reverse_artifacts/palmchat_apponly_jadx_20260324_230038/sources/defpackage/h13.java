package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.browser.SRobotCompModel;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h13 {
    public static int m = 0;
    public static int n = 1;
    public static int o = 3;
    public static int p = 4;
    public static int q = 5;
    public static int r = 6;
    public static int s = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17850a = null;
    public String b = null;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public long f = 0;
    public long g = 0;
    public String h = null;
    public int i = -1;
    public long j = 0;
    public SRobotCompModel k;
    public Activity l;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h13.this.b();
        }
    }

    public final void b() {
        Activity activity;
        LogUtil.i("LXWebViewTracer", "checkIfTimeout ");
        if (this.c || (activity = this.l) == null || activity.isFinishing()) {
            return;
        }
        g();
        this.l.finish();
    }

    public long c() {
        long j = this.f;
        return j != 0 ? this.j + ir5.e(j) : this.j;
    }

    public final void d(String str, String str2, long j) {
        LogUtil.i("LXWebViewTracer", "logClose url =" + str + " preurl=" + str2 + " during=" + j);
        HashMap map = new HashMap();
        map.put("url", this.h);
        map.put("currentUrl", str);
        zn6.i("H5_loading_close", map);
    }

    public final void e() {
        LogUtil.i("LXWebViewTracer", "logStart url =" + this.h);
        HashMap map = new HashMap();
        map.put("url", this.h);
        zn6.i("H5_loadingstart", map);
    }

    public final void f() {
        if (this.e || this.d) {
            return;
        }
        this.d = true;
        LogUtil.i("LXWebViewTracer", "logSuccess url =" + this.h);
        HashMap map = new HashMap();
        map.put("url", this.h);
        zn6.i("H5_loadingvictory", map);
    }

    public final void g() {
        LogUtil.i("LXWebViewTracer", "logTimeout url =" + this.h);
        HashMap map = new HashMap();
        map.put("url", this.h);
        zn6.i("H5_loadingtimeout", map);
    }

    public void h(Activity activity, String str, int i, SRobotCompModel sRobotCompModel) {
        String str2;
        int iA;
        this.l = activity;
        this.h = str;
        this.i = i;
        this.k = sRobotCompModel;
        if (activity.getLocalClassName().equals("activity.webview.TransparentCordovaWebActivity") && (str2 = this.h) != null && !str2.contains("/mapps/wallet") && (iA = vs0.a().a("H5_loadingtimeout", 5)) > 0) {
            u93.b(iA * 1000, new a());
        }
        e();
        this.g = ir5.b();
    }

    public void i() {
        d(this.b, this.f17850a, c());
    }

    public void j(String str, boolean z) {
        LogUtil.i("LXWebViewTracer", "onPageFinished");
        this.c = true;
        if (z) {
            this.f17850a = this.b;
            this.b = str;
            this.f = ir5.b();
        } else {
            this.f = 0L;
        }
        this.j = 0L;
        f();
    }

    public void k(String str) {
        LogUtil.i("LXWebViewTracer", "onPageStarted");
    }

    public void l() {
        long j = this.f;
        if (j != 0) {
            this.j += ir5.e(j);
        }
    }

    public void m(int i) {
        LogUtil.i("LXWebViewTracer", "onProgressChanged " + i);
        if (i == 100) {
            if (!this.c) {
                LogUtil.e("LXWebViewTracer", "onProgressChanged 100 " + ir5.e(this.g));
                if (ir5.e(this.g) < 20000) {
                    this.c = true;
                }
            }
            f();
        }
    }

    public void n(int i, String str, String str2) {
        this.c = true;
        this.e = true;
        LogUtil.i("LXWebViewTracer", "onReceivedError " + i + " description " + str + " failingUrl=" + str2);
        HashMap map = new HashMap();
        map.put("url", str2);
        map.put("error", str);
        map.put("code", String.valueOf(i));
        zn6.i("H5_loadingfail", map);
    }

    public void o(String str) {
        n(-10086, str, this.h);
    }

    public void p() {
        long jB = ir5.b();
        long j = this.f;
        if (j == 0 || j > jB) {
            return;
        }
        this.f = jB;
    }
}
