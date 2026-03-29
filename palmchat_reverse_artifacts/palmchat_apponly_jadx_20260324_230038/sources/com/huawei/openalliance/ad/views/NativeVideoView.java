package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.ca;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.ey;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fx;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hz;
import com.huawei.hms.ads.ia;
import com.huawei.hms.ads.ig;
import com.huawei.hms.ads.it;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.lr;
import com.huawei.hms.ads.me;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.u;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ap;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.views.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NativeVideoView extends NativeMediaView implements gl, lm, me {
    private static final String S = "NativeVideoView";
    private a D;
    private hb F;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f6967a;
    private it b;
    private VideoInfo c;
    private ImageInfo d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;
    private NativeVideoControlPanel i;
    private VideoView j;
    private lr k;
    private MediaContent l;
    private long m;
    private long n;
    private boolean o;
    private fx p;
    private boolean q;
    private final com.huawei.openalliance.ad.media.listener.b r;
    private final com.huawei.openalliance.ad.media.listener.h s;
    private final MediaStateListener t;
    private final com.huawei.openalliance.ad.media.listener.c u;
    private com.huawei.openalliance.ad.media.listener.d v;
    private com.huawei.openalliance.ad.media.listener.f w;
    private j.a x;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void I();

        void V();

        void V(boolean z, int i);

        void Z();
    }

    public NativeVideoView(Context context) {
        super(context);
        this.F = new gp();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.n();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.m();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.k();
                hb hbVar = NativeVideoView.this.F;
                if (i > 0) {
                    hbVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (hbVar != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), !"y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ap.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                NativeVideoView.this.f6967a.I(i);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f6967a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f6967a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fh.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.j() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }
        };
        Code(context);
    }

    private void b() {
        fh.V(S, "setInnerListener");
        this.j.Code(this.u);
        this.j.Code(this.w);
        this.f6967a.Z(!h());
    }

    private void e() {
        VideoConfiguration videoConfiguration;
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null) {
            return;
        }
        this.c = lVar.C();
        d();
        if (((NativeMediaView) this).B.at() != null && (videoConfiguration = ((NativeMediaView) this).B.at().getVideoConfiguration()) != null) {
            if (!jg.d(((NativeMediaView) this).B.K())) {
                Code(videoConfiguration.isStartMuted());
            }
            setAudioFocusType(videoConfiguration.getAudioFocusType());
        }
        if (this.c == null) {
            this.f6967a.B();
            return;
        }
        this.f6967a.Code(this.j);
        this.f = ((NativeMediaView) this).B.az();
        this.f6967a.Code(this.c);
        Float fG = this.c.g();
        if (fG == null) {
            fG = Float.valueOf(1.7777778f);
        }
        setRatio(fG);
        this.f6967a.B(this.f);
        this.f6967a.Z(!h());
        this.f6967a.V(getContinuePlayTime());
        this.f6967a.I(this.c.I());
        this.f6967a.Z(getAutoPlayNetForVideoCtrlBridge());
        this.b.Code(this.c);
        this.i.setNonWifiAlertMsg(this.c.Z() > 0 ? getResources().getString(R.string.hiad_consume_data_to_play_video, bc.Code(getContext(), this.c.Z())) : getResources().getString(R.string.hiad_consume_data_to_play_video_no_data_size));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        MediaContent mediaContent;
        if (((NativeMediaView) this).B == null) {
            return;
        }
        MediaContent mediaContent2 = this.l;
        if (mediaContent2 == null || mediaContent2.getImage() == null) {
            List<ImageInfo> listB = ((NativeMediaView) this).B.B();
            if (listB == null || listB.size() <= 0) {
                return;
            }
            ImageInfo imageInfo = listB.get(0);
            this.d = imageInfo;
            if (imageInfo != null) {
                MediaContent mediaContent3 = this.l;
                if (mediaContent3 != null && mediaContent3.getImage() != null) {
                    mediaContent = this.l;
                    if (mediaContent instanceof ca) {
                        if (((ca) mediaContent).Code(this.d.Z())) {
                            mediaContent = this.l;
                        }
                    }
                }
                Code(this.d);
                return;
            }
            return;
        }
        mediaContent = this.l;
        if (mediaContent instanceof ca) {
        }
        Code(mediaContent);
    }

    private void g() {
        this.e = false;
        this.f6967a.S(true);
    }

    private int getAutoPlayNetForVideoCtrlBridge() {
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null) {
            return 0;
        }
        return (lVar.f_() == null || (jg.c(((NativeMediaView) this).B.K()) && this.c != null)) ? this.c.f() : ((NativeMediaView) this).B.f_().getAutoPlayNetwork();
    }

    private int getContinuePlayTime() {
        VideoInfo videoInfo = this.c;
        if (videoInfo == null) {
            fh.Code(S, "getContinuePlayTime other");
            return 0;
        }
        int iL = videoInfo.L();
        if (iL >= 5000) {
            return iL;
        }
        return 0;
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    private boolean h() {
        if (!p() || jg.d(((NativeMediaView) this).B.K()) || i()) {
            VideoInfo videoInfo = this.c;
            return videoInfo != null && TextUtils.equals(videoInfo.a(), "y");
        }
        boolean zIsStartMuted = ((NativeMediaView) this).B.f_().isStartMuted();
        fh.V(S, "VideoConfig, isMute: %s", Boolean.valueOf(zIsStartMuted));
        return !zIsStartMuted;
    }

    private boolean i() {
        j jVar = this.f6967a;
        return jVar != null && jVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        VideoInfo videoInfo = this.c;
        if (videoInfo == null) {
            return false;
        }
        if (videoInfo.L() >= this.c.I()) {
            this.c.Code(0);
            fh.V(S, "play progress bigger than video duration, skip autoPlay.");
            return false;
        }
        if (p() && !jg.c(((NativeMediaView) this).B.K())) {
            int autoPlayNetwork = ((NativeMediaView) this).B.f_().getAutoPlayNetwork();
            fh.V(S, "videoConfig, auto play net: %s.", Integer.valueOf(autoPlayNetwork));
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && ap.I(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !ap.I(getContext())) {
                return false;
            }
        }
        return TextUtils.equals(this.c.B(), "y") || TextUtils.equals(this.c.B(), "a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.I();
        }
    }

    private boolean o() {
        if (this.c == null || !ap.Z(getContext()) || !j()) {
            return false;
        }
        if (p() && !jg.c(((NativeMediaView) this).B.K())) {
            int autoPlayNetwork = ((NativeMediaView) this).B.f_().getAutoPlayNetwork();
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && ap.I(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !ap.I(getContext())) {
                return false;
            }
        }
        if (this.c.f() == 1) {
            return true;
        }
        return this.c.f() == 0 && ap.I(getContext());
    }

    private boolean p() {
        l lVar = ((NativeMediaView) this).B;
        return (lVar == null || lVar.f_() == null) ? false : true;
    }

    private void q() {
        ey.Code(null);
        ez.Code(getContext()).V();
    }

    public void C() {
        this.j.b();
    }

    public void D() {
        this.f6967a.V(false);
    }

    public void F() {
        this.j.c();
    }

    public void L() {
        this.f6967a.D();
    }

    @Override // com.huawei.hms.ads.me
    public void destroyView() {
        this.j.destroyView();
        this.l = null;
        this.F.I();
    }

    public float getAspectRatio() {
        Float fG;
        VideoInfo videoInfo = this.c;
        if (videoInfo == null || (fG = videoInfo.g()) == null) {
            return 0.0f;
        }
        return fG.floatValue();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getAutoPlayAreaPercentageThresshold() {
        VideoInfo videoInfo = this.c;
        return videoInfo != null ? videoInfo.c() : super.getAutoPlayAreaPercentageThresshold();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getHiddenAreaPercentageThreshhold() {
        VideoInfo videoInfo = this.c;
        return videoInfo != null ? Math.max(100 - videoInfo.d(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    public MediaContent getMediaContent() {
        return this.l;
    }

    public ImageView getPreviewImageView() {
        return this.i.S();
    }

    public VideoView getVideoView() {
        return this.j;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.F.I();
    }

    @Override // com.huawei.hms.ads.me
    public void pauseView() {
        this.f6967a.L();
    }

    @Override // com.huawei.hms.ads.me
    public void resumeView() {
        this.f6967a.a();
        fh.V(S, "resumeView");
        b();
        ((NativeMediaView) this).V = false;
        ((NativeMediaView) this).C.onGlobalLayout();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i) {
        this.j.setAudioFocusType(i);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f6967a.Code(onClickListener);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.l = mediaContent;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.lm
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        String str = S;
        StringBuilder sb = new StringBuilder();
        sb.append("setNativeAd ");
        sb.append(gVar != null ? gVar.d() : com.igexin.push.core.b.m);
        fh.V(str, sb.toString());
        if (gVar == null) {
            this.l = null;
        }
        com.huawei.openalliance.ad.media.b currentState = this.j.getCurrentState();
        if (((NativeMediaView) this).B == gVar && currentState.V(com.huawei.openalliance.ad.media.d.IDLE) && currentState.V(com.huawei.openalliance.ad.media.d.ERROR)) {
            fh.V(str, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        g();
        this.b.Code(((NativeMediaView) this).B);
        if (((NativeMediaView) this).B != null) {
            f();
            e();
            this.f6967a.C(false);
        } else {
            this.f6967a.Z(true);
            this.c = null;
            this.l = null;
        }
        if (!j() || h()) {
            return;
        }
        this.o = true;
    }

    @Override // com.huawei.hms.ads.lm
    public void setPpsNativeView(lr lrVar) {
        this.k = lrVar;
    }

    public void setVideoEventListener(a aVar) {
        this.D = aVar;
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new gp();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.n();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.m();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.k();
                hb hbVar = NativeVideoView.this.F;
                if (i > 0) {
                    hbVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (hbVar != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), !"y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ap.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                NativeVideoView.this.f6967a.I(i);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f6967a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f6967a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fh.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.j() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }
        };
        Code(context);
    }

    private boolean c() {
        NativeAdConfiguration nativeAdConfigurationAt;
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null || (nativeAdConfigurationAt = lVar.at()) == null) {
            return false;
        }
        return nativeAdConfigurationAt.isReturnUrlsForImages();
    }

    private void d() {
        String str;
        String str2;
        String str3 = S;
        fh.V(str3, "reset video info");
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null || lVar.q() == null || this.c == null) {
            return;
        }
        Map map = (Map) ad.V(((NativeMediaView) this).B.q().bg(), Map.class, new Class[0]);
        fh.V(str3, "configMap : %s", ((NativeMediaView) this).B.q().bg());
        if (map != null) {
            str = (String) map.get("videoAutoPlay");
            str2 = (String) map.get("videoPlaySound");
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "y";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "n";
        }
        this.c.B(str);
        this.c.C(str2);
        this.c.Code(str2);
        this.c.Z(TextUtils.equals(str, "a") ? 1 : 0);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void B() {
        fh.V(S, "onViewShownBetweenFullAndPartial");
        this.f6967a.C(true);
        b();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void I() {
        fh.V(S, "onViewPartialHidden");
        this.g = false;
        this.j.V(this.u);
        this.j.V(this.w);
        if (this.c != null) {
            this.f6967a.C(false);
            this.f6967a.I(false);
            this.q = true;
            this.f6967a.C();
            this.f6967a.S();
        }
    }

    @Override // com.huawei.hms.ads.lm
    public void S() {
        this.f6967a.S();
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new gp();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, true);
                NativeVideoView.this.n();
                if (NativeVideoView.this.b != null) {
                    long j = i2;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.m();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (fh.Code()) {
                    fh.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i2));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i2;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.k();
                hb hbVar = NativeVideoView.this.F;
                if (i2 > 0) {
                    hbVar.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (hbVar != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), !"y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i2);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i22, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ap.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                NativeVideoView.this.f6967a.I(i2);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f6967a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f6967a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i2) {
                NativeVideoView.this.V(z, i2);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fh.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.j() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i2) {
                NativeVideoView.this.Code(z, i2);
            }
        };
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void Code() {
        super.Code();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void V() {
        this.h = System.currentTimeMillis();
        this.f6967a.C(true);
        Code(this.c);
        b();
        String str = S;
        fh.V(str, "onViewFullShown hashCheckSuccess: %s", Boolean.valueOf(this.e));
        if (this.e) {
            boolean zJ = j();
            this.q = false;
            fh.V(str, "onViewFullShown autoplay: %s", Boolean.valueOf(zJ));
            this.f6967a.I(zJ);
            this.f6967a.V(getContinuePlayTime());
            if (o()) {
                this.f6967a.Code(this.c.S());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        VideoInfo videoInfo = this.c;
        if (videoInfo != null) {
            videoInfo.Code(z ? 0 : i);
        }
        this.p.I();
        if (this.L) {
            this.L = false;
            if (z) {
                this.b.Code(this.m, System.currentTimeMillis(), this.n, i);
                this.F.a();
            } else {
                this.b.V(this.m, System.currentTimeMillis(), this.n, i);
                this.F.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V(z, i);
        }
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(long j) {
        this.b.Code(j);
    }

    private void Code(Context context) {
        this.b = new ig(context, this);
        LayoutInflater.from(context).inflate(R.layout.hiad_native_video_view, this);
        this.j = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.i = (NativeVideoControlPanel) findViewById(R.id.hiad_native_video_ctrl_panel);
        this.j.setStandalone(false);
        this.j.setScreenOnWhilePlaying(true);
        this.j.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        j jVar = new j(this.j, this.i);
        this.f6967a = jVar;
        jVar.Code(this.x);
        this.j.Code(this.t);
        this.j.Code(this.r);
        this.j.Code(this.u);
        this.j.Code(this.w);
        this.j.Code(this.v);
        this.j.Code(this.s);
        this.p = new fx(getTAG());
    }

    public void Code(hb hbVar, l lVar) {
        this.F = hbVar;
        Code(lVar);
    }

    private void Code(MediaContent mediaContent) {
        this.f6967a.Code(mediaContent.getImage());
        if (mediaContent.getAspectRatio() > 0.0f) {
            setRatio(Float.valueOf(mediaContent.getAspectRatio()));
        }
    }

    private void Code(ImageInfo imageInfo) {
        if (imageInfo.B() > 0) {
            setRatio(Float.valueOf((imageInfo.C() * 1.0f) / imageInfo.B()));
        }
        if (c()) {
            return;
        }
        this.b.Code(imageInfo);
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.d;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.Z(), imageInfo.Z())) {
            return;
        }
        u uVar = new u(this.d, false);
        uVar.Code(drawable);
        this.l = new ca(uVar);
        this.f6967a.Code(drawable);
    }

    private void Code(VideoInfo videoInfo) {
        ex exVarCode = ey.Code();
        if (exVarCode == null || videoInfo == null) {
            return;
        }
        int iCode = exVarCode.Code();
        videoInfo.Code(iCode);
        fh.V(S, "obtain progress from linked view " + iCode);
        q();
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(VideoInfo videoInfo, boolean z) {
        VideoInfo videoInfo2;
        String str = S;
        fh.V(str, "onCheckVideoResult: %s", Boolean.valueOf(z));
        if (!z || (videoInfo2 = this.c) == null || videoInfo == null || !TextUtils.equals(videoInfo2.V(), videoInfo.V())) {
            return;
        }
        this.e = true;
        this.f6967a.Code(videoInfo.V());
        if (((NativeMediaView) this).V) {
            this.f6967a.V(getContinuePlayTime());
            boolean zJ = j();
            fh.V(str, "onCheckVideoResult - full shown, autoPlay: %s", Boolean.valueOf(zJ));
            this.f6967a.I(zJ);
            if (o()) {
                long jS = ((long) videoInfo.S()) - (System.currentTimeMillis() - this.h);
                if (jS < 0) {
                    jS = 0;
                }
                this.f6967a.Code(jS);
            }
        }
    }

    private void Code(l lVar) {
        if (lVar.C() != null) {
            this.F.Code(ia.Code(0.0f, o(), hz.STANDALONE));
        }
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(String str) {
        this.b.Code(str);
    }

    public void Code(boolean z) {
        fh.V(S, "customToggleVideoMute, customMuteState is " + z);
        VideoInfo videoInfo = this.c;
        if (videoInfo != null) {
            videoInfo.Code(z ? "n" : "y");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code(z, i);
        }
    }

    @Override // com.huawei.hms.ads.gl
    public View getOpenMeasureView() {
        return this;
    }

    @Deprecated
    public void setNotShowDataUsageAlert(boolean z) {
    }
}
