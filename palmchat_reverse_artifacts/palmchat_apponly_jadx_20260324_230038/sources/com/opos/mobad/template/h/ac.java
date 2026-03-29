package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ac extends com.opos.mobad.template.j.b {
    private com.opos.mobad.d.e.a A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9932a;
    private int b;
    private int c;
    private int g;
    private Context h;
    private com.opos.mobad.d.a i;
    private boolean j;
    private Handler k;
    private com.opos.mobad.template.d.f l;
    private com.opos.mobad.template.d.c m;
    private int n;
    private long o;
    private com.opos.mobad.template.cmn.baseview.c p;
    private z q;
    private u r;
    private ImageView s;
    private n t;
    private com.opos.mobad.template.cmn.w u;
    private com.opos.mobad.template.k.c v;
    private RelativeLayout w;
    private Drawable x;
    private Runnable y;
    private b z;

    private ac(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, boolean z) {
        super(i);
        this.j = true;
        this.n = 0;
        this.y = new Runnable() { // from class: com.opos.mobad.template.h.ac.1
            @Override // java.lang.Runnable
            public void run() {
                if (ac.this.n() == 8) {
                    return;
                }
                long j = ac.this.n;
                long j2 = ac.this.o;
                ac acVar = ac.this;
                if (j > j2) {
                    acVar.z.a(ac.this.n, ac.this.o);
                    return;
                }
                acVar.c(acVar.n, ac.this.o);
                ac.this.l.f("看" + (((int) (ac.this.o - ((long) ac.this.n))) / 1000) + "s立即获得奖励");
                ac acVar2 = ac.this;
                acVar2.n = acVar2.n + 1000;
                ac.this.k.postDelayed(this, 1000L);
            }
        };
        this.z = new b() { // from class: com.opos.mobad.template.h.ac.4
            @Override // com.opos.mobad.template.h.b
            public void a() {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(long j, long j2) {
                ac.this.b(j, j2);
                if (ac.this.n() != 8) {
                    ac.this.k.removeCallbacks(ac.this.y);
                    ac.this.k.post(ac.this.y);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(int i2) {
                ac.this.b(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(long j, long j2) {
                if (j == 0) {
                    ac.this.k.removeCallbacks(ac.this.y);
                    ac.this.k.postDelayed(ac.this.y, 10L);
                    ac.this.c(0L, r3.n);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void e(View view, int[] iArr) {
                ac.this.a(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f() {
                ac.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.template.h.ac.4.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        ac.this.w();
                        ac.this.v();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void g(View view, int[] iArr) {
                ac.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void h(View view, int[] iArr) {
                ac.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void l(View view, int[] iArr) {
                ac.this.k(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2) {
                ac.this.a(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                ac.this.e(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(long j, long j2) {
                ac.this.a(j, j2);
                if (ac.this.n() != 8) {
                    ac.this.k.removeCallbacks(ac.this.y);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2, int[] iArr) {
                ac.this.a(i2, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(Map<String, String> map) {
                if (ac.this.n() != 8) {
                    ac.this.k.removeCallbacks(ac.this.y);
                }
                ac.this.c(map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                ac.this.d(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(long j, long j2) {
                ac.this.o();
                ac.this.k.removeCallbacks(ac.this.y);
                ac.this.x();
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int i2, boolean z2) {
                ac.this.a(view, i2, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr) {
                ac.this.j(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr, boolean z2) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(a.b bVar, Map<String, String> map) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(Map<String, String> map) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void j(View view, int[] iArr) {
            }
        };
        this.h = context;
        this.k = new Handler(Looper.getMainLooper());
        this.i = aVar2;
        this.j = z;
        this.c = com.opos.cmn.an.h.f.a.b(this.h);
        this.g = com.opos.cmn.an.h.f.a.c(this.h);
        p();
        a(z);
        q();
    }

    private void p() {
        com.opos.mobad.template.d.f fVar = new com.opos.mobad.template.d.f();
        this.l = fVar;
        fVar.g("emptyurl", "");
        this.l.a(30000L, 500L);
        this.l.d(2);
        this.x = this.h.getDrawable(R.drawable.opos_mobad_feedback_logo);
    }

    private void q() {
        this.p = new com.opos.mobad.template.cmn.baseview.c(this.h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.p.setId(View.generateViewId());
        this.p.setBackgroundColor(Color.parseColor("#000000"));
        this.p.setLayoutParams(layoutParams);
        this.p.setVisibility(8);
        r();
        s();
        t();
        u();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.ac.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ac.this.h(view, iArr);
            }
        };
        this.p.setOnClickListener(pVar);
        this.p.setOnTouchListener(pVar);
        this.p.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.ac.3
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("RewardVideoFallbackTemplate", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                ac.this.a(view, i, z);
            }
        });
        if (Build.VERSION.SDK_INT >= 29) {
            this.p.setForceDarkAllowed(false);
        }
    }

    private void r() {
        ImageView imageView;
        Context context;
        int i;
        this.s = new ImageView(this.h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.s.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.addView(this.s, layoutParams);
        if (this.j) {
            imageView = this.s;
            context = this.h;
            i = R.drawable.opos_mobad_feed_bg_portrait;
        } else {
            imageView = this.s;
            context = this.h;
            i = R.drawable.opos_mobad_feed_bg_landscape;
        }
        imageView.setImageDrawable(context.getDrawable(i));
    }

    private void s() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.h);
        int iA = com.opos.cmn.an.h.f.a.a(this.h, 28.0f);
        LinearLayout linearLayout = new LinearLayout(this.h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.h, 12.0f);
        layoutParams.weight = 1.0f;
        bVar.addView(linearLayout, layoutParams);
        u uVarA = u.a(this.h);
        this.r = uVarA;
        uVarA.setId(View.generateViewId());
        linearLayout.addView(this.r, new LinearLayout.LayoutParams(-2, iA));
        z zVarA = z.a(this.h);
        this.q = zVarA;
        zVarA.c();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        layoutParams2.rightMargin = this.b;
        bVar.addView(this.q, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f9932a;
        this.p.addView(bVar, layoutParams3);
    }

    private void t() {
        RelativeLayout.LayoutParams layoutParams;
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.h);
        this.u = wVar;
        wVar.setId(View.generateViewId());
        this.u.a(90.0f);
        n nVarA = n.a(this.h, "", true);
        this.t = nVarA;
        nVarA.setGravity(17);
        this.t.setLines(1);
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setTextSize(1, 16.0f);
        this.t.setTextColor(-1);
        if (this.j) {
            layoutParams = new RelativeLayout.LayoutParams((this.c * 312) / 360, (this.g * 44) / 800);
            layoutParams.topMargin = (this.g * 724) / 800;
            layoutParams.addRule(14);
        } else {
            layoutParams = new RelativeLayout.LayoutParams((this.c * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL) / 360, (this.g * 44) / 800);
            layoutParams.topMargin = (this.c * MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR) / 360;
            layoutParams.leftMargin = (this.g * MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI) / 800;
        }
        this.t.setText("立即前往");
        this.u.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
        this.u.setBackgroundColor(ColorUtils.setAlphaComponent(this.h.getResources().getColor(R.color.opos_mobad_feedback_rewardvideo_button_background_color_blue), 255));
        this.p.addView(this.u, layoutParams);
    }

    private void u() {
        int i;
        this.w = new RelativeLayout(this.h);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1975368116);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.h, 4.0f));
        this.w.setBackground(gradientDrawable);
        this.v = com.opos.mobad.template.k.c.a(this.h, 0, 0, this.i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.h, 14.0f));
        if (this.j) {
            layoutParams.topMargin = (this.g * MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT) / 800;
            i = (this.c * 168) / 360;
        } else {
            layoutParams.topMargin = (this.c * 159) / 360;
            i = (this.g * 528) / 800;
        }
        layoutParams.leftMargin = i;
        this.w.addView(this.v);
        this.v.a(true, this.x);
        this.p.addView(this.w, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.A == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.h);
            this.A = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.ac.5
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (ac.this.m == null) {
                        return;
                    }
                    if (!z) {
                        ac.this.l();
                    } else {
                        ac.this.a((Map<String, String>) null);
                        ac.this.k();
                    }
                }
            });
        }
        if (this.p.indexOfChild(this.A) < 0) {
            this.p.addView(this.A, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.t.setVisibility(0);
        this.w.setVisibility(0);
        this.r.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.r.setVisibility(8);
        this.q.setVisibility(4);
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.p;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("RewardVideoFallbackTemplate", "do End");
        this.k.removeCallbacks(this.y);
        com.opos.mobad.template.cmn.baseview.c cVar = this.p;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    public static ac b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ac(context, i, aVar, aVar2, false);
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.cmn.an.f.a.b("RewardVideoFallbackTemplate", "start countdown...");
        this.k.removeCallbacks(this.y);
        this.k.postDelayed(this.y, 100L);
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        this.k.removeCallbacks(this.y);
        return true;
    }

    public static ac a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ac(context, i, aVar, aVar2, true);
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.q.a(this.z);
        this.r.a(this.z);
        this.t.a(this.z);
        this.v.a(this.z);
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        this.r.a(cVar.q, cVar.B);
        this.q.a(cVar.A);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.f fVar2 = this.l;
        if (fVar2 == null) {
            com.opos.cmn.an.f.a.a("RewardVideoFallbackTemplate", "data is null");
        } else {
            com.opos.mobad.template.d.c cVarB = fVar2.b();
            if (cVarB != null) {
                if (this.m == null && this.e != null) {
                    this.z.f();
                }
                this.m = cVarB;
                com.opos.mobad.template.cmn.baseview.c cVar = this.p;
                if (cVar != null && cVar.getVisibility() != 0) {
                    this.p.setVisibility(0);
                }
                com.opos.mobad.template.d.c cVar2 = this.m;
                long j = cVar2.v;
                this.o = j;
                if (j <= 0) {
                    this.o = 30000L;
                }
                a(cVar2);
                return;
            }
            com.opos.cmn.an.f.a.d("RewardVideoFallbackTemplate", "render with data null");
        }
        a(1);
    }

    private void a(boolean z) {
        Context context;
        float f = 16.0f;
        if (z) {
            this.f9932a = com.opos.cmn.an.h.f.a.a(this.h, 49.0f);
            context = this.h;
        } else {
            this.f9932a = com.opos.cmn.an.h.f.a.a(this.h, 16.0f);
            context = this.h;
            f = 24.0f;
        }
        this.b = com.opos.cmn.an.h.f.a.a(context, f);
    }
}
