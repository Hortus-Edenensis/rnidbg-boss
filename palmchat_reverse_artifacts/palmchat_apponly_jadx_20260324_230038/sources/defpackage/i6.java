package defpackage;

import android.text.TextUtils;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f18111a;

    public static boolean a(String str) {
        Exception e;
        int i;
        String[] strArrSplit;
        if (f18111a != null && !TextUtils.isEmpty(str)) {
            try {
                String strE = v4.e(c.b());
                if (!TextUtils.isEmpty(strE)) {
                    i = (int) ((Long.parseLong(strE) / 16384) % 100);
                    try {
                        String strOptString = f18111a.optString(str);
                        if (!TextUtils.isEmpty(strOptString)) {
                            if (BeiZiBiddingConstant.Adn.ADN_OTHER.equals(strOptString)) {
                                LogUtil.d("", "AdEventManager checkAllowEvent 9999 not allow eventId " + str);
                            } else {
                                String[] strArrSplit2 = strOptString.split(",");
                                if (strArrSplit2 != null && strArrSplit2.length > 0) {
                                    for (String str2 : strArrSplit2) {
                                        if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.split("-")) != null) {
                                            int i2 = Integer.parseInt(strArrSplit[0]);
                                            int i3 = Integer.parseInt(strArrSplit[1]);
                                            if (i >= i2 && i <= i3) {
                                                LogUtil.d("", "AdEventManager checkAllowEvent check allow eventId " + str + " target " + i + " result true  min " + i2 + " max " + i3);
                                                return true;
                                            }
                                        }
                                    }
                                }
                                LogUtil.d("", "AdEventManager checkAllowEvent check not allow eventId " + str + " target " + i);
                            }
                            return false;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        LogUtil.d("", "AdEventManager checkAllowEvent check Exception eventId " + str + " target " + i + " " + e.toString());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                i = 0;
            }
        }
        return true;
    }

    public static void b(String str) {
        try {
            f18111a = new JSONObject(str);
            LogUtil.d("", "AdEventManager initConfig ext " + str);
        } catch (JSONException unused) {
        }
    }
}
