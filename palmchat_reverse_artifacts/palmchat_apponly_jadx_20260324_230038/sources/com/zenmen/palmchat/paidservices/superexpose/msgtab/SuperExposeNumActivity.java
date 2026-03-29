package com.zenmen.palmchat.paidservices.superexpose.msgtab;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bj5;
import defpackage.do5;
import defpackage.ds0;
import defpackage.fo5;
import defpackage.go5;
import defpackage.hs3;
import defpackage.l50;
import defpackage.qm5;
import defpackage.ro2;
import defpackage.xn5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeNumActivity extends BaseActionBarActivity {
    public View q = null;
    public TextView r = null;
    public TextView s = null;
    public TextView t = null;
    public ImageView u = null;
    public TextView v = null;
    public ViewGroup w = null;
    public View x = null;
    public go5 y = null;
    public do5 z = null;
    public TextView A = null;
    public TextView B = null;
    public final int C = 1;
    public final int E = 2;
    public int F = 1;
    public int G = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            hs3.f();
            com.zenmen.palmchat.paidservices.superexpose.a.b().g(SuperExposeNumActivity.this, 0, 35, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ro2 ro2VarA = bj5.b().a();
            SuperExposeNumActivity superExposeNumActivity = SuperExposeNumActivity.this;
            ro2VarA.I(superExposeNumActivity, 35, 0, superExposeNumActivity.G, fo5.l);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SuperExposeNumActivity.this.C1(2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            SuperExposeNumActivity.this.C1(1);
        }
    }

    public final void C1(int i) {
        LogUtil.d("", "MsgTabTaijiModelManager SuperExposeNumActivity changeRecycleTab mCurTab " + this.F + " tab " + i);
        if (this.F != i) {
            this.F = i;
            if (i == 1) {
                this.A.setTextColor(Color.parseColor("#222222"));
                this.B.setTextColor(Color.parseColor("#999999"));
                this.y.h(0);
                this.z.h(8);
                return;
            }
            if (i == 2) {
                this.B.setTextColor(Color.parseColor("#222222"));
                this.A.setTextColor(Color.parseColor("#999999"));
                this.y.h(8);
                this.z.h(0);
            }
        }
    }

    public final void D1() {
        if (getIntent() != null) {
            this.G = getIntent().getIntExtra("status", 0);
            LogUtil.d("", "MsgTabTaijiModelManager SuperExposeNumActivity initIntentValue mStatus " + this.G);
        }
    }

    public final void E1() {
        if (this.G == 1) {
            this.u.setVisibility(8);
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
            this.u.setVisibility(0);
        }
    }

    public final void F1() {
        this.r = (TextView) findViewById(R.id.count_title);
        this.s = (TextView) findViewById(R.id.super_num_title);
        this.t = (TextView) findViewById(R.id.super_sub_title);
        this.u = (ImageView) findViewById(R.id.super_num_show_dialog);
        this.v = (TextView) findViewById(R.id.super_num_text_dialog);
        E1();
        this.q = findViewById(R.id.super_num_buy_layout);
        this.u.setOnClickListener(new a());
        this.v.setOnClickListener(new b());
        TextView textView = (TextView) findViewById(R.id.super_expose_num_distance);
        this.B = textView;
        textView.setOnClickListener(new c());
        TextView textView2 = (TextView) findViewById(R.id.super_expose_num_mind);
        this.A = textView2;
        textView2.setOnClickListener(new d());
        this.w = (ViewGroup) findViewById(R.id.mind_distance_recycler_all_layout);
        this.x = findViewById(R.id.mind_distance_recycler_no_layout);
        this.y = new go5(this.w, this);
        this.z = new do5(this.w, this);
        this.y.h(0);
    }

    public void G1(SuperExposeTabData superExposeTabData) {
        if (superExposeTabData != null) {
            String str = superExposeTabData.count;
            if (!TextUtils.isEmpty(str)) {
                this.r.setText(str);
                if ("0人".equals(str)) {
                    this.w.setVisibility(8);
                    this.x.setVisibility(0);
                } else {
                    this.w.setVisibility(0);
                    this.x.setVisibility(8);
                }
            }
            String str2 = superExposeTabData.title;
            if (!TextUtils.isEmpty(str2)) {
                this.s.setText(str2);
            }
            String str3 = superExposeTabData.subTitle;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.t.setText(str3);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_super_expose_num_all);
        ds0.a().c(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar(toolbar, "", true);
        toolbar.setBackgroundColor(0);
        D1();
        F1();
        hs3.h(null, 0);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
    }

    @qm5
    public void onSuperExposeEvent(xn5 xn5Var) {
        if (xn5Var == null || xn5Var.f22014a != 0) {
            return;
        }
        this.G = 1;
        E1();
    }
}
