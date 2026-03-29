package com.opos.mobad.mediaplayer.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.TBLPlayerManager;
import com.opos.exoplayer.ui.AspectRatioFrameLayout;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c implements IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPlayerEventListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnVideoSizeChangedListener, com.opos.mobad.d.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9034a;
    private IMediaPlayer c;
    private RelativeLayout f;
    private View g;
    private AspectRatioFrameLayout h;
    private ImageView i;
    private TextureView j;
    private List<com.opos.mobad.d.d.b> b = new ArrayList();
    private long d = 0;
    private int e = 0;
    private boolean k = true;

    public c(Context context, com.opos.mobad.d.d.b bVar) {
        this.f9034a = context.getApplicationContext();
        b(bVar);
        a();
    }

    private void j() {
        try {
            IMediaPlayer iMediaPlayerCreatePlayer = TBLPlayerManager.createPlayer(this.f9034a);
            this.c = iMediaPlayerCreatePlayer;
            iMediaPlayerCreatePlayer.setOnPreparedListener(this);
            this.c.setOnInfoListener(this);
            this.c.setOnCompletionListener(this);
            this.c.setOnErrorListener(this);
            this.c.setOnPlayerEventListener(this);
            this.c.setOnVideoSizeChangedListener(this);
            com.opos.cmn.an.f.a.a("TblVideoPlayer", "initPlayer");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "initPlayer", e);
        }
    }

    private void k() {
        this.f = new RelativeLayout(this.f9034a);
        View view = new View(this.f9034a);
        this.g = view;
        view.setBackgroundColor(-16777216);
        this.f.addView(this.g, new ViewGroup.LayoutParams(-1, -1));
        this.h = new AspectRatioFrameLayout(this.f9034a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f.addView(this.h, layoutParams);
        this.h.setId(View.generateViewId());
        this.i = new ImageView(this.f9034a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, this.h.getId());
        layoutParams2.addRule(8, this.h.getId());
        layoutParams2.addRule(7, this.h.getId());
        layoutParams2.addRule(5, this.h.getId());
        this.f.addView(this.i, layoutParams2);
        this.i.setVisibility(8);
        TextureView textureView = new TextureView(this.f9034a);
        this.j = textureView;
        this.h.addView(textureView, new ViewGroup.LayoutParams(-1, -1));
        this.c.setVideoTextureView(this.j);
    }

    private void l() {
        this.i.setVisibility(0);
        this.i.setImageBitmap(null);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "show cover");
            TextureView textureView = this.j;
            if (textureView != null) {
                this.i.setImageBitmap(textureView.getBitmap());
            }
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "show cover end:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "show cover fail");
        }
    }

    private void m() {
        this.i.setVisibility(8);
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "hideCover()");
    }

    private void n() {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "autoPlayIfNeed: " + this.k);
        if (this.k) {
            e();
        }
    }

    @Override // com.opos.mobad.d.d.a
    public Bitmap b(String str) {
        return com.opos.mobad.mediaplayer.a.b.a(this.j, str);
    }

    @Override // com.opos.mobad.d.d.a
    public long c() {
        long duration = 0;
        try {
            duration = this.c.getDuration();
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "getDuration = " + duration);
            return duration;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "getDuration", e);
            return duration;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public long d() {
        long currentPosition = 0;
        try {
            currentPosition = this.c.getCurrentPosition();
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "getCurrentPosition = " + currentPosition);
            return currentPosition;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "getCurrentPosition", e);
            return currentPosition;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void e() {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "start mCurrentState = " + this.e);
        try {
            int i = this.e;
            m();
            IMediaPlayer iMediaPlayer = this.c;
            if (iMediaPlayer != null) {
                iMediaPlayer.start();
            }
            if (1 == i) {
                a(2, (Map<String, String>) null);
                com.opos.cmn.an.f.a.b("TblVideoPlayer", "onStart");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "start", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void f() {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "pauseVideo mCurrentState = " + this.e);
        try {
            int i = this.e;
            if (1 == i || 2 == i || 4 == i) {
                l();
                this.c.pause();
                this.d = d();
                a(6, (Map<String, String>) null);
                com.opos.cmn.an.f.a.b("TblVideoPlayer", "onPause");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "pause", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void g() {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "resume mCurrentState = " + this.e);
        try {
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "mCurrentState = " + this.e);
            int i = this.e;
            if (1 == i) {
                e();
                a(5, (Map<String, String>) null);
            } else {
                if (3 != i && 4 != i) {
                    return;
                }
                m();
                a(this.d);
                this.c.start();
                com.opos.cmn.an.f.a.b("TblVideoPlayer", az.ag);
                a(5, (Map<String, String>) null);
            }
            com.opos.cmn.an.f.a.b("TblVideoPlayer", "onResume");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", az.ag, e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void h() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.mediaplayer.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("TblVideoPlayer", "releaseTblVideoPlayer mCurrentState = " + c.this.e);
                try {
                    if (c.this.c != null) {
                        c.this.c.setVideoTextureView(null);
                        c.this.c.release();
                    }
                    c.this.f = null;
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("TblVideoPlayer", "release", e);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.a
    public int i() {
        return this.e;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnCompletionListener
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        a(3, (Map<String, String>) null);
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onComplete");
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onDownstreamSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f) {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onDownstreamSizeChanged: ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2, String str) {
        com.opos.cmn.an.f.a.a("TblVideoPlayer", "onError, errorType = " + i + ", errorCode = " + i2 + ", extra = " + str);
        HashMap map = new HashMap();
        map.put("errCode", String.valueOf(i));
        map.put("errType", String.valueOf(i2));
        map.put(WifiNestConst.OtherConst.KEY_MSG, str);
        map.put("playerType", "3");
        a(4, map);
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onError");
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, Object... objArr) {
        String str;
        if (i == 20003) {
            a(9, (Map<String, String>) null);
            str = "onRenderFirstFrame";
        } else if (i == 701) {
            a(7, (Map<String, String>) null);
            str = "onBufferingStart";
        } else {
            if (i != 702) {
                return false;
            }
            a(8, (Map<String, String>) null);
            str = "onBufferingEnd";
        }
        com.opos.cmn.an.f.a.b("TblVideoPlayer", str);
        return false;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onIsPlayingChanged(IMediaPlayer iMediaPlayer, boolean z) {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onIsPlayingChanged：" + z);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener
    public void onPlayerStateChanged(IMediaPlayer iMediaPlayer, int i) {
        int i2;
        int i3 = this.e;
        if (i == 0) {
            i2 = -1;
        } else {
            if (i != 1) {
                if (i == 4) {
                    this.e = 4;
                } else if (i == 8) {
                    this.e = 1;
                } else if (i == 16) {
                    i2 = 2;
                } else if (i == 32) {
                    i2 = 3;
                } else if (i == 128) {
                    i2 = 5;
                }
                com.opos.cmn.an.f.a.b("TblVideoPlayer", "onPlayerStateChanged： oldCurrentState = " + a(i3) + ", mCurrentState = " + a(this.e));
            }
            i2 = 0;
        }
        this.e = i2;
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onPlayerStateChanged： oldCurrentState = " + a(i3) + ", mCurrentState = " + a(this.e));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "onPrepare");
        a(iMediaPlayer.getVideoWidth(), iMediaPlayer.getVideoHeight());
        a(1, (Map<String, String>) null);
        n();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, float f) {
        a(i, i2);
    }

    @Override // com.opos.mobad.d.d.a
    public View b() {
        return this.f;
    }

    @Override // com.opos.mobad.d.d.a
    public void c(int i) {
        this.h.a(i);
    }

    @Override // com.opos.mobad.d.d.a
    public void d(int i) {
        this.g.setBackgroundColor(i);
    }

    public static String a(int i) {
        switch (i) {
            case -1:
                return "ERROR";
            case 0:
                return "IDLE";
            case 1:
                return "PREPARED";
            case 2:
                return "PLAYING";
            case 3:
                return "PAUSED";
            case 4:
                return "BUFFERING";
            case 5:
                return "COMPLETED";
            default:
                return Integer.toString(i);
        }
    }

    private void a() {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "init");
        try {
            j();
            k();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "init", e);
        }
    }

    public void b(com.opos.mobad.d.d.b bVar) {
        if (bVar != null) {
            this.b.add(bVar);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(float f) {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "setVolume = " + f);
        try {
            this.c.setVolume(f);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "getVolume", e);
        }
    }

    private void a(int i, int i2) {
        this.h.a(i / i2);
    }

    private void a(int i, Map<String, String> map) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            try {
                switch (i) {
                    case 1:
                        this.b.get(i2).c();
                        break;
                    case 2:
                        this.b.get(i2).d();
                        break;
                    case 3:
                        this.b.get(i2).e();
                        break;
                    case 4:
                        this.b.get(i2).a(map);
                        break;
                    case 5:
                        this.b.get(i2).f();
                        break;
                    case 6:
                        this.b.get(i2).g();
                        break;
                    case 7:
                        this.b.get(i2).h();
                        break;
                    case 8:
                        this.b.get(i2).i();
                        break;
                    case 9:
                        this.b.get(i2).j();
                        break;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("TblVideoPlayer", "dispatchListenerEvent", e);
                return;
            }
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("TblVideoPlayer", "seekTo position = " + j);
        if (j >= 0) {
            try {
                this.c.seekTo(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("TblVideoPlayer", "seekTo", e);
            }
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(com.opos.mobad.d.d.b bVar) {
        b(bVar);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVideoPath path = ");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("TblVideoPlayer", sb.toString());
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return;
            }
            this.c.setDataSource(Uri.parse(str));
            this.c.prepareAsync();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TblVideoPlayer", "setVideoPath error", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str, boolean z) {
        if (z) {
            this.c.setLooping(true);
        }
        a(str);
    }
}
