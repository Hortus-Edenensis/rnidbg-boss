package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dc;
import com.umeng.analytics.pro.bd;
import com.zenmen.openapi.OpenApiManager;
import com.zenmen.openapi.R$string;
import com.zenmen.openapi.auth.widget.ConfirmDialogView;
import com.zenmen.openapi.auth.widget.a;
import com.zenmen.openapi.impl.OAAccountUtils;
import com.zenmen.openapi.jssdk.widget.PermissionDialogView;
import defpackage.ka3;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ua3 implements pt5<qt5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e84 f21172a;
    public Activity b;
    public xn4 c;
    public qm d;
    public om e;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ka3.b f21174a;

        public b(ka3.b bVar) {
            this.f21174a = bVar;
        }

        @Override // com.zenmen.openapi.auth.widget.a.b
        public void onConfirmback(int i) {
            if (i == 0) {
                f84.b(ua3.this.d, "confirm_u");
                ua3.this.l(this.f21174a.f21948a, "USERINFO");
            } else {
                f84.b(ua3.this.d, "cancel_u");
                ua3 ua3Var = ua3.this;
                ua3Var.i(2, ua3Var.b.getString(R$string.lx_open_api_user_cancel), null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ka3.b f21175a;

        public c(ka3.b bVar) {
            this.f21175a = bVar;
        }

        @Override // com.zenmen.openapi.auth.widget.a.b
        public void onConfirmback(int i) {
            if (i == 0) {
                f84.b(ua3.this.d, "confirm_m");
                ua3.this.l(this.f21175a.f21948a, "MOBILE");
            } else {
                f84.b(ua3.this.d, "cancel_m");
                ua3 ua3Var = ua3.this;
                ua3Var.i(2, ua3Var.b.getString(R$string.lx_open_api_user_cancel), null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements pt5<qt5> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21176a;

        public d(String str) {
            this.f21176a = str;
        }

        @Override // defpackage.pt5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(qt5 qt5Var) {
            ua3.this.m();
            String strOptString = qt5Var.b;
            if (qt5Var.f20322a == 1) {
                if ("USERINFO".equals(this.f21176a)) {
                    f84.b(ua3.this.d, "suc_u");
                } else if ("MOBILE".equals(this.f21176a)) {
                    f84.b(ua3.this.d, "suc_m");
                }
                strOptString = qt5Var.c.optString("data");
            } else {
                if (qt5Var.c != null) {
                    ua3.this.d.f = qt5Var.c.toString();
                }
                if ("USERINFO".equals(this.f21176a)) {
                    f84.b(ua3.this.d, "fail_u");
                } else if ("MOBILE".equals(this.f21176a)) {
                    f84.b(ua3.this.d, "fail_m");
                }
            }
            ua3.this.i(qt5Var.f20322a, strOptString, qt5Var.c);
        }

        @Override // defpackage.pt5
        public void onPreExecute(String str) {
            ua3.this.q();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21177a;

        public e(String str) {
            this.f21177a = str;
        }

        @Override // com.zenmen.openapi.auth.widget.a.b
        public void onConfirmback(int i) {
            if (i == 0) {
                new f92(ua3.this).executeOnExecutor(jm.a(), this.f21177a, ua3.this.e.f19789a, ua3.this.e.d);
                f84.b(ua3.this.d, "confirm");
            } else {
                ua3 ua3Var = ua3.this;
                ua3Var.i(2, ua3Var.b.getString(R$string.lx_open_api_user_cancel), null);
                f84.b(ua3.this.d, "cancel");
            }
        }
    }

    public ua3(Activity activity, e84 e84Var) {
        this.b = activity;
        this.f21172a = e84Var;
    }

    public void h(ka3.b bVar) {
        qm qmVar = new qm("LX_OPEN_AUTH");
        this.d = qmVar;
        qmVar.f18275a = bVar.f21948a;
        f84.b(qmVar, "sta_s");
        new g92(new a()).executeOnExecutor(jm.a(), bVar.f21948a);
    }

    public final void i(int i, String str, Object obj) {
        e84 e84Var = this.f21172a;
        if (e84Var != null) {
            e84Var.onCallback(i, str, obj);
        }
        p();
    }

    public void j(ka3.b bVar) throws Throwable {
        qm qmVar = new qm("LX_OPEN_AUTH");
        this.d = qmVar;
        qmVar.f18275a = bVar.f21948a;
        o44 userProfile = OAAccountUtils.getUserProfile(OAAccountUtils.getUid());
        PermissionDialogView.a aVar = new PermissionDialogView.a();
        aVar.c = this.b.getString(R$string.lx_auth_mobile_regist, sm.a(userProfile.b()));
        aVar.f12022a = bVar;
        aVar.b = "com.zenmen.palmchat.permissions.GET_PHONENUMBER";
        f84.b(this.d, "show_m");
        w43.h(this.b, aVar, new c(bVar));
    }

    public void k(ka3.b bVar) throws Throwable {
        qm qmVar = new qm("LX_OPEN_AUTH");
        this.d = qmVar;
        qmVar.f18275a = bVar.f21948a;
        o44 userProfile = OAAccountUtils.getUserProfile(OAAccountUtils.getUid());
        ConfirmDialogView.a aVar = new ConfirmDialogView.a();
        aVar.e = userProfile.c();
        aVar.f = userProfile.a();
        aVar.f12015a = "BASE";
        aVar.c = bVar.b;
        aVar.b = bVar.c;
        aVar.d = OpenApiManager.getContext().getString(R$string.lx_auth_userinfo_promt);
        f84.b(this.d, "show_u");
        sm.b(this.b, aVar, new b(bVar));
    }

    public final void l(String str, String str2) {
        new s92(new d(str2)).executeOnExecutor(jm.a(), str, str2);
    }

    public final void m() {
        xn4 xn4Var;
        Activity activity = this.b;
        if (activity == null || activity.isFinishing() || (xn4Var = this.c) == null) {
            return;
        }
        xn4Var.dismiss();
    }

    public void n(om omVar) {
        qm qmVar = new qm("LX_OPEN_AUTH");
        this.d = qmVar;
        qmVar.f18275a = omVar.f19789a;
        qmVar.d = omVar.c;
        this.e = omVar;
        f84.b(qmVar, bd.x);
        new d92(this).executeOnExecutor(jm.a(), omVar);
    }

    @Override // defpackage.pt5
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(qt5 qt5Var) {
        m();
        if (qt5Var.f20322a != 1) {
            JSONObject jSONObject = qt5Var.c;
            if (jSONObject != null) {
                this.d.f = jSONObject.toString();
            }
            f84.b(this.d, "fail");
            this.d.f = "";
            i(qt5Var.f20322a, qt5Var.b, null);
            return;
        }
        String strOptString = qt5Var.c.optString("oauthCode");
        String strOptString2 = qt5Var.c.optString("key");
        if (TextUtils.isEmpty(strOptString)) {
            f84.b(this.d, bq.b.V);
            sm.b(this.b, ConfirmDialogView.a.a(qt5Var.c), new e(strOptString2));
        } else {
            if (d92.class.getSimpleName().equals(qt5Var.d)) {
                f84.b(this.d, dc.F);
            }
            f84.b(this.d, "suc");
            i(qt5Var.f20322a, strOptString, qt5Var.c);
        }
    }

    @Override // defpackage.pt5
    public void onPreExecute(String str) {
        q();
    }

    public void p() {
        this.b = null;
        this.f21172a = null;
    }

    public final void q() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.c == null) {
            Activity activity2 = this.b;
            this.c = db3.a(activity2, activity2.getString(R$string.lx_open_api_auth_loading));
        }
        this.c.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements pt5<qt5> {
        public a() {
        }

        @Override // defpackage.pt5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(qt5 qt5Var) {
            if (qt5Var.f20322a == 1) {
                f84.b(ua3.this.d, "suc_s");
                ua3.this.i(qt5Var.f20322a, qt5Var.c.optString("oauthCode"), qt5Var.c);
            } else {
                if (qt5Var.c != null) {
                    ua3.this.d.f = qt5Var.c.toString();
                }
                f84.b(ua3.this.d, "fail_s");
                ua3.this.d.f = "";
                ua3.this.i(qt5Var.f20322a, qt5Var.b, null);
            }
        }

        @Override // defpackage.pt5
        public void onPreExecute(String str) {
        }
    }
}
