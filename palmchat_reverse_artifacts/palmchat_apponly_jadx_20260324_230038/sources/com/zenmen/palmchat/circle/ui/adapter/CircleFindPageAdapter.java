package com.zenmen.palmchat.circle.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.zenmen.palmchat.circle.ui.fragment.CircleAllFragment;
import com.zenmen.palmchat.circle.ui.fragment.CircleLoadFragment;
import com.zenmen.palmchat.circle.ui.fragment.CircleMineGroupFragment;
import com.zenmen.palmchat.circle.ui.fragment.CircleNearFragment;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleFindPageAdapter extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f13258a;
    public List<CircleLoadFragment> b;

    public CircleFindPageAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.f13258a = new ArrayList();
        this.b = new ArrayList();
        this.f13258a.add("全部");
        this.f13258a.add("附近");
        this.f13258a.add("我的");
        this.b.add(CircleAllFragment.p0(i));
        this.b.add(CircleNearFragment.s0(i));
        this.b.add(CircleMineGroupFragment.m0(i));
    }

    public List<String> f() {
        return this.f13258a;
    }

    public void g(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        CircleNearFragment circleNearFragment = (CircleNearFragment) this.b.get(1);
        if (circleNearFragment != null) {
            circleNearFragment.t0(permissionType, permissionUsage);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f13258a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.f13258a.get(i);
    }

    public void h(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        CircleNearFragment circleNearFragment = (CircleNearFragment) this.b.get(1);
        if (circleNearFragment != null) {
            circleNearFragment.u0(permissionType, permissionUsage, z);
        }
    }

    public void i(int i) {
        this.b.get(i).R();
    }
}
