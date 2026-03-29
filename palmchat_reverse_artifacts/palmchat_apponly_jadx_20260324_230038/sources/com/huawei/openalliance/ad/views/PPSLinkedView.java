package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ek;
import com.huawei.hms.ads.ez;
import com.huawei.hms.ads.fa;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.ft;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.gc;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hx;
import com.huawei.hms.ads.ij;
import com.huawei.hms.ads.iv;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.jp;
import com.huawei.hms.ads.jq;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.lq;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.listeners.m;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bm;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.dialog.PPSAdvertiserInfoDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSLinkedView extends RelativeLayout implements fw.a, lq {
    private static View.OnTouchListener bF = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private com.huawei.openalliance.ad.views.d A;
    private LinkedSurfaceView E;
    private TextureGlVideoView G;
    private PPSDestView H;
    protected double I;
    private List<View> J;
    private PPSSplashView K;
    private WindowManager M;
    private MediaPlayerAgent N;
    private PPSSkipButton O;
    private ImageView P;
    private boolean Q;
    private h R;
    private View T;
    private int U;
    private ViewStub W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private ValueAnimator aI;
    private boolean aJ;
    private boolean aK;
    private int aL;
    private boolean aM;
    private Integer aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ;
    private boolean aR;
    private int aS;
    private final String aT;
    private PPSSplashProView aU;
    private PPSSplashSwipeView aV;
    private PPSSplashTwistView aW;
    private jq aX;
    private jp aY;
    private int aZ;
    private View aa;
    private View ab;
    private int ac;
    private boolean ad;
    private long ae;
    private long af;
    private long ag;
    private long ah;
    private boolean ai;
    private boolean aj;
    private final String ak;
    private int al;
    private int am;
    private float an;
    private float ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private float at;
    private float au;
    private float av;
    private int[] aw;
    private boolean ax;
    private boolean ay;
    private m az;
    private MediaStateListener bA;
    private final com.huawei.openalliance.ad.media.listener.h bB;
    private com.huawei.openalliance.ad.media.listener.d bC;
    private View.OnClickListener bD;
    private View.OnTouchListener bE;
    private View.OnTouchListener bG;
    private View.OnTouchListener bH;
    private com.huawei.openalliance.ad.media.listener.c bI;
    private com.huawei.openalliance.ad.media.listener.f bJ;
    private com.huawei.openalliance.ad.media.listener.b bK;
    private View.OnClickListener bL;
    private double ba;
    private double bb;
    private double bc;
    private double bd;
    private double be;
    private double bf;
    private double bg;
    private double bh;
    private double bi;
    private float bl;
    private Integer bm;
    private Integer bn;
    private Integer bo;
    private int br;
    private int bs;
    private int bt;
    private WeakReference<Context> bu;
    private int bv;
    private PPSSplashSwipeClickView bw;
    private PPSSplashTwistClickView bx;
    private boolean by;
    private com.huawei.openalliance.ad.media.listener.g bz;
    private float e;
    private hb f;
    private MaterialClickInfo g;
    private PPSAdvertiserInfoDialog h;
    private boolean i;
    private Context j;
    private eh k;
    private PPSWLSView l;
    private PPSSplashAdSourceView m;
    private boolean n;
    private fw o;
    private k p;
    private ft q;
    private int r;
    private VideoInfo s;
    private iv t;
    private g u;
    private e v;
    private f w;
    private com.huawei.openalliance.ad.media.listener.a x;
    private com.huawei.openalliance.ad.media.listener.f y;
    private SplashLinkedVideoView z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSLinkedView> Code;
        private AdContentData V;

        public a(PPSLinkedView pPSLinkedView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSLinkedView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSLinkedView pPSLinkedView = this.Code.get();
            if (pPSLinkedView != null) {
                final int[] choiceViewLoc = pPSLinkedView.l.getChoiceViewLoc();
                final int[] choiceViewSize = pPSLinkedView.l.getChoiceViewSize();
                if (z.Code(choiceViewLoc, 2) && z.Code(choiceViewSize, 2)) {
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSLinkedView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends BroadcastReceiver {
        private WeakReference<PPSLinkedView> Code;

        public b(PPSLinkedView pPSLinkedView) {
            this.Code = new WeakReference<>(pPSLinkedView);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                PPSLinkedView pPSLinkedView = this.Code.get();
                if (pPSLinkedView == null) {
                    fh.I("PPSLinkedView", "view is null");
                    return;
                }
                VideoInfo videoInfo = pPSLinkedView.s;
                k kVar = pPSLinkedView.p;
                m mVar = pPSLinkedView.az;
                if (!fa.Code.equals(intent.getAction())) {
                    if (!fa.V.equals(intent.getAction()) || videoInfo == null) {
                        return;
                    }
                    fh.V("PPSLinkedView", "LinkedSplashAdReceiver, progress resume %s  soundSwitch %s", Integer.valueOf(videoInfo.L()), videoInfo.a());
                    if (kVar != null) {
                        kVar.Code(videoInfo);
                    }
                    if (mVar != null) {
                        mVar.V(kVar);
                    }
                    ez.Code(context).V();
                    return;
                }
                int intExtra = intent.getIntExtra(fa.Z, 0);
                String stringExtra = intent.getStringExtra(fa.B);
                fh.V("PPSLinkedView", "LinkedSplashAdReceiver playProgress " + intExtra);
                if (videoInfo != null) {
                    videoInfo.Code(stringExtra);
                    videoInfo.Code(intExtra);
                }
            } catch (Throwable th) {
                fh.I("PPSLinkedView", "LinkedSplashAdReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements jp.a {
        private c() {
        }

        @Override // com.huawei.hms.ads.jp.a
        public void Code(float f, float f2, float f3) {
            String str;
            PPSLinkedView.this.bl = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (fh.Code()) {
                fh.Code("PPSLinkedView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(PPSLinkedView.this.bt), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(PPSLinkedView.this.bl));
            }
            if (PPSLinkedView.this.M()) {
                fh.V("PPSLinkedView", "meet, diffX: %s, diffY: %s, diffZ: %s, limit: %s", Double.valueOf(PPSLinkedView.this.ba), Double.valueOf(PPSLinkedView.this.bd), Double.valueOf(PPSLinkedView.this.bg), Integer.valueOf(PPSLinkedView.this.bs));
                PPSLinkedView.this.H();
                if (PPSLinkedView.this.z != null) {
                    str = PPSLinkedView.this.z.getWidth() + "*" + PPSLinkedView.this.z.getHeight();
                } else {
                    str = null;
                }
                PPSLinkedView.this.g = new MaterialClickInfo.a().Code(Float.valueOf(PPSLinkedView.this.e)).V(str).I((Integer) 2).Code();
                PPSLinkedView.this.I(19);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements jq.a {
        private d() {
        }

        @Override // com.huawei.hms.ads.jq.a
        public void Code(double d, double d2, double d3) {
            String str;
            fh.V("PPSLinkedView", "xDegree=%s, yDegree=%s, zDegree=%s", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
            if (PPSLinkedView.this.bm == null) {
                PPSLinkedView.this.bm = Integer.valueOf((int) d);
            }
            if (PPSLinkedView.this.bn == null) {
                PPSLinkedView.this.bn = Integer.valueOf((int) d2);
            }
            if (PPSLinkedView.this.bo == null) {
                PPSLinkedView.this.bo = Integer.valueOf((int) d3);
            }
            PPSLinkedView.this.Code(d, d2, d3);
            PPSLinkedView pPSLinkedView = PPSLinkedView.this;
            pPSLinkedView.ba = pPSLinkedView.V(pPSLinkedView.bb, PPSLinkedView.this.bc);
            PPSLinkedView pPSLinkedView2 = PPSLinkedView.this;
            pPSLinkedView2.bd = pPSLinkedView2.V(pPSLinkedView2.be, PPSLinkedView.this.bf);
            PPSLinkedView pPSLinkedView3 = PPSLinkedView.this;
            pPSLinkedView3.bg = pPSLinkedView3.V(pPSLinkedView3.bh, PPSLinkedView.this.bi);
            if (fh.Code()) {
                fh.Code("PPSLinkedView", "diffDegreeX: %s diffDegreeY: %s diffDegreeZ: %s", Double.valueOf(PPSLinkedView.this.ba), Double.valueOf(PPSLinkedView.this.bd), Double.valueOf(PPSLinkedView.this.bg));
                fh.Code("PPSLinkedView", "diffLeftDegreeX: %s diffRightDegreeX: %s ", Double.valueOf(PPSLinkedView.this.bb), Double.valueOf(PPSLinkedView.this.bc));
                fh.Code("PPSLinkedView", "diffLeftDegreeY: %s diffRightDegreeY: %s ", Double.valueOf(PPSLinkedView.this.be), Double.valueOf(PPSLinkedView.this.bf));
                fh.Code("PPSLinkedView", "diffLeftDegreeZ: %s diffRightDegreeZ: %s ", Double.valueOf(PPSLinkedView.this.bh), Double.valueOf(PPSLinkedView.this.bi));
            }
            if (PPSLinkedView.this.M()) {
                fh.V("PPSLinkedView", "meet, diffX: %s, diffY: %s, diffZ: %s, limit: %s", Double.valueOf(PPSLinkedView.this.ba), Double.valueOf(PPSLinkedView.this.bd), Double.valueOf(PPSLinkedView.this.bg), Integer.valueOf(PPSLinkedView.this.bs));
                PPSLinkedView.this.H();
                if (PPSLinkedView.this.z != null) {
                    str = PPSLinkedView.this.z.getWidth() + "*" + PPSLinkedView.this.z.getHeight();
                } else {
                    str = null;
                }
                PPSLinkedView.this.g = new MaterialClickInfo.a().Code(Float.valueOf(PPSLinkedView.this.e)).V(str).I((Integer) 2).Code();
                PPSLinkedView.this.I(19);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void Code(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void Code();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void Code(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends CountDownTimer {
        final /* synthetic */ PPSLinkedView Code;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            fh.V("PPSLinkedView", "CountDownTimer onFinish");
            if (this.Code.ar == 1) {
                this.Code.Code((Integer) 8, false);
                this.Code.aL = 2;
                bj.Code(this.Code.aT);
                if (this.Code.aG) {
                    return;
                }
                this.Code.v();
                this.Code.aG = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            fh.Code("PPSLinkedView", "onTick: %s", Long.valueOf(j));
        }
    }

    public PPSLinkedView(Context context) {
        super(context);
        this.f = new gp();
        this.i = false;
        this.n = true;
        this.r = 1;
        this.Q = true;
        this.ac = 0;
        this.ad = false;
        this.ag = -1L;
        this.ai = false;
        this.aj = false;
        this.ak = x.ao + hashCode();
        this.al = 0;
        this.am = 0;
        this.as = 3500;
        this.aw = new int[2];
        this.ax = false;
        this.ay = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aJ = false;
        this.aK = false;
        this.aM = true;
        this.aO = true;
        this.aP = true;
        this.aQ = false;
        this.aR = false;
        this.aS = 0;
        this.aT = "skip_btn_delay_id_" + hashCode();
        this.by = false;
        this.bz = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aQ));
                if (PPSLinkedView.this.aQ) {
                    return;
                }
                PPSLinkedView.this.aQ = true;
                PPSLinkedView.this.y();
            }
        };
        this.bA = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.by = true;
                if (PPSLinkedView.this.ar == 2 && PPSLinkedView.this.o != null && PPSLinkedView.this.o.F()) {
                    fh.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.N.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Z(i);
                }
                if (PPSLinkedView.this.t != null) {
                    long j = i;
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.ad = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ah = i;
                PPSLinkedView.this.af = System.currentTimeMillis();
                if (!PPSLinkedView.this.ax) {
                    PPSLinkedView.this.x();
                    PPSLinkedView.this.j();
                }
                if (i > 0) {
                    PPSLinkedView.this.t.L();
                    PPSLinkedView.this.f.f();
                } else {
                    PPSLinkedView.this.t.D();
                    if (PPSLinkedView.this.f != null && PPSLinkedView.this.s != null) {
                        fh.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f.Code(PPSLinkedView.this.s.I(), true ^ "y".equals(PPSLinkedView.this.s.a()));
                    }
                }
                if (PPSLinkedView.this.p != null && PPSLinkedView.this.p.I()) {
                    db.Code(PPSLinkedView.this.j, PPSLinkedView.this.p.r(), PPSLinkedView.this.p.d(), (System.currentTimeMillis() - PPSLinkedView.this.k.T().longValue()) - ((long) PPSLinkedView.this.k.U()), PPSLinkedView.this.p.q(), "84");
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.I(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aQ) {
                    fh.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aQ = true;
                    PPSLinkedView.this.y();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.s.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i, i2);
                }
                if (PPSLinkedView.this.ad) {
                    PPSLinkedView.this.f.Code(i);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, i2, PPSLinkedView.this.s == null ? 0L : PPSLinkedView.this.s.I());
                }
            }
        };
        this.bB = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bC = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                fh.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aK && PPSLinkedView.this.w != null) {
                    PPSLinkedView.this.aK = true;
                    PPSLinkedView.this.w.Code();
                }
                if (PPSLinkedView.this.aN == null) {
                    PPSLinkedView.this.aN = Integer.valueOf(i);
                    if (PPSLinkedView.this.p == null || PPSLinkedView.this.p.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.p.C().V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.bD = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (PPSLinkedView.this.n) {
                    if (PPSLinkedView.this.ar == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.g)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.n = false;
                    fh.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.ar == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aU.getMode() ? 17 : 9;
                        PPSLinkedView.this.n();
                    }
                    PPSLinkedView.this.I(i);
                    PPSLinkedView.this.i = true;
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.n = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bE = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (bm.Code(PPSLinkedView.this.bv, PPSLinkedView.this.br, this.V - x, this.I - y)) {
                        kx.Code(view, motionEvent, 1, PPSLinkedView.this.g);
                        PPSLinkedView.this.z.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.bG = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.z.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.g = l.Code(view, motionEvent);
                if (PPSLinkedView.this.g != null) {
                    PPSLinkedView.this.g.V((Integer) 0);
                    PPSLinkedView.this.g.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bH = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                kx.Code(view, motionEvent, null, PPSLinkedView.this.g);
                return false;
            }
        };
        this.bI = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                fh.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.ax));
                PPSLinkedView.this.P();
                PPSLinkedView.this.Q();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.x != null) {
                    fh.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.x.Code(i, i2, i3);
                }
            }
        };
        this.bJ = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.Code();
                }
                PPSLinkedView.this.f.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.V();
                }
                PPSLinkedView.this.f.V(1.0f);
            }
        };
        this.bK = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.f.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.f.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.bL = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        J();
        K();
    }

    private void J() {
        fh.V("PPSLinkedView", "resetDegree");
        this.bm = null;
        this.bn = null;
        this.bo = null;
        this.ba = 0.0d;
        this.bb = 0.0d;
        this.bc = 0.0d;
        this.bd = 0.0d;
        this.be = 0.0d;
        this.bf = 0.0d;
        this.bg = 0.0d;
        this.bh = 0.0d;
        this.bi = 0.0d;
        this.bl = 0.0f;
    }

    private void K() {
        fh.Code("PPSLinkedView", "releaseSensor");
        jp jpVar = this.aY;
        if (jpVar != null) {
            jpVar.V();
        }
        jq jqVar = this.aX;
        if (jqVar != null) {
            jqVar.V();
        }
    }

    private boolean O() {
        fh.Code("PPSLinkedView", "acceptableAngle: diffDegreeX: %s, diffDegreeY: %s, diffDegreeZ: %s, limitDegree: %s", Double.valueOf(this.ba), Double.valueOf(this.bd), Double.valueOf(this.bg), Integer.valueOf(this.bs));
        double d2 = this.ba;
        double d3 = this.I;
        return d2 >= d3 || this.bd >= d3 || this.bg >= d3;
    }

    private void R() {
        k kVar = this.p;
        if (kVar != null) {
            kVar.F(false);
        }
        this.p = null;
        this.K = null;
        this.T = null;
        this.ab = null;
        LinkedSurfaceView linkedSurfaceView = this.E;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
        }
        TextureGlVideoView textureGlVideoView = this.G;
        if (textureGlVideoView != null) {
            textureGlVideoView.destroyView();
        }
        com.huawei.openalliance.ad.views.d dVar = this.A;
        if (dVar != null) {
            dVar.D();
        }
        setPlaying(false);
        W();
        bj.Code(this.aT);
        this.f.I();
        com.huawei.openalliance.ad.inter.d.Code(this.j).Code(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double V(double d2, double d3) {
        if (Math.abs(d2) < this.bs || Math.abs(d3) < this.bs) {
            return 0.0d;
        }
        return Math.abs(d2) + Math.abs(d3);
    }

    private Integer Z(AdContentData adContentData) {
        return Code(Integer.valueOf(I(adContentData)), jg.C(adContentData.v()));
    }

    private void setDestViewClickable(PPSDestView pPSDestView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pPSDestView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z) {
        this.aJ = z;
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.ar() <= 0) {
            return;
        }
        this.aS = adContentData.ar();
    }

    private void setSplashViewClickable(SplashLinkedVideoView splashLinkedVideoView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashLinkedVideoView);
        V(arrayList);
    }

    private void t() {
        fh.V("PPSLinkedView", "removeSplashView");
        SplashLinkedVideoView splashLinkedVideoView = this.z;
        if (splashLinkedVideoView != null) {
            splashLinkedVideoView.setVisibility(8);
            this.z.V();
        }
        LinkedSurfaceView linkedSurfaceView = this.E;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
            com.huawei.openalliance.ad.views.d dVar = this.A;
            if (dVar != null) {
                dVar.V(this.E);
            }
            this.E = null;
        }
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.18
            @Override // java.lang.Runnable
            public void run() {
                if (PPSLinkedView.this.z != null) {
                    if (PPSLinkedView.this.z.isAttachedToWindow()) {
                        PPSLinkedView.this.M.removeView(PPSLinkedView.this.z);
                    }
                    PPSLinkedView.this.z.I();
                    PPSLinkedView.this.z = null;
                }
            }
        }, 20L);
        PPSSplashProView pPSSplashProView = this.aU;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.aV;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        jq jqVar = this.aX;
        if (jqVar != null) {
            jqVar.V();
        }
        jp jpVar = this.aY;
        if (jpVar != null) {
            jpVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        fh.V("PPSLinkedView", "startScaleDown. ");
        w();
        if (!q()) {
            if (this.ay || this.ag == -1) {
                return;
            }
            this.t.Code(System.currentTimeMillis() - this.ag, 100);
            this.ag = -1L;
            return;
        }
        this.aH = true;
        n();
        this.z.setClickable(false);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aI = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new ek(0.4f, 0.0f, 0.2f, 1.0f));
        this.aI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.at - 1.0f)) + 1.0f;
                    float animatedFraction2 = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.av - 1.0f)) + 1.0f;
                    PPSLinkedView.this.E.Code(animatedFraction, valueAnimator.getAnimatedFraction() * PPSLinkedView.this.au, animatedFraction2, (int) (PPSLinkedView.this.ao * animatedFraction2), (int) (PPSLinkedView.this.an * animatedFraction));
                } catch (Throwable th) {
                    fh.V("PPSLinkedView", "scaleAndTransAnimation err: %s", th.getClass().getSimpleName());
                }
            }
        });
        this.aI.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LinkedSurfaceView linkedSurfaceView;
                float fFloatValue;
                float f2;
                int i;
                int i2;
                fh.V("PPSLinkedView", "onAnimationEnd");
                try {
                    if (PPSLinkedView.this.ap > 0 && PPSLinkedView.this.s != null) {
                        if (PPSLinkedView.this.s.g().floatValue() < 1.0f) {
                            linkedSurfaceView = PPSLinkedView.this.E;
                            fFloatValue = (PPSLinkedView.this.aq * 1.0f) / (PPSLinkedView.this.ap * 1.0f);
                            f2 = (PPSLinkedView.this.aq * 1.0f) / (PPSLinkedView.this.ap * 1.0f);
                            i = PPSLinkedView.this.aq;
                            i2 = PPSLinkedView.this.ap;
                        } else {
                            linkedSurfaceView = PPSLinkedView.this.E;
                            fFloatValue = PPSLinkedView.this.s.g().floatValue();
                            f2 = (PPSLinkedView.this.aq * 1.0f) / (PPSLinkedView.this.ap * 1.0f);
                            i = PPSLinkedView.this.aq;
                            i2 = PPSLinkedView.this.ap;
                        }
                        linkedSurfaceView.Code(fFloatValue, f2, i, i2);
                    }
                    PPSLinkedView.this.p();
                    PPSLinkedView.this.ar = 2;
                } catch (Throwable th) {
                    fh.V("PPSLinkedView", "onAnimationEnd err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                fh.V("PPSLinkedView", "onAnimationStart");
                if (PPSLinkedView.this.h != null) {
                    PPSLinkedView.this.h.setVisibility(8);
                }
                if (PPSLinkedView.this.P != null) {
                    PPSLinkedView.this.P.setVisibility(8);
                }
                if (PPSLinkedView.this.O != null) {
                    PPSLinkedView.this.O.setVisibility(8);
                }
                if (PPSLinkedView.this.m != null) {
                    PPSLinkedView.this.m.Code();
                    PPSLinkedView.this.m.setVisibility(8);
                }
                if (PPSLinkedView.this.l != null) {
                    PPSLinkedView.this.l.setVisibility(8);
                }
                if (PPSLinkedView.this.aa != null) {
                    PPSLinkedView.this.aa.setVisibility(8);
                }
                if (PPSLinkedView.this.aU != null) {
                    PPSLinkedView.this.aU.setVisibility(8);
                    PPSLinkedView.this.aU.Code();
                }
                if (PPSLinkedView.this.aV != null) {
                    PPSLinkedView.this.aV.setVisibility(8);
                    PPSLinkedView.this.aV.V();
                }
                if (PPSLinkedView.this.aW != null) {
                    PPSLinkedView.this.aW.setVisibility(8);
                }
                if (PPSLinkedView.this.bx != null) {
                    PPSLinkedView.this.bx.setVisibility(8);
                }
                if (PPSLinkedView.this.bw != null) {
                    PPSLinkedView.this.bw.setVisibility(8);
                }
                if (PPSLinkedView.this.z != null) {
                    PPSLinkedView.this.z.setOnTouchListener(null);
                }
                if (PPSLinkedView.this.aX != null) {
                    PPSLinkedView.this.aX.V();
                }
                if (PPSLinkedView.this.aY != null) {
                    PPSLinkedView.this.aY.V();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aI.setDuration(1000L).start();
    }

    private void w() {
        h hVar = this.R;
        if (hVar != null) {
            hVar.cancel();
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ae = jCurrentTimeMillis;
        ft ftVar = this.q;
        if (ftVar != null) {
            ftVar.Code(jCurrentTimeMillis);
        }
    }

    private void z() {
        int iA = this.k.A();
        if (iA > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aU.getLayoutParams();
            int iV = z.V(getContext(), iA);
            this.aU.setPadding(iV, iV, iV, iV);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - iV);
                layoutParams.setMarginEnd(layoutParams.rightMargin - iV);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - iV, layoutParams.topMargin, layoutParams.rightMargin - iV, layoutParams.bottomMargin);
            }
            this.aU.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iCode = kx.Code(motionEvent);
            if (iCode == 0) {
                this.g = kx.Code(this, motionEvent);
            }
            if (1 == iCode) {
                kx.Code(this, motionEvent, null, this.g);
            }
        } catch (Throwable th) {
            fh.I("PPSLinkedView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Context getActivityContext() {
        return getContext();
    }

    public AdContentData getContentRecord() {
        k kVar = this.p;
        if (kVar != null) {
            return kVar.aJ();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.lq
    public String getSplashViewSlotPosition() {
        return bg.Code((gc) this.K);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        fh.V("PPSLinkedView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(i));
        if (bg.V() && windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                List boundingRects = displayCutout.getBoundingRects();
                if (!ag.Code(boundingRects)) {
                    this.al = ((Rect) boundingRects.get(0)).height();
                }
            } else {
                fh.V("PPSLinkedView", "DisplayCutout is null");
            }
        }
        if (this.al <= 0 && i >= 26 && cn.Code(this.j).Code(getContext())) {
            this.al = Math.max(this.al, cn.Code(this.j).Code(this));
        }
        fh.V("PPSLinkedView", "notchHeight:" + this.al);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fh.Code("PPSLinkedView", "onAttachedToWindow");
        fw fwVar = this.o;
        if (fwVar != null) {
            fwVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fh.Code("PPSLinkedView", "onDetechedFromWindow");
        fw fwVar = this.o;
        if (fwVar != null) {
            fwVar.L();
        }
        bj.Code(this.aT);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fh.Code("PPSLinkedView", "onVisibilityChanged:");
        fw fwVar = this.o;
        if (fwVar != null) {
            fwVar.a();
        }
    }

    public void setLinkedAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        fh.V("PPSLinkedView", "setLinkedAdActionListener. ");
        iv ivVar = this.t;
        if (ivVar != null) {
            ivVar.Code(aVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z) {
        this.aM = z;
    }

    public void setOnLinkedAdClickListener(e eVar) {
        this.v = eVar;
    }

    public void setOnLinkedAdPreparedListener(f fVar) {
        this.w = fVar;
    }

    public void setOnLinkedAdSwitchListener(g gVar) {
        this.u = gVar;
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new gp();
        this.i = false;
        this.n = true;
        this.r = 1;
        this.Q = true;
        this.ac = 0;
        this.ad = false;
        this.ag = -1L;
        this.ai = false;
        this.aj = false;
        this.ak = x.ao + hashCode();
        this.al = 0;
        this.am = 0;
        this.as = 3500;
        this.aw = new int[2];
        this.ax = false;
        this.ay = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aJ = false;
        this.aK = false;
        this.aM = true;
        this.aO = true;
        this.aP = true;
        this.aQ = false;
        this.aR = false;
        this.aS = 0;
        this.aT = "skip_btn_delay_id_" + hashCode();
        this.by = false;
        this.bz = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aQ));
                if (PPSLinkedView.this.aQ) {
                    return;
                }
                PPSLinkedView.this.aQ = true;
                PPSLinkedView.this.y();
            }
        };
        this.bA = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.by = true;
                if (PPSLinkedView.this.ar == 2 && PPSLinkedView.this.o != null && PPSLinkedView.this.o.F()) {
                    fh.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.N.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Z(i);
                }
                if (PPSLinkedView.this.t != null) {
                    long j = i;
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.ad = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ah = i;
                PPSLinkedView.this.af = System.currentTimeMillis();
                if (!PPSLinkedView.this.ax) {
                    PPSLinkedView.this.x();
                    PPSLinkedView.this.j();
                }
                if (i > 0) {
                    PPSLinkedView.this.t.L();
                    PPSLinkedView.this.f.f();
                } else {
                    PPSLinkedView.this.t.D();
                    if (PPSLinkedView.this.f != null && PPSLinkedView.this.s != null) {
                        fh.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f.Code(PPSLinkedView.this.s.I(), true ^ "y".equals(PPSLinkedView.this.s.a()));
                    }
                }
                if (PPSLinkedView.this.p != null && PPSLinkedView.this.p.I()) {
                    db.Code(PPSLinkedView.this.j, PPSLinkedView.this.p.r(), PPSLinkedView.this.p.d(), (System.currentTimeMillis() - PPSLinkedView.this.k.T().longValue()) - ((long) PPSLinkedView.this.k.U()), PPSLinkedView.this.p.q(), "84");
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fh.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.I(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aQ) {
                    fh.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aQ = true;
                    PPSLinkedView.this.y();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.s.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i, i2);
                }
                if (PPSLinkedView.this.ad) {
                    PPSLinkedView.this.f.Code(i);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, i2, PPSLinkedView.this.s == null ? 0L : PPSLinkedView.this.s.I());
                }
            }
        };
        this.bB = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bC = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                fh.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aK && PPSLinkedView.this.w != null) {
                    PPSLinkedView.this.aK = true;
                    PPSLinkedView.this.w.Code();
                }
                if (PPSLinkedView.this.aN == null) {
                    PPSLinkedView.this.aN = Integer.valueOf(i);
                    if (PPSLinkedView.this.p == null || PPSLinkedView.this.p.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.p.C().V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.bD = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (PPSLinkedView.this.n) {
                    if (PPSLinkedView.this.ar == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.g)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.n = false;
                    fh.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.ar == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aU.getMode() ? 17 : 9;
                        PPSLinkedView.this.n();
                    }
                    PPSLinkedView.this.I(i);
                    PPSLinkedView.this.i = true;
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.n = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bE = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (bm.Code(PPSLinkedView.this.bv, PPSLinkedView.this.br, this.V - x, this.I - y)) {
                        kx.Code(view, motionEvent, 1, PPSLinkedView.this.g);
                        PPSLinkedView.this.z.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.bG = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.z.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.g = l.Code(view, motionEvent);
                if (PPSLinkedView.this.g != null) {
                    PPSLinkedView.this.g.V((Integer) 0);
                    PPSLinkedView.this.g.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bH = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                kx.Code(view, motionEvent, null, PPSLinkedView.this.g);
                return false;
            }
        };
        this.bI = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                fh.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.ax));
                PPSLinkedView.this.P();
                PPSLinkedView.this.Q();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.x != null) {
                    fh.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.x.Code(i, i2, i3);
                }
            }
        };
        this.bJ = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.Code();
                }
                PPSLinkedView.this.f.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.V();
                }
                PPSLinkedView.this.f.V(1.0f);
            }
        };
        this.bK = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.f.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.f.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.bL = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    private void A() {
        fh.V("PPSLinkedView", "setAccListener");
        if (this.aY == null) {
            fh.V("PPSLinkedView", "new setAccListener");
            jp jpVar = new jp(getContext());
            this.aY = jpVar;
            jpVar.Code(new c());
            this.aY.Code();
        }
    }

    private void E() {
        fh.V("PPSLinkedView", "setRotationListener");
        if (this.aX == null) {
            fh.V("PPSLinkedView", " new setRotationListener");
            jq jqVar = new jq(getContext());
            this.aX = jqVar;
            jqVar.Code(new d());
            this.aX.Code();
        }
    }

    private void G() {
        String str;
        try {
            if (this.aa == null) {
                View viewInflate = this.W.inflate();
                this.aa = viewInflate;
                viewInflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aa.getLayoutParams();
            if (this.al > 0) {
                fh.Code("PPSLinkedView", "left:%s, top:%s, right:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.al, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.aa.setLayoutParams(layoutParams);
            }
            ImageView imageView = (ImageView) this.aa.findViewById(R.id.hiad_full_mode_logo);
            int i = this.U;
            if (i > 0) {
                imageView.setImageResource(i);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) this.aa.findViewById(R.id.hiad_media_name);
            int i2 = this.ac;
            if (i2 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setText(i2);
                textView.setVisibility(0);
            }
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            fh.I("PPSLinkedView", str);
        } catch (Exception e2) {
            str = "showFullModeLogo " + e2.getClass().getSimpleName();
            fh.I("PPSLinkedView", str);
        }
    }

    private int I(AdContentData adContentData) {
        return (adContentData.aA() == null || adContentData.aA().Code() == null) ? this.k.y() : adContentData.aA().Code().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        fh.Code("PPSLinkedView", "interactiveLogic: %s", Integer.valueOf(this.aZ));
        return this.aZ == 1 ? N() && O() : N() || O();
    }

    private boolean N() {
        fh.Code("PPSLinkedView", "acceptableAcceleration: sqrtAcc: %s, limitAcc: %s", Float.valueOf(this.bl), Integer.valueOf(this.bt));
        return this.bl >= ((float) this.bt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.ar != 1 || this.ax) {
            return;
        }
        this.ax = true;
        w();
        this.ar = 0;
        TextureGlVideoView textureGlVideoView = this.G;
        if (textureGlVideoView != null) {
            textureGlVideoView.L();
            this.G.destroyView();
        }
        setPlaying(false);
        t();
        com.huawei.openalliance.ad.views.d dVar = this.A;
        if (dVar != null) {
            dVar.D();
        }
        this.K = null;
        this.T = null;
        this.ab = null;
        W();
        PPSSplashProView pPSSplashProView = this.aU;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        if (this.ay || !this.ad) {
            return;
        }
        fh.Code("PPSLinkedView", "report imp and phyImp on splash. ");
        this.t.Code(System.currentTimeMillis() - this.af, 100);
        Code((Integer) 8, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        fh.V("PPSLinkedView", "reportDisplayError, adMediator: %s, linkedAdListener: %s", bc.V(this.q), bc.V(this.az));
        boolean z = this.aR;
        if (!z && this.q != null) {
            fh.V("PPSLinkedView", "report display error. ");
            this.aR = true;
            this.q.I(-3);
            this.q.r();
            return;
        }
        if (z) {
            return;
        }
        fh.V("PPSLinkedView", "report fail to display. ");
        this.aR = true;
        Z(-3);
    }

    private void W() {
        List<View> list = this.J;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.J) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void X() {
        if (this.Q && this.P == null) {
            ImageView imageView = new ImageView(getContext());
            this.P = imageView;
            imageView.setImageResource(R.drawable.hiad_selector_ic_sound_check);
            bg.Code(this.P);
            Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_8_dp);
            this.P.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            int i = R.dimen.haid_splash_sound_margin_right;
            layoutParams.rightMargin = resources.getDimensionPixelSize(i);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.haid_splash_sound_margin_bottom);
            layoutParams.bottomMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset + bg.I(getContext());
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i));
            this.z.addView(this.P, layoutParams);
            this.P.bringToFront();
            this.P.setSelected(false);
            this.P.setOnClickListener(this.bL);
        }
    }

    private boolean Y() {
        return this.aJ;
    }

    private void aa() {
        if (this.O != null) {
            fh.Code("PPSLinkedView", "%d delay, skip btn show", Integer.valueOf(this.aS));
            if (this.aS > 0) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSLinkedView.this.O != null) {
                            fh.Code("PPSLinkedView", "skip btn show");
                            PPSLinkedView.this.O.setVisibility(0);
                        }
                    }
                }, this.aT, this.aS);
            } else {
                fh.Code("PPSLinkedView", "skip btn show");
                this.O.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        fh.V("PPSLinkedView", "reportAdShowStartEvent");
        this.aj = false;
        String strValueOf = String.valueOf(this.ae);
        k kVar = this.p;
        if (kVar == null) {
            fh.I("PPSLinkedView", "linkedSplashAd is null! please register first");
            return;
        }
        kVar.m(strValueOf);
        this.p.Code(this.ae);
        this.p.Z(false);
        this.p.C(false);
        this.p.F(true);
        if (!this.p.aw()) {
            this.p.I(true);
        }
        this.t.Code(strValueOf);
        this.t.Code(this.ae);
        fh.Code("PPSLinkedView", "report showStart. ");
        this.t.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        fh.V("PPSLinkedView", "calculateScaleAndTrans");
        o();
        if (this.an <= 0.0f || this.ao <= 0.0f) {
            fh.I("PPSLinkedView", "calculateScaleAndTrans, get screen size failed. ");
            Q();
            L();
            return;
        }
        boolean zF = bg.F(this.j);
        fh.V("PPSLinkedView", "calculateScaleAndTrans, MultiWindow:%s, screenHeight:%s,  screenWidth:%s", Boolean.valueOf(zF), Float.valueOf(this.an), Float.valueOf(this.ao));
        this.H.getLocationOnScreen(this.aw);
        this.ap = this.H.getHeight();
        this.aq = this.H.getWidth();
        fh.V("PPSLinkedView", "calculateScaleAndTrans, destViewHeight:%s, destViewWidth:%s, locationX:%s, locationY:%s", Integer.valueOf(this.ap), Integer.valueOf(this.aq), Integer.valueOf(this.aw[0]), Integer.valueOf(this.aw[1]));
        Point point = new Point();
        this.M.getDefaultDisplay().getRealSize(point);
        fh.Code("PPSLinkedView", "calculateScaleAndTrans, screenHeight:%s, point.y:%s", Float.valueOf(this.an), Integer.valueOf(point.y));
        if (this.al <= 0 && cn.Code(this.j).Code(this.j)) {
            this.al = Math.max(this.al, cn.Code(this.j).Code(this));
        }
        if ((point.y - this.al) - this.an > bg.C(this.j)) {
            this.am = bg.S(getContext());
        } else {
            this.am = 0;
        }
        fh.V("PPSLinkedView", "calculateScaleAndTrans, NotchEnable: %s, scrennHeight:%s, screenWidth:%s, navigationBarHeight:%s, notchHeight:%s", Boolean.valueOf(cn.Code(this.j).Code(this.j)), Float.valueOf(this.an), Float.valueOf(this.ao), Integer.valueOf(this.am), Integer.valueOf(this.al));
        if (cn.Code(this.j).Code(this.j)) {
            if (zF) {
                int i = this.ap;
                f5 = this.an;
                int i2 = this.al;
                this.at = (i * 1.0f) / (i2 + f5);
                f4 = this.aw[1] + ((i * 1.0f) / 2.0f);
                f6 = i2;
            } else {
                int i3 = this.ap;
                float f7 = this.an;
                int i4 = this.al;
                int i5 = this.am;
                this.at = (i3 * 1.0f) / ((i4 + f7) + i5);
                f4 = this.aw[1] + ((i3 * 1.0f) / 2.0f);
                f5 = f7 + i4;
                f6 = i5;
            }
            f3 = f4 - (((f5 + f6) * 1.0f) / 2.0f);
        } else {
            if (zF) {
                int i6 = this.ap;
                float f8 = this.an;
                this.at = (i6 * 1.0f) / f8;
                f2 = (this.aw[1] + ((i6 * 1.0f) / 2.0f)) - ((f8 * 1.0f) / 2.0f);
            } else {
                int i7 = this.ap;
                int i8 = this.am;
                float f9 = this.an;
                this.at = (i7 * 1.0f) / (i8 + f9);
                f2 = (this.aw[1] + ((i7 * 1.0f) / 2.0f)) - (((f9 + i8) * 1.0f) / 2.0f);
            }
            f3 = f2 - this.al;
        }
        this.au = f3;
        this.av = ((this.aq * 1.0f) / this.ao) * 1.0f;
    }

    private void o() {
        DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
        this.an = displayMetrics.heightPixels;
        this.ao = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        fh.V("PPSLinkedView", "switchViewOnAnimationEnd. ");
        Code(this.aO);
        if (fh.Code()) {
            fh.Code("PPSLinkedView", "isMoved: %s, linkedAdListener on switch: %s ", Boolean.valueOf(this.ax), this.az);
        }
        if (this.az == null) {
            fh.I("PPSLinkedView", "linkedAdListener is null. ");
        } else {
            fh.Code("PPSLinkedView", "splash show end. ");
            this.az.V();
        }
    }

    private boolean q() {
        boolean zR = r();
        boolean zS = s();
        if (!zR && !zS) {
            return true;
        }
        fh.I("PPSLinkedView", "checkDestView, destView change null, linkedAdListener: %s, isMoved:%s. ", bc.V(this.az), Boolean.valueOf(this.ax));
        fh.V("PPSLinkedView", "isDestViewNull:%s, isDestViewNotAvalible:%s", Boolean.valueOf(zR), Boolean.valueOf(zS));
        if (!this.aR) {
            this.aR = true;
            Z(-5);
            m mVar = this.az;
            if (mVar != null) {
                mVar.V();
            }
        }
        if (!this.ax) {
            this.ax = true;
            this.ar = 0;
            TextureGlVideoView textureGlVideoView = this.G;
            if (textureGlVideoView != null) {
                textureGlVideoView.L();
                this.G.destroyView();
            }
            setPlaying(false);
            t();
            W();
            g gVar = this.u;
            if (gVar != null) {
                gVar.Code(this.aL);
            }
        }
        return false;
    }

    private boolean r() {
        PPSDestView pPSDestView = this.H;
        return pPSDestView == null || pPSDestView.getHeight() == 0 || this.H.getWidth() == 0;
    }

    private boolean s() {
        TextureGlVideoView textureGlVideoView = this.G;
        return textureGlVideoView == null || !textureGlVideoView.h();
    }

    private void u() {
        fh.V("PPSLinkedView", "addMonitor");
        fw fwVar = new fw(this, this);
        this.o = fwVar;
        fwVar.D();
        k kVar = this.p;
        if (kVar != null) {
            this.o.V(kVar.x(), this.p.y());
        }
        this.o.Code(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!this.ai) {
            this.ai = true;
            k kVar = this.p;
            if (kVar != null && kVar.I()) {
                com.huawei.openalliance.ad.ipc.d.Code(getContext()).Code("dismissSlogan", null, null, null);
            }
            this.ag = System.currentTimeMillis();
            if (!this.k.m()) {
                Code((Long) null, (Integer) null, (Integer) 8, false);
                this.ay = true;
            }
            if (this.ar == 1) {
                aa();
                X();
                V(this.p);
                G();
                Code(this.p);
            }
        }
        View view = this.T;
        if (view != null) {
            view.setVisibility(8);
            this.T = null;
        }
        if (this.K != null) {
            fh.Code("PPSLinkedView", "PPSSplashView is not null. ");
            this.K.setVisibility(8);
            this.K = null;
        }
        View view2 = this.ab;
        if (view2 != null) {
            view2.setVisibility(8);
            this.ab = null;
        }
    }

    @Override // com.huawei.hms.ads.fw.a
    public void B() {
        fh.V("PPSLinkedView", "onViewPartialHidden: ");
        if (this.G == null || this.N == null) {
            return;
        }
        fh.V("PPSLinkedView", "onViewPartialHidden, start pause");
        this.N.D();
        VideoInfo videoInfo = this.s;
        if (videoInfo != null) {
            videoInfo.Code("n");
        }
        this.N.Z();
        this.N.e();
        setPlaying(false);
    }

    @Override // com.huawei.hms.ads.fw.a
    public void C() {
        fh.V("PPSLinkedView", "onViewShownBetweenFullAndPartial: ");
        if (this.G == null || this.N == null) {
            return;
        }
        fh.V("PPSLinkedView", "onViewShownBetweenFullAndPartial, start mute");
        this.N.D();
        this.N.e();
        VideoInfo videoInfo = this.s;
        if (videoInfo != null) {
            videoInfo.Code("n");
        }
    }

    public void L() {
        fh.V("PPSLinkedView", "unregister. ");
        R();
    }

    public SplashLinkedVideoView i() {
        return this.z;
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new gp();
        this.i = false;
        this.n = true;
        this.r = 1;
        this.Q = true;
        this.ac = 0;
        this.ad = false;
        this.ag = -1L;
        this.ai = false;
        this.aj = false;
        this.ak = x.ao + hashCode();
        this.al = 0;
        this.am = 0;
        this.as = 3500;
        this.aw = new int[2];
        this.ax = false;
        this.ay = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = false;
        this.aJ = false;
        this.aK = false;
        this.aM = true;
        this.aO = true;
        this.aP = true;
        this.aQ = false;
        this.aR = false;
        this.aS = 0;
        this.aT = "skip_btn_delay_id_" + hashCode();
        this.by = false;
        this.bz = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aQ));
                if (PPSLinkedView.this.aQ) {
                    return;
                }
                PPSLinkedView.this.aQ = true;
                PPSLinkedView.this.y();
            }
        };
        this.bA = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fh.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, true);
                PPSLinkedView.this.by = true;
                if (PPSLinkedView.this.ar == 2 && PPSLinkedView.this.o != null && PPSLinkedView.this.o.F()) {
                    fh.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.N.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Z(i2);
                }
                if (PPSLinkedView.this.t != null) {
                    long j = i2;
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fh.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fh.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i2));
                PPSLinkedView.this.ad = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ah = i2;
                PPSLinkedView.this.af = System.currentTimeMillis();
                if (!PPSLinkedView.this.ax) {
                    PPSLinkedView.this.x();
                    PPSLinkedView.this.j();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.t.L();
                    PPSLinkedView.this.f.f();
                } else {
                    PPSLinkedView.this.t.D();
                    if (PPSLinkedView.this.f != null && PPSLinkedView.this.s != null) {
                        fh.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f.Code(PPSLinkedView.this.s.I(), true ^ "y".equals(PPSLinkedView.this.s.a()));
                    }
                }
                if (PPSLinkedView.this.p != null && PPSLinkedView.this.p.I()) {
                    db.Code(PPSLinkedView.this.j, PPSLinkedView.this.p.r(), PPSLinkedView.this.p.d(), (System.currentTimeMillis() - PPSLinkedView.this.k.T().longValue()) - ((long) PPSLinkedView.this.k.U()), PPSLinkedView.this.p.q(), "84");
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fh.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.I(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
                if (i22 > 0 && !PPSLinkedView.this.aQ) {
                    fh.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i22));
                    PPSLinkedView.this.aQ = true;
                    PPSLinkedView.this.y();
                }
                if (i22 > 0) {
                    PPSLinkedView.this.s.Code(i22);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.x != null) {
                    PPSLinkedView.this.x.Code(i2, i22);
                }
                if (PPSLinkedView.this.ad) {
                    PPSLinkedView.this.f.Code(i2);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.j, i22, PPSLinkedView.this.s == null ? 0L : PPSLinkedView.this.s.I());
                }
            }
        };
        this.bB = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fh.Code()) {
                    fh.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bC = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                fh.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aK && PPSLinkedView.this.w != null) {
                    PPSLinkedView.this.aK = true;
                    PPSLinkedView.this.w.Code();
                }
                if (PPSLinkedView.this.aN == null) {
                    PPSLinkedView.this.aN = Integer.valueOf(i2);
                    if (PPSLinkedView.this.p == null || PPSLinkedView.this.p.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.p.C().V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
            }
        };
        this.bD = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                if (PPSLinkedView.this.n) {
                    if (PPSLinkedView.this.ar == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.g)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.n = false;
                    fh.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.ar == 2) {
                        i2 = 10;
                    } else {
                        i2 = 2 == PPSLinkedView.this.aU.getMode() ? 17 : 9;
                        PPSLinkedView.this.n();
                    }
                    PPSLinkedView.this.I(i2);
                    PPSLinkedView.this.i = true;
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.n = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bE = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fh.Code()) {
                        fh.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (bm.Code(PPSLinkedView.this.bv, PPSLinkedView.this.br, this.V - x, this.I - y)) {
                        kx.Code(view, motionEvent, 1, PPSLinkedView.this.g);
                        PPSLinkedView.this.z.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.bG = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.z.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.g = l.Code(view, motionEvent);
                if (PPSLinkedView.this.g != null) {
                    PPSLinkedView.this.g.V((Integer) 0);
                    PPSLinkedView.this.g.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bH = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.g = kx.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                kx.Code(view, motionEvent, null, PPSLinkedView.this.g);
                return false;
            }
        };
        this.bI = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                fh.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.ax));
                PPSLinkedView.this.P();
                PPSLinkedView.this.Q();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.x != null) {
                    fh.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.x.Code(i2, i22, i3);
                }
            }
        };
        this.bJ = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fh.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.Code();
                }
                PPSLinkedView.this.f.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fh.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.y != null) {
                    PPSLinkedView.this.y.V();
                }
                PPSLinkedView.this.f.V(1.0f);
            }
        };
        this.bK = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.f.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.f.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }
        };
        this.bL = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    private void B(int i) {
        String strJ_;
        String strR;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        k kVar = this.p;
        if (kVar != null) {
            strJ_ = kVar.j_();
            strR = this.p.r();
            AdContentData adContentData = new AdContentData();
            adContentData.B(this.p.d());
            adContentData.D(this.p.j_());
            adContentData.d(this.p.s());
            adContentData.S(this.p.A());
            fh.V("PPSLinkedView", "reportExLinkedAdFailedToLoad, uniqueId: %s", adContentData.aa());
            analysisEventReport.Code(adContentData);
            analysisEventReport.c(this.p.d());
            analysisEventReport.e(this.p.r());
            if (this.p.aJ() != null) {
                analysisEventReport.I(this.p.aJ().aF());
                analysisEventReport.d(this.p.aJ().aE());
            }
        } else {
            strJ_ = null;
            strR = null;
        }
        analysisEventReport.Code(i);
        analysisEventReport.I(strJ_);
        analysisEventReport.Z(strR);
        com.huawei.openalliance.ad.ipc.g.V(this.j).Code("rptSplashFailedEvt", ad.V(analysisEventReport), null, null);
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.a();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.fw.a
    public void Z() {
        VideoInfo videoInfo;
        fh.V("PPSLinkedView", "onViewFullShown: ");
        if (this.G == null || (videoInfo = this.s) == null || this.N == null) {
            return;
        }
        int iL = videoInfo.L();
        if (Y()) {
            return;
        }
        fh.V("PPSLinkedView", "onViewFullShown, start play, duration: %s, playProgress: %s", this.aN, Integer.valueOf(iL));
        this.N.I(iL);
        this.N.V();
        setPlaying(true);
        Integer num = this.aN;
        if (num == null || Math.abs(num.intValue() - iL) >= 1000) {
            this.N.Code(iL, 3);
        } else {
            fh.V("PPSLinkedView", "onViewFullShown, seek to 0");
            this.N.Code(0L, 3);
        }
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private void Z(int i) {
        m mVar = this.az;
        if (mVar != null) {
            mVar.Code(i);
        }
        B(i);
    }

    @Override // com.huawei.hms.ads.fw.a
    public void I() {
        k kVar;
        fh.V("PPSLinkedView", "onViewPhysicalShowStart");
        if (!this.ax || (kVar = this.p) == null || kVar.aH()) {
            return;
        }
        x();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        e eVar;
        ez.Code(getContext()).Code(new b(this));
        Code(this.ar);
        if (this.t.Code(i, this.g)) {
            w();
            if (18 == i) {
                Context context = this.bu.get();
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
                }
            }
        }
        this.g = null;
        this.f.Code(hx.CLICK);
        int i2 = this.ar;
        int i3 = 1;
        if (i2 == 1) {
            this.aL = 3;
            eVar = this.v;
            if (eVar == null) {
                return;
            }
        } else {
            i3 = 2;
            if (i2 != 2) {
                return;
            }
            this.aL = 4;
            eVar = this.v;
            if (eVar == null) {
                return;
            }
        }
        eVar.Code(i3);
    }

    private String V(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private Integer Code(Integer num, int i) {
        fh.V("PPSLinkedView", "initial mode: %s", num);
        if (i == 0) {
            return null;
        }
        int iY = num == null ? this.k.y() : num.intValue();
        if (iY == 0) {
            return Integer.valueOf(iY);
        }
        Map<String, String> mapCode = ad.Code(eh.Code(getContext()).aj());
        if (mapCode != null) {
            if ((2 == iY || 3 == iY) && Code(bc.I(mapCode.get(x.cz)))) {
                iY = 4;
            }
            if ((1 == iY || 4 == iY) && Code(bc.I(mapCode.get(x.cy)))) {
                return 0;
            }
        }
        if (1 != getResources().getConfiguration().orientation || 2 != i) {
            return 0;
        }
        if (!V(iY)) {
            return Integer.valueOf(iY);
        }
        fh.V("PPSLinkedView", "can't use twist, enable : %s", Boolean.valueOf(this.k.g()));
        return 0;
    }

    private String V(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.b() == null) ? this.k.H() : interactCfg.b();
    }

    private String Code(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private String V(AdContentData adContentData) {
        String strCode = com.huawei.openalliance.ad.utils.c.Code(getContext(), adContentData, 0);
        return !TextUtils.isEmpty(strCode) ? strCode : !TextUtils.isEmpty(this.k.z()) ? this.k.z() : adContentData.av();
    }

    private String Code(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.b() == null) ? this.k.E() : interactCfg.b();
    }

    @Override // com.huawei.hms.ads.fw.a
    public void V() {
        fh.V("PPSLinkedView", "onViewShowStartRecord");
        k kVar = this.p;
        if (kVar == null || !this.ax) {
            return;
        }
        fh.Code("PPSLinkedView", "ad.getMinEffectiveShowTime: %s. ", Long.valueOf(kVar.x()));
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSLinkedView pPSLinkedView;
                Long lValueOf;
                Integer numValueOf;
                int i;
                k kVar2 = PPSLinkedView.this.p;
                if (kVar2 != null) {
                    if (PPSLinkedView.this.ar == 2) {
                        pPSLinkedView = PPSLinkedView.this;
                        lValueOf = Long.valueOf(kVar2.x());
                        numValueOf = Integer.valueOf(PPSLinkedView.this.o.B());
                        i = 9;
                    } else {
                        pPSLinkedView = PPSLinkedView.this;
                        lValueOf = Long.valueOf(kVar2.x());
                        numValueOf = Integer.valueOf(PPSLinkedView.this.o.B());
                        i = 8;
                    }
                    pPSLinkedView.Code(lValueOf, numValueOf, Integer.valueOf(i), false);
                }
            }
        }, this.ak, kVar.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(double d2, double d3, double d4) {
        if (d2 - ((double) this.bm.intValue()) < 0.0d && Code(this.bb, d2 - ((double) this.bm.intValue()))) {
            this.bb = Math.min(this.bb, d2 - ((double) this.bm.intValue()));
        } else if (Code(this.bc, d2 - ((double) this.bm.intValue()))) {
            this.bc = Math.max(this.bc, d2 - ((double) this.bm.intValue()));
        }
        if (d3 - ((double) this.bn.intValue()) < 0.0d && Code(this.be, d3 - ((double) this.bn.intValue()))) {
            this.be = Math.min(this.be, d3 - ((double) this.bn.intValue()));
        } else if (Code(this.bf, d3 - ((double) this.bn.intValue()))) {
            this.bf = Math.max(this.bf, d3 - ((double) this.bn.intValue()));
        }
        if (d4 - ((double) this.bo.intValue()) < 0.0d && Code(this.bh, d4 - ((double) this.bo.intValue()))) {
            this.bh = Math.min(this.bh, d4 - ((double) this.bo.intValue()));
        } else if (Code(this.bi, d4 - ((double) this.bo.intValue()))) {
            this.bi = Math.max(this.bi, d4 - ((double) this.bo.intValue()));
        }
    }

    @Override // com.huawei.hms.ads.fw.a
    public void V(long j, int i) {
        fh.V("PPSLinkedView", "onViewPhysicalShowEnd: ");
        bj.Code(this.ak);
        k kVar = this.p;
        if (kVar != null) {
            kVar.F(false);
        }
        if (this.G != null) {
            fh.V("PPSLinkedView", "onViewPhysicalShowEnd, start pause. ");
            this.N.Z();
            this.N.e();
            setPlaying(false);
        }
        fh.Code("PPSLinkedView", "onViewPhysicalShowEnd, noPhyImp: %s. ", Boolean.valueOf(this.ay));
        if (this.ay || i <= 0) {
            return;
        }
        fh.Code("PPSLinkedView", "report phyImp. ");
        if (this.ag == -1) {
            this.t.Code(j, i);
        } else {
            this.t.Code(System.currentTimeMillis() - this.ag, i);
            this.ag = -1L;
        }
    }

    private void Code(int i) {
        int i2;
        if (i == 1) {
            i2 = 12;
        } else if (i != 2) {
            return;
        } else {
            i2 = 13;
        }
        Code(Integer.valueOf(i2), true);
    }

    private void V(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.k = eh.Code(applicationContext);
        this.t = new ij(this.j, this);
        this.M = (WindowManager) context.getSystemService("window");
        this.aP = cn.Code(this.j).V();
        this.e = com.huawei.openalliance.ad.utils.d.a(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        VideoInfo videoInfo = this.s;
        if (videoInfo != null) {
            videoInfo.Code(z ? 0 : i);
        }
        if (this.ad) {
            this.ad = false;
            iv ivVar = this.t;
            long j = this.af;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.ah;
            long j3 = i;
            if (z) {
                ivVar.Code(j, jCurrentTimeMillis, j2, j3);
                this.f.a();
            } else {
                ivVar.V(j, jCurrentTimeMillis, j2, j3);
                this.f.e();
            }
        }
        setPlaying(false);
    }

    private void V(k kVar) {
        fh.V("PPSLinkedView", "LinkedSplashAd:%s, isChinaRom:%s", kVar, Boolean.valueOf(this.aP));
        if (kVar != null) {
            Integer numZ = Z(kVar.aJ());
            InteractCfg interactCfgAA = kVar.aJ().aA();
            Integer numC = interactCfgAA == null ? null : interactCfgAA.C();
            if (this.aP) {
                this.m.setAdMediator(this.q);
                this.m.Code(this, numZ, numC, z.Code(true, kVar.ad(), kVar.ac()));
                this.m.setVisibility(0);
                this.m.Code(kVar.aJ(), false, this.al, 1, false);
                return;
            }
            this.l.setPpsLinkedView(this);
            this.l.Code(numZ, numC);
            this.l.setVisibility(0);
            this.l.Code(kVar.aJ(), false, this.al, 1, false);
            if (ag.Code(kVar.aL())) {
                return;
            }
            this.l.setChoiceViewOnClickListener(new a(this, kVar.aJ()));
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(this.bD);
            }
        }
    }

    @Override // com.huawei.hms.ads.fw.a
    public void Code(long j, int i) {
        fh.V("PPSLinkedView", "onViewShowEndRecord");
        bj.Code(this.ak);
        if (!this.o.Code(j) || this.aj) {
            return;
        }
        this.aj = true;
        Code(Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.ar == 2 ? 9 : 8), false);
    }

    private void Code(AdContentData adContentData) {
        int iIntValue;
        this.br = eh.Code(getContext()).G();
        if (adContentData.aA() != null) {
            InteractCfg interactCfgAA = adContentData.aA();
            if (this.br <= 0 && interactCfgAA.V() != null && interactCfgAA.V().intValue() > 0) {
                this.br = interactCfgAA.V().intValue();
            }
            this.bt = interactCfgAA.I() != null ? interactCfgAA.I().intValue() : eh.Code(getContext()).K();
            this.bs = interactCfgAA.Z() != null ? interactCfgAA.Z().intValue() : eh.Code(getContext()).J();
            this.bv = interactCfgAA.S().intValue();
            iIntValue = interactCfgAA.B().intValue();
        } else {
            this.br = eh.Code(getContext()).G();
            this.bt = eh.Code(getContext()).K();
            this.bs = eh.Code(getContext()).J();
            iIntValue = 0;
        }
        this.aZ = iIntValue;
        int i = this.br;
        if (i <= 0) {
            i = 200;
        }
        this.br = i;
        this.br = z.V(getContext(), this.br);
        this.I = this.bs * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        MediaPlayerAgent mediaPlayerAgent;
        VideoInfo videoInfo;
        String str;
        fh.V("PPSLinkedView", "switchSound enableSound: " + z);
        if (this.E == null || (mediaPlayerAgent = this.N) == null) {
            return;
        }
        if (z) {
            mediaPlayerAgent.L();
            this.P.setSelected(true);
            videoInfo = this.s;
            if (videoInfo != null) {
                str = "y";
                videoInfo.Code(str);
            }
        } else {
            mediaPlayerAgent.D();
            this.P.setSelected(false);
            videoInfo = this.s;
            if (videoInfo != null) {
                str = "n";
                videoInfo.Code(str);
            }
        }
        this.t.V(!z);
    }

    private void Code(AdContentData adContentData, int i) {
        z();
        this.aU.setVisibility(4);
        this.aU.setDesc(V(adContentData));
        this.aU.Code(false, i);
        if (i != 0) {
            this.aU.setVisibility(0);
        }
        this.z.setOnTouchListener(this.bH);
    }

    private boolean V(int i) {
        if (2 != i && 3 != i) {
            return false;
        }
        if (this.k.g()) {
            return !q.Z(getContext().getApplicationContext());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (z.Code(iArr, 2) && z.Code(iArr2, 2) && adContentData != null) {
            if (fh.Code()) {
                fh.Code("PPSLinkedView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                fh.Code("PPSLinkedView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            this.h = pPSAdvertiserInfoDialog;
            this.z.addView(pPSAdvertiserInfoDialog, layoutParams);
            this.h.setScreenWidth(this.z.getMeasuredWidth());
            this.h.setScreenHeight(this.z.getMeasuredHeight());
            this.h.setAdContent(adContentData);
        }
    }

    private void Code(k kVar) {
        AdContentData adContentDataAJ;
        Integer numZ;
        if (this.aU == null || kVar == null || (adContentDataAJ = kVar.aJ()) == null) {
            return;
        }
        int iC = jg.C(adContentDataAJ.v());
        int iS = jg.S(adContentDataAJ.v());
        fh.V("PPSLinkedView", "set splashpro mode:" + iC);
        if (iC == 0 || (numZ = Z(adContentDataAJ)) == null) {
            this.aU.setVisibility(8);
        } else if (numZ.intValue() == 0) {
            Code(adContentDataAJ, iS);
        } else {
            Code(adContentDataAJ);
            Code(false, numZ.intValue(), adContentDataAJ);
        }
        this.aU.setMode(iC);
    }

    public void Code(Integer num, boolean z) {
        fh.Code("PPSLinkedView", "reportSplashAdShowEvent. ");
        Code(Long.valueOf(System.currentTimeMillis() - this.af), (Integer) 100, num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        fh.Code("PPSLinkedView", "reportAdShowEvent. ");
        k kVar = this.p;
        if (kVar == null) {
            return;
        }
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(kVar.h_(), num2);
        if (!this.p.aB() || (zCode && !this.p.ab())) {
            if (!this.k.m()) {
                this.p.Z(true);
                this.t.Code((Long) null, (Integer) null, num2, z);
            } else if (z || l.longValue() >= this.p.x()) {
                this.p.Z(true);
                fh.Code("PPSLinkedView", "report imp. ");
                this.t.Code(l, num, num2, z);
            }
            if (zCode) {
                this.p.C(true);
            }
            this.f.D();
        }
    }

    private void Code(boolean z) {
        fh.V("PPSLinkedView", "moveLinkedView");
        if (q() && !this.ax) {
            t();
            g gVar = this.u;
            if (gVar != null) {
                gVar.Code(this.aL);
            }
            if (z) {
                u();
            }
            this.ax = true;
        }
    }

    private void Code(boolean z, int i, AdContentData adContentData) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        this.z.setOnClickListener(null);
        InteractCfg interactCfgAA = adContentData.aA();
        String strCode = com.huawei.openalliance.ad.utils.c.Code(getContext(), adContentData, i);
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.aV;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.aV.Code(Code(interactCfgAA), Code(interactCfgAA, strCode));
            this.aV.setShowLogo(z);
            this.aV.setVisibility(0);
            this.z.setOnTouchListener(this.bE);
            return;
        }
        if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.aW;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.aW.Code(V(interactCfgAA), V(interactCfgAA, strCode));
            this.aW.setShowLogo(z);
            this.aW.setVisibility(0);
            this.z.setOnTouchListener(bF);
            A();
            E();
            return;
        }
        if (3 != i) {
            if (4 != i || (pPSSplashSwipeClickView = this.bw) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.bw.Code(I(interactCfgAA), Code(interactCfgAA, strCode));
            this.bw.setShowLogo(z);
            this.bw.setVisibility(0);
            this.z.setOnTouchListener(this.bE);
            this.bw.getClickAreaView().setOnTouchListener(this.bG);
            return;
        }
        PPSSplashTwistClickView pPSSplashTwistClickView = this.bx;
        if (pPSSplashTwistClickView == null) {
            return;
        }
        pPSSplashTwistClickView.setVisibility(4);
        this.bx.Code(Z(interactCfgAA), V(interactCfgAA, strCode));
        this.bx.setShowLogo(z);
        this.bx.setVisibility(0);
        this.z.setOnTouchListener(bF);
        this.bx.getClickAreaView().setOnTouchListener(this.bG);
        A();
        E();
    }

    private boolean Code(double d2, double d3) {
        return ((double) this.bs) > Math.abs(d3) || Math.abs(d2) > Math.abs(d3) / 2.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(MaterialClickInfo materialClickInfo) {
        PPSSplashProView pPSSplashProView = this.aU;
        if (pPSSplashProView != null && materialClickInfo != null) {
            int mode = pPSSplashProView.getMode();
            if (fh.Code()) {
                fh.Code("PPSLinkedView", "splashpro mode:" + mode);
            }
            if (1 != mode && mode != 0) {
                Rect rect = new Rect();
                this.aU.getHitRect(rect);
                boolean zContains = rect.contains(materialClickInfo.Code().intValue(), materialClickInfo.V().intValue());
                fh.V("PPSLinkedView", "check result:" + zContains);
                return zContains;
            }
        }
        return true;
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long jAi = eh.Code(getContext()).ai();
        return jAi == -1 || System.currentTimeMillis() < (jAi * 86400000) + l.longValue();
    }
}
