package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.opos.mobad.ui.a.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10206a;

    public h(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        super(context, dVar, frameLayout, z);
        this.f10206a = false;
    }

    @Override // com.opos.mobad.ui.a.a
    public void O() {
        com.opos.cmn.an.f.a.b("MediaCreative", "resetDisappearTime");
        this.H.removeMessages(1);
        if ((this.y || this.w) && !this.x) {
            this.H.sendMessageDelayed(this.H.obtainMessage(1), 3000L);
        }
    }

    @Override // com.opos.mobad.ui.a.a
    public void P() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch");
        int iC = k.a().c(this.B);
        if (iC == 2) {
            com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowPauseCover" + this.y);
            if (this.y) {
                G();
                A();
            } else {
                F();
                z();
            }
        }
        if (iC != 3) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowContinueCover" + this.x);
        if (this.x) {
            C();
            A();
        } else {
            B();
            z();
        }
    }

    public void Q() {
        com.opos.cmn.an.f.a.b("MediaCreative", "pauseVideo");
        k.a().b(this.B);
    }

    public long R() {
        if (k.a() != null) {
            return k.a().d(this.B);
        }
        return -1L;
    }

    public void S() {
        k.a().c();
    }

    public void T() {
        this.H.removeMessages(1);
    }

    public void U() {
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(k.a().e(this.B));
        }
    }

    public void V() {
        d dVar = this.v;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void W() {
        this.f10206a = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.2
            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                ImageView imageView = hVar.m;
                if (imageView != null) {
                    hVar.e.removeView(imageView);
                }
                Bitmap bitmap = h.this.n;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                h.this.n.recycle();
            }
        });
    }

    public void X() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitCoverStatus");
        r();
        D();
        y();
        u();
        K();
        I();
        w();
        u();
    }

    public void Y() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitBufferCoverStatus");
        r();
        L();
        C();
        G();
        K();
    }

    public void Z() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitWifiCoverStatus");
        r();
        v();
        C();
        G();
        K();
        u();
    }

    public void a(long j) {
        com.opos.cmn.an.f.a.b("MediaCreative", "seekTo:" + j);
        if (k.a() != null) {
            k.a().a(this.B, j);
        }
    }

    public abstract void a(String str);

    public void aa() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitClickBufferStatus");
        L();
        w();
        u();
        G();
        C();
    }

    public void ab() {
        L();
        w();
        C();
        G();
        u();
    }

    public void ac() {
        M();
    }

    public void ad() {
        p();
        M();
        s();
        E();
        w();
        K();
        u();
        G();
    }

    public void ae() {
        I();
        M();
        K();
        u();
        B();
    }

    public void af() {
        p();
        M();
        s();
        K();
        E();
        w();
        u();
        F();
        O();
    }

    public void ag() {
        M();
        G();
        C();
        q();
        r();
        J();
    }

    public void ah() {
        M();
        G();
        C();
        w();
        t();
    }

    @Override // com.opos.mobad.d.d.b
    public void c() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPrepare,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f != null) {
                    hVar.C = 0;
                    hVar.g.setProgress(0);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void d() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onStart,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.4
            @Override // java.lang.Runnable
            public void run() {
                TextView textView;
                if (h.this.f10206a) {
                    return;
                }
                h hVar = h.this;
                hVar.a(hVar.d);
                h hVar2 = h.this;
                if (hVar2.f != null && (textView = hVar2.i) != null) {
                    textView.setText(com.opos.mobad.cmn.func.b.f.a(k.a().d(h.this.B)));
                }
                h.this.ad();
                h hVar3 = h.this;
                d dVar = hVar3.v;
                if (dVar != null) {
                    dVar.a(hVar3.o);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void e() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onComplete,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f != null) {
                    hVar.g.setProgress(100);
                }
                h.this.ag();
                h hVar2 = h.this;
                d dVar = hVar2.v;
                if (dVar != null) {
                    dVar.b(hVar2.o);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void f() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onResume,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.7
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h hVar = h.this;
                if (hVar.f != null && hVar.i != null && hVar.h != null) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "onResume:" + com.opos.mobad.cmn.func.b.f.a(k.a().d(h.this.B)));
                    long jD = k.a().d(h.this.B);
                    h.this.i.setText(com.opos.mobad.cmn.func.b.f.a(jD));
                    long jE = k.a().e(h.this.B);
                    h.this.h.setText(com.opos.mobad.cmn.func.b.f.a(jE));
                    if (jD != 0) {
                        int i = (int) ((jE * 100) / jD);
                        h.this.g.setProgress(i);
                        h.this.C = i;
                    }
                }
                h.this.af();
                h hVar2 = h.this;
                d dVar = hVar2.v;
                if (dVar != null) {
                    dVar.b(hVar2.o, k.a().e(h.this.B));
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void g() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPause,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.8
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h.this.ae();
                h hVar = h.this;
                d dVar = hVar.v;
                if (dVar != null) {
                    dVar.a(hVar.o, k.a().e(h.this.B));
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void h() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingStart");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.10
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h.this.ab();
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void i() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingEnd");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.11
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h.this.ac();
            }
        });
    }

    @Override // com.opos.mobad.ui.a.a
    public void r() {
        ImageView imageView;
        if (this.d == null || (imageView = this.m) == null || imageView.getDrawable() != null) {
            super.r();
        } else if (a(this.d)) {
            super.r();
        } else {
            s();
        }
    }

    public void a(long j, long j2) {
        if (this.f == null || k.a().c(this.B) != 2) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "currentPosition=" + j + ",totalPosition=" + j2);
        if (j < 0 || j2 <= 0) {
            this.g.setProgress(0);
            return;
        }
        this.h.setText(com.opos.mobad.cmn.func.b.f.a(500 + j));
        int i = (int) ((j * 100) / j2);
        com.opos.cmn.an.f.a.b("MediaCreative", "currentProgress=" + i + ",mLastProgress=" + this.C);
        if (i - this.C >= 1) {
            this.g.setProgress(i);
        }
        this.C = i;
    }

    private void a(Context context, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.3
            @Override // java.lang.Runnable
            public void run() {
                String strA = com.opos.cmn.d.d.a(h.this.c, str);
                boolean zIsEmpty = TextUtils.isEmpty(strA);
                if (zIsEmpty) {
                    strA = str;
                }
                final Bitmap bitmapA = com.opos.mobad.mediaplayer.a.b.a(strA, zIsEmpty);
                if (bitmapA == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.ui.a.h.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.m.setImageBitmap(bitmapA);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.ui.a.f
    public void a(final String str, final long j) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.9
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                if (!TextUtils.isEmpty(h.this.B) && h.this.B.equals(str)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "mCountDown:" + k.a().e(h.this.B));
                    h hVar = h.this;
                    if (hVar.D && hVar.f != null) {
                        h.this.a(j, hVar.R());
                    }
                    h hVar2 = h.this;
                    d dVar = hVar2.v;
                    if (dVar != null) {
                        dVar.c(hVar2.o, j);
                    }
                }
                h.this.s();
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void a(final Map<String, String> map) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onError,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f10206a) {
                    return;
                }
                h.this.ah();
                d dVar = h.this.v;
                if (dVar != null) {
                    dVar.a(map);
                }
            }
        });
    }

    public boolean a(a.C0803a c0803a) {
        ImageView imageView = this.m;
        if (imageView != null) {
            if (imageView.getDrawable() != null) {
                com.opos.cmn.an.f.a.b("MediaCreative", "createAndLoadCoverImg cover is not null ");
                return true;
            }
            if (c0803a != null) {
                String str = c0803a.f10203a;
                if (!TextUtils.isEmpty(str)) {
                    a(str);
                    return true;
                }
                String str2 = c0803a.b;
                if (TextUtils.isEmpty(str2)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "videoUrl is empty");
                    return false;
                }
                a(this.c, str2);
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.mobad.d.d.b
    public void j() {
    }
}
