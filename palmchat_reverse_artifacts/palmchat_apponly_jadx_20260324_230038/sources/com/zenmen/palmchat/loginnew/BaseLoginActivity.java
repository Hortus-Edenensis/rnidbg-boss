package com.zenmen.palmchat.loginnew;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.opensdk.LXEntryActivity;
import com.zenmen.palmchat.route.share.ExternalShareActivity;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.captcha.CaptchaResult;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.gf2;
import defpackage.iq5;
import defpackage.mz;
import defpackage.nz;
import defpackage.s34;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tj2;
import defpackage.ts0;
import defpackage.x63;
import defpackage.y63;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLoginActivity extends FrameworkBaseActivity {
    public boolean q = false;
    public boolean r = false;
    public JSONObject s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14469a;
        public final /* synthetic */ h b;
        public final /* synthetic */ int c;

        public a(boolean z, h hVar, int i) {
            this.f14469a = z;
            this.b = hVar;
            this.c = i;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            BaseLoginActivity.this.E1(this.f14469a, this.b);
            sy5.e(BaseLoginActivity.this, R.string.login_fail_title, 0).g();
            HashMap<String, Object> mapE = x63.e(this.c);
            mapE.put("result", 0);
            mapE.put("duration", y63.i());
            LogUtil.uploadInfoImmediate("lx_client_login_auth_resp", mapE);
            zn6.j("lx_client_login_auth_resp", null, mapE);
            BaseLoginActivity.this.K1(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14470a;
        public final /* synthetic */ h b;
        public final /* synthetic */ int c;

        public b(boolean z, h hVar, int i) {
            this.f14470a = z;
            this.b = hVar;
            this.c = i;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.optInt("resultCode", -1) != 0) {
                BaseLoginActivity.this.E1(this.f14470a, this.b);
            }
            BaseLoginActivity.this.s = jSONObject;
            if (jSONObject != null) {
                int iOptInt = jSONObject.optInt("resultCode", -1);
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (iOptInt == 0) {
                    BaseLoginActivity.this.M1(jSONObject, this.c, true, this.f14470a, this.b);
                } else if (iOptInt == 1700) {
                    BaseLoginActivity.this.O1(jSONObject, this.c);
                } else if (jSONObject.optInt("resultCode", -1) == 43) {
                    if (!TextUtils.isEmpty(strOptString)) {
                        BaseLoginActivity.this.N1(jSONObject, strOptString);
                    }
                } else if (TextUtils.isEmpty(strOptString)) {
                    sy5.e(BaseLoginActivity.this, R.string.login_fail_title, 0).g();
                    BaseLoginActivity.this.K1(false);
                } else {
                    BaseLoginActivity.this.H1(strOptString);
                }
                if (iOptInt != 0) {
                    HashMap<String, Object> mapE = x63.e(this.c);
                    mapE.put("result", 0);
                    mapE.put("errorcode", Integer.valueOf(iOptInt));
                    mapE.put("errormsg", strOptString);
                    mapE.put("duration", y63.i());
                    LogUtil.uploadInfoImmediate("lx_client_login_auth_resp", mapE);
                    zn6.j("lx_client_login_auth_resp", null, mapE);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14471a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Response.ErrorListener c;
        public final /* synthetic */ Response.Listener d;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements CaptchaManager.a {
            public a() {
            }

            @Override // com.zenmen.palmchat.utils.captcha.CaptchaManager.a
            public void a(int i, CaptchaResult captchaResult) {
                if (captchaResult != null) {
                    c cVar = c.this;
                    y63.e(!cVar.f14471a, cVar.b, com.igexin.push.core.b.m, captchaResult, -1, -1, cVar.c, cVar.d, false);
                }
            }
        }

        public c(boolean z, String str, Response.ErrorListener errorListener, Response.Listener listener) {
            this.f14471a = z;
            this.b = str;
            this.c = errorListener;
            this.d = listener;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null || !nz.c(jSONObject.optInt("resultCode", -1))) {
                this.d.onResponse(jSONObject);
            } else {
                CaptchaManager.c(BaseLoginActivity.this, new mz(jSONObject.optJSONObject("data"), null, null, true), new a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<Void, Void, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f14473a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ h e;

        public d(JSONObject jSONObject, int i, boolean z, boolean z2, h hVar) {
            this.f14473a = jSONObject;
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = hVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            boolean zJ1;
            String strL = y63.l(this.f14473a);
            if (ts0.o().K()) {
                y63.z(strL);
            }
            boolean zO = y63.o(this.f14473a);
            HashMap<String, Object> mapE = x63.e(this.b);
            mapE.put("result", 1);
            mapE.put(DeviceInfoUtil.UID_TAG, strL);
            mapE.put("completeinfor", Integer.valueOf(zO ? 1 : 0));
            mapE.put("duration", y63.i());
            y63.h("lx_thread_change");
            LogUtil.uploadInfoImmediate("lx_client_login_auth_resp", mapE);
            zn6.j("lx_client_login_auth_resp", null, mapE);
            y63.t();
            y63.h("lx_prepare_sta");
            if (zO) {
                if (this.c) {
                    y63.A(this.f14473a);
                }
                y63.v(BaseLoginActivity.this, this.f14473a);
                PushTokenManager.k(BaseLoginActivity.this.s.optJSONObject("data"));
                PushTokenManager.c(AppContext.getContext());
                zJ1 = false;
            } else {
                zJ1 = BaseLoginActivity.this.J1();
            }
            AppContext.getContext().updateDNSOnLogin(strL);
            if (zO) {
                gf2.b(BaseLoginActivity.this);
            }
            return Integer.valueOf(zO ? 1 : zJ1 ? 2 : 0);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            y63.h("lx_prepare_finish");
            JSONObject jSONObjectI = y63.i();
            HashMap<String, Object> mapE = x63.e(this.b);
            mapE.put("duration", jSONObjectI);
            BaseLoginActivity.this.E1(this.d, this.e);
            if (num.intValue() == 1) {
                LogUtil.uploadInfoImmediate("lx_client_login_jump_complete", mapE);
                zn6.j("lx_client_login_jump_complete", null, mapE);
                BaseLoginActivity.this.F1(this.b);
            } else if (num.intValue() == 2) {
                LogUtil.uploadInfoImmediate("lx_client_login_jump_main", mapE);
                BaseLoginActivity.this.G1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f14474a;
        public final /* synthetic */ int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements y63.o {
            public a() {
            }

            @Override // y63.o
            public void onFail() {
                BaseLoginActivity.this.hideBaseProgressBar();
                sy5.e(BaseLoginActivity.this, R.string.login_Exception_tip, 0).g();
                BaseLoginActivity.this.K1(false);
            }

            @Override // y63.o
            public void onSuccess() {
                BaseLoginActivity.this.hideBaseProgressBar();
                e eVar = e.this;
                BaseLoginActivity.this.M1(eVar.f14474a, eVar.b, false, false, null);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("type", 2);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("type", 1);
            }
        }

        public e(JSONObject jSONObject, int i) {
            this.f14474a = jSONObject;
            this.b = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            BaseLoginActivity.this.K1(false);
            LogUtil.uploadInfoImmediate("lx_login_click", new c());
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            y63.A(this.f14474a);
            y63.y(this.f14474a, new a());
            LogUtil.uploadInfoImmediate("lx_login_click", new b());
            BaseLoginActivity.this.showBaseProgressBar();
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14478a;

        public f(String str) {
            this.f14478a = str;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            BaseLoginActivity.this.K1(false);
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            BaseLoginActivity.this.K1(true);
            BaseLoginActivity.P1(BaseLoginActivity.this, this.f14478a);
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            BaseLoginActivity.this.K1(false);
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h {
        void a();
    }

    public static void P1(Context context, String str) {
        Intent intent = new Intent();
        intent.setClass(context, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("from_out_web_url", true);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putBoolean("needCheckAccount", false);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void B1(boolean z, String str, int i, boolean z2) {
        C1(z, str, i, z2, null);
    }

    public void C1(boolean z, String str, int i, boolean z2, h hVar) {
        LogUtil.i("InitActivity", "authImp" + str);
        HashMap<String, Object> mapE = x63.e(i);
        LogUtil.uploadInfoImmediate("lx_client_login_auth_req", mapE);
        zn6.j("lx_client_login_auth_req", null, mapE);
        a aVar = new a(z2, hVar, i);
        y63.e(!z, str, com.igexin.push.core.b.m, null, -1, -1, aVar, new c(z, str, aVar, new b(z2, hVar, i)), false);
        if (z2) {
            showBaseProgressBar(R.string.progress_login, false);
        }
    }

    public void D1(LXBaseNetBean<JSONObject> lXBaseNetBean, int i, boolean z) {
        JSONObject jSONObjectQ1 = Q1(lXBaseNetBean);
        this.s = jSONObjectQ1;
        if (lXBaseNetBean.isSuccess()) {
            M1(jSONObjectQ1, i, true, true, null);
        } else if (lXBaseNetBean.resultCode == 1700) {
            O1(jSONObjectQ1, i);
        } else if (TextUtils.isEmpty(lXBaseNetBean.errorMsg)) {
            sy5.e(this, R.string.send_failed, 0).g();
            K1(false);
        } else {
            int i2 = lXBaseNetBean.resultCode;
            if (i2 == 43) {
                N1(jSONObjectQ1, lXBaseNetBean.errorMsg);
            } else if (i2 == 1136) {
                sy5.f(this, "" + lXBaseNetBean.errorMsg, 0).g();
            } else if (com.zenmen.palmchat.loginnew.b.u().y().booleanValue() && z) {
                int i3 = lXBaseNetBean.resultCode;
                if (i3 == 100 || i3 == 2) {
                    K1(false);
                    sy5.f(this, "登陆失败，请输入手机号，重新登陆!", 0).g();
                    CompleteLoginActivity.e2(this, i, this.r, this.q);
                } else {
                    H1(lXBaseNetBean.errorMsg);
                }
            } else {
                H1(lXBaseNetBean.errorMsg);
            }
        }
        if (lXBaseNetBean.isSuccess()) {
            return;
        }
        HashMap<String, Object> mapE = x63.e(i);
        mapE.put("result", 0);
        mapE.put("errorcode", Integer.valueOf(lXBaseNetBean.resultCode));
        mapE.put("errormsg", lXBaseNetBean.errorMsg);
        mapE.put("duration", y63.i());
        LogUtil.uploadInfoImmediate("lx_client_login_auth_resp", mapE);
        zn6.j("lx_client_login_auth_resp", null, mapE);
    }

    public final void E1(boolean z, h hVar) {
        if (z) {
            hideBaseProgressBar();
        } else if (hVar != null) {
            hVar.a();
        }
    }

    public abstract void F1(int i);

    public void G1() {
        LogUtil.i("BaseLoginActivity", "goToMainTab");
        if (!defpackage.c.j().l(this)) {
            if (this.r) {
                Intent intent = getIntent();
                intent.setClass(this, ExternalShareActivity.class);
                startActivity(intent);
            } else if (this.q) {
                Intent intent2 = getIntent();
                intent2.setClass(this, LXEntryActivity.class);
                startActivity(intent2);
            } else {
                startActivity(new Intent(this, (Class<?>) MainTabsActivity.class));
            }
        }
        ch.s().N();
        finish();
    }

    public void H1(String str) {
        new sd3(this).k(str).O(R.string.alert_dialog_ok).f(new g()).h(false).e().show();
    }

    public void I1(String str, String str2) {
        new sd3(this).k(str).O(R.string.text_appeals).K(R.string.alert_dialog_cancel).h(false).f(new f(str2)).e().show();
    }

    public boolean J1() {
        JSONObject jSONObject = this.s;
        int iQ = jSONObject != null ? y63.q(jSONObject, null, null) : 1203;
        iq5.j(false, new String[0]);
        s34.i();
        return iQ == 0;
    }

    public abstract void K1(boolean z);

    public void L1(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.r = intent.getBooleanExtra("key_has_share", false);
            this.q = intent.getBooleanExtra("key_from_open_sdk", false);
        }
    }

    public void M1(JSONObject jSONObject, int i, boolean z, boolean z2, h hVar) {
        new d(jSONObject, i, z, z2, hVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[PHI: r1 r2
      0x004e: PHI (r1v1 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v5 boolean), (r1v6 boolean) binds: [B:3:0x0008, B:10:0x0026, B:17:0x004d, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE]
      0x004e: PHI (r2v1 int) = (r2v0 int), (r2v0 int), (r2v0 int), (r2v3 int) binds: [B:3:0x0008, B:10:0x0026, B:17:0x004d, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N1(JSONObject jSONObject, String str) {
        int i;
        JSONObject jSONObjectOptJSONObject;
        String strJ = tj2.j();
        boolean zOptBoolean = true;
        int i2 = 0;
        String strOptString = "";
        if (jSONObject != null) {
            String strOptString2 = jSONObject.optString("extension");
            if (TextUtils.isEmpty(strOptString2) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                strOptString2 = jSONObjectOptJSONObject.optString("extension");
            }
            if (TextUtils.isEmpty(strOptString2)) {
                i = 0;
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    zOptBoolean = jSONObject2.optBoolean("appeal", true);
                    int iOptInt = jSONObject2.optInt("lockType", 0);
                    try {
                        int iOptInt2 = jSONObject2.optInt("lockRule", 0);
                        try {
                            strOptString = jSONObject2.optString("appealUrl");
                        } catch (JSONException unused) {
                        }
                        i = iOptInt2;
                        i2 = iOptInt;
                    } catch (JSONException unused2) {
                        i2 = iOptInt;
                        i = 0;
                    }
                } catch (JSONException unused3) {
                }
            }
        }
        if (!zOptBoolean) {
            H1(str);
            return;
        }
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = strJ + "?lockType=" + i2 + "&lockRule=" + i;
        }
        I1(str, strOptString);
    }

    public void O1(JSONObject jSONObject, int i) {
        try {
            jSONObject.put("resultCode", 0);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data").optJSONObject("loginPopCfg");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("title");
                String strOptString2 = jSONObjectOptJSONObject.optString("content");
                String strOptString3 = jSONObjectOptJSONObject.optString("okBtn");
                new sd3(this).U(strOptString).k(strOptString2).P(strOptString3).L(jSONObjectOptJSONObject.optString("cancelBtn")).f(new e(jSONObject, i)).h(false).e().show();
                LogUtil.uploadInfoImmediate("lx_login_show", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final JSONObject Q1(LXBaseNetBean<JSONObject> lXBaseNetBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", lXBaseNetBean.resultCode);
            jSONObject.put(MediationConstant.KEY_ERROR_MSG, lXBaseNetBean.errorMsg);
            jSONObject.put("data", lXBaseNetBean.data);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setNeedShowKickOutDialog(false);
        L1(bundle);
    }
}
