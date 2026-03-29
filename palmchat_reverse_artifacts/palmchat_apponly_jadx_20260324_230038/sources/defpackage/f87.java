package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f87 implements g07 {
    @Override // defpackage.g07
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = wz6.a();
        xv6.c("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return wz6.b(context);
        }
        return null;
    }
}
