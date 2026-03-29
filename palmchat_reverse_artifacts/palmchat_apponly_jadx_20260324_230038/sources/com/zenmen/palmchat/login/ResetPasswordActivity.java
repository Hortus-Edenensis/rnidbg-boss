package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import defpackage.dt2;
import defpackage.hs0;
import defpackage.k86;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ResetPasswordActivity extends BaseActivityWithoutCheckAccount implements TextWatcher, Response.Listener<JSONObject>, Response.ErrorListener {
    public EditText A;
    public Response.ErrorListener q = new d();
    public Response.Listener<JSONObject> r = new e();
    public String s;
    public String t;
    public String u;
    public String v;
    public TextView w;
    public TextView x;
    public TextView y;
    public EditText z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ResetPasswordActivity.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ResetPasswordActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ResetPasswordActivity.this.startActivity(new Intent(ResetPasswordActivity.this, (Class<?>) MainTabsActivity.class));
            ResetPasswordActivity.this.setResult(-1);
            ResetPasswordActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ResetPasswordActivity.this.hideBaseProgressBar();
            sy5.e(ResetPasswordActivity.this, R.string.network_exception_title, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                ResetPasswordActivity.this.E1();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
                ResetPasswordActivity.this.E1();
            }
        }

        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ResetPasswordActivity.this.hideBaseProgressBar();
            if (!r75.d(AppContext.getContext(), "is_first_launch", true)) {
                if (y63.q(jSONObject, ResetPasswordActivity.this.t, ResetPasswordActivity.this.u) == 0) {
                    ResetPasswordActivity.this.E1();
                }
            } else {
                if (y63.q(jSONObject, ResetPasswordActivity.this.t, ResetPasswordActivity.this.u) == 0) {
                    new sd3(ResetPasswordActivity.this).T(R.string.update_install_dialog_title).j(R.string.notice_read_phone_contact).h(false).O(R.string.dialog_confirm).K(R.string.dialog_cancel).f(new a()).e().show();
                    return;
                }
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = ResetPasswordActivity.this.getResources().getString(R.string.default_response_error);
                }
                new sd3(ResetPasswordActivity.this).k(strOptString).O(R.string.alert_dialog_ok).Q();
            }
        }
    }

    public final void E1() {
        new Handler().postDelayed(new c(), 100L);
    }

    public final void F1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.setting_password);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.setting_password);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.w = textView;
        textView.setEnabled(false);
        this.w.setText(R.string.modify_contact_info_finish);
        this.w.setOnClickListener(new a());
    }

    public final void G1() {
        Intent intent = getIntent();
        this.s = intent.getStringExtra("account");
        this.t = intent.getStringExtra(w.v);
        this.u = intent.getStringExtra("phone_number");
        this.v = intent.getStringExtra(Constant.MAP_KEY_UUID);
    }

    public final void H1() {
        showBaseProgressBar(getString(R.string.progress_sending), false, false);
        this.x = (TextView) findViewById(R.id.zx_id_des);
        this.y = (TextView) findViewById(R.id.zx_id);
        if (TextUtils.isEmpty(this.s)) {
            this.x.setText(R.string.string_phone_number);
            this.y.setText(hs0.g().a(this.u, this.t));
        } else {
            this.x.setText(R.string.settings_account);
            this.y.setText(this.s);
        }
        EditText editText = (EditText) findViewById(R.id.zx_password);
        this.z = editText;
        editText.addTextChangedListener(this);
        EditText editText2 = (EditText) findViewById(R.id.zx_confirm);
        this.A = editText2;
        editText2.addTextChangedListener(this);
    }

    @Override // com.android.volley.Response.Listener
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void onResponse(JSONObject jSONObject) {
        if (jSONObject.optInt("resultCode") == 0) {
            showBaseProgressBar(getString(R.string.progress_login), false, false);
            y63.p(this.t, !TextUtils.isEmpty(this.s) ? this.s : this.u, this.z.getText().toString(), !TextUtils.isEmpty(this.s) ? "1" : "0", this.q, this.r);
        } else {
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getResources().getString(R.string.default_response_error);
            }
            new sd3(this).k(strOptString).O(R.string.alert_dialog_ok).Q();
        }
    }

    public final void J1(int i) {
        int i2 = R.string.invalid_char_password;
        if (i == 0) {
            getString(R.string.update_install_dialog_title);
            getString(R.string.string_password_not_equal);
        } else if (i == 1) {
            getString(R.string.string_signup_fail);
            getString(R.string.string_signup_fail_reason);
        } else if (i == 2) {
            getString(R.string.update_install_dialog_title);
            getString(R.string.invalid_char_password);
        }
        MaterialDialog.d dVarT = new sd3(this).T(R.string.update_install_dialog_title);
        if (i == 0) {
            i2 = R.string.string_password_not_equal;
        }
        dVarT.j(i2).O(R.string.alert_dialog_ok).Q();
    }

    public final void K1() {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.quit_reset_password_tip).K(R.string.dialog_cancel).O(R.string.alert_dialog_ok).f(new b()).Q();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.z.getText().toString()) || TextUtils.isEmpty(this.A.getText().toString())) {
            this.w.setEnabled(false);
        } else {
            this.w.setEnabled(true);
        }
    }

    public final void b() {
        String string = this.z.getText().toString();
        String string2 = this.A.getText().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!string.equals(string2)) {
            J1(0);
        } else if (!dt2.c("[^\\u4e00-\\u9fa5]{8,16}", string)) {
            J1(1);
        } else {
            hideBaseProgressBar();
            y63.s(this.v, this.t, this.u, string, this, this);
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_password);
        G1();
        F1();
        H1();
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        hideBaseProgressBar();
        sy5.e(this, R.string.network_exception_title, 0).g();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        K1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        K1();
        return true;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
