package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.LinkMobileActivity;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.bo0;
import defpackage.fn0;
import defpackage.hx3;
import defpackage.k86;
import defpackage.l50;
import defpackage.n50;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.ve;
import defpackage.w4;
import java.util.HashMap;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AccountAndSafeSettingsActivity extends BaseActionBarActivity {
    public ContactInfoItem q;
    public TextView r;
    public View s;
    public TextView t;
    public View u;
    public ImageView v;
    public n50 w;
    public View x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15094a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f15094a = str;
            this.b = str2;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            AccountAndSafeSettingsActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") != 0) {
                AccountAndSafeSettingsActivity.this.I1(this.b);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(AccountAndSafeSettingsActivity.this, UpdatePasswordActivity.class);
            intent.putExtra("encrypt_ori_password", this.f15094a);
            AccountAndSafeSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            AccountAndSafeSettingsActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AccountAndSafeSettingsActivity.this.q = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            AccountAndSafeSettingsActivity.this.updateViews();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AccountAndSafeSettingsActivity.this.q == null || !TextUtils.isEmpty(AccountAndSafeSettingsActivity.this.q.getAccount())) {
                return;
            }
            Intent intent = new Intent(AccountAndSafeSettingsActivity.this, (Class<?>) ModifyPersonalInfoActivity.class);
            intent.putExtra("mode", 2);
            intent.putExtra("info", AccountAndSafeSettingsActivity.this.q.getNickName());
            intent.putExtra("info_2", AccountAndSafeSettingsActivity.this.q.getIconURL());
            AccountAndSafeSettingsActivity.this.startActivityForResult(intent, 40);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            boolean z;
            if (l50.a()) {
                return;
            }
            if (AccountAndSafeSettingsActivity.this.q == null || AccountAndSafeSettingsActivity.this.q.getExt() == null) {
                z = false;
            } else {
                z = true;
                if (AccountAndSafeSettingsActivity.this.q.getExt().getPrcRealName() != 1) {
                }
            }
            w4.B(AccountAndSafeSettingsActivity.this, 0, null, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccountAndSafeSettingsActivity.this, (Class<?>) LinkMobileActivity.class);
            intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_ACCOUNT");
            AccountAndSafeSettingsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountAndSafeSettingsActivity.this.J1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ve.o(AccountAndSafeSettingsActivity.this, "zenxin://activity?page=a0052&pkgId=deregister", false);
            LogUtil.onClickEvent("4363", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f15102a;

        public i(EditText editText) {
            this.f15102a = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(this.f15102a.getText().toString())) {
                AccountAndSafeSettingsActivity.this.I1(null);
            } else {
                AccountAndSafeSettingsActivity.this.G1(this.f15102a.getText().toString());
            }
        }
    }

    public final void G1(String str) {
        HashMap map = new HashMap();
        String strDigestString = EncryptUtils.digestString(str);
        map.put("originalPwd", strDigestString);
        if (!hx3.m(this)) {
            new sd3(this).T(R.string.update_install_dialog_title).j(R.string.string_plum_pwd_net).O(R.string.alert_dialog_ok).f(new k()).e().show();
            return;
        }
        n50 n50Var = new n50(new a(strDigestString, str), new b());
        this.w = n50Var;
        try {
            n50Var.n(map);
            showBaseProgressBar();
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void H1() {
        this.q = bo0.r().l(AccountUtils.p(AppContext.getContext()));
        this.v = (ImageView) findViewById(R.id.account_arrow);
        View viewFindViewById = findViewById(R.id.account_area);
        this.s = viewFindViewById;
        viewFindViewById.setOnClickListener(new d());
        findViewById(R.id.safe_account_prauthen).setOnClickListener(new e());
        this.r = (TextView) findViewById(R.id.account_textview);
        View viewFindViewById2 = findViewById(R.id.phone_area);
        this.u = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new f());
        if (ac1.C()) {
            this.u.setVisibility(8);
        }
        this.t = (TextView) findViewById(R.id.phone_number_textview);
        findViewById(R.id.setting_plum_pwd).setOnClickListener(new g());
        this.x = findViewById(R.id.safe_account_cancellation);
        updateViews();
    }

    public final void I1(String str) {
        new sd3(this).T(R.string.update_install_dialog_title).k(getString(TextUtils.isEmpty(str) ? R.string.string_empty_password_des : R.string.string_wrong_password_des)).O(R.string.alert_dialog_ok).f(new j()).e().show();
    }

    public final void J1() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_change_password_content, (ViewGroup) null);
        new sd3(this).p(viewInflate, false).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new i((EditText) viewInflate.findViewById(R.id.edit_text))).e().show();
    }

    public final void K1() {
        this.x.setVisibility(0);
        this.x.setOnClickListener(new h());
        LogUtil.onEvent("4362", null, null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 152;
    }

    public final void initActionBar() {
        initToolbar(R.string.string_setting_safe);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 40 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("info");
            ContactInfoItem contactInfoItem = this.q;
            if (contactInfoItem != null) {
                contactInfoItem.setAccount(stringExtra);
                updateViews();
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_safe);
        initActionBar();
        H1();
        bo0.r().i().j(this);
        K1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        n50 n50Var = this.w;
        if (n50Var != null) {
            n50Var.onCancel();
        }
        bo0.r().i().l(this);
        super.onDestroy();
    }

    @qm5
    public void onProfileUpdated(fn0 fn0Var) {
        runOnUiThread(new c());
    }

    public final void updateViews() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            if (TextUtils.isEmpty(contactInfoItem.getAccount())) {
                this.r.setText("");
            } else {
                this.r.setText(this.q.getAccount());
                this.v.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.q.getMobile())) {
                return;
            }
            this.t.setText(k86.O(this.q.getMobile()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends MaterialDialog.e {
        public j() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends MaterialDialog.e {
        public k() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }
}
