package cn.fly.verify.common.callback;

import cn.fly.verify.aq;
import cn.fly.verify.ar;
import cn.fly.verify.au;
import cn.fly.verify.ax;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.e;
import cn.fly.verify.k;
import cn.fly.verify.pure.entity.PreVerifyResult;
import cn.fly.verify.s;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2161a;
    private int b;
    private final OperationCallback<PreVerifyResult> c;

    public a(OperationCallback<PreVerifyResult> operationCallback, s... sVarArr) {
        int i = 0;
        for (s sVar : sVarArr) {
            if (sVar != null) {
                i++;
            }
        }
        this.b = i;
        this.c = operationCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final OperationCallback<PreVerifyResult> operationCallback, String str2, final PreVerifyResult preVerifyResult, final VerifyException verifyException, e eVar) {
        k.a().a(str, str2, eVar, new b<cn.fly.verify.a>() { // from class: cn.fly.verify.common.callback.a.3
            @Override // cn.fly.verify.common.callback.b
            public void a(cn.fly.verify.a aVar) {
                long jCurrentTimeMillis = System.currentTimeMillis() + 3600000;
                String str3 = aVar.b;
                String str4 = str;
                PreVerifyResult preVerifyResult2 = new PreVerifyResult(str3, str4, jCurrentTimeMillis, str4);
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 != null) {
                    operationCallback2.onComplete(preVerifyResult2);
                }
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(VerifyException verifyException2) {
                PreVerifyResult preVerifyResult2 = preVerifyResult;
                if (preVerifyResult2 != null) {
                    OperationCallback operationCallback2 = operationCallback;
                    if (operationCallback2 != null) {
                        operationCallback2.onComplete(preVerifyResult2);
                        return;
                    }
                    return;
                }
                VerifyException verifyException3 = verifyException;
                if (verifyException3 != null) {
                    verifyException2 = verifyException3;
                }
                OperationCallback operationCallback3 = operationCallback;
                if (operationCallback3 != null) {
                    operationCallback3.onFailure(verifyException2);
                }
            }
        });
    }

    public void a(final String str, final VerifyException verifyException, boolean z, final e eVar) {
        if (this.f2161a) {
            au.a(ax.g()).a();
            return;
        }
        if (this.b == 1) {
            this.c.onFailure(verifyException);
            au.a(ax.g()).a();
            int iK = aq.k();
            if (z && (iK == 3 || iK == 6 || iK == 4 || iK == 7)) {
                Executors.newSingleThreadExecutor().execute(new ar() { // from class: cn.fly.verify.common.callback.a.2
                    @Override // cn.fly.verify.ar
                    public void a() {
                        a.this.a(str, null, null, null, verifyException, eVar);
                    }
                });
            }
        }
        this.b--;
    }

    public boolean a(final String str, final PreVerifyResult preVerifyResult, boolean z, final e eVar) {
        if (this.f2161a) {
            au.a(ax.g()).a();
            return false;
        }
        this.f2161a = true;
        this.c.onComplete(preVerifyResult);
        au.a(ax.g()).a();
        int iK = aq.k();
        if (z && (iK == 2 || iK == 4 || iK == 7)) {
            Executors.newSingleThreadExecutor().execute(new ar() { // from class: cn.fly.verify.common.callback.a.1
                @Override // cn.fly.verify.ar
                public void a() {
                    a.this.a(str, null, preVerifyResult.getSecurityPhone(), preVerifyResult, null, eVar);
                }
            });
        }
        return true;
    }
}
