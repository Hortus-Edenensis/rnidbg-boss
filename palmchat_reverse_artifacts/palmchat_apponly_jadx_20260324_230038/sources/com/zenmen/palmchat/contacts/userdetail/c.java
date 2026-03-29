package com.zenmen.palmchat.contacts.userdetail;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.UserDetailActivityV2;
import com.zenmen.palmchat.contacts.bean.ContactLoveBean;
import com.zenmen.palmchat.contacts.userdetail.UserDetailGalleryAdapter;
import com.zenmen.palmchat.contacts.userdetail.UserDetailThumbnailAdapter;
import com.zenmen.palmchat.contacts.widget.UserDetailEnergyView2;
import com.zenmen.palmchat.contacts.widget.UserDetailLevelViewV2;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.peoplematch.view.LoopingViewPager;
import com.zenmen.palmchat.settings.ModifyPersonalInfoActivity;
import com.zenmen.palmchat.settings.portrait.PortraitAlbumActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import defpackage.a65;
import defpackage.ai5;
import defpackage.ap3;
import defpackage.bo0;
import defpackage.ch;
import defpackage.f74;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.g74;
import defpackage.gs2;
import defpackage.hc2;
import defpackage.hs0;
import defpackage.il5;
import defpackage.io0;
import defpackage.jo6;
import defpackage.jw5;
import defpackage.l50;
import defpackage.m66;
import defpackage.me1;
import defpackage.nl0;
import defpackage.nn4;
import defpackage.nx3;
import defpackage.rk4;
import defpackage.tj2;
import defpackage.tn0;
import defpackage.v4;
import defpackage.v8;
import defpackage.ve;
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
public class c implements View.OnClickListener, f74 {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public View F;
    public UserDetailLevelViewV2 G;
    public UserDetailLevelViewV2 H;
    public UserDetailEnergyView2 I;
    public AppCompatTextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public ImageView N;
    public TextView O;
    public UserDetailActivityV2 P;
    public ContactInfoItem Q;
    public int R;
    public String S;
    public String T;
    public String U;
    public String V;
    public int W;
    public String X;
    public String Y;
    public SquareFeed Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13706a;
    public AppBarLayout b;
    public Toolbar c;
    public Toolbar d;
    public View e;
    public TextView f;
    public ImageView g;
    public float g0;
    public ImageView h;
    public TextView i;
    public p i0;
    public TextView j;
    public TextView k;
    public Handler k0;
    public LoopingViewPager l;
    public RecyclerView m;
    public TextView n;
    public View o;
    public TextView o0;
    public TextView p;
    public RelativeLayout p0;
    public TextView q;
    public ImageView q0;
    public ImageView r;
    public TextView r0;
    public UserDetailGalleryAdapter s;
    public UserDetailTabHeaderView s0;
    public UserDetailThumbnailAdapter t;
    public UserDetailPageHelper t0;
    public View v;
    public int v0;
    public View w;
    public ArrayList<TextView> x;
    public View y;
    public TextView z;
    public int u = 0;
    public boolean e0 = false;
    public boolean f0 = true;
    public int h0 = 0;
    public boolean j0 = false;
    public boolean l0 = false;
    public boolean m0 = false;
    public boolean n0 = false;
    public boolean u0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivityV2 f13707a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1033a extends HashMap<String, Object> {
            public C1033a() {
                put("target_uid", c.this.Q.getChatId());
            }
        }

        public a(UserDetailActivityV2 userDetailActivityV2) {
            this.f13707a = userDetailActivityV2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("profile_amulet_other", "click", new C1033a());
            nx3.e("key_amulet_mytab_profile_bubble" + c.this.Q.getChatId());
            rk4.d(this.f13707a, 3, null, 1, -1, -1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("target_uid", c.this.Q.getChatId());
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1034c extends HashMap<String, String> {
        public C1034c() {
            put("fuid", c.this.Q.getUid());
            put("type", "alert");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("targetuid", c.this.Q.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements fg6.b {
        public e() {
        }

        @Override // fg6.b
        public void onFail(Exception exc) {
            LogUtil.i("getVip", "onFail: " + exc.getMessage());
        }

        @Override // fg6.b
        public void onSuccess(int i) {
            if (i < 0) {
                c.this.f.setTextColor(c.this.P.getResources().getColor(R.color.Gb));
                return;
            }
            if (i == 0) {
                c.this.g.setImageDrawable(c.this.P.getResources().getDrawable(R.drawable.selector_icon_vip));
            } else {
                c.this.g.setImageDrawable(c.this.P.getResources().getDrawable(R.drawable.selector_icon_svip));
            }
            c.this.g.setVisibility(0);
            c.this.f.setTextColor(c.this.P.getResources().getColor(R.color.Gg));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.r(c.this.P, "7", fg6.d(c.this.P) ? "1" : "0");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("targetuid", c.this.Q.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends RecyclerView.ItemDecoration {
        public int b = me1.b(AppContext.getContext(), 8);

        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.left = -this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements g74<UserDetailThumbnailAdapter.a> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("targetUid", c.this.Q.getUid());
            }
        }

        public j() {
        }

        @Override // defpackage.g74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, int i, UserDetailThumbnailAdapter.a aVar) {
            if (l50.a()) {
                return;
            }
            if (aVar != null && aVar.d) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", 2);
                PortraitAlbumActivity.f2(c.this.P, bundle);
                zn6.j("newpageprofil_headupload", "click", new a());
                return;
            }
            if (aVar == null || aVar.b == null) {
                return;
            }
            c.this.u = i;
            c.this.l.setCurrentItem(c.this.u + 1, true);
            c.this.t.s(c.this.u);
            c.this.m();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("targetUid", c.this.Q.getUid());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("targetUid", c.this.Q.getUid());
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            boolean z = c.this.Q.getUid() != null && c.this.Q.getUid().equals(v4.e(com.zenmen.palmchat.c.b()));
            List listP = c.p(c.this.Q);
            if (z && !c.this.Q.hasPortrait()) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", 2);
                PortraitAlbumActivity.f2(c.this.P, bundle);
                zn6.j("newpageprofil_headupload", "click", new a());
                return;
            }
            if (!z || listP.size() != 1) {
                if (c.this.Q.hasPortrait()) {
                    return;
                }
                c.this.t();
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("from", 2);
                PortraitAlbumActivity.f2(c.this.P, bundle2);
                zn6.j("newpageprofil_headupload", "click", new b());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("targetUid", c.this.Q.getUid());
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("from", 3);
            PortraitAlbumActivity.f2(c.this.P, bundle);
            zn6.j("newpageprofil_headupload", "click", new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivityV2 f13723a;

        public m(UserDetailActivityV2 userDetailActivityV2) {
            this.f13723a = userDetailActivityV2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent(this.f13723a, (Class<?>) ModifyPersonalInfoActivity.class);
            intent.putExtra("mode", 1);
            if (c.this.Q != null && !TextUtils.isEmpty(c.this.Q.getSignature())) {
                intent.putExtra("info", c.this.Q.getSignature());
            }
            this.f13723a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends HashMap<String, Object> {
        public o() {
            put("targetUid", c.this.Q.getUid());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface p {
        void b();

        void c();

        void e();

        void f();
    }

    public c(UserDetailActivityV2 userDetailActivityV2, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, p pVar, Handler handler, boolean z, int i4, SquareFeed squareFeed, int i5) {
        this.P = userDetailActivityV2;
        this.R = i2;
        this.S = str;
        this.T = str2;
        this.i0 = pVar;
        this.U = str3;
        this.W = i3;
        this.V = str4;
        this.X = str5;
        this.Y = str6;
        this.Z = squareFeed;
        this.v0 = i5;
        this.b = (AppBarLayout) userDetailActivityV2.findViewById(R.id.app_bar);
        this.c = (Toolbar) userDetailActivityV2.findViewById(R.id.toolbar);
        this.d = (Toolbar) userDetailActivityV2.findViewById(R.id.toolbar2);
        this.j = (TextView) userDetailActivityV2.findViewById(R.id.online_text);
        this.k = (TextView) userDetailActivityV2.findViewById(R.id.district_text);
        this.e = userDetailActivityV2.findViewById(R.id.name_layout);
        this.f = (TextView) userDetailActivityV2.findViewById(R.id.nameMain);
        this.g = (ImageView) userDetailActivityV2.findViewById(R.id.iv_vip);
        this.h = (ImageView) userDetailActivityV2.findViewById(R.id.iv_ai_chat);
        this.i = (TextView) userDetailActivityV2.findViewById(R.id.tv_official);
        this.l = (LoopingViewPager) userDetailActivityV2.findViewById(R.id.portrait_gallery);
        this.m = (RecyclerView) userDetailActivityV2.findViewById(R.id.portrait_thumbnail_recycler);
        this.n = (TextView) userDetailActivityV2.findViewById(R.id.portrait_add_tips);
        this.q = (TextView) userDetailActivityV2.findViewById(R.id.portrait_empty_tips);
        this.r = (ImageView) userDetailActivityV2.findViewById(R.id.portrait_cancellation);
        this.o = userDetailActivityV2.findViewById(R.id.portrait_permission_tips);
        this.p = (TextView) userDetailActivityV2.findViewById(R.id.portrait_permission_text);
        TextView textView = (TextView) userDetailActivityV2.findViewById(R.id.decor_guide_bubble);
        this.O = textView;
        textView.setOnClickListener(new a(userDetailActivityV2));
        UserDetailGalleryAdapter userDetailGalleryAdapter = new UserDetailGalleryAdapter(userDetailActivityV2);
        this.s = userDetailGalleryAdapter;
        this.l.setAdapter(userDetailGalleryAdapter);
        this.l.setOffscreenPageLimit(1);
        this.l.setIndicatorChangeListener(new h());
        this.m.setLayoutManager(new LinearLayoutManager(userDetailActivityV2, 0, false));
        this.m.setItemAnimator(null);
        this.m.addItemDecoration(new i());
        UserDetailThumbnailAdapter userDetailThumbnailAdapter = new UserDetailThumbnailAdapter(userDetailActivityV2, null);
        this.t = userDetailThumbnailAdapter;
        userDetailThumbnailAdapter.n(new j());
        this.m.setAdapter(this.t);
        this.n.setOnClickListener(new k());
        this.o.setOnClickListener(new l());
        this.K = (TextView) userDetailActivityV2.findViewById(R.id.signature_text);
        this.L = (TextView) userDetailActivityV2.findViewById(R.id.signature_tips);
        this.J = (AppCompatTextView) userDetailActivityV2.findViewById(R.id.tv_member_gender_age);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("还没有个性签名，立即编辑");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#14cd64")), 8, 12, 18);
        this.L.setText(spannableStringBuilder);
        this.L.setOnClickListener(new m(userDetailActivityV2));
        this.F = userDetailActivityV2.findViewById(R.id.profile_empty);
        this.G = (UserDetailLevelViewV2) userDetailActivityV2.findViewById(R.id.rich_level);
        this.H = (UserDetailLevelViewV2) userDetailActivityV2.findViewById(R.id.charm_level);
        UserDetailEnergyView2 userDetailEnergyView2 = (UserDetailEnergyView2) userDetailActivityV2.findViewById(R.id.energy_view);
        this.I = userDetailEnergyView2;
        if (userDetailEnergyView2 != null) {
            userDetailEnergyView2.resetRefreshState();
        }
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        ((NestTopicFeedsActivity.SquareBehavior) ((CoordinatorLayout.LayoutParams) userDetailActivityV2.findViewById(R.id.dynamic_life).getLayoutParams()).getBehavior()).setOnPreScrollListener(this);
        this.v = userDetailActivityV2.findViewById(R.id.request_layout);
        View viewFindViewById = userDetailActivityV2.findViewById(R.id.reply);
        this.w = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        ArrayList<TextView> arrayList = new ArrayList<>();
        this.x = arrayList;
        arrayList.add((TextView) userDetailActivityV2.findViewById(R.id.item0));
        this.x.add((TextView) userDetailActivityV2.findViewById(R.id.item1));
        this.x.add((TextView) userDetailActivityV2.findViewById(R.id.item2));
        this.y = userDetailActivityV2.findViewById(R.id.action_layout);
        this.E = (TextView) userDetailActivityV2.findViewById(R.id.textview_blacklist);
        TextView textView2 = (TextView) userDetailActivityV2.findViewById(R.id.action_btn_add);
        this.A = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) userDetailActivityV2.findViewById(R.id.action_btn_chat);
        this.B = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) userDetailActivityV2.findViewById(R.id.action_btn_delete);
        this.C = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) userDetailActivityV2.findViewById(R.id.action_btn_video_call);
        this.z = textView5;
        textView5.setOnClickListener(this);
        this.k0 = handler;
        this.M = (TextView) userDetailActivityV2.findViewById(R.id.alert_tv);
        this.f13706a = i4;
        this.o0 = (TextView) userDetailActivityV2.findViewById(R.id.like_guide);
        this.p0 = (RelativeLayout) userDetailActivityV2.findViewById(R.id.like_container);
        this.q0 = (ImageView) userDetailActivityV2.findViewById(R.id.like_img);
        this.r0 = (TextView) userDetailActivityV2.findViewById(R.id.like_count);
        this.N = (ImageView) userDetailActivityV2.findViewById(R.id.iv_label);
        this.s0 = (UserDetailTabHeaderView) userDetailActivityV2.findViewById(R.id.tab_layout);
        UserDetailPageHelper userDetailPageHelper = (UserDetailPageHelper) userDetailActivityV2.findViewById(R.id.dynamic_life);
        this.t0 = userDetailPageHelper;
        userDetailPageHelper.bind(this.s0);
    }

    public static List<ContactInfoItem.Portrait> p(ContactInfoItem contactInfoItem) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(contactInfoItem.getBigIconURL()) || !TextUtils.isEmpty(contactInfoItem.getIconURL())) {
            ContactInfoItem.Portrait portrait = new ContactInfoItem.Portrait();
            portrait.headIcon = contactInfoItem.getIconURL();
            portrait.headImg = contactInfoItem.getBigIconURL();
            arrayList.add(portrait);
        }
        if (contactInfoItem.getImgList() != null) {
            arrayList.addAll(contactInfoItem.getImgList());
        }
        return arrayList;
    }

    public void A() {
        L();
    }

    public final void B(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visitObjectUid", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        zw4.f(nl0.z + "/lxmbr.who.like.me.click.v1", 1, jSONObject, null);
    }

    public void C() {
        this.l0 = true;
        G();
    }

    public void D(boolean z) {
        this.e0 = z;
    }

    public void E() {
        this.j0 = true;
    }

    public void F(String str) {
        this.V = str;
        G();
    }

    public void G() {
        ContactInfoItem contactInfoItem;
        this.m0 = false;
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        if (this.h0 == 0) {
            this.y.setVisibility(8);
        } else if (this.R != 11 || jo6.F()) {
            if (this.h0 != 2) {
                this.B.setVisibility(0);
                if (this.j0) {
                    this.B.setText(R.string.send_greeting);
                } else {
                    this.B.setText(R.string.send_message);
                }
            } else if (this.P.W2(this.R)) {
                this.A.setVisibility(0);
                this.A.setText(R.string.add_friend);
                this.A.setBackgroundResource(R.drawable.selector_big_button_yellow);
                this.B.setVisibility(0);
                this.B.setText(ai5.k().g().getUserHomeChatText(this.P));
            } else {
                int i2 = this.R;
                if ((i2 == 7 || i2 == 36) && !TextUtils.isEmpty(this.V) && !ContactRequestsVO.isSenderParseFromRid(this.V)) {
                    this.A.setVisibility(0);
                    this.A.setText(R.string.accept_friend_request);
                    this.m0 = true;
                } else if (this.R == 5 && (contactInfoItem = this.Q) != null && fu5.t(contactInfoItem.getBizType()) && ContactInfoItem.isUidAvailable(this.Q.getUid()) && tn0.i().v(this.Q.getUid(), true)) {
                    this.A.setVisibility(0);
                    this.A.setText(R.string.accept_friend_request);
                    this.m0 = true;
                } else {
                    this.A.setVisibility(0);
                    this.A.setText(R.string.add_friend);
                }
            }
        } else if (this.h0 == 2) {
            this.A.setText(R.string.nearby_greeting);
            this.A.setVisibility(0);
        } else {
            this.B.setText(R.string.send_message);
            this.B.setVisibility(0);
        }
        if (!this.l0 || this.h0 != 2) {
            this.A.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.A.setEnabled(true);
        } else {
            this.A.setVisibility(0);
            this.A.setText(R.string.contact_friend_wait_confirm);
            this.A.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user_detail_wait_confirm, 0, 0, 0);
            this.A.setEnabled(false);
        }
    }

    public final void H() {
        ContactInfoItem contactInfoItem = this.Q;
        if (contactInfoItem != null) {
            if (jw5.e(contactInfoItem.getSessionConfig())) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
        }
    }

    public final void I() {
        ContactInfoItem contactInfoItem = this.Q;
        if (contactInfoItem != null && contactInfoItem.isCancellation()) {
            ((AppBarLayout.LayoutParams) this.b.getChildAt(0).getLayoutParams()).setScrollFlags(0);
            this.z.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            if (this.h0 == 2) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            this.M.setVisibility(8);
            return;
        }
        String strC = y66.b().c(this.Q);
        if (TextUtils.isEmpty(strC) || this.h0 == 0) {
            this.M.setVisibility(8);
            return;
        }
        this.M.setVisibility(0);
        this.M.setText(strC);
        if (!this.n0) {
            zn6.h("pageprofil_but_alertbanner", "view", new C1034c());
        }
        this.n0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(Cursor cursor) {
        ContactInfoItem contactInfoItem;
        String str;
        if (this.h0 != 2 || (contactInfoItem = this.Q) == null || contactInfoItem.isCancellation() || this.e0) {
            this.v.setVisibility(8);
            return;
        }
        if (cursor.getCount() <= 0) {
            this.v.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        Iterator<TextView> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        int i2 = 0;
        while (cursor.moveToNext() && i2 < 3) {
            TextView textView = this.x.get(2 - i2);
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
                        string = this.P.getString(R.string.notification_add_contact_request_group);
                    } else if (i4 == 3) {
                        string = this.P.getString(R.string.new_friend_wants_to_add_phone);
                    } else if (i4 == 7) {
                        string = this.P.getString(R.string.notification_add_contact_request_auto);
                    } else if (i4 == 10) {
                        string = this.P.getString(R.string.notification_add_contact_request_active);
                    } else if (i4 == 14) {
                        string = this.P.getString(R.string.notification_greeting_content);
                    } else if (i4 == 20) {
                        string = this.P.getString(R.string.new_friend_wants_to_add_phone);
                        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(string4);
                        if (phoneContactItem != null) {
                            String strM = phoneContactItem.m();
                            if (TextUtils.isEmpty(strM)) {
                                str = null;
                            } else {
                                str = this.P.getString(R.string.contact_phone_nick_name, strM) + ",";
                            }
                            if (!TextUtils.isEmpty(str)) {
                                string = str + string;
                            }
                        }
                    } else if (i4 == 22) {
                        string = this.P.getString(R.string.notification_add_contact_request_sec);
                    } else if (i4 != 28 && i4 != 34) {
                        if (i4 != 17) {
                            string = i4 != 18 ? this.P.getString(R.string.notification_add_contact_request_content_new) : this.P.getString(R.string.notification_add_contact_request_accurate);
                        }
                    }
                }
                if (zIsSenderParseFromRid) {
                    textView.setText(this.P.getString(R.string.tab_settings) + "：" + string);
                } else {
                    textView.setText(string2 + "：" + string);
                }
                textView.setVisibility(0);
                i2++;
            }
        }
    }

    public final void K() {
        String str;
        if (this.Q.needHideProfile()) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.K.setVisibility(8);
            this.J.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
        } else {
            if (this.Q.isOnline() || (this.h0 == 0 && ch.s().t() == 1)) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            ArrayList arrayList = new ArrayList();
            if (this.h0 != 0) {
                if (!TextUtils.isEmpty(this.Q.getCityName())) {
                    arrayList.add(this.Q.getCityName());
                }
                if (this.Q.getDistance() >= 0) {
                    double distance = this.Q.getDistance() / 1000.0d;
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
            String strJoin = TextUtils.join(" · ", arrayList);
            if (this.j.getVisibility() != 0 && !TextUtils.isEmpty(this.Q.getOnlineStatusDesc())) {
                strJoin = this.Q.getOnlineStatusDesc() + "   " + strJoin;
            }
            if (TextUtils.isEmpty(strJoin)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(strJoin);
                this.k.setVisibility(0);
            }
            if (!TextUtils.isEmpty(this.Q.getSignature())) {
                this.K.setText(this.Q.getSignature());
                this.K.setVisibility(0);
                this.L.setVisibility(8);
            } else if (this.h0 == 0) {
                this.K.setVisibility(8);
                this.L.setVisibility(0);
            } else {
                this.K.setVisibility(8);
                this.L.setVisibility(8);
            }
            this.J.setVisibility(0);
            if (TextUtils.isEmpty(this.Q.getAge())) {
                this.J.setText("");
                this.J.setPadding(me1.b(this.P, 2), me1.b(this.P, 2), me1.b(this.P, 2), me1.b(this.P, 2));
            } else {
                this.J.setText(this.Q.getAge());
                this.J.setPadding(me1.b(this.P, 8), me1.b(this.P, 2), me1.b(this.P, 8), me1.b(this.P, 2));
            }
            this.J.setBackgroundResource(this.Q.getGender() == 0 ? R.drawable.bg_member_gender_age_male : R.drawable.bg_member_gender_age_female);
            this.J.setCompoundDrawablesWithIntrinsicBounds(this.Q.getGender() == 0 ? R.drawable.ic_member_male : R.drawable.ic_member_female, 0, 0, 0);
            if (TextUtils.isEmpty(this.Q.getAge()) && this.Q.getGender() == -1) {
                this.J.setVisibility(8);
            }
            this.G.setLevel(this.Q.getRichLevel());
            if (this.Q.getCharmLevel() > 0 && this.H.getVisibility() != 0) {
                zn6.j("profile_charm", "view", new d());
            }
            this.H.setLevel(this.Q.getCharmLevel());
            UserDetailEnergyView2 userDetailEnergyView2 = this.I;
            if (userDetailEnergyView2 != null) {
                userDetailEnergyView2.setUserInfo(this.Q, this.h0);
            }
        }
        L();
    }

    public final void L() {
        if (!nx3.a("key_amulet_mytab_profile_bubble" + this.Q.getChatId())) {
            this.O.setVisibility(8);
            return;
        }
        ContactInfoItem contactInfoItemS = bo0.r().s();
        boolean z = contactInfoItemS != null && contactInfoItemS.hasAmulet();
        boolean zHasAmulet = this.Q.hasAmulet();
        if (z || !zHasAmulet) {
            this.O.setVisibility(8);
            return;
        }
        String strC = rk4.c();
        if (TextUtils.isEmpty(strC)) {
            this.O.setVisibility(8);
            return;
        }
        this.O.setText(strC);
        if (this.O.getVisibility() == 8) {
            zn6.j("profile_amulet_other", "view", new b());
        }
        this.O.setVisibility(0);
    }

    public final void M(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = (TextView) this.P.findViewById(R.id.tv_user_fid_info);
        TextView textView2 = (TextView) this.P.findViewById(R.id.tv_user_fid_error);
        String str2 = "(" + str + ")";
        textView.setText(str2);
        textView2.setText(str2);
        textView.setVisibility(0);
        textView2.setVisibility(0);
    }

    public final void N() {
        if (this.h0 == 0) {
            this.f.setText(this.Q.getNickName());
            return;
        }
        if (!TextUtils.isEmpty(this.Q.getNickName())) {
            this.f.setText(this.Q.getNickName());
        }
        String strR = r();
        if (TextUtils.isEmpty(strR)) {
            return;
        }
        this.f.setText(strR);
    }

    public void O() {
        ContactInfoItem contactInfoItem = this.Q;
        if (contactInfoItem == null || il5.l(contactInfoItem.getUid()) || this.Q.isCancellation() || this.h0 == 0) {
            ContactInfoItem contactInfoItem2 = this.Q;
            if (contactInfoItem2 == null || il5.l(contactInfoItem2.getUid()) || this.Q.isCancellation() || this.h0 != 0) {
                this.p0.setVisibility(4);
                return;
            }
            this.p0.setClickable(true);
            this.p0.setOnClickListener(this);
            this.q0.setImageResource(R.drawable.user_detail_like_select_v2);
            this.p0.setVisibility(0);
            this.o0.setVisibility(4);
            this.r0.setText(this.Q.getLikeCount());
            return;
        }
        String uid = this.Q.getUid();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.USER_DETAIL;
        if (sPUtil.a(scene, "key_user_detail_guide", false)) {
            this.o0.setVisibility(4);
        } else {
            this.o0.setVisibility(0);
            sPUtil.t(scene, "key_user_detail_guide", Boolean.TRUE);
        }
        if (sPUtil.a(scene, "key_user_detail_like_status_" + uid, false)) {
            this.p0.setClickable(false);
            this.q0.setImageResource(R.drawable.user_detail_like_select_v2);
        } else {
            this.p0.setClickable(true);
            this.p0.setOnClickListener(this);
            this.q0.setImageResource(R.drawable.user_detail_like_normal_v2);
            w("view", uid);
        }
        this.p0.setVisibility(0);
    }

    @Override // defpackage.f74
    public void O0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, int i2, int i3, @NonNull int[] iArr, int i4) {
        int[] iArr2 = new int[2];
        this.l.getLocationOnScreen(iArr2);
        this.g0 = 1.0f - Math.max(0.0f, Math.min(((iArr2[1] + r2) * 1.0f) / me1.b(this.P, 100), 1.0f));
        LogUtil.d("logprofile", "onNestedPreScroll: y = " + iArr2[1] + ", alpha = " + this.g0);
        float f2 = this.g0;
        if (f2 == 1.0f && this.f0) {
            this.f0 = false;
            this.c.setAlpha(1.0f);
        } else if (f2 < 1.0f) {
            this.f0 = true;
            this.c.setAlpha(f2);
        }
        if (this.g0 == 0.0f) {
            this.d.setVisibility(0);
            this.c.setVisibility(4);
        } else {
            this.d.setVisibility(4);
            this.c.setVisibility(0);
        }
    }

    public final void P() {
        if (this.Q.isCancellation()) {
            this.f.setText(R.string.account_has_cancelled);
            return;
        }
        if (this.Q.isRiskClosure() && this.h0 != 0) {
            this.f.setText(R.string.account_has_forbid);
            return;
        }
        this.f.setText("");
        String strR = r();
        if (TextUtils.isEmpty(strR) && !TextUtils.isEmpty(this.S)) {
            strR = this.S;
        }
        int i2 = this.R;
        if (i2 == 6) {
            N();
            return;
        }
        if ((i2 == 7 || (i2 == 36 && !TextUtils.isEmpty(this.V))) && this.h0 == 2) {
            if (TextUtils.isEmpty(strR)) {
                this.f.setText(this.Q.getNickName());
                return;
            } else {
                this.f.setText(strR);
                return;
            }
        }
        if (TextUtils.isEmpty(strR)) {
            this.f.setText(this.Q.getNickName());
        } else {
            this.f.setText(strR);
        }
    }

    public final void Q() {
        if (this.Q.isCancellation()) {
            this.i.setVisibility(8);
            return;
        }
        if (this.Q.isRiskClosure() && this.h0 != 0) {
            this.i.setVisibility(8);
            return;
        }
        TextView textView = this.f;
        if (textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(this.f.getText().toString())) {
            this.i.setVisibility(8);
        } else if (!this.Q.isOfficialAccount()) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.f.setTextColor(this.P.getResources().getColor(R.color.Gg));
        }
    }

    public final void R() {
        if (this.Q.needHideProfile()) {
            this.r.setVisibility(0);
            this.l.setVisibility(4);
            this.q.setVisibility(4);
            this.n.setVisibility(4);
            this.m.setVisibility(4);
            this.o.setVisibility(4);
            return;
        }
        boolean z = this.h0 == 0 || !m66.d() || this.Q.isPortraitPermission();
        boolean z2 = this.Q.getUid() != null && this.Q.getUid().equals(v4.e(com.zenmen.palmchat.c.b()));
        List<ContactInfoItem.Portrait> listP = p(this.Q);
        if (this.Q.hasPortrait()) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < listP.size()) {
                UserDetailGalleryAdapter.b bVar = new UserDetailGalleryAdapter.b();
                bVar.f13673a = listP.get(i2);
                bVar.b = i2 == 0 || z;
                bVar.c = this.Q;
                arrayList.add(bVar);
                i2++;
            }
            this.l.update(arrayList, this.u);
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < listP.size()) {
                UserDetailThumbnailAdapter.a aVar = new UserDetailThumbnailAdapter.a();
                aVar.b = listP.get(i3);
                aVar.c = this.Q;
                aVar.f13679a = i3 == this.u;
                aVar.e = i3 == 0 || z;
                arrayList2.add(aVar);
                i3++;
            }
            if (z2 && listP.size() > 1) {
                UserDetailThumbnailAdapter.a aVar2 = new UserDetailThumbnailAdapter.a();
                aVar2.d = true;
                arrayList2.add(aVar2);
            }
            this.t.q(arrayList2);
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            ArrayList arrayList3 = new ArrayList();
            if (listP.size() > 0) {
                UserDetailThumbnailAdapter.a aVar3 = new UserDetailThumbnailAdapter.a();
                aVar3.b = listP.get(0);
                aVar3.c = this.Q;
                aVar3.f13679a = true;
                aVar3.e = true;
                arrayList3.add(aVar3);
            }
            this.t.q(arrayList3);
        }
        if (z2 && !this.Q.hasPortrait()) {
            this.q.setVisibility(0);
            this.q.setText("你还没有头像呢");
            this.n.setVisibility(0);
            this.n.setText("上传你的头像，更受欢迎");
        } else if (z2 && listP.size() == 1) {
            this.q.setVisibility(8);
            this.n.setVisibility(0);
            this.n.setText("上传多张头像，人气暴涨");
        } else if (this.Q.hasPortrait()) {
            this.q.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText("Ta还没有头像呢");
            this.n.setVisibility(0);
            this.n.setText("邀请Ta上传自己的头像吧");
        }
        m();
    }

    public void S(ContactInfoItem contactInfoItem, int i2, boolean z) {
        this.Q = contactInfoItem;
        this.h0 = i2;
        G();
        M(contactInfoItem.getFid());
        if (this.Q != null) {
            K();
            R();
            P();
            U();
            u();
            Q();
            if (v8.C(contactInfoItem.getUid()) && v8.o) {
                this.h.setVisibility(0);
                Glide.with((FragmentActivity) this.P).load2(v8.u).error(R.drawable.ai_chat_find_logo_bg).into(this.h);
            } else {
                this.h.setVisibility(8);
            }
            if (i2 != 1 || a65.e(contactInfoItem) || com.zenmen.palmchat.videocall.c.e()) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(8);
            }
            if (this.R == 23) {
                this.z.setVisibility(8);
            }
            if (fu5.u(this.Q)) {
                this.z.setVisibility(8);
            }
            if (this.u0) {
                this.t0.updateUIWithContactInfoItem(this.Q, o());
            } else {
                this.u0 = true;
                this.t0.load(this.P, this.Q, !this.Q.getIsStranger(), 0);
            }
        }
        I();
        H();
        ContactInfoItem contactInfoItem2 = this.Q;
        if (contactInfoItem2 != null) {
            if (!z || i2 == 0) {
                if (contactInfoItem2.needHideProfile()) {
                    this.F.setVisibility(0);
                    this.s0.setVisibility(8);
                    this.t0.setVisibility(8);
                } else {
                    this.s0.setVisibility(0);
                    this.t0.setVisibility(0);
                    this.F.setVisibility(8);
                }
            }
        }
    }

    public void T(List<String> list) {
        UserDetailActivityV2 userDetailActivityV2 = this.P;
        if (userDetailActivityV2 == null || !userDetailActivityV2.isDestroyed()) {
            ContactInfoItem contactInfoItem = this.Q;
            if (contactInfoItem == null || contactInfoItem.isCancellation() || this.Q.getAccountType() == -3 || this.Q.getAccountType() == -4) {
                this.N.setVisibility(8);
                return;
            }
            if (list == null || list.isEmpty() || TextUtils.isEmpty(list.get(0))) {
                this.N.setVisibility(8);
            } else {
                hc2.b(this.P).load(list.get(0)).into(this.N);
                this.N.setVisibility(0);
            }
        }
    }

    public final void U() {
        TextView textView;
        if (this.Q.isCancellation()) {
            this.g.setVisibility(8);
        } else if ((this.Q.isRiskClosure() && this.h0 != 0) || (textView = this.f) == null || textView.getVisibility() != 0 || TextUtils.isEmpty(this.f.getText().toString())) {
            this.g.setVisibility(8);
        } else if (this.h0 == 0) {
            this.g.setVisibility(8);
            if (fg6.d(this.P) || fg6.j(this.P)) {
                this.f.setTextColor(this.P.getResources().getColor(R.color.Gg));
            } else {
                this.f.setTextColor(this.P.getResources().getColor(R.color.Gb));
            }
            fg6.k(AppContext.getContext(), new e());
        } else {
            int iG = fg6.g(this.Q.getExt());
            if (fg6.q(iG)) {
                this.g.setVisibility(0);
                this.g.setImageResource(fg6.e(iG));
            } else {
                this.g.setVisibility(8);
            }
            this.f.setTextColor(fg6.n(this.P, iG));
        }
        this.g.setOnClickListener(new f());
    }

    public void l(int i2, int i3) {
        int i4 = this.R;
        if (i4 == 11 || this.P.W2(i4) || this.h0 != 2) {
            return;
        }
        int i5 = this.R;
        if ((i5 != 7 && i5 != 36) || TextUtils.isEmpty(this.V) || ContactRequestsVO.isSenderParseFromRid(this.V)) {
            if (i2 == 1 || i2 == 2 || i3 == 1 || i3 == 2) {
                this.A.setVisibility(0);
                this.A.setText(R.string.add_friend);
            } else if (this.f13706a != 1) {
                this.A.setVisibility(8);
            } else {
                this.A.setVisibility(0);
                this.A.setText(R.string.add_friend);
            }
        }
    }

    public final void m() {
        if ((this.h0 == 0 || !m66.d() || this.Q.isPortraitPermission()) || this.u == 0) {
            this.o.setVisibility(8);
            return;
        }
        if (this.Q.getAlbum() != null) {
            this.p.setText(this.Q.getAlbum().getAlbumMsg());
        }
        this.o.setVisibility(0);
    }

    public HashMap<String, Object> n() {
        HashMap<String, Object> mapO = o();
        mapO.put("chatbutton", Integer.valueOf(this.B.getVisibility() == 0 ? 1 : 0));
        mapO.put("avchatbutton", Integer.valueOf(this.z.getVisibility() == 0 ? 1 : 0));
        if (this.A.getVisibility() == 0) {
            mapO.put("passbutton", Integer.valueOf(this.m0 ? 1 : 0));
            mapO.put("addbutton", Integer.valueOf(!this.m0 ? 1 : 0));
        } else {
            mapO.put("passbutton", 0);
            mapO.put("addbutton", 0);
        }
        mapO.put("cancelbutton", Integer.valueOf(this.C.getVisibility() == 0 ? 1 : 0));
        int i2 = this.h0;
        mapO.put("relationtype", Integer.valueOf(i2 == 0 ? 2 : i2 == 1 ? 1 : 0));
        mapO.put("friendcircle", Integer.valueOf(this.h0 == 1 ? 1 : 0));
        ContactInfoItem contactInfoItem = this.Q;
        if (contactInfoItem != null) {
            mapO.put("gender", Integer.valueOf(contactInfoItem.getGender()));
            mapO.put("target_uid", this.Q.getUid());
        }
        SquareFeed squareFeed = this.Z;
        if (squareFeed != null) {
            mapO.put("imprId", squareFeed.imprId);
        }
        return mapO;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, Object> o() {
        HashMap<String, Object> mapS = s();
        int i2 = this.R;
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
                        ContactInfoItem contactInfoItem = this.Q;
                        i2 = (contactInfoItem != null && fu5.t(contactInfoItem.getBizType())) ? 35 : 34;
                        break;
                    case 6:
                        i2 = 36;
                        break;
                    case 7:
                    case 8:
                        int i3 = this.W;
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
        mapS.put("from", Integer.valueOf(i2));
        return mapS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.A || view == this.B || view == this.C) {
            if (this.P.W2(this.R) && view == this.A) {
                this.i0.e();
            } else {
                this.i0.b();
            }
            if (view == this.B) {
                HashMap<String, Object> mapO = o();
                SquareFeed squareFeed = this.Z;
                if (squareFeed != null) {
                    mapO.put("imprId", squareFeed.imprId);
                }
                mapO.put("relationtype", Integer.valueOf(this.h0 == 1 ? 1 : 0));
                zn6.j("pageprofil_foot_chatbutton", "click", mapO);
                return;
            }
            if (view == this.C) {
                HashMap<String, Object> mapO2 = o();
                SquareFeed squareFeed2 = this.Z;
                if (squareFeed2 != null) {
                    mapO2.put("imprId", squareFeed2.imprId);
                }
                mapO2.put("relationtype", Integer.valueOf(this.h0 == 1 ? 1 : 0));
                zn6.j("pageprofil_foot_deletebutton", "click", mapO2);
                return;
            }
            if (view == this.A) {
                HashMap<String, Object> mapO3 = o();
                SquareFeed squareFeed3 = this.Z;
                if (squareFeed3 != null) {
                    mapO3.put("imprId", squareFeed3.imprId);
                }
                zn6.j(this.m0 ? "pageprofil_foot_passbutton" : "pageprofil_foot_addbutton", "click", mapO3);
                return;
            }
            return;
        }
        if (view == this.w) {
            this.i0.f();
            return;
        }
        if (view == this.z) {
            this.i0.c();
            HashMap<String, Object> mapO4 = o();
            SquareFeed squareFeed4 = this.Z;
            if (squareFeed4 != null) {
                mapO4.put("imprId", squareFeed4.imprId);
            }
            zn6.j("pageprofil_foot_avchatbutton", "click", mapO4);
            return;
        }
        if (view == this.G) {
            if (this.h0 == 0) {
                v(1);
                return;
            }
            return;
        }
        if (view == this.H) {
            if (this.h0 == 0) {
                v(2);
                zn6.j("profile_charm", "click", new g());
                return;
            }
            return;
        }
        if (view == this.p0) {
            ContactInfoItem contactInfoItem = this.Q;
            if (contactInfoItem == null || il5.l(contactInfoItem.getUid()) || this.Q.isCancellation() || this.h0 == 0) {
                ContactInfoItem contactInfoItem2 = this.Q;
                if (contactInfoItem2 == null || il5.l(contactInfoItem2.getUid()) || this.Q.isCancellation() || this.h0 != 0) {
                    return;
                }
                ve.o(this.P, "zenxin://activity?page=a0052&pkgId=lkme", false);
                zn6.b("page_my_user_detail_likeme");
                return;
            }
            String uid = this.Q.getUid();
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.USER_DETAIL;
            if (sPUtil.a(scene, "key_user_detail_like_status_" + uid, false)) {
                return;
            }
            a46.C(this.q0, R.anim.square_click_like_anim);
            B(uid);
            this.q0.setImageResource(R.drawable.user_detail_like_select_v2);
            sPUtil.t(scene, "key_user_detail_like_status_" + uid, Boolean.TRUE);
            w("click", uid);
        }
    }

    public String q() {
        if (!TextUtils.isEmpty(this.Q.getRemarkName())) {
            return this.Q.getRemarkName();
        }
        if (!jo6.i() || !io0.t(this.W) || TextUtils.isEmpty(this.U)) {
            return "";
        }
        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.U));
        return phoneContactItem != null ? io0.v(phoneContactItem.m()) : "";
    }

    public String r() {
        if (!TextUtils.isEmpty(this.Q.getRemarkName())) {
            return this.Q.getRemarkName();
        }
        if (!io0.t(this.W) || TextUtils.isEmpty(this.U)) {
            return "";
        }
        PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(hs0.g().d(this.U));
        return phoneContactItem != null ? io0.v(phoneContactItem.m()) : "";
    }

    public HashMap<String, Object> s() {
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(this.Q.getUid())) {
            map.put("targetUid", this.Q.getUid());
        }
        if (!TextUtils.isEmpty(this.Q.getExid())) {
            map.put("targetExid", this.Q.getExid());
        }
        return map;
    }

    public final void t() {
        if (l50.a()) {
            return;
        }
        if (this.h0 == 0) {
            this.P.startActivity(nn4.a(this.P, 4));
        } else {
            gs2.g(1, this.P, this.Q, new n());
            zn6.j("newpageprofil_headinvite", "click", new o());
        }
    }

    public final void u() {
        if (this.e0) {
            this.v.setVisibility(8);
        } else {
            if (this.h0 == 2 || this.Q.needHideProfile()) {
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public final void v(int i2) {
        String str = tj2.B() + "?page_type=" + i2;
        Intent intent = new Intent();
        intent.setClass(this.P, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putBoolean("hide_toolbar", true);
        bundle.putBoolean("hide_progressbar", true);
        intent.putExtras(bundle);
        this.P.startActivity(intent);
    }

    public final void w(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetUid", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("pageprofile_heart", str, jSONObject);
    }

    public void x() {
        zn6.j("newpageprofil_gagefail", "view", o());
    }

    public void y() {
        HashMap<String, Object> mapO = o();
        int i2 = 1;
        boolean z = (this.e0 || this.Q.needHideProfile() || UserProfileFragment.j0(this.Q)) ? false : true;
        boolean z2 = (this.e0 || this.Q.needHideProfile() || UserProfileFragment.k0(this.Q)) ? false : true;
        if (z && z2) {
            mapO.put("infor", 3);
        } else if (z) {
            mapO.put("infor", 1);
        } else if (z2) {
            mapO.put("infor", 2);
        } else {
            mapO.put("infor", 0);
        }
        List<ContactLoveBean> loveView = this.Q.getLoveView();
        if (this.e0 || this.Q.needHideProfile() || loveView == null || loveView.size() <= 0) {
            mapO.put("viewpoint", 0);
        } else {
            mapO.put("viewpoint", Integer.valueOf(loveView.size()));
        }
        String hobby = this.Q.getHobby();
        if (!this.e0 && !this.Q.needHideProfile() && (!TextUtils.isEmpty(hobby) || this.h0 == 0)) {
            i2 = 0;
        }
        mapO.put("like", Integer.valueOf(i2));
        mapO.put("headicon_num", Integer.valueOf(p(this.Q).size()));
        zn6.j("newpageprofil_gageshow", "view", mapO);
    }

    public void z() {
        UserDetailPageHelper userDetailPageHelper = this.t0;
        if (userDetailPageHelper != null) {
            userDetailPageHelper.onDestory();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements gs2.b {
        public n() {
        }

        @Override // gs2.b
        public void a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements LoopingViewPager.c {
        public h() {
        }

        @Override // com.zenmen.palmchat.peoplematch.view.LoopingViewPager.c
        public void b(int i) {
            c.this.u = i;
            c.this.t.s(c.this.u);
            c.this.m();
            zn6.j("newpageprofil_headclick", "click", c.this.o());
        }

        @Override // com.zenmen.palmchat.peoplematch.view.LoopingViewPager.c
        public void a(int i, float f) {
        }
    }
}
