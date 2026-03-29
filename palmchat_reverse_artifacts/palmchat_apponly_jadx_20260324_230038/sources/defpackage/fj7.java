package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.u.nr.fx;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fj7 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile fj7 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17537a;
    public Map<fx, bd7> b = new HashMap();
    public ui7 c;
    public b17 d;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17538a;

        static {
            int[] iArr = new int[fx.values().length];
            f17538a = iArr;
            try {
                iArr[fx.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17538a[fx.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17538a[fx.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public fj7(@NonNull Context context) {
        this.f17537a = context;
        this.c = new ui7(this.f17537a);
        this.d = new b17(this.f17537a);
    }

    public static fj7 b() {
        if (e != null) {
            return e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (e == null) {
            e = new fj7(context);
        }
    }

    @Nullable
    public final bd7 a(fx fxVar) {
        bd7 jm7Var = this.b.get(fxVar);
        if (jm7Var != null) {
            return jm7Var;
        }
        int i = a.f17538a[fxVar.ordinal()];
        if (i == 1) {
            jm7Var = new jm7(this.f17537a, this.c, this.d);
        } else if (i == 2) {
            jm7Var = new gl7(this.f17537a, this.c, this.d);
        } else if (i == 3) {
            jm7Var = new ze7(this.f17537a, this.c, this.d);
        }
        if (jm7Var != null) {
            this.b.put(fxVar, jm7Var);
        }
        return jm7Var;
    }

    public ql7 c(fx fxVar, ql7 ql7Var) {
        bd7 bd7VarA;
        return (fxVar == null || (bd7VarA = a(fxVar)) == null) ? ql7Var : bd7VarA.f(ql7Var);
    }
}
