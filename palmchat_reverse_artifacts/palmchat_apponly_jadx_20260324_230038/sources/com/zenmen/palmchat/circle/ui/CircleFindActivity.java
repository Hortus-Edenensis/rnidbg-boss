package com.zenmen.palmchat.circle.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.appbar.AppBarLayout;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.circle.banner.Banner;
import com.zenmen.palmchat.circle.banner.BannerImageLoader;
import com.zenmen.palmchat.circle.bean.CircleLoopBean;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.ui.adapter.CircleFindPageAdapter;
import com.zenmen.palmchat.circle.ui.view.CircleTabLayout;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bu3;
import defpackage.c70;
import defpackage.g16;
import defpackage.hc0;
import defpackage.mb4;
import defpackage.n64;
import defpackage.oc0;
import defpackage.sy5;
import defpackage.ve;
import defpackage.wi0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleFindActivity extends BaseActionBarActivity {
    public int q;
    public ViewPager r;
    public CircleTabLayout s;
    public CircleFindPageAdapter t;
    public Banner u;
    public TextView v;
    public String w;
    public CircleLoopBean x;
    public AppBarLayout y;
    public List<Integer> z = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<CircleLoopBean>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleLoopBean> baseResponse) {
            CircleFindActivity.this.hideBaseProgressBar();
            if (baseResponse != null && baseResponse.getResultCode() == 0) {
                CircleFindActivity.this.O1(baseResponse.getData());
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleFindActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleFindActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements n64 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleLoopBean f13157a;

        public c(CircleLoopBean circleLoopBean) {
            this.f13157a = circleLoopBean;
        }

        @Override // defpackage.n64
        public void a(int i) {
            CircleFindActivity.this.H1(this.f13157a.actBitList.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1(int i) {
        LogUtil.d("tab_position", "position:" + i);
        this.t.i(i);
        Q1(i);
        T1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L1(View view) {
        S1(this.s.getCurrentIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M1(View view) {
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) CircleLaunchCreateCircleActivity.class);
        intent.putExtra("extra_from", 2);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(View view) {
        finish();
    }

    public static void R1(Context context, int i) {
        Intent intent = new Intent();
        intent.setClass(context, CircleFindActivity.class);
        intent.putExtra("fromtype", i);
        context.startActivity(intent);
    }

    public final void H1(CircleLoopBean.LoopData loopData) {
        Pair<Integer, ContentValues> pairG;
        Object obj;
        if (loopData == null || TextUtils.isEmpty(loopData.link)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("report_type", "click");
        map.put("activityid", Long.valueOf(loopData.id));
        oc0.h("pagegroup_posactivity", map);
        int i = loopData.jumpMode;
        if (i == 1) {
            Intent intent = new Intent();
            intent.setClass(this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", loopData.link);
            bundle.putInt("BackgroundColor", -1);
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        if (i == 2) {
            startActivity(bu3.g().e(this, loopData.link));
        } else {
            if (i != 3 || (pairG = mb4.g(loopData.link)) == null || (obj = pairG.second) == null) {
                return;
            }
            ve.k(this, null, (ContentValues) obj, null, null);
        }
    }

    public final void I1() {
        showBaseProgressBar();
        c70.R().U(new a());
    }

    public final void J1() {
        this.r = (ViewPager) findViewById(R.id.viewpager);
        this.s = (CircleTabLayout) findViewById(R.id.tabLayout);
        this.u = (Banner) findViewById(R.id.banner);
        this.v = (TextView) findViewById(R.id.text_search_hint);
        this.y = (AppBarLayout) findViewById(R.id.appbar_layout);
        this.r.setOffscreenPageLimit(2);
        CircleFindPageAdapter circleFindPageAdapter = new CircleFindPageAdapter(getSupportFragmentManager(), this.q);
        this.t = circleFindPageAdapter;
        this.r.setAdapter(circleFindPageAdapter);
        List<String> listF = this.t.f();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listF.size(); i++) {
            hc0 hc0Var = new hc0();
            hc0Var.f17922a = listF.get(i);
            if (i == 0) {
                hc0Var.b = MapController.DEFAULT_LAYER_TAG;
            }
            arrayList.add(hc0Var);
        }
        this.s.bindTableItems(arrayList, MapController.DEFAULT_LAYER_TAG);
        this.s.setupWithViewPage(this.r);
        this.s.setTabListener(new CircleTabLayout.b() { // from class: y80
            @Override // com.zenmen.palmchat.circle.ui.view.CircleTabLayout.b
            public final void a(int i2) {
                this.f22158a.K1(i2);
            }
        });
        this.t.i(0);
        T1(0);
        findViewById(R.id.lin_search).setOnClickListener(new View.OnClickListener() { // from class: z80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22377a.L1(view);
            }
        });
        findViewById(R.id.image_add).setOnClickListener(new View.OnClickListener() { // from class: a90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1176a.M1(view);
            }
        });
        findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() { // from class: b90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1669a.N1(view);
            }
        });
    }

    public final void O1(CircleLoopBean circleLoopBean) {
        if (!TextUtils.isEmpty(circleLoopBean.hotSearchWord)) {
            this.w = circleLoopBean.hotSearchWord;
            this.v.setText("大家都在搜：" + this.w);
        }
        List<CircleLoopBean.LoopData> list = circleLoopBean.actBitList;
        if (list == null || list.isEmpty()) {
            this.u.setVisibility(8);
            return;
        }
        this.x = circleLoopBean;
        this.u.setBannerStyle(1);
        this.u.setImageLoader(new BannerImageLoader());
        this.u.setImages(circleLoopBean.actBitList);
        this.u.setBannerAnimation(g16.b);
        this.u.isAutoPlay(true);
        this.u.setDelayTime(5000);
        this.u.setIndicatorGravity(6);
        this.u.setOnPageChangeListener(new b(circleLoopBean));
        this.u.setOnBannerListener(new c(circleLoopBean));
        this.u.start();
    }

    public final void P1(int i, CircleLoopBean.LoopData loopData) {
        if (loopData == null || this.z.contains(Integer.valueOf(i))) {
            return;
        }
        this.z.add(Integer.valueOf(i));
        HashMap map = new HashMap();
        map.put("report_type", "view");
        map.put("activityid", Long.valueOf(loopData.id));
        oc0.h("pagegroup_posactivity", map);
    }

    public final void Q1(int i) {
        if (i == 2) {
            Banner banner = this.u;
            if (banner != null) {
                banner.setVisibility(8);
            }
            TextView textView = this.v;
            if (textView != null) {
                textView.setText("搜索");
                return;
            }
            return;
        }
        Banner banner2 = this.u;
        if (banner2 != null) {
            if (this.x == null) {
                banner2.setVisibility(8);
            } else {
                banner2.setVisibility(0);
            }
        }
        if (this.v == null || TextUtils.isEmpty(this.w)) {
            return;
        }
        this.v.setText("大家都在搜：" + this.w);
    }

    public final void S1(int i) {
        Intent intent = new Intent(this, (Class<?>) CircleSearchActivity.class);
        if (i != 2) {
            i = 0;
        }
        intent.putExtra("intent_from", i);
        intent.putExtra("intent_hot_word", this.w);
        startActivity(intent);
    }

    public final void T1(int i) {
        HashMap map = new HashMap();
        map.put("report_type", "click");
        map.put(az.at, Integer.valueOf(i + 1));
        oc0.h("pagegroup_postab", map);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_find_circle);
        this.q = getIntent().getIntExtra("fromtype", 0);
        J1();
        I1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Banner banner = this.u;
        if (banner != null) {
            banner.releaseBanner();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        this.t.g(permissionType, permissionUsage);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        this.t.h(permissionType, permissionUsage, z);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        HashMap map = new HashMap(1);
        map.put("fromtype", Integer.valueOf(this.q));
        oc0.h("lx_richgroup_show", map);
        Banner banner = this.u;
        if (banner != null) {
            banner.startAutoPlay();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Banner banner = this.u;
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleLoopBean f13156a;

        public b(CircleLoopBean circleLoopBean) {
            this.f13156a = circleLoopBean;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            LogUtil.d(MediationConstant.RIT_TYPE_BANNER, "position:" + i);
            if (this.f13156a.actBitList.size() > i) {
                CircleFindActivity.this.P1(i, this.f13156a.actBitList.get(i));
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
