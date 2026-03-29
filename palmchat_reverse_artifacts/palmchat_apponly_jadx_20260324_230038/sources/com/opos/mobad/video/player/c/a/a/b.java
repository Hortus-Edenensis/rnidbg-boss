package com.opos.mobad.video.player.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.opos.mobad.video.player.c.a.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b>, a.c.InterfaceC0810a, a.d.InterfaceC0811a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f10287a;
    private a.c b;
    private C0813b c;
    private com.opos.mobad.video.player.c.a.a.a d;
    private d e;
    private FrameLayout f;
    private boolean g;
    private boolean h;
    private boolean i;
    private a k;
    private a.b l;
    private final Handler j = new Handler(Looper.getMainLooper());
    private long m = -1;
    private long n = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements a.InterfaceC0809a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CopyOnWriteArrayList<a.InterfaceC0809a> f10290a;

        private a() {
            this.f10290a = new CopyOnWriteArrayList<>();
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
        public void a() {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveShow");
            Iterator<a.InterfaceC0809a> it = this.f10290a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
        public void b() {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveDismiss");
            Iterator<a.InterfaceC0809a> it = this.f10290a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
        public void a(int i, int[] iArr) {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveClick");
            Iterator<a.InterfaceC0809a> it = this.f10290a.iterator();
            while (it.hasNext()) {
                it.next().a(i, iArr);
            }
        }

        public void a(a.InterfaceC0809a interfaceC0809a) {
            if (this.f10290a.contains(interfaceC0809a)) {
                return;
            }
            this.f10290a.add(interfaceC0809a);
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0813b implements a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a.d f10291a;
        private boolean b;

        private C0813b() {
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(a.d.InterfaceC0811a interfaceC0811a) {
            a.d dVar = this.f10291a;
            if (b(dVar)) {
                return;
            }
            dVar.a(interfaceC0811a);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void b(String str) {
            a.d dVar = this.f10291a;
            if (b(dVar)) {
                return;
            }
            dVar.b(str);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public View f() {
            a.d dVar = this.f10291a;
            if (dVar != null) {
                return dVar.f();
            }
            return null;
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void g() {
            this.b = true;
            a.d dVar = this.f10291a;
            if (dVar != null) {
                dVar.g();
            }
        }

        private boolean b(a.d dVar) {
            return dVar == null || this.b;
        }

        public void a(a.d dVar) {
            this.f10291a = dVar;
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(Object obj, String str) {
            a.d dVar = this.f10291a;
            if (b(dVar)) {
                return;
            }
            dVar.a(obj, str);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(String str) {
            a.d dVar = this.f10291a;
            if (b(dVar)) {
                return;
            }
            dVar.a(str);
        }
    }

    public b(Context context) {
        this.c = new C0813b();
        this.f10287a = new c(context, this);
        this.e = new d(context);
        this.k = new a();
        this.f10287a.a(this.c);
        this.f10287a.a(this.k);
        this.k.a(this.f10287a);
        this.e.setVisibility(4);
        this.e.a(this.f10287a);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        this.e.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public FrameLayout a() {
        return this.e;
    }

    @Override // com.opos.mobad.video.player.c.a.a.d.InterfaceC0811a
    public void e() {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "web onLoadFail,position=" + this.m + ",duration=" + this.n);
        this.h = false;
        b();
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void b() {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "destroy,isWebClosed=" + this.i);
        if (this.i) {
            return;
        }
        this.i = true;
        this.k.b();
        this.e.setVisibility(8);
        this.c.g();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void c() {
        this.f10287a.c();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d.InterfaceC0811a
    public void d() {
        this.h = true;
        com.opos.cmn.an.f.a.a("TTLightInteractive", "web onLoadSuccess,position=" + this.m + ",duration=" + this.n);
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void a(final long j, final long j2) {
        this.m = j;
        this.n = j2;
        this.j.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.i) {
                    return;
                }
                if (b.this.l == null || !b.this.l.c()) {
                    b.this.f10287a.a(j, j2);
                    View viewF = b.this.c.f();
                    if (!b.this.g && b.this.d != null) {
                        String strB = b.this.d.b();
                        if (!TextUtils.isEmpty(strB)) {
                            b.this.g = true;
                            b.this.c.a(strB);
                            com.opos.cmn.an.f.a.a("TTLightInteractive", "loadUrl,h=" + (viewF != null ? viewF.getHeight() : 0) + ",w=" + (viewF != null ? viewF.getWidth() : 0) + ",webUrl=" + strB);
                        }
                    }
                    long jD = b.this.d != null ? b.this.d.d() : 3000L;
                    if (!b.this.h || j <= jD || viewF == null || b.this.e.isShown()) {
                        return;
                    }
                    b.this.k.a();
                    b.this.e.setVisibility(0);
                }
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void b(long j, long j2) {
        this.f10287a.b(j, j2);
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void c(long j, long j2) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "onComplete,position=" + j + ",duration=" + j2);
        this.f10287a.c(j, j2);
        b();
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(a.InterfaceC0809a interfaceC0809a) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setInteractiveListener,listener=" + interfaceC0809a);
        this.k.a(interfaceC0809a);
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(a.b bVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setIInterceptor,interceptor=" + bVar);
        this.l = bVar;
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(a.c cVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setPlayer,player=" + cVar);
        this.b = cVar;
        this.f10287a.a(cVar);
        a.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(this);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(a.d dVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setWebView,webView=" + dVar);
        this.c.a(dVar);
        this.j.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                View viewF = b.this.c.f();
                if (viewF != null) {
                    b.this.f.removeAllViews();
                    ViewParent parent = viewF.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewF);
                    }
                    b.this.f.addView(viewF, new FrameLayout.LayoutParams(-1, -1));
                    b.this.c.a(b.this.f10287a, "nativeGlobal");
                    b.this.c.a(b.this);
                    b.this.e.setBackgroundColor(0);
                    viewF.setBackgroundColor(0);
                    viewF.setLayerType(1, null);
                    com.opos.cmn.an.f.a.a("TTLightInteractive", "setWebView,add view=" + viewF);
                }
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.b bVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "bindData,ITTLightData=" + bVar);
        com.opos.mobad.video.player.c.a.a.a aVar = new com.opos.mobad.video.player.c.a.a.a(bVar);
        this.d = aVar;
        this.f10287a.a(aVar);
    }
}
