package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.openapi.LoginResult;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.loginnew.BaseLoginActivity;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.verifycode.VerifyCodeView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.az2;
import defpackage.ch;
import defpackage.cl6;
import defpackage.ds0;
import defpackage.hx3;
import defpackage.il5;
import defpackage.l50;
import defpackage.lo;
import defpackage.nl0;
import defpackage.nx4;
import defpackage.q05;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.uk5;
import defpackage.w4;
import defpackage.x4;
import defpackage.x63;
import defpackage.y63;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VerifyFragment extends BaseLoginFragment {
    public static final String L = "VerifyFragment";
    public boolean A;
    public String B;
    public String C;
    public String E;
    public String F;
    public String G;
    public int H;
    public boolean I;
    public long J;
    public boolean K = false;
    public Activity h;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public TextView p;
    public n q;
    public VerifyCodeView r;
    public EditText s;
    public Timer t;
    public TimerTask u;
    public int v;
    public boolean w;
    public com.zenmen.palmchat.loginnew.a x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f14547a;

        public a(uk5 uk5Var) {
            this.f14547a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14547a.f21235a != 2) {
                return;
            }
            int iY = ch.s().y();
            LogUtil.d(VerifyFragment.L, "network status changed:" + iY);
            if (iY == 1 && !il5.l(VerifyFragment.this.r.getVcText()) && VerifyFragment.this.r.getVcText().length() == cl6.f()) {
                VerifyFragment verifyFragment = VerifyFragment.this;
                verifyFragment.O0(verifyFragment.r.getVcText());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VerifyFragment.this.x.n(VerifyFragment.this.g);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_dlg_back", mapE);
            zn6.j("lx_client_messagelogin_verify_dlg_back", "click", mapE);
            VerifyFragment.this.x.n(VerifyFragment.this.g);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_dlg_wait", mapE);
            zn6.j("lx_client_messagelogin_verify_dlg_wait", "click", mapE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends TimerTask {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VerifyFragment.this.isAdded()) {
                    if (com.zenmen.palmchat.loginnew.b.u().z().booleanValue()) {
                        if (VerifyFragment.this.v <= 0) {
                            VerifyFragment.this.l.setText("重新发送");
                            VerifyFragment.this.l.setAlpha(1.0f);
                            return;
                        } else {
                            TextView textView = VerifyFragment.this.l;
                            VerifyFragment verifyFragment = VerifyFragment.this;
                            textView.setText(verifyFragment.getString(R.string.validate_sms_code_countdown_new1, Integer.valueOf(verifyFragment.v)));
                            VerifyFragment.this.l.setAlpha(0.3f);
                            return;
                        }
                    }
                    if (VerifyFragment.this.v <= 0) {
                        VerifyFragment.this.k.setVisibility(8);
                        VerifyFragment.this.m.setVisibility(0);
                        return;
                    }
                    VerifyFragment.this.k.setVisibility(0);
                    TextView textView2 = VerifyFragment.this.k;
                    VerifyFragment verifyFragment2 = VerifyFragment.this;
                    textView2.setText(verifyFragment2.getString(R.string.validate_sms_code_countdown_new, Integer.valueOf(verifyFragment2.v)));
                    VerifyFragment.this.m.setVisibility(8);
                }
            }
        }

        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            VerifyFragment verifyFragment = VerifyFragment.this;
            verifyFragment.v--;
            if (VerifyFragment.this.v == 0) {
                VerifyFragment.this.a1();
                HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_timeout", mapE);
                zn6.j("lx_client_messagelogin_verify_timeout", "view", mapE);
            }
            if (VerifyFragment.this.h.isFinishing() || VerifyFragment.this.isDetached() || !VerifyFragment.this.w) {
                return;
            }
            VerifyFragment.this.h.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VerifyFragment.this.Q0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements VerifyCodeView.c {
        public f() {
        }

        @Override // com.zenmen.palmchat.widget.verifycode.VerifyCodeView.c
        public void d(String str) {
            if (!TextUtils.isEmpty(str) && !VerifyFragment.this.y) {
                VerifyFragment.this.y = true;
                if (VerifyFragment.this.p.getVisibility() != 4) {
                    VerifyFragment.this.p.setVisibility(4);
                }
                HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                mapE.put("codenumber", Integer.valueOf(str.length()));
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_input", mapE);
                zn6.j("lx_client_messagelogin_verify_input", "click", mapE);
            }
            if (TextUtils.isEmpty(str) || str.length() != cl6.f()) {
                return;
            }
            HashMap<String, Object> mapE2 = x63.e(VerifyFragment.this.H);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_complete", mapE2);
            zn6.j("lx_client_messagelogin_verify_complete", "click", mapE2);
            VerifyFragment.this.K0();
            VerifyFragment.this.O0(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("lx_client_messagelogin_verify__helpclick", 2, null);
            SAppUtil.J(VerifyFragment.this.getActivity(), nl0.h() ? "https://assets-pre.lianxinapp.com/hint/#/" : nl0.c().equals("release") ? "https://assets.cdn.lianxinapp.com/hint/#/" : "https://short1.lx-qa.com/mapps/hint/#/", false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nx4<LXBaseNetBean<JSONObject>> {
            public a() {
            }

            @Override // defpackage.nx4
            public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
                if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                    return;
                }
                int i = lXBaseNetBean.resultCode;
                if (i == 202) {
                    VerifyFragment.this.S0();
                    sy5.e(VerifyFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                    VerifyFragment.this.X0();
                } else if (i == 200 || lXBaseNetBean.isNetError()) {
                    sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                } else {
                    VerifyFragment.this.x.x0(lXBaseNetBean, VerifyFragment.this.H);
                }
                VerifyFragment.this.G();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements BLCallback {
            public b() {
            }

            @Override // com.lantern.auth.core.BLCallback
            public void run(int i, String str, Object obj) {
                if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                    return;
                }
                LoginResult loginResult = (LoginResult) obj;
                if (i != 1) {
                    sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                    VerifyFragment.this.G();
                } else if (!TextUtils.isEmpty(loginResult.mAuthCode)) {
                    y63.h("sdk_verify_suc");
                    VerifyFragment.this.x.A(false, loginResult.mAuthCode, VerifyFragment.this.H, true, null);
                } else {
                    VerifyFragment.this.S0();
                    sy5.e(VerifyFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                    VerifyFragment.this.G();
                    VerifyFragment.this.X0();
                }
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l50.a() && VerifyFragment.this.v <= 0) {
                q05.a("lx_client_messagelogin_verify_button_click", 2, null);
                if (hx3.m(AppContext.getContext())) {
                    VerifyFragment.this.L();
                    if (VerifyFragment.this.A) {
                        VerifyFragment.this.R0();
                    } else if (VerifyFragment.this.z) {
                        Activity activity = VerifyFragment.this.h;
                        VerifyFragment verifyFragment = VerifyFragment.this;
                        cl6.e(activity, verifyFragment.F, verifyFragment.G, new a());
                    } else {
                        VerifyFragment verifyFragment2 = VerifyFragment.this;
                        cl6.c(verifyFragment2.F, verifyFragment2.G, new b());
                    }
                } else {
                    sy5.e(VerifyFragment.this.h, R.string.net_status_unavailable, 0).g();
                }
                HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_resend", mapE);
                zn6.j("lx_client_messagelogin_verify_resend", "click", mapE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements nx4<LXBaseNetBean<JSONObject>> {
            public a() {
            }

            @Override // defpackage.nx4
            public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
                if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                    return;
                }
                int i = lXBaseNetBean.resultCode;
                if (i == 202) {
                    VerifyFragment.this.S0();
                    sy5.e(VerifyFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                    VerifyFragment.this.X0();
                } else if (i == 200 || lXBaseNetBean.isNetError()) {
                    sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                } else {
                    VerifyFragment.this.x.x0(lXBaseNetBean, VerifyFragment.this.H);
                }
                VerifyFragment.this.G();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements BLCallback {
            public b() {
            }

            @Override // com.lantern.auth.core.BLCallback
            public void run(int i, String str, Object obj) {
                if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                    return;
                }
                LoginResult loginResult = (LoginResult) obj;
                if (i != 1) {
                    sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                    VerifyFragment.this.G();
                } else if (!TextUtils.isEmpty(loginResult.mAuthCode)) {
                    y63.h("sdk_verify_suc");
                    VerifyFragment.this.x.A(false, loginResult.mAuthCode, VerifyFragment.this.H, true, null);
                } else {
                    VerifyFragment.this.S0();
                    sy5.e(VerifyFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                    VerifyFragment.this.G();
                    VerifyFragment.this.X0();
                }
            }
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (hx3.m(AppContext.getContext())) {
                VerifyFragment.this.L();
                if (VerifyFragment.this.A) {
                    VerifyFragment.this.R0();
                } else if (VerifyFragment.this.z) {
                    Activity activity = VerifyFragment.this.h;
                    VerifyFragment verifyFragment = VerifyFragment.this;
                    cl6.e(activity, verifyFragment.F, verifyFragment.G, new a());
                } else {
                    VerifyFragment verifyFragment2 = VerifyFragment.this;
                    cl6.c(verifyFragment2.F, verifyFragment2.G, new b());
                }
            } else {
                sy5.e(VerifyFragment.this.h, R.string.net_status_unavailable, 0).g();
            }
            HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_resend", mapE);
            zn6.j("lx_client_messagelogin_verify_resend", "click", mapE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements nx4<LXBaseNetBean<JSONObject>> {
        public j() {
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                return;
            }
            LogUtil.i("AccountPrAuthenManager", "loginPrClick onResultPrLogin info onResult=" + az2.c(lXBaseNetBean));
            VerifyFragment.this.G();
            if (lXBaseNetBean == null) {
                sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == 202) {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick onResultPrLogin 短信验证码发送成功");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bizSeq", VerifyFragment.this.B);
                    jSONObject.put("certPwData", VerifyFragment.this.C);
                    jSONObject.put("idCardAuthData", VerifyFragment.this.E);
                    com.zenmen.palmchat.loginnew.a aVar = VerifyFragment.this.x;
                    VerifyFragment verifyFragment = VerifyFragment.this;
                    aVar.x(verifyFragment.f, verifyFragment.H, verifyFragment.F, verifyFragment.G, true, jSONObject);
                    sy5.e(VerifyFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (i == 200 || lXBaseNetBean.isNetError()) {
                sy5.e(VerifyFragment.this.h, R.string.send_failed, 0).g();
                return;
            }
            if (lXBaseNetBean.resultCode == 0) {
                HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_freeaccess", mapE);
                zn6.j("lx_client_messagelogin_freeaccess", null, mapE);
                y63.h("sdk_verify_suc");
            }
            VerifyFragment.this.x.x0(lXBaseNetBean, VerifyFragment.this.H);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements nx4<LXBaseNetBean<JSONObject>> {
        public k() {
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                return;
            }
            LogUtil.i("AccountPrAuthenManager", "loginPrClick VerifyFragment loginBySMSCode info onResult=" + az2.c(lXBaseNetBean));
            VerifyFragment.this.L0();
            if (lXBaseNetBean == null) {
                sy5.f(VerifyFragment.this.h, VerifyFragment.this.getString(R.string.login_verify_code_error), 0).g();
                return;
            }
            if (!lXBaseNetBean.isNetError()) {
                String string = lXBaseNetBean.errorMsg;
                if (lXBaseNetBean.resultCode == 201) {
                    string = VerifyFragment.this.getString(R.string.login_verify_code_error);
                    VerifyFragment.this.p.startAnimation(AnimationUtils.loadAnimation(VerifyFragment.this.getContext(), R.anim.anim_shake));
                    VerifyFragment.this.s.setText("");
                    VerifyFragment.this.r.clearVcText();
                    VerifyFragment.this.X0();
                }
                if (lXBaseNetBean.resultCode != -13) {
                    if (TextUtils.isEmpty(string)) {
                        VerifyFragment.this.p.setVisibility(4);
                    } else {
                        VerifyFragment.this.p.setText(string);
                        VerifyFragment.this.p.setVisibility(0);
                    }
                }
            }
            int i = lXBaseNetBean.resultCode;
            if (i != -13) {
                if (i != 201) {
                    VerifyFragment.this.x.x0(lXBaseNetBean, VerifyFragment.this.H);
                }
            } else {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick VerifyFragment loginBySMSCode 该手机号已绑定其他身份信息，请更换新手机号绑定");
                sy5.f(VerifyFragment.this.h, "该手机号已绑定其他身份信息，请更换新手机号绑定", 0).g();
                ds0.a().b(new x4(x4.e));
                VerifyFragment.this.x.n(VerifyFragment.this.g);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements nx4<LXBaseNetBean<JSONObject>> {
        public l() {
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            int i;
            if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                return;
            }
            VerifyFragment.this.L0();
            if (!lXBaseNetBean.isSuccess()) {
                HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                if (lXBaseNetBean.isNetError()) {
                    i = 0;
                } else {
                    String string = lXBaseNetBean.errorMsg;
                    if (lXBaseNetBean.resultCode == 201) {
                        string = VerifyFragment.this.getString(R.string.login_verify_code_error);
                        VerifyFragment.this.p.startAnimation(AnimationUtils.loadAnimation(VerifyFragment.this.getContext(), R.anim.anim_shake));
                        VerifyFragment.this.s.setText("");
                        VerifyFragment.this.r.clearVcText();
                        VerifyFragment.this.X0();
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (TextUtils.isEmpty(string)) {
                        VerifyFragment.this.p.setVisibility(4);
                    } else {
                        VerifyFragment.this.p.setText(string);
                        VerifyFragment.this.p.setVisibility(0);
                    }
                }
                mapE.put("result", 0);
                mapE.put("invalidcode", Integer.valueOf(i));
                mapE.put("errormsg", lXBaseNetBean.errorMsg);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_ret", mapE);
                zn6.j("lx_client_messagelogin_verify_ret", null, mapE);
            }
            if (lXBaseNetBean.resultCode != 201) {
                VerifyFragment.this.x.x0(lXBaseNetBean, VerifyFragment.this.H);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements BLCallback {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f14565a;

            /* JADX INFO: renamed from: com.zenmen.palmchat.loginnew.fragment.VerifyFragment$m$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1072a implements BaseLoginActivity.h {
                public C1072a() {
                }

                @Override // com.zenmen.palmchat.loginnew.BaseLoginActivity.h
                public void a() {
                    VerifyFragment.this.L0();
                }
            }

            public a(String str) {
                this.f14565a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                y63.h("sdk_verify_suc");
                VerifyFragment.this.x.A(false, this.f14565a, VerifyFragment.this.H, false, new C1072a());
            }
        }

        public m() {
        }

        @Override // com.lantern.auth.core.BLCallback
        public void run(int i, String str, Object obj) {
            if (!VerifyFragment.this.w || VerifyFragment.this.h.isFinishing()) {
                return;
            }
            boolean z = true;
            if (i == 1) {
                try {
                    String str2 = ((LoginResult) obj).mAuthCode;
                    if (TextUtils.isEmpty(str2)) {
                        VerifyFragment.this.L0();
                    } else {
                        VerifyFragment.this.i.postDelayed(new a(str2), 50L);
                        HashMap<String, Object> mapE = x63.e(VerifyFragment.this.H);
                        mapE.put("result", 1);
                        mapE.put("invalidcode", 0);
                        mapE.put("errormsg", 0);
                        LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_ret", mapE);
                        zn6.j("lx_client_messagelogin_verify_ret", null, mapE);
                    }
                    return;
                } catch (Exception e) {
                    VerifyFragment.this.L0();
                    e.printStackTrace();
                    return;
                }
            }
            VerifyFragment.this.L0();
            try {
                HashMap<String, Object> mapE2 = x63.e(VerifyFragment.this.H);
                mapE2.put("result", 0);
                mapE2.put("invalidcode", Integer.valueOf(i == 0 ? 1 : 0));
                if (obj != null) {
                    mapE2.put("errormsg", ((LoginResult) obj).mMsg);
                }
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_ret", mapE2);
                zn6.j("lx_client_messagelogin_verify_ret", null, mapE2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i != 0) {
                sy5.e(VerifyFragment.this.h, R.string.net_status_unavailable, 0).g();
                return;
            }
            try {
                LoginResult loginResult = (LoginResult) obj;
                String str3 = loginResult.mServerRetCd;
                String str4 = loginResult.mMsg;
                if (str3 == null || !str3.equals("H.USER.0047")) {
                    z = false;
                }
                if (TextUtils.isEmpty(str4)) {
                    VerifyFragment.this.p.setVisibility(4);
                } else {
                    if (z) {
                        str = VerifyFragment.this.getString(R.string.login_verify_code_error);
                    }
                    VerifyFragment.this.p.setText(" " + str);
                    VerifyFragment.this.p.setVisibility(0);
                }
                if (z) {
                    VerifyFragment.this.p.startAnimation(AnimationUtils.loadAnimation(VerifyFragment.this.getContext(), R.anim.anim_shake));
                    VerifyFragment.this.s.setText("");
                    VerifyFragment.this.r.clearVcText();
                    VerifyFragment.this.X0();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends Dialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Window f14567a;
        public Animation b;
        public TextView c;
        public ImageView d;

        public n(Context context) {
            super(context, R.style.custom_progress_dialog);
            this.f14567a = getWindow();
            a(context);
        }

        public void a(Context context) {
            WindowManager.LayoutParams attributes = this.f14567a.getAttributes();
            attributes.dimAmount = 0.0f;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(2);
            this.f14567a.requestFeature(1);
            this.f14567a.setContentView(R.layout.layout_verify_progress_dialog);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            this.d = (ImageView) this.f14567a.findViewById(R.id.progress_img_upload);
            this.c = (TextView) this.f14567a.findViewById(R.id.message_textview);
            this.b = AnimationUtils.loadAnimation(context, R.anim.custom_progress_dialog_rotate);
            setCancelable(false);
        }

        @Override // android.app.Dialog
        public void onStart() {
            super.onStart();
            this.d.startAnimation(this.b);
        }

        @Override // android.app.Dialog
        public void onStop() {
            super.onStop();
            this.d.clearAnimation();
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public boolean J() {
        if (!isVisible()) {
            return false;
        }
        Q0();
        return true;
    }

    public void K0() {
        InputMethodManager inputMethodManager;
        Activity activity = this.h;
        if (activity == null || activity.isFinishing() || (inputMethodManager = (InputMethodManager) this.h.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.s.getWindowToken(), 0);
    }

    public final void L0() {
        n nVar = this.q;
        if (nVar != null) {
            try {
                nVar.dismiss();
            } catch (Exception unused) {
            }
        }
        this.K = false;
    }

    public final void M0() {
        Toolbar toolbar = (Toolbar) this.i.findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("");
            toolbar.setNavigationIcon(R.drawable.login_back);
            toolbar.setNavigationOnClickListener(new e());
        }
    }

    public final void N0() {
        this.j = (TextView) this.i.findViewById(R.id.tv_send_num);
        this.p = (TextView) this.i.findViewById(R.id.verif_fail_toast);
        this.n = this.i.findViewById(R.id.loginLayout);
        this.o = this.i.findViewById(R.id.loginLayout_new);
        this.r = (VerifyCodeView) this.i.findViewById(R.id.verify_edit_square);
        EditText editText = (EditText) this.i.findViewById(R.id.verify_edit_square_test);
        this.s = editText;
        this.r.setEditText(editText);
        this.r.setVisibility(0);
        this.r.setOnTextChangedListener(new f());
        this.k = (TextView) this.i.findViewById(R.id.verify_countdown);
        this.l = (TextView) this.i.findViewById(R.id.verify_countdown_new);
        if (com.zenmen.palmchat.loginnew.b.u().z().booleanValue()) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.l.setVisibility(0);
        } else {
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.l.setVisibility(8);
        }
        ((TextView) this.i.findViewById(R.id.not_receive_sms_code)).setOnClickListener(new g());
        this.l.setOnClickListener(new h());
        TextView textView = (TextView) this.i.findViewById(R.id.send_again);
        this.m = textView;
        textView.setOnClickListener(new i());
    }

    public final void O0(String str) {
        if (this.K || !this.w) {
            return;
        }
        String strTrim = str.trim();
        if (hx3.m(AppContext.getContext())) {
            Z0();
            y63.t();
            if (this.A) {
                w4.x(this.F, this.G, strTrim, this.B, this.C, this.E, new k());
            } else if (this.z) {
                cl6.k(this.F, this.G, strTrim, new l());
            } else {
                cl6.j(this.F, this.G, strTrim, new m());
            }
            HashMap<String, Object> mapE = x63.e(this.H);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_send", mapE);
            zn6.j("lx_client_messagelogin_verify_send", null, mapE);
        } else {
            sy5.e(this.h, R.string.net_status_unavailable, 0).g();
        }
        if (strTrim != null) {
            this.I = true;
        }
    }

    public final void Q0() {
        try {
            HashMap<String, Object> mapE = x63.e(this.H);
            mapE.put("submitted", Integer.valueOf(this.I ? 1 : 0));
            mapE.put("staytime", Long.valueOf(System.currentTimeMillis() - this.J));
            mapE.put("codenumber", Integer.valueOf(this.r.getVcText().trim().length()));
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_back", mapE);
            zn6.j("lx_client_messagelogin_verify_back", "click", mapE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        K0();
        new sd3(getContext()).T(R.string.login_verify_back_title).h(true).O(R.string.mend_update_wait).K(R.string.go_back).f(new c()).e().show();
    }

    public final void R0() {
        if (!this.w || this.h.isFinishing()) {
            return;
        }
        L0();
        w4.v(this.h, this.F, this.G, new j());
    }

    public final void S0() {
        this.v = 60;
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
        }
        this.t = new Timer();
        d dVar = new d();
        this.u = dVar;
        this.t.schedule(dVar, 0L, 1000L);
    }

    public void T0(int i2, String str, String str2) {
        this.H = i2;
        this.F = str;
        this.G = str2;
        HashMap<String, Object> mapE = x63.e(i2);
        LogUtil.uploadInfoImmediate("lx_client_messagelogin_verify_show", mapE);
        if (this.A) {
            mapE.put("from", 2);
        } else if (!TextUtils.isEmpty(str2)) {
            mapE.put("from", 1);
        }
        zn6.j("lx_client_messagelogin_verify_show", "view", mapE);
        this.I = false;
        this.y = false;
        this.J = System.currentTimeMillis();
    }

    public void V0(boolean z) {
        this.z = z;
    }

    public void W0(boolean z, String str, String str2, String str3) {
        this.A = z;
        this.B = str;
        this.C = str2;
        this.E = str3;
    }

    public void X0() {
        KeyboardKt.a(this.s, this.h, Keyboard$SHOW_FLAG.IMPLICIT, 300L);
    }

    public final void Z0() {
        if (this.q == null) {
            this.q = new n(getContext());
        }
        this.K = true;
        this.q.show();
    }

    public final void a1() {
        Timer timer = this.t;
        if (timer != null) {
            timer.cancel();
        }
        this.t = null;
    }

    public final void b1() {
        com.zenmen.palmchat.loginnew.a aVar;
        if (!TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(this.G)) {
            this.j.setText(getString(R.string.confirm_phone_number_send_des_new, com.zenmen.palmchat.loginnew.b.u().z().booleanValue() ? this.G.toString() : this.G.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")));
            this.p.setVisibility(4);
            this.s.setText("");
            this.r.clearVcText();
            S0();
            return;
        }
        if (!this.w || (aVar = this.x) == null) {
            return;
        }
        try {
            aVar.n(this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @qm5
    public void onBackLoginPhonePageChanged(lo loVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.h = activity;
        this.x = (com.zenmen.palmchat.loginnew.a) activity;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_verify_code, (ViewGroup) null, false);
        this.i = viewInflate;
        viewInflate.setVisibility(this.w ? 0 : 4);
        M0();
        N0();
        b1();
        return this.i;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        LogUtil.i(L, "onDestroyView");
        a1();
        super.onDestroyView();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i(L, "onResume");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ch.s().r().j(this);
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new a(uk5Var));
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.w = z;
        if (z) {
            View view = this.i;
            if (view != null) {
                view.setVisibility(0);
                b1();
                X0();
                q05.a("lx_client_messagelogin_verify_helpshow", 1, null);
                return;
            }
            return;
        }
        View view2 = this.i;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        K0();
        a1();
        if (this.K) {
            L0();
        }
    }
}
