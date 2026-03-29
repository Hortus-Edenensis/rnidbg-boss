package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.battery.BatterySaveConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ot0 {
    public static ot0 b = null;
    public static String c = "DaemOnConfigFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19866a = g("keep_alive", "");

    public static ot0 f() {
        if (b == null) {
            b = new ot0();
        }
        return b;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.optBoolean("opentype")) {
                return false;
            }
            String str2 = Build.MANUFACTURER;
            Log.d("baohuo", "itemConfig: " + str + "  systemType:" + str2);
            JSONArray jSONArray = jSONObject.getJSONArray("shieldBrand");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str2.equalsIgnoreCase(jSONArray.getString(i))) {
                    return false;
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean b(String str) {
        return c(str, true);
    }

    public boolean c(String str, boolean z) {
        boolean zA;
        Log.d("baohuo", "daemonisOpenByConfig = " + this.f19866a);
        if (TextUtils.isEmpty(this.f19866a)) {
            zA = true;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(this.f19866a);
                zA = !jSONObject.optBoolean("opentype") ? false : a(jSONObject.optString(str));
            } catch (JSONException e) {
                e.printStackTrace();
                zA = true;
            }
        }
        BatterySaveConfig batterySaveConfigB = ns.c().b();
        boolean z2 = ("getui".equals(str) && batterySaveConfigB.isGetuiSwitch()) || ("yuanbao".equals(str) && batterySaveConfigB.isYbaoSwitch()) || (("ziqidongbaoheSdk".equals(str) && batterySaveConfigB.isSelfSwitch()) || (("yaoshiSdk".equals(str) && batterySaveConfigB.isWkSwitch()) || (("jiguang".equals(str) && batterySaveConfigB.isJiguangSwitch()) || ("mob".equals(str) && batterySaveConfigB.isMobSwitch()))));
        boolean zH = h();
        boolean z3 = AppContext.getContext().isPrivacyAgreeBeforInit() || !z;
        Log.d("baohuo", "daemonisOpenByConfig: tpye = " + str + " isOpen " + zA + " bsm= " + z2 + " isBlackListModel=" + zH + " isPrivacyAgree=" + z3);
        return zA && !z2 && !zH && z3;
    }

    public final boolean d(String str, boolean z) {
        return AppContext.getContext().getSharedPreferences(c, 0).getBoolean(str, z);
    }

    public int e() {
        int iOptInt = 3600;
        if (!TextUtils.isEmpty(this.f19866a)) {
            try {
                iOptInt = new JSONObject(this.f19866a).optInt("wakeup_time", 3600);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d("baohuo", "daemonisOpenByConfig: getDaemonConfigPullWakeTime = " + iOptInt);
        return iOptInt;
    }

    public final String g(String str, String str2) {
        return AppContext.getContext().getSharedPreferences(c, 0).getString(str, str2);
    }

    public final boolean h() {
        String str = Build.MODEL;
        return "WDY-AN00".equals(str) || "KOZ-AL00".equals(str) || "KOZ-AL40".equals(str) || "PEFM00".equals(str);
    }

    public boolean i() {
        return d("configkey_wkdaemonasyncenable", false);
    }

    public final boolean j(String str, boolean z) {
        SharedPreferences.Editor editorEdit = AppContext.getContext().getSharedPreferences(c, 0).edit();
        editorEdit.putBoolean(str, z);
        return editorEdit.commit();
    }

    public void k() {
        String strI = ts0.o().i("keep_alive");
        boolean zO = ts0.o().O();
        if (!TextUtils.isEmpty(strI)) {
            l("keep_alive", strI);
        }
        j("configkey_wkdaemonasyncenable", zO);
    }

    public final boolean l(String str, String str2) {
        SharedPreferences.Editor editorEdit = AppContext.getContext().getSharedPreferences(c, 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }
}
