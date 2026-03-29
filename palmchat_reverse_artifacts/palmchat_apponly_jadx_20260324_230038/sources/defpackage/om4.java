package defpackage;

import android.app.Activity;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.zenmen.openapi.R$string;
import com.zenmen.openapi.webapp.WebAppManager;
import com.zenmen.openapi.webapp.floatview.RemainTimeFloat;
import defpackage.x93;
import java.util.HashMap;
import java.util.UUID;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class om4 implements pt5<qt5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f19792a;
    public d b;
    public String c;
    public boolean d;
    public x93 e;
    public x93 f;
    public CountDownTimer g;
    public RemainTimeFloat h;
    public String i;
    public tn1 j;
    public vy3 k;
    public boolean l;
    public long m = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            f84.b(om4.this.j, "toShow");
            om4 om4Var = om4.this;
            om4Var.q(om4Var.f19792a.getString(R$string.lx_webapp_time_remain));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            om4.this.m = j;
            if (om4.this.h != null) {
                if (j > 600000) {
                    om4.this.h.setVisibility(8);
                    return;
                }
                if (om4.this.h.getVisibility() != 0) {
                    f84.b(om4.this.j, "toPromptShow");
                    om4.this.h.setVisibility(0);
                }
                om4.this.h.setRemainTime(pm4.b(j));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            f84.b(om4.this.j, "anExit");
            om4.this.k(false);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            f84.b(om4.this.j, "anConfirm");
            om4.this.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            om4.this.k(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onCancel();
    }

    public om4(Activity activity, d dVar, String str) {
        this.f19792a = activity;
        this.b = dVar;
        this.c = str;
        tn1 tn1Var = new tn1();
        this.j = tn1Var;
        tn1Var.f18275a = str;
        an1.c().p(this);
    }

    public void h() {
        an1.c().r(this);
        vy3 vy3Var = this.k;
        if (vy3Var != null) {
            vy3Var.cancel(true);
        }
        this.h = null;
        this.f19792a = null;
    }

    public final void i() {
        z93 z93VarB = aa3.b("openapiWebApp");
        String strA = z93VarB.a("nameAuthUrl", n44.e());
        StringBuilder sb = new StringBuilder(strA);
        if (strA.contains(Constants.STRING_VALUE_UNSET)) {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb.append(Constants.STRING_VALUE_UNSET);
        }
        sb.append("thirdAppId=");
        sb.append(this.c);
        wa3.c(this.f19792a, sb.toString(), z93VarB.a("nameAuthAppId", WebAppManager.APPID_WEBAPP_PREVENT), "nameAuth", "");
    }

    public final void j(qt5 qt5Var) {
        if (qt5Var.f20322a != 1) {
            f84.b(this.j, "ucFail");
            return;
        }
        this.j.f = qt5Var.c.toString();
        f84.b(this.j, "ucSuc");
        this.j.f = "";
        String strOptString = qt5Var.c.optString("code");
        if ("0".equals(strOptString)) {
            n(qt5Var);
            return;
        }
        if ("1".equals(strOptString)) {
            r(qt5Var);
            return;
        }
        if ("2".equals(strOptString)) {
            f84.b(this.j, "uaShow");
            q(qt5Var.c.optString("msg"));
        } else if ("3".equals(strOptString)) {
            n(qt5Var);
        } else if (!"5".equals(strOptString) && "6".equals(strOptString)) {
            f84.b(this.j, "adShow");
            q(qt5Var.c.optString("msg"));
        }
    }

    public final void k(boolean z) {
        d dVar = this.b;
        if (dVar == null || z) {
            return;
        }
        dVar.onCancel();
    }

    @Override // defpackage.pt5
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(qt5 qt5Var) {
        j(qt5Var);
        this.l = false;
    }

    public void m() {
        if (this.d) {
            pm4.c("0", this.c, this.i);
        }
        u();
    }

    public final void n(qt5 qt5Var) {
        this.d = true;
        x93 x93Var = this.e;
        if (x93Var != null) {
            x93Var.dismiss();
        }
        this.e = null;
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        this.i = strReplace;
        pm4.c("1", this.c, strReplace);
        long jOptLong = qt5Var.c.optLong("second", -1L) * 1000;
        this.m = jOptLong;
        if (jOptLong > 0) {
            t();
        }
    }

    public void o() {
        s();
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onJsEvent(bx2 bx2Var) {
        ma3.a("gonJsEvent " + bx2Var, new Object[0]);
        if ("nameauth_suc".equals(bx2Var.a())) {
            f84.b(this.j, "anSuc");
        }
    }

    public void p(RemainTimeFloat remainTimeFloat) {
        this.h = remainTimeFloat;
    }

    public final void q(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f19792a.getString(R$string.lx_webapp_children_promt);
        }
        if (this.f == null) {
            this.f = (x93) new x93.a(this.f19792a).T(R$string.lx_open_api_prompt).k(str).O(R$string.lx_open_api_confirm).f(new c()).h(false).e();
        }
        this.f.show();
        this.d = false;
        pm4.c("0", this.c, this.i);
    }

    public final void r(qt5 qt5Var) {
        f84.b(this.j, "anShow");
        String strOptString = qt5Var.c.optString("msg");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = this.f19792a.getString(R$string.lx_webapp_prevent_indulge_promt);
        }
        if (this.e == null) {
            this.e = (x93) new x93.a(this.f19792a).T(R$string.lx_open_api_prompt).K(R$string.lx_webapp_exit_game).O(R$string.lx_webapp_go_nameauth).k(strOptString).b(false).f(new b()).h(false).e();
        }
        this.e.show();
    }

    public void s() {
        if (this.l) {
            return;
        }
        this.l = true;
        HashMap map = new HashMap();
        map.put("thirdAppId", this.c);
        f84.b(this.j, "ucSta");
        this.k = vy3.b("00500103", this, map);
    }

    public final void t() {
        if (this.m > 0) {
            u();
            a aVar = new a(this.m, 1000L);
            this.g = aVar;
            aVar.start();
        }
    }

    public final void u() {
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.g = null;
    }

    @Override // defpackage.pt5
    public void onPreExecute(String str) {
    }
}
