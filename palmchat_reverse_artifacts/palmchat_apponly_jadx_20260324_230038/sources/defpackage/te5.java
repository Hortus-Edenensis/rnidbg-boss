package defpackage;

import com.android.volley.Response;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class te5 {
    public static String b = "SliderManager";
    public static volatile te5 c = null;
    public static String d = "57595070";
    public static String e = "71394288";
    public static String f = "46781275";
    public static String g = "74906897";
    public static String h = "04224683";
    public static String i = "58875374";
    public static String j = nl0.b + "/bizh5/sliderlock/index.html?id=";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public se5 f20972a;

    public static te5 a() {
        if (c == null) {
            synchronized (tq3.class) {
                if (c == null) {
                    c = new te5();
                }
            }
        }
        return c;
    }

    public String b(int i2) {
        if (Locale.getDefault().getLanguage().toString().equals("zh")) {
            return j + i2 + "&iszh=1";
        }
        return j + i2 + "&iszh=0";
    }

    public void c(String str, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener) {
        LogUtil.i(b, "isSliderShow sceneId = " + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sceneId", str);
            jSONObject.put(az.aW, ac1.f);
            jSONObject.put("deviceName", ac1.b);
            jSONObject.put("platform", ac1.c);
            jSONObject.put("osVersion", ac1.e);
            jSONObject.put("channelId", ac1.m);
            jSONObject.put("versionName", ac1.g);
            se5 se5Var = new se5(listener, errorListener, jSONObject);
            this.f20972a = se5Var;
            se5Var.n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }
}
