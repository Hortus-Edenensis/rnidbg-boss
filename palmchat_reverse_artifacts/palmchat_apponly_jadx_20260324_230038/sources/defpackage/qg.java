package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.kotlin.common.SPUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qg {
    public static boolean a() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (sPUtil.a(scene, "app_evaluate_has_show", false)) {
            return false;
        }
        long jI = sPUtil.i(scene, "app_evaluate_latest_active_time", 0L);
        int iF = sPUtil.f(scene, "app_evaluate_active_day", 0);
        if (by5.k(86400000 + jI)) {
            iF++;
            sPUtil.t(scene, "app_evaluate_active_day", Integer.valueOf(iF));
            sPUtil.t(scene, "app_evaluate_latest_active_time", Long.valueOf(System.currentTimeMillis()));
        } else if (by5.k(jI)) {
            long jI2 = sPUtil.i(scene, "app_evaluate_check_time", 0L);
            if (jI2 > 0 && by5.k(jI2)) {
                iF = 0;
            }
        } else {
            sPUtil.t(scene, "app_evaluate_active_day", 1);
            sPUtil.t(scene, "app_evaluate_latest_active_time", Long.valueOf(System.currentTimeMillis()));
            iF = 1;
        }
        return iF >= b();
    }

    public static int b() {
        int iC = ts0.o().c();
        if (iC > 0) {
            return iC;
        }
        return 3;
    }

    public static void c(Activity activity, String str, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.addFlags(268435456);
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(activity, "您的手机没有安装Android应用市场", 0).show();
        }
    }

    public static void d() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "app_evaluate_has_show", Boolean.TRUE);
    }

    public static void e() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "app_evaluate_check_time", Long.valueOf(System.currentTimeMillis()));
    }
}
