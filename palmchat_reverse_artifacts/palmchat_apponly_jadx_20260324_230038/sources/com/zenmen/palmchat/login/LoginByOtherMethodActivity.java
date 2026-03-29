package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import defpackage.hx3;
import defpackage.k86;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LoginByOtherMethodActivity extends BaseActivityWithoutCheckAccount implements TextWatcher, View.OnClickListener {
    public EditText q;
    public EditText r;
    public TextView s;
    public TextView t;
    public Handler u = new Handler();
    public Response.ErrorListener v;
    public Response.Listener<JSONObject> w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LoginByOtherMethodActivity.this.hideBaseProgressBar();
            sy5.e(LoginByOtherMethodActivity.this, R.string.login_fail, 1).g();
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
                LoginByOtherMethodActivity.this.E1();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
                LoginByOtherMethodActivity.this.E1();
            }
        }

        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LoginByOtherMethodActivity.this.hideBaseProgressBar();
            boolean zD = r75.d(AppContext.getContext(), "is_first_launch", true);
            int iQ = y63.q(jSONObject, null, null);
            if (iQ == 0) {
                if (zD) {
                    new sd3(LoginByOtherMethodActivity.this).T(R.string.update_install_dialog_title).j(R.string.notice_read_phone_contact).h(false).O(R.string.dialog_confirm).K(R.string.dialog_cancel).f(new a()).e().show();
                    return;
                } else {
                    LoginByOtherMethodActivity.this.E1();
                    return;
                }
            }
            if (iQ == 1203) {
                LoginByOtherMethodActivity.this.H1();
                return;
            }
            if (iQ == 1212) {
                LoginByOtherMethodActivity.this.I1();
            } else if (iQ != 1213) {
                LoginByOtherMethodActivity.this.H1();
            } else {
                LoginByOtherMethodActivity.this.J1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            LoginByOtherMethodActivity.this.startActivityForResult(new Intent(LoginByOtherMethodActivity.this, (Class<?>) LoginWithSmsActivity.class), 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoginByOtherMethodActivity.this.startActivity(new Intent(LoginByOtherMethodActivity.this, (Class<?>) MainTabsActivity.class));
            LoginByOtherMethodActivity.this.setResult(-1);
            LoginByOtherMethodActivity.this.finish();
        }
    }

    public final void E1() {
        this.u.postDelayed(new d(), 100L);
    }

    public final void F1() {
        this.v = new a();
        this.w = new b();
    }

    public final void G1() {
        this.q = (EditText) findViewById(R.id.account_edit);
        this.r = (EditText) findViewById(R.id.password_edit);
        this.s = (TextView) findViewById(R.id.log_in_text);
        this.t = (TextView) findViewById(R.id.forget_password);
        this.q.addTextChangedListener(this);
        this.r.addTextChangedListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
    }

    public final void H1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_content).O(R.string.alert_dialog_ok).e().show();
    }

    public final void I1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_reset_content).O(R.string.find_password).K(R.string.alert_dialog_cancel).f(new c()).e().show();
    }

    public final void J1() {
        new sd3(this).j(R.string.login_fail_fast_content).O(R.string.alert_dialog_ok).e().show();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.q.getEditableText().length() <= 0 || this.r.getEditableText().length() <= 0) {
            this.s.setEnabled(false);
        } else {
            this.s.setEnabled(true);
        }
    }

    public final void initActionBar() {
        initToolbar(R.string.login_zhangxin);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.s) {
            if (view == this.t) {
                startActivityForResult(new Intent(this, (Class<?>) LoginWithSmsActivity.class), 0);
            }
        } else if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
        } else {
            y63.p(null, this.q.getText().toString(), this.r.getText().toString(), "1", this.v, this.w);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_login), false, false);
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_login_by_other_method);
        initActionBar();
        F1();
        G1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        setResult(0);
        finish();
        return true;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
