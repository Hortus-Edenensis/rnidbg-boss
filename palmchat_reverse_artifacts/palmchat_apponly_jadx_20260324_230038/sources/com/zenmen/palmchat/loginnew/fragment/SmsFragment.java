package com.zenmen.palmchat.loginnew.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.openalliance.ad.constant.w;
import com.lantern.auth.server.WkParams;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.login.countrycode.CountryCodeListActivity;
import com.zenmen.palmchat.loginnew.view.AgreementDialog;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ClearEditTextView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.a73;
import defpackage.az2;
import defpackage.ch;
import defpackage.cl6;
import defpackage.ds0;
import defpackage.e73;
import defpackage.hx3;
import defpackage.l50;
import defpackage.lo;
import defpackage.nx4;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.sy5;
import defpackage.ts0;
import defpackage.u93;
import defpackage.uk5;
import defpackage.vs0;
import defpackage.w4;
import defpackage.x4;
import defpackage.x63;
import defpackage.y63;
import defpackage.z63;
import defpackage.zm4;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SmsFragment extends BaseLoginFragment {
    public static final String F = "SmsFragment";
    public View A;
    public boolean B;
    public JSONObject C;
    public final int E = 1;
    public Activity h;
    public View i;
    public View j;
    public TextView k;
    public TextView l;
    public ClearEditTextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public boolean r;
    public boolean s;
    public int t;
    public com.zenmen.palmchat.loginnew.a u;
    public View v;
    public ImageView w;
    public TextView x;
    public boolean y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmsFragment.this.m.setText("");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AgreementDialog.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14535a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(int i, String str, String str2) {
            this.f14535a = i;
            this.b = str;
            this.c = str2;
        }

        @Override // com.zenmen.palmchat.loginnew.view.AgreementDialog.d
        public void onCancel() {
            HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_popclose", mapE);
            zn6.j("lx_client_messagelogin_popclose", "click", mapE);
        }

        @Override // com.zenmen.palmchat.loginnew.view.AgreementDialog.d
        public void onConfirm() {
            if (this.f14535a == 1) {
                w4.y(SmsFragment.this.getActivity());
                return;
            }
            HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_popclick", mapE);
            zn6.j("lx_client_messagelogin_popclick", "click", mapE);
            SmsFragment.this.y = true;
            SmsFragment.this.w.setImageResource(R.drawable.ic_login_agreement_selected);
            SmsFragment.this.K0(this.b, this.c, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements nx4<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14536a;
        public final /* synthetic */ String b;

        public c(String str, String str2) {
            this.f14536a = str;
            this.b = str2;
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (!SmsFragment.this.s || SmsFragment.this.h.isFinishing()) {
                return;
            }
            LogUtil.i("AccountPrAuthenManager", "loginPrClick getSmsPrLogin info onResult=" + az2.c(lXBaseNetBean));
            SmsFragment.this.G();
            if (lXBaseNetBean == null) {
                sy5.e(SmsFragment.this.h, R.string.send_failed, 0).g();
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == 202) {
                LogUtil.i("AccountPrAuthenManager", "loginPrClick getSmsPrLogin 短信验证码发送成功");
                com.zenmen.palmchat.loginnew.a aVar = SmsFragment.this.u;
                SmsFragment smsFragment = SmsFragment.this;
                aVar.x(smsFragment.f, smsFragment.t, this.f14536a, this.b, true, SmsFragment.this.C);
                sy5.e(SmsFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                return;
            }
            if (i == 200 || lXBaseNetBean.isNetError()) {
                sy5.e(SmsFragment.this.h, R.string.send_failed, 0).g();
                return;
            }
            if (lXBaseNetBean.resultCode == 0) {
                HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_freeaccess", mapE);
                zn6.j("lx_client_messagelogin_freeaccess", null, mapE);
                y63.h("sdk_verify_suc");
            }
            SmsFragment.this.u.x0(lXBaseNetBean, SmsFragment.this.t);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements nx4<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14537a;
        public final /* synthetic */ String b;

        public d(String str, String str2) {
            this.f14537a = str;
            this.b = str2;
        }

        @Override // defpackage.nx4
        public void a(LXBaseNetBean<JSONObject> lXBaseNetBean) {
            if (!SmsFragment.this.s || SmsFragment.this.h.isFinishing()) {
                return;
            }
            SmsFragment.this.G();
            int i = lXBaseNetBean.resultCode;
            int i2 = 0;
            int i3 = 1;
            if (i == 202) {
                com.zenmen.palmchat.loginnew.a aVar = SmsFragment.this.u;
                SmsFragment smsFragment = SmsFragment.this;
                aVar.x(smsFragment.f, smsFragment.t, this.f14537a, this.b, true, null);
                sy5.e(SmsFragment.this.h, R.string.login_verify_toast_sms_success, 1).g();
                i2 = 1;
            } else {
                if (i != 200 && !lXBaseNetBean.isNetError()) {
                    if (lXBaseNetBean.resultCode == 0) {
                        HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
                        LogUtil.uploadInfoImmediate("lx_client_messagelogin_freeaccess", mapE);
                        zn6.j("lx_client_messagelogin_freeaccess", null, mapE);
                        y63.h("sdk_verify_suc");
                        i2 = 1;
                    } else {
                        i3 = 0;
                    }
                    SmsFragment.this.u.x0(lXBaseNetBean, SmsFragment.this.t);
                    HashMap<String, Object> mapE2 = x63.e(SmsFragment.this.t);
                    mapE2.put("result", Integer.valueOf(i2));
                    mapE2.put("errormsg", lXBaseNetBean.errorMsg);
                    mapE2.put("freeaccess", Integer.valueOf(i3));
                    LogUtil.uploadInfoImmediate("lx_client_messagelogin_ret", mapE2);
                    zn6.j("lx_client_messagelogin_ret", null, mapE2);
                }
                sy5.e(SmsFragment.this.h, R.string.send_failed, 0).g();
            }
            i3 = 0;
            HashMap<String, Object> mapE22 = x63.e(SmsFragment.this.t);
            mapE22.put("result", Integer.valueOf(i2));
            mapE22.put("errormsg", lXBaseNetBean.errorMsg);
            mapE22.put("freeaccess", Integer.valueOf(i3));
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_ret", mapE22);
            zn6.j("lx_client_messagelogin_ret", null, mapE22);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmsFragment.this.Q0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x4 f14539a;

        public f(x4 x4Var) {
            this.f14539a = x4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            x4 x4Var = this.f14539a;
            if (x4Var != null) {
                int i = x4Var.f21873a;
                if (i == x4.i) {
                    LogUtil.i("AccountPrAuthenManager", "loginPrClick prDialogEvent 开始绑定手机号");
                    SmsFragment.this.T0(this.f14539a.c);
                    return;
                }
                if (i == x4.h) {
                    LogUtil.i("AccountPrAuthenManager", "loginPrClick prDialogEvent 认证成功");
                    SmsFragment smsFragment = SmsFragment.this;
                    smsFragment.O(smsFragment.getString(R.string.login_reg_check_waiting), false, false);
                } else if (i == x4.g) {
                    LogUtil.i("AccountPrAuthenManager", "loginPrClick prDialogEvent 服务端绑定结束");
                    SmsFragment.this.G();
                } else if (i == x4.e) {
                    SmsFragment.this.m.setText("");
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmsFragment.this.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmsFragment.this.startActivityForResult(new Intent(SmsFragment.this.h, (Class<?>) CountryCodeListActivity.class), 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            String strTrim = SmsFragment.this.m.getText().toString().trim();
            String strTrim2 = SmsFragment.this.o.getText().toString().trim();
            boolean zB = z63.b(strTrim, strTrim2);
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(SmsFragment.this.h, R.string.net_status_unavailable, 0).g();
                return;
            }
            LogUtil.i("AccountPrAuthenManager", "loginPrClick smsFragment 点击下一步， isPrLoginFrom " + SmsFragment.this.B);
            if (SmsFragment.this.B) {
                w4.r();
            } else if (strTrim != null) {
                int length = strTrim.length();
                HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
                mapE.put("status", Integer.valueOf(SmsFragment.this.y ? 1 : 0));
                mapE.put(EventParams.KEY_PARAM_NUMBER, Integer.valueOf(length));
                mapE.put("clickstatus", Integer.valueOf(zB ? 1 : 0));
                mapE.put("phonenumber", rb3.c(strTrim));
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_click", mapE);
                zn6.j("lx_client_messagelogin_click", "click", mapE);
            }
            if (!zB) {
                SmsFragment.this.r = true;
                SmsFragment.this.m.setTextColor(SmsFragment.this.h.getResources().getColor(R.color.Ba));
                sy5.e(SmsFragment.this.h, R.string.toast_phone_wrong, 0).g();
            } else if (!SmsFragment.this.y) {
                SmsFragment.this.R0(strTrim2, strTrim, 0);
            } else if (SmsFragment.this.B) {
                SmsFragment.this.L0(strTrim2, strTrim);
            } else {
                SmsFragment.this.K0(strTrim2, strTrim, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmsFragment.this.y = !r3.y;
            SmsFragment.this.W0();
            HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
            mapE.put("status", Integer.valueOf(SmsFragment.this.y ? 1 : 0));
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_agreement", mapE);
            zn6.j("lx_client_messagelogin_agreement", "click", mapE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            LogUtil.i("AccountPrAuthenManager", "loginPrClick SmsFragment prLoginView click bAgreementSelected " + SmsFragment.this.y);
            if (SmsFragment.this.y) {
                w4.y(SmsFragment.this.getActivity());
            } else {
                SmsFragment.this.R0("", "", 1);
            }
            w4.s();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f14546a;

        public m(uk5 uk5Var) {
            this.f14546a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f14546a.f21235a;
            if (i == 2 || i == 5) {
                SmsFragment.this.V0();
            }
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

    public final void K0(String str, String str2, boolean z) {
        y63.t();
        cl6.e(this.h, str, str2, new d(str, str2));
        O(getString(R.string.login_reg_check_waiting), false, false);
        HashMap<String, Object> mapE = x63.e(this.t);
        mapE.put("from", Integer.valueOf(z ? 2 : 1));
        LogUtil.uploadInfoImmediate("lx_client_messagelogin_send", mapE);
        zn6.j("lx_client_messagelogin_send", null, mapE);
    }

    public final void L0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        O(getString(R.string.login_reg_check_waiting), false, false);
        w4.v(this.h, str, str2, new c(str, str2));
    }

    public void M0(int i2) {
        this.t = i2;
    }

    public final void N0() {
        Toolbar toolbar = (Toolbar) this.i.findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("");
            toolbar.setNavigationIcon(R.drawable.login_back);
            toolbar.setNavigationOnClickListener(new e());
        }
    }

    public final void O0() {
        String strB;
        View viewFindViewById = this.i.findViewById(R.id.net_status_bar);
        this.j = viewFindViewById;
        viewFindViewById.setOnClickListener(new g());
        this.k = (TextView) this.i.findViewById(R.id.tv_text_title);
        String strC = e73.c();
        if (!TextUtils.isEmpty(strC)) {
            this.k.setText(strC);
        }
        this.l = (TextView) this.i.findViewById(R.id.tv_text_subtitle);
        if (ts0.o().H() && (strB = e73.b()) != null) {
            this.l.setText(strB);
        }
        TextView textView = (TextView) this.i.findViewById(R.id.country_code);
        this.o = textView;
        textView.setOnClickListener(new h());
        this.n = (TextView) this.i.findViewById(R.id.phone_number_hint);
        this.m = (ClearEditTextView) this.i.findViewById(R.id.phone_number_edit);
        if (a73.a()) {
            e73.r(this.m, R.drawable.login_phonenumber_cursor);
        }
        this.m.addTextChangedListener(new i());
        this.q = (LinearLayout) this.i.findViewById(R.id.ly_btn);
        if (!T()) {
            this.q.getLayoutParams().height = -1;
        }
        this.p = (TextView) this.i.findViewById(R.id.btn_next);
        String strA = e73.a();
        if (!TextUtils.isEmpty(strA)) {
            this.p.setText(strA);
        }
        this.p.setOnClickListener(new j());
        this.v = this.i.findViewById(R.id.agreement_layout);
        ImageView imageView = (ImageView) this.i.findViewById(R.id.img_select);
        this.w = imageView;
        imageView.setOnClickListener(new k());
        this.x = (TextView) this.i.findViewById(R.id.tv_agreement);
        this.v.setVisibility(0);
        this.x.setText(zm4.d(this.h, this.t));
        this.x.setMovementMethod(LinkMovementMethod.getInstance());
        this.x.setHighlightColor(this.h.getResources().getColor(android.R.color.transparent));
        View viewFindViewById2 = this.i.findViewById(R.id.pr_login_icon);
        this.A = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new l());
        JSONObject config = vs0.a().getConfig("PRClogin");
        boolean zOptBoolean = config != null ? config.optBoolean("PRClogin_entry", true) : true;
        LogUtil.i("AccountPrAuthenManager", "loginPrClick SmsFragment initUi prLoginShow " + zOptBoolean);
        if (zOptBoolean) {
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(8);
        }
    }

    public final void Q0() {
        try {
            int length = this.m.getEditableText().toString().trim().length();
            HashMap<String, Object> mapE = x63.e(this.t);
            mapE.put(EventParams.KEY_PARAM_NUMBER, Integer.valueOf(length));
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_back", mapE);
            zn6.j("lx_client_messagelogin_back", "click", mapE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.y = !a73.a();
        this.m.setText("");
        this.o.setText(WkParams.COUNTCODE);
        this.h.finish();
    }

    public final void R0(String str, String str2, int i2) {
        LogUtil.i("AccountPrAuthenManager", "loginPrClick SmsFragment showAgreementDialog from " + i2);
        AgreementDialog agreementDialog = new AgreementDialog(this.h, this.t, new b(i2, str, str2));
        agreementDialog.w(false);
        agreementDialog.show();
        HashMap<String, Object> mapE = x63.e(this.t);
        LogUtil.uploadInfoImmediate("lx_client_messagelogin_popshow", mapE);
        zn6.j("lx_client_messagelogin_popshow", "view", mapE);
    }

    public void S0() {
        ClearEditTextView clearEditTextView = this.m;
        if (clearEditTextView != null) {
            KeyboardKt.a(clearEditTextView, this.h, Keyboard$SHOW_FLAG.IMPLICIT, 300L);
        }
    }

    public final void T0(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.B = true;
        JSONObject config = vs0.a().getConfig("PRClogin");
        String strOptString = "绑定手机号";
        String strOptString2 = "关联手机号，获取完整服务";
        if (config != null && (jSONObjectOptJSONObject = config.optJSONObject("bindphone")) != null) {
            strOptString = jSONObjectOptJSONObject.optString("title", "绑定手机号");
            strOptString2 = jSONObjectOptJSONObject.optString(MediaFormat.KEY_SUBTITLE, "关联手机号，获取完整服务");
        }
        this.k.setText(strOptString);
        this.l.setText(strOptString2);
        this.v.setVisibility(8);
        this.A.setVisibility(8);
        this.y = true;
        this.C = jSONObject;
        this.m.setText("");
        this.o.setText(WkParams.COUNTCODE);
        w4.q();
    }

    public final void V0() {
        if (this.s) {
            this.j.setVisibility(hx3.m(this.h) ? 8 : 0);
        }
    }

    public final void W0() {
        this.w.setImageResource(this.y ? R.drawable.ic_login_agreement_selected : R.drawable.ic_login_agreement_unselect);
        this.p.setEnabled(this.m.getEditableText().length() > 0);
        V0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            String stringExtra = intent.getStringExtra(w.v);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.o.setText(stringExtra);
        }
    }

    @qm5
    public void onBackLoginPhonePageChanged(lo loVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.palmchat.loginnew.fragment.BaseLoginFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        FragmentActivity activity = getActivity();
        this.h = activity;
        this.u = (com.zenmen.palmchat.loginnew.a) activity;
        this.y = !a73.a();
        ch.s().r().j(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_sms_login, (ViewGroup) null, false);
        this.i = viewInflate;
        viewInflate.setVisibility(this.s ? 0 : 4);
        N0();
        O0();
        W0();
        int i2 = this.t;
        if (i2 == 0 || i2 == 6 || i2 == 5) {
            HashMap<String, Object> mapE = x63.e(i2);
            LogUtil.uploadInfoImmediate("lx_client_messagelogin_show", mapE);
            zn6.j("lx_client_messagelogin_show", "view", mapE);
        }
        return this.i;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ch.s().r().l(this);
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.s) {
            S0();
        }
        LogUtil.i(F, "onResume");
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        FragmentActivity activity;
        LogUtil.i(F, "onStatusChanged type =" + uk5Var.f21235a);
        int i2 = uk5Var.f21235a;
        if ((i2 != 2 && i2 != 5) || (activity = getActivity()) == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new m(uk5Var));
    }

    @qm5
    public void prDialogEvent(x4 x4Var) {
        u93.c(new f(x4Var));
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.s = z;
        if (!z) {
            View view = this.i;
            if (view != null) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        View view2 = this.i;
        if (view2 != null) {
            view2.setVisibility(0);
            W0();
            S0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements TextWatcher {
        public i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SmsFragment.this.r) {
                SmsFragment.this.m.setTextColor(SmsFragment.this.h.getResources().getColor(R.color.Gb));
                SmsFragment.this.r = false;
            }
            int length = SmsFragment.this.m.getEditableText().toString().trim().length();
            if (length <= 0) {
                SmsFragment.this.p.setEnabled(false);
                return;
            }
            SmsFragment.this.p.setEnabled(true);
            String strTrim = SmsFragment.this.o.getText().toString().trim();
            if (!SmsFragment.this.z) {
                SmsFragment.this.z = true;
                HashMap<String, Object> mapE = x63.e(SmsFragment.this.t);
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_input", mapE);
                zn6.j("lx_client_messagelogin_input", "click", mapE);
            }
            if (length == 11 && strTrim != null && strTrim.equals(WkParams.COUNTCODE)) {
                HashMap<String, Object> mapE2 = x63.e(SmsFragment.this.t);
                mapE2.put("phonenumber", rb3.c(SmsFragment.this.m.getEditableText().toString().trim()));
                LogUtil.uploadInfoImmediate("lx_client_messagelogin_input_complete", mapE2);
                zn6.j("lx_client_messagelogin_input_complete", "click", mapE2);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SmsFragment.this.n.setVisibility(TextUtils.isEmpty(charSequence) ? 0 : 4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
