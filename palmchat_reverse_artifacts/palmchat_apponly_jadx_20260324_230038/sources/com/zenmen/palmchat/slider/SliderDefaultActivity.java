package com.zenmen.palmchat.slider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.bq;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.r75;
import defpackage.st2;
import defpackage.sy5;
import defpackage.te5;
import defpackage.u13;
import defpackage.zn6;
import defpackage.zt5;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SliderDefaultActivity extends BaseActionBarActivity {
    public static int A = 1;
    public static int B = 2;
    public static String x = "SliderDefaultActivity";
    public static String y = "is_show_error_view";
    public static String z = "scence_id";
    public View q;
    public View r;
    public boolean s;
    public String t;
    public Response.ErrorListener u;
    public Response.Listener v;
    public boolean w = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.slider.SliderDefaultActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1106a implements Runnable {
            public RunnableC1106a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                te5.a().c(SliderDefaultActivity.this.t, SliderDefaultActivity.this.u, SliderDefaultActivity.this.v);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SliderDefaultActivity sliderDefaultActivity = SliderDefaultActivity.this;
            if (sliderDefaultActivity.w) {
                sliderDefaultActivity.showBaseProgressBar(R.string.loading, false);
                SliderDefaultActivity.this.w = false;
                new Handler().postDelayed(new RunnableC1106a(), 500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            SliderDefaultActivity.this.hideBaseProgressBar();
            SliderDefaultActivity.this.w = true;
            LogUtil.i(SliderDefaultActivity.x, "isSliderShow errorMsg = " + volleyError.toString());
            SliderDefaultActivity.this.M1(true);
            sy5.f(SliderDefaultActivity.this.getApplicationContext(), SliderDefaultActivity.this.getApplicationContext().getString(R.string.slider_timeout), 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(SliderDefaultActivity.x, "isSliderShow response = " + jSONObject.toString());
            SliderDefaultActivity.this.hideBaseProgressBar();
            SliderDefaultActivity.this.w = true;
            if (jSONObject.optInt("resultCode") != 0) {
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                LogUtil.i(SliderDefaultActivity.x, "errorMsg = " + strOptString);
                SliderDefaultActivity.this.M1(true);
                sy5.f(SliderDefaultActivity.this.getApplicationContext(), SliderDefaultActivity.this.getApplication().getString(R.string.slider_error), 0).g();
                return;
            }
            if (jSONObject.optBoolean(bq.b.V)) {
                te5 te5VarA = te5.a();
                SliderDefaultActivity sliderDefaultActivity = SliderDefaultActivity.this;
                String strB = te5VarA.b(sliderDefaultActivity.I1(sliderDefaultActivity.t));
                if (!SliderDefaultActivity.this.t.equals(te5.e)) {
                    SliderDefaultActivity sliderDefaultActivity2 = SliderDefaultActivity.this;
                    sliderDefaultActivity2.J1(strB, sliderDefaultActivity2.t);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(SliderDefaultActivity.this, CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", strB);
                bundle.putBoolean("web_show_right_menu", false);
                bundle.putBoolean("disable_back_keycode", true);
                bundle.putBoolean("hide_close", true);
                intent.putExtras(bundle);
                SliderDefaultActivity.this.startActivityForResult(intent, SliderDefaultActivity.A);
                return;
            }
            if (SliderDefaultActivity.this.t.equals(te5.d)) {
                r75.o(SliderDefaultActivity.this, "sp_slider_show_default_login", false);
                r75.o(SliderDefaultActivity.this, "sp_slider_show_default_upgrade", false);
                SliderDefaultActivity.this.startActivity(new Intent(SliderDefaultActivity.this, (Class<?>) MainTabsActivity.class));
                SliderDefaultActivity.this.finish();
                return;
            }
            if (SliderDefaultActivity.this.t.equals(te5.e)) {
                r75.o(SliderDefaultActivity.this, "sp_slider_show_default_register", false);
                SliderDefaultActivity.this.setResult(-1);
                SliderDefaultActivity.this.finish();
            } else {
                if (!SliderDefaultActivity.this.t.equals(te5.f)) {
                    SliderDefaultActivity.this.setResult(-1);
                    SliderDefaultActivity.this.finish();
                    return;
                }
                if (TeenagersModeManager.a().d()) {
                    zt5.c();
                } else {
                    u13.b().a();
                    Intent intentC = st2.c();
                    LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), BaseWrapper.ENTER_ID_OAPS_DEMO, "1", null, null);
                    zn6.d("lx_client_near_31", null, null);
                    intentC.putExtra("fromType", 3);
                    SliderDefaultActivity.this.startActivity(intentC);
                }
                SliderDefaultActivity.this.finish();
            }
        }
    }

    public final int I1(String str) {
        if (str.equals(te5.d)) {
            return 1;
        }
        if (str.equals(te5.e)) {
            return 2;
        }
        if (str.equals(te5.f)) {
            return 3;
        }
        if (str.equals(te5.g)) {
            return 4;
        }
        if (str.equals(te5.h)) {
            return 5;
        }
        return str.equals(te5.i) ? 6 : 0;
    }

    public final void J1(String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        if (str2.equals(te5.e) || str2.equals(te5.d)) {
            bundle.putBoolean("disable_back_keycode", true);
            bundle.putBoolean("hide_close", true);
        }
        intent.putExtras(bundle);
        if (str2.equals(te5.h) || str2.equals(te5.g)) {
            startActivityForResult(intent, B);
        } else {
            startActivity(intent);
            finish();
        }
    }

    public final void K1() {
        this.u = new b();
        this.v = new c();
    }

    public final void L1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.s = intent.getBooleanExtra(y, false);
            this.t = intent.getStringExtra(z);
        }
        String str = this.t;
        if (str == null || !(str.equals(te5.d) || this.t.equals(te5.e))) {
            initToolbar(R.string.slider_title);
        } else {
            initToolbar(R.string.slider_title, false);
        }
        this.q = findViewById(R.id.slider_view);
        View viewFindViewById = findViewById(R.id.error_view);
        this.r = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        M1(this.s);
        if (this.s || TextUtils.isEmpty(this.t)) {
            return;
        }
        te5.a().c(this.t, this.u, this.v);
    }

    public final void M1(boolean z2) {
        if (z2) {
            this.q.setVisibility(8);
            this.r.setVisibility(0);
        } else {
            this.q.setVisibility(0);
            this.r.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == A || i == B) && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i == B && i2 == 0) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_slider_default);
        K1();
        L1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (this.t.equals(te5.e) || this.t.equals(te5.d))) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
