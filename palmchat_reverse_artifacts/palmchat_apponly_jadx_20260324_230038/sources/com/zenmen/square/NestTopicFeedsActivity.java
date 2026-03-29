package com.zenmen.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.fragment.FeedsFragment;
import com.zenmen.square.fragment.NestTopicFeedsFragment;
import com.zenmen.square.fragment.NestTopicTimelineFragment;
import com.zenmen.square.mvp.model.bean.NestTopicResp;
import com.zenmen.square.ui.widget.NestTopicTabHeaderView;
import com.zenmen.square.ui.widget.SquareButton;
import defpackage.a46;
import defpackage.an1;
import defpackage.bj5;
import defpackage.f74;
import defpackage.l50;
import defpackage.pm5;
import defpackage.qj5;
import defpackage.ry5;
import defpackage.wj5;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicFeedsActivity extends FrameworkBaseActivity implements NestTopicTabHeaderView.a, f74 {
    public static final String[][] G = {new String[]{"推荐", NestTopicFeedsFragment.class.getName()}, new String[]{"最新", NestTopicTimelineFragment.class.getName()}};
    public String A;
    public List<FeedsFragment> B = new ArrayList();
    public List<NestTopicTabHeaderView.b> C = new ArrayList();
    public boolean E = false;
    public int F;
    public NestTopicTabHeaderView q;
    public NestTopicTabHeaderView r;
    public NestTopicFragmentAdapter s;
    public int t;
    public ViewPager u;
    public TextView v;
    public NestTopicResp w;
    public View x;
    public long y;
    public b z;

    /* JADX INFO: compiled from: SearchBox */
    public class NestTopicFragmentAdapter extends FragmentPagerAdapter {
        public NestTopicFragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return NestTopicFeedsActivity.this.B.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            Fragment fragment = (Fragment) NestTopicFeedsActivity.this.B.get(i);
            if (fragment instanceof FeedsFragment) {
                FeedsFragment feedsFragment = (FeedsFragment) fragment;
                if (TextUtils.isEmpty(feedsFragment.getSid())) {
                    feedsFragment.u(NestTopicFeedsActivity.this.A);
                }
                feedsFragment.i(true);
            }
            return (Fragment) NestTopicFeedsActivity.this.B.get(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class SquareBehavior extends AppBarLayout.ScrollingViewBehavior {
        private f74 mOnPreScrollListener;

        public SquareBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i, int i2, @NonNull int[] iArr, int i3) {
            f74 f74Var = this.mOnPreScrollListener;
            if (f74Var != null) {
                f74Var.O0(coordinatorLayout, view, view2, i, i2, iArr, i3);
            }
            super.onNestedPreScroll(coordinatorLayout, view, view2, i, i2, iArr, i3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, int i, int i2) {
            if (this.mOnPreScrollListener != null) {
                return true;
            }
            return super.onStartNestedScroll(coordinatorLayout, view, view2, view3, i, i2);
        }

        public void setOnPreScrollListener(f74 f74Var) {
            this.mOnPreScrollListener = f74Var;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f16091a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public LinearLayout f;
        public LinearLayout g;
        public SquareButton h;
        public SquareButton i;
        public NestTopicResp j;
        public long k;
        public int l;
        public long m = 0;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RelativeLayout.LayoutParams f16092a;

            public a(RelativeLayout.LayoutParams layoutParams) {
                this.f16092a = layoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b.this.h.getLayoutParams();
                if (b.this.i.getWidth() >= b.this.l || b.this.h.getWidth() >= b.this.l) {
                    layoutParams.width = b.this.l;
                    this.f16092a.width = b.this.l;
                    b.this.h.setLayoutParams(layoutParams);
                    b.this.i.setLayoutParams(this.f16092a);
                    return;
                }
                if (b.this.i.getWidth() > b.this.h.getWidth()) {
                    layoutParams.width = b.this.i.getWidth();
                    b.this.h.setLayoutParams(layoutParams);
                } else {
                    this.f16092a.width = b.this.h.getWidth();
                    b.this.i.setLayoutParams(this.f16092a);
                }
            }
        }

        public b(Activity activity, long j) {
            this.k = j;
            this.l = (a46.m(NestTopicFeedsActivity.this).x / 2) - a46.b(NestTopicFeedsActivity.this, 33.0f);
            this.e = (TextView) activity.findViewById(R$id.tv_topic_title);
            this.f16091a = (TextView) activity.findViewById(R$id.tv_topic_name);
            this.b = (TextView) activity.findViewById(R$id.tv_topic_time);
            this.c = (TextView) activity.findViewById(R$id.tv_topic_des);
            TextView textView = (TextView) activity.findViewById(R$id.tv_act_detail_click);
            this.d = textView;
            textView.setOnClickListener(this);
            this.g = (LinearLayout) activity.findViewById(R$id.ll_act_rule_click);
            this.f = (LinearLayout) activity.findViewById(R$id.rl_header_topic);
            SquareButton squareButton = (SquareButton) activity.findViewById(R$id.ll_nest_topic_bottom_btn);
            this.h = squareButton;
            squareButton.setOnClickListener(this);
            SquareButton squareButton2 = (SquareButton) activity.findViewById(R$id.ll_nest_topic_bottom_publish);
            this.i = squareButton2;
            squareButton2.setOnClickListener(this);
        }

        public void d(NestTopicResp nestTopicResp) {
            this.j = nestTopicResp;
            if (nestTopicResp == null) {
                return;
            }
            this.f16091a.setText(nestTopicResp.topic);
            this.e.setText(this.j.topic);
            if (!TextUtils.isEmpty(this.j.toast) && System.currentTimeMillis() - this.m > 5000) {
                ry5.a(this.j.toast);
                this.m = System.currentTimeMillis();
            }
            NestTopicResp nestTopicResp2 = this.j;
            NestTopicResp.Plot plot = nestTopicResp2.activity;
            if (plot == null || plot.id <= 0) {
                this.c.setText(nestTopicResp2.topicDesc);
                this.b.setVisibility(8);
                this.g.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.b.setText(this.j.activity.time);
                if (!TextUtils.isEmpty(this.j.activity.rule)) {
                    this.c.setText(this.j.activity.rule);
                }
                this.g.setVisibility(0);
            }
            SquareButton squareButton = this.h;
            NestTopicResp nestTopicResp3 = this.j;
            squareButton.setBtnInfo(nestTopicResp3.buttonText, nestTopicResp3.buttonIconUrl);
            SquareButton squareButton2 = this.i;
            NestTopicResp nestTopicResp4 = this.j;
            squareButton2.setBtnInfo(nestTopicResp4.publishButtonText, nestTopicResp4.publishButtonIcon);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            if (this.h.getVisibility() == 0) {
                layoutParams.leftMargin = a46.b(this.h.getContext(), 34.0f);
            } else {
                layoutParams.leftMargin = 0;
            }
            this.i.setLayoutParams(layoutParams);
            this.i.post(new a(layoutParams));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NestTopicResp nestTopicResp;
            NestTopicResp.Plot plot;
            if (l50.a()) {
                return;
            }
            if (view == this.h) {
                NestTopicResp nestTopicResp2 = this.j;
                NestTopicResp.Plot plot2 = nestTopicResp2.activity;
                if (plot2 == null || plot2.id <= 0) {
                    if (TextUtils.isEmpty(nestTopicResp2.publishButtonText)) {
                        qj5.H(2, this.k);
                    } else {
                        qj5.H(3, this.k);
                    }
                    wj5.g().h((Activity) view.getContext(), this.k, this.j.topic, null, 7);
                    return;
                }
                qj5.H(1, this.k);
                wj5 wj5VarG = wj5.g();
                Activity activity = (Activity) view.getContext();
                long j = this.k;
                NestTopicResp nestTopicResp3 = this.j;
                wj5VarG.i(activity, j, nestTopicResp3.topic, nestTopicResp3.activity.id, 7);
                return;
            }
            if (view != this.i) {
                if (view != this.d || (nestTopicResp = this.j) == null || (plot = nestTopicResp.activity) == null || TextUtils.isEmpty(plot.detailUrl)) {
                    return;
                }
                qj5.j0("pagetalk_top_rules", "click");
                bj5.b().a().c(NestTopicFeedsActivity.this, this.j.activity.detailUrl, false);
                return;
            }
            NestTopicResp nestTopicResp4 = this.j;
            if (nestTopicResp4 == null || TextUtils.isEmpty(nestTopicResp4.publishButtonUrl)) {
                return;
            }
            qj5.I(3, this.k);
            StringBuilder sb = new StringBuilder(this.j.publishButtonUrl);
            if (this.j.publishButtonUrl.contains(Constants.STRING_VALUE_UNSET)) {
                sb.append("&topicId=");
                sb.append(this.k);
            } else {
                sb.append("?topicId=");
                sb.append(this.k);
            }
            bj5.b().a().c(NestTopicFeedsActivity.this, sb.toString(), false);
        }
    }

    public static void G1(Context context, long j, int i) {
        Intent intent = new Intent(context, (Class<?>) NestTopicFeedsActivity.class);
        intent.putExtra("topic_id", j);
        intent.putExtra("key_from", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final void E1() {
        if (this.C.size() == 0) {
            for (String[] strArr : G) {
                NestTopicTabHeaderView.b bVar = new NestTopicTabHeaderView.b();
                for (int i = 0; i < strArr.length; i++) {
                    if (i == 0) {
                        bVar.f16542a = strArr[i];
                    }
                    if (i == 1) {
                        bVar.b = strArr[i];
                    }
                }
                FeedsFragment feedsFragment = (FeedsFragment) Fragment.instantiate(this, bVar.b);
                feedsFragment.setArguments(getIntent().getExtras());
                this.B.add(feedsFragment);
                this.C.add(bVar);
            }
        }
    }

    public final void F1() {
        this.s = new NestTopicFragmentAdapter(getSupportFragmentManager());
        this.u.addOnPageChangeListener(new a());
        this.u.setAdapter(this.s);
        this.q.onSelect(0);
        this.r.onSelect(0);
    }

    public final void H1() {
        NestTopicResp nestTopicResp = this.w;
        if (nestTopicResp == null || !this.E) {
            return;
        }
        this.z.d(nestTopicResp);
    }

    @Override // defpackage.f74
    public void O0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i, int i2, @NonNull int[] iArr, int i3) {
        if (this.F == 0) {
            this.F = this.x.getHeight();
        }
        int[] iArr2 = new int[2];
        this.q.getLocationOnScreen(iArr2);
        if (iArr2[1] <= this.F) {
            this.r.setVisibility(0);
            this.r.setBackgroundColor(-1);
            this.x.setBackgroundColor(-1);
            this.v.setVisibility(0);
            return;
        }
        this.x.setBackgroundColor(0);
        this.r.setVisibility(4);
        this.r.setBackgroundColor(0);
        this.v.setVisibility(8);
    }

    public void onBackClick(View view) {
        qj5.j0("pagetalk_top_return", "click");
        onBackPressed();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_square_nest_topic_feeds);
        this.A = UUID.randomUUID().toString().replace("-", "");
        this.v = (TextView) findViewById(R$id.tv_topic_title);
        this.y = getIntent().getLongExtra("topic_id", -1L);
        View viewFindViewById = findViewById(R$id.rl_tool_bar);
        this.x = viewFindViewById;
        viewFindViewById.setPadding(0, a46.n(this), 0, a46.b(this, 10.0f));
        findViewById(R$id.rl_header_topic).setPadding(a46.b(this, 14.0f), a46.n(this), a46.b(this, 14.0f), 0);
        this.q = (NestTopicTabHeaderView) findViewById(R$id.topic_select_tab_header);
        this.r = (NestTopicTabHeaderView) findViewById(R$id.topic_select_tab_header_second);
        ViewPager viewPager = (ViewPager) findViewById(R$id.square_nest_topic_feed_viewpager);
        this.u = viewPager;
        viewPager.setOffscreenPageLimit(0);
        ((SquareBehavior) ((CoordinatorLayout.LayoutParams) this.u.getLayoutParams()).getBehavior()).setOnPreScrollListener(this);
        this.t = getIntent().getIntExtra("key_from", 0);
        E1();
        this.q.setHeaderViewEventListener(this);
        this.q.bindTableItems(this.C, NestTopicFeedsFragment.class.getName());
        this.r.setHeaderViewEventListener(this);
        this.r.bindTableItems(this.C, NestTopicFeedsFragment.class.getName());
        this.z = new b(this, this.y);
        an1.c().p(this);
        F1();
        qj5.V(this.t, this.y);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        an1.c().r(this);
    }

    @Override // com.zenmen.square.ui.widget.NestTopicTabHeaderView.a
    public void onItemSelected(int i) {
        this.u.setCurrentItem(i);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.E = false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.E = true;
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void receiveHeaderContent(NestTopicResp nestTopicResp) {
        this.w = nestTopicResp;
        H1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            NestTopicFeedsActivity.this.q.onSelect(i);
            NestTopicFeedsActivity.this.r.onSelect(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
