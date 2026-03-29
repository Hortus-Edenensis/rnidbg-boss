package cn.fly.verify;

import android.os.SystemClock;
import cn.fly.verify.common.exception.VerifyErr;
import cn.fly.verify.common.exception.VerifyException;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private g b;
    private boolean d;
    private Integer e;
    private String f;
    private Integer g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2211a = 0;
    private String c = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: cn.fly.verify.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2212a;

        static {
            int[] iArr = new int[g.values().length];
            f2212a = iArr;
            try {
                iArr[g.PREVERIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2212a[g.VERIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2212a[g.INIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2212a[g.AUTHPAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e(g gVar) {
        this.b = gVar;
        if (gVar == g.INIT) {
            ai.a().b(this.c);
        } else if (gVar == g.PREVERIFY) {
            ai.a().a(this.c);
        }
    }

    private VerifyErr d(String str) {
        return "CMCC".equals(str) ? "preVerify".equals(g()) ? VerifyErr.C_ONE_KEY_OBTAIN_CM_OPERATOR_ACCESS_CODE_ERR : VerifyErr.C_ONE_KEY_OBTAIN_CM_OPERATOR_ACCESS_TOKEN_ERR : "CTCC".equals(str) ? "preVerify".equals(g()) ? VerifyErr.C_ONE_KEY_OBTAIN_CT_OPERATOR_ACCESS_CODE_ERR : VerifyErr.C_ONE_KEY_OBTAIN_CT_OPERATOR_ACCESS_TOKEN_ERR : "CUCC".equals(str) ? "preVerify".equals(g()) ? VerifyErr.C_ONE_KEY_OBTAIN_CU_OPERATOR_ACCESS_CODE_ERR : VerifyErr.C_ONE_KEY_OBTAIN_CU_OPERATOR_ACCESS_TOKEN_ERR : "CUXW".equals(str) ? "preVerify".equals(g()) ? VerifyErr.C_ONE_KEY_OBTAIN_XW_OPERATOR_ACCESS_CODE_ERR : VerifyErr.C_ONE_KEY_OBTAIN_XW_OPERATOR_ACCESS_TOKEN_ERR : VerifyErr.C_PREVERIFY_CATCH;
    }

    private String g() {
        int i = AnonymousClass1.f2212a[this.b.ordinal()];
        if (i == 1) {
            return "preVerify";
        }
        if (i == 2) {
            return "verify";
        }
        if (i == 3) {
            return "init";
        }
        if (i != 4) {
            return null;
        }
        return "authPageOpend";
    }

    public c a(String str, int i, String str2, int i2, String str3) {
        c cVarB = b(str);
        cVarB.b(true);
        cVarB.a(i);
        cVarB.c(str2);
        cVarB.b(i2);
        cVarB.d(str3);
        return cVarB;
    }

    public c b(String str) {
        long j = this.f2211a;
        long j2 = 0;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (j == 0) {
            this.f2211a = jUptimeMillis;
        } else {
            j2 = jUptimeMillis - this.f2211a;
        }
        c cVar = new c(this.b, str);
        cVar.a(this.c);
        cVar.c(j2);
        cVar.b(j2);
        cVar.a(System.currentTimeMillis());
        Integer num = this.e;
        if (num != null) {
            cVar.a(num);
        }
        String str2 = this.f;
        if (str2 != null) {
            cVar.g(str2);
        }
        Integer num2 = this.g;
        if (num2 != null) {
            cVar.b(num2);
        }
        return cVar;
    }

    public void c() {
        d.b();
    }

    public String e() {
        return this.f;
    }

    public Integer f() {
        return this.g;
    }

    private void c(c cVar) {
        d.b(cVar);
    }

    public c a(String str, String str2, int i, String str3) {
        c cVarB = b(g());
        cVarB.e(str2);
        cVarB.f(str);
        cVarB.b(true);
        VerifyErr verifyErrD = d(str);
        if (verifyErrD != null) {
            cVarB.a(verifyErrD.getCode());
            cVarB.c(verifyErrD.getMessage());
        }
        cVarB.b(i);
        cVarB.d(str3);
        return cVarB;
    }

    public c b(String str, String str2) {
        c cVarB = b(g());
        cVarB.e(str2);
        cVarB.f(str);
        cVarB.a(200);
        cVarB.c("success");
        return cVarB;
    }

    public boolean d() {
        return this.d;
    }

    public VerifyErr a(String str, String str2, VerifyException verifyException) {
        a(a(str, str2, verifyException.getCode(), verifyException.getMessage()));
        c();
        return d(str);
    }

    public String b() {
        int i = AnonymousClass1.f2212a[this.b.ordinal()];
        String strB = null;
        String str = i != 1 ? i != 2 ? null : "verify" : "preVerify";
        if ("preVerify".equals(str)) {
            strB = ai.a().c();
        } else if ("verify".equals(str)) {
            strB = ai.a().b();
        }
        if (strB == null || strB.equals(this.c)) {
            return this.c;
        }
        return this.c + "," + strB;
    }

    public void c(String str) {
        this.f = str;
    }

    public String a() {
        return this.c;
    }

    public void b(c cVar) {
        d.b(cVar);
        d.b();
    }

    public void a(c cVar) {
        if (cVar != null) {
            c(cVar);
        }
    }

    public void b(Integer num) {
        this.g = num;
    }

    public void a(VerifyException verifyException, VerifyException verifyException2) {
        a(a(g(), verifyException.getCode(), verifyException.getMessage(), verifyException2.getCode(), verifyException2.getMessage()));
        c();
    }

    @Deprecated
    public void a(VerifyException verifyException, VerifyException verifyException2, String str) {
        c cVarA = a(g(), verifyException.getCode(), verifyException.getMessage(), verifyException2.getCode(), verifyException2.getMessage());
        cVarA.f(str);
        a(cVarA);
        c();
    }

    public void a(Integer num) {
        this.e = num;
    }

    public void a(String str) {
        c cVarB = b(g());
        cVarB.a(200);
        cVarB.c(str);
        a(cVarB);
        c();
    }

    public void a(String str, String str2) {
        a(b(str, str2));
        c();
    }

    public void a(String str, String str2, String str3) {
        c cVarB = b(str3);
        cVarB.a(200);
        cVarB.c("success");
        cVarB.f(str);
        cVarB.e(str2);
        cVarB.b(this.d ? 300 : 200);
        a(cVarB);
    }

    public void a(String str, String str2, String str3, String str4) {
        c cVarB = b(str3);
        cVarB.a(200);
        cVarB.c("success");
        cVarB.f(str);
        cVarB.e(str2);
        cVarB.c(str4);
        cVarB.b(this.d ? 300 : 200);
        a(cVarB);
    }

    public void a(boolean z) {
        this.d = z;
    }
}
