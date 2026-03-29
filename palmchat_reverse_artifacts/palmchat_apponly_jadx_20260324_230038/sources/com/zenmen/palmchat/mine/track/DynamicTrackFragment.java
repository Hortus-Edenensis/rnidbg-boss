package com.zenmen.palmchat.mine.track;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.databinding.FragmentDynamicTrackBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DynamicTrackFragment extends BaseFragment {
    public FragmentDynamicTrackBinding i;
    public MPagerAdapter k;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;
    public int j = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class MPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<Integer, Fragment> f14710a;
        public Context b;
        public List<a> c;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f14711a;
            public String b;
            public String c;

            public a(String str, String str2, String str3) {
                this.f14711a = str;
                this.b = str2;
                this.c = str3;
            }
        }

        @SuppressLint({"WrongConstant"})
        public MPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager, BaseFragment.D());
            this.f14710a = new HashMap<>();
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
            bundle.putInt("ARG_PARAM_INDEX", i);
            fragmentInstantiate.setArguments(bundle);
            this.f14710a.put(Integer.valueOf(i), fragmentInstantiate);
            return fragmentInstantiate;
        }
    }

    public final void R() {
        this.i.b.setSelectedTabIndicatorHeight(0);
        ArrayList<MPagerAdapter.a> arrayList = new ArrayList();
        arrayList.add(new MPagerAdapter.a("TAB_DYNAMIC_TRACK_MY_LOOK", TrackDynamicFragment.class.getName(), "我看过的"));
        arrayList.add(new MPagerAdapter.a("TAB_DYNAMIC_TRACK_MY_COMMENT", TrackDynamicFragment.class.getName(), "我评论过"));
        arrayList.add(new MPagerAdapter.a("TAB_DYNAMIC_TRACK_MY_APPROVE", TrackDynamicFragment.class.getName(), "我赞过"));
        for (MPagerAdapter.a aVar : arrayList) {
            TabLayout.Tab tabNewTab = this.i.b.newTab();
            tabNewTab.setCustomView(R.layout.view_track_tab_custom_view3);
            TextView textView = (TextView) tabNewTab.getCustomView().findViewById(R.id.tv_tab_title);
            tabNewTab.setTag(aVar.f14711a);
            textView.setText(aVar.c);
            this.i.b.addTab(tabNewTab);
        }
        this.i.b.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
        T(this.j);
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager(), getContext());
        this.k = mPagerAdapter;
        mPagerAdapter.f(arrayList);
        this.i.f13895a.addOnPageChangeListener(new b());
        this.i.f13895a.setAdapter(this.k);
        this.i.f13895a.setOffscreenPageLimit(2);
        this.i.f13895a.setCurrentItem(this.j);
    }

    public void T(int i) {
        for (int i2 = 0; i2 < this.i.b.getTabCount(); i2++) {
            View customView = this.i.b.getTabAt(i2).getCustomView();
            View viewFindViewById = customView.findViewById(R.id.tab_item_bottom);
            TextView textView = (TextView) customView.findViewById(R.id.tv_tab_title);
            if (i2 == i) {
                viewFindViewById.setVisibility(0);
                textView.setTextColor(Color.parseColor("#222222"));
            } else {
                viewFindViewById.setVisibility(8);
                textView.setTextColor(Color.parseColor("#666666"));
            }
        }
        TabLayout tabLayout = this.i.b;
        tabLayout.selectTab(tabLayout.getTabAt(i));
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.j = getArguments().getInt("EXTRA_TAB_SUBINDEX", 0);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentDynamicTrackBinding fragmentDynamicTrackBindingB = FragmentDynamicTrackBinding.b(layoutInflater, viewGroup, false);
        this.i = fragmentDynamicTrackBindingB;
        return fragmentDynamicTrackBindingB.getRoot();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        R();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if ("TAB_DYNAMIC_TRACK_MY_LOOK".equals(tab.getTag())) {
                DynamicTrackFragment.this.T(0);
                DynamicTrackFragment.this.i.f13895a.setCurrentItem(0, true);
            } else if ("TAB_DYNAMIC_TRACK_MY_COMMENT".equals(tab.getTag())) {
                DynamicTrackFragment.this.T(1);
                DynamicTrackFragment.this.i.f13895a.setCurrentItem(1, true);
            } else if ("TAB_DYNAMIC_TRACK_MY_APPROVE".equals(tab.getTag())) {
                DynamicTrackFragment.this.T(2);
                DynamicTrackFragment.this.i.f13895a.setCurrentItem(2, true);
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
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            DynamicTrackFragment.this.T(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
    }
}
