package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ku6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18833a;
    public SharedPreferences b;
    public SharedPreferences.Editor c = null;
    public Context d;
    public boolean e;

    public ku6(Context context, String str, String str2, boolean z, boolean z2) {
        this.b = null;
        this.e = z2;
        this.f18833a = str2;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str2, 0);
        }
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!kc7.b(string)) {
                return string;
            }
        }
        return "";
    }

    public void b(String str, String str2) {
        if (kc7.b(str) || str.equals("t")) {
            return;
        }
        d();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c() {
        boolean z;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.c;
        if (editor == null) {
            z = true;
        } else {
            if (!this.e && this.b != null) {
                editor.putLong("t", jCurrentTimeMillis);
            }
            if (!this.c.commit()) {
                z = false;
            }
        }
        if (this.b != null && (context = this.d) != null) {
            this.b = context.getSharedPreferences(this.f18833a, 0);
        }
        return z;
    }

    public final void d() {
        SharedPreferences sharedPreferences;
        if (this.c != null || (sharedPreferences = this.b) == null) {
            return;
        }
        this.c = sharedPreferences.edit();
    }

    public void e(String str) {
        if (kc7.b(str) || str.equals("t")) {
            return;
        }
        d();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.remove(str);
        }
    }
}
