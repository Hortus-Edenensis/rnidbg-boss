package com.zenmen.square.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.listui.list.BaseListFragment;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.task1v1.TaskTipBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.MainTabSubFragment;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.SquareMessageActivity;
import com.zenmen.square.bean.GuideObjBean;
import com.zenmen.square.bean.SquareGuideTieziDialogBean;
import com.zenmen.square.bean.SquareShareFeedBean;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.tag.config.SquareConfig;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.ui.widget.BottomGuideView;
import com.zenmen.square.ui.widget.NearByFilterDialog;
import com.zenmen.square.ui.widget.PostBar;
import com.zenmen.square.ui.widget.SelectTabHeaderView;
import defpackage.a46;
import defpackage.ai5;
import defpackage.b05;
import defpackage.bj5;
import defpackage.ft5;
import defpackage.gi5;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.je1;
import defpackage.kl5;
import defpackage.l50;
import defpackage.lj5;
import defpackage.ma3;
import defpackage.mj5;
import defpackage.q05;
import defpackage.q42;
import defpackage.qj5;
import defpackage.qs5;
import defpackage.ro2;
import defpackage.tg4;
import defpackage.ti5;
import defpackage.to2;
import defpackage.vi5;
import defpackage.vs0;
import defpackage.wh5;
import defpackage.zn6;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFragment extends MainTabSubFragment implements SelectTabHeaderView.g, View.OnClickListener, Observer {
    public static boolean U = false;
    public View A;
    public PostBar B;
    public ViewGroup F;
    public int G;
    public int H;
    public LocationEx I;
    public ImageView J;
    public TextView K;
    public TextView L;
    public CountDownTimer N;
    public SelectTabHeaderView k;
    public View l;
    public ImageView m;
    public View n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public ViewPager r;
    public SquareFragmentAdapter s;
    public String t;
    public TextView u;
    public View w;
    public View x;
    public View y;
    public BottomGuideView z;
    public long f = 0;
    public long g = 0;
    public List<to2> h = new ArrayList();
    public List<qs5> i = gi5.r();
    public int j = 0;
    public boolean v = true;
    public boolean C = true;
    public ti5 E = new ti5(this);
    public boolean M = false;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = true;
    public je1 R = new je1.a().s(true).A(R$drawable.bg_square_guide_big).t(true).q(Bitmap.Config.RGB_565).r();
    public int S = 1;
    public RecyclerView.OnScrollListener T = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class SquareFragmentAdapter extends FragmentPagerAdapter {
        @SuppressLint({"WrongConstant"})
        public SquareFragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager, BaseFragment.D());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return SquareFragment.this.h.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            to2 to2Var = (to2) SquareFragment.this.h.get(i);
            if (TextUtils.isEmpty(to2Var.getSid())) {
                if (TextUtils.isEmpty(SquareFragment.this.t)) {
                    SquareFragment.this.t = UUID.randomUUID().toString().replaceAll("-", "");
                }
                to2Var.u(SquareFragment.this.t);
            }
            ma3.a("getItem onSupperSelect " + SquareFragment.this.isResumed(), new Object[0]);
            to2Var.i(SquareFragment.this.isResumed());
            return (Fragment) to2Var;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            SquareFragment.this.e1(recyclerView);
            if (SquareFragment.this.l.getVisibility() == 0) {
                SquareFragment.this.l.setVisibility(8);
            }
            SquareFragment.this.E.m(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            SquareFragment.this.e1(recyclerView);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f16330a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("postguide_ID", Long.valueOf(b.this.f16330a));
            }
        }

        /* JADX INFO: renamed from: com.zenmen.square.fragment.SquareFragment$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1155b implements q05.e {

            /* JADX INFO: renamed from: com.zenmen.square.fragment.SquareFragment$b$b$a */
            /* JADX INFO: compiled from: SearchBox */
            public class a implements q05.f {
                public a() {
                }

                @Override // q05.f
                public void a() {
                    if (SquareFragment.this.m != null) {
                        SquareFragment.this.m.setVisibility(8);
                    }
                }
            }

            public C1155b() {
            }

            @Override // q05.e
            public void a(Object obj) {
                q05.u(SquareFragment.this.getActivity(), new a());
            }
        }

        public b(long j) {
            this.f16330a = j;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            if (bitmap == null) {
                return;
            }
            SquareFragment.this.m.setImageBitmap(bitmap);
            q05.y(SquareFragment.this.m, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            SquareFragment.this.m.setVisibility(0);
            q05.a("postguide_bubble", 1, new a());
            SquareFragment squareFragment = SquareFragment.this;
            squareFragment.N = q05.l(squareFragment.getActivity(), 10000L, new C1155b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareFragment.this.x();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicListBean.Topic topic;
            if (q05.p()) {
                return;
            }
            SquareFragment.this.m.setVisibility(8);
            if (lj5.c().g == null || lj5.c().g.bindTopicId == null) {
                topic = null;
            } else {
                topic = new TopicListBean.Topic();
                topic.topicId = lj5.c().g.bindTopicId.longValue();
                topic.topicName = lj5.c().g.bindTopicName;
            }
            qj5.h(1);
            bj5.b().a().c0(SquareFragment.this.getActivity(), 103, null, topic, null, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareGuideTieziDialogBean f16336a;

        public e(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
            this.f16336a = squareGuideTieziDialogBean;
            put("view_tab", Integer.valueOf(SquareFragment.this.r.getCurrentItem() + 1));
            put("view_type", Integer.valueOf(squareGuideTieziDialogBean.triggerType));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareGuideTieziDialogBean f16337a;

        public f(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
            this.f16337a = squareGuideTieziDialogBean;
            put("view_tab", Integer.valueOf(SquareFragment.this.r.getCurrentItem() + 1));
            put("view_type", Integer.valueOf(squareGuideTieziDialogBean.triggerType));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareGuideTieziDialogBean f16338a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("view_type", Integer.valueOf(g.this.f16338a.triggerType));
            }
        }

        public g(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
            this.f16338a = squareGuideTieziDialogBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("postguide_entry", "click", new a());
            SquareFragment.this.c1(this.f16338a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements NearByFilterDialog.a {
        public i() {
        }

        @Override // com.zenmen.square.ui.widget.NearByFilterDialog.a
        public void a(int i) {
            qj5.A(i);
            SquareFragment.this.x();
        }

        @Override // com.zenmen.square.ui.widget.NearByFilterDialog.a
        public void onCancel() {
            qj5.b("filtratewindow_close", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(int i2) {
        if (i2 == 0) {
            Z0("recommendTitle");
        } else if (i2 == 2) {
            Z0("friendFeedTitle");
        }
    }

    public void A() {
        List<to2> list;
        if (this.j < 0 || (list = this.h) == null || list.size() <= this.j) {
            return;
        }
        this.A.setVisibility(8);
        this.h.get(this.j).A();
    }

    public final long A0() {
        JSONObject config = vs0.a().getConfig("autoreFresh");
        if (config != null) {
            return config.optLong("time", 180000L);
        }
        return 180000L;
    }

    public int B0() {
        Object objC0 = C0();
        if (objC0 instanceof BaseListFragment) {
            return ((BaseListFragment) objC0).o();
        }
        return 2;
    }

    public final to2 C0() {
        List<to2> list = this.h;
        if (list == null || list.isEmpty() || this.j >= this.h.size()) {
            return null;
        }
        return this.h.get(this.j);
    }

    public final void E0() {
        boolean zP = a46.p();
        this.n.setVisibility(8);
        if ((C0() instanceof SquareMomentsFragment) || zP) {
            this.z.setCurrentGuideMode(0);
        } else if (a46.o()) {
            this.z.setCurrentGuideMode(1);
        } else {
            this.z.setCurrentGuideMode(2);
        }
        if (!(C0() instanceof NearByFragment)) {
            this.k.setToolIconVisibility(0);
            this.k.setNearByIconVisible(4);
        } else {
            this.k.setToolIconVisibility(4);
            this.k.setNearByIconVisible(0);
            this.l.setVisibility(8);
        }
    }

    public final void G0() {
        SquareConfig.GuideInfo guideInfo = ai5.k().j().getGuideInfo();
        if (TextUtils.isEmpty(guideInfo.getDiscoverleadpagepic())) {
            this.o.setImageResource(R$drawable.bg_square_guide_big);
        } else {
            gr2.j().h(guideInfo.getDiscoverleadpagepic(), this.o, this.R);
        }
        String pageleadtitle = guideInfo.getPageleadtitle();
        ma3.a("get guideTitle is " + pageleadtitle, new Object[0]);
        if (TextUtils.isEmpty(pageleadtitle)) {
            pageleadtitle = kl5.a(R$string.square_welcome);
        }
        ma3.a("get guideTitle2 is " + pageleadtitle, new Object[0]);
        this.p.setText(pageleadtitle);
        int leadpersonnum = ai5.k().j().getLeadpersonnum();
        ma3.a("get leadNum from server " + leadpersonnum, new Object[0]);
        if (leadpersonnum <= 0) {
            leadpersonnum = new Random().nextInt(10000) + 20001;
        }
        String str = new DecimalFormat("#,###").format(leadpersonnum);
        String pageleadintro = guideInfo.getPageleadintro();
        ma3.a("get leadString is " + pageleadintro, new Object[0]);
        if (TextUtils.isEmpty(pageleadintro)) {
            pageleadintro = kl5.a(R$string.square_welcome_summary);
        }
        ma3.a("get leadString2 is " + pageleadintro, new Object[0]);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(pageleadintro.replace("#leadpersonnum#", str));
        int iIndexOf = pageleadintro.indexOf(35);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F95645")), iIndexOf, str.length() + iIndexOf, 18);
        this.q.setText(spannableStringBuilder);
    }

    public void I0(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
        if (squareGuideTieziDialogBean == null || getContext() == null || getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        this.F.setVisibility(0);
        b05.d("view_tab" + this.r.getCurrentItem() + 1);
        zn6.j("postguide_entry", "view", new f(squareGuideTieziDialogBean));
        GuideObjBean guideObjBean = squareGuideTieziDialogBean.guideObj;
        if (guideObjBean != null) {
            if (!TextUtils.isEmpty(guideObjBean.guideTitle)) {
                this.K.setText(squareGuideTieziDialogBean.guideObj.guideTitle);
            }
            if (!TextUtils.isEmpty(squareGuideTieziDialogBean.guideObj.guideIntro)) {
                this.L.setText(squareGuideTieziDialogBean.guideObj.guideIntro);
            }
            if (!TextUtils.isEmpty(squareGuideTieziDialogBean.guideObj.guidePic)) {
                hc2.a(getContext()).load(squareGuideTieziDialogBean.guideObj.guidePic).into(this.J);
            }
            this.F.setOnClickListener(new g(squareGuideTieziDialogBean));
            if (this.O || mj5.r().u()) {
                return;
            }
            c1(squareGuideTieziDialogBean);
            this.O = true;
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        b05.d("squareFragment===》 onUserVisibleChange=====>" + z);
        ma3.a("SquareFragment onUserVisibleChange " + z, new Object[0]);
        this.P = z;
        if (z) {
            if (bj5.b().a().t()) {
                lj5.c().e(getActivity(), "a0404");
                S0();
                R0();
            }
            this.t = UUID.randomUUID().toString().replace("-", "");
            Iterator<to2> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().u(this.t);
            }
            zn6.c("pagediscover_tabbutton", "click");
            y0();
        }
        T0(z);
    }

    public final void K0() {
        if (this.s == null || this.C) {
            List<Fragment> fragments = getChildFragmentManager().getFragments();
            if (fragments != null && !fragments.isEmpty()) {
                this.h.clear();
                for (ActivityResultCaller activityResultCaller : fragments) {
                    if (activityResultCaller instanceof to2) {
                        to2 to2Var = (to2) activityResultCaller;
                        to2Var.i(isResumed());
                        to2Var.n(this.T);
                        this.h.add(to2Var);
                    }
                }
            }
            this.s = new SquareFragmentAdapter(getChildFragmentManager());
            this.r.addOnPageChangeListener(new k());
            this.r.setAdapter(this.s);
            this.r.setCurrentItem(this.j, false);
            this.k.onSelect(this.j);
            this.C = false;
        }
    }

    public final void L0(View view) {
        List<qs5> list;
        view.setPadding(0, a46.n(getContext()), 0, 0);
        this.l = view.findViewById(R$id.rl_square_guide_publish_float);
        this.m = (ImageView) view.findViewById(R$id.rl_square_yunying_guide_Image);
        if (!bj5.b().a().t()) {
            if (SPUtil.f14322a.a(SPUtil.SCENE.SQUARE_CONFIG, "key_square_click_publish", false) || q42.a()) {
                this.l.setVisibility(8);
            } else {
                this.l.findViewById(R$id.square_guide_publish_float_normal).setVisibility(0);
                this.l.findViewById(R$id.square_guide_publish_float_red).setVisibility(8);
                this.l.setVisibility(0);
            }
        }
        this.p = (TextView) view.findViewById(R$id.tv_guide_welcome);
        this.q = (TextView) view.findViewById(R$id.tv_guide_summary);
        this.o = (ImageView) view.findViewById(R$id.bg_square_guide_big_logo);
        this.n = view.findViewById(R$id.square_profile_location_guide);
        this.z = (BottomGuideView) view.findViewById(R$id.layout_square_permission_guide_v2);
        TextView textView = (TextView) view.findViewById(R$id.btn_profile_location_guide);
        this.u = textView;
        textView.setOnClickListener(this);
        this.k = (SelectTabHeaderView) view.findViewById(R$id.square_main_head_view);
        ViewPager viewPager = (ViewPager) view.findViewById(R$id.square_fragment_viewpager);
        this.r = viewPager;
        viewPager.setOffscreenPageLimit(2);
        String str = null;
        if (this.h.size() == 0 && (list = this.i) != null) {
            for (qs5 qs5Var : list) {
                if (str == null) {
                    str = qs5Var.c;
                }
                to2 to2Var = (to2) Fragment.instantiate(getContext(), qs5Var.c);
                to2Var.n(this.T);
                this.h.add(to2Var);
            }
        }
        this.k.setHeaderViewEventListener(this);
        this.k.bindTableItems(this.i, str);
        this.w = view.findViewById(R$id.sys_location_server_layout);
        this.x = view.findViewById(R$id.sys_location_service_setting);
        this.y = view.findViewById(R$id.iv_close_sys_location_service_tips);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        G0();
        View viewFindViewById = view.findViewById(R$id.iv_go_top);
        this.A = viewFindViewById;
        viewFindViewById.setVisibility(8);
        this.A.setOnClickListener(new c());
        PostBar postBar = (PostBar) view.findViewById(R$id.public_progress);
        this.B = postBar;
        postBar.setOnPostListener(new PostBar.f() { // from class: pi5
            @Override // com.zenmen.square.ui.widget.PostBar.f
            public final void a(int i2) {
                this.f20023a.M0(i2);
            }
        });
        this.F = (ViewGroup) view.findViewById(R$id.square_user_guid_tiezi_layout);
        this.J = (ImageView) view.findViewById(R$id.square_user_guid_tiezi_image);
        this.K = (TextView) view.findViewById(R$id.square_user_guid_tiezi_title);
        this.L = (TextView) view.findViewById(R$id.square_user_guid_tiezi_subtitle);
        this.m.setOnClickListener(new d());
        this.E.i((ViewGroup) view.findViewById(R$id.voice_match_bubble_layout));
    }

    public final void N0() {
        this.n.setVisibility(8);
        this.v = true;
        K0();
    }

    public void Q0() {
        if (this.n.getVisibility() == 0) {
            return;
        }
        qj5.h(0);
        bj5.b().a().c0(getActivity(), 10, null, null, null, true);
    }

    public void R0() {
        b05.d("onShowXinshouYindaoQiPao()");
        if (this.P && lj5.c().e && !lj5.c().f) {
            lj5.c().e = false;
            lj5.c().f = true;
            if (SPUtil.f14322a.a(SPUtil.SCENE.SQUARE_CONFIG, "key_square_click_publish", false)) {
                this.l.setVisibility(8);
            } else {
                if (q42.a()) {
                    this.l.setVisibility(8);
                    return;
                }
                this.l.findViewById(R$id.square_guide_publish_float_normal).setVisibility(0);
                this.l.findViewById(R$id.square_guide_publish_float_red).setVisibility(8);
                this.l.setVisibility(0);
            }
        }
    }

    public void S0() {
        b05.d("onShowYunyingTieziQiPao()");
        if (this.P && lj5.c().c && lj5.c().g != null) {
            long j2 = lj5.c().g.id;
            lj5.c().c = false;
            lj5.c().b();
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_click_publish", Boolean.TRUE);
            hc2.b(getActivity()).asBitmap().load(lj5.c().g.imageUrl).into(new b(j2));
        }
    }

    public void T0(boolean z) {
        List<to2> list = this.h;
        if (list != null) {
            Iterator<to2> it = list.iterator();
            while (it.hasNext()) {
                it.next().i(z);
            }
            if (!z) {
                this.f = System.currentTimeMillis();
            } else {
                if (this.f == 0 || System.currentTimeMillis() - this.f <= A0()) {
                    return;
                }
                A();
                this.f = 0L;
            }
        }
    }

    public void V0() {
        ti5 ti5Var = this.E;
        if (ti5Var != null) {
            ti5Var.r();
        }
    }

    public final void W0() {
        E0();
        N0();
    }

    public void Z0(String str) {
        if (TextUtils.isEmpty(str) || this.i == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.i.size()) {
                break;
            }
            if (this.i.get(i3).d.equals(str)) {
                i2 = i3;
                break;
            }
            i3++;
        }
        SelectTabHeaderView selectTabHeaderView = this.k;
        if (selectTabHeaderView == null) {
            this.j = i2;
        } else {
            selectTabHeaderView.selectedTargetItem(i2, true);
        }
    }

    public void a1(int i2, String str) {
        this.G = i2;
        if (i2 == 43) {
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(i2));
            if ("recommendTitle".equals(str)) {
                qj5.b("pagediscover_nofriend", "view", map);
            }
            if ("momentsTitle".equals(str)) {
                qj5.b("pagediscover_isfriendcircle", "view", map);
            }
        }
    }

    public void b1() {
        if (this.P) {
            lj5.c().e(getActivity(), "a0404");
        }
    }

    public final void c1(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
        if (this.I == null || squareGuideTieziDialogBean == null) {
            return;
        }
        SquareUserGuideChoseDialog squareUserGuideChoseDialog = new SquareUserGuideChoseDialog(getContext(), this.I, squareGuideTieziDialogBean.popupMsgList, squareGuideTieziDialogBean.guideObj);
        squareUserGuideChoseDialog.v(0.9f);
        squareUserGuideChoseDialog.x(2);
        squareUserGuideChoseDialog.getWindow().setSoftInputMode(34);
        squareUserGuideChoseDialog.show();
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_squre_guide_show_time", Long.valueOf(System.currentTimeMillis()));
        b05.d("view_tab" + this.r.getCurrentItem() + 1);
        zn6.j("postguide_popup", "view", new e(squareGuideTieziDialogBean));
    }

    @Override // com.zenmen.square.ui.widget.SelectTabHeaderView.g
    public void d() {
        qj5.b("pagediscover_nearby_filtrate", "click", null);
        NearByFilterDialog.A(getActivity(), new i());
    }

    public final void e1(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.computeVerticalScrollOffset() >= a46.m(getContext()).y * 3) {
            this.A.setVisibility(0);
        } else {
            this.A.setVisibility(4);
        }
    }

    public void f1() {
        this.k.updateRedDot(SquareSingleton.getInstance().getMessageCountManager().e(), "nearbyFeedTitle");
        this.k.updateRedDot();
    }

    @Override // com.zenmen.square.ui.widget.SelectTabHeaderView.g
    public void g() {
        View view = this.l;
        if (view != null && view.findViewById(R$id.square_guide_publish_float_red).getVisibility() == 0) {
            HashMap map = new HashMap();
            map.put("type", Integer.valueOf(this.H));
            qj5.b("MissionPost_popover", "click", map);
        }
        if (this.n.getVisibility() == 0) {
            return;
        }
        qj5.h(0);
        bj5.b().a().c0(getActivity(), B0(), null, null, null, true);
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE_CONFIG, "key_square_click_publish", Boolean.TRUE);
        this.l.setVisibility(8);
    }

    public final void h1(TaskTipBean taskTipBean) {
        if (this.l != null) {
            if (!q42.a() || taskTipBean == null || TextUtils.isEmpty(taskTipBean.squareTip)) {
                this.l.findViewById(R$id.square_guide_publish_float_red).setVisibility(8);
                if (SPUtil.f14322a.a(SPUtil.SCENE.SQUARE_CONFIG, "key_square_click_publish", false)) {
                    this.l.setVisibility(8);
                    return;
                } else {
                    this.l.findViewById(R$id.square_guide_publish_float_normal).setVisibility(0);
                    this.l.setVisibility(0);
                    return;
                }
            }
            this.l.findViewById(R$id.square_guide_publish_float_red).setVisibility(0);
            this.l.findViewById(R$id.square_guide_publish_float_normal).setVisibility(8);
            ((TextView) this.l.findViewById(R$id.square_guide_publish_tv)).setText(Html.fromHtml(taskTipBean.squareTip));
            this.l.setVisibility(0);
            HashMap map = new HashMap();
            int i2 = taskTipBean.squareFromType;
            this.H = i2;
            map.put("type", Integer.valueOf(i2));
            qj5.b("MissionPost_popover", "view", map);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R$id.btn_profile_location_guide) {
            if (id == R$id.sys_location_service_setting) {
                R();
                return;
            } else {
                if (id == R$id.iv_close_sys_location_service_tips) {
                    this.w.setVisibility(8);
                    U = true;
                    return;
                }
                return;
            }
        }
        boolean zB = tg4.b(getContext(), com.kuaishou.weapon.p0.g.g);
        if (vi5.b().g()) {
            qj5.G("pagediscover_guide_open", "click", 1, this.S);
            vi5.b().k(getContext(), new j(zB));
        } else if (zB) {
            N0();
        } else {
            qj5.G("pagediscover_guide_open", "click", 2, this.S);
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getActivity(), BaseActivityPermissionDispatcher.PermissionType.SQUARE_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SQUARE_GET_LOCATION);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mj5.r().addObserver(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = true;
        View viewInflate = layoutInflater.inflate(R$layout.square_layout_activity_main, viewGroup, false);
        L0(viewInflate);
        b05.d("squareFragment===》onCreateView");
        return viewInflate;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.N;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        mj5.r().deleteObserver(this);
    }

    @Override // com.zenmen.square.ui.widget.SelectTabHeaderView.g
    public void onItemSelected(int i2) {
        if (this.v) {
            to2 to2Var = i2 < this.h.size() ? this.h.get(i2) : null;
            if (to2Var instanceof RecommendFeedsFragment) {
                if (to2Var instanceof NearByFeedsFragment) {
                    wh5.W(getActivity(), 2, 0);
                } else {
                    wh5.Y(getActivity(), 2, 0);
                }
            } else if (to2Var instanceof FriendFeedsFragment) {
                wh5.X(getActivity(), 2, 0);
            }
            if (to2Var != null) {
                e1(to2Var.e());
            }
            this.r.setCurrentItem(i2);
            this.j = i2;
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.g = System.currentTimeMillis();
        this.E.k();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ma3.a("SquareFragment onResume", new Object[0]);
        b05.d("squareFragment===》onResume");
        W0();
        if (!this.Q) {
            f1();
            g1();
        }
        this.Q = false;
        this.E.l();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.zenmen.square.ui.widget.SelectTabHeaderView.g
    public void s() {
        if (this.n.getVisibility() == 0) {
            return;
        }
        qj5.g();
        startActivity(new Intent(getActivity(), (Class<?>) SquareMessageActivity.class));
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (!(observable instanceof mj5) || this.B == null) {
            return;
        }
        ViewGroup viewGroup = this.F;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            this.F.setVisibility(8);
            this.M = true;
        }
        if (obj != null) {
            this.B.updateStatus((SquareShareFeedBean) obj);
        } else {
            this.B.updateStatus(null);
        }
    }

    public void x() {
        this.A.setVisibility(8);
        Iterator<to2> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().x();
        }
    }

    public final void y0() {
        ft5.b(2, new h());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16342a;

        public j(boolean z) {
            this.f16342a = z;
        }

        @Override // ro2.a
        public void onSuccess() {
            if (this.f16342a) {
                SquareFragment.this.N0();
            } else {
                SquareFragment.this.W0();
            }
        }

        @Override // ro2.a
        public void onCancel() {
        }
    }

    public void X0() {
    }

    public void g1() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements ft5.b {
        public h() {
        }

        @Override // ft5.b
        public void a(TaskTipBean taskTipBean) {
            SquareFragment.this.h1(taskTipBean);
        }

        @Override // ft5.b
        public void onFail(Exception exc) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements ViewPager.OnPageChangeListener {
        public k() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageSelected(int i) {
            LogUtil.d("logsquare", "onPageSelected: " + i);
            if (SquareFragment.this.j != i && i < SquareFragment.this.h.size() && i >= 0) {
                qj5.l0(((BaseDurationFragment) SquareFragment.this.h.get(i)).o());
                SquareFragment squareFragment = SquareFragment.this;
                squareFragment.e1(((to2) squareFragment.h.get(i)).e());
                if (SquareFragment.this.h.get(i) instanceof RecommendFeedsFragment) {
                    boolean z = ((RecommendFeedsFragment) SquareFragment.this.h.get(i)).o() == 1;
                    SquareFragment.this.E.n(z);
                }
            }
            SquareFragment.this.j = i;
            SquareFragment.this.k.onSelect(i);
            SquareFragment.this.E0();
            SquareFragment.this.X0();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    public void O0(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
    }
}
