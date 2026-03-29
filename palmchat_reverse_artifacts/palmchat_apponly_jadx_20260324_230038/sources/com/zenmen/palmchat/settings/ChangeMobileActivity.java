package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.login.countrycode.CountryCodeListActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gs;
import defpackage.hs0;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.y63;
import defpackage.yy2;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChangeMobileActivity extends BaseActionBarActivity {
    public gs q = new c();
    public TextView r;
    public TextView s;
    public EditText t;
    public String u;
    public String v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChangeMobileActivity.this.C1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChangeMobileActivity.this.startActivityForResult(new Intent(ChangeMobileActivity.this, (Class<?>) CountryCodeListActivity.class), 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends gs {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f15161a;

            public a(JSONObject jSONObject) {
                this.f15161a = jSONObject;
                put("action", "request_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", ChangeMobileActivity.this.t.getText().toString());
                put("type", 3);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "request_sms");
                put("status", "fail");
                put("phone_number", ChangeMobileActivity.this.t.getText().toString());
                put("type", 3);
            }
        }

        public c() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            ChangeMobileActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new b(), exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            ChangeMobileActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new a(jSONObject), (Throwable) null);
            if (yy2Var.f22300a) {
                String strOptString = yy2Var.d.optString("smsid");
                Intent intent = new Intent(ChangeMobileActivity.this, (Class<?>) ValidateMobileActivity.class);
                intent.putExtra("mobile_number", ChangeMobileActivity.this.t.getText().toString());
                intent.putExtra(w.v, ChangeMobileActivity.this.u);
                intent.putExtra("smsid", strOptString);
                ChangeMobileActivity.this.startActivity(intent);
                ChangeMobileActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            ChangeMobileActivity.this.finish();
        }
    }

    public void C1() {
        String string = this.t.getText().toString();
        if (TextUtils.isEmpty(string)) {
            new sd3(this).T(R.string.update_install_dialog_title).j(R.string.toast_phone_wrong).O(R.string.dialog_confirm).Q();
            return;
        }
        if (!hs0.g().j(string, this.u)) {
            sy5.e(this, R.string.toast_wrong_mobile_number_format, 0).g();
        } else if (string.equals(AccountUtils.k(this)) && this.u.equals(AccountUtils.i(this))) {
            sy5.e(this, R.string.toast_phone_same_number, 0).g();
        } else {
            F1();
        }
    }

    public final void D1() {
        new sd3(this).T(R.string.confirm_exit_changing_mobile_title).j(R.string.confirm_exit_changing_mobile_content).K(R.string.alert_dialog_cancel).O(R.string.dialog_confirm).f(new d()).Q();
    }

    public final void E1() {
        ((TextView) findViewById(R.id.validate_mobile_tip_text)).setText(getString(R.string.validate_mobile_tip, AccountUtils.k(this)));
        findViewById(R.id.country_code_area).setOnClickListener(new b());
        this.r = (TextView) findViewById(R.id.country_code_text);
        this.u = AccountUtils.i(this);
        this.r.setText("+" + this.u);
        this.t = (EditText) findViewById(R.id.mobile_edit);
        this.s = (TextView) findViewById(R.id.country_name_text);
        this.s.setText(com.zenmen.palmchat.login.countrycode.b.b().c().get(this.u));
    }

    public final void F1() {
        showBaseProgressBar();
        y63.j().r(this.u, this.t.getText().toString(), 3, this.q);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.validate_mobile);
        setSupportActionBar(toolbarInitToolbar);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        textView.setText(R.string.next_step);
        textView.setOnClickListener(new a());
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.validate_mobile);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            this.u = intent.getStringExtra(w.v);
            this.v = intent.getStringExtra("country_name");
            if (!TextUtils.isEmpty(this.u)) {
                this.r.setText("+" + this.u);
            }
            if (TextUtils.isEmpty(this.v)) {
                return;
            }
            this.s.setText(this.v);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_mobile);
        initActionBar();
        E1();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        D1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        D1();
        return true;
    }
}
