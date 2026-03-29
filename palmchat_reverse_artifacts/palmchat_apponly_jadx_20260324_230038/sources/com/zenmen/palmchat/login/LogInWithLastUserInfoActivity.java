package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.w;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.mt2;
import defpackage.r75;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.td3;
import defpackage.y63;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LogInWithLastUserInfoActivity extends BaseActivityWithoutCheckAccount {
    public Response.ErrorListener A;
    public Response.Listener<JSONObject> B;
    public Handler C;
    public InputMethodManager E;
    public ImageView r;
    public TextView s;
    public EditText t;
    public TextView u;
    public TextView v;
    public TextView w;
    public ScrollView x;
    public final String q = LogInWithLastUserInfoActivity.class.getSimpleName();
    public String y = null;
    public String z = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements mt2.c {

        /* JADX INFO: renamed from: com.zenmen.palmchat.login.LogInWithLastUserInfoActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1066a implements Runnable {
            public RunnableC1066a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogInWithLastUserInfoActivity.this.x.scrollTo(0, 5000);
            }
        }

        public a() {
        }

        @Override // mt2.c
        public void onSoftKeyboardStatusChanged(int i, int i2) {
            if (i == 0) {
                LogInWithLastUserInfoActivity.this.C.post(new RunnableC1066a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogInWithLastUserInfoActivity.this.startActivity(new Intent(LogInWithLastUserInfoActivity.this, (Class<?>) MainTabsActivity.class));
            LogInWithLastUserInfoActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(LogInWithLastUserInfoActivity.this, R.string.net_status_unavailable, 1).g();
            } else {
                y63.p(LogInWithLastUserInfoActivity.this.z, LogInWithLastUserInfoActivity.this.y, LogInWithLastUserInfoActivity.this.t.getText().toString(), "0", LogInWithLastUserInfoActivity.this.A, LogInWithLastUserInfoActivity.this.B);
                LogInWithLastUserInfoActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_login), false, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(LogInWithLastUserInfoActivity.this, (Class<?>) LoginWithSmsActivity.class);
            intent.putExtra(w.v, LogInWithLastUserInfoActivity.this.z);
            intent.putExtra("phone_number", LogInWithLastUserInfoActivity.this.y);
            LogInWithLastUserInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {
            public a() {
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (i == 0) {
                    LogInWithLastUserInfoActivity.this.startActivityForResult(new Intent(LogInWithLastUserInfoActivity.this, (Class<?>) LogInActivity.class), 1);
                } else if (i == 1) {
                    LogInWithLastUserInfoActivity.this.startActivityForResult(new Intent(LogInWithLastUserInfoActivity.this, (Class<?>) SignUpActivity.class), 2);
                }
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new td3.c(LogInWithLastUserInfoActivity.this).c(new String[]{LogInWithLastUserInfoActivity.this.getResources().getString(R.string.switch_account), LogInWithLastUserInfoActivity.this.getResources().getString(R.string.sign_up)}).d(new a()).a().b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            LogInWithLastUserInfoActivity.this.E.hideSoftInputFromWindow(LogInWithLastUserInfoActivity.this.t.getWindowToken(), 0);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(LogInWithLastUserInfoActivity.this.q, volleyError.toString());
            LogInWithLastUserInfoActivity.this.hideBaseProgressBar();
            sy5.e(LogInWithLastUserInfoActivity.this, R.string.login_fail, 1).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {
        public i() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(LogInWithLastUserInfoActivity.this.q, jSONObject.toString());
            LogInWithLastUserInfoActivity.this.hideBaseProgressBar();
            int iQ = y63.q(jSONObject, LogInWithLastUserInfoActivity.this.z, LogInWithLastUserInfoActivity.this.y);
            if (iQ == 0) {
                LogInWithLastUserInfoActivity.this.O1();
                return;
            }
            if (iQ == 1203) {
                LogInWithLastUserInfoActivity.this.R1();
                return;
            }
            if (iQ == 1212) {
                LogInWithLastUserInfoActivity.this.S1();
            } else if (iQ != 1213) {
                LogInWithLastUserInfoActivity.this.R1();
            } else {
                LogInWithLastUserInfoActivity.this.T1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends MaterialDialog.e {
        public j() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            Intent intent = new Intent(LogInWithLastUserInfoActivity.this, (Class<?>) LoginWithSmsActivity.class);
            intent.putExtra(w.v, LogInWithLastUserInfoActivity.this.z);
            intent.putExtra("phone_number", LogInWithLastUserInfoActivity.this.y);
            LogInWithLastUserInfoActivity.this.startActivityForResult(intent, 3);
        }
    }

    public final void O1() {
        this.C.postDelayed(new b(), 100L);
    }

    public final void P1() {
        this.A = new h();
        this.B = new i();
    }

    public final void Q1() {
        this.r = (ImageView) findViewById(R.id.portrait);
        this.s = (TextView) findViewById(R.id.account);
        this.t = (EditText) findViewById(R.id.password);
        this.x = (ScrollView) findViewById(R.id.scrollView);
        this.t.addTextChangedListener(new c());
        this.u = (TextView) findViewById(R.id.login);
        this.v = (TextView) findViewById(R.id.forget_password);
        this.w = (TextView) findViewById(R.id.more);
        try {
            JSONObject jSONObject = new JSONObject(r75.i(AppContext.getContext(), "last_login_user_info"));
            this.y = jSONObject.optString("phone");
            this.z = jSONObject.optString("ic");
            this.s.setText(hs0.g().a(this.y, this.z));
            gr2.j().h(jSONObject.optString("headIconUrl"), this.r, bq6.s());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.u.setOnClickListener(new d());
        this.v.setOnClickListener(new e());
        this.w.setOnClickListener(new f());
        this.x.setOnTouchListener(new g());
    }

    public final void R1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_content).O(R.string.alert_dialog_ok).e().show();
    }

    public final void S1() {
        new sd3(this).T(R.string.login_fail_title).j(R.string.login_fail_reset_content).O(R.string.find_password).K(R.string.alert_dialog_cancel).f(new j()).e().show();
    }

    public final void T1() {
        new sd3(this).j(R.string.login_fail_fast_content).O(R.string.alert_dialog_ok).e().show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 1 || i2 == 2 || i2 == 3) && i3 == -1) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = new Handler();
        this.E = (InputMethodManager) getSystemService("input_method");
        setContentView(R.layout.layout_activity_login_with_userinfo);
        initToolbar(getString(R.string.app_name), false);
        P1();
        Q1();
        mt2.a(this, new a());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LogInWithLastUserInfoActivity.this.u.setEnabled(!TextUtils.isEmpty(LogInWithLastUserInfoActivity.this.t.getText()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
