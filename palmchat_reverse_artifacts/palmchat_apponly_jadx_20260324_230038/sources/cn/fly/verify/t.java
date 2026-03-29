package cn.fly.verify;

import android.net.Network;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.fly.verify.common.exception.VerifyErr;
import cn.fly.verify.common.exception.VerifyException;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class t extends s {
    private SparseArray<String> i;
    private String j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        x xVar = new x(this.b, this.c);
        xVar.c("https://config2.cmpassport.com/client/uniConfig");
        xVar.b("POST");
        xVar.a(str);
        new z().a(xVar, 4);
    }

    private int g() {
        String strJ = al.j();
        if (!TextUtils.isEmpty(strJ) && !"none".equalsIgnoreCase(strJ)) {
            boolean zB = as.b(ax.g());
            if ("wifi".equalsIgnoreCase(strJ) && zB) {
                return 3;
            }
            if ("wifi".equalsIgnoreCase(strJ) && !zB) {
                return 2;
            }
            if (zB) {
                return 1;
            }
        }
        return 0;
    }

    @Override // cn.fly.verify.s
    public Object a(boolean z) {
        int iG = g();
        if (!as.a(ax.g())) {
            return new VerifyException(200010, this.i.get(200010));
        }
        if (iG == 0) {
            return new VerifyException(102101, this.i.get(102101));
        }
        if (iG == 2) {
            return new VerifyException(102103, this.i.get(102103));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        x xVar = new x(this.b, this.c);
        xVar.b("POST");
        xVar.c("https://log2.cmpassport.com:9443/log/logReport");
        xVar.a(str);
        new z().a(xVar, 5);
    }

    @Override // cn.fly.verify.s
    public void a(String str, String str2, String str3, e eVar) {
        super.a(str, str2, str3, eVar);
        SparseArray<String> sparseArray = new SparseArray<>();
        this.i = sparseArray;
        sparseArray.put(200010, "no sim");
        this.i.put(102101, "no network");
        this.i.put(102103, "no mobile data");
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, Network network, Object obj, cn.fly.verify.common.callback.b bVar, e eVar) {
        if (obj != null && (obj instanceof VerifyException)) {
            if (bVar != null) {
                bVar.a((VerifyException) obj);
                return;
            }
            return;
        }
        try {
            final x xVar = new x(this.b, this.c);
            z zVar = new z();
            xVar.b("POST");
            xVar.f("quick_login_android_5.9.6");
            xVar.a(network);
            xVar.c("https://rcs.cmpassport.com/unisdk/rs/scripAndTokenForHttps");
            if (!z) {
                xVar.d(this.j);
                if (eVar != null) {
                    eVar.a(eVar.b("cm_tokenRequest_start"));
                }
            }
            HashMap<String, Object> mapA = zVar.a(xVar, z ? 0 : 1);
            if (!z && eVar != null) {
                eVar.a(eVar.b("cm_tokenRequest"));
            }
            if (mapA == null) {
                if (bVar != null) {
                    bVar.a(new VerifyException(200025, "result null"));
                }
            } else if (mapA.containsKey("error")) {
                if (bVar != null) {
                    bVar.a(new VerifyException(mapA.containsKey("code") ? ((Integer) mapA.get("code")).intValue() : 200025, (String) mapA.get("error")));
                }
            } else {
                if (bVar != null) {
                    bVar.a(mapA);
                }
                (z ? new ar() { // from class: cn.fly.verify.t.1
                    @Override // cn.fly.verify.ar
                    public void a() {
                        t.this.c(xVar.a());
                    }
                } : new ar() { // from class: cn.fly.verify.t.2
                    @Override // cn.fly.verify.ar
                    public void a() {
                        t.this.b(xVar.a());
                    }
                }).b();
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(new VerifyException(200025, as.a(th)));
            }
        }
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, final cn.fly.verify.common.callback.b bVar) {
        if (z) {
            super.a(true, bVar);
            return;
        }
        this.h = as.b(this.d);
        HashMap<String, Object> mapA = a();
        if (mapA == null) {
            if (this.k) {
                if (bVar != null) {
                    bVar.a(new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR));
                    return;
                }
                return;
            } else {
                e eVar = this.g;
                if (eVar != null) {
                    eVar.a(eVar.b("no_upc"));
                }
                b(true, new cn.fly.verify.common.callback.b() { // from class: cn.fly.verify.t.3
                    @Override // cn.fly.verify.common.callback.b
                    public void a(VerifyException verifyException) {
                        cn.fly.verify.common.callback.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(verifyException);
                        }
                    }

                    @Override // cn.fly.verify.common.callback.b
                    public void a(Object obj) {
                        if (obj != null) {
                            t.this.k = true;
                            t.this.b(bVar);
                        } else {
                            cn.fly.verify.common.callback.b bVar2 = bVar;
                            if (bVar2 != null) {
                                bVar2.a(new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "result null"));
                            }
                        }
                    }
                });
                return;
            }
        }
        String str = mapA.containsKey("phone") ? (String) mapA.get("phone") : null;
        long jLongValue = mapA.containsKey("expired") ? ((Long) mapA.get("expired")).longValue() : 0L;
        e eVar2 = this.g;
        if (eVar2 != null) {
            eVar2.c(str);
            e eVar3 = this.g;
            eVar3.a(eVar3.b("upc"));
        }
        ai.a().b(2);
        ai.a().a(jLongValue);
        this.j = mapA.containsKey("optoken") ? (String) mapA.get("optoken") : null;
        b(false, bVar);
    }

    @Override // cn.fly.verify.s
    public boolean a(VerifyException verifyException, cn.fly.verify.common.callback.b bVar) {
        return true;
    }
}
