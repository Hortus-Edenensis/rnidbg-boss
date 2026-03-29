package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.fx.fx;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.sdk.openadsdk.upie.nr;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bykv.vk.openvk.component.video.api.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LottieAnimationView f5437a;
    private final int b;
    private boolean bg;
    private boolean bq;
    private boolean c;
    private int d;
    private boolean dw;
    private final long fx;
    private long h;
    private final com.bykv.vk.openvk.component.video.api.renderview.nr iz;
    private boolean ja;
    private Bitmap jk;
    private final com.bykv.vk.openvk.component.video.api.u k;
    private boolean kj;
    private final String mv;
    private boolean my;
    private String n;
    private final String nr;
    private u.InterfaceC0156u o;
    private final int pn;
    private boolean q;
    private boolean qq;
    private final JSONObject s;
    private final Context x;
    private ViewTreeObserverOnGlobalLayoutListenerC0319u xg;
    private boolean z;
    private final String u = "TTLottieFakeVideoPlayer";
    private final Map<String, Bitmap> t = new HashMap();
    private final Map<String, Integer> l = new HashMap();
    private final Set<u.InterfaceC0156u> sx = new HashSet();
    private volatile int gi = 200;
    private float rh = 1.0f;
    private int bf = 0;
    private int wq = 0;
    private final Handler m = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final Runnable f5438jp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.4
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = u.this.sx.iterator();
            while (it.hasNext()) {
                ((u.InterfaceC0156u) it.next()).u(u.this, r3.d, u.this.sx());
            }
            if (u.this.d < u.this.sx()) {
                u.this.d += u.this.gi;
                u.this.m.postDelayed(u.this.f5438jp, u.this.gi);
                return;
            }
            if (u.this.f5437a != null) {
                u.this.f5437a.iz();
            }
            if (u.this.dw && !u.this.q && u.this.k != null && u.this.k.mv()) {
                u.this.k.fx();
            }
            u.this.bq = false;
            u.this.c = true;
            u.this.kj();
            Iterator it2 = u.this.sx.iterator();
            while (it2.hasNext()) {
                ((u.InterfaceC0156u) it2.next()).u(u.this);
            }
        }
    };
    private long pb = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.video.lottie.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewTreeObserverOnGlobalLayoutListenerC0319u implements ViewTreeObserver.OnGlobalLayoutListener {
        private int fx;
        private final ViewGroup nr;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.nr.getWidth();
            int height = this.nr.getHeight();
            this.nr.removeAllViews();
            int i = this.fx;
            this.fx = i - 1;
            if (i < 0) {
                this.nr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.nr.addView(u.this.f5437a);
            } else {
                this.nr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = u.this.b / u.this.pn;
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                if (u.this.pn <= 0 || f < f4) {
                    width = (int) (f3 * f);
                } else {
                    height = (int) (f2 / f);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.nr.addView(u.this.f5437a, layoutParams);
            }
            if (!u.this.bg || u.this.f5437a.pn()) {
                return;
            }
            u.this.f5437a.u();
        }

        private ViewTreeObserverOnGlobalLayoutListenerC0319u(ViewGroup viewGroup) {
            this.fx = 10;
            this.nr = viewGroup;
        }
    }

    public u(com.bykv.vk.openvk.component.video.api.renderview.nr nrVar, com.bytedance.sdk.openadsdk.upie.u uVar, com.bykv.vk.openvk.component.video.api.u uVar2, iz izVar) {
        this.x = nrVar.getView().getContext();
        this.iz = nrVar;
        this.fx = uVar.iz();
        this.b = uVar.b();
        this.pn = uVar.pn();
        String strFx = uVar.fx();
        this.mv = strFx;
        String strU = uVar.u();
        this.nr = strU;
        String strNr = uVar.nr();
        this.s = uVar.x();
        u(strU);
        nr(strFx);
        this.k = uVar2;
        u(strNr, izVar);
    }

    public static /* synthetic */ int c(u uVar) {
        int i = uVar.wq;
        uVar.wq = i + 1;
        return i;
    }

    public static /* synthetic */ int qq(u uVar) {
        int i = uVar.bf;
        uVar.bf = i + 1;
        return i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceTexture n() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int o() {
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceHolder x() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        final ViewGroup viewGroup = (ViewGroup) this.iz.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.f5437a);
        this.xg = new ViewTreeObserverOnGlobalLayoutListenerC0319u(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.xg);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(u.this.xg);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.13
            @Override // java.lang.Runnable
            public void run() {
                if (!u.this.z) {
                    if (u.this.mv()) {
                        u.this.gi();
                    }
                    Iterator it = u.this.sx.iterator();
                    while (it.hasNext()) {
                        ((u.InterfaceC0156u) it.next()).u(u.this, -1, -1, -1);
                    }
                }
                u.this.z = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw() {
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.8
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.jk == null || u.this.n == null || !u.this.my || u.this.f5437a != null) {
                    return;
                }
                u.this.f5437a = new LottieAnimationView(u.this.x);
                u.this.f5437a.u(u.this.n, u.this.nr);
                u.this.f5437a.setRepeatCount(-1);
                u.this.f5437a.setSpeed(u.this.rh);
                u.this.f5437a.setTextDelegate(new bq(u.this.f5437a) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.8.1
                    @Override // com.bytedance.adsdk.lottie.bq
                    public String u(String str) {
                        return com.bytedance.sdk.openadsdk.upie.u.u.u(str, u.this.s != null ? u.this.s : null);
                    }
                });
                u.this.f5437a.setImageAssetDelegate(new b() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.8.2
                    @Override // com.bytedance.adsdk.lottie.b
                    public Bitmap u(a aVar) {
                        if (aVar != null) {
                            String strMv = aVar.mv();
                            if (!TextUtils.isEmpty(strMv)) {
                                if (strMv.startsWith("${") && strMv.endsWith("}")) {
                                    strMv = com.bytedance.sdk.openadsdk.upie.u.u.u(strMv, u.this.s);
                                    if (TextUtils.isEmpty(strMv)) {
                                        return null;
                                    }
                                    if (!strMv.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || TextUtils.equals(strMv, u.this.mv)) {
                                        Bitmap bitmap = u.this.jk;
                                        if (bitmap != null && (bitmap.getWidth() != aVar.u() || bitmap.getHeight() != aVar.nr())) {
                                            u.this.jk = Bitmap.createScaledBitmap(bitmap, aVar.u(), aVar.nr(), false);
                                        }
                                        return u.this.jk;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) u.this.t.get(strMv);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                u.this.u(strMv, aVar.u(), aVar.nr());
                            }
                        }
                        return null;
                    }
                });
                u.this.bq();
                u.this.dw = true;
                u.this.pb = SystemClock.elapsedRealtime() - u.this.pb;
                for (u.InterfaceC0156u interfaceC0156u : u.this.sx) {
                    interfaceC0156u.nr(u.this);
                    u uVar = u.this;
                    interfaceC0156u.u((com.bykv.vk.openvk.component.video.api.u) uVar, uVar.b, u.this.pn);
                }
                if (u.this.bg) {
                    u.this.k.u(u.this.ja);
                    u.this.k.fx(true);
                    if (u.this.h > 0) {
                        u uVar2 = u.this;
                        uVar2.nr(uVar2.h);
                    } else {
                        u.this.nr();
                    }
                }
                for (u.InterfaceC0156u interfaceC0156u2 : u.this.sx) {
                    u uVar3 = u.this;
                    interfaceC0156u2.u(uVar3, uVar3.pb);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi() {
        com.bykv.vk.openvk.component.video.api.u uVar;
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null && this.dw && lottieAnimationView.pn()) {
            this.f5437a.x();
        }
        if (this.dw && !this.q && (uVar = this.k) != null && uVar.mv()) {
            this.k.fx();
        }
        this.bq = false;
        kj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj() {
        this.m.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.15
            @Override // java.lang.Runnable
            public void run() {
                u.this.z = false;
                if (u.this.s()) {
                    u.this.z();
                }
                Iterator it = u.this.sx.iterator();
                while (it.hasNext()) {
                    ((u.InterfaceC0156u) it.next()).u((com.bykv.vk.openvk.component.video.api.u) u.this, -1);
                }
            }
        });
    }

    private void qq() {
        this.m.removeCallbacksAndMessages(null);
        this.m.post(this.f5438jp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.bykv.vk.openvk.component.video.api.u uVar;
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null && this.dw && !lottieAnimationView.pn()) {
            if (this.d > 0) {
                this.f5437a.nr();
            } else {
                this.f5437a.u();
            }
        }
        if (this.dw && !this.q && (uVar = this.k) != null && !uVar.mv()) {
            if (this.d > 0) {
                this.k.nr();
            } else {
                this.k.u(0L);
                this.k.nr();
            }
        }
        this.bq = true;
        qq();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean a() {
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long bg() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean jk() {
        return this.bg;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean k() {
        return this.q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int l() {
        return this.pn;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean mv() {
        return this.bq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long my() {
        if (this.dw) {
            return this.pb;
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean s() {
        return (this.bq || this.c || this.q || !this.dw) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long sx() {
        return this.fx;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int t() {
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceHolder surfaceHolder) {
    }

    private void b(final boolean z) {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = u.this.sx.iterator();
                while (it.hasNext()) {
                    ((u.InterfaceC0156u) it.next()).u(u.this, z);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean iz() {
        return this.dw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void pn() {
        this.q = true;
        kj();
        this.t.clear();
        this.jk = null;
        com.bykv.vk.openvk.component.video.api.u uVar = this.k;
        if (uVar != null) {
            if (this.dw) {
                uVar.b();
            }
            this.k.pn();
        }
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.7
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) u.this.iz.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(u.this.xg);
                }
                Iterator it = u.this.sx.iterator();
                while (it.hasNext()) {
                    ((u.InterfaceC0156u) it.next()).fx(u.this);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(iz izVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void b() {
        com.bykv.vk.openvk.component.video.api.u uVar;
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null) {
            lottieAnimationView.iz();
            this.bg = false;
        }
        if (this.dw && !this.q && (uVar = this.k) != null && uVar.mv()) {
            this.k.fx();
        }
        kj();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx() {
        gi();
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = u.this.sx.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx(boolean z) {
        this.qq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final String str) {
        if (TextUtils.isEmpty(str)) {
            u(new fx(60008, 10002, "广告主图url为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.nr.u().nr(str, new nr.u<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.10
                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(Bitmap bitmap) {
                    u.this.jk = bitmap;
                    u.this.dw();
                }

                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(int i, String str2) {
                    u.qq(u.this);
                    if (u.this.bf <= 3) {
                        u.this.nr(str);
                    } else {
                        u.this.u(new fx(60008, 10003, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final int i) {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = u.this.sx.iterator();
                while (it.hasNext()) {
                    ((u.InterfaceC0156u) it.next()).nr(u.this, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(long j) {
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null) {
            lottieAnimationView.u();
        }
        u(j);
        com.bykv.vk.openvk.component.video.api.u uVar = this.k;
        if (uVar != null) {
            uVar.nr();
        }
        this.bq = true;
        qq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            u(new fx(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.u.nr.fx(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.9
                @Override // java.lang.Runnable
                public void run() {
                    String strU = com.bytedance.sdk.openadsdk.upie.nr.u().u(str);
                    if (TextUtils.isEmpty(strU)) {
                        com.bytedance.sdk.openadsdk.upie.nr.u().u(str, new nr.u<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.9.1
                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(String str2) {
                                u.this.n = str2;
                                u.this.dw();
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(int i, String str2) {
                                if (i == 10006) {
                                    u.this.u(new fx(60008, i, str2));
                                    return;
                                }
                                u.c(u.this);
                                if (u.this.wq <= 3) {
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    u.this.u(str);
                                } else {
                                    u.this.u(new fx(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        u.this.n = strU;
                        u.this.dw();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i, final int i2) {
        Integer num = this.l.get(str);
        if (num == null || num.intValue() != 1) {
            this.l.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.nr.u().u(this.x, str, new nr.u<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.11
                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        u.this.t.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (u.this.f5437a != null) {
                                    u.this.f5437a.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(int i3, String str2) {
                    u.this.l.put(str, 2);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr() {
        z();
        if (this.d > 0) {
            com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = u.this.sx.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final fx fxVar) {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.12
            @Override // java.lang.Runnable
            public void run() {
                if (!u.this.kj) {
                    Iterator it = u.this.sx.iterator();
                    while (it.hasNext()) {
                        ((u.InterfaceC0156u) it.next()).u(u.this, fxVar);
                    }
                }
                u.this.kj = true;
            }
        });
    }

    private void u(String str, iz izVar) {
        if (TextUtils.isEmpty(str)) {
            u(new fx(60008, 10004, "lottie音频url为空"));
            return;
        }
        u.InterfaceC0156u interfaceC0156u = new u.InterfaceC0156u() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.u.3
            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar) {
                u.this.my = true;
                u.this.dw();
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
                u.this.nr(i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, fx fxVar) {
                int iU;
                String strFx;
                int iNr;
                if (fxVar != null) {
                    iU = fxVar.u();
                    iNr = fxVar.nr();
                    strFx = fxVar.fx();
                } else {
                    iU = -1;
                    strFx = "";
                    iNr = -1;
                }
                u.this.u(new fx(iU, iNr, "lottie音频播放失败:".concat(String.valueOf(strFx))));
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2, int i3) {
                u.this.c();
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
                u.this.q();
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void fx(com.bykv.vk.openvk.component.video.api.u uVar) {
            }
        };
        this.o = interfaceC0156u;
        this.k.u(interfaceC0156u);
        this.k.u(izVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z) {
        this.ja = z;
        com.bykv.vk.openvk.component.video.api.u uVar = this.k;
        if (uVar != null) {
            uVar.u(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(long j) {
        this.d = (int) j;
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = sx();
            }
            if (duration > 0) {
                this.f5437a.setProgress((j % duration) / duration);
            }
        }
        com.bykv.vk.openvk.component.video.api.u uVar = this.k;
        if (uVar != null && uVar.sx() > 0) {
            this.k.u((int) (j % this.k.sx()));
        }
        b(true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z, long j, boolean z2) {
        this.ja = z2;
        this.bg = true;
        this.h = j;
        this.k.u(z, j, z2);
        if (this.dw) {
            this.k.u(z2);
            this.k.fx(true);
            if (j > 0) {
                nr(j);
            } else {
                nr();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u() {
        kj();
        this.d = 0;
        this.dw = true;
        this.c = false;
        this.q = false;
        LottieAnimationView lottieAnimationView = this.f5437a;
        if (lottieAnimationView != null) {
            lottieAnimationView.iz();
            this.f5437a.setProgress(0.0f);
        }
        nr();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(u.InterfaceC0156u interfaceC0156u) {
        this.sx.add(interfaceC0156u);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(int i) {
        this.gi = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(float f) {
        this.rh = f;
    }
}
