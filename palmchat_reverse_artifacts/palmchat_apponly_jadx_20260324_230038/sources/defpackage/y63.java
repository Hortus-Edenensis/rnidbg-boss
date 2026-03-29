package defpackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.cdo.oaps.ad.wrapper.download.RedirectRespWrapper;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.app.WkConstants;
import com.lantern.auth.server.WkParams;
import com.lantern.auth.stub.WkSDKFeature;
import com.litesuits.async.AsyncTask;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.SocialContentProvider;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.modulemanager.LXModuleInitManager;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.HexDumper;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.support.SquareSingleton;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class y63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22131a = "y63";
    public static long b = 604800000;
    public static volatile y63 c = null;
    public static boolean d = false;
    public static boolean e = false;
    public static Map<String, Object> f = new HashMap();
    public static long g;
    public static long h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(y63.f22131a, volleyError.toString());
            y63.e = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22132a;

        public b(String str) {
            this.f22132a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(y63.f22131a, jSONObject.toString());
            y63.e = false;
            if (jSONObject.optInt("resultCode") == 0) {
                LogUtil.d(y63.f22131a, " uploadDeviceInfo success " + ac1.f);
                r75.o(AppContext.getContext(), this.f22132a, true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f22133a;
        public final /* synthetic */ long b;

        public c(JSONObject jSONObject, long j) {
            this.f22133a = jSONObject;
            this.b = j;
            put("action", WkSDKFeature.WHAT_LOGIN);
            put("status", "success");
            put("detail", jSONObject);
            put("duration", Long.valueOf(ir5.e(j)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f22134a;

        public d(o oVar) {
            this.f22134a = oVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(y63.f22131a, volleyError.toString());
            this.f22134a.onFail();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f22135a;

        public e(o oVar) {
            this.f22135a = oVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(y63.f22131a, jSONObject.toString());
            if (jSONObject.optInt("resultCode") == 0) {
                this.f22135a.onSuccess();
            } else {
                this.f22135a.onFail();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22136a;
        public final /* synthetic */ int b;

        public f(String str, int i) {
            this.f22136a = str;
            this.b = i;
            put("action", "request_sms");
            put("status", "start");
            put("phone_number", str);
            put("type", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22137a;
        public final /* synthetic */ int b;

        public g(String str, int i) {
            this.f22137a = str;
            this.b = i;
            put("action", "validate_sms");
            put("status", "start");
            put("phone_number", str);
            put("type", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {
        public h() {
            put("action", WkSDKFeature.WHAT_LOGIN);
            put("status", "start");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22138a;
        public final /* synthetic */ Response.ErrorListener b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", WkSDKFeature.WHAT_LOGIN);
                put("status", "fail");
                put("duration", Long.valueOf(ir5.e(i.this.f22138a)));
            }
        }

        public i(long j, Response.ErrorListener errorListener) {
            this.f22138a = j;
            this.b = errorListener;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(y63.f22131a, 3, new a(), (Throwable) null);
            Response.ErrorListener errorListener = this.b;
            if (errorListener != null) {
                errorListener.onErrorResponse(volleyError);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Response.Listener f22140a;

        public j(Response.Listener listener) {
            this.f22140a = listener;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            Response.Listener listener = this.f22140a;
            if (listener != null) {
                listener.onResponse(jSONObject);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f22141a;
        public final /* synthetic */ long b;

        public k(Exception exc, long j) {
            this.f22141a = exc;
            this.b = j;
            put("action", WkSDKFeature.WHAT_LOGIN);
            put("status", "fail");
            put("detail", exc.toString());
            put("duration", Long.valueOf(ir5.e(j)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends AsyncTask<Void, Void, Pair<JSONObject, byte[]>> {
        public final /* synthetic */ String m;
        public final /* synthetic */ boolean n;
        public final /* synthetic */ boolean o;
        public final /* synthetic */ CaptchaResult p;
        public final /* synthetic */ Response.ErrorListener q;
        public final /* synthetic */ Response.Listener r;
        public final /* synthetic */ String s;
        public final /* synthetic */ int t;
        public final /* synthetic */ int u;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", WkSDKFeature.WHAT_LOGIN);
                put("status", "start");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f22143a;

            /* JADX INFO: compiled from: SearchBox */
            public class a extends HashMap<String, Object> {
                public a() {
                    put("action", WkSDKFeature.WHAT_LOGIN);
                    put("status", "fail");
                    put("duration", Long.valueOf(ir5.e(b.this.f22143a)));
                }
            }

            public b(long j) {
                this.f22143a = j;
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                y63.h("lx_req_finish");
                LogUtil.i(y63.f22131a, 3, new a(), (Throwable) null);
                Response.ErrorListener errorListener = l.this.q;
                if (errorListener != null) {
                    errorListener.onErrorResponse(volleyError);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Response.Listener<JSONObject> {
            public c() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                y63.h("lx_req_finish");
                Response.Listener listener = l.this.r;
                if (listener != null) {
                    listener.onResponse(jSONObject);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Exception f22146a;
            public final /* synthetic */ long b;

            public d(Exception exc, long j) {
                this.f22146a = exc;
                this.b = j;
                put("action", WkSDKFeature.WHAT_LOGIN);
                put("status", "fail");
                put("detail", exc.toString());
                put("duration", Long.valueOf(ir5.e(j)));
            }
        }

        public l(String str, boolean z, boolean z2, CaptchaResult captchaResult, Response.ErrorListener errorListener, Response.Listener listener, String str2, int i, int i2) {
            this.m = str;
            this.n = z;
            this.o = z2;
            this.p = captchaResult;
            this.q = errorListener;
            this.r = listener;
            this.s = str2;
            this.t = i;
            this.u = i2;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Pair<JSONObject, byte[]> g(Void... voidArr) {
            byte[] bArrCipherWithHashKey;
            y63.h("params_sta");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authKey", this.m);
                jSONObject.put("channelId", ac1.m);
                jSONObject.put("deviceId", ac1.h);
                jSONObject.put("did", ac1.o);
                jSONObject.put("platform", ac1.c);
                jSONObject.put(az.aW, ac1.f);
                jSONObject.put("sourceWay", this.n ? "h5" : "wifi");
                jSONObject.put(WkParams.IMEI, ac1.i);
                jSONObject.put("mac", ac1.k);
                jSONObject.put("dhid", ac1.y());
                jSONObject.put("autoLogin", this.o ? "1" : "0");
                String strV = ac1.v();
                jSONObject.put("sdid", strV);
                LogUtil.i("SmidHelper", "login smid=" + strV);
                jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
                jSONObject.put("oneId", "");
                jSONObject.put("androidId", ac1.p);
                nz.b(jSONObject, this.p);
                jSONObject.put("ipInfo", vu2.c().d());
                if (!this.n) {
                    jSONObject.put("appId", eb4.b());
                }
                if (ts0.o().K()) {
                    jSONObject.put("dfp", fm1.k().toString());
                    jSONObject.put("appList", ac1.s());
                }
                LogUtil.i(y63.f22131a, "DeviceUtil.mDid: " + ac1.o);
                EncryptUtils.setLxData(jSONObject);
                EncryptUtils.createCKey();
                bArrCipherWithHashKey = EncryptUtils.cipherWithHashKey(jSONObject, 2, nl0.k());
            } catch (Throwable th) {
                th.printStackTrace();
                LogUtil.log4ClientError("authLogin", th);
                bArrCipherWithHashKey = null;
            }
            y63.h("params_finish");
            if (bArrCipherWithHashKey != null) {
                return new Pair<>(jSONObject, bArrCipherWithHashKey);
            }
            return null;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(Pair<JSONObject, byte[]> pair) {
            if (pair == null) {
                Response.ErrorListener errorListener = this.q;
                if (errorListener != null) {
                    errorListener.onErrorResponse(new VolleyError("encryptedBody is null"));
                    return;
                }
                return;
            }
            JSONObject jSONObject = (JSONObject) pair.first;
            byte[] bArr = (byte[]) pair.second;
            y63.h("lx_req_sta");
            long jB = ir5.b();
            LogUtil.i(y63.f22131a, 3, new a(), (Throwable) null);
            b bVar = new b(jB);
            c cVar = new c();
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            try {
                String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
                String strE0 = k86.e0(nl0.n + (!this.n ? WkConstants.LxLoginConst.API_AUTH_TOKEN : "/webuic/auth/v14/auth_login.json"), this.s, Integer.toString(this.t), Integer.toString(this.u));
                LogUtil.i(y63.f22131a, strE0);
                EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strE0, bArr, jSONObject, 1, cVar, bVar);
                encryptedJsonRequest.addHeader("Content-CKey", hexString);
                encryptedJsonRequest.addHeader("Content-CKey-Version", EncryptUtils.getCkVersion());
                encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
                normalRequestQueue.add(encryptedJsonRequest);
            } catch (Exception e) {
                Response.ErrorListener errorListener2 = this.q;
                if (errorListener2 != null) {
                    errorListener2.onErrorResponse(null);
                }
                e.printStackTrace();
                LogUtil.i(y63.f22131a, 3, new d(e, jB), (Throwable) null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(y63.f22131a, volleyError.toString());
            y63.d = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22147a;

        public n(String str) {
            this.f22147a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            y63.d = false;
            if (jSONObject != null) {
                LogUtil.d(y63.f22131a, jSONObject.toString());
                if (jSONObject.optInt("resultCode") == 0) {
                    LogUtil.d(y63.f22131a, " uploadDeviceInfo success " + ac1.f);
                    r75.q(AppContext.getContext(), this.f22147a, ir5.b());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface o {
        void onFail();

        void onSuccess();
    }

    public static void A(JSONObject jSONObject) {
        if (jSONObject.optInt("resultCode") == 0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            AppContext.setSecretKey(jSONObjectOptJSONObject.optString("skey"), jSONObjectOptJSONObject.optString("iv"));
        }
    }

    public static void B(boolean z, String str, String str2) {
        if (d) {
            return;
        }
        String str3 = "last_update_dfp_applist_time_" + ac1.f + str;
        boolean z2 = Math.abs(System.currentTimeMillis() - r75.h(AppContext.getContext(), str3)) >= b;
        if (z || z2) {
            new l56(new n(str3), new m(), str, str2).q();
            d = true;
        }
    }

    public static void C(boolean z) {
        String str = f22131a;
        LogUtil.i(str, "uploadDeviceInfo1 isManualLogin =" + z + " isUploadingDeviceInfo=" + e);
        if (e) {
            return;
        }
        String str2 = "upload_device_info_" + ac1.f;
        boolean zD = r75.d(AppContext.getContext(), str2, false);
        if (z || !zD) {
            LogUtil.i(str, "uploadDeviceInfo2 isManualLogin =" + z + " isCurrentVersionDeviceInfoUploaded=" + zD);
            m(new a(), new b(str2), zD ^ true);
            e = true;
        }
    }

    public static String d(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return str;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        try {
            return k86.b0(str, jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG), jSONObjectOptJSONObject.optString(WkParams.SESSIONID));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static void e(boolean z, String str, String str2, CaptchaResult captchaResult, int i2, int i3, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener, boolean z2) {
        new l(str, z, z2, captchaResult, errorListener, listener, str2, i2, i3).h(new Void[0]);
    }

    public static void f(String str, String str2, String str3, int i2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        try {
            String str4 = wm0.f + "?phone=" + str2;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ic", str3);
            jSONObject.put("phone", str2);
            jSONObject.put("type", i2);
            jSONObject.put(WkParams.SESSIONID, str);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, str4, jSONObject, 1, false, listener, errorListener);
            encryptedJsonRequest.addHeader("Content-CKey", hexString);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            VolleyNetwork.getNormalRequestQueue().add(encryptedJsonRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void g(Context context) {
        r75.r(context, "SP_LOGIN_INFO_FOR_MEND_PROFILE", "");
    }

    public static void h(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        f.put(str + "_part", Long.valueOf(jCurrentTimeMillis - h));
        f.put(str + "_duration", Long.valueOf(jCurrentTimeMillis - g));
        h = jCurrentTimeMillis;
    }

    public static JSONObject i() {
        try {
            return new JSONObject(f);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public static y63 j() {
        if (c == null) {
            synchronized (y63.class) {
                if (c == null) {
                    c = new y63();
                }
            }
        }
        return c;
    }

    public static JSONObject k(Context context) {
        String strI = r75.i(context, "SP_LOGIN_INFO_FOR_MEND_PROFILE");
        if (!TextUtils.isEmpty(strI)) {
            try {
                return new JSONObject(new String(EncryptUtils.cipherWithType(mh2.a(strI.toCharArray()), 7, nl0.k())));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject.optInt("resultCode", -1) != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG);
    }

    public static void m(Response.ErrorListener errorListener, Response.Listener<JSONObject> listener, boolean z) {
        int iIntValue;
        m56 m56Var = new m56(listener, errorListener);
        JSONObject jSONObject = new JSONObject();
        String strI = r75.i(AppContext.getContext(), "sp_last_version_code");
        try {
            iIntValue = Integer.valueOf(strI).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            iIntValue = 0;
        }
        int i2 = z ? iIntValue == 0 ? 2 : 1 : 0;
        try {
            jSONObject.put("upgrade", i2);
            jSONObject.put("localOldVersionCode", strI);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        LogUtil.i(f22131a, "iUploadDeviceInfo upgrade =" + i2 + " localOldVersionCode=" + strI);
        m56Var.p(jSONObject);
    }

    public static boolean n(Context context) {
        String strP;
        ContactInfoItem contactInfoItemL;
        if (context == null) {
            context = AppContext.getContext();
        }
        if (!AccountUtils.r(context) || (strP = AccountUtils.p(context)) == null) {
            return false;
        }
        if (r75.d(context, strP + "profile_mended", false) || (contactInfoItemL = bo0.r().l(strP)) == null) {
            return false;
        }
        return il5.p(contactInfoItemL.getNickName()) || il5.p(contactInfoItemL.getBigIconURL()) || il5.p(contactInfoItemL.getIconURL());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            z = false;
        } else {
            String strOptString = jSONObjectOptJSONObject.optString("nickname");
            String strOptString2 = jSONObjectOptJSONObject.optString("headImgUrl");
            String strOptString3 = jSONObjectOptJSONObject.optString("headIconUrl");
            if (il5.p(strOptString) || il5.p(strOptString2) || il5.p(strOptString3)) {
                z = true;
            }
        }
        return z;
    }

    public static void p(String str, String str2, String str3, String str4, Response.ErrorListener errorListener, Response.Listener<JSONObject> listener) {
        long jB = ir5.b();
        LogUtil.i(f22131a, 3, new h(), (Throwable) null);
        i iVar = new i(jB, errorListener);
        j jVar = new j(listener);
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        try {
            JSONObject jSONObject = new JSONObject();
            if (str4.equals("0")) {
                jSONObject.put("ic", str);
            }
            jSONObject.put("account", str2);
            jSONObject.put("pwd", EncryptUtils.digestString(str3));
            jSONObject.put("ctype", str4);
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("platform", ac1.c);
            jSONObject.put(az.aW, ac1.f);
            EncryptUtils.setLxData(jSONObject);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, wm0.b + "?account=" + str2, EncryptUtils.cipherWithHashKey(jSONObject, 2, nl0.k()), jSONObject, 1, jVar, iVar);
            encryptedJsonRequest.addHeader("Content-CKey", hexString);
            encryptedJsonRequest.addHeader("Content-CKey-Version", EncryptUtils.getCkVersion());
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(encryptedJsonRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtil.i(f22131a, 3, new k(e2, jB), (Throwable) null);
        }
    }

    public static int q(JSONObject jSONObject, String str, String str2) {
        int iOptInt = jSONObject.optInt("resultCode");
        if (iOptInt == 0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString = jSONObjectOptJSONObject.optString(DeviceInfoUtil.UID_TAG);
            String strOptString2 = jSONObjectOptJSONObject.optString(bd.h);
            String strOptString3 = jSONObjectOptJSONObject.optString("ic");
            String strOptString4 = jSONObjectOptJSONObject.optString("nickname");
            String strOptString5 = jSONObjectOptJSONObject.optString("headIconUrl");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("newUser", 1);
            String str3 = !TextUtils.isEmpty(strOptString3) ? strOptString3 : str;
            String strOptString6 = jSONObjectOptJSONObject.optString("phone");
            String str4 = !TextUtils.isEmpty(strOptString6) ? strOptString6 : str2;
            if (r75.d(AppContext.getContext(), "is_first_launch", true)) {
                r75.o(AppContext.getContext(), "is_first_launch", false);
            }
            String strOptString7 = jSONObjectOptJSONObject.optString("skey");
            String strOptString8 = jSONObjectOptJSONObject.optString("iv");
            if (!TextUtils.isEmpty(strOptString7)) {
                AppContext.setSecretKey(strOptString7, strOptString8);
            }
            String strOptString9 = jSONObjectOptJSONObject.optString(WkParams.SESSIONID);
            String strOptString10 = jSONObjectOptJSONObject.optString("refreshKey");
            SocialContentProvider.l(strOptString);
            rl0.h().a(strOptString);
            v4.j(new s4(strOptString, strOptString2, strOptString9, strOptString10, str3, str4, strOptString4));
            tq3.e().l(strOptString);
            jSONObjectOptJSONObject.remove("skey");
            jSONObjectOptJSONObject.remove("iv");
            jSONObjectOptJSONObject.remove(WkParams.SESSIONID);
            jSONObjectOptJSONObject.remove("refreshKey");
            try {
                Uri uriInsert = AppContext.getContext().getContentResolver().insert(ho0.f18003a, co0.b(true, jSONObjectOptJSONObject, 1));
                r75.r(AppContext.getContext(), "last_login_user_info", jSONObjectOptJSONObject.toString());
                iOptInt = uriInsert == null ? 1203 : 0;
            } catch (IllegalArgumentException e2) {
                LogUtil.i(f22131a, "IllegalArgumentException e = " + e2);
                iOptInt = iOptInt;
            }
            r75.o(AppContext.getContext(), "update_user", true);
            ko1.c(strOptString2);
            t34.f(t34.e(jSONObjectOptJSONObject.optString("ext")));
            AppContext.getContext().getTrayPreferences().f(k86.w(), jSONObjectOptJSONObject.optInt("privacyConfig"));
            LogUtil.d(f22131a, "profileData = " + jSONObjectOptJSONObject.toString() + ", mode =" + jSONObjectOptJSONObject.optInt("mode"));
            AppContext.getContext().getTrayPreferences().f(k86.s(), jSONObjectOptJSONObject.optInt("mode"));
            SquareSingleton.getInstance().onLogin(jSONObjectOptJSONObject.optInt("guide", -1));
            if (jSONObjectOptJSONObject.has("kidsModeCfg")) {
                TeenagersModeManager.a().f(jSONObjectOptJSONObject.optInt("kidsModeCfg"));
            }
            C(true);
            if (r75.d(AppContext.getContext(), "uploadInMendPhoto", false)) {
                r75.o(AppContext.getContext(), "uploadInMendPhoto", false);
            } else if (!ts0.o().K()) {
                B(true, AccountUtils.p(AppContext.getContext()), null);
            }
            r75.o(AppContext.getContext(), k86.a("is_first_login"), iOptInt2 == 0);
            if (iOptInt2 == 0) {
                r75.o(AppContext.getContext(), "sp_show_bottle_group", false);
            }
            int i2 = (TextUtils.isEmpty(strOptString4) || TextUtils.isEmpty(strOptString5)) ? 0 : iOptInt2;
            r75.p(AppContext.getContext(), k86.a("is_new_user"), i2);
            r75.o(AppContext.getContext(), "sp_show_nearby_fake_badge", i2 == 0);
            SPUtil sPUtil = SPUtil.f14322a;
            sPUtil.t(SPUtil.SCENE.CONTACT, k86.a("key_new_user"), Boolean.valueOf(i2 == 0));
            if (i2 == 0) {
                sPUtil.t(SPUtil.SCENE.NOTIFY_GUIDE, k86.a("key_new_user_register_time"), Long.valueOf(ir5.b()));
            }
        }
        fg6.k(AppContext.getContext(), null);
        LXModuleInitManager.getInstance().onLogin();
        LogUtil.i(f22131a, 3, new c(jSONObject, ir5.b()), (Throwable) null);
        return iOptInt;
    }

    public static void s(String str, String str2, String str3, String str4, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.MAP_KEY_UUID, str);
            jSONObject.put("ic", str2);
            jSONObject.put("phone", str3);
            jSONObject.put("pwd", EncryptUtils.digestString(str4));
            jSONObject.put(RedirectRespWrapper.KEY_VERCODE, ac1.f);
            jSONObject.put("platform", ac1.c);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, wm0.g, jSONObject, 1, false, listener, errorListener);
            encryptedJsonRequest.addHeader("Content-CKey", hexString);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            VolleyNetwork.getNormalRequestQueue().add(encryptedJsonRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void t() {
        f.clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        g = jCurrentTimeMillis;
        h = jCurrentTimeMillis;
    }

    public static void u(String str, String str2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(r75.i(AppContext.getContext(), "last_login_user_info"));
            jSONObject.put("headIconUrl", str2);
            jSONObject.put("headImgUrl", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            r75.r(AppContext.getContext(), "last_login_user_info", jSONObject.toString());
        }
    }

    public static void v(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject != null) {
                    jSONObjectOptJSONObject.remove("skey");
                    jSONObjectOptJSONObject.remove("iv");
                    r75.r(context, "SP_LOGIN_INFO_FOR_MEND_PROFILE", mh2.e(EncryptUtils.cipherWithType(jSONObject.toString().getBytes(), 6, nl0.k())));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void w(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Response.ErrorListener errorListener, Response.Listener<String> listener) {
        RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.MAP_KEY_UUID, str);
            jSONObject.put("ic", str2);
            jSONObject.put("phone", str3);
            jSONObject.put("name", URLEncoder.encode(str4, "utf-8"));
            jSONObject.put("pwd", str5);
            jSONObject.put(RedirectRespWrapper.KEY_VERCODE, str6);
            jSONObject.put("platform", str8);
            EncryptUtils.createCKey();
            String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
            byte[] bArrCipherWithType = EncryptUtils.cipherWithType(jSONObject.toString().getBytes(), 2, nl0.k());
            rs3 rs3Var = new rs3(wm0.f21749a + "?phone=" + str3, errorListener, listener, !TextUtils.isEmpty(str7) ? new File(str7) : null, "headImg", new HashMap(), null, "AES/ECB/PKCS5Padding", 1);
            rs3Var.b("userInfo", bArrCipherWithType);
            rs3Var.addHeader("Content-CKey", hexString);
            rs3Var.addHeader("Content-Encrypted-ZX", "1");
            rs3Var.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            normalRequestQueue.add(rs3Var);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x() {
        String[] strArr;
        String[] stringArray = AppContext.getContext().getResources().getStringArray(R.array.contacts_resources);
        String strP = AccountUtils.p(AppContext.getContext());
        String strGenerateMessageToken = EncryptUtils.generateMessageToken();
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            int i3 = 0;
            while (i3 < 10) {
                try {
                    RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
                    String str = "126001" + Integer.valueOf((i2 * 100) + i3);
                    String str2 = stringArray[i2] + i3;
                    strArr = stringArray;
                    try {
                        w("123456", "+86", str, str2, EncryptUtils.digestString("123456"), String.valueOf(k86.C()), "media_pick_photo_key", "android", requestFutureNewFuture, requestFutureNewFuture);
                        String str3 = (String) requestFutureNewFuture.get(5000L, TimeUnit.MILLISECONDS);
                        if (new JSONObject(str3).optInt("resultCode") == 0) {
                            LogUtil.d(f22131a, "sign up number " + str + " nickeName " + str2);
                        } else {
                            LogUtil.d(f22131a, "sign up number error " + str + "\n" + str3);
                        }
                        RequestFuture requestFutureNewFuture2 = RequestFuture.newFuture();
                        try {
                            VolleyNetwork.getNormalRequestQueue().add(new StringRequest(0, (nl0.n + "/friend/v1/add_friends.json") + "?uid=" + strP + "&token=" + URLEncoder.encode(strGenerateMessageToken, "utf-8") + "&phone=" + AccountUtils.k(AppContext.getContext()) + "&fphone=" + str + "&ic1=86&ic2=86", requestFutureNewFuture2, requestFutureNewFuture2));
                            String str4 = (String) requestFutureNewFuture2.get();
                            if (new JSONObject(str4).getInt("resultCode") == 0) {
                                LogUtil.d(f22131a, "add friend number " + str);
                            } else {
                                LogUtil.d(f22131a, "add friend  error " + str + "\n" + str4);
                            }
                        } catch (Exception unused) {
                            LogUtil.d(f22131a, "sign up number exception ");
                        }
                    } catch (Exception unused2) {
                        LogUtil.d(f22131a, "sign up number exception ");
                        i3++;
                        stringArray = strArr;
                    }
                } catch (Exception unused3) {
                    strArr = stringArray;
                }
                i3++;
                stringArray = strArr;
            }
        }
    }

    public static void y(JSONObject jSONObject, o oVar) {
        d dVar = new d(oVar);
        try {
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, d(jSONObject, nl0.z + "/uac.unFreeze.v1"), new JSONObject(), new e(oVar), dVar);
            encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            VolleyNetwork.getNormalRequestQueue().add(encryptedJsonRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            oVar.onFail();
        }
    }

    public static void z(String str) {
        r75.q(AppContext.getContext(), "last_update_dfp_applist_time_" + ac1.f + str, ir5.b());
    }

    public void D(String str, String str2, int i2, String str3, String str4, gs gsVar) {
        LogUtil.i(f22131a, 3, new g(str2, i2), (Throwable) null);
        qf5.b(str, str2, i2, str3, str4, gsVar);
    }

    public void r(String str, String str2, int i2, gs gsVar) {
        LogUtil.i(f22131a, 3, new f(str2, i2), (Throwable) null);
        qf5.a(str, str2, i2, gsVar);
    }
}
