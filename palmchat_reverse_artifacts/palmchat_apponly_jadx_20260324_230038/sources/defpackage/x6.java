package defpackage;

import android.app.Activity;
import android.content.Context;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.login.AdSplaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class x6 {
    public static x6 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleDateFormat f21887a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;

    public x6() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.f21887a = simpleDateFormat;
        this.b = simpleDateFormat.format(new Date());
    }

    public static x6 a() {
        if (g == null) {
            g = new x6();
        }
        return g;
    }

    public int b() {
        return this.f;
    }

    public boolean c() {
        String strG = go.g("openscreen", "");
        LogUtil.d("AdSplashManager", "isSHowOpenScreen setOpenscreen " + strG + "   sDate" + this.b);
        return this.b.equals(strG);
    }

    public void d(boolean z) {
        this.e = z;
    }

    public void e() {
        go.o("openscreen", this.b);
    }

    public void f(int i) {
        this.f = i;
    }

    public void g(Context context, boolean z) {
        String strB = pu3.b();
        String str = z ? "switch" : "open";
        pu3.f(strB, str, 0, 0, 0, 0, 1000);
        LogUtil.d("", "SplashAdIn start triggerAd onRestart " + z);
        if (z) {
            this.d = true;
        } else if (this.d) {
            this.d = false;
            LogUtil.d("", "SplashAdIn start triggerAd onRestart false mSkipNextTrigger is true not allow");
            pu3.f(strB, str, 0, 98, 0, 0, 0);
            return;
        }
        if (this.e) {
            this.e = false;
            LogUtil.d("", "SplashAdIn start triggerAd mFlagOpenScreen true not allow");
            pu3.f(strB, str, 0, 99, 0, 0, 0);
            pu3.c(18, "LX-31249", dw3.y());
        } else if (context instanceof MainTabsActivity) {
            int i = !this.c ? 1 : 2;
            int iK = dw3.k(i, (Activity) context);
            LogUtil.d("", "SplashAdIn start triggerAd result " + iK);
            if (iK == -1) {
                WifiLog.d("NestSplashAd Activity allowRequestSplashAd , initActivityIsOnCreate:" + this.c + " , isBackground:" + AppContext.getContext().isBackground());
                if (!this.c || AppContext.getContext().isBackground()) {
                    f(i);
                    AdSplaseActivity.u = true;
                    AdSplaseActivity.B1(context, strB, str);
                    LogUtil.i("AdSplashManager", "AdSplashManageronRestart start");
                } else {
                    pu3.f(strB, str, 0, 106, 0, 0, 0);
                    LogUtil.d("", "SplashAdIn start triggerAd sBackground not allow ");
                }
                HashMap map = new HashMap();
                map.put("splash_type", String.valueOf(i));
                zn6.i("lx_client_req", map);
            } else {
                pu3.f(strB, str, 0, iK, 0, 0, 0);
            }
            LogUtil.i("AdSplashManager", "AdSplashManageronRestart");
        }
        LogUtil.d("AdSplashManager", "triggerAd, onRestart=" + z);
        this.c = true;
    }
}
