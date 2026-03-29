package com.zenmen.palmchat.maintab;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.material.appbar.AppBarLayout;
import com.kuaishou.weapon.p0.g;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.find.bean.FindFriendCondition;
import com.zenmen.openapi.config.LxApiProxy;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.FindFriendFragment;
import com.zenmen.palmchat.maintab.config.TurnInfo;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dialogmanager.DialogScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.fragment.MapFindNearByFragment;
import com.zenmen.square.fragment.NearByFragment;
import com.zenmen.square.fragment.QualityFriendshipFragment;
import com.zenmen.square.fragment.RecommendNearByFragment;
import com.zenmen.square.fragment.online.OnlineRecommend;
import com.zenmen.square.tag.config.FindFriendFilterGuideConfig;
import com.zenmen.square.ui.widget.FindMapEntryView;
import com.zenmen.square.ui.widget.FindSelectTabView;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.a46;
import defpackage.ai5;
import defpackage.an1;
import defpackage.b05;
import defpackage.da3;
import defpackage.dw1;
import defpackage.e9;
import defpackage.fg6;
import defpackage.gi5;
import defpackage.hw5;
import defpackage.iw5;
import defpackage.jo6;
import defpackage.l50;
import defpackage.lj5;
import defpackage.ma3;
import defpackage.pm5;
import defpackage.qj5;
import defpackage.qs5;
import defpackage.rv1;
import defpackage.sd3;
import defpackage.tg4;
import defpackage.to2;
import defpackage.uc3;
import defpackage.uj5;
import defpackage.y84;
import defpackage.z64;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FindFriendFragment extends BaseFragment implements FindSelectTabView.d, ConditionHelper.a, Observer {
    public static final String v = "com.zenmen.palmchat.maintab.FindFriendFragment";
    public FindSelectTabView g;
    public View h;
    public ViewPager j;
    public FindFriendPagerAdapter k;
    public String m;
    public RelativeLayout o;
    public AppBarLayout p;
    public FindMapEntryView q;
    public long f = com.igexin.push.f.b.d.b;
    public List<to2> i = new ArrayList();
    public int l = 0;
    public List<qs5> n = gi5.e();
    public boolean r = false;
    public boolean s = LxApiProxy.getInstance().getConfigApi().b();
    public com.zenmen.palmchat.paidservices.superexpose.b t = null;
    public boolean u = true;

    /* JADX INFO: compiled from: SearchBox */
    public class FindFriendPagerAdapter extends FragmentPagerAdapter {
        @SuppressLint({"WrongConstant"})
        public FindFriendPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager, BaseFragment.D());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (FindFriendFragment.this.i != null) {
                return FindFriendFragment.this.i.size();
            }
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            to2 to2Var = (to2) FindFriendFragment.this.i.get(i);
            FindFriendFragment.this.S0();
            if (TextUtils.isEmpty(to2Var.getSid())) {
                if (TextUtils.isEmpty(FindFriendFragment.this.m)) {
                    FindFriendFragment.this.m = UUID.randomUUID().toString().replaceAll("-", "");
                }
                to2Var.u(FindFriendFragment.this.m);
            }
            ma3.a("getItem onSupperSelect " + FindFriendFragment.this.isResumed(), new Object[0]);
            to2Var.i(FindFriendFragment.this.isResumed());
            return (Fragment) to2Var;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hw5 f14601a;

        public a(hw5 hw5Var) {
            this.f14601a = hw5Var;
            put("style", Integer.valueOf(hw5Var.h()));
            put("mid", hw5Var.g());
            put(TurnInfo.TYPE_DEEP_LINK, hw5Var.d());
            put("type", 53);
            put("pageIndex", "b0001");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14603a;

        public c(MaterialDialog materialDialog) {
            this.f14603a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14603a.dismiss();
            qj5.F("discoverleadalert_loc_accept", "click");
            FindFriendFragment.this.w0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14604a;

        public d(MaterialDialog materialDialog) {
            this.f14604a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14604a.dismiss();
            qj5.F("discoverleadalert_loc_close", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            qj5.F("discoverleadalert_loc_close", "click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3 f14606a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public f(uc3 uc3Var, int i, int i2) {
            this.f14606a = uc3Var;
            this.b = i;
            this.c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f14606a.dismiss();
            com.zenmen.palmchat.paidservices.superexpose.a.b().g(FindFriendFragment.this.getActivity(), this.b, this.c, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(MaterialDialog materialDialog, View view) {
        to2 to2VarP0 = p0();
        if (to2VarP0 instanceof NearByFragment) {
            ConditionHelper.openFilterDialog(((NearByFragment) to2VarP0).o(), getActivity());
        }
        qj5.j0("ffriend_popup_click", null);
        materialDialog.dismiss();
    }

    public static /* synthetic */ void y0(MaterialDialog materialDialog, View view) {
        qj5.j0("ffriend_popup_close", null);
        materialDialog.dismiss();
    }

    public final void A0() {
        List<to2> list = this.i;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.i.size(); i++) {
            if (this.i.get(i) instanceof OnlineRecommend) {
                z64.l();
                ((OnlineRecommend) this.i.get(i)).I1(this.g);
                LogUtil.d("", "onlineTT onResume pageactivehall_entryview");
                return;
            }
        }
    }

    public void B0(boolean z) {
        List<to2> list = this.i;
        if (list != null) {
            Iterator<to2> it = list.iterator();
            while (it.hasNext()) {
                it.next().i(z);
            }
        }
    }

    public void C0(boolean z, int i) {
        FindMapEntryView findMapEntryView = this.q;
        if (findMapEntryView != null) {
            findMapEntryView.checkPermissionAndJump(i, 0, 0, z);
        }
    }

    public final void E0(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", fg6.j(AppContext.getContext()) ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f(str, str2, jSONObject);
    }

    public void G0(String str, int i, boolean z, int i2, int i3) {
        if (TextUtils.isEmpty(str) || this.n == null || this.g == null) {
            return;
        }
        if (i == 81) {
            i = 4;
        } else if (i == 43) {
            i = p0() instanceof RecommendNearByFragment ? 3 : p0() instanceof NearByFragment ? 2 : 1;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.n.size()) {
                i4 = 0;
                break;
            } else if (this.n.get(i4).d.equals(str)) {
                break;
            } else {
                i4++;
            }
        }
        this.g.selectedTargetItem(i4, true);
        if ((p0() instanceof OnlineRecommend) && i3 == 1) {
            ((OnlineRecommend) p0()).C1();
        }
        if (z && uj5.a()) {
            this.q.checkPermissionAndJump(i, 0, i2);
        }
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void H0() {
        to2 to2VarP0 = p0();
        if ((to2VarP0 instanceof NearByFragment) && !(to2VarP0 instanceof QualityFriendshipFragment) && da3.b().a(DialogScene.VIP_SELECT)) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_find_friend_filter_guide, (ViewGroup) null);
            final MaterialDialog materialDialogE = new sd3(getContext()).p(viewInflate, false).c(0).b(true).e();
            AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R.id.positive_btn);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) viewInflate.findViewById(R.id.negative_btn);
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.iv_ffriend_guide_ic);
            FindFriendFilterGuideConfig findFriendFilterGuideConfigI = ai5.k().i();
            if (!TextUtils.isEmpty(findFriendFilterGuideConfigI.getPopupBgUrl())) {
                a46.u(findFriendFilterGuideConfigI.getPopupBgUrl(), appCompatImageView, R.drawable.ic_ffriend_guide_pop);
            }
            appCompatTextView.setText(findFriendFilterGuideConfigI.getPositiveText());
            appCompatTextView2.setText(findFriendFilterGuideConfigI.getNegativeText());
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: wv1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f21808a.x0(materialDialogE, view);
                }
            });
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: xv1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FindFriendFragment.y0(materialDialogE, view);
                }
            });
            materialDialogE.show();
            qj5.j0("ffriend_popup_show", null);
        }
    }

    public final void I0() {
        if (m0()) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.n.size()) {
                    break;
                }
                if (this.n.get(i2).d.equals("nearbyrecommend")) {
                    i = i2;
                    break;
                }
                i2++;
            }
            this.g.selectedTargetItem(i, true);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        com.zenmen.palmchat.paidservices.superexpose.b bVar = this.t;
        if (bVar != null) {
            bVar.o(z);
        }
        this.u = z;
        ma3.a(" SquareFragment setUserVisibleHint " + z, new Object[0]);
        if (z) {
            if (SAppUtil.a.b()) {
                to2 to2VarP0 = p0();
                if (to2VarP0 instanceof RecommendNearByFragment) {
                    RecommendNearByFragment recommendNearByFragment = (RecommendNearByFragment) to2VarP0;
                    e9.d().e = !recommendNearByFragment.K0();
                    if (e9.d().d) {
                        e9.d().d = false;
                        if (recommendNearByFragment.K0()) {
                            e9.d().o(getActivity());
                        }
                    }
                } else if (to2VarP0 instanceof NearByFragment) {
                    NearByFragment nearByFragment = (NearByFragment) to2VarP0;
                    e9.d().f = !nearByFragment.K0();
                    if (e9.d().d) {
                        e9.d().d = false;
                        if (nearByFragment.K0()) {
                            e9.d().o(getActivity());
                        }
                    }
                }
            }
            lj5.c().e(getActivity(), "a0081");
            this.m = UUID.randomUUID().toString().replace("-", "");
            Iterator<to2> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().u(this.m);
            }
            qj5.B(this.m);
            R0();
            FindSelectTabView findSelectTabView = this.g;
            if (findSelectTabView != null) {
                findSelectTabView.checkLineItemRedDot();
            }
        }
        B0(z);
    }

    public void K0(int i) {
        List<to2> list = this.i;
        if (list != null) {
            for (to2 to2Var : list) {
                if (to2Var instanceof NearByFragment) {
                    ((NearByFragment) to2Var).O0(i);
                }
            }
        }
    }

    public void L0() {
        if (this.u) {
            lj5.c().e(getActivity(), "a0081");
        }
    }

    public final void M0() {
        View viewInflate = View.inflate(getContext(), R.layout.dialog_square_location_permission, null);
        MaterialDialog materialDialogE = new sd3(getActivity()).p(viewInflate, false).h(true).e();
        materialDialogE.show();
        View viewFindViewById = viewInflate.findViewById(R.id.action);
        View viewFindViewById2 = viewInflate.findViewById(R.id.close);
        viewFindViewById.setOnClickListener(new c(materialDialogE));
        viewFindViewById2.setOnClickListener(new d(materialDialogE));
        materialDialogE.setOnCancelListener(new e());
    }

    public void N0(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        qj5.F("discoverleadalert_loc", "view");
        M0();
    }

    public final void O0() {
        if (dw1.l()) {
            LogUtil.d("", "tab showTabTitlePosition position " + this.l);
            FindSelectTabView findSelectTabView = this.g;
            if (findSelectTabView != null) {
                findSelectTabView.showTabTitlePosition(this.l, n0());
            }
            if (p0() instanceof MapFindNearByFragment) {
                ((MapFindNearByFragment) p0()).c1(this.q);
                try {
                    HashMap map = new HashMap();
                    map.put("report_type", "click");
                    zn6.g("pagelffriend_mapfindertab", new JSONObject(map));
                } catch (Exception unused) {
                }
            }
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void OpenSuperShowCardEvent(y84 y84Var) {
        if (l50.a() || y84Var == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(y84Var.f22162a)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(y84Var.f22162a);
            int iOptInt = jSONObject.optInt("buyScene", 0);
            int iOptInt2 = jSONObject.optInt("from", 0);
            b05.d("buyScene=" + iOptInt);
            b05.d("from=" + iOptInt2);
            Q0(iOptInt, iOptInt2);
        } catch (Exception unused) {
        }
    }

    public final void Q0(int i, int i2) {
        FindSelectTabView findSelectTabView;
        if (this.u || (findSelectTabView = this.g) != null || findSelectTabView.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.g.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            View viewInflate = View.inflate(getContext(), R.layout.dialog_superexpose_yingdao, null);
            uc3 uc3Var = new uc3(getContext(), viewInflate);
            uc3Var.show();
            if (viewInflate != null) {
                View viewFindViewById = viewInflate.findViewById(R.id.top_view);
                View viewFindViewById2 = viewInflate.findViewById(R.id.content_view);
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.width = a46.m(getContext()).x;
                layoutParams.height = (i3 + this.g.getHeight()) - a46.n(getContext());
                viewFindViewById.setLayoutParams(layoutParams);
                viewFindViewById2.setOnClickListener(new f(uc3Var, i, i2));
            }
        }
    }

    public final void R0() {
        DriftInfo driftInfo;
        if (!uj5.a()) {
            this.q.setVisibility(8);
            return;
        }
        MapFinderConfig.MainEntry mainEntry = gi5.g().main_circleentry;
        if (mainEntry != null && !mainEntry.pagelffriend_nearby_showstate) {
            this.q.setVisibility(8);
            return;
        }
        UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
        if (dw1.l() && userrecommendTabs230414Config.mapfinder.show_Switch) {
            if (p0() instanceof NearByFragment) {
                zn6.b("map_finder");
                if (((NearByFragment) p0()).o() == 49) {
                    this.q.setVisibility(0);
                    this.q.triggleBubbleShow();
                    this.q.setMapIconViewStatus(0);
                    this.q.setInfoBarStatus(8);
                    return;
                }
                if (((NearByFragment) p0()).o() == 113 && (driftInfo = ConditionHelper.getInstance().getDriftInfo()) != null && driftInfo.valid()) {
                    this.q.setVisibility(0);
                    this.q.triggleBubbleShow();
                    this.q.setMapIconViewStatus(8);
                    this.q.setInfoBarStatus(0);
                    return;
                }
            }
        } else if ((p0() instanceof NearByFragment) && ((NearByFragment) p0()).o() == 49) {
            zn6.b("map_finder");
            this.q.setVisibility(0);
            this.q.triggleBubbleShow();
            return;
        }
        this.q.setVisibility(8);
    }

    public final void S0() {
        FindSelectTabView findSelectTabView;
        to2 to2VarP0 = p0();
        if (!(to2VarP0 instanceof NearByFragment)) {
            if (!(to2VarP0 instanceof OnlineRecommend) || (findSelectTabView = this.g) == null) {
                return;
            }
            findSelectTabView.setOnlineRefreshVisible(0);
            return;
        }
        NearByFragment nearByFragment = (NearByFragment) to2VarP0;
        FindSelectTabView findSelectTabView2 = this.g;
        if (findSelectTabView2 != null) {
            findSelectTabView2.setCondIconSelected(!nearByFragment.K0());
            this.g.setCondIconEnable(nearByFragment.A0());
            boolean z = !nearByFragment.K0();
            boolean zA0 = nearByFragment.A0();
            long jI = SPUtil.f14322a.i(SPUtil.SCENE.FIND_FRIEND_TAB, "key_find_friend_filter_red_dot_show_time", 0L);
            if (!zA0 || z || System.currentTimeMillis() - jI < this.f) {
                this.g.setRedDotVisible(8);
            } else {
                this.g.setRedDotVisible(0);
            }
            this.g.setOnlineRefreshVisible(8);
            if (dw1.l() && (nearByFragment instanceof MapFindNearByFragment)) {
                DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
                if (driftInfo == null || !driftInfo.valid()) {
                    this.g.setCondIconEnable(false);
                }
            }
        }
    }

    public final void T0() {
        hw5 hw5VarN = iw5.m().n("b0001");
        ma3.a("update notice UI " + hw5VarN, new Object[0]);
        if (hw5VarN == null || !hw5VarN.j()) {
            return;
        }
        E0("pagelffriend_campaign", "view");
        zn6.j("pagemsg_noticenew", "view", new a(hw5VarN));
    }

    public final void V0() {
        FindSelectTabView findSelectTabView;
        if (!(p0() instanceof QualityFriendshipFragment) || (findSelectTabView = this.g) == null) {
            return;
        }
        findSelectTabView.setQfRedTextShow();
    }

    public final void W0() {
        this.g.showImageBg(false);
    }

    @Override // com.zenmen.square.ui.widget.FindSelectTabView.d
    public void d() {
        if (p0() instanceof NearByFragment) {
            FindSelectTabView findSelectTabView = this.g;
            if (findSelectTabView != null && findSelectTabView.getRedDotVisible() == 0) {
                this.g.setRedDotVisible(8);
            }
            SPUtil.f14322a.t(SPUtil.SCENE.FIND_FRIEND_TAB, "key_find_friend_filter_red_dot_show_time", Long.valueOf(System.currentTimeMillis()));
            qj5.i0(((NearByFragment) p0()).o() == 48 ? 1 : ((NearByFragment) p0()).o() == 49 ? 2 : ((NearByFragment) p0()).o() == 113 ? 3 : -1, this.m);
            ConditionHelper.openFilterDialog(((NearByFragment) p0()).o(), (FrameworkBaseActivity) getActivity());
            e9.d().d = true;
        }
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void d1(FindFriendCondition findFriendCondition) {
        p0().z(true);
        S0();
        this.r = true;
    }

    @Override // com.zenmen.square.ui.widget.FindSelectTabView.d
    public int f() {
        if (p0() instanceof NearByFragment) {
            return ((NearByFragment) p0()).o();
        }
        return 0;
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void j(FindFriendCondition findFriendCondition) {
        p0().z(true);
        S0();
        this.r = true;
    }

    public final void l0(String str) {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.n.size()) {
                break;
            }
            if (this.n.get(i2).d.equals(str)) {
                i = i2;
                break;
            }
            i2++;
        }
        this.g.selectedTargetItem(i, true);
    }

    public boolean m0() {
        return tg4.b(com.zenmen.palmchat.c.b(), g.g) && com.zenmen.palmchat.location.b.f(com.zenmen.palmchat.c.b());
    }

    public int n0() {
        if (p0() instanceof NearByFragment) {
            return ((NearByFragment) p0()).o();
        }
        return 48;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_find_friend_fragment_new, viewGroup, false);
        t0(viewInflate);
        ConditionHelper.getInstance().addConditionChangeListener(this);
        com.zenmen.palmchat.paidservices.superexpose.b bVar = new com.zenmen.palmchat.paidservices.superexpose.b(AppContext.getContext(), this);
        this.t = bVar;
        bVar.m(viewInflate);
        an1.c().p(this);
        return viewInflate;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ConditionHelper.getInstance().removeConditionChangeListener(this);
        iw5.m().deleteObserver(this);
        com.zenmen.palmchat.paidservices.superexpose.b bVar = this.t;
        if (bVar != null) {
            bVar.n();
        }
        an1.c().r(this);
    }

    @Override // com.zenmen.square.ui.widget.FindSelectTabView.d
    public void onItemSelected(int i) {
        this.j.setCurrentItem(i);
        this.l = i;
        S0();
        rv1.f(n0());
        if (p0() instanceof OnlineRecommend) {
            z64.s();
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.r) {
            this.r = false;
            UserProfileGuide.k(getActivity(), 3);
        }
        S0();
        V0();
        if (this.g != null && this.s != LxApiProxy.getInstance().getConfigApi().b()) {
            this.g.reBindItems(gi5.e());
            this.s = !this.s;
        }
        T0();
        A0();
    }

    public to2 p0() {
        List<to2> list = this.i;
        if (list == null || list.isEmpty() || this.l >= this.i.size()) {
            return null;
        }
        return this.i.get(this.l);
    }

    public final void r0() {
        List<qs5> list;
        String str = null;
        if (this.i.size() == 0 && (list = this.n) != null) {
            for (qs5 qs5Var : list) {
                if (str == null) {
                    str = qs5Var.c;
                }
                this.i.add((to2) Fragment.instantiate(getContext(), qs5Var.c));
            }
        }
        this.g.setHeaderViewEventListener(this);
        this.g.bindTableItems(this.n, str);
        s0();
    }

    public final void s0() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            this.i.clear();
            Iterator<Fragment> it = fragments.iterator();
            while (it.hasNext()) {
                to2 to2Var = (to2) ((Fragment) it.next());
                to2Var.i(isResumed());
                this.i.add(to2Var);
            }
        }
        this.k = new FindFriendPagerAdapter(getChildFragmentManager());
        this.j.addOnPageChangeListener(new b());
        this.j.setOffscreenPageLimit(this.i.size());
        this.j.setAdapter(this.k);
        this.g.onSelect(this.l);
        R0();
        if (jo6.h("LX-41697")) {
            I0();
        }
    }

    public final void t0(View view) {
        this.h = view;
        view.findViewById(R.id.content_layout).setPadding(0, a46.n(getContext()), 0, 0);
        this.g = (FindSelectTabView) view.findViewById(R.id.find_tab_header);
        this.p = (AppBarLayout) view.findViewById(R.id.container);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_super_expose_tip_enter);
        this.o = relativeLayout;
        this.g.setSuperExposeTipEnterContainer(relativeLayout);
        FindMapEntryView findMapEntryView = (FindMapEntryView) view.findViewById(R.id.rl_find_map_entry);
        this.q = findMapEntryView;
        findMapEntryView.setHeadView(this.g);
        this.j = (ViewPager) view.findViewById(R.id.find_friend_viewpager);
        r0();
        iw5.m().h(this, "b0001");
        W0();
    }

    public boolean u0() {
        return (p0() instanceof NearByFragment) && (((NearByFragment) p0()).o() == 75 || ((NearByFragment) p0()).o() == 113);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (TextUtils.equals("b0001", (String) obj) && isResumed() && isVisible()) {
            T0();
        }
    }

    @Override // com.zenmen.square.ui.widget.FindSelectTabView.d
    public void v() {
        if (p0() instanceof OnlineRecommend) {
            ((OnlineRecommend) p0()).F1();
        }
    }

    public void w0() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getContext().getPackageName(), null));
        startActivity(intent);
    }

    public void x() {
        this.p.setExpanded(true, false);
        Iterator<to2> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().x();
        }
    }

    @Override // com.zenmen.find.ConditionHelper.a
    public void z0() {
        l0((dw1.l() && UserrecommendTabs230414Config.getUserrecommendTabs230414Config().mapfinder.show_Switch) ? "mapfinder" : "nearbyrecommend");
        p0().z(true);
        S0();
        this.r = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FindFriendFragment.this.l = i;
            FindFriendFragment.this.g.onSelect(i);
            FindFriendFragment.this.S0();
            if (FindFriendFragment.this.p0() instanceof NearByFragment) {
                if (FindFriendFragment.this.t != null) {
                    FindFriendFragment.this.t.s();
                    FindFriendFragment.this.t.z(1);
                }
                rv1.f(FindFriendFragment.this.n0());
            }
            FindFriendFragment.this.R0();
            FindFriendFragment.this.O0();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }
}
