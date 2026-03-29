package com.zenmen.palmchat.mine.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.ActivityTrackHomeBinding;
import defpackage.me1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TrackHomeActivity extends BaseActionBarActivity {
    public ActivityTrackHomeBinding q;
    public int r = 0;
    public int s = 0;
    public MPagerAdapter t;

    /* JADX INFO: compiled from: SearchBox */
    public class MPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<Integer, Fragment> f14729a;
        public Context b;
        public List<a> c;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f14730a;
            public String b;
            public String c;

            public a(String str, String str2, String str3) {
                this.f14730a = str;
                this.b = str2;
                this.c = str3;
            }
        }

        @SuppressLint({"WrongConstant"})
        public MPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager, BaseFragment.D());
            this.f14729a = new HashMap<>();
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
            Bundle bundle = new Bundle();
            TrackHomeActivity trackHomeActivity = TrackHomeActivity.this;
            bundle.putInt("EXTRA_TAB_SUBINDEX", i == trackHomeActivity.r ? trackHomeActivity.s : 0);
            fragmentInstantiate.setArguments(bundle);
            this.f14729a.put(Integer.valueOf(i), fragmentInstantiate);
            return fragmentInstantiate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackHomeActivity.this.sInstance.onBackPressed();
        }
    }

    public static void A1(Context context, int i, int i2) {
        Intent intent = new Intent(context, (Class<?>) TrackHomeActivity.class);
        intent.putExtra("EXTRA_TAB_INDEX", i);
        intent.putExtra("EXTRA_TAB_SUBINDEX", i2);
        context.startActivity(intent);
    }

    public final void B1() {
        this.q.f13892a.setOnClickListener(new a());
        this.q.d.setSelectedTabIndicatorHeight(0);
        ArrayList<MPagerAdapter.a> arrayList = new ArrayList();
        arrayList.add(new MPagerAdapter.a("TAB_USERTRACK", UserTrackFragment.class.getName(), "用户足迹"));
        arrayList.add(new MPagerAdapter.a("TAB_MY_DYNAMIC", DynamicTrackFragment.class.getName(), "动态足迹"));
        for (MPagerAdapter.a aVar : arrayList) {
            TabLayout.Tab tabNewTab = this.q.d.newTab();
            tabNewTab.setCustomView(R.layout.view_track_home_tab_custom_view3);
            TextView textView = (TextView) tabNewTab.getCustomView().findViewById(R.id.tv_tab_title);
            tabNewTab.setTag(aVar.f14730a);
            textView.setText(aVar.c);
            this.q.d.addTab(tabNewTab);
        }
        this.q.d.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        C1(this.r);
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getSupportFragmentManager(), this);
        this.t = mPagerAdapter;
        mPagerAdapter.f(arrayList);
        this.q.b.addOnPageChangeListener(new c());
        this.q.b.setAdapter(this.t);
        this.q.b.setCurrentItem(this.r);
    }

    public void C1(int i) {
        for (int i2 = 0; i2 < this.q.d.getTabCount(); i2++) {
            View customView = this.q.d.getTabAt(i2).getCustomView();
            View viewFindViewById = customView.findViewById(R.id.tab_item_bottom);
            TextView textView = (TextView) customView.findViewById(R.id.tv_tab_title);
            if (i2 == i) {
                viewFindViewById.setVisibility(0);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                viewFindViewById.setVisibility(8);
                textView.setTypeface(Typeface.DEFAULT);
            }
        }
        TabLayout tabLayout = this.q.d;
        tabLayout.selectTab(tabLayout.getTabAt(i));
    }

    public void D1(ViewGroup viewGroup) {
        viewGroup.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = me1.h(this);
        viewGroup.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityTrackHomeBinding activityTrackHomeBindingB = ActivityTrackHomeBinding.b(getLayoutInflater());
        this.q = activityTrackHomeBindingB;
        setContentView(activityTrackHomeBindingB.getRoot());
        this.r = getIntent().getIntExtra("EXTRA_TAB_INDEX", 0);
        this.s = getIntent().getIntExtra("EXTRA_TAB_SUBINDEX", 0);
        D1(this.q.f);
        B1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if ("TAB_USERTRACK".equals(tab.getTag())) {
                TrackHomeActivity.this.C1(0);
                TrackHomeActivity.this.q.b.setCurrentItem(0, true);
            } else {
                TrackHomeActivity.this.C1(1);
                TrackHomeActivity.this.q.b.setCurrentItem(1, true);
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
    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TrackHomeActivity.this.C1(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
