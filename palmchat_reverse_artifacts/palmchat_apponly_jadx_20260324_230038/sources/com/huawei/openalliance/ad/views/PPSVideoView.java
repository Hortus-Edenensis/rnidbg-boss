package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fx;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.ik;
import com.huawei.hms.ads.iw;
import com.huawei.hms.ads.lu;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSVideoView extends PPSBaseView<iw> implements lu {
    private View.OnClickListener A;
    private com.huawei.openalliance.ad.media.listener.g E;
    private MediaStateListener G;
    private final com.huawei.openalliance.ad.media.listener.h H;
    private com.huawei.openalliance.ad.media.listener.c J;
    private final com.huawei.openalliance.ad.media.listener.b K;
    private com.huawei.openalliance.ad.media.listener.f M;
    private VideoView d;
    private ImageView e;
    private boolean f;
    private boolean g;
    private VideoInfo h;
    private int i;
    private long j;
    private long k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private float v;
    private fx w;
    private int x;
    private int y;
    private int z;

    public PPSVideoView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.f = true;
        this.g = true;
        this.i = Integer.MAX_VALUE;
        this.l = false;
        this.m = false;
        this.n = 1;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 0.0f;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSVideoView.this.Code(!view.isSelected());
            }
        };
        this.E = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.Code("PPSVideoView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSVideoView.this.r));
                if (PPSVideoView.this.r) {
                    return;
                }
                PPSVideoView.this.r = true;
                if (PPSVideoView.this.d != null) {
                    PPSVideoView.this.d.setAlpha(1.0f);
                }
                PPSVideoView.this.Z();
                if (PPSVideoView.this.s) {
                    PPSVideoView.this.g = false;
                }
                PPSVideoView.this.c();
            }
        };
        this.G = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3
            private void Code(int i5) {
                onMediaStop(null, i5);
                if (PPSVideoView.this.getContext() == null || PPSVideoView.this.S == null) {
                    return;
                }
                AnalysisEventReport analysisEventReport = new AnalysisEventReport();
                analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.c);
                analysisEventReport.I(String.valueOf(PPSVideoView.this.S.Z()));
                analysisEventReport.Z(String.valueOf(PPSVideoView.this.x));
                analysisEventReport.B(String.valueOf(i5));
                analysisEventReport.C(String.valueOf(PPSVideoView.this.z));
                analysisEventReport.S(String.valueOf(PPSVideoView.this.y));
                new db().Code(PPSVideoView.this.getContext(), analysisEventReport, PPSVideoView.this.S);
            }

            private void V(int i5) {
                if (PPSVideoView.this.m) {
                    fh.V("PPSVideoView", "has reported play end event");
                    return;
                }
                PPSVideoView.this.m = true;
                PPSVideoView pPSVideoView = PPSVideoView.this;
                ((iw) pPSVideoView.B).Code(pPSVideoView.j, z.Code(), PPSVideoView.this.k, i5);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i5) {
                Code(i5, true);
                PPSVideoView pPSVideoView = PPSVideoView.this;
                P p = pPSVideoView.B;
                if (p != 0) {
                    long j = i5;
                    ((iw) p).Code(pPSVideoView.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, final int i5) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Code(i5, false);
                    }
                }, 1000L);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i5) {
                if (PPSVideoView.this.l) {
                    return;
                }
                fh.V("PPSVideoView", "onMediaStart, playTime is %s", Integer.valueOf(i5));
                PPSVideoView.this.h();
                PPSVideoView.this.l = true;
                PPSVideoView.this.k = i5;
                PPSVideoView.this.j = z.Code();
                PPSVideoView pPSVideoView = PPSVideoView.this;
                if (i5 > 0) {
                    pPSVideoView.C.f();
                } else {
                    if (pPSVideoView.h != null) {
                        PPSVideoView.this.C.Code(r8.h.I(), PPSVideoView.this.f);
                    }
                    PPSVideoView pPSVideoView2 = PPSVideoView.this;
                    ((iw) pPSVideoView2.B).Code(pPSVideoView2.w.B(), PPSVideoView.this.w.Z(), PPSVideoView.this.j);
                }
                PPSVideoView pPSVideoView3 = PPSVideoView.this;
                ((iw) pPSVideoView3.B).Code(pPSVideoView3.j);
                PPSVideoView pPSVideoView4 = PPSVideoView.this;
                pPSVideoView4.f6970a.Code(pPSVideoView4.j);
                ((iw) PPSVideoView.this.B).F();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i5) {
                Code(i5, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i5, int i6) {
                fh.Code("PPSVideoView", "onProgress, playTime: %d, alreadyNotified: %s", Integer.valueOf(i6), Boolean.valueOf(PPSVideoView.this.r));
                if (PPSVideoView.this.B(i6)) {
                    Code(i6);
                }
                if (i6 > 0 && !PPSVideoView.this.r) {
                    PPSVideoView.this.r = true;
                    if (PPSVideoView.this.d != null) {
                        PPSVideoView.this.d.setAlpha(1.0f);
                    }
                    PPSVideoView.this.Z();
                    PPSVideoView.this.c();
                }
                if (PPSVideoView.this.d != null && PPSVideoView.this.d.getCurrentState().Code() && PPSVideoView.this.x > 0) {
                    PPSVideoView.this.setAndUpdateLeftTime(i6);
                }
                if (PPSVideoView.this.l) {
                    PPSVideoView.this.C.Code(i5);
                    PPSVideoView pPSVideoView = PPSVideoView.this;
                    P p = pPSVideoView.B;
                    if (p != 0) {
                        ((iw) p).Code(pPSVideoView.getContext(), i6, PPSVideoView.this.x);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Code(int i5, boolean z) {
                if (PPSVideoView.this.l) {
                    if (PPSVideoView.this.w != null) {
                        PPSVideoView.this.w.I();
                    }
                    PPSVideoView.this.l = false;
                    V(i5);
                    ((iw) PPSVideoView.this.B).V();
                    hb hbVar = PPSVideoView.this.C;
                    if (z) {
                        hbVar.a();
                    } else {
                        hbVar.e();
                    }
                }
            }
        };
        this.H = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code("PPSVideoView", "reportVideoTime: %s", Long.valueOf(j));
                }
                PPSVideoView pPSVideoView = PPSVideoView.this;
                P p = pPSVideoView.B;
                if (p != 0) {
                    ((iw) p).Code(pPSVideoView.getContext(), j);
                }
            }
        };
        this.J = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i5, int i6, int i7) {
                PPSVideoView.this.V(-302);
                PPSVideoView.this.Code();
            }
        };
        this.K = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSVideoView.this.C.b();
                if (PPSVideoView.this.w != null) {
                    PPSVideoView.this.w.V();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSVideoView.this.C.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i5) {
            }
        };
        this.M = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.7
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                PPSVideoView.this.setMuteButtonState(true);
                PPSVideoView.this.C.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                PPSVideoView.this.setMuteButtonState(false);
                PPSVideoView.this.C.V(1.0f);
            }
        };
        this.p = i2;
        this.o = i;
        this.q = i3;
        this.B = new ik(context, this);
        this.w = new fx("PPSVideoView");
    }

    private void Z(int i) {
        int iMax = Math.max(1, (int) Math.ceil((Math.max(i, 0) * 1.0f) / 1000.0f));
        fh.Code("PPSVideoView", "left seconds: %d", Integer.valueOf(iMax));
        if (iMax < this.i) {
            this.i = iMax;
            I(iMax);
        }
    }

    private void d() {
        if (e()) {
            g();
        } else {
            f();
        }
    }

    private void f() {
        VideoInfo videoInfo = this.h;
        if (videoInfo != null) {
            this.x = videoInfo.I();
        }
        MetaData metaDataS = this.S.S();
        if (metaDataS == null || metaDataS.k() <= 0) {
            return;
        }
        this.x = (int) metaDataS.k();
    }

    private void g() {
        VideoInfo videoInfo = this.h;
        if (videoInfo == null) {
            return;
        }
        int iZ = videoInfo.Z();
        this.z = iZ;
        if (this.D <= 0 || iZ - this.L <= 0) {
            this.x = Math.min(5000, iZ);
            this.L = 0;
            this.S.h(0);
        } else {
            this.x = Math.min(this.h.Z() - this.L, this.D);
        }
        this.y = this.x + this.L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.t || !this.u) {
            return;
        }
        float f = this.v;
        if (f > 0.0f) {
            this.d.setSoundVolume(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAndUpdateLeftTime(int i) {
        if (!e()) {
            Z(this.x - i);
            return;
        }
        int i2 = this.x;
        int i3 = (this.L + i2) - i;
        if (i3 <= i2) {
            Z(i3);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public boolean C() {
        return this.x > 0;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public void D() {
        super.D();
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.D();
        }
    }

    public int getSplashDuration() {
        return this.x;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoView videoView = this.d;
        if (videoView != null) {
            removeView(videoView);
            this.d.destroyView();
            this.d = null;
        }
        this.i = Integer.MAX_VALUE;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.me
    public void pauseView() {
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.pauseView();
            this.d.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public void setAudioFocusType(int i) {
        this.n = i;
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.setAudioFocusType(i);
        }
    }

    public void setHideSoundIcon(boolean z) {
        this.s = z;
    }

    public void setIgnoreSoundCtrl(boolean z) {
        this.t = z;
    }

    public void setMuteButtonState(boolean z) {
        this.f = z;
        if (this.e != null) {
            this.e.setImageResource(bg.Code(z));
            this.e.setSelected(!z);
            bg.Code(this.e);
        }
    }

    public void setStartVol(float f) {
        this.v = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(int i) {
        int i2;
        return e() && (i > (i2 = this.y) || i2 == 0);
    }

    private void b() {
        if (this.d == null) {
            VideoView videoView = new VideoView(getContext());
            this.d = videoView;
            videoView.setScreenOnWhilePlaying(true);
            this.d.setStandalone(true);
            this.d.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            this.d.setVideoScaleMode(2);
            this.d.setMuteOnlyOnLostAudioFocus(true);
            this.d.Code(this.E);
            this.d.Code(this.G);
            this.d.Code(this.J);
            this.d.Code(this.M);
            this.d.Code(this.K);
            this.d.Code(this.H);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.d, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        if (this.g && this.e == null) {
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            imageView.setId(R.id.hiad_mute_icon);
            this.e.setImageResource(bg.Code(true));
            bg.Code(this.e);
            Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_8_dp);
            this.e.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.haid_splash_sound_margin_bottom);
            int i = R.dimen.haid_splash_sound_margin_right;
            layoutParams.rightMargin = resources.getDimensionPixelSize(i);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i));
            if (this.o == 0) {
                if (cn.V(getContext())) {
                    if (layoutParams.isMarginRelative()) {
                        layoutParams.setMarginEnd(layoutParams.rightMargin + this.p + bg.I(getContext()));
                    } else {
                        layoutParams.rightMargin += this.p + bg.I(getContext());
                    }
                    if (this.S.c() != 1 && (5 == this.q || q.B(getContext()) || q.S(getContext()))) {
                        layoutParams.bottomMargin += bg.I(getContext());
                    }
                } else if (layoutParams.isMarginRelative()) {
                    layoutParams.setMarginEnd(this.p + bg.I(getContext()));
                } else {
                    layoutParams.rightMargin = this.p + bg.I(getContext());
                }
            } else if (this.S.c() != 1) {
            }
            addView(this.e, layoutParams);
            this.e.bringToFront();
            this.e.setSelected(false);
            this.e.setOnClickListener(this.A);
        }
    }

    private boolean e() {
        AdContentData adContentData = this.S;
        return adContentData != null && adContentData.Z() == 1;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public void Code(int i, int i2) {
        super.Code(i, i2);
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lv
    public void F() {
        super.F();
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.D();
        }
    }

    public void L() {
        fh.V("PPSVideoView", "unMuteCustomized");
        VideoView videoView = this.d;
        if (videoView != null) {
            float f = this.v;
            if (f > 0.0f) {
                videoView.Code(f);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView
    public void S() {
        pauseView();
    }

    @Override // com.huawei.hms.ads.lu
    public void Code(String str) {
        fx fxVar = this.w;
        if (fxVar != null) {
            fxVar.Code();
        }
        VideoInfo videoInfoT = this.S.t();
        this.h = videoInfoT;
        if (videoInfoT != null) {
            this.u = TextUtils.equals("y", videoInfoT.S());
            if (TextUtils.equals("n", this.h.f()) || this.s) {
                this.g = false;
            }
        }
        d();
        b();
        this.d.setAudioFocusType(this.n);
        this.d.setAlpha(0.0f);
        this.d.setVideoFileUrl(str);
        if (this.t || !this.u) {
            this.d.b();
        } else {
            this.d.c();
        }
        this.d.Code(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        fh.V("PPSVideoView", "switchSound enableSound: " + z);
        VideoView videoView = this.d;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
        ((iw) this.B).Code(!z);
    }
}
