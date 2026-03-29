package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.login.countrycode.CountryCodeListActivity;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hx3;
import defpackage.k86;
import defpackage.kb4;
import defpackage.mt2;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LogInActivity extends BaseActivityWithoutCheckAccount implements TextWatcher {
    public Response.Listener<JSONObject> A;
    public Handler B;
    public EditText r;
    public EditText s;
    public EditText t;
    public View u;
    public View v;
    public TextView w;
    public String x;
    public String y;
    public Response.ErrorListener z;
    public final String q = LogInActivity.class.getSimpleName();
    public boolean C = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(LogInActivity.this.q, volleyError.toString());
            LogInActivity.this.hideBaseProgressBar();
            sy5.e(LogInActivity.this, R.string.login_fail, 1).g();
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
                LogInActivity.this.T1();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
                LogInActivity.this.T1();
            }
        }

        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(LogInActivity.this.q, jSONObject.toString());
            LogInActivity.this.hideBaseProgressBar();
            boolean zD = r75.d(AppContext.getContext(), "is_first_launch", true);
            int iQ = y63.q(jSONObject, LogInActivity.this.x, LogInActivity.this.y);
            if (iQ == 0) {
                if (zD) {
                    new sd3(LogInActivity.this).T(R.string.update_install_dialog_title).j(R.string.notice_read_phone_contact).h(false).O(R.string.dialog_confirm).K(R.string.dialog_cancel).f(new a()).e().show();
                    return;
                } else {
                    LogInActivity.this.T1();
                    return;
                }
            }
            if (iQ == 1203) {
                LogInActivity.this.X1();
                return;
            }
            if (iQ == 1212) {
                LogInActivity.this.Y1();
            } else if (iQ != 1213) {
                LogInActivity.this.X1();
            } else {
                LogInActivity.this.Z1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            Intent intent = new Intent(LogInActivity.this, (Class<?>) LoginWithSmsActivity.class);
            intent.putExtra(w.v, LogInActivity.this.x);
            intent.putExtra("phone_number", LogInActivity.this.y);
            LogInActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogInActivity.this.startActivity(new Intent(LogInActivity.this, (Class<?>) MainTabsActivity.class));
            LogInActivity.this.setResult(-1);
            LogInActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(LogInActivity.this, R.string.net_status_unavailable, 1).g();
                return;
            }
            LogInActivity logInActivity = LogInActivity.this;
            logInActivity.y = logInActivity.r.getText().toString();
            LogInActivity logInActivity2 = LogInActivity.this;
            logInActivity2.x = logInActivity2.s.getText().toString();
            y63.p(LogInActivity.this.x, LogInActivity.this.y, LogInActivity.this.t.getText().toString(), "0", LogInActivity.this.z, LogInActivity.this.A);
            LogInActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_login), false, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogInActivity.this.startActivityForResult(new Intent(LogInActivity.this, (Class<?>) LoginByOtherMethodActivity.class), 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogInActivity.this.startActivity(new Intent(LogInActivity.this, (Class<?>) MainTabsActivity.class));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogInActivity.this.startActivityForResult(new Intent(LogInActivity.this, (Class<?>) CountryCodeListActivity.class), 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.d(MessagingService.c, "start MessagingService on login ", 1);
            AppContext.getContext().initMessagingService("STASRT_REASON_TEST");
            LogInActivity.this.bindMessagingService();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                LogInActivity.this.getMessagingServiceInterface().r(MessageVo.buildTextMessage(kb4.a(), "15216790617", "123456", null, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogInActivity logInActivity = LogInActivity.this;
            logInActivity.y = logInActivity.r.getText().toString();
            LogInActivity logInActivity2 = LogInActivity.this;
            logInActivity2.x = logInActivity2.s.getText().toString();
            Intent intent = new Intent(LogInActivity.this, (Class<?>) LoginWithSmsActivity.class);
            intent.putExtra(w.v, LogInActivity.this.x);
            intent.putExtra("phone_number", LogInActivity.this.y);
            LogInActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14384a;

        public m(View view) {
            this.f14384a = view;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (LogInActivity.this.r.hasFocus() || LogInActivity.this.s.hasFocus()) {
                this.f14384a.setBackgroundResource(R.drawable.shape_light_green_underline);
            } else {
                this.f14384a.setBackgroundResource(R.drawable.shape_light_gray_underline);
            }
        }
    }

    public final void T1() {
        this.B.postDelayed(new d(), 100L);
    }

    public final void U1() {
        m mVar = new m(findViewById(R.id.phoneContainer));
        this.r.setOnFocusChangeListener(mVar);
        this.s.setOnFocusChangeListener(mVar);
    }

    public final void V1() {
        this.z = new a();
        this.A = new b();
    }

    public final void W1() {
        View viewFindViewById = findViewById(R.id.log_in_text);
        this.u = viewFindViewById;
        viewFindViewById.setOnClickListener(new e());
        findViewById(R.id.login_by_other_method).setOnClickListener(new f());
        findViewById(R.id.log_in_text_2).setOnClickListener(new g());
        EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        this.r = editText;
        editText.requestFocus();
        this.r.addTextChangedListener(this);
        this.s = (EditText) findViewById(R.id.country_code_edit);
        EditText editText2 = (EditText) findViewById(R.id.password_edit);
        this.t = editText2;
        editText2.addTextChangedListener(this);
        EditText editText3 = (EditText) findViewById(R.id.country_code_edit);
        this.s = editText3;
        editText3.addTextChangedListener(new h());
        View viewFindViewById2 = findViewById(R.id.country_name_view);
        this.v = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new i());
        this.w = (TextView) findViewById(R.id.country_name_textview);
        findViewById(R.id.log_in_text_3).setOnClickListener(new j());
        findViewById(R.id.log_in_text_4).setOnClickListener(new k());
        U1();
        findViewById(R.id.login_by_sms).setOnClickListener(new l());
    }

    public final void X1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_content).O(R.string.alert_dialog_ok).e().show();
    }

    public final void Y1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_reset_content).O(R.string.find_password).K(R.string.alert_dialog_cancel).f(new c()).e().show();
    }

    public final void Z1() {
        new sd3(this).j(R.string.login_fail_fast_content).O(R.string.alert_dialog_ok).e().show();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.t.getEditableText().length() <= 0 || this.r.getEditableText().length() <= 0 || !this.C) {
            this.u.setEnabled(false);
        } else {
            this.u.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            String stringExtra = intent.getStringExtra("country_name");
            String stringExtra2 = intent.getStringExtra(w.v);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.w.setText(stringExtra);
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.s.setText(stringExtra2);
            return;
        }
        if (i2 == 2 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 3 && i3 == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = new Handler();
        setContentView(R.layout.layout_activity_login);
        initToolbar(R.string.login_activity_title);
        V1();
        W1();
        mt2.a(this, null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
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
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (TextUtils.isEmpty(string)) {
                LogInActivity.this.w.setText(R.string.choose_from_list);
                LogInActivity.this.C = false;
                return;
            }
            if (com.zenmen.palmchat.login.countrycode.b.b().c().containsKey(string)) {
                LogInActivity.this.w.setText(com.zenmen.palmchat.login.countrycode.b.b().c().get(string));
                LogInActivity.this.C = true;
            } else {
                LogInActivity.this.C = false;
                LogInActivity.this.w.setText(R.string.invalid_country_code);
            }
            if (LogInActivity.this.t.getEditableText().length() <= 0 || LogInActivity.this.r.getEditableText().length() <= 0 || !LogInActivity.this.C) {
                LogInActivity.this.u.setEnabled(false);
            } else {
                LogInActivity.this.u.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
