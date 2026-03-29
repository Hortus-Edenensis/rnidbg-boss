package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.opos.cmn.i.g;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.cmn.a.e;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.p.a;
import com.opos.mobad.p.b;
import com.opos.mobad.p.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AdBaseActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.activity.webview.b f8466a;
    private com.opos.mobad.p.b b;
    private e c;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        finish();
    }

    public abstract void a(Intent intent);

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b("AdActivity", "onConfigurationChanged newConfig=" + configuration.toString());
        com.opos.mobad.activity.webview.b bVar = this.f8466a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        h.a(this);
        g.b(this);
        super.onCreate(bundle);
        this.b = new b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.1
            @Override // com.opos.mobad.p.b
            public void a() throws RemoteException {
                AdBaseActivity.this.a();
            }
        };
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        a(getIntent());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        com.opos.mobad.activity.webview.b bVar = this.f8466a;
        if (bVar != null) {
            bVar.d();
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        com.opos.mobad.activity.webview.b bVar = this.f8466a;
        if (bVar != null && bVar.a(i, keyEvent)) {
            return true;
        }
        e eVar = this.c;
        if (eVar == null || !eVar.a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("AdActivity", "onNewIntent");
        setIntent(intent);
        b(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("AdActivity", "onPause");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("AdActivity", "onStart");
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("AdActivity", "onStop");
    }

    public void b(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        com.opos.mobad.activity.webview.b bVar = this.f8466a;
        if (bVar != null) {
            bVar.d();
        }
        a(intent);
    }

    private void a(WebDataHepler webDataHepler, final com.opos.mobad.p.a aVar) {
        e eVar = new e(new com.opos.mobad.activity.webview.b.c() { // from class: com.opos.mobad.activity.AdBaseActivity.2
            @Override // com.opos.mobad.activity.webview.b.c
            public void a() {
                com.opos.mobad.p.a aVar2 = aVar;
                if (aVar2 != null) {
                    try {
                        aVar2.a(AdBaseActivity.this.b);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("AdActivity", "show callback fail", e);
                    }
                }
            }

            @Override // com.opos.mobad.activity.webview.b.c
            public void b() {
                com.opos.mobad.p.a aVar2 = aVar;
                if (aVar2 != null) {
                    try {
                        aVar2.a();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("AdActivity", "close callback fail", e);
                    }
                }
            }
        });
        this.c = eVar;
        eVar.a(this, webDataHepler.f(), webDataHepler.g());
    }

    private void b(com.opos.mobad.b bVar, WebDataHepler webDataHepler, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar) {
        try {
            if (TextUtils.isEmpty(webDataHepler.d())) {
                com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                a();
                return;
            }
            com.opos.mobad.activity.webview.b bVar2 = this.f8466a;
            if (bVar2 != null) {
                bVar2.d();
            }
            com.opos.mobad.activity.webview.b bVar3 = new com.opos.mobad.activity.webview.b(this, bVar, webDataHepler);
            this.f8466a = bVar3;
            bVar3.a();
            this.f8466a.a(new a(aVar, this.b, cVar));
            this.f8466a.a(aVar);
            this.f8466a.a(new b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.3
                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    AdBaseActivity.this.a();
                }
            });
            setContentView(this.f8466a.c());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdActivity", "initWebView", (Throwable) e);
        }
    }

    public void a(com.opos.mobad.b bVar, Intent intent) {
        if (bVar == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "context not init");
            return;
        }
        if (intent != null) {
            try {
                WebDataHepler webDataHepler = (WebDataHepler) intent.getParcelableExtra("webData");
                IBinder binder = intent.getExtras().getBinder("webCallback");
                IBinder binder2 = intent.getExtras().getBinder("videoCallback");
                com.opos.mobad.p.a aVarA = binder != null ? a.AbstractBinderC0760a.a(binder) : null;
                com.opos.mobad.p.c cVarA = binder2 != null ? c.a.a(binder2) : null;
                if (webDataHepler != null) {
                    a(bVar, webDataHepler, aVarA, cVarA);
                    return;
                }
                com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                a();
                return;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdActivity", "handleAction", (Throwable) e);
            }
        } else {
            com.opos.cmn.an.f.a.b("AdActivity", "handle but intent null");
        }
        a();
    }

    public void a(com.opos.mobad.b bVar, WebDataHepler webDataHepler, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar) {
        if (com.opos.mobad.cmn.service.a.a().c() == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "handle but not init");
            return;
        }
        int iF = webDataHepler.f();
        if (iF == 1 || iF == 2) {
            h.a(this, "#F5EEEEEE");
            b(bVar, webDataHepler, aVar, cVar);
        } else if (iF == 3 || iF == 4 || iF == 5) {
            a(webDataHepler, aVar);
        } else {
            a();
        }
        com.opos.cmn.an.f.a.a("AdActivity", webDataHepler);
    }
}
