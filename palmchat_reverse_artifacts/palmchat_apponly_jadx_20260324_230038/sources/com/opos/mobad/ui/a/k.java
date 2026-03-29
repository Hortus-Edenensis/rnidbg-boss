package com.opos.mobad.ui.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f10226a;
    private RelativeLayout.LayoutParams b;
    private boolean c = false;
    private Handler d = new Handler(Looper.getMainLooper());
    private Runnable e = new Runnable() { // from class: com.opos.mobad.ui.a.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.h != null && k.this.h.i() == 2 && k.this.i != null) {
                k.this.i.a(k.this.g, k.this.h.d());
            }
            k.this.d.postDelayed(k.this.e, 1000L);
        }
    };
    private boolean f;
    private String g;
    private com.opos.mobad.d.d.a h;
    private a i;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements f {
        private boolean b = true;
        private f c;

        public a(f fVar) {
            this.c = fVar;
        }

        public void a() {
            this.b = false;
        }

        @Override // com.opos.mobad.d.d.b
        public void c() {
            if (this.b) {
                k.this.f = true;
            }
            k.this.d.post(k.this.e);
            f fVar = this.c;
            if (fVar != null) {
                fVar.c();
            }
            k.this.c = false;
            com.opos.cmn.an.f.a.b("VideoPlayer", "onPrepare url:" + k.this.g);
        }

        @Override // com.opos.mobad.d.d.b
        public void d() {
            if (this.b) {
                k.this.f = true;
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.d();
            }
            if (k.this.c) {
                k.this.d.post(new Runnable() { // from class: com.opos.mobad.ui.a.k.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (k.this.h != null && k.this.c) {
                            com.opos.cmn.an.f.a.b("VideoPlayer", "onStart but pauseVideo");
                            k.this.h.f();
                        }
                        k.this.c = false;
                    }
                });
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void e() {
            if (this.b) {
                k.this.f = false;
                k.this.c();
            }
            k.this.d.removeCallbacks(k.this.e);
            f fVar = this.c;
            if (fVar != null) {
                fVar.e();
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void f() {
            if (this.b) {
                k.this.f = true;
            }
            k.this.d.post(k.this.e);
            f fVar = this.c;
            if (fVar != null) {
                fVar.f();
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void g() {
            if (this.b) {
                k.this.f = false;
            }
            k.this.d.removeCallbacks(k.this.e);
            f fVar = this.c;
            if (fVar != null) {
                fVar.g();
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void h() {
            f fVar = this.c;
            if (fVar != null) {
                fVar.h();
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void i() {
            f fVar = this.c;
            if (fVar != null) {
                fVar.i();
            }
        }

        public void a(f fVar) {
            this.c = fVar;
        }

        @Override // com.opos.mobad.ui.a.f
        public void a(String str, long j) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(str, j);
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void a(Map<String, String> map) {
            if (this.b) {
                k.this.f = false;
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(map);
            }
        }

        @Override // com.opos.mobad.d.d.b
        public void j() {
        }
    }

    private k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.b = layoutParams;
        layoutParams.addRule(13);
    }

    public int c(String str) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0;
        }
        return aVar.i();
    }

    public long d(String str) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0L;
        }
        return aVar.c();
    }

    public long e(String str) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return 0L;
        }
        return aVar.d();
    }

    public static k a() {
        k kVar = f10226a;
        if (kVar == null) {
            synchronized (k.class) {
                kVar = f10226a;
                if (kVar == null) {
                    kVar = new k();
                    f10226a = kVar;
                }
            }
        }
        return kVar;
    }

    public void b(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.g) && this.g.equals(str)) {
                this.h.f();
                View viewB = this.h.b();
                ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(viewB);
                    }
                    relativeLayout.removeAllViews();
                    viewB.setLayoutParams(this.b);
                    relativeLayout.addView(viewB);
                    relativeLayout.bringToFront();
                }
                this.i.a(fVar);
                com.opos.mobad.d.d.a aVar = this.h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.d.d.a aVarA = com.opos.mobad.mediaplayer.b.d.a(applicationContext, i, aVar2);
        this.h = aVarA;
        this.g = str;
        this.f = true;
        aVarA.a(str);
        com.opos.mobad.d.d.a aVar3 = this.h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.h.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
    }

    public void a(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || b()) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null context=" + context + ",isplay:" + b() + ",url=" + str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (this.h != null) {
            if (!TextUtils.isEmpty(this.g) && this.g.equals(str)) {
                this.h.f();
                View viewB = this.h.b();
                ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                if (viewGroup == null || relativeLayout != viewGroup) {
                    com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
                    if (viewGroup != null) {
                        viewGroup.removeView(viewB);
                    }
                    relativeLayout.removeAllViews();
                    viewB.setLayoutParams(this.b);
                    relativeLayout.addView(viewB);
                    relativeLayout.bringToFront();
                }
                this.i.a(fVar);
                com.opos.mobad.d.d.a aVar = this.h;
                if (z) {
                    aVar.a(1.0f);
                } else {
                    aVar.a(0.0f);
                }
                this.h.g();
                return;
            }
            c();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.d.d.a aVarA = com.opos.mobad.mediaplayer.b.d.a(applicationContext, i, aVar2);
        this.h = aVarA;
        this.g = str;
        this.f = true;
        aVarA.a(str);
        com.opos.mobad.d.d.a aVar3 = this.h;
        if (z) {
            aVar3.a(1.0f);
        } else {
            aVar3.a(0.0f);
        }
        this.h.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
    }

    public void b(String str) {
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || this.h == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("VideoPlayer", "mExoVideoPlayer.getState()=" + this.h.i());
        if (this.h.i() == 1) {
            this.c = true;
        } else {
            this.h.f();
        }
    }

    public void c() {
        com.opos.cmn.an.f.a.b("VideoPlayer", "video player release");
        if (this.h != null) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.a();
                this.i = null;
            }
            this.d.removeCallbacks(this.e);
            this.h.f();
            final com.opos.mobad.d.d.a aVar2 = this.h;
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.ui.a.k.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.d.d.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.h();
                    }
                }
            });
            this.h = null;
            this.g = null;
            this.f = false;
        }
    }

    public void a(String str, long j) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return;
        }
        aVar.a(j);
    }

    public boolean b() {
        return this.f;
    }

    public void c(Context context, String str, int i, RelativeLayout relativeLayout, f fVar, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("VideoPlayer", "play with params null");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        com.opos.mobad.d.d.a aVar = this.h;
        if (aVar != null) {
            aVar.h();
        }
        a aVar2 = new a(fVar);
        this.i = aVar2;
        com.opos.mobad.d.d.a aVarA = com.opos.mobad.mediaplayer.b.d.a(applicationContext, i, aVar2);
        this.h = aVarA;
        aVarA.b().setLayoutParams(this.b);
        relativeLayout.addView(this.h.b());
        this.g = str;
        this.f = true;
        this.h.a(z ? 1.0f : 0.0f);
        this.h.a(str);
    }

    public void a(String str, ViewGroup viewGroup) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return;
        }
        View viewB = aVar.b();
        ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
        if (viewGroup2 != null && viewGroup != viewGroup2) {
            com.opos.cmn.an.f.a.b("VideoPlayer", "play to other media view");
            viewGroup2.removeView(viewB);
            viewGroup.removeAllViews();
            viewGroup.addView(viewB);
            viewGroup.bringToFront();
        }
        this.h.g();
    }

    public void a(String str, boolean z) {
        com.opos.mobad.d.d.a aVar;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(str) || (aVar = this.h) == null) {
            return;
        }
        aVar.a(z ? 1.0f : 0.0f);
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(this.g) && this.g.equals(str);
    }
}
