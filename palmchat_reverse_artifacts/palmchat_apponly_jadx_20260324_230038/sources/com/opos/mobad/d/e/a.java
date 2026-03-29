package com.opos.mobad.d.e;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<Class> f8759a = new LinkedList();
    private static Handler l;
    private InterfaceC0735a b;
    private b c;
    private c d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private View j;
    private Rect k;

    /* JADX INFO: renamed from: com.opos.mobad.d.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0735a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(boolean z, boolean z2);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        l = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e = true;
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = false;
        b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        a(i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.opos.cmn.an.f.a.b("StatusMediaView", "onViewVisibile hasWindowFocus=" + z);
        boolean z2 = getVisibility() == 0 && isShown();
        if (z) {
            if (z2) {
                a(true);
                b(true);
                return;
            }
            return;
        }
        a(false);
        if (z2) {
            b(false);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }

    private void a(int i) {
        com.opos.cmn.an.f.a.b("StatusMediaView", "visibility change = " + i + "," + this.f + "," + a() + "," + this.g);
        if (i != 0) {
            a(false);
            return;
        }
        if (getVisibility() == 0 && a() && isShown()) {
            a(true);
        }
        if (getVisibility() == 0 && isShown()) {
            b(true);
        }
    }

    public void b(boolean z) {
        if (this.g == (!z)) {
            this.g = z;
            if (this.d != null) {
                l.post(new Runnable() { // from class: com.opos.mobad.d.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.d != null) {
                            if (a.this.j != null && a.this.k != null) {
                                a aVar = a.this;
                                aVar.i = aVar.j.getGlobalVisibleRect(a.this.k);
                                a aVar2 = a.this;
                                aVar2.h = aVar2.j.isAttachedToWindow();
                            }
                            a.this.d.a(a.this.i, a.this.h);
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0735a interfaceC0735a) {
        this.b = interfaceC0735a;
        if (!this.e || interfaceC0735a == null) {
            return;
        }
        l.post(new Runnable() { // from class: com.opos.mobad.d.e.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.e || a.this.b == null) {
                    return;
                }
                a.this.b.a(a.this.f);
            }
        });
    }

    public void a(b bVar) {
        this.c = bVar;
        if (!this.e || bVar == null) {
            return;
        }
        bVar.b();
    }

    public void a(c cVar, View view) {
        this.d = cVar;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        if (view != null) {
            view.getLocationOnScreen(iArr);
            this.h = isAttachedToWindow();
            this.i = view.getGlobalVisibleRect(rect);
            this.j = view;
            this.k = rect;
        }
        if (!this.e || this.d == null) {
            return;
        }
        l.post(new Runnable() { // from class: com.opos.mobad.d.e.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.e || a.this.d == null) {
                    return;
                }
                a.this.d.a(a.this.i, a.this.h);
            }
        });
    }

    public void a(final boolean z) {
        if (this.f == (!z)) {
            this.f = z;
            if (this.b != null) {
                l.post(new Runnable() { // from class: com.opos.mobad.d.e.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(z);
                        }
                    }
                });
            }
        }
    }

    private boolean a() {
        List<Class> list;
        View rootView = getRootView();
        if (rootView != null && (list = f8759a) != null && !list.isEmpty()) {
            for (Class cls : f8759a) {
                if (cls.isAssignableFrom(rootView.getClass())) {
                    com.opos.cmn.an.f.a.b("StatusMediaView", "filter for " + cls.getName());
                    return true;
                }
            }
        }
        return hasWindowFocus();
    }
}
