package com.opos.mobad.mediaplayer.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.az;
import com.opos.exoplayer.core.ExoPlaybackException;
import com.opos.exoplayer.core.Player;
import com.opos.exoplayer.core.c.a;
import com.opos.exoplayer.core.n;
import com.opos.exoplayer.core.p;
import com.opos.exoplayer.core.source.e;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.upstream.g;
import com.opos.exoplayer.core.upstream.j;
import com.opos.exoplayer.core.upstream.l;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.v;
import com.opos.exoplayer.core.video.e;
import com.opos.exoplayer.core.w;
import com.opos.exoplayer.ui.AspectRatioFrameLayout;
import com.opos.mobad.mediaplayer.b.d;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a implements Player.b, com.opos.mobad.d.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9008a;
    private v b;
    private RelativeLayout c;
    private ImageView d;
    private AspectRatioFrameLayout e;
    private com.opos.exoplayer.ui.b f;
    private g.a g;
    private h h;
    private List<com.opos.mobad.d.d.b> i = new ArrayList();
    private int j = 0;
    private long k = 0;
    private boolean l = true;
    private View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.mediaplayer.c.a.3
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            com.opos.exoplayer.ui.b bVar = a.this.f;
            if (bVar == null || bVar.isHardwareAccelerated()) {
                return;
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onViewAttachedToWindow switchSurfaceType");
            bVar.a(1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    public a(Context context, com.opos.mobad.d.d.b bVar) {
        this.f9008a = context;
        b(bVar);
        j();
    }

    private void j() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "init");
        try {
            b(false);
            k();
            Context context = this.f9008a;
            this.g = new l(context, y.a(context, context.getPackageName()));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "init", e);
        }
    }

    private void k() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayerView");
        try {
            this.c = new RelativeLayout(this.f9008a);
            com.opos.exoplayer.ui.b bVar = new com.opos.exoplayer.ui.b(this.f9008a);
            this.f = bVar;
            bVar.addOnAttachStateChangeListener(this.m);
            this.f.b(0);
            this.f.a(false);
            this.f.a(this.b);
            this.c.addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.f9008a);
            this.e = aspectRatioFrameLayout;
            aspectRatioFrameLayout.a(0);
            ImageView imageView = new ImageView(this.f9008a);
            this.d = imageView;
            imageView.setVisibility(8);
            this.e.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.c.addView(this.e, layoutParams);
            l();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initPlayerView", e);
        }
    }

    private void l() {
        Player.d dVarA = this.b.a();
        if (dVarA == null) {
            return;
        }
        dVarA.a(new e() { // from class: com.opos.mobad.mediaplayer.c.a.1
            @Override // com.opos.exoplayer.core.video.e
            public void a() {
                for (int i = 0; i < a.this.i.size(); i++) {
                    if (a.this.i.get(i) != null) {
                        ((com.opos.mobad.d.d.b) a.this.i.get(i)).j();
                    }
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRenderFirstFrame");
            }

            @Override // com.opos.exoplayer.core.video.e
            public void a(int i, int i2, int i3, float f) {
                float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
                com.opos.exoplayer.ui.b bVar = a.this.f;
                if (bVar == null) {
                    com.opos.cmn.an.f.a.c("ExoVideoPlayer", "callback but playerView null");
                    return;
                }
                View viewB = bVar.b();
                if (viewB != null && (viewB instanceof TextureView) && (i3 == 90 || i3 == 270)) {
                    f2 = 1.0f / f2;
                }
                a.this.e.a(f2);
            }
        });
    }

    private void m() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "playVideo mCurrentState=" + this.j);
        try {
            h hVar = this.h;
            if (hVar != null) {
                this.j = 1;
                this.b.a(hVar);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "prepareVideo", e);
        }
    }

    private void n() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "hideCover()");
        this.d.setVisibility(8);
    }

    private void o() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCover()");
        this.d.setVisibility(0);
        this.d.setImageBitmap(null);
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.opos.exoplayer.ui.b bVar = this.f;
            if (bVar == null) {
                return;
            }
            View viewB = bVar.b();
            if (viewB != null) {
                if (viewB instanceof TextureView) {
                    a((TextureView) viewB);
                } else if (viewB instanceof SurfaceView) {
                    a((SurfaceView) viewB);
                }
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCover() end cost=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("ExoVideoPlayer", "showCover() fail", th);
        }
    }

    private void p() {
        try {
            v vVar = this.b;
            if (vVar != null) {
                vVar.f();
            }
            b(true);
            this.f.a(this.b);
            l();
            this.j = 0;
            a(0L);
            m();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "resetPlayerWithoutAudio", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public Bitmap b(String str) {
        com.opos.exoplayer.ui.b bVar = this.f;
        if (bVar == null) {
            return null;
        }
        return com.opos.mobad.mediaplayer.a.b.a(bVar.b(), str);
    }

    @Override // com.opos.mobad.d.d.a
    public long c() {
        long jL = 0;
        try {
            jL = this.b.l();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getDuration=" + jL);
            return jL;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "getDuration", e);
            return jL;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public long d() {
        long jM = 0;
        try {
            jM = this.b.m();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getCurrentPosition=" + jM);
            return jM;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "getCurrentPosition", e);
            return jM;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void e() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "start mCurrentState=" + this.j);
        try {
            v vVar = this.b;
            if (vVar != null) {
                vVar.a(true);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "start", e);
        }
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void e_() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onSeekProcessed");
    }

    @Override // com.opos.mobad.d.d.a
    public void f() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "pauseVideo mCurrentState=" + this.j);
        try {
            int i = this.j;
            if (1 == i || 2 == i || 4 == i) {
                o();
                this.b.a(false);
                this.k = d();
                if (2 == this.j) {
                    this.j = 3;
                }
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).g();
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPause");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "pause", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void g() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "resume mCurrentState=" + this.j);
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "mCurrentState=" + this.j);
            int i = this.j;
            if (1 == i || 3 == i || 4 == i) {
                n();
                a(this.k);
                this.b.a(true);
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", az.ag);
                if (3 == this.j) {
                    this.j = 2;
                }
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).f();
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onResume");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", az.ag, e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void h() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "releaseExoVideoPlayer mCurrentState=" + this.j);
        try {
            v vVar = this.b;
            if (vVar != null) {
                vVar.f();
            }
            com.opos.exoplayer.ui.b bVar = this.f;
            if (bVar != null) {
                bVar.removeOnAttachStateChangeListener(this.m);
                this.f = null;
            }
            this.c = null;
            if (this.h != null) {
                this.h = null;
            }
            if (this.g != null) {
                this.g = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "release", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public int i() {
        return this.j;
    }

    @Override // com.opos.mobad.d.d.a
    public void a(float f) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setVolume =" + f);
        this.b.a(f);
    }

    @Override // com.opos.mobad.d.d.a
    public View b() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRepeatModeChanged repeatMode=" + i);
    }

    @Override // com.opos.mobad.d.d.a
    public void c(int i) {
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setResizeMode=" + i);
            AspectRatioFrameLayout aspectRatioFrameLayout = this.e;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.a(i);
            }
            com.opos.exoplayer.ui.b bVar = this.f;
            if (bVar != null) {
                bVar.b(i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "setResizeMode", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void d(int i) {
        com.opos.exoplayer.ui.b bVar = this.f;
        if (bVar != null) {
            bVar.c(i);
        }
    }

    private void c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("initMediaSource path=");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource path is null!!!");
            } else {
                this.h = new e.a(this.g).a(Uri.parse(str));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "seekTo position=" + j);
        if (j >= 0) {
            try {
                this.b.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "seekTo", e);
            }
        }
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void b(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPositionDiscontinuity reason=" + i);
    }

    private void a(SurfaceView surfaceView) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCoverWithSurfaceView()");
        if (surfaceView != null && Build.VERSION.SDK_INT >= 25) {
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
            PixelCopy.request(surfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.mediaplayer.c.a.2
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public void onPixelCopyFinished(int i) {
                    a.this.d.setImageBitmap(bitmapCreateBitmap);
                }
            }, surfaceView.getHandler());
        }
    }

    public void b(com.opos.mobad.d.d.b bVar) {
        if (bVar != null) {
            this.i.add(bVar);
        }
    }

    private void a(TextureView textureView) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCoverWithTextureView()");
        if (textureView == null) {
            return;
        }
        this.d.setImageBitmap(textureView.getBitmap());
    }

    private void b(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayer unsupportedAudio=" + z);
        try {
            d.a(z);
            com.opos.exoplayer.core.c.c cVar = new com.opos.exoplayer.core.c.c(new a.C0682a(new j()));
            this.b = z ? com.opos.exoplayer.core.h.a(new p(this.f9008a), cVar) : com.opos.exoplayer.core.h.a(this.f9008a, cVar);
            this.b.a(this);
            this.b.a(this.l);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initPlayer", e);
        }
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(ExoPlaybackException exoPlaybackException) {
        Object[] objArr = new Object[3];
        objArr[0] = "onPlayerError error=";
        String message = com.igexin.push.core.b.m;
        objArr[1] = exoPlaybackException != null ? exoPlaybackException.toString() : com.igexin.push.core.b.m;
        objArr[2] = exoPlaybackException;
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", objArr);
        int i = -1;
        try {
            this.j = -1;
            if (exoPlaybackException != null && exoPlaybackException.f8082a == 3) {
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerError TYPE_AUDIO_RENDERER");
                p();
                return;
            }
            String string = "unknown error.";
            if (exoPlaybackException != null) {
                i = exoPlaybackException.f8082a;
                StringBuilder sb = new StringBuilder();
                sb.append("cause: ");
                sb.append(exoPlaybackException.getCause() != null ? exoPlaybackException.getCause() : com.igexin.push.core.b.m);
                sb.append(", message: ");
                if (exoPlaybackException.getMessage() != null) {
                    message = exoPlaybackException.getMessage();
                }
                sb.append(message);
                sb.append(", exceptionTag: ");
                sb.append(exoPlaybackException.a());
                string = sb.toString();
            }
            HashMap map = new HashMap();
            map.put("errCode", String.valueOf(i));
            map.put(WifiNestConst.OtherConst.KEY_MSG, string);
            map.put("playerType", "2");
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                this.i.get(i2).a(map);
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onError");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ExoVideoPlayer", "onPlayerError", e);
        }
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(n nVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onPlaybackParametersChanged playbackParameters=");
        sb.append(nVar != null ? nVar.toString() : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(com.opos.exoplayer.core.source.p pVar, com.opos.exoplayer.core.c.g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTracksChanged trackGroups=");
        String string = com.igexin.push.core.b.m;
        sb.append(pVar != null ? pVar.toString() : com.igexin.push.core.b.m);
        sb.append(",trackSelections=");
        if (gVar != null) {
            string = gVar.toString();
        }
        sb.append(string);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(w wVar, Object obj, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onTimelineChanged timeline=");
        String string = com.igexin.push.core.b.m;
        sb.append(wVar != null ? wVar.toString() : com.igexin.push.core.b.m);
        sb.append(",manifest=");
        if (obj != null) {
            string = obj.toString();
        }
        sb.append(string);
        sb.append(",reason=");
        sb.append(i);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
    }

    @Override // com.opos.mobad.d.d.a
    public void a(com.opos.mobad.d.d.b bVar) {
        b(bVar);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVideoPath path=");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        try {
            c(str);
            m();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "setVideoPath", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str, boolean z) {
        v vVar;
        int i;
        if (z) {
            vVar = this.b;
            i = 2;
        } else {
            vVar = this.b;
            i = 0;
        }
        vVar.a(i);
        a(str);
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onLoadingChanged=" + z);
    }

    @Override // com.opos.exoplayer.core.Player.b
    public void a(boolean z, int i) {
        String str;
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerStateChanged playWhenReady=" + z + ",playbackState=" + i);
        StringBuilder sb = new StringBuilder();
        sb.append("mCurrentState=");
        sb.append(this.j);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", sb.toString());
        int i2 = 0;
        try {
            if (i == 2) {
                if (z && 2 == this.j) {
                    this.k = d();
                    while (i2 < this.i.size()) {
                        this.i.get(i2).h();
                        i2++;
                    }
                    com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onBufferingStart");
                    this.j = 4;
                    return;
                }
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.j = 5;
                o();
                while (i2 < this.i.size()) {
                    this.i.get(i2).e();
                    i2++;
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onComplete");
                return;
            }
            if (z) {
                n();
                int i3 = this.j;
                if (1 != i3 && 5 != i3) {
                    if (4 == i3) {
                        while (i2 < this.i.size()) {
                            this.i.get(i2).i();
                            i2++;
                        }
                        str = "onBufferingEnd";
                    }
                    this.j = 2;
                }
                while (i2 < this.i.size()) {
                    this.i.get(i2).c();
                    this.i.get(i2).d();
                    i2++;
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPrepare");
                str = "onStart";
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", str);
                this.j = 2;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "onPlayerStateChanged", e);
        }
    }
}
