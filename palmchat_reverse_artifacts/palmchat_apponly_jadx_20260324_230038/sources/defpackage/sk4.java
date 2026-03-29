package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.settings.portrait.ProfileEditConfig;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sk4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20767a = false;
    public View b;
    public TextView c;
    public ProfileEditConfig d;
    public Activity e;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<ProfileEditConfig>> {
        public a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/userem.update.userinfo.check.v1", new HashMap()).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ProfileEditConfig> lXBaseNetBean, Exception exc) {
            if (z && lXBaseNetBean != null && lXBaseNetBean.resultCode == 0) {
                sk4.this.d = lXBaseNetBean.data;
                sk4.this.i();
            }
            if (sk4.this.f20767a) {
                sk4.this.d = new ProfileEditConfig();
                sk4.this.i();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20769a;

        public b(Runnable runnable) {
            this.f20769a = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.cancel();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.cancel();
            this.f20769a.run();
            sk4.this.d = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            materialDialog.cancel();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            materialDialog.cancel();
        }
    }

    public void d(Activity activity) {
        this.e = activity;
        this.b = activity.findViewById(R.id.tip3Layout);
        this.c = (TextView) activity.findViewById(R.id.tips3Tv);
        e();
    }

    public final void e() {
        zw4.e(new a());
    }

    public final void f(int i) {
        HashMap map = new HashMap();
        map.put("from", String.valueOf(99));
        map.put("type", String.valueOf(i));
        zn6.i("newpageprofi_profileh5_lastpop", map);
    }

    public void g(boolean z, Runnable runnable) {
        ProfileEditConfig profileEditConfig;
        ProfileEditConfig profileEditConfig2;
        if (z && (profileEditConfig2 = this.d) != null && profileEditConfig2.needShowLastChance()) {
            sd3 sd3Var = new sd3(this.e);
            sd3Var.k("当前仅可再提交一次头像内容，提交后将无法再次修改，确认提交吗");
            sd3Var.P("提交");
            sd3Var.L("放弃");
            sd3Var.f(new b(runnable));
            sd3Var.Q();
            f(1);
            return;
        }
        if (!z || (profileEditConfig = this.d) == null || profileEditConfig.canModifyPortrait()) {
            runnable.run();
            return;
        }
        sd3 sd3Var2 = new sd3(this.e);
        sd3Var2.k("头像修改次数已用尽，无法提交修改！");
        sd3Var2.P("我知道了");
        sd3Var2.f(new c());
        sd3Var2.Q();
        f(2);
    }

    public void h(JSONObject jSONObject) {
        if (this.e.isFinishing()) {
            return;
        }
        int iOptInt = jSONObject.optInt("resultCode");
        String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (iOptInt == 1137) {
            sd3 sd3Var = new sd3(this.e);
            sd3Var.k(strOptString);
            sd3Var.P("我知道了");
            sd3Var.Q();
            f(2);
            return;
        }
        if (iOptInt == 1138) {
            sd3 sd3Var2 = new sd3(this.e);
            sd3Var2.k(strOptString);
            sd3Var2.P("好的");
            sd3Var2.Q();
            f(3);
        }
    }

    public final void i() {
        ProfileEditConfig profileEditConfig = this.d;
        if (profileEditConfig == null || TextUtils.isEmpty(profileEditConfig.getPortraitTips())) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.c.setText(this.d.getPortraitTips());
        }
    }
}
