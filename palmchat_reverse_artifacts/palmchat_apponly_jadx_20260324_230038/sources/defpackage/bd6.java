package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Rational;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.lxvoip.vertc.R$id;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.lxvoip.vertc.databinding.ActivityVideoCallVoipBinding;
import com.zenmen.palmchat.lxvoip.vertc.databinding.LayoutVideoMatchCallPanelBinding;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import defpackage.jy;
import defpackage.kd3;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class bd6 extends n0 implements kd3.a0 {
    public VoiceMatchInfo A;
    public long B;
    public Runnable C;
    public final Handler D;
    public boolean E;
    public LayoutVideoMatchCallPanelBinding q;
    public TextureView r;
    public TextureView s;
    public mb6 t;
    public final HashMap<String, Boolean> u;
    public String v;
    public boolean w;
    public np2 x;
    public RcySAdapter<String, RcyHolder> y;
    public kd3 z;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1689a;

        static {
            int[] iArr = new int[VoipState.values().length];
            f1689a = iArr;
            try {
                iArr[VoipState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1689a[VoipState.CALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1689a[VoipState.ONTHECALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1689a[VoipState.RINGING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bd6.this.L0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements jy {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jy
        public void a(jy.a aVar) {
            LogUtil.i("VideoMatchCallComponent", "joinRoom " + aVar.b);
            if (aVar.b) {
                bd6.this.E = false;
            } else {
                hg5.g((String) aVar.f18531a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchInfo f1692a;

        public d(VoiceMatchInfo voiceMatchInfo) {
            this.f1692a = voiceMatchInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ry5.a((bd6.this.A == null || !bd6.this.A.isInvitedVideo) ? "视频通话已取消（视频卡已退回）" : "视频通话已取消");
            bd6.this.m0(true);
            HashMap<String, String> map = new HashMap<>();
            map.put("reportType", "click");
            RoomSDKInfo roomSDKInfo = this.f1692a.chattinginfo;
            if (roomSDKInfo != null) {
                map.put("newRoomId", roomSDKInfo.roomId);
            }
            bd6.this.x.b("audioMatch_videoChat_hold", map);
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
            TextView textView = (TextView) rcyHolder.l(R$id.content);
            if (str == null || !str.startsWith("[提示]")) {
                textView.setText(str);
                return;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF463C")), 0, 4, 33);
            textView.setText(spannableString);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bd6.this.f19399a == null || bd6.this.f19399a.isFinishing() || com.volcengine.lxvertc.videocall.call.a.t().r() != VoipState.ONTHECALL || bd6.this.w) {
                return;
            }
            bd6.this.w = true;
            LogUtil.i("VideoMatchCallComponent", "autoExchangeRenderView");
            bd6.this.n0();
            bd6.this.M0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> map = new HashMap<>();
            map.put("reason", "3");
            bd6.this.x.b("audioMatch_oncall_public", map);
            bd6.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements op2 {
        public h() {
        }

        @Override // defpackage.op2
        public void a(VoiceMatchType voiceMatchType) {
            bd6.this.z.t(voiceMatchType);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bd6.this.q.l.setTextColor(Color.parseColor("#050505"));
            bd6.this.z.w(er4.f());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bd6.this.q.m.setTextColor(Color.parseColor("#050505"));
        }
    }

    public bd6(FragmentActivity fragmentActivity, ActivityVideoCallVoipBinding activityVideoCallVoipBinding, String str, String str2, String str3, Runnable runnable, VoiceMatchInfo voiceMatchInfo) {
        super(fragmentActivity, activityVideoCallVoipBinding, str, str2, str3, runnable);
        this.u = new HashMap<>(2);
        this.w = false;
        this.y = null;
        this.B = 0L;
        this.C = new b();
        this.D = new Handler();
        this.E = false;
        this.x = ap3.a().T();
        this.A = voiceMatchInfo;
        LogUtil.i("VideoMatchCallComponent", "VideoMatchCallComponent init " + az2.c(voiceMatchInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(View view) {
        this.x.z(true, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        this.z.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        this.x.onEvent(com.volcengine.lxvertc.videocall.call.a.t().r() == VoipState.IDLE ? "audioMatch_end_report" : "audioMatch_oncall_report");
        n();
        this.x.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        this.z.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        this.f19399a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        this.x.onEvent("audioMatch_oncall_mini");
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        this.x.onEvent("audioMatch_oncall_mini");
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        this.x.onEvent(com.volcengine.lxvertc.videocall.call.a.t().r() == VoipState.IDLE ? "audioMatch_end_report" : "audioMatch_oncall_report");
        n();
        this.x.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        this.x.z(false, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        n0();
        M0();
    }

    public void A0() {
        LogUtil.i("VideoMatchCallComponent", "onFirstLocalVideoFrameCaptured");
        (z0() ? this.r : this.s).setVisibility(0);
    }

    public void B0(String str, String str2) {
        LogUtil.i("VideoMatchCallComponent", "onFirstRemoteVideoFrameDecoded");
        this.q.e0.setVisibility(0);
        this.v = str;
        this.u.put(str2, Boolean.TRUE);
        H0(z0() ? this.s : this.r, str2);
        if (this.o != null) {
            N0();
        }
    }

    @Override // defpackage.n0
    public void C() {
        super.C();
        LogUtil.i("VideoMatchCallComponent", "onDestroy " + this + " state=" + com.volcengine.lxvertc.videocall.call.a.t().z() + " isSwitchingVideo=" + this.z.f18630a);
        if (com.volcengine.lxvertc.videocall.call.a.t().z() == null && !this.z.f18630a) {
            this.x.s();
        }
        this.z.p();
        this.D.removeCallbacks(this.C);
    }

    public void C0(boolean z, Configuration configuration) {
        mb6 mb6Var = this.t;
        if (mb6Var != null) {
            mb6Var.e(z, this.v);
        }
    }

    public final void D0() {
        LogUtil.i("VideoMatchCallComponent", "onPreview end " + az2.c(this.A));
        this.x.j(this.A);
        b();
        this.q.C.setVisibility(8);
        this.q.X.setVisibility(0);
        com.volcengine.lxvertc.videocall.call.a.t().K(this.A.chattinginfo, CallType.VIDEO, new c());
    }

    @Override // defpackage.n0
    public void E(VoipState voipState) {
        LogUtil.i("VideoMatchCallComponent", "refreshUi newState " + voipState);
        int i2 = a.f1689a[voipState.ordinal()];
        if (i2 == 1) {
            K0();
        } else if (i2 == 3) {
            this.q.u.setText("挂断");
        }
        K();
        J();
        J0();
        N0();
    }

    public final void E0(VoiceMatchInfo voiceMatchInfo) {
        LogUtil.i("VideoMatchCallComponent", "onPreview start " + az2.c(voiceMatchInfo));
        HashMap<String, String> map = new HashMap<>();
        map.put("reportType", "view");
        RoomSDKInfo roomSDKInfo = voiceMatchInfo.chattinginfo;
        if (roomSDKInfo != null) {
            map.put("newRoomId", roomSDKInfo.roomId);
        }
        this.x.b("audioMatch_videoChat_hold", map);
        this.E = true;
        this.o.t();
        this.q.e0.setVisibility(8);
        this.q.C.setVisibility(0);
        this.q.X.setVisibility(8);
        this.q.A.setOnClickListener(new d(voiceMatchInfo));
        this.B = ir5.b();
        this.D.postDelayed(this.C, 500L);
        VoiceMatchConfig voiceMatchConfigI = this.x.i();
        this.q.B.setText(voiceMatchInfo.isInvitedVideo ? voiceMatchConfigI.getVideoChatConfig().inviteeHolding : voiceMatchConfigI.getVideoChatConfig().inviterHolding);
    }

    @Override // defpackage.n0
    public void F() {
        super.F();
        this.q.r.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: pc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19993a.w(view);
            }
        }));
        this.q.w.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: uc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21191a.x(view);
            }
        }));
        this.q.y.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: vc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21407a.y(view);
            }
        }));
        this.q.e0.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: wc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21674a.z(view);
            }
        }));
        this.q.J.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: xc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21931a.t0(view);
            }
        }));
        this.q.G.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: yc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22175a.u0(view);
            }
        }));
        this.q.g.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: zc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f22394a.v0(view);
            }
        }));
        this.q.I.setMatchClick(new h());
        this.q.p.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: ad6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1212a.w0(view);
            }
        }));
        this.q.V.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: qc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20228a.x0(view);
            }
        }));
        this.q.l.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: rc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20454a.y0(view);
            }
        }));
        this.q.m.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: sc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20715a.r0(view);
            }
        }));
        this.j.setOnClickListener(lv0.a(new View.OnClickListener() { // from class: tc6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20960a.s0(view);
            }
        }));
    }

    public void F0(String str) {
        this.w = true;
        LogUtil.i("VideoMatchCallComponent", "onUserJoined");
        this.q.e0.setVisibility(0);
        n0();
        M0();
    }

    public void G0(String str, boolean z) {
        Object tag;
        this.u.put(str, Boolean.valueOf(z));
        TextureView textureView = this.r;
        if (textureView == null || (tag = textureView.getTag(R$id.render_view_uid)) == null) {
            return;
        }
        H0(TextUtils.equals((String) tag, str) ? this.r : this.s, str);
        if (!TextUtils.equals(p(), str)) {
            if (!z) {
                hg5.d(R$string.remote_user_close_camera);
            }
            N0();
        } else {
            J0();
            if (z) {
                return;
            }
            hg5.d(R$string.local_user_close_camera);
        }
    }

    public final void H0(TextureView textureView, String str) {
        textureView.setTag(R$id.render_view_uid, str);
        boolean z = this.u.get(str) != null && Boolean.TRUE.equals(this.u.get(str));
        if (!z || !TextUtils.equals(p(), str)) {
            textureView.setVisibility(z ? 0 : 8);
        }
        if (TextUtils.equals(p(), str)) {
            this.o.r(textureView);
        } else {
            this.o.s(str, this.v, textureView);
        }
    }

    @Override // defpackage.n0
    public void I(boolean z) {
        this.q.X.setVisibility(z ? 8 : 0);
    }

    public void I0(int i2) {
        VoiceMatchConfig voiceMatchConfigI = this.x.i();
        if (voiceMatchConfigI != null) {
            int i3 = (voiceMatchConfigI.totalMinutes * 60) - i2;
            if (i3 > 0) {
                String strB = i86.b(i3);
                this.q.v.setText(strB);
                mb6 mb6Var = this.t;
                if (mb6Var != null) {
                    mb6Var.j(strB, i3 < 60 ? SupportMenu.CATEGORY_MASK : -1);
                }
                if (i3 == 60) {
                    this.x.v().add(voiceMatchConfigI.countDownTips);
                    this.y.g(this.x.v(), true);
                    this.q.z.smoothScrollToPosition(this.y.getData().size() - 1);
                    this.q.v.setTextColor(SupportMenu.CATEGORY_MASK);
                }
            } else {
                D();
            }
        }
        if (i2 >= this.x.x().getAutoOpenIdMinutes() * 60) {
            this.x.g(new g());
        }
    }

    public final void J0() {
        this.u.get(p());
    }

    public final void K0() {
        if (this.A == null || !this.E) {
            this.q.o.setVisibility(0);
        } else {
            this.q.o.setVisibility(8);
        }
        RoomUserInfo roomUserInfoP0 = p0();
        if (roomUserInfoP0 != null) {
            if (this.x.y()) {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoP0.headImg)).placeholder(R$drawable.default_portrait).into(this.q.p);
                this.q.q.setText(roomUserInfoP0.nickName);
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoP0.headImg)).placeholder(R$drawable.default_portrait).transform(new y5(8, 4)).into(this.q.p);
                this.q.q.setText(o0(roomUserInfoP0.nickName));
            }
        }
        if (this.x.x().isVoiceMatch) {
            this.q.S.setText("语音匹配");
        } else {
            this.q.S.setText("视频匹配");
        }
        this.q.I.setVoiceType(this.x.x().isVoiceMatch);
        e();
        String strB = i86.b(com.volcengine.lxvertc.videocall.call.a.t().u());
        int i2 = roomUserInfoP0 != null && roomUserInfoP0.sex == 1 ? this.x.i().exitseconds_female : this.x.i().exitseconds_male;
        VoiceMatchInfo voiceMatchInfoX = ap3.a().T().x();
        if (voiceMatchInfoX != null && voiceMatchInfoX.isVoiceMatch && voiceMatchInfoX.voiceMatchType != VoiceMatchType.NORMAL) {
            i2 = this.x.i().exitseconds_payer;
        }
        boolean z = er4.f() && com.volcengine.lxvertc.videocall.call.a.t().u() < i2;
        String str = z ? this.x.i().ending.exit : (this.x.y() && this.x.e()) ? this.x.i().ending.profileopend : this.x.i().ending.profilenotopen;
        this.q.n.setText("通话时间" + strB + "，" + str);
        VoiceMatchInfo voiceMatchInfoX2 = this.x.x();
        int i3 = voiceMatchInfoX2.commentState;
        if (i3 == 1) {
            this.q.l.setTextColor(Color.parseColor("#050505"));
        } else if (i3 == 2) {
            this.q.m.setTextColor(Color.parseColor("#050505"));
        }
        if (!this.E) {
            HashMap<String, String> map = new HashMap<>();
            SkuItem skuItem = voiceMatchInfoX2.getSkuItem(VoiceMatchType.SAME_CITY);
            map.put("localview", skuItem != null ? "1" : "0");
            map.put("localnum", String.valueOf(skuItem != null ? skuItem.remainingQuantity : 0));
            this.x.b("audioMatch_end", map);
            this.z.n(er4.f(), z, com.volcengine.lxvertc.videocall.call.a.t().v());
        }
        this.z.m();
    }

    public final void L0() {
        this.D.removeCallbacks(this.C);
        int i2 = this.x.i().getVideoChatConfig().holdSeconds;
        int iE = (int) (ir5.e(this.B) / 1000);
        LogUtil.i("VideoMatchCallComponent", "updatePreviewDuring pastTime " + iE);
        if (iE > i2) {
            D0();
            return;
        }
        TextView textView = this.q.E;
        textView.setText((i2 - iE) + "s...");
        this.D.postDelayed(this.C, 1000L);
    }

    public final void M0() {
        String bigIconURL;
        boolean zZ0 = z0();
        RoomUserInfo roomUserInfoP0 = p0();
        ContactInfoItem contactInfoItemF = v4.f();
        if (zZ0) {
            bigIconURL = contactInfoItemF != null ? contactInfoItemF.getBigIconURL() : null;
            if (roomUserInfoP0 != null) {
                str = roomUserInfoP0.headImg;
            }
        } else {
            String bigIconURL2 = contactInfoItemF != null ? contactInfoItemF.getBigIconURL() : null;
            str = bigIconURL2;
            bigIconURL = roomUserInfoP0 != null ? roomUserInfoP0.headImg : null;
        }
        kc2<Drawable> kc2VarLoad = hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(str));
        int i2 = com.zenmen.palmchat.lxvoip.vertc.R$drawable.video_call_icon_loading_fail_bg;
        kc2VarLoad.error(i2).transform(new gu(14, 4)).into(this.q.i);
        hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(bigIconURL)).error(i2).transform(new gu(14, 4)).into(this.q.h);
    }

    public final void N0() {
        mb6 mb6Var = this.t;
        if (mb6Var == null) {
            return;
        }
        this.t.k(mb6Var.c(), this.v);
    }

    @Override // kd3.a0
    public void a() {
        VoiceMatchInfo voiceMatchInfo = this.A;
        ry5.a((voiceMatchInfo == null || !voiceMatchInfo.isInvitedVideo) ? "视频通话已取消（视频卡已退回）" : "视频通话已取消");
        if (this.E) {
            m0(false);
        } else if (com.volcengine.lxvertc.videocall.call.a.t().r() == VoipState.ONTHECALL) {
            D();
        }
    }

    @Override // kd3.a0
    public void b() {
        RoomUserInfo roomUserInfoP0 = p0();
        if (roomUserInfoP0 != null) {
            if (this.x.y()) {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoP0.headImg)).placeholder(R$drawable.default_portrait).into(this.q.U);
                this.q.W.setText(roomUserInfoP0.nickName);
            } else {
                hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(roomUserInfoP0.headImg)).placeholder(R$drawable.default_portrait).transform(new y5(8, 4)).into(this.q.U);
                this.q.W.setText(o0(roomUserInfoP0.nickName));
            }
        }
        if (this.x.y() && this.x.e()) {
            this.q.H.setText("已互相公开");
            this.q.G.setEnabled(false);
            this.q.F.setImageResource(com.zenmen.palmchat.lxvoip.vertc.R$drawable.ic_video_match_btn_publish_done);
        } else if (this.x.e()) {
            if (this.x.h()) {
                this.q.H.setText("邀ta公开资料");
                this.q.G.setEnabled(false);
            } else {
                this.q.H.setText("邀ta公开资料");
            }
            this.q.F.setImageResource(com.zenmen.palmchat.lxvoip.vertc.R$drawable.ic_video_match_btn_publish_done);
        } else {
            this.q.H.setText("公开资料");
            this.q.F.setImageResource(com.zenmen.palmchat.lxvoip.vertc.R$drawable.ic_video_match_btn_publish);
        }
        this.y.g(this.x.v(), true);
        this.q.z.smoothScrollToPosition(this.y.getData().size() - 1);
    }

    @Override // kd3.a0
    public void c(String str) {
        this.x.v().add("[提示]" + str);
        this.y.g(this.x.v(), true);
        this.q.z.smoothScrollToPosition(this.y.getData().size() - 1);
    }

    @Override // kd3.a0
    public void d() {
        if (!this.x.y()) {
            sy5.h(this.f19399a, "对方未公开身份，无法查看个人主页及更多资料", 1);
            return;
        }
        this.x.onEvent("audioMatch_oncall_avatar_click");
        n();
        this.x.C();
    }

    @Override // kd3.a0
    public void e() {
        this.q.I.setVisibility(0);
        this.q.I.updateUI(ap3.a().T().x());
    }

    public final void m0(boolean z) {
        if (z) {
            this.x.a();
        }
        LogUtil.i("VideoMatchCallComponent", "cancelVideoImp " + z);
        this.D.removeCallbacks(this.C);
        this.E = false;
        this.o.y();
        K0();
        this.q.C.setVisibility(8);
        this.q.o.setVisibility(0);
    }

    @Override // defpackage.n0
    public void n() {
        if (m()) {
            if (this.t == null) {
                FragmentActivity fragmentActivity = this.f19399a;
                ActivityVideoCallVoipBinding activityVideoCallVoipBinding = this.b;
                LayoutVideoMatchCallPanelBinding layoutVideoMatchCallPanelBinding = this.q;
                this.t = new mb6(fragmentActivity, activityVideoCallVoipBinding, layoutVideoMatchCallPanelBinding.Z, layoutVideoMatchCallPanelBinding.f0, this.u);
            }
            this.t.a(new Rational(90, 130), q(), this.k);
        }
    }

    public final void n0() {
        TextureView textureView = z0() ? this.s : this.r;
        H0(textureView, p());
        String strQ = q();
        TextureView textureView2 = this.s;
        if (textureView == textureView2) {
            textureView2 = this.r;
        }
        H0(textureView2, strQ);
    }

    public final String o0(String str) {
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

    public final RoomUserInfo p0() {
        return this.x.x().getMatchUserInfo();
    }

    public final void q0() {
        VoiceMatchInfo voiceMatchInfo = this.A;
        if (voiceMatchInfo != null) {
            E0(voiceMatchInfo);
        }
        e eVar = new e(this.f19399a, R$layout.item_vm_message_video);
        this.y = eVar;
        this.q.z.setAdapter(eVar);
        this.q.z.setLayoutManager(new LinearLayoutManager(this.f19399a, 1, false));
        this.y.g(this.x.v(), true);
        this.q.z.smoothScrollToPosition(this.y.getData().size() - 1);
        b();
        M0();
        if (this.A == null) {
            u93.b(3000, new f());
        }
    }

    @Override // defpackage.n0
    public void t() {
        dr4 dr4Var;
        boolean zS = s();
        if (!zS && (dr4Var = this.o) != null) {
            dr4Var.m(true);
        }
        this.u.put(p(), Boolean.valueOf(zS));
        this.u.put(q(), Boolean.TRUE);
        this.v = this.x.x().chattinginfo.roomId;
    }

    @Override // defpackage.n0
    public void u() {
        this.b.f.inflate();
        LayoutVideoMatchCallPanelBinding layoutVideoMatchCallPanelBindingA = LayoutVideoMatchCallPanelBinding.a(this.b.getRoot().findViewById(R$id.video_match_call_panel));
        this.q = layoutVideoMatchCallPanelBindingA;
        this.c = layoutVideoMatchCallPanelBindingA.M;
        this.d = layoutVideoMatchCallPanelBindingA.O;
        this.g = layoutVideoMatchCallPanelBindingA.P;
        this.h = layoutVideoMatchCallPanelBindingA.R;
        this.i = layoutVideoMatchCallPanelBindingA.b;
        this.j = layoutVideoMatchCallPanelBindingA.s;
        TextureView textureView = layoutVideoMatchCallPanelBindingA.Z;
        this.r = textureView;
        this.s = layoutVideoMatchCallPanelBindingA.f0;
        this.f = layoutVideoMatchCallPanelBindingA.x;
        H0(textureView, p());
        if (!s()) {
            hg5.d(R$string.camera_permission_hint);
        }
        F();
        q0();
        kd3 kd3Var = new kd3(this.f19399a, this.x, this, this);
        this.z = kd3Var;
        kd3Var.o();
    }

    public final boolean z0() {
        return TextUtils.equals((String) this.r.getTag(R$id.render_view_uid), p());
    }
}
