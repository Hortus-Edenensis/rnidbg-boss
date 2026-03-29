package com.zenmen.palmchat.settings.pr;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import cn.wh.auth.OnCallBack;
import cn.wh.auth.WAuthService;
import cn.wh.auth.bean.Result;
import cn.wh.auth.bean.WParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.bl4;
import defpackage.ds0;
import defpackage.go2;
import defpackage.hx3;
import defpackage.l50;
import defpackage.nl0;
import defpackage.sw4;
import defpackage.w4;
import defpackage.x4;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PrAuthenActivity extends BaseActionBarActivity {
    public View q = null;
    public View r = null;
    public View s = null;
    public View t = null;
    public View u = null;
    public View v = null;
    public View w = null;
    public int x = 0;
    public String y = "数据异常，认证失败";
    public boolean z = false;
    public boolean A = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements OnCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15323a;

        public a(String str) {
            this.f15323a = str;
        }

        @Override // cn.wh.auth.OnCallBack
        public void onResult(Result result) {
            String resultCode = result.getResultCode();
            String resultDesc = result.getResultDesc();
            LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity startAuthApp onResult resultCode " + resultCode + " resultDesc " + resultDesc);
            if (!"C0000000".equals(resultCode)) {
                PrAuthenActivity.this.H1("认证失败:" + resultDesc);
                if ("C0412002".equals(resultCode)) {
                    w4.E(PrAuthenActivity.this);
                    return;
                }
                return;
            }
            String idCardAuthData = result.getResultData().getIdCardAuthData();
            String certPwdData = result.getResultData().getCertPwdData();
            LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity startAuthApp onResult idCardAuthData " + idCardAuthData + " certPwdData " + certPwdData);
            if (!TextUtils.isEmpty(idCardAuthData) && !TextUtils.isEmpty(certPwdData)) {
                PrAuthenActivity.this.N1(this.f15323a, certPwdData, idCardAuthData);
            } else {
                PrAuthenActivity prAuthenActivity = PrAuthenActivity.this;
                prAuthenActivity.H1(prAuthenActivity.y);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<PrPostData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15324a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(String str, String str2, String str3) {
            this.f15324a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("bizSeq", this.f15324a);
            map.put("certPwdData", this.b);
            map.put("idCardAuthData", this.c);
            return sw4.b(1, nl0.z + "/cash.network.bind.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<PrPostData> lXBaseNetBean, Exception exc) {
            LogUtil.i("AccountPrAuthenManager", "postAuthen info onResult=" + az2.c(lXBaseNetBean));
            PrAuthenActivity.this.A = false;
            if (lXBaseNetBean == null) {
                PrAuthenActivity prAuthenActivity = PrAuthenActivity.this;
                prAuthenActivity.H1(prAuthenActivity.y);
            } else if (lXBaseNetBean.resultCode == 0) {
                PrAuthenActivity.this.I1();
            } else if (!TextUtils.isEmpty(lXBaseNetBean.errorMsg)) {
                PrAuthenActivity.this.H1(lXBaseNetBean.errorMsg);
            } else {
                PrAuthenActivity prAuthenActivity2 = PrAuthenActivity.this;
                prAuthenActivity2.H1(prAuthenActivity2.y);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PrAuthenActivity.this.J1();
            w4.p("Accountset_PRCauthentication_failed_submitagain");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PrAuthenActivity.this.J1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            PrAuthenActivity.this.Q1();
            w4.p("Accountset_PRCauthentication_cancel");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            w4.p("Accountset_PRCauthentication_cancel");
            PrAuthenActivity.this.finish();
        }
    }

    public final void H1(String str) {
        LogUtil.i("AccountPrAuthenManager", "authFailed start msg" + str + " from " + this.x);
        if (this.x == 1) {
            x4 x4Var = new x4(x4.k);
            x4Var.b = str;
            ds0.a().b(x4Var);
            finish();
            return;
        }
        O1();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Toast.makeText(this, str, 0).show();
    }

    public final void I1() {
        LogUtil.i("AccountPrAuthenManager", "authSuccess start  from " + this.x);
        if (this.x != 1) {
            P1();
        } else {
            ds0.a().b(new x4(x4.j));
            finish();
        }
    }

    public final void J1() {
        if (!hx3.m(AppContext.getContext())) {
            LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen 无网络");
            M1();
            return;
        }
        LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen 网络正常");
        if (this.z) {
            LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen isPrAuthen 已经完成身份验证");
            P1();
            return;
        }
        ArrayList<String> arrayListT = w4.t(com.zenmen.palmchat.c.b());
        boolean z = false;
        if (arrayListT != null && (arrayListT.size() != 1 || !com.zenmen.palmchat.c.b().getPackageName().equals(arrayListT.get(0)))) {
            z = true;
        }
        LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen perInstall " + z);
        if (!z) {
            R1();
            return;
        }
        LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen isPrAuthen 未完成身份验证");
        if (!w4.k(arrayListT)) {
            w4.E(this);
        } else {
            LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity checkPrAuthen app 已经安装");
            R1();
        }
    }

    public final void K1() {
        if (getIntent() != null) {
            this.x = getIntent().getIntExtra("authen_from", 0);
            this.z = getIntent().getBooleanExtra("authen_status", false);
        }
        LogUtil.d("AccountPrAuthenManager", "PrAuthenActivity initIntent from " + this.x + " isPrAuthen " + this.z);
    }

    public final void L1() {
        this.q = findViewById(R.id.net_error_layout);
        this.r = findViewById(R.id.pr_authen_success_layout);
        this.s = findViewById(R.id.pr_authen_failed_layout);
        this.t = findViewById(R.id.net_err_refresh);
        View viewFindViewById = findViewById(R.id.pr_authen_failed_btn);
        this.u = viewFindViewById;
        viewFindViewById.setOnClickListener(new c());
        this.t.setOnClickListener(new d());
        View viewFindViewById2 = findViewById(R.id.pr_authen_success_delete);
        this.v = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new e());
        View viewFindViewById3 = findViewById(R.id.pr_authen_success_know);
        this.w = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new f());
    }

    public final void M1() {
        this.q.setVisibility(0);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
    }

    public final void N1(String str, String str2, String str3) {
        LogUtil.i("AccountPrAuthenManager", "postAuthen start mIsRequesting" + this.A);
        if (this.A) {
            return;
        }
        zw4.e(new b(str, str2, str3));
    }

    public final void O1() {
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.s.setVisibility(0);
    }

    public final void P1() {
        this.q.setVisibility(8);
        this.r.setVisibility(0);
        this.s.setVisibility(8);
    }

    public final void Q1() {
        new bl4(this).show();
    }

    public final void R1() {
        String strO = w4.o();
        new WAuthService(this, new WParams("00000304", "0001", strO, 1, "")).getAuthResult(new a(strO));
        LogUtil.d("AccountPrAuthenManager", "startAuthApp start app");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    public final void initActionBar() {
        initToolbar("身份认证");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_prauthen);
        K1();
        initActionBar();
        L1();
        J1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
