package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import com.beizi.ad.a.a.a;
import com.beizi.ad.a.a.b;
import com.beizi.ad.a.a.c;
import com.beizi.ad.a.a.d;
import com.beizi.ad.a.a.e;
import com.beizi.ad.a.a.f;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.i;
import com.beizi.ad.internal.e.s;
import com.beizi.ad.internal.e.t;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.ad.internal.view.a.a;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BeiZiNewInterstitialActivity extends Activity {
    private boolean B;
    private MediaPlayer C;
    private int E;
    private boolean F;
    private int G;
    private CountDownTimer H;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private AdSpacesBean.BuyerBean O;
    private c P;
    private e Q;
    private d R;
    private a S;
    private b T;
    private Timer V;
    private TimerTask W;
    private boolean X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.beizi.ad.v2.c.b f4523a;
    private com.beizi.ad.internal.d.a b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private RelativeLayout k;
    private RelativeLayout l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RelativeLayout o;
    private RelativeLayout p;
    private FrameLayout q;
    private CustomRoundImageView r;
    private CustomRoundImageView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private VideoView w;
    private View x;
    private View y;
    private boolean z = false;
    private boolean A = false;
    private boolean D = false;
    private boolean I = true;
    private boolean U = true;

    private void A() {
        try {
            if (this.w != null && this.B) {
                if (this.n.getVisibility() == 0) {
                    this.E = 0;
                } else {
                    this.E = this.w.getCurrentPosition();
                }
                this.w.pause();
            }
            e eVar = this.Q;
            if (eVar != null) {
                eVar.b();
            }
            a aVar = this.S;
            if (aVar != null) {
                aVar.b();
            }
            CountDownTimer countDownTimer = this.H;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.H = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void x() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (scrollClick = buyerBean.getScrollClick()) == null) {
                return;
            }
            d dVar = new d(this, scrollClick, this.O.getSpaceId(), this.N);
            this.R = dVar;
            if (this.z) {
                dVar.a(this.p);
            } else {
                dVar.a(this.o);
            }
            this.R.a(this.k, new d.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.8
                @Override // com.beizi.ad.a.a.d.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleScrollViewContent scroll");
                    BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 1);
                }

                @Override // com.beizi.ad.a.a.d.a
                public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    if (BeiZiNewInterstitialActivity.this.T == null || !BeiZiNewInterstitialActivity.this.T.a()) {
                        return;
                    }
                    m.a("BeiZisAd", "handleScrollViewContent scroll click");
                    BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void y() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.O == null || com.beizi.fusion.c.b.a().o() || (eulerAngleRule = this.O.getEulerAngleRule()) == null) {
                return;
            }
            a aVar = new a(this, eulerAngleRule, this.O.getSpaceId(), this.N);
            this.S = aVar;
            if (this.z) {
                aVar.a(this.p);
            } else {
                aVar.a(this.o);
            }
            this.S.a(new a.InterfaceC0113a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.9
                @Override // com.beizi.ad.a.a.a.InterfaceC0113a
                public void a() {
                    m.a("BeiZisAd", "handleEulerAngleViewContent click");
                    BeiZiNewInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void z() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            b bVar = new b(this, fullScreenClick, this.N);
            this.T = bVar;
            bVar.a(this.k, new b.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.10
                @Override // com.beizi.ad.a.a.b.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleFullScreenClickContent click");
                    BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_interstitial);
            b();
            c();
            d();
            i();
            k();
            h();
            m();
            f();
            l();
            p();
            s();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            c cVar = this.P;
            if (cVar != null) {
                cVar.b();
            }
            this.P = null;
            e eVar = this.Q;
            if (eVar != null) {
                eVar.d();
            }
            this.Q = null;
            a aVar = this.S;
            if (aVar != null) {
                aVar.d();
            }
            this.S = null;
            d dVar = this.R;
            if (dVar != null) {
                dVar.a();
            }
            this.R = null;
            b bVar = this.T;
            if (bVar != null) {
                bVar.b();
            }
            this.T = null;
            Timer timer = this.V;
            if (timer != null) {
                timer.cancel();
            }
            this.V = null;
            TimerTask timerTask = this.W;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.W = null;
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
        A();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        t();
    }

    private void c() {
        try {
            com.beizi.ad.v2.c.b bVar = com.beizi.ad.v2.c.b.G;
            this.f4523a = bVar;
            this.O = bVar.a();
            this.X = this.f4523a.j();
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.z = true;
            } else {
                this.z = false;
            }
            com.beizi.ad.internal.d.a aVarM = this.f4523a.m();
            this.b = aVarM;
            if (aVarM == null) {
                return;
            }
            this.N = aVarM.c();
            boolean zY = this.b.y();
            this.B = zY;
            if (zY) {
                this.M = this.b.x();
            } else {
                this.M = this.b.w();
            }
            this.J = this.b.z();
            this.F = this.b.f();
            this.G = this.b.h();
            this.K = this.b.u();
            this.L = this.b.v();
            this.A = this.b.e() ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams;
        double d;
        double d2;
        RelativeLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        try {
            int iA = t.a(this, 10.0f);
            com.beizi.ad.internal.e.m.a(this.c, "#FFFFFF", 0, (String) null, iA);
            int iA2 = t.a(this, 49.0f);
            int iA3 = t.a(this, 19.0f);
            int iA4 = t.a(this, 8.0f);
            int iA5 = t.a(this, 52.0f);
            TextView textView = this.f;
            if (textView != null) {
                com.beizi.ad.internal.e.m.a(textView, "#66303030", 0, (String) null, iA);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams4.width = iA2;
                layoutParams4.height = iA3;
                layoutParams4.setMargins(iA4, iA4, 0, 0);
                layoutParams4.addRule(17);
                this.f.setLayoutParams(layoutParams4);
            }
            ImageView imageView = this.t;
            if (imageView != null && this.B) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.width = iA3;
                layoutParams5.height = iA3;
                layoutParams5.setMargins(0, iA4, iA, 0);
                this.t.setLayoutParams(layoutParams5);
            }
            LinearLayout linearLayout = this.d;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams6.width = iA5;
                layoutParams6.height = iA3;
                layoutParams6.setMargins(0, iA4, iA4, 0);
                this.d.setLayoutParams(layoutParams6);
                com.beizi.ad.internal.e.m.a(this.d, "#66303030", 0, (String) null, iA);
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = iA3;
                layoutParams7.height = iA3;
                this.g.setLayoutParams(layoutParams7);
                com.beizi.ad.internal.e.m.a(this.g, "#66303030", 0, (String) null, iA * 2);
            }
            ImageView imageView2 = this.u;
            if (imageView2 != null) {
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams8.width = iA3;
                layoutParams8.height = iA3;
                layoutParams8.setMargins(0, iA4, iA4, 0);
                this.u.setLayoutParams(layoutParams8);
            }
            int iF = q.f(this);
            int iG = q.g(this);
            double d3 = iF;
            int i = (int) (0.65d * d3);
            int iA6 = t.a(this, 5.0f);
            if (this.z) {
                i = (int) (d3 * 0.85d);
                iA6 = t.a(this, 10.0f);
                this.p.setVisibility(0);
                RelativeLayout relativeLayout = this.p;
                if (relativeLayout != null && (layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams()) != null) {
                    layoutParams3.width = i - (iA6 * 3);
                    layoutParams3.height = -2;
                    if (!TextUtils.isEmpty(this.J) && TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L)) {
                        layoutParams3.setMargins(0, iA6, 0, t.a(this, 5.0f));
                    } else {
                        layoutParams3.setMargins(0, (int) (((double) iA6) * 1.5d), 0, t.a(this, 5.0f));
                    }
                    this.p.setLayoutParams(layoutParams3);
                }
            } else {
                this.o.setVisibility(0);
                RelativeLayout relativeLayout2 = this.o;
                if (relativeLayout2 != null && (layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams()) != null) {
                    layoutParams.width = i;
                    layoutParams.height = -2;
                    layoutParams.setMargins(0, iA6 * 3, 0, 0);
                    this.o.setLayoutParams(layoutParams);
                }
            }
            LinearLayout linearLayout2 = this.c;
            if (linearLayout2 != null && (layoutParams2 = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams()) != null) {
                layoutParams2.width = i;
                layoutParams2.height = -2;
                this.c.setLayoutParams(layoutParams2);
                this.c.setPadding(iA6, iA6, iA6, iA6);
            }
            RelativeLayout relativeLayout3 = this.m;
            if (relativeLayout3 != null) {
                int i2 = i - (iA6 * 2);
                if (this.z) {
                    d = i2;
                    d2 = 0.56d;
                } else {
                    d = i2;
                    d2 = 1.78d;
                }
                int i3 = (int) (d * d2);
                double d4 = iG;
                if (i3 > 0.7d * d4) {
                    i3 = (int) (d4 * 0.5d);
                }
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) relativeLayout3.getLayoutParams();
                if (layoutParams9 != null) {
                    layoutParams9.width = i2;
                    layoutParams9.height = i3;
                    this.m.setLayoutParams(layoutParams9);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean e() {
        if (this.B) {
            return true;
        }
        return this.F && this.G > 0;
    }

    private void f() {
        try {
            if (!e()) {
                this.d.setVisibility(8);
                this.u.setVisibility(0);
            } else {
                this.d.setVisibility(0);
                this.u.setVisibility(8);
                this.d.measure(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            this.H = null;
            int i = this.G;
            TextView textView = this.g;
            if (textView != null) {
                try {
                    String string = textView.getText().toString();
                    if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                        i = Integer.parseInt(string);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.g.setText(String.valueOf(i));
            }
            CountDownTimer countDownTimer = new CountDownTimer(i * 1000, 1000L) { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    try {
                        m.a("BeiZisAd", "onFinish");
                        if (!BeiZiNewInterstitialActivity.this.F || BeiZiNewInterstitialActivity.this.G <= 0) {
                            return;
                        }
                        BeiZiNewInterstitialActivity.this.q();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    try {
                        int i2 = (int) ((j / 1000) + 1);
                        if (BeiZiNewInterstitialActivity.this.g != null) {
                            BeiZiNewInterstitialActivity.this.g.setText(String.valueOf(i2));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            };
            this.H = countDownTimer;
            countDownTimer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        try {
            if (!this.B && this.r != null && !TextUtils.isEmpty(this.M)) {
                this.r.setVisibility(0);
                h.a((Context) null).a(this.M, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.12
                    @Override // com.beizi.ad.internal.e.h.a
                    public void a(Bitmap bitmap) {
                        try {
                            if (BeiZiNewInterstitialActivity.this.r != null) {
                                if (BeiZiNewInterstitialActivity.this.m != null) {
                                    BeiZiNewInterstitialActivity.this.m.measure(0, 0);
                                    ViewGroup.LayoutParams layoutParams = BeiZiNewInterstitialActivity.this.r.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.width = BeiZiNewInterstitialActivity.this.m.getMeasuredWidth();
                                        layoutParams.height = BeiZiNewInterstitialActivity.this.m.getMeasuredHeight();
                                        BeiZiNewInterstitialActivity.this.r.setLayoutParams(layoutParams);
                                    }
                                }
                                BeiZiNewInterstitialActivity.this.r.setRectRadius(t.a(BeiZiNewInterstitialActivity.this, 6.0f));
                                BeiZiNewInterstitialActivity.this.r.setBackground(new BitmapDrawable(i.a(BeiZiNewInterstitialActivity.this, bitmap, 20.0f)));
                                BeiZiNewInterstitialActivity.this.r.setImageBitmap(bitmap);
                                BeiZiNewInterstitialActivity.this.o();
                                BeiZiNewInterstitialActivity.this.u();
                                BeiZiNewInterstitialActivity.this.r();
                                if (!BeiZiNewInterstitialActivity.this.F || BeiZiNewInterstitialActivity.this.G <= 0) {
                                    return;
                                }
                                BeiZiNewInterstitialActivity.this.g();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.beizi.ad.internal.e.h.a
                    public void a() {
                        BeiZiNewInterstitialActivity.this.finish();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        AdSpacesBean.ComplainBean complain;
        TextView textView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null || (complain = buyerBean.getComplain()) == null || complain.getOpen() != 1 || (textView = this.f) == null) {
                return;
            }
            textView.setVisibility(0);
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BeiZiNewInterstitialActivity.this.j();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            A();
            a.C0120a c0120a = new a.C0120a(this);
            c0120a.a(new a.b() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.14
                @Override // com.beizi.ad.internal.view.a.a.b
                public void a(String str) {
                    try {
                        if (BeiZiNewInterstitialActivity.this.f4523a == null) {
                            return;
                        }
                        BeiZiNewInterstitialActivity.this.f4523a.f(str);
                        BeiZiNewInterstitialActivity.this.f4523a.v();
                        BeiZiNewInterstitialActivity.this.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.beizi.ad.internal.view.a.a.b
                public void a() {
                    BeiZiNewInterstitialActivity.this.t();
                }
            });
            c0120a.a().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        try {
            if (this.b == null) {
                return;
            }
            if (TextUtils.isEmpty(this.J)) {
                View view = this.x;
                if (view != null) {
                    view.setVisibility(8);
                }
                CustomRoundImageView customRoundImageView = this.s;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(8);
                    return;
                }
                return;
            }
            int iA = t.a(this, 20.0f);
            CustomRoundImageView customRoundImageView2 = this.s;
            if (customRoundImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customRoundImageView2.getLayoutParams();
                int i = iA * 2;
                layoutParams.width = i;
                layoutParams.height = i;
                this.s.setLayoutParams(layoutParams);
                this.s.setVisibility(0);
            }
            View view2 = this.x;
            if (view2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = iA;
                this.x.setLayoutParams(layoutParams2);
                this.x.setVisibility(0);
            }
            h.a((Context) null).a(this.J, new h.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.15
                @Override // com.beizi.ad.internal.e.h.a
                public void a() {
                }

                @Override // com.beizi.ad.internal.e.h.a
                public void a(Bitmap bitmap) {
                    try {
                        if (BeiZiNewInterstitialActivity.this.s != null) {
                            BeiZiNewInterstitialActivity.this.s.setImageBitmap(bitmap);
                        }
                        BeiZiNewInterstitialActivity.this.s.setRectRadius(t.a(BeiZiNewInterstitialActivity.this, 6.0f));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
            if (this.i != null) {
                if (TextUtils.isEmpty(this.K)) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                    this.i.setText(this.K);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                    if (layoutParams != null) {
                        if (TextUtils.isEmpty(this.L)) {
                            layoutParams.setMargins(0, t.a(this, 13.0f), 0, 0);
                        } else {
                            layoutParams.setMargins(0, t.a(this, 10.0f), 0, 0);
                        }
                        this.i.setLayoutParams(layoutParams);
                    }
                    this.i.setPadding(0, 0, 0, 0);
                }
            }
            if (this.j != null) {
                if (TextUtils.isEmpty(this.L)) {
                    this.j.setVisibility(8);
                } else {
                    this.j.setVisibility(0);
                    this.j.setText(this.L);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                    if (TextUtils.isEmpty(this.K)) {
                        layoutParams2.setMargins(0, t.a(this, 13.0f), 0, 0);
                    } else {
                        layoutParams2.setMargins(0, t.a(this, 8.0f), 0, 0);
                    }
                    if (layoutParams2 != null) {
                        this.j.setLayoutParams(layoutParams2);
                    }
                    this.j.setPadding(0, 0, 0, 0);
                }
            }
            if (this.z) {
                View view = this.y;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.y != null) {
                if (TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L) && TextUtils.isEmpty(this.J)) {
                    this.y.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
                layoutParams3.width = -2;
                if (TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.L) && !TextUtils.isEmpty(this.J)) {
                    layoutParams3.height = t.a(this, 5.0f);
                } else {
                    layoutParams3.height = t.a(this, 10.0f);
                }
                this.y.setLayoutParams(layoutParams3);
                this.y.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m() {
        try {
            if (this.B && this.w != null && !TextUtils.isEmpty(this.M)) {
                RelativeLayout relativeLayout = this.m;
                if (relativeLayout != null) {
                    com.beizi.ad.internal.e.m.a(relativeLayout, "#000000", 0, (String) null, t.a(this, 6.0f));
                }
                ImageView imageView = this.t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.A) {
                        this.t.setImageResource(R.drawable.beizi_voice_on);
                    } else {
                        this.t.setImageResource(R.drawable.beizi_voice_off);
                    }
                }
                RelativeLayout relativeLayout2 = this.n;
                if (relativeLayout2 != null) {
                    com.beizi.ad.internal.e.m.a(relativeLayout2, "#66303030", 0, (String) null, t.a(this, 6.0f));
                    this.n.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (BeiZiNewInterstitialActivity.this.n != null) {
                                    BeiZiNewInterstitialActivity.this.n.setVisibility(8);
                                }
                                if (BeiZiNewInterstitialActivity.this.w != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiNewInterstitialActivity.this.C.seekTo(0L, 3);
                                    }
                                    BeiZiNewInterstitialActivity.this.w.start();
                                }
                                int duration = BeiZiNewInterstitialActivity.this.C.getDuration() / 1000;
                                if (BeiZiNewInterstitialActivity.this.g != null) {
                                    BeiZiNewInterstitialActivity.this.g.setText(String.valueOf(duration));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                if (this.v != null) {
                    int iA = t.a(this, 54.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
                    layoutParams.width = iA;
                    layoutParams.height = iA;
                    this.v.setLayoutParams(layoutParams);
                }
                this.w.setVisibility(0);
                s.a().a(this, this.M, new s.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.17
                    @Override // com.beizi.ad.internal.e.s.a
                    public void a(String str) {
                        try {
                            m.a("BeiZisAd", "onVideoLoaded: 加载成功");
                            BeiZiNewInterstitialActivity.this.w.setVideoPath(str);
                            BeiZiNewInterstitialActivity.this.w.requestFocus();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.beizi.ad.internal.e.s.a
                    public void a() {
                        BeiZiNewInterstitialActivity.this.finish();
                    }
                });
                this.w.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.18
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        m.a("BeiZisAd", "onCompletion: 播放完成");
                        try {
                            BeiZiNewInterstitialActivity.this.E = 0;
                            if (BeiZiNewInterstitialActivity.this.n != null) {
                                BeiZiNewInterstitialActivity.this.n.setVisibility(0);
                            }
                            if (!BeiZiNewInterstitialActivity.this.F || BeiZiNewInterstitialActivity.this.G <= 0) {
                                if (BeiZiNewInterstitialActivity.this.F) {
                                    BeiZiNewInterstitialActivity.this.q();
                                } else if (BeiZiNewInterstitialActivity.this.g != null) {
                                    BeiZiNewInterstitialActivity.this.g.setText("0");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.w.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.19
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            BeiZiNewInterstitialActivity.this.C = mediaPlayer;
                            m.a("BeiZisAd", "onPrepared: 准备完成");
                            if (BeiZiNewInterstitialActivity.this.A) {
                                BeiZiNewInterstitialActivity.this.C.setVolume(0.0f, 1.0f);
                            } else {
                                BeiZiNewInterstitialActivity.this.C.setVolume(0.0f, 0.0f);
                            }
                            if (BeiZiNewInterstitialActivity.this.w != null) {
                                if (BeiZiNewInterstitialActivity.this.E > 0) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        BeiZiNewInterstitialActivity.this.C.seekTo(BeiZiNewInterstitialActivity.this.E, 3);
                                    }
                                } else if (Build.VERSION.SDK_INT >= 26) {
                                    BeiZiNewInterstitialActivity.this.C.seekTo(2L, 3);
                                }
                                if (BeiZiNewInterstitialActivity.this.n != null && BeiZiNewInterstitialActivity.this.n.getVisibility() == 8) {
                                    BeiZiNewInterstitialActivity.this.w.start();
                                }
                            }
                            if (BeiZiNewInterstitialActivity.this.U) {
                                if (!BeiZiNewInterstitialActivity.this.F || BeiZiNewInterstitialActivity.this.G <= 0) {
                                    int duration = mediaPlayer.getDuration() / 1000;
                                    if (BeiZiNewInterstitialActivity.this.g != null) {
                                        BeiZiNewInterstitialActivity.this.g.setText(String.valueOf(duration));
                                    }
                                }
                                BeiZiNewInterstitialActivity.this.n();
                                BeiZiNewInterstitialActivity.this.o();
                                BeiZiNewInterstitialActivity.this.u();
                                BeiZiNewInterstitialActivity.this.r();
                            }
                            BeiZiNewInterstitialActivity.this.U = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.w.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.2
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        return false;
                    }
                });
                if (!this.F || this.G <= 0) {
                    a();
                } else {
                    g();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (this.w == null) {
                return;
            }
            int width = this.m.getWidth();
            int height = this.m.getHeight();
            this.w.measure(0, 0);
            int measuredWidth = this.w.getMeasuredWidth();
            int measuredHeight = this.w.getMeasuredHeight();
            float f = (float) ((((double) measuredWidth) * 1.0d) / ((double) measuredHeight));
            ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
            int i = -2;
            int i2 = -1;
            if (measuredWidth >= width || (measuredHeight <= height && width - measuredWidth <= height - measuredHeight)) {
                i = -1;
                i2 = -2;
            }
            if (layoutParams != null) {
                layoutParams.width = i;
                layoutParams.height = i2;
                this.w.setLayoutParams(layoutParams);
            }
            if (Math.abs((this.z ? 1.78f : 0.56f) - f) < 0.0f || Math.abs(r0) > 0.15d) {
                return;
            }
            this.w.setOutlineProvider(new f(t.a(this, 6.0f)));
            this.w.setClipToOutline(true);
            RelativeLayout relativeLayout = this.m;
            if (relativeLayout != null) {
                com.beizi.ad.internal.e.m.a(relativeLayout, "#FFFFFF", 0, (String) null, t.a(this, 6.0f));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
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
            if (this.q != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int iA = t.a(this, 8.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                this.q.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void p() {
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        BeiZiNewInterstitialActivity.this.q();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (BeiZiNewInterstitialActivity.this.A) {
                            BeiZiNewInterstitialActivity.this.t.setImageResource(R.drawable.beizi_voice_off);
                            if (BeiZiNewInterstitialActivity.this.C != null) {
                                BeiZiNewInterstitialActivity.this.C.setVolume(0.0f, 0.0f);
                            }
                        } else {
                            BeiZiNewInterstitialActivity.this.t.setImageResource(R.drawable.beizi_voice_on);
                            if (BeiZiNewInterstitialActivity.this.C != null) {
                                BeiZiNewInterstitialActivity.this.C.setVolume(0.0f, 1.0f);
                            }
                        }
                        BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                        beiZiNewInterstitialActivity.A = !beiZiNewInterstitialActivity.A;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        CountDownTimer countDownTimer = this.H;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.H = null;
        }
        com.beizi.ad.v2.c.b bVar = this.f4523a;
        if (bVar != null) {
            bVar.v();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.beizi.ad.internal.d.a aVarM;
        try {
            com.beizi.ad.v2.c.b bVar = this.f4523a;
            if (bVar == null || (aVarM = bVar.m()) == null) {
                return;
            }
            aVarM.a(this.c, this.f4523a.e());
            this.f4523a.u();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void s() {
        try {
            com.beizi.ad.internal.d.a aVar = this.b;
            if (aVar == null) {
                return;
            }
            int iT = aVar.t();
            if (iT == 2 || iT == 5) {
                this.h.setVisibility(0);
                final String strL = this.b.l();
                String strO = this.b.o();
                String strN = this.b.n();
                String strQ = this.b.q();
                final String strP = !TextUtils.isEmpty(strQ) ? strQ : this.b.p();
                final String strR = this.b.r();
                final String strS = this.b.s();
                this.h.setText(Html.fromHtml("应用名称：" + strL + " | 开发者：" + strO + " | 应用版本：" + strN + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(BeiZiNewInterstitialActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                            intent.putExtra("title_content_key", strL);
                            intent.putExtra("privacy_content_key", strR);
                            intent.putExtra("permission_content_key", strP);
                            intent.putExtra("intro_content_key", strS);
                            intent.setFlags(268435456);
                            BeiZiNewInterstitialActivity.this.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            VideoView videoView = this.w;
            if (videoView != null && this.B) {
                videoView.resume();
            }
            e eVar = this.Q;
            if (eVar != null) {
                eVar.a();
            }
            com.beizi.ad.a.a.a aVar = this.S;
            if (aVar != null) {
                aVar.a();
            }
            if (!this.I && this.F && this.G > 0) {
                g();
            }
            this.I = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (this.O == null) {
                return;
            }
            z();
            v();
            w();
            x();
            y();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void v() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.O;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            c cVar = new c(this, regionalClickView, this.N, this.X);
            this.P = cVar;
            if (this.z) {
                cVar.a(this.p);
            } else {
                cVar.a(this.o);
            }
            this.P.a(new c.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.6
                @Override // com.beizi.ad.a.a.c.a
                public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                    m.a("BeiZisAd", "handleRegionalClickViewContent click");
                    BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void w() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.O == null || com.beizi.fusion.c.b.a().o() || (shakeView = this.O.getShakeView()) == null) {
                return;
            }
            e eVar = new e(this, shakeView, this.O.getSpaceId(), this.N);
            this.Q = eVar;
            if (this.z) {
                eVar.a(this.p);
            } else {
                eVar.a(this.o);
            }
            this.Q.a(new e.a() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.7
                @Override // com.beizi.ad.a.a.e.a
                public void a() {
                    m.a("BeiZisAd", "handleShakeViewContent click");
                    BeiZiNewInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        this.k = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_content_rl);
        this.c = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_container_ll);
        this.f = (TextView) findViewById(R.id.beizi_interstitial_ad_complain_tv);
        this.l = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_close_container_rl);
        this.d = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_close_text_container_ll);
        this.u = (ImageView) findViewById(R.id.beizi_interstitial_ad_close_iv);
        this.g = (TextView) findViewById(R.id.beizi_interstitial_ad_countdown_tv);
        this.m = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_material_container_rl);
        this.n = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_video_replay_container_rl);
        this.v = (ImageView) findViewById(R.id.beizi_interstitial_ad_video_replay_iv);
        this.q = (FrameLayout) findViewById(R.id.beizi_interstitial_ad_logo_container_fl);
        this.r = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_img_iv);
        this.w = (VideoView) findViewById(R.id.beizi_interstitial_ad_video_vv);
        this.s = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_app_icon_iv);
        this.x = findViewById(R.id.beizi_interstitial_ad_divide_view);
        this.t = (ImageView) findViewById(R.id.beizi_interstitial_ad_voice_iv);
        this.e = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_title_container_ll);
        this.i = (TextView) findViewById(R.id.beizi_interstitial_ad_title_tv);
        this.j = (TextView) findViewById(R.id.beizi_interstitial_ad_subtitle_tv);
        this.y = findViewById(R.id.beizi_interstitial_ad_title_divider_view);
        this.p = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_landscape_rl);
        this.o = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_portrait_rl);
        this.h = (TextView) findViewById(R.id.beizi_interstitial_ad_app_download_info_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.beizi.ad.internal.d.a aVarM;
        try {
            if (this.f4523a == null || !hasWindowFocus() || (aVarM = this.f4523a.m()) == null) {
                return;
            }
            String strE = this.f4523a.e();
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
            aVarM.a(this.c, dVar, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.D, strE, i);
            this.D = true;
            this.f4523a.w();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        try {
            if (this.V == null) {
                this.V = new Timer();
            }
            if (this.W == null) {
                this.W = new TimerTask() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.11
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            if (BeiZiNewInterstitialActivity.this.w == null || !BeiZiNewInterstitialActivity.this.w.isPlaying()) {
                                return;
                            }
                            BeiZiNewInterstitialActivity.this.runOnUiThread(new Runnable() { // from class: com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int duration;
                                    try {
                                        if (BeiZiNewInterstitialActivity.this.g == null || (duration = (BeiZiNewInterstitialActivity.this.w.getDuration() - BeiZiNewInterstitialActivity.this.w.getCurrentPosition()) / 1000) <= 0) {
                                            return;
                                        }
                                        BeiZiNewInterstitialActivity.this.g.setText(String.valueOf(duration));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            this.V.scheduleAtFixedRate(this.W, 0L, 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
