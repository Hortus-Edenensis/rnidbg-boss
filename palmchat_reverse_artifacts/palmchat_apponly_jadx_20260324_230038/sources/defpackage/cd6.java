package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.databinding.LayoutActivityVoiceMatchBinding;
import com.zenmen.palmchat.databinding.LayoutVideoMatchPanelBinding;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.paidservices.voicematch.FastGuideDialog;
import com.zenmen.palmchat.paidservices.voicematch.TextVerticalLoopView;
import com.zenmen.palmchat.paidservices.voicematch.VoiceMatchState;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cd6 extends r0 implements View.OnClickListener {
    public LayoutActivityVoiceMatchBinding c;
    public LayoutVideoMatchPanelBinding d;
    public f e = new f(this);
    public ValueAnimator f;
    public TextVerticalLoopView g;
    public FrameworkBaseActivity h;
    public ky4 i;
    public il4 j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements op2 {
        public a() {
        }

        @Override // defpackage.op2
        public void a(VoiceMatchType voiceMatchType) {
            HashMap<String, String> mapU = lh6.V().U();
            mapU.put("retryType", String.valueOf(voiceMatchType.type));
            zn6.i("audioMatch_fail_retry", mapU);
            cd6.this.q(voiceMatchType, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cd6.this.d.f13907a.startLightingAnimation(-1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (cd6.this.f == null) {
                int width = cd6.this.d.t.getWidth();
                if (width == 0) {
                    width = me1.b(AppContext.getContext(), 110);
                }
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(cd6.this.d.s, PropertyValuesHolder.ofFloat("alpha", 0.1f, 0.6f), PropertyValuesHolder.ofFloat("translationX", 0.0f, width));
                objectAnimatorOfPropertyValuesHolder.setInterpolator(new AccelerateInterpolator(0.5f));
                objectAnimatorOfPropertyValuesHolder.setRepeatCount(1000);
                objectAnimatorOfPropertyValuesHolder.setDuration(1100L);
                cd6.this.f = objectAnimatorOfPropertyValuesHolder;
            }
            cd6.this.f.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchType f1959a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements FastGuideDialog.d {
            public a() {
            }

            @Override // com.zenmen.palmchat.paidservices.voicematch.FastGuideDialog.d
            public void onConfirm() {
                if (lh6.V().b0() == VoiceMatchState.IDEL || lh6.V().b0() == VoiceMatchState.MATCHING || lh6.V().b0() == VoiceMatchState.ERROR) {
                    zn6.i("audioMatch_speedup_popup_click", lh6.V().U());
                    cd6.this.q(VoiceMatchType.FAST, 3);
                }
            }
        }

        public d(VoiceMatchType voiceMatchType) {
            this.f1959a = voiceMatchType;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1959a == VoiceMatchType.NORMAL && lh6.V().b0() == VoiceMatchState.ERROR && lh6.V().x().errorCode == 1023) {
                VoiceMatchConfig voiceMatchConfigI = lh6.V().i();
                new FastGuideDialog(cd6.this.h, new a(), voiceMatchConfigI != null ? voiceMatchConfigI.timeUpPOP : "次数已用完，使用加速卡额外匹配一次").show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1961a;

        static {
            int[] iArr = new int[VoiceMatchState.values().length];
            f1961a = iArr;
            try {
                iArr[VoiceMatchState.IDEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1961a[VoiceMatchState.MATCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1961a[VoiceMatchState.PROPMATCHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1961a[VoiceMatchState.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1961a[VoiceMatchState.CHAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1961a[VoiceMatchState.MATCHFAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<cd6> f1962a;

        public f(cd6 cd6Var) {
            this.f1962a = new WeakReference<>(cd6Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f1962a.get() != null) {
                    this.f1962a.get().w();
                }
                removeMessages(0);
                sendEmptyMessageDelayed(0, 3000L);
                return;
            }
            if (i != 1) {
                return;
            }
            if (this.f1962a.get() != null && lh6.V().b0() == VoiceMatchState.MATCHING) {
                this.f1962a.get().v();
                removeMessages(0);
                sendEmptyMessageDelayed(0, 3000L);
            }
            removeMessages(1);
        }
    }

    public cd6(FrameworkBaseActivity frameworkBaseActivity, LayoutActivityVoiceMatchBinding layoutActivityVoiceMatchBinding, ky4 ky4Var) {
        this.h = frameworkBaseActivity;
        this.c = layoutActivityVoiceMatchBinding;
        this.i = ky4Var;
    }

    @Override // defpackage.r0, defpackage.xm2
    public void a(VoiceMatchState voiceMatchState) {
        LogUtil.i("VideoMatchComponent", "updateUI" + voiceMatchState);
        VoiceMatchInfo voiceMatchInfoX = lh6.V().x();
        boolean z = true;
        switch (e.f1961a[voiceMatchState.ordinal()]) {
            case 1:
                this.d.B.setVisibility(8);
                z(true);
                u(0, null, null);
                this.d.y.setVisibility(8);
                this.d.G.setVisibility(8);
                boolean zB = tg4.b(this.h, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL.permissionList);
                u(zB ? 0 : VoiceMatchInfo.ERROR_PERMISSION, null, null);
                if (zB) {
                    this.j.a(this.d.I);
                } else {
                    z(false);
                }
                r();
                t();
                s();
                break;
            case 2:
                this.j.a(this.d.I);
                u(0, null, null);
                this.d.C.setText("超多声音好听的小姐姐在等你聊天");
                this.d.E.setVisibility(0);
                this.d.y.setVisibility(8);
                this.d.B.setVisibility(0);
                this.d.F.setVisibility(8);
                this.d.G.setVisibility(8);
                z(true);
                n();
                p();
                this.e.sendEmptyMessageDelayed(1, lh6.V().i().fake_timeout * 1000);
                break;
            case 3:
                this.j.a(this.d.I);
                u(0, null, null);
                z(false);
                this.d.y.setVisibility(0);
                this.d.B.setVisibility(8);
                this.d.F.setVisibility(8);
                this.d.G.setVisibility(8);
                VoiceMatchConfig voiceMatchConfigI = lh6.V().i();
                VoiceMatchType voiceMatchType = voiceMatchInfoX.voiceMatchType;
                if (voiceMatchType == VoiceMatchType.FAST) {
                    this.d.z.setImageResource(R.drawable.ic_voice_match_prop_fast_video);
                    this.d.s.setImageResource(R.drawable.ic_voice_match_fast_matching_arrow);
                    if (voiceMatchConfigI.speedup != null) {
                        TextView textView = this.d.u;
                        String[] strArr = voiceMatchInfoX.title;
                        textView.setText((strArr == null || strArr.length <= 0) ? "正在加速匹配中" : strArr[0]);
                    }
                } else if (voiceMatchType == VoiceMatchType.SAME_CITY) {
                    this.d.z.setImageResource(R.drawable.ic_voice_match_prop_city_video);
                    this.d.s.setImageResource(R.drawable.ic_voice_match_city_matching_arrow);
                    TextView textView2 = this.d.u;
                    String[] strArr2 = voiceMatchInfoX.title;
                    textView2.setText((strArr2 == null || strArr2.length <= 0) ? "正在同城匹配中" : strArr2[0]);
                }
                n();
                o();
                break;
            case 4:
                int i = voiceMatchInfoX.errorCode;
                String[] strArr3 = voiceMatchInfoX.title;
                String str = (strArr3 == null || strArr3.length <= 0) ? null : strArr3[0];
                String[] strArr4 = voiceMatchInfoX.subTitle;
                String str2 = (strArr4 == null || strArr4.length <= 0) ? null : strArr4[0];
                if (i == -1 || i == -2) {
                    u(i, null, null);
                    this.d.B.setVisibility(8);
                    this.d.G.setVisibility(8);
                    this.d.y.setVisibility(8);
                    z(false);
                    this.d.y.setVisibility(8);
                } else if (i == 1021) {
                    u(1021, str, str2);
                    this.d.B.setVisibility(8);
                    this.d.G.setVisibility(8);
                    this.d.y.setVisibility(8);
                    z(false);
                    this.d.y.setVisibility(8);
                } else if (i == 1020) {
                    u(1020, str, str2);
                    this.d.B.setVisibility(8);
                    this.d.G.setVisibility(8);
                    this.d.y.setVisibility(8);
                    z(false);
                    this.d.y.setVisibility(8);
                } else if (i == -10088) {
                    u(VoiceMatchInfo.ERROR_LOCATION_FAIL, "定位失败", null);
                    this.d.B.setVisibility(8);
                    this.d.y.setVisibility(8);
                    z(true);
                    this.d.y.setVisibility(8);
                } else {
                    z(true);
                    u(0, null, null);
                    this.d.y.setVisibility(8);
                    this.d.G.setVisibility(8);
                    if (i != 1022) {
                        this.d.C.setText(str);
                        this.d.F.setVisibility(0);
                        this.d.F.setText(str2);
                        this.d.E.setVisibility(8);
                        this.d.B.setVisibility(0);
                    } else {
                        this.d.B.setVisibility(8);
                        if (tg4.b(this.h, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL.permissionList)) {
                            this.j.a(this.d.I);
                        }
                    }
                    z = false;
                }
                if (z) {
                    this.j.b();
                }
                r();
                t();
                s();
                break;
            case 5:
                this.j.b();
                this.d.G.setVisibility(8);
                z(false);
                r();
                t();
                s();
                break;
            case 6:
                this.j.b();
                u(0, null, null);
                VoiceMatchInfo voiceMatchInfoX2 = lh6.V().x();
                TextView textView3 = this.d.C;
                String[] strArr5 = voiceMatchInfoX2.title;
                textView3.setText((strArr5 == null || strArr5.length <= 0) ? "匹配失败，排队人太多了" : strArr5[0]);
                this.d.F.setVisibility(0);
                TextView textView4 = this.d.F;
                String[] strArr6 = voiceMatchInfoX2.subTitle;
                textView4.setText((strArr6 == null || strArr6.length <= 0) ? "使用加速卡，效率翻3倍" : strArr6[0]);
                this.d.E.setVisibility(8);
                this.d.B.setVisibility(0);
                y(voiceMatchInfoX);
                this.d.y.setVisibility(8);
                z(false);
                this.d.y.setVisibility(8);
                r();
                t();
                s();
                break;
        }
    }

    @Override // defpackage.xm2
    public View b() {
        return this.d.getRoot();
    }

    @Override // defpackage.r0
    public void c() {
        super.c();
        il4 il4Var = this.j;
        if (il4Var != null) {
            il4Var.b();
        }
    }

    @Override // defpackage.r0
    public void d() {
        super.d();
        LayoutVideoMatchPanelBinding layoutVideoMatchPanelBindingB = LayoutVideoMatchPanelBinding.b(LayoutInflater.from(this.h));
        this.d = layoutVideoMatchPanelBindingB;
        layoutVideoMatchPanelBindingB.getRoot().setVisibility(8);
        this.c.o.addView(this.d.getRoot());
        m();
    }

    @Override // defpackage.r0
    public void e() {
        super.e();
    }

    public final void m() {
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            hc2.a(com.zenmen.palmchat.c.b()).load(k86.p(contactInfoItemF.getIconURL())).placeholder(R.drawable.ic_default_portrait).transform(new y5(16, 8)).into(this.d.A);
        }
        this.d.c.setOnClickListener(this);
        this.d.n.setOnClickListener(this);
        this.d.G.setMatchClick(new a());
        this.d.F.setOnClickListener(this);
        this.d.d.setOnClickListener(this);
        this.d.k.setOnClickListener(this);
        TextVerticalLoopView textVerticalLoopView = new TextVerticalLoopView(this.h, 14.0f, -1);
        this.g = textVerticalLoopView;
        this.d.E.addView(textVerticalLoopView, new ViewGroup.LayoutParams(-1, -2));
        this.g.setTextStillTime(5000L);
        this.g.setAnimTime(300L);
        this.j = new il4();
    }

    public final void o() {
        u93.b(100, new c());
        this.e.sendEmptyMessage(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        LayoutVideoMatchPanelBinding layoutVideoMatchPanelBinding = this.d;
        if (view == layoutVideoMatchPanelBinding.n) {
            q(VoiceMatchType.FAST, 0);
            return;
        }
        if (view == layoutVideoMatchPanelBinding.c) {
            if (lh6.V().e0() || lh6.V().x() == null) {
                return;
            }
            q(VoiceMatchType.NORMAL, 0);
            return;
        }
        if (view == layoutVideoMatchPanelBinding.d) {
            q(VoiceMatchType.SAME_CITY, 0);
            return;
        }
        LinearLayout linearLayout = layoutVideoMatchPanelBinding.k;
        if (view == linearLayout) {
            Integer num = (Integer) linearLayout.getTag();
            if (num.intValue() == -1) {
                q(VoiceMatchType.NORMAL, 0);
            }
            if (num.intValue() == -2) {
                lh6.V().w0();
            } else if (num.intValue() != -10088 && num.intValue() == -10089) {
                BaseActivityPermissionDispatcher.b(this.h, BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH_VIDEO);
            }
        }
    }

    @Override // defpackage.xm2
    public void onDestroy() {
        r();
        t();
        s();
    }

    @Override // defpackage.r0, defpackage.xm2
    public void onPause() {
        super.onPause();
        if (this.j == null || lh6.V().b0() == VoiceMatchState.CHAT) {
            return;
        }
        this.j.b();
    }

    @Override // defpackage.r0, defpackage.xm2
    public void onResume() {
        super.onResume();
        a(lh6.V().b0());
    }

    public final void p() {
        this.e.sendEmptyMessage(0);
        this.g.setDataList(lh6.V().X());
        this.g.startAutoScroll();
    }

    public final void q(VoiceMatchType voiceMatchType, int i) {
        lh6.V().E0(voiceMatchType, i, new d(voiceMatchType));
    }

    public final void r() {
        this.i.d();
    }

    public final void s() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void t() {
        this.e.removeMessages(0);
        this.e.removeMessages(1);
        this.g.stopAutoScroll();
    }

    public final void u(int i, String str, String str2) {
        LogUtil.i("VideoMatchComponent", "updateErrorView " + i + " " + str + " " + str2);
        int color = Color.parseColor("#88FFFFFF");
        int i2 = R.drawable.ic_voice_match_video_permission;
        if (i == -10089) {
            boolean zB = tg4.b(this.h, "android.permission.CAMERA");
            boolean zB2 = tg4.b(this.h, "android.permission.RECORD_AUDIO");
            str = (!zB || zB2) ? (zB || !zB2) ? "匹配失败，未开启麦克风和摄像头权限" : "匹配失败，未开启摄像头权限" : "匹配失败，未开启麦克风权限";
            color = Color.parseColor("#14CD64");
            str2 = "去开启";
        } else if (i == 1023) {
            i2 = R.drawable.ic_voice_match_net_error_video_fail;
        } else if (i == -2 || i == -1) {
            i2 = R.drawable.ic_voice_match_net_error_video;
            str = "获取失败，请稍后重试";
        } else if (i == 1020) {
            i2 = R.drawable.ic_voice_match_empty;
            str = "功能内测中，仅受邀用户可参与";
            str2 = "敬请期待哦~";
        } else if (i != 1021) {
            str = "加入匹配失败";
            i2 = R.drawable.ic_voice_match_net_error_video_fail;
        }
        this.d.k.setTag(Integer.valueOf(i));
        if (i == 0) {
            this.d.k.setVisibility(8);
        } else {
            this.d.k.setVisibility(0);
        }
        this.d.j.setImageResource(i2);
        if (!TextUtils.isEmpty(str)) {
            this.d.m.setText(str);
        }
        if (i == -1 || i == -2) {
            SpannableString spannableString = new SpannableString("加载失败，点击刷新");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), 5, 9, 33);
            this.d.m.setText(spannableString);
        }
        if (TextUtils.isEmpty(str2)) {
            this.d.l.setVisibility(8);
        } else {
            this.d.l.setText(str2);
            this.d.l.setVisibility(0);
        }
        this.d.l.setTextColor(color);
    }

    public final void v() {
        this.d.C.setText(lh6.V().i().match_timeout);
        HashMap<String, String> mapU = lh6.V().U();
        mapU.put("duration", String.valueOf(ir5.e(lh6.V().x().startMatchTime)));
        zn6.i("audioMatch_timeout", mapU);
    }

    public final void w() {
        if (lh6.V().b0() == VoiceMatchState.MATCHING) {
            this.d.C.setText(lh6.V().Z());
        } else if (lh6.V().b0() == VoiceMatchState.PROPMATCHING) {
            this.d.t.setText(lh6.V().a0());
            this.d.t.setMinWidth((int) Math.ceil(this.d.t.getPaint().measureText(lh6.V().Y())));
        }
    }

    public final void y(VoiceMatchInfo voiceMatchInfo) {
        this.d.G.setVisibility(0);
        this.d.G.updateUI(voiceMatchInfo);
        x(this.d.G);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(boolean z) {
        boolean z2;
        if (!z) {
            this.d.H.setVisibility(8);
            return;
        }
        this.d.H.setVisibility(0);
        VoiceMatchInfo voiceMatchInfoX = lh6.V().x();
        SkuItem skuItem = voiceMatchInfoX.getSkuItem(VoiceMatchType.FAST);
        SkuItem skuItem2 = voiceMatchInfoX.getSkuItem(VoiceMatchType.SAME_CITY);
        voiceMatchInfoX.getSkuItem(VoiceMatchType.NORMAL);
        this.d.c.setText("发起匹配");
        if (lh6.V().e0()) {
            this.d.c.setText("匹配中…");
            this.d.c.setBackgroundResource(R.drawable.voice_match_prop_normal_btn_bg_video_disable);
        } else {
            this.d.c.setBackgroundResource(R.drawable.voice_match_prop_normal_btn_bg_video);
        }
        if (skuItem != null) {
            String str = skuItem.price + "连信豆/次";
            if (skuItem.remainingQuantity > 0) {
                str = "剩余" + skuItem.remainingQuantity + "次";
            }
            this.d.v.setText(str);
            this.d.q.setText(lh6.V().i().getQueueSizeForShow(skuItem.queueSize));
            this.d.x.setText(skuItem.name);
            this.d.w.setText(skuItem.description);
            this.d.n.setText(skuItem.btnText);
        }
        if (skuItem2 != null) {
            String str2 = skuItem2.price + "连信豆/次";
            if (skuItem2.remainingQuantity > 0) {
                str2 = "剩余" + skuItem2.remainingQuantity + "次";
            }
            this.d.g.setText(str2);
            this.d.i.setText(skuItem2.name);
            this.d.h.setText(skuItem2.description);
            this.d.d.setText(skuItem2.btnText);
            this.d.e.setVisibility(0);
            this.d.f13907a.post(new b());
        } else {
            this.d.e.setVisibility(8);
        }
        if (v4.f() != null) {
            z2 = v4.f().getGender() == 1;
        }
        if (z2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.o.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.d.o.setLayoutParams(layoutParams);
            this.d.o.setPadding(0, 0, 0, 0);
            this.d.o.setBackgroundResource(R.drawable.ic_voice_match_card_bg_city_video);
            this.d.q.setVisibility(8);
        }
        x(this.d.H);
    }

    public final void x(View view) {
    }

    public void n() {
    }
}
