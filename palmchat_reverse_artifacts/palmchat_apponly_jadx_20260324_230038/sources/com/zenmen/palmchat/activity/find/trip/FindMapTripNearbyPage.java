package com.zenmen.palmchat.activity.find.trip;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.find.bean.LoadCountBean;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ds0;
import defpackage.ew1;
import defpackage.hx3;
import defpackage.l50;
import defpackage.qm5;
import defpackage.qw1;
import defpackage.v4;
import defpackage.vs0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FindMapTripNearbyPage extends FrameworkBaseActivity {
    public View A;
    public View B;
    public View C;
    public String E;
    public String s;
    public String t;
    public View z;
    public Context q = null;
    public List<LoadCountBean.MarkerBean> r = null;
    public TextView u = null;
    public TextView v = null;
    public View w = null;
    public View x = null;
    public TextView y = null;
    public String F = "提示：行程计划由用户发布，请仔细辨别真假，避免上当";
    public String G = "解锁聊天";
    public View H = null;
    public View I = null;
    public TripAllFragment J = null;
    public TripNormalFragment K = null;
    public MyFragmentPagerAdapter L = null;
    public View M = null;
    public ViewPager N = null;
    public List<LoadCountBean.MarkerBean> O = new ArrayList();
    public List<LoadCountBean.MarkerBean> P = new ArrayList();
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;

    /* JADX INFO: compiled from: SearchBox */
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Fragment> f12261a;

        public MyFragmentPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f12261a = new ArrayList();
        }

        public void f(Fragment fragment) {
            this.f12261a.add(fragment);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f12261a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.f12261a.get(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<LoadCountBean.MarkerBean> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LoadCountBean.MarkerBean markerBean, LoadCountBean.MarkerBean markerBean2) {
            if (markerBean == null || markerBean2 == null) {
                return 0;
            }
            String str = markerBean.distanceMi;
            String str2 = markerBean2.distanceMi;
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return 0;
                }
                return Float.parseFloat(str) < Float.parseFloat(str2) ? -1 : 0;
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<LoadCountBean.MarkerBean> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LoadCountBean.MarkerBean markerBean, LoadCountBean.MarkerBean markerBean2) {
            if (markerBean == null || markerBean2 == null) {
                return 0;
            }
            long jF = ew1.F(markerBean.uid + "", markerBean.scheduleOrderId);
            StringBuilder sb = new StringBuilder();
            sb.append(markerBean2.uid);
            sb.append("");
            return jF > ew1.F(sb.toString(), markerBean2.scheduleOrderId) ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripNearbyPage.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripNearbyPage.this.H1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            FindMapTripNearbyPage.this.I1(true);
        }
    }

    public final void C1(LoadCountBean.MarkerBean markerBean) {
        if (markerBean != null) {
            this.J.F(markerBean);
        }
    }

    public final void D1(LoadCountBean.MarkerBean markerBean) {
        if (markerBean != null) {
            this.J.I();
            this.K.D(markerBean);
            LogUtil.d("", "isResumeon enoughBeanSuccess isOtherDialogShow " + this.S);
            if (this.S) {
                return;
            }
            ew1.f0(markerBean, this);
        }
    }

    public final void E1() {
        this.u = (TextView) findViewById(R.id.trip_nearby_tool_all_text);
        this.v = (TextView) findViewById(R.id.trip_nearby_tool_normal_text);
        this.w = findViewById(R.id.trip_nearby_tool_all_line);
        this.x = findViewById(R.id.trip_nearby_tool_normal_line);
        TextView textView = (TextView) findViewById(R.id.trip_map_nearby_toast_text);
        this.y = textView;
        textView.setSelected(true);
        this.z = findViewById(R.id.trip_map_nearby_icon_all);
        this.A = findViewById(R.id.trip_map_nearby_icon_normal);
        this.H = findViewById(R.id.trip_map_nearby_network_error_layout);
        this.I = findViewById(R.id.trip_map_nearby_show_data);
        this.N = (ViewPager) findViewById(R.id.trip_nearby_viewpager_layout);
        this.M = findViewById(R.id.trip_map_nearby_toast_layout_all);
        View viewFindViewById = findViewById(R.id.trip_map_nearby_layout);
        this.B = viewFindViewById;
        viewFindViewById.setOnClickListener(new d());
        View viewFindViewById2 = findViewById(R.id.trip_map_nearby_click_close);
        this.C = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new e());
        findViewById(R.id.trip_nearby_tool_all_layout).setOnClickListener(new f());
        findViewById(R.id.trip_nearby_tool_normal_layout).setOnClickListener(new g());
        if (TextUtils.isEmpty(this.s)) {
            this.E = "查看位置: 距离你 " + this.t;
        } else {
            this.E = "查看位置: " + this.s;
        }
        JSONObject config = vs0.a().getConfig("mapFinderConfig");
        if (config != null) {
            try {
                JSONObject jSONObjectOptJSONObject = config.optJSONObject("itineraryConfig");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("unlockedlist_intro");
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.F = "提示: " + strOptString;
                    }
                    this.G = jSONObjectOptJSONObject.optString("notunlocklist_button", "解锁聊天");
                    LogUtil.d("TripNearByTag", "initView notunlocklistButton " + this.G + " noticeToast " + strOptString);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void F1() {
        this.S = false;
        LogUtil.d("", "isResumeonPause false");
    }

    public void G1() {
        this.S = true;
        LogUtil.d("", "isResumeonResume true ");
    }

    public final void H1(boolean z) {
        this.u.setTextColor(Color.parseColor("#222222"));
        this.u.setTypeface(Typeface.defaultFromStyle(1));
        this.w.setVisibility(0);
        this.v.setTextColor(Color.parseColor("#666666"));
        this.v.setTypeface(Typeface.defaultFromStyle(0));
        this.x.setVisibility(8);
        this.z.setVisibility(0);
        this.A.setVisibility(8);
        this.M.setVisibility(0);
        this.y.setText(this.E);
        if (z) {
            this.N.setCurrentItem(0, false);
        }
        if (this.R) {
            return;
        }
        this.R = true;
        ew1.o0(1);
    }

    public final void I1(boolean z) {
        this.v.setTextColor(Color.parseColor("#222222"));
        this.v.setTypeface(Typeface.defaultFromStyle(1));
        this.x.setVisibility(0);
        this.u.setTextColor(Color.parseColor("#666666"));
        this.u.setTypeface(Typeface.defaultFromStyle(0));
        this.w.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        this.y.setText(this.F);
        if (z) {
            this.N.setCurrentItem(1, false);
        }
        if (this.Q) {
            return;
        }
        this.Q = true;
        ew1.o0(2);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        ew1.m0();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_map_trip_nearby_layout);
        ds0.a().c(this);
        if (getIntent() != null) {
            this.s = getIntent().getStringExtra("trip_address_tag");
            String stringExtra = getIntent().getStringExtra("trip_distance_tag");
            this.t = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.t = "0km";
            }
        }
        this.q = getApplicationContext();
        E1();
        this.O.clear();
        this.P.clear();
        if (ew1.u != null) {
            for (int i = 0; i < ew1.u.size(); i++) {
                LoadCountBean.MarkerBean markerBean = ew1.u.get(i);
                String str = markerBean.uid + "";
                if (!str.equals(v4.e(this)) && ew1.h(str, markerBean.scheduleOrderId)) {
                    this.O.add(markerBean);
                }
            }
        }
        List<LoadCountBean.MarkerBean> listQ = ew1.q();
        if (listQ != null && listQ.size() > 0) {
            LogUtil.d(FrameworkBaseActivity.TAG, "saveTrip unLockTripBean onCreate spSaveUnlock.size " + listQ.size());
            this.P.addAll(listQ);
        }
        Collections.sort(this.O, new a());
        Collections.sort(this.P, new b());
        LogUtil.d("TripNearByTag", "FindMapTripNearbyPage onCreate curAddress " + this.s + " curDistance " + this.t + " unLockTripBean size " + this.O.size() + " normalTripBean size " + this.P.size());
        this.L = new MyFragmentPagerAdapter(getSupportFragmentManager());
        TripAllFragment tripAllFragment = new TripAllFragment();
        this.J = tripAllFragment;
        tripAllFragment.G(this.O, this, this.G);
        TripNormalFragment tripNormalFragment = new TripNormalFragment();
        this.K = tripNormalFragment;
        tripNormalFragment.F(this.P, this, this.G);
        this.L.f(this.J);
        this.L.f(this.K);
        this.N.setAdapter(this.L);
        this.N.addOnPageChangeListener(new c());
        H1(true);
        if (hx3.m(this.q)) {
            this.I.setVisibility(0);
            this.H.setVisibility(8);
        } else {
            this.I.setVisibility(8);
            this.H.setVisibility(0);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            List<LoadCountBean.MarkerBean> list = this.O;
            if (list != null) {
                list.clear();
            }
            List<LoadCountBean.MarkerBean> list2 = this.P;
            if (list2 != null) {
                list2.clear();
            }
            TripAllFragment tripAllFragment = this.J;
            if (tripAllFragment != null) {
                tripAllFragment.onDestroy();
            }
            TripNormalFragment tripNormalFragment = this.K;
            if (tripNormalFragment != null) {
                tripNormalFragment.onDestroy();
            }
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @qm5
    public void tripEvent(qw1 qw1Var) {
        if (qw1Var != null) {
            int i = qw1Var.f20336a;
            if (i == 1) {
                D1(qw1Var.e);
            } else if (i == 3) {
                C1(qw1Var.e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 0) {
                FindMapTripNearbyPage.this.H1(false);
            } else {
                FindMapTripNearbyPage.this.I1(false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
