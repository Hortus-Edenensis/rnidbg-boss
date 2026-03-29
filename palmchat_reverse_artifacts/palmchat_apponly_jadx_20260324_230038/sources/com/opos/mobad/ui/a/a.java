package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements e, f {
    protected String B;
    protected boolean D;
    protected ImageView E;
    protected Context c;
    protected C0803a d;
    protected FrameLayout e;
    protected RelativeLayout f;
    protected ProgressBar g;
    protected TextView h;
    protected TextView i;
    protected ImageView j;
    protected ImageView k;
    protected ImageView l;
    protected ImageView m;
    protected Bitmap n;
    protected RelativeLayout o;
    protected g p;
    protected i q;
    protected c r;
    protected View s;
    protected View t;
    protected View u;
    protected d v;
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;
    protected boolean A = false;
    protected int C = 0;
    protected boolean F = false;
    protected volatile boolean G = false;
    protected Handler H = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.ui.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                a.this.I();
                a.this.y();
                a.this.A();
            }
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.ui.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0803a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10203a;
        public final String b;
        public final String c;
        public final int d;

        public C0803a(String str, String str2, String str3, int i) {
            this.f10203a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        public String toString() {
            return "RenderData{imgUrl='" + this.f10203a + "', videoUrl='" + this.b + "', proxyUrl='" + this.c + "', videoType=" + this.d + '}';
        }
    }

    public a(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        this.D = false;
        this.c = context.getApplicationContext();
        this.v = dVar;
        this.r = new c(context, this);
        this.p = new g(this.c);
        this.e = frameLayout;
        this.D = z;
        b();
        a();
    }

    private void Q() {
        View viewC = this.p.c();
        this.s = viewC;
        viewC.setBackgroundColor(Color.parseColor("#00000000"));
        this.s.setClickable(true);
        this.e.addView(this.s, new ViewGroup.LayoutParams(-1, -1));
        this.s.setVisibility(8);
    }

    private void R() {
        ImageView imageView = new ImageView(this.c);
        this.j = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.j.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 50.0f), com.opos.cmn.an.h.f.a.a(this.c, 42.0f));
        layoutParams.gravity = 17;
        this.e.addView(this.j, layoutParams);
        this.j.setVisibility(8);
        a(this.j, 2);
        ImageView imageView2 = new ImageView(this.c);
        this.k = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_native_video_pause_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 50.0f), com.opos.cmn.an.h.f.a.a(this.c, 42.0f));
        layoutParams2.gravity = 17;
        this.e.addView(this.k, layoutParams2);
        this.k.setVisibility(8);
        a(this.k, 3);
        ImageView imageView3 = new ImageView(this.c);
        this.l = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        this.l.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 50.0f), com.opos.cmn.an.h.f.a.a(this.c, 42.0f));
        layoutParams3.gravity = 17;
        this.e.addView(this.l, layoutParams3);
        this.l.setVisibility(8);
        a(this.l, 1);
    }

    private void S() {
        ImageView imageView = new ImageView(this.c);
        this.E = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.E.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 19.0f), com.opos.cmn.an.h.f.a.a(this.c, 15.0f));
        layoutParams.gravity = 53;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 10.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.c, 13.0f);
        this.e.addView(this.E, layoutParams);
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.c(!r2.F);
            }
        });
    }

    private void b() {
        k();
        R();
        Q();
        if (this.D) {
            o();
            m();
            S();
        }
        n();
    }

    public void A() {
        ImageView imageView = this.E;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.E.setVisibility(8);
        this.A = false;
    }

    public void B() {
        D();
        x();
    }

    public void C() {
        E();
        y();
    }

    public void D() {
        ImageView imageView = this.j;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.j.setVisibility(0);
        this.j.bringToFront();
        this.x = true;
    }

    public void E() {
        ImageView imageView = this.j;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(8);
        this.x = false;
    }

    public void F() {
        H();
        x();
    }

    public void G() {
        I();
        y();
    }

    public void H() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.k.setVisibility(0);
        this.k.bringToFront();
        this.y = true;
    }

    public void I() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.k.setVisibility(8);
        this.y = false;
    }

    public void J() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.l.setVisibility(0);
        this.l.bringToFront();
        this.z = true;
    }

    public void K() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.l.setVisibility(8);
        this.z = false;
    }

    public void L() {
        View view = this.s;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.s.setVisibility(0);
        this.s.bringToFront();
        this.p.d();
    }

    public void M() {
        View view = this.s;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.s.setVisibility(8);
        this.p.e();
    }

    public void N() {
        E();
        L();
    }

    public abstract void O();

    public abstract void P();

    public abstract void a();

    public void a(final View view, final int i) {
        final int[] iArr = {SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.ui.a.a.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || 1 == motionEvent.getAction()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            iArr[0] = (int) motionEvent.getX();
                            iArr[1] = (int) motionEvent.getY();
                        } else if (action == 1) {
                            iArr[2] = (int) motionEvent.getX();
                            iArr[3] = (int) motionEvent.getY();
                            if (i == 4) {
                                a aVar = a.this;
                                if (aVar.D) {
                                    aVar.P();
                                }
                            }
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.ui.a.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.opos.cmn.an.f.a.b("BaseMediaCreative", "clickBnListener status:" + i);
                    a.this.a(view, iArr, i);
                    a.this.O();
                }
            });
        }
    }

    public abstract void a(View view, int[] iArr, int i);

    public void c(boolean z) {
        boolean z2;
        ImageView imageView;
        Context context;
        String str;
        if (this.E != null) {
            if (z) {
                if (this.F) {
                    return;
                }
                z2 = true;
                k.a().a(this.B, true);
                imageView = this.E;
                context = this.c;
                str = "opos_module_biz_ui_cmn_volume_switch_on_img.png";
            } else {
                if (!this.F) {
                    return;
                }
                z2 = false;
                k.a().a(this.B, false);
                imageView = this.E;
                context = this.c;
                str = "opos_module_biz_ui_cmn_volume_switch_off_img.png";
            }
            imageView.setImageDrawable(com.opos.cmn.an.e.a.a.c(context, str));
            this.F = z2;
        }
    }

    public void k() {
        this.o = new RelativeLayout(this.c);
        this.e.addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }

    public void l() {
        ImageView imageView = new ImageView(this.c);
        this.m = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.m.setVisibility(8);
        this.e.addView(this.m, layoutParams);
    }

    public void m() {
        i iVar = new i(this.c, this);
        this.q = iVar;
        View viewD = iVar.d();
        this.t = viewD;
        viewD.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.setVisibility(8);
        this.e.addView(this.t, layoutParams);
    }

    public void n() {
        View viewD = this.r.d();
        this.u = viewD;
        viewD.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.u.setVisibility(8);
        this.e.addView(this.u, layoutParams);
    }

    public void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        this.f = relativeLayout;
        com.opos.cmn.module.ui.d.a.a(relativeLayout, com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_native_video_transparent_cover.png"));
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.c);
        this.h = textView;
        textView.setText("00:00");
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 9.0f);
        this.h.setGravity(21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 26.0f), com.opos.cmn.an.h.f.a.a(this.c, 13.0f));
        layoutParams.weight = 1.0f;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 6.0f);
        linearLayout.addView(this.h, layoutParams);
        ProgressBar progressBar = new ProgressBar(this.c);
        this.g = progressBar;
        com.opos.cmn.module.ui.d.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.g.setIndeterminate(false);
        this.g.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#FF2AD181")), 3, 1));
        this.g.setBackgroundColor(Color.parseColor("#7fD8D8D8"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 260.0f), com.opos.cmn.an.h.f.a.a(this.c, 4.0f));
        layoutParams2.weight = 4.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(this.g, layoutParams2);
        TextView textView2 = new TextView(this.c);
        this.i = textView2;
        textView2.setText("00:00");
        this.i.setTextColor(-1);
        this.i.setTextSize(1, 9.0f);
        this.i.setGravity(19);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 26.0f), com.opos.cmn.an.h.f.a.a(this.c, 13.0f));
        layoutParams3.weight = 1.0f;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.c, 6.0f);
        linearLayout.addView(this.i, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.c, 12.0f);
        this.f.addView(linearLayout, layoutParams4);
        this.f.setVisibility(8);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 96.0f));
        layoutParams5.gravity = 80;
        this.e.addView(this.f, layoutParams5);
    }

    public void p() {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.o.setVisibility(0);
    }

    public void q() {
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    public void r() {
        ImageView imageView = this.m;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.m.setVisibility(0);
    }

    public void s() {
        ImageView imageView = this.m;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.m.setVisibility(8);
    }

    public void t() {
        View view = this.u;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.u.setVisibility(0);
        this.u.bringToFront();
    }

    public void u() {
        View view = this.u;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.u.setVisibility(8);
    }

    public void v() {
        View view = this.t;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.t.setVisibility(0);
        this.t.bringToFront();
    }

    public void w() {
        View view = this.t;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.t.setVisibility(8);
    }

    public void x() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.f.setVisibility(0);
        this.f.bringToFront();
        this.w = true;
    }

    public void y() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f.setVisibility(8);
        this.w = false;
    }

    public void z() {
        ImageView imageView = this.E;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.E.setVisibility(0);
        this.E.bringToFront();
        this.A = true;
    }

    public void b(boolean z) {
        if (this.E == null || this.G) {
            return;
        }
        this.F = z;
        this.E.setImageDrawable(com.opos.cmn.an.e.a.a.c(this.c, z ? "opos_module_biz_ui_cmn_volume_switch_on_img.png" : "opos_module_biz_ui_cmn_volume_switch_off_img.png"));
        this.G = true;
    }
}
