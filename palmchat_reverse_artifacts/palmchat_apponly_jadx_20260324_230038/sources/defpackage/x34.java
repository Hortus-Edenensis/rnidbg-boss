package defpackage;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class x34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21869a;
    public Uri b;

    public x34(Context context) {
        this.f21869a = context;
        String strH = rv2.h("k97muQEI3n3mlJTZdD9q3lC6tvCVkeY7wPOrf0wd0l4zQtrGyn5uq0enBKOySISr");
        p63.a("NubiaOpenIDHelper", "url: " + strH);
        this.b = Uri.parse(strH);
    }

    public String a() {
        try {
            Context context = this.f21869a;
            return w34.a(context, context.getPackageName(), this.b);
        } catch (Exception e) {
            p63.f("NubiaOpenIDHelper", "get Ids-aa error: " + e.getMessage());
            return "";
        }
    }

    public String b() {
        try {
            return w34.b(this.f21869a, this.b);
        } catch (Exception e) {
            p63.f("NubiaOpenIDHelper", "get Ids-oa error: " + e.getMessage());
            return "";
        }
    }

    public String c() {
        try {
            Context context = this.f21869a;
            return w34.c(context, context.getPackageName(), this.b);
        } catch (Exception e) {
            p63.f("NubiaOpenIDHelper", "get Ids-va error: " + e.getMessage());
            return "";
        }
    }
}
