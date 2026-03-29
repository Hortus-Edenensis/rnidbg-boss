package com.zenmen.palmchat.maintab.cell;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.a;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.mine.NewMineFragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.a00;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bo0;
import defpackage.fg6;
import defpackage.gk4;
import defpackage.js2;
import defpackage.l50;
import defpackage.m66;
import defpackage.nb3;
import defpackage.nx3;
import defpackage.q05;
import defpackage.rk4;
import defpackage.rw0;
import defpackage.uk5;
import defpackage.zn6;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AbsCellViewController implements View.OnClickListener {
    public static int z = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14612a;
    public ContactInfoItem b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public LXPortraitView k;
    public RelativeLayout l;
    public View m;
    public View n;
    public TextView o;
    public ImageView p;
    public ImageView q;
    public Animation r;
    public View s;
    public int t;
    public Activity u;
    public AnimatorSet v;
    public SLightingAnimationView w;
    public Handler x = new Handler(Looper.getMainLooper());
    public int y = 2;

    /* JADX INFO: compiled from: SearchBox */
    public class d implements fg6.b {
        public d() {
        }

        @Override // fg6.b
        public void onFail(Exception exc) {
            LogUtil.i("getVip", "onFail: " + exc.getMessage());
        }

        @Override // fg6.b
        public void onSuccess(int i) {
            a.this.j.setVisibility(0);
            boolean z = i >= 0;
            if (i == 1) {
                a.this.j.setImageDrawable(a.this.u.getResources().getDrawable(R.drawable.selector_icon_svip));
            } else {
                a.this.j.setImageDrawable(a.this.u.getResources().getDrawable(R.drawable.selector_icon_vip));
            }
            a.this.j.setSelected(!z);
            if (z || (a.this.b != null && a.this.b.isOfficialAccount())) {
                a.this.e.setTextColor(a.this.u.getResources().getColor(R.color.Gg));
            } else {
                a.this.e.setTextColor(a.this.u.getResources().getColor(R.color.Gb));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14617a;

        public e(boolean z) {
            this.f14617a = z;
            put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, Integer.valueOf(z ? 2 : 1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return 0;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return this.c;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public a00 getViewStatus() {
        return super.getViewStatus();
    }

    public final void k() {
        Animation animation = this.r;
        if (animation != null) {
            animation.setAnimationListener(new c());
        }
        this.p.clearAnimation();
    }

    public final int l(ContactInfoItem contactInfoItem) {
        try {
            return Integer.valueOf(contactInfoItem.getAge()).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final String m() {
        try {
            final LocationEx locationExI = q05.i();
            b05.c(new b05.a() { // from class: p65
                @Override // b05.a
                public final Object getValue() {
                    return a.t(locationExI);
                }
            });
            if (locationExI == null) {
                return "";
            }
            String realCityName = locationExI.getRealCityName();
            return !TextUtils.isEmpty(realCityName) ? n(realCityName) : "";
        } catch (Exception unused) {
            b05.a("获取历史位置信息失败");
            return "";
        }
    }

    public final String n(String str) {
        return TextUtils.isEmpty(str) ? "" : str.endsWith("市") ? str.substring(0, str.length() - 1) : str;
    }

    public final String o(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == z) {
            b05.d("onActivityResult====>initData()");
            p(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.homepage_wrapper /* 2131364246 */:
            case R.id.mine_head_group_layout /* 2131365941 */:
                s(false);
                LogUtil.uploadInfoImmediate(BaseWrapper.ENTER_ID_OAPS_RECENTS, "1", null, null);
                boolean z2 = this.m.getVisibility() == 0;
                zn6.j("pagemy_tag_infor", "click", new e(z2));
                if (z2) {
                    com.zenmen.palmchat.settings.b.c().a(1);
                    this.m.setVisibility(8);
                }
                if (this.n.getVisibility() == 0) {
                    com.zenmen.palmchat.settings.b.c().a(64);
                    this.n.setVisibility(8);
                }
                break;
            case R.id.iv_vip /* 2131364644 */:
                u();
                Activity activity = this.u;
                ap3.r(activity, "1", fg6.d(activity) ? "1" : "0");
                break;
            case R.id.mine_head_portrait /* 2131365946 */:
                zn6.b("profile_amulet_mytab");
                nx3.e("key_amulet_mytab_bubble");
                rk4.d(this.u, 1, null, 1, -1, -1);
                break;
            case R.id.user_info_sub_wallet /* 2131368184 */:
                if (!l50.a()) {
                    zn6.c("pagemy_postopnav_btnwallet", "click");
                    LogUtil.uploadInfoImmediate("qb1", null, null, null);
                    nx3.e("key_wallet_new");
                    nb3.j(this.u);
                    SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_wallet_activity_click", new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss").format(new Date()));
                }
                break;
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        FragmentActivity activity = dynamicConfigFragment.getActivity();
        this.u = activity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.layout_fragment_mine_head, (ViewGroup) null);
        this.c = relativeLayout;
        this.l = (RelativeLayout) relativeLayout.findViewById(R.id.mine_head_group_layout);
        this.q = (ImageView) this.c.findViewById(R.id.amuletGuide);
        this.w = (SLightingAnimationView) this.c.findViewById(R.id.anim_view);
        this.d = (TextView) this.c.findViewById(R.id.mine_head_des);
        this.f = (TextView) this.c.findViewById(R.id.mine_head_age);
        this.g = (TextView) this.c.findViewById(R.id.mine_head_area);
        this.e = (TextView) this.c.findViewById(R.id.mine_head_name);
        this.j = (ImageView) this.c.findViewById(R.id.iv_vip);
        this.s = this.c.findViewById(R.id.homepage_wrapper);
        this.i = (ImageView) this.c.findViewById(R.id.mine_head_gender);
        this.k = (LXPortraitView) this.c.findViewById(R.id.mine_head_portrait);
        this.m = this.c.findViewById(R.id.homepage_reddot);
        this.n = this.c.findViewById(R.id.mine_head_homepage_dot);
        this.o = (TextView) this.c.findViewById(R.id.mine_head_homepage);
        this.s.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(R.id.tv_official);
        this.p = (ImageView) this.c.findViewById(R.id.red_icon);
        q();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        k();
        AnimatorSet animatorSet = this.v;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        Iterator<Animator> it = this.v.getChildAnimations().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.v.cancel();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        b05.d("onResume()===>initData()");
        p(false);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        int i = uk5Var.f21235a;
        if (i == 52) {
            this.x.post(new f());
        } else if (i == 53) {
            x();
        }
    }

    public final void p(boolean z2) {
        this.f14612a = AccountUtils.p(AppContext.getContext());
        ContactInfoItem contactInfoItemL = bo0.r().l(this.f14612a);
        this.b = contactInfoItemL;
        if (contactInfoItemL == null) {
            return;
        }
        this.k.setAvatarView(o(contactInfoItemL), this.b.getAmulet());
        this.k.setOnClickListener(this);
        this.e.setText(this.b.getNickName());
        String strM = m();
        int iL = l(this.b);
        this.t = iL;
        if (iL > 0 && !TextUtils.isEmpty(strM)) {
            strM = this.t + "岁  ·  " + strM;
        } else if (this.t > 0) {
            strM = this.t + "岁";
        } else if (TextUtils.isEmpty(strM)) {
            strM = "";
        }
        this.f.setText(strM);
        this.i.setVisibility(0);
        if (this.b.getGender() == 1) {
            this.i.setImageResource(R.drawable.square_gender_female_26);
        } else if (this.b.getGender() == 0) {
            this.i.setImageResource(R.drawable.square_gender_male_26);
        } else {
            this.i.setVisibility(8);
        }
        if (this.b.isOfficialAccount()) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        int iG = fg6.g(this.b.getExt());
        if (fg6.d(this.u)) {
            this.j.setImageDrawable(this.u.getResources().getDrawable(R.drawable.selector_icon_svip));
            this.j.setSelected(false);
        } else if (fg6.q(iG)) {
            this.j.setImageResource(fg6.e(iG));
            this.j.setSelected(false);
        } else {
            this.j.setImageDrawable(this.u.getResources().getDrawable(R.drawable.selector_icon_vip));
            this.j.setSelected(true);
        }
        this.j.setVisibility(0);
        if (fg6.d(this.u) || fg6.q(iG) || this.b.isOfficialAccount()) {
            this.e.setTextColor(this.u.getResources().getColor(R.color.Gg));
        } else {
            this.e.setTextColor(this.u.getResources().getColor(R.color.Gb));
        }
        if (TextUtils.isEmpty(this.b.getSignature())) {
            this.d.setText(R.string.no_signature);
        } else {
            this.d.setText(this.b.getSignature());
        }
        x();
        if (m66.f()) {
            this.n.setVisibility(com.zenmen.palmchat.settings.b.c().d(64) ? 0 : 8);
        } else {
            this.m.setVisibility(com.zenmen.palmchat.settings.b.c().d(1) ? 0 : 8);
        }
        if (m66.f()) {
            this.o.setText(m66.b());
        }
        this.l.setOnClickListener(this);
        if (this.b.hasAmulet()) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            if (rw0.b()) {
                this.q.setImageResource(R.drawable.ic_amulet_head_guide_mall);
                if (z2) {
                    v(this.q);
                }
            } else {
                this.q.setImageResource(R.drawable.ic_amulet_head_guide);
            }
        }
        w();
    }

    public final void q() {
        if (!r()) {
            this.c.findViewById(R.id.user_info_sub_layout).setVisibility(0);
            this.c.findViewById(R.id.user_info_sub_layout2).setVisibility(8);
            this.c.findViewById(R.id.homepage_wrapper).setVisibility(0);
        } else {
            this.c.findViewById(R.id.user_info_sub_layout).setVisibility(8);
            this.c.findViewById(R.id.user_info_sub_layout2).setVisibility(0);
            this.c.findViewById(R.id.homepage_wrapper).setVisibility(8);
            this.c.findViewById(R.id.user_info_sub_wallet).setOnClickListener(this);
        }
    }

    public final boolean r() {
        DynamicConfigFragment dynamicConfigFragment = this.fragment;
        if (dynamicConfigFragment instanceof NewMineFragment) {
            return ((NewMineFragment) dynamicConfigFragment).o;
        }
        return false;
    }

    public final void s(boolean z2) {
        Intent intent = new Intent(this.u, (Class<?>) m66.c());
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(this.f14612a);
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", 35);
        if (z2 && gk4.e()) {
            intent.putExtra("extra_auto_polish", true);
        }
        this.fragment.getActivity().startActivityForResult(intent, z);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z2) {
        if (z2) {
            b05.d("setUserVisibleHint===>initData()");
            p(z2);
        }
    }

    public void u() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("vip_status", this.j.isSelected() ? 0 : 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.d("pagemy_top_vip", null, jSONObject.toString());
    }

    public final void v(View view) {
        AnimatorSet animatorSet = this.v;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.y = 2;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.7f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.7f);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat2.setDuration(500L);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.0f);
            objectAnimatorOfFloat3.setDuration(500L);
            objectAnimatorOfFloat4.setDuration(500L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.v = animatorSet4;
            animatorSet4.playSequentially(animatorSet2, animatorSet3);
            this.v.addListener(new C1073a());
            b05.d("开始动画" + this.y);
            this.v.start();
        }
    }

    public final void w() {
        if (this.p == null) {
            return;
        }
        if (!js2.m() || !js2.l()) {
            if (this.p.getVisibility() == 8) {
                return;
            }
            k();
            this.p.setVisibility(8);
            return;
        }
        if (this.p.getVisibility() == 0) {
            return;
        }
        this.p.setVisibility(0);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.u, R.anim.main_mine_cell_header_redicon);
        this.r = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(new b());
        this.p.startAnimation(this.r);
        js2.i();
    }

    public final void x() {
        fg6.i(AppContext.getContext(), new d());
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.maintab.cell.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1073a implements Animator.AnimatorListener {
        public C1073a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b05.d("onAnimationEnd" + a.this.y);
            if (a.this.y == 0) {
                b05.d("开始放光");
                a.this.w.startLightingAnimation(0);
            }
            if (a.this.y > 0) {
                a aVar = a.this;
                aVar.y--;
                a.this.v.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.p.startAnimation(a.this.r);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static /* synthetic */ Object t(LocationEx locationEx) {
        return locationEx;
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
}
