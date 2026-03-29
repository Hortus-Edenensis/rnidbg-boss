package com.opos.mobad.video.player.c;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.video.player.c.b;
import com.opos.mobad.video.player.c.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InteractiveData f10276a;
    private com.opos.mobad.b b;
    private WebView c;
    private AdHelper.a d;
    private InterfaceC0808a e;
    private boolean f = false;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0808a {
        void a();

        void b();
    }

    public a(com.opos.mobad.b bVar, AdHelper.a aVar, InteractiveData interactiveData) {
        this.b = bVar;
        this.d = aVar;
        this.f10276a = interactiveData;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.video.player.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f) {
                    return;
                }
                a.this.d();
            }
        });
    }

    private void i() {
        HashMap map = new HashMap();
        map.put("interactiveAd", new b(this.f10276a.a(), new b.a() { // from class: com.opos.mobad.video.player.c.a.2
            @Override // com.opos.mobad.video.player.c.b.a
            public boolean a() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive click");
                if (a.this.f) {
                    return false;
                }
                if (a.this.e != null) {
                    a.this.e.a();
                }
                a.this.g();
                a.this.h();
                return true;
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public void b() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive transform");
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.b();
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public boolean c() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive onClose");
                if (a.this.f) {
                    return false;
                }
                a.this.h();
                return true;
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public boolean a(Map<String, String> map2) {
                if (a.this.f) {
                    return false;
                }
                com.opos.cmn.an.f.a.b("ad_show", "interactive report");
                e.a(a.this.b, a.this.d.c.g(), a.this.d.c, a.this.d.d, String.valueOf(a.this.f10276a.c), map2);
                return true;
            }
        }));
        WebView webViewA = c.a(this.b.b(), (com.opos.cmn.biz.web.b.a.a.a) null, map, new c.a() { // from class: com.opos.mobad.video.player.c.a.3
            @Override // com.opos.mobad.video.player.c.c.a
            public void b() {
                a.this.d();
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void c() {
                a.this.d();
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void a() {
            }
        });
        this.c = webViewA;
        webViewA.setBackgroundColor(0);
        this.c.setLayerType(1, null);
    }

    public View a() {
        return this.c;
    }

    private void f() {
        WebView webView = this.c;
        if (webView != null) {
            webView.removeAllViews();
            this.c.stopLoading();
            this.c.getSettings().setJavaScriptEnabled(false);
            this.c.getSettings().setSavePassword(false);
            this.c.clearHistory();
            this.c.destroyDrawingCache();
            this.c.destroy();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (TextUtils.isEmpty(this.f10276a.d)) {
            return;
        }
        com.opos.mobad.o.a.a(this.b.b(), this.f10276a.d);
        Toast.makeText(this.b.b(), "礼包码已复制，打开应用领取吧！", 1).show();
    }

    public void a(InterfaceC0808a interfaceC0808a) {
        this.e = interfaceC0808a;
    }

    public void b() {
        if (this.f) {
            return;
        }
        this.c.loadUrl("https://adsfs.heytapimage.com/mp/static/light-interactive/index.html?templateId=" + this.f10276a.c);
        this.c.setVisibility(0);
        com.opos.mobad.b bVar = this.b;
        String strG = this.d.c.g();
        AdHelper.a aVar = this.d;
        e.a(bVar, strG, aVar.c, aVar.d, String.valueOf(this.f10276a.c));
    }

    public boolean c() {
        if (!d()) {
            return false;
        }
        com.opos.mobad.b bVar = this.b;
        String strG = this.d.c.g();
        AdHelper.a aVar = this.d;
        e.b(bVar, strG, aVar.c, aVar.d, String.valueOf(this.f10276a.c));
        return true;
    }

    public boolean d() {
        if (this.f || this.c.getVisibility() != 0) {
            return false;
        }
        this.c.setVisibility(8);
        return true;
    }

    public void e() {
        d();
        this.f = true;
        f();
        this.e = null;
    }
}
