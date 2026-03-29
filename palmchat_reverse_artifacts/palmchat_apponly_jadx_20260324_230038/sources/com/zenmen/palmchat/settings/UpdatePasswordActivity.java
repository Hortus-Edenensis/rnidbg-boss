package com.zenmen.palmchat.settings;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.bo0;
import defpackage.dt2;
import defpackage.e56;
import defpackage.sd3;
import defpackage.sy5;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UpdatePasswordActivity extends BaseActionBarActivity {
    public TextView q = null;
    public EditText r = null;
    public EditText s = null;
    public String t;
    public e56 u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdatePasswordActivity.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            UpdatePasswordActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                sy5.e(UpdatePasswordActivity.this, R.string.string_set_pwd_success, 0).g();
                UpdatePasswordActivity.this.finish();
            } else {
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = UpdatePasswordActivity.this.getResources().getString(R.string.default_response_error);
                }
                sy5.f(UpdatePasswordActivity.this, strOptString, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UpdatePasswordActivity.this.hideBaseProgressBar();
            sy5.e(UpdatePasswordActivity.this, R.string.network_exception_title, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            UpdatePasswordActivity.this.finish();
        }
    }

    public final void B1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.setting_password);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.setting_password);
        TextView textView = (TextView) findViewById(R.id.action_button);
        textView.setText(R.string.modify_contact_info_finish);
        textView.setOnClickListener(new a());
    }

    public final void C1() {
        TextView textView = (TextView) findViewById(R.id.des);
        TextView textView2 = (TextView) findViewById(R.id.zx_id_des);
        this.q = (TextView) findViewById(R.id.zx_id);
        ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(this));
        if (contactInfoItemL != null) {
            if (TextUtils.isEmpty(contactInfoItemL.getAccount())) {
                this.q.setText(contactInfoItemL.getMobile());
                textView.setText(R.string.string_change_password_phone);
                textView2.setText(R.string.string_phone_number);
            } else {
                this.q.setText(contactInfoItemL.getAccount());
                textView.setText(R.string.string_change_password);
                textView2.setText(R.string.settings_account);
            }
        }
        this.r = (EditText) findViewById(R.id.zx_password);
        this.s = (EditText) findViewById(R.id.zx_confirm);
    }

    public final void D1() {
        this.t = getIntent().getStringExtra("encrypt_ori_password");
    }

    public final void E1(String str) {
        HashMap map = new HashMap();
        map.put("originalPwd", this.t);
        map.put("newPwd", EncryptUtils.digestString(str));
        if (this.u == null) {
            this.u = new e56(new b(), new c());
        }
        try {
            this.u.n(map);
            showBaseProgressBar();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void F1(int i) {
        String string;
        if (i == 0) {
            string = getString(R.string.update_install_dialog_title);
            getString(R.string.string_password_not_equal);
        } else if (i == 1) {
            string = getString(R.string.string_signup_fail);
            getString(R.string.string_signup_fail_reason);
        } else if (i != 2) {
            string = null;
        } else {
            string = getString(R.string.update_install_dialog_title);
            getString(R.string.invalid_char_password);
        }
        new sd3(this).U(string).k(i == 0 ? getString(R.string.string_password_not_equal) : getString(R.string.invalid_char_password)).O(R.string.alert_dialog_ok).f(null).e().show();
    }

    public final void G1() {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.quit_reset_password_tip).K(R.string.dialog_cancel).O(R.string.alert_dialog_ok).f(new d()).Q();
    }

    public final void b() {
        String string = this.r.getText().toString();
        String string2 = this.s.getText().toString();
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            F1(0);
            return;
        }
        if (!string.equals(string2)) {
            F1(0);
        } else if (dt2.c("[^\\u4e00-\\u9fa5]{8,16}", string)) {
            E1(string);
        } else {
            F1(1);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D1();
        setContentView(R.layout.activity_change_password);
        B1();
        C1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        e56 e56Var = this.u;
        if (e56Var != null) {
            e56Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        G1();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        G1();
        return true;
    }
}
