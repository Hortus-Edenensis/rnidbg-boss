package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.opos.cmn.biz.web.c.b.c;
import com.opos.mobad.cmn.func.adhandler.UnlockHandler;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f8498a;
    private c b;
    private WebDataHepler c;
    private Activity d;
    private com.opos.mobad.b e;
    private C0713b f;
    private com.opos.mobad.activity.a g;
    private a h;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: com.opos.mobad.activity.webview.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0713b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.cmn.func.a f8499a;
        public final com.opos.mobad.activity.webview.a.a b;
        public final com.opos.mobad.activity.webview.a.b c;

        private C0713b(com.opos.mobad.activity.webview.a.b bVar, com.opos.mobad.activity.webview.a.a aVar, com.opos.mobad.cmn.func.a aVar2) {
            this.f8499a = aVar2;
            this.b = aVar;
            this.c = bVar;
        }

        public static C0713b a(Activity activity, com.opos.mobad.b bVar, String str) {
            com.opos.mobad.cmn.func.a aVarC;
            com.opos.mobad.activity.webview.a.a aVar;
            com.opos.mobad.activity.webview.a.b bVarA;
            com.opos.mobad.activity.webview.a aVarD = com.opos.mobad.cmn.service.a.a().d();
            if (aVarD == null || (aVarC = com.opos.mobad.cmn.service.a.a().c()) == null || (bVarA = aVarD.a(activity, new c.a().b("ad_mob").a(true).a(str).a(), (aVar = new com.opos.mobad.activity.webview.a.a(bVar, new UnlockHandler(activity))))) == null) {
                return null;
            }
            return new C0713b(bVarA, aVar, aVarC);
        }

        public void a() {
            com.opos.mobad.activity.webview.a.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
            com.opos.mobad.activity.webview.a.a aVar = this.b;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    public b(Activity activity, com.opos.mobad.b bVar, WebDataHepler webDataHepler) {
        this.d = activity;
        this.e = bVar.c();
        this.c = webDataHepler;
        this.f = C0713b.a(activity, bVar, webDataHepler.c());
    }

    public void a() {
        com.opos.cmn.an.f.a.b("WebPresenter", "render");
        if (this.f8498a != null) {
            return;
        }
        a(this.f);
        this.f8498a.a(this.c);
    }

    public void b() {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    public View c() {
        c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    public void d() {
        C0713b c0713b = this.f;
        if (c0713b != null) {
            c0713b.a();
        }
        e eVar = this.f8498a;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void a(com.opos.mobad.activity.a aVar) {
        this.g = aVar;
        e eVar = this.f8498a;
        if (eVar != null) {
            eVar.a((com.opos.mobad.activity.webview.b.c) aVar);
            this.f8498a.a((com.opos.mobad.activity.webview.b.d) aVar);
        }
    }

    public void a(a aVar) {
        this.h = aVar;
        C0713b c0713b = this.f;
        if (c0713b != null) {
            c0713b.b.a(aVar);
        }
        e eVar = this.f8498a;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    private void a(C0713b c0713b) {
        if (this.f8498a != null) {
            return;
        }
        HashMap map = new HashMap();
        if (c0713b != null) {
            map.put("mixad", c0713b.c);
        } else {
            com.opos.cmn.an.f.a.b("WebPresenter", "null jsEngine");
        }
        c cVar = new c(this.d, this.e, new d(map, this.c.f(), this.c.h(), this.c.i()));
        this.b = cVar;
        e eVar = new e(this.d, this.e, cVar);
        this.f8498a = eVar;
        com.opos.mobad.activity.a aVar = this.g;
        if (aVar != null) {
            eVar.a((com.opos.mobad.activity.webview.b.c) aVar);
            this.f8498a.a((com.opos.mobad.activity.webview.b.d) this.g);
        }
        a aVar2 = this.h;
        if (aVar2 != null) {
            this.f8498a.a(aVar2);
        }
        if (c0713b != null) {
            c0713b.b.a(this.f8498a, this.c, c0713b.f8499a);
            c0713b.b.a(this.h);
        }
    }

    public void a(com.opos.mobad.p.a aVar) {
        C0713b c0713b = this.f;
        if (c0713b != null) {
            c0713b.b.a(aVar);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        e eVar = this.f8498a;
        return eVar != null && eVar.a(i, keyEvent);
    }
}
