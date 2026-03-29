package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.w;
import com.ss.android.ttvecamera.TECameraSettings;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.EncryptUtils;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.k86;
import defpackage.r75;
import defpackage.sd3;
import defpackage.y63;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class WelcomeBackActivity extends BaseActivityWithoutCheckAccount {
    public Response.Listener<String> A;
    public Response.ErrorListener B;
    public Response.Listener<JSONObject> C;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Toolbar w;
    public ImageView x;
    public TextView y;
    public Response.ErrorListener z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.ErrorListener {
        public a() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            WelcomeBackActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<String> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            try {
                if (new JSONObject(str).optInt("resultCode") == 0) {
                    y63.p(WelcomeBackActivity.this.t, WelcomeBackActivity.this.s, WelcomeBackActivity.this.u, "0", WelcomeBackActivity.this.B, WelcomeBackActivity.this.C);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            WelcomeBackActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                WelcomeBackActivity.this.G1();
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
                WelcomeBackActivity.this.G1();
            }
        }

        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            WelcomeBackActivity.this.hideBaseProgressBar();
            if (r75.d(AppContext.getContext(), "is_first_launch", true)) {
                if (y63.q(jSONObject, WelcomeBackActivity.this.t, WelcomeBackActivity.this.s) == 0) {
                    new sd3(WelcomeBackActivity.this).T(R.string.update_install_dialog_title).j(R.string.notice_read_phone_contact).h(false).O(R.string.dialog_confirm).K(R.string.dialog_cancel).f(new a()).e().show();
                }
            } else if (y63.q(jSONObject, WelcomeBackActivity.this.t, WelcomeBackActivity.this.s) == 0) {
                WelcomeBackActivity.this.G1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WelcomeBackActivity.this.startActivity(new Intent(WelcomeBackActivity.this, (Class<?>) MainTabsActivity.class));
            WelcomeBackActivity.this.setResult(-1);
            WelcomeBackActivity.this.finish();
        }
    }

    public final void G1() {
        new Handler().postDelayed(new e(), 100L);
    }

    public final void H1() {
        Intent intent = getIntent();
        this.q = intent.getStringExtra("nick_name");
        this.r = intent.getStringExtra(TECameraSettings.SCENE_MODE_PORTRAIT);
        this.s = intent.getStringExtra("phone_number");
        this.t = intent.getStringExtra(w.v);
        this.u = intent.getStringExtra("password");
        this.v = intent.getStringExtra(Constant.MAP_KEY_UUID);
    }

    public final void I1() {
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
    }

    public final void J1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.welcome_back);
        this.w = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void K1() {
        this.x = (ImageView) findViewById(R.id.portrait);
        gr2.j().h(this.r, this.x, bq6.s());
        TextView textView = (TextView) findViewById(R.id.nick_name);
        this.y = textView;
        textView.setText(this.q);
        showBaseProgressBar(getString(R.string.progress_sending), false);
    }

    public void login(View view) {
        this.mBaseProgressDialog.show();
        y63.w(this.v, this.t, this.s, this.q, EncryptUtils.digestString(this.u), String.valueOf(k86.C()), null, "android", this.z, this.A);
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_welcome_back);
        H1();
        I1();
        J1();
        K1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
