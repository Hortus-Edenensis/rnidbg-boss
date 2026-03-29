package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class m03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19114a = false;
    public static boolean b = false;
    public static String[] c;
    public static long[] d;
    public static int e;
    public static int f;
    public static b93 g;
    public static a93 h;
    public static volatile sw3 i;
    public static volatile qw3 j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a93 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19115a;

        public a(Context context) {
            this.f19115a = context;
        }

        @Override // defpackage.a93
        @NonNull
        public File getCacheDir() {
            return new File(this.f19115a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (b) {
            int i2 = e;
            if (i2 == 20) {
                f++;
                return;
            }
            c[i2] = str;
            d[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            e++;
        }
    }

    public static float b(String str) {
        int i2 = f;
        if (i2 > 0) {
            f = i2 - 1;
            return 0.0f;
        }
        if (!b) {
            return 0.0f;
        }
        int i3 = e - 1;
        e = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(c[i3])) {
            TraceCompat.endSection();
            return (System.nanoTime() - d[e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
    }

    @NonNull
    public static qw3 c(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        qw3 qw3Var = j;
        if (qw3Var == null) {
            synchronized (qw3.class) {
                qw3Var = j;
                if (qw3Var == null) {
                    a93 aVar = h;
                    if (aVar == null) {
                        aVar = new a(applicationContext);
                    }
                    qw3Var = new qw3(aVar);
                    j = qw3Var;
                }
            }
        }
        return qw3Var;
    }

    @NonNull
    public static sw3 d(@NonNull Context context) {
        sw3 sw3Var = i;
        if (sw3Var == null) {
            synchronized (sw3.class) {
                sw3Var = i;
                if (sw3Var == null) {
                    qw3 qw3VarC = c(context);
                    b93 g61Var = g;
                    if (g61Var == null) {
                        g61Var = new g61();
                    }
                    sw3Var = new sw3(qw3VarC, g61Var);
                    i = sw3Var;
                }
            }
        }
        return sw3Var;
    }
}
