package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.beizi.ad.a.a.a;
import com.beizi.ad.a.a.b;
import com.beizi.ad.a.a.c;
import com.beizi.ad.a.a.d;
import com.beizi.ad.a.a.e;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.download.BeiZiWebView;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.i;
import com.beizi.ad.internal.e.m;
import com.beizi.ad.internal.e.s;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.ad.internal.view.a.a;
import com.beizi.ad.lance.a.q;
import com.beizi.ad.model.c;
import com.beizi.ad.v2.f.b;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.af;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BeiZiNewRewardVideoActivity extends Activity {
    private TextView A;
    private FrameLayout B;
    private CustomRoundImageView C;
    private CustomRoundImageView D;
    private VideoView E;
    private ProgressBar F;
    private boolean H;
    private int K;
    private int L;
    private boolean M;
    private MediaPlayer N;
    private int P;
    private boolean Q;
    private int R;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private AdSpacesBean.BuyerBean Y;
    private c Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f4544a;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private c.j aF;
    private c.j aG;
    private int aH;
    private int aI;
    private c.q aJ;
    private c.q aK;
    private c.q aL;
    private c.q aM;
    private LinearLayout aN;
    private RelativeLayout aO;
    private TextView aP;
    private TextView aQ;
    private TextView aR;
    private TextView aS;
    private c.k aT;
    private boolean aU;
    private boolean aV;
    private FrameLayout aW;
    private TextView aX;
    private ImageView aY;
    private int aZ;
    private e aa;
    private d ab;
    private a ac;
    private com.beizi.ad.a.a.b ad;
    private boolean af;
    private String ag;
    private String ah;
    private String ai;
    private long aj;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private String ap;
    private int aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private c.n aw;
    private int ax;
    private c.m ay;
    private int az;
    private com.beizi.ad.internal.d.a b;
    private int ba;
    private int bb;
    private int bj;
    private RelativeLayout c;
    private RelativeLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private View k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private boolean G = false;
    private boolean I = false;
    private int J = 30;
    private boolean O = false;
    private boolean S = true;
    private boolean ae = true;
    private boolean ak = false;
    private Handler aE = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int currentPosition;
            super.handleMessage(message);
            try {
                if (message.what != 10010) {
                    return;
                }
                BeiZiNewRewardVideoActivity.this.aE.sendEmptyMessageDelayed(10010, 1000L);
                BeiZiNewRewardVideoActivity.this.T();
                if (BeiZiNewRewardVideoActivity.this.M && BeiZiNewRewardVideoActivity.this.E != null && BeiZiNewRewardVideoActivity.this.E.isPlaying()) {
                    int duration = BeiZiNewRewardVideoActivity.this.E.getDuration();
                    currentPosition = BeiZiNewRewardVideoActivity.this.E.getCurrentPosition();
                    BeiZiNewRewardVideoActivity.this.b(currentPosition);
                    BeiZiNewRewardVideoActivity.this.a(duration, currentPosition);
                } else {
                    currentPosition = 0;
                }
                if (!BeiZiNewRewardVideoActivity.this.as && !BeiZiNewRewardVideoActivity.this.am && !BeiZiNewRewardVideoActivity.this.aV && !BeiZiNewRewardVideoActivity.this.aD) {
                    if (!BeiZiNewRewardVideoActivity.this.M) {
                        BeiZiNewRewardVideoActivity.i(BeiZiNewRewardVideoActivity.this);
                        currentPosition = BeiZiNewRewardVideoActivity.this.az * 1000;
                    }
                    int i = BeiZiNewRewardVideoActivity.this.ax == 0 ? ((BeiZiNewRewardVideoActivity.this.J * 1000) - currentPosition) / 1000 : 0;
                    BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                    beiZiNewRewardVideoActivity.K = ((beiZiNewRewardVideoActivity.J * 1000) - currentPosition) / 1000;
                    if (BeiZiNewRewardVideoActivity.this.K <= BeiZiNewRewardVideoActivity.this.L || BeiZiNewRewardVideoActivity.this.L <= 0) {
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                        beiZiNewRewardVideoActivity2.L = beiZiNewRewardVideoActivity2.K;
                        if (BeiZiNewRewardVideoActivity.this.bb == BeiZiNewRewardVideoActivity.this.bc) {
                            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity3 = BeiZiNewRewardVideoActivity.this;
                            beiZiNewRewardVideoActivity3.be = (beiZiNewRewardVideoActivity3.bf * 1000) - currentPosition;
                        }
                        if (BeiZiNewRewardVideoActivity.this.bb != BeiZiNewRewardVideoActivity.this.bc || BeiZiNewRewardVideoActivity.this.be > 0) {
                            BeiZiNewRewardVideoActivity.this.d(i);
                        } else if (BeiZiNewRewardVideoActivity.this.ax != 0 || i > 0) {
                            BeiZiNewRewardVideoActivity.this.D();
                        } else {
                            BeiZiNewRewardVideoActivity.this.d(i);
                        }
                        if (!BeiZiNewRewardVideoActivity.this.M && i <= 0) {
                            BeiZiNewRewardVideoActivity.this.J();
                        }
                        if ((BeiZiNewRewardVideoActivity.this.bf * 1000) - currentPosition >= 0 || BeiZiNewRewardVideoActivity.this.bb != BeiZiNewRewardVideoActivity.this.bd || BeiZiNewRewardVideoActivity.this.al) {
                            return;
                        }
                        BeiZiNewRewardVideoActivity.this.R();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private int bc = 1;
    private int bd = 2;
    private int be = 0;
    private int bf = 5;
    private int bg = 15;
    private int bh = 15;
    private int bi = 0;

    public static /* synthetic */ int i(BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity) {
        int i = beiZiNewRewardVideoActivity.az;
        beiZiNewRewardVideoActivity.az = i + 1;
        return i;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_reward_video);
            a();
            b();
            c();
            d();
            a(this.C, 55);
            a(this.p, this.q);
            if (this.M) {
                g();
            } else {
                f();
            }
            Q();
            F();
            B();
            C();
            l();
            r();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            com.beizi.ad.a.a.c cVar = this.Z;
            if (cVar != null) {
                cVar.b();
            }
            this.Z = null;
            e eVar = this.aa;
            if (eVar != null) {
                eVar.d();
            }
            this.aa = null;
            a aVar = this.ac;
            if (aVar != null) {
                aVar.d();
            }
            this.ac = null;
            d dVar = this.ab;
            if (dVar != null) {
                dVar.a();
            }
            this.ab = null;
            com.beizi.ad.a.a.b bVar = this.ad;
            if (bVar != null) {
                bVar.b();
            }
            this.ad = null;
            Handler handler = this.aE;
            if (handler != null) {
                handler.removeMessages(10010);
            }
            this.aE = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.ak = false;
        y();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b == null || this.f4544a == null) {
            finish();
        }
        this.ak = true;
        s();
        V();
        N();
        this.aj = 0L;
        if (this.ao) {
            return;
        }
        VideoView videoView = this.E;
        if (videoView != null && this.M && !this.ar && !this.as && !this.am && !this.aV) {
            videoView.resume();
        }
        this.S = false;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.am) {
            if (!this.O) {
                this.aj = 0L;
            } else if (this.bg >= 0) {
                this.aj = System.currentTimeMillis();
            } else {
                this.aj = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.beizi.ad.internal.d.a aVarM;
        try {
            b bVar = this.f4544a;
            if (bVar == null || (aVarM = bVar.m()) == null) {
                return;
            }
            aVarM.f(this.c, this.f4544a.e());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void B() {
        try {
            c.n nVar = this.aw;
            if (nVar == null) {
                return;
            }
            c.j jVarG = nVar.g();
            this.aF = jVarG;
            if (jVarG == null) {
                this.aF = new c.j();
            }
            c.q qVarC = this.aF.c();
            this.aJ = qVarC;
            if (qVarC == null) {
                c.q qVar = new c.q();
                this.aJ = qVar;
                qVar.a("__TIME__秒后可领取奖励");
                this.aJ.b("点击广告可提前领取奖励");
                this.aJ.c("已经获得奖励");
                this.aF.a(this.aJ);
            }
            c.q qVarD = this.aF.d();
            this.aK = qVarD;
            if (qVarD == null) {
                c.q qVar2 = new c.q();
                this.aK = qVar2;
                qVar2.a("跳过");
                this.aK.c("关闭");
                this.aF.b(this.aK);
            }
            c.j jVarH = this.aw.h();
            this.aG = jVarH;
            if (jVarH == null) {
                this.aG = new c.j();
            }
            c.q qVarC2 = this.aG.c();
            this.aL = qVarC2;
            if (qVarC2 == null) {
                c.q qVar3 = new c.q();
                this.aL = qVar3;
                qVar3.a("点击广告领取奖励");
                this.aL.b("点击广告领取奖励");
                this.aL.c("已经获得奖励");
                this.aG.a(this.aL);
            }
            c.q qVarD2 = this.aG.d();
            this.aM = qVarD2;
            if (qVarD2 == null) {
                c.q qVar4 = new c.q();
                this.aM = qVar4;
                qVar4.a("跳过");
                this.aM.b("跳过");
                this.aM.c("关闭");
                this.aG.b(this.aM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void C() {
        c.j jVar;
        try {
            if (this.aw != null && (jVar = this.aF) != null) {
                this.aH = jVar.a();
                this.aI = this.aF.b();
                c.q qVarC = this.aF.c();
                this.aJ = qVarC;
                String strReplace = null;
                String strA = qVarC != null ? qVarC.a() : null;
                c.q qVarD = this.aF.d();
                this.aK = qVarD;
                String strA2 = qVarD != null ? qVarD.a() : null;
                int i = this.ax;
                if (i == 1 || i == 2) {
                    strReplace = strA;
                } else if (!TextUtils.isEmpty(strA)) {
                    strReplace = strA.replace("__TIME__", this.J + "");
                }
                if (this.aH != 0 || this.aI != 0) {
                    strA2 = strReplace;
                } else if (!TextUtils.isEmpty(strReplace)) {
                    strA2 = strReplace + " ｜ " + strA2;
                }
                if (this.o != null && !TextUtils.isEmpty(strA2)) {
                    this.o.setText(strA2);
                }
                if (this.aH == 0 && this.aI > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.11
                        @Override // java.lang.Runnable
                        public void run() {
                            BeiZiNewRewardVideoActivity.this.aI = 0;
                        }
                    }, this.aI * 1000);
                }
                TextView textView = this.o;
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.13
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (BeiZiNewRewardVideoActivity.this.aH == 1 || BeiZiNewRewardVideoActivity.this.aI > 0) {
                                return;
                            }
                            BeiZiNewRewardVideoActivity.this.E();
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        try {
            if (this.bb != this.bc || this.ao || this.o == null) {
                return;
            }
            this.an = true;
            c.q qVar = this.aJ;
            String strB = qVar != null ? qVar.b() : null;
            c.q qVar2 = this.aK;
            String strA = qVar2 != null ? qVar2.a() : null;
            if (this.aH == 0 && this.aI == 0) {
                if (TextUtils.isEmpty(strB)) {
                    strB = strA;
                } else {
                    strB = strB + " ｜ " + strA;
                }
            }
            if (this.o == null || TextUtils.isEmpty(strB)) {
                return;
            }
            this.o.setText(strB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        c.j jVar;
        try {
            if (this.aw == null || (jVar = this.aF) == null) {
                return;
            }
            int iF = jVar.f();
            if (!af.a(this.aF.e())) {
                iF = 0;
            }
            if (this.ao) {
                iF = 0;
            }
            int iG = this.aF.g();
            if (iF != 0) {
                if (iF == 1) {
                    this.aF.c(0);
                    R();
                    return;
                } else {
                    if (iF != 2) {
                        return;
                    }
                    this.aF.c(0);
                    W();
                    return;
                }
            }
            if (this.aF.f() == 1 && iG == 1 && this.am) {
                return;
            }
            if (!this.ao) {
                G();
            } else {
                if (this.aF.h() != 1) {
                    m();
                    return;
                }
                if (this.am) {
                    U();
                }
                J();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void F() {
        try {
            c.n nVar = this.aw;
            if (nVar == null) {
                return;
            }
            c.k kVarJ = nVar.j();
            this.aT = kVarJ;
            if (kVarJ == null) {
                this.aT = new c.k();
            }
            if (this.aT.a() == null) {
                c.q qVar = new c.q();
                qVar.a("仅需再观看__TIME__秒即可获取奖励");
                this.aT.a(qVar);
            }
            if (this.aT.b() == null) {
                c.q qVar2 = new c.q();
                qVar2.a("确定退出吗");
                this.aT.b(qVar2);
            }
            if (this.aT.c() == null) {
                c.q qVar3 = new c.q();
                qVar3.a("继续观看");
                this.aT.c(qVar3);
            }
            if (this.aT.d() == null) {
                c.q qVar4 = new c.q();
                qVar4.a("关闭广告");
                this.aT.d(qVar4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void G() {
        try {
            if (this.aO == null) {
                return;
            }
            if (this.ao) {
                J();
                return;
            }
            this.as = true;
            y();
            this.aO.setVisibility(0);
            c.k kVar = this.aT;
            if (kVar != null) {
                c.q qVarA = kVar.a();
                strA = qVarA != null ? qVarA.a() : null;
                b(this.aQ, this.aT.b());
                b(this.aR, this.aT.c());
                b(this.aS, this.aT.d());
            }
            if (this.aP != null && !TextUtils.isEmpty(strA)) {
                this.aP.setText(strA.replace("__TIME__", this.K + ""));
            }
            TextView textView = this.aR;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiNewRewardVideoActivity.this.H();
                    }
                });
            }
            TextView textView2 = this.aS;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiNewRewardVideoActivity.this.as = false;
                        BeiZiNewRewardVideoActivity.this.I();
                    }
                });
            }
            this.aO.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            this.as = false;
            RelativeLayout relativeLayout = this.aO;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            s();
            h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        try {
            if (this.aw == null) {
                m();
                return;
            }
            c.k kVar = this.aT;
            if (kVar == null) {
                m();
                return;
            }
            int iF = kVar.f();
            if (!af.a(this.aT.e())) {
                iF = 0;
            }
            if (this.ao) {
                iF = 0;
            }
            if (iF == 0) {
                m();
                return;
            }
            if (iF == 1) {
                H();
                this.aT.a(0);
                if (this.am) {
                    U();
                }
                J();
                return;
            }
            if (iF == 2) {
                H();
                this.aT.a(0);
                R();
            } else if (iF == 3) {
                H();
                this.aT.a(0);
                W();
            } else {
                if (iF != 4) {
                    return;
                }
                this.aT.a(0);
                H();
            }
        } catch (Exception e) {
            e.printStackTrace();
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        try {
            c.n nVar = this.aw;
            if (nVar == null || this.aV) {
                return;
            }
            this.aV = true;
            c.i iVarK = nVar.k();
            if (iVarK == null) {
                iVarK = new c.i();
                iVarK.a(0);
            }
            this.aZ = iVarK.a();
            String strN = this.b.N();
            if (TextUtils.isEmpty(strN)) {
                this.aZ = 0;
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            K();
            int i = this.aZ;
            if (i != 0 && i != 1) {
                if (i != 2 || this.b == null) {
                    return;
                }
                y();
                X();
                HashMap map = new HashMap();
                if (this.b != null) {
                    map = new HashMap();
                    map.put("isRedirectionCanJump", Boolean.valueOf(this.b.T()));
                    map.put("isDownload", Boolean.valueOf(this.af));
                    map.put("landingPageUrl", strN);
                    map.put("deeplinkUrl", this.b.M());
                    map.put("webDeepLink", Boolean.valueOf(this.b.U()));
                }
                BeiZiWebView beiZiWebView = new BeiZiWebView(this, map);
                beiZiWebView.loadUrl(strN);
                this.aW.addView(beiZiWebView);
                return;
            }
            M();
            L();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void K() {
        if (this.aU) {
            return;
        }
        this.aU = true;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_end_car_container_rl);
        relativeLayout.setVisibility(0);
        int iF = q.f(this);
        int iG = q.g(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.width = iF;
        layoutParams.height = iG;
        relativeLayout.setLayoutParams(layoutParams);
        this.aX = (TextView) findViewById(R.id.beizi_reward_video_ad_end_car_close_tv);
        a((FrameLayout) findViewById(R.id.beizi_reward_video_ad_end_car_logo_container_fl));
        this.aW = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_end_car_container_fl);
        if (this.aX != null) {
            int iA = t.a(this, 15.0f);
            int iA2 = t.a(this, 30.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aX.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = iA2;
            this.aX.setLayoutParams(layoutParams2);
            this.aX.setVisibility(0);
            m.a(this.aX, "#66000000", 1, "#66FFFFFF", iA);
            this.aX.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiNewRewardVideoActivity.this.P();
                }
            });
            O();
        }
    }

    private void L() {
        FrameLayout frameLayout;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.beizi_reward_video_end_car_normal, (ViewGroup) null);
        if (viewInflate != null && (frameLayout = this.aW) != null) {
            frameLayout.removeAllViews();
            this.aW.addView(viewInflate);
        }
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_image_iv);
        if (imageView != null && !TextUtils.isEmpty(this.ap)) {
            h.a(this).a(this.ap, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.18
                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    try {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(i.a(BeiZiNewRewardVideoActivity.this, bitmap, 10.0f));
                        ImageView imageView2 = imageView;
                        if (imageView2 == null || bitmap == null) {
                            return;
                        }
                        imageView2.setBackground(bitmapDrawable);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        View view = (LinearLayout) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_container_ll);
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = t.a(this, 50.0f);
            view.setLayoutParams(layoutParams);
        }
        if (view != null) {
            m.a(view, "#3976FF", 0, (String) null, t.a(this, 25.0f));
        }
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_icon_iv);
        TextView textView = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_title_tv);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_subtitle_tv);
        a(customRoundImageView, 89);
        a(textView, textView2);
        this.aY = (ImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_iv);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_title_tv);
        if (!TextUtils.isEmpty(this.ag) && textView3 != null) {
            textView3.setText(this.ag);
        }
        a(this.aY);
        a(view);
    }

    private void M() {
        MediaPlayer mediaPlayer;
        try {
            if (this.aZ != 1 || this.ar) {
                i();
                return;
            }
            if (this.E == null || !this.M) {
                return;
            }
            int i = this.P;
            if (i > 0 && (mediaPlayer = this.N) != null && Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(i, 3);
            }
            ImageView imageView = this.l;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.beizi_voice_off);
            }
            this.I = false;
            this.N.setVolume(0.0f, 0.0f);
            this.E.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            if (this.aV) {
                O();
                if (!this.am) {
                    a(this.aY);
                }
                M();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O() {
        String strA;
        try {
            c.q qVar = this.aL;
            String strA2 = null;
            if (qVar == null) {
                strA = null;
            } else if (this.ao) {
                strA = qVar.c();
            } else {
                strA = qVar.a();
                if (TextUtils.isEmpty(strA)) {
                    strA = this.aL.b();
                }
            }
            c.q qVar2 = this.aM;
            if (qVar2 != null) {
                if (this.ao) {
                    strA2 = qVar2.c();
                } else {
                    strA2 = qVar2.a();
                    if (TextUtils.isEmpty(strA2)) {
                        strA2 = this.aM.b();
                    }
                }
            }
            TextView textView = this.aX;
            if (textView != null) {
                textView.setText(strA + " ｜ " + strA2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        try {
            if (this.aw == null) {
                m();
                return;
            }
            c.j jVar = this.aG;
            if (jVar == null) {
                m();
                return;
            }
            int iF = jVar.f();
            if (!af.a(this.aG.e())) {
                iF = 0;
            }
            if (this.ao) {
                iF = 0;
            }
            if (iF == 0) {
                m();
                return;
            }
            if (iF == 1) {
                this.aG.c(0);
                R();
            } else {
                if (iF != 2) {
                    return;
                }
                this.aG.c(0);
                W();
            }
        } catch (Exception e) {
            e.printStackTrace();
            m();
        }
    }

    private void Q() {
        c.n nVar = this.aw;
        if (nVar == null) {
            return;
        }
        c.m mVarI = nVar.i();
        this.ay = mVarI;
        if (mVarI == null) {
            this.ay = new c.m();
            int iA = this.aw.a();
            if (iA > 0) {
                this.ay.b(iA);
            }
            int iD = this.aw.d();
            if (iD > 0) {
                this.ay.c(iD);
            }
            int iB = this.aw.b();
            if (iB > 0) {
                this.ay.d(iB);
            }
            int iC = this.aw.c();
            if (iC > 0) {
                this.ay.e(iC);
            }
        }
        this.bf = this.ay.j();
        int iK = this.ay.k();
        this.bi = iK;
        this.bj = iK;
        int i = this.ay.i();
        this.bg = i;
        this.bh = i;
        this.bb = this.ay.b();
        this.ba = this.ay.a();
        if (this.ay.c() == null) {
            c.q qVar = new c.q();
            qVar.a("恭喜获得特权");
            qVar.b("恭喜获得特权");
            qVar.c("恭喜获得特权");
            this.ay.a(qVar);
        }
        if (this.ay.d() == null) {
            c.q qVar2 = new c.q();
            qVar2.a("打开并体验内容");
            qVar2.b("只需再体验__TIME__秒");
            qVar2.c("任务达成");
            this.ay.b(qVar2);
        }
        if (this.ay.e() == null) {
            c.q qVar3 = new c.q();
            qVar3.a("__TIME__秒即可获得奖励");
            qVar3.b("即可获得奖励");
            qVar3.c("已经提前获取到奖励");
            this.ay.c(qVar3);
        }
        if (this.ay.f() == null) {
            c.q qVar4 = new c.q();
            qVar4.a("浏览详情，获取奖励");
            qVar4.b("继续浏览，获取奖励");
            qVar4.c("已获得奖励，继续体验");
            this.ay.d(qVar4);
        }
        if (this.ay.g() == null) {
            c.q qVar5 = new c.q();
            qVar5.a("__TIME__秒后继续播放");
            qVar5.b("浏览时间不足，无法领取奖励");
            qVar5.c("恭喜您！已提前获取奖励");
            this.ay.e(qVar5);
        }
        if (this.ay.h() == null) {
            c.q qVar6 = new c.q();
            qVar6.a("放弃特权");
            qVar6.b("放弃特权");
            qVar6.c("关闭");
            this.ay.f(qVar6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        try {
            if (this.ay == null || this.g == null || this.am) {
                return;
            }
            s();
            this.al = true;
            this.am = true;
            if (this.bb == 1) {
                this.an = true;
            }
            this.bf = this.ay.j();
            int iK = this.ay.k();
            this.bi = iK;
            this.bj = iK;
            int i = this.ay.i();
            this.bg = i;
            this.bh = i;
            this.g.setVisibility(0);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            b(this.s, this.ay.c());
            b(this.t, this.ay.d());
            c.q qVarE = this.ay.e();
            if (qVarE != null) {
                String strA = qVarE.a();
                if (this.u != null && !TextUtils.isEmpty(strA)) {
                    if (strA.contains("__TIME__秒")) {
                        String str = this.bh + "秒";
                        String strReplace = strA.replace("__TIME__秒", str);
                        int iIndexOf = strReplace.indexOf(str);
                        SpannableString spannableString = new SpannableString(strReplace);
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3976FF")), iIndexOf, str.length() + iIndexOf, 33);
                        this.u.setText(spannableString);
                    } else {
                        this.u.setText(strA);
                    }
                }
            }
            b(this.z, this.ay.f());
            c.q qVarG = this.ay.g();
            if (qVarG != null) {
                String strA2 = qVarG.a();
                if (this.v != null && !TextUtils.isEmpty(strA2)) {
                    this.v.setText(strA2.replace("__TIME__", this.bj + ""));
                }
            }
            b(this.w, this.ay.h());
            i();
            if (this.i != null) {
                if (TextUtils.isEmpty(this.T) && TextUtils.isEmpty(this.U) && TextUtils.isEmpty(this.V)) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                }
            }
            a(this.D, 47);
            a(this.x, this.y);
            a(this.n);
            a(this.j);
            if (this.w != null) {
                if (this.ay.l() == 1) {
                    this.w.setVisibility(8);
                } else {
                    this.w.setVisibility(0);
                }
                this.w.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                        beiZiNewRewardVideoActivity.bh = beiZiNewRewardVideoActivity.bg;
                        BeiZiNewRewardVideoActivity.this.S();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        try {
            c.m mVar = this.ay;
            if (mVar == null) {
                return;
            }
            int iN = mVar.n();
            if (!af.a(this.ay.m())) {
                iN = 0;
            }
            boolean z = this.ao;
            if (z) {
                iN = 0;
            }
            if (iN != 0) {
                if (iN == 1) {
                    this.ay.g(0);
                    W();
                }
            } else if (z) {
                m();
            } else {
                U();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int i;
        try {
            c.m mVar = this.ay;
            if (mVar != null && mVar.k() != 0 && this.am && this.ak && !this.as && (i = this.bj) != -999 && !this.aD) {
                if (i <= 0) {
                    if (i == 0) {
                        U();
                        return;
                    }
                    return;
                }
                c.q qVarG = this.ay.g();
                if (qVarG != null) {
                    String strA = qVarG.a();
                    if (this.v != null && !TextUtils.isEmpty(strA)) {
                        this.v.setText(strA.replace("__TIME__", this.bj + ""));
                    }
                }
                this.bj--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void U() {
        this.am = false;
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (this.aV) {
            N();
            return;
        }
        if (this.ak) {
            h();
        }
        a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V() {
        boolean z;
        c.q qVarD;
        try {
            if (this.S) {
                return;
            }
            if (this.am) {
                a(this.n);
            }
            if (this.O && !this.as && this.am && this.aj > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.aj;
                if (this.bb != this.bc) {
                    z = false;
                } else {
                    if (!this.an) {
                        return;
                    }
                    if (jCurrentTimeMillis > this.bh * 1000) {
                        z = true;
                    }
                }
                if (jCurrentTimeMillis > this.bh * 1000) {
                    z = true;
                }
                if ((z && this.ba == 0) || (this.ba == 1 && this.ao)) {
                    o();
                    d(0);
                }
                a(this.s, this.ay.c());
                int i = ((int) (((long) (this.bh * 1000)) - jCurrentTimeMillis)) / 1000;
                this.bh = i;
                if (i <= 0) {
                    this.bh = 1;
                }
                if (this.t != null && (qVarD = this.ay.d()) != null) {
                    String strB = qVarD.b();
                    if (this.ao) {
                        strB = qVarD.c();
                    }
                    if (!TextUtils.isEmpty(strB)) {
                        if (strB.contains("__TIME__秒")) {
                            String str = this.bh + "秒";
                            String strReplace = strB.replace("__TIME__秒", str);
                            SpannableString spannableString = new SpannableString(strReplace);
                            int iIndexOf = strReplace.indexOf(str);
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3976FF")), iIndexOf, str.length() + iIndexOf, 33);
                            this.t.setText(spannableString);
                        } else {
                            this.t.setText(strB);
                        }
                    }
                }
                a(this.u, this.ay.e());
                a(this.z, this.ay.f());
                this.bj = SkuConfig.INFINITE_COUNT;
                a(this.v, this.ay.g());
                a(this.w, this.ay.h());
                if (this.ba == 1) {
                    this.v.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.21
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                Intent launchIntentForPackage = BeiZiNewRewardVideoActivity.this.getPackageManager().getLaunchIntentForPackage(BeiZiNewRewardVideoActivity.this.b.m());
                                if (launchIntentForPackage != null) {
                                    launchIntentForPackage.setFlags(268435456);
                                    BeiZiNewRewardVideoActivity.this.startActivity(launchIntentForPackage);
                                }
                                BeiZiNewRewardVideoActivity.this.ao = true;
                                BeiZiNewRewardVideoActivity.this.V();
                                BeiZiNewRewardVideoActivity.this.N();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void W() {
        try {
            LinearLayout linearLayout = this.f;
            if (linearLayout == null) {
                return;
            }
            int[] iArr = new int[2];
            linearLayout.getLocationOnScreen(iArr);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int iA = t.a(this, 50.0f);
            int iD = layoutParams != null ? layoutParams.width : 0;
            if (iD <= 0) {
                iD = q.d(this) - t.a(this, 30.0f);
            }
            int[] iArrA = af.a(iD / 2, iA / 2);
            a(String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), String.valueOf(iArrA[0]), String.valueOf(iArrA[1]), String.valueOf(iArrA[0] + iArr[0]), String.valueOf(iArrA[1] + iArr[1]), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void X() {
        try {
            int[] iArr = new int[2];
            this.f.getLocationOnScreen(iArr);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int iA = t.a(this, 50.0f);
            int iD = layoutParams != null ? layoutParams.width : 0;
            if (iD <= 0) {
                iD = q.d(this) - t.a(this, 30.0f);
            }
            int[] iArrA = af.a(iD / 2, iA / 2);
            String strE = this.f4544a.e();
            com.beizi.ad.model.d dVar = new com.beizi.ad.model.d();
            dVar.a(String.valueOf(iArrA[0]));
            dVar.e(String.valueOf(iArrA[0]));
            dVar.b(String.valueOf(iArrA[1]));
            dVar.f(String.valueOf(iArrA[1]));
            dVar.c(String.valueOf(iArrA[0] + iArr[0]));
            dVar.g(String.valueOf(iArrA[0] + iArr[0]));
            dVar.d(String.valueOf(iArrA[1] + iArr[1]));
            dVar.h(String.valueOf(iArrA[1] + iArr[1]));
            this.b.a(true);
            this.b.a(this.f, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), strE, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(this, this.b.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewB = t.b(this, this.b.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            if (this.B != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int iA = t.a(this, 8.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                this.B.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l() {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiNewRewardVideoActivity.this.I) {
                            BeiZiNewRewardVideoActivity.this.l.setImageResource(R.drawable.beizi_voice_off);
                            if (BeiZiNewRewardVideoActivity.this.N != null) {
                                BeiZiNewRewardVideoActivity.this.N.setVolume(0.0f, 0.0f);
                            }
                        } else {
                            BeiZiNewRewardVideoActivity.this.l.setImageResource(R.drawable.beizi_voice_on);
                            if (BeiZiNewRewardVideoActivity.this.N != null) {
                                BeiZiNewRewardVideoActivity.this.N.setVolume(0.0f, 1.0f);
                            }
                        }
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                        beiZiNewRewardVideoActivity.I = !beiZiNewRewardVideoActivity.I;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void m() {
        Handler handler = this.aE;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        b bVar = this.f4544a;
        if (bVar != null) {
            bVar.x();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.beizi.ad.internal.d.a aVarM;
        try {
            b bVar = this.f4544a;
            if (bVar == null || this.aA || (aVarM = bVar.m()) == null) {
                return;
            }
            this.aA = true;
            aVarM.a(this.c, this.f4544a.e());
            this.f4544a.w();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        b bVar;
        try {
            if (this.ao || (bVar = this.f4544a) == null || bVar.m() == null) {
                return;
            }
            this.ao = true;
            this.f4544a.a((String) null, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        b bVar;
        try {
            if (this.aB || (bVar = this.f4544a) == null || bVar.m() == null) {
                return;
            }
            this.aB = true;
            this.f4544a.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        b bVar;
        try {
            if (this.aC || (bVar = this.f4544a) == null || bVar.m() == null) {
                return;
            }
            this.aC = true;
            this.f4544a.A();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void r() {
        try {
            com.beizi.ad.internal.d.a aVar = this.b;
            if (aVar != null && this.af) {
                int iT = aVar.t();
                if (iT == 2 || iT == 5) {
                    this.A.setVisibility(0);
                    final String strL = this.b.l();
                    String strO = this.b.o();
                    String strN = this.b.n();
                    String strQ = this.b.q();
                    final String strP = !TextUtils.isEmpty(strQ) ? strQ : this.b.p();
                    final String strR = this.b.r();
                    final String strS = this.b.s();
                    this.A.setText(Html.fromHtml("应用名称：" + strL + " | 开发者：" + strO + " | 应用版本：" + strN + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                Intent intent = new Intent(BeiZiNewRewardVideoActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                                intent.putExtra("title_content_key", strL);
                                intent.putExtra("privacy_content_key", strR);
                                intent.putExtra("permission_content_key", strP);
                                intent.putExtra("intro_content_key", strS);
                                intent.setFlags(268435456);
                                BeiZiNewRewardVideoActivity.this.startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        try {
            e eVar = this.aa;
            if (eVar != null) {
                eVar.a();
            }
            a aVar = this.ac;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.Y == null) {
                return;
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            x();
            u();
            v();
            w();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void u() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            String str = "#3976FF";
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            this.ag = regionalClickView.getTitle();
            com.beizi.ad.a.a.c cVar = new com.beizi.ad.a.a.c(this, regionalClickView, this.X, this.af);
            this.Z = cVar;
            String strA = cVar.a();
            if (!TextUtils.isEmpty(strA)) {
                str = strA;
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                m.a(linearLayout, str, 0, (String) null, t.a(this, 5.0f));
                this.Z.a(this.f, this.r);
                this.Z.a(new c.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.4
                    @Override // com.beizi.ad.a.a.c.a
                    public void a(String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
                        com.beizi.ad.lance.a.m.a("BeiZisAd", "handleRegionalClickViewContent click");
                        BeiZiNewRewardVideoActivity.this.a(str2, str3, str4, str5, str6, str7, str8, str9, 0);
                    }
                });
            }
            LinearLayout linearLayout2 = this.j;
            if (linearLayout2 != null) {
                m.a(linearLayout2, "#2A8BEF", 0, (String) null, t.a(this, 25.0f));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void v() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.Y == null || com.beizi.fusion.c.b.a().o() || (shakeView = this.Y.getShakeView()) == null) {
                return;
            }
            e eVar = new e(this, shakeView, this.Y.getSpaceId(), this.X);
            this.aa = eVar;
            eVar.a(new e.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.5
                @Override // com.beizi.ad.a.a.e.a
                public void a() {
                    com.beizi.ad.lance.a.m.a("BeiZisAd", "handleShakeViewContent click");
                    BeiZiNewRewardVideoActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
            this.ai = "shake";
            this.ah = this.aa.c();
            a(this.m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void w() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.Y == null || com.beizi.fusion.c.b.a().o() || (eulerAngleRule = this.Y.getEulerAngleRule()) == null) {
                return;
            }
            a aVar = new a(this, eulerAngleRule, this.Y.getSpaceId(), this.X);
            this.ac = aVar;
            aVar.a(new a.InterfaceC0113a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.6
                @Override // com.beizi.ad.a.a.a.InterfaceC0113a
                public void a() {
                    com.beizi.ad.lance.a.m.a("BeiZisAd", "handleEulerAngleViewContent click");
                    BeiZiNewRewardVideoActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
            this.ai = "eulerAngle";
            this.ah = this.ac.c();
            a(this.m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void x() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            com.beizi.ad.a.a.b bVar = new com.beizi.ad.a.a.b(this, fullScreenClick, this.X);
            this.ad = bVar;
            bVar.a(this.c, new b.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.7
                @Override // com.beizi.ad.a.a.b.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    com.beizi.ad.lance.a.m.a("BeiZisAd", "handleFullScreenClickContent click");
                    BeiZiNewRewardVideoActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void y() {
        try {
            VideoView videoView = this.E;
            if (videoView != null && this.M) {
                int currentPosition = videoView.getCurrentPosition();
                if (currentPosition > 0) {
                    this.P = currentPosition;
                }
                i();
            }
            e eVar = this.aa;
            if (eVar != null) {
                eVar.b();
            }
            a aVar = this.ac;
            if (aVar != null) {
                aVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.beizi.ad.internal.d.a aVarM;
        try {
            com.beizi.ad.v2.f.b bVar = this.f4544a;
            if (bVar == null || (aVarM = bVar.m()) == null) {
                return;
            }
            aVarM.b(this.c, this.f4544a.e());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        try {
            if (this.M && this.E != null && !TextUtils.isEmpty(this.W)) {
                if (this.ax == 0) {
                    d(this.J);
                }
                ImageView imageView = this.l;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.I) {
                        this.l.setImageResource(R.drawable.beizi_voice_on);
                    } else {
                        this.l.setImageResource(R.drawable.beizi_voice_off);
                    }
                }
                this.E.setVisibility(0);
                if (this.H) {
                    com.beizi.ad.lance.a.m.a("BeiZisAd", "isVideoCacheSuccess: true");
                    a(0);
                } else {
                    com.beizi.ad.lance.a.m.a("BeiZisAd", "isVideoCacheSuccess: false");
                    this.E.setVideoPath(this.W);
                    this.E.requestFocus();
                }
                this.E.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.25
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        com.beizi.ad.lance.a.m.a("BeiZisAd", "onCompletion: 播放完成");
                        try {
                            BeiZiNewRewardVideoActivity.this.ar = true;
                            if (BeiZiNewRewardVideoActivity.this.F != null) {
                                BeiZiNewRewardVideoActivity.this.F.setVisibility(8);
                            }
                            BeiZiNewRewardVideoActivity.this.P = 0;
                            if (mediaPlayer != null) {
                                BeiZiNewRewardVideoActivity.this.b(mediaPlayer.getDuration());
                            }
                            BeiZiNewRewardVideoActivity.this.A();
                            if (BeiZiNewRewardVideoActivity.this.aV) {
                                return;
                            }
                            BeiZiNewRewardVideoActivity.this.p();
                            BeiZiNewRewardVideoActivity.this.o();
                            BeiZiNewRewardVideoActivity.this.J();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.E.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.26
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            BeiZiNewRewardVideoActivity.this.N = mediaPlayer;
                            if (BeiZiNewRewardVideoActivity.this.I) {
                                BeiZiNewRewardVideoActivity.this.N.setVolume(0.0f, 1.0f);
                            } else {
                                BeiZiNewRewardVideoActivity.this.N.setVolume(0.0f, 0.0f);
                            }
                            BeiZiNewRewardVideoActivity.this.h();
                            if (BeiZiNewRewardVideoActivity.this.ae) {
                                int duration = mediaPlayer.getDuration() / 1000;
                                if (BeiZiNewRewardVideoActivity.this.J > duration) {
                                    BeiZiNewRewardVideoActivity.this.J = duration;
                                }
                                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                                beiZiNewRewardVideoActivity.K = beiZiNewRewardVideoActivity.J;
                                if (BeiZiNewRewardVideoActivity.this.F != null) {
                                    BeiZiNewRewardVideoActivity.this.F.setMax(duration);
                                }
                                BeiZiNewRewardVideoActivity.this.k();
                                BeiZiNewRewardVideoActivity.this.t();
                                BeiZiNewRewardVideoActivity.this.n();
                                if (BeiZiNewRewardVideoActivity.this.aE != null) {
                                    BeiZiNewRewardVideoActivity.this.aE.sendEmptyMessageDelayed(10010, 1000L);
                                }
                                BeiZiNewRewardVideoActivity.this.z();
                            }
                            BeiZiNewRewardVideoActivity.this.ae = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.E.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.27
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        try {
                            com.beizi.ad.lance.a.m.a("BeiZisAd", "setOnErrorListener: 播放失败");
                            s sVarA = s.a();
                            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                            sVarA.a(beiZiNewRewardVideoActivity, beiZiNewRewardVideoActivity.W);
                            if (BeiZiNewRewardVideoActivity.this.aV) {
                                return true;
                            }
                            BeiZiNewRewardVideoActivity.this.q();
                            BeiZiNewRewardVideoActivity.this.n();
                            BeiZiNewRewardVideoActivity.this.o();
                            BeiZiNewRewardVideoActivity.this.J();
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });
                this.E.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.28
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                        if (mediaPlayer == null || i != 701) {
                            return false;
                        }
                        try {
                            BeiZiNewRewardVideoActivity.this.a(mediaPlayer.getCurrentPosition());
                            return false;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        MediaPlayer mediaPlayer;
        try {
            if (this.E != null && this.M && !this.am && !this.as && !this.aV) {
                int i = this.P;
                if (i > 0 && (mediaPlayer = this.N) != null && Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(i, 3);
                }
                this.E.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        VideoView videoView = this.E;
        if (videoView == null) {
            return;
        }
        videoView.pause();
    }

    private String j() {
        com.beizi.ad.v2.f.b bVar = this.f4544a;
        if (bVar == null) {
            return null;
        }
        return bVar.v();
    }

    private void b() {
        try {
            com.beizi.ad.v2.f.b bVar = com.beizi.ad.v2.f.b.G;
            this.f4544a = bVar;
            this.Y = bVar.a();
            this.af = this.f4544a.j();
            this.H = this.f4544a.u();
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.G = true;
            } else {
                this.G = false;
            }
            com.beizi.ad.internal.d.a aVarM = this.f4544a.m();
            this.b = aVarM;
            if (aVarM == null) {
                return;
            }
            this.X = aVarM.c();
            boolean zY = this.b.y();
            this.M = zY;
            if (zY) {
                this.W = this.b.x();
            }
            this.aq = this.b.J();
            this.T = this.b.z();
            this.Q = this.b.f();
            this.R = this.b.h();
            this.U = this.b.u();
            this.V = this.b.v();
            this.I = this.b.e() ? false : true;
            this.ap = this.b.I();
            c.n nVarK = this.b.K();
            this.aw = nVarK;
            if (nVarK == null) {
                c.n nVar = new c.n();
                this.aw = nVar;
                nVar.f(30);
            }
            int iF = this.aw.f();
            this.J = iF;
            if (iF <= 0) {
                int iG = this.b.g();
                if (iG > 0) {
                    this.J = iG;
                } else {
                    this.J = 30;
                }
            }
            int i = this.aq;
            if (i > 0 && this.J > i) {
                this.J = i;
            }
            this.ax = this.aw.e();
            this.K = this.J;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            int iA = t.a(this, 15.0f);
            int iA2 = t.a(this, 30.0f);
            ImageView imageView = this.l;
            if (imageView != null && this.M) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = iA2;
                layoutParams.height = iA2;
                this.l.setLayoutParams(layoutParams);
            }
            View view = this.k;
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.width = iA2;
                layoutParams2.height = iA2;
                this.k.setLayoutParams(layoutParams2);
                m.a(this.k, (String) null, 1, "#66FFFFFF", iA2 / 2);
            }
            LinearLayout linearLayout = this.e;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = iA2;
                this.e.setLayoutParams(layoutParams3);
                m.a(this.e, "#66000000", 1, "#66FFFFFF", iA);
            }
            LinearLayout linearLayout2 = this.f;
            if (linearLayout2 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
                layoutParams4.width = -1;
                layoutParams4.height = t.a(this, 44.0f);
                this.f.setLayoutParams(layoutParams4);
            }
            LinearLayout linearLayout3 = this.h;
            if (linearLayout3 != null) {
                m.a(linearLayout3, "#FFFFFF", 0, (String) null, iA);
            }
            LinearLayout linearLayout4 = this.i;
            if (linearLayout4 != null) {
                m.a(linearLayout4, "#EBF1FF", 0, (String) null, iA2 / 3);
            }
            LinearLayout linearLayout5 = this.j;
            if (linearLayout5 != null) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout5.getLayoutParams();
                layoutParams5.width = -1;
                layoutParams5.height = t.a(this, 50.0f);
                this.j.setLayoutParams(layoutParams5);
            }
            TextView textView = this.w;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                int iA3 = t.a(this, 120.0f);
                int iA4 = t.a(this, 35.0f);
                layoutParams6.width = iA3;
                layoutParams6.height = iA4;
                this.w.setLayoutParams(layoutParams6);
                m.a(this.w, "#4DFFFFFF", 0, (String) null, iA4 / 2);
            }
            LinearLayout linearLayout6 = this.aN;
            if (linearLayout6 != null) {
                m.a(linearLayout6, "#FFFFFF", 0, (String) null, iA);
            }
            TextView textView2 = this.aR;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = -1;
                int iA5 = t.a(this, 44.0f);
                layoutParams7.height = iA5;
                m.a(this.aR, "#3976FF", 0, (String) null, iA5 / 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        try {
            TextView textView = (TextView) findViewById(R.id.beizi_reward_video_complaint_tv);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiNewRewardVideoActivity.this.e();
                }
            });
            float fA = t.a(this, 5.0f);
            m.a(textView, "#66000000", 1, "#66FFFFFF", new float[]{0.0f, 0.0f, fA, fA, fA, fA, 0.0f, 0.0f});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            y();
            a.C0120a c0120a = new a.C0120a(this);
            c0120a.a(new a.b() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.22
                @Override // com.beizi.ad.internal.view.a.a.b
                public void a(String str) {
                    try {
                        if (BeiZiNewRewardVideoActivity.this.f4544a == null) {
                            return;
                        }
                        BeiZiNewRewardVideoActivity.this.f4544a.f(str);
                        BeiZiNewRewardVideoActivity.this.f4544a.x();
                        BeiZiNewRewardVideoActivity.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.view.a.a.b
                public void a() {
                    BeiZiNewRewardVideoActivity.this.aD = false;
                    BeiZiNewRewardVideoActivity.this.s();
                    BeiZiNewRewardVideoActivity.this.h();
                }
            });
            c0120a.a().show();
            this.aD = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.aD = false;
        }
    }

    private void f() {
        try {
            if (!this.M && !TextUtils.isEmpty(this.ap)) {
                if (this.ax == 0) {
                    d(this.J);
                }
                ProgressBar progressBar = this.F;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                final ImageView imageView = (ImageView) findViewById(R.id.beizi_reward_video_ad_image_iv);
                imageView.setVisibility(0);
                h.a(this).a(this.ap, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.24
                    @Override // com.beizi.ad.internal.e.h.a
                    public void a(final Bitmap bitmap) {
                        try {
                            float fAbs = Math.abs(((float) ((((double) q.f(BeiZiNewRewardVideoActivity.this)) * 1.0d) / ((double) q.g(BeiZiNewRewardVideoActivity.this)))) - ((float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()))));
                            if (fAbs > 0.1f) {
                                final ImageView imageView2 = imageView;
                                com.beizi.ad.lance.a.c.b().e().execute(new Runnable() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.24.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            Bitmap bitmap2 = bitmap;
                                            if (bitmap2 != null) {
                                                final BitmapDrawable bitmapDrawable = new BitmapDrawable(i.a(BeiZiNewRewardVideoActivity.this, bitmap2, 20.0f));
                                                if (BeiZiNewRewardVideoActivity.this.aE != null) {
                                                    BeiZiNewRewardVideoActivity.this.aE.post(new Runnable() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.24.1.1
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            ImageView imageView3;
                                                            try {
                                                                BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                                                if (bitmapDrawable2 == null || (imageView3 = imageView2) == null) {
                                                                    return;
                                                                }
                                                                imageView3.setBackground(bitmapDrawable2);
                                                            } catch (Throwable th) {
                                                                th.printStackTrace();
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            } else if (fAbs > 0.07d) {
                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            } else {
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            imageView.setImageBitmap(bitmap);
                            BeiZiNewRewardVideoActivity.this.k();
                            BeiZiNewRewardVideoActivity.this.t();
                            BeiZiNewRewardVideoActivity.this.n();
                            if (BeiZiNewRewardVideoActivity.this.aE != null) {
                                BeiZiNewRewardVideoActivity.this.aE.sendEmptyMessageDelayed(10010, 1000L);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.beizi.ad.internal.e.h.a
                    public void a() {
                        BeiZiNewRewardVideoActivity.this.n();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a() {
        this.c = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_container_rl);
        this.E = (VideoView) findViewById(R.id.beizi_reward_video_ad_video_vv);
        this.F = (ProgressBar) findViewById(R.id.beizi_reward_video_progress_bar);
        this.d = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_voice_close_container_rl);
        this.l = (ImageView) findViewById(R.id.beizi_reward_video_ad_voice_iv);
        this.k = findViewById(R.id.beizi_reward_video_ad_voice_outline_view);
        this.e = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_get_rewards_container_ll);
        this.o = (TextView) findViewById(R.id.beizi_reward_video_ad_get_rewards_close_tv);
        this.C = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_ad_app_icon_iv);
        this.p = (TextView) findViewById(R.id.beizi_reward_video_ad_app_title_tv);
        this.q = (TextView) findViewById(R.id.beizi_reward_video_ad_app_subtitle_tv);
        this.B = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_logo_container_fl);
        this.f = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_interaction_container_ll);
        this.m = (ImageView) findViewById(R.id.beizi_reward_video_ad_interaction_iv);
        this.r = (TextView) findViewById(R.id.beizi_reward_video_ad_interaction_title_tv);
        this.A = (TextView) findViewById(R.id.beizi_reward_video_ad_app_download_info_tv);
        this.g = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_container_ll);
        this.h = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_content_container_ll);
        this.s = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_title_tv);
        this.t = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_sub_title_tv);
        this.i = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_app_info_ll);
        this.D = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_icon_iv);
        this.x = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_title_tv);
        this.y = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_subtitle_tv);
        this.u = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_detail_tv);
        this.j = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_container_ll);
        this.z = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_title_tv);
        this.n = (ImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_iv);
        this.v = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_countdown_tv);
        this.w = (TextView) findViewById(R.id.beizi_reward_video_cancel_privilege_dialog_tv);
        this.aO = (RelativeLayout) findViewById(R.id.beizi_reward_video_quit_dialog_container_rl);
        this.aN = (LinearLayout) findViewById(R.id.beizi_reward_video_quit_dialog_content_container_ll);
        this.aP = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_get_reward_tv);
        this.aQ = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_quit_tv);
        this.aR = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_continue_play_tv);
        this.aS = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_close_ad_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        TextView textView;
        try {
            if (this.ax == 0 && (textView = this.o) != null) {
                if (this.J > 0 && i <= 0) {
                    if (textView != null) {
                        c.q qVar = this.aJ;
                        String strC = qVar != null ? qVar.c() : null;
                        c.q qVar2 = this.aK;
                        strReplace = qVar2 != null ? qVar2.c() : null;
                        if (this.aH == 0 && this.aI == 0) {
                            strC = strC + " ｜ " + strReplace;
                        }
                        this.o.setText(strC);
                    }
                    o();
                    return;
                }
                if (this.ao) {
                    return;
                }
                c.q qVar3 = this.aJ;
                String strA = qVar3 != null ? qVar3.a() : null;
                c.q qVar4 = this.aK;
                String strA2 = qVar4 != null ? qVar4.a() : null;
                if (!TextUtils.isEmpty(strA)) {
                    strReplace = strA.replace("__TIME__", i + "");
                }
                if (this.aH != 0 || this.aI != 0) {
                    strA2 = strReplace;
                } else if (!TextUtils.isEmpty(strReplace)) {
                    strA2 = strReplace + " ｜ " + strA2;
                }
                if (this.o != null && !TextUtils.isEmpty(strA2)) {
                    this.o.setText(strA2);
                }
                if (i <= 0) {
                    o();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        try {
            ProgressBar progressBar = this.F;
            if (progressBar == null) {
                return;
            }
            progressBar.setProgress(i / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(TextView textView, c.q qVar) {
        if (textView == null || qVar == null) {
            return;
        }
        try {
            String strA = qVar.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            textView.setText(strA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(int i) {
        com.beizi.ad.internal.d.a aVarM;
        com.beizi.ad.v2.f.b bVar = this.f4544a;
        if (bVar == null || (aVarM = bVar.m()) == null) {
            return;
        }
        String strE = this.f4544a.e();
        if (i == 25) {
            aVarM.c(this.c, strE);
        } else if (i == 50) {
            aVarM.d(this.c, strE);
        } else if (i == 75) {
            aVarM.e(this.c, strE);
        }
    }

    private void a(final CustomRoundImageView customRoundImageView, int i) {
        try {
            if (this.b == null || customRoundImageView == null) {
                return;
            }
            if (TextUtils.isEmpty(this.T)) {
                customRoundImageView.setVisibility(8);
                return;
            }
            final int iA = t.a(this, i);
            customRoundImageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) customRoundImageView.getLayoutParams();
            layoutParams.width = iA;
            layoutParams.height = iA;
            customRoundImageView.setLayoutParams(layoutParams);
            h.a((Context) null).a(this.T, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.23
                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    try {
                        CustomRoundImageView customRoundImageView2 = customRoundImageView;
                        if (customRoundImageView2 != null) {
                            customRoundImageView2.setImageBitmap(bitmap);
                            customRoundImageView.setRectRadius(iA / 2);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(TextView textView, TextView textView2) {
        if (textView != null) {
            try {
                if (!TextUtils.isEmpty(this.U)) {
                    textView.setVisibility(0);
                    textView.setText(this.U);
                } else {
                    textView.setVisibility(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(this.V)) {
                textView2.setVisibility(0);
                textView2.setText(this.V);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        try {
            String strJ = j();
            if (TextUtils.isEmpty(strJ)) {
                return;
            }
            this.E.setVideoPath(strJ);
            if (i == 0) {
                this.E.requestFocus();
            } else {
                this.E.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.beizi.ad.internal.d.a aVarM;
        try {
            if (this.f4544a == null || this.as || !hasWindowFocus() || (aVarM = this.f4544a.m()) == null) {
                return;
            }
            if (this.bb == this.bc && this.an && this.bg > 0 && !this.ao) {
                R();
            } else if (this.aV && !this.ao) {
                R();
            }
            String strE = this.f4544a.e();
            com.beizi.ad.model.d dVar = new com.beizi.ad.model.d();
            dVar.a(str);
            dVar.e(str5);
            dVar.b(str2);
            dVar.f(str6);
            dVar.c(str3);
            dVar.g(str7);
            dVar.d(str4);
            dVar.h(str8);
            aVarM.a(true);
            aVarM.a(this.c, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.O, strE, i);
            this.O = true;
            this.f4544a.y();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(final ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            if ("shake".equals(this.ai)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                if (!TextUtils.isEmpty(this.ah)) {
                    h.a(this).b(this.ah, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.8
                        @Override // com.beizi.ad.internal.e.h.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.e.h.a
                        public void a(Bitmap bitmap) {
                            try {
                                ImageView imageView2 = imageView;
                                if (imageView2 == null || bitmap == null) {
                                    return;
                                }
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                e eVar = this.aa;
                if (eVar != null) {
                    eVar.a(imageView);
                    return;
                }
                return;
            }
            if ("eulerAngle".equals(this.ai)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                if (!TextUtils.isEmpty(this.ah)) {
                    h.a(this).b(this.ah, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.9
                        @Override // com.beizi.ad.internal.e.h.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.e.h.a
                        public void a(Bitmap bitmap) {
                            try {
                                ImageView imageView2 = imageView;
                                if (imageView2 == null || bitmap == null) {
                                    return;
                                }
                                imageView2.setVisibility(0);
                                imageView.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                com.beizi.ad.a.a.a aVar = this.ac;
                if (aVar != null) {
                    aVar.a(imageView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity.10

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f4546a;
            float b;
            float c;
            float d;
            float e;
            float f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f4546a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getRawX();
                    this.d = motionEvent.getRawY();
                    this.e = motionEvent.getX();
                    this.f = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        this.e = motionEvent.getX();
                        this.f = motionEvent.getY();
                    }
                } else if (Math.abs(this.e - this.f4546a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f) {
                    BeiZiNewRewardVideoActivity.this.a(String.valueOf(this.f4546a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f4546a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), 0);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        double d = i2;
        double d2 = i;
        if (d >= 0.25d * d2 && !this.at) {
            this.at = true;
            c(25);
        }
        if (d >= 0.5d * d2 && !this.au) {
            this.au = true;
            c(50);
        }
        if (d < d2 * 0.75d || this.av) {
            return;
        }
        this.av = true;
        c(75);
    }

    private void a(FrameLayout frameLayout) {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutA = t.a(this, this.b.k());
            frameLayoutA.setVisibility(0);
            linearLayout.addView(frameLayoutA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewB = t.b(this, this.b.j());
            viewB.setVisibility(0);
            linearLayout.addView(viewB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewB.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewB.setLayoutParams(layoutParams);
            if (frameLayout != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                layoutParams2.setMargins(0, 0, t.a(this, 12.0f), t.a(this, 30.0f));
                frameLayout.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(TextView textView, c.q qVar) {
        if (textView == null || qVar == null) {
            return;
        }
        try {
            String strB = qVar.b();
            if (this.ao) {
                strB = qVar.c();
            }
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            textView.setText(strB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
