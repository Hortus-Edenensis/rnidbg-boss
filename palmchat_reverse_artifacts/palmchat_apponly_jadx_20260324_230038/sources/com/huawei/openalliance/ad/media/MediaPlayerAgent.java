package com.huawei.openalliance.ad.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.ce;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.media.listener.f;
import com.huawei.openalliance.ad.media.listener.g;
import com.huawei.openalliance.ad.media.listener.h;
import com.huawei.openalliance.ad.utils.bb;
import com.huawei.openalliance.ad.utils.be;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.w;
import defpackage.ak;
import defpackage.tj;
import defpackage.uk3;
import defpackage.wj;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public class MediaPlayerAgent {
    private static final int B = 20;
    private static final int C = 805;
    private static final int F = 2;
    private static final String I = "MediaPlayerAgent";
    private static final int L = 100;
    private static final int S = 300;
    private static final int Z = -10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f6952a = 0;
    private static final String b = "progress_task";
    private static final int c = 100;
    private static final int d = 200;
    private static final int e = 0;
    private Object A;
    private MediaPlayer D;
    private WeakReference<Surface> E;
    private int G;
    private e J;
    private Context K;
    private volatile String h;
    private boolean i;
    private int n;
    private int o;
    private AudioManager u;
    private static final String Code = "thread_media_player_ctrl";
    private static final w V = new w(Code);
    private int f = 0;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m = 0;
    private final b p = new b();
    private final byte[] q = new byte[0];
    private final byte[] r = new byte[0];
    private final byte[] s = new byte[0];
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private boolean y = false;
    private volatile int z = 0;
    private boolean H = false;
    private final CopyOnWriteArraySet<MediaStateListener> M = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.b> N = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.c> O = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<f> P = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.d> Q = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<MediaPlayer.OnVideoSizeChangedListener> R = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<g> T = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.e> U = new CopyOnWriteArraySet<>();
    private final MediaPlayer.OnVideoSizeChangedListener W = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MediaPlayerAgent.this.Code(mediaPlayer, i, i2);
        }
    };
    private MediaPlayer.OnCompletionListener X = new MediaPlayer.OnCompletionListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.12
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MediaPlayerAgent.this.p.Code(d.ERROR)) {
                return;
            }
            b bVar = MediaPlayerAgent.this.p;
            d dVar = d.PLAYBACK_COMPLETED;
            if (bVar.Code(dVar)) {
                return;
            }
            MediaPlayerAgent.this.p.I(dVar);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int iL = MediaPlayerAgent.this.l();
            fh.V(MediaPlayerAgent.I, "onCompletion " + currentPosition + " duration: " + iL);
            int iMax = Math.max(currentPosition, iL);
            MediaPlayerAgent.this.V(100, iMax);
            MediaPlayerAgent.this.B(iMax);
            MediaPlayerAgent.this.u();
            MediaPlayerAgent.F(MediaPlayerAgent.this.g);
            MediaPlayerAgent.this.m = 0;
            MediaPlayerAgent.this.t = 0;
        }
    };
    private MediaPlayer.OnInfoListener Y = new MediaPlayer.OnInfoListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.23
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            fh.V(MediaPlayerAgent.I, "onInfo what: %d extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i != 3) {
                if (i == 805) {
                    MediaPlayerAgent.this.a(i2);
                } else if (i == 701) {
                    MediaPlayerAgent.this.r();
                } else if (i == 702) {
                }
                return true;
            }
            MediaPlayerAgent.this.s();
            MediaPlayerAgent.this.u();
            return true;
        }
    };
    private MediaPlayer.OnPreparedListener aa = new MediaPlayer.OnPreparedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.34
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            fh.V(MediaPlayerAgent.I, "onPrepared");
            MediaPlayerAgent.this.k = false;
            mediaPlayer.setOnInfoListener(MediaPlayerAgent.this.Y);
            if (MediaPlayerAgent.this.l || MediaPlayerAgent.this.p.V(d.PREPARING)) {
                MediaPlayerAgent.this.p.I(d.PREPARED);
                MediaPlayerAgent mediaPlayerAgent = MediaPlayerAgent.this;
                mediaPlayerAgent.L(mediaPlayerAgent.l());
                return;
            }
            try {
                MediaPlayerAgent.this.p.I(d.PREPARED);
                mediaPlayer.start();
                MediaPlayerAgent.V(mediaPlayer, MediaPlayerAgent.this.o, 3);
                MediaPlayerAgent.this.p.I(d.PLAYING);
                if (fh.Code()) {
                    fh.Code(MediaPlayerAgent.I, "seek to prefer pos: %d", Integer.valueOf(MediaPlayerAgent.this.o));
                }
                MediaPlayerAgent.this.S(mediaPlayer.getCurrentPosition());
                MediaPlayerAgent mediaPlayerAgent2 = MediaPlayerAgent.this;
                mediaPlayerAgent2.L(mediaPlayerAgent2.l());
                MediaPlayerAgent.this.x();
            } catch (IllegalStateException unused) {
                fh.I(MediaPlayerAgent.I, "onPrepared - IllegalStateException");
                MediaPlayerAgent.this.p.I(d.ERROR);
                MediaPlayerAgent.this.Code(0, -1, -1);
            }
        }
    };
    private MediaPlayer.OnErrorListener ab = new MediaPlayer.OnErrorListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.38
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            fh.I(MediaPlayerAgent.I, "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i), Integer.valueOf(i2), MediaPlayerAgent.this.p, MediaPlayerAgent.this);
            MediaPlayerAgent.this.u();
            b bVar = MediaPlayerAgent.this.p;
            d dVar = d.ERROR;
            if (bVar.Code(dVar)) {
                return true;
            }
            MediaPlayerAgent.this.p.I(dVar);
            MediaPlayerAgent.this.Code(mediaPlayer.getCurrentPosition(), i, i2);
            return true;
        }
    };
    private MediaPlayer.OnBufferingUpdateListener ac = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.39
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (MediaPlayerAgent.this.p.Code()) {
                if (i < 0) {
                    i = 0;
                }
                if (i > 100) {
                    i = 100;
                }
                MediaPlayerAgent.this.C(i);
            }
        }
    };
    private Callable<Boolean> ad = new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.7
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(MediaPlayerAgent.this.n());
        }
    };
    private Runnable ae = new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.30
        @Override // java.lang.Runnable
        public void run() {
            int iL;
            MediaPlayerAgent.F(MediaPlayerAgent.this.g);
            if (MediaPlayerAgent.this.p.V(d.PREPARING) && MediaPlayerAgent.this.p.V(d.PLAYING) && MediaPlayerAgent.this.p.V(d.PREPARED)) {
                return;
            }
            int iB = MediaPlayerAgent.this.B();
            if (MediaPlayerAgent.this.M.size() > 0 && (iL = MediaPlayerAgent.this.l()) > 0) {
                int iCeil = (int) Math.ceil((iB * 100.0f) / iL);
                if (iCeil > 100) {
                    iCeil = 100;
                }
                MediaPlayerAgent.this.V(iCeil, iB);
                if (iB >= iL) {
                    MediaPlayerAgent.p(MediaPlayerAgent.this);
                    if (MediaPlayerAgent.this.t > 2) {
                        fh.V(MediaPlayerAgent.I, "reach end count exceeds");
                        MediaPlayerAgent.this.X.onCompletion(MediaPlayerAgent.this.f());
                        return;
                    }
                }
            }
            if (MediaPlayerAgent.this.i && MediaPlayerAgent.this.N.size() > 0 && MediaPlayerAgent.this.t == 0) {
                if (Math.abs(iB - MediaPlayerAgent.this.m) < 100) {
                    MediaPlayerAgent.this.r();
                } else {
                    MediaPlayerAgent.this.u();
                    MediaPlayerAgent.this.m = iB;
                }
            }
            MediaPlayerAgent.V(MediaPlayerAgent.this.ae, MediaPlayerAgent.this.g, 200L);
        }
    };
    private AudioManager.OnAudioFocusChangeListener af = new AudioManager.OnAudioFocusChangeListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.36
        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            if (MediaPlayerAgent.this.H) {
                fh.V(MediaPlayerAgent.I, "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.H);
                V();
                return;
            }
            boolean zN = MediaPlayerAgent.this.n();
            fh.V(MediaPlayerAgent.I, "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(zN));
            if (zN) {
                MediaPlayerAgent.this.Z();
                MediaPlayerAgent.this.v = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            fh.V(MediaPlayerAgent.I, "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.H);
            if (MediaPlayerAgent.this.H) {
                if (MediaPlayerAgent.this.w) {
                    MediaPlayerAgent.this.q();
                }
            } else {
                if (MediaPlayerAgent.this.x == -2 || MediaPlayerAgent.this.x == -1) {
                    if (MediaPlayerAgent.this.v) {
                        MediaPlayerAgent.this.g();
                        MediaPlayerAgent.this.v = false;
                        return;
                    }
                    return;
                }
                if (MediaPlayerAgent.this.x == -3 && MediaPlayerAgent.this.w) {
                    MediaPlayerAgent.this.q();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V() {
            fh.V(MediaPlayerAgent.I, "handleAudioFocusLossTransientCanDuck soundMuted: " + MediaPlayerAgent.this.y);
            if (MediaPlayerAgent.this.y) {
                return;
            }
            MediaPlayerAgent.this.p();
            MediaPlayerAgent.this.w = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            MediaPlayerAgent.V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.36.1
                @Override // java.lang.Runnable
                public void run() {
                    fh.V(MediaPlayerAgent.I, "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.x));
                    int i2 = i;
                    if (i2 == -3) {
                        V();
                    } else if (i2 == -2 || i2 == -1) {
                        Code();
                    } else if (i2 == 1 || i2 == 2) {
                        I();
                    }
                    MediaPlayerAgent.this.x = i;
                }
            });
        }
    };
    private String g = b + hashCode();

    @com.huawei.openalliance.ad.annotations.b
    public MediaPlayerAgent(Context context) {
        this.K = context.getApplicationContext();
        this.u = (AudioManager) context.getSystemService("audio");
        V.Code();
    }

    private void A() {
        String str;
        if (!G()) {
            fh.I(I, "audio focus is not needed");
            return;
        }
        try {
            fh.V(I, "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.u.requestAudioFocus(this.af, 3, 2);
            } else {
                tj.a();
                AudioFocusRequest audioFocusRequestBuild = ak.a(2).setOnAudioFocusChangeListener(this.af).build();
                this.A = audioFocusRequestBuild;
                this.u.requestAudioFocus(audioFocusRequestBuild);
            }
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            fh.I(I, str);
        } catch (Exception e2) {
            str = "requestAudioFocus " + e2.getClass().getSimpleName();
            fh.I(I, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void E() {
        String str;
        try {
            try {
                fh.V(I, "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.u.abandonAudioFocus(this.af);
                } else {
                    if (uk3.a(this.A)) {
                        this.u.abandonAudioFocusRequest(wj.a(this.A));
                    }
                    this.A = null;
                }
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                fh.I(I, str);
            } catch (Exception e2) {
                str = "abandonAudioFocus " + e2.getClass().getSimpleName();
                fh.I(I, str);
            }
        } finally {
            this.w = false;
            this.v = false;
            this.x = 0;
        }
    }

    private boolean G() {
        fh.V(I, "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.z), Boolean.valueOf(this.y));
        if (this.z == 0) {
            return true;
        }
        if (this.z == 2) {
            return false;
        }
        return (this.z == 1 && this.y) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer f() {
        MediaPlayer mediaPlayer;
        synchronized (this.q) {
            if (this.D == null) {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                mediaPlayer2.setOnCompletionListener(this.X);
                mediaPlayer2.setOnPreparedListener(this.aa);
                mediaPlayer2.setOnErrorListener(this.ab);
                mediaPlayer2.setOnBufferingUpdateListener(this.ac);
                mediaPlayer2.setOnVideoSizeChangedListener(this.W);
                mediaPlayer2.setLooping(false);
                mediaPlayer2.setAudioStreamType(3);
                this.D = mediaPlayer2;
            }
            mediaPlayer = this.D;
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.p.Code(d.END)) {
            fh.V(I, "play - current state: %s - agent: %s", this.p, this);
            return;
        }
        fh.Code(I, "play file: %s", bl.Code(this.h));
        this.l = false;
        if (!this.p.Code(d.ERROR) && !this.p.Code(d.IDLE)) {
            b bVar = this.p;
            d dVar = d.PLAYING;
            if (!bVar.Code(dVar)) {
                MediaPlayer mediaPlayerF = f();
                fh.V(I, "play - state before play: %s - agent: %s", this.p, this);
                if (this.k || !(this.p.Code(d.PAUSED) || this.p.Code(d.PLAYBACK_COMPLETED) || this.p.Code(d.PREPARED))) {
                    try {
                        C(this.h);
                        if (this.p.Code(d.INITIALIZED)) {
                            V(true);
                        }
                    } catch (du e2) {
                        fh.Code(I, "set media file error:%s", e2.getMessage());
                        fh.I(I, "set media file error:" + e2.getClass().getSimpleName());
                        this.p.I(d.ERROR);
                        Code(0, -1, -1);
                    }
                } else {
                    try {
                        mediaPlayerF.start();
                        if (this.p.Code(d.PREPARED)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                mediaPlayerF.seekTo(this.o, 3);
                            } else {
                                mediaPlayerF.seekTo(this.o);
                            }
                        }
                        int currentPosition = this.p.Code(d.PLAYBACK_COMPLETED) ? 0 : mediaPlayerF.getCurrentPosition();
                        this.p.I(dVar);
                        S(currentPosition);
                        x();
                    } catch (IllegalStateException unused) {
                        fh.I(I, "play - start IllegalStateException");
                        this.p.I(d.ERROR);
                        Code(mediaPlayerF.getCurrentPosition(), -100, 0);
                        u();
                    }
                }
                fh.V(I, "play - current state: %s", this.p);
                return;
            }
        }
        fh.V(I, "play - current state: %s - agent: %s", this.p, this);
        if (this.p.Code(d.PLAYING)) {
            S(f().getCurrentPosition());
            x();
            return;
        }
        try {
            C(this.h);
            fh.V(I, "play - current state after set file: %s", this.p);
            if (this.p.Code(d.INITIALIZED)) {
                V(true);
            }
        } catch (du e3) {
            fh.Code(I, "set media file error:%s", e3.getMessage());
            fh.I(I, "set media file error:" + e3.getClass().getSimpleName());
            this.p.I(d.ERROR);
            Code(0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        fh.V(I, "prepareInternal - current state: %s - agent: %s", this.p, this);
        if (this.p.Code(d.END)) {
            return;
        }
        fh.V(I, "prepareInternal - current state after set file: %s", this.p);
        if (this.p.Code(d.INITIALIZED)) {
            this.l = true;
            V(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        MediaPlayer mediaPlayer;
        int duration;
        if (this.p.Code(d.END)) {
            return 0;
        }
        int iM = m();
        if (!this.p.Code() || this.k) {
            return iM;
        }
        try {
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            return (mediaPlayer == null || (duration = mediaPlayer.getDuration()) <= 0) ? iM : duration;
        } catch (IllegalStateException unused) {
            fh.I(I, "getDuration IllegalStateException");
            return iM;
        }
    }

    private int m() {
        int i;
        synchronized (this.r) {
            i = this.n;
        }
        return i;
    }

    private Surface o() {
        WeakReference<Surface> weakReference = this.E;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static /* synthetic */ int p(MediaPlayerAgent mediaPlayerAgent) {
        int i = mediaPlayerAgent.t;
        mediaPlayerAgent.t = i + 1;
        return i;
    }

    private void t() {
        CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.e> copyOnWriteArraySet = this.U;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        fh.V(I, "notify player release");
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.19
            @Override // java.lang.Runnable
            public void run() {
                for (com.huawei.openalliance.ad.media.listener.e eVar : MediaPlayerAgent.this.U) {
                    if (eVar != null) {
                        eVar.Code();
                    }
                }
            }
        });
    }

    private void w() {
        if (!this.y) {
            fh.V(I, "already unmuted, don't notify");
            return;
        }
        fh.V(I, "notifyUnmute");
        this.y = false;
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.27
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : MediaPlayerAgent.this.P) {
                    if (fVar != null) {
                        fVar.V();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        F(this.g);
        if (this.M.size() > 0) {
            V(this.ae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.media.MediaPlayer, android.media.MediaPlayer$OnVideoSizeChangedListener] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void y() {
        synchronized (this.q) {
            b bVar = this.p;
            d dVar = d.END;
            if (bVar.Code(dVar)) {
                return;
            }
            this.p.I(dVar);
            fh.V(I, "release - agent: %s", this);
            V.V();
            z();
            MediaPlayer mediaPlayer = this.D;
            if (mediaPlayer != null) {
                ?? r2 = 0;
                try {
                    try {
                        mediaPlayer.setSurface(null);
                        this.D.setOnVideoSizeChangedListener(null);
                        this.D.release();
                        this.D = null;
                        fh.V(I, "release media player");
                        r2 = "release media player";
                    } catch (Throwable th) {
                        this.D.setOnVideoSizeChangedListener(r2);
                        this.D.release();
                        this.D = r2;
                        fh.V(I, "release media player");
                        t();
                        throw th;
                    }
                } catch (IllegalStateException unused) {
                    fh.I(I, "media player reset surface IllegalStateException");
                    this.D.setOnVideoSizeChangedListener(null);
                    this.D.release();
                    this.D = null;
                    fh.V(I, "release media player");
                    r2 = "release media player";
                }
                t();
            }
            this.M.clear();
            this.N.clear();
            this.O.clear();
            this.P.clear();
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        MediaPlayer mediaPlayer;
        if (!this.p.Code(d.END) && !this.p.Code(d.ERROR) && !this.p.Code(d.IDLE)) {
            try {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                if (mediaPlayer != null) {
                    return mediaPlayer.getCurrentPosition();
                }
            } catch (IllegalStateException unused) {
                fh.I(I, "getCurrentPlayPosition IllegalStateException");
            }
        }
        return 0;
    }

    @com.huawei.openalliance.ad.annotations.b
    public b C() {
        return this.p;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void L() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.11
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.q();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void a() {
        synchronized (this.s) {
            int i = this.f - 1;
            this.f = i;
            if (i < 0) {
                this.f = 0;
            }
            if (fh.Code()) {
                fh.Code(I, "release - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
            }
            if (this.f == 0) {
                V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.31
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaPlayerAgent.this.y();
                    }
                });
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void c() {
        synchronized (this.s) {
            this.f++;
            if (fh.Code()) {
                fh.Code(I, "acquire - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int d() {
        int i;
        synchronized (this.s) {
            i = this.f;
        }
        return i;
    }

    public void e() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.35
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.E();
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.32
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.y();
            }
        });
    }

    public String toString() {
        return "MediaPlayerAgent@" + Integer.toHexString(hashCode()) + " [" + bl.Code(this.h) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i) {
        fh.V(I, "notifyMediaCompletion playTime: %d", Integer.valueOf(i));
        e();
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.15
            @Override // java.lang.Runnable
            public void run() {
                for (MediaStateListener mediaStateListener : MediaPlayerAgent.this.M) {
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaCompletion(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final int i) {
        if (this.i) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.16
                @Override // java.lang.Runnable
                public void run() {
                    for (com.huawei.openalliance.ad.media.listener.b bVar : MediaPlayerAgent.this.N) {
                        if (bVar != null) {
                            bVar.Code(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final int i) {
        fh.V(I, "notifyDurationReady: %d", Integer.valueOf(i));
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.28
            @Override // java.lang.Runnable
            public void run() {
                for (com.huawei.openalliance.ad.media.listener.d dVar : MediaPlayerAgent.this.Q) {
                    if (dVar != null) {
                        dVar.Code(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i) {
        fh.V(I, "notifyMediaStart playTime: %d", Integer.valueOf(i));
        A();
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.21
            @Override // java.lang.Runnable
            public void run() {
                for (MediaStateListener mediaStateListener : MediaPlayerAgent.this.M) {
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStart(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    public void a(final int i) {
        fh.V(I, "notifyVideoPictureNotPlaying");
        if (i < Z) {
            int i2 = this.G;
            if (i2 < 20) {
                this.G = i2 + 1;
                Code();
                V();
            } else {
                Code();
                this.ab.onError(f(), 805, i);
            }
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.29
            @Override // java.lang.Runnable
            public void run() {
                for (com.huawei.openalliance.ad.media.listener.d dVar : MediaPlayerAgent.this.Q) {
                    if (dVar != null) {
                        dVar.V(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.p.Code(d.END) || this.p.Code(d.ERROR) || this.p.Code(d.IDLE)) {
            return;
        }
        if (this.p.Code() || this.p.Code(d.PREPARING)) {
            try {
                MediaPlayer mediaPlayerF = f();
                int currentPosition = mediaPlayerF.getCurrentPosition();
                if (this.p.Code() && !this.k) {
                    mediaPlayerF.stop();
                }
                if (this.p.Code(d.PLAYBACK_COMPLETED)) {
                    currentPosition = 0;
                }
                F(currentPosition);
                V(0, 0);
                this.p.I(d.INITIALIZED);
            } catch (IllegalStateException unused) {
                fh.I(I, "stop IllegalStateException");
                this.p.I(d.ERROR);
            }
        }
        this.m = 0;
        this.t = 0;
        u();
        F(this.g);
        fh.V(I, "stop - agent: %s", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        fh.V(I, "pauseInternal before State: %s - agent: %s", this.p, this);
        this.v = false;
        if (k()) {
            return;
        }
        try {
            MediaPlayer mediaPlayerF = f();
            if (mediaPlayerF.isPlaying()) {
                mediaPlayerF.pause();
            }
            this.p.I(d.PAUSED);
            D(mediaPlayerF.getCurrentPosition());
        } catch (IllegalStateException unused) {
            fh.I(I, "pause IllegalStateException");
            this.p.I(d.ERROR);
        }
        u();
        F(this.g);
        fh.V(I, "pause");
    }

    private boolean k() {
        return this.p.Code(d.END) || this.p.Code(d.ERROR) || this.p.Code(d.PAUSED) || this.p.Code(d.INITIALIZED) || this.p.Code(d.IDLE) || this.p.Code(d.PLAYBACK_COMPLETED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        MediaPlayer mediaPlayer;
        if (!this.p.Code()) {
            return false;
        }
        try {
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (IllegalStateException unused) {
            fh.I(I, "isPlaying IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.w = false;
        if (I(0.0f)) {
            v();
        }
        if (this.z == 1 && n()) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.w = false;
        if (I(1.0f)) {
            w();
        }
        if (this.z == 1 && n()) {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!this.j && this.i && this.N.size() > 0) {
            if (this.p.Code(d.PLAYING) || this.p.Code(d.PREPARING)) {
                fh.V(I, "notifyBufferingStart currentState: %s", this.p);
                this.j = true;
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.17
                    @Override // java.lang.Runnable
                    public void run() {
                        for (com.huawei.openalliance.ad.media.listener.b bVar : MediaPlayerAgent.this.N) {
                            if (bVar != null) {
                                bVar.Code();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        CopyOnWriteArraySet<g> copyOnWriteArraySet = this.T;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        fh.V(I, "notifyRenderStart");
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.18
            @Override // java.lang.Runnable
            public void run() {
                for (g gVar : MediaPlayerAgent.this.T) {
                    if (gVar != null) {
                        gVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.j && this.i) {
            this.j = false;
            fh.V(I, "notifyBufferingEnd currentState: %s", this.p);
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.20
                @Override // java.lang.Runnable
                public void run() {
                    for (com.huawei.openalliance.ad.media.listener.b bVar : MediaPlayerAgent.this.N) {
                        if (bVar != null) {
                            bVar.V();
                        }
                    }
                }
            });
        }
    }

    private void v() {
        if (this.y) {
            fh.V(I, "already muted, don't notify");
            return;
        }
        fh.V(I, "notifyMute");
        this.y = true;
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.26
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : MediaPlayerAgent.this.P) {
                    if (fVar != null) {
                        fVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        synchronized (this.q) {
            fh.V(I, "resetInternal - agent: %s", this);
            try {
            } catch (IllegalStateException unused) {
                fh.I(I, "media player reset IllegalStateException");
            } catch (Throwable th) {
                fh.I(I, "media player reset exception: %s", th.getClass().getSimpleName());
            }
            if (this.D == null) {
                this.m = 0;
                this.t = 0;
                this.k = false;
                this.w = false;
                this.v = false;
                this.x = 0;
                this.G = 0;
                this.p.I(d.IDLE);
                u();
                F(this.g);
            } else {
                if (this.p.Code()) {
                    int currentPosition = this.D.getCurrentPosition();
                    this.D.stop();
                    if (this.p.Code(d.PLAYBACK_COMPLETED)) {
                        currentPosition = 0;
                    }
                    F(currentPosition);
                    V(0, 0);
                    C(0);
                }
                this.D.reset();
                this.m = 0;
                this.t = 0;
                this.k = false;
                this.w = false;
                this.v = false;
                this.x = 0;
                this.G = 0;
                this.p.I(d.IDLE);
                u();
                F(this.g);
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.2
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.i();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void D() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.10
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.p();
            }
        });
    }

    public String F() {
        return this.h;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.42
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.h();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.4
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.j();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void b() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.33
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.z();
            }
        });
    }

    private void D(final int i) {
        fh.V(I, "notifyMediaPause playTime: %d", Integer.valueOf(i));
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.24
            @Override // java.lang.Runnable
            public void run() {
                for (MediaStateListener mediaStateListener : MediaPlayerAgent.this.M) {
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaPause(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.V(i);
        }
    }

    private void F(final int i) {
        fh.V(I, "notifyMediaStop playTime: %d", Integer.valueOf(i));
        e();
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.22
            @Override // java.lang.Runnable
            public void run() {
                for (MediaStateListener mediaStateListener : MediaPlayerAgent.this.M) {
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStop(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.w = false;
        if (I(f)) {
            w();
        }
        if (this.z == 1 && n()) {
            A();
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.13
            @Override // java.lang.Runnable
            public void run() {
                fh.Code(MediaPlayerAgent.I, "setSoundVolume %f result: %s", Float.valueOf(f), Boolean.valueOf(MediaPlayerAgent.this.I(f)));
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(int i) {
        fh.Code(I, "setPreferStartPlayTime %s", Integer.valueOf(i));
        this.o = i;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.40
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str) {
        V.Code(str);
    }

    private void S(String str) throws du, IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayerF = f();
        if (Uri.parse(str).getScheme() == null) {
            mediaPlayerF.setDataSource(str);
        } else {
            ce ceVar = ce.FILE;
            if (str.startsWith(ceVar.toString())) {
                str = str.substring(ceVar.toString().length());
            } else if (str.startsWith(ce.CONTENT.toString())) {
                if (!Code(str, mediaPlayerF)) {
                    fh.I(I, "set remote media fail");
                    throw new du();
                }
            } else if (str.startsWith(ce.HTTP.toString()) || str.startsWith(ce.HTTPS.toString())) {
                this.i = true;
            }
            mediaPlayerF.setDataSource(str);
        }
        mediaPlayerF.setVideoScalingMode(1);
        this.p.I(d.INITIALIZED);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i) {
        Code(i, 0);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.R.remove(onVideoSizeChangedListener);
    }

    public void V(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.37
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.Z(f);
            }
        });
    }

    public void Z(int i) {
        this.z = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str) throws du {
        if (this.p.Code(d.END)) {
            return;
        }
        fh.Code(I, "setMediaFileUrl: %s", bl.Code(str));
        MediaPlayer mediaPlayerF = f();
        try {
            if (this.p.Code()) {
                mediaPlayerF.stop();
            }
        } catch (IllegalStateException unused) {
            fh.I(I, "setMediaFileUrl stop IllegalStateException");
        } catch (Throwable th) {
            fh.I(I, "setMediaFileUrl exception: %s", th.getClass().getSimpleName());
        }
        try {
            mediaPlayerF.reset();
            this.p.I(d.IDLE);
        } catch (Throwable th2) {
            fh.I(I, "mediaPlayer reset exception: %s", th2.getClass().getSimpleName());
        }
        this.G = 0;
        this.h = str;
        if (TextUtils.isEmpty(str)) {
            fh.I(I, "media file url is empty");
            this.p.I(d.ERROR);
            throw new du("media file url is empty");
        }
        try {
            S(str);
        } catch (Exception unused2) {
            fh.I(I, "setMediaFileUrl Exception");
            this.p.I(d.ERROR);
            throw new du("setMediaFileUrl Exception");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i, int i2) {
        MediaPlayer mediaPlayer;
        try {
            if (!this.p.Code() || this.k) {
                return;
            }
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            int iL = (l() * i) / 100;
            V(mediaPlayer, iL, i2);
            V(i, iL);
        } catch (IllegalStateException unused) {
            fh.I(I, "seekTo IllegalStateException");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        if (this.p.Code(d.END)) {
            return false;
        }
        return ((Boolean) be.Code(this.ad, 300L, Boolean.valueOf(this.p.Code(d.PLAYING)))).booleanValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(int i) {
        synchronized (this.r) {
            this.n = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i, final int i2, final int i3) {
        fh.V(I, "notifyError playTime: %d", Integer.valueOf(i));
        e();
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.25
            @Override // java.lang.Runnable
            public void run() {
                for (com.huawei.openalliance.ad.media.listener.c cVar : MediaPlayerAgent.this.O) {
                    if (cVar != null) {
                        cVar.Code(MediaPlayerAgent.this, i, i2, i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i, final int i2) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.14
            @Override // java.lang.Runnable
            public void run() {
                for (MediaStateListener mediaStateListener : MediaPlayerAgent.this.M) {
                    if (mediaStateListener != null) {
                        mediaStateListener.onProgress(i, i2);
                    }
                }
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.U.remove(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaPlayerAgent.this.C(str);
                } catch (du e2) {
                    fh.Code(MediaPlayerAgent.I, "set media file error:%s", e2.getMessage());
                    fh.I(MediaPlayerAgent.I, "set media file error:" + e2.getClass().getSimpleName());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j, int i) {
        MediaPlayer mediaPlayer;
        try {
            fh.V(I, "seekToMillis " + j);
            if (this.p.Code()) {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                V(mediaPlayer, j, i);
                long jL = l();
                if (jL > 0) {
                    V((int) ((100 * j) / jL), (int) j);
                }
            }
        } catch (IllegalStateException unused) {
            fh.I(I, "seekTo IllegalStateException");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final long j, final int i) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.6
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.V(j, i);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(g gVar) {
        if (gVar == null) {
            return;
        }
        this.T.remove(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        V(onVideoSizeChangedListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.5
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    return;
                }
                MediaPlayerAgent.this.j();
            }
        });
    }

    public void V(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.R.add(onVideoSizeChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayer mediaPlayer, int i, int i2) {
        Iterator<MediaPlayer.OnVideoSizeChangedListener> it = this.R.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(mediaPlayer, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(float f) {
        if (this.p.Code(d.END)) {
            return false;
        }
        try {
            f().setVolume(f, f);
            return true;
        } catch (IllegalStateException unused) {
            fh.I(I, "mute IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(MediaPlayer mediaPlayer, long j, int i) {
        if (mediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(j, i);
            } else {
                mediaPlayer.seekTo((int) j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        String str;
        if (this.p.Code(d.END)) {
            return;
        }
        if (surface != null && !surface.isValid()) {
            fh.I(I, "setSurfaceInternal - surface is invalid");
            return;
        }
        if (surface == o()) {
            fh.V(I, "setSurfaceInternal - pass-in surface is the same as currentSurface");
            return;
        }
        this.E = new WeakReference<>(surface);
        try {
            fh.V(I, "setSurfaceInternal");
            f().setSurface(surface);
        } catch (IllegalArgumentException unused) {
            str = "setSurface IllegalArgumentException";
            fh.I(I, str);
        } catch (IllegalStateException unused2) {
            str = "setSurface IllegalStateException";
            fh.I(I, str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final Surface surface) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.9
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.V(surface);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.M.remove(mediaStateListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.N.remove(bVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.O.remove(cVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.Q.remove(dVar);
    }

    public void V(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.U.add(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.M.add(mediaStateListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(f fVar) {
        if (fVar == null) {
            return;
        }
        this.P.remove(fVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.N.add(bVar);
    }

    public void V(g gVar) {
        if (gVar == null) {
            return;
        }
        this.T.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable) {
        V.Code(runnable);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.O.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable, String str, long j) {
        V.Code(runnable, str, j);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.Q.add(dVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.e eVar) {
        V(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    return;
                }
                MediaPlayerAgent.this.i();
            }
        });
    }

    private void V(boolean z) {
        if (this.p.Code(d.END)) {
            return;
        }
        try {
            fh.V(I, "prepareMediaPlayer");
            this.p.I(d.PREPARING);
            this.k = true;
            f().prepareAsync();
            if (z) {
                r();
            }
        } catch (IllegalStateException unused) {
            fh.I(I, "prepareMediaPlayer IllegalStateException");
            this.p.I(d.ERROR);
            Code(0, -1, -1);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(f fVar) {
        if (fVar == null) {
            return;
        }
        this.P.add(fVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(g gVar) {
        V(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(h hVar) {
        if (this.J == null) {
            this.J = new e(this.K);
        }
        this.J.Code(hVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.41
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    fh.V(MediaPlayerAgent.I, "playWhenUrlMatchs - url not match");
                } else {
                    MediaPlayerAgent.this.g();
                }
            }
        });
    }

    public void Code(boolean z) {
        this.H = z;
    }

    public boolean Code(String str, MediaPlayer mediaPlayer) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = this.K.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "*/*", null);
        if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
            bb.Code(assetFileDescriptorOpenTypedAssetFileDescriptor);
            return false;
        }
        try {
            if (assetFileDescriptorOpenTypedAssetFileDescriptor.getDeclaredLength() < 0) {
                mediaPlayer.setDataSource(assetFileDescriptorOpenTypedAssetFileDescriptor.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(assetFileDescriptorOpenTypedAssetFileDescriptor.getFileDescriptor(), assetFileDescriptorOpenTypedAssetFileDescriptor.getStartOffset(), assetFileDescriptorOpenTypedAssetFileDescriptor.getDeclaredLength());
            }
            bb.Code(assetFileDescriptorOpenTypedAssetFileDescriptor);
            return true;
        } catch (Throwable th) {
            bb.Code(assetFileDescriptorOpenTypedAssetFileDescriptor);
            throw th;
        }
    }
}
