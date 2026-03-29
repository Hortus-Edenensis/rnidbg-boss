package defpackage;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.HexDumper;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final String e = "c";
    public static c f;
    public static final String g = nl0.j + "/outerchannel/qryAdContent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1859a = false;
    public String b;
    public String c;
    public long d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1860a;

        public a(e eVar) {
            this.f1860a = eVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            volleyError.printStackTrace();
            LogUtil.i(c.e, "onErrorResponse:" + volleyError.getMessage());
            c.this.o(false, volleyError.getMessage(), null, null);
            e eVar = this.f1860a;
            if (eVar != null) {
                eVar.onFinish();
            }
            c.this.f1859a = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1861a;

        public b(e eVar) {
            this.f1861a = eVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject != null) {
                LogUtil.i(c.e, "onResponse = " + jSONObject.toString());
                int iOptInt = jSONObject.optInt("resultCode");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (iOptInt != 0 || jSONObjectOptJSONObject == null) {
                    c.this.o(false, jSONObject.optString(MediationConstant.KEY_ERROR_MSG), null, null);
                } else {
                    c.this.b = jSONObjectOptJSONObject.optString("oldChannel");
                    c.this.c = jSONObjectOptJSONObject.optString("adContentUrl");
                    SharedPreferences.Editor editorEdit = AppContext.getContext().getSharedPreferences("lx_ad_config", 0).edit();
                    editorEdit.putString("lx_ad_channel", c.this.b);
                    editorEdit.putString("lx_ad_deeplink", c.this.c);
                    editorEdit.putLong("lx_last_ad_update_time", c.this.d);
                    editorEdit.apply();
                    c cVar = c.this;
                    cVar.o(true, null, cVar.b, c.this.c);
                }
            }
            e eVar = this.f1861a;
            if (eVar != null) {
                eVar.onFinish();
            }
            c.this.f1859a = false;
        }
    }

    /* JADX INFO: renamed from: c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0029c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1862a;

        public RunnableC0029c(e eVar) {
            this.f1862a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f1862a;
            if (eVar != null) {
                eVar.onFinish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1863a;
        public final /* synthetic */ String b;

        public d(boolean z, String str) {
            this.f1863a = z;
            this.b = str;
            put("result", z ? "success" : "fail");
            put("adContent", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void onFinish();
    }

    public c() {
        SharedPreferences sharedPreferences = AppContext.getContext().getSharedPreferences("lx_ad_config", 0);
        this.d = sharedPreferences.getLong("lx_last_ad_update_time", 0L);
        this.b = sharedPreferences.getString("lx_ad_channel", "NoneAD");
        this.c = sharedPreferences.getString("lx_ad_deeplink", null);
    }

    public static c j() {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    f = new c();
                }
            }
        }
        return f;
    }

    public String h() {
        return this.b;
    }

    public long i() {
        return this.d;
    }

    public final boolean k(FrameworkBaseActivity frameworkBaseActivity, String str) {
        boolean zD;
        try {
            zD = d73.d(frameworkBaseActivity, str, true);
            if (zD) {
                return zD;
            }
            try {
                Pair<Integer, ContentValues> pairG = mb4.g(str);
                return pairG != null ? d73.e(frameworkBaseActivity, false, ((Integer) pairG.first).intValue(), (ContentValues) pairG.second, str, null) : zD;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return zD;
            }
        } catch (Exception e3) {
            e = e3;
            zD = false;
        }
    }

    public boolean l(FrameworkBaseActivity frameworkBaseActivity) {
        if (TextUtils.isEmpty(this.c)) {
            return false;
        }
        boolean zK = k(frameworkBaseActivity, this.c);
        m(zK, this.c);
        this.c = null;
        SharedPreferences.Editor editorEdit = AppContext.getContext().getSharedPreferences("lx_ad_config", 0).edit();
        editorEdit.putString("lx_ad_deeplink", this.c);
        editorEdit.apply();
        return zK;
    }

    public final void m(boolean z, String str) {
        d dVar = new d(z, str);
        zn6.i("advertising_match_jump", dVar);
        LogUtil.uploadInfoImmediate("advertising_match_jump", dVar);
    }

    public final void n() {
        zn6.d("advertising_message_request", null, null);
        LogUtil.uploadInfoImmediate("advertising_message_request", null, null, null);
    }

    public final void o(boolean z, String str, String str2, String str3) {
        HashMap map = new HashMap();
        if (z) {
            map.put("result", "success");
            map.put("adChannel", str2);
            map.put("adContent", str3);
        } else {
            map.put("result", "fail");
            map.put(MediationConstant.KEY_ERROR_MSG, str);
        }
        zn6.i("advertising_message_return", map);
        LogUtil.uploadInfoImmediate("advertising_message_return", map);
    }

    public void p(e eVar) {
        if (this.f1859a) {
            return;
        }
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.d <= 600000) {
                if (eVar != null) {
                    eVar.onFinish();
                }
                return;
            }
            this.d = jCurrentTimeMillis;
            try {
                RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WkParams.IMEI, ac1.i);
                jSONObject.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
                jSONObject.put("androidId", ac1.o(AppContext.getContext()));
                jSONObject.put("deviceId", ac1.h);
                jSONObject.put("timestamp", ir5.b());
                EncryptUtils.setLxData(jSONObject);
                EncryptUtils.createCKey();
                String hexString = HexDumper.toHexString(EncryptUtils.getEncryptedCKey(nl0.k()));
                byte[] bArrCipherWithHashKey = EncryptUtils.cipherWithHashKey(jSONObject, 2, nl0.k());
                a aVar = new a(eVar);
                b bVar = new b(eVar);
                String strZ = k86.Z(g);
                String str = e;
                LogUtil.d(str, "updateChannel url :" + strZ);
                LogUtil.d(str, "updateChannel body :" + jSONObject.toString());
                EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, bArrCipherWithHashKey, jSONObject, 1, bVar, aVar);
                encryptedJsonRequest.addHeader("Content-CKey", hexString);
                encryptedJsonRequest.addHeader("Content-CKey-Version", EncryptUtils.getCkVersion());
                encryptedJsonRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
                normalRequestQueue.add(encryptedJsonRequest);
                this.f1859a = true;
                n();
                new Handler().postDelayed(new RunnableC0029c(eVar), 500L);
            } catch (Throwable th) {
                th.printStackTrace();
                if (eVar != null) {
                    eVar.onFinish();
                }
            }
        }
    }
}
