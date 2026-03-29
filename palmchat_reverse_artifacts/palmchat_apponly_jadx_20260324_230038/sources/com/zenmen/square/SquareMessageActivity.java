package com.zenmen.square;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.fragment.FriendMessageFragment;
import com.zenmen.square.fragment.SquareInteractFragment;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.ui.widget.MessageTabHeaderView;
import defpackage.ap3;
import defpackage.gi5;
import defpackage.n5;
import defpackage.r75;
import defpackage.v4;
import defpackage.xl1;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareMessageActivity extends FrameworkBaseActivity implements MessageTabHeaderView.b {
    public List<BaseListFragment> q = new ArrayList();
    public Tab[] r;
    public Tab s;
    public boolean t;
    public MessageTabHeaderView u;
    public ViewPager v;
    public Adapter w;
    public String x;

    /* JADX INFO: compiled from: SearchBox */
    public class Adapter extends FragmentPagerAdapter {
        public Adapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return SquareMessageActivity.this.q.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) SquareMessageActivity.this.q.get(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum Tab {
        SQUARE("动态消息"),
        FRIEND("好友消息");

        private String confTitle;
        private String title;

        Tab(String str) {
            this.title = str;
        }

        public String getTitle() {
            return TextUtils.isEmpty(this.confTitle) ? this.title : this.confTitle;
        }

        public void setConfTitle(String str) {
            this.confTitle = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16095a;

        public b(View view) {
            this.f16095a = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.a().x().b();
            this.f16095a.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16096a;

        static {
            int[] iArr = new int[Tab.values().length];
            f16096a = iArr;
            try {
                iArr[Tab.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16096a[Tab.FRIEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SquareMessageActivity() {
        Tab tab = Tab.SQUARE;
        this.r = new Tab[]{tab, Tab.FRIEND};
        this.s = tab;
    }

    public final void F1() {
        View viewFindViewById = findViewById(R$id.risk_notify_layout);
        String strE = ap3.a().x().e();
        if (TextUtils.isEmpty(strE)) {
            viewFindViewById.setVisibility(8);
            return;
        }
        zn6.b("risktip_feedactive");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R$id.risk_notify_tv)).setText(strE);
        findViewById(R$id.risk_notify_close).setOnClickListener(new b(viewFindViewById));
    }

    @Override // com.zenmen.square.ui.widget.MessageTabHeaderView.b
    public void T0(Tab tab) {
        int i = 0;
        while (true) {
            Tab[] tabArr = this.r;
            if (i >= tabArr.length) {
                i = -1;
                break;
            } else if (tabArr[i] == tab) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.v.setCurrentItem(i);
            this.s = tab;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (!r75.k() && this.t && !TextUtils.isEmpty(v4.e(com.zenmen.palmchat.c.b()))) {
            startActivity(n5.b(this, null));
        }
        super.finish();
    }

    public final void initActionBar() {
        initToolbar(R$id.toolbar, "消息通知", true);
        getToolbar().setBackgroundResource(R$color.white);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_square_activity_praises);
        xl1.e(getBaseContext());
        this.t = getIntent().getBooleanExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, false);
        this.x = UUID.randomUUID().toString().replace("-", "");
        Tab tab = Tab.SQUARE;
        tab.setConfTitle(gi5.p("nofriendsTitle"));
        Tab tab2 = Tab.FRIEND;
        tab2.setConfTitle(gi5.p("friendsTitle"));
        this.s = tab;
        if (SquareSingleton.getInstance().getLastPraiseUnReadCount() + SquareSingleton.getInstance().getLastCommentUnReadCount() <= 0 && SquareSingleton.getInstance().getFriendMsgUnReadCount() > 0) {
            this.s = tab2;
        }
        String stringExtra = getIntent().getStringExtra("key_page");
        if (stringExtra != null) {
            this.s = tab;
            if ("a0403".equals(stringExtra)) {
                this.s = tab2;
            }
        }
        initActionBar();
        this.u = (MessageTabHeaderView) findViewById(R$id.square_main_head_view);
        ViewPager viewPager = (ViewPager) findViewById(R$id.square_fragment_viewpager);
        this.v = viewPager;
        viewPager.setOffscreenPageLimit(1);
        this.r = new Tab[]{tab};
        this.u.setVisibility(8);
        for (Tab tab3 : this.r) {
            int i = c.f16096a[tab3.ordinal()];
            if (i == 1) {
                SquareInteractFragment squareInteractFragment = new SquareInteractFragment();
                squareInteractFragment.u(this.x);
                squareInteractFragment.i(true);
                this.q.add(squareInteractFragment);
            } else if (i == 2) {
                FriendMessageFragment friendMessageFragment = new FriendMessageFragment();
                friendMessageFragment.u(this.x);
                friendMessageFragment.i(true);
                this.q.add(friendMessageFragment);
            }
        }
        this.u.setHeaderViewEventListener(this);
        this.u.bindTabItems(this.r, this.s);
        this.w = new Adapter(getSupportFragmentManager());
        this.v.addOnPageChangeListener(new a());
        this.v.setAdapter(this.w);
        this.u.onSelect(this.s);
        F1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SquareMessageActivity squareMessageActivity = SquareMessageActivity.this;
            squareMessageActivity.s = squareMessageActivity.r[i];
            SquareMessageActivity.this.u.onSelect(SquareMessageActivity.this.s);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
