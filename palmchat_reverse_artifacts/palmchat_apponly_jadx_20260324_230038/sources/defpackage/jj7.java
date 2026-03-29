package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class jj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18423a = null;
    public String b = null;
    public int c = -1;

    public jj7(Context context) {
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f18423a) && !"0".equals(this.f18423a)) {
            return this.f18423a;
        }
        if (!TextUtils.isEmpty(this.b) && !"0".equals(this.b)) {
            return this.b;
        }
        String strF = x97.a().f();
        this.f18423a = strF;
        if (!TextUtils.isEmpty(strF) && !"0".equals(this.f18423a)) {
            return this.f18423a;
        }
        String strG = xi7.d().g();
        this.b = strG;
        return strG;
    }

    public void b(String str) {
        this.f18423a = str;
        xi7.d().i(str);
    }

    public boolean c() {
        return this.f18423a != null;
    }
}
