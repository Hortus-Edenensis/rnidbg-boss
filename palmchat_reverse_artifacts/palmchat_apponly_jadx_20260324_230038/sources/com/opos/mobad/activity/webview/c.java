package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.SystemClock;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.d.e.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c implements com.opos.mobad.activity.webview.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.activity.webview.c.a f8500a;
    private a b;
    private LinearLayout c;
    private View d;
    private View e;
    private View f;
    private Context g;
    private int h;
    private boolean i;
    private com.opos.mobad.d.e.a j;
    private com.opos.cmn.biz.web.b.a.a k;
    private String l;
    private String m;
    private String n;
    private boolean o = false;
    private final AtomicInteger p = new AtomicInteger(0);
    private final AtomicLong q = new AtomicLong(SystemClock.elapsedRealtime());
    private a.InterfaceC0735a r = new a.InterfaceC0735a() { // from class: com.opos.mobad.activity.webview.c.6
        @Override // com.opos.mobad.d.e.a.InterfaceC0735a
        public void a(boolean z) {
            a aVar;
            boolean z2;
            com.opos.cmn.an.f.a.b("WebViewEngine", "onViewVisibile = " + z + "," + c.this.j);
            if (c.this.b != null) {
                if (!z) {
                    aVar = c.this.b;
                    z2 = false;
                } else {
                    if (c.this.j == null || c.this.j.getVisibility() != 0) {
                        return;
                    }
                    aVar = c.this.b;
                    z2 = true;
                }
                aVar.a(z2);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(boolean z);

        void b();

        void b(boolean z);

        void c();

        void d();
    }

    public c(final Activity activity, final com.opos.mobad.b bVar, d dVar) {
        if (activity == null || dVar == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        this.g = applicationContext;
        this.l = applicationContext.getResources().getString(R.string.opos_mob_web_ssl_error_tips);
        this.m = this.g.getResources().getString(R.string.opos_mob_web_ssl_error_confirm);
        this.n = this.g.getResources().getString(R.string.opos_mob_web_ssl_error_cancel);
        this.k = new com.opos.cmn.biz.web.b.a.a(com.opos.mobad.service.a.a(this.g), new b.a().a(new com.opos.cmn.biz.web.b.a.a.b() { // from class: com.opos.mobad.activity.webview.c.3
            @Override // com.opos.cmn.biz.web.b.a.a.b
            public void c() {
                if (c.this.b != null) {
                    c.this.b.a();
                }
            }
        }).a(new com.opos.cmn.biz.web.b.a.a.c() { // from class: com.opos.mobad.activity.webview.c.2
            @Override // com.opos.cmn.biz.web.b.a.a.c
            public void a(String str) {
                com.opos.cmn.an.f.a.b("WebViewEngine", "webView to deeplink: " + c.this.p.incrementAndGet());
                if (c.this.b != null) {
                    c.this.b.d();
                }
            }

            @Override // com.opos.cmn.biz.web.b.a.a.c
            public boolean b(String str) {
                return true;
            }
        }).a(dVar.f8512a).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.activity.webview.c.1
            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage(c.this.l);
                    builder.setPositiveButton(c.this.m, new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sslErrorHandler.proceed();
                        }
                    });
                    builder.setNegativeButton(c.this.n, new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sslErrorHandler.cancel();
                            c.this.k();
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setCancelable(false);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    alertDialogCreate.show();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("WebViewEngine", "", e);
                }
            }
        }).b(a(bVar)).a());
        if (dVar.c) {
            this.f8500a = new com.opos.mobad.activity.webview.c.a(activity.getApplicationContext(), this);
        }
        this.h = dVar.b;
        this.i = dVar.d;
        f();
    }

    private void h() {
        if (this.h == 2) {
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
            this.j = aVar;
            aVar.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (com.opos.cmn.an.h.f.a.b(this.g) * 9) / 16);
            this.j.a(this.r);
            this.c.addView(this.j, layoutParams);
        }
    }

    private void j() {
        LinearLayout linearLayout;
        View view = this.d;
        if (view == null || (linearLayout = this.c) == null) {
            return;
        }
        linearLayout.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void l() {
        a(this.f);
    }

    private void m() {
        com.opos.mobad.d.e.a aVar = this.j;
        if (aVar == null || aVar.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(8);
    }

    public View d() {
        return this.c;
    }

    private Map<String, Object> a(com.opos.mobad.b bVar) {
        HashMap map = new HashMap();
        map.put("activityExtraParams", g.a(bVar.e(), ""));
        return map;
    }

    private void f() {
        if (this.g != null) {
            LinearLayout linearLayout = new LinearLayout(this.g);
            this.c = linearLayout;
            linearLayout.setOrientation(1);
            this.c.setFitsSystemWindows(this.i);
            this.c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.activity.webview.c.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.activity.webview.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.b != null) {
                                c.this.b.c();
                            }
                        }
                    });
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }
            });
            g();
            h();
            i();
            com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(this.g);
            aVar.a(new a.InterfaceC0735a() { // from class: com.opos.mobad.activity.webview.c.5
                @Override // com.opos.mobad.d.e.a.InterfaceC0735a
                public void a(boolean z) {
                    if (z && !c.this.o && c.this.b != null) {
                        c.this.b.b();
                        c.this.o = true;
                    }
                    if (c.this.b != null) {
                        c.this.b.b(z);
                    }
                    com.opos.cmn.an.f.a.b("WebViewEngine", "emptyView:visible " + z);
                }
            });
            this.c.addView(aVar, 0, 0);
        }
    }

    private void g() {
        com.opos.mobad.activity.webview.c.a aVar = this.f8500a;
        if (aVar != null) {
            View viewA = aVar.a();
            this.e = viewA;
            if (viewA == null || this.c == null) {
                return;
            }
            this.c.addView(this.e, new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.g, 43.33f)));
        }
    }

    private void i() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            View viewB = aVar.b();
            this.d = viewB;
            if (viewB == null || this.c == null) {
                return;
            }
            viewB.setFitsSystemWindows(this.i);
            this.c.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void b() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar == null) {
            return;
        }
        if (aVar.c()) {
            k();
        } else {
            if (this.k.d()) {
                return;
            }
            k();
        }
    }

    @Override // com.opos.mobad.activity.webview.b.a
    public void c() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void e() {
        com.opos.cmn.an.f.a.b("WebViewEngine", "refresh for rotation");
        if (this.h == 2) {
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                j();
                l();
            } else {
                m();
                j();
            }
            i();
        }
    }

    public void a() {
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            com.opos.mobad.d.e.a aVar = this.j;
            if (aVar != null) {
                aVar.removeAllViews();
            }
            com.opos.cmn.biz.web.b.a.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    public void a(View view) {
        if (this.h == 2) {
            this.f = view;
            if (com.opos.cmn.an.h.f.a.d(this.g)) {
                View view2 = this.f;
                if (view2 != null && this.j.indexOfChild(view2) < 0) {
                    this.j.removeAllViews();
                    this.j.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
                }
                this.j.setVisibility(0);
            }
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(String str) {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            aVar.a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("showWebPageWithString url=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("WebViewEngine", sb.toString());
    }
}
