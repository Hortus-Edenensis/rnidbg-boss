package com.zenmen.palmchat.paidservices.superexpose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.ActivitySuperExposeHomeBinding;
import defpackage.b05;
import defpackage.ds0;
import defpackage.kj1;
import defpackage.me1;
import defpackage.qm5;
import defpackage.xn5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeHomeActivity extends BaseActionBarActivity {
    public ActivitySuperExposeHomeBinding q;
    public int r;
    public MPagerAdapter s;

    /* JADX INFO: compiled from: SearchBox */
    public enum FROM {
        DEEPLINK(50101),
        POLISH_ADD(50102),
        POLISH_SUCCESS(50103);

        public int value;

        FROM(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<Integer, Fragment> f14778a;
        public Context b;
        public List<a> c;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f14779a;
            public String b;
            public String c;

            public a(String str, String str2, String str3) {
                this.f14779a = str;
                this.b = str2;
                this.c = str3;
            }
        }

        @SuppressLint({"WrongConstant"})
        public MPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager, BaseFragment.D());
            this.f14778a = new HashMap<>();
            this.c = new ArrayList();
            this.b = context;
        }

        public void f(List<a> list) {
            this.c = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.c.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            Fragment fragmentInstantiate = Fragment.instantiate(this.b, this.c.get(i).b);
            this.f14778a.put(Integer.valueOf(i), fragmentInstantiate);
            return fragmentInstantiate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SuperExposeHomeActivity.this.sInstance.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ViewPager.PageTransformer {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(@NonNull View view, float f) {
            if (f <= 0.0f || !kj1.b().c().booleanValue()) {
                return;
            }
            SuperExposeHomeActivity.this.q.g.setAlpha(f);
        }
    }

    public static void B1(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) SuperExposeHomeActivity.class);
        intent.putExtra("EXTRA_FROM", i);
        context.startActivity(intent);
    }

    public static void C1(Context context, FROM from) {
        B1(context, from.value);
    }

    public int A1() {
        return this.r;
    }

    public final void D1() {
        this.q.f13891a.setOnClickListener(new a());
        this.q.e.setSelectedTabIndicatorHeight(0);
        ArrayList<MPagerAdapter.a> arrayList = new ArrayList();
        arrayList.add(new MPagerAdapter.a("TAB_MYSELF", SuperExposeMyselfFragment.class.getName(), "曝光我自己"));
        if (kj1.b().c().booleanValue()) {
            this.q.e.setVisibility(0);
            this.q.d.setVisibility(8);
            arrayList.add(new MPagerAdapter.a("TAB_MY_DYNAMIC", SuperExposeMyDynamicFragment.class.getName(), "曝光我的动态"));
            for (MPagerAdapter.a aVar : arrayList) {
                TabLayout.Tab tabNewTab = this.q.e.newTab();
                tabNewTab.setCustomView(R.layout.view_thread_new_tab_custom_view3);
                TextView textView = (TextView) tabNewTab.getCustomView().findViewById(R.id.tv_tab_title);
                tabNewTab.setTag(aVar.f14779a);
                textView.setText(aVar.c);
                this.q.e.addTab(tabNewTab);
            }
            this.q.e.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
            F1(0);
        } else {
            this.q.e.setVisibility(8);
            this.q.d.setVisibility(0);
        }
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getSupportFragmentManager(), this);
        this.s = mPagerAdapter;
        mPagerAdapter.f(arrayList);
        this.q.b.setPageTransformer(true, new c());
        this.q.b.addOnPageChangeListener(new d());
        this.q.b.setAdapter(this.s);
    }

    public final void E1() {
        this.r = getIntent().getIntExtra("EXTRA_FROM", 0);
    }

    public void F1(int i) {
        for (int i2 = 0; i2 < this.q.e.getTabCount(); i2++) {
            View customView = this.q.e.getTabAt(i2).getCustomView();
            View viewFindViewById = customView.findViewById(R.id.tab_item_bottom);
            TextView textView = (TextView) customView.findViewById(R.id.tv_tab_title);
            if (i2 == i) {
                viewFindViewById.setVisibility(0);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(Color.parseColor("#222222"));
            } else {
                viewFindViewById.setVisibility(8);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextColor(Color.parseColor("#999999"));
            }
        }
        TabLayout tabLayout = this.q.e;
        tabLayout.selectTab(tabLayout.getTabAt(i));
    }

    public void G1(ViewGroup viewGroup) {
        viewGroup.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = me1.h(this);
        viewGroup.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        E1();
        ActivitySuperExposeHomeBinding activitySuperExposeHomeBindingB = ActivitySuperExposeHomeBinding.b(getLayoutInflater());
        this.q = activitySuperExposeHomeBindingB;
        setContentView(activitySuperExposeHomeBindingB.getRoot());
        G1(this.q.i);
        D1();
        ds0.a().c(this);
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
        b05.a("收到onSuperExposeEvent通知");
        if ("tab_find_friend".equals(MainTabsActivity.y2())) {
            finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if ("TAB_MYSELF".equals(tab.getTag())) {
                SuperExposeHomeActivity.this.F1(0);
                SuperExposeHomeActivity.this.q.b.setCurrentItem(0, true);
            } else {
                SuperExposeHomeActivity.this.F1(1);
                SuperExposeHomeActivity.this.q.b.setCurrentItem(1, true);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ViewPager.OnPageChangeListener {
        public d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (kj1.b().c().booleanValue()) {
                SuperExposeHomeActivity.this.F1(i);
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
