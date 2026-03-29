package com.opos.mobad.video.player.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<Class> f10299a = new LinkedList();
    private static Handler f;
    private a b;
    private b c;
    private boolean d;
    private boolean e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b();
    }

    public d(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        f = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d = true;
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = false;
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
        boolean z2;
        super.onWindowFocusChanged(z);
        com.opos.cmn.an.f.a.b("VisibilityMonitorView", "onViewVisible hasWindowFocus=" + z);
        if (!z) {
            z2 = false;
        } else if (getVisibility() != 0 || !isShown()) {
            return;
        } else {
            z2 = true;
        }
        a(z2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }

    private void a(int i) {
        boolean z;
        com.opos.cmn.an.f.a.b("VisibilityMonitorView", "visibility change = " + i + "," + this.e + "," + a());
        if (i != 0) {
            z = false;
        } else if (getVisibility() != 0 || !a() || !isShown()) {
            return;
        } else {
            z = true;
        }
        a(z);
    }

    public void a(a aVar) {
        this.b = aVar;
        if (!this.d || aVar == null) {
            return;
        }
        f.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (!d.this.d || d.this.b == null) {
                    return;
                }
                d.this.b.a(d.this.e);
            }
        });
    }

    public void a(final boolean z) {
        if (this.e == (!z)) {
            this.e = z;
            if (this.b != null) {
                f.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.b != null) {
                            d.this.b.a(z);
                        }
                    }
                });
            }
        }
    }

    private boolean a() {
        List<Class> list;
        View rootView = getRootView();
        if (rootView != null && (list = f10299a) != null && !list.isEmpty()) {
            for (Class cls : f10299a) {
                if (cls.isAssignableFrom(rootView.getClass())) {
                    com.opos.cmn.an.f.a.b("VisibilityMonitorView", "filter for " + cls.getName());
                    return true;
                }
            }
        }
        return hasWindowFocus();
    }
}
