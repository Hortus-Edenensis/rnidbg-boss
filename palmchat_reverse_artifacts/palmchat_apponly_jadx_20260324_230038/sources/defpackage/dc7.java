package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class dc7 implements g07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17025a = false;

    @Override // defpackage.g07
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f17025a) {
            du6.c(context);
            this.f17025a = true;
        }
        boolean zA = du6.a();
        xv6.c("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return du6.b(context);
        }
        return null;
    }
}
