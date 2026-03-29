package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.login.countrycode.CountryCodeListActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gs;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.mt2;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LoginWithSmsActivity extends BaseActivityWithoutCheckAccount implements TextWatcher {
    public String q;
    public String r;
    public TextView s;
    public EditText t;
    public EditText u;
    public View v;
    public TextView w;
    public boolean x = true;
    public gs y = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gs {

        /* JADX INFO: renamed from: com.zenmen.palmchat.login.LoginWithSmsActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1067a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f14402a;

            public C1067a(JSONObject jSONObject) {
                this.f14402a = jSONObject;
                put("action", "request_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", LoginWithSmsActivity.this.r);
                put("type", 2);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "request_sms");
                put("status", "fail");
                put("phone_number", LoginWithSmsActivity.this.r);
                put("type", 2);
            }
        }

        public a() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            LoginWithSmsActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new b(), exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LoginWithSmsActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new C1067a(jSONObject), (Throwable) null);
            if (yy2Var.f22300a) {
                String strOptString = yy2Var.d.optString("smsid");
                Intent intent = new Intent(LoginWithSmsActivity.this, (Class<?>) SMSCodeValidateActivity.class);
                intent.putExtra("phone_number", LoginWithSmsActivity.this.r);
                intent.putExtra(w.v, LoginWithSmsActivity.this.q);
                intent.putExtra("smsid", strOptString);
                intent.putExtra("action", 1);
                LoginWithSmsActivity.this.startActivityForResult(intent, 2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                LoginWithSmsActivity.this.showBaseProgressBar();
                y63.j().r(LoginWithSmsActivity.this.q, LoginWithSmsActivity.this.r, 2, LoginWithSmsActivity.this.y);
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(LoginWithSmsActivity.this, R.string.net_status_unavailable, 1).g();
                return;
            }
            LoginWithSmsActivity loginWithSmsActivity = LoginWithSmsActivity.this;
            loginWithSmsActivity.r = loginWithSmsActivity.t.getText().toString();
            LoginWithSmsActivity loginWithSmsActivity2 = LoginWithSmsActivity.this;
            loginWithSmsActivity2.q = loginWithSmsActivity2.u.getText().toString();
            if (hs0.g().j(LoginWithSmsActivity.this.r, LoginWithSmsActivity.this.q)) {
                new sd3(LoginWithSmsActivity.this).T(R.string.confirm_phone_number).k(LoginWithSmsActivity.this.getString(R.string.confirm_phone_number_send_des, hs0.g().b(LoginWithSmsActivity.this.r, LoginWithSmsActivity.this.q, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL))).K(R.string.dialog_cancel).O(R.string.alert_dialog_ok).f(new a()).Q();
            } else {
                new sd3(LoginWithSmsActivity.this).T(R.string.phone_number_error).j(R.string.invalid_phone_number).O(R.string.alert_dialog_ok).Q();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginWithSmsActivity.this.startActivityForResult(new Intent(LoginWithSmsActivity.this, (Class<?>) CountryCodeListActivity.class), 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14408a;

        public e(View view) {
            this.f14408a = view;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (LoginWithSmsActivity.this.t.hasFocus() || LoginWithSmsActivity.this.u.hasFocus()) {
                this.f14408a.setBackgroundResource(R.drawable.shape_light_green_underline);
            } else {
                this.f14408a.setBackgroundResource(R.drawable.shape_light_gray_underline);
            }
        }
    }

    public final void L1() {
        e eVar = new e(findViewById(R.id.phoneContainer));
        this.t.setOnFocusChangeListener(eVar);
        this.u.setOnFocusChangeListener(eVar);
    }

    public final void M1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.login_by_sms);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.s = textView;
        textView.setText(R.string.next_step);
        this.s.setOnClickListener(new b());
    }

    public final void N1() {
        EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        this.t = editText;
        editText.requestFocus();
        this.t.addTextChangedListener(this);
        EditText editText2 = (EditText) findViewById(R.id.country_code_edit);
        this.u = editText2;
        editText2.addTextChangedListener(new c());
        View viewFindViewById = findViewById(R.id.country_name_view);
        this.v = viewFindViewById;
        viewFindViewById.setOnClickListener(new d());
        this.w = (TextView) findViewById(R.id.country_name_textview);
        L1();
    }

    public final void O1() {
        String stringExtra = getIntent().getStringExtra("phone_number");
        this.r = stringExtra;
        this.t.setText(stringExtra);
        String stringExtra2 = getIntent().getStringExtra(w.v);
        this.q = stringExtra2;
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        this.u.setText(this.q);
        if (com.zenmen.palmchat.login.countrycode.b.b().c().containsKey(this.q)) {
            this.w.setText(com.zenmen.palmchat.login.countrycode.b.b().c().get(this.q));
            this.x = true;
        } else {
            this.x = false;
            this.w.setText(R.string.invalid_country_code);
        }
        if (this.t.getEditableText().length() <= 0 || !this.x) {
            this.s.setEnabled(false);
        } else {
            this.s.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.t.getEditableText().length() <= 0 || !this.x) {
            this.s.setEnabled(false);
        } else {
            this.s.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("country_name");
            String stringExtra2 = intent.getStringExtra(w.v);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.w.setText(stringExtra);
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.u.setText(stringExtra2);
            return;
        }
        if (i == 2) {
            if (i2 != -1) {
                this.t.setText("");
            } else {
                setResult(-1);
                finish();
            }
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_login_with_sms);
        M1();
        N1();
        O1();
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

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (TextUtils.isEmpty(string)) {
                LoginWithSmsActivity.this.w.setText(R.string.choose_from_list);
                LoginWithSmsActivity.this.x = false;
                return;
            }
            if (com.zenmen.palmchat.login.countrycode.b.b().c().containsKey(string)) {
                LoginWithSmsActivity.this.w.setText(com.zenmen.palmchat.login.countrycode.b.b().c().get(string));
                LoginWithSmsActivity.this.x = true;
            } else {
                LoginWithSmsActivity.this.x = false;
                LoginWithSmsActivity.this.w.setText(R.string.invalid_country_code);
            }
            if (LoginWithSmsActivity.this.t.getEditableText().length() <= 0 || !LoginWithSmsActivity.this.x) {
                LoginWithSmsActivity.this.s.setEnabled(false);
            } else {
                LoginWithSmsActivity.this.s.setEnabled(true);
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
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
