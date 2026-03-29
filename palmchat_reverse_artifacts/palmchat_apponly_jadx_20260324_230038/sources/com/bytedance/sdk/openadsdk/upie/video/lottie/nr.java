package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.fx.fx;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.openadsdk.upie.nr;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bykv.vk.openvk.component.video.api.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.component.video.api.u f5436a;
    private boolean b;
    private final int fx;
    private long iz;
    private LottieAnimationView l;
    private final int nr;
    private final com.bykv.vk.openvk.component.video.api.renderview.nr t;
    private final String u = "UpieVideoPlayer";
    private int pn = 0;
    private volatile boolean x = false;
    private volatile boolean n = false;
    private final Map<u.InterfaceC0156u, u.InterfaceC0156u> jk = new ConcurrentHashMap();

    public nr(com.bykv.vk.openvk.component.video.api.u uVar, com.bytedance.sdk.openadsdk.upie.u uVar2, com.bykv.vk.openvk.component.video.api.renderview.nr nrVar) {
        this.f5436a = uVar;
        this.nr = uVar2.b();
        this.fx = uVar2.pn();
        this.t = nrVar;
        if (nrVar instanceof UpieVideoView) {
            this.l = ((UpieVideoView) nrVar).getLottieAnimationView();
        }
        u(uVar2.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.4
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.n && nr.this.x) {
                    nr.this.f5436a.nr();
                    if (nr.this.l != null) {
                        nr.this.l.u();
                        if (nr.this.iz > 0) {
                            nr nrVar = nr.this;
                            nrVar.nr(nrVar.iz);
                        }
                    }
                }
            }
        });
    }

    public static /* synthetic */ int u(nr nrVar) {
        int i = nrVar.pn;
        nrVar.pn = i + 1;
        return i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long bg() {
        return this.f5436a.bg();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean k() {
        return !this.b && this.f5436a.k();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean mv() {
        return !this.b && this.f5436a.mv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long my() {
        return this.f5436a.my();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int o() {
        return this.f5436a.o();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean s() {
        return !this.b && this.f5436a.s();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long sx() {
        return this.f5436a.sx();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean a() {
        return !this.b && this.f5436a.a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void b() {
        this.f5436a.b();
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.x();
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).nr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean iz() {
        return this.f5436a.iz();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean jk() {
        return !this.b && this.f5436a.jk();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int l() {
        return this.fx;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceTexture n() {
        return this.f5436a.n();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void pn() {
        this.f5436a.pn();
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.iz();
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).nr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int t() {
        return this.nr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceHolder x() {
        return this.f5436a.x();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx() {
        this.f5436a.fx();
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.x();
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).nr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr() {
        this.f5436a.nr();
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.nr();
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            u(new fx(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.u.nr.fx(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    String strU = com.bytedance.sdk.openadsdk.upie.nr.u().u(str);
                    if (TextUtils.isEmpty(strU)) {
                        com.bytedance.sdk.openadsdk.upie.nr.u().u(str, new nr.u<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.1.1
                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(String str2) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                nr.this.u(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(int i, String str2) {
                                if (i == 10006) {
                                    nr.this.u(new fx(60008, i, str2));
                                    return;
                                }
                                nr.u(nr.this);
                                if (nr.this.pn <= 3) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    nr.this.u(str);
                                } else {
                                    nr.this.u(new fx(60008, i, str2));
                                }
                            }
                        });
                    } else {
                        nr.this.u(strU, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(long j) {
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = sx();
            }
            if (duration > 0) {
                this.l.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx(boolean z) {
        this.f5436a.fx(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final fx fxVar) {
        com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.2
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.b) {
                    return;
                }
                nr.this.b = true;
                Iterator it = nr.this.jk.entrySet().iterator();
                while (it.hasNext()) {
                    ((u.InterfaceC0156u) ((Map.Entry) it.next()).getKey()).u(nr.this, fxVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.3
            @Override // java.lang.Runnable
            public void run() {
                nr.this.x = true;
                if (nr.this.l != null) {
                    nr.this.l.u(str, str2);
                }
                nr.this.bq();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr(boolean z) {
        this.f5436a.nr(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(iz izVar) {
        this.f5436a.u(izVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z) {
        this.f5436a.u(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z, long j, boolean z2) {
        this.f5436a.u(z, j, z2);
        this.iz = j;
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).u();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u() {
        this.f5436a.u();
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.iz();
            this.l.setProgress(0.0f);
            this.l.u();
        }
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.t;
        if (nrVar instanceof UpieVideoView) {
            ((UpieVideoView) nrVar).u();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(long j) {
        this.f5436a.u(j);
        nr(j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceHolder surfaceHolder) {
        this.f5436a.u(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(SurfaceTexture surfaceTexture) {
        this.f5436a.u(surfaceTexture);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final u.InterfaceC0156u interfaceC0156u) {
        if (interfaceC0156u == null) {
            return;
        }
        u.InterfaceC0156u interfaceC0156u2 = new u.InterfaceC0156u() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.5
            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void fx(com.bykv.vk.openvk.component.video.api.u uVar) {
                interfaceC0156u.fx(nr.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar) {
                com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nr.this.n = true;
                        if (!nr.this.x) {
                            nr.this.f5436a.fx();
                        }
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0156u.nr(nr.this);
                        nr.this.bq();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar) {
                interfaceC0156u.u(nr.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
                interfaceC0156u.nr(nr.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, final long j) {
                com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.nr.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        interfaceC0156u.u(nr.this, j);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, fx fxVar) {
                nr.this.u(fxVar);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, boolean z) {
                interfaceC0156u.u(nr.this, z);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2) {
                u.InterfaceC0156u interfaceC0156u3 = interfaceC0156u;
                nr nrVar = nr.this;
                interfaceC0156u3.u((com.bykv.vk.openvk.component.video.api.u) nrVar, nrVar.nr, nr.this.fx);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2, int i3) {
                interfaceC0156u.u(nr.this, i, i2, i3);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
                interfaceC0156u.u((com.bykv.vk.openvk.component.video.api.u) nr.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j, long j2) {
                interfaceC0156u.u(nr.this, j, j2);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, JSONObject jSONObject, String str) {
                interfaceC0156u.u(nr.this, jSONObject, str);
            }
        };
        this.jk.put(interfaceC0156u, interfaceC0156u2);
        this.f5436a.u(interfaceC0156u2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(int i) {
        this.f5436a.u(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(float f) {
        this.f5436a.u(f);
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }
}
