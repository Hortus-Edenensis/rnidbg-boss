package com.zenmen.palmchat.QRCodeScan;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.l92;
import defpackage.nl0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: compiled from: SearchBox */
    public class b extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yw4 f12134a;

        public b(yw4 yw4Var) {
            this.f12134a = yw4Var;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            this.f12134a.onFail(exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            this.f12134a.onSuccess(jSONObject, yy2Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yw4 f12135a;

        public c(yw4 yw4Var) {
            this.f12135a = yw4Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            this.f12135a.onSuccess(jSONObject, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yw4 f12136a;

        public d(yw4 yw4Var) {
            this.f12136a = yw4Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f12136a.onFail(volleyError);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(String str);
    }

    public static boolean a() {
        return false;
    }

    public static void b(Context context, String str, yw4 yw4Var) {
        if (!a()) {
            try {
                new l92(new c(yw4Var), new d(yw4Var)).n(str.substring(10));
                return;
            } catch (DaoException e2) {
                e2.printStackTrace();
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        zw4.f(nl0.b + "/user/v1/scan.json", 1, jSONObject, new b(yw4Var));
    }

    public static void c(e eVar) {
        if (a()) {
            zw4.f(nl0.b + "/user/v1/qr_code.json", 1, null, new C0947a(eVar));
            return;
        }
        eVar.a("addfriend:" + AccountUtils.p(AppContext.getContext()));
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.QRCodeScan.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0947a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f12133a;

        public C0947a(e eVar) {
            this.f12133a = eVar;
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            if (!yy2Var.f22300a || (jSONObject2 = yy2Var.d) == null) {
                return;
            }
            this.f12133a.a(jSONObject2.optString("code"));
        }

        @Override // defpackage.yw4
        public boolean toastOnFail() {
            return true;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }
}
