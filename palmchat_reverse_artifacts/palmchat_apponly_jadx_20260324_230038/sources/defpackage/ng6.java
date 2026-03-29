package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ng6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19509a = "";
    public Context b;

    public ng6(Context context) {
        this.b = context;
    }

    public String a() {
        String strE = mg6.f(this.b).e(this.f19509a);
        return TextUtils.isEmpty(strE) ? "" : strE;
    }

    public String b() {
        String strG = mg6.f(this.b).g();
        return strG == null ? "" : strG;
    }

    public String c() {
        String strI = mg6.f(this.b).i(this.f19509a);
        return strI == null ? "" : strI;
    }

    public void d(String str) {
        this.f19509a = str;
    }
}
