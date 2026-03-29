package com.zenmen.palmchat.utils.captcha;

import android.app.Activity;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.utils.HexDumper;
import defpackage.ac1;
import defpackage.k86;
import defpackage.mz;
import defpackage.zn6;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CaptchaManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum Scene {
        LOGIN_GENDER,
        LOGIN_OCCUPATION,
        LOGIN_INCOME,
        LOGIN_INTENTION,
        LOGIN_NAME
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, CaptchaResult captchaResult);
    }

    public static String a(String str) {
        try {
            return HexDumper.toHexString(k86.f(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(int i, String str, mz mzVar) {
        HashMap map = new HashMap();
        map.put("androidId", ac1.p);
        map.put("sdid", ac1.v());
        map.put("failCode", String.valueOf(i));
        map.put("failInfo", String.valueOf(str));
        map.put("process", !TextUtils.isEmpty(mzVar.f19394a) ? "1" : "0");
        if (!TextUtils.isEmpty(mzVar.f19394a)) {
            map.put(DeviceInfoUtil.UID_TAG, mzVar.f19394a);
        } else if (!TextUtils.isEmpty(mzVar.b)) {
            map.put("phone", a(mzVar.b));
        }
        zn6.i("client_dot_verif_smserver", map);
    }

    public static void c(Activity activity, mz mzVar, a aVar) {
        if (activity.isFinishing()) {
            return;
        }
        d(activity, mzVar, aVar);
    }

    public static void d(Activity activity, mz mzVar, a aVar) {
        try {
            zn6.b("robotcheck");
            new com.zenmen.palmchat.utils.captcha.a(activity, mzVar, aVar).show();
        } catch (Exception e) {
            b(0, e.toString(), mzVar);
        }
    }
}
