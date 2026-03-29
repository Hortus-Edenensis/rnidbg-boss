package com.bytedance.sdk.openadsdk.core.pn.pn;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.pn.iz;
import com.bytedance.sdk.openadsdk.core.qq;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b<T> extends nr {
    private final long b;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(boolean z);
    }

    public b(int i) {
        super(i);
        this.b = System.currentTimeMillis();
    }

    private void b(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, pn<T> pnVar, oa oaVar) {
        u(nrVar, pnVar, oaVar, (com.bytedance.sdk.openadsdk.core.pn.pn.u.nr) null);
    }

    private void fx(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, pn<T> pnVar, oa oaVar) {
        final com.bytedance.sdk.openadsdk.core.pn.pn.u.fx fxVar = new com.bytedance.sdk.openadsdk.core.pn.pn.u.fx(this.u);
        u(nrVar, pnVar, oaVar, fxVar);
        u(nrVar, pnVar, oaVar.iz == 2, fxVar, 0L, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.9
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
            public void u(boolean z) {
                if (z) {
                    return;
                }
                fxVar.u(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, pn<T> pnVar, oa oaVar) {
        long jCurrentTimeMillis;
        final n.fx fxVarT = this.u.t();
        final iz.u uVarU = com.bytedance.sdk.openadsdk.core.pn.iz.u(nrVar.b(), fxVarT);
        final com.bytedance.sdk.openadsdk.core.pn.pn.u.b bVar = new com.bytedance.sdk.openadsdk.core.pn.pn.u.b(this.u);
        bVar.u();
        u(nrVar, pnVar, oaVar, bVar);
        nrVar.b();
        final int iU = uVarU.u(fxVarT.pn(), fxVarT);
        if (iU < 0) {
            nrVar.b();
            bVar.u(false);
            return;
        }
        if (iU > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iU) * 60) * 1000);
            nrVar.b();
        } else {
            jCurrentTimeMillis = 0;
        }
        u(nrVar, pnVar, oaVar.iz == 2, bVar, jCurrentTimeMillis, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.11
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
            public void u(boolean z) {
                nrVar.b();
                bVar.u(z);
                if (z) {
                    iz.u uVar = uVarU;
                    int i = b.this.nr;
                    com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2 = nrVar;
                    n.fx fxVar = fxVarT;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iU);
                    uVar.u(i, nrVar2, fxVar, "backup_cache", sb.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, pn<T> pnVar) {
        if (nrVar == null) {
            return;
        }
        if (i == -1) {
            i = nr();
        }
        if (n.u(this.nr).u("load_only_online", nrVar, null)) {
            i = 0;
        }
        nrVar.b();
        if (i == 1) {
            u(nrVar, pnVar, oaVar);
            return;
        }
        if (i == 2) {
            nr(nrVar, pnVar, oaVar);
            return;
        }
        if (i == 3) {
            fx(nrVar, pnVar, oaVar);
            return;
        }
        if (i == 4) {
            pn(nrVar, pnVar, oaVar);
        } else if (i != 5) {
            b(nrVar, pnVar, oaVar);
        } else {
            x(nrVar, pnVar, oaVar);
        }
    }

    private void pn(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final pn<T> pnVar, oa oaVar) {
        u(nrVar, pnVar, oaVar.iz == 2, (com.bytedance.sdk.openadsdk.core.pn.pn.u.nr) null, 0L, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.10
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
            public void u(boolean z) {
                if (z) {
                    return;
                }
                pnVar.u(-3, "no cache");
            }
        });
    }

    private void x(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, pn<T> pnVar, oa oaVar) {
        double d;
        n.fx fxVarT = this.u.t();
        iz.u uVarU = com.bytedance.sdk.openadsdk.core.pn.iz.u(nrVar.b(), fxVarT);
        if (fxVarT.nr() > 0) {
            nrVar.b();
            try {
                d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value"));
            } catch (Exception unused) {
                d = 0.0d;
            }
            if (d > 0.0d && d < fxVarT.nr()) {
                nrVar.b();
                u(nrVar, (pn) pnVar, oaVar, true, 0L, "device_score", String.valueOf(d));
                return;
            }
        }
        if (fxVarT.fx() > 0) {
            nrVar.b();
            int iFx = o.fx(dw.getContext());
            boolean z = true;
            if (iFx == 2 ? (fxVarT.fx() & 1) == 0 : iFx == 3 ? (2 & fxVarT.fx()) == 0 : iFx == 4 ? (fxVarT.fx() & 16) == 0 : iFx == 5 ? (4 & fxVarT.fx()) == 0 : iFx != 6 || (fxVarT.fx() & 8) == 0) {
                z = false;
            }
            if (z) {
                nrVar.b();
                u(nrVar, (pn) pnVar, oaVar, true, 0L, HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(iFx));
                return;
            }
        }
        if (fxVarT.b() > 0) {
            nrVar.b();
            int iU = uVarU.u(fxVarT.b(), fxVarT);
            if (iU > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iU) * 60) * 1000);
                nrVar.b();
                u(nrVar, (pn) pnVar, oaVar, true, jCurrentTimeMillis, "good_cache", String.valueOf(iU));
                return;
            } else if (iU == 0) {
                nrVar.b();
                u(nrVar, (pn) pnVar, oaVar, true, 0L, "behavior_score", String.valueOf(iU));
                return;
            }
        }
        nrVar.b();
        u(nrVar, (pn) pnVar, oaVar, false, 0L, "", "");
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar, final int i, final pn<T> pnVar) {
        com.bytedance.sdk.openadsdk.gi.x.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.nr(nrVar, oaVar, i, new iz(pnVar));
            }
        });
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final pn<T> pnVar, final oa oaVar) {
        final com.bytedance.sdk.openadsdk.core.pn.pn.u.u uVar = new com.bytedance.sdk.openadsdk.core.pn.pn.u.u(this.u) { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.6
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.u
            public void u() {
                b.this.u(nrVar, pnVar, oaVar, this);
            }
        };
        u(nrVar, pnVar, oaVar.iz == 2, uVar, 0L, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.7
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
            public void u(boolean z) {
                if (z) {
                    return;
                }
                uVar.u(false);
            }
        });
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final pn<T> pnVar, final oa oaVar, boolean z, long j, final String str, final String str2) {
        final n.fx fxVarT = this.u.t();
        final iz.u uVarU = com.bytedance.sdk.openadsdk.core.pn.iz.u(nrVar.b(), fxVarT);
        if (z) {
            nrVar.b();
            final com.bytedance.sdk.openadsdk.core.pn.pn.u.u uVar = new com.bytedance.sdk.openadsdk.core.pn.pn.u.u(this.u) { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.12
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.u.u
                public void u() {
                    nrVar.b();
                    b.this.iz(nrVar, pnVar, oaVar);
                }
            };
            u(nrVar, pnVar, oaVar.iz == 2, uVar, j, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.13
                @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
                public void u(boolean z2) {
                    nrVar.b();
                    if (z2) {
                        uVarU.u(b.this.nr, nrVar, fxVarT, str, str2);
                    } else {
                        uVar.u(false);
                    }
                }
            });
        } else {
            nrVar.b();
            iz(nrVar, pnVar, oaVar);
        }
    }

    private void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, pn<T> pnVar, oa oaVar) {
        final com.bytedance.sdk.openadsdk.core.pn.pn.u.b bVar = new com.bytedance.sdk.openadsdk.core.pn.pn.u.b(this.u);
        bVar.u();
        u(nrVar, pnVar, oaVar, bVar);
        u(nrVar, pnVar, oaVar.iz == 2, bVar, 0L, new u() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.8
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.b.u
            public void u(boolean z) {
                bVar.u(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nr() {
        n.nr nrVar = this.u;
        return (nrVar == null || nrVar.a() == -1) ? com.bytedance.sdk.openadsdk.core.pn.pn.u.u(this.nr) : this.u.a();
    }

    private void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final pn<T> pnVar, final boolean z, final com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar2, long j, final u uVar) {
        List<bc> listU;
        nrVar.b();
        if (!TextUtils.isEmpty(nrVar.dw())) {
            uVar.u(false);
            return;
        }
        if (u(z) == null) {
            uVar.u(false);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iMin = Math.min(n.u(this.nr).l(), nrVar.l());
        com.bytedance.sdk.openadsdk.core.pn.fx.u uVar2 = this.fx;
        if (uVar2 != null) {
            uVar2.nr(nrVar.b());
            listU = this.fx.u(nrVar.b(), j, iMin);
        } else {
            listU = null;
        }
        if (listU != null && !listU.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (bc bcVar : listU) {
                if (u(bcVar)) {
                    arrayList.add(bcVar);
                }
            }
            if (arrayList.isEmpty()) {
                uVar.u(false);
                return;
            }
            if (!u(z).u(nrVar, arrayList)) {
                uVar.u(false);
                return;
            }
            nrVar.b();
            arrayList.size();
            com.bytedance.sdk.openadsdk.core.pn.nr.u uVar3 = new com.bytedance.sdk.openadsdk.core.pn.nr.u(this.nr);
            uVar3.u(jCurrentTimeMillis);
            uVar3.nr(System.currentTimeMillis());
            uVar3.u(arrayList, new com.bytedance.sdk.openadsdk.core.pn.nr.pn() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.2
                @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                public void fx(List<bc> list) {
                    Iterator<bc> it = list.iterator();
                    while (it.hasNext()) {
                        b.this.fx.u(nrVar.b(), it.next());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                public void nr(List<bc> list) {
                    nrVar.b();
                    list.size();
                    if (list.isEmpty()) {
                        uVar.u(false);
                    } else {
                        b.this.u(list, nrVar, z, nrVar2, pnVar, uVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pn.nr.pn
                public void u(List<bc> list) {
                    b.this.u(list, nrVar, z, nrVar2, pnVar, uVar);
                }
            });
            return;
        }
        uVar.u(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final pn<T> pnVar, final oa oaVar, final com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar2) {
        nrVar.b();
        dw.u().u(nrVar, oaVar, this.nr, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.3
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar3) {
                nrVar.b();
                if (b.this.u(oaVar.iz == 2) != null) {
                    b.this.u(oaVar.iz == 2).u(nrVar, i, str, nrVar3);
                }
                com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar4 = nrVar2;
                if (nrVar4 != null) {
                    nrVar4.u(pnVar, i, str);
                    return;
                }
                pn pnVar2 = pnVar;
                if (pnVar2 != null) {
                    pnVar2.u(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, final com.bytedance.sdk.openadsdk.core.kj.nr nrVar3) {
                nrVar.b();
                com.bytedance.sdk.openadsdk.core.pn.u.u uVarU = b.this.u(oaVar.iz == 2);
                if (uVarU == null) {
                    return;
                }
                uVarU.u(b.this.nr, uVar, nrVar3, oaVar, nrVar, pnVar, new x() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.3.1
                    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.x
                    public void u(fx fxVar) {
                        if (fxVar != null) {
                            com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar4 = nrVar2;
                            if (nrVar4 == null) {
                                fxVar.u();
                            } else {
                                nrVar4.u(fxVar);
                            }
                        }
                        com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar5 = nrVar2;
                        if (nrVar5 != null) {
                            nrVar5.fx();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.x
                    public void u(int i) {
                        pn pnVar2 = pnVar;
                        if (pnVar2 != null) {
                            pnVar2.u(i, com.bytedance.sdk.openadsdk.core.x.u(i));
                        }
                        nrVar3.u(i);
                        com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar3);
                        com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar4 = nrVar2;
                        if (nrVar4 != null) {
                            nrVar4.fx();
                        }
                    }
                });
            }
        });
    }

    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final oa oaVar) {
        if (nrVar == null) {
            return;
        }
        nrVar.b();
        if (com.bytedance.sdk.openadsdk.core.live.pn.b.u(nrVar.c())) {
            com.bytedance.sdk.openadsdk.gi.x.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(nrVar.dw())) {
                        if (b.this.u(oaVar.iz == 2) != null) {
                            b.this.u(oaVar.iz == 2).u(nrVar);
                        }
                    } else if (b.this.nr() != 0 && b.this.fx.u(nrVar.b())) {
                        nrVar.b();
                        b.this.u(nrVar, (pn) null, oaVar, (com.bytedance.sdk.openadsdk.core.pn.pn.u.nr) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final List<bc> list, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z, final com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar2, pn<T> pnVar, final u uVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong(f.p, this.b);
        u(z).u(this.nr, list, nrVar, pnVar, bundle, new x() { // from class: com.bytedance.sdk.openadsdk.core.pn.pn.b.5
            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.x
            public void u(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.pn.pn.x
            public void u(fx fxVar) {
                com.bytedance.sdk.openadsdk.core.pn.pn.u.nr nrVar3 = nrVar2;
                if (nrVar3 != null) {
                    nrVar3.nr(fxVar);
                    nrVar2.u(true);
                    list.size();
                    nrVar.b();
                } else {
                    fxVar.u();
                    list.size();
                    nrVar.b();
                }
                uVar.u(true);
            }
        });
    }
}
