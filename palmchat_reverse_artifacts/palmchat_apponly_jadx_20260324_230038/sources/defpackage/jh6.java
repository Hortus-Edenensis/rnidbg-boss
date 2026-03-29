package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.databinding.LayoutActivityVoiceMatchBinding;
import com.zenmen.palmchat.databinding.LayoutVoiceMatchPanelBinding;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.paidservices.voicematch.TextVerticalLoopView;
import com.zenmen.palmchat.paidservices.voicematch.VoiceMatchState;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.c15;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class jh6 extends r0 implements View.OnClickListener {
    public LayoutActivityVoiceMatchBinding c;
    public LayoutVoiceMatchPanelBinding d;
    public g e = new g(this);
    public boolean f = false;
    public ValueAnimator g;
    public TextVerticalLoopView h;
    public FrameworkBaseActivity i;
    public ky4 j;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements op2 {
        public b() {
        }

        @Override // defpackage.op2
        public void a(VoiceMatchType voiceMatchType) {
            HashMap<String, String> mapU = lh6.V().U();
            mapU.put("retryType", String.valueOf(voiceMatchType.type));
            zn6.i("audioMatch_fail_retry", mapU);
            lh6.V().D0(voiceMatchType, 2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jh6.this.d.d.startLightingAnimation(-1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f18411a;

        public d(View view) {
            this.f18411a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int top = this.f18411a.getTop();
            int bottom = jh6.this.d.J.getBottom() + jh6.this.d.z.getHeight();
            LogUtil.e("VoiceMatchComponent", "propTop=" + top + " matchBottom=" + bottom + " " + jh6.this.d.z.getHeight());
            int i = bottom > top ? top - bottom : 0;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jh6.this.d.z.getLayoutParams();
            layoutParams.setMargins(0, i, 0, 0);
            jh6.this.d.z.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jh6.this.g == null) {
                int width = jh6.this.d.r.getWidth();
                if (width == 0) {
                    width = me1.b(AppContext.getContext(), 110);
                }
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(jh6.this.d.q, PropertyValuesHolder.ofFloat("alpha", 0.1f, 0.6f), PropertyValuesHolder.ofFloat("translationX", 0.0f, width));
                objectAnimatorOfPropertyValuesHolder.setInterpolator(new AccelerateInterpolator(0.5f));
                objectAnimatorOfPropertyValuesHolder.setRepeatCount(1000);
                objectAnimatorOfPropertyValuesHolder.setDuration(1100L);
                jh6.this.g = objectAnimatorOfPropertyValuesHolder;
            }
            jh6.this.g.start();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18413a;

        static {
            int[] iArr = new int[VoiceMatchState.values().length];
            f18413a = iArr;
            try {
                iArr[VoiceMatchState.IDEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18413a[VoiceMatchState.MATCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18413a[VoiceMatchState.PROPMATCHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18413a[VoiceMatchState.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18413a[VoiceMatchState.CHAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18413a[VoiceMatchState.MATCHFAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<jh6> f18414a;

        public g(jh6 jh6Var) {
            this.f18414a = new WeakReference<>(jh6Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                if (this.f18414a.get() != null) {
                    this.f18414a.get().v();
                }
                removeMessages(0);
                sendEmptyMessageDelayed(0, 3000L);
                return;
            }
            if (i != 1) {
                return;
            }
            if (this.f18414a.get() != null && lh6.V().b0() == VoiceMatchState.MATCHING) {
                this.f18414a.get().u();
                removeMessages(0);
                sendEmptyMessageDelayed(0, 3000L);
            }
            removeMessages(1);
        }
    }

    public jh6(FrameworkBaseActivity frameworkBaseActivity, LayoutActivityVoiceMatchBinding layoutActivityVoiceMatchBinding, ky4 ky4Var) {
        this.i = frameworkBaseActivity;
        this.c = layoutActivityVoiceMatchBinding;
        this.j = ky4Var;
    }

    @Override // defpackage.r0, defpackage.xm2
    public void a(VoiceMatchState voiceMatchState) {
        LogUtil.i("VoiceMatchComponent", "updateUI" + voiceMatchState);
        VoiceMatchInfo voiceMatchInfoX = lh6.V().x();
        switch (f.f18413a[voiceMatchState.ordinal()]) {
            case 1:
                this.d.z.setVisibility(8);
                y(false);
                this.d.w.setVisibility(8);
                this.d.E.setVisibility(8);
                if (!tg4.b(this.i, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL.permissionList)) {
                    this.d.z.setVisibility(0);
                    this.d.A.setText("匹配失败，未开启麦克风权限");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("去开启");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FE7FCD")), 0, 3, 18);
                    this.d.C.setText(spannableStringBuilder);
                    this.d.C.setVisibility(0);
                }
                r();
                t();
                s();
                break;
            case 2:
                this.d.G.setVisibility(8);
                this.d.J.setVisibility(0);
                this.d.A.setText("超多声音好听的小姐姐在等你聊天");
                this.d.B.setVisibility(0);
                this.d.w.setVisibility(8);
                this.d.z.setVisibility(0);
                this.d.C.setVisibility(8);
                this.d.E.setVisibility(8);
                y(true);
                o();
                q();
                this.e.sendEmptyMessageDelayed(1, lh6.V().i().fake_timeout * 1000);
                break;
            case 3:
                this.d.G.setVisibility(8);
                this.d.J.setVisibility(0);
                y(false);
                this.d.w.setVisibility(0);
                this.d.z.setVisibility(8);
                this.d.C.setVisibility(8);
                this.d.E.setVisibility(8);
                VoiceMatchConfig voiceMatchConfigI = lh6.V().i();
                VoiceMatchType voiceMatchType = voiceMatchInfoX.voiceMatchType;
                if (voiceMatchType == VoiceMatchType.FAST) {
                    this.d.x.setImageResource(R.drawable.ic_voice_match_prop_fast);
                    this.d.q.setImageResource(R.drawable.ic_voice_match_fast_matching_arrow);
                    if (voiceMatchConfigI.speedup != null) {
                        TextView textView = this.d.s;
                        String[] strArr = voiceMatchInfoX.title;
                        textView.setText((strArr == null || strArr.length <= 0) ? "正在加速匹配中" : strArr[0]);
                    }
                } else if (voiceMatchType == VoiceMatchType.SAME_CITY) {
                    this.d.x.setImageResource(R.drawable.ic_voice_match_prop_city);
                    this.d.q.setImageResource(R.drawable.ic_voice_match_city_matching_arrow);
                    TextView textView2 = this.d.s;
                    String[] strArr2 = voiceMatchInfoX.title;
                    textView2.setText((strArr2 == null || strArr2.length <= 0) ? "正在同城匹配中" : strArr2[0]);
                }
                o();
                p();
                break;
            case 4:
                int i = voiceMatchInfoX.errorCode;
                String[] strArr3 = voiceMatchInfoX.title;
                String str = null;
                String str2 = (strArr3 == null || strArr3.length <= 0) ? null : strArr3[0];
                String[] strArr4 = voiceMatchInfoX.subTitle;
                if (strArr4 != null && strArr4.length > 0) {
                    str = strArr4[0];
                }
                if (i == -1) {
                    this.d.G.setVisibility(0);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("加载失败，点击刷新");
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.parseColor("#FE7FCD")), 5, 9, 18);
                    this.d.H.setText(spannableStringBuilder2);
                    this.d.z.setVisibility(8);
                    this.d.J.setVisibility(8);
                    this.d.E.setVisibility(8);
                    this.d.w.setVisibility(8);
                    y(false);
                    this.d.w.setVisibility(8);
                } else if (i == 1021) {
                    this.d.G.setVisibility(8);
                    this.d.A.setText(str2);
                    this.d.C.setVisibility(0);
                    this.d.C.setText(str);
                    this.d.B.setVisibility(8);
                    this.d.z.setVisibility(0);
                    this.d.E.setVisibility(8);
                    this.d.w.setVisibility(8);
                    y(false);
                    this.d.w.setVisibility(8);
                } else if (i == 1020) {
                    this.d.G.setVisibility(8);
                    this.d.c.setVisibility(0);
                    this.d.f13908a.setText(str2);
                    this.d.b.setText(str);
                    this.d.z.setVisibility(8);
                    this.d.J.setVisibility(8);
                    this.d.E.setVisibility(8);
                    this.d.w.setVisibility(8);
                    y(false);
                    this.d.w.setVisibility(8);
                } else if (i == 1023) {
                    this.d.G.setVisibility(8);
                    this.d.A.setText(str2);
                    this.d.C.setVisibility(0);
                    this.d.C.setText(str);
                    this.d.B.setVisibility(8);
                    this.d.z.setVisibility(0);
                    this.d.E.setVisibility(8);
                    this.d.w.setVisibility(8);
                    this.d.w.setVisibility(8);
                    y(true);
                } else if (i == -10088) {
                    this.d.G.setVisibility(8);
                    this.d.A.setText("定位失败");
                    this.d.C.setVisibility(0);
                    this.d.C.setText("定位失败");
                    this.d.B.setVisibility(8);
                    this.d.z.setVisibility(0);
                    this.d.w.setVisibility(8);
                    y(true);
                    this.d.w.setVisibility(8);
                } else {
                    this.d.G.setVisibility(8);
                    this.d.A.setText(str2);
                    this.d.C.setVisibility(0);
                    this.d.C.setText(str);
                    this.d.B.setVisibility(8);
                    this.d.z.setVisibility(0);
                    this.d.w.setVisibility(8);
                    y(true);
                    this.d.w.setVisibility(8);
                }
                r();
                t();
                s();
                break;
            case 5:
                this.d.E.setVisibility(8);
                y(false);
                r();
                t();
                s();
                break;
            case 6:
                this.d.G.setVisibility(8);
                this.d.J.setVisibility(0);
                VoiceMatchInfo voiceMatchInfoX2 = lh6.V().x();
                TextView textView3 = this.d.A;
                String[] strArr5 = voiceMatchInfoX2.title;
                textView3.setText((strArr5 == null || strArr5.length <= 0) ? "匹配失败，排队人太多了" : strArr5[0]);
                this.d.C.setVisibility(0);
                TextView textView4 = this.d.C;
                String[] strArr6 = voiceMatchInfoX2.subTitle;
                textView4.setText((strArr6 == null || strArr6.length <= 0) ? "使用加速卡，效率翻3倍" : strArr6[0]);
                this.d.B.setVisibility(8);
                this.d.z.setVisibility(0);
                x(voiceMatchInfoX);
                this.d.w.setVisibility(8);
                y(false);
                this.d.w.setVisibility(8);
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
    public void d() {
        super.d();
        LayoutVoiceMatchPanelBinding layoutVoiceMatchPanelBindingB = LayoutVoiceMatchPanelBinding.b(LayoutInflater.from(this.i));
        this.d = layoutVoiceMatchPanelBindingB;
        layoutVoiceMatchPanelBindingB.getRoot().setVisibility(8);
        this.c.q.addView(this.d.getRoot());
        n();
    }

    public final void m() {
        this.d.y.startAnimation(AnimationUtils.loadAnimation(this.i, R.anim.voice_match_head_animation));
    }

    public final void n() {
        this.d.I.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.I.setFillMode(SVGAImageView.FillMode.Clear);
        this.d.I.setLoops(Integer.MAX_VALUE);
        this.d.I.setClearsAfterDetached(true);
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            a46.u(contactInfoItemF.getIconURL(), this.d.y, R.drawable.ic_default_portrait);
            c15.INSTANCE.b().n(contactInfoItemF.getGender() != 0 ? "svga/match_male.svga" : "svga/match_female.svga", new a(), null);
        }
        this.d.l.setOnClickListener(this);
        this.d.E.setMatchClick(new b());
        this.d.G.setOnClickListener(this);
        this.d.C.setOnClickListener(this);
        this.d.e.setOnClickListener(this);
        TextVerticalLoopView textVerticalLoopView = new TextVerticalLoopView(this.i, 12.0f);
        this.h = textVerticalLoopView;
        this.d.B.addView(textVerticalLoopView, new ViewGroup.LayoutParams(-1, -2));
        this.h.setTextStillTime(5000L);
        this.h.setAnimTime(300L);
    }

    public void o() {
        if (this.f) {
            m();
            if (!this.d.I.getIsAnimating()) {
                this.d.I.startAnimation();
            }
        }
        this.j.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        LayoutVoiceMatchPanelBinding layoutVoiceMatchPanelBinding = this.d;
        if (view == layoutVoiceMatchPanelBinding.l) {
            lh6.V().C0(VoiceMatchType.FAST);
            return;
        }
        if (view == layoutVoiceMatchPanelBinding.G) {
            lh6.V().C0(VoiceMatchType.NORMAL);
            return;
        }
        if (view == layoutVoiceMatchPanelBinding.e) {
            lh6.V().C0(VoiceMatchType.SAME_CITY);
            return;
        }
        TextView textView = layoutVoiceMatchPanelBinding.C;
        if (view == textView && "去开启".equals(textView.getText().toString())) {
            BaseActivityPermissionDispatcher.b(this.i, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL, BaseActivityPermissionDispatcher.PermissionUsage.AUDIO_MATCH);
        }
    }

    @Override // defpackage.xm2
    public void onDestroy() {
        r();
        t();
        s();
    }

    public final void p() {
        u93.b(100, new e());
        this.e.sendEmptyMessage(0);
    }

    public final void q() {
        this.e.sendEmptyMessage(0);
        this.h.setDataList(lh6.V().X());
        this.h.startAutoScroll();
    }

    public final void r() {
        if (this.f) {
            this.d.I.stopAnimation();
            this.d.I.stepToPercentage(0.5d, false);
        }
        this.j.d();
    }

    public final void s() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void t() {
        this.e.removeMessages(0);
        this.e.removeMessages(1);
        this.h.stopAutoScroll();
    }

    public final void u() {
        this.d.A.setText(lh6.V().i().match_timeout);
        HashMap<String, String> mapU = lh6.V().U();
        mapU.put("duration", String.valueOf(ir5.e(lh6.V().x().startMatchTime)));
        zn6.i("audioMatch_timeout", mapU);
    }

    public final void v() {
        if (lh6.V().b0() == VoiceMatchState.MATCHING) {
            this.d.A.setText(lh6.V().Z());
        } else if (lh6.V().b0() == VoiceMatchState.PROPMATCHING) {
            this.d.r.setText(lh6.V().a0());
            this.d.r.setMinWidth((int) Math.ceil(this.d.r.getPaint().measureText(lh6.V().Y())));
        }
    }

    public final void w(View view) {
        u93.b(50, new d(view));
    }

    public final void x(VoiceMatchInfo voiceMatchInfo) {
        this.d.E.setVisibility(0);
        this.d.E.updateUI(voiceMatchInfo);
        w(this.d.E);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(boolean z) {
        boolean z2;
        if (!z) {
            this.d.F.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.z.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.d.z.setLayoutParams(layoutParams);
            return;
        }
        this.d.F.setVisibility(0);
        VoiceMatchInfo voiceMatchInfoX = lh6.V().x();
        SkuItem skuItem = voiceMatchInfoX.getSkuItem(VoiceMatchType.FAST);
        SkuItem skuItem2 = voiceMatchInfoX.getSkuItem(VoiceMatchType.SAME_CITY);
        if (skuItem != null) {
            String str = skuItem.price + "连信豆/次";
            if (skuItem.remainingQuantity > 0) {
                str = "剩余" + skuItem.remainingQuantity + "次";
            }
            this.d.t.setText(str);
            this.d.o.setText(lh6.V().i().getQueueSizeForShow(skuItem.queueSize));
            this.d.v.setText(skuItem.name);
            this.d.u.setText(skuItem.description);
            this.d.l.setText(skuItem.btnText);
        }
        if (skuItem2 != null) {
            String str2 = skuItem2.price + "连信豆/次";
            if (skuItem2.remainingQuantity > 0) {
                str2 = "剩余" + skuItem2.remainingQuantity + "次";
            }
            this.d.h.setText(str2);
            this.d.j.setText(skuItem2.name);
            this.d.i.setText(skuItem2.description);
            this.d.e.setText(skuItem2.btnText);
            this.d.f.setVisibility(0);
            this.d.d.post(new c());
        } else {
            this.d.f.setVisibility(8);
        }
        if (v4.f() != null) {
            z2 = v4.f().getGender() == 1;
        }
        if (z2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.m.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            this.d.m.setLayoutParams(layoutParams2);
            this.d.m.setPadding(0, 0, 0, 0);
            this.d.m.setBackgroundResource(R.drawable.ic_voice_match_card_bg_city);
            this.d.o.setVisibility(8);
        }
        w(this.d.F);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c15.d {
        public a() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            jh6.this.d.I.setVideoItem(m15Var);
            jh6.this.d.I.stepToPercentage(0.5d, false);
            jh6.this.d.I.setCallback(new C1223a());
            jh6.this.f = true;
            if (lh6.V().e0()) {
                jh6.this.o();
            }
        }

        /* JADX INFO: renamed from: jh6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1223a implements v05 {
            public C1223a() {
            }

            @Override // defpackage.v05
            public void c() {
                jh6.this.m();
            }

            @Override // defpackage.v05
            public void a() {
            }

            @Override // defpackage.v05
            public void onPause() {
            }

            @Override // defpackage.v05
            public void b(int i, double d) {
            }
        }

        @Override // c15.d
        public void onError() {
        }
    }
}
