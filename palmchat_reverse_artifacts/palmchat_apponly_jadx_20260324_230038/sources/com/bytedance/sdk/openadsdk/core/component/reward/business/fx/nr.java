package com.bytedance.sdk.openadsdk.core.component.reward.business.fx;

import android.widget.Toast;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.u.n;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.my.fx.nr.t;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private u u;
    private AtomicBoolean nr = new AtomicBoolean(false);
    private AtomicBoolean fx = new AtomicBoolean(false);
    private AtomicBoolean b = new AtomicBoolean(false);

    public nr(u uVar) {
        this.u = uVar;
    }

    public boolean fx() {
        return this.nr.get();
    }

    public void nr(final int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar) {
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.u.nr.u().u(nrVar, i, bcVar, new com.bytedance.sdk.openadsdk.core.component.reward.u.b(new com.bytedance.sdk.openadsdk.bq.u.nr.u.b(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr.2
                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
                public void nr() {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
                public void u(final t tVar) {
                    x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            t tVar2 = tVar;
                            if (tVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.nr) {
                                com.bytedance.sdk.openadsdk.core.component.reward.nr nrVar2 = (com.bytedance.sdk.openadsdk.core.component.reward.nr) tVar2;
                                nrVar2.u(true);
                                nrVar2.u(nr.this.u.getActivity());
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                b.nr(bcVar, true, i, 0);
                            } else {
                                nr.this.u();
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                b.nr(bcVar, false, i, 1);
                            }
                            nr.this.b.set(false);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
                public void nr(t tVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
                public void u(int i2, String str) {
                    k.nr("SecondPageImpl", "requestNewFullScreenAd onError code:" + i2 + " message:" + str);
                    nr.this.b.set(false);
                    nr.this.u();
                    b.nr(bcVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            k.u("SecondPageImpl", "requestNewAd error", th.toString());
            this.b.set(false);
            u();
            b.u(bcVar, false, i, 6);
        }
    }

    public void u(int i) {
        u uVar = this.u;
        if (uVar == null) {
            u();
            b.u(null, false, i, 1);
            return;
        }
        bc bcVarU = uVar.u();
        if (bcVarU == null) {
            u();
            b.u(null, false, i, 2);
            return;
        }
        if (this.u.getActivity() == null) {
            u();
            b.u(bcVarU, false, i, 3);
            return;
        }
        if (this.b.get()) {
            b.u(bcVarU, false, i, 4);
            return;
        }
        this.b.set(true);
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().u(jp.u(bcVarU, ""));
        int iJk = jp.jk(bcVarU);
        if (iJk == 7) {
            u(i, nrVarU, bcVarU);
        } else {
            if (iJk == 8) {
                nr(i, nrVarU, bcVarU);
                return;
            }
            u();
            b.u(bcVarU, false, i, 5);
            this.b.set(false);
        }
    }

    public boolean nr() {
        return this.fx.get();
    }

    public void nr(boolean z) {
        this.nr.set(z);
    }

    public void u(final int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar) {
        try {
            n.u().u(nrVar, i, bcVar, new com.bytedance.sdk.openadsdk.core.component.reward.u.b(new com.bytedance.sdk.openadsdk.bq.u.nr.u.x(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr.1
                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void nr() {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void u(final com.bytedance.sdk.openadsdk.my.fx.nr.k kVar) {
                    x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.my.fx.nr.k kVar2 = kVar;
                            if (kVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.fx) {
                                com.bytedance.sdk.openadsdk.core.component.reward.fx fxVar = (com.bytedance.sdk.openadsdk.core.component.reward.fx) kVar2;
                                fxVar.u(true);
                                fxVar.u(nr.this.u.getActivity());
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                b.nr(bcVar, true, i, 0);
                            } else {
                                nr.this.u();
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                b.nr(bcVar, false, i, 1);
                            }
                            nr.this.b.set(false);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void nr(com.bytedance.sdk.openadsdk.my.fx.nr.k kVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
                public void u(int i2, String str) {
                    k.nr("SecondPageImpl", "requestNewRewardAd onError code:" + i2 + " message:" + str);
                    nr.this.b.set(false);
                    nr.this.u();
                    b.nr(bcVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            this.b.set(false);
            k.u("SecondPageImpl", "requestNewAd error", th.toString());
            u();
            b.u(bcVar, false, i, 6);
        }
    }

    public void u() {
        u uVar = this.u;
        if (uVar == null || uVar.getActivity() == null) {
            return;
        }
        Toast.makeText(this.u.getActivity(), "加载失败了，将跳转至推荐页面", 1).show();
        this.u.nr();
    }

    public void u(boolean z) {
        this.fx.set(z);
    }
}
