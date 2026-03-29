package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.bean.ContactLoveBean;
import com.zenmen.palmchat.contacts.userdetail.polish.PolishView;
import com.zenmen.palmchat.contacts.widget.UserDetailEnergyView;
import com.zenmen.palmchat.contacts.widget.UserDetailLevelView;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import defpackage.a65;
import defpackage.ai5;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bj5;
import defpackage.bo0;
import defpackage.ch;
import defpackage.db1;
import defpackage.f74;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.gr2;
import defpackage.gs2;
import defpackage.hc2;
import defpackage.hs0;
import defpackage.ik4;
import defpackage.il5;
import defpackage.io0;
import defpackage.jo6;
import defpackage.js2;
import defpackage.jw5;
import defpackage.l50;
import defpackage.nl0;
import defpackage.nn4;
import defpackage.nx3;
import defpackage.q05;
import defpackage.rk4;
import defpackage.tj2;
import defpackage.tn0;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.v4;
import defpackage.v8;
import defpackage.ve;
import defpackage.xn3;
import defpackage.y66;
import defpackage.zn6;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class e implements View.OnClickListener, f74 {
    public TextView A;
    public p A0;
    public View B;
    public TextView C;
    public Handler C0;
    public TextView E;
    public uo2 E0;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public ViewGroup I0;
    public View J;
    public ImageView J0;
    public TextView K;
    public RelativeLayout K0;
    public View L;
    public ImageView L0;
    public TextView M;
    public TextView M0;
    public TextView N;
    public View N0;
    public View O;
    public TextView O0;
    public TextView P;
    public TextView P0;
    public TextView Q;
    public TextView Q0;
    public TextView R;
    public int R0;
    public TextView S;
    public TextView T;
    public View U;
    public TextView V;
    public View W;
    public UserDetailLevelView X;
    public UserDetailLevelView Y;
    public UserDetailEnergyView Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13573a;
    public AppBarLayout c;
    public Toolbar d;
    public Toolbar e;
    public com.zenmen.palmchat.contacts.userdetail.a e0;
    public NestedScrollView f;
    public com.zenmen.palmchat.contacts.userdetail.b f0;
    public View g;
    public ik4 g0;
    public TextView h;
    public TextView h0;
    public ImageView i;
    public View i0;
    public ImageView j;
    public TextView j0;
    public ImageView k;
    public UserDetailActivity k0;
    public TextView l;
    public ContactInfoItem l0;
    public TextView m;
    public int m0;
    public TextView n;
    public String n0;
    public TextView o;
    public String o0;
    public LXPortraitView p;
    public String p0;
    public View q;
    public String q0;
    public View r;
    public int r0;
    public ArrayList<TextView> s;
    public String s0;
    public ImageView t;
    public String t0;
    public TextView u;
    public SquareFeed u0;
    public TextView v;
    public View w;
    public TextView x;
    public float x0;
    public TextView y;
    public float y0;
    public TextView z;
    public boolean b = false;
    public boolean v0 = false;
    public boolean w0 = true;
    public int z0 = 0;
    public boolean B0 = false;
    public boolean D0 = false;
    public boolean F0 = false;
    public boolean G0 = false;
    public boolean H0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends tw4<CommonResponse<SquareDynamicLifeResponseBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13574a;

        public a(ContactInfoItem contactInfoItem) {
            this.f13574a = contactInfoItem;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareDynamicLifeResponseBean> commonResponse) {
            if (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().errorCode != -1003) {
                b05.d("请求没有结果不管");
                e.this.e0.q(this.f13574a);
            } else {
                b05.d("是黑名单");
                e.this.e0.l();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, String> {
        public b() {
            put("fuid", e.this.l0.getUid());
            put("type", "alert");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {
        public c() {
            put("targetuid", e.this.l0.getUid());
        }
    }

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
            if (i < 0) {
                e.this.h.setTextColor(e.this.k0.getResources().getColor(R.color.Gb));
                return;
            }
            if (i == 0) {
                e.this.i.setImageDrawable(e.this.k0.getResources().getDrawable(R.drawable.selector_icon_vip));
            } else {
                e.this.i.setImageDrawable(e.this.k0.getResources().getDrawable(R.drawable.selector_icon_svip));
            }
            e.this.i.setVisibility(0);
            e.this.h.setTextColor(e.this.k0.getResources().getColor(R.color.Gg));
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1025e implements View.OnClickListener {
        public ViewOnClickListenerC1025e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.r(e.this.k0, "7", fg6.d(e.this.k0) ? "1" : "0");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends HashMap<String, Object> {
        public f() {
            put("targetuid", e.this.l0.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements NestedScrollView.OnScrollChangeListener {
        public g() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Log.i("UserDetailViewHelper", "onScrollChange: " + i + "  " + i2 + " " + i3 + "  " + i4);
            if (i2 == 0) {
                e.this.i0.setVisibility(0);
            } else {
                e.this.i0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivity f13581a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("target_uid", e.this.l0.getChatId());
            }
        }

        public h(UserDetailActivity userDetailActivity) {
            this.f13581a = userDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("profile_amulet_other", "click", new a());
            nx3.e("key_amulet_mytab_profile_bubble" + e.this.l0.getChatId());
            rk4.d(this.f13581a, 3, null, 1, -1, -1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.q(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js2.g();
            e.this.q(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.q(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.q(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivity f13587a;

        public m(UserDetailActivity userDetailActivity) {
            this.f13587a = userDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13587a.M2(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements gs2.b {
        public n() {
        }

        @Override // gs2.b
        public void a() {
            e.this.W(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends HashMap<String, Object> {
        public o() {
            put("target_uid", e.this.l0.getChatId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface p {
        void b();

        void c();

        void e();

        void f();

        void n0();
    }

    public e(UserDetailActivity userDetailActivity, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, p pVar, Handler handler, boolean z, int i4, SquareFeed squareFeed, int i5) {
        this.k0 = userDetailActivity;
        this.m0 = i2;
        this.n0 = str;
        this.o0 = str2;
        this.A0 = pVar;
        this.p0 = str3;
        this.r0 = i3;
        this.q0 = str4;
        this.s0 = str5;
        this.t0 = str6;
        this.u0 = squareFeed;
        this.R0 = i5;
        this.c = (AppBarLayout) userDetailActivity.findViewById(R.id.app_bar);
        this.d = (Toolbar) userDetailActivity.findViewById(R.id.toolbar);
        this.e = (Toolbar) userDetailActivity.findViewById(R.id.toolbar2);
        NestedScrollView nestedScrollView = (NestedScrollView) userDetailActivity.findViewById(R.id.scroll);
        this.f = nestedScrollView;
        nestedScrollView.setOnScrollChangeListener(new g());
        this.m = (TextView) userDetailActivity.findViewById(R.id.online_text);
        this.n = (TextView) userDetailActivity.findViewById(R.id.district_text);
        this.o = (TextView) userDetailActivity.findViewById(R.id.signature_text);
        this.g = userDetailActivity.findViewById(R.id.name_layout);
        this.h = (TextView) userDetailActivity.findViewById(R.id.nameMain);
        this.i = (ImageView) userDetailActivity.findViewById(R.id.iv_vip);
        this.j = (ImageView) userDetailActivity.findViewById(R.id.iv_ai_chat);
        this.k = (ImageView) userDetailActivity.findViewById(R.id.iv_label);
        this.l = (TextView) userDetailActivity.findViewById(R.id.tv_official);
        this.p = (LXPortraitView) userDetailActivity.findViewById(R.id.portrait);
        this.t = (ImageView) userDetailActivity.findViewById(R.id.img_gender);
        this.u = (TextView) userDetailActivity.findViewById(R.id.profile_00_text);
        this.v = (TextView) userDetailActivity.findViewById(R.id.profile_01_text);
        this.w = userDetailActivity.findViewById(R.id.intention);
        this.x = (TextView) userDetailActivity.findViewById(R.id.intention_complete_action);
        this.y = (TextView) userDetailActivity.findViewById(R.id.intention_1);
        this.z = (TextView) userDetailActivity.findViewById(R.id.intention_2);
        this.A = (TextView) userDetailActivity.findViewById(R.id.intention_3);
        this.B = userDetailActivity.findViewById(R.id.love);
        this.C = (TextView) userDetailActivity.findViewById(R.id.love_title_1);
        this.E = (TextView) userDetailActivity.findViewById(R.id.love_answer_1);
        this.F = (TextView) userDetailActivity.findViewById(R.id.love_title_2);
        this.G = (TextView) userDetailActivity.findViewById(R.id.love_answer_2);
        this.H = (TextView) userDetailActivity.findViewById(R.id.love_title_3);
        this.I = (TextView) userDetailActivity.findViewById(R.id.love_answer_3);
        this.J = userDetailActivity.findViewById(R.id.hobby);
        this.K = (TextView) userDetailActivity.findViewById(R.id.hobby_text);
        this.L = userDetailActivity.findViewById(R.id.hobby_complete);
        this.M = (TextView) userDetailActivity.findViewById(R.id.hobby_complete_title);
        this.N = (TextView) userDetailActivity.findViewById(R.id.hobby_complete_action);
        this.N0 = userDetailActivity.findViewById(R.id.profile_complete_task);
        this.O0 = (TextView) userDetailActivity.findViewById(R.id.profile_part1);
        this.P0 = (TextView) userDetailActivity.findViewById(R.id.profile_part2);
        this.Q0 = (TextView) userDetailActivity.findViewById(R.id.menu_edit_profile);
        TextView textView = (TextView) userDetailActivity.findViewById(R.id.decor_guide_bubble);
        this.h0 = textView;
        textView.setOnClickListener(new h(userDetailActivity));
        this.i0 = userDetailActivity.findViewById(R.id.decor_guide_bubble_layout);
        this.k0.findViewById(R.id.profile_complete_action).setOnClickListener(new i());
        this.P0.setOnClickListener(new j());
        this.x.setOnClickListener(new k());
        this.N.setOnClickListener(new l());
        this.W = userDetailActivity.findViewById(R.id.userLevel_layout);
        this.X = (UserDetailLevelView) userDetailActivity.findViewById(R.id.rich_level);
        this.Y = (UserDetailLevelView) userDetailActivity.findViewById(R.id.charm_level);
        UserDetailEnergyView userDetailEnergyView = (UserDetailEnergyView) userDetailActivity.findViewById(R.id.energy_view);
        this.Z = userDetailEnergyView;
        if (userDetailEnergyView != null) {
            userDetailEnergyView.resetRefreshState();
        }
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.U = userDetailActivity.findViewById(R.id.profile_empty);
        this.V = (TextView) userDetailActivity.findViewById(R.id.profile_error);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#14cd64")), 5, 9, 18);
        this.V.setText(spannableStringBuilder);
        this.V.setOnClickListener(new m(userDetailActivity));
        this.e0 = new com.zenmen.palmchat.contacts.userdetail.a(userDetailActivity, this);
        this.f0 = new com.zenmen.palmchat.contacts.userdetail.b(userDetailActivity, userDetailActivity.findViewById(R.id.gift), false, z);
        ((NestTopicFeedsActivity.SquareBehavior) ((CoordinatorLayout.LayoutParams) this.f.getLayoutParams()).getBehavior()).setOnPreScrollListener(this);
        this.q = userDetailActivity.findViewById(R.id.request_layout);
        View viewFindViewById = userDetailActivity.findViewById(R.id.reply);
        this.r = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        ArrayList<TextView> arrayList = new ArrayList<>();
        this.s = arrayList;
        arrayList.add((TextView) userDetailActivity.findViewById(R.id.item0));
        this.s.add((TextView) userDetailActivity.findViewById(R.id.item1));
        this.s.add((TextView) userDetailActivity.findViewById(R.id.item2));
        this.p.setOnClickListener(this);
        this.O = userDetailActivity.findViewById(R.id.action_layout);
        this.T = (TextView) userDetailActivity.findViewById(R.id.textview_blacklist);
        TextView textView2 = (TextView) userDetailActivity.findViewById(R.id.action_btn_add);
        this.Q = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) userDetailActivity.findViewById(R.id.action_btn_chat);
        this.R = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) userDetailActivity.findViewById(R.id.action_btn_delete);
        this.S = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) userDetailActivity.findViewById(R.id.action_btn_video_call);
        this.P = textView5;
        textView5.setOnClickListener(this);
        this.C0 = handler;
        this.j0 = (TextView) userDetailActivity.findViewById(R.id.alert_tv);
        this.f13573a = i4;
        this.I0 = (ViewGroup) userDetailActivity.findViewById(R.id.item_wrappers);
        this.J0 = (ImageView) userDetailActivity.findViewById(R.id.like_guide);
        this.K0 = (RelativeLayout) userDetailActivity.findViewById(R.id.like_container);
        this.L0 = (ImageView) userDetailActivity.findViewById(R.id.like_img);
        this.M0 = (TextView) userDetailActivity.findViewById(R.id.like_count);
        ik4 ik4Var = new ik4((PolishView) userDetailActivity.findViewById(R.id.polishView));
        this.g0 = ik4Var;
        if (z) {
            ik4Var.c();
        }
    }

    public static boolean A(ContactInfoItem contactInfoItem) {
        int i2;
        String[] intentionForShow;
        if (contactInfoItem == null) {
            return true;
        }
        if (contactInfoItem.getGender() != 0 && contactInfoItem.getGender() != 1) {
            return true;
        }
        try {
            i2 = Integer.parseInt(contactInfoItem.getAge());
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        return i2 <= 0 || contactInfoItem.getExt() == null || TextUtils.isEmpty(contactInfoItem.getOccupationForShow()) || TextUtils.isEmpty(contactInfoItem.getIncomeForShow()) || (intentionForShow = contactInfoItem.getIntentionForShow()) == null || intentionForShow.length <= 0;
    }

    public void B() {
        com.zenmen.palmchat.contacts.userdetail.a aVar = this.e0;
        if (aVar != null) {
            aVar.p();
        }
        com.zenmen.palmchat.contacts.userdetail.b bVar = this.f0;
        if (bVar != null) {
            bVar.l();
        }
        db1.g();
    }

    public void C() {
        com.zenmen.palmchat.contacts.userdetail.b bVar = this.f0;
        if (bVar != null) {
            bVar.m();
        }
        N();
    }

    public final void D(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visitObjectUid", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        zw4.f(nl0.z + "/lxmbr.who.like.me.click.v1", 1, jSONObject, null);
    }

    public void E() {
        this.D0 = true;
        I();
    }

    public void F(boolean z) {
        this.v0 = z;
    }

    public void G() {
        this.B0 = true;
    }

    public void H(String str) {
        this.q0 = str;
        I();
    }

    public void I() {
        ContactInfoItem contactInfoItem;
        this.F0 = false;
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
        if (this.z0 == 0) {
            this.O.setVisibility(8);
        } else if (this.m0 != 11 || jo6.F()) {
            if (this.z0 != 2) {
                this.R.setVisibility(0);
                if (this.B0) {
                    this.R.setText(R.string.send_greeting);
                } else {
                    this.R.setText(R.string.send_message);
                }
            } else if (this.k0.a3(this.m0)) {
                this.Q.setVisibility(0);
                this.Q.setText(R.string.add_friend);
                this.Q.setBackgroundResource(R.drawable.selector_big_button_yellow);
                this.R.setVisibility(0);
                this.R.setText(ai5.k().g().getUserHomeChatText(this.k0));
            } else {
                int i2 = this.m0;
                if ((i2 == 7 || i2 == 36) && !TextUtils.isEmpty(this.q0) && !ContactRequestsVO.isSenderParseFromRid(this.q0)) {
                    this.Q.setVisibility(0);
                    this.Q.setText(R.string.accept_friend_request);
                    this.F0 = true;
                } else if (this.m0 == 5 && (contactInfoItem = this.l0) != null && fu5.t(contactInfoItem.getBizType()) && ContactInfoItem.isUidAvailable(this.l0.getUid()) && tn0.i().v(this.l0.getUid(), true)) {
                    this.Q.setVisibility(0);
                    this.Q.setText(R.string.accept_friend_request);
                    this.F0 = true;
                } else if (!this.b) {
                    this.Q.setVisibility(0);
                    this.Q.setText(R.string.add_friend);
                }
            }
        } else if (this.z0 == 2) {
            this.Q.setText(R.string.nearby_greeting);
            this.Q.setVisibility(0);
        } else {
            this.R.setText(R.string.send_message);
            this.R.setVisibility(0);
        }
        if (!this.D0 || this.z0 != 2) {
            this.Q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.Q.setEnabled(true);
        } else {
            this.Q.setVisibility(0);
            this.Q.setText(R.string.contact_friend_wait_confirm);
            this.Q.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user_detail_wait_confirm, 0, 0, 0);
            this.Q.setEnabled(false);
        }
    }

    public final void J() {
        ContactInfoItem contactInfoItem = this.l0;
        if (contactInfoItem != null) {
            if (jw5.e(contactInfoItem.getSessionConfig())) {
                this.T.setVisibility(0);
            } else {
                this.T.setVisibility(8);
            }
        }
    }

    public final void K() {
        ContactInfoItem contactInfoItem = this.l0;
        if (contactInfoItem != null && contactInfoItem.isCancellation()) {
            ((AppBarLayout.LayoutParams) this.c.getChildAt(0).getLayoutParams()).setScrollFlags(0);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            if (this.z0 == 2) {
                this.S.setVisibility(8);
            } else {
                this.S.setVisibility(0);
            }
            this.j0.setVisibility(8);
            return;
        }
        String strC = y66.b().c(this.l0);
        if (TextUtils.isEmpty(strC) || this.z0 == 0) {
            this.j0.setVisibility(8);
            return;
        }
        this.j0.setVisibility(0);
        this.j0.setText(strC);
        if (!this.G0) {
            zn6.h("pageprofil_but_alertbanner", "view", new b());
        }
        this.G0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L(Cursor cursor) {
        ContactInfoItem contactInfoItem;
        String str;
        if (this.z0 != 2 || (contactInfoItem = this.l0) == null || contactInfoItem.isCancellation() || this.v0) {
            this.q.setVisibility(8);
            return;
        }
        if (cursor.getCount() <= 0) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        Iterator<TextView> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        int i2 = 0;
        while (cursor.moveToNext() && i2 < 3) {
            TextView textView = this.s.get(2 - i2);
            String string = cursor.getString(cursor.getColumnIndex("request_info"));
            String string2 = cursor.getString(cursor.getColumnIndex("from_nick_name"));
            String string3 = cursor.getString(cursor.getColumnIndex("rid"));
            if (!TextUtils.isEmpty(string3)) {
                int i3 = cursor.getInt(cursor.getColumnIndex("request_type"));
                String string4 = cursor.getString(cursor.getColumnIndex("identify_code"));
                boolean zIsSenderParseFromRid = i3 == 0 ? ContactRequestsVO.isSenderParseFromRid(string3) : i3 == 2;
                if (TextUtils.isEmpty(string)) {
                    int i4 = cursor.getInt(cursor.getColumnIndex("source_type"));
                    if (i4 == 2) {
                        string = this.k0.getString(R.string.notification_add_contact_request_group);
                    } else if (i4 == 3) {
                        string = this.k0.getString(R.string.new_friend_wants_to_add_phone);
                    } else if (i4 == 7) {
                        string = this.k0.getString(R.string.notification_add_contact_request_auto);
                    } else if (i4 == 10) {
                        string = this.k0.getString(R.string.notification_add_contact_request_active);
                    } else if (i4 == 14) {
                        string = this.k0.getString(R.string.notification_greeting_content);
                    } else if (i4 == 20) {
                        string = this.k0.getString(R.string.new_friend_wants_to_add_phone);
                        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(string4);
                        if (phoneContactItem != null) {
                            String strM = phoneContactItem.m();
                            if (TextUtils.isEmpty(strM)) {
                                str = null;
                            } else {
                                str = this.k0.getString(R.string.contact_phone_nick_name, strM) + ",";
                            }
                            if (!TextUtils.isEmpty(str)) {
                                string = str + string;
                            }
                        }
                    } else if (i4 == 22) {
                        string = this.k0.getString(R.string.notification_add_contact_request_sec);
                    } else if (i4 != 28 && i4 != 34) {
                        if (i4 != 17) {
                            string = i4 != 18 ? this.k0.getString(R.string.notification_add_contact_request_content_new) : this.k0.getString(R.string.notification_add_contact_request_accurate);
                        }
                    }
                }
                if (zIsSenderParseFromRid) {
                    textView.setText(this.k0.getString(R.string.tab_settings) + "：" + string);
                } else {
                    textView.setText(string2 + "：" + string);
                }
                textView.setVisibility(0);
                i2++;
            }
        }
    }

    public final void M() {
        String str;
        if (this.l0.needHideProfile()) {
            this.p.getPortraitView().setImageResource(R.drawable.ic_portrait_cancellation);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.t.setVisibility(8);
            this.o.setVisibility(8);
        } else {
            this.p.setAvatarView(m(this.l0), this.l0.getAmulet());
            if (!TextUtils.isEmpty(this.l0.getSignature())) {
                this.o.setText(this.l0.getSignature());
                this.o.setVisibility(0);
            } else if (this.z0 == 0) {
                this.o.setVisibility(0);
                this.o.setText(R.string.no_signature);
            } else {
                this.o.setText(R.string.default_signature);
                this.o.setVisibility(0);
            }
            this.t.setVisibility(0);
            if (this.l0.getGender() == 1) {
                this.t.setImageResource(R.drawable.square_gender_female_26);
            } else if (this.l0.getGender() == 0) {
                this.t.setImageResource(R.drawable.square_gender_male_26);
            } else {
                this.t.setVisibility(8);
            }
            if (this.l0.isOnline() || (this.z0 == 0 && ch.s().t() == 1)) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            ArrayList arrayList = new ArrayList();
            if (this.z0 != 0) {
                if (!TextUtils.isEmpty(this.l0.getCityName())) {
                    arrayList.add(this.l0.getCityName());
                }
                if (this.l0.getDistance() >= 0) {
                    double distance = this.l0.getDistance() / 1000.0d;
                    if (distance < 0.01d) {
                        distance = 0.01d;
                    }
                    if (distance > 1.0d) {
                        str = Math.round(distance) + "km";
                    } else {
                        str = String.format("%.2fkm", Double.valueOf(distance));
                    }
                    arrayList.add(str);
                }
            }
            if (this.m.getVisibility() == 0) {
                if (!arrayList.isEmpty()) {
                    arrayList.add("");
                }
            } else if (!TextUtils.isEmpty(this.l0.getOnlineStatusDesc())) {
                arrayList.add(this.l0.getOnlineStatusDesc());
            }
            if (arrayList.isEmpty()) {
                this.n.setVisibility(8);
            } else {
                this.n.setText(TextUtils.join("  ·  ", arrayList));
                this.n.setVisibility(0);
            }
        }
        this.X.setLevel(this.l0.getRichLevel());
        if (this.l0.getCharmLevel() > 0 && this.Y.getVisibility() != 0) {
            zn6.j("profile_charm", "view", new c());
        }
        this.Y.setLevel(this.l0.getCharmLevel());
        UserDetailEnergyView userDetailEnergyView = this.Z;
        if (userDetailEnergyView != null) {
            userDetailEnergyView.setUserInfo(this.l0, this.z0);
        }
        N();
    }

    public final void N() {
        if (!nx3.a("key_amulet_mytab_profile_bubble" + this.l0.getChatId())) {
            this.h0.setVisibility(8);
            return;
        }
        ContactInfoItem contactInfoItemS = bo0.r().s();
        boolean z = contactInfoItemS != null && contactInfoItemS.hasAmulet();
        boolean zHasAmulet = this.l0.hasAmulet();
        if (z || !zHasAmulet) {
            this.h0.setVisibility(8);
            return;
        }
        String strC = rk4.c();
        if (TextUtils.isEmpty(strC)) {
            this.h0.setVisibility(8);
            return;
        }
        this.h0.setText(strC);
        if (this.h0.getVisibility() == 8) {
            zn6.j("profile_amulet_other", "view", new o());
        }
        this.h0.setVisibility(0);
    }

    public final void O(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = (TextView) this.k0.findViewById(R.id.tv_user_fid_info);
        TextView textView2 = (TextView) this.k0.findViewById(R.id.tv_user_fid_error);
        String str2 = "(" + str + ")";
        textView.setText(str2);
        textView2.setText(str2);
        textView.setVisibility(0);
        textView2.setVisibility(0);
    }

    @Override // defpackage.f74
    public void O0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i2, int i3, @NonNull int[] iArr, int i4) {
        this.p.getLocationOnScreen(new int[2]);
        float f2 = this.y0;
        if (f2 == 0.0f || r1[1] > f2) {
            this.y0 = r1[1];
        }
        float f3 = this.y0;
        float fMax = Math.max(0.0f, Math.min(Math.abs((f3 - r1[1]) / f3), 1.0f));
        this.x0 = fMax;
        if (fMax == 1.0f && this.w0) {
            this.w0 = false;
            this.d.setBackgroundColor(-1);
        } else if (fMax < 1.0f) {
            this.w0 = true;
            this.d.setBackgroundColor(ColorUtils.setAlphaComponent(-1, Math.round(fMax * 255.0f)));
        }
    }

    public final void P() {
        if (this.z0 == 0) {
            this.h.setText(this.l0.getNickName());
            return;
        }
        if (!TextUtils.isEmpty(this.l0.getNickName())) {
            this.h.setText(this.l0.getNickName());
        }
        String strO = o();
        if (TextUtils.isEmpty(strO)) {
            return;
        }
        this.h.setText(strO);
    }

    public final void Q() {
        if (this.v0 || this.l0.needHideProfile()) {
            this.J.setVisibility(8);
            return;
        }
        String hobby = this.l0.getHobby();
        if (!TextUtils.isEmpty(hobby)) {
            this.J.setVisibility(0);
            this.K.setVisibility(0);
            this.L.setVisibility(8);
            this.K.setText(hobby);
            return;
        }
        this.J.setVisibility(0);
        this.K.setVisibility(8);
        this.L.setVisibility(0);
        if (this.z0 != 0) {
            this.J.setVisibility(8);
            return;
        }
        this.M.setText("让喜欢你的人更懂你，");
        this.N.setText("去完善资料");
        this.N.setEnabled(true);
        this.N.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
    }

    public final void R() {
        this.w.setVisibility(0);
        this.x.setVisibility(8);
        this.k0.findViewById(R.id.intention_empty).setVisibility(8);
        String[] intentionForShow = this.l0.getIntentionForShow();
        if (intentionForShow.length == 1) {
            this.y.setVisibility(0);
            this.y.setText(intentionForShow[0]);
            this.z.setVisibility(8);
            this.A.setVisibility(8);
        }
        if (intentionForShow.length == 2) {
            this.y.setVisibility(0);
            this.y.setText(intentionForShow[0]);
            this.z.setVisibility(0);
            this.z.setText(intentionForShow[1]);
            this.A.setVisibility(8);
        }
        if (intentionForShow.length >= 3) {
            this.y.setVisibility(0);
            this.y.setText(intentionForShow[0]);
            this.z.setVisibility(0);
            this.z.setText(intentionForShow[1]);
            this.A.setVisibility(0);
            this.A.setText(intentionForShow[2]);
        }
    }

    public void S() {
        ContactInfoItem contactInfoItem = this.l0;
        if (contactInfoItem == null || il5.l(contactInfoItem.getUid()) || this.l0.isCancellation() || this.z0 == 0) {
            ContactInfoItem contactInfoItem2 = this.l0;
            if (contactInfoItem2 == null || il5.l(contactInfoItem2.getUid()) || this.l0.isCancellation() || this.z0 != 0) {
                this.K0.setVisibility(8);
                return;
            }
            this.K0.setClickable(true);
            this.K0.setOnClickListener(this);
            gr2.j().e(R.drawable.user_detail_like_select, this.L0, null);
            this.K0.setVisibility(0);
            this.J0.setVisibility(8);
            this.M0.setText(this.l0.getLikeCount());
            return;
        }
        String uid = this.l0.getUid();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.USER_DETAIL;
        if (sPUtil.a(scene, "key_user_detail_guide", false)) {
            this.J0.setVisibility(8);
        } else {
            this.J0.setVisibility(0);
            sPUtil.t(scene, "key_user_detail_guide", Boolean.TRUE);
        }
        if (sPUtil.a(scene, "key_user_detail_like_status_" + uid, false)) {
            this.K0.setClickable(false);
            gr2.j().e(R.drawable.user_detail_like_select, this.L0, null);
        } else {
            this.K0.setClickable(true);
            this.K0.setOnClickListener(this);
            gr2.j().e(R.drawable.user_detail_like_normal, this.L0, null);
            u("view", uid);
        }
        this.K0.setVisibility(0);
    }

    public final void T() {
        if (this.v0 || this.l0.needHideProfile()) {
            this.B.setVisibility(8);
            return;
        }
        List<ContactLoveBean> loveView = this.l0.getLoveView();
        if (loveView == null || loveView.isEmpty()) {
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(0);
        if (loveView.size() >= 1) {
            this.C.setVisibility(0);
            this.C.setText("#" + loveView.get(0).getRecentQuestionTitle());
            this.E.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("我的看法：“" + loveView.get(0).getRecentQuestionAnswer() + "”");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.k0.getResources().getColor(R.color.Gb)), 0, 5, 18);
            this.E.setText(spannableStringBuilder);
        } else {
            this.C.setVisibility(8);
            this.E.setVisibility(8);
        }
        if (loveView.size() >= 2) {
            this.F.setVisibility(0);
            this.F.setText("#" + loveView.get(1).getRecentQuestionTitle());
            this.G.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("我的看法：“" + loveView.get(1).getRecentQuestionAnswer() + "”");
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.k0.getResources().getColor(R.color.Gb)), 0, 5, 18);
            this.G.setText(spannableStringBuilder2);
        } else {
            this.F.setVisibility(8);
            this.G.setVisibility(8);
        }
        if (loveView.size() < 3) {
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        this.H.setText("#" + loveView.get(2).getRecentQuestionTitle());
        this.I.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("我的看法：“" + loveView.get(2).getRecentQuestionAnswer() + "”");
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(this.k0.getResources().getColor(R.color.Gb)), 0, 5, 18);
        this.I.setText(spannableStringBuilder3);
    }

    public final void U() {
        if (this.l0.isCancellation()) {
            this.h.setText(R.string.account_has_cancelled);
            return;
        }
        if (this.l0.isRiskClosure() && this.z0 != 0) {
            this.h.setText(R.string.account_has_forbid);
            return;
        }
        this.h.setText("");
        String strO = o();
        if (TextUtils.isEmpty(strO) && !TextUtils.isEmpty(this.n0)) {
            strO = this.n0;
        }
        int i2 = this.m0;
        if (i2 == 6) {
            P();
            return;
        }
        if ((i2 == 7 || (i2 == 36 && !TextUtils.isEmpty(this.q0))) && this.z0 == 2) {
            if (TextUtils.isEmpty(strO)) {
                this.h.setText(this.l0.getNickName());
                return;
            } else {
                this.h.setText(strO);
                return;
            }
        }
        if (TextUtils.isEmpty(strO)) {
            this.h.setText(this.l0.getNickName());
        } else {
            this.h.setText(strO);
        }
    }

    public final void V() {
        if (this.l0.isCancellation()) {
            this.l.setVisibility(8);
            return;
        }
        if (this.l0.isRiskClosure() && this.z0 != 0) {
            this.l.setVisibility(8);
            return;
        }
        TextView textView = this.h;
        if (textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(this.h.getText().toString())) {
            this.l.setVisibility(8);
        } else if (!this.l0.isOfficialAccount()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.h.setTextColor(this.k0.getResources().getColor(R.color.Gg));
        }
    }

    public final void W(boolean z) {
        boolean z2;
        int i2;
        if (this.v0 || this.l0.needHideProfile()) {
            this.k0.findViewById(R.id.profile_layout).setVisibility(8);
            return;
        }
        this.k0.findViewById(R.id.profile_layout).setVisibility(0);
        String str = null;
        if (A(this.l0)) {
            this.k0.findViewById(R.id.profile).setVisibility(8);
            this.k0.findViewById(R.id.profile_complete_wrapper).setVisibility(0);
            if (this.z0 != 0) {
                this.Q0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.k0.findViewById(R.id.profile_complete).setVisibility(0);
                this.N0.setVisibility(8);
                if (r(this.l0.getUid())) {
                    ((TextView) this.k0.findViewById(R.id.profile_complete_title)).setText("已邀请填写资料，等待更新中...");
                    ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setVisibility(8);
                    ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    ((TextView) this.k0.findViewById(R.id.profile_complete_title)).setText("想要更了解Ta，");
                    ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setText("邀请Ta完善资料");
                    ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setVisibility(0);
                    ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
                }
            } else if (js2.m()) {
                this.Q0.setCompoundDrawablesWithIntrinsicBounds(this.k0.getDrawable(R.mipmap.generic_income_task_redicon), (Drawable) null, (Drawable) null, (Drawable) null);
                if (z) {
                    js2.q(this.k0);
                }
                this.k0.findViewById(R.id.profile_complete).setVisibility(8);
                if (this.N0.getVisibility() != 0) {
                    js2.h();
                }
                this.N0.setVisibility(0);
                this.O0.setText(js2.k().f18491a);
                this.P0.setText(js2.k().b);
            } else {
                this.Q0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.k0.findViewById(R.id.profile_complete).setVisibility(0);
                this.N0.setVisibility(8);
                ((TextView) this.k0.findViewById(R.id.profile_complete_title)).setText("让喜欢你的人更懂你，");
                ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setText("去完善资料");
                ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setVisibility(0);
                ((TextView) this.k0.findViewById(R.id.profile_complete_action)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
            }
        } else {
            this.Q0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.k0.findViewById(R.id.profile_complete_wrapper).setVisibility(8);
        }
        if (this.l0.getGender() == -1) {
            this.u.setText("未填写");
            this.u.setTextColor(this.k0.getResources().getColor(R.color.Gd));
            z2 = false;
        } else {
            this.u.setText(this.l0.getGender() == 0 ? "男" : "女");
            this.u.setTextColor(this.k0.getResources().getColor(R.color.Gb));
            z2 = true;
        }
        try {
            try {
                i2 = Integer.parseInt(this.l0.getAge());
            } catch (Exception unused) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            str = i2 + "岁";
        }
        if (str != null) {
            try {
                this.v.setText(str);
                this.v.setTextColor(this.k0.getResources().getColor(R.color.Gb));
                z2 = true;
            } catch (Exception unused2) {
                z2 = true;
            }
        } else {
            this.v.setText("未填写");
            this.v.setTextColor(this.k0.getResources().getColor(R.color.Gd));
        }
        ((TextView) this.k0.findViewById(R.id.profile_10_label)).setText("职业");
        TextView textView = (TextView) this.k0.findViewById(R.id.profile_10_text);
        if (TextUtils.isEmpty(this.l0.getOccupationForShow())) {
            textView.setText("未填写");
            textView.setTextColor(this.k0.getResources().getColor(R.color.Gd));
        } else {
            textView.setText(this.l0.getOccupationForShow());
            textView.setTextColor(this.k0.getResources().getColor(R.color.Gb));
            z2 = true;
        }
        ((TextView) this.k0.findViewById(R.id.profile_11_label)).setText("收入");
        TextView textView2 = (TextView) this.k0.findViewById(R.id.profile_11_text);
        if (TextUtils.isEmpty(this.l0.getIncomeForShow())) {
            textView2.setText("未填写");
            textView2.setTextColor(this.k0.getResources().getColor(R.color.Gd));
        } else {
            textView2.setText(this.l0.getIncomeForShow());
            textView2.setTextColor(this.k0.getResources().getColor(R.color.Gb));
            z2 = true;
        }
        this.k0.findViewById(R.id.profile_2).setVisibility(8);
        this.k0.findViewById(R.id.profile).setVisibility(z2 ? 0 : 8);
        this.k0.findViewById(R.id.profile_empty_gap).setVisibility((z2 || !z()) ? 8 : 0);
        if (!z()) {
            R();
            return;
        }
        if (A(this.l0)) {
            this.w.setVisibility(z2 ? 0 : 8);
            this.x.setVisibility(8);
            this.k0.findViewById(R.id.intention_empty).setVisibility(z2 ? 0 : 8);
        } else {
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.k0.findViewById(R.id.intention_empty).setVisibility(8);
            if (this.z0 == 0) {
                this.x.setText("立即填写");
                this.x.setEnabled(true);
                this.x.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
            } else if (r(this.l0.getUid())) {
                this.x.setText("已邀请填写资料，等待更新中...");
                this.x.setTextColor(this.k0.getResources().getColor(R.color.Gc));
                this.x.setEnabled(false);
                this.x.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.x.setText("邀请Ta完善交友意愿");
                this.x.setEnabled(true);
                this.x.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.user_detail_profile_complete_arrow, 0);
            }
        }
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
    }

    public void X(ContactInfoItem contactInfoItem, int i2, boolean z) {
        this.l0 = contactInfoItem;
        this.z0 = i2;
        I();
        O(contactInfoItem.getFid());
        if (this.l0 != null) {
            M();
            U();
            Z();
            s();
            V();
            W(!z);
            T();
            Q();
            if (v8.C(contactInfoItem.getUid()) && v8.o) {
                this.j.setVisibility(0);
                if (!q05.o(this.k0)) {
                    Glide.with((FragmentActivity) this.k0).load2(v8.u).error(R.drawable.ai_chat_find_logo_bg).into(this.j);
                }
            } else {
                this.j.setVisibility(8);
            }
            if (!z) {
                if (TextUtils.equals(this.l0.getUid(), v4.e(this.k0)) || this.l0.needHideProfile()) {
                    if (this.H0) {
                        this.H0 = false;
                        db1.g();
                    }
                } else if (!this.H0) {
                    this.H0 = true;
                    db1.b(this.I0);
                    db1.k(this.k0, 1);
                    db1.j(this.k0);
                }
            }
            if (i2 != 1 || a65.e(contactInfoItem) || com.zenmen.palmchat.videocall.c.e()) {
                this.P.setVisibility(8);
            } else {
                this.P.setVisibility(8);
            }
            if (this.m0 == 23) {
                this.P.setVisibility(8);
            }
            if (fu5.u(this.l0)) {
                this.P.setVisibility(8);
            }
        }
        K();
        J();
        ContactInfoItem contactInfoItem2 = this.l0;
        if (contactInfoItem2 != null) {
            if (!z || i2 == 0) {
                if (contactInfoItem2.needHideProfile()) {
                    this.U.setVisibility(0);
                    this.V.setVisibility(8);
                    this.W.setVisibility(8);
                    this.e0.l();
                    this.f0.j();
                    this.g0.b();
                    return;
                }
                this.U.setVisibility(8);
                if (this.v0) {
                    this.V.setVisibility(0);
                    this.W.setVisibility(8);
                    this.e0.l();
                    this.f0.j();
                    this.g0.b();
                    return;
                }
                b05.d("updateUIWithContactInfoItem()");
                this.V.setVisibility(8);
                this.W.setVisibility(0);
                j(this.l0);
                this.f0.o(this.l0);
                this.g0.a();
            }
        }
    }

    public void Y(List<String> list) {
        UserDetailActivity userDetailActivity = this.k0;
        if (userDetailActivity == null || !userDetailActivity.isDestroyed()) {
            ContactInfoItem contactInfoItem = this.l0;
            if (contactInfoItem == null || contactInfoItem.isCancellation() || this.l0.getAccountType() == -3 || this.l0.getAccountType() == -4) {
                this.k.setVisibility(8);
                return;
            }
            if (list == null || list.isEmpty() || TextUtils.isEmpty(list.get(0))) {
                this.k.setVisibility(8);
            } else {
                hc2.b(this.k0).load(list.get(0)).into(this.k);
                this.k.setVisibility(0);
            }
        }
    }

    public final void Z() {
        TextView textView;
        if (this.l0.isCancellation()) {
            this.i.setVisibility(8);
        } else if ((this.l0.isRiskClosure() && this.z0 != 0) || (textView = this.h) == null || textView.getVisibility() != 0 || TextUtils.isEmpty(this.h.getText().toString())) {
            this.i.setVisibility(8);
        } else if (this.z0 == 0) {
            this.i.setVisibility(8);
            if (fg6.d(this.k0) || fg6.j(this.k0)) {
                this.h.setTextColor(this.k0.getResources().getColor(R.color.Gg));
            } else {
                this.h.setTextColor(this.k0.getResources().getColor(R.color.Gb));
            }
            fg6.k(AppContext.getContext(), new d());
        } else {
            int iG = fg6.g(this.l0.getExt());
            if (fg6.q(iG)) {
                this.i.setVisibility(0);
                this.i.setImageResource(fg6.e(iG));
            } else {
                this.i.setVisibility(8);
            }
            this.h.setTextColor(fg6.n(this.k0, iG));
        }
        this.i.setOnClickListener(new ViewOnClickListenerC1025e());
    }

    public void i(int i2, int i3) {
        this.b = false;
        int i4 = this.m0;
        if (i4 == 11 || this.k0.a3(i4) || this.z0 != 2) {
            return;
        }
        int i5 = this.m0;
        if ((i5 != 7 && i5 != 36) || TextUtils.isEmpty(this.q0) || ContactRequestsVO.isSenderParseFromRid(this.q0)) {
            if (i2 == 1 || i2 == 2 || i3 == 1 || i3 == 2) {
                this.Q.setVisibility(0);
                this.Q.setText(R.string.add_friend);
            } else if (this.f13573a == 1) {
                this.Q.setVisibility(0);
                this.Q.setText(R.string.add_friend);
            } else {
                this.Q.setVisibility(8);
                this.b = true;
            }
        }
    }

    public void j(ContactInfoItem contactInfoItem) {
        if (this.E0 == null) {
            this.E0 = bj5.b().c();
        }
        if (contactInfoItem == null) {
            return;
        }
        this.E0.f(contactInfoItem.getUid(), contactInfoItem.getExid(), xn3.a(), 0L, new a(contactInfoItem));
    }

    public HashMap<String, Object> k() {
        HashMap<String, Object> mapL = l();
        mapL.put("chatbutton", Integer.valueOf(this.R.getVisibility() == 0 ? 1 : 0));
        mapL.put("avchatbutton", Integer.valueOf(this.P.getVisibility() == 0 ? 1 : 0));
        if (this.Q.getVisibility() == 0) {
            mapL.put("passbutton", Integer.valueOf(this.F0 ? 1 : 0));
            mapL.put("addbutton", Integer.valueOf(!this.F0 ? 1 : 0));
        } else {
            mapL.put("passbutton", 0);
            mapL.put("addbutton", 0);
        }
        mapL.put("cancelbutton", Integer.valueOf(this.S.getVisibility() == 0 ? 1 : 0));
        int i2 = this.z0;
        mapL.put("relationtype", Integer.valueOf(i2 == 0 ? 2 : i2 == 1 ? 1 : 0));
        mapL.put("friendcircle", Integer.valueOf(this.z0 == 1 ? 1 : 0));
        ContactInfoItem contactInfoItem = this.l0;
        if (contactInfoItem != null) {
            mapL.put("gender", Integer.valueOf(contactInfoItem.getGender()));
            mapL.put("target_uid", this.l0.getUid());
        }
        SquareFeed squareFeed = this.u0;
        if (squareFeed != null) {
            mapL.put("imprId", squareFeed.imprId);
        }
        return mapL;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, Object> l() {
        HashMap<String, Object> mapP = p();
        int i2 = this.m0;
        if (i2 == 13) {
            i2 = 999;
        } else if (i2 == 75) {
            i2 = 75;
        } else if (i2 == 79) {
            i2 = 79;
        } else if (i2 != 201) {
            if (i2 == 45) {
                i2 = 45;
            } else if (i2 != 46) {
                switch (i2) {
                    case 0:
                        i2 = 40;
                        break;
                    case 1:
                    case 2:
                    case 3:
                        i2 = 37;
                        break;
                    case 4:
                        i2 = 38;
                        break;
                    case 5:
                        ContactInfoItem contactInfoItem = this.l0;
                        i2 = (contactInfoItem != null && fu5.t(contactInfoItem.getBizType())) ? 35 : 34;
                        break;
                    case 6:
                        i2 = 36;
                        break;
                    case 7:
                    case 8:
                        int i3 = this.r0;
                        if (i3 != 14 && i3 != 34 && i3 != 38) {
                            i2 = 39;
                            break;
                        }
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        switch (i2) {
                            case 18:
                            case 19:
                                break;
                            case 20:
                                i2 = 29;
                                break;
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                break;
                            default:
                                switch (i2) {
                                    case 33:
                                        i2 = 1;
                                        break;
                                    case 34:
                                        i2 = 49;
                                        break;
                                    case 35:
                                        i2 = 0;
                                        break;
                                    case 36:
                                        i2 = 100;
                                        break;
                                    case 37:
                                        i2 = 30;
                                        break;
                                    case 38:
                                        i2 = 28;
                                        break;
                                    case 39:
                                        i2 = 2;
                                        break;
                                    case 40:
                                        i2 = 4;
                                        break;
                                    case 41:
                                        i2 = 41;
                                        break;
                                    case 42:
                                        i2 = 42;
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                i2 = 46;
            }
        }
        mapP.put("from", Integer.valueOf(i2));
        return mapP;
    }

    public final String m(ContactInfoItem contactInfoItem) {
        return TextUtils.isEmpty(contactInfoItem.getBigIconURL()) ? contactInfoItem.getIconURL() : contactInfoItem.getBigIconURL();
    }

    public String n() {
        if (!TextUtils.isEmpty(this.l0.getRemarkName())) {
            return this.l0.getRemarkName();
        }
        if (!jo6.i() || !io0.t(this.r0) || TextUtils.isEmpty(this.p0)) {
            return "";
        }
        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.p0));
        return phoneContactItem != null ? io0.v(phoneContactItem.m()) : "";
    }

    public String o() {
        if (!TextUtils.isEmpty(this.l0.getRemarkName())) {
            return this.l0.getRemarkName();
        }
        if (!io0.t(this.r0) || TextUtils.isEmpty(this.p0)) {
            return "";
        }
        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.p0));
        return phoneContactItem != null ? io0.v(phoneContactItem.m()) : "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.p) {
            ContactInfoItem contactInfoItem = this.l0;
            if (contactInfoItem == null || contactInfoItem.needHideProfile()) {
                return;
            }
            this.A0.n0();
            return;
        }
        if (view == this.Q || view == this.R || view == this.S) {
            if (this.k0.a3(this.m0) && view == this.Q) {
                this.A0.e();
            } else {
                this.A0.b();
            }
            if (view == this.R) {
                HashMap<String, Object> mapL = l();
                SquareFeed squareFeed = this.u0;
                if (squareFeed != null) {
                    mapL.put("imprId", squareFeed.imprId);
                }
                mapL.put("relationtype", Integer.valueOf(this.z0 == 1 ? 1 : 0));
                zn6.j("pageprofil_foot_chatbutton", "click", mapL);
                return;
            }
            if (view == this.S) {
                HashMap<String, Object> mapL2 = l();
                SquareFeed squareFeed2 = this.u0;
                if (squareFeed2 != null) {
                    mapL2.put("imprId", squareFeed2.imprId);
                }
                mapL2.put("relationtype", Integer.valueOf(this.z0 == 1 ? 1 : 0));
                zn6.j("pageprofil_foot_deletebutton", "click", mapL2);
                return;
            }
            if (view == this.Q) {
                HashMap<String, Object> mapL3 = l();
                SquareFeed squareFeed3 = this.u0;
                if (squareFeed3 != null) {
                    mapL3.put("imprId", squareFeed3.imprId);
                }
                zn6.j(this.F0 ? "pageprofil_foot_passbutton" : "pageprofil_foot_addbutton", "click", mapL3);
                return;
            }
            return;
        }
        if (view == this.r) {
            this.A0.f();
            return;
        }
        if (view == this.P) {
            this.A0.c();
            HashMap<String, Object> mapL4 = l();
            SquareFeed squareFeed4 = this.u0;
            if (squareFeed4 != null) {
                mapL4.put("imprId", squareFeed4.imprId);
            }
            zn6.j("pageprofil_foot_avchatbutton", "click", mapL4);
            return;
        }
        if (view == this.X) {
            if (this.z0 == 0) {
                t(1);
                return;
            }
            return;
        }
        if (view == this.Y) {
            if (this.z0 == 0) {
                t(2);
                zn6.j("profile_charm", "click", new f());
                return;
            }
            return;
        }
        if (view == this.K0) {
            ContactInfoItem contactInfoItem2 = this.l0;
            if (contactInfoItem2 == null || il5.l(contactInfoItem2.getUid()) || this.l0.isCancellation() || this.z0 == 0) {
                ContactInfoItem contactInfoItem3 = this.l0;
                if (contactInfoItem3 == null || il5.l(contactInfoItem3.getUid()) || this.l0.isCancellation() || this.z0 != 0) {
                    return;
                }
                ve.o(this.k0, "zenxin://activity?page=a0052&pkgId=lkme", false);
                zn6.b("page_my_user_detail_likeme");
                return;
            }
            String uid = this.l0.getUid();
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.USER_DETAIL;
            if (sPUtil.a(scene, "key_user_detail_like_status_" + uid, false)) {
                return;
            }
            D(uid);
            gr2.j().e(R.drawable.user_detail_like_select, this.L0, null);
            sPUtil.t(scene, "key_user_detail_like_status_" + uid, Boolean.TRUE);
            u("click", uid);
        }
    }

    public HashMap<String, Object> p() {
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(this.l0.getUid())) {
            map.put("targetUid", this.l0.getUid());
        }
        if (!TextUtils.isEmpty(this.l0.getExid())) {
            map.put("targetExid", this.l0.getExid());
        }
        return map;
    }

    public final void q(boolean z) {
        if (l50.a()) {
            return;
        }
        if (this.z0 != 0) {
            gs2.g(0, this.k0, this.l0, new n());
            w();
            return;
        }
        this.k0.startActivity(nn4.a(this.k0, 4));
        if (z) {
            v();
        }
    }

    public boolean r(String str) {
        return gs2.e(str);
    }

    public final void s() {
        if (this.v0) {
            this.q.setVisibility(8);
        } else {
            if (this.z0 == 2 || this.l0.needHideProfile()) {
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public final void t(int i2) {
        String str = tj2.B() + "?page_type=" + i2;
        Intent intent = new Intent();
        intent.setClass(this.k0, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putBoolean("hide_toolbar", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        this.k0.startActivity(intent);
    }

    public final void u(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetUid", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f("pageprofile_heart", str, jSONObject);
    }

    public void v() {
        HashMap<String, Object> mapL = l();
        boolean z = this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.k0.findViewById(R.id.profile).getVisibility() == 0;
        boolean z2 = this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.w.getVisibility() == 0 && this.x.getVisibility() == 8;
        if (z && z2) {
            return;
        }
        if (z) {
            mapL.put("infor", 2);
        } else if (z2) {
            mapL.put("infor", 1);
        } else {
            mapL.put("infor", 0);
        }
        zn6.j("newpageprofil_gageclick", "click", mapL);
    }

    public void w() {
        HashMap<String, Object> mapL = l();
        boolean z = false;
        boolean z2 = this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.k0.findViewById(R.id.profile).getVisibility() == 0;
        if (this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.w.getVisibility() == 0 && this.x.getVisibility() == 8) {
            z = true;
        }
        if (z2 && z) {
            return;
        }
        if (z2) {
            mapL.put("type", 3);
        } else if (z) {
            mapL.put("type", 2);
        } else {
            mapL.put("type", 1);
        }
        zn6.j("Inviteprofile_inviteclick", "click", mapL);
    }

    public void x() {
        zn6.j("newpageprofil_gagefail", "view", l());
    }

    public void y() {
        HashMap<String, Object> mapL = l();
        boolean z = this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.k0.findViewById(R.id.profile).getVisibility() == 0;
        boolean z2 = this.k0.findViewById(R.id.profile_layout).getVisibility() == 0 && this.w.getVisibility() == 0 && this.x.getVisibility() == 8;
        if (z && z2) {
            mapL.put("infor", 3);
        } else if (z) {
            mapL.put("infor", 1);
        } else if (z2) {
            mapL.put("infor", 2);
        } else {
            mapL.put("infor", 0);
        }
        if (this.B.getVisibility() == 0) {
            List<ContactLoveBean> loveView = this.l0.getLoveView();
            mapL.put("viewpoint", Integer.valueOf(loveView != null ? loveView.size() : 0));
        } else {
            mapL.put("viewpoint", 0);
        }
        mapL.put("like", Integer.valueOf(this.J.getVisibility() == 0 ? 0 : 1));
        zn6.j("newpageprofil_gageshow", "view", mapL);
    }

    public final boolean z() {
        ContactInfoItem contactInfoItem = this.l0;
        return contactInfoItem == null || contactInfoItem.getExt() == null || this.l0.getExt().getIntention() == null || this.l0.getExt().getIntention().length <= 0;
    }
}
