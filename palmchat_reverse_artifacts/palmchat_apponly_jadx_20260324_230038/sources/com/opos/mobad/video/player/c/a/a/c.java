package com.opos.mobad.video.player.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.location.LocationConst;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.func.a.a.e;
import com.opos.mobad.video.player.c.a.a;
import com.opos.mobad.video.player.c.a.a.a.b;
import com.opos.mobad.video.player.c.a.a.d;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c implements a.InterfaceC0809a, a.c.InterfaceC0810a, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10292a;
    private a.d b;
    private a.c c;
    private a d;
    private a.InterfaceC0809a e;
    private volatile com.opos.mobad.video.player.c.a.a.a.b f;
    private volatile com.opos.mobad.video.player.c.a.a.a.b g;
    private volatile com.opos.mobad.video.player.c.a.a.a.b h;
    private com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> i;
    private boolean l;
    private long j = -1;
    private long k = -1;
    private final Handler m = new Handler(Looper.getMainLooper());

    public c(Context context, com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar) {
        this.f10292a = context;
        this.i = aVar;
    }

    @JavascriptInterface
    public void adsConvert(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL adsConvert:" + str + ",mListener=" + this.e);
        final a.InterfaceC0809a interfaceC0809a = this.e;
        if (interfaceC0809a == null) {
            return;
        }
        try {
            JSONObject jSONObject = new com.opos.mobad.video.player.c.a.a.a.a(str).b;
            final int iOptInt = jSONObject != null ? jSONObject.optInt("clickArea", 1) : 1;
            final JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("clickInfo") : null;
            a(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObjectOptJSONObject;
                    int iOptInt2 = jSONObject2 != null ? jSONObject2.optInt("down_x", SkuConfig.INFINITE_COUNT) : SkuConfig.INFINITE_COUNT;
                    JSONObject jSONObject3 = jSONObjectOptJSONObject;
                    int iOptInt3 = jSONObject3 != null ? jSONObject3.optInt("down_y", SkuConfig.INFINITE_COUNT) : SkuConfig.INFINITE_COUNT;
                    JSONObject jSONObject4 = jSONObjectOptJSONObject;
                    int iOptInt4 = jSONObject4 != null ? jSONObject4.optInt("up_x", SkuConfig.INFINITE_COUNT) : SkuConfig.INFINITE_COUNT;
                    JSONObject jSONObject5 = jSONObjectOptJSONObject;
                    int iOptInt5 = jSONObject5 != null ? jSONObject5.optInt("up_y", SkuConfig.INFINITE_COUNT) : SkuConfig.INFINITE_COUNT;
                    if (iOptInt2 != -999) {
                        iOptInt2 = com.opos.cmn.an.h.f.a.a(c.this.f10292a, iOptInt2);
                    }
                    if (iOptInt3 != -999) {
                        iOptInt3 = com.opos.cmn.an.h.f.a.a(c.this.f10292a, iOptInt3);
                    }
                    if (iOptInt4 != -999) {
                        iOptInt4 = com.opos.cmn.an.h.f.a.a(c.this.f10292a, iOptInt4);
                    }
                    if (iOptInt5 != -999) {
                        iOptInt5 = com.opos.cmn.an.h.f.a.a(c.this.f10292a, iOptInt5);
                    }
                    interfaceC0809a.a(iOptInt, new int[]{iOptInt2, iOptInt3, iOptInt4, iOptInt5});
                }
            });
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJsEngine", "adsConvert error", th);
        }
    }

    @JavascriptInterface
    public void closeWebview(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL closeWebview:" + str);
        d();
    }

    @JavascriptInterface
    public void getAdsData(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL getAdsData:" + str);
        a aVar = this.d;
        com.opos.mobad.video.player.c.a.a.a.b bVar = new com.opos.mobad.video.player.c.a.a.a.b(new com.opos.mobad.video.player.c.a.a.a.a(str));
        b.a aVar2 = new b.a();
        bVar.d = aVar2;
        aVar2.f10284a = a(str) ? 1 : 0;
        bVar.d.b = a(str) ? aVar.a() : new JSONObject();
        a(bVar);
    }

    @JavascriptInterface
    public void registerFocusStateChange(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL registerFocusStateChange:" + str);
    }

    @JavascriptInterface
    public void registerVideoStateChange(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL registerVideoStateChange:" + str);
        this.f = new com.opos.mobad.video.player.c.a.a.a.b(new com.opos.mobad.video.player.c.a.a.a.a(str));
    }

    @JavascriptInterface
    public void registerVisibilityStateChange(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL registerVisibilityStateChange:" + str);
        this.g = new com.opos.mobad.video.player.c.a.a.a.b(new com.opos.mobad.video.player.c.a.a.a.a(str));
    }

    @JavascriptInterface
    public void requestVideoCallback(String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL requestVideoCallback:" + str);
        this.h = new com.opos.mobad.video.player.c.a.a.a.b(new com.opos.mobad.video.player.c.a.a.a.a(str));
    }

    @JavascriptInterface
    public void sendTrack(final String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL sendTrack:" + str);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                String strC = c.this.d != null ? c.this.d.c() : "";
                if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new com.opos.mobad.video.player.c.a.a.a.a(str).b;
                if (jSONObject != null) {
                    strC = strC.replace("__LABEL__", jSONObject.optString("label")).replace("__PARAMS__", jSONObject.optString("params"));
                }
                e eVarA = com.opos.cmn.func.a.a.b.a().a(c.this.f10292a, new d.a().a("GET").b(strC).a());
                com.opos.cmn.an.f.a.a("TTLightJsEngine", "sendTrack isSuccess=" + (eVarA != null && 200 == eVarA.f7934a) + ",url=" + strC);
            }
        });
    }

    @JavascriptInterface
    public void setVideoState(final String str) {
        com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALL setVideoState:" + str + ",mPlayer=" + this.c);
        final a.c cVar = this.c;
        if (cVar == null) {
            return;
        }
        a(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int iOptInt = new com.opos.mobad.video.player.c.a.a.a.a(str).b.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE);
                    if (iOptInt == 0) {
                        cVar.d();
                    } else if (iOptInt == 1) {
                        cVar.e();
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.d("TTLightJsEngine", "setVideoState error", th);
                }
            }
        });
    }

    private void d() {
        a(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.i.b();
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void a() {
        this.l = false;
        if (this.h != null) {
            this.h.d = new b.a();
            a(this.h);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void b() {
        this.l = true;
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void c() {
        a(new b.C0812b(3, this.j));
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC0809a
    public void a(int i, int[] iArr) {
        a.c cVar = this.c;
        if (cVar != null) {
            cVar.d();
        }
        d();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void b(long j, long j2) {
        a(new b.C0812b(2, this.j));
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void c(long j, long j2) {
        a(new b.C0812b(4, this.k));
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC0810a
    public void a(long j, long j2) {
        this.j = j;
        this.k = j2;
        a(new b.C0812b(1, j));
    }

    public void a(a.InterfaceC0809a interfaceC0809a) {
        this.e = interfaceC0809a;
    }

    public void a(a.c cVar) {
        this.c = cVar;
    }

    public void a(a.d dVar) {
        this.b = dVar;
    }

    private void a(b.C0812b c0812b) {
        if (this.f != null) {
            b.a aVar = new b.a();
            aVar.b = c0812b.a();
            this.f.d = aVar;
            a(this.f);
        }
    }

    private void a(com.opos.mobad.video.player.c.a.a.a.b bVar) {
        try {
            if (!this.l && this.b != null && bVar != null) {
                final String str = "javascript:JSBridge._handleMessageFromApp(" + bVar.a().toString() + ")";
                com.opos.cmn.an.f.a.b("TTLightJsEngine", "JS_CALLBACK=" + str);
                a(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.b.b(str);
                    }
                });
                return;
            }
            com.opos.cmn.an.f.a.a("TTLightJsEngine", "evaluateJs,web closed or param error!");
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJsEngine", "evaluateJavascript error", th);
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    private void a(final Runnable runnable) {
        this.m.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.d("TTLightJsEngine", "callOnMainThread error", th);
                }
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a.d.a
    public void a(boolean z) {
        if (this.g != null) {
            b.c cVar = new b.c(z ? 1 : 0);
            b.a aVar = new b.a();
            aVar.b = cVar.a();
            this.g.d = aVar;
            a(this.g);
        }
    }

    private boolean a(String str) {
        return (this.d == null || TextUtils.isEmpty(str)) ? false : true;
    }
}
