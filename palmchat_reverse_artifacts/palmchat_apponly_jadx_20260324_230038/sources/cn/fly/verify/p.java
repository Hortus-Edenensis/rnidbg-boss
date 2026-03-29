package cn.fly.verify;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.fly.verify.common.callback.OperationCallback;
import cn.fly.verify.common.exception.VerifyErr;
import cn.fly.verify.common.exception.VerifyException;
import cn.fly.verify.fq;
import cn.fly.verify.pure.entity.PreVerifyResult;
import cn.fly.verify.pure.entity.VerifyResult;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private static volatile p b;
    private long c;
    private PreVerifyResult e;
    private int f;
    private String g;
    private at h;
    private at i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<a> f2410a = new AtomicReference<>();
    private long d = 5000;

    private p() {
        new be().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        boolean zA = as.a(ax.g());
        return (zA ? 10 : 0) + (as.d() > -1 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(String str) {
        if ("CMCC".equals(str)) {
            return 1;
        }
        if ("CUXW".equals(str)) {
            return 3;
        }
        if ("CUCC".equals(str)) {
            return 2;
        }
        return "CTCC".equals(str) ? 4 : 5;
    }

    public static int a(String str) {
        int iA = as.a(str);
        if (iA == 1) {
            return 1;
        }
        return iA == 2 ? m.b() ? 3 : 2 : iA == 3 ? 4 : 5;
    }

    public at a(boolean z) {
        if (z) {
            if (this.h == null) {
                this.h = new at("preVerify");
            }
            return this.h;
        }
        if (this.i == null) {
            this.i = new at("verify");
        }
        return this.i;
    }

    public static p a() {
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    b = new p();
                }
            }
        }
        return b;
    }

    public void b(final OperationCallback<VerifyResult> operationCallback) {
        f.a().b("[FlyVerify] ==>%s", "start verify");
        new ar() { // from class: cn.fly.verify.p.4
            @Override // cn.fly.verify.ar
            public void a() {
                e eVar = new e(g.VERIFY);
                try {
                    if (ax.h()) {
                        p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, new VerifyException(VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR));
                        return;
                    }
                    eVar.a((String) null, (String) null, "start");
                    if (fq.d.b()) {
                        p.this.a(true).b();
                        p.this.a(false).a();
                        p.this.a(eVar, operationCallback);
                    } else {
                        f.a().a("not main process");
                        VerifyException verifyException = new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "not main process");
                        VerifyException verifyException2 = new VerifyException(VerifyErr.C_VERIFY_CATCH);
                        eVar.a(verifyException2, verifyException);
                        verifyException2.setSerialId(eVar.b());
                        p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException2);
                    }
                } catch (Throwable th) {
                    String strA = as.a(th);
                    VerifyErr verifyErr = VerifyErr.C_VERIFY_CATCH;
                    VerifyException verifyException3 = new VerifyException(verifyErr.getCode(), strA);
                    VerifyException verifyException4 = new VerifyException(verifyErr);
                    eVar.a(verifyException4, verifyException3);
                    verifyException4.setSerialId(eVar.b());
                    p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException4);
                }
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                p.this.a(false).a(new VerifyException(VerifyErr.C_VERIFY_CATCH.getCode(), as.a(th)));
            }
        }.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(e eVar, OperationCallback operationCallback, boolean z) {
        PreVerifyResult preVerifyResult;
        VerifyException verifyException;
        Object objA = a(z).a();
        if (objA == null) {
            return false;
        }
        e eVarC = a(z).c();
        if (eVarC != null) {
            eVar.c(eVarC.e());
            eVar.a(eVarC.d());
            eVar.b(eVarC.f());
        }
        VerifyResult verifyResult = null;
        if (objA instanceof VerifyException) {
            verifyException = new VerifyException(eVar.a(as.b(), this.g, (VerifyException) objA));
            preVerifyResult = null;
        } else if (objA instanceof PreVerifyResult) {
            preVerifyResult = (PreVerifyResult) objA;
            eVar.a(preVerifyResult.getOperator(), this.g);
            verifyException = null;
        } else if (objA instanceof VerifyResult) {
            VerifyResult verifyResult2 = (VerifyResult) objA;
            eVar.a(verifyResult2.getOperator(), this.g);
            verifyException = null;
            verifyResult = verifyResult2;
            preVerifyResult = null;
        } else {
            preVerifyResult = null;
            verifyException = null;
        }
        if (z) {
            a((OperationCallback<PreVerifyResult>) operationCallback, preVerifyResult, verifyException);
            return true;
        }
        a((OperationCallback<VerifyResult>) operationCallback, verifyResult, verifyException);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(s sVar, e eVar, OperationCallback<VerifyResult> operationCallback, String str) throws VerifyException {
        a aVar = a().f2410a.get();
        if (aVar == null || !a(aVar, sVar)) {
            return false;
        }
        if (eVar != null) {
            eVar.a(sVar.f2433a, sVar.b, "usc", String.valueOf(aVar.d));
        }
        f.a().b("[FlyVerify] ==>%s", "use server cache");
        ai.a().b(1);
        ai.a().a(aVar.d);
        VerifyResult verifyResult = new VerifyResult(aVar.b, aVar.f2058a, sVar.b());
        String[] strArrA = C1319r.a().a(verifyResult.getOpToken(), verifyResult.getOperator(), sVar, str);
        c cVarB = eVar.b(sVar.f2433a, this.g);
        cVarB.d(strArrA[1]);
        eVar.b(cVarB);
        verifyResult.setToken(strArrA[0]);
        a(operationCallback, verifyResult, (VerifyException) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, PreVerifyResult preVerifyResult, final e eVar) {
        l lVar;
        au.a(ax.g()).a();
        if (eVar.d()) {
            return;
        }
        final SparseArray<l> sparseArrayA = l.a();
        SparseArray<l> sparseArrayC = l.c();
        this.f = i;
        if (preVerifyResult != null) {
            try {
                if ("CUXW".equals(preVerifyResult.getChannel())) {
                    this.f = 3;
                }
            } catch (Throwable th) {
                as.a(th);
                c cVarB = eVar.b("pre_2_f");
                cVarB.e(sparseArrayC.get(this.f).b);
                cVarB.f(as.a(this.f));
                eVar.a(cVarB);
                eVar.c();
                return;
            }
        }
        if (sparseArrayA != null && (lVar = sparseArrayA.get(this.f)) != null) {
            String str = lVar.b;
            String str2 = lVar.c;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !sparseArrayC.get(this.f).b.equals(str)) {
                final s sVarA = as.a(null, this.f, str, str2, lVar.d(), lVar.e(), lVar.f(), eVar);
                l.a(sparseArrayA);
                a(new OperationCallback<PreVerifyResult>() { // from class: cn.fly.verify.p.8
                    @Override // cn.fly.verify.common.callback.OperationCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onComplete(PreVerifyResult preVerifyResult2) {
                        p.this.e = preVerifyResult2;
                        c cVarB2 = eVar.b("pre_2_s");
                        cVarB2.e(((l) sparseArrayA.get(p.this.f)).b);
                        cVarB2.f(preVerifyResult2.getChannel());
                        eVar.a(cVarB2);
                        eVar.c();
                        au.a(ax.g()).a();
                    }

                    @Override // cn.fly.verify.common.callback.OperationCallback
                    public void onFailure(VerifyException verifyException) {
                        c cVarB2 = eVar.b("pre_2_f");
                        cVarB2.e(((l) sparseArrayA.get(p.this.f)).b);
                        cVarB2.f(sVarA.f2433a);
                        eVar.a(cVarB2);
                        eVar.c();
                        au.a(ax.g()).a();
                    }
                }, false, sVarA);
                return;
            }
        }
        c cVarB2 = eVar.b("pre_2_no");
        cVarB2.e(sparseArrayC.get(this.f).b);
        cVarB2.f(as.a(this.f));
        eVar.a(cVarB2);
        eVar.c();
    }

    public void a(OperationCallback<PreVerifyResult> operationCallback) {
        a(operationCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OperationCallback<PreVerifyResult> operationCallback, final PreVerifyResult preVerifyResult, final VerifyException verifyException) {
        f fVarA;
        String str;
        au.a(ax.g()).a();
        if (operationCallback == null) {
            at atVarA = a(true);
            Object obj = preVerifyResult;
            if (preVerifyResult == null) {
                obj = verifyException;
            }
            atVarA.a(obj);
            return;
        }
        if (operationCallback.isCanceled()) {
            fVarA = f.a();
            str = "get result , but already timeout";
        } else {
            operationCallback.setCanceled(true);
            gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.p.7
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    PreVerifyResult preVerifyResult2 = preVerifyResult;
                    if (preVerifyResult2 != null) {
                        operationCallback.onComplete(preVerifyResult2);
                        return false;
                    }
                    operationCallback.onFailure(verifyException);
                    return false;
                }
            });
            at atVarA2 = a(true);
            Object obj2 = preVerifyResult;
            if (preVerifyResult == null) {
                obj2 = verifyException;
            }
            atVarA2.a(obj2);
            fVarA = f.a();
            str = "get result , cancel timeout";
        }
        fVarA.b("[FlyVerify] ==>%s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OperationCallback<VerifyResult> operationCallback, final VerifyResult verifyResult, final VerifyException verifyException) {
        f fVarA;
        String str;
        au.a(ax.g()).a();
        if (operationCallback == null) {
            at atVarA = a(false);
            Object obj = verifyResult;
            if (verifyResult == null) {
                obj = verifyException;
            }
            atVarA.a(obj);
            return;
        }
        if (operationCallback.isCanceled()) {
            fVarA = f.a();
            str = "get result , but already timeout";
        } else {
            operationCallback.setCanceled(true);
            this.f2410a.set(null);
            gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.p.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    VerifyResult verifyResult2 = verifyResult;
                    if (verifyResult2 != null) {
                        operationCallback.onComplete(verifyResult2);
                        return false;
                    }
                    operationCallback.onFailure(verifyException);
                    return false;
                }
            });
            at atVarA2 = a(false);
            Object obj2 = verifyResult;
            if (verifyResult == null) {
                obj2 = verifyException;
            }
            atVarA2.a(obj2);
            fVarA = f.a();
            str = "get result , cancel timeout";
        }
        fVarA.b("[FlyVerify] ==>%s", str);
    }

    public void a(OperationCallback<PreVerifyResult> operationCallback, boolean z) {
        a(operationCallback, z, false);
    }

    public void a(final OperationCallback<PreVerifyResult> operationCallback, final boolean z, final boolean z2) {
        f.a().b("[FlyVerify] ==>%s", "start preVerify");
        this.c = System.currentTimeMillis();
        new ar() { // from class: cn.fly.verify.p.1
            @Override // cn.fly.verify.ar
            public void a() {
                e eVar = new e(g.PREVERIFY);
                try {
                    if (ax.h()) {
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, new VerifyException(VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR));
                        return;
                    }
                    eVar.a(Integer.valueOf(z2 ? 1 : 0));
                    eVar.a((String) null, (String) null, "start");
                    if (fq.d.b()) {
                        if (p.this.b(eVar, operationCallback, true)) {
                            return;
                        }
                        p.this.a(eVar, operationCallback, z);
                    } else {
                        f.a().a("not main process");
                        VerifyException verifyException = new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "not main process");
                        VerifyException verifyException2 = new VerifyException(VerifyErr.C_PREVERIFY_CATCH);
                        eVar.a(verifyException2, verifyException);
                        verifyException2.setSerialId(eVar.b());
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException2);
                    }
                } catch (Throwable th) {
                    f.a().a(th);
                    VerifyErr verifyErr = VerifyErr.C_PREVERIFY_CATCH;
                    VerifyException verifyException3 = new VerifyException(verifyErr.getCode(), as.a(th));
                    VerifyException verifyException4 = new VerifyException(verifyErr);
                    eVar.a(verifyException4, verifyException3);
                    verifyException4.setSerialId(eVar.b());
                    p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException4);
                }
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                p.this.a(true).a(new VerifyException(VerifyErr.C_PREVERIFY_CATCH.getCode(), as.a(th)));
            }
        }.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OperationCallback<PreVerifyResult> operationCallback, boolean z, s... sVarArr) {
        o.a().a(operationCallback, z, sVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        String securityPhone;
        String operator;
        try {
            if (8 == aq.k()) {
                PreVerifyResult preVerifyResult = this.e;
                if (preVerifyResult != null) {
                    securityPhone = preVerifyResult.getSecurityPhone();
                    operator = this.e.getOperator();
                } else {
                    securityPhone = null;
                    operator = null;
                }
                f.a().b("[FlyVerify] ==>%s", "request cache before verify");
                k.a().a(operator, securityPhone, eVar, null);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(final e eVar, final OperationCallback<VerifyResult> operationCallback) {
        al.a(new ar() { // from class: cn.fly.verify.p.5
            /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x015e  */
            @Override // cn.fly.verify.ar
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a() {
                l lVar;
                l lVar2;
                final l lVar3;
                SparseArray<l> sparseArrayA;
                l lVar4;
                VerifyException verifyException;
                e eVar2;
                VerifyException verifyException2;
                p.this.a(eVar);
                int iA = p.a(as.a(true));
                if (iA == 5 && ai.a().k().booleanValue() && p.this.e != null) {
                    iA = p.c(p.this.e.getChannel());
                }
                if (iA == 5) {
                    verifyException = new VerifyException(VerifyErr.C_UNSUPPORTED_OPERATOR);
                    verifyException.setExtraDesc("unknown operator");
                    eVar2 = eVar;
                    verifyException2 = new VerifyException(VerifyErr.INNER_UNKNOWN_OPERATOR);
                } else {
                    if (iA == 2 && p.this.e != null && "CUXW".equals(p.this.e.getChannel())) {
                        iA = 3;
                    }
                    p.this.a(eVar, operationCallback, iA, false);
                    eVar.a(as.a(iA), (String) null, "get_cc");
                    SparseArray<l> sparseArrayA2 = l.a();
                    SparseArray<l> sparseArrayC = l.c();
                    boolean z = (sparseArrayA2 == null || sparseArrayC == null || sparseArrayA2.get(iA) == null || sparseArrayC.get(iA) == null || sparseArrayA2.get(iA).b == null || sparseArrayA2.get(iA).b.equals(sparseArrayC.get(iA).b)) ? false : true;
                    if (z) {
                        lVar4 = sparseArrayA2.get(iA);
                    } else {
                        if (sparseArrayC != null) {
                            lVar2 = sparseArrayC.get(iA);
                        } else if (sparseArrayA2 != null) {
                            lVar2 = sparseArrayA2.get(iA);
                        } else {
                            lVar = null;
                            if (lVar == null) {
                                SparseArray<l> sparseArrayA3 = m.a();
                                if (sparseArrayA3 != null) {
                                    ai.a().a(0);
                                    eVar.a((String) null, (String) null, "use_ca");
                                    f.a().b("[FlyVerify] ==>%s", "use cache config");
                                    lVar = sparseArrayA3.get(iA);
                                }
                                if (lVar == null && (sparseArrayA = n.a(2000L, 4000L, eVar)) != null) {
                                    ai.a().a(2);
                                    f.a().b("[FlyVerify] ==>%s", "use server config");
                                    lVar4 = sparseArrayA.get(iA);
                                }
                            }
                            lVar3 = lVar;
                            if (lVar3 != null) {
                                eVar.b(Integer.valueOf(lVar3.d()));
                                final s sVarA = as.a(null, iA, lVar3.b, lVar3.c, lVar3.d(), lVar3.e(), lVar3.f(), eVar);
                                eVar.a(as.a(iA), lVar3.b, "get_ci");
                                if (!z || p.this.f2410a.get() != null) {
                                    p.this.a(sVarA, (OperationCallback<VerifyResult>) operationCallback, eVar, lVar3.b);
                                    return;
                                }
                                f.a().a("[FlyVerify] ==>%s", "pre3：" + lVar3.b);
                                p.this.a(new OperationCallback<PreVerifyResult>() { // from class: cn.fly.verify.p.5.1
                                    @Override // cn.fly.verify.common.callback.OperationCallback
                                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                    public void onComplete(PreVerifyResult preVerifyResult) {
                                        p.this.e = preVerifyResult;
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        p.this.a(sVarA, (OperationCallback<VerifyResult>) operationCallback, eVar, lVar3.b);
                                    }

                                    @Override // cn.fly.verify.common.callback.OperationCallback
                                    public void onFailure(VerifyException verifyException3) {
                                        eVar.a(sVarA.f2433a, lVar3.b, verifyException3);
                                        verifyException3.setSerialId(eVar.b());
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException3);
                                    }
                                }, true, sVarA);
                                return;
                            }
                            verifyException = new VerifyException(VerifyErr.C_UNSUPPORTED_OPERATOR);
                            verifyException.setExtraDesc("no operator config");
                            eVar2 = eVar;
                            verifyException2 = new VerifyException(VerifyErr.INNER_NO_OPERATOR_CONFIG);
                        }
                        lVar = lVar2;
                        if (lVar == null) {
                        }
                        lVar3 = lVar;
                        if (lVar3 != null) {
                        }
                    }
                    lVar3 = lVar4;
                    if (lVar3 != null) {
                    }
                }
                eVar2.a(verifyException, verifyException2);
                verifyException.setSerialId(eVar.b());
                p.this.a(false).a(eVar);
                p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException);
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                String strA = as.a(th);
                VerifyErr verifyErr = VerifyErr.C_VERIFY_CATCH;
                VerifyException verifyException = new VerifyException(verifyErr.getCode(), strA);
                VerifyException verifyException2 = new VerifyException(verifyErr);
                eVar.a(verifyException2, verifyException);
                p.this.a(false).a(eVar);
                verifyException2.setExtraDesc(eVar.b());
                verifyException2.setSerialId(eVar.b());
                p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException2);
            }
        }, true, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final e eVar, final OperationCallback operationCallback, final int i, final boolean z) {
        long jLongValue = this.d;
        Long l = ak.f2068a;
        if (l != null && z) {
            jLongValue = l.longValue();
            if (jLongValue < 2000) {
                jLongValue = this.d;
            }
            if (eVar != null) {
                eVar.a(as.a(i), (String) null, WkAdConfigModel.TAG_TIMEOUT, String.valueOf(l));
            }
        } else if (i == 4) {
            jLongValue *= 2;
        }
        final long j = jLongValue;
        final int iT = ai.a().t();
        f.a().a("isOperatorCode:" + iT);
        new ar() { // from class: cn.fly.verify.p.2
            @Override // cn.fly.verify.ar
            public void a() {
                final VerifyException verifyException;
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
                OperationCallback operationCallback2 = operationCallback;
                if (operationCallback2 == null || operationCallback2.isCanceled()) {
                    return;
                }
                try {
                    operationCallback.setCanceled(true);
                    f.a().b("[FlyVerify] ==>%s", "handleTimeout");
                    VerifyErr verifyErr = VerifyErr.INNER_TIMEOUT_ERR;
                    int code = verifyErr.getCode();
                    if (z && iT == 1) {
                        int i2 = i;
                        if (i2 == 1) {
                            code = 200023;
                        } else if (i2 == 2 || i2 == 3) {
                            code = 101005;
                        } else if (i2 == 4) {
                            code = 80000;
                        }
                    }
                    VerifyException verifyException2 = new VerifyException(code, verifyErr.getMessage());
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        VerifyErr verifyErrA = eVar2.a(as.a(i), (String) null, verifyException2);
                        eVar.a(true);
                        verifyException = new VerifyException(verifyErrA);
                        verifyException.setSerialId(eVar.b());
                    } else {
                        verifyException = new VerifyException(VerifyErr.C_PREVERIFY_TIMEOUT);
                    }
                    if (z && iT == 1 && code != verifyErr.getCode()) {
                        verifyException.setOperatorCode(code + "");
                    }
                    au.a(ax.g()).a();
                    gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.p.2.1
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            operationCallback.onFailure(verifyException);
                            return false;
                        }
                    });
                } catch (Throwable unused2) {
                    verifyException = new VerifyException(VerifyErr.C_PREVERIFY_CATCH);
                    gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.p.2.2
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            operationCallback.onFailure(verifyException);
                            return false;
                        }
                    });
                }
                p.this.a(z).a(eVar);
                p.this.a(z).a(verifyException);
            }
        }.b();
    }

    public void a(final e eVar, final OperationCallback<PreVerifyResult> operationCallback, final boolean z) {
        al.a(new ar() { // from class: cn.fly.verify.p.3
            @Override // cn.fly.verify.ar
            public void a() {
                final SparseArray<l> sparseArray;
                boolean z2;
                s[] sVarArr;
                final boolean z3;
                p.this.e = null;
                final String strA = as.a(true);
                if ((as.a(strA) == 1 && ai.a().n() == 1) || (as.a(strA) == 2 && ai.a().o() == 1)) {
                    new aj().a();
                }
                SparseArray<l> sparseArrayA = l.a();
                if (sparseArrayA == null) {
                    sparseArrayA = m.a();
                    if (sparseArrayA != null) {
                        ai.a().a(0);
                        eVar.a((String) null, (String) null, "use_ca");
                        f.a().b("[FlyVerify] ==>%s", "use cache config");
                    }
                } else {
                    ai.a().a(2);
                    eVar.a((String) null, (String) null, "use_cdn");
                    f.a().b("[FlyVerify] ==>%s", "use server config");
                }
                if (sparseArrayA == null && z) {
                    SparseArray<l> sparseArrayA2 = n.a(2000L, 4000L, eVar);
                    if (sparseArrayA2 != null) {
                        ai.a().a(2);
                        f.a().b("[FlyVerify] ==>%s", "use server config");
                    }
                    sparseArray = sparseArrayA2;
                    z2 = true;
                } else {
                    sparseArray = sparseArrayA;
                    z2 = false;
                }
                if (sparseArray == null) {
                    VerifyException verifyException = new VerifyException(VerifyErr.C_CONFIG_ERROR);
                    verifyException.setExtraDesc(z2 ? "has retry" : "no retry");
                    eVar.a(verifyException, new VerifyException(z2 ? VerifyErr.INNER_NO_INIT_RETRY : VerifyErr.INNER_NO_INIT_NO_RETRY));
                    verifyException.setSerialId(eVar.b());
                    p.this.a(true).a(eVar);
                    p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException);
                    return;
                }
                final int iA = p.a(strA);
                String strD = al.d();
                if (iA != 5 && (TextUtils.isEmpty(strD) || "-1".equalsIgnoreCase(strD))) {
                    eVar.a(as.a(iA), (String) null, "dh_carrier_error");
                }
                l.a(sparseArray);
                p.this.a(eVar, operationCallback, iA, true);
                eVar.a(as.a(iA), (String) null, "get_cc", String.valueOf(p.this.b()));
                if (!ai.a().k().booleanValue() && iA == 5) {
                    f.a().c("[FlyVerify] ==>%s", "carrier unknown");
                    VerifyException verifyException2 = new VerifyException(VerifyErr.C_UNSUPPORTED_OPERATOR);
                    VerifyErr verifyErr = VerifyErr.INNER_UNKNOWN_OPERATOR;
                    verifyException2.setExtraDesc(verifyErr.getMessage());
                    VerifyException verifyException3 = new VerifyException(verifyErr);
                    verifyException3.setExtraDesc(strA);
                    eVar.a(verifyException2, verifyException3);
                    p.this.a(true).a(eVar);
                    verifyException2.setSerialId(eVar.b());
                    p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException2);
                    return;
                }
                if (iA == 5) {
                    int[] iArr = {1, 4, 2, 3};
                    sVarArr = new s[4];
                    for (int i = 0; i < 4; i++) {
                        l lVar = sparseArray.get(iArr[i]);
                        if (lVar != null) {
                            sVarArr[i] = as.a(null, iArr[i], lVar.b, lVar.c, lVar.d(), lVar.e(), lVar.f(), eVar).b(true);
                        }
                    }
                    eVar.a((String) null, (String) null, "unknown_try");
                    z3 = true;
                } else {
                    l lVar2 = sparseArray.get(iA);
                    if (lVar2 == null) {
                        f.a().c("[FlyVerify] ==>%s", "no operator config");
                        VerifyException verifyException4 = new VerifyException(VerifyErr.C_UNSUPPORTED_OPERATOR);
                        VerifyErr verifyErr2 = VerifyErr.INNER_NO_OPERATOR_CONFIG;
                        verifyException4.setExtraDesc(verifyErr2.getMessage());
                        eVar.a(verifyException4, new VerifyException(verifyErr2), as.a(iA));
                        p.this.a(true).a(eVar);
                        verifyException4.setSerialId(eVar.b());
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException4);
                        return;
                    }
                    if (TextUtils.isEmpty(lVar2.b) || TextUtils.isEmpty(lVar2.c)) {
                        f.a().c("[FlyVerify] ==>%s", "no appid");
                        VerifyException verifyException5 = new VerifyException(VerifyErr.C_APPID_NULL);
                        eVar.a(verifyException5, verifyException5, as.a(iA));
                        p.this.a(true).a(eVar);
                        verifyException5.setSerialId(eVar.b());
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException5);
                        return;
                    }
                    eVar.b(Integer.valueOf(lVar2.d()));
                    s[] sVarArr2 = {as.a(null, iA, lVar2.b, lVar2.c, lVar2.d(), lVar2.e(), lVar2.f(), eVar)};
                    p.this.g = lVar2.b;
                    f.a().b("[FlyVerify] ==>%s", "aid:" + lVar2.b + ", us: " + (System.currentTimeMillis() - p.this.c));
                    eVar.a(as.a(iA), lVar2.b, "get_ci");
                    sVarArr = sVarArr2;
                    z3 = false;
                }
                o.a().a(new OperationCallback<PreVerifyResult>() { // from class: cn.fly.verify.p.3.1
                    @Override // cn.fly.verify.common.callback.OperationCallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onComplete(PreVerifyResult preVerifyResult) {
                        p.this.e = preVerifyResult;
                        p.this.a(true).a(eVar);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, preVerifyResult, (VerifyException) null);
                        if (eVar.d()) {
                            eVar.a(preVerifyResult.getChannel(), p.this.g, "timeout_success");
                        } else if (!z3) {
                            eVar.a(preVerifyResult.getChannel(), p.this.g);
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            p.this.a(iA, preVerifyResult, eVar);
                        } else {
                            l lVar3 = (l) sparseArray.get(p.c(preVerifyResult.getChannel()));
                            c cVarB = eVar.b(preVerifyResult.getChannel(), lVar3 != null ? lVar3.b : null);
                            cVarB.b(201);
                            eVar.a(cVarB);
                        }
                        eVar.c();
                        AnonymousClass3 anonymousClass322 = AnonymousClass3.this;
                        p.this.a(iA, preVerifyResult, eVar);
                    }

                    @Override // cn.fly.verify.common.callback.OperationCallback
                    public void onFailure(VerifyException verifyException6) {
                        VerifyException verifyException7;
                        p.this.e = null;
                        if (eVar.d()) {
                            c cVarA = eVar.a(as.a(iA), p.this.g, verifyException6.getCode(), verifyException6.getMessage());
                            cVarA.b(false);
                            cVarA.b("timeout_error");
                            eVar.a(cVarA);
                            eVar.c();
                            return;
                        }
                        if (z3) {
                            verifyException7 = new VerifyException(VerifyErr.C_UNSUPPORTED_OPERATOR);
                            VerifyErr verifyErr3 = VerifyErr.INNER_UNKNOWN_OPERATOR_TRIED;
                            verifyException7.setExtraDesc(verifyErr3.getMessage());
                            VerifyException verifyException8 = new VerifyException(verifyErr3);
                            verifyException8.setExtraDesc(strA);
                            eVar.a(verifyException7, verifyException8);
                        } else {
                            VerifyException verifyException9 = new VerifyException(eVar.a(as.a(iA), p.this.g, verifyException6));
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            p.this.a(iA, (PreVerifyResult) null, eVar);
                            verifyException7 = verifyException9;
                        }
                        if (ai.a().t() == 1) {
                            verifyException7.setOperatorCode(verifyException6.getCode() + "");
                        }
                        p.this.a(true).a(eVar);
                        verifyException7.setSerialId(eVar.b());
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException7);
                    }
                }, true, sVarArr);
            }

            @Override // cn.fly.verify.ar
            public void a(Throwable th) {
                f.a().a(th);
                VerifyErr verifyErr = VerifyErr.C_PREVERIFY_CATCH;
                VerifyException verifyException = new VerifyException(verifyErr.getCode(), as.a(th));
                VerifyException verifyException2 = new VerifyException(verifyErr);
                eVar.a(verifyException2, verifyException);
                p.this.a(true).a(eVar);
                verifyException2.setSerialId(eVar.b());
                p.this.a((OperationCallback<PreVerifyResult>) operationCallback, (PreVerifyResult) null, verifyException2);
            }
        }, true, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, OperationCallback<VerifyResult> operationCallback, e eVar, String str) {
        a(sVar, eVar, operationCallback, str);
    }

    private void a(final s sVar, final e eVar, final OperationCallback<VerifyResult> operationCallback, final String str) {
        sVar.b(new cn.fly.verify.common.callback.b<VerifyResult>() { // from class: cn.fly.verify.p.9
            @Override // cn.fly.verify.common.callback.b
            public void a(final VerifyException verifyException) {
                as.a(new ar() { // from class: cn.fly.verify.p.9.2
                    @Override // cn.fly.verify.ar
                    public void a() {
                        try {
                            String str2 = "";
                            s sVar2 = sVar;
                            if (sVar2 != null && sVar2.a() != null && sVar.a().containsKey("optoken")) {
                                str2 = (String) sVar.a().get("optoken");
                            }
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            if (p.this.b(sVar, eVar, operationCallback, str2)) {
                                return;
                            }
                            AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                            VerifyException verifyException2 = new VerifyException(eVar.a(sVar.f2433a, str, verifyException));
                            p.this.a(false).a(eVar);
                            verifyException2.setSerialId(eVar.b());
                            AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                            p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException2);
                        } catch (VerifyException unused) {
                            AnonymousClass9 anonymousClass94 = AnonymousClass9.this;
                            VerifyException verifyException3 = new VerifyException(eVar.a(sVar.f2433a, str, verifyException));
                            p.this.a(false).a(eVar);
                            verifyException3.setSerialId(eVar.b());
                            AnonymousClass9 anonymousClass95 = AnonymousClass9.this;
                            p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException3);
                        }
                    }
                });
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(final VerifyResult verifyResult) {
                as.a(new ar() { // from class: cn.fly.verify.p.9.1
                    @Override // cn.fly.verify.ar
                    public void a() {
                        VerifyErr verifyErrA;
                        try {
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            if (p.this.b(sVar, eVar, operationCallback, verifyResult.getOpToken())) {
                                return;
                            }
                            String[] strArrA = C1319r.a().a(verifyResult.getOpToken(), verifyResult.getOperator(), sVar, verifyResult.getOpToken());
                            AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                            c cVarB = eVar.b(sVar.f2433a, str);
                            cVarB.d(strArrA[1]);
                            eVar.b(cVarB);
                            verifyResult.setToken(strArrA[0]);
                            p.this.a(false).a(eVar);
                            AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                            p.this.a((OperationCallback<VerifyResult>) operationCallback, verifyResult, (VerifyException) null);
                        } catch (Throwable th) {
                            if (th instanceof VerifyException) {
                                AnonymousClass9 anonymousClass94 = AnonymousClass9.this;
                                verifyErrA = eVar.a(sVar.f2433a, str, th);
                            } else {
                                AnonymousClass9 anonymousClass95 = AnonymousClass9.this;
                                verifyErrA = eVar.a(sVar.f2433a, str, new VerifyException(VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), as.a(th)));
                            }
                            VerifyException verifyException = new VerifyException(verifyErrA);
                            p.this.a(false).a(eVar);
                            verifyException.setSerialId(eVar.b());
                            AnonymousClass9 anonymousClass96 = AnonymousClass9.this;
                            p.this.a((OperationCallback<VerifyResult>) operationCallback, (VerifyResult) null, verifyException);
                        }
                    }
                });
            }
        });
    }

    private boolean a(a aVar, s sVar) {
        String str;
        boolean z = false;
        if (aVar != null && (str = aVar.e) != null && sVar != null && str.equals(sVar.b()) && aVar.f == as.d()) {
            z = true;
        }
        f.a().b("[FlyVerify] ==>%s", "cache and current ope is same " + z);
        return z;
    }
}
