package com.zenmen.palmchat.circle.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.ui.CircleGroupFragment;
import com.zenmen.palmchat.circle.ui.view.CircleTabLayout;
import defpackage.hc0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleMineGroupFragment extends CircleLoadFragment {
    public String[] m = {"我创建的", "我管理的", "我加入的"};
    public List<CircleGroupFragment> n = new ArrayList();
    public int o;
    public CircleTabLayout p;
    public ViewPager q;
    public View r;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CircleMineGroupFragment.this.m.length;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) CircleMineGroupFragment.this.n.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return CircleMineGroupFragment.this.m[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(int i) {
        this.n.get(i).R();
    }

    public static CircleMineGroupFragment m0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        CircleMineGroupFragment circleMineGroupFragment = new CircleMineGroupFragment();
        circleMineGroupFragment.setArguments(bundle);
        return circleMineGroupFragment;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public View W(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_circle_mine, viewGroup, false);
        this.r = viewInflate;
        this.p = (CircleTabLayout) viewInflate.findViewById(R.id.tabLayout);
        this.q = (ViewPager) this.r.findViewById(R.id.view_pager);
        return this.r;
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment
    public void Y() {
        Z(false);
        if (this.n.isEmpty()) {
            k0();
            return;
        }
        int currentIndex = this.p.getCurrentIndex();
        if (currentIndex < this.n.size()) {
            this.n.get(currentIndex).R();
        }
    }

    public final void k0() {
        this.n.add(CircleGroupFragment.l0(1));
        this.n.add(CircleGroupFragment.l0(2));
        this.n.add(CircleGroupFragment.l0(3));
        this.q.setAdapter(new a(getChildFragmentManager()));
        this.q.setOffscreenPageLimit(this.n.size() - 1);
        this.p.setupWithViewPage(this.q);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.length; i++) {
            hc0 hc0Var = new hc0();
            hc0Var.f17922a = this.m[i];
            if (i == 0) {
                hc0Var.b = MapController.DEFAULT_LAYER_TAG;
            }
            arrayList.add(hc0Var);
        }
        this.p.bindMatchTableItems(arrayList, MapController.DEFAULT_LAYER_TAG);
        this.p.setTabListener(new CircleTabLayout.b() { // from class: ra0
            @Override // com.zenmen.palmchat.circle.ui.view.CircleTabLayout.b
            public final void a(int i2) {
                this.f20424a.l0(i2);
            }
        });
        this.n.get(0).R();
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.o = getArguments().getInt("type", -1);
    }

    @Override // com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
