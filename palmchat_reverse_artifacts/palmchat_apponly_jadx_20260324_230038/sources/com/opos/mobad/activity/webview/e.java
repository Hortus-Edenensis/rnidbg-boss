package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.opos.acs.st.STManager;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.c;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f8513a;
    private com.opos.mobad.b b;
    private c c;
    private com.opos.mobad.activity.c d;
    private WebDataHepler e;
    private com.opos.mobad.activity.webview.b.c f;
    private com.opos.mobad.activity.webview.b.d g;
    private MaterialData h;
    private Map<String, String> i;
    private b.a k;
    private int j = 0;
    private c.b l = new c.b() { // from class: com.opos.mobad.activity.webview.e.2
        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "notifyInstallCompletedEvent pkgName =" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e.this.a(200, 100, "", str, (String) null);
            e.this.b.l().c(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private com.opos.mobad.cmn.service.a.c m = new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.activity.webview.e.3
        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void b(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void c(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void d(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void e(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void f(int i, int i2, String str, String str2) {
            e.this.a(i, i2, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i, int i2, String str, String str2, String str3) {
            e.this.a(i, i2, str, str2, str3);
        }
    };
    private c.a n = new c.a() { // from class: com.opos.mobad.activity.webview.e.4
        @Override // com.opos.mobad.activity.webview.c.a
        public void a() {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onUserClose");
            if (e.this.k != null) {
                e.this.k.a();
            }
            if (e.this.j == 1) {
                e.this.d();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void b() {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onWebViewShow");
            if (e.this.f != null) {
                e.this.f.a();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void c() {
            if (e.this.f != null) {
                e.this.f.b();
                if (e.this.e.f() == 2 && e.this.g != null) {
                    e.this.g.c();
                }
                e.this.f = null;
            }
            e.this.g = null;
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void d() {
            if (e.this.h == null || e.this.e == null) {
                return;
            }
            AdItemData adItemDataA = e.this.e.a();
            HashMap map = new HashMap();
            map.put("uSdkVC", g.g() + "");
            map.put("traceId", e.this.h.o());
            map.put(STManager.KEY_AD_POS_ID, adItemDataA.g());
            map.put("posType", String.valueOf(adItemDataA.aa()));
            map.put("adId", adItemDataA.f());
            map.put("webUrl", e.this.e.d());
            e.this.b.i().a(map);
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onViewVisible = " + z);
            if (e.this.j == 4) {
                return;
            }
            if (!z) {
                if (e.this.j == 1) {
                    e.this.d();
                }
            } else if (e.this.j != 3) {
                e eVar = e.this;
                eVar.a(eVar.e.a(), e.this.e.e());
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void b(boolean z) {
            e.this.b(z);
        }
    };
    private com.opos.mobad.ui.a.d o = new com.opos.mobad.ui.a.d() { // from class: com.opos.mobad.activity.webview.e.5
        @Override // com.opos.mobad.ui.a.d
        public void a() {
        }

        @Override // com.opos.mobad.ui.a.d
        public void b(View view) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayComplete");
            if (e.this.g != null) {
                e.this.g.e();
            }
        }

        @Override // com.opos.mobad.ui.a.d
        public void c(View view, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayProgress currentPosition:" + j);
            if (e.this.g != null) {
                e.this.g.a(j);
            }
        }

        @Override // com.opos.mobad.ui.a.d
        public void a(long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "videoUserPlayPause ");
            e.this.j = 3;
        }

        @Override // com.opos.mobad.ui.a.d
        public void b(View view, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayResume");
            e.this.j = 1;
        }

        @Override // com.opos.mobad.ui.a.d
        public void a(View view) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayStart");
            e.this.j = 1;
            if (e.this.g != null) {
                e.this.g.d();
            }
        }

        @Override // com.opos.mobad.ui.a.d
        public void a(View view, long j) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayPause");
            if (e.this.g != null) {
                e.this.g.b(j);
            }
            if (e.this.j == 3) {
                if (e.this.g != null) {
                    e.this.g.c(j);
                    return;
                }
                return;
            }
            e.this.j = 2;
        }

        @Override // com.opos.mobad.ui.a.d
        public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.func.b.a aVar) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoClick");
        }

        @Override // com.opos.mobad.ui.a.d
        public void a(Map<String, String> map) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayError code: " + map);
            if (e.this.g != null) {
                e.this.g.a(map);
            }
        }
    };

    public e(Activity activity, com.opos.mobad.b bVar, c cVar) {
        this.f8513a = activity;
        this.b = bVar.c();
        this.c = cVar;
        cVar.a(this.n);
        this.i = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.mobad.activity.c cVar;
        int i = this.j;
        if ((i == 2 && i == 3) || (cVar = this.d) == null) {
            return;
        }
        cVar.Q();
    }

    public void b() {
        this.j = 4;
        a();
        com.opos.mobad.activity.c cVar = this.d;
        if (cVar != null) {
            cVar.b();
        }
        this.b.l().a(this.m);
        this.b.m().a(this.l);
        this.f8513a = null;
    }

    public void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void b(String str) {
        this.b.l().a(str);
    }

    public void c(String str) {
        this.b.l().b(str);
    }

    public void d(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.i) == null) {
            return;
        }
        map.remove(str);
    }

    public void b(String str, String str2) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.i) == null) {
            return;
        }
        map.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        this.b.m().a(str2, this.l);
        this.b.l().a(str, str2, str3, str4, this.m);
    }

    public com.opos.mobad.cmn.service.a.b a(String str, String str2) {
        return com.opos.cmn.an.h.d.a.d(this.b.b(), str2) ? new com.opos.mobad.cmn.service.a.b(200, 100) : this.b.l().a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        String string;
        com.opos.cmn.an.f.a.a("WebViewPresenter", "notifyWebViewVisibilityChanged");
        String str = this.i.get("onVisibilityChanged");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, z ? 1 : 0);
            string = jSONObject.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WebViewPresenter", "", (Throwable) e);
            string = "";
        }
        a("javascript:" + str + "(" + string + ")");
    }

    public void a() {
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2, String str3) {
        String string;
        if (this.j == 4) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dlUrl", str);
            jSONObject.put("dlPkgName", str2);
            jSONObject.put("dlStatus", i);
            if (str3 != null) {
                jSONObject.put("dlErrorCode", str3);
            }
            jSONObject.put("dlProcess", i2);
            string = jSONObject.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WebViewPresenter", "", (Throwable) e);
            string = "";
        }
        a("javascript:onActionDownloader(" + string + ")");
    }

    public void a(WebDataHepler webDataHepler) {
        this.e = webDataHepler;
        if (webDataHepler.a() != null && this.e.a().i() != null && this.e.a().i().size() > 0) {
            this.h = this.e.a().i().get(0);
        }
        if (this.e.f() == 2) {
            FrameLayout frameLayout = new FrameLayout(this.b.b());
            frameLayout.setBackgroundColor(-1);
            this.d = new com.opos.mobad.activity.c(this.b.b(), this.o, frameLayout);
            this.c.a(frameLayout);
        }
        a(this.h);
        a(this.e.d());
    }

    public void a(b.a aVar) {
        this.k = aVar;
    }

    public void a(com.opos.mobad.activity.webview.b.c cVar) {
        this.f = cVar;
    }

    public void a(com.opos.mobad.activity.webview.b.d dVar) {
        this.g = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, String str) {
        com.opos.mobad.activity.c cVar = this.d;
        if (cVar != null) {
            cVar.a(adItemData, str);
            if (this.e.j() > 0) {
                this.d.a(this.e.j());
            }
        }
    }

    private void a(MaterialData materialData) {
        if (g.a(materialData)) {
            this.b.l().a(this.b.n().b(), this.b.n().c());
        }
    }

    public void a(String str) {
        this.c.a(str);
    }

    public void a(final String str, final String str2, final String str3, final String str4) {
        if (this.f8513a == null || !g.a(this.b) || "WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.b.b()))) {
            b(str, str2, str3, str4);
        } else {
            final com.opos.cmn.module.ui.b.a aVar = new com.opos.cmn.module.ui.b.a(this.f8513a);
            aVar.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.activity.webview.e.1
                @Override // com.opos.cmn.module.ui.b.d.a
                public void a(View view, int[] iArr) {
                    aVar.a();
                }

                @Override // com.opos.cmn.module.ui.b.d.a
                public void b(View view, int[] iArr) {
                    e.this.b(str, str2, str3, str4);
                    g.a(false);
                    aVar.a();
                }
            });
        }
    }

    private void a(boolean z) {
        com.opos.mobad.activity.c cVar = this.d;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 0 || i == 4) {
            if ((this.e.f() == 2 || this.e.f() == 1) && i == 4 && keyEvent.getAction() == 0) {
                this.c.b();
                return true;
            }
        } else if (i != 24) {
            if (i == 25 && this.e.f() == 2) {
                a(true);
            }
        } else if (this.e.f() == 2) {
            a(false);
        }
        return false;
    }
}
