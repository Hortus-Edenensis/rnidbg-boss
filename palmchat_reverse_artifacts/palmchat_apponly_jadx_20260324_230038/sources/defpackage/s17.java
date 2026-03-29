package defpackage;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.y17;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class s17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f20654a = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");
    public static final l87 b = new l87();
    public static final y17 c = new y17.b(120, 120000).b();

    public static /* synthetic */ String e() {
        return "AppCode is empty.";
    }

    public static /* synthetic */ void f(pw6 pw6Var) {
        ow6.c(pw6Var.j(), pw6Var);
    }

    public static void g(@NonNull Context context, @Nullable e54 e54Var) {
        h(context, x17.i(context), e54Var);
    }

    public static void h(@NonNull Context context, String str, @Nullable e54 e54Var) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            qw6.a().b((Application) applicationContext);
        }
        if (TextUtils.isEmpty(str)) {
            n87.c("OplusTrack", new la7() { // from class: cz6
                @Override // defpackage.la7
                public final Object get() {
                    return s17.e();
                }
            });
        }
        x17.f(context, str);
        nw6.f(str, context, e54Var);
        if (e54Var != null) {
            n87.b(e54Var.a() == 1);
        }
    }

    public static boolean i(final pw6 pw6Var, final int i) {
        if (!c.d(pw6Var.i() + "_" + pw6Var.m() + "_" + pw6Var.b())) {
            uw6.d().e(pw6Var);
            return false;
        }
        try {
            n87.f("OplusTrack", new la7() { // from class: fz6
                @Override // defpackage.la7
                public final Object get() {
                    return s17.k(pw6Var, i);
                }
            });
            if ((i & 1) == 1) {
                po6.d(new Runnable() { // from class: hz6
                    @Override // java.lang.Runnable
                    public final void run() {
                        s17.l(pw6Var);
                    }
                });
            }
            if ((i & 2) == 2) {
                po6.d(new Runnable() { // from class: jz6
                    @Override // java.lang.Runnable
                    public final void run() {
                        s17.f(pw6Var);
                    }
                });
            }
            return true;
        } catch (Exception e) {
            n87.a("OplusTrack", new kz6(e));
            return false;
        }
    }

    public static boolean j(@NonNull Context context, String str, String str2, String str3, Map<String, String> map) {
        pw6 pw6Var = new pw6(context);
        pw6Var.f(str);
        pw6Var.n(str2);
        pw6Var.k(str3);
        pw6Var.l(map);
        return i(pw6Var, 1);
    }

    public static /* synthetic */ String k(pw6 pw6Var, int i) {
        return "onCommon logTag is " + pw6Var.m() + ",eventID:" + pw6Var.b() + ",flagSendTo:" + i;
    }

    public static /* synthetic */ void l(pw6 pw6Var) {
        j47.a(pw6Var.j(), pw6Var);
    }
}
