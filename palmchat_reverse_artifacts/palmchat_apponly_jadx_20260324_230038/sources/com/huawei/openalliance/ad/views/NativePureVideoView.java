package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fx;
import com.huawei.hms.ads.ig;
import com.huawei.hms.ads.it;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.lr;
import com.huawei.hms.ads.me;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bm;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NativePureVideoView extends NativeMediaView implements lm, me {
    private static final String S = "NativePureVideoView";
    private VideoView D;
    private it F;
    private ImageView L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6966a;
    private VideoInfo b;
    private ImageInfo c;
    private boolean d;
    private long e;
    private long f;
    private boolean g;
    private lr h;
    private fx i;
    private com.huawei.openalliance.ad.media.listener.b j;
    private MediaStateListener k;
    private final com.huawei.openalliance.ad.media.listener.h l;
    private com.huawei.openalliance.ad.media.listener.c m;
    private com.huawei.openalliance.ad.media.listener.f n;

    public NativePureVideoView(Context context) {
        super(context);
        this.g = false;
        this.j = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
            }
        };
        this.k = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i;
                NativePureVideoView.this.e = System.currentTimeMillis();
                it itVar = NativePureVideoView.this.F;
                if (i > 0) {
                    itVar.V();
                } else {
                    itVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
            }
        };
        this.l = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativePureVideoView.this.F != null) {
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.getContext(), j);
                }
            }
        };
        this.m = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }
        };
        this.n = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    private void b() {
        List<ImageInfo> listB;
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null || (listB = lVar.B()) == null || listB.size() <= 0) {
            return;
        }
        ImageInfo imageInfo = listB.get(0);
        this.c = imageInfo;
        if (imageInfo != null) {
            if (bc.B(imageInfo.Z())) {
                fh.V(S, "don't load preview image with http url");
                return;
            }
            if (this.c.B() > 0) {
                setRatio(Float.valueOf((this.c.C() * 1.0f) / this.c.B()));
            }
            this.F.Code(this.c);
        }
    }

    private void c() {
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null) {
            return;
        }
        VideoInfo videoInfoC = lVar.C();
        this.b = videoInfoC;
        if (videoInfoC != null) {
            Float fG = videoInfoC.g();
            if (fG == null) {
                fG = Float.valueOf(1.7777778f);
            }
            setRatio(fG);
            this.D.setDefaultDuration(this.b.I());
            this.F.Code(this.b);
        }
    }

    private void d() {
        e();
        this.f6966a = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (fh.Code()) {
            fh.Code(S, "showPreviewView");
        }
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bm.Code((View) this.L, true);
        this.D.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (fh.Code()) {
            fh.Code(S, "hidePreviewView");
        }
        bm.Code(this.L, 8, 300, 300);
        this.D.setAlpha(1.0f);
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    @Override // com.huawei.hms.ads.me
    public void destroyView() {
        this.D.destroyView();
    }

    public com.huawei.openalliance.ad.media.b getCurrentState() {
        return this.D.getCurrentState();
    }

    public ImageView getPreviewImageView() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.me
    public void pauseView() {
        this.D.pauseView();
    }

    @Override // com.huawei.hms.ads.me
    public void resumeView() {
        ((NativeMediaView) this).V = false;
        this.D.resumeView();
        this.D.setNeedPauseOnSurfaceDestory(true);
        ((NativeMediaView) this).C.onGlobalLayout();
    }

    public void setAudioFocusType(int i) {
        this.D.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.lm
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        com.huawei.openalliance.ad.media.b currentState = this.D.getCurrentState();
        if (((NativeMediaView) this).B == gVar && currentState.V(com.huawei.openalliance.ad.media.d.IDLE) && currentState.V(com.huawei.openalliance.ad.media.d.ERROR)) {
            fh.V(S, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        d();
        this.F.Code(((NativeMediaView) this).B);
        if (((NativeMediaView) this).B == null) {
            this.b = null;
        } else {
            b();
            c();
        }
    }

    @Override // com.huawei.hms.ads.lm
    public void setPpsNativeView(lr lrVar) {
        this.h = lrVar;
    }

    public void setPreferStartPlayTime(int i) {
        this.D.setPreferStartPlayTime(i);
    }

    public void setStandalone(boolean z) {
        this.D.setStandalone(z);
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.j = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
            }
        };
        this.k = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i;
                NativePureVideoView.this.e = System.currentTimeMillis();
                it itVar = NativePureVideoView.this.F;
                if (i > 0) {
                    itVar.V();
                } else {
                    itVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
            }
        };
        this.l = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativePureVideoView.this.F != null) {
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.getContext(), j);
                }
            }
        };
        this.m = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i, false);
            }
        };
        this.n = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    @Override // com.huawei.hms.ads.lm
    public void S() {
        this.D.D();
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        this.j = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.i.V();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
            }
        };
        this.k = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativePureVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i2));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.g) {
                    return;
                }
                NativePureVideoView.this.g = true;
                NativePureVideoView.this.f = i2;
                NativePureVideoView.this.e = System.currentTimeMillis();
                it itVar = NativePureVideoView.this.F;
                if (i2 > 0) {
                    itVar.V();
                } else {
                    itVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.i.B(), NativePureVideoView.this.i.Z(), NativePureVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
            }
        };
        this.l = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code(NativePureVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativePureVideoView.this.F != null) {
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.getContext(), j);
                }
            }
        };
        this.m = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i2, false);
            }
        };
        this.n = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("n");
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (NativePureVideoView.this.b != null) {
                    NativePureVideoView.this.b.Code("y");
                }
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        this.i.I();
        if (this.g) {
            this.g = false;
            if (z) {
                this.F.Code(this.e, System.currentTimeMillis(), this.f, i);
            } else {
                this.F.V(this.e, System.currentTimeMillis(), this.f, i);
            }
        }
    }

    private void V(boolean z) {
        fh.V(S, "doRealPlay, auto:" + z);
        this.i.Code();
        this.D.Code(z);
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(long j) {
        this.F.Code(j);
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_native_pure_video_view, this);
        this.F = new ig(context, this);
        this.i = new fx(getTAG());
        this.D = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = (ImageView) findViewById(R.id.hiad_iv_preview_video);
        this.D.setScreenOnWhilePlaying(true);
        this.D.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.D.Code(this.k);
        this.D.Code(this.j);
        this.D.Code(this.m);
        this.D.Code(this.n);
        this.D.Code(this.l);
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.c;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.Z(), imageInfo.Z())) {
            return;
        }
        this.L.setImageDrawable(drawable);
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(VideoInfo videoInfo, boolean z) {
        VideoInfo videoInfo2;
        fh.V(S, "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z));
        if (!z || (videoInfo2 = this.b) == null || videoInfo == null || !TextUtils.equals(videoInfo2.V(), videoInfo.V())) {
            return;
        }
        this.f6966a = true;
        this.D.setVideoFileUrl(videoInfo.V());
        if (this.d) {
            V(false);
        }
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(String str) {
        this.F.Code(str);
    }
}
