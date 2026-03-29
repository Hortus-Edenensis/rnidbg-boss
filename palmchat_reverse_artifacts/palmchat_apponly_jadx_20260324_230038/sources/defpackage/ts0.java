package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.chat.config.FamilyGroupConfig;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ts0 {
    public static final String e = "ts0";
    public static ts0 f;
    public static final String g = nl0.b + "/appcfg/DHIDConfig/get";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f21049a = null;
    public Boolean b = null;
    public JSONObject c;
    public long d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21050a;

        public a(Context context) {
            this.f21050a = context;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() > 0) {
                Log.i(ts0.e, "update = " + jSONObject.toString());
                synchronized (ts0.this) {
                    ts0.this.c = jSONObject;
                }
                SharedPreferences.Editor editorEdit = xp3.c("ly_dhid_config").edit();
                editorEdit.putString(com.igexin.push.core.b.Y, jSONObject.toString());
                editorEdit.putLong("last_update_time", ts0.this.d);
                editorEdit.apply();
                ch.s().L();
                ts0.this.Q();
            }
            if (ts0.this.M()) {
                q35.b().i(this.f21050a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21051a;

        public b(Context context) {
            this.f21051a = context;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            volleyError.printStackTrace();
            LogUtil.i(ts0.e, "onErrorResponse:" + volleyError.getMessage());
            if (ts0.this.M()) {
                q35.b().i(this.f21051a);
            }
        }
    }

    public static ts0 o() {
        if (f == null) {
            synchronized (ts0.class) {
                if (f == null) {
                    f = new ts0();
                }
            }
        }
        return f;
    }

    public synchronized JSONObject A() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("ServicePerceptionAndroid") : null;
    }

    public JSONObject B() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("squareFeedCardInChat");
        }
        return null;
    }

    @Nullable
    public JSONObject C() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null || !jSONObject.has("vas")) {
            return null;
        }
        try {
            return this.c.getJSONObject("vas");
        } catch (JSONException unused) {
            return null;
        }
    }

    public synchronized String D() {
        String strOptString;
        strOptString = WkAdxAdConfigMg.DSP_NAME_BAIDU;
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("verifyCodeAB", WkAdxAdConfigMg.DSP_NAME_BAIDU);
        }
        return strOptString.toUpperCase();
    }

    public JSONObject E() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("vipCenter");
        }
        return null;
    }

    public JSONObject F() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("vip_gift_config");
        }
        return null;
    }

    public JSONObject G() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("vip_config");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean H() {
        boolean z;
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            z = jSONObject.length() > 0;
        }
        return z;
    }

    public void I(Context context) {
        xp3 xp3VarC = xp3.c("ly_dhid_config");
        try {
            this.d = xp3VarC.getLong("last_update_time", 0L);
            String string = xp3VarC.getString(com.igexin.push.core.b.Y, "");
            if (!TextUtils.isEmpty(string)) {
                this.c = new JSONObject(string);
            }
            Q();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public synchronized boolean J() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optBoolean("WFLoginOn") : false;
    }

    public synchronized boolean K() {
        if (this.f21049a == null) {
            this.f21049a = Boolean.TRUE;
            JSONObject jSONObject = this.c;
            if (jSONObject != null) {
                this.f21049a = Boolean.valueOf(jSONObject.optBoolean("LoginWithDfp", true));
            }
        }
        return this.f21049a.booleanValue();
    }

    public synchronized boolean L() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optBoolean("msg_label_group_switch", true) : true;
    }

    public synchronized boolean M() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optBoolean("openScreen", false) : false;
    }

    public synchronized boolean N() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optBoolean("syncReset") : false;
    }

    public synchronized boolean O() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optBoolean("wkDaemonAsyncEnable") : false;
    }

    public boolean P(Context context) {
        String strOptString;
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - this.d) <= 600000 || !ap3.a().i()) {
                return false;
            }
            this.d = jCurrentTimeMillis;
            JSONObject jSONObject = this.c;
            long jOptLong = 0;
            if (jSONObject != null) {
                jOptLong = jSONObject.optLong("currentVersion", 0L);
                strOptString = this.c.optString("currentArea");
            } else {
                strOptString = null;
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            String strY = y(String.valueOf(jOptLong), strOptString);
            LogUtil.i(e, "update url:" + strY);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, strY, null, new a(context), new b(context));
            jsonObjectRequest.addHeader(Request.HEADER_RUN_IN_THREAD, "1");
            normalRequestQueue.add(jsonObjectRequest);
            return true;
        }
    }

    public void Q() {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject = this.c;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("officialUids")) == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                hashSet.add(strOptString);
            }
        }
        r54.a(hashSet);
    }

    public synchronized int c() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optInt("activeDay", 0) : 0;
    }

    public synchronized JSONObject d() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("batteryCanary") : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized JSONObject e() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = this.c;
        if (jSONObject2 == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject("Channel")) == null) {
            jSONObject = null;
        } else {
            String strH = jSONObjectOptJSONObject.has(c.j().h()) ? c.j().h() : jSONObjectOptJSONObject.has(ac1.m) ? ac1.m : "";
            if (!il5.l(strH)) {
                String strOptString = jSONObjectOptJSONObject.optString(strH);
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        jSONObject = new JSONObject(strOptString);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        jSONObject = null;
                        return jSONObject;
                    }
                }
            }
        }
        return jSONObject;
    }

    public JSONObject f() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("chatGiftConfig");
        }
        return null;
    }

    public JSONObject g() {
        return this.c;
    }

    public synchronized JSONObject h() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("ButtonLabel") : null;
    }

    public String i(String str) {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optString(str);
        }
        return null;
    }

    public synchronized JSONObject j() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("dynamicMainTab") : null;
    }

    public FamilyGroupConfig k() {
        JSONObject jSONObject = this.c;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("family_group") : null;
        if (jSONObjectOptJSONObject == null) {
            return new FamilyGroupConfig();
        }
        FamilyGroupConfig familyGroupConfig = (FamilyGroupConfig) az2.a(jSONObjectOptJSONObject.toString(), FamilyGroupConfig.class);
        return familyGroupConfig == null ? new FamilyGroupConfig() : familyGroupConfig;
    }

    public String l() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        String str = nl0.c + "/help/faq/index.html";
        if (!jo6.a("LX-25706", false) || (jSONObject = this.c) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("h5url")) == null) {
            return str;
        }
        String strOptString = jSONObjectOptJSONObject.optString("help");
        return !TextUtils.isEmpty(strOptString) ? strOptString : str;
    }

    public synchronized JSONObject m() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("contactInfo") : null;
    }

    public JSONObject n() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("permissionget");
        }
        return null;
    }

    public synchronized String p() {
        String str;
        str = "内容不见了，换一个看看吧";
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("jue_error", "");
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString;
            }
        }
        return str;
    }

    public synchronized JSONObject q() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("loginPage") : null;
    }

    public synchronized JSONObject r() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("msg_label_jcgroup") : null;
    }

    public JSONObject s() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgtab_function_android");
        }
        return null;
    }

    public String t() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        String str = nl0.c + "/help/notify/index.html";
        if (!jo6.a("LX-25706", false) || (jSONObject = this.c) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("h5url")) == null) {
            return str;
        }
        String strOptString = jSONObjectOptJSONObject.optString("notify");
        return !TextUtils.isEmpty(strOptString) ? strOptString : str;
    }

    public synchronized JSONObject u() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("personalizedAndroid") : null;
    }

    public JSONObject v() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("privacyAgreementConfig");
        }
        return null;
    }

    public JSONObject w() {
        if (this.c != null) {
            return jo6.H() ? this.c.optJSONObject("privatechat_new") : this.c.optJSONObject("privatechat");
        }
        return null;
    }

    public synchronized JSONObject x() {
        JSONObject jSONObject;
        jSONObject = this.c;
        return jSONObject != null ? jSONObject.optJSONObject("regProfile") : null;
    }

    public final String y(String str, String str2) {
        Uri.Builder builderBuildUpon = Uri.parse(g).buildUpon();
        builderBuildUpon.appendQueryParameter("dhid", ac1.h);
        builderBuildUpon.appendQueryParameter("version", str);
        builderBuildUpon.appendQueryParameter("privacyAgreementVersion", String.valueOf(2));
        if (!TextUtils.isEmpty(str2)) {
            builderBuildUpon.appendQueryParameter("currentArea", str2);
        }
        return builderBuildUpon.build().toString();
    }

    public JSONObject z() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("selfsdk_frequency");
        }
        return null;
    }
}
