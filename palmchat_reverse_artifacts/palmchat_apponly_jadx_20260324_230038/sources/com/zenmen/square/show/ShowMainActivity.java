package com.zenmen.square.show;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.R$anim;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.lxpager.PagerFragment;
import com.zenmen.square.lxpager.SquareViewPager2;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.bj5;
import defpackage.da5;
import defpackage.fa3;
import defpackage.k66;
import defpackage.l66;
import defpackage.o22;
import defpackage.p66;
import defpackage.si5;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ShowMainActivity extends BaseDurationActivity implements fa3 {
    public static boolean B = false;
    public static boolean C = false;
    public int r;
    public int s;
    public boolean t = false;
    public k66 u = null;
    public l66 v = null;
    public o22 w = null;
    public SquareViewPager2 x = null;
    public da5 y = null;
    public si5 z = new si5();
    public ViewPager2.OnPageChangeCallback A = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            super.onPageScrollStateChanged(i);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            if (ShowMainActivity.this.y != null) {
                ShowMainActivity.this.y.H(i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerFragment currentFragment = ShowMainActivity.this.x.getCurrentFragment();
            if (currentFragment instanceof FeedShowDetailFragment) {
                ((FeedShowDetailFragment) currentFragment).b1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.b("show_feed_publish");
            bj5.b().a().c0(ShowMainActivity.this, 10, null, null, null, true);
        }
    }

    public static boolean E1(int i, Context context) {
        Intent intent = new Intent(context, (Class<?>) ShowMainActivity.class);
        intent.putExtra("key_from", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public View C1() {
        return findViewById(R$id.back_arrow);
    }

    public final void D1() {
        List<SquareFeed> list;
        this.x = (SquareViewPager2) findViewById(R$id.square_detail_pager);
        ShowListStateView showListStateView = (ShowListStateView) findViewById(R$id.list_state);
        showListStateView.setEventCallback(this);
        this.x.setBackView(findViewById(R$id.back_arrow));
        this.x.setNeedRefresh(true);
        ShowDetailAdapter showDetailAdapter = new ShowDetailAdapter(this);
        Bundle extras = getIntent().getExtras();
        extras.remove("key_feed_list");
        String strReplaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        extras.putString("key_sid", strReplaceAll);
        showDetailAdapter.k(extras);
        this.x.setAdapter(showDetailAdapter);
        ArrayList arrayList = new ArrayList();
        if (this.s >= arrayList.size()) {
            this.s = 0;
        }
        da5 da5Var = new da5(this.r, "square.tinder.recommend.scroll", extras);
        this.y = da5Var;
        this.x.setPagerListModel(da5Var);
        o22 o22Var = new o22(this.x, this.y);
        this.w = o22Var;
        o22Var.y(showListStateView);
        if (B && p66.e(this.r, arrayList) && !p66.f()) {
            k66 k66Var = new k66(this, this.w, this.s, arrayList.size(), strReplaceAll);
            this.u = k66Var;
            List<SquareFeed> listA = k66Var.a(arrayList);
            this.s = this.u.c();
            list = listA;
        } else {
            list = arrayList;
        }
        this.w.l(list, this.s);
        this.w.u();
        if (B && p66.e(this.r, list) && p66.f()) {
            this.v = new l66(this, this.w, list, strReplaceAll, this.s);
        }
        findViewById(R$id.iv_more).setOnClickListener(new b());
        findViewById(R$id.iv_publish).setOnClickListener(new c());
    }

    public void F1(ContactInfoItem contactInfoItem) {
        this.z.k(this, contactInfoItem, 301, 0, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.enter_from_left, R$anim.out_to_right);
    }

    public final void initActionBar() {
        setStatusBarColor(-16777216);
        a46.A(getWindow(), false);
        View viewFindViewById = findViewById(R$id.back_arrow);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.setMargins(0, a46.n(this), 0, 0);
        viewFindViewById.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity
    public int o() {
        return 100;
    }

    public void onArrowPress(View view) {
        onBackPressed();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_activity_show_main);
        this.r = getIntent().getIntExtra("key_from", 0);
        this.s = getIntent().getIntExtra("key_target_position", 0);
        initActionBar();
        D1();
        this.z.i(this, (ViewGroup) findViewById(R$id.large_gift_container), (ViewGroup) findViewById(R$id.small_gift_container));
        this.x.getViewPager2().registerOnPageChangeCallback(this.A);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k66 k66Var = this.u;
        if (k66Var != null) {
            k66Var.e();
        }
        l66 l66Var = this.v;
        if (l66Var != null) {
            l66Var.f();
        }
        this.z.j();
        this.x.getViewPager2().unregisterOnPageChangeCallback(this.A);
    }

    @Override // defpackage.fa3
    public void onEvent(int i, Object obj) {
        if (i == 2) {
            this.w.u();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
