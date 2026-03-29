package defpackage;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.igexin.push.core.b;
import com.lantern.auth.server.WkParams;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.wallet.WalletActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ii6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<WalletActivity> f18175a;
    public String b = null;
    public boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements za3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rt2 f18176a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ WalletActivity d;

        public a(rt2 rt2Var, String str, JSONObject jSONObject, WalletActivity walletActivity) {
            this.f18176a = rt2Var;
            this.b = str;
            this.c = jSONObject;
            this.d = walletActivity;
        }

        @Override // defpackage.za3
        public void onPayBack(int i, String str, Object obj) {
            JSONObject jSONObjectC = ii6.c();
            JSONObject jSONObject = new JSONObject();
            try {
                if (obj instanceof Map) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, new JSONObject((Map) obj));
                }
                jSONObject.put("retCode", i);
                jSONObject.put(WkParams.RETMSG, str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("payResult", jSONObject);
                jSONObjectC.put("data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f18176a.c();
            LogUtil.i("WalletJs4UnionPay", "unionPay callbackName=" + this.b + " params=" + this.c + " result =" + jSONObjectC.toString());
            this.d.O1(this.b, jSONObjectC.toString());
        }
    }

    public ii6(WalletActivity walletActivity) {
        this.f18175a = new WeakReference<>(walletActivity);
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", "0");
            jSONObject.put("msg", b.B);
        } catch (JSONException e) {
            ma3.c(e);
        }
        return jSONObject;
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", "-1");
            jSONObject.put("msg", "fail");
        } catch (JSONException e) {
            ma3.c(e);
        }
        return jSONObject;
    }

    public void b(String str) {
        WalletActivity walletActivity = this.f18175a.get();
        if (walletActivity == null || walletActivity.isFinishing()) {
            return;
        }
        JSONObject jSONObjectC = c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", "v5");
            jSONObjectC.put("data", jSONObject);
        } catch (JSONException unused) {
        }
        LogUtil.i("WalletJs4UnionPay", "getPayVersion result= " + jSONObjectC);
        walletActivity.O1(str, jSONObjectC.toString());
    }

    public void e() {
        if (this.c) {
            try {
                an1.c().r(this);
            } catch (Exception unused) {
            }
        }
    }

    public void f(String str, JSONObject jSONObject) {
        WalletActivity walletActivity;
        LogUtil.i("WalletJs4UnionPay", "payByWxMiniProgram callbackName=" + str + " params=" + jSONObject);
        if (l50.a() || (walletActivity = this.f18175a.get()) == null || walletActivity.isFinishing()) {
            return;
        }
        if (jSONObject == null) {
            walletActivity.O1(str, d().toString());
            return;
        }
        String strOptString = jSONObject.optString("wx_ID");
        String strOptString2 = jSONObject.optString(OapsWrapper.KEY_PATH);
        HashMap map = new HashMap();
        if (jSONObject.keys() != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.opt(next));
            }
        } else {
            map.put("Empty", "Empty");
        }
        zn6.j("open_wx_mini_program", null, map);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            walletActivity.O1(str, d().toString());
            return;
        }
        g();
        so6.a().d(strOptString, strOptString2);
        this.b = str;
        LogUtil.i("WalletJs4UnionPay", "payByWxMiniProgram end callbackName=" + str + " params=" + jSONObject);
    }

    public final void g() {
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            an1.c().p(this);
        } catch (Exception unused) {
        }
    }

    public void h(WalletActivity walletActivity, String str, JSONObject jSONObject) {
        LogUtil.i("WalletJs4UnionPay", "unionPay callbackName=" + str + " params=" + jSONObject);
        rt2 rt2Var = new rt2();
        rt2Var.b(jSONObject, new a(rt2Var, str, jSONObject, walletActivity), walletActivity);
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onPayBack(WXLaunchMiniProgram.Resp resp) {
        WalletActivity walletActivity;
        LogUtil.i("WalletJs4UnionPay", "onPayBack resp= " + resp);
        if (l50.a() || (walletActivity = this.f18175a.get()) == null || walletActivity.isFinishing()) {
            return;
        }
        if (this.b != null) {
            JSONObject jSONObjectC = c();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("wxResp", az2.c(resp));
                jSONObjectC.put("data", jSONObject);
            } catch (JSONException unused) {
            }
            LogUtil.i("WalletJs4UnionPay", "onPayBack result= " + jSONObjectC);
            walletActivity.O1(this.b, jSONObjectC.toString());
        }
        this.b = null;
    }
}
