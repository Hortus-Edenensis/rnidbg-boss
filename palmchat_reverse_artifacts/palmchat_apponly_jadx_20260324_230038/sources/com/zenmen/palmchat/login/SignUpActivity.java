package com.zenmen.palmchat.login;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.huawei.openalliance.ad.constant.w;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.login.countrycode.CountryCodeListActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dt2;
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
public class SignUpActivity extends BaseActivityWithoutCheckAccount implements TextWatcher {
    public View q;
    public EditText r;
    public EditText s;
    public EditText t;
    public EditText u;
    public View v;
    public TextView w;
    public ImageView x;
    public String y;
    public boolean z = true;
    public gs A = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            SignUpActivity.this.O1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends gs {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f14442a;

            public a(JSONObject jSONObject) {
                this.f14442a = jSONObject;
                put("action", "request_sms");
                put("status", "success");
                put("detail", jSONObject);
                put("phone_number", SignUpActivity.this.r.getText().toString());
                put("type", 1);
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.login.SignUpActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1069b extends HashMap<String, Object> {
            public C1069b() {
                put("action", "request_sms");
                put("status", "fail");
                put("phone_number", SignUpActivity.this.r.getText().toString());
                put("type", 1);
            }
        }

        public b() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            SignUpActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new C1069b(), exc);
            sy5.e(SignUpActivity.this, R.string.network_exception_title, 0).g();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            SignUpActivity.this.hideBaseProgressBar();
            LogUtil.i(gs.e, 3, new a(jSONObject), (Throwable) null);
            if (yy2Var.f22300a) {
                String strOptString = yy2Var.d.optString("smsid");
                Intent intent = new Intent(SignUpActivity.this, (Class<?>) SMSCodeValidateActivity.class);
                intent.putExtra("smsid", strOptString);
                intent.putExtra("nick_name", SignUpActivity.this.u.getText().toString());
                intent.putExtra("phone_number", SignUpActivity.this.r.getText().toString());
                intent.putExtra(w.v, SignUpActivity.this.s.getText().toString());
                intent.putExtra("password", SignUpActivity.this.t.getText().toString());
                intent.putExtra(TECameraSettings.SCENE_MODE_PORTRAIT, SignUpActivity.this.y);
                SignUpActivity.this.startActivityForResult(intent, 3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            int i2;
            if (dt2.c("[^\\u4e00-\\u9fa5]{8,16}", SignUpActivity.this.t.getText().toString())) {
                i = -1;
                i2 = -1;
            } else {
                i = R.string.sign_up_failed;
                i2 = R.string.invalid_char_password;
            }
            if (i == -1 || i2 == -1) {
                SignUpActivity.this.P1();
            } else {
                new sd3(SignUpActivity.this).T(i).j(i2).O(R.string.alert_dialog_ok).Q();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SignUpActivity.this.startActivityForResult(new Intent(SignUpActivity.this, (Class<?>) CountryCodeListActivity.class), 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(SignUpActivity.this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            SignUpActivity.this.startActivityForResult(intent, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f14448a;

        public g(ImageView imageView) {
            this.f14448a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f14448a.isSelected()) {
                this.f14448a.setSelected(false);
                SignUpActivity.this.t.setInputType(129);
            } else {
                this.f14448a.setSelected(true);
                SignUpActivity.this.t.setInputType(144);
            }
            SignUpActivity.this.t.requestFocus();
            SignUpActivity.this.t.setSelection(SignUpActivity.this.t.getText().length());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f14449a;

        public h(View view) {
            this.f14449a = view;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (SignUpActivity.this.r.hasFocus() || SignUpActivity.this.s.hasFocus()) {
                this.f14449a.setBackgroundResource(R.drawable.shape_light_green_underline);
            } else {
                this.f14449a.setBackgroundResource(R.drawable.shape_light_gray_underline);
            }
        }
    }

    public final void L1() {
        h hVar = new h(findViewById(R.id.phoneContainer));
        this.r.setOnFocusChangeListener(hVar);
        this.s.setOnFocusChangeListener(hVar);
    }

    public final void M1() {
        ImageView imageView = (ImageView) findViewById(R.id.show_password);
        imageView.setOnClickListener(new g(imageView));
    }

    public final void N1() {
        this.q = findViewById(R.id.sign_up_text);
        EditText editText = (EditText) findViewById(R.id.nick_name_edit);
        this.u = editText;
        editText.addTextChangedListener(this);
        this.q.setOnClickListener(new c());
        EditText editText2 = (EditText) findViewById(R.id.phone_number_edit);
        this.r = editText2;
        editText2.addTextChangedListener(this);
        EditText editText3 = (EditText) findViewById(R.id.country_code_edit);
        this.s = editText3;
        editText3.addTextChangedListener(new d());
        EditText editText4 = (EditText) findViewById(R.id.password_edit);
        this.t = editText4;
        editText4.addTextChangedListener(this);
        View viewFindViewById = findViewById(R.id.country_name_view);
        this.v = viewFindViewById;
        viewFindViewById.setOnClickListener(new e());
        this.w = (TextView) findViewById(R.id.country_name_textview);
        ImageView imageView = (ImageView) findViewById(R.id.take_photo);
        this.x = imageView;
        imageView.setOnClickListener(new f());
        L1();
        M1();
    }

    public final void O1() {
        showBaseProgressBar();
        y63.j().r(this.s.getText().toString(), this.r.getText().toString(), 1, this.A);
    }

    public final void P1() {
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            return;
        }
        if (!hs0.g().j(this.r.getText().toString(), this.s.getText().toString())) {
            new sd3(this).T(R.string.phone_number_error).j(R.string.invalid_phone_number).O(R.string.alert_dialog_ok).Q();
            return;
        }
        sd3 sd3Var = new sd3(this);
        sd3Var.T(R.string.confirm_phone_number).k(getResources().getString(R.string.confirm_phone_number_send_des, hs0.g().b(this.r.getText().toString(), this.s.getText().toString(), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL))).h(true).O(R.string.alert_dialog_ok).K(R.string.alert_dialog_cancel).f(new a());
        sd3Var.e().show();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.u.getText().length() <= 0 || this.r.getText().length() <= 0 || this.t.getText().length() <= 0 || !this.z) {
            this.q.setEnabled(false);
        } else {
            this.q.setEnabled(true);
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
            this.s.setText(stringExtra2);
            return;
        }
        if (i != 2 || i2 != -1) {
            if (i == 3 && i2 == -1) {
                setResult(-1);
                finish();
                return;
            }
            return;
        }
        String stringExtra3 = intent.getStringExtra("media_pick_photo_key");
        this.y = stringExtra3;
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        this.x.setImageBitmap(BitmapFactory.decodeFile(this.y));
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_signup);
        initToolbar(R.string.signup_activity_title);
        N1();
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

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        dt2.d(this.u, charSequence, 32);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string = editable.toString();
            if (TextUtils.isEmpty(string)) {
                SignUpActivity.this.w.setText(R.string.choose_from_list);
                SignUpActivity.this.z = false;
                return;
            }
            if (com.zenmen.palmchat.login.countrycode.b.b().c().containsKey(string)) {
                SignUpActivity.this.w.setText(com.zenmen.palmchat.login.countrycode.b.b().c().get(string));
                SignUpActivity.this.z = true;
            } else {
                SignUpActivity.this.z = false;
                SignUpActivity.this.w.setText(R.string.invalid_country_code);
            }
            if (SignUpActivity.this.u.getText().length() <= 0 || SignUpActivity.this.r.getText().length() <= 0 || SignUpActivity.this.t.getText().length() <= 0 || !SignUpActivity.this.z) {
                SignUpActivity.this.q.setEnabled(false);
            } else {
                SignUpActivity.this.q.setEnabled(true);
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
}
