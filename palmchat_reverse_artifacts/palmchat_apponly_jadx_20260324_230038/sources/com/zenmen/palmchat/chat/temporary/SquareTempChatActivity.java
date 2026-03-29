package com.zenmen.palmchat.chat.temporary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.fragment.SimpleChatFragment;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXPortraitView;
import com.zenmen.square.fragment.online.OnLineDetailActiveInfo;
import com.zenmen.square.fragment.online.OnLineDetailData;
import defpackage.ap3;
import defpackage.az2;
import defpackage.bg5;
import defpackage.bj5;
import defpackage.bo0;
import defpackage.d20;
import defpackage.e20;
import defpackage.fg6;
import defpackage.fu5;
import defpackage.hb3;
import defpackage.il5;
import defpackage.me1;
import defpackage.nw5;
import defpackage.sd3;
import defpackage.x20;
import defpackage.z64;
import defpackage.zh;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SquareTempChatActivity extends BaseActionBarActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public TextView F;
    public TextView G;
    public ImageView H;
    public View J;
    public View K;
    public View L;
    public boolean M;
    public String N;
    public String O;
    public FrameLayout P;
    public FrameLayout Q;
    public OnLineDetailData R;
    public ContactInfoItem s;
    public SimpleChatFragment t;
    public View w;
    public LXPortraitView x;
    public ImageView y;
    public TextView z;
    public int q = 0;
    public int r = 0;
    public int u = -1;
    public int v = -1;
    public SimpleChatFragment.v I = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SimpleChatFragment.v {
        public a() {
        }

        @Override // com.zenmen.palmchat.chat.fragment.SimpleChatFragment.v
        public FrameworkBaseActivity b() {
            return SquareTempChatActivity.this;
        }

        @Override // com.zenmen.palmchat.chat.fragment.SimpleChatFragment.v
        public ViewGroup c() {
            if (SquareTempChatActivity.this.Q != null) {
                return SquareTempChatActivity.this.Q;
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.fragment.SimpleChatFragment.v
        public ViewGroup d() {
            if (SquareTempChatActivity.this.P != null) {
                return SquareTempChatActivity.this.P;
            }
            return null;
        }

        @Override // com.zenmen.palmchat.chat.fragment.SimpleChatFragment.v
        public View getTitleView() {
            if (SquareTempChatActivity.this.w != null) {
                return SquareTempChatActivity.this.w;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            SquareTempChatActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements zh.a<ThreadChatItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12901a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public c(int i, ContactInfoItem contactInfoItem, Activity activity, String str, String str2, String str3) {
            this.f12901a = i;
            this.b = contactInfoItem;
            this.c = activity;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // zh.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ThreadChatItem threadChatItem) {
            int i;
            int i2 = this.f12901a;
            if (threadChatItem != null && threadChatItem.isContactReady && threadChatItem.activeStatus == 1) {
                i2 = threadChatItem.bizType;
                i = i2;
            } else {
                i = -1;
            }
            LogUtil.i("logaddfriend", "square  startchat bizType=" + i2 + " prebizType= " + i + " fBizType=" + this.f12901a);
            this.b.setBizType(i2);
            if (e20.a()) {
                bj5.b().a().g(this.c, this.b, this.d, -1);
                return;
            }
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) SquareTempChatActivity.class);
            intent.putExtra("chat_item", this.b);
            intent.putExtra("EXTRA_INPUT_TEXT", this.e);
            if (!TextUtils.isEmpty(this.f)) {
                intent.putExtra("online_gift_data", this.f);
            }
            intent.putExtra("thread_biz_type", i2);
            if (i2 == 65 || i2 == 68 || i2 == 5062) {
                intent.putExtra("extra_key_impr_id", this.d);
            } else {
                intent.putExtra("extra_key_square_feed", this.d);
            }
            this.c.startActivity(intent);
            this.c.overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements zh.a<ThreadChatItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12902a;
        public final /* synthetic */ ContactInfoItem b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public d(int i, ContactInfoItem contactInfoItem, Activity activity, String str, int i2, int i3, int i4) {
            this.f12902a = i;
            this.b = contactInfoItem;
            this.c = activity;
            this.d = str;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // zh.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ThreadChatItem threadChatItem) {
            int i;
            int i2 = this.f12902a;
            if (threadChatItem != null && threadChatItem.isContactReady && threadChatItem.activeStatus == 1) {
                i2 = threadChatItem.bizType;
                i = i2;
            } else {
                i = -1;
            }
            LogUtil.i("logaddfriend", "square  startchat2 bizType=" + i2 + " prebizType= " + i + " fBizType=" + this.f12902a);
            this.b.setBizType(i2);
            if (e20.a()) {
                bj5.b().a().g(this.c, this.b, this.d, this.e);
                return;
            }
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) SquareTempChatActivity.class);
            intent.putExtra("chat_item", this.b);
            intent.putExtra("thread_biz_type", i2);
            intent.putExtra(EventParams.KEY_CT_SDK_POSITION, this.f);
            intent.putExtra("click_area", this.g);
            intent.putExtra("superExposeMsgTabItem", this.e);
            if (i2 == 65 || i2 == 68 || i2 == 5062) {
                intent.putExtra("extra_key_impr_id", this.d);
            } else {
                intent.putExtra("extra_key_square_feed", this.d);
            }
            this.c.startActivity(intent);
            this.c.overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                SquareTempChatActivity.this.finish();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements bg5.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareTempChatActivity squareTempChatActivity = SquareTempChatActivity.this;
                squareTempChatActivity.V1(squareTempChatActivity.M);
            }
        }

        public f() {
        }

        @Override // bg5.a
        public void a() {
            SquareTempChatActivity.this.K.postDelayed(new a(), 50L);
        }

        @Override // bg5.a
        public void b(int i, int i2) {
            SquareTempChatActivity.this.V1(true);
            SquareTempChatActivity.this.t.D1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bg5 f12906a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements InputFragment.g1 {
            public a() {
            }

            @Override // com.zenmen.palmchat.chat.InputFragment.g1
            public void a(boolean z) {
                SquareTempChatActivity.this.M = z;
                if (z) {
                    SquareTempChatActivity.this.V1(true);
                    SquareTempChatActivity.this.t.D1();
                } else {
                    g gVar = g.this;
                    SquareTempChatActivity.this.V1(gVar.f12906a.b());
                }
            }
        }

        public g(bg5 bg5Var) {
            this.f12906a = bg5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SquareTempChatActivity.this.t.S0() == null) {
                return;
            }
            SquareTempChatActivity.this.t.S0().v3(new a());
        }
    }

    public static void I1(Activity activity, ContactInfoItem contactInfoItem, int i, String str) {
        K1(activity, contactInfoItem, i, str, "", "");
    }

    public static void J1(Activity activity, ContactInfoItem contactInfoItem, int i, String str, int i2, int i3, int i4) {
        if (activity == null) {
            return;
        }
        nw5.g(contactInfoItem.getChatId(), new d(i, contactInfoItem, activity, str, i4, i2, i3));
    }

    public static void K1(Activity activity, ContactInfoItem contactInfoItem, int i, String str, String str2, String str3) {
        if (activity == null) {
            return;
        }
        nw5.g(contactInfoItem.getChatId(), new c(i, contactInfoItem, activity, str, str2, str3));
    }

    public final void L1() {
        R1();
        T1();
    }

    public final void M1() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.s = (ContactInfoItem) intent.getParcelableExtra("chat_item");
        this.r = intent.getIntExtra("thread_biz_type", 0);
        this.u = intent.getIntExtra(EventParams.KEY_CT_SDK_POSITION, -1);
        this.v = intent.getIntExtra("click_area", -1);
        int intExtra = intent.getIntExtra("superExposeMsgTabItem", -1);
        this.q = intExtra;
        if (intExtra == -1 && fu5.s(this.r)) {
            this.q = 1;
        }
        this.N = intent.getStringExtra("extra_key_square_feed");
        this.O = intent.getStringExtra("EXTRA_INPUT_TEXT");
        String stringExtra = intent.getStringExtra("online_gift_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.R = (OnLineDetailData) az2.a(stringExtra, OnLineDetailData.class);
    }

    public final void N1() {
        View view = this.J;
        if (view != null) {
            view.setOnTouchListener(new e());
        }
        bg5 bg5Var = new bg5(this.K, false);
        bg5Var.a(new f());
        this.K.postDelayed(new g(bg5Var), 200L);
    }

    public final void O1() {
        View viewFindViewById = this.w.findViewById(R.id.risk_notify_layout);
        ContactInfoItem contactInfoItem = this.s;
        int accountType = contactInfoItem != null ? contactInfoItem.getAccountType() : 0;
        String strD = ap3.a().x().d(accountType);
        if (TextUtils.isEmpty(strD)) {
            viewFindViewById.setVisibility(8);
            return;
        }
        if (accountType == -4 || accountType == -3) {
            HashMap map = new HashMap();
            ContactInfoItem contactInfoItem2 = this.s;
            map.put("fuid", contactInfoItem2 != null ? contactInfoItem2.getUid() : "");
            map.put("scene", "nofrd");
            map.put("window", "half");
            map.put("type", "risklevel");
            zn6.i("risktip_chat", map);
        }
        viewFindViewById.setVisibility(0);
        TextView textView = (TextView) this.w.findViewById(R.id.risk_notify_tv);
        textView.setText(strD);
        if (accountType == -3 || accountType == -4) {
            viewFindViewById.setBackgroundColor(Color.parseColor("#FCE9E9"));
            textView.setTextColor(Color.parseColor("#FF463C"));
            this.w.findViewById(R.id.risk_notify_serious).setVisibility(0);
        }
    }

    public final void P1() {
        this.K = findViewById(R.id.root_view);
        this.J = findViewById(R.id.empty_layout);
        this.L = findViewById(R.id.chat_layout);
        View viewInflate = getLayoutInflater().inflate(R.layout.title_layout_square, (ViewGroup) null);
        this.w = viewInflate;
        this.x = (LXPortraitView) viewInflate.findViewById(R.id.iv_avatar);
        this.y = (ImageView) this.w.findViewById(R.id.iv_gender);
        this.z = (TextView) this.w.findViewById(R.id.tv_name);
        this.A = (TextView) this.w.findViewById(R.id.tv_gender);
        this.B = (TextView) this.w.findViewById(R.id.tv_age);
        this.C = (TextView) this.w.findViewById(R.id.tv_district);
        this.E = (TextView) this.w.findViewById(R.id.tv_signature);
        this.F = (TextView) this.w.findViewById(R.id.tv_official);
        this.H = (ImageView) this.w.findViewById(R.id.iv_vip);
        this.G = (TextView) this.w.findViewById(R.id.tv_occupation);
        this.x.getPortraitView().changeShapeType(1);
        this.x.getPortraitView().setDegreeForRoundRectangle(me1.b(this, 6), me1.b(this, 6));
        this.x.getPortraitView().setBorderWidth(me1.b(this, 2));
        this.x.getPortraitView().setBorderColor(-1);
        this.P = (FrameLayout) findViewById(R.id.large_gift_container);
        this.Q = (FrameLayout) findViewById(R.id.small_gift_container);
        this.t = new SimpleChatFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("chat_item", this.s);
        bundle.putInt("thread_biz_type", this.r);
        bundle.putInt(EventParams.KEY_CT_SDK_POSITION, this.u);
        bundle.putInt("click_area", this.v);
        bundle.putInt("superExposeMsgTabItem", this.q);
        if (this.r == 64) {
            bundle.putString("extra_key_input_hint_text", getString(R.string.input_hint_text_aquare));
        }
        bundle.putBoolean("extra_key_auto_show_keyboard", true);
        bundle.putString("extra_key_square_feed", this.N);
        bundle.putString("EXTRA_INPUT_TEXT", this.O);
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putString("extra_key_impr_id", intent.getStringExtra("extra_key_impr_id"));
        }
        this.t.setArguments(bundle);
        this.t.G1(this.I);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_translate_in, R.anim.activity_translate_out).replace(this.L.getId(), this.t, SimpleChatFragment.f0).commit();
        O1();
    }

    public boolean Q1() {
        if (this.s.getChatType() != 0) {
            return false;
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(this.s.getChatId());
        if (contactInfoItemL != null) {
            return contactInfoItemL.getIsStranger();
        }
        return true;
    }

    public final void R1() {
        ContactInfoItem contactInfoItem;
        int i;
        if (this.w == null || (contactInfoItem = this.s) == null) {
            return;
        }
        String iconURL = contactInfoItem.getIconURL();
        String nameForShow = this.s.getNameForShow();
        int gender = this.s.getGender();
        String age = this.s.getAge();
        String strI = il5.i(this, this.s.getCountry(), this.s.getProvince(), this.s.getCity());
        String signature = this.s.getSignature();
        String occupationForShow = this.s.getOccupationForShow();
        if (iconURL != null) {
            this.x.setAvatarView(iconURL, this.s.getAmulet());
        }
        if (gender == 0) {
            this.y.setVisibility(0);
            this.y.setImageResource(R.drawable.icon_male);
            this.A.setVisibility(0);
            this.A.setText(getString(R.string.complete_gender_male));
        } else if (gender == 1) {
            this.y.setVisibility(0);
            this.y.setImageResource(R.drawable.icon_female);
            this.A.setVisibility(0);
            this.A.setText(getString(R.string.complete_gender_female));
        } else {
            this.y.setVisibility(4);
            this.A.setVisibility(8);
        }
        if (TextUtils.isEmpty(nameForShow)) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
            this.z.setText(nameForShow);
        }
        try {
            i = Integer.parseInt(age);
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i <= 0) {
            this.B.setVisibility(8);
        } else {
            this.B.setVisibility(0);
            this.B.setText(String.format(getString(R.string.people_match_setting_age), age));
        }
        if (TextUtils.isEmpty(strI)) {
            this.C.setVisibility(8);
        } else {
            this.C.setVisibility(0);
            this.C.setText(strI);
        }
        if (TextUtils.isEmpty(occupationForShow)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.G.setText(occupationForShow);
        }
        if (TextUtils.isEmpty(signature)) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
            this.E.setText(signature);
        }
        if (this.s.isOfficialAccount()) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        int iG = fg6.g(this.s.getExt());
        if (fg6.q(iG)) {
            this.H.setVisibility(0);
            this.H.setImageResource(fg6.c(iG));
        } else {
            this.H.setVisibility(8);
        }
        if (this.s.isOfficialAccount()) {
            this.z.setTextColor(getResources().getColor(R.color.Gg));
        } else {
            this.z.setTextColor(fg6.n(this, iG));
        }
    }

    public void S1() {
        SimpleChatFragment simpleChatFragment = this.t;
        if (simpleChatFragment == null || simpleChatFragment.S0() == null) {
            return;
        }
        this.t.S0().g3(x20.b());
    }

    public final void T1() {
        OnLineDetailActiveInfo onLineDetailActiveInfo;
        try {
            OnLineDetailData onLineDetailData = this.R;
            if (onLineDetailData == null || (onLineDetailActiveInfo = onLineDetailData.activeInfo) == null) {
                return;
            }
            int i = (int) onLineDetailActiveInfo.panelId;
            int i2 = (int) onLineDetailActiveInfo.itemId;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.s.getChatId());
            HashMap map = new HashMap();
            int bizType = this.s.getBizType();
            String str = DomainHelper.m(this.s).domain;
            map.put("domain", str);
            if (DomainHelper.Domains.DOMAIN_PRIVATE.domain.equalsIgnoreCase(str) && fu5.q(bizType)) {
                map.put("bizType", Integer.valueOf(bizType + AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite));
            } else {
                map.put("bizType", Integer.valueOf(bizType));
            }
            String str2 = this.s.getChatId() + str;
            String strReplace = UUID.randomUUID().toString().replace("-", "");
            String string = new JSONObject(map).toString();
            long jCurrentTimeMillis = System.currentTimeMillis();
            OnLineDetailActiveInfo onLineDetailActiveInfo2 = this.R.activeInfo;
            com.zenmen.palmchat.giftkit.b.j().l(i, 2, str2, false, i2, 1, false, strReplace, arrayList, string, jCurrentTimeMillis, onLineDetailActiveInfo2.price, "", false, onLineDetailActiveInfo2.itemName);
        } catch (Exception unused) {
        }
    }

    public void U1() {
        SimpleChatFragment simpleChatFragment = this.t;
        if (simpleChatFragment == null || !simpleChatFragment.isAdded()) {
            return;
        }
        this.t.H1();
    }

    public final void V1(boolean z) {
        float f2;
        if (z) {
            f2 = 7.0f;
        } else {
            f = hb3.g().i() ? 0.8f : 1.0f;
            f2 = 1.5f;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.J.getLayoutParams();
        layoutParams.weight = f;
        this.J.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.L.getLayoutParams();
        layoutParams2.weight = f2;
        this.L.setLayoutParams(layoutParams2);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UserProfileGuide.k(this, 13);
        ContactInfoItem contactInfoItem = this.s;
        if (contactInfoItem != null && contactInfoItem.getBizType() == 5055 && this.R == null) {
            z64.H(this.s, this);
        }
        overridePendingTransition(R.anim.alpha_fade_in, R.anim.alpha_fade_out);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SimpleChatFragment simpleChatFragment = this.t;
        if (simpleChatFragment == null || !simpleChatFragment.J()) {
            super.onBackPressed();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_square_temp_chat);
        getWindow().setSoftInputMode(16);
        M1();
        if (this.s == null) {
            finish();
            return;
        }
        P1();
        N1();
        L1();
        d20.m(false);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        SimpleChatFragment simpleChatFragment = this.t;
        if (simpleChatFragment != null) {
            simpleChatFragment.v1(permissionType, permissionUsage, z);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TeenagersModeManager.a().d() && Q1()) {
            new sd3(this).k("青少年模式下，陌生人私聊暂不支持使用").n(GravityEnum.CENTER).P("返回").b(false).h(false).f(new b()).e().show();
        }
    }
}
