package com.zenmen.palmchat;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.kuaishou.weapon.p0.g;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.SquareGuideTieziDialogBean;
import com.zenmen.square.fragment.SquareFragment;
import com.zenmen.square.support.SquareSingleton;
import defpackage.b05;
import defpackage.ch;
import defpackage.d46;
import defpackage.e46;
import defpackage.hx3;
import defpackage.i53;
import defpackage.n53;
import defpackage.os5;
import defpackage.qm5;
import defpackage.tg4;
import defpackage.ui5;
import defpackage.uk5;
import defpackage.vs0;
import defpackage.wi5;
import defpackage.yj5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SquareTabFragment extends SquareFragment {
    public ui5 V;
    public long W = 0;
    public d46 X = new a();
    public long Y = 0;
    public int Z = 2;
    public boolean e0 = false;
    public boolean f0 = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends e46 {
        public a() {
        }

        @Override // defpackage.e46, defpackage.d46
        public void a(boolean z) {
            SquareTabFragment.this.g1();
        }

        @Override // defpackage.e46, defpackage.d46
        public void c(int i) {
            SquareTabFragment.this.g1();
        }

        @Override // defpackage.d46
        public void e(int i) {
            SquareTabFragment.this.g1();
        }

        @Override // defpackage.d46
        public void f(int i) {
            LogUtil.d("SquareFragment", "get praise count " + i);
            SquareTabFragment.this.g1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareTabFragment.this.x();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SquareTabFragment.this.g1();
            SquareTabFragment.this.f1();
        }
    }

    @Override // com.zenmen.square.fragment.SquareFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        if (z) {
            k1();
            j1();
        }
    }

    @Override // com.zenmen.square.fragment.SquareFragment
    public void X0() {
        if (!yj5.a() || this.e0) {
            return;
        }
        b05.d("开始定位");
        l1();
    }

    @Override // com.zenmen.square.fragment.SquareFragment
    public void g1() {
        int iP = SquareSingleton.getInstance().getMessageCountManager().p();
        FragmentActivity activity = getActivity();
        os5 os5VarC2 = (activity == null || !(activity instanceof MainTabsActivity)) ? null : ((MainTabsActivity) activity).C2("tab_square");
        if (os5VarC2 != null) {
            if (iP <= 0) {
                os5VarC2.c(false);
                os5VarC2.d(SquareSingleton.getInstance().getMessageCountManager().o());
            } else {
                os5VarC2.d(false);
                os5VarC2.c(true);
                os5VarC2.b(iP);
            }
        }
    }

    public final void j1() {
        boolean zB = tg4.b(com.zenmen.palmchat.c.b(), g.g);
        boolean zF = com.zenmen.palmchat.location.b.f(com.zenmen.palmchat.c.b());
        b05.d("hasLocation=" + zB);
        b05.d("isSysLocationServiceOpen=" + zF);
        if (zF && zB) {
            X0();
        }
    }

    public final void k1() {
        if (System.currentTimeMillis() - this.Y > 60000) {
            this.Y = System.currentTimeMillis();
            SquareSingleton.getInstance().reloadPraiseCount();
        }
    }

    public final void l1() {
        if (this.M) {
            return;
        }
        try {
            if (this.W != 0) {
                b05.d("lastShowTime=" + this.W);
                long jOptLong = vs0.a().getConfig("postguide").optLong("postguide_fre", 0L);
                b05.d("intervalTime=" + jOptLong);
                if (System.currentTimeMillis() - this.W < jOptLong * 1000) {
                    b05.d("还在缓存期间内");
                    return;
                }
            }
        } catch (Exception unused) {
        }
        if (hx3.m(com.zenmen.palmchat.c.b())) {
            b05.d("开始请求");
            this.e0 = true;
            com.zenmen.palmchat.location.d.g().k(LocationScene.PUBLISH_SQUARE, new d());
        }
    }

    @Override // com.zenmen.square.fragment.SquareFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ch.s().r().j(this);
        g1();
        this.W = SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, "key_squre_guide_show_time", 0L);
    }

    @Override // com.zenmen.square.fragment.SquareFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ch.s().r().l(this);
        SquareSingleton.getInstance().unRegisterCountChangeListener(this.X);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zenmen.square.fragment.SquareFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.square.fragment.SquareFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k1();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        FragmentActivity activity;
        if (uk5Var.f21235a != 46 || (activity = getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new b());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        SquareSingleton.getInstance().registerCountChangeListener(this.X);
    }

    @qm5
    public void onStatusChanged(wi5 wi5Var) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new c());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements i53 {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ui5.b {
            public a() {
            }

            @Override // ui5.b
            public void a(SquareGuideTieziDialogBean squareGuideTieziDialogBean) {
                if (squareGuideTieziDialogBean.popupFlag) {
                    b05.d("服务端展示弹窗");
                    SquareTabFragment.this.I0(squareGuideTieziDialogBean);
                }
            }
        }

        public d() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            SquareTabFragment.this.e0 = false;
            LogUtil.i("BaseLocationListMode", "get location success " + locationEx);
            if (i != 0 || locationEx == null) {
                return;
            }
            SquareTabFragment squareTabFragment = SquareTabFragment.this;
            squareTabFragment.I = locationEx;
            if (squareTabFragment.V == null) {
                squareTabFragment.V = new ui5();
            }
            SquareTabFragment squareTabFragment2 = SquareTabFragment.this;
            squareTabFragment2.V.a(squareTabFragment2.I, new a());
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
