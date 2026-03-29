package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.adexpress.b.jk;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.mv.nr;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.k;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u;
import com.bytedance.sdk.openadsdk.core.y.c;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.s.n;
import com.cdo.oaps.ad.OapsKey;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PlayableFeedWebView extends SSWebView implements nr.u, n, com.bytedance.sdk.openadsdk.core.z.nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f5378a;
    private k bg;
    private k bq;
    private double dw;
    private ja iz;
    private final ViewGroup jk;
    private final Runnable k;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u l;
    private boolean mv;
    private final Runnable my;
    private com.bytedance.sdk.openadsdk.core.z.u n;
    private com.bytedance.sdk.openadsdk.s.n o;
    private final Context pn;
    private int s;
    private com.bytedance.sdk.component.adexpress.nr.t sx;
    private boolean t;
    private final bc x;

    public PlayableFeedWebView(com.bytedance.sdk.openadsdk.core.z.u uVar, ViewGroup viewGroup) {
        super(uVar.getContext());
        this.t = false;
        this.mv = false;
        this.s = 8;
        this.k = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.nr(0);
            }
        };
        this.my = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.nr(8);
            }
        };
        this.sx = new com.bytedance.sdk.component.adexpress.nr.t() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.3
            @Override // com.bytedance.sdk.component.adexpress.nr.t
            public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
            }

            @Override // com.bytedance.sdk.component.adexpress.nr.t
            public void u(s sVar) {
            }

            @Override // com.bytedance.sdk.component.adexpress.nr.t
            public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                PlayableFeedWebView.this.l.nr(view, i, fxVar);
            }
        };
        this.n = uVar;
        this.pn = uVar.getContext();
        this.x = uVar.u();
        this.jk = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    private void a() {
        com.bytedance.sdk.openadsdk.core.c.fx fxVar = new com.bytedance.sdk.openadsdk.core.c.fx();
        com.bytedance.sdk.openadsdk.core.c.pn pnVar = new com.bytedance.sdk.openadsdk.core.c.pn(this.iz);
        com.bytedance.sdk.openadsdk.core.c.b bVar = new com.bytedance.sdk.openadsdk.core.c.b();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.bytedance.sdk.openadsdk.s.n nVarFx = fxVar.u(dw.getContext(), this, pnVar, bVar, hashSet, n.u.OTHER).pn(getUrl()).b(com.bytedance.sdk.openadsdk.core.n.u.x()).u(com.bytedance.sdk.openadsdk.core.n.u.u()).u("sdkEdition", com.bytedance.sdk.openadsdk.core.n.u.fx()).nr(com.bytedance.sdk.openadsdk.core.n.u.pn()).fx(com.bytedance.sdk.openadsdk.core.n.u.b()).fx(false);
        this.o = nVarFx;
        Set<String> setJk = nVarFx.jk();
        if (this.iz == null || setJk == null || setJk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.o);
        Iterator<String> it = setJk.iterator();
        while (it.hasNext()) {
            this.iz.iz().u(it.next(), (com.bytedance.sdk.component.u.pn<?, ?>) new com.bytedance.sdk.component.u.pn<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.4
                @Override // com.bytedance.sdk.component.u.pn
                public JSONObject u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.s.n nVar = (com.bytedance.sdk.openadsdk.s.n) weakReference.get();
                        if (nVar == null) {
                            return null;
                        }
                        return nVar.b(u(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    private void jk() {
        ja jaVar = new ja(this.pn);
        this.iz = jaVar;
        jaVar.nr(this).u(this.x).nr(this.x.lk()).b(this.x.ap()).u(jp.nr(this.x)).pn(jp.sx(this.x)).u((n) this).b(com.bytedance.sdk.openadsdk.core.nativeexpress.nr.nr.u(0.0f, 0.0f, false, this.x)).u(this.sx).u((SSWebView) this);
    }

    private void t() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        u((SSWebView) this);
        if (this.x != null) {
            Context context = this.pn;
            ja jaVar = this.iz;
            bc bcVar = this.x;
            setWebViewClient(new u(context, jaVar, bcVar, bcVar.lk()));
        }
        com.bytedance.sdk.component.adexpress.pn.pn.u().u(this, this.iz);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.iz));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        u(Integer.MIN_VALUE, Integer.MIN_VALUE, this.jk.getWidth(), this.jk.getHeight());
        jk();
        a();
        t();
        loadUrl(z.pn(this.x).u(this.jk.getWidth() <= this.jk.getHeight()));
        setExpressVideoListener(this.l);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public boolean G_() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void H_() {
        if (this.iz == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z(this, this.iz, this.x));
        if (this.n != null) {
            this.n.u(true, getMaxRectJson(), 2);
        }
        nr(getVisibility());
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void b() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar = this.l;
        if (uVar != null) {
            uVar.u((View) this);
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.mv.fx
    public void destroy() {
        this.l = null;
        K_();
        setOnShakeListener(null);
        ja jaVar = this.iz;
        if (jaVar != null) {
            jaVar.pn();
            this.iz.u((SSWebView.nr) null);
        }
        this.iz = null;
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void fx() {
        if (this.n != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, 1);
            } catch (JSONException e) {
                e.getMessage();
            }
            this.n.u(false, jSONObject, 2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.nr
    public JSONObject getActualRectJson() {
        return k.u(this.bq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.jk.getLeft();
            int top = this.jk.getTop();
            jSONArray.put(0, y.b(getContext(), left));
            jSONArray.put(1, y.b(getContext(), top));
            jSONObject.put(OapsKey.KEY_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.jk.getMeasuredWidth();
            int measuredHeight = this.jk.getMeasuredHeight();
            jSONArray2.put(0, y.b(getContext(), measuredWidth));
            jSONArray2.put(1, y.b(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.bytedance.sdk.openadsdk.core.z.u uVar = this.n;
        if (uVar != null) {
            return uVar.nr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.nr
    public double getExceedAreaRate() {
        return this.dw;
    }

    public ja getJsObject() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.z.nr
    public JSONObject getMaxRectJson() {
        return k.u(this.bg);
    }

    public void iz() {
        this.mv = true;
        ja jaVar = this.iz;
        if (jaVar != null) {
            jaVar.wq();
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.mv.fx
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void n() {
        u(false);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        u(i == 0);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        u(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.my);
        removeCallbacks(this.k);
        if (i == 0) {
            postDelayed(this.k, 50L);
        } else {
            postDelayed(this.my, 50L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void setEasyPlayInteractionAreaInfo(k kVar) {
        this.bq = kVar;
    }

    public void setEasyPlayableListener(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u uVar) {
        this.l = uVar;
    }

    public void setExpressVideoListener(com.bytedance.sdk.openadsdk.core.nativeexpress.t tVar) {
        ja jaVar = this.iz;
        if (jaVar != null) {
            jaVar.u(tVar);
        }
    }

    public void x() {
        if (this.t) {
            return;
        }
        this.t = true;
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void nr() {
        com.bytedance.sdk.openadsdk.core.z.u uVar = this.n;
        if (uVar != null) {
            uVar.fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void u(k kVar, double d) {
        this.bg = kVar;
        this.dw = d;
        this.f5378a = kVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.bytedance.sdk.openadsdk.core.widget.u.b {
        private bc u;

        public u(Context context, ja jaVar, bc bcVar, String str) {
            super(context, jaVar, str);
            this.u = bcVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.u.nr.u uVarU = com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.u(webView, this.u, str, new u.InterfaceC0277u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.u.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                    public boolean u() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr.u.InterfaceC0277u
                    public com.bytedance.sdk.component.adexpress.u.nr.u u(String str2, jk.u uVar, String str3) {
                        com.bytedance.sdk.component.adexpress.u.nr.u uVar2 = new com.bytedance.sdk.component.adexpress.u.nr.u();
                        uVar2.u(5);
                        uVar2.u(com.bytedance.sdk.openadsdk.core.ugeno.iz.u.nr().u(webView, uVar, str2));
                        return uVar2;
                    }
                });
                if (uVarU != null && uVarU.u() != null) {
                    return uVarU.u();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.u("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    public void nr(int i) {
        if (i == this.s) {
            return;
        }
        this.s = i;
        if (this.iz == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", i == 0);
            this.iz.nr("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.n
    public void u(final int i, final int i2, final int i3, final int i4) {
        com.bytedance.sdk.openadsdk.gi.x.u((Runnable) new com.bytedance.sdk.component.jk.a("changeFrame") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
                int i5 = i;
                if (i5 == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                if (i5 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i5);
                }
                int i6 = i2;
                if (i6 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i6);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void u(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.u.nr.u(this.pn).u(false).u(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            c.u(sSWebView, d.fx, bc.b(this.x));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("xeasy", e.toString());
        }
    }

    public void u(boolean z) {
        ja jaVar = this.iz;
        if (jaVar != null) {
            jaVar.t(z);
        }
    }

    @Override // com.bytedance.sdk.component.mv.nr.u
    public Pair<Boolean, Boolean> u(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iB = y.b(getContext(), x);
        int iB2 = y.b(getContext(), y);
        k kVar = this.f5378a;
        if (kVar == null || kVar.u(iB, iB2)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.z.u.u(this.x, iB, iB2, 2);
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }
}
