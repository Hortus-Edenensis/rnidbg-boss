package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.zenmen.palmchat.network.VolleyNetwork;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.wallet.WalletActivity;
import com.zenmen.palmchat.wallet.WalletAllowsResp;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hi6 extends wt0 {
    public static List<Pattern> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<WalletActivity> f17972a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            Log.i("TAG", jSONObject + "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            Log.i("TAG", volleyError + "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17975a;
        public final /* synthetic */ String b;

        public c(boolean z, String str) {
            this.f17975a = z;
            this.b = str;
        }

        @Override // hi6.d
        public void a(String str, VolleyError volleyError) {
            LogUtil.d("LxWallet", "onError url=" + str + ",error=" + volleyError);
            WalletActivity walletActivity = (WalletActivity) hi6.this.f17972a.get();
            if (walletActivity == null || walletActivity.isFinishing()) {
                return;
            }
            if (volleyError instanceof NoConnectionError) {
                if (this.f17975a) {
                    walletActivity.O1(this.b, fi6.d(6001, Pair.create("debugUrl", str)));
                    return;
                } else {
                    walletActivity.O1(this.b, fi6.a(6001));
                    return;
                }
            }
            if (volleyError instanceof NetworkError) {
                if (this.f17975a) {
                    walletActivity.O1(this.b, fi6.d(6002, Pair.create("debugUrl", str)));
                    return;
                } else {
                    walletActivity.O1(this.b, fi6.a(6002));
                    return;
                }
            }
            if (this.f17975a) {
                walletActivity.O1(this.b, fi6.d(3001, Pair.create("debugUrl", str)));
            } else {
                walletActivity.O1(this.b, fi6.a(3001));
            }
        }

        @Override // hi6.d
        public void b(String str, JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            LogUtil.d("LxWallet", "onResponse url=" + str + ",response=" + jSONObject2);
            if (str != null && str.contains("/vas.wallet.pay.order.create.v1")) {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("data");
                LogUtil.d("LxWallet", "data1=" + jSONObjectOptJSONObject);
                if (jSONObjectOptJSONObject != null) {
                    try {
                        String strOptString = jSONObjectOptJSONObject.optString("id");
                        String strOptString2 = jSONObjectOptJSONObject.optString("data");
                        LogUtil.d("LxWallet", "data2=" + strOptString2);
                        JSONObject jSONObject3 = new JSONObject(strOptString2);
                        String strOptString3 = jSONObject3.optString("payInfo");
                        String strOptString4 = jSONObject3.optString("openOrderId");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("extend");
                        LogUtil.d("LxWallet", "data3=" + jSONObjectOptJSONObject2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("id", strOptString);
                        if (!TextUtils.isEmpty(strOptString3)) {
                            jSONObject4.put("payInfo", Base64.encodeToString(strOptString3.toString().getBytes(), 0));
                        }
                        jSONObject4.put("openOrderId", strOptString4);
                        if (jSONObjectOptJSONObject2 != null) {
                            jSONObject4.put("extend", Base64.encodeToString(jSONObjectOptJSONObject2.toString().getBytes(), 0));
                        }
                        jSONObject2 = jSONObject4;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        LogUtil.d("LxWallet", "ex=" + jSONObjectOptJSONObject, e);
                    }
                }
            }
            LogUtil.d("LxWallet", "data4=" + jSONObject2);
            LogUtil.d("LxWallet", "onResponse url=" + str + ",response2222=" + fi6.e(jSONObject2));
            WalletActivity walletActivity = (WalletActivity) hi6.this.f17972a.get();
            if (walletActivity == null || walletActivity.isFinishing()) {
                return;
            }
            if (this.f17975a) {
                walletActivity.O1(this.b, fi6.f(jSONObject2, Pair.create("debugUrl", str)));
            } else {
                walletActivity.O1(this.b, fi6.e(jSONObject2));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(String str, VolleyError volleyError);

        void b(String str, JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements Response.Listener<JSONObject>, Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17976a;
        public final d b;

        public e(String str, d dVar) {
            this.f17976a = str;
            this.b = dVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.b(this.f17976a, jSONObject);
            }
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(this.f17976a, volleyError);
            }
        }
    }

    public hi6(WalletActivity walletActivity) {
        this.f17972a = new WeakReference<>(walletActivity);
    }

    public void o(String str, String str2) {
        boolean z;
        WalletActivity walletActivity = this.f17972a.get();
        if (walletActivity == null || walletActivity.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(ActionUtils.METHOD);
            if (TextUtils.isEmpty(strOptString)) {
                walletActivity.O1(str2, fi6.a(4002));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
            boolean zOptBoolean = false;
            if (jSONObjectOptJSONObject != null) {
                boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("fake", false);
                zOptBoolean = jSONObjectOptJSONObject.optBoolean("debug", false);
                z = zOptBoolean2;
            } else {
                z = false;
            }
            if (WalletAllowsResp.isAllow(walletActivity.J1(), strOptString, b)) {
                r(walletActivity, str2, strOptString, jSONObject.optJSONObject("params"), z, new c(zOptBoolean, str2));
            } else {
                walletActivity.O1(str2, fi6.a(5004));
            }
        } catch (JSONException e2) {
            LogUtil.e("LxWallet", "JS call illegal param", e2);
            walletActivity.O1(str2, fi6.a(4002));
        }
    }

    public final void p(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        try {
            LogUtil.d("LxWallet", "request: url=" + str);
            LogUtil.d("LxWallet", "request: params=" + jSONObject);
            try {
                String strZ = k86.Z(str);
                RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
                EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, listener, errorListener);
                normalRequestQueue.add(encryptedJsonRequest);
                this.mRequests.add(encryptedJsonRequest);
            } catch (UnsupportedEncodingException e2) {
                errorListener.onErrorResponse(new VolleyError(e2));
                LogUtil.e("LxWallet", e2);
            }
        } catch (Exception e3) {
            errorListener.onErrorResponse(new VolleyError(e3));
        }
    }

    public void q() {
        p(nl0.z + "/vas.wallet.sdk.acls.v1", null, new a(), new b());
    }

    public final void r(WalletActivity walletActivity, String str, String str2, JSONObject jSONObject, boolean z, d dVar) {
        String str3 = nl0.z + "/" + str2;
        LogUtil.d("LxWallet", "request: url=" + str3);
        LogUtil.d("LxWallet", "request: params=" + jSONObject);
        try {
            String strZ = k86.Z(str3);
            e eVar = new e(strZ, dVar);
            if (z) {
                eVar.onResponse(new JSONObject());
                return;
            }
            RequestQueue normalRequestQueue = VolleyNetwork.getNormalRequestQueue();
            EncryptedJsonRequest encryptedJsonRequest = new EncryptedJsonRequest(1, strZ, jSONObject, eVar, eVar);
            normalRequestQueue.add(encryptedJsonRequest);
            this.mRequests.add(encryptedJsonRequest);
        } catch (UnsupportedEncodingException e2) {
            LogUtil.e("LxWallet", e2);
            walletActivity.O1(str, fi6.a(4001));
        }
    }
}
