package com.opos.mobad.video.player.e;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.video.player.c.a.a;
import com.opos.mobad.video.player.c.c;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements a.InterfaceC0809a, a.b, a.c, a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10340a;
    private final a b;
    private a.c.InterfaceC0810a c;
    private WebView d;
    private final Context e;
    private a.d.InterfaceC0811a f;
    private a.b g;

    public f(Context context, b bVar, a aVar) {
        this.f10340a = bVar;
        this.b = aVar;
        this.e = context;
        h();
    }

    private void h() {
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar;
        b bVar = this.f10340a;
        if (bVar == null || (aVar = bVar.j) == null) {
            return;
        }
        a(aVar);
        aVar.a((a.c) this);
        aVar.a((a.d) this);
        aVar.a((a.InterfaceC0809a) this);
        aVar.a((a.b) this);
    }

    private WebView i() {
        WebView webView = this.d;
        if (webView != null) {
            return webView;
        }
        WebView webViewA = com.opos.mobad.video.player.c.c.a(this.e, (com.opos.cmn.biz.web.b.a.a.a) null, (Map<String, Object>) null, new c.a() { // from class: com.opos.mobad.video.player.e.f.2
            @Override // com.opos.mobad.video.player.c.c.a
            public void a() {
                if (f.this.f != null) {
                    f.this.f.d();
                }
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void b() {
                if (f.this.f != null) {
                    f.this.f.e();
                }
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void c() {
                if (f.this.f != null) {
                    f.this.f.e();
                }
            }
        });
        this.d = webViewA;
        return webViewA;
    }

    public void c(long j, long j2) {
        a.c.InterfaceC0810a interfaceC0810a = this.c;
        if (interfaceC0810a != null) {
            interfaceC0810a.c(j, j2);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void d() {
        com.opos.mobad.template.a aVar;
        b bVar = this.f10340a;
        if (bVar == null || (aVar = bVar.b) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void e() {
        com.opos.mobad.template.a aVar;
        b bVar = this.f10340a;
        if (bVar == null || (aVar = bVar.b) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public View f() {
        return i();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void g() {
        i().destroy();
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void a() {
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void b() {
    }

    @Override // com.opos.mobad.video.player.c.a.a.b
    public boolean c() {
        a.b bVar = this.g;
        return bVar != null && bVar.c();
    }

    public void a(int i, String str) {
        a.c.InterfaceC0810a interfaceC0810a = this.c;
        if (interfaceC0810a != null) {
            interfaceC0810a.c();
        }
    }

    public void b(long j, long j2) {
        a.c.InterfaceC0810a interfaceC0810a = this.c;
        if (interfaceC0810a != null) {
            interfaceC0810a.b(j, j2);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void a(int i, int[] iArr) {
        b bVar;
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar;
        a aVar2 = this.b;
        if (aVar2 == null || (bVar = this.f10340a) == null || (aVar = bVar.j) == null) {
            return;
        }
        aVar2.a(aVar.a(), iArr, com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE);
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void b(String str) {
        i().evaluateJavascript(str, null);
    }

    public void a(long j, long j2) {
        a.c.InterfaceC0810a interfaceC0810a = this.c;
        if (interfaceC0810a != null) {
            interfaceC0810a.a(j, j2);
        }
    }

    public void a(a.b bVar) {
        this.g = bVar;
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void a(a.c.InterfaceC0810a interfaceC0810a) {
        this.c = interfaceC0810a;
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(a.d.InterfaceC0811a interfaceC0811a) {
        this.f = interfaceC0811a;
    }

    private void a(final com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar) {
        FrameLayout frameLayoutA;
        if (aVar == null || (frameLayoutA = aVar.a()) == null) {
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.e, 20.0f);
        ImageView imageView = new ImageView(this.e);
        imageView.setImageResource(R.drawable.opos_mob_drawable_light_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 5;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.e, 49.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.e, 16.0f);
        frameLayoutA.addView(imageView, layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.e.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.opos.mobad.template.a aVar2;
                aVar.b();
                if (f.this.f10340a == null || (aVar2 = f.this.f10340a.b) == null) {
                    return;
                }
                aVar2.b();
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(Object obj, String str) {
        try {
            i().addJavascriptInterface(obj, str);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightController", "addJavascriptInterface", th);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(String str) {
        i().loadUrl(str);
    }
}
