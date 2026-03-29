package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.maintab.CellUpdateEvent;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.AbsCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.mine.NewMineFragment;
import com.zenmen.palmchat.sync.MyTabOfFriendTabConfig;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.SquareMessageActivity;
import com.zenmen.square.support.SquareSingleton;
import defpackage.ax4;
import defpackage.hp3;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class r65 extends AbsCellViewController implements View.OnClickListener {
    public static hp3.g M;
    public Handler L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20399a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public View m;
    public View n;
    public Activity o;
    public Map<String, String> p;
    public int q;
    public long r;
    public ViewGroup s = null;
    public ViewGroup t = null;
    public EffectiveShapeView u = null;
    public EffectiveShapeView v = null;
    public EffectiveShapeView w = null;
    public View x = null;
    public View y = null;
    public LinearLayout z = null;
    public ImageView A = null;
    public TextView B = null;
    public boolean C = false;
    public View E = null;
    public View F = null;
    public TextView G = null;
    public TextView H = null;
    public int I = 0;
    public boolean J = false;
    public d46 K = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends e46 {
        public a() {
        }

        @Override // defpackage.e46, defpackage.d46
        public void b(String str, String str2) {
            Log.i(AbsCellViewController.TAG, "onLookMeChange: ");
            r65.this.y(str, str2);
        }

        @Override // defpackage.d46
        public void e(int i) {
            if (r65.this.k != null) {
                r65.this.z(true);
            }
            r65.this.i();
        }

        @Override // defpackage.d46
        public void f(int i) {
            LogUtil.d(AbsCellViewController.TAG, "get praise count " + i);
            if (r65.this.k != null) {
                r65.this.z(true);
            }
            r65.this.i();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements rn {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f20402a;

            public a(Object obj) {
                this.f20402a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                hp3 hp3Var = (hp3) this.f20402a;
                r65.M = hp3Var.e();
                r65.this.p.put("vip_status", String.valueOf(hp3Var.i()));
                r65.this.m(hp3Var);
            }
        }

        public b() {
        }

        @Override // defpackage.rn
        public void run(int i, String str, Object obj) {
            if (1 != i || obj == null || r65.this.f20399a == null) {
                return;
            }
            r65.this.f20399a.post(new a(obj));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20403a;

        public c(int i) {
            this.f20403a = i;
            put("levelnew", Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(int i, int i2, int i3, int i4) {
        Activity activity = this.o;
        if (activity == null) {
            return;
        }
        if (!((activity instanceof Activity) && (activity.isFinishing() || this.o.isDestroyed())) && i3 > 0 && i4 > i3) {
            new d10(this.o, i3, i4).show();
            zn6.j("charm_update", "click", new c(i4));
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return 0;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return this.f20399a;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        syncStatusFromView();
        return super.getViewStatus();
    }

    public final void i() {
        if (np3.b() && np3.o) {
            LogUtil.d("", "MineSeeMe isRequestIng doGetData false not allow");
            return;
        }
        np3.o = true;
        LogUtil.d("", "MineSeeMe isRequestIng true doGetData start allow");
        ax4.f(new b());
    }

    public final void j() {
        if (Math.abs(System.currentTimeMillis() - this.r) < 60000) {
            return;
        }
        this.r = System.currentTimeMillis();
        ax4.m(new ax4.c() { // from class: q65
            @Override // ax4.c
            public final void a(int i, int i2, int i3, int i4) {
                this.f20187a.v(i, i2, i3, i4);
            }
        });
    }

    public final String k(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }

    public final void l() {
        try {
            ve.o(this.o, "zenxin://activity?page=a0052&pkgId=lwsyv2", false);
            ip3.c("pagemy_income_click");
            SPUtil.f14322a.t(SPUtil.SCENE.MYTAB, "key_income_enter_click_time", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public final void m(hp3 hp3Var) {
        if (hp3Var == null) {
            return;
        }
        try {
            p(hp3Var);
            n(hp3Var);
            this.g.setText(hp3Var.f());
            if (hp3Var.a() != null && hp3Var.b() != null) {
                this.f.setText(hp3Var.h());
            }
            r(hp3Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void n(hp3 hp3Var) {
        if (hp3Var == null || this.z == null || this.c == null) {
            return;
        }
        if (!q42.a()) {
            this.z.setVisibility(8);
            this.c.setVisibility(0);
            return;
        }
        this.z.setVisibility(0);
        this.c.setVisibility(8);
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(hp3Var.g());
        }
        long jI = SPUtil.f14322a.i(SPUtil.SCENE.MYTAB, "key_income_enter_click_time", 0L);
        if (is2.f18251a != 1 || System.currentTimeMillis() - jI <= ((long) is2.b) * 60 * 1000) {
            this.A.setVisibility(8);
        } else {
            this.A.setVisibility(0);
        }
    }

    public final void o() {
        View view = this.f20399a;
        if (view != null) {
            this.z = (LinearLayout) view.findViewById(R.id.mine_self_income_container);
            this.A = (ImageView) this.f20399a.findViewById(R.id.mine_self_income_pop);
            this.B = (TextView) this.f20399a.findViewById(R.id.mine_self_income_mub);
            this.z.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TeenagersModeManager.a().d()) {
            ry5.a("青少年模式下暂不支持使用");
        }
        switch (view.getId()) {
            case R.id.mine_self_friend_relayout /* 2131365959 */:
                if (!l50.a() && this.fragment.getActivity() != null) {
                    Intent intent = new Intent(this.fragment.getActivity(), (Class<?>) ContactActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("source_tab_tag", MainTabsActivity.y2());
                    intent.putExtras(bundle);
                    this.fragment.getActivity().startActivity(intent);
                    new lt3(AppContext.getContext()).q(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE);
                    zn6.c("pagemy_friend", "click");
                    break;
                }
                break;
            case R.id.mine_self_gift_relayout /* 2131365964 */:
                if (!l50.a()) {
                    Uri.Builder builderBuildUpon = Uri.parse(tj2.i("/receive-gift/#/")).buildUpon();
                    String strP = AccountUtils.p(this.o);
                    ContactInfoItem contactInfoItemL = bo0.r().l(strP);
                    builderBuildUpon.appendQueryParameter(DeviceInfoUtil.UID_TAG, strP);
                    builderBuildUpon.appendQueryParameter("fuid", strP);
                    builderBuildUpon.appendQueryParameter("nickname", contactInfoItemL.getNickName());
                    builderBuildUpon.appendQueryParameter("gender", contactInfoItemL.getGender() + "");
                    builderBuildUpon.appendQueryParameter("vipStatus", fg6.g(contactInfoItemL.getExt()) + "");
                    builderBuildUpon.appendQueryParameter(LxAdDLManager.ITEM_ICONURL, k(contactInfoItemL));
                    Intent intent2 = new Intent();
                    intent2.setClass(this.o, CordovaWebActivity.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("web_url", builderBuildUpon.toString());
                    bundle2.putBoolean("web_show_right_menu", false);
                    bundle2.putBoolean("hide_toolbar", true);
                    bundle2.putBoolean("hide_progressbar", true);
                    intent2.putExtras(bundle2);
                    this.o.startActivity(intent2);
                    ip3.c("pagemy_update_gift");
                }
                break;
            case R.id.mine_self_income_container /* 2131365967 */:
                if (!l50.a()) {
                    l();
                }
                break;
            case R.id.mine_self_like_me_relayout /* 2131365978 */:
                if (!l50.a()) {
                    w();
                }
                break;
            case R.id.mine_self_look_me_relayout /* 2131365986 */:
                if (!l50.a()) {
                    go.k(MyTabOfFriendTabConfig.SP_LOOK_ME_VALUE, false);
                    ip3.b("pagemy_update_seeme", "click", this.p);
                    kb3.a(this.o, "wseem", "mytab", false);
                }
                break;
            case R.id.mine_self_praise_comment_relayout /* 2131365991 */:
                if (!l50.a()) {
                    Intent intent3 = new Intent(this.o, (Class<?>) SquareMessageActivity.class);
                    intent3.putExtra("key_page", "a0401");
                    this.fragment.getActivity().startActivity(intent3);
                    ip3.c("pagemy_update_thumbup");
                }
                break;
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        SquareSingleton.getInstance().registerCountChangeListener(this.K);
        FragmentActivity activity = dynamicConfigFragment.getActivity();
        this.o = activity;
        this.f20399a = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.layout_fragment_mine_self_info, (ViewGroup) null);
        t();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        SquareSingleton.getInstance().unRegisterCountChangeListener(this.K);
        Handler handler = this.L;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.L = null;
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        i();
        j();
        x();
    }

    public final void p(hp3 hp3Var) {
        TextView textView;
        if (hp3Var == null) {
            return;
        }
        try {
            boolean zJ = hp3Var.j();
            this.C = zJ;
            if (!zJ) {
                View view = this.E;
                if (view == null || this.b == null) {
                    return;
                }
                view.setVisibility(8);
                this.b.setVisibility(0);
                return;
            }
            View view2 = this.E;
            if (view2 != null && this.b != null) {
                view2.setVisibility(0);
                this.b.setVisibility(8);
            }
            hp3.e eVarC = hp3Var.c();
            if (eVarC != null && (textView = this.G) != null && this.F != null && this.H != null) {
                textView.setText(eVarC.a());
                this.y.setVisibility(8);
                if ("0".equals(eVarC.a())) {
                    this.F.setVisibility(8);
                    this.H.setVisibility(8);
                    return;
                }
                String strB = eVarC.b();
                if (TextUtils.isEmpty(strB)) {
                    if (go.c(MyTabOfFriendTabConfig.SP_LIKE_ME_VALUE, true)) {
                        this.F.setVisibility(0);
                    } else {
                        this.F.setVisibility(8);
                    }
                    this.H.setVisibility(8);
                    this.I = 0;
                } else {
                    int i = Integer.parseInt(strB);
                    this.I = i;
                    if (i > 99) {
                        this.F.setVisibility(8);
                        this.H.setVisibility(0);
                        this.H.setText("99");
                        this.y.setVisibility(0);
                    } else if (i > 0) {
                        this.F.setVisibility(8);
                        this.H.setVisibility(0);
                        this.H.setText(strB);
                    } else {
                        if (go.c(MyTabOfFriendTabConfig.SP_LIKE_ME_VALUE, true)) {
                            this.F.setVisibility(0);
                        } else {
                            this.F.setVisibility(8);
                        }
                        this.H.setVisibility(8);
                        this.I = 0;
                    }
                }
                ds0.a().b(CellUpdateEvent.produceEvent(7, null));
            }
        } catch (Exception unused) {
        }
    }

    public final void q() {
        View view = this.f20399a;
        if (view != null) {
            this.E = view.findViewById(R.id.mine_self_like_me_relayout);
            this.F = this.f20399a.findViewById(R.id.mine_self_like_me_red);
            this.G = (TextView) this.f20399a.findViewById(R.id.mine_self_like_me_num);
            this.H = (TextView) this.f20399a.findViewById(R.id.mine_self_like_me_red_count);
            this.E.setOnClickListener(this);
            this.y = this.f20399a.findViewById(R.id.mine_self_like_me_red_count_plus);
        }
    }

    public final void r(hp3 hp3Var) {
        if (hp3Var.d() != null) {
            np3.e(this.u, this.v, this.w);
            this.h.setText(hp3Var.d().a());
            if ("0".equals(hp3Var.d().a())) {
                this.m.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                String strB = hp3Var.d().b();
                if (TextUtils.isEmpty(strB)) {
                    if (go.c(MyTabOfFriendTabConfig.SP_LOOK_ME_VALUE, true)) {
                        this.m.setVisibility(0);
                        this.i.setVisibility(8);
                    } else {
                        this.m.setVisibility(8);
                        this.i.setVisibility(8);
                    }
                    this.q = 0;
                } else {
                    this.q = Integer.parseInt(strB);
                    this.x.setVisibility(8);
                    int i = this.q;
                    if (i > 99) {
                        this.m.setVisibility(8);
                        this.i.setVisibility(0);
                        this.i.setText("99");
                        this.x.setVisibility(0);
                    } else if (i > 0) {
                        this.m.setVisibility(8);
                        this.i.setVisibility(0);
                        this.i.setText(strB);
                        LogUtil.d("", "MineSeeMeAAA initSeeMeData unReadCount " + strB);
                    } else {
                        if (go.c(MyTabOfFriendTabConfig.SP_LOOK_ME_VALUE, true)) {
                            this.m.setVisibility(0);
                            this.i.setVisibility(8);
                        } else {
                            this.m.setVisibility(8);
                            this.i.setVisibility(8);
                        }
                        this.q = 0;
                    }
                }
                np3.k = this.q;
                ds0.a().b(CellUpdateEvent.produceEvent(7, null));
            }
            np3.i();
        }
    }

    public final void s() {
        this.u = (EffectiveShapeView) this.f20399a.findViewById(R.id.head_img1);
        this.v = (EffectiveShapeView) this.f20399a.findViewById(R.id.head_img2);
        this.w = (EffectiveShapeView) this.f20399a.findViewById(R.id.head_img3);
        this.u.setBorderColor(-1);
        this.v.setBorderColor(-1);
        this.w.setBorderColor(-1);
        View viewFindViewById = this.f20399a.findViewById(R.id.mine_self_look_me_red_count_plus);
        this.x = viewFindViewById;
        np3.j = viewFindViewById;
        EffectiveShapeView effectiveShapeView = this.u;
        np3.e = effectiveShapeView;
        EffectiveShapeView effectiveShapeView2 = this.v;
        np3.f = effectiveShapeView2;
        EffectiveShapeView effectiveShapeView3 = this.w;
        np3.g = effectiveShapeView3;
        np3.e(effectiveShapeView, effectiveShapeView2, effectiveShapeView3);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        if (z) {
            i();
            j();
            ip3.d("pagemy_update_thumbup");
            ip3.d("pagemy_update_gift");
            ip3.b("pagemy_update_seeme", "view", this.p);
        }
    }

    public final void syncStatusFromView() {
        View view;
        View view2;
        TextView textView;
        b05.a("小红点syncStatusFromView()=====》" + this.status.f1127a);
        if (this.i.getVisibility() == 0 || (this.C && (textView = this.H) != null && textView.getVisibility() == 0)) {
            this.status.f1127a = this.I + this.q;
            return;
        }
        if ((this.k.getVisibility() != 0 || this.b.getVisibility() != 0) && ((this.m.getVisibility() != 0 || this.d.getVisibility() != 0) && ((this.e.getVisibility() != 0 || this.n.getVisibility() != 0) && (!this.C || (view = this.F) == null || view.getVisibility() != 0 || this.E.getVisibility() != 0)))) {
            this.status.f1127a = 0;
            return;
        }
        this.status.f1127a = -1;
        if (this.k.getVisibility() == 0) {
            b05.a("小红点mCommentPraiseVw.getVisibility() == View.VISIBLE");
        }
        if (this.m.getVisibility() == 0) {
            b05.a(" 小红点mLookMeVw.getVisibility()==View.VISIBLE");
        }
        if (this.C && (view2 = this.F) != null && view2.getVisibility() == 0) {
            b05.a("小红点(mShowLikeMe && mLikeMeRed != null && mLikeMeRed.getVisibility() == View.VISIBLE)");
        }
    }

    public final void t() {
        this.f20399a.findViewById(R.id.contentLayout);
        RelativeLayout relativeLayout = (RelativeLayout) this.f20399a.findViewById(R.id.mine_self_friend_relayout);
        this.e = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.j = (TextView) this.f20399a.findViewById(R.id.mine_self_friend_mub);
        this.n = this.f20399a.findViewById(R.id.mine_self_friend_red);
        this.e.setVisibility(u() ? 0 : 8);
        this.b = (RelativeLayout) this.f20399a.findViewById(R.id.mine_self_praise_comment_relayout);
        this.c = (RelativeLayout) this.f20399a.findViewById(R.id.mine_self_gift_relayout);
        this.d = (RelativeLayout) this.f20399a.findViewById(R.id.mine_self_look_me_relayout);
        this.s = (ViewGroup) this.f20399a.findViewById(R.id.mine_self_seemme_new_img_layout);
        this.t = (ViewGroup) this.f20399a.findViewById(R.id.mine_self_look_me_layout);
        s();
        np3.c(this.s);
        this.f = (TextView) this.f20399a.findViewById(R.id.mine_self_praise_comment_mub);
        this.g = (TextView) this.f20399a.findViewById(R.id.mine_self_gift_mub);
        this.h = (TextView) this.f20399a.findViewById(R.id.mine_self_look_me_mub);
        this.k = this.f20399a.findViewById(R.id.mine_self_praise_comment_red);
        this.l = this.f20399a.findViewById(R.id.mine_self_gift_red);
        this.m = this.f20399a.findViewById(R.id.mine_self_look_me_red);
        TextView textView = (TextView) this.f20399a.findViewById(R.id.mine_self_look_me_red_count);
        this.i = textView;
        np3.h = this.t;
        np3.i = textView;
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        HashMap map = new HashMap();
        this.p = map;
        map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(AppContext.getContext()));
        this.p.put(DeviceInfoUtil.DEVICEID_TAG, ac1.h);
        q();
        o();
        x();
    }

    public final boolean u() {
        DynamicConfigFragment dynamicConfigFragment = this.fragment;
        if (dynamicConfigFragment instanceof NewMineFragment) {
            return ((NewMineFragment) dynamicConfigFragment).o;
        }
        return false;
    }

    public final void w() {
        try {
            go.k(MyTabOfFriendTabConfig.SP_LIKE_ME_VALUE, false);
            ip3.b("pagemy_update_likeme", "click", this.p);
            ve.o(this.o, "zenxin://activity?page=a0052&pkgId=lkme", false);
            zn6.b("page_my_user_detail_likeme");
        } catch (Exception unused) {
        }
    }

    public final void x() {
        if (u()) {
            this.j.setText(String.valueOf(bo0.r().k()));
            lt3 lt3Var = new lt3(AppContext.getContext());
            this.n.setVisibility(lt3Var.n() > 0 || lt3Var.f(MyTabOfFriendTabConfig.SP_MYFRIENDS_VALUE) ? 0 : 8);
        }
    }

    public final void y(String str, String str2) {
        TextView textView = this.h;
        if (textView == null || this.i == null) {
            return;
        }
        textView.setText(str);
        if ("0".equals(str)) {
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            this.i.setVisibility(8);
            this.q = 0;
        } else {
            int i = Integer.parseInt(str2);
            this.q = i;
            if (i > 99) {
                this.m.setVisibility(8);
                this.i.setVisibility(0);
                this.i.setText("99+");
            } else if (i > 0) {
                this.m.setVisibility(8);
                this.i.setVisibility(0);
                this.i.setText(str2);
            } else {
                this.i.setVisibility(8);
                this.q = 0;
            }
        }
        ds0.a().b(CellUpdateEvent.produceEvent(7, null));
    }

    public final void z(boolean z) {
        this.k.setVisibility(SquareSingleton.getInstance().getLastCommentUnReadCount() + SquareSingleton.getInstance().getLastPraiseUnReadCount() > 0 ? 0 : 8);
        if (z) {
            ds0.a().b(CellUpdateEvent.produceEvent(7, null));
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public void updateViewStatus(a00 a00Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onPause() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
