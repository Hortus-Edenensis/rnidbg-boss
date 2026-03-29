package cn.fly.verify;

import android.content.Context;
import android.net.Network;
import cn.fly.verify.common.exception.VerifyErr;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.pure.entity.PreVerifyResult;
import cn.fly.verify.pure.entity.VerifyResult;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2433a;
    public String b;
    public String c;
    public Context d;
    public boolean e = false;
    protected int f = 1;
    protected e g;
    protected boolean h;
    private int i;
    private boolean j;
    private int k;
    private Integer l;
    private String m;

    public static /* synthetic */ int e(s sVar) {
        int i = sVar.i;
        sVar.i = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        String strJ = al.j();
        if (this.h && "wifi".equalsIgnoreCase(strJ)) {
            return 0;
        }
        if (this.h) {
            return 1;
        }
        if ("wifi".equalsIgnoreCase(strJ)) {
            return 2;
        }
        return "none".equalsIgnoreCase(strJ) ? 4 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        e eVar = this.g;
        return eVar != null && eVar.d();
    }

    public abstract Object a(boolean z);

    public abstract void a(boolean z, Network network, Object obj, cn.fly.verify.common.callback.b bVar, e eVar);

    public e c() {
        return this.g;
    }

    public int d() {
        return this.k;
    }

    public String f() {
        return this.m;
    }

    public HashMap<String, Object> a() {
        f fVarA;
        String str;
        String strA = ah.a(this.f2433a + "_cache");
        if (strA != null) {
            HashMap<String, Object> mapA = fv.a(strA);
            long jLongValue = mapA.containsKey("expired") ? ((Long) mapA.get("expired")).longValue() : 0L;
            int iIntValue = mapA.containsKey("subId") ? ((Integer) mapA.get("subId")).intValue() : -1;
            String str2 = mapA.containsKey("clientId") ? (String) mapA.get("clientId") : "";
            if (iIntValue == as.d()) {
                boolean z = str2 == null || str2.equals(this.b);
                boolean z2 = jLongValue < System.currentTimeMillis();
                if (z && !z2) {
                    return mapA;
                }
                fVarA = f.a();
                str = "cache invalid, expired = " + z2;
            } else {
                fVarA = f.a();
                str = "subid changed, cache invalid";
            }
            fVarA.a(str);
            ah.b(this.f2433a + "_cache", null);
        }
        return null;
    }

    public s b(boolean z) {
        this.j = z;
        return this;
    }

    public Integer e() {
        return this.l;
    }

    public void a(final cn.fly.verify.common.callback.b<PreVerifyResult> bVar) {
        as.a(new ar() { // from class: cn.fly.verify.s.1
            @Override // cn.fly.verify.ar
            public void a() {
                s.this.a(true, (cn.fly.verify.common.callback.b) new cn.fly.verify.common.callback.b<PreVerifyResult>() { // from class: cn.fly.verify.s.1.1
                    @Override // cn.fly.verify.common.callback.b
                    public void a(VerifyException verifyException) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (bVar != null) {
                            s sVar = s.this;
                            if (sVar.f <= 0 || sVar.h() || s.this.j) {
                                s sVar2 = s.this;
                                e eVar = sVar2.g;
                                if (eVar != null) {
                                    eVar.a(sVar2.f2433a, sVar2.b, "failure_retry_count", String.valueOf(sVar2.i));
                                    s sVar3 = s.this;
                                    sVar3.g.a(sVar3.f2433a, sVar3.b, "cell_wifi", String.valueOf(sVar3.g()));
                                }
                                bVar.a(verifyException);
                                return;
                            }
                            r7.f--;
                            s.e(s.this);
                            f.a().a("retry count = " + s.this.i);
                            s sVar4 = s.this;
                            e eVar2 = sVar4.g;
                            if (eVar2 != null) {
                                eVar2.a(sVar4.f2433a, sVar4.b, "retry", String.valueOf(sVar4.i));
                                s sVar5 = s.this;
                                sVar5.g.a(sVar5.f2433a, sVar5.b, "cell_wifi", String.valueOf(sVar5.g()));
                            }
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            s.this.a(bVar);
                        }
                    }

                    @Override // cn.fly.verify.common.callback.b
                    public void a(PreVerifyResult preVerifyResult) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (bVar != null) {
                            s sVar = s.this;
                            e eVar = sVar.g;
                            if (eVar != null) {
                                eVar.a(sVar.f2433a, sVar.b, "success_retry_count", String.valueOf(sVar.i));
                                s sVar2 = s.this;
                                sVar2.g.a(sVar2.f2433a, sVar2.b, "cell_wifi", String.valueOf(sVar2.g()));
                            }
                            bVar.a(preVerifyResult);
                        }
                    }
                });
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                cn.fly.verify.common.callback.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), as.a(th)));
                }
            }
        });
    }

    public String b() {
        return this.e ? "CUCC" : this.f2433a;
    }

    public void a(Integer num) {
        this.l = num;
    }

    public void b(int i) {
        this.k = i;
    }

    public void a(String str) {
        this.m = str;
    }

    public void b(final cn.fly.verify.common.callback.b<VerifyResult> bVar) {
        as.a(new ar() { // from class: cn.fly.verify.s.2
            @Override // cn.fly.verify.ar
            public void a() {
                s.this.a(false, (cn.fly.verify.common.callback.b) new cn.fly.verify.common.callback.b<VerifyResult>() { // from class: cn.fly.verify.s.2.1
                    @Override // cn.fly.verify.common.callback.b
                    public void a(VerifyException verifyException) {
                        ah.b(s.this.f2433a + "_cache", null);
                        s sVar = s.this;
                        e eVar = sVar.g;
                        if (eVar != null) {
                            eVar.a(sVar.f2433a, sVar.b, "cell_wifi", String.valueOf(sVar.g()));
                        }
                        cn.fly.verify.common.callback.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(verifyException);
                        }
                    }

                    @Override // cn.fly.verify.common.callback.b
                    public void a(VerifyResult verifyResult) {
                        ah.b(s.this.f2433a + "_cache", null);
                        s sVar = s.this;
                        e eVar = sVar.g;
                        if (eVar != null) {
                            eVar.a(sVar.f2433a, sVar.b, "cell_wifi", String.valueOf(sVar.g()));
                        }
                        cn.fly.verify.common.callback.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(verifyResult);
                        }
                    }
                });
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                ah.b(s.this.f2433a + "_cache", null);
                cn.fly.verify.common.callback.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), as.a(th)));
                }
            }
        });
    }

    public void a(String str, String str2, String str3, e eVar) {
        this.f2433a = str3;
        this.d = ax.g();
        this.b = str.trim();
        this.c = str2.trim();
        this.g = eVar;
        if ("CTCC".equals(str3)) {
            this.f = 2;
        }
    }

    public void b(final boolean z, final cn.fly.verify.common.callback.b bVar) {
        Network networkC = null;
        try {
            if ("wifi".equalsIgnoreCase(al.j())) {
                e eVar = this.g;
                if (eVar != null) {
                    eVar.a(this.f2433a, this.b, "switch_s");
                }
                networkC = new aj().c();
                e eVar2 = this.g;
                if (eVar2 != null) {
                    eVar2.a(this.f2433a, this.b, "switch_e");
                }
            }
        } catch (VerifyException e) {
            if (a(e, bVar)) {
                return;
            }
            if (ai.a().u() == 0) {
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
            e eVar3 = this.g;
            if (eVar3 != null) {
                c cVarB = eVar3.b("switch_e");
                cVarB.f(this.f2433a);
                cVarB.e(this.b);
                cVarB.b(e.getCode());
                cVarB.d(e.getMessage());
                this.g.a(cVarB);
            }
        }
        Network network = networkC;
        Object objA = a(z);
        e eVar4 = this.g;
        if (eVar4 != null) {
            eVar4.a(eVar4.b("request_start"));
        }
        a(z, network, objA, new cn.fly.verify.common.callback.b() { // from class: cn.fly.verify.s.3
            @Override // cn.fly.verify.common.callback.b
            public void a(VerifyException verifyException) {
                cn.fly.verify.common.callback.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(verifyException);
                }
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(Object obj) {
                e eVar5 = s.this.g;
                if (eVar5 != null) {
                    eVar5.a(eVar5.b("request_end"));
                }
                if (obj == null || !(obj instanceof HashMap)) {
                    return;
                }
                HashMap map = (HashMap) obj;
                String str = map.containsKey("phone") ? (String) map.get("phone") : "";
                long jLongValue = map.containsKey("expired") ? ((Long) map.get("expired")).longValue() : 0L;
                e eVar6 = s.this.g;
                if (eVar6 != null) {
                    eVar6.c(str);
                }
                if (z) {
                    map.put("subId", Integer.valueOf(as.d()));
                    map.put("clientId", s.this.b);
                    ah.b(s.this.f2433a + "_cache", fv.a(map));
                } else {
                    ai.a().b(0);
                    ai.a().a(jLongValue);
                }
                cn.fly.verify.common.callback.b bVar2 = bVar;
                if (bVar2 != null) {
                    if (!z) {
                        bVar.a(new VerifyResult(str, map.containsKey("optoken") ? (String) map.get("optoken") : "", s.this.f2433a));
                    } else {
                        String str2 = s.this.f2433a;
                        bVar2.a(new PreVerifyResult(str, str2, jLongValue, str2));
                    }
                }
            }
        }, this.g);
    }

    public void a(boolean z, cn.fly.verify.common.callback.b bVar) {
        cn.fly.verify.pure.entity.a verifyResult;
        this.h = as.b(this.d);
        HashMap<String, Object> mapA = a();
        if (mapA == null) {
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(eVar.b("no_upc"));
            }
            b(z, bVar);
            return;
        }
        String str = mapA.containsKey("phone") ? (String) mapA.get("phone") : null;
        long jLongValue = mapA.containsKey("expired") ? ((Long) mapA.get("expired")).longValue() : 0L;
        e eVar2 = this.g;
        if (eVar2 != null) {
            eVar2.c(str);
            e eVar3 = this.g;
            eVar3.a(eVar3.b("upc"));
        }
        if (!z) {
            ah.b(this.f2433a + "_cache", null);
            ai.a().b(2);
            ai.a().a(jLongValue);
        }
        if (bVar != null) {
            if (z) {
                String str2 = this.f2433a;
                verifyResult = new PreVerifyResult(str, str2, jLongValue, str2);
            } else {
                verifyResult = new VerifyResult(str, mapA.containsKey("optoken") ? (String) mapA.get("optoken") : null, this.f2433a);
            }
            bVar.a(verifyResult);
        }
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(VerifyException verifyException, cn.fly.verify.common.callback.b bVar) {
        return false;
    }
}
