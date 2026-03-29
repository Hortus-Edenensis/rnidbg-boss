package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.nb;
import com.bytedance.sdk.openadsdk.core.nr.u.u.u;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f5266a = new Handler(Looper.getMainLooper());
    private fx b;
    private FrameLayout fx;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx iz;
    private SoftReference<com.bytedance.sdk.openadsdk.my.fx.u.fx> n;
    private bc nr;
    private com.bytedance.sdk.openadsdk.core.nr.u pn;
    private Context u;
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.u> x;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        Context getActivity();

        void nr();

        void u();

        void u(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        this.f5266a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (!com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.u) {
                    n.this.nr();
                    return;
                }
                com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.u = false;
                if (n.this.iz instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                    ((com.bytedance.sdk.openadsdk.core.l.fx.pn) n.this.iz).n().u(new com.bytedance.sdk.openadsdk.core.l.fx.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.n.4.1
                        @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.u
                        public void u() {
                            n.this.nr();
                        }
                    });
                }
            }
        }, 100L);
    }

    public void nr() {
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.nr();
        }
    }

    public void u(Context context, bc bcVar) {
        this.u = context;
        this.nr = bcVar;
        this.fx = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.fx.setLayoutParams(layoutParams);
        nb.nr(this.nr);
    }

    public ViewGroup u() {
        return this.fx;
    }

    public void u(String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.u uVar, com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        this.x = new SoftReference<>(uVar);
        if (fxVar != null) {
            this.n = new SoftReference<>(fxVar);
        }
        HashMap map = new HashMap();
        map.put("splash_show_type", Integer.valueOf(i));
        com.bytedance.sdk.openadsdk.core.nr.u uVar2 = new com.bytedance.sdk.openadsdk.core.nr.u(this.u, this.nr, str, 4);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(map);
        SoftReference<com.bytedance.sdk.openadsdk.my.fx.u.fx> softReference = this.n;
        if (softReference == null) {
            u(str, this.fx, null);
        } else {
            u(str, this.fx, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.iz);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) uVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(new u.InterfaceC0278u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.n.1
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.u.u.InterfaceC0278u
            public void u(View view, int i2) {
                if (n.this.x != null && n.this.x.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.u) n.this.x.get()).nr();
                }
                n.this.fx();
            }
        });
        this.pn = uVar2;
        fx fxVar2 = this.b;
        if (fxVar2 != null) {
            fxVar2.u(uVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.l.nr.fx u(bc bcVar, String str) {
        if (bcVar.qf() == 4) {
            return com.bytedance.sdk.openadsdk.core.l.n.u(this.u, bcVar, str, false);
        }
        return null;
    }

    private void u(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        bc bcVar = this.nr;
        if (bcVar == null || this.u == null || viewGroup == null) {
            return;
        }
        this.iz = u(bcVar, str);
        EmptyView emptyView = new EmptyView(this.u, viewGroup, this.nr.re());
        emptyView.u(this.nr, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (fxVar != null) {
            u(fxVar);
        }
        emptyView.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.n.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                if (n.this.iz != null) {
                    n.this.iz.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z) {
                if (n.this.iz != null && z) {
                    n.this.iz.u();
                }
                n.this.u(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                ViewGroup viewGroup2;
                Context context;
                if (n.this.iz != null) {
                    n.this.iz.u(false);
                }
                if (n.this.iz == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                n.this.iz.u((Activity) context);
            }
        });
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar2 = this.iz;
        if (fxVar2 == null) {
            return;
        }
        fxVar2.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.n.3
            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void fx(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.fx(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void nr(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.nr(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u() {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.u();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.u(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, String str, String str2) {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.u(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(String str, String str2) {
                com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar3 = fxVar;
                if (fxVar3 != null) {
                    fxVar3.u(str, str2);
                }
            }
        });
    }

    public void u(int i) {
        if (i == 2 && nb.u(this.nr)) {
            this.b = new b();
        }
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(this.u, this.fx, this.nr);
            this.b.u(this.pn);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, u uVar) {
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(bVar, uVar);
        }
    }

    public void u(boolean z) {
        fx fxVar = this.b;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }
}
