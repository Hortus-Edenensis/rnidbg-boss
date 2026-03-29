package defpackage;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class we6 {
    public static void a(Activity activity) {
        if (activity == null || !e() || !d() || c()) {
            return;
        }
        try {
            String strE = yi1.e();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strE);
            int iOptInt = jSONObject.optInt("time");
            int iOptInt2 = jSONObject.optInt("max");
            int iOptInt3 = jSONObject.optInt("interval");
            String strOptString = jSONObject.optString("title");
            String strOptString2 = jSONObject.optString(MediaFormat.KEY_SUBTITLE);
            String strOptString3 = jSONObject.optString("btntitle");
            if (iOptInt <= 0 || iOptInt2 <= 0 || iOptInt3 <= 0) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            long jI = sPUtil.i(scene, "key_video_top_wifikey_guide_last_show_time", 0L);
            int iF = sPUtil.f(scene, "key_video_top_wifikey_guide_count", 0);
            if (iF >= iOptInt2 || System.currentTimeMillis() - jI <= ((long) iOptInt3) * 3600000) {
                return;
            }
            ve6.p(activity, strOptString, strOptString2, strOptString3, iOptInt);
            sPUtil.t(scene, "key_video_top_wifikey_guide_last_show_time", Long.valueOf(System.currentTimeMillis()));
            sPUtil.t(scene, "key_video_top_wifikey_guide_count", Integer.valueOf(iF + 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(String str) {
        PackageInfo packageInfo;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = c.b().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean c() {
        return b("com.snda.wifilocating") || b("com.snda.lantern.wifilocating");
    }

    public static boolean d() {
        return hx3.m(c.b()) && !hx3.n();
    }

    public static boolean e() {
        return jo6.p() && yi1.d();
    }
}
