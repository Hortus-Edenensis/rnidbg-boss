package com.zenmen.palmchat.conversations.threadsnew;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.ui.CircleFindActivity;
import com.zenmen.palmchat.conversations.threadsnew.ThreadsNewFragment;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ch;
import defpackage.k86;
import defpackage.me1;
import defpackage.nx3;
import defpackage.oc0;
import defpackage.tn0;
import defpackage.uw5;
import defpackage.yb0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f13816a;
    public TabLayout b;
    public ThreadsNewFragment c;
    public View d;
    public TextView e;
    public ImageView f;
    public boolean g = false;
    public View h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadsNewFragment f13817a;

        public a(ThreadsNewFragment threadsNewFragment) {
            this.f13817a = threadsNewFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((MainTabsActivity) this.f13817a.getActivity()).d3();
        }
    }

    public b(ThreadsNewFragment threadsNewFragment, View view) {
        this.c = threadsNewFragment;
        this.f13816a = view.findViewById(R.id.id_nr_stickylayout_sticky_view);
        this.h = view.findViewById(R.id.new_tab_container);
        this.f13816a.setVisibility(8);
        this.h.setVisibility(0);
        ((LinearLayout.LayoutParams) this.h.getLayoutParams()).setMargins(0, me1.i(threadsNewFragment.getContext()), 0, 0);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout2);
        this.b = tabLayout;
        tabLayout.setSelectedTabIndicatorHeight(0);
        this.e = (TextView) view.findViewById(R.id.new_group);
        this.f = (ImageView) view.findViewById(R.id.image_red_point);
        this.e.setText(uw5.b());
        if (uw5.c() == 1) {
            HashMap map = new HashMap();
            map.put("report_type", "view");
            oc0.h("pagelx_poshome_tongogroup", map);
            if (!SPUtil.f14322a.a(SPUtil.SCENE.MAINTAB_CONFIG, "key_circle_find_click", false)) {
                this.f.setVisibility(0);
            }
        }
        this.e.setOnClickListener(this);
        this.d = view.findViewById(R.id.head_group);
        d();
        this.d.setOnClickListener(this);
        view.findViewById(R.id.head_more).setOnClickListener(new a(threadsNewFragment));
    }

    public void b(List<ThreadsNewFragment.ThreadPagerAdapter.a> list) {
        for (ThreadsNewFragment.ThreadPagerAdapter.a aVar : list) {
            TabLayout.Tab tabNewTab = this.b.newTab();
            tabNewTab.setCustomView(R.layout.view_thread_new_tab_custom_view2);
            TextView textView = (TextView) tabNewTab.getCustomView().findViewById(R.id.tv_tab_title);
            tabNewTab.setTag(aVar.f13786a);
            textView.setText(aVar.c);
            this.b.addTab(tabNewTab);
        }
        c(0);
        this.b.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C1039b());
    }

    public void c(int i) {
        this.b.getTabAt(i);
        this.b.getTabCount();
        for (int i2 = 0; i2 < this.b.getTabCount(); i2++) {
            View customView = this.b.getTabAt(i2).getCustomView();
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
        TabLayout tabLayout = this.b;
        tabLayout.selectTab(tabLayout.getTabAt(i));
    }

    public void d() {
        View view = this.d;
        if (view != null) {
            view.setVisibility(yb0.a().b() ? 0 : 8);
        }
    }

    public void e(int i, boolean z) {
        TabLayout.Tab tabAt = this.b.getTabAt(1);
        View viewFindViewById = tabAt.getCustomView().findViewById(R.id.red_dot);
        TextView textView = (TextView) tabAt.getCustomView().findViewById(R.id.red_text);
        if (i != 0 || z) {
            viewFindViewById.setVisibility(8);
            textView.setVisibility(8);
            if (tn0.i().b() > 0) {
                tn0.i().z(0);
                ch.s().K(tn0.i().s(), null);
                return;
            }
            return;
        }
        int iS = tn0.i().s();
        if (this.g) {
            iS = 10;
        }
        if (iS > 0) {
            viewFindViewById.setVisibility(8);
            textView.setVisibility(0);
            textView.setText(k86.l(iS));
        } else {
            textView.setVisibility(8);
            if (nx3.a("key_new_friend_tab")) {
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
        }
    }

    public void f(int i) {
        TextView textView = (TextView) this.b.getTabAt(0).getCustomView().findViewById(R.id.red_text);
        if (i <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(k86.l(i));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iC = uw5.c();
        if (iC == 0) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class);
            intent.putExtra("from_type", 1);
            this.c.startActivity(intent);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "15q2", "1", null, null);
            HashMap map = new HashMap(1);
            map.put("fromtype", 1);
            oc0.h("lx_group_create3_click", map);
            return;
        }
        if (iC == 1) {
            Intent intent2 = new Intent();
            intent2.setClass(this.c.getActivity(), CircleFindActivity.class);
            intent2.putExtra("fromtype", 102);
            this.c.startActivity(intent2);
            HashMap map2 = new HashMap(1);
            map2.put("fromtype", 2);
            oc0.h("lx_group_create3_click", map2);
            HashMap map3 = new HashMap();
            map3.put("report_type", "click");
            oc0.h("pagelx_poshome_tongogroup", map3);
            if (this.f.getVisibility() == 0) {
                this.f.setVisibility(8);
                SPUtil.f14322a.t(SPUtil.SCENE.MAINTAB_CONFIG, "key_circle_find_click", Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1039b implements TabLayout.OnTabSelectedListener {
        public C1039b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (!"tab_msg".equals(tab.getTag())) {
                b.this.c.Q0(1);
            } else {
                b.this.c.Q0(0);
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "15q", "1", null, null);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }
}
