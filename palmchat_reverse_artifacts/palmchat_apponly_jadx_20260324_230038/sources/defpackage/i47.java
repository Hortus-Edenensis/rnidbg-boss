package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class i47 implements g07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uz6 f18099a;
    public boolean b = false;
    public boolean c = false;

    @Override // defpackage.g07
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            uz6 uz6Var = new uz6();
            this.f18099a = uz6Var;
            this.c = uz6Var.a(context, null) == 1;
            this.b = true;
        }
        xv6.c("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.f18099a.h()) {
            return this.f18099a.f();
        }
        return null;
    }
}
