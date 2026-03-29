package com.zenmen.palmchat.paidservices.superexpose;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.FindFriendFragment;
import com.zenmen.palmchat.paidservices.superexpose.SuperExposeHomeActivity;
import com.zenmen.palmchat.paidservices.superexpose.a;
import com.zenmen.palmchat.paidservices.superexpose.bean.StyleConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.view.SuperExposeTypeALayout;
import com.zenmen.palmchat.paidservices.superexpose.view.SuperExposeTypeCLayout;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dialogmanager.DialogScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.ui.widget.CircleProgressView;
import com.zenmen.square.ui.widget.FindSelectTabView;
import defpackage.a46;
import defpackage.az2;
import defpackage.b05;
import defpackage.bj5;
import defpackage.cd1;
import defpackage.cy5;
import defpackage.da3;
import defpackage.ds0;
import defpackage.fo5;
import defpackage.gr2;
import defpackage.hc2;
import defpackage.ko5;
import defpackage.l50;
import defpackage.lo5;
import defpackage.me1;
import defpackage.qm5;
import defpackage.u93;
import defpackage.xn5;
import defpackage.yn5;
import defpackage.zn6;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class b implements yn5 {
    public static float w = 54.0f;
    public static int x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f14803a;
    public FindSelectTabView h;
    public CountDownTimer i;
    public FindFriendFragment j;
    public SuperExposeInfo l;
    public CountDownTimer o;
    public boolean p;
    public boolean q;
    public RelativeLayout r;
    public ImageView s;
    public CircleProgressView t;
    public TextView u;
    public SuperExposeTypeALayout b = null;
    public ko5 c = null;
    public SuperExposeTypeCLayout d = null;
    public lo5 e = null;
    public float f = 35.0f;
    public int g = 0;
    public boolean k = false;
    public boolean m = false;
    public boolean n = false;
    public boolean v = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(b.this.j.n0()));
            zn6.j("boost_FloatingWindow", "click", map);
            b bVar = b.this;
            bVar.t(1, 0, bVar.j.n0());
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.superexpose.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC1085b implements Runnable {
        public RunnableC1085b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.z(2);
        }
    }

    public b(Context context, FindFriendFragment findFriendFragment) {
        this.f14803a = context;
        this.j = findFriendFragment;
    }

    @Override // defpackage.yn5
    public void a(int i) {
        FindFriendFragment findFriendFragment;
        StyleConfig styleConfig;
        if (l50.a()) {
            return;
        }
        int iN0 = this.j.n0();
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.j.n0()));
        SuperExposeInfo superExposeInfo = this.l;
        if (superExposeInfo != null && (styleConfig = superExposeInfo.styleConfig) != null) {
            map.put("type", Integer.valueOf(styleConfig.style));
            map.put("type_code", this.l.styleConfig.typeCode);
        }
        int i2 = 20;
        if (i == 0) {
            if (this.j.n0() != 48 && this.j.n0() == 49) {
                i2 = 23;
            }
            zn6.j("boost_portal", "click", map);
        } else {
            if (this.j.n0() == 48) {
                i2 = 21;
            } else if (this.j.n0() == 49) {
                i2 = 24;
            }
            zn6.j("boost_bubble", "click", map);
        }
        if (!SAppUtil.g.b() || (findFriendFragment = this.j) == null || findFriendFragment.getActivity() == null) {
            t(0, i2, iN0);
        } else {
            SuperExposeHomeActivity.C1(this.j.getActivity(), SuperExposeHomeActivity.FROM.DEEPLINK);
        }
    }

    @Override // defpackage.yn5
    public void b() {
        StyleConfig styleConfig;
        this.p = true;
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.j.n0()));
        SuperExposeInfo superExposeInfo = this.l;
        if (superExposeInfo != null && (styleConfig = superExposeInfo.styleConfig) != null) {
            map.put("type", Integer.valueOf(styleConfig.style));
            map.put("type_code", this.l.styleConfig.typeCode);
        }
        zn6.j("boost_bubble_close", "click", map);
    }

    public float l() {
        int i = this.g;
        return (i == 2 || i == 3 || i == 4) ? w : this.f;
    }

    public void m(View view) {
        this.h = (FindSelectTabView) view.findViewById(R.id.find_tab_header);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_super_expose_in_effect_container);
        this.s = (ImageView) view.findViewById(R.id.iv_super_expose_in_effect_bg);
        hc2.a(this.f14803a).load(Integer.valueOf(R.drawable.ic_super_expose_animation)).into(this.s);
        this.t = (CircleProgressView) view.findViewById(R.id.cpv_super_expose);
        this.u = (TextView) view.findViewById(R.id.tv_super_expose_number);
        this.r.setOnClickListener(new a());
        ds0.a().c(this);
    }

    public void n() {
        CountDownTimer countDownTimer = this.i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.i = null;
        }
        ds0.a().d(this);
    }

    public void o(boolean z) {
        LogUtil.i("SuperExposeViewControl", "onUserVisibleChange" + z);
        w(z);
        b05.d("SuperExposeViewControl===>onUserVisibleChange()");
        x(false);
        this.p = false;
        this.v = false;
    }

    @qm5
    public void onSuperExposeEvent(xn5 xn5Var) {
        int i = xn5Var.f22014a;
        if (i != 0) {
            if (i == 1) {
                u93.c(new RunnableC1085b());
            }
        } else if (this.j.isAdded()) {
            q(false, true, true);
            x(true);
            if (xn5Var.b == 0) {
                if (this.j.isResumed() || "tab_find_friend".equals(MainTabsActivity.y2())) {
                    t(1, 0, this.j.n0());
                }
            }
        }
    }

    public final void p(boolean z, SuperExposeInfo superExposeInfo) {
        LogUtil.i("SuperExpose", "refreshSuperExposeUI" + z + az2.c(superExposeInfo));
        if (superExposeInfo != null) {
            try {
                this.q = superExposeInfo.showEntrance;
                if (this.j.p0() instanceof NearByFragment) {
                    ((NearByFragment) this.j.p0()).B0(this.q);
                }
                if (this.j.u0()) {
                    this.r.setVisibility(8);
                    FindSelectTabView findSelectTabView = this.h;
                    if (findSelectTabView != null) {
                        findSelectTabView.hideSuperExposeTabEnter();
                        this.h.hideSuperExposeTipEnter();
                        return;
                    }
                    return;
                }
                FindSelectTabView findSelectTabView2 = this.h;
                if (findSelectTabView2 != null) {
                    if (this.q) {
                        if (!this.n) {
                            HashMap map = new HashMap();
                            map.put("from", Integer.valueOf(this.j.n0()));
                            StyleConfig styleConfig = superExposeInfo.styleConfig;
                            if (styleConfig != null) {
                                map.put("type", Integer.valueOf(styleConfig.style));
                                map.put("type_code", superExposeInfo.styleConfig.typeCode);
                            }
                            StyleConfig styleConfig2 = superExposeInfo.styleConfig;
                            if (styleConfig2 != null && styleConfig2.style == 1) {
                                zn6.j("boost_portal", "view", map);
                            }
                            zn6.j("boost_bubble", "view", map);
                            this.n = true;
                        }
                        this.l = superExposeInfo;
                        v(superExposeInfo, this.p, true, z);
                    } else {
                        this.n = false;
                        findSelectTabView2.hideSuperExposeTabEnter();
                        this.h.hideSuperExposeTipEnter();
                    }
                }
                int i = superExposeInfo.status;
                if (i == 1) {
                    this.k = true;
                    if (!this.m) {
                        HashMap map2 = new HashMap();
                        map2.put("from", Integer.valueOf(this.j.n0()));
                        zn6.j("boost_FloatingWindow", "view", map2);
                        this.m = true;
                    }
                    this.r.setVisibility(0);
                    long j = superExposeInfo.totalSeconds;
                    long j2 = superExposeInfo.remainSeconds;
                    long j3 = superExposeInfo.showCount;
                    fo5.l = j3;
                    CountDownTimer countDownTimer = this.o;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.o = null;
                    }
                    d dVar = new d(j * 1000, 1000L, j2, j, j3);
                    this.o = dVar;
                    dVar.start();
                } else {
                    this.k = false;
                    this.m = false;
                    if (i == -10 || i == -20 || !this.q) {
                        this.r.setVisibility(8);
                        if (superExposeInfo.status == -10) {
                            u(1, 0, this.j.n0(), superExposeInfo.status, superExposeInfo.showCount);
                        }
                    }
                }
                if (this.j.p0() instanceof NearByFragment) {
                    ((NearByFragment) this.j.p0()).Q0(this.k);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void q(boolean z, boolean z2, boolean z3) {
        LogUtil.d("SuperExpose", "requestSuperExposeInfo tabEntranceNeedAnim " + z + " fromTimeTask " + z3);
        com.zenmen.palmchat.paidservices.superexpose.a.b().f(new c(z), z2, z3);
    }

    public void r(SuperExposeInfo superExposeInfo, int i) {
        FindSelectTabView findSelectTabView;
        if (superExposeInfo == null || superExposeInfo.styleConfig == null || (findSelectTabView = this.h) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findSelectTabView.getSuperExposeTipEnterContainer();
        StyleConfig styleConfig = superExposeInfo.styleConfig;
        LogUtil.d("SuperExpose", "showExposeView style " + styleConfig.style + " curPosition " + i);
        ArrayList<Integer> arrayList = styleConfig.showPos;
        if (arrayList != null && !arrayList.contains(Integer.valueOf(i + 1))) {
            this.h.hideSuperExposeTabEnter();
            this.h.hideSuperExposeTipEnter();
            return;
        }
        int i2 = styleConfig.style;
        if (i2 == 1) {
            this.g = 1;
            if (this.b == null) {
                this.b = new SuperExposeTypeALayout(this.f14803a, this.h, this);
                viewGroup.setPadding(a46.b(this.f14803a, 16.0f), 0, a46.b(this.f14803a, 16.0f), 0);
                viewGroup.removeAllViews();
                viewGroup.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                View superExposeTabEnter = this.h.getSuperExposeTabEnter();
                ViewGroup.LayoutParams layoutParams = superExposeTabEnter.getLayoutParams();
                if ((superExposeTabEnter instanceof ImageView) && !TextUtils.isEmpty(styleConfig.topImgUrl)) {
                    gr2.j().g(styleConfig.topImgUrl, (ImageView) superExposeTabEnter);
                    if (styleConfig.topImgHeight > 0 && styleConfig.topImgWidth > 0) {
                        int iB = me1.b(this.f14803a, 21);
                        float f = (styleConfig.topImgWidth * 1.0f) / styleConfig.topImgHeight;
                        int i3 = (int) (iB * f);
                        layoutParams.height = iB;
                        layoutParams.width = i3;
                        superExposeTabEnter.setLayoutParams(layoutParams);
                        LogUtil.d("SuperExpose", "showExposeView enterBgView load img bgWidth " + i3 + " scale " + f + " url " + styleConfig.topImgUrl);
                    }
                }
            }
            this.h.showSuperExposeTabEnter();
            this.b.setAllData(superExposeInfo);
        } else if (i2 == 2) {
            this.g = 2;
            if (this.c == null) {
                this.c = new ko5(this.f14803a, this);
                viewGroup.removeAllViews();
                viewGroup.addView(this.c.a(), new ViewGroup.LayoutParams(-1, -2));
            }
            this.h.hideSuperExposeTabEnter();
            this.c.c(superExposeInfo);
        } else if (i2 == 3) {
            this.g = 3;
            if (this.d == null) {
                this.d = new SuperExposeTypeCLayout(this.f14803a, this);
                viewGroup.removeAllViews();
                viewGroup.addView(this.d, new ViewGroup.LayoutParams(-1, -2));
            }
            this.h.hideSuperExposeTabEnter();
            this.d.setAllData(superExposeInfo);
        } else if (i2 == 4) {
            this.g = 4;
            if (this.e == null) {
                this.e = new lo5(this.f14803a, this);
                viewGroup.removeAllViews();
                viewGroup.addView(this.e.a(), new ViewGroup.LayoutParams(-1, -2));
            }
            this.h.hideSuperExposeTabEnter();
            this.e.c(superExposeInfo);
        }
        if (this.g == 1) {
            View superExposeTipEnterContainer = this.h.getSuperExposeTipEnterContainer();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) superExposeTipEnterContainer.getLayoutParams();
            layoutParams2.topMargin = -me1.b(this.f14803a, 6);
            layoutParams2.bottomMargin = me1.b(this.f14803a, 6);
            superExposeTipEnterContainer.setLayoutParams(layoutParams2);
        } else {
            View superExposeTipEnterContainer2 = this.h.getSuperExposeTipEnterContainer();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) superExposeTipEnterContainer2.getLayoutParams();
            layoutParams3.topMargin = -me1.b(this.f14803a, 0);
            layoutParams3.bottomMargin = me1.b(this.f14803a, 0);
            superExposeTipEnterContainer2.setLayoutParams(layoutParams3);
        }
        this.h.showSuperExposeTipEnter(a46.b(this.f14803a, l()));
    }

    public void s() {
        if (this.h != null) {
            if (this.j.u0() || !this.q) {
                this.h.hideSuperExposeTabEnter();
                this.h.hideSuperExposeTipEnter();
            } else {
                v(this.l, this.p, true, false);
            }
        }
        if (this.r != null) {
            if (this.j.u0()) {
                this.r.setVisibility(8);
            } else if (this.k) {
                this.r.setVisibility(0);
            }
        }
    }

    public final void t(int i, int i2, int i3) {
        u(i, i2, i3, -1, -1L);
    }

    public final void u(int i, int i2, int i3, int i4, long j) {
        if (i == 0) {
            com.zenmen.palmchat.paidservices.superexpose.a.b().g(this.j.getActivity(), i3, i2, false);
        } else if (i == 1) {
            bj5.b().a().I(this.j.getActivity(), i2, i3, i4, j);
        }
    }

    public void v(SuperExposeInfo superExposeInfo, boolean z, boolean z2, boolean z3) {
        LogUtil.i("SuperExpose", "showSuperExposeTypeABC 1");
        FindSelectTabView findSelectTabView = this.h;
        if (findSelectTabView != null) {
            if (superExposeInfo == null || (z && !z2)) {
                findSelectTabView.hideSuperExposeTipEnter();
                this.h.hideSuperExposeTabEnter();
                return;
            }
            LogUtil.i("SuperExpose", "showSuperExposeTypeABC todayHasDoAnim" + SPUtil.f14322a.a(SPUtil.SCENE.FIND_FRIEND_TAB, "key_super_expose_tip_show_" + cy5.f(System.currentTimeMillis()), false));
            r(superExposeInfo, this.h.getCurrentIndex());
            StyleConfig styleConfig = superExposeInfo.styleConfig;
            if (styleConfig == null || styleConfig.style != 1) {
                this.h.hideSuperExposeTabEnter();
                return;
            }
            this.h.checkPzjyView();
            ArrayList<Integer> arrayList = superExposeInfo.styleConfig.showPos;
            if (arrayList == null || arrayList.contains(Integer.valueOf(this.h.getCurrentIndex() + 1))) {
                this.h.showSuperExposeTabEnterWithAnim(z3);
            } else {
                this.h.hideSuperExposeTabEnter();
            }
        }
    }

    public final void w(boolean z) {
        SuperExposeTypeALayout superExposeTypeALayout = this.b;
        if (superExposeTypeALayout != null) {
            if (z) {
                superExposeTypeALayout.startAutoScroll();
            } else {
                superExposeTypeALayout.stopAutoScroll();
            }
        }
        ko5 ko5Var = this.c;
        if (ko5Var != null) {
            if (z) {
                ko5Var.d();
            } else {
                ko5Var.e();
            }
        }
    }

    public final void x(boolean z) {
        if (!this.j.isResumed()) {
            CountDownTimer countDownTimer = this.i;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                return;
            }
            return;
        }
        if (this.i == null) {
            this.i = new e(5000L, 5000L);
        }
        this.i.cancel();
        this.i.start();
        if (this.j.u0()) {
            return;
        }
        q(true, z, false);
        com.zenmen.palmchat.paidservices.superexpose.a.b().c();
    }

    public final String y(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        if (j >= 1000 && j < 10000) {
            return decimalFormat.format(j / 1000.0d) + "千";
        }
        if (j >= 10000) {
            return decimalFormat.format(j / 10000.0d) + "万";
        }
        return j + "";
    }

    public void z(int i) {
        if (this.q && !this.k && (!this.j.u0())) {
            boolean zA = cd1.a(i);
            LogUtil.i("SuperExposeViewControl", "triggerBuyDialogGuide:" + i + " " + zA);
            if (zA) {
                int i2 = this.j.n0() == 48 ? 27 : this.j.n0() == 49 ? 28 : 0;
                if (da3.b().a(DialogScene.SUPER_EXPOSE_GUIDE)) {
                    t(0, i2, this.j.n0());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14806a;

        public c(boolean z) {
            this.f14806a = z;
        }

        @Override // com.zenmen.palmchat.paidservices.superexpose.a.e
        public void a(SuperExposeInfo superExposeInfo) {
            b.this.p(this.f14806a, superExposeInfo);
        }

        @Override // com.zenmen.palmchat.paidservices.superexpose.a.e
        public void onFail(Exception exc) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends CountDownTimer {
        public e(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (b.this.k) {
                if (!b.this.j.u0()) {
                    b.this.q(false, true, true);
                }
                if (b.this.i != null) {
                    b.this.i.cancel();
                    b.this.i.start();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f14807a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j, long j2, long j3, long j4, long j5) {
            super(j, j2);
            this.f14807a = j3;
            this.b = j4;
            this.c = j5;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = this.f14807a + (j / 1000);
            long j3 = this.b;
            int i = (int) (((j2 - j3) * 100) / j3);
            if (i >= 0) {
                b.this.t.setProgress(i);
            }
            b.this.u.setText(b.this.y(this.c));
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }
    }
}
