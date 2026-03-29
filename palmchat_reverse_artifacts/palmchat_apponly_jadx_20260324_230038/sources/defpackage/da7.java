package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.apm.lite.CrashType;
import defpackage.y37;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class da7 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile da7 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17008a;
    public Map<CrashType, y37> b = new HashMap();
    public nz6 c;
    public b87 d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17009a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f17009a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17009a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17009a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17009a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17009a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17009a[CrashType.ENSURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public da7(Context context) {
        this.f17008a = context;
        try {
            this.c = nz6.y();
            this.d = new b87(this.f17008a);
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
        }
    }

    public static da7 d() {
        if (e == null) {
            Context contextM = x97.m();
            if (contextM == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            e = new da7(contextM);
        }
        return e;
    }

    public ev6 a(CrashType crashType, ev6 ev6Var) {
        y37 y37VarC;
        return (crashType == null || (y37VarC = c(crashType)) == null) ? ev6Var : y37VarC.c(ev6Var, null, false);
    }

    public ev6 b(CrashType crashType, ev6 ev6Var, y37.a aVar, boolean z) {
        y37 y37VarC;
        return (crashType == null || (y37VarC = c(crashType)) == null) ? ev6Var : y37VarC.c(ev6Var, aVar, z);
    }

    public final y37 c(CrashType crashType) {
        y37 ge7Var = this.b.get(crashType);
        if (ge7Var != null) {
            return ge7Var;
        }
        switch (a.f17009a[crashType.ordinal()]) {
            case 1:
                ge7Var = new ge7(this.f17008a, this.c, this.d);
                break;
            case 2:
                ge7Var = new se7(this.f17008a, this.c, this.d);
                break;
            case 3:
                ge7Var = new if7(this.f17008a, this.c, this.d);
                break;
            case 4:
                ge7Var = new ov6(this.f17008a, this.c, this.d);
                break;
            case 5:
                ge7Var = new xb7(this.f17008a, this.c, this.d);
                break;
            case 6:
                ge7Var = new od7(this.f17008a, this.c, this.d);
                break;
        }
        if (ge7Var != null) {
            this.b.put(crashType, ge7Var);
        }
        return ge7Var;
    }
}
