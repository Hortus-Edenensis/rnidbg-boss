package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dislike.ui.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.b.mv;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.ugeno.n.x;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.fx;
import com.bytedance.sdk.openadsdk.core.widget.jk;
import com.bytedance.sdk.openadsdk.core.widget.my;
import com.bytedance.sdk.openadsdk.core.widget.n;
import com.bytedance.sdk.openadsdk.core.widget.nr;
import com.bytedance.sdk.openadsdk.core.widget.pn;
import com.bytedance.sdk.openadsdk.core.widget.t;
import com.bytedance.sdk.openadsdk.core.widget.x;
import com.bytedance.sdk.openadsdk.core.y.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTDelegateActivity extends Activity {
    private static x my;
    private static String o;
    private static String sx;
    public static bc u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f5205a;
    private nr b;
    private AlertDialog fx;
    private b iz;
    private Activity jk;
    private my k;
    private com.bytedance.sdk.openadsdk.core.widget.nr l;
    private t mv;
    private Dialog n;
    private Intent nr;
    private jk pn;
    private a s;
    private fx t;
    private pn x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.component.jk.a {
        public u(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.l.b.b bVarB = mv.b();
            if (bVarB != null) {
                Function<SparseArray<Object>, Object> functionY = com.bytedance.sdk.openadsdk.core.n.o().y();
                if (functionY != null) {
                    bVarB.u(com.bytedance.sdk.openadsdk.my.fx.nr(functionY).booleanValue(1));
                }
                sx.jk();
            }
        }
    }

    private void iz(String str) {
        if (y.a(this.jk)) {
            if (str != null && this.b == null) {
                try {
                    bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(str));
                    if (bcVarU != null) {
                        nr nrVar = new nr(this.jk, bcVarU.vz(), false, com.bytedance.sdk.openadsdk.n.nr.u());
                        this.b = nrVar;
                        com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.jk, bcVarU, nrVar);
                        this.b.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                            public void nr() {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                            public void u() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                            public void u(int i, String str2, boolean z) {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException unused) {
                }
            }
            nr nrVar2 = this.b;
            if (nrVar2 != null) {
                nrVar2.u();
            }
        }
    }

    private void pn() {
        try {
            Intent intent = this.nr;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.nr.getStringExtra("app_download_url");
            this.nr.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    iz();
                    break;
                case 3:
                    fx(stringExtra, this.nr.getStringExtra("dialog_title"), this.nr.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    nr(this.nr.getStringExtra("permission_id_key"), this.nr.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    nr(stringExtra, this.nr.getStringExtra("dialog_title"), this.nr.getStringExtra("dialog_content_key"), this.nr.getStringExtra("dialog_btn_yes_key"), this.nr.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    iz(this.nr.getStringExtra("materialmeta"));
                    break;
                case 7:
                    fx(stringExtra);
                    break;
                case 8:
                    u(this.nr.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    fx(this.nr.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    nr(this.nr.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    pn(this.nr.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    nr(this.nr.getStringExtra("web_url"), this.nr.getStringExtra("web_title"));
                    break;
                case 13:
                    nr();
                    break;
                case 14:
                    u(this.nr.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    u(this.nr.getStringExtra("web_url"));
                    break;
                case 16:
                    u(this.nr.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fx fxVar = this.t;
        if (fxVar == null || fxVar.isShowing()) {
            return;
        }
        this.t.u();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jk = this;
        b();
        this.nr = getIntent();
        if (dw.getContext() == null) {
            dw.u(this.jk);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            u = null;
            AlertDialog alertDialog = this.fx;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.fx.dismiss();
            }
            n nVar = this.f5205a;
            if (nVar == null || !nVar.isShowing()) {
                iz.u(o);
            } else {
                iz.u(this.f5205a.u());
                if (this.f5205a.isShowing()) {
                    this.f5205a.dismiss();
                }
            }
            b bVar = this.iz;
            if (bVar != null && bVar.isShowing()) {
                this.iz.dismiss();
            }
            fx fxVar = this.t;
            if (fxVar != null) {
                if (fxVar.isShowing()) {
                    this.t.dismiss();
                }
                iz.u(this.t.b());
            } else {
                iz.u(sx);
            }
            com.bytedance.sdk.openadsdk.core.widget.nr nrVar = this.l;
            if (nrVar != null && nrVar.isShowing()) {
                this.l.dismiss();
            }
            pn pnVar = this.x;
            if (pnVar != null && pnVar.isShowing()) {
                this.x.dismiss();
            }
            t tVar = this.mv;
            if (tVar != null && tVar.isShowing()) {
                this.mv.dismiss();
            }
            Dialog dialog = this.n;
            if (dialog != null && dialog.isShowing()) {
                this.n.dismiss();
            }
            o = null;
            sx = null;
        } catch (Throwable th) {
            k.u("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (dw.getContext() == null) {
            dw.u(this.jk);
        }
        try {
            setIntent(intent);
            this.nr = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        n nVar = this.f5205a;
        if (nVar != null) {
            o = nVar.u();
        }
        fx fxVar = this.t;
        if (fxVar != null) {
            sx = fxVar.b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.bytedance.sdk.openadsdk.core.h.pn.u().u(this.jk, strArr, iArr);
        com.bytedance.sdk.component.jk.x.u(new u("onRequestPermissionsResult"), 1);
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            pn();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        fx();
    }

    public static void b(Context context, String str, String str2) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 12);
        intentU.putExtra("web_url", str);
        intentU.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void fx(Context context, String str, String str2) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 14);
        intentU.putExtra("dialog_app_desc_url", str2);
        intentU.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void nr(Context context, String str, String str2) {
        if (context == null) {
            context = dw.getContext();
        }
        com.bytedance.sdk.openadsdk.core.kj.iz izVarB = b(str2);
        if (izVarB == null) {
            return;
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 9);
        intentU.putExtra("dialog_app_privacy_url", izVarB.n());
        intentU.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(String str, String[] strArr) {
        Intent intent = new Intent(dw.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (dw.getContext() != null) {
            com.bytedance.sdk.component.utils.nr.u(dw.getContext(), intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.nr.u
                public void u() {
                }

                @Override // com.bytedance.sdk.component.utils.nr.u
                public void u(Throwable th) {
                    k.u("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void fx() {
        if (com.bytedance.sdk.openadsdk.core.n.o().eh()) {
            if (this.t == null && this.f5205a == null && this.mv == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.n.o().n(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(str, "click_other", str3, str2, new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    private void iz() {
        ApplicationInfo applicationInfo;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            try {
                com.bytedance.sdk.openadsdk.my.fx.fx.b bVarBq = com.bytedance.sdk.openadsdk.core.n.o().bq();
                boolean zFx = bVarBq.fx();
                boolean zPn = bVarBq.pn();
                ArrayList arrayList = new ArrayList();
                com.bytedance.sdk.openadsdk.k.nr.u(bVarBq, arrayList);
                if (zFx) {
                    arrayList.add(g.c);
                }
                Context context = dw.getContext();
                if (context != null && (applicationInfo = context.getApplicationInfo()) != null) {
                    if (applicationInfo.targetSdkVersion >= 33 && i >= 33) {
                        arrayList.add(com.huawei.openalliance.ad.constant.x.cI);
                    } else if (zPn) {
                        arrayList.add(g.j);
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.h.pn.u().u(this.jk, strArr, new com.bytedance.sdk.openadsdk.core.h.iz() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                    @Override // com.bytedance.sdk.openadsdk.core.h.iz
                    public void u() {
                        com.bytedance.sdk.component.jk.x.u(new u("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.iz
                    public void u(String str) {
                        g.c.equals(str);
                        com.bytedance.sdk.component.jk.x.u(new u("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
            }
        }
        finish();
    }

    public static void nr(Context context, String str) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 11);
        intentU.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    private static com.bytedance.sdk.openadsdk.core.kj.iz b(String str) {
        try {
            return com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    private void fx(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strT;
        String str8;
        String str9;
        String str10;
        float fFx;
        Intent intent = this.nr;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.nr.getStringExtra("event_adId");
        final String stringExtra3 = this.nr.getStringExtra("event_TAG");
        String stringExtra4 = this.nr.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.nr.getStringExtra("dialog_title");
        final String stringExtra6 = this.nr.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.nr.getStringExtra("dialog_app_description");
        boolean z = false;
        boolean booleanExtra = this.nr.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String strOptString = "";
            float f = 0.0f;
            if (TextUtils.isEmpty(stringExtra4)) {
                str2 = stringExtra4;
                jSONArray = null;
                str3 = null;
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(jSONObject);
                if (izVarPn != null) {
                    String strPn = izVarPn.pn();
                    String strX = izVarPn.x();
                    String strJk = izVarPn.jk();
                    String strS = izVarPn.s();
                    if (!TextUtils.isEmpty(strS)) {
                        stringExtra5 = strS;
                    }
                    JSONArray jSONArrayB = izVarPn.b();
                    fFx = izVarPn.fx();
                    strT = izVarPn.t();
                    strOptString = stringExtra5;
                    str8 = strPn;
                    str9 = strX;
                    jSONArray2 = jSONArrayB;
                    str10 = strJk;
                } else {
                    strT = null;
                    str8 = "";
                    str9 = str8;
                    str10 = str9;
                    fFx = 0.0f;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put("app_name", strOptString);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put("description", stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z = true;
                }
                str2 = stringExtra4;
                str6 = strOptString;
                str3 = strT;
                str7 = str10;
                str4 = str8;
                strOptString = jSONObject.optString("hand_icon_url");
                jSONArray = jSONArray2;
                float f2 = fFx;
                str5 = str9;
                f = f2;
            }
            if (booleanExtra) {
                u(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            if (z) {
                final String str11 = str2;
                final float f3 = f;
                final String str12 = strOptString;
                final JSONArray jSONArray3 = jSONArray;
                final String str13 = str4;
                final String str14 = str5;
                final String str15 = str6;
                final String str16 = str7;
                final String str17 = str3;
                u(str, str2, new x() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
                    public void u(int i, String str18) {
                        TTDelegateActivity.this.u(str, str11, stringExtra6, f3, stringExtra7, str12, jSONArray3, str13, str14, str15, str16, str17, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.f5205a != null) {
                            TTDelegateActivity.this.f5205a.u((x) null);
                        }
                        if (TTDelegateActivity.my != null) {
                            TTDelegateActivity.my.u(i, str18);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
                    public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                        if (TTDelegateActivity.my != null) {
                            TTDelegateActivity.my.u(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            u(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 3);
        intentU.putExtra("app_download_url", str);
        intentU.putExtra("dialog_title", str2);
        intentU.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    private void nr() {
        try {
            if (this.s == null) {
                this.s = new a(this.jk, getIntent());
            }
            if (this.s.isShowing()) {
                this.s.dismiss();
            }
            this.s.u(new a.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.a.u
                public void u(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.s.show();
        } catch (Throwable unused) {
        }
    }

    private static Intent u(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private void nr(String str) {
        try {
            if (y.a(this.jk)) {
                Dialog dialog = this.n;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.u uVar = new com.bytedance.sdk.openadsdk.core.widget.u(this.jk, str);
                    this.n = uVar;
                    uVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.n.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void u(x xVar) {
        my = xVar;
    }

    public static void u(Context context, String str, String str2, String str3, x xVar, bc bcVar) {
        try {
            u = bcVar;
            my = xVar;
            if (context == null) {
                context = dw.getContext();
            }
            Intent intentU = u(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentU.putExtra("type", 7);
            intentU.putExtra("app_download_url", str);
            intentU.putExtra("dialog_app_manage_model", str2);
            if (bcVar != null) {
                intentU.putExtra("event_adId", bcVar.lk());
                intentU.putExtra("event_extInfo", bcVar.ap());
                intentU.putExtra("event_TAG", jp.nr(bcVar));
            }
            intentU.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentU.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentU.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentU.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
        } catch (Exception unused) {
        }
    }

    private void nr(String str, String str2) {
        try {
            if (y.a(this.jk)) {
                b bVar = this.iz;
                if (bVar != null) {
                    bVar.dismiss();
                }
                b bVar2 = new b(this.jk, str, str2);
                this.iz = bVar2;
                bVar2.u(new b.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.b.u
                    public void u(Dialog dialog) {
                        if (TTDelegateActivity.this.iz != null) {
                            TTDelegateActivity.this.iz.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.iz.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void nr(final String str, String str2, String str3, String str4, String str5) {
        if (y.a(this.jk)) {
            AlertDialog alertDialog = this.fx;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.pn == null) {
                this.pn = new jk(this.jk).u(str2).nr(str3).fx(str4).b(str5).u(new jk.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
                    public void onClickNo(Dialog dialog) {
                        iz.fx(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.jk.u
                    public void onClickYes(Dialog dialog) {
                        iz.nr(str);
                        TTDelegateActivity.this.finish();
                    }
                }).u(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        iz.b(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.pn.isShowing()) {
                this.pn.show();
            }
            this.fx = this.pn;
        }
    }

    private void pn(String str) {
        try {
            if (y.a(this.jk)) {
                t tVar = this.mv;
                if (tVar != null) {
                    tVar.dismiss();
                }
                t tVar2 = new t(this.jk, str);
                this.mv = tVar2;
                tVar2.u(new t.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.t.u
                    public void u(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.mv.show();
            }
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context, String str, String str2, String str3, bc bcVar) {
        if (context == null) {
            try {
                context = dw.getContext();
            } catch (Exception unused) {
                return;
            }
        }
        Intent intentU = u(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentU.putExtra("type", 7);
        intentU.putExtra("app_download_url", str);
        intentU.putExtra("dialog_app_manage_model", str2);
        if (bcVar != null) {
            intentU.putExtra("event_adId", bcVar.lk());
            intentU.putExtra("event_extInfo", bcVar.ap());
            intentU.putExtra("event_TAG", jp.nr(bcVar));
        }
        intentU.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentU.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentU.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentU.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    private void fx(String str, String str2) {
        if (this.nr == null) {
            return;
        }
        u(str, str2, 2, true, (Dialog) null);
    }

    private void fx(final String str, String str2, String str3) {
        if (y.a(this.jk)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = q.u(this.jk, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            u(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    iz.nr(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    iz.fx(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    iz.b(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void nr(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    com.bytedance.sdk.openadsdk.core.h.pn.u().u(this.jk, strArr, new com.bytedance.sdk.openadsdk.core.h.iz() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                        @Override // com.bytedance.sdk.openadsdk.core.h.iz
                        public void u() {
                            com.bytedance.sdk.openadsdk.core.y.x.u(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.h.iz
                        public void u(String str2) {
                            com.bytedance.sdk.openadsdk.core.y.x.u(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                }
            }
            finish();
            return;
        }
        finish();
    }

    public static void u(Context context, String str, String str2) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 8);
        intentU.putExtra("app_download_url", str);
        intentU.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(Context context, String str) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 10);
        intentU.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(Context context, String str, String str2, bc bcVar) {
        if (context == null) {
            context = dw.getContext();
        }
        com.bytedance.sdk.openadsdk.core.kj.iz izVarB = b(str2);
        if (izVarB == null) {
            return;
        }
        if (bcVar != null) {
            nr(jp.nr(bcVar), bcVar.ap(), bcVar.lk());
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 16);
        intentU.putExtra("dialog_app_registration_url", izVarB.t());
        intentU.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 5);
        intentU.putExtra("app_download_url", str);
        intentU.putExtra("dialog_title", str2);
        intentU.putExtra("dialog_content_key", str3);
        intentU.putExtra("dialog_btn_yes_key", str4);
        intentU.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(Context context, bc bcVar) {
        JSONObject jSONObjectEt;
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 6);
        if (bcVar != null && (jSONObjectEt = bcVar.et()) != null) {
            intentU.putExtra("materialmeta", jSONObjectEt.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentU);
            } catch (Throwable unused) {
            }
        }
    }

    public void u(String str) {
        if (this.k == null) {
            this.k = new my(this.jk, str);
        }
        if (this.k.isShowing()) {
            this.k.dismiss();
        }
        this.k.u(new my.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.my.u
            public void nr(String str2) {
                iz.b(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.my.u
            public void u(String str2) {
                iz.nr(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.k.show();
    }

    public static void u(Context context, String str, boolean z) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 15);
        if (!z) {
            intentU.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    public static void u(Context context, String str, bc bcVar) {
        if (context == null) {
            context = dw.getContext();
        }
        Intent intentU = u(context);
        intentU.putExtra("type", 13);
        u = bcVar;
        intentU.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.nr.u(context, intentU, null);
    }

    private void u(String str, String str2, x xVar, String str3, String str4, String str5) {
        if (y.a(this.jk)) {
            if (TextUtils.isEmpty(str2)) {
                xVar.u(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                fx fxVar = this.t;
                if (fxVar == null || !fxVar.isShowing()) {
                    fx fxVarA = new com.bytedance.sdk.openadsdk.core.widget.mv(this.jk, jSONObject, xVar).a(str);
                    this.t = fxVarA;
                    ((com.bytedance.sdk.openadsdk.core.widget.mv) fxVarA).nr(u(str, str2, str3, str4, str5));
                    this.t.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void u(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        u(str, str2, str7, f, new x() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(int i, String str13) {
                TTDelegateActivity.this.u(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.f5205a != null) {
                    TTDelegateActivity.this.f5205a.u((x) null);
                }
                if (TTDelegateActivity.my != null) {
                    TTDelegateActivity.my.u(i, str13);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.n.x
            public void u(com.bytedance.adsdk.ugeno.nr.fx<View> fxVar) {
                if (TTDelegateActivity.my != null) {
                    TTDelegateActivity.my.u(null);
                }
            }
        }, str10, str11, str12);
    }

    private void u(final String str, final String str2, String str3, float f, x xVar, final String str4, final String str5, final String str6) {
        if (y.a(this.jk)) {
            if (TextUtils.isEmpty(str2)) {
                xVar.u(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f);
                JSONObject jSONObjectU = com.bytedance.sdk.openadsdk.core.ugeno.jk.u(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
                if (jSONObjectU == null) {
                    xVar.u(8, "uegnTemplate is empty");
                    return;
                }
                n nVar = this.f5205a;
                if (nVar == null || !nVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    n nVar2 = new n(str, this.jk, jSONObjectU, jSONObject2, xVar, u);
                    this.f5205a = nVar2;
                    nVar2.u(new x.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // com.bytedance.sdk.openadsdk.core.widget.x.u
                        public void b(Dialog dialog) {
                            try {
                                com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(str2));
                                if (izVarPn != null) {
                                    TTDelegateActivity.this.u(izVarPn.n(), str, 2, false, (Dialog) TTDelegateActivity.this.f5205a);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.f5205a != null) {
                                TTDelegateActivity.this.f5205a.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.x.u
                        public void fx(Dialog dialog) {
                            iz.b(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.x.u
                        public void nr(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.u(str2, str, false, (Dialog) tTDelegateActivity.f5205a);
                            if (TTDelegateActivity.this.f5205a != null) {
                                TTDelegateActivity.this.f5205a.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.x.u
                        public void u(Dialog dialog) {
                            iz.nr(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.x.u
                        public void u() {
                            try {
                                com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(str2));
                                if (izVarPn != null) {
                                    TTDelegateActivity.this.u(izVarPn.a(), str, 1, false, (Dialog) TTDelegateActivity.this.f5205a);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.f5205a != null) {
                                TTDelegateActivity.this.f5205a.hide();
                            }
                        }
                    });
                    this.f5205a.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (y.a(this.jk)) {
            fx fxVar = this.t;
            if (fxVar == null || !fxVar.isShowing()) {
                fx fxVarU = new fx(this.jk).u(str8).pn(str6).iz(str9).nr(str3).n(str7).a(str).fx(str5).u(f).u(jSONArray).x(str10).b(str4).u(u(str, str2, str11, str12, str13));
                this.t = fxVarU;
                fxVarU.show();
            }
        }
    }

    private fx.u u(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void b(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(str2));
                    if (izVarPn != null) {
                        TTDelegateActivity.this.u(izVarPn.n(), str, 2, false, (Dialog) null);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void fx(Dialog dialog) {
                iz.b(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void iz(Dialog dialog) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    TTDelegateActivity.nr(str4, str5, str3);
                    com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(jSONObject);
                    if (izVarPn == null) {
                        return;
                    }
                    TTDelegateActivity.this.u(izVarPn.t(), str, 3, false, (Dialog) null);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void nr(Dialog dialog) {
                TTDelegateActivity.this.u(str2, str, false, (Dialog) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void pn(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.kj.iz izVarPn = com.bytedance.sdk.openadsdk.core.u.pn(new JSONObject(str2));
                    if (izVarPn == null) {
                        return;
                    }
                    TTDelegateActivity.this.u(izVarPn.a(), str, 1, false, (Dialog) null);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.fx.u
            public void u(Dialog dialog) {
                iz.nr(str);
                TTDelegateActivity.this.finish();
            }
        };
    }

    private void u(String str, String str2) {
        if (this.nr == null) {
            return;
        }
        u(str, str2, true, (Dialog) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (y.a(this.jk)) {
                pn pnVar = this.x;
                if (pnVar != null) {
                    pnVar.dismiss();
                }
                if (i == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                pn pnVar2 = new pn(this.jk, str, str3, str4);
                this.x = pnVar2;
                pnVar2.u(new pn.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.pn.u
                    public void fx(Dialog dialog2) {
                        if (TTDelegateActivity.this.x != null) {
                            if (z) {
                                iz.b(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.x.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.pn.u
                    public void nr(Dialog dialog2) {
                        iz.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.pn.u
                    public void u(Dialog dialog2) {
                        iz.nr(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.x.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (y.a(this.jk)) {
                com.bytedance.sdk.openadsdk.core.widget.nr nrVar = this.l;
                if (nrVar != null) {
                    nrVar.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.nr nrVar2 = new com.bytedance.sdk.openadsdk.core.widget.nr(this.jk, str);
                this.l = nrVar2;
                nrVar2.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.nr.u
                    public void fx(Dialog dialog2) {
                        if (TTDelegateActivity.this.l != null) {
                            if (z) {
                                iz.b(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.l.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.nr.u
                    public void nr(Dialog dialog2) {
                        iz.b(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.nr.u
                    public void u(Dialog dialog2) {
                        iz.nr(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.l.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void u(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.fx == null) {
                this.fx = new AlertDialog.Builder(this.jk, q.x(this.jk, "Theme.Dialog.TTDownload")).create();
            }
            this.fx.setTitle(String.valueOf(str));
            this.fx.setMessage(String.valueOf(str2));
            this.fx.setButton(-1, q.u(this.jk, "tt_label_ok"), onClickListener);
            this.fx.setButton(-2, q.u(this.jk, "tt_label_cancel"), onClickListener2);
            this.fx.setOnCancelListener(onCancelListener);
            if (this.fx.isShowing()) {
                return;
            }
            this.fx.show();
        } catch (Exception unused) {
        }
    }
}
