package defpackage;

import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19285a = false;
    public static String b = "MineNestSdkManager";
    public static Boolean c;
    public static List<ou3> d = new ArrayList();
    public static String e = "";
    public static String f = "";
    public static int g = 3;

    public static String a() {
        String strC = jo6.c("LX-24769", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        LogUtil.i(b, "getPMTaichiValue " + strC);
        return strC;
    }

    public static void b() {
        f19285a = true;
    }

    public static void c(String str) {
        LogUtil.d(b, "updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
        try {
            e = new JSONObject(str).getString(a());
            LogUtil.d(b, "strategyJson = " + e);
        } catch (Exception unused) {
        }
    }

    public static void d() {
        LogUtil.d(b, "updateEnableWithTaichi strategyJson = " + e + ", configExtra =" + f);
        if (TextUtils.isEmpty(e) && !TextUtils.isEmpty(f)) {
            try {
                e = new JSONObject(f).getString(a());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("taichi", "LX-24769");
                    jSONObject.put("exp_group", a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                zn6.d("lx_client_nestad_getConfig", null, jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        boolean z = ("A".equals(a()) || "H".equals(a()) || TextUtils.isEmpty(e)) ? false : true;
        LogUtil.i(b, "updateEnableWithTaichi  isNestEnable " + z + ", strategyJson = " + e + ", getTaichiValue = " + a());
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_nest_mine_enable"), Boolean.valueOf(z));
        c = Boolean.valueOf(z);
    }
}
