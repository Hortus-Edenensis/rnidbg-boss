package defpackage;

import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ko1 {
    public static String a(String str, String str2) {
        if (b()) {
            str = str2;
        }
        LogUtil.i("ExidProcessor", "getExidSupportUrl " + str);
        return str;
    }

    public static boolean b() {
        return true;
    }

    public static void c(String str) {
        String strI = r75.i(AppContext.getContext(), k86.a("sp_key_local_exid"));
        if (str != null && !str.equals(strI)) {
            ap4.u();
            r75.r(AppContext.getContext(), k86.a("sp_key_local_exid"), str);
        }
        LogUtil.i("ExidProcessor", "ResetSyncProcessor resetSyncOnLogin exid=" + str + " preexid =" + strI);
    }

    public static void d(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(bd.h);
            int iOptInt = jSONObject.optInt("sync");
            if (!TextUtils.isEmpty(strOptString)) {
                if (!strOptString.equals(str)) {
                    AccountUtils.C(strOptString);
                }
                if (iOptInt == 1) {
                    ap4.u();
                    r75.r(AppContext.getContext(), k86.a("sp_key_local_exid"), strOptString);
                }
            }
        }
        LogUtil.i("ExidProcessor", "ResetSyncProcessor updateLocalExidOnAkGet " + jSONObject + "currentExid = " + str);
    }
}
