package com.zenmen.palmchat.loginnew;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.auth.onekey.prelogin.PreLoginResult;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.loginnew.b;
import com.zenmen.palmchat.loginnew.view.AgreementDialog;
import com.zenmen.palmchat.loginnew.view.AuthLoginBackDialog;
import com.zenmen.palmchat.loginnew.view.AuthLoginButton;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.ch;
import defpackage.e73;
import defpackage.me1;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.ts2;
import defpackage.uk5;
import defpackage.vq2;
import defpackage.vu2;
import defpackage.x63;
import defpackage.y63;
import defpackage.zm4;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AuthLoginActivity extends BaseLoginActivity {
    public ImageView A;
    public TextView B;
    public vq2 C;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public View t;
    public TextView u;
    public AuthLoginButton v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ts2.i(AuthLoginActivity.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AgreementDialog.d {
        public b() {
        }

        @Override // com.zenmen.palmchat.loginnew.view.AgreementDialog.d
        public void onCancel() {
            HashMap<String, Object> mapE = x63.e(AuthLoginActivity.this.G);
            LogUtil.uploadInfoImmediate("lx_client_quicklogin_popclose", mapE);
            zn6.j("lx_client_quicklogin_popclose", "click", mapE);
        }

        @Override // com.zenmen.palmchat.loginnew.view.AgreementDialog.d
        public void onConfirm() {
            HashMap<String, Object> mapE = x63.e(AuthLoginActivity.this.G);
            LogUtil.uploadInfoImmediate("lx_client_quicklogin_popclick", mapE);
            zn6.j("lx_client_quicklogin_popclick", "click", mapE);
            AuthLoginActivity.this.E = true;
            AuthLoginActivity.this.A.setImageResource(R.drawable.ic_login_privacy_selected);
            AuthLoginActivity.this.h2(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AuthLoginBackDialog.d {
        public c() {
        }

        @Override // com.zenmen.palmchat.loginnew.view.AuthLoginBackDialog.d
        public void a() {
            HashMap<String, Object> mapE = x63.e(AuthLoginActivity.this.G);
            mapE.put("type", "continue");
            LogUtil.uploadInfoImmediate("lx_client_login_slidepopclick", mapE);
        }

        @Override // com.zenmen.palmchat.loginnew.view.AuthLoginBackDialog.d
        public void b() {
            AuthLoginActivity.this.finish();
            HashMap<String, Object> mapE = x63.e(AuthLoginActivity.this.G);
            mapE.put("type", "refuse");
            LogUtil.uploadInfoImmediate("lx_client_login_slidepopclick", mapE);
        }

        @Override // com.zenmen.palmchat.loginnew.view.AuthLoginBackDialog.d
        public void onCancel() {
            LogUtil.uploadInfoImmediate("lx_client_login_slidepopback", x63.e(AuthLoginActivity.this.G));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthLoginActivity.this.n2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(View view) {
        if (this.v.hasProgress()) {
            return;
        }
        SmidHelper.r();
        b05.d("QuickAuthManger.getInstance().getMobileTypeForUI()=" + com.zenmen.palmchat.loginnew.b.u().v());
        if (com.zenmen.palmchat.loginnew.b.u().v() == 0) {
            c2(0);
            HashMap<String, Object> mapE = x63.e(this.G);
            LogUtil.uploadInfoImmediate("lx_client_login_loginpageclick", mapE);
            zn6.j("lx_client_login_loginpageclick", "click", mapE);
            return;
        }
        HashMap<String, Object> mapE2 = x63.e(com.zenmen.palmchat.loginnew.b.u().v());
        mapE2.put("status", Integer.valueOf(this.E ? 1 : 0));
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_click", mapE2);
        zn6.j("lx_client_quicklogin_click", "click", mapE2);
        if (this.E) {
            h2(false);
        } else {
            i2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(View view) {
        SmidHelper.r();
        c2(6);
        HashMap<String, Object> mapE = x63.e(this.G);
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_other", mapE);
        zn6.j("lx_client_quicklogin_other", "click", mapE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(View view) {
        SmidHelper.r();
        boolean z = !this.E;
        this.E = z;
        this.A.setImageResource(z ? R.drawable.ic_login_privacy_selected : R.drawable.ic_login_privacy_quick_unselect);
        HashMap<String, Object> mapE = x63.e(this.G);
        mapE.put("status", Integer.valueOf(this.E ? 1 : 0));
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_agreement", mapE);
        zn6.j("lx_client_quicklogin_agreement", "click", mapE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(int i, int i2, Object obj) {
        LXBaseNetBean<JSONObject> lXBaseNetBean;
        if (obj instanceof PreLoginResult) {
            PreLoginResult preLoginResult = (PreLoginResult) obj;
            if (preLoginResult.mRetCode != 0 && (lXBaseNetBean = preLoginResult.loginResult) != null) {
                D1(lXBaseNetBean, i2, true);
                return;
            } else {
                sy5.e(this, R.string.login_auth_fail, 0).g();
                c2(5);
                return;
            }
        }
        String str = (String) obj;
        int i3 = (i != 1 || TextUtils.isEmpty(str)) ? 0 : 1;
        HashMap<String, Object> mapE = x63.e(com.zenmen.palmchat.loginnew.b.u().s());
        mapE.put("result", Integer.valueOf(i3));
        y63.h("sdk_auto_suc");
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_resp", mapE);
        zn6.j("lx_client_quicklogin_resp", null, mapE);
        if (i3 != 0) {
            B1(i2 == 4, str, i2, false);
        } else if (i == 50) {
            sy5.f(this, "请升级至最新版本", 0).g();
            c2(5);
        } else {
            sy5.e(this, R.string.login_auth_fail, 0).g();
            c2(5);
        }
    }

    public static void k2(Activity activity, boolean z, boolean z2) {
        Intent intent = new Intent(activity, (Class<?>) AuthLoginActivity.class);
        Intent intent2 = activity.getIntent();
        if (intent2 != null) {
            if (intent2.getExtras() != null) {
                intent.putExtras(intent2.getExtras());
            }
            if (intent2.getAction() != null) {
                intent.setAction(intent2.getAction());
            }
            if (intent2.getType() != null) {
                intent.setType(intent2.getType());
            }
        }
        intent.putExtra("key_has_share", z);
        intent.putExtra("key_from_open_sdk", z2);
        activity.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity
    public void F1(int i) {
        this.F = false;
        this.v.stopAnimation();
        CompleteLoginActivity.d2(this, i, this.r, this.q);
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity
    public void K1(boolean z) {
        this.F = false;
        this.v.stopAnimation();
        this.v.setText(getString(R.string.login_fail_btn));
        l2();
    }

    public void a2() {
        if (y63.k(this) != null) {
            F1(7);
            LogUtil.uploadInfoImmediate("lx_client_login_jump_complete", x63.e(7));
            zn6.j("lx_client_login_jump_complete", null, x63.e(7));
        }
    }

    public final void b2() {
        setContentView(R.layout.layout_activity_auth_login);
        me1.o(getWindow(), false);
        getWindow().setNavigationBarColor(-16777216);
        TextView textView = (TextView) findViewById(R.id.login_slogan);
        this.u = textView;
        textView.setText(e73.n());
        View viewFindViewById = findViewById(R.id.login_bg);
        this.t = viewFindViewById;
        viewFindViewById.setVisibility(0);
        Drawable drawable = getResources().getDrawable(R.drawable.bg_init);
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                vq2 vq2Var = new vq2(this, bitmapDrawable.getBitmap());
                this.C = vq2Var;
                this.t.setBackgroundDrawable(vq2Var);
            }
        }
        findViewById(R.id.visitor).setOnClickListener(new a());
        AuthLoginButton authLoginButton = (AuthLoginButton) findViewById(R.id.login_btn);
        this.v = authLoginButton;
        authLoginButton.setOnClickListener(new View.OnClickListener() { // from class: km
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18719a.d2(view);
            }
        });
        this.w = (TextView) findViewById(R.id.phone_number_mask);
        this.x = (TextView) findViewById(R.id.auth_title);
        TextView textView2 = (TextView) findViewById(R.id.other_login);
        this.y = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: lm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19028a.e2(view);
            }
        });
        this.z = findViewById(R.id.agreement_layout);
        ImageView imageView = (ImageView) findViewById(R.id.img_select);
        this.A = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: mm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19263a.f2(view);
            }
        });
        this.B = (TextView) findViewById(R.id.tv_agreement);
        n2(true);
    }

    public final void c2(int i) {
        this.F = false;
        this.v.stopAnimation();
        CompleteLoginActivity.e2(this, i, this.r, this.q);
    }

    public final void h2(boolean z) {
        com.zenmen.palmchat.loginnew.b.u().p(this, new b.e() { // from class: nm
            @Override // com.zenmen.palmchat.loginnew.b.e
            public final void a(int i, int i2, Object obj) {
                this.f19557a.g2(i, i2, obj);
            }
        });
        this.F = true;
        this.v.startAnimation();
        m2();
        HashMap<String, Object> mapE = x63.e(this.G);
        mapE.put("from", Integer.valueOf(z ? 2 : 1));
        y63.t();
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_req", mapE);
        zn6.j("lx_client_quicklogin_req", null, mapE);
    }

    public final void i2() {
        AgreementDialog agreementDialog = new AgreementDialog(this, com.zenmen.palmchat.loginnew.b.u().t(), new b());
        agreementDialog.w(false);
        agreementDialog.show();
        HashMap<String, Object> mapE = x63.e(this.G);
        LogUtil.uploadInfoImmediate("lx_client_quicklogin_popshow", mapE);
        zn6.j("lx_client_quicklogin_popshow", "view", mapE);
    }

    public final void j2() {
        new AuthLoginBackDialog(this, new c()).show();
        LogUtil.uploadInfoImmediate("lx_client_login_slidepopshow", x63.e(this.G));
    }

    public final void l2() {
        vq2 vq2Var = this.C;
        if (vq2Var == null || this.F) {
            return;
        }
        vq2Var.b();
    }

    public final void m2() {
        vq2 vq2Var = this.C;
        if (vq2Var != null) {
            vq2Var.c();
        }
    }

    public final void n2(boolean z) {
        int iT = com.zenmen.palmchat.loginnew.b.u().t();
        this.G = iT;
        this.w.setVisibility(iT == 0 ? 4 : 0);
        this.x.setVisibility(this.G == 0 ? 4 : 0);
        this.y.setVisibility(this.G == 0 ? 4 : 0);
        this.z.setVisibility(this.G == 0 ? 4 : 0);
        this.A.setVisibility(this.G == 0 ? 4 : 0);
        this.z.setVisibility(this.G == 0 ? 4 : 0);
        this.B.setText(zm4.d(this, this.G));
        this.B.setMovementMethod(LinkMovementMethod.getInstance());
        this.B.setHighlightColor(getResources().getColor(android.R.color.transparent));
        int i = this.G;
        if (i == 1) {
            this.x.setText(R.string.login_auth_by_cmcc);
        } else if (i == 2) {
            this.x.setText(R.string.login_auth_by_unicom);
        } else if (i == 3) {
            this.x.setText(R.string.login_auth_by_ct);
        } else if (i == 4) {
            this.x.setText(R.string.login_auth_by_wifi);
        }
        if (z) {
            HashMap<String, Object> mapE = x63.e(com.zenmen.palmchat.loginnew.b.u().s());
            mapE.put("status", Integer.valueOf(com.zenmen.palmchat.loginnew.b.u().x() ? 0 : this.G == 0 ? 2 : 1));
            LogUtil.uploadInfoImmediate("lx_client_login_loginpageshow", mapE);
            zn6.j("lx_client_login_loginpageshow", "view", mapE);
            this.H = System.currentTimeMillis();
        }
        if (this.G != 0) {
            this.w.setText(com.zenmen.palmchat.loginnew.b.u().w());
            HashMap<String, Object> mapE2 = x63.e(com.zenmen.palmchat.loginnew.b.u().s());
            mapE2.put("duration", Long.valueOf(z ? 0L : System.currentTimeMillis() - this.H));
            LogUtil.uploadInfoImmediate("lx_client_quicklogin_show", mapE2);
            zn6.j("lx_client_quicklogin_show", "view", mapE2);
            this.H = System.currentTimeMillis();
        }
    }

    @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setNeedShowKickOutDialog(false);
        L1(bundle);
        if (com.zenmen.palmchat.loginnew.b.u().A()) {
            com.zenmen.palmchat.loginnew.b.u().C();
        }
        b2();
        a2();
        try {
            ch.s().r().j(this);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        vu2.c().e();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ch.s().r().l(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        HashMap<String, Object> mapE = x63.e(this.G);
        LogUtil.uploadInfoImmediate("lx_client_login_loginpageback", mapE);
        zn6.j("lx_client_login_loginpageback", "click", mapE);
        j2();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l2();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i("AuthLoginActivity", " onStatusChanged eventType ：" + uk5Var.f21235a);
        int i = uk5Var.f21235a;
        if (i != 45) {
            if (i != 47) {
                return;
            }
            runOnUiThread(new d());
        } else {
            if (isFinishing()) {
                return;
            }
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        m2();
        super.onStop();
    }
}
