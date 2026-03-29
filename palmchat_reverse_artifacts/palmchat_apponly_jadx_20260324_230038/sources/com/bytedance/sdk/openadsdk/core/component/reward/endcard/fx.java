package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.c.pn;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.nr;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.s.iz;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.s.n;
import com.bytedance.sdk.openadsdk.s.x;
import com.oplus.tblplayer.Constants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.u implements rh.u, iz.nr {
    private static final x.u cj = new x.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.2
        @Override // com.bytedance.sdk.openadsdk.s.x.u
        public void u(String str, String str2, Throwable th) {
            k.u(str, str2, th);
        }
    };
    private final com.bytedance.sdk.openadsdk.core.playable.u bc;
    private com.bytedance.sdk.openadsdk.core.ugeno.b.fx bf;
    final rh d;
    protected final AtomicBoolean gi;
    long h;
    private FrameLayout ja;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private PlayableEndcardFrameLayout f5231jp;
    protected final AtomicBoolean kj;
    private nr.InterfaceC0247nr m;
    private com.bytedance.sdk.openadsdk.core.nr.nr mh;
    private final u oa;
    private n pb;
    private final AtomicBoolean rh;
    private DownloadListener su;
    private final com.bytedance.sdk.openadsdk.core.dw.b tk;
    private nr.u w;
    private com.bytedance.sdk.openadsdk.core.dw.nr wi;
    private com.bytedance.sdk.openadsdk.core.s.x wq;
    private boolean xg;
    private com.bytedance.sdk.openadsdk.core.multipro.nr.u xw;
    private RewardLpBottomView y;
    private String yd;
    protected final AtomicBoolean z;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(WebView webView, String str);

        void u(WebView webView, String str, Bitmap bitmap);
    }

    public fx(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, String str, int i, int i2, boolean z, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, bcVar, str, i, i2, z);
        this.kj = new AtomicBoolean(false);
        this.z = new AtomicBoolean(false);
        this.gi = new AtomicBoolean(false);
        this.rh = new AtomicBoolean(false);
        this.d = new rh(Looper.getMainLooper(), this);
        this.h = 0L;
        this.oa = new u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.u
            public void u(WebView webView, String str2) {
                if (fx.this.u.yd() instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.n) {
                    return;
                }
                fx.this.d.removeMessages(101);
                if (fx.this.kj.getAndSet(true)) {
                    return;
                }
                if (q.fx(fx.this.nr) || fx.this.xg) {
                    if (fx.this.c()) {
                        fx.this.u(0);
                    } else if (fx.this.w != null) {
                        fx.this.w.u();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.u
            public void u(WebView webView, String str2, Bitmap bitmap) {
                if (q.fx(fx.this.nr)) {
                    if (fx.this.nr.gs() == 1 || bg.t(fx.this.nr)) {
                        fx.this.d.sendEmptyMessageDelayed(101, 10000L);
                    }
                    if (fx.this.z.getAndSet(true)) {
                        return;
                    }
                    fx.this.h = System.currentTimeMillis();
                    fx.this.m.u();
                }
            }
        };
        this.tk = new com.bytedance.sdk.openadsdk.core.dw.b() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.3
            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void nr() {
                if (!bg.u(fx.this.nr) || bg.t(fx.this.nr)) {
                    return;
                }
                fx.this.u.u(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void u(int i3) {
                fx.this.n.a(true);
                if (bg.t(fx.this.nr)) {
                    fx.this.m.nr();
                }
                fx.this.u.fx(i3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dw.b
            public void u() {
                if (yd.t(fx.this.nr)) {
                    fx.this.u.b(3);
                }
            }
        };
        this.wi = new com.bytedance.sdk.openadsdk.core.dw.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.4
            @Override // com.bytedance.sdk.openadsdk.core.dw.nr
            public void u(boolean z2, int i3, String str2) {
                if (z2) {
                    fx.this.my = true;
                }
            }
        };
        this.x = abstractEndCardFrameLayout.getPlayableWebView();
        this.ja = (FrameLayout) this.u.findViewById(2114387919);
        this.f5231jp = (PlayableEndcardFrameLayout) this.u.findViewById(2114387675);
        this.y = (RewardLpBottomView) this.u.findViewById(2114387824);
        this.bc = new com.bytedance.sdk.openadsdk.core.playable.u(this.fx, tTBaseVideoActivity, bcVar, q.fx(this.nr) ? 2 : 1, tTBaseVideoActivity.yd().pb(), abstractEndCardFrameLayout.getVideoArea());
        u();
    }

    private void jp() {
        this.d.sendMessage(nr(3));
        nr.u uVar = this.w;
        if (uVar != null) {
            uVar.u();
        }
        this.u.fx(0);
    }

    private void m() {
        this.jk = q.u(this.nr);
        float fBa = this.nr.ba();
        if (TextUtils.isEmpty(this.jk)) {
            return;
        }
        String strTrim = this.jk.trim();
        this.jk = strTrim;
        if (this.bg == 1) {
            if (strTrim.contains(Constants.STRING_VALUE_UNSET)) {
                this.jk += "&orientation=portrait";
            } else {
                this.jk += "?orientation=portrait";
            }
        }
        if (this.jk.contains(Constants.STRING_VALUE_UNSET)) {
            this.jk += "&height=" + this.dw + "&width=" + this.bq + "&aspect_ratio=" + fBa;
            return;
        }
        this.jk += "?height=" + this.dw + "&width=" + this.bq + "&aspect_ratio=" + fBa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb() {
        this.my = true;
        this.gi.set(true);
        this.d.sendMessage(nr(4));
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        if (tTBaseVideoActivity != null) {
            tTBaseVideoActivity.mv(8);
        }
        nr.InterfaceC0247nr interfaceC0247nr = this.m;
        if (interfaceC0247nr != null) {
            interfaceC0247nr.u();
        }
    }

    private void xg() {
        RewardLpBottomView rewardLpBottomView;
        if (!q.x(this.nr)) {
            this.y = null;
            return;
        }
        if (bg.b(this.nr)) {
            this.y = null;
            return;
        }
        if (!bg.pn(this.nr)) {
            this.y = null;
        } else {
            if (this.f5231jp == null || (rewardLpBottomView = this.y) == null) {
                return;
            }
            rewardLpBottomView.u(this.nr, this.fx);
            this.f5231jp.u(new PlayableEndcardFrameLayout.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.u
                public void u() {
                    if (fx.this.y != null) {
                        fx.this.y.nr();
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = fx.this.u;
                    if (tTBaseVideoActivity != null) {
                        tTBaseVideoActivity.jk(1);
                    }
                }
            });
        }
    }

    private void y() {
        if (this.u.su() == null) {
            return;
        }
        long jMy = !this.u.su().u() ? this.u.su().my() : 0L;
        boolean zMv = this.u.su().mv();
        if (!(this.u.yd() instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.n)) {
            n nVar = this.pb;
            zMv = nVar != null && nVar.x();
        }
        this.bc.u(jMy, zMv);
    }

    public boolean bf() {
        return !this.gi.get();
    }

    public void d() {
        u(true);
        n nVar = this.pb;
        if (nVar != null) {
            nVar.nr(true);
        }
        fx(true);
        u(false, true);
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = this.t;
        if (bVar != null) {
            bVar.nr(false);
        }
    }

    public void gi() {
        SSWebView sSWebView;
        if (this.k || (sSWebView = this.x) == null || sSWebView.getWebView() == null) {
            return;
        }
        this.x.loadUrl(this.jk);
        this.k = true;
        n nVar = this.pb;
        if (nVar != null) {
            nVar.iz(this.jk);
        }
    }

    public long h() {
        return System.currentTimeMillis() - this.h;
    }

    public ja ja() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void k() {
        super.k();
        n nVar = this.pb;
        if (nVar != null) {
            nVar.wq();
        }
        iz izVar = this.l;
        if (izVar != null) {
            izVar.u((iz.nr) null);
        }
        this.bc.b();
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = this.bf;
        if (fxVar != null) {
            fxVar.b();
        }
        com.bytedance.sdk.openadsdk.core.s.x xVar = this.wq;
        if (xVar != null) {
            xVar.b();
        }
        this.su = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void kj() {
        super.kj();
        this.bc.fx();
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = this.bf;
        if (fxVar != null) {
            fxVar.fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void l() {
        super.l();
        if (this.pb != null && y.b(this.x)) {
            this.pb.nr(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = this.bf;
        if (fxVar != null) {
            fxVar.fx();
        }
        com.bytedance.sdk.openadsdk.core.s.x xVar = this.wq;
        if (xVar != null) {
            xVar.fx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void mv() {
        super.mv();
        n nVar = this.pb;
        if (nVar != null) {
            nVar.nr(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = this.bf;
        if (fxVar != null) {
            fxVar.nr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public String qq() {
        return "playable";
    }

    public boolean rh() {
        ja jaVar = this.n;
        if (jaVar != null) {
            return jaVar.t();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void s() {
        super.s();
        com.bytedance.sdk.openadsdk.core.s.x xVar = this.wq;
        if (xVar != null) {
            xVar.u(0);
        }
    }

    public void wq() {
        if (this.x == null || this.pb != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.n.o().tk()) {
            x.u(cj);
        }
        com.bytedance.sdk.openadsdk.core.c.fx fxVar = new com.bytedance.sdk.openadsdk.core.c.fx();
        b bVar = new b(this.tk);
        pn pnVar = new pn(this.n);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.nr.lk());
            jSONObject.put("log_extra", this.nr.ap());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        n nVarU = fxVar.u(dw.getContext(), this.x, pnVar, bVar, hashSet, n.u.LAND_PAGE).pn(this.jk).b(com.bytedance.sdk.openadsdk.core.n.u.x()).u(com.bytedance.sdk.openadsdk.core.n.u.u()).pn(jSONObject).u("sdkEdition", com.bytedance.sdk.openadsdk.core.n.u.fx()).nr(com.bytedance.sdk.openadsdk.core.n.u.pn()).fx(com.bytedance.sdk.openadsdk.core.n.u.b()).u(10L).nr(10L).fx(false).u(false);
        this.pb = nVarU;
        Set<String> setJk = nVarU.jk();
        if (this.n == null || setJk == null || setJk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.pb);
        Iterator<String> it = setJk.iterator();
        while (it.hasNext()) {
            this.n.iz().u(it.next(), (com.bytedance.sdk.component.u.pn<?, ?>) new com.bytedance.sdk.component.u.pn<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.8
                @Override // com.bytedance.sdk.component.u.pn
                public JSONObject u(JSONObject jSONObject2, com.bytedance.sdk.component.u.iz izVar) throws Exception {
                    try {
                        n nVar = (n) weakReference.get();
                        if (nVar == null) {
                            return null;
                        }
                        return nVar.b(u(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z, Map<String, Object> map, View view) {
        SSWebView sSWebView = this.x;
        if (sSWebView == null) {
            return;
        }
        iz izVarNr = new iz(this.nr, sSWebView).nr(true);
        this.l = izVarNr;
        izVarNr.u(this);
        this.l.u(true);
        this.l.u(z ? "reward_endcard" : "fullscreen_endcard");
        ja jaVar = new ja(this.u);
        this.n = jaVar;
        jaVar.nr(this.x).u(this.nr).nr(this.nr.lk()).b(this.nr.ap()).fx(z ? 7 : 5).u(this.q).pn(jp.sx(this.nr)).u(this.x).nr(jk.u(this.nr)).u(this.fx).u(map).u(this.qq).u(view).fx(this.u.u()).u(this.tk);
        if (!q.fx(this.nr)) {
            this.n.n(true);
        }
        this.n.u(this.wi);
        xg();
        m();
        wq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void b(boolean z) {
        super.b(z);
        if (!z) {
            this.bc.nr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = this.bf;
        if (fxVar != null) {
            fxVar.nr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void iz() {
        SSWebView sSWebView = this.x;
        if (sSWebView != null && sSWebView.getVisibility() == 0) {
            this.m.fx().u(true);
        }
        super.iz();
        this.bc.u();
        n nVar = this.pb;
        if (nVar != null) {
            nVar.nr(false);
        }
        u(true, false);
    }

    public void pn(boolean z) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            this.n.x(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z);
            this.n.nr("isVerifyReward", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar) {
        this.xw = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(boolean z, Map<String, Object> map, View view) {
        if (jp.c(this.nr) && this.ja != null) {
            u(map, view);
        } else {
            nr(z, map, view);
        }
    }

    public void iz(boolean z) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        this.xg = z;
    }

    private void u(final Map<String, Object> map, final View view) {
        com.bytedance.sdk.openadsdk.core.s.x xVar = new com.bytedance.sdk.openadsdk.core.s.x(this.nr);
        this.wq = xVar;
        xVar.u(true);
        this.wq.u();
        this.ja.setVisibility(0);
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        FrameLayout frameLayout = this.ja;
        com.bytedance.sdk.openadsdk.core.s.x xVar2 = this.wq;
        bc bcVar = this.nr;
        String str = this.fx;
        com.bytedance.sdk.openadsdk.core.ugeno.b.fx fxVar = new com.bytedance.sdk.openadsdk.core.ugeno.b.fx(tTBaseVideoActivity, frameLayout, xVar2, bcVar, str, jp.nr(str), this.xw);
        this.bf = fxVar;
        fxVar.u();
        this.bf.u(new com.bytedance.sdk.openadsdk.core.ugeno.pn.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(View view2) {
                fx.this.pb();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.pn.u
            public void u(int i) {
                fx.this.bf = null;
                com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fx.this.ja != null) {
                            fx.this.ja.setVisibility(8);
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        fx fxVar2 = fx.this;
                        fxVar2.k = false;
                        fxVar2.nr(fxVar2.b, map, view);
                        fx fxVar3 = fx.this;
                        fxVar3.nr(fxVar3.su, fx.this.mh);
                        fx.this.su = null;
                        fx.this.gi();
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.su = downloadListener;
        this.mh = nrVar;
        nr(downloadListener, nrVar);
    }

    private void u(com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!q.x(this.nr) || (rewardLpBottomView = this.y) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(int i) {
        super.u(i);
        y();
    }

    public void u(nr.InterfaceC0247nr interfaceC0247nr) {
        this.m = interfaceC0247nr;
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i == 101) {
            jp();
            return;
        }
        if (i != 102) {
            return;
        }
        this.d.removeMessages(102);
        this.m.fx().u(true);
        this.u.eh();
        int i2 = message.arg1;
        if (i2 == 2) {
            nr.u uVar = this.w;
            if (uVar != null) {
                uVar.u();
                return;
            }
            return;
        }
        if (i2 == 0 || i2 == 1) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        if (this.x == null) {
            return;
        }
        this.mh = null;
        com.bytedance.sdk.openadsdk.core.widget.u.b bVar = new com.bytedance.sdk.openadsdk.core.widget.u.b(this.u, this.n, this.nr.lk(), this.l) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (fx.this.pb != null && str != null && !str.contains("about:blank")) {
                    fx.this.pb.x(str);
                }
                super.onPageFinished(webView, str);
                fx.this.oa.u(webView, str);
                if (fx.this.y != null) {
                    fx.this.y.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                fx.this.gi.set(true);
                fx.this.oa.u(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                fx.this.o.set(false);
                fx.this.sx = this.n;
                fx fxVar = fx.this;
                fxVar.mv = i;
                fxVar.s = str;
                if (fxVar.pb != null) {
                    fx.this.pb.u(i, str, str2);
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (fx.this.pb != null) {
                    try {
                        fx.this.pb.u(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (fx.this.jk.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        fx.this.o.set(false);
                        fx.this.sx = this.n;
                    }
                    if (webResourceResponse != null) {
                        fx.this.mv = webResourceResponse.getStatusCode();
                        fx.this.s = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    bc bcVar = fx.this.nr;
                    if (bcVar == null) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    if (TextUtils.isEmpty(bcVar.wv())) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    fx.this.pn++;
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    k.u("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.u.b, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    fx.this.o.set(false);
                    fx.this.sx = this.n;
                }
                fx.this.mv = webResourceError.getErrorCode();
                fx.this.s = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.t = bVar;
        this.x.setWebViewClient(bVar);
        this.x.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.u.fx(this.n, this.l));
        u(this.x);
        this.x.setBackgroundColor(-16777216);
        this.x.setDisplayZoomControls(false);
        this.x.setDownloadListener(downloadListener);
        u(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.s.iz.nr
    public void u(String str) {
        if (TextUtils.isEmpty(this.yd)) {
            this.yd = str;
        }
        if (TextUtils.equals(this.yd, str)) {
            return;
        }
        this.yd = str;
        this.u.jk(1);
    }

    public void nr(int i, int i2) {
        if (this.n == null || this.u.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i);
            if (this.b) {
                jSONObject.put("reward_remain_time", i2);
            }
            this.n.nr("reward_button_status", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void u(nr.u uVar) {
        this.w = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void u(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.s.jk jkVar = this.f5232a;
        if (jkVar != null) {
            jkVar.jk();
        }
        if (map == null || !q.fx(this.nr)) {
            return;
        }
        map.put("duration", Long.valueOf(h()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.u
    public void nr(boolean z) {
        n nVar = this.pb;
        if (nVar != null) {
            nVar.u(z);
        }
        this.bc.u(z);
    }

    private Message nr(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.arg1 = i;
        return messageObtain;
    }
}
