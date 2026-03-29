package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class in3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18208a = "";
    public Context b;

    public in3(Context context) {
        this.b = context;
    }

    public String a() {
        String strE = hn3.f(this.b).e(this.f18208a);
        return TextUtils.isEmpty(strE) ? "" : strE;
    }

    public String b() {
        String strG = hn3.f(this.b).g();
        return strG == null ? "" : strG;
    }

    public String c() {
        String strH = hn3.f(this.b).h(this.f18208a);
        return strH == null ? "" : strH;
    }
}
