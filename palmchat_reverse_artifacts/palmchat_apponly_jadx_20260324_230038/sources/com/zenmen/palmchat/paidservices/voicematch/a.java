package com.zenmen.palmchat.paidservices.voicematch;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.databinding.LayoutActivityVoiceMatchBinding;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.paidservices.voicematch.FastGuideDialog;
import com.zenmen.palmchat.paidservices.voicematch.b;
import defpackage.c15;
import defpackage.cd6;
import defpackage.jh6;
import defpackage.ky4;
import defpackage.l50;
import defpackage.ld3;
import defpackage.lh6;
import defpackage.m15;
import defpackage.me1;
import defpackage.ry5;
import defpackage.tg4;
import defpackage.u93;
import defpackage.v05;
import defpackage.v4;
import defpackage.xm2;
import defpackage.zn6;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutActivityVoiceMatchBinding f14902a;
    public VoiceMatchActivity b;
    public xm2 d;
    public cd6 e;
    public jh6 f;
    public ky4 g;
    public Boolean c = null;
    public HashSet<String> h = new HashSet<>();
    public boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.voicematch.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1089a implements b.c {
            public C1089a() {
            }

            @Override // com.zenmen.palmchat.paidservices.voicematch.b.c
            public void a() {
                a.this.b.Q1(false);
            }

            @Override // com.zenmen.palmchat.paidservices.voicematch.b.c
            public void b() {
                a.this.b.R1();
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.paidservices.voicematch.b.a(a.this.b, a.this.f14902a.g, !lh6.V().x().isVoiceMatch, new C1089a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            lh6.V().A0(1);
            a.this.p(false, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            lh6.V().A0(1);
            a.this.p(false, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            lh6.V().o.c(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMatchConfig.SpeedupPOP f14910a;

        public g(VoiceMatchConfig.SpeedupPOP speedupPOP) {
            this.f14910a = speedupPOP;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m(this.f14910a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements FastGuideDialog.d {
        public h() {
        }

        @Override // com.zenmen.palmchat.paidservices.voicematch.FastGuideDialog.d
        public void onConfirm() {
            if (lh6.V().b0() == VoiceMatchState.MATCHING) {
                zn6.i("audioMatch_speedup_popup_click", lh6.V().U());
                lh6.V().D0(VoiceMatchType.FAST, 1);
            }
        }
    }

    public a(VoiceMatchActivity voiceMatchActivity, LayoutActivityVoiceMatchBinding layoutActivityVoiceMatchBinding) {
        this.b = voiceMatchActivity;
        this.f14902a = layoutActivityVoiceMatchBinding;
        ky4 ky4Var = new ky4(voiceMatchActivity);
        this.g = ky4Var;
        this.e = new cd6(voiceMatchActivity, layoutActivityVoiceMatchBinding, ky4Var);
        this.f = new jh6(voiceMatchActivity, layoutActivityVoiceMatchBinding, this.g);
    }

    public final void f() {
        ContactInfoItem contactInfoItemF;
        VoiceMatchConfig.SpeedupPOP speedupPOP = lh6.V().i().speedupPOP;
        if (speedupPOP == null || !speedupPOP.enable || (contactInfoItemF = v4.f()) == null || contactInfoItemF.getGender() != 0) {
            return;
        }
        u93.b(speedupPOP.waitSeconds * 1000, new g(speedupPOP));
    }

    public final void g() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14902a.m.getLayoutParams();
        layoutParams.setMargins(0, me1.h(this.b), 0, 0);
        this.f14902a.m.setLayoutParams(layoutParams);
        if (lh6.f0()) {
            this.f14902a.l.setVisibility(8);
            this.f14902a.i.setVisibility(0);
        } else {
            this.f14902a.l.setVisibility(0);
            this.f14902a.i.setVisibility(8);
        }
        this.f14902a.f13902a.setOnClickListener(new b());
        this.f14902a.g.setOnClickListener(new c());
        this.f14902a.j.setOnClickListener(new d());
        this.f14902a.k.setOnClickListener(new e());
        if (lh6.f0()) {
            this.f14902a.p.setVisibility(SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_voice_match_has_video_clicked", false) ? 8 : 0);
        } else {
            this.f14902a.p.setVisibility(8);
        }
        f fVar = new f();
        this.f14902a.b.setOnClickListener(fVar);
        this.f14902a.d.setOnClickListener(fVar);
    }

    public void h(boolean z) {
        g();
        p(true, !z);
    }

    public void i() {
        this.d.onDestroy();
    }

    public void j(ld3 ld3Var) {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f14902a.c.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.f14902a.c.getLayoutParams();
        layoutParams.height = me1.h(AppContext.getContext()) + me1.b(AppContext.getContext(), 104);
        this.f14902a.c.setLayoutParams(layoutParams);
        if (ld3Var.b) {
            n(ld3Var);
        } else {
            o(ld3Var.c);
        }
    }

    public void k() {
        this.d.onPause();
        this.g.d();
    }

    public void l() {
        this.d.onResume();
    }

    public final void m(VoiceMatchConfig.SpeedupPOP speedupPOP) {
        String str;
        if (lh6.V().b0() != VoiceMatchState.MATCHING || this.b.isFinishing() || (str = lh6.V().x().matchid) == null || this.h.contains(str)) {
            return;
        }
        this.h.add(str);
        String strReplace = speedupPOP.title;
        if (strReplace != null && strReplace.contains("m") && speedupPOP.m > 0) {
            strReplace = strReplace.replace("m", speedupPOP.m + "%");
        }
        try {
            new FastGuideDialog(this.b, new h(), strReplace).show();
            zn6.i("audioMatch_speedup_popup", lh6.V().U());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void n(ld3 ld3Var) {
        this.f14902a.n.setText(ld3Var.f18960a);
        this.f14902a.b.setVisibility(0);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(AppContext.getContext(), R.anim.vm_level_bubble_show);
        animationLoadAnimation.setAnimationListener(new i(ld3Var));
        this.f14902a.b.startAnimation(animationLoadAnimation);
    }

    public final void o(int i2) {
        this.f14902a.d.setVisibility(0);
        this.f14902a.e.setText("Lv." + i2);
        String str = i2 == 1 ? "match_level_1.svga" : i2 == 2 ? "match_level_2.svga" : i2 == 3 ? "match_level_3.svga" : i2 == 4 ? "match_level_4.svga" : i2 == 5 ? "match_level_5.svga" : "match_level_0.svga";
        int i3 = i2 == 1 ? R.drawable.vm_level_1 : i2 == 2 ? R.drawable.vm_level_2 : i2 == 3 ? R.drawable.vm_level_3 : i2 == 4 ? R.drawable.vm_level_4 : i2 == 5 ? R.drawable.vm_level_5 : R.drawable.vm_level_0;
        this.f14902a.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f14902a.h.setFillMode(SVGAImageView.FillMode.Clear);
        this.f14902a.h.setLoops(1);
        this.f14902a.h.setClearsAfterDetached(true);
        this.f14902a.h.setCallback(new j(i3));
        c15.INSTANCE.b().n("svga/" + str, new C1088a(), null);
    }

    public final void p(boolean z, boolean z2) {
        if (z || !lh6.V().t()) {
            q(z2);
            if (!z2 && this.f14902a.p.getVisibility() == 0) {
                this.f14902a.p.setVisibility(8);
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_voice_match_has_video_clicked", Boolean.TRUE);
            }
            boolean z3 = true;
            boolean z4 = z && !z2;
            if (lh6.V().h0() == z2) {
                z3 = z4;
            } else {
                if (lh6.V().e0()) {
                    lh6.V().G0(102);
                    ry5.a(lh6.V().h0() ? "语音速配已停止" : "视频匹配已停止");
                } else {
                    lh6.V().F();
                }
                lh6.V().B0(z2);
                if (z2) {
                    if (tg4.b(this.b, BaseActivityPermissionDispatcher.PermissionType.AUDIO_CALL.permissionList)) {
                        lh6.V().C0(VoiceMatchType.NORMAL);
                    }
                    z3 = z4;
                }
            }
            if (z3) {
                lh6.V().w0();
            }
            if (z2) {
                this.f.e();
                this.e.c();
            } else {
                this.f.c();
                this.e.e();
            }
            this.d = z2 ? this.f : this.e;
            lh6.V().onEvent("pagediscover_audioMatch");
        }
    }

    public final void q(boolean z) {
        if (z) {
            this.f14902a.f.setBackgroundResource(R.drawable.voice_match_background);
            this.f14902a.f13902a.setImageResource(R.drawable.ic_voice_match_back);
            this.f14902a.g.setImageResource(R.drawable.ic_voice_match_rule);
            this.f14902a.i.setBackgroundResource(R.drawable.voice_match_toolbar_bg_white);
            this.f14902a.k.setBackgroundResource(R.drawable.voice_match_toolbar_bg_white_selected);
            this.f14902a.k.setTextColor(Color.parseColor("#222222"));
            this.f14902a.j.setBackgroundColor(0);
            this.f14902a.j.setTextColor(Color.parseColor("#666666"));
        } else {
            this.f14902a.f.setBackgroundColor(Color.parseColor("#88000000"));
            this.f14902a.f13902a.setImageResource(R.drawable.ic_voice_match_back_white);
            this.f14902a.g.setImageResource(R.drawable.ic_voice_match_rule_2);
            this.f14902a.i.setBackgroundResource(R.drawable.voice_match_toolbar_bg_black);
            this.f14902a.k.setBackgroundColor(0);
            this.f14902a.k.setTextColor(-1);
            this.f14902a.j.setBackgroundResource(R.drawable.voice_match_toolbar_bg_white_selected);
            this.f14902a.j.setTextColor(Color.parseColor("#222222"));
        }
        this.f14902a.c.setVisibility(z ? 0 : 8);
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_voice_match_last_select_voice", Boolean.valueOf(z));
    }

    public void r(VoiceMatchState voiceMatchState) {
        this.d.a(voiceMatchState);
        if (voiceMatchState == VoiceMatchState.MATCHING) {
            f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ld3 f14912a;

        public i(ld3 ld3Var) {
            this.f14912a = ld3Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.o(this.f14912a.c);
            a.this.f14902a.b.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.voicematch.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1088a implements c15.d {
        public C1088a() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            a.this.f14902a.h.setVideoItem(m15Var);
            a.this.f14902a.h.startAnimation();
        }

        @Override // c15.d
        public void onError() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements v05 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14913a;

        public j(int i) {
            this.f14913a = i;
        }

        @Override // defpackage.v05
        public void a() {
            a.this.f14902a.h.setImageResource(this.f14913a);
        }

        @Override // defpackage.v05
        public void c() {
        }

        @Override // defpackage.v05
        public void onPause() {
        }

        @Override // defpackage.v05
        public void b(int i, double d) {
        }
    }
}
