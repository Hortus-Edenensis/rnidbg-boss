package com.bytedance.sdk.openadsdk.core.component.splash.fx.fx;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.fx.u.x;
import com.bytedance.sdk.openadsdk.core.kj.oa;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.u.u f5258a;
    volatile boolean b;
    volatile boolean fx;
    private nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x> iz;
    private com.bytedance.sdk.openadsdk.core.component.splash.nr jk;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz n;
    volatile boolean nr;
    private com.bytedance.sdk.openadsdk.core.component.splash.fx.u.pn pn;
    volatile boolean u;
    private x x;

    public pn(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.pn pnVar, nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x> nrVar, com.bytedance.sdk.openadsdk.core.component.splash.u.u uVar, com.bytedance.sdk.openadsdk.core.component.splash.nr nrVar2) {
        if (pnVar == null || nrVar == null) {
            return;
        }
        this.pn = pnVar;
        this.iz = nrVar;
        this.f5258a = uVar;
        this.jk = nrVar2;
    }

    public void u(final int i) {
        if (this.pn == null || this.iz == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.fx().u(this.pn, this.iz);
            return;
        }
        if (i == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u(this.f5258a).u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    pn.this.iz.nr(izVar);
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.u.u.u(i) || pn.this.f5258a == null || pn.this.pn == null) {
                        return;
                    }
                    pn.this.f5258a.nr(pn.this.pn.b(), pn.this.pn.pn());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    if (xVar != null && pn.this.pn != null) {
                        pn.this.pn.u(xVar.b());
                        pn.this.pn.u(xVar.fx());
                    }
                    if (pn.this.jk == null || !pn.this.jk.nr()) {
                        new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.fx().u(pn.this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                            public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                                if (!pn.this.b) {
                                    pn.this.iz.nr(izVar);
                                } else {
                                    if (pn.this.f5258a == null || pn.this.pn == null) {
                                        return;
                                    }
                                    pn.this.f5258a.u(izVar, pn.this.pn.b(), true, 1);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                            public void u(x xVar2) {
                                pn.this.iz.u(xVar2);
                                if (!com.bytedance.sdk.openadsdk.core.component.splash.u.u.u(i) || pn.this.f5258a == null || pn.this.pn == null) {
                                    return;
                                }
                                pn.this.f5258a.nr(pn.this.pn.b(), pn.this.pn.pn());
                            }
                        });
                    } else {
                        pn.this.iz.u(xVar);
                    }
                }
            });
            return;
        }
        if (i == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.fx().u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    pn.this.n = izVar;
                    if (pn.this.x != null && izVar != null) {
                        izVar.u(pn.this.x.b());
                        izVar.u(pn.this.x.fx());
                    }
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时物料加载成功 isCache " + izVar.pn());
                    pn.this.iz.nr(izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "实时物料加载失败 ");
                    pn.this.iz.u(xVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u(this.f5258a).u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存物料加载成功 isCache " + izVar.pn());
                    pn.this.iz.nr(izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    pn.this.x = xVar;
                    com.bytedance.sdk.openadsdk.core.x.u.u("Splash_FullLink", "缓存物料加载失败  ");
                    if (pn.this.n != null && xVar != null) {
                        pn.this.n.u(xVar.b());
                        pn.this.n.u(xVar.fx());
                    }
                    pn.this.iz.u(xVar);
                }
            });
        } else if (i == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.fx().u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    pn.this.n = izVar;
                    if (pn.this.fx || pn.this.b) {
                        if (pn.this.f5258a == null || pn.this.pn == null) {
                            return;
                        }
                        pn.this.f5258a.u(izVar, pn.this.pn.b(), true, 3);
                        return;
                    }
                    if (pn.this.x != null && izVar != null) {
                        izVar.u(pn.this.x.b());
                        izVar.u(pn.this.x.fx());
                    }
                    pn.this.fx = true;
                    pn.this.iz.nr(izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    pn.this.u = true;
                    if (pn.this.nr) {
                        pn.this.iz.u(xVar);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.u.u.u(i) || pn.this.f5258a == null || pn.this.pn == null) {
                        return;
                    }
                    pn.this.f5258a.nr(pn.this.pn.b(), pn.this.pn.pn());
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u(this.f5258a).u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    if (pn.this.fx) {
                        return;
                    }
                    pn.this.fx = true;
                    pn.this.iz.nr(izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    pn.this.x = xVar;
                    if (pn.this.n != null && xVar != null) {
                        pn.this.n.u(xVar.b());
                        pn.this.n.u(xVar.fx());
                    }
                    pn.this.nr = true;
                    if (pn.this.u) {
                        pn.this.iz.u(xVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.component.splash.nr.u.u(this.f5258a).u(this.pn, new nr<com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz, x>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.pn.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public void nr(com.bytedance.sdk.openadsdk.core.component.splash.fx.u.iz izVar) {
                    pn.this.iz.nr(izVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.fx.nr
                public void u(x xVar) {
                    pn.this.iz.u(xVar);
                }
            });
        }
    }

    public void u() {
        this.b = true;
    }

    public static boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar) {
        return (nrVar == null || oaVar == null || TextUtils.isEmpty(nrVar.dw()) || oaVar.b > 0) ? false : true;
    }
}
