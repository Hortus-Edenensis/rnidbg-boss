package com.zenmen.palmchat.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.w;
import com.lantern.auth.server.WkParams;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.g13;
import defpackage.gs;
import defpackage.hx3;
import defpackage.k86;
import defpackage.nl0;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.td3;
import defpackage.y63;
import defpackage.yy2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SMSCodeValidateActivity extends BaseActivityWithoutCheckAccount {
    public static final String L = "SMSCodeValidateActivity";
    public String A;
    public String B;
    public Response.ErrorListener F;
    public Response.Listener<String> G;
    public Response.ErrorListener H;
    public Response.Listener<JSONObject> I;
    public TextView q;
    public EditText r;
    public TextView s;
    public TextView t;
    public TextView u;
    public BroadcastReceiver v;
    public String x;
    public String w = WkParams.COUNTCODE;
    public String y = "123456";
    public String z = "123";
    public int C = 0;
    public q E = new q(this);
    public gs J = new e();
    public gs K = new f().f(false);

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SmsMessage[] smsMessageArr;
            SmsMessage smsMessage;
            String strY1;
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        Object[] objArr = (Object[]) extras.get("pdus");
                        if (objArr != null) {
                            smsMessageArr = new SmsMessage[objArr.length];
                            for (int i = 0; i < objArr.length; i++) {
                                smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                            }
                        } else {
                            smsMessageArr = null;
                        }
                        if (smsMessageArr == null || (smsMessage = smsMessageArr[0]) == null || (strY1 = SMSCodeValidateActivity.Y1(smsMessage.getMessageBody())) == null) {
                            return;
                        }
                        SMSCodeValidateActivity.this.r.setText(strY1);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                SMSCodeValidateActivity.this.finish();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                SMSCodeValidateActivity.this.startActivity(new Intent(SMSCodeValidateActivity.this, (Class<?>) SignUpActivity.class));
                SMSCodeValidateActivity.this.setResult(-1);
                SMSCodeValidateActivity.this.finish();
            }
        }

        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                new sd3(SMSCodeValidateActivity.this).k(jSONObject.optString(MediationConstant.KEY_ERROR_MSG)).O(R.string.alert_dialog_ok).Q();
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString = jSONObjectOptJSONObject.optString(Constant.MAP_KEY_UUID);
            if (jSONObjectOptJSONObject.optInt("existsFlag") != 1) {
                if (SMSCodeValidateActivity.this.C == 0) {
                    y63.w(strOptString, SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x, SMSCodeValidateActivity.this.z, EncryptUtils.digestString(SMSCodeValidateActivity.this.y), String.valueOf(k86.C()), SMSCodeValidateActivity.this.A, "android", SMSCodeValidateActivity.this.F, SMSCodeValidateActivity.this.G);
                    return;
                } else {
                    if (SMSCodeValidateActivity.this.C == 1) {
                        new sd3(SMSCodeValidateActivity.this).h(false).j(R.string.signup_tip).K(R.string.dialog_cancel).O(R.string.sign_up).f(new a()).Q();
                        return;
                    }
                    return;
                }
            }
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            if (SMSCodeValidateActivity.this.C != 0) {
                if (SMSCodeValidateActivity.this.C == 1) {
                    Intent intent = new Intent(SMSCodeValidateActivity.this, (Class<?>) ResetPasswordActivity.class);
                    intent.putExtra("account", jSONObjectOptJSONObject.optString("account"));
                    intent.putExtra("phone_number", SMSCodeValidateActivity.this.x);
                    intent.putExtra(w.v, SMSCodeValidateActivity.this.w);
                    intent.putExtra(Constant.MAP_KEY_UUID, strOptString);
                    SMSCodeValidateActivity.this.startActivityForResult(intent, 1001);
                    return;
                }
                return;
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("nickname");
            String strOptString3 = jSONObjectOptJSONObject.optString("headImgUrl");
            Intent intent2 = new Intent(SMSCodeValidateActivity.this, (Class<?>) WelcomeBackActivity.class);
            intent2.putExtra("nick_name", strOptString2);
            intent2.putExtra(TECameraSettings.SCENE_MODE_PORTRAIT, strOptString3);
            intent2.putExtra("phone_number", SMSCodeValidateActivity.this.x);
            intent2.putExtra(w.v, SMSCodeValidateActivity.this.w);
            intent2.putExtra("password", SMSCodeValidateActivity.this.y);
            intent2.putExtra(Constant.MAP_KEY_UUID, strOptString);
            SMSCodeValidateActivity.this.startActivityForResult(intent2, 1000);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            SMSCodeValidateActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SMSCodeValidateActivity.this.startActivity(new Intent(SMSCodeValidateActivity.this, (Class<?>) MainTabsActivity.class));
            SMSCodeValidateActivity.this.setResult(-1);
            SMSCodeValidateActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends gs {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f14420a;

            public a(JSONObject jSONObject) {
                this.f14420a = jSONObject;
                put("action", "request_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", SMSCodeValidateActivity.this.x);
                put("type", Integer.valueOf(SMSCodeValidateActivity.this.C == 0 ? 1 : 2));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "request_sms");
                put("status", "fail");
                put("phone_number", SMSCodeValidateActivity.this.x);
                put("type", Integer.valueOf(SMSCodeValidateActivity.this.C == 0 ? 1 : 2));
            }
        }

        public e() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new b(), exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new a(jSONObject), (Throwable) null);
            if (yy2Var.f22300a) {
                SMSCodeValidateActivity.this.B = yy2Var.d.optString("smsid");
                SMSCodeValidateActivity.this.u.setEnabled(false);
                SMSCodeValidateActivity.this.e2(60);
                sy5.e(SMSCodeValidateActivity.this, R.string.validate_sms_code_has_been_sent, 1).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends gs {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f14422a;

            public a(JSONObject jSONObject) {
                this.f14422a = jSONObject;
                put("action", "validate_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", SMSCodeValidateActivity.this.x);
                put("type", Integer.valueOf(SMSCodeValidateActivity.this.C == 0 ? 1 : 2));
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "validate_sms");
                put("status", "fail");
                put("phone_number", SMSCodeValidateActivity.this.x);
                put("type", Integer.valueOf(SMSCodeValidateActivity.this.C == 0 ? 1 : 2));
            }
        }

        public f() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new b(), exc);
            sy5.f(AppContext.getContext(), AppContext.getContext().getString(R.string.sent_request_failed), 0).g();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i(gs.e, 3, new a(jSONObject), (Throwable) null);
            SMSCodeValidateActivity.this.d2(yy2Var.f22300a, yy2Var.f22300a ? yy2Var.d.optString(WkParams.SESSIONID) : null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            Intent intent = new Intent(SMSCodeValidateActivity.this, (Class<?>) InitActivity.class);
            intent.setFlags(268468224);
            SMSCodeValidateActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SMSCodeValidateActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), true, true);
            y63.j().D(SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x, SMSCodeValidateActivity.this.C == 0 ? 1 : 2, SMSCodeValidateActivity.this.r.getText().toString(), SMSCodeValidateActivity.this.B, SMSCodeValidateActivity.this.K);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: com.zenmen.palmchat.login.SMSCodeValidateActivity$j$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class RunnableC1068a implements Runnable {
                public RunnableC1068a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SMSCodeValidateActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), true, true);
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PreferenceManager.getDefaultSharedPreferences(AppContext.getContext());
                if (TextUtils.isEmpty("123456")) {
                    return;
                }
                SMSCodeValidateActivity.this.E.post(new RunnableC1068a());
                y63.w("123456", SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x, SMSCodeValidateActivity.this.z, EncryptUtils.digestString(SMSCodeValidateActivity.this.y), String.valueOf(k86.C()), SMSCodeValidateActivity.this.A, "android", SMSCodeValidateActivity.this.F, SMSCodeValidateActivity.this.G);
            }
        }

        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y63.x();
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new g13(new a()).start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {
            public a() {
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                SMSCodeValidateActivity.this.f2();
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new td3.c(SMSCodeValidateActivity.this).c(new String[]{SMSCodeValidateActivity.this.getString(R.string.resend_validate_sms_code)}).d(new a()).a().b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.ErrorListener {
        public m() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(SMSCodeValidateActivity.L, "sign up error");
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            sy5.e(SMSCodeValidateActivity.this, R.string.network_exception_title, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.Listener<String> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "user_register_ok");
                put("detail", "uid =" + SMSCodeValidateActivity.this.x);
            }
        }

        public n() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            LogUtil.d(SMSCodeValidateActivity.L, "sign up response=" + str);
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("resultCode") == 0) {
                    y63.p(SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x, SMSCodeValidateActivity.this.y, "0", SMSCodeValidateActivity.this.H, SMSCodeValidateActivity.this.I);
                    if (jSONObject.optJSONObject("data").optInt("type") == 0) {
                        LogUtil.i(SMSCodeValidateActivity.L, 3, new a(), (Throwable) null);
                        return;
                    }
                    return;
                }
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = SMSCodeValidateActivity.this.getResources().getString(R.string.default_response_error);
                }
                new sd3(SMSCodeValidateActivity.this).k(strOptString).O(R.string.alert_dialog_ok).Q();
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.d(SMSCodeValidateActivity.L, "sign up error");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Response.ErrorListener {
        public o() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(SMSCodeValidateActivity.L, "log in error");
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            sy5.e(SMSCodeValidateActivity.this, R.string.network_exception_title, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                SMSCodeValidateActivity.this.Z1();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
                SMSCodeValidateActivity.this.Z1();
            }
        }

        public p() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            SMSCodeValidateActivity.this.hideBaseProgressBar();
            if (r75.d(AppContext.getContext(), "is_first_launch", true)) {
                if (y63.q(jSONObject, SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x) == 0) {
                    new sd3(SMSCodeValidateActivity.this).T(R.string.update_install_dialog_title).j(R.string.notice_read_phone_contact).h(false).O(R.string.dialog_confirm).K(R.string.dialog_cancel).f(new a()).e().show();
                }
            } else if (y63.q(jSONObject, SMSCodeValidateActivity.this.w, SMSCodeValidateActivity.this.x) == 0) {
                SMSCodeValidateActivity.this.Z1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class q extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<SMSCodeValidateActivity> f14440a;

        public q(SMSCodeValidateActivity sMSCodeValidateActivity) {
            this.f14440a = new WeakReference<>(sMSCodeValidateActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0 || this.f14440a.get() == null) {
                return;
            }
            if (message.arg1 != 0) {
                this.f14440a.get().e2(message.arg1 - 1);
            } else {
                this.f14440a.get().u.setText(R.string.validate_code_not_received);
                this.f14440a.get().u.setEnabled(true);
            }
        }
    }

    public static String Y1(String str) {
        Matcher matcher = Pattern.compile("\\d\\d\\d\\d\\d\\d").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public final void X1() {
        new sd3(this).j(R.string.cancel_sign_up).O(R.string.restart_sign_up).K(R.string.wait).f(new g()).Q();
    }

    public final void Z1() {
        this.E.postDelayed(new d(), 100L);
    }

    public final void a2() {
        this.F = new m();
        this.G = new n();
        this.H = new o();
        this.I = new p();
    }

    public final void b2() {
        this.v = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(this.v, intentFilter);
    }

    public final void c2() {
        TextView textView = (TextView) findViewById(R.id.sms_sent_message_text);
        this.q = textView;
        textView.setText(Html.fromHtml(getResources().getString(R.string.sms_sent_message)));
        EditText editText = (EditText) findViewById(R.id.validate_code_edit);
        this.r = editText;
        editText.addTextChangedListener(new h());
        TextView textView2 = (TextView) findViewById(R.id.validate_sms_code_button);
        this.s = textView2;
        textView2.setOnClickListener(new i());
        TextView textView3 = (TextView) findViewById(R.id.phone_number);
        this.t = textView3;
        textView3.setText(this.x);
        ((TextView) findViewById(R.id.country_code)).setText(this.w);
        if (nl0.k()) {
            findViewById(R.id.validate_sms_code_button_2).setVisibility(8);
        } else if (this.C == 0) {
            findViewById(R.id.validate_sms_code_button_2).setVisibility(0);
        }
        findViewById(R.id.validate_sms_code_button_2).setOnClickListener(new j());
        findViewById(R.id.validate_sms_code_button_3).setOnClickListener(new k());
        TextView textView4 = (TextView) findViewById(R.id.validate_sms_code_countdown_text);
        this.u = textView4;
        textView4.setOnClickListener(new l());
        e2(60);
    }

    public final void d2(boolean z, String str) {
        if (!hx3.m(AppContext.getContext())) {
            hideBaseProgressBar();
            sy5.e(this, R.string.net_status_unavailable, 1).g();
        } else {
            if (!z) {
                hideBaseProgressBar();
                new sd3(this).j(R.string.valid_sms_code_failed).O(R.string.alert_dialog_ok).Q();
                return;
            }
            b bVar = new b();
            c cVar = new c();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            y63.f(str, this.x, this.w, this.C == 0 ? 1 : 2, bVar, cVar);
        }
    }

    public final void e2(int i2) {
        this.u.setText(getString(R.string.validate_sms_code_countdown, Integer.valueOf(i2)));
        Message message = new Message();
        message.what = 0;
        message.arg1 = i2;
        this.E.sendMessageDelayed(message, 1000L);
    }

    public final void f2() {
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
        } else {
            showBaseProgressBar();
            y63.j().r(this.w, this.x, this.C != 0 ? 2 : 1, this.J);
        }
    }

    public final void g2() {
        BroadcastReceiver broadcastReceiver = this.v;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    public final void initActionBar() {
        initToolbar(R.string.sms_code_validate_activity_title);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 1001) {
            setResult(i3);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_sms_code_validate);
        Intent intent = getIntent();
        this.x = intent.getStringExtra("phone_number");
        this.z = intent.getStringExtra("nick_name");
        this.w = intent.getStringExtra(w.v);
        this.y = intent.getStringExtra("password");
        this.A = intent.getStringExtra(TECameraSettings.SCENE_MODE_PORTRAIT);
        this.C = intent.getIntExtra("action", 0);
        this.B = intent.getStringExtra("smsid");
        initActionBar();
        a2();
        c2();
        b2();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g2();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || this.C != 0) {
            return super.onKeyUp(i2, keyEvent);
        }
        X1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.C == 0) {
            X1();
            return true;
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        super.bindMessagingService();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        super.unBindMessagingService();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements TextWatcher {
        public h() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SMSCodeValidateActivity.this.r.length() > 0) {
                SMSCodeValidateActivity.this.s.setEnabled(true);
            } else {
                SMSCodeValidateActivity.this.s.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
