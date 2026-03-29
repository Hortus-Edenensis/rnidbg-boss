package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.e54;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class nw6 {
    public static Map<String, nw6> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19633a;

    @NonNull
    public final Context b;
    public e54 c;

    public nw6(String str, @NonNull Context context, @Nullable e54 e54Var) {
        this.f19633a = str;
        this.b = context;
        this.c = e54Var != null ? d(context, e54Var) : c(context);
    }

    @Nullable
    public static synchronized nw6 e(String str) {
        return d.get(str);
    }

    public static synchronized nw6 f(String str, @NonNull Context context, @Nullable e54 e54Var) {
        nw6 nw6VarE;
        nw6VarE = e(str);
        if (nw6VarE == null) {
            nw6VarE = new nw6(str, context, e54Var);
            d.put(str, nw6VarE);
        }
        return nw6VarE;
    }

    public static /* synthetic */ String g() {
        return "createDefaultConfig PackageManager.NameNotFoundException.";
    }

    @NonNull
    public e54 b() {
        if (e54.f.equals(this.c)) {
            this.c = c(this.b);
        }
        return this.c;
    }

    public final e54 c(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            n87.c("OTrackContext", new la7() { // from class: mt6
                @Override // defpackage.la7
                public final Object get() {
                    return nw6.g();
                }
            });
            packageInfo = null;
        }
        return packageInfo == null ? e54.f : new e54.b().b(packageInfo.packageName).d(packageInfo.versionName).f(packageInfo.applicationInfo.loadLabel(packageManager).toString()).c();
    }

    public final e54 d(Context context, e54 e54Var) {
        if (TextUtils.isEmpty(e54Var.e())) {
            e54Var.b(x17.d(context));
        }
        if (TextUtils.isEmpty(e54Var.g())) {
            e54Var.d(x17.h(context));
        }
        if (TextUtils.isEmpty(e54Var.h())) {
            e54Var.f(x17.g(context));
        }
        return e54Var;
    }
}
