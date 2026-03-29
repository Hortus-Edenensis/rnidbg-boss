package com.zenmen.palmchat.circle.coupon.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.me1;
import defpackage.o70;
import defpackage.q70;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCouponInfoActivity extends BaseActionBarActivity {
    public View A;
    public View B;
    public View C;
    public LinearLayout E;
    public LinearLayout F;
    public o70 G;
    public ArrayList<CircleCouponInfoItem> H = new ArrayList<>();
    public String I;
    public String J;
    public q70 K;
    public Toolbar q;
    public EffectiveShapeView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ListView y;
    public View z;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleCouponInfoActivity.this.I1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleCouponInfoActivity.this.I1();
        }
    }

    public static void J1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) CircleCouponInfoActivity.class);
        intent.putExtra("key_extra_packet_rid", str);
        intent.putExtra("key_extra_packet_vcode", str2);
        context.startActivity(intent);
    }

    public final void C1() {
        this.K.h();
    }

    public final void D1() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.list_circle_info_footer_view, (ViewGroup) null);
        this.A = viewInflate;
        this.z = viewInflate.findViewById(R.id.loading);
        this.y.addFooterView(this.A);
    }

    public final void E1() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_circle_coupon_info_header, (ViewGroup) null);
        this.B = viewInflate;
        this.F = (LinearLayout) viewInflate.findViewById(R.id.layout_amount);
        EffectiveShapeView effectiveShapeView = (EffectiveShapeView) this.B.findViewById(R.id.portrait);
        this.r = effectiveShapeView;
        effectiveShapeView.changeShapeType(3);
        this.r.setDegreeForRoundRectangle(13, 13);
        this.r.setBorderWidth(me1.a(this, 1.5f));
        this.r.setBorderColor(getResources().getColor(R.color.toolbar_red_portrait_line));
        this.s = (TextView) this.B.findViewById(R.id.remark);
        this.t = (TextView) this.B.findViewById(R.id.amount);
        this.v = (TextView) this.B.findViewById(R.id.tip);
        this.x = (TextView) this.B.findViewById(R.id.message);
        this.E = (LinearLayout) this.B.findViewById(R.id.container);
        this.w = (TextView) this.B.findViewById(R.id.sender_tips);
        this.C = this.B.findViewById(R.id.head_below_line);
        this.y.addHeaderView(this.B);
    }

    public final void F1() {
        this.y = (ListView) findViewById(R.id.info_list);
        this.G = new o70(this);
        D1();
        E1();
        this.y.setAdapter((ListAdapter) this.G);
        this.y.setOnScrollListener(new a());
        M1(false, false);
    }

    public final void G1() {
        showBaseProgressBar(R.string.progress_sending, false);
        Intent intent = getIntent();
        if (intent != null) {
            this.I = intent.getStringExtra("key_extra_packet_rid");
            this.J = intent.getStringExtra("key_extra_packet_vcode");
        }
    }

    public void H1(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.send_failed);
        }
        sy5.f(this, str, 0).g();
    }

    public final void I1() {
        Intent intent = new Intent(this, (Class<?>) CordovaWebActivity.class);
        intent.putExtra("web_url", CircleConfig.getCouponUrl());
        startActivity(intent);
    }

    public void K1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.t.setText(str);
        }
    }

    public void L1(List<CircleCouponInfoItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.H.addAll(list);
        this.G.a(this.H);
    }

    public void M1(boolean z, boolean z2) {
        this.A.setVisibility(z ? 0 : 8);
        if (z2) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
    }

    public void N1(boolean z) {
        this.y.setVisibility(z ? 0 : 8);
    }

    public void O1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.x.setVisibility(8);
            this.C.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.x.setText(str);
        }
    }

    public void P1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.w.setText(str);
        this.w.setVisibility(0);
        this.F.setVisibility(8);
    }

    public void Q1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gr2.j().h(str, this.r, bq6.s());
    }

    public void R1(boolean z) {
        if (!z) {
            this.v.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        this.v.setText(getString(R.string.circle_coupon_info_receive_tips));
        this.v.setOnClickListener(new b());
    }

    public void S1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.setVisibility(0);
        this.s.setText(str);
    }

    public final void initActionBar() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setNavigationIcon(R.drawable.circle_coupon_left_arrow);
        TextView textView = (TextView) findViewById(R.id.title);
        this.u = textView;
        textView.setTextColor(getResources().getColor(R.color.color_FFE5B1));
        this.u.setText(getString(R.string.circle_coupon_info_title));
        TextView textView2 = (TextView) this.q.findViewById(R.id.action_button);
        textView2.setVisibility(0);
        textView2.setText(getString(R.string.circle_coupon_info_my_card_package));
        textView2.setTextColor(getResources().getColor(R.color.color_FFE5B1));
        textView2.setOnClickListener(new c());
        setSupportActionBar(this.q);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coupon_info);
        G1();
        initActionBar();
        setRedStatusBarColor();
        F1();
        q70 q70Var = new q70(this.I, this.J);
        this.K = q70Var;
        q70Var.e(this);
        C1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.K.f();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 || absListView.getLastVisiblePosition() <= absListView.getCount() - 10) {
                return;
            }
            CircleCouponInfoActivity.this.K.i();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
