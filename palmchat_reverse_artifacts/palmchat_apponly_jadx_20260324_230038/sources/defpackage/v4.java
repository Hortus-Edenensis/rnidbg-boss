package defpackage;

import android.accounts.AccountManagerCallback;
import android.content.Context;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static dk2 f21350a;

    public static s4 a(Context context) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.f(context);
        }
        return null;
    }

    public static String b(Context context) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.b(context);
        }
        return null;
    }

    public static String c(Context context) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.h(context);
        }
        return null;
    }

    public static String d() {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.c();
        }
        return null;
    }

    public static String e(Context context) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.e(context);
        }
        return null;
    }

    public static ContactInfoItem f() {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            return dk2Var.a(c.b());
        }
        return null;
    }

    public static void g(Context context, dk2 dk2Var) {
        if (dk2Var != null) {
            f21350a = dk2Var;
        }
        f21350a.init(context);
    }

    public static boolean h() {
        ContactInfoItem contactInfoItemF = f();
        return contactInfoItemF != null && contactInfoItemF.getGender() == 1;
    }

    public static void i(Context context, AccountManagerCallback accountManagerCallback) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            dk2Var.g(context, accountManagerCallback);
        }
    }

    public static void j(s4 s4Var) {
        dk2 dk2Var = f21350a;
        if (dk2Var != null) {
            dk2Var.d(s4Var);
        }
    }
}
