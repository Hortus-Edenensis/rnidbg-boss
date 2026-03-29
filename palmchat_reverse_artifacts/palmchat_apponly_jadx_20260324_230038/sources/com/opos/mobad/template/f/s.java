package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a;
import com.opos.mobad.d.e.a;
import com.opos.mobad.template.a;
import com.opos.mobad.template.a.h;
import com.opos.mobad.template.cmn.af;
import com.opos.mobad.template.f.w;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f9598a = 0;
    private static int b = 1;
    private com.opos.mobad.d.a A;
    private com.opos.mobad.template.e.c.a B;
    private String C;
    private String D;
    private n F;
    private boolean c;
    private RelativeLayout h;
    private RelativeLayout i;
    private Context j;
    private a.InterfaceC0778a k;
    private View l;
    private int m;
    private View n;
    private ProgressBar o;
    private View p;
    private w q;
    private com.opos.mobad.d.d.a r;
    private int t;
    private com.opos.mobad.template.d.c x;
    private int y;
    private com.opos.mobad.template.a.h z;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean s = false;
    private boolean u = false;
    private Runnable v = new Runnable() { // from class: com.opos.mobad.template.f.s.1
        @Override // java.lang.Runnable
        public void run() {
            if (s.this.s) {
                return;
            }
            if (s.this.k != null) {
                s.this.k.d(s.this.r.d(), s.this.r.c());
            }
            s.this.o.setProgress(s.this.f());
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "on progress" + s.this.o.getProgress());
            s.this.w.postDelayed(this, 500L);
        }
    };
    private boolean E = false;
    private com.opos.mobad.d.d.b G = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.f.s.6
        @Override // com.opos.mobad.d.d.b
        public void a(Map<String, String> map) {
            if (s.this.k != null) {
                s.this.k.b(map);
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            s.this.l();
            if (s.this.k != null) {
                s.this.k.d(0L, s.this.r.c());
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            s.this.w.removeCallbacks(s.this.v);
            s.this.w.postDelayed(s.this.v, 500L);
            s.this.k.d(s.this.r.d(), s.this.r.c());
            s.this.o.setProgress(0);
            s.this.i();
        }

        @Override // com.opos.mobad.d.d.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (s.this.k != null) {
                s.this.k.a(s.this.r.c(), s.this.r.c());
            }
            s.this.w.removeCallbacks(s.this.v);
            s.this.k();
        }

        @Override // com.opos.mobad.d.d.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            s.this.u = false;
            s.this.i();
        }

        @Override // com.opos.mobad.d.d.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            s.this.p.setVisibility(0);
        }

        @Override // com.opos.mobad.d.d.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            s.this.j();
        }

        @Override // com.opos.mobad.d.d.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            s.this.i();
        }

        @Override // com.opos.mobad.d.d.b
        public void j() {
        }
    };
    private Handler w = new Handler(Looper.getMainLooper());

    public s(Context context, int i, com.opos.mobad.template.a.h hVar, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.j = context;
        this.y = i;
        this.h = new RelativeLayout(context);
        this.r = aVar;
        aVar.a(this.G);
        this.t = i2;
        this.z = hVar;
        this.A = aVar2;
        this.c = af.a(context, 2.12f) >= 0;
        a(hVar);
        g();
        h();
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new s(context.getApplicationContext(), i, new com.opos.mobad.template.a.h(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 145, h.a.BELOW), f9598a, aVar, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (0 == this.r.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.r.d() * 100) / this.r.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.n.setVisibility(8);
        this.p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f = true;
        a.InterfaceC0778a interfaceC0778a = this.k;
        if (interfaceC0778a != null) {
            interfaceC0778a.f();
            if (this.e) {
                this.k.a(com.opos.mobad.template.h.a(this.B));
            }
            if (this.g) {
                Map<String, String> mapA = com.opos.mobad.template.h.a(this.B);
                mapA.put("isVisibleRect", this.C);
                mapA.put("isAttached", this.D);
                this.k.a(mapA);
            }
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.h;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.y;
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new s(context.getApplicationContext(), i, new com.opos.mobad.template.a.h(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, h.a.BELOW), b, aVar, aVar2);
    }

    private void g() {
        this.F = this.t == b ? this.c ? n.a(this.j) : n.c(this.j) : this.c ? n.b(this.j) : n.d(this.j);
    }

    private void h() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.j);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.s.4
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (s.this.x == null) {
                    return;
                }
                if (!z) {
                    s.this.r.f();
                    return;
                }
                s.this.a(com.opos.mobad.template.h.a(s.this.B));
                if (s.this.r.i() != 5) {
                    if (s.this.r.i() == 3 && s.this.u) {
                        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "resume but user pause");
                        return;
                    }
                    s.this.r.g();
                }
                if (s.this.B == null || s.this.B.c() == null || s.this.B.c().getVisibility() == 0) {
                    return;
                }
                s.this.B.c().setVisibility(0);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.f.s.5
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                com.opos.cmn.an.f.a.b("InterstitialPortVideo", "interstitialPortVideo onViewVisibleWithoutFocus " + z + ", " + z2);
                if (s.this.x == null) {
                    return;
                }
                Map<String, String> mapA = com.opos.mobad.template.h.a(s.this.B);
                s.this.C = String.valueOf(z);
                s.this.D = String.valueOf(z2);
                mapA.put("isVisibleRect", s.this.C);
                mapA.put("isAttached", s.this.D);
                s.this.b(mapA);
            }
        }, c());
        this.h.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.n.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d = true;
        this.o.setProgress(100);
        if (this.t == b) {
            this.q.setVisibility(4);
        }
        if (this.i.indexOfChild(this.F) < 0) {
            this.i.addView(this.F);
        }
        com.opos.mobad.template.e.c.a aVar = this.B;
        if (aVar == null || !aVar.e()) {
            return;
        }
        this.B.f();
        if (this.B.c().getVisibility() != 8) {
            this.B.c().setVisibility(8);
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.x = null;
        com.opos.mobad.d.d.a aVar = this.r;
        if (aVar != null) {
            aVar.f();
            this.r.h();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.j();
        }
        this.s = true;
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        this.r.a(cVar.N.f9414a, false);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "stop");
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
            return;
        }
        this.u = true;
        this.r.f();
        this.w.removeCallbacks(this.v);
        com.opos.mobad.template.e.c.a aVar = this.B;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.k = interfaceC0778a;
        this.F.a(interfaceC0778a);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "start");
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
            return;
        }
        this.r.g();
        this.w.post(this.v);
        com.opos.mobad.template.e.c.a aVar = this.B;
        if (aVar != null) {
            aVar.h();
        }
    }

    private void a(com.opos.mobad.template.a.h hVar) {
        this.i = new RelativeLayout(this.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, 258.0f), com.opos.cmn.an.h.f.a.a(this.j, e() == 12 ? 400 : MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME));
        layoutParams.addRule(13);
        this.h.addView(this.i, layoutParams);
        this.l = this.r.b();
        this.r.d(-16777216);
        this.l.setBackgroundColor(-16777216);
        int iGenerateViewId = View.generateViewId();
        this.m = iGenerateViewId;
        this.l.setId(iGenerateViewId);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, hVar.f9293a), com.opos.cmn.an.h.f.a.a(this.j, hVar.b));
        layoutParams2.addRule(10);
        this.i.addView(this.l, layoutParams2);
        com.opos.mobad.template.cmn.baseview.a aVar = new com.opos.mobad.template.cmn.baseview.a(this.j);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, this.m);
        layoutParams3.addRule(5, this.m);
        layoutParams3.addRule(6, this.m);
        layoutParams3.addRule(8, this.m);
        this.i.addView(aVar, layoutParams3);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.s.7
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (s.this.k != null) {
                    s.this.k.f(view, iArr);
                }
            }
        };
        aVar.setOnTouchListener(pVar);
        aVar.setOnClickListener(pVar);
        com.opos.mobad.template.cmn.baseview.f fVar = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.s.8
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialPortVideo", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (s.this.k != null) {
                    s.this.k.a(view, i, z);
                }
            }
        };
        aVar.a(fVar);
        this.n = new ProgressBar(this.j);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, 30.0f), com.opos.cmn.an.h.f.a.a(this.j, 39.0f));
        layoutParams4.gravity = 17;
        this.n.setVisibility(0);
        aVar.addView(this.n, layoutParams4);
        View view = new View(this.j);
        this.p = view;
        view.setBackground(this.j.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.j, 60.0f), com.opos.cmn.an.h.f.a.a(this.j, 60.0f));
        layoutParams5.gravity = 17;
        this.p.setVisibility(4);
        aVar.addView(this.p, layoutParams5);
        a(fVar);
        ProgressBar progressBar = new ProgressBar(this.j);
        this.o = progressBar;
        progressBar.setId(View.generateViewId());
        af.a(this.o, "mOnlyIndeterminate", new Boolean(false));
        this.o.setIndeterminate(false);
        this.o.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.o.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.j, 2.0f));
        layoutParams6.addRule(8, this.m);
        layoutParams6.addRule(7, this.m);
        layoutParams6.addRule(5, this.m);
        this.o.setVisibility(0);
        this.i.addView(this.o, layoutParams6);
    }

    private void b(com.opos.mobad.template.d.c cVar) {
        if (this.x != null) {
            return;
        }
        int i = cVar.z;
        if (this.t == f9598a) {
            i = 0;
        }
        this.q.a(cVar.b, cVar.f9413a, cVar.j, i);
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.q.e();
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.j, 44.0f);
        com.opos.mobad.d.a aVar = this.A;
        com.opos.mobad.template.d.e eVar2 = cVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.s.3
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i2, final Bitmap bitmap) {
                if (s.this.s) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (s.this.k != null) {
                        s.this.k.c(i2);
                    }
                } else {
                    if (i2 == 1 && s.this.k != null) {
                        s.this.k.c(i2);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.s.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            if (s.this.s || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                return;
                            }
                            s.this.q.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.t == b) {
            this.q = this.c ? w.a(this.j, 42, 14, 10, w.a.n) : w.c(this.j, 42, 14, 10, w.a.n);
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.j, 66.0f));
            layoutParams.addRule(8, this.m);
            layoutParams.addRule(7, this.m);
            layoutParams.addRule(5, this.m);
        } else {
            this.q = this.c ? w.b(this.j, 60, 14, 12, w.a.m) : w.d(this.j, 60, 14, 12, w.a.m);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.m);
            layoutParams.addRule(12);
        }
        this.i.addView(this.q, layoutParams);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.s.9
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (s.this.k != null) {
                    s.this.k.h(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(pVar);
        this.q.setOnTouchListener(pVar);
        this.q.a(fVar);
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.s.10
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (s.this.k != null) {
                    s.this.k.g(view, iArr);
                }
            }
        };
        this.q.f().setOnClickListener(pVar2);
        this.q.f().setOnTouchListener(pVar2);
        this.q.f().a(fVar);
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        int i;
        if (!this.E) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.j, e(), bVar.L);
            this.B = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.s.11
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i2, int[] iArr) {
                    if (s.this.k != null) {
                        s.this.k.a(i2, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (s.this.k != null) {
                        s.this.k.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (s.this.k != null) {
                        s.this.k.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (s.this.k != null) {
                        s.this.k.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.j, 46.0f));
            if (this.t == b) {
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.j, 79.0f);
                i = 12;
            } else {
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.j, 89.0f);
                i = 10;
            }
            layoutParams.addRule(i);
            layoutParams.addRule(14);
            if (this.B.e() && this.B.c() != null) {
                this.i.addView(this.B.c(), layoutParams);
            }
            this.E = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.B;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, String> map) {
        if (!this.f || this.g) {
            this.g = true;
            return;
        }
        a.InterfaceC0778a interfaceC0778a = this.k;
        if (interfaceC0778a != null) {
            interfaceC0778a.a(map);
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        if (this.x != null) {
            return;
        }
        this.F.a(cVar.b, cVar.f9413a, cVar.j);
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.F.a();
            this.q.e();
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(this.j, 44.0f);
            com.opos.mobad.d.a aVar = this.A;
            com.opos.mobad.template.d.e eVar2 = cVar.k;
            aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.s.2
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (s.this.s) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (s.this.k != null) {
                            s.this.F.a();
                            s.this.k.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && s.this.k != null) {
                        s.this.F.a();
                        s.this.k.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.s.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (s.this.s) {
                                return;
                            }
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                s.this.F.a();
                            } else {
                                s.this.F.a(bitmap);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("InterstitialPortVideo", "render with data null");
            a.InterfaceC0778a interfaceC0778a = this.k;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.x == null) {
            c(cVarB);
        }
        this.r.a(cVarB.A == 1 ? 1.0f : 0.0f);
        b(cVarB);
        a(cVarB);
        a((com.opos.mobad.template.d.b) cVarB);
        this.x = cVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map) {
        if (!this.f || this.e) {
            this.e = true;
            return;
        }
        a.InterfaceC0778a interfaceC0778a = this.k;
        if (interfaceC0778a != null) {
            interfaceC0778a.a(map);
        }
    }
}
