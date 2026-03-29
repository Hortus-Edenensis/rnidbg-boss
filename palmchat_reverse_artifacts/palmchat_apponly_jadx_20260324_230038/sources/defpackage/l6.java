package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class l6 {
    public static l6 g = null;
    public static boolean h = true;
    public static boolean i = true;
    public static String[] j;
    public Runnable e = null;
    public final int f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f18912a = vw5.d("AdManager");
    public final Handler b = new Handler(c.b().getMainLooper());
    public final List<s7> c = new ArrayList();
    public final List<a> d = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s7 f18913a;
        public boolean b;

        public a() {
        }
    }

    public static boolean a() {
        return !"A".equals(ap3.a().n("LX-58414", "A"));
    }

    public static boolean b(String str, String str2, String str3) {
        return (ac1.f.equals(str) || "all".equals(str)) && (ac1.g.equals(str3) || "all".equals(str3)) && (ac1.m.equals(str2) || "all".equals(str2));
    }

    public static boolean c() {
        return fg6.d(c.b());
    }

    public static l6 d() {
        if (g == null) {
            synchronized (l6.class) {
                if (g == null) {
                    g = new l6();
                }
            }
        }
        return g;
    }

    public static boolean f(int i2) {
        if (!i) {
            return false;
        }
        if (ap3.s()) {
            return v5.o(i2);
        }
        LogUtil.d("", "isAdConfigOpen nestAdInitDone not allow scene " + i2);
        return false;
    }

    public static void h(String str, boolean z) {
        LogUtil.d("AdManager", "isAdConfigOpen updateConfig extra = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            i(z, jSONObject);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("switchList");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArrayOptJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("switch");
                    String string2 = jSONObject2.getString("version");
                    String string3 = jSONObject2.getString("channel");
                    String strOptString = jSONObject2.optString("versionName", "");
                    String strOptString2 = jSONObject2.optString("adScenes", "");
                    if (ac1.m.equals(string3) && ac1.f.equals(string2) && ac1.g.equals(strOptString)) {
                        if (!TextUtils.isEmpty(strOptString2)) {
                            try {
                                j = strOptString2.split(",");
                            } catch (Exception unused) {
                            }
                        }
                        h = !WkInteractiveManager.TimingTypeOff.equals(string);
                    } else {
                        i2++;
                    }
                }
            }
            LogUtil.d("AdManager", "isAdConfigOpen = " + h + ", mChannelId = " + ac1.m + ", mVersion = " + ac1.f + ", mVersionName = " + ac1.g + " mAdScenes " + j);
            if (j != null) {
                for (int i3 = 0; i3 < j.length; i3++) {
                    LogUtil.d("AdManager", "isAdConfigOpen i = " + i3 + " scene " + j[i3]);
                }
            }
        } catch (Exception e) {
            LogUtil.e("AdManager", "updateConfig exception = " + e);
        }
    }

    public static void i(boolean z, JSONObject jSONObject) {
        boolean z2 = true;
        try {
            i = true;
            if (!z || jSONObject == null) {
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("switchYouthList");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArrayOptJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String strOptString = jSONObject2.optString("switch");
                    String strOptString2 = jSONObject2.optString("version");
                    String strOptString3 = jSONObject2.optString("channel");
                    String strOptString4 = jSONObject2.optString("versionName");
                    LogUtil.d("AdManager", "config channel = " + strOptString3 + ", version = " + strOptString2 + ", versionName = " + strOptString4);
                    if (b(strOptString2, strOptString3, strOptString4)) {
                        if (WkInteractiveManager.TimingTypeOff.equals(strOptString)) {
                            z2 = false;
                        }
                        i = z2;
                    } else {
                        i2++;
                    }
                }
            }
            LogUtil.d("AdManager", "isAdYouthConfigOpen = " + i + ", mChannelId = " + ac1.m + ", mVersion = " + ac1.f + ", mVersionName = " + ac1.g);
        } catch (Exception e) {
            LogUtil.e("AdManager", "updateYouthConfig exception = " + e);
        }
    }

    public static boolean j(int i2) {
        if (i2 != 1 && i2 != 2 && i2 != 28 && i2 != 56 && i2 != 57 && i2 != 42 && i2 != 40 && i2 != 45 && i2 != 59 && i2 != 60 && i2 != 46 && i2 != 51 && i2 != 52 && i2 != 62 && i2 != 16 && i2 != 27 && i2 != 6 && i2 != 7 && i2 != 78 && i2 != 82 && i2 != 83 && i2 != 86 && i2 != 59) {
            return h;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("vip_no_ad_req", null, jSONObject.toString());
        return false;
    }

    public static void k(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("no_ad_click", null, jSONObject.toString());
        ap3.y(c.b(), i2 + "", "1");
    }

    public static void l(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("no_ad_show", null, jSONObject.toString());
    }

    public ExecutorService e() {
        return this.f18912a;
    }

    public void g(s7 s7Var, boolean z) {
        if (this.d != null) {
            a aVar = new a();
            aVar.f18913a = s7Var;
            aVar.b = z;
            this.d.add(aVar);
        }
    }
}
