package com.zenmen.palmchat.settings.cert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.e00;
import defpackage.hx3;
import defpackage.l50;
import defpackage.sy5;
import defpackage.tk5;
import defpackage.vm0;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MyCertActivity extends BaseActionBarActivity {
    public Toolbar q;
    public LinearLayout r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public ImageView v;
    public int w;
    public int x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(AppContext.getContext(), R.string.people_match_cert_error, 0).g();
                return;
            }
            if (l50.a()) {
                return;
            }
            if (MyCertActivity.this.w == -101) {
                sy5.e(AppContext.getContext(), R.string.string_reviewing_toast, 0).g();
            } else if (MyCertActivity.this.w == -100) {
                sy5.e(AppContext.getContext(), R.string.string_cert_more_times, 0).g();
            } else {
                MyCertActivity.this.startActivity(new Intent(MyCertActivity.this, (Class<?>) CertGuideActivity.class));
            }
            e00.a("authentication_main_realperson_click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e00.a("authentication_main_back_click");
            MyCertActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {
        public d() {
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            sy5.e(AppContext.getContext(), R.string.people_match_cert_error, 0).g();
            MyCertActivity.this.I1(-1, -1);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("MyCertActivity", ":" + jSONObject);
            if (jSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode", -1);
            if (iOptInt != 0) {
                onFail(new Exception("code is wrong:" + iOptInt));
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                onFail(new Exception("data is null"));
                return;
            }
            MyCertActivity.this.w = jSONObjectOptJSONObject.optInt("realPerson");
            MyCertActivity.this.x = jSONObjectOptJSONObject.optInt("realName");
            MyCertActivity myCertActivity = MyCertActivity.this;
            myCertActivity.I1(myCertActivity.w, MyCertActivity.this.x);
        }
    }

    public final void F1() {
        zw4.f(vm0.h1, 1, null, new d());
    }

    public final void G1() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setBackgroundResource(R.color.color_trans);
        Toolbar toolbar = this.q;
        toolbar.setPadding(0, toolbar.getPaddingTop(), 0, 0);
        setSupportActionBar(this.q);
        findViewById(R.id.back).setOnClickListener(new c());
    }

    public final void H1() {
        G1();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.my_cert_bottom);
        this.r = linearLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = a46.b(this, 188.0f) + this.q.getPaddingTop();
        this.r.setLayoutParams(layoutParams);
        this.s = (TextView) findViewById(R.id.zrrz_to_cert);
        this.t = (ImageView) findViewById(R.id.zrrz_success);
        this.u = (TextView) findViewById(R.id.smrz_to_cert);
        this.v = (ImageView) findViewById(R.id.smrz_success);
        this.s.setOnClickListener(new a());
        this.u.setOnClickListener(new b());
    }

    public final void I1(int i, int i2) {
        if (i == 1) {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        }
        if (i2 == 1) {
            this.u.setVisibility(8);
            this.v.setVisibility(0);
        } else {
            this.u.setVisibility(0);
            this.v.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_cert);
        tk5.a(this);
        e00.a("authentication_main_show");
        H1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        F1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!hx3.m(AppContext.getContext())) {
                sy5.e(AppContext.getContext(), R.string.people_match_cert_error, 0).g();
            } else {
                if (l50.a()) {
                    return;
                }
                com.zenmen.palmchat.settings.cert.a.a().d(MyCertActivity.this, new a());
                e00.a("authentication_main_realname_click");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.b {
            public a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
            }
        }
    }
}
