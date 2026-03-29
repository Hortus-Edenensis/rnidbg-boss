package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.cmn.j;
import com.opos.mobad.template.h.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ag extends com.opos.mobad.template.j.b {
    private LinearLayout A;
    private TextView B;
    private com.opos.mobad.template.k.c C;
    private TextView D;
    private TextView E;
    private com.opos.mobad.template.cmn.w F;
    private com.opos.mobad.template.a.c G;
    private com.opos.mobad.template.cmn.w H;
    private com.opos.mobad.template.cmn.n I;
    private com.opos.mobad.template.cmn.w J;
    private TextView K;
    private TextView L;
    private TextView M;
    private int N;
    private Runnable O;
    private com.opos.mobad.d.e.a P;
    private b Q;
    private com.opos.mobad.template.cmn.baseview.f R;
    private com.opos.mobad.template.cmn.p S;
    private com.opos.mobad.template.cmn.q T;
    private j.b U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f9958a;
    private Context b;
    private com.opos.mobad.d.a c;
    private com.opos.mobad.template.cmn.baseview.c g;
    private ah h;
    private z i;
    private u j;
    private w k;
    private com.opos.mobad.template.cmn.baseview.c l;
    private com.opos.mobad.template.cmn.baseview.c m;
    private Handler n;
    private com.opos.mobad.template.d.c o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private LinearLayout v;
    private com.opos.mobad.template.cmn.w w;
    private LinearLayout x;
    private LinearLayout y;
    private com.opos.mobad.template.cmn.y z;

    private ag(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2, boolean z) {
        super(i);
        this.f9958a = null;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = 0;
        this.u = false;
        this.N = -1;
        this.O = new Runnable() { // from class: com.opos.mobad.template.h.ag.1
            @Override // java.lang.Runnable
            public void run() {
                if (ag.this.n() == 8) {
                    return;
                }
                long jF = ag.this.h.f();
                ag.this.c(jF, ag.this.h.g());
                ag.this.a(jF);
                ag agVar = ag.this;
                agVar.N = Math.max(agVar.N, ag.this.p());
                if (!ag.this.q() && ag.this.N > 5 && ag.this.N - 3 >= ag.this.p() && ag.this.H != null && ag.this.H.getVisibility() != 0) {
                    ag.this.H.setVisibility(0);
                }
                ag.f(ag.this);
                ag.this.n.postDelayed(this, 1000L);
            }
        };
        this.Q = new b() { // from class: com.opos.mobad.template.h.ag.9
            @Override // com.opos.mobad.template.h.b
            public void a() {
                if (ag.this.o == null) {
                    return;
                }
                ag agVar = ag.this;
                agVar.a(agVar.o, ag.this.h.b());
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(long j, long j2) {
                ag.this.b(j, j2);
                if (ag.this.n() != 8) {
                    ag.this.n.removeCallbacks(ag.this.O);
                    ag.this.n.post(ag.this.O);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(int i2) {
                ag.this.b(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(long j, long j2) {
                if (j == 0) {
                    ag.this.n.removeCallbacks(ag.this.O);
                    ag.this.n.postDelayed(ag.this.O, 10L);
                    ag.this.c(0L, r3.h.g());
                    ag.this.u();
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void e(View view, int[] iArr) {
                ag.this.a(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f() {
                ag.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.template.h.ag.9.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        ag.this.x();
                        ag.this.w();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void g(View view, int[] iArr) {
                ag.this.g(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void h(View view, int[] iArr) {
                ag.this.h(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void l(View view, int[] iArr) {
                ag.this.k(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2) {
                ag.this.a(i2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(View view, int[] iArr) {
                ag.this.e(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(long j, long j2) {
                ag.this.a(j, j2);
                if (ag.this.n() != 8) {
                    ag.this.n.removeCallbacks(ag.this.O);
                }
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void d(View view, int[] iArr) {
                ag.this.f(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void f(View view, int[] iArr) {
                ag.this.i(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int i2, int[] iArr) {
                ag.this.a(i2, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(Map<String, String> map) {
                if (ag.this.n() != 8) {
                    ag.this.n.removeCallbacks(ag.this.O);
                }
                ag.this.c(map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void c(View view, int[] iArr) {
                ag.this.d(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(long j, long j2) {
                ag.this.o();
                ag.this.n.removeCallbacks(ag.this.O);
                ag.this.v();
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void b(int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int i2, boolean z2) {
                ag.this.a(view, i2, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr) {
                ag.this.j(view, iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(View view, int[] iArr, boolean z2) {
                ag.this.a(view, iArr, z2);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(a.b bVar, Map<String, String> map) {
                ag.this.a(bVar, map);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(Map<String, String> map) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void a(int[] iArr) {
                ag.this.b(iArr);
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.template.a.InterfaceC0778a
            public void j(View view, int[] iArr) {
            }
        };
        this.R = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.ag.10
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z2) {
                com.opos.cmn.an.f.a.a("RewardVideoTopTemplate", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z2 + ";view:" + view.getClass().getName());
                ag.this.a(view, i2, z2);
            }
        };
        this.S = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.ag.11
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ag.this.h(view, iArr);
            }
        };
        this.T = new com.opos.mobad.template.cmn.q() { // from class: com.opos.mobad.template.h.ag.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                ag.this.g(view, iArr);
            }
        };
        this.U = new j.b() { // from class: com.opos.mobad.template.h.ag.3
            @Override // com.opos.mobad.template.cmn.j.b
            public boolean a() {
                return ag.this.n() == 8;
            }
        };
        this.b = context;
        this.n = new Handler(Looper.getMainLooper());
        this.c = aVar2;
        boolean zA = com.opos.mobad.d.c.b.a(this.b);
        this.s = zA;
        z = zA ? true : z;
        this.r = z;
        a(aVar, z);
    }

    public static /* synthetic */ int f(ag agVar) {
        int i = agVar.t;
        agVar.t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        com.opos.mobad.template.d.c cVar = this.o;
        if (cVar != null && cVar.J.containsKey("EXT_PARAM_KEY_COUNTDOWN")) {
            try {
                return Integer.parseInt(this.o.J.get("EXT_PARAM_KEY_COUNTDOWN"));
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }
        }
        return -1;
    }

    private void r() {
        this.m = new com.opos.mobad.template.cmn.baseview.c(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 280.0f));
        layoutParams.addRule(12);
        this.m.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.b, 30.0f));
        this.g.addView(this.m, layoutParams);
        this.m.setVisibility(8);
        com.opos.mobad.template.cmn.p.a(this.m, this.S);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{ColorUtils.setAlphaComponent(-16777216, 255), ColorUtils.setAlphaComponent(-16777216, 255), ColorUtils.setAlphaComponent(-16777216, 200), ColorUtils.setAlphaComponent(-16777216, 160), ColorUtils.setAlphaComponent(-16777216, 0)});
        gradientDrawable.setShape(0);
        this.m.setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.v = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        layoutParams2.leftMargin = iA;
        layoutParams2.rightMargin = iA;
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 84.0f);
        this.v.setGravity(80);
        this.m.addView(this.v, layoutParams2);
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        this.w = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 16.0f));
        this.w.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 140.0f));
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        this.w.setLayoutParams(layoutParams3);
        this.v.addView(this.w);
        LinearLayout linearLayout2 = new LinearLayout(this.b);
        this.x = linearLayout2;
        linearLayout2.setId(View.generateViewId());
        this.x.setOrientation(0);
        this.x.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        layoutParams4.topMargin = iA2;
        layoutParams4.leftMargin = iA2;
        layoutParams4.rightMargin = iA2;
        this.w.addView(this.x, layoutParams4);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.b, com.opos.cmn.an.h.f.a.a(r11, 12.0f));
        this.z = nVar;
        nVar.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 52.0f), com.opos.cmn.an.h.f.a.a(this.b, 52.0f)));
        this.z.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.b);
        wVar2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        wVar2.addView(this.z);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.b, 12.0f));
        this.x.addView(wVar2);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 14.0f));
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
        com.opos.mobad.template.k.c cVarA = com.opos.mobad.template.k.c.a(this.b, 2, 0, this.c);
        this.C = cVarA;
        cVarA.setLayoutParams(layoutParams5);
        this.A = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 52.0f));
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        this.A.setGravity(16);
        this.A.setLayoutParams(layoutParams6);
        this.A.setOrientation(1);
        this.x.addView(this.A);
        LinearLayout linearLayout3 = new LinearLayout(this.b);
        this.y = linearLayout3;
        linearLayout3.setGravity(16);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 16;
        this.y.setLayoutParams(layoutParams7);
        this.y.setOrientation(0);
        this.A.addView(this.y);
        TextView textView = new TextView(this.b);
        this.B = textView;
        com.opos.mobad.template.h.a(textView);
        this.B.setTextSize(1, 14.0f);
        this.B.setTextColor(Color.parseColor("#E6000000"));
        this.B.setLines(1);
        this.B.setSingleLine(true);
        this.B.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams8.gravity = 16;
        this.y.addView(this.B, layoutParams8);
        this.y.addView(this.C);
        this.D = new TextView(this.b);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 4.0f);
        this.D.setTextSize(1, 14.0f);
        this.D.setLines(1);
        this.D.setGravity(16);
        this.D.setEllipsize(TextUtils.TruncateAt.END);
        this.D.setTextColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME));
        this.A.addView(this.D, layoutParams9);
        com.opos.mobad.template.cmn.w wVar3 = new com.opos.mobad.template.cmn.w(this.b);
        this.F = wVar3;
        wVar3.setBackgroundColor(Color.parseColor("#247CFF"));
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 44.0f));
        layoutParams10.addRule(3, this.x.getId());
        layoutParams10.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams10.leftMargin = iA;
        layoutParams10.rightMargin = iA;
        this.F.setLayoutParams(layoutParams10);
        this.F.a(90.0f);
        TextView textView2 = new TextView(this.b);
        this.E = textView2;
        textView2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.E.setTextColor(-1);
        this.E.setTextSize(1, 16.0f);
        com.opos.mobad.template.h.a(this.E);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(13);
        this.F.addView(this.E, layoutParams11);
        this.w.addView(this.F);
        com.opos.mobad.template.a.c cVar = new com.opos.mobad.template.a.c(this.b);
        this.G = cVar;
        cVar.setGravity(3);
        this.G.setVisibility(8);
        this.v.addView(this.G, new LinearLayout.LayoutParams(-1, -2));
    }

    private void s() {
        com.opos.mobad.template.cmn.w wVar = new com.opos.mobad.template.cmn.w(this.b);
        this.H = wVar;
        wVar.a(com.opos.cmn.an.h.f.a.a(this.b, 16.0f));
        this.H.setBackgroundColor(-1);
        this.H.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 76.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 81.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        this.g.addView(this.H, layoutParams);
        com.opos.mobad.template.cmn.p.a(this.H, this.S);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(this.b, com.opos.cmn.an.h.f.a.a(r3, 10.0f));
        this.I = nVar;
        nVar.setLayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b, 44.0f), com.opos.cmn.an.h.f.a.a(this.b, 44.0f)));
        this.I.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.mobad.template.cmn.w wVar2 = new com.opos.mobad.template.cmn.w(this.b);
        wVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        layoutParams2.addRule(15);
        wVar2.addView(this.I);
        wVar2.a(com.opos.cmn.an.h.f.a.a(this.b, 10.0f));
        this.H.addView(wVar2, layoutParams2);
        com.opos.mobad.template.cmn.w wVar3 = new com.opos.mobad.template.cmn.w(this.b);
        this.J = wVar3;
        wVar3.setId(View.generateViewId());
        this.J.setBackgroundColor(Color.parseColor("#247CFF"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        this.J.setPadding(com.opos.cmn.an.h.f.a.a(this.b, 12.0f), 0, com.opos.cmn.an.h.f.a.a(this.b, 12.0f), 0);
        this.J.a(90.0f);
        this.H.addView(this.J, layoutParams3);
        TextView textView = new TextView(this.b);
        this.K = textView;
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.K.setMinWidth(com.opos.cmn.an.h.f.a.a(this.b, 28.0f));
        this.K.setMaxWidth(com.opos.cmn.an.h.f.a.a(this.b, 56.0f));
        this.K.setTextColor(-1);
        this.K.setTextSize(1, 14.0f);
        com.opos.mobad.template.h.a(this.K);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        this.J.addView(this.K, layoutParams4);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 42.0f));
        layoutParams5.addRule(15);
        layoutParams5.addRule(0, this.J.getId());
        layoutParams5.addRule(1, wVar2.getId());
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        layoutParams5.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 8.0f);
        this.H.addView(linearLayout, layoutParams5);
        TextView textView2 = new TextView(this.b);
        this.L = textView2;
        com.opos.mobad.template.h.a(textView2);
        this.L.setMaxWidth(com.opos.cmn.an.h.f.a.a(this.b, 228.0f));
        this.L.setTextSize(1, 16.0f);
        this.L.setTextColor(Color.parseColor("#E5000000"));
        this.L.setLines(1);
        this.L.setSingleLine(true);
        this.L.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(this.L);
        this.M = new TextView(this.b);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.opos.cmn.an.h.f.a.a(this.b, 2.0f);
        this.M.setTextSize(1, 14.0f);
        this.M.setLines(1);
        this.M.setGravity(16);
        this.M.setEllipsize(TextUtils.TruncateAt.END);
        this.M.setTextColor(Color.parseColor("#8A000000"));
        linearLayout.addView(this.M, layoutParams6);
    }

    private void t() {
        com.opos.mobad.template.cmn.baseview.b bVar = new com.opos.mobad.template.cmn.baseview.b(this.b);
        bVar.setBackgroundColor(-16777216);
        bVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.b, 94.0f)));
        bVar.setId(View.generateViewId());
        this.j = u.a(this.b);
        this.i = z.a(this.b);
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 28.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(this.b, 16.0f);
        LinearLayout linearLayout = new LinearLayout(this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, iA);
        layoutParams.gravity = 80;
        layoutParams.leftMargin = iA2;
        layoutParams.bottomMargin = iA2;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.b, 12.0f);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.j, new LinearLayout.LayoutParams(-2, iA));
        this.i.setId(View.generateViewId());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, iA);
        layoutParams2.gravity = 80;
        layoutParams2.rightMargin = iA2;
        layoutParams2.bottomMargin = iA2;
        bVar.addView(linearLayout, layoutParams);
        bVar.addView(this.i, layoutParams2);
        this.g.addView(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        w wVar = this.k;
        if (wVar == null) {
            return;
        }
        wVar.removeAllViews();
        this.g.removeView(this.k);
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.opos.mobad.template.d.c cVar = this.o;
        if (cVar != null && cVar.F == 1) {
            this.i.c();
            return;
        }
        this.j.setVisibility(8);
        this.i.setVisibility(4);
        this.H.setVisibility(8);
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.P == null) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.b);
            this.P = aVar;
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.h.ag.5
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (ag.this.o == null) {
                        return;
                    }
                    if (!z) {
                        ag.this.l();
                        return;
                    }
                    if (!ag.this.p) {
                        ag.this.p = true;
                        ag.this.a((Map<String, String>) null);
                    }
                    ag.this.k();
                }
            });
            this.P.a(new a.c() { // from class: com.opos.mobad.template.h.ag.6
                @Override // com.opos.mobad.d.e.a.c
                public void a(boolean z, boolean z2) {
                    com.opos.cmn.an.f.a.b("RewardVideoTopTemplate", "onViewVisibleWithoutFocus: " + z + ", " + z2);
                    HashMap map = new HashMap();
                    map.put("isVisibleRect", String.valueOf(z));
                    map.put("isAttached", String.valueOf(z2));
                    ag.this.b(map);
                }
            }, c());
        }
        if (this.g.indexOfChild(this.P) < 0) {
            this.g.addView(this.P, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.j.setVisibility(0);
        this.m.setVisibility(0);
    }

    private void b(com.opos.mobad.d.d.a aVar, boolean z) {
        this.l = new com.opos.mobad.template.cmn.baseview.c(this.b);
        this.g.addView(this.l, new RelativeLayout.LayoutParams(-1, -1));
        this.h = ah.a(this.b, aVar);
        this.l.addView(this.h, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        com.opos.mobad.template.d.c cVar = this.o;
        if (cVar != null && cVar.J.containsKey("EXT_PARAM_KEY_REWARD")) {
            try {
                return "1".equals(this.o.J.get("EXT_PARAM_KEY_REWARD"));
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }
        }
        return false;
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.g;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean f() {
        com.opos.cmn.an.f.a.b("RewardVideoTopTemplate", "start countdown...");
        this.h.c();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public boolean g() {
        this.h.a();
        return true;
    }

    @Override // com.opos.mobad.template.j.a
    public void h() {
        com.opos.cmn.an.f.a.b("RewardVideoTopTemplate", "do End");
        this.h.d();
        this.n.removeCallbacks(this.O);
        com.opos.mobad.template.cmn.baseview.c cVar = this.g;
        if (cVar != null) {
            cVar.removeAllViews();
        }
    }

    public static ag a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new ag(context, i, aVar, aVar2, true);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.a.c cVar2;
        com.opos.mobad.template.d.a aVar = cVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f9412a) || TextUtils.isEmpty(aVar.b) || (cVar2 = this.G) == null) {
            return;
        }
        cVar2.setVisibility(0);
        this.G.a(aVar.f9412a, aVar.b);
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.template.cmn.w wVar;
        this.j.a(cVar.q, cVar.B);
        this.i.a(cVar.A);
        if (!q() || (wVar = this.H) == null || wVar.getVisibility() == 8) {
            return;
        }
        this.H.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.opos.mobad.template.d.c cVar = this.o;
        if (cVar == null || this.q) {
            return;
        }
        long j2 = cVar.C;
        if (j2 <= 0 || j >= j2) {
            this.q = true;
            this.i.a();
        }
    }

    private void a(com.opos.mobad.d.d.a aVar, boolean z) {
        this.g = new com.opos.mobad.template.cmn.baseview.c(this.b);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.g.setId(View.generateViewId());
        this.g.setBackgroundColor(Color.parseColor("#000000"));
        this.g.setLayoutParams(layoutParams);
        this.g.setVisibility(8);
        b(aVar, z);
        t();
        s();
        r();
        a(z);
        com.opos.mobad.template.cmn.p.a(this.g, this.S);
        this.g.a(this.R);
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.setForceDarkAllowed(false);
        }
    }

    @Override // com.opos.mobad.template.j.a, com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        super.a(interfaceC0778a);
        this.i.a(this.Q);
        this.h.a(this.Q);
        this.j.a(this.Q);
        this.G.a(this.Q);
        this.C.a(this.Q);
        w wVar = this.k;
        if (wVar != null) {
            wVar.a(this.Q);
        }
        this.i.a(new z.a() { // from class: com.opos.mobad.template.h.ag.4
            @Override // com.opos.mobad.template.h.z.a
            public void a(int i) {
                ag.this.h.a(i);
            }
        });
        com.opos.mobad.template.cmn.p.a(this.F, this.T);
        com.opos.mobad.template.cmn.p.a(this.J, this.T);
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        a(cVar.k);
        c(cVar);
        this.B.setText(cVar.b);
        this.D.setText(cVar.f9413a);
        this.E.setText(cVar.j);
        this.L.setText(cVar.b);
        this.M.setText(cVar.f9413a);
        this.K.setText(cVar.j);
        this.C.a(cVar.p, cVar.e, cVar.f, cVar.h, cVar.i);
        b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.template.d.c cVar, com.opos.mobad.d.d.a aVar) {
        if (this.f9958a != null) {
            this.l.setBackground(new BitmapDrawable(this.f9958a));
        } else {
            com.opos.mobad.template.cmn.af.a(aVar, cVar.N.f9414a, new af.a() { // from class: com.opos.mobad.template.h.ag.8
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(Bitmap bitmap) {
                    if (ag.this.n() == 8) {
                        return;
                    }
                    ag agVar = ag.this;
                    agVar.f9958a = com.opos.mobad.template.cmn.f.a(agVar.b, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.h.ag.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ag.this.n() == 8) {
                                return;
                            }
                            ag.this.l.setBackground(new BitmapDrawable(ag.this.f9958a));
                        }
                    });
                }
            });
        }
    }

    private void a(com.opos.mobad.template.d.e eVar) {
        this.z.setScaleType(ImageView.ScaleType.FIT_XY);
        this.I.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            com.opos.mobad.template.cmn.y yVar = this.z;
            int i = R.drawable.opos_mobad_icon_null;
            yVar.setBackgroundResource(i);
            this.I.setBackgroundResource(i);
            com.opos.cmn.an.f.a.b("RewardVideoTopTemplate", "iconUrl is null");
            return;
        }
        if (this.u) {
            return;
        }
        this.u = true;
        int iA = com.opos.cmn.an.h.f.a.a(this.b, 52.0f);
        com.opos.mobad.template.cmn.j.a(eVar.f9414a, eVar.b, iA, iA, this.c, new j.c() { // from class: com.opos.mobad.template.h.ag.7
            @Override // com.opos.mobad.template.cmn.j.c
            public void a(int i2) {
                if (i2 != 1) {
                    com.opos.mobad.template.cmn.y yVar2 = ag.this.z;
                    int i3 = R.drawable.opos_mobad_icon_null;
                    yVar2.setBackgroundResource(i3);
                    ag.this.I.setBackgroundResource(i3);
                }
                ag.this.b(i2);
            }

            @Override // com.opos.mobad.template.cmn.j.c
            public void a(Bitmap bitmap) {
                ag.this.z.setImageBitmap(bitmap);
                ag.this.I.setImageBitmap(bitmap);
            }
        }, this.U);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (fVar == null) {
            com.opos.cmn.an.f.a.a("RewardVideoTopTemplate", "data is null");
        } else {
            com.opos.mobad.template.d.c cVarB = fVar.b();
            if (cVarB != null) {
                if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.o == null) {
                    this.h.a(cVarB);
                }
                this.o = cVarB;
                com.opos.mobad.template.cmn.baseview.c cVar = this.g;
                if (cVar != null && cVar.getVisibility() != 0) {
                    this.g.setVisibility(0);
                }
                a(cVarB);
                return;
            }
            com.opos.cmn.an.f.a.d("RewardVideoTopTemplate", "render with data null");
        }
        a(1);
    }

    private void a(boolean z) {
        this.k = z ? w.a(this.b) : w.b(this.b);
        this.g.addView(this.k, new RelativeLayout.LayoutParams(-1, -1));
    }
}
