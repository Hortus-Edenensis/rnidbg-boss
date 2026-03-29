package com.zenmen.palmchat.contacts.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.zenmen.palmchat.BaseFragment;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewFriendsAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<BaseFragment> f13590a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f13590a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.f13590a.get(i);
    }
}
