package defpackage;

import android.app.Activity;
import com.wifi.ad.core.data.NestAdData;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class tt2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ut2 {
        @Override // defpackage.ut2
        public void onAdClose(String str, NestAdData nestAdData) {
            LogUtil.d("InterAdBaseManager", "global interstitial, onAdClose, providerType:" + str);
        }

        @Override // defpackage.ut2
        public void onAdExpose(String str, NestAdData nestAdData) {
            LogUtil.d("InterAdBaseManager", "global interstitial, onAdExpose, providerType:" + str);
        }
    }

    public static int a(String str) {
        return wt2.b(str) ? 1 : 0;
    }

    public static ut2 b() {
        return new a();
    }

    public static boolean c(String str) {
        if (a(str) != 1) {
            return false;
        }
        return wt2.b(str);
    }

    public static void d(Activity activity, String str) {
        LogUtil.d("InterAdBaseManager", "global interstitial, requestPopAd, ready to start.  tabTag:" + str);
        uv3.y(activity, str);
    }

    public static void e(Activity activity, String str, String str2) {
        if (a(str) != 1) {
            return;
        }
        if (wt2.c()) {
            f(activity, str, str2);
            return;
        }
        LogUtil.d("InterAdBaseManager", "global interstitial, requestOrShowAd, taiChi not allow.  pageName:" + str2);
    }

    public static void f(Activity activity, String str, String str2) {
        if (!uv3.l()) {
            LogUtil.d("InterAdBaseManager", "global interstitial, requestPopAd, smallVideo not allow.  tabTag:" + str);
            return;
        }
        LogUtil.d("InterAdBaseManager", "global interstitial, requestOrShowAd, ready to start.  tabTag:" + str + " , pageName:" + str2);
        uv3.B(activity, str, str2, b());
    }

    public static void g(Activity activity, String str) {
        if (a(str) != 1) {
            return;
        }
        if (wt2.c()) {
            d(activity, str);
            return;
        }
        LogUtil.d("InterAdBaseManager", "global interstitial, requestPopAd, taiChi not allow.  tabTag:" + str);
    }
}
