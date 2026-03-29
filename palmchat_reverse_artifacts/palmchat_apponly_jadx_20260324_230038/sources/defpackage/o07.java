package defpackage;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class o07 {
    public static String a(String str) {
        String strA;
        try {
            strA = pc7.a(str);
        } catch (Throwable unused) {
            strA = "";
        }
        if (!xu6.c(strA)) {
            return strA;
        }
        return a47.a(".SystemConfig" + File.separator + str);
    }
}
