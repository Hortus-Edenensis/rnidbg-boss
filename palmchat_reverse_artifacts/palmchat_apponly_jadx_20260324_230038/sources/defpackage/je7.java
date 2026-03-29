package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class je7 implements g07 {
    @Override // defpackage.g07
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zB = wa7.b(context);
        xv6.c("getOAID", "isSupported", Boolean.valueOf(zB));
        if (zB) {
            return wa7.a(context);
        }
        return null;
    }
}
