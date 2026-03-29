package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.ap;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bm;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j implements MediaStateListener, com.huawei.openalliance.ad.media.listener.b, com.huawei.openalliance.ad.media.listener.c, BaseVideoView.h, e {
    private static final String V = "j";
    private ImageView B;
    private ImageView C;
    private View D;
    private ImageView F;
    private VideoView I;
    private View L;
    private View S;
    private NativeVideoControlPanel Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6988a;
    private boolean c;
    private int d;
    private boolean e;
    private View.OnClickListener f;
    private a g;
    private int h;
    private VideoInfo j;
    private final String b = "aPT" + hashCode();
    private boolean i = false;
    private int k = 0;
    private boolean l = false;
    private Runnable m = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.I == null || !j.this.c) {
                return;
            }
            j.this.V(true);
        }
    };
    private View.OnClickListener n = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.l = true;
            j.this.L(!view.isSelected());
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void V(boolean z, int i);

        boolean V();
    }

    public j(VideoView videoView, NativeVideoControlPanel nativeVideoControlPanel) {
        Code(videoView);
        Code(nativeVideoControlPanel);
    }

    private void b(boolean z) {
        if (this.I == null) {
            return;
        }
        if (z || this.h == 1 || this.i) {
            s();
        } else {
            t();
        }
    }

    private void c(boolean z) {
        VideoView videoView;
        a aVar = this.g;
        if (aVar == null || (videoView = this.I) == null) {
            return;
        }
        aVar.Code(z, videoView.getCurrentState().V());
    }

    private void e() {
        NativeVideoControlPanel nativeVideoControlPanel = this.Z;
        if (nativeVideoControlPanel == null) {
            return;
        }
        this.S = nativeVideoControlPanel.C();
        this.D = this.Z.L();
        View viewF = this.Z.F();
        this.L = viewF;
        if (viewF != null) {
            viewF.setClickable(true);
        }
        ImageView imageViewS = this.Z.S();
        this.F = imageViewS;
        if (imageViewS != null) {
            imageViewS.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.o();
                }
            });
        }
        I(this.Z);
        k();
        i();
        a(false);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        bj.Code(this.b);
        i();
        if (this.k == 10) {
            q();
        }
        VideoView videoView = this.I;
        if (videoView != null && !videoView.getCurrentState().Code()) {
            g();
        }
        V(false);
    }

    private void g() {
        if (this.F == null) {
            return;
        }
        fh.Code(V, "showPreviewView");
        Animation animation = this.F.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bm.Code((View) this.F, true);
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    private void h() {
        VideoView videoView;
        fh.Code(V, "hidePreviewView");
        bm.Code(this.F, 8, 300, 300);
        if (this.F == null || (videoView = this.I) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    private void i() {
        View view = this.L;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void j() {
        View view = this.L;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void k() {
        l();
        Z(this.Z);
        V(this.Z);
        if (this.k == 10) {
            m();
        }
    }

    private void l() {
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.Code((MediaStateListener) this);
            this.I.Code((com.huawei.openalliance.ad.media.listener.b) this);
            this.I.Code((com.huawei.openalliance.ad.media.listener.c) this);
            this.I.Code((e) this);
            this.I.setSurfaceListener(this);
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.p();
                }
            });
        }
    }

    private void m() {
        NativeVideoControlPanel nativeVideoControlPanel = this.Z;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.I == null) {
            return;
        }
        bj.Code(this.b);
        if (this.I.a()) {
            this.I.L();
            return;
        }
        if (!ap.Z(this.I.getContext())) {
            Toast.makeText(this.I.getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.i || this.h == 1 || ap.I(this.I.getContext())) {
            V(false);
            return;
        }
        fh.V(V, "non wifi, show alert");
        this.I.L();
        j();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        View.OnClickListener onClickListener;
        VideoView videoView = this.I;
        if (videoView == null || (onClickListener = this.f) == null) {
            return;
        }
        onClickListener.onClick(videoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        View.OnClickListener onClickListener;
        if (this.I == null || (onClickListener = this.f) == null) {
            return;
        }
        onClickListener.onClick(this.Z);
    }

    private void r() {
        Code(false, false);
    }

    private void s() {
        if (this.I == null) {
            return;
        }
        i();
        if (!this.I.getCurrentState().Code()) {
            g();
        }
        a aVar = this.g;
        if (aVar != null) {
            this.c = aVar.V();
        }
        if (this.c && !this.e) {
            V(true);
        } else {
            if (this.I.a()) {
                return;
            }
            F();
        }
    }

    private void t() {
        VideoView videoView = this.I;
        if (videoView != null) {
            if ((!videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.d.PREPARING) && !this.I.a()) || this.i || this.h == 1) {
                return;
            }
            this.I.D();
        }
    }

    private void u() {
        VideoView videoView = this.I;
        if (videoView != null) {
            if (videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.d.PREPARING) || this.I.a()) {
                this.I.L();
            }
        }
    }

    public void B() {
        fh.Code(V, "setForImageOnly");
        Code((VideoView) null);
        Code(false, false);
        a(false);
    }

    public void C() {
        bj.Code(this.b);
    }

    public void D() {
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.h
    public void I() {
        g();
        a(false);
    }

    public void L() {
        this.e = true;
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void V() {
        View view = this.S;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.S.setVisibility(8);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Z() {
        u();
    }

    public void a() {
        this.e = false;
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.resumeView();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, false, true);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, true, false);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
        h();
        Code(false, false);
        a(true);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, false, false);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onProgress(int i, int i2) {
        VideoInfo videoInfo;
        if (i2 <= 0 || (videoInfo = this.j) == null) {
            return;
        }
        videoInfo.Code(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        fh.V(V, "switchSound: " + z);
        VideoView videoView = this.I;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
    }

    private void a(boolean z) {
        NativeVideoControlPanel nativeVideoControlPanel = this.Z;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.Code(z);
        }
    }

    private void d(boolean z) {
        VideoView videoView;
        a aVar = this.g;
        if (aVar == null || (videoView = this.I) == null) {
            return;
        }
        aVar.V(z, videoView.getCurrentState().V());
    }

    public void B(int i) {
        fh.Code(V, "linkedVideoMode is " + i);
        this.k = i;
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void Code() {
        View view = this.S;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.S.setVisibility(0);
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void F() {
        Code(true, false);
    }

    public void I(int i) {
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.setDefaultDuration(i);
        }
    }

    public void S() {
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.D();
        }
        i();
        a(false);
        F();
        g();
    }

    public void V(int i) {
        fh.Code(V, "setPreferStartPlayTime " + i);
        this.d = i;
        VideoView videoView = this.I;
        if (videoView != null) {
            videoView.setPreferStartPlayTime(i);
        }
    }

    public void Z(int i) {
        this.h = i;
    }

    public boolean c() {
        return this.l;
    }

    private void D(boolean z) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.Code(z);
        }
    }

    private void I(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView imageViewB = nativeVideoControlPanel.B();
        this.C = imageViewB;
        if (imageViewB != null) {
            imageViewB.setOnClickListener(this.n);
        }
    }

    private void V(NativeVideoControlPanel nativeVideoControlPanel) {
        View viewD = nativeVideoControlPanel.D();
        this.f6988a = viewD;
        if (viewD != null) {
            viewD.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.f();
                }
            });
        }
    }

    private void Z(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView imageViewCode = nativeVideoControlPanel.Code();
        this.B = imageViewCode;
        if (imageViewCode != null) {
            imageViewCode.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.this.g != null) {
                        j.this.g.Code();
                    }
                    if (j.this.k != 10) {
                        j.this.n();
                        return;
                    }
                    fh.Code(j.V, "linkedVideoMode is " + j.this.k);
                    j.this.q();
                }
            });
            if (nativeVideoControlPanel.V() > 0) {
                this.B.setImageResource(nativeVideoControlPanel.V());
                bg.Code(this.B);
            }
        }
    }

    public void C(boolean z) {
        if (fh.Code()) {
            fh.Code(V, "setPlayBtn: %s", Boolean.valueOf(z));
        }
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void Code(int i) {
    }

    public void S(boolean z) {
        if (z) {
            Code((String) null);
            V(0);
            I(0);
            Code((Bitmap) null);
        }
        g();
        F();
    }

    private void Code(int i, boolean z, boolean z2) {
        NativeVideoControlPanel nativeVideoControlPanel;
        C();
        if (z2) {
            i = 0;
        }
        this.d = i;
        if (this.B != null && (nativeVideoControlPanel = this.Z) != null && nativeVideoControlPanel.V() != 0) {
            this.B.setImageResource(this.Z.V());
            bg.Code(this.B);
        }
        if (!z) {
            g();
        }
        a(false);
        View view = this.L;
        if (view == null || view.getVisibility() != 0) {
            Code(true, true);
        }
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void B(boolean z) {
        fh.V(V, "setMuteBtn: " + z);
        ImageView imageViewB = this.Z.B();
        if (imageViewB != null) {
            imageViewB.setSelected(!z);
        }
    }

    public void Code(long j) {
        VideoView videoView;
        String str = V;
        fh.V(str, "autoPlay - delayMs: %d", Long.valueOf(j));
        bj.Code(this.b);
        if (!this.c || (videoView = this.I) == null) {
            return;
        }
        if (videoView.a()) {
            fh.Code(str, "autoPlay - video is playing");
            V(true);
        } else {
            fh.Code(str, "autoPlay - start delay runnable");
            this.I.e();
            bj.Code(this.m, this.b, j);
        }
    }

    public void I(boolean z) {
        this.c = z;
    }

    public void V(boolean z) {
        if (this.I != null) {
            D(z);
            this.I.setPreferStartPlayTime(this.d);
            this.I.Code(z);
        }
    }

    public void Z(boolean z) {
        fh.V(V, "toggleMute: " + z);
        if (this.I == null || this.Z == null) {
            return;
        }
        B(z);
        if (z) {
            this.I.b();
        } else {
            this.I.c();
        }
    }

    public void Code(Bitmap bitmap) {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void Code(Drawable drawable) {
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void Code(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void Code(VideoInfo videoInfo) {
        this.j = videoInfo;
    }

    @Override // com.huawei.openalliance.ad.media.listener.c
    public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
        Code(i, false, false);
    }

    public void Code(NativeVideoControlPanel nativeVideoControlPanel) {
        this.Z = nativeVideoControlPanel;
        e();
    }

    public void Code(VideoView videoView) {
        this.I = videoView;
    }

    public void Code(a aVar) {
        this.g = aVar;
    }

    public void Code(String str) {
        VideoView videoView;
        if (this.Z == null || (videoView = this.I) == null) {
            return;
        }
        videoView.setVideoFileUrl(str);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Code(boolean z) {
        fh.Code(V, "onNetworkConnectedOrChanged, isWifi= %s", Boolean.valueOf(z));
        b(z);
    }

    private void Code(boolean z, boolean z2) {
        boolean zCode;
        View view = this.D;
        if (z2) {
            zCode = bm.Code(view, z ? 0 : 8);
        } else {
            zCode = bm.Code(view, z);
        }
        if (zCode) {
            if (z) {
                c(z2);
            } else {
                d(z2);
            }
        }
    }
}
