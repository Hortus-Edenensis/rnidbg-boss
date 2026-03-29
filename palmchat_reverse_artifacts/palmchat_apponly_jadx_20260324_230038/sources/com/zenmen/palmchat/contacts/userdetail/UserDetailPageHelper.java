package com.zenmen.palmchat.contacts.userdetail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserDetailTabHeaderView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment;
import com.zenmen.square.moments.PersonalMomentsFragment;
import com.zenmen.square.ui.widget.NestDynamicLifeTabHeaderView;
import defpackage.ds0;
import defpackage.hj5;
import defpackage.ip2;
import defpackage.m66;
import defpackage.qm5;
import defpackage.v4;
import defpackage.zi1;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@SuppressLint({"LongLogTag"})
public class UserDetailPageHelper extends ViewPager {
    public static final String TAG = "UserDetailPageHelper";
    private NestFragmentAdapter mAdapter;
    private ContactInfoItem mContactInfoItem;
    private boolean mDynamicLifeLoaded;
    private List<Fragment> mFragmentList;
    private List<NestDynamicLifeTabHeaderView.b> mItems;
    private boolean mMomentLoaded;
    private boolean mShowTimeLine;
    private UserDetailTabHeaderView mTab;
    private int tabPosition;

    /* JADX INFO: compiled from: SearchBox */
    public class NestFragmentAdapter extends FragmentPagerAdapter {
        public NestFragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return UserDetailPageHelper.this.mFragmentList.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            Fragment fragment = (Fragment) UserDetailPageHelper.this.mFragmentList.get(i);
            if (fragment instanceof BaseDurationFragment) {
                ((BaseDurationFragment) fragment).i(true);
            }
            return (Fragment) UserDetailPageHelper.this.mFragmentList.get(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements UserDetailTabHeaderView.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.contacts.userdetail.UserDetailTabHeaderView.a
        public void onItemSelected(int i) {
            UserDetailPageHelper.this.setCurrentItem(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13678a;
        public final /* synthetic */ int b;

        public c(String str, int i) {
            this.f13678a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailPageHelper.this.onLoadSuccess(this.f13678a, this.b);
        }
    }

    public UserDetailPageHelper(Context context) {
        super(context);
        this.tabPosition = 0;
        this.mFragmentList = new ArrayList();
        this.mItems = new ArrayList();
        init(null, 0);
    }

    private HashMap<String, Object> getReportParams(int i) {
        HashMap<String, Object> reportParams = getReportParams();
        reportParams.put("nums", Integer.valueOf(i));
        return reportParams;
    }

    private void init(AttributeSet attributeSet, int i) {
        setOffscreenPageLimit(3);
        ds0.a().c(this);
    }

    private void initSelectTabBar() {
        if (this.mItems.size() == 0) {
            this.mItems = new ArrayList(hj5.a());
            NestDynamicLifeTabHeaderView.b bVar = new NestDynamicLifeTabHeaderView.b();
            bVar.b = "资料";
            bVar.c = UserProfileFragment.class.getName();
            bVar.f16541a = 1;
            this.mItems.add(0, bVar);
            for (NestDynamicLifeTabHeaderView.b bVar2 : this.mItems) {
                if (this.mShowTimeLine || !bVar2.c.equals(PersonalMomentsFragment.class.getName())) {
                    Fragment fragmentInstantiate = Fragment.instantiate(getContext(), bVar2.c);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("user_item_info", this.mContactInfoItem);
                    bundle.putBoolean("v2", true);
                    fragmentInstantiate.setArguments(bundle);
                    this.mFragmentList.add(fragmentInstantiate);
                }
            }
        }
        this.mTab.bindTableItems(this.mShowTimeLine, this.mItems);
        this.mTab.setHeaderViewEventListener(new a());
    }

    private void initSubFragment(Activity activity) {
        this.mAdapter = new NestFragmentAdapter(((FragmentActivity) activity).getSupportFragmentManager());
        addOnPageChangeListener(new b());
        setAdapter(this.mAdapter);
        this.mTab.onSelect(this.tabPosition);
        reportSelected(this.tabPosition);
    }

    private void reportLoaded(String str, int i) {
        if (!this.mDynamicLifeLoaded && PersonalDynamicLifeFragment.class.getName().equals(str)) {
            zn6.j("pageprofil_dynamiclife_load", null, getReportParams(i));
            this.mDynamicLifeLoaded = true;
        } else {
            if (this.mMomentLoaded || !PersonalMomentsFragment.class.getName().equals(str)) {
                return;
            }
            zn6.j("pageprofil_friendcircle_load", null, getReportParams(i));
            this.mMomentLoaded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSelected(int i) {
        try {
            NestDynamicLifeTabHeaderView.b bVar = this.mItems.get(i);
            if (PersonalDynamicLifeFragment.class.getName().equals(bVar.c)) {
                zn6.j("pageprofil_dynamiclife", "click", getReportParams());
            } else if (PersonalMomentsFragment.class.getName().equals(bVar.c)) {
                zn6.j("pageprofil_fricircle", "click", getReportParams());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bind(UserDetailTabHeaderView userDetailTabHeaderView) {
        Log.i(TAG, "bind: ");
        this.mTab = userDetailTabHeaderView;
    }

    public void load(Activity activity, ContactInfoItem contactInfoItem, boolean z, int i) {
        this.mContactInfoItem = contactInfoItem;
        this.mShowTimeLine = z;
        this.tabPosition = i;
        this.mTab.showTabLayout(true);
        initSelectTabBar();
        initSubFragment(activity);
    }

    public void onDestory() {
        ds0.a().d(this);
    }

    @qm5
    public void onDynamicCountEvent(zi1 zi1Var) {
        LogUtil.d(TAG, "onLoadSuccess:");
        post(new c(zi1Var.f22432a, zi1Var.b));
    }

    public void onLoadSuccess(String str, int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            NestDynamicLifeTabHeaderView.b bVar = this.mItems.get(i2);
            if (bVar.c.equals(str)) {
                this.mTab.updateTabTitle(i2, bVar, (i <= 0 || this.mContactInfoItem == null) ? this.mItems.get(i2).b : this.mItems.get(i2).b + i, bVar.c.equals(PersonalDynamicLifeFragment.class.getName()) && i > 0 && m66.e() && !TextUtils.equals(this.mContactInfoItem.getUid(), v4.e(getContext())));
                reportLoaded(str, i);
            }
        }
    }

    public void updateUIWithContactInfoItem(ContactInfoItem contactInfoItem, HashMap<String, Object> map) {
        for (ActivityResultCaller activityResultCaller : this.mFragmentList) {
            if (activityResultCaller instanceof ip2) {
                ((ip2) activityResultCaller).c(contactInfoItem, map);
            }
        }
    }

    private HashMap<String, Object> getReportParams() {
        HashMap<String, Object> map = new HashMap<>();
        ContactInfoItem contactInfoItem = this.mContactInfoItem;
        if (contactInfoItem != null && !TextUtils.isEmpty(contactInfoItem.getUid())) {
            map.put("targetUid", this.mContactInfoItem.getUid());
        }
        ContactInfoItem contactInfoItem2 = this.mContactInfoItem;
        if (contactInfoItem2 != null && !TextUtils.isEmpty(contactInfoItem2.getExid())) {
            map.put("targetExid", this.mContactInfoItem.getExid());
        }
        return map;
    }

    public UserDetailPageHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tabPosition = 0;
        this.mFragmentList = new ArrayList();
        this.mItems = new ArrayList();
        init(attributeSet, 0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            UserDetailPageHelper.this.mTab.onSelect(i);
            UserDetailPageHelper.this.reportSelected(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
