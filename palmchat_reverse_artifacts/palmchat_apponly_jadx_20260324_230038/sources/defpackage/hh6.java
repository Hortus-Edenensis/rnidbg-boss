package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.opensource.svgaplayer.SVGAImageView;
import com.ss.bytertc.engine.data.AudioRoute;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.lxvoip.vertc.R$anim;
import com.zenmen.palmchat.lxvoip.vertc.R$drawable;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutVoiceMatchCallPanelBinding;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import defpackage.c15;
import defpackage.kd3;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hh6 extends n0 implements kd3.a0 {
    public LayoutVoiceMatchCallPanelBinding q;
    public RcySAdapter<String, RcyHolder> r;
    public np2 s;
    public boolean t;
    public boolean u;
    public kd3 v;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> map = new HashMap<>();
            map.put("reason", "3");
            hh6.this.s.b("audioMatch_oncall_public", map);
            hh6.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17960a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f17960a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17960a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17960a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17960a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends RcySAdapter<String, RcyHolder> {
        public e(Context context, int i) {
            super(context, i);
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, String str, int i) {
            ((TextView) rcyHolder.l(R$id.content)).setText(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hh6.this.q.g0.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "view");
            map.put("clickType", "1");
            hh6.this.s.b("audioMatch_oncall_videoChatButton", map);
            hh6.this.q.E.setVisibility(0);
            String str = hh6.this.s.i().getVideoChatConfig().inviteButton;
            if (!TextUtils.isEmpty(str)) {
                hh6.this.q.F.setText(str);
            }
            hh6.this.q.C.startAnimation(AnimationUtils.loadAnimation(hh6.this.f19399a, R$anim.voice_match_invite_scale));
            VoiceMatchConfig voiceMatchConfigI = hh6.this.s.i();
            if (voiceMatchConfigI != null) {
                hh6.this.s.v().add(voiceMatchConfigI.getVideoChatConfig().tips);
                hh6.this.r.g(hh6.this.s.v(), true);
                hh6.this.q.J.smoothScrollToPosition(hh6.this.r.getData().size() - 1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hh6.this.r.g(hh6.this.s.v(), true);
            hh6.this.q.J.smoothScrollToPosition(hh6.this.r.getData().size() - 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements op2 {
        public i() {
        }

        @Override // defpackage.op2
        public void a(VoiceMatchType voiceMatchType) {
            hh6.this.v.t(voiceMatchType);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hh6.this.q.r.setTextColor(Color.parseColor("#050505"));
            hh6.this.v.w(er4.f());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            hh6.this.q.s.setTextColor(Color.parseColor("#050505"));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17968a;

        public l(int i) {
            this.f17968a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            hh6.this.q0(Math.max(1, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f17968a)));
        }
    }

    public hh6(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable) {
        super(fragmentActivity, activityVideoCallVoipBinding, str, str2, str3, runnable);
        this.r = null;
        this.t = false;
        this.u = true;
        this.s = ap3.a().T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        this.v.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        this.s.onEvent("audioMatch_oncall_topic");
        this.s.w(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        this.s.z(false, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        this.s.z(true, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        this.v.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        this.s.onEvent("audioMatch_oncall_mini");
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        this.s.onEvent(com.volcengine.lxvertc.videocall.call.a.t().r() == VoipState.IDLE ? "audioMatch_end_report" : "audioMatch_oncall_report");
        e0();
        this.s.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        this.f19399a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        this.v.r();
    }

    @Override // defpackage.n0
    public void C() {
        super.C();
        if (com.volcengine.lxvertc.videocall.call.a.t().z() == null && !this.t && !this.v.f18630a) {
            this.s.s();
        }
        this.v.p();
    }

    @Override // defpackage.n0
    public void E(VoipState voipState) {
        int i2 = c.f17960a[voipState.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                this.f.setText(R$string.calling_wait_accept);
                this.f.setVisibility(0);
                this.q.e.setVisibility(8);
                this.q.z.setVisibility(0);
                this.q.V.setVisibility(0);
                this.q.S.setVisibility(0);
                this.q.A.setText("取消");
            } else if (i2 == 3) {
                this.f.setVisibility(8);
                this.q.e.setVisibility(8);
                this.q.z.setVisibility(0);
                this.q.V.setVisibility(0);
                this.q.S.setVisibility(0);
                this.q.A.setText("挂断");
            } else if (i2 == 4) {
                this.f.setText(R$string.called_audio_wait_accept);
                this.f.setVisibility(0);
                this.q.e.setVisibility(0);
                this.q.z.setVisibility(0);
                this.q.V.setVisibility(8);
                this.q.S.setVisibility(8);
                this.q.A.setText("拒绝");
            }
        } else if (!this.v.b) {
            t0();
        }
        K();
        J();
    }

    @Override // defpackage.n0
    public void F() {
        super.F();
        this.q.x.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: wg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21698a.w(view);
            }
        }));
        this.q.M.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: zg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22416a.x(view);
            }
        }));
        this.q.i.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: ah6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1231a.y(view);
            }
        }));
        this.q.B.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: bh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1720a.z(view);
            }
        }));
        this.q.f0.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: ch6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1992a.k0(view);
            }
        }));
        this.q.L.setMatchClick(new i());
        this.q.v.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: dh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17053a.l0(view);
            }
        }));
        this.q.h0.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: eh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17303a.m0(view);
            }
        }));
        this.q.r.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: fh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17532a.n0(view);
            }
        }));
        this.q.s.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: gh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17727a.o0(view);
            }
        }));
        this.j.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: xg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21956a.p0(view);
            }
        }));
        this.q.E.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: yg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22194a.j0(view);
            }
        }));
    }

    @Override // defpackage.n0
    public void J() {
        super.J();
        this.g.setImageResource(this.o.d() == AudioRoute.AUDIO_ROUTE_SPEAKERPHONE ? R$drawable.ic_vm_speaker_enable_new : R$drawable.ic_vm_speaker_normal_new);
        this.h.setTextColor(Color.parseColor("#222222"));
    }

    @Override // defpackage.n0
    public void K() {
        super.K();
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(this.o.f() ? R$drawable.ic_vm_silence_enable_new : R$drawable.ic_vm_silence_normal_new);
    }

    @Override // kd3.a0
    public void b() {
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            if (this.s.e()) {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(contactInfoItemF.getIconURL())).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).into(this.q.P);
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(contactInfoItemF.getIconURL())).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).transform(f0()).into(this.q.P);
            }
            this.q.Q.setText(contactInfoItemF.getNameForShow());
            s0(this.q.H, this.s.x().currentLevel);
        }
        RoomUserInfo roomUserInfoH0 = h0();
        if (roomUserInfoH0 != null) {
            if (this.s.y()) {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoH0.headImg)).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).into(this.q.h0);
                this.q.i0.setText(roomUserInfoH0.nickName);
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoH0.headImg)).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).transform(f0()).into(this.q.h0);
                this.q.i0.setText(g0(roomUserInfoH0.nickName));
            }
            s0(this.q.I, roomUserInfoH0.level);
        }
        if (this.s.y() && this.s.e()) {
            this.q.B.setVisibility(8);
            this.q.K.setVisibility(8);
        } else {
            this.q.B.setVisibility(0);
            this.q.K.setVisibility(0);
            if (!this.s.e()) {
                this.q.B.setText("我要公开身份");
            } else if (this.s.h()) {
                this.q.B.setText("等待对方公开身份");
                this.q.B.setEnabled(false);
            } else {
                this.q.B.setText("邀请ta公开身份");
            }
        }
        this.r.g(this.s.v(), true);
        this.q.J.smoothScrollToPosition(this.r.getData().size() - 1);
        if (this.s.B()) {
            this.q.F.setText("接听视频");
        } else if (this.s.r()) {
            this.q.F.setText("等待接听");
        } else {
            this.q.F.setText("邀ta视频");
        }
    }

    @Override // kd3.a0
    public void c(String str) {
        q0(1);
        this.q.N.setAlpha(1.0f);
        this.q.O.setText(str);
        this.q.N.setVisibility(0);
        int iG = me1.g() - me1.b(this.f19399a, 32);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.addUpdateListener(new l(iG));
        valueAnimator.start();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.q.N, "alpha", 1.0f, 0.0f).setDuration(200L);
        duration.setStartDelay(2500L);
        duration.addListener(new a());
        duration.start();
    }

    @Override // kd3.a0
    public void d() {
        if (!this.s.y()) {
            sy5.h(this.f19399a, "对方未公开身份，无法查看个人主页及更多资料", 1);
            return;
        }
        this.s.onEvent("audioMatch_oncall_avatar_click");
        e0();
        this.s.C();
    }

    @Override // kd3.a0
    public void e() {
        this.q.L.setVisibility(0);
        this.q.L.updateUI(ap3.a().T().x());
    }

    public final void e0() {
        if (vg6.w()) {
            this.t = true;
            vg6.t().C(this.k);
            this.f19399a.finish();
        }
    }

    public final y5 f0() {
        return new y5(8, 4);
    }

    public final String g0(String str) {
        if (str.length() == 1) {
            return "*";
        }
        if (str.length() == 2) {
            return str.substring(0, 1) + "*";
        }
        if (str.length() < 3) {
            return str;
        }
        return str.substring(0, 1) + "*" + str.substring(str.length() - 1, str.length());
    }

    public final RoomUserInfo h0() {
        return this.s.x().getMatchUserInfo();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.q.e0.getLayoutParams();
        layoutParams.setMargins(0, me1.h(this.f19399a), 0, 0);
        this.q.e0.setLayoutParams(layoutParams);
        this.q.u.setVisibility(8);
        this.q.Y.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.q.Y.setFillMode(SVGAImageView.FillMode.Clear);
        this.q.Y.setLoops(Integer.MAX_VALUE);
        this.q.Y.setClearsAfterDetached(true);
        String string = null;
        c15.INSTANCE.b().n("svga/match_chatting.svga", new d(), null);
        RoomUserInfo roomUserInfoH0 = h0();
        if (roomUserInfoH0 != null) {
            if (roomUserInfoH0.sex == 1) {
                this.q.c.setText("关于她");
                this.q.b.setImageResource(R$drawable.ic_vm_female);
            } else {
                this.q.c.setText("关于他");
                this.q.b.setImageResource(R$drawable.ic_vm_male);
            }
            if (TextUtils.isEmpty(roomUserInfoH0.incomeTip)) {
                this.q.p.setVisibility(8);
            } else {
                this.q.n.setText(roomUserInfoH0.incomeTip);
                this.q.p.setVisibility(0);
            }
            int[] iArr = roomUserInfoH0.intention;
            if (iArr != null && iArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < roomUserInfoH0.intention.length; i2++) {
                    sb.append(hs1.e().f(roomUserInfoH0.intention[i2]));
                    if (i2 != roomUserInfoH0.intention.length - 1) {
                        sb.append("，");
                    }
                }
                string = sb.toString();
            }
            if (TextUtils.isEmpty(string)) {
                this.q.q.setVisibility(8);
            } else {
                this.q.o.setText(string);
                this.q.q.setVisibility(0);
            }
            this.q.K.setText("聊满n分钟自动公开身份".replace("n", String.valueOf(this.s.x().getAutoOpenIdMinutes())));
        }
        e eVar = new e(this.f19399a, R$layout.item_vm_message);
        this.r = eVar;
        this.q.J.setAdapter(eVar);
        this.q.J.setLayoutManager(new LinearLayoutManager(this.f19399a, 1, false));
        this.r.g(this.s.v(), true);
        this.q.J.smoothScrollToPosition(this.r.getData().size() - 1);
        if (!this.u) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (sPUtil.a(scene, "key_has_topic_bubble_show", false)) {
                this.q.g0.setVisibility(8);
            } else {
                sPUtil.t(scene, "key_has_topic_bubble_show", Boolean.TRUE);
                this.q.g0.setVisibility(0);
                this.q.g0.postDelayed(new f(), 3000L);
            }
        }
        this.s.c(new g());
        b();
    }

    @Override // defpackage.n0
    public void n() {
        if (m()) {
            if (!vg6.w()) {
                vg6.D(this.f19399a);
            } else {
                vg6.t().C(this.k);
                this.f19399a.finish();
            }
        }
    }

    @Override // defpackage.n0
    public TextView o() {
        return this.e;
    }

    public final void q0(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.q.N.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i2;
        this.q.N.setLayoutParams(layoutParams);
    }

    public void r0(int i2) {
        if (i2 >= this.s.x().getAutoOpenIdMinutes() * 60) {
            this.s.g(new b());
        }
    }

    public void s0(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view;
        TextView textView = (TextView) viewGroup.getChildAt(0);
        ImageView imageView = (ImageView) viewGroup.getChildAt(1);
        textView.setText("Lv." + i2);
        int i3 = R$drawable.vm_level_0;
        if (i2 == 1) {
            i3 = R$drawable.vm_level_1;
        } else if (i2 == 2) {
            i3 = R$drawable.vm_level_2;
        } else if (i2 == 3) {
            i3 = R$drawable.vm_level_3;
        } else if (i2 == 4) {
            i3 = R$drawable.vm_level_4;
        } else if (i2 == 5) {
            i3 = R$drawable.vm_level_5;
        }
        imageView.setImageResource(i3);
    }

    public final void t0() {
        this.q.E.setVisibility(8);
        this.q.m.setVisibility(8);
        this.q.J.setVisibility(8);
        this.q.f0.setVisibility(8);
        this.q.g0.setVisibility(8);
        this.q.x.setVisibility(8);
        this.q.j.setVisibility(8);
        this.q.i.setVisibility(0);
        this.q.u.setVisibility(0);
        RoomUserInfo roomUserInfoH0 = h0();
        if (roomUserInfoH0 != null) {
            if (this.s.y()) {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoH0.headImg)).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).into(this.q.v);
                this.q.w.setText(roomUserInfoH0.nickName);
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoH0.headImg)).placeholder(com.zenmen.palmchat.framework.R$drawable.default_portrait).transform(f0()).into(this.q.v);
                this.q.w.setText(g0(roomUserInfoH0.nickName));
            }
            s0(this.q.G, roomUserInfoH0.level);
        }
        e();
        String strB = i86.b(com.volcengine.lxvertc.videocall.call.a.t().u());
        int i2 = roomUserInfoH0 != null && roomUserInfoH0.sex == 1 ? this.s.i().exitseconds_female : this.s.i().exitseconds_male;
        VoiceMatchInfo voiceMatchInfoX = ap3.a().T().x();
        if (voiceMatchInfoX != null && voiceMatchInfoX.isVoiceMatch && voiceMatchInfoX.voiceMatchType != VoiceMatchType.NORMAL) {
            i2 = this.s.i().exitseconds_payer;
        }
        boolean z = er4.f() && com.volcengine.lxvertc.videocall.call.a.t().u() < i2;
        String str = z ? this.s.i().ending.exit : (this.s.y() && this.s.e()) ? this.s.i().ending.profileopend : this.s.i().ending.profilenotopen;
        this.q.t.setText("通话时间" + strB + "，" + str);
        VoiceMatchInfo voiceMatchInfoX2 = this.s.x();
        int i3 = voiceMatchInfoX2.commentState;
        if (i3 == 1) {
            this.q.r.setTextColor(Color.parseColor("#050505"));
        } else if (i3 == 2) {
            this.q.s.setTextColor(Color.parseColor("#050505"));
        }
        HashMap<String, String> map = new HashMap<>();
        SkuItem skuItem = voiceMatchInfoX2.getSkuItem(VoiceMatchType.SAME_CITY);
        map.put("localview", skuItem != null ? "1" : "0");
        map.put("localnum", String.valueOf(skuItem != null ? skuItem.remainingQuantity : 0));
        this.s.b("audioMatch_end", map);
        this.v.n(er4.f(), z, com.volcengine.lxvertc.videocall.call.a.t().v());
        this.v.m();
    }

    @Override // defpackage.n0
    public void u() {
        this.b.k.inflate();
        LayoutVoiceMatchCallPanelBinding layoutVoiceMatchCallPanelBindingA = LayoutVoiceMatchCallPanelBinding.a(this.b.getRoot().findViewById(R$id.voice_match_call_panel));
        this.q = layoutVoiceMatchCallPanelBindingA;
        this.e = layoutVoiceMatchCallPanelBindingA.k;
        this.c = layoutVoiceMatchCallPanelBindingA.R;
        this.d = layoutVoiceMatchCallPanelBindingA.T;
        this.g = layoutVoiceMatchCallPanelBindingA.U;
        this.h = layoutVoiceMatchCallPanelBindingA.W;
        this.i = layoutVoiceMatchCallPanelBindingA.d;
        this.j = layoutVoiceMatchCallPanelBindingA.y;
        this.f = layoutVoiceMatchCallPanelBindingA.l;
        F();
        i0();
        kd3 kd3Var = new kd3(this.f19399a, this.s, this, this);
        this.v = kd3Var;
        kd3Var.o();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            hh6.this.q.O.setText("");
            hh6.this.q0(1);
            hh6.this.q.N.setAlpha(1.0f);
            hh6.this.q.N.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
        }
    }

    @Override // defpackage.n0
    public void I(boolean z) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements c15.d {
        public d() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            hh6.this.q.Y.setVideoItem(m15Var);
            hh6.this.q.Y.startAnimation();
        }

        @Override // c15.d
        public void onError() {
        }
    }

    @Override // kd3.a0
    public void a() {
    }
}
