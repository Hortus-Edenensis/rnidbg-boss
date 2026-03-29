package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
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
public class q implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f9576a = 0;
    private static int b = 1;
    private com.opos.mobad.template.e.c.a A;
    private String B;
    private String C;
    private n E;
    private com.opos.mobad.d.a c;
    private RelativeLayout e;
    private RelativeLayout f;
    private Context g;
    private a.InterfaceC0778a h;
    private View i;
    private int j;
    private View k;
    private ProgressBar l;
    private View m;
    private w n;
    private com.opos.mobad.d.d.a o;
    private int q;
    private com.opos.mobad.template.d.c w;
    private int x;
    private com.opos.mobad.template.a.h y;
    private boolean d = false;
    private boolean p = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private Runnable u = new Runnable() { // from class: com.opos.mobad.template.f.q.1
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.p) {
                return;
            }
            if (q.this.h != null) {
                q.this.h.d(q.this.o.d(), q.this.o.c());
            }
            q.this.l.setProgress(q.this.f());
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "on progress" + q.this.l.getProgress());
            q.this.v.postDelayed(this, 500L);
        }
    };
    private boolean z = false;
    private boolean D = false;
    private com.opos.mobad.d.d.b F = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.f.q.7
        @Override // com.opos.mobad.d.d.b
        public void a(Map<String, String> map) {
            if (q.this.h != null) {
                q.this.h.b(map);
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            q.this.m();
            if (q.this.h != null) {
                q.this.h.d(0L, q.this.o.c());
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            q.this.v.removeCallbacks(q.this.u);
            q.this.v.postDelayed(q.this.u, 500L);
            q.this.h.d(q.this.o.d(), q.this.o.c());
            q.this.l.setProgress(0);
            q.this.j();
        }

        @Override // com.opos.mobad.d.d.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (q.this.h != null) {
                q.this.h.a(q.this.o.c(), q.this.o.c());
            }
            q.this.v.removeCallbacks(q.this.u);
            q.this.l();
        }

        @Override // com.opos.mobad.d.d.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            q.this.z = false;
            q.this.j();
        }

        @Override // com.opos.mobad.d.d.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            q.this.m.setVisibility(0);
        }

        @Override // com.opos.mobad.d.d.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            q.this.k();
        }

        @Override // com.opos.mobad.d.d.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            q.this.j();
        }

        @Override // com.opos.mobad.d.d.b
        public void j() {
            if (q.this.w == null) {
                return;
            }
            q qVar = q.this;
            qVar.b(qVar.w);
        }
    };
    private Bitmap G = null;
    private Handler v = new Handler(Looper.getMainLooper());

    public q(Context context, int i, com.opos.mobad.template.a.h hVar, int i2, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        this.g = context;
        this.x = i;
        this.e = new RelativeLayout(context);
        this.o = aVar;
        aVar.a(this.F);
        this.q = i2;
        this.y = hVar;
        this.c = aVar2;
        a(hVar, i2);
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (0 == this.o.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.o.d() * 100) / this.o.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.q == b) {
            this.f.setBackground(new BitmapDrawable(this.G));
        }
        this.E.setBackground(new BitmapDrawable(this.G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.d = true;
        this.l.setProgress(100);
        this.n.setVisibility(4);
        if (this.f.indexOfChild(this.E) < 0) {
            this.f.addView(this.E);
        }
        com.opos.mobad.template.e.c.a aVar = this.A;
        if (aVar == null || !aVar.e()) {
            return;
        }
        this.A.f();
        if (this.A.c().getVisibility() != 8) {
            this.A.c().setVisibility(8);
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.e;
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.x;
    }

    public static final com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new q(context.getApplicationContext(), i, new com.opos.mobad.template.a.h(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, h.a.RIGHT), f9576a, aVar, aVar2);
    }

    public static final com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.d.d.a aVar, com.opos.mobad.d.a aVar2) {
        return new q(context.getApplicationContext(), i, new com.opos.mobad.template.a.h(145, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, h.a.RIGHT), b, aVar, aVar2);
    }

    private void g() {
        this.E = this.q == b ? n.f(this.g) : n.e(this.g);
    }

    private void h() {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
        aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.template.f.q.5
            @Override // com.opos.mobad.d.e.a.InterfaceC0735a
            public void a(boolean z) {
                if (q.this.w == null) {
                    return;
                }
                if (!z) {
                    q.this.o.f();
                    return;
                }
                q.this.a(com.opos.mobad.template.h.a(q.this.A));
                if (q.this.o.i() != 5) {
                    if (q.this.o.i() == 3 && q.this.z) {
                        com.opos.cmn.an.f.a.b("InterstitialLandVideo", "resume but user pause");
                        return;
                    }
                    q.this.o.g();
                }
                if (q.this.A == null || q.this.A.c() == null || q.this.A.c().getVisibility() == 0) {
                    return;
                }
                q.this.A.c().setVisibility(0);
            }
        });
        aVar.a(new a.c() { // from class: com.opos.mobad.template.f.q.6
            @Override // com.opos.mobad.d.e.a.c
            public void a(boolean z, boolean z2) {
                if (q.this.w == null) {
                    return;
                }
                Map<String, String> mapA = com.opos.mobad.template.h.a(q.this.A);
                q.this.B = String.valueOf(z);
                q.this.C = String.valueOf(z2);
                mapA.put("isVisibleRect", q.this.B);
                mapA.put("isAttached", q.this.C);
                q.this.b(mapA);
            }
        }, c());
        this.e.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k.setVisibility(8);
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.k.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.s = true;
        a.InterfaceC0778a interfaceC0778a = this.h;
        if (interfaceC0778a != null) {
            interfaceC0778a.f();
            if (this.r) {
                this.h.a(com.opos.mobad.template.h.a(this.A));
            }
            if (this.t) {
                Map<String, String> mapA = com.opos.mobad.template.h.a(this.A);
                mapA.put("isVisibleRect", this.B);
                mapA.put("isAttached", this.C);
                this.h.a(mapA);
            }
        }
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.w = null;
        com.opos.mobad.d.d.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
            this.o.h();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.j();
        }
        this.p = true;
    }

    private void c(com.opos.mobad.template.d.c cVar) {
        this.E.a(cVar.b, cVar.f9413a, cVar.j);
        if (this.w != null) {
            return;
        }
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.n.e();
            this.E.a();
        } else {
            int iA = com.opos.cmn.an.h.f.a.a(this.g, 44.0f);
            com.opos.mobad.d.a aVar = this.c;
            com.opos.mobad.template.d.e eVar2 = cVar.k;
            aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.q.3
                @Override // com.opos.mobad.d.a.InterfaceC0732a
                public void a(int i, final Bitmap bitmap) {
                    if (i != 0 && i != 1) {
                        if (q.this.h != null) {
                            q.this.E.a();
                            q.this.h.c(i);
                            return;
                        }
                        return;
                    }
                    if (i == 1 && q.this.h != null) {
                        q.this.E.a();
                        q.this.h.c(i);
                    }
                    com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.q.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (q.this.p) {
                                return;
                            }
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                q.this.E.a();
                            } else {
                                q.this.E.a(bitmap);
                            }
                        }
                    });
                }
            });
        }
    }

    private void d(com.opos.mobad.template.d.c cVar) {
        this.n.a(cVar.b, cVar.f9413a, cVar.j, cVar.z);
        if (this.w != null) {
            return;
        }
        com.opos.mobad.template.d.e eVar = cVar.k;
        if (eVar == null || TextUtils.isEmpty(eVar.f9414a)) {
            this.n.e();
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.g, 44.0f);
        com.opos.mobad.d.a aVar = this.c;
        com.opos.mobad.template.d.e eVar2 = cVar.k;
        aVar.a(eVar2.f9414a, eVar2.b, iA, iA, new a.InterfaceC0732a() { // from class: com.opos.mobad.template.f.q.4
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(int i, final Bitmap bitmap) {
                if (i != 0 && i != 1) {
                    if (q.this.h != null) {
                        q.this.n.e();
                        q.this.h.c(i);
                        return;
                    }
                    return;
                }
                if (q.this.p) {
                    return;
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    q.this.n.e();
                    return;
                }
                if (i == 1 && q.this.h != null) {
                    q.this.n.e();
                    q.this.h.c(i);
                }
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.q.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (q.this.p) {
                            return;
                        }
                        q.this.n.a(bitmap);
                    }
                });
            }
        });
    }

    private void e(com.opos.mobad.template.d.c cVar) {
        this.o.a(cVar.N.f9414a, false);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no stop for has complete");
            return;
        }
        this.z = true;
        this.o.f();
        this.v.removeCallbacks(this.u);
        com.opos.mobad.template.e.c.a aVar = this.A;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        if (this.d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no start for has complete");
            return;
        }
        this.o.g();
        this.v.post(this.u);
        com.opos.mobad.template.e.c.a aVar = this.A;
        if (aVar != null) {
            aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.template.d.c cVar) {
        if (this.G != null) {
            i();
        } else {
            af.a(this.o, cVar.N.f9414a, new af.a() { // from class: com.opos.mobad.template.f.q.2
                @Override // com.opos.mobad.template.cmn.af.a
                public void a() {
                }

                @Override // com.opos.mobad.template.cmn.af.a
                public void a(Bitmap bitmap) {
                    if (q.this.p) {
                        return;
                    }
                    q qVar = q.this;
                    qVar.G = com.opos.mobad.template.cmn.f.a(qVar.g, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.f.q.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (q.this.p) {
                                return;
                            }
                            q.this.i();
                        }
                    });
                }
            });
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.h = interfaceC0778a;
        this.E.a(interfaceC0778a);
    }

    private void a(com.opos.mobad.template.a.h hVar, int i) {
        this.j = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(this.g);
        this.f = relativeLayout;
        relativeLayout.setId(this.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 458.0f), com.opos.cmn.an.h.f.a.a(this.g, 258.0f));
        layoutParams.addRule(13);
        this.e.addView(this.f, layoutParams);
        this.e.setBackgroundColor(-16777216);
        this.i = this.o.b();
        this.o.d(-16777216);
        this.i.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, hVar.f9293a), com.opos.cmn.an.h.f.a.a(this.g, hVar.b));
        layoutParams2.addRule(13);
        this.f.addView(this.i, layoutParams2);
        com.opos.mobad.template.cmn.baseview.d dVar = new com.opos.mobad.template.cmn.baseview.d(this.g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, this.j);
        layoutParams3.addRule(5, this.j);
        layoutParams3.addRule(6, this.j);
        layoutParams3.addRule(8, this.j);
        this.f.addView(dVar, layoutParams3);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.q.8
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (q.this.h != null) {
                    q.this.h.f(view, iArr);
                }
            }
        };
        dVar.setOnTouchListener(pVar);
        dVar.setOnClickListener(pVar);
        com.opos.mobad.template.cmn.baseview.f fVar = new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.q.9
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialLandVideo", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (q.this.h != null) {
                    q.this.h.a(view, i2, z);
                }
            }
        };
        dVar.a(fVar);
        this.k = new ProgressBar(this.g);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 30.0f), com.opos.cmn.an.h.f.a.a(this.g, 39.0f));
        layoutParams4.addRule(13);
        this.k.setVisibility(0);
        this.f.addView(this.k, layoutParams4);
        View view = new View(this.g);
        this.m = view;
        view.setBackground(this.g.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.g, 60.0f), com.opos.cmn.an.h.f.a.a(this.g, 60.0f));
        layoutParams5.addRule(13);
        this.m.setVisibility(4);
        this.f.addView(this.m, layoutParams5);
        a(fVar);
        ProgressBar progressBar = new ProgressBar(this.g);
        this.l = progressBar;
        progressBar.setId(View.generateViewId());
        af.a(this.l, "mOnlyIndeterminate", new Boolean(false));
        this.l.setIndeterminate(false);
        this.l.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.l.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 2.0f));
        layoutParams6.addRule(12);
        this.l.setVisibility(0);
        this.f.addView(this.l, layoutParams6);
    }

    private void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        this.n = w.e(this.g, 42, 14, 10, w.a.n);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.q.10
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (q.this.h != null) {
                    q.this.h.h(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(pVar);
        this.n.setOnTouchListener(pVar);
        this.n.a(fVar);
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.q.11
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (q.this.h != null) {
                    q.this.h.g(view, iArr);
                }
            }
        };
        this.n.f().setOnClickListener(pVar2);
        this.n.f().setOnTouchListener(pVar2);
        this.n.f().a(fVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 66.0f));
        layoutParams.addRule(12);
        this.f.addView(this.n, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, String> map) {
        if (!this.s || this.t) {
            this.t = true;
            return;
        }
        a.InterfaceC0778a interfaceC0778a = this.h;
        if (interfaceC0778a != null) {
            interfaceC0778a.a(map);
        }
    }

    private void a(com.opos.mobad.template.d.b bVar) {
        if (!this.D) {
            com.opos.mobad.template.e.c.a aVarA = com.opos.mobad.template.e.a.i.a().a(this.g, e(), bVar.L);
            this.A = aVarA;
            if (aVarA == null) {
                return;
            }
            aVarA.a(new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.template.f.q.12
                @Override // com.opos.mobad.template.e.c.b
                public void a(int i, int[] iArr) {
                    if (q.this.h != null) {
                        q.this.h.a(i, iArr);
                    }
                }

                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (q.this.h != null) {
                        q.this.h.g(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.e.c.b
                public void a(View view, int[] iArr) {
                    if (q.this.h != null) {
                        q.this.h.h(view, iArr);
                    }
                }

                @Override // com.opos.mobad.template.c
                public void a(int[] iArr) {
                    if (q.this.h != null) {
                        q.this.h.a(iArr);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 46.0f));
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.g, 78.0f);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            if (this.A.e() && this.A.c() != null) {
                this.f.addView(this.A.c(), layoutParams);
            }
            this.D = true;
        }
        com.opos.mobad.template.e.c.a aVar = this.A;
        if (aVar != null) {
            aVar.a(com.opos.mobad.template.e.b.a.a(bVar));
        }
    }

    private void a(com.opos.mobad.template.d.c cVar) {
        if (this.w != null) {
            return;
        }
        b(cVar);
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.c cVarB = fVar.b();
        if (cVarB == null) {
            com.opos.cmn.an.f.a.d("InterstitialLandVideo", "render with data null");
            a.InterfaceC0778a interfaceC0778a = this.h;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(cVarB.N.f9414a) && this.w == null) {
            e(cVarB);
        }
        this.o.a(cVarB.A == 1 ? 1.0f : 0.0f);
        d(cVarB);
        a(cVarB);
        c(cVarB);
        a((com.opos.mobad.template.d.b) cVarB);
        this.w = cVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map) {
        if (!this.s || this.r) {
            this.r = true;
            return;
        }
        a.InterfaceC0778a interfaceC0778a = this.h;
        if (interfaceC0778a != null) {
            interfaceC0778a.a(map);
        }
    }
}
